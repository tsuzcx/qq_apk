package com.tencent.mm.cc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.b.e
{
  public static a aclu;
  public static b aclv;
  private String aclt;
  
  static
  {
    AppMethodBeat.i(104893);
    aclu = new a();
    aclv = new b();
    AppMethodBeat.o(104893);
  }
  
  public a()
  {
    AppMethodBeat.i(104851);
    AppMethodBeat.o(104851);
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
  
  public static Uri getUri()
  {
    AppMethodBeat.i(185735);
    Uri localUri = Uri.parse("content://" + com.tencent.mm.api.h.AUTHORITY + "/");
    AppMethodBeat.o(185735);
    return localUri;
  }
  
  public static a iRg()
  {
    return aclu;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104862);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(paramEmojiInfo);
      AppMethodBeat.o(104862);
      return paramEmojiInfo;
    }
    paramEmojiInfo = com.tencent.mm.emoji.decode.a.aUc().a(paramEmojiInfo);
    AppMethodBeat.o(104862);
    return paramEmojiInfo;
  }
  
  public final boolean aUW()
  {
    AppMethodBeat.i(104875);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aUW();
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
  
  public final boolean aUX()
  {
    AppMethodBeat.i(104876);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aUX();
      AppMethodBeat.o(104876);
      return bool;
    }
    AppMethodBeat.o(104876);
    return false;
  }
  
  public final EmojiInfo aof(String paramString)
  {
    AppMethodBeat.i(104866);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aof(paramString);
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
  
  public final String aoi(String paramString)
  {
    AppMethodBeat.i(104852);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(104852);
      return paramString;
    }
    paramString = a(getUri(), "getCurLangDesc", paramString, null).getString("data", "");
    AppMethodBeat.o(104852);
    return paramString;
  }
  
  public final void aos(String paramString)
  {
    AppMethodBeat.i(177033);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aos(paramString);
    }
    AppMethodBeat.o(177033);
  }
  
  public final boolean aot(String paramString)
  {
    AppMethodBeat.i(104882);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aot(paramString);
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
  
  public final boolean aou(String paramString)
  {
    AppMethodBeat.i(231061);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aou(paramString);
      AppMethodBeat.o(231061);
      return bool;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_path", paramString);
    paramString = a(getUri(), "checkGifFile", null, localBundle);
    if ((paramString != null) && (paramString.getBoolean("key_data")))
    {
      AppMethodBeat.o(231061);
      return true;
    }
    AppMethodBeat.o(231061);
    return false;
  }
  
  public final void aov(String paramString)
  {
    AppMethodBeat.i(104887);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aov(paramString);
        AppMethodBeat.o(104887);
      }
    }
    else {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "deleteLoadingCaptureEmoji", paramString, null);
    }
    AppMethodBeat.o(104887);
  }
  
  public final void aow(String paramString)
  {
    AppMethodBeat.i(104889);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aow(paramString);
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
  
  public final <T> T c(at.a parama, T paramT)
  {
    AppMethodBeat.i(104880);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      parama = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().c(parama, paramT);
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
  
  public final void d(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(104881);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().d(parama, paramObject);
      AppMethodBeat.o(104881);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("key_config_key", parama);
    localBundle.putSerializable("key_config_value", (Serializable)paramObject);
    a(getUri(), "setConfig", null, localBundle);
    AppMethodBeat.o(104881);
  }
  
  public final void dzA()
  {
    AppMethodBeat.i(104885);
    if ((((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) && (com.tencent.mm.kernel.h.baC().aZN())) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzA();
    }
    AppMethodBeat.o(104885);
  }
  
  public final boolean dzD()
  {
    AppMethodBeat.i(104874);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzD();
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
  
  public final List<x> dzE()
  {
    AppMethodBeat.i(104878);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      List localList = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzE();
      AppMethodBeat.o(104878);
      return localList;
    }
    AppMethodBeat.o(104878);
    return null;
  }
  
  public final void dzF()
  {
    AppMethodBeat.i(104879);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzF();
    }
    AppMethodBeat.o(104879);
  }
  
  public final boolean dzG()
  {
    AppMethodBeat.i(104883);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      boolean bool = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzG();
      AppMethodBeat.o(104883);
      return bool;
    }
    AppMethodBeat.o(104883);
    return false;
  }
  
  public final ArrayList<SmileyInfo> dzv()
  {
    AppMethodBeat.i(104884);
    Object localObject;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzv();
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
  
  public final ArrayList<SmileyPanelConfigInfo> dzw()
  {
    AppMethodBeat.i(104890);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzw();
      AppMethodBeat.o(104890);
      return localObject;
    }
    Object localObject = a(getUri(), "getSmileyPanelInfoList", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getParcelableArrayList("smiley_panel_info");
    AppMethodBeat.o(104890);
    return localObject;
  }
  
  public final String dzz()
  {
    AppMethodBeat.i(104891);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzz();
      AppMethodBeat.o(104891);
      return localObject;
    }
    Object localObject = a(getUri(), "getPanelConfigName", null, null);
    ((Bundle)localObject).setClassLoader(SmileyPanelConfigInfo.class.getClassLoader());
    localObject = ((Bundle)localObject).getString("key_data");
    AppMethodBeat.o(104891);
    return localObject;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(104871);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      this.aclt = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().getAccPath();
    }
    for (;;)
    {
      String str = this.aclt;
      AppMethodBeat.o(104871);
      return str;
      if (Util.isNullOrNil(this.aclt)) {
        this.aclt = a(getUri(), "getAccPath", null, null).getString("path");
      }
    }
  }
  
  public final void h(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104861);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().h(paramIOnStorageChange);
    }
    AppMethodBeat.o(104861);
  }
  
  public final void i(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104863);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().i(paramIOnStorageChange);
    }
    AppMethodBeat.o(104863);
  }
  
  public final void j(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104864);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().j(paramIOnStorageChange);
    }
    AppMethodBeat.o(104864);
  }
  
  public final void k(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(104865);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().k(paramIOnStorageChange);
    }
    AppMethodBeat.o(104865);
  }
  
  public final EmojiInfo o(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104853);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(paramString, "", paramInt1, paramInt2, paramInt3, "");
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      paramEmojiInfo = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().p(paramEmojiInfo);
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().t(paramEmojiInfo);
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
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
    public static void btU(String paramString)
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
      AppMethodBeat.i(231034);
      Uri localUri = Uri.parse("content://" + com.tencent.mm.api.h.AUTHORITY + "/userinfo/");
      AppMethodBeat.o(231034);
      return localUri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cc.a
 * JD-Core Version:    0.7.0.1
 */