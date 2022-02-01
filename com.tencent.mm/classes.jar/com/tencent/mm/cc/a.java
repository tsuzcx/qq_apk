package com.tencent.mm.cc;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.vfs.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.a.e
{
  public static a EMh;
  public static b EMi;
  public static c EMj;
  private String EMc;
  private ArrayList<EmojiInfo> EMd;
  private ArrayList<EmojiInfo> EMe;
  private HashMap<String, ArrayList<EmojiInfo>> EMf;
  private ArrayList<EmojiGroupInfo> EMg;
  
  static
  {
    AppMethodBeat.i(104893);
    EMh = new a();
    EMi = new b();
    EMj = new c();
    AppMethodBeat.o(104893);
  }
  
  public a()
  {
    AppMethodBeat.i(104851);
    this.EMd = new ArrayList();
    this.EMe = new ArrayList();
    this.EMf = new HashMap();
    this.EMg = new ArrayList();
    AppMethodBeat.o(104851);
  }
  
  private static byte[] D(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104868);
    if (paramEmojiInfo == null)
    {
      ad.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
      AppMethodBeat.o(104868);
      return null;
    }
    String str = paramEmojiInfo.gaa();
    byte[] arrayOfByte2 = i.aR(str, 0, -1);
    if ((i.aMN(str) > 0L) && (arrayOfByte2 != null) && (arrayOfByte2.length >= 10))
    {
      byte[] arrayOfByte1 = new byte[10];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl) && (!t.co(arrayOfByte1)))
      {
        long l1 = System.currentTimeMillis();
        int j = (int)i.aMN(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        arrayOfByte1 = i.aR(str, 0, i);
        if (!bt.isNullOrNil(aaQ())) {}
        for (;;)
        {
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, aaQ().getBytes(), false, false);
            if ((bt.cw(arrayOfByte1)) || (bt.cw(arrayOfByte2))) {
              break;
            }
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
            long l2 = System.currentTimeMillis();
            ad.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l2 - l1) });
            if (!a(paramEmojiInfo, arrayOfByte2)) {
              break label322;
            }
            AppMethodBeat.o(104868);
            return arrayOfByte2;
          }
          catch (Throwable localThrowable)
          {
            ad.printErrStackTrace("MicroMsg.EmotionStorageResolver", localThrowable, "", new Object[0]);
          }
          Object localObject = null;
        }
        ad.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[] { str });
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
      ad.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
    }
    label322:
    AppMethodBeat.o(104868);
    return null;
  }
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104869);
    String str;
    if (t.cp(paramArrayOfByte))
    {
      str = paramEmojiInfo.field_externMd5;
      paramArrayOfByte = ai.D(paramArrayOfByte);
      if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramArrayOfByte)) || (!bt.kU(str, paramArrayOfByte))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ad.w("MicroMsg.EmotionStorageResolver", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(104869);
      return bool;
      str = paramEmojiInfo.field_md5;
      break;
    }
  }
  
  private static String aaQ()
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
      paramUri = aj.getContext().getContentResolver().call(paramUri, paramString1, paramString2, paramBundle);
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
        ad.printErrStackTrace("MicroMsg.EmotionStorageResolver", paramUri, "", new Object[0]);
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
  
  public static a eCL()
  {
    return EMh;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(202414);
    Uri localUri = Uri.parse("content://com.tencent.mm.storage.provider.emotion/");
    AppMethodBeat.o(202414);
    return localUri;
  }
  
  public final EmojiInfo TA(String paramString)
  {
    AppMethodBeat.i(104866);
    if (((h)g.afy().aeZ()).agu())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TA(paramString);
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
  
  public final String TD(String paramString)
  {
    AppMethodBeat.i(104852);
    if (((h)g.afy().aeZ()).agu())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(paramString);
      AppMethodBeat.o(104852);
      return paramString;
    }
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", paramString, null).getString("data", "");
    AppMethodBeat.o(104852);
    return paramString;
  }
  
  public final void TL(String paramString)
  {
    AppMethodBeat.i(177033);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TL(paramString);
    }
    AppMethodBeat.o(177033);
  }
  
  public final boolean TM(String paramString)
  {
    AppMethodBeat.i(104882);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TM(paramString);
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
  
  public final void TN(String paramString)
  {
    AppMethodBeat.i(104887);
    if (((h)g.afy().aeZ()).agu())
    {
      if (g.afz().aeI())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TN(paramString);
        AppMethodBeat.o(104887);
      }
    }
    else {
      aj.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "deleteLoadingCaptureEmoji", paramString, null);
    }
    AppMethodBeat.o(104887);
  }
  
  public final void TO(String paramString)
  {
    AppMethodBeat.i(104889);
    if (((h)g.afy().aeZ()).agu())
    {
      if (g.afz().aeI())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TO(paramString);
        AppMethodBeat.o(104889);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_md5", paramString);
      aj.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "addCaptureEmojiUploadTask", null, localBundle);
    }
    AppMethodBeat.o(104889);
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104862);
    if (((h)g.afy().aeZ()).agu())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiInfo);
      AppMethodBeat.o(104862);
      return paramEmojiInfo;
    }
    paramEmojiInfo = D(paramEmojiInfo);
    AppMethodBeat.o(104862);
    return paramEmojiInfo;
  }
  
  public final boolean abA()
  {
    AppMethodBeat.i(104876);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abA();
      AppMethodBeat.o(104876);
      return bool;
    }
    AppMethodBeat.o(104876);
    return false;
  }
  
  public final boolean abz()
  {
    AppMethodBeat.i(104875);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abz();
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
  
  public final ArrayList<SmileyInfo> bUE()
  {
    AppMethodBeat.i(104884);
    Object localObject;
    if (((h)g.afy().aeZ()).agu())
    {
      if (g.afz().aeI())
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUE();
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
  
  public final ArrayList<SmileyPanelConfigInfo> bUF()
  {
    AppMethodBeat.i(104890);
    if (((h)g.afy().aeZ()).agu())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUF();
      AppMethodBeat.o(104890);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyPanelInfoList", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getParcelableArrayList("smiley_panel_info");
    AppMethodBeat.o(104890);
    return localObject;
  }
  
  public final String bUI()
  {
    AppMethodBeat.i(104891);
    if (((h)g.afy().aeZ()).agu())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUI();
      AppMethodBeat.o(104891);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getPanelConfigName", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getString("key_data");
    AppMethodBeat.o(104891);
    return localObject;
  }
  
  public final void bUJ()
  {
    AppMethodBeat.i(104885);
    if ((((h)g.afy().aeZ()).agu()) && (g.afz().aeI())) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUJ();
    }
    AppMethodBeat.o(104885);
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(104874);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUK();
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
  
  public final List<u> bUL()
  {
    AppMethodBeat.i(104878);
    if (((h)g.afy().aeZ()).agu())
    {
      List localList = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUL();
      AppMethodBeat.o(104878);
      return localList;
    }
    AppMethodBeat.o(104878);
    return null;
  }
  
  public final void bUM()
  {
    AppMethodBeat.i(104879);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUM();
    }
    AppMethodBeat.o(104879);
  }
  
  public final boolean bUN()
  {
    AppMethodBeat.i(104883);
    if (((h)g.afy().aeZ()).agu())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bUN();
      AppMethodBeat.o(104883);
      return bool;
    }
    AppMethodBeat.o(104883);
    return false;
  }
  
  public final <T> T c(ae.a parama, T paramT)
  {
    AppMethodBeat.i(104880);
    if (((h)g.afy().aeZ()).agu())
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
  
  public final void d(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(104881);
    if (((h)g.afy().aeZ()).agu())
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
    if (((h)g.afy().aeZ()).agu()) {
      this.EMc = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().getAccPath();
    }
    for (;;)
    {
      String str = this.EMc;
      AppMethodBeat.o(104871);
      return str;
      if (bt.isNullOrNil(this.EMc)) {
        this.EMc = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(104861);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(parama);
    }
    AppMethodBeat.o(104861);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(104863);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().i(parama);
    }
    AppMethodBeat.o(104863);
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(104864);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(parama);
    }
    AppMethodBeat.o(104864);
  }
  
  public final void k(k.a parama)
  {
    AppMethodBeat.i(104865);
    if (((h)g.afy().aeZ()).agu()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().k(parama);
    }
    AppMethodBeat.o(104865);
  }
  
  public final EmojiInfo l(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104853);
    if (((h)g.afy().aeZ()).agu())
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
    this.EMg.clear();
    AppMethodBeat.o(104873);
  }
  
  public final EmojiInfo p(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104867);
    if (((h)g.afy().aeZ()).agu())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().p(paramEmojiInfo);
      AppMethodBeat.o(104867);
      return paramEmojiInfo;
    }
    Bundle localBundle = new Bundle(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", paramEmojiInfo);
    paramEmojiInfo = aj.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRandomEmoji", null, localBundle);
    if (paramEmojiInfo == null)
    {
      ad.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
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
      ad.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bundle is null?", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(104867);
      return null;
    }
  }
  
  public final void t(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104888);
    if (((h)g.afy().aeZ()).agu())
    {
      if (g.afz().aeI())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().t(paramEmojiInfo);
        AppMethodBeat.o(104888);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("emojiInfo", paramEmojiInfo);
      aj.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiInPanel", null, localBundle);
    }
    AppMethodBeat.o(104888);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104854);
    if (((h)g.afy().aeZ()).agu())
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
    public static void aEG(String paramString)
    {
      AppMethodBeat.i(104849);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", Integer.valueOf(-29414086));
      localContentValues.put("value", paramString);
      a.a(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), localContentValues);
      AppMethodBeat.o(104849);
    }
    
    public static String cC(int paramInt, String paramString)
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
    public final void tP()
    {
      try
      {
        AppMethodBeat.i(104850);
        this.fHq = true;
        a.eCL();
        a.b localb = a.EMi;
        r(a.b.cC(278529, null), false);
        a.eCL();
        localb = a.EMi;
        r(a.b.cC(278530, null), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */