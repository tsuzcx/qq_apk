package com.tencent.mm.ca;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.as.a.a.b.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.a.e
{
  public static a.a uaM = new a.a();
  public static a.b uaN = new a.b();
  public static a.c uaO = new a.c();
  private com.tencent.mm.as.a.a jwM;
  private String uaH;
  private ArrayList<EmojiInfo> uaI = new ArrayList();
  private ArrayList<EmojiInfo> uaJ = new ArrayList();
  private HashMap<String, ArrayList<EmojiInfo>> uaK = new HashMap();
  private ArrayList<EmojiGroupInfo> uaL = new ArrayList();
  
  private static String aHd()
  {
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
  }
  
  public static a.a cpp()
  {
    return uaM;
  }
  
  public final int AE(String paramString)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().AE(paramString);
    }
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", paramString, null).getInt("data", 0);
  }
  
  public final ArrayList<EmojiInfo> AF(String paramString)
  {
    Object localObject2;
    if (((h)g.DM().Dr()).Ex()) {
      localObject2 = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().AF(paramString);
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject2 = (ArrayList)this.uaK.get(paramString);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            this.uaK.put(paramString, localObject1);
          }
          localObject2 = localObject1;
        } while (((ArrayList)localObject1).size() != 0);
        paramString = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiListByGroupId", paramString, null);
        localObject2 = localObject1;
      } while (paramString == null);
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      localObject2 = localObject1;
    } while (!paramString.containsKey("data"));
    paramString = paramString.getParcelableArrayList("data");
    ((ArrayList)localObject1).addAll(paramString);
    y.i("MicroMsg.EmotionStorageResolver", "[getEmojiListByGroupIdExport] size%s", new Object[] { Integer.valueOf(paramString.size()) });
    return localObject1;
  }
  
  public final boolean AG(String paramString)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().AG(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "checkGifFile", null, localBundle);
    return (paramString != null) && (paramString.getBoolean("key_data"));
  }
  
  public final EmojiInfo At(String paramString)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().At(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    paramString = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiByMd5", null, localBundle);
    if (paramString != null)
    {
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      return (EmojiInfo)paramString.getParcelable("key_emoji_info");
    }
    return null;
  }
  
  public final String Aw(String paramString)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(paramString);
    }
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", paramString, null).getString("data", "");
  }
  
  public final String FU()
  {
    if (((h)g.DM().Dr()).Ex()) {
      this.uaH = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().FU();
    }
    for (;;)
    {
      return this.uaH;
      if (bk.bl(this.uaH)) {
        this.uaH = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final <T> T a(ac.a parama, T paramT)
  {
    if (((h)g.DM().Dr()).Ex()) {
      parama = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama, paramT);
    }
    Object localObject;
    do
    {
      do
      {
        return parama;
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("key_config_key", parama);
        localObject = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getConfig", null, (Bundle)localObject);
        parama = paramT;
      } while (localObject == null);
      localObject = ((Bundle)localObject).get("key_config_value");
      parama = paramT;
    } while (localObject == null);
    return localObject;
  }
  
  public final void a(bsl parambsl)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parambsl);
    }
  }
  
  public final boolean a(Context paramContext, EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.EmotionStorageResolver", "[cpan] save emoji failed. context is null");
      return false;
    }
    if (paramEmojiInfo == null)
    {
      y.e("MicroMsg.EmotionStorageResolver", "[cpan] save emoji failed. emoji is null");
      return false;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, Class.forName("com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI"));
      localIntent.putExtra("extra_id", paramEmojiInfo.Wv());
      localIntent.putExtra("extra_scence", paramInt1);
      localIntent.putExtra("extra_move_to_top", true);
      localIntent.putExtra("extra_current", true);
      localIntent.putExtra("key_is_selfie", paramBoolean);
      localIntent.putExtra("key_attached_text", paramString1);
      localIntent.putExtra("key_attached_emoji_md5", paramArrayList);
      localIntent.putExtra("key_imitate_md5", paramString2);
      localIntent.addFlags(65536);
      if ((paramInt2 > 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt2);
      } else {
        paramContext.startActivity(localIntent);
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.EmotionStorageResolver", paramContext, "start EmojiAddCustomDialogUI failed", new Object[0]);
    }
    return true;
  }
  
  public final boolean a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiGroupInfo);
    }
    return false;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramEmojiInfo);
    }
    if (paramEmojiInfo == null)
    {
      y.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
      return null;
    }
    String str = paramEmojiInfo.cwL();
    byte[] arrayOfByte1 = com.tencent.mm.vfs.e.c(str, 0, -1);
    long l1;
    int i;
    if ((com.tencent.mm.vfs.e.aeQ(str) > 0L) && (arrayOfByte1 != null) && (arrayOfByte1.length >= 10))
    {
      byte[] arrayOfByte2 = new byte[10];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo) && (!o.by(arrayOfByte2)))
      {
        l1 = System.currentTimeMillis();
        int j = (int)com.tencent.mm.vfs.e.aeQ(str);
        i = j;
        if (j > 1024) {
          i = 1024;
        }
        paramEmojiInfo = com.tencent.mm.vfs.e.c(str, 0, i);
        if (bk.bl(aHd())) {
          break label287;
        }
      }
    }
    label287:
    for (paramEmojiInfo = AesEcb.aesCryptEcb(paramEmojiInfo, aHd().getBytes(), false, false);; paramEmojiInfo = null)
    {
      if ((!bk.bE(paramEmojiInfo)) && (!bk.bE(arrayOfByte1)))
      {
        System.arraycopy(paramEmojiInfo, 0, arrayOfByte1, 0, i);
        long l2 = System.currentTimeMillis();
        y.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l2 - l1) });
        return arrayOfByte1;
      }
      y.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[] { str });
      return arrayOfByte1;
      return arrayOfByte1;
      y.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
      return null;
    }
  }
  
  public final bsl aHm()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHm();
    }
    return null;
  }
  
  public final ArrayList<EmojiGroupInfo> aHn()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHn();
    }
    if (this.uaL.size() == 0)
    {
      Object localObject = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiGroupInfoList", null, null);
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(EmojiGroupInfo.class.getClassLoader());
        if (((Bundle)localObject).containsKey("data"))
        {
          localObject = ((Bundle)localObject).getParcelableArrayList("data");
          this.uaL.addAll((Collection)localObject);
          y.i("MicroMsg.EmotionStorageResolver", "[getEmojiGroupInfoListExport] size%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        }
      }
    }
    return this.uaL;
  }
  
  public final int aHo()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHo();
    }
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt("data", 0);
  }
  
  public final ArrayList<EmojiInfo> aHp()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHp();
    }
    if (this.uaI.size() == 0)
    {
      Object localObject = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAllCustomEmoji", "false", null);
      if (localObject != null)
      {
        ((Bundle)localObject).setClassLoader(EmojiInfo.class.getClassLoader());
        if (((Bundle)localObject).containsKey("data"))
        {
          localObject = ((Bundle)localObject).getParcelableArrayList("data");
          this.uaI.addAll((Collection)localObject);
          y.i("MicroMsg.EmotionStorageResolver", "[getAllCustomEmojiExport] size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
        }
      }
    }
    return this.uaI;
  }
  
  public final ArrayList<EmojiInfo> aHq()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHq();
    }
    return this.uaJ;
  }
  
  public final com.tencent.mm.as.a.a aHr()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHr();
    }
    if (this.jwM == null)
    {
      b.a locala = new b.a(ae.getContext());
      locala.eqS = new com.tencent.mm.view.d.a();
      this.jwM = new com.tencent.mm.as.a.a(locala.OU());
    }
    return this.jwM;
  }
  
  public final boolean aHs()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHs();
    }
    Bundle localBundle = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHEVCDecode", null, null);
    return (localBundle != null) && (localBundle.getBoolean("key_data"));
  }
  
  public final boolean aHt()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHt();
    }
    Bundle localBundle = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHevcUpload", null, null);
    return (localBundle != null) && (localBundle.getBoolean("key_data"));
  }
  
  public final boolean aHu()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHu();
    }
    return false;
  }
  
  public final List<u> aHv()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHv();
    }
    return null;
  }
  
  public final void aHw()
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHw();
    }
  }
  
  public final void b(ac.a parama, Object paramObject)
  {
    if (((h)g.DM().Dr()).Ex())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().b(parama, paramObject);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    localBundle.putSerializable("key_config_value", (Serializable)paramObject);
    ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "setConfig", null, localBundle);
  }
  
  public final boolean bNy()
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bNy();
    }
    return false;
  }
  
  public final void bv(String paramString, int paramInt)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bv(paramString, paramInt);
    }
  }
  
  public final EmojiInfo c(EmojiInfo paramEmojiInfo)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(paramEmojiInfo);
    }
    Bundle localBundle = new Bundle(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", paramEmojiInfo);
    paramEmojiInfo = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRamdomEmoji", null, localBundle);
    if (paramEmojiInfo == null)
    {
      y.e("MicroMsg.EmotionStorageResolver", "[getRamdomEmoji] bunndle is null! ");
      return null;
    }
    paramEmojiInfo.setClassLoader(EmojiInfo.class.getClassLoader());
    if (paramEmojiInfo.containsKey("data")) {
      return (EmojiInfo)paramEmojiInfo.getParcelable("data");
    }
    if (paramEmojiInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.e("MicroMsg.EmotionStorageResolver", "[getRamdomEmoji] bundle is null?", new Object[] { Boolean.valueOf(bool) });
      return null;
    }
  }
  
  public final void d(EmojiInfo paramEmojiInfo)
  {
    if (((h)g.DM().Dr()).Ex())
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramEmojiInfo);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("key_emoji_info", paramEmojiInfo);
    ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "updateEmojiInfo", null, localBundle);
  }
  
  public final int fc(boolean paramBoolean)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fc(paramBoolean);
    }
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, null).getInt("data", 0);
  }
  
  public final void g(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().g(parama);
    }
  }
  
  public final EmojiInfo h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((h)g.DM().Dr()).Ex()) {
      return ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString, "", paramInt1, paramInt2, paramInt3, "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_md5", paramString);
    localBundle.putInt("key_group", paramInt1);
    localBundle.putInt("key_type", paramInt2);
    localBundle.putInt("key_size", paramInt3);
    paramString = ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "createEmojiInfo", null, localBundle);
    if (paramString != null)
    {
      paramString.setClassLoader(EmojiInfo.class.getClassLoader());
      return (EmojiInfo)paramString.getParcelable("key_emoji_info");
    }
    return null;
  }
  
  public final void h(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(parama);
    }
  }
  
  public final void i(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().i(parama);
    }
  }
  
  public final void j(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(parama);
    }
  }
  
  public final void k(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(parama);
    }
  }
  
  public final void l(j.a parama)
  {
    if (((h)g.DM().Dr()).Ex()) {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().k(parama);
    }
  }
  
  public final void onDestroy()
  {
    this.uaL.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ca.a
 * JD-Core Version:    0.7.0.1
 */