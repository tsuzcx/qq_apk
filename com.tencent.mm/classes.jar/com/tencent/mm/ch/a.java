package com.tencent.mm.ch;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.vfs.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.b.e
{
  public static a UQk;
  public static b UQl;
  private String UQj;
  
  static
  {
    AppMethodBeat.i(104893);
    UQk = new a();
    UQl = new b();
    AppMethodBeat.o(104893);
  }
  
  public a()
  {
    AppMethodBeat.i(104851);
    AppMethodBeat.o(104851);
  }
  
  private static byte[] E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104868);
    if (paramEmojiInfo == null)
    {
      Log.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
      AppMethodBeat.o(104868);
      return null;
    }
    String str = paramEmojiInfo.ifh();
    byte[] arrayOfByte2 = u.aY(str, 0, -1);
    if ((u.bBQ(str) > 0L) && (arrayOfByte2 != null) && (arrayOfByte2.length >= 10))
    {
      byte[] arrayOfByte1 = new byte[10];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM) && (!ImgUtil.isImageFile(arrayOfByte1)))
      {
        long l1 = System.currentTimeMillis();
        int j = (int)u.bBQ(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        arrayOfByte1 = u.aY(str, 0, i);
        if (!Util.isNullOrNil(aBg())) {}
        for (;;)
        {
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, aBg().getBytes(), false, false);
            if ((Util.isNullOrNil(arrayOfByte1)) || (Util.isNullOrNil(arrayOfByte2))) {
              break;
            }
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
            long l2 = System.currentTimeMillis();
            Log.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l2 - l1) });
            if (!a(paramEmojiInfo, arrayOfByte2)) {
              break label322;
            }
            AppMethodBeat.o(104868);
            return arrayOfByte2;
          }
          catch (Throwable localThrowable)
          {
            Log.printErrStackTrace("MicroMsg.EmotionStorageResolver", localThrowable, "", new Object[0]);
          }
          Object localObject = null;
        }
        Log.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[] { str });
        if (a(paramEmojiInfo, arrayOfByte2))
        {
          AppMethodBeat.o(104868);
          return arrayOfByte2;
        }
      }
      else if (a(paramEmojiInfo, arrayOfByte2))
      {
        AppMethodBeat.o(104868);
        return arrayOfByte2;
      }
    }
    else
    {
      Log.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
    }
    label322:
    AppMethodBeat.o(104868);
    return null;
  }
  
  public static Bundle a(Uri paramUri, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(104886);
    try
    {
      paramUri = MMApplicationContext.getContext().getContentResolver().call(paramUri, paramString1, paramString2, paramBundle);
      if (paramUri != null)
      {
        AppMethodBeat.o(104886);
        return paramUri;
      }
    }
    catch (NullPointerException paramUri)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.EmotionStorageResolver", paramUri, "", new Object[0]);
        paramUri = null;
      }
      paramUri = new Bundle();
      AppMethodBeat.o(104886);
      return paramUri;
    }
    catch (IllegalArgumentException paramUri)
    {
      break label31;
    }
    catch (SecurityException paramUri)
    {
      label31:
      break label31;
    }
  }
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104869);
    String str;
    if (ImgUtil.isWXGF(paramArrayOfByte))
    {
      str = paramEmojiInfo.field_externMd5;
      paramArrayOfByte = MD5Util.getMD5String(paramArrayOfByte);
      if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramArrayOfByte)) || (!Util.isEqual(str, paramArrayOfByte))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        Log.w("MicroMsg.EmotionStorageResolver", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(104869);
      return bool;
      str = paramEmojiInfo.field_md5;
      break;
    }
  }
  
  private static String aBg()
  {
    AppMethodBeat.i(104870);
    String str = a(getUri(), "getEmojiKey", null, null).getString("key", "");
    AppMethodBeat.o(104870);
    return str;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(185735);
    Uri localUri = Uri.parse("content://" + g.AUTHORITY + "/");
    AppMethodBeat.o(185735);
    return localUri;
  }
  
  public static a hqW()
  {
    return UQk;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104862);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiInfo);
      AppMethodBeat.o(104862);
      return paramEmojiInfo;
    }
    paramEmojiInfo = E(paramEmojiInfo);
    AppMethodBeat.o(104862);
    return paramEmojiInfo;
  }
  
  public final boolean aBZ()
  {
    AppMethodBeat.i(104875);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aBZ();
      AppMethodBeat.o(104875);
      return bool;
    }
    Bundle localBundle = a(getUri(), "isEnableHevcUpload", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(104875);
      return true;
    }
    AppMethodBeat.o(104875);
    return false;
  }
  
  public final boolean aCa()
  {
    AppMethodBeat.i(104876);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aCa();
      AppMethodBeat.o(104876);
      return bool;
    }
    AppMethodBeat.o(104876);
    return false;
  }
  
  public final EmojiInfo aue(String paramString)
  {
    AppMethodBeat.i(104866);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aue(paramString);
      AppMethodBeat.o(104866);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    paramString = a(getUri(), "getEmojiByMd5", null, localBundle);
    if (paramString != null)
    {
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      paramString = (EmojiInfo)paramString.getParcelable("key_emoji_info");
      AppMethodBeat.o(104866);
      return paramString;
    }
    AppMethodBeat.o(104866);
    return null;
  }
  
  public final String auh(String paramString)
  {
    AppMethodBeat.i(104852);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramString);
      AppMethodBeat.o(104852);
      return paramString;
    }
    paramString = a(getUri(), "getCurLangDesc", paramString, null).getString("data", "");
    AppMethodBeat.o(104852);
    return paramString;
  }
  
  public final void aur(String paramString)
  {
    AppMethodBeat.i(177033);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aur(paramString);
    }
    AppMethodBeat.o(177033);
  }
  
  public final boolean aus(String paramString)
  {
    AppMethodBeat.i(104882);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aus(paramString);
      AppMethodBeat.o(104882);
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = a(getUri(), "checkGifFile", null, localBundle);
    if ((paramString != null) && (paramString.getBoolean("key_data")))
    {
      AppMethodBeat.o(104882);
      return true;
    }
    AppMethodBeat.o(104882);
    return false;
  }
  
  public final boolean aut(String paramString)
  {
    AppMethodBeat.i(223295);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aut(paramString);
      AppMethodBeat.o(223295);
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = a(getUri(), "checkGifFile", null, localBundle);
    if ((paramString != null) && (paramString.getBoolean("key_data")))
    {
      AppMethodBeat.o(223295);
      return true;
    }
    AppMethodBeat.o(223295);
    return false;
  }
  
  public final void auu(String paramString)
  {
    AppMethodBeat.i(104887);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auu(paramString);
        AppMethodBeat.o(104887);
      }
    }
    else {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "deleteLoadingCaptureEmoji", paramString, null);
    }
    AppMethodBeat.o(104887);
  }
  
  public final void auv(String paramString)
  {
    AppMethodBeat.i(104889);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auv(paramString);
        AppMethodBeat.o(104889);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_md5", paramString);
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "addCaptureEmojiUploadTask", null, localBundle);
    }
    AppMethodBeat.o(104889);
  }
  
  public final <T> T c(ar.a parama, T paramT)
  {
    AppMethodBeat.i(104880);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      parama = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(parama, paramT);
      AppMethodBeat.o(104880);
      return parama;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    parama = a(getUri(), "getConfig", null, localBundle);
    if (parama != null)
    {
      parama = parama.get("key_config_value");
      if (parama != null)
      {
        AppMethodBeat.o(104880);
        return parama;
      }
    }
    AppMethodBeat.o(104880);
    return paramT;
  }
  
  public final ArrayList<SmileyInfo> cUo()
  {
    AppMethodBeat.i(104884);
    Object localObject;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUo();
        AppMethodBeat.o(104884);
        return localObject;
      }
    }
    else
    {
      localObject = a(getUri(), "getSmileyInfoList", null, null);
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(SmileyInfo.class.getClassLoader());
        localObject = ((Bundle)localObject).getSerializable("key_data");
        if ((localObject instanceof ArrayList))
        {
          localObject = (ArrayList)localObject;
          AppMethodBeat.o(104884);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(104884);
    return null;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> cUp()
  {
    AppMethodBeat.i(104890);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUp();
      AppMethodBeat.o(104890);
      return localObject;
    }
    Object localObject = a(getUri(), "getSmileyPanelInfoList", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getParcelableArrayList("smiley_panel_info");
    AppMethodBeat.o(104890);
    return localObject;
  }
  
  public final String cUs()
  {
    AppMethodBeat.i(104891);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUs();
      AppMethodBeat.o(104891);
      return localObject;
    }
    Object localObject = a(getUri(), "getPanelConfigName", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getString("key_data");
    AppMethodBeat.o(104891);
    return localObject;
  }
  
  public final void cUt()
  {
    AppMethodBeat.i(104885);
    if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) && (com.tencent.mm.kernel.h.aHE().aGM())) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUt();
    }
    AppMethodBeat.o(104885);
  }
  
  public final boolean cUw()
  {
    AppMethodBeat.i(104874);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUw();
      AppMethodBeat.o(104874);
      return bool;
    }
    Bundle localBundle = a(getUri(), "isEnableHEVCDecode", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(104874);
      return true;
    }
    AppMethodBeat.o(104874);
    return false;
  }
  
  public final List<v> cUx()
  {
    AppMethodBeat.i(104878);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      List localList = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUx();
      AppMethodBeat.o(104878);
      return localList;
    }
    AppMethodBeat.o(104878);
    return null;
  }
  
  public final void cUy()
  {
    AppMethodBeat.i(104879);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUy();
    }
    AppMethodBeat.o(104879);
  }
  
  public final boolean cUz()
  {
    AppMethodBeat.i(104883);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUz();
      AppMethodBeat.o(104883);
      return bool;
    }
    AppMethodBeat.o(104883);
    return false;
  }
  
  public final void d(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(104881);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(parama, paramObject);
      AppMethodBeat.o(104881);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    localBundle.putSerializable("key_config_value", (Serializable)paramObject);
    a(getUri(), "setConfig", null, localBundle);
    AppMethodBeat.o(104881);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(104871);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      this.UQj = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().getAccPath();
    }
    for (;;)
    {
      String str = this.UQj;
      AppMethodBeat.o(104871);
      return str;
      if (Util.isNullOrNil(this.UQj)) {
        this.UQj = a(getUri(), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final void h(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104861);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(paramIOnStorageChange);
    }
    AppMethodBeat.o(104861);
  }
  
  public final void i(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104863);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().i(paramIOnStorageChange);
    }
    AppMethodBeat.o(104863);
  }
  
  public final void j(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104864);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(paramIOnStorageChange);
    }
    AppMethodBeat.o(104864);
  }
  
  public final void k(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104865);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().k(paramIOnStorageChange);
    }
    AppMethodBeat.o(104865);
  }
  
  public final EmojiInfo n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104853);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString, "", paramInt1, paramInt2, paramInt3, "");
      AppMethodBeat.o(104853);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    localBundle.putInt("key_group", paramInt1);
    localBundle.putInt("key_type", paramInt2);
    localBundle.putInt("key_size", paramInt3);
    paramString = a(getUri(), "createEmojiInfo", null, localBundle);
    if (paramString != null)
    {
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      paramString = (EmojiInfo)paramString.getParcelable("key_emoji_info");
      AppMethodBeat.o(104853);
      return paramString;
    }
    AppMethodBeat.o(104853);
    return null;
  }
  
  public final EmojiInfo p(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104867);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().p(paramEmojiInfo);
      AppMethodBeat.o(104867);
      return paramEmojiInfo;
    }
    Bundle localBundle = new Bundle(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", paramEmojiInfo);
    paramEmojiInfo = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getRandomEmoji", null, localBundle);
    if (paramEmojiInfo == null)
    {
      Log.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
      AppMethodBeat.o(104867);
      return null;
    }
    paramEmojiInfo.setClassLoader(EmojiInfo.class.getClassLoader());
    if (paramEmojiInfo.containsKey("data"))
    {
      paramEmojiInfo = (EmojiInfo)paramEmojiInfo.getParcelable("data");
      AppMethodBeat.o(104867);
      return paramEmojiInfo;
    }
    if (paramEmojiInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bundle is null?", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(104867);
      return null;
    }
  }
  
  public final void t(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104888);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().t(paramEmojiInfo);
        AppMethodBeat.o(104888);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("emojiInfo", paramEmojiInfo);
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "showCaptureEmojiInPanel", null, localBundle);
    }
    AppMethodBeat.o(104888);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104854);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      AppMethodBeat.o(104854);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("key_emoji_info", paramEmojiInfo);
    a(getUri(), "updateEmojiInfo", null, localBundle);
    AppMethodBeat.o(104854);
  }
  
  public static final class a {}
  
  public static final class b
  {
    public static void btV(String paramString)
    {
      AppMethodBeat.i(104849);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", Integer.valueOf(-29414086));
      localContentValues.put("value", paramString);
      a.a(getUri(), localContentValues);
      AppMethodBeat.o(104849);
    }
    
    public static Uri getUri()
    {
      AppMethodBeat.i(231180);
      Uri localUri = Uri.parse("content://" + g.AUTHORITY + "/userinfo/");
      AppMethodBeat.o(231180);
      return localUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ch.a
 * JD-Core Version:    0.7.0.1
 */