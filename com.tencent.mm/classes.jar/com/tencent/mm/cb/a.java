package com.tencent.mm.cb;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.vfs.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.a.e
{
  public static a Gjt;
  public static b Gju;
  public static c Gjv;
  private String Gjo;
  private ArrayList<EmojiInfo> Gjp;
  private ArrayList<EmojiInfo> Gjq;
  private HashMap<String, ArrayList<EmojiInfo>> Gjr;
  private ArrayList<EmojiGroupInfo> Gjs;
  
  static
  {
    AppMethodBeat.i(104893);
    Gjt = new a();
    Gju = new b();
    Gjv = new c();
    AppMethodBeat.o(104893);
  }
  
  public a()
  {
    AppMethodBeat.i(104851);
    this.Gjp = new ArrayList();
    this.Gjq = new ArrayList();
    this.Gjr = new HashMap();
    this.Gjs = new ArrayList();
    AppMethodBeat.o(104851);
  }
  
  private static byte[] E(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104868);
    if (paramEmojiInfo == null)
    {
      ac.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
      AppMethodBeat.o(104868);
      return null;
    }
    String str = paramEmojiInfo.ghd();
    byte[] arrayOfByte2 = i.aU(str, 0, -1);
    if ((i.aSp(str) > 0L) && (arrayOfByte2 != null) && (arrayOfByte2.length >= 10))
    {
      byte[] arrayOfByte1 = new byte[10];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm) && (!s.cn(arrayOfByte1)))
      {
        long l1 = System.currentTimeMillis();
        int j = (int)i.aSp(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        arrayOfByte1 = i.aU(str, 0, i);
        if (!bs.isNullOrNil(abP())) {}
        for (;;)
        {
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, abP().getBytes(), false, false);
            if ((bs.cv(arrayOfByte1)) || (bs.cv(arrayOfByte2))) {
              break;
            }
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
            long l2 = System.currentTimeMillis();
            ac.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l2 - l1) });
            if (!a(paramEmojiInfo, arrayOfByte2)) {
              break label322;
            }
            AppMethodBeat.o(104868);
            return arrayOfByte2;
          }
          catch (Throwable localThrowable)
          {
            ac.printErrStackTrace("MicroMsg.EmotionStorageResolver", localThrowable, "", new Object[0]);
          }
          Object localObject = null;
        }
        ac.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[] { str });
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
      ac.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
    }
    label322:
    AppMethodBeat.o(104868);
    return null;
  }
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104869);
    String str;
    if (s.co(paramArrayOfByte))
    {
      str = paramEmojiInfo.field_externMd5;
      paramArrayOfByte = ah.B(paramArrayOfByte);
      if ((bs.isNullOrNil(str)) || (bs.isNullOrNil(paramArrayOfByte)) || (!bs.lr(str, paramArrayOfByte))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ac.w("MicroMsg.EmotionStorageResolver", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(104869);
      return bool;
      str = paramEmojiInfo.field_md5;
      break;
    }
  }
  
  private static String abP()
  {
    AppMethodBeat.i(104870);
    String str = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
    AppMethodBeat.o(104870);
    return str;
  }
  
  public static Bundle call(Uri paramUri, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(104886);
    try
    {
      paramUri = ai.getContext().getContentResolver().call(paramUri, paramString1, paramString2, paramBundle);
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
        ac.printErrStackTrace("MicroMsg.EmotionStorageResolver", paramUri, "", new Object[0]);
        paramUri = null;
      }
      paramUri = new Bundle();
      AppMethodBeat.o(104886);
      return paramUri;
    }
    catch (IllegalArgumentException paramUri)
    {
      label31:
      break label31;
    }
  }
  
  public static a eSf()
  {
    return Gjt;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(210509);
    Uri localUri = Uri.parse("content://com.tencent.mm.storage.provider.emotion/");
    AppMethodBeat.o(210509);
    return localUri;
  }
  
  public final EmojiInfo XM(String paramString)
  {
    AppMethodBeat.i(104866);
    if (((h)g.agO().agp()).ahL())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XM(paramString);
      AppMethodBeat.o(104866);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiByMd5", null, localBundle);
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
  
  public final String XP(String paramString)
  {
    AppMethodBeat.i(104852);
    if (((h)g.agO().agp()).ahL())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(paramString);
      AppMethodBeat.o(104852);
      return paramString;
    }
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", paramString, null).getString("data", "");
    AppMethodBeat.o(104852);
    return paramString;
  }
  
  public final void XX(String paramString)
  {
    AppMethodBeat.i(177033);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XX(paramString);
    }
    AppMethodBeat.o(177033);
  }
  
  public final boolean XY(String paramString)
  {
    AppMethodBeat.i(104882);
    if (((h)g.agO().agp()).ahL())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XY(paramString);
      AppMethodBeat.o(104882);
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "checkGifFile", null, localBundle);
    if ((paramString != null) && (paramString.getBoolean("key_data")))
    {
      AppMethodBeat.o(104882);
      return true;
    }
    AppMethodBeat.o(104882);
    return false;
  }
  
  public final void XZ(String paramString)
  {
    AppMethodBeat.i(104887);
    if (((h)g.agO().agp()).ahL())
    {
      if (g.agP().afY())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XZ(paramString);
        AppMethodBeat.o(104887);
      }
    }
    else {
      ai.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "deleteLoadingCaptureEmoji", paramString, null);
    }
    AppMethodBeat.o(104887);
  }
  
  public final void Ya(String paramString)
  {
    AppMethodBeat.i(104889);
    if (((h)g.agO().agp()).ahL())
    {
      if (g.agP().afY())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ya(paramString);
        AppMethodBeat.o(104889);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_md5", paramString);
      ai.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "addCaptureEmojiUploadTask", null, localBundle);
    }
    AppMethodBeat.o(104889);
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104862);
    if (((h)g.agO().agp()).ahL())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiInfo);
      AppMethodBeat.o(104862);
      return paramEmojiInfo;
    }
    paramEmojiInfo = E(paramEmojiInfo);
    AppMethodBeat.o(104862);
    return paramEmojiInfo;
  }
  
  public final boolean acy()
  {
    AppMethodBeat.i(104875);
    if (((h)g.agO().agp()).ahL())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acy();
      AppMethodBeat.o(104875);
      return bool;
    }
    Bundle localBundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHevcUpload", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(104875);
      return true;
    }
    AppMethodBeat.o(104875);
    return false;
  }
  
  public final boolean acz()
  {
    AppMethodBeat.i(104876);
    if (((h)g.agO().agp()).ahL())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acz();
      AppMethodBeat.o(104876);
      return bool;
    }
    AppMethodBeat.o(104876);
    return false;
  }
  
  public final <T> T c(ah.a parama, T paramT)
  {
    AppMethodBeat.i(104880);
    if (((h)g.agO().agp()).ahL())
    {
      parama = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(parama, paramT);
      AppMethodBeat.o(104880);
      return parama;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    parama = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getConfig", null, localBundle);
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
  
  public final ArrayList<SmileyInfo> cbR()
  {
    AppMethodBeat.i(104884);
    Object localObject;
    if (((h)g.agO().agp()).ahL())
    {
      if (g.agP().afY())
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbR();
        AppMethodBeat.o(104884);
        return localObject;
      }
    }
    else
    {
      localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyInfoList", null, null);
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
  
  public final ArrayList<SmileyPanelConfigInfo> cbS()
  {
    AppMethodBeat.i(104890);
    if (((h)g.agO().agp()).ahL())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbS();
      AppMethodBeat.o(104890);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyPanelInfoList", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getParcelableArrayList("smiley_panel_info");
    AppMethodBeat.o(104890);
    return localObject;
  }
  
  public final String cbV()
  {
    AppMethodBeat.i(104891);
    if (((h)g.agO().agp()).ahL())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbV();
      AppMethodBeat.o(104891);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getPanelConfigName", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getString("key_data");
    AppMethodBeat.o(104891);
    return localObject;
  }
  
  public final void cbW()
  {
    AppMethodBeat.i(104885);
    if ((((h)g.agO().agp()).ahL()) && (g.agP().afY())) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbW();
    }
    AppMethodBeat.o(104885);
  }
  
  public final boolean cbX()
  {
    AppMethodBeat.i(104874);
    if (((h)g.agO().agp()).ahL())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbX();
      AppMethodBeat.o(104874);
      return bool;
    }
    Bundle localBundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHEVCDecode", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(104874);
      return true;
    }
    AppMethodBeat.o(104874);
    return false;
  }
  
  public final List<v> cbY()
  {
    AppMethodBeat.i(104878);
    if (((h)g.agO().agp()).ahL())
    {
      List localList = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbY();
      AppMethodBeat.o(104878);
      return localList;
    }
    AppMethodBeat.o(104878);
    return null;
  }
  
  public final void cbZ()
  {
    AppMethodBeat.i(104879);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cbZ();
    }
    AppMethodBeat.o(104879);
  }
  
  public final boolean cca()
  {
    AppMethodBeat.i(104883);
    if (((h)g.agO().agp()).ahL())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cca();
      AppMethodBeat.o(104883);
      return bool;
    }
    AppMethodBeat.o(104883);
    return false;
  }
  
  public final void d(ah.a parama, Object paramObject)
  {
    AppMethodBeat.i(104881);
    if (((h)g.agO().agp()).ahL())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(parama, paramObject);
      AppMethodBeat.o(104881);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    localBundle.putSerializable("key_config_value", (Serializable)paramObject);
    call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "setConfig", null, localBundle);
    AppMethodBeat.o(104881);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(104871);
    if (((h)g.agO().agp()).ahL()) {
      this.Gjo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().getAccPath();
    }
    for (;;)
    {
      String str = this.Gjo;
      AppMethodBeat.o(104871);
      return str;
      if (bs.isNullOrNil(this.Gjo)) {
        this.Gjo = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(104861);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(parama);
    }
    AppMethodBeat.o(104861);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(104863);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().i(parama);
    }
    AppMethodBeat.o(104863);
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(104864);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(parama);
    }
    AppMethodBeat.o(104864);
  }
  
  public final void k(k.a parama)
  {
    AppMethodBeat.i(104865);
    if (((h)g.agO().agp()).ahL()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().k(parama);
    }
    AppMethodBeat.o(104865);
  }
  
  public final EmojiInfo l(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104853);
    if (((h)g.agO().agp()).ahL())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString, "", paramInt1, paramInt2, paramInt3, "");
      AppMethodBeat.o(104853);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    localBundle.putInt("key_group", paramInt1);
    localBundle.putInt("key_type", paramInt2);
    localBundle.putInt("key_size", paramInt3);
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "createEmojiInfo", null, localBundle);
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
  
  public final void onDestroy()
  {
    AppMethodBeat.i(104873);
    this.Gjs.clear();
    AppMethodBeat.o(104873);
  }
  
  public final EmojiInfo p(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104867);
    if (((h)g.agO().agp()).ahL())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().p(paramEmojiInfo);
      AppMethodBeat.o(104867);
      return paramEmojiInfo;
    }
    Bundle localBundle = new Bundle(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", paramEmojiInfo);
    paramEmojiInfo = ai.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRandomEmoji", null, localBundle);
    if (paramEmojiInfo == null)
    {
      ac.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
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
      ac.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bundle is null?", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(104867);
      return null;
    }
  }
  
  public final void t(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104888);
    if (((h)g.agO().agp()).ahL())
    {
      if (g.agP().afY())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().t(paramEmojiInfo);
        AppMethodBeat.o(104888);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("emojiInfo", paramEmojiInfo);
      ai.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiInPanel", null, localBundle);
    }
    AppMethodBeat.o(104888);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104854);
    if (((h)g.agO().agp()).ahL())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      AppMethodBeat.o(104854);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("key_emoji_info", paramEmojiInfo);
    call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "updateEmojiInfo", null, localBundle);
    AppMethodBeat.o(104854);
  }
  
  public static final class a {}
  
  public static final class b
  {
    public static void aJX(String paramString)
    {
      AppMethodBeat.i(104849);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", Integer.valueOf(-29414086));
      localContentValues.put("value", paramString);
      a.a(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), localContentValues);
      AppMethodBeat.o(104849);
    }
    
    public static String cF(int paramInt, String paramString)
    {
      AppMethodBeat.i(104848);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key", paramInt);
      paramString = a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, localBundle).getString("key", paramString);
      AppMethodBeat.o(104848);
      return paramString;
    }
  }
  
  public static final class c
    extends com.tencent.mm.m.e
  {
    public final void tX()
    {
      try
      {
        AppMethodBeat.i(104850);
        this.fKX = true;
        a.eSf();
        a.b localb = a.Gju;
        r(a.b.cF(278529, null), false);
        a.eSf();
        localb = a.Gju;
        r(a.b.cF(278530, null), false);
        AppMethodBeat.o(104850);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cb.a
 * JD-Core Version:    0.7.0.1
 */