package com.tencent.mm.ca;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.b.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.a.e
{
  public static a.a yiG;
  public static a.b yiH;
  public static a.c yiI;
  private com.tencent.mm.at.a.a lGl;
  private String yiB;
  private ArrayList<EmojiInfo> yiC;
  private ArrayList<EmojiInfo> yiD;
  private HashMap<String, ArrayList<EmojiInfo>> yiE;
  private ArrayList<EmojiGroupInfo> yiF;
  
  static
  {
    AppMethodBeat.i(62641);
    yiG = new a.a();
    yiH = new a.b();
    yiI = new a.c();
    AppMethodBeat.o(62641);
  }
  
  public a()
  {
    AppMethodBeat.i(62594);
    this.yiC = new ArrayList();
    this.yiD = new ArrayList();
    this.yiE = new HashMap();
    this.yiF = new ArrayList();
    AppMethodBeat.o(62594);
  }
  
  private static byte[] F(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(138408);
    if (paramEmojiInfo == null)
    {
      ab.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
      AppMethodBeat.o(138408);
      return null;
    }
    String str = paramEmojiInfo.dQB();
    byte[] arrayOfByte2 = com.tencent.mm.vfs.e.i(str, 0, -1);
    if ((com.tencent.mm.vfs.e.avI(str) > 0L) && (arrayOfByte2 != null) && (arrayOfByte2.length >= 10))
    {
      byte[] arrayOfByte1 = new byte[10];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx) && (!r.bW(arrayOfByte1)))
      {
        long l1 = System.currentTimeMillis();
        int j = (int)com.tencent.mm.vfs.e.avI(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        arrayOfByte1 = com.tencent.mm.vfs.e.i(str, 0, i);
        if (!bo.isNullOrNil(bkR())) {}
        for (;;)
        {
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, bkR().getBytes(), false, false);
            if ((bo.ce(arrayOfByte1)) || (bo.ce(arrayOfByte2))) {
              break;
            }
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
            long l2 = System.currentTimeMillis();
            ab.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l2 - l1) });
            if (!a(paramEmojiInfo, arrayOfByte2)) {
              break label322;
            }
            AppMethodBeat.o(138408);
            return arrayOfByte2;
          }
          catch (Throwable localThrowable)
          {
            ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", localThrowable, "", new Object[0]);
          }
          Object localObject = null;
        }
        ab.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[] { str });
        if (a(paramEmojiInfo, arrayOfByte2))
        {
          AppMethodBeat.o(138408);
          return arrayOfByte2;
        }
      }
      else if (a(paramEmojiInfo, arrayOfByte2))
      {
        AppMethodBeat.o(138408);
        return arrayOfByte2;
      }
    }
    else
    {
      ab.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
    }
    label322:
    AppMethodBeat.o(138408);
    return null;
  }
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154799);
    String str;
    if (r.bX(paramArrayOfByte))
    {
      str = paramEmojiInfo.field_externMd5;
      paramArrayOfByte = ag.v(paramArrayOfByte);
      if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramArrayOfByte)) || (!bo.isEqual(str, paramArrayOfByte))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ab.w("MicroMsg.EmotionStorageResolver", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(154799);
      return bool;
      str = paramEmojiInfo.field_md5;
      break;
    }
  }
  
  private static String bkR()
  {
    AppMethodBeat.i(62616);
    String str = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
    AppMethodBeat.o(62616);
    return str;
  }
  
  public static Bundle call(Uri paramUri, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(62634);
    try
    {
      paramUri = ah.getContext().getContentResolver().call(paramUri, paramString1, paramString2, paramBundle);
      if (paramUri != null)
      {
        AppMethodBeat.o(62634);
        return paramUri;
      }
    }
    catch (NullPointerException paramUri)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", paramUri, "", new Object[0]);
        paramUri = null;
      }
      paramUri = new Bundle();
      AppMethodBeat.o(62634);
      return paramUri;
    }
    catch (IllegalArgumentException paramUri)
    {
      label31:
      break label31;
    }
  }
  
  public static a.a dqM()
  {
    return yiG;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(156834);
    Uri localUri = Uri.parse("content://com.tencent.mm.storage.provider.emotion/");
    AppMethodBeat.o(156834);
    return localUri;
  }
  
  public final int KF(String paramString)
  {
    AppMethodBeat.i(62601);
    if (((h)g.RI().Rj()).SD())
    {
      i = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KF(paramString);
      AppMethodBeat.o(62601);
      return i;
    }
    int i = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", paramString, null).getInt("data", 0);
    AppMethodBeat.o(62601);
    return i;
  }
  
  public final boolean KG(String paramString)
  {
    AppMethodBeat.i(62629);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KG(paramString);
      AppMethodBeat.o(62629);
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "checkGifFile", null, localBundle);
    if ((paramString != null) && (paramString.getBoolean("key_data")))
    {
      AppMethodBeat.o(62629);
      return true;
    }
    AppMethodBeat.o(62629);
    return false;
  }
  
  public final void KH(String paramString)
  {
    AppMethodBeat.i(62635);
    if (((h)g.RI().Rj()).SD())
    {
      if (g.RJ().QU())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KH(paramString);
        AppMethodBeat.o(62635);
      }
    }
    else {
      ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "deleteLoadingCaptureEmoji", paramString, null);
    }
    AppMethodBeat.o(62635);
  }
  
  public final EmojiInfo Ku(String paramString)
  {
    AppMethodBeat.i(62614);
    if (((h)g.RI().Rj()).SD())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ku(paramString);
      AppMethodBeat.o(62614);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiByMd5", null, localBundle);
    if (paramString != null)
    {
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      paramString = (EmojiInfo)paramString.getParcelable("key_emoji_info");
      AppMethodBeat.o(62614);
      return paramString;
    }
    AppMethodBeat.o(62614);
    return null;
  }
  
  public final String Kx(String paramString)
  {
    AppMethodBeat.i(62595);
    if (((h)g.RI().Rj()).SD())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(paramString);
      AppMethodBeat.o(62595);
      return paramString;
    }
    paramString = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", paramString, null).getString("data", "");
    AppMethodBeat.o(62595);
    return paramString;
  }
  
  public final ArrayList<EmojiInfo> OA()
  {
    AppMethodBeat.i(62606);
    ArrayList localArrayList = com.tencent.mm.emoji.a.d.Oz().OA();
    AppMethodBeat.o(62606);
    return localArrayList;
  }
  
  public final ArrayList<EmojiGroupInfo> OB()
  {
    AppMethodBeat.i(62604);
    ArrayList localArrayList = com.tencent.mm.emoji.a.d.Oz().OB();
    AppMethodBeat.o(62604);
    return localArrayList;
  }
  
  public final boolean OQ()
  {
    AppMethodBeat.i(62621);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OQ();
      AppMethodBeat.o(62621);
      return bool;
    }
    Bundle localBundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHevcUpload", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(62621);
      return true;
    }
    AppMethodBeat.o(62621);
    return false;
  }
  
  public final boolean OR()
  {
    AppMethodBeat.i(62622);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OR();
      AppMethodBeat.o(62622);
      return bool;
    }
    AppMethodBeat.o(62622);
    return false;
  }
  
  public final void a(EmojiCaptureUploadManager.UploadTask paramUploadTask)
  {
    AppMethodBeat.i(62636);
    if (((h)g.RI().Rj()).SD())
    {
      if (g.RJ().QU())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramUploadTask);
        AppMethodBeat.o(62636);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("emojiMd5", paramUploadTask.lsX);
      localBundle.putParcelable("reporter", paramUploadTask.lsY);
      ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "uploadEmojiRemote", null, localBundle);
    }
    AppMethodBeat.o(62636);
  }
  
  public final void a(cda paramcda)
  {
    AppMethodBeat.i(62599);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramcda);
    }
    AppMethodBeat.o(62599);
  }
  
  public final boolean a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(62603);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiGroupInfo);
      AppMethodBeat.o(62603);
      return bool;
    }
    AppMethodBeat.o(62603);
    return false;
  }
  
  public final void b(EmojiCaptureUploadManager.UploadTask paramUploadTask)
  {
    AppMethodBeat.i(62639);
    if (((h)g.RI().Rj()).SD())
    {
      if (g.RJ().QU())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().b(paramUploadTask);
        AppMethodBeat.o(62639);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("uploadTask", paramUploadTask);
      ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "addCaptureEmojiUploadTask", null, localBundle);
    }
    AppMethodBeat.o(62639);
  }
  
  public final ArrayList<SmileyInfo> bkU()
  {
    AppMethodBeat.i(62631);
    if (((h)g.RI().Rj()).SD()) {
      if (g.RJ().QU()) {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkU();
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(62631);
        return null;
        localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyInfoList", null, null);
      } while (localObject == null);
      ((Bundle)localObject).setClassLoader(SmileyInfo.class.getClassLoader());
      localObject = ((Bundle)localObject).getSerializable("key_data");
    } while (!(localObject instanceof ArrayList));
    Object localObject = (ArrayList)localObject;
    AppMethodBeat.o(62631);
    return localObject;
  }
  
  public final ArrayList<SmileyPanelConfigInfo> bkV()
  {
    AppMethodBeat.i(151740);
    if (((h)g.RI().Rj()).SD())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkV();
      AppMethodBeat.o(151740);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyPanelInfoList", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getParcelableArrayList("smiley_panel_info");
    AppMethodBeat.o(151740);
    return localObject;
  }
  
  public final String bkY()
  {
    AppMethodBeat.i(151741);
    if (((h)g.RI().Rj()).SD())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkY();
      AppMethodBeat.o(151741);
      return localObject;
    }
    Object localObject = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getPanelConfigName", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getString("key_data");
    AppMethodBeat.o(151741);
    return localObject;
  }
  
  public final void bkZ()
  {
    AppMethodBeat.i(62632);
    if ((((h)g.RI().Rj()).SD()) && (g.RJ().QU())) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkZ();
    }
    AppMethodBeat.o(62632);
  }
  
  public final cda blb()
  {
    AppMethodBeat.i(62598);
    if (((h)g.RI().Rj()).SD())
    {
      cda localcda = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().blb();
      AppMethodBeat.o(62598);
      return localcda;
    }
    AppMethodBeat.o(62598);
    return null;
  }
  
  public final int blc()
  {
    AppMethodBeat.i(62602);
    if (((h)g.RI().Rj()).SD())
    {
      i = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().blc();
      AppMethodBeat.o(62602);
      return i;
    }
    int i = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt("data", 0);
    AppMethodBeat.o(62602);
    return i;
  }
  
  public final com.tencent.mm.at.a.a bld()
  {
    AppMethodBeat.i(62608);
    if (((h)g.RI().Rj()).SD())
    {
      localObject = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bld();
      AppMethodBeat.o(62608);
      return localObject;
    }
    if (this.lGl == null)
    {
      localObject = new b.a(ah.getContext());
      ((b.a)localObject).fHi = new com.tencent.mm.view.d.a();
      this.lGl = new com.tencent.mm.at.a.a(((b.a)localObject).ahO());
    }
    Object localObject = this.lGl;
    AppMethodBeat.o(62608);
    return localObject;
  }
  
  public final boolean ble()
  {
    AppMethodBeat.i(62620);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().ble();
      AppMethodBeat.o(62620);
      return bool;
    }
    Bundle localBundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHEVCDecode", null, null);
    if ((localBundle != null) && (localBundle.getBoolean("key_data")))
    {
      AppMethodBeat.o(62620);
      return true;
    }
    AppMethodBeat.o(62620);
    return false;
  }
  
  public final List<s> blf()
  {
    AppMethodBeat.i(62624);
    if (((h)g.RI().Rj()).SD())
    {
      List localList = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().blf();
      AppMethodBeat.o(62624);
      return localList;
    }
    AppMethodBeat.o(62624);
    return null;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(62625);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().blg();
    }
    AppMethodBeat.o(62625);
  }
  
  public final boolean blh()
  {
    AppMethodBeat.i(62630);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().blh();
      AppMethodBeat.o(62630);
      return bool;
    }
    AppMethodBeat.o(62630);
    return false;
  }
  
  public final <T> T c(ac.a parama, T paramT)
  {
    AppMethodBeat.i(62626);
    if (((h)g.RI().Rj()).SD())
    {
      parama = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(parama, paramT);
      AppMethodBeat.o(62626);
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
        AppMethodBeat.o(62626);
        return parama;
      }
    }
    AppMethodBeat.o(62626);
    return paramT;
  }
  
  public final void cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(62623);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cb(paramString, paramInt);
    }
    AppMethodBeat.o(62623);
  }
  
  public final ArrayList<EmojiInfo> ch(boolean paramBoolean)
  {
    AppMethodBeat.i(62605);
    ArrayList localArrayList = com.tencent.mm.emoji.a.d.Oz().ch(paramBoolean);
    AppMethodBeat.o(62605);
    return localArrayList;
  }
  
  public final void d(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(62627);
    if (((h)g.RI().Rj()).SD())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(parama, paramObject);
      AppMethodBeat.o(62627);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    localBundle.putSerializable("key_config_value", (Serializable)paramObject);
    call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "setConfig", null, localBundle);
    AppMethodBeat.o(62627);
  }
  
  public final void e(k.a parama)
  {
    AppMethodBeat.i(62609);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().e(parama);
    }
    AppMethodBeat.o(62609);
  }
  
  public final void f(k.a parama)
  {
    AppMethodBeat.i(62611);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().f(parama);
    }
    AppMethodBeat.o(62611);
  }
  
  public final void g(k.a parama)
  {
    AppMethodBeat.i(62612);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().g(parama);
    }
    AppMethodBeat.o(62612);
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(62617);
    if (((h)g.RI().Rj()).SD()) {
      this.yiB = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().getAccPath();
    }
    for (;;)
    {
      String str = this.yiB;
      AppMethodBeat.o(62617);
      return str;
      if (bo.isNullOrNil(this.yiB)) {
        this.yiB = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final void h(k.a parama)
  {
    AppMethodBeat.i(62613);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(parama);
    }
    AppMethodBeat.o(62613);
  }
  
  public final void i(k.a parama)
  {
    AppMethodBeat.i(62628);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(parama);
    }
    AppMethodBeat.o(62628);
  }
  
  public final EmojiInfo j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(62596);
    if (((h)g.RI().Rj()).SD())
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString, "", paramInt1, paramInt2, paramInt3, "");
      AppMethodBeat.o(62596);
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
      AppMethodBeat.o(62596);
      return paramString;
    }
    AppMethodBeat.o(62596);
    return null;
  }
  
  public final void j(k.a parama)
  {
    AppMethodBeat.i(62633);
    if (((h)g.RI().Rj()).SD()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().i(parama);
    }
    AppMethodBeat.o(62633);
  }
  
  public final byte[] l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62610);
    if (((h)g.RI().Rj()).SD())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(paramEmojiInfo);
      AppMethodBeat.o(62610);
      return paramEmojiInfo;
    }
    paramEmojiInfo = F(paramEmojiInfo);
    AppMethodBeat.o(62610);
    return paramEmojiInfo;
  }
  
  public final ArrayList<EmojiInfo> lL(String paramString)
  {
    AppMethodBeat.i(62607);
    paramString = com.tencent.mm.emoji.a.d.Oz().lL(paramString);
    AppMethodBeat.o(62607);
    return paramString;
  }
  
  public final EmojiInfo n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62615);
    if (((h)g.RI().Rj()).SD())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().n(paramEmojiInfo);
      AppMethodBeat.o(62615);
      return paramEmojiInfo;
    }
    Bundle localBundle = new Bundle(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", paramEmojiInfo);
    paramEmojiInfo = ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRandomEmoji", null, localBundle);
    if (paramEmojiInfo == null)
    {
      ab.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
      AppMethodBeat.o(62615);
      return null;
    }
    paramEmojiInfo.setClassLoader(EmojiInfo.class.getClassLoader());
    if (paramEmojiInfo.containsKey("data"))
    {
      paramEmojiInfo = (EmojiInfo)paramEmojiInfo.getParcelable("data");
      AppMethodBeat.o(62615);
      return paramEmojiInfo;
    }
    if (paramEmojiInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bundle is null?", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(62615);
      return null;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(62619);
    this.yiF.clear();
    AppMethodBeat.o(62619);
  }
  
  public final void r(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62637);
    if (((h)g.RI().Rj()).SD())
    {
      if (g.RJ().QU())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(paramEmojiInfo);
        AppMethodBeat.o(62637);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("emojiInfo", paramEmojiInfo);
      ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiInPanel", null, localBundle);
    }
    AppMethodBeat.o(62637);
  }
  
  public final void s(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62638);
    if (((h)g.RI().Rj()).SD())
    {
      if (g.RJ().QU())
      {
        ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s(paramEmojiInfo);
        AppMethodBeat.o(62638);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("emojiInfo", paramEmojiInfo);
      ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiDefaultErrorDialog", null, localBundle);
    }
    AppMethodBeat.o(62638);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(62597);
    if (((h)g.RI().Rj()).SD())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      AppMethodBeat.o(62597);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("key_emoji_info", paramEmojiInfo);
    call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "updateEmojiInfo", null, localBundle);
    AppMethodBeat.o(62597);
  }
  
  public final int y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62600);
    if (((h)g.RI().Rj()).SD())
    {
      i = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().y(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(62600);
      return i;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("withSystem", paramBoolean1);
    localBundle.putBoolean("onlySuccess", paramBoolean2);
    int i = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, localBundle).getInt("data", 0);
    AppMethodBeat.o(62600);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ca.a
 * JD-Core Version:    0.7.0.1
 */