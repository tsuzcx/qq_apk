package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.decode.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.r;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionContentProvider
  extends ContentProvider
{
  private static final UriMatcher uGx;
  
  static
  {
    AppMethodBeat.i(108743);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    uGx = localUriMatcher;
    localUriMatcher.addURI(g.AUTHORITY, "EmojiGroupInfo", 1);
    uGx.addURI(g.AUTHORITY, "userinfo", 2);
    uGx.addURI(g.AUTHORITY, "GetEmotionListCache", 3);
    uGx.addURI(g.AUTHORITY, "EmojiInfo", 4);
    uGx.addURI(g.AUTHORITY, "EmojiInfoDesc", 5);
    AppMethodBeat.o(108743);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(108742);
    Log.d("MicroMsg.EmotionContentProvider", "[call] method:%s", new Object[] { paramString1 });
    if ((!com.tencent.mm.kernel.h.aHH().kdm) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      Log.i("MicroMsg.EmotionContentProvider", "[call] method:%s, but kernel or account not init.", new Object[] { paramString1 });
      AppMethodBeat.o(108742);
      return null;
    }
    if (paramString1.equals("getAccPath"))
    {
      paramString1 = new Bundle();
      paramString1.putString("path", com.tencent.mm.kernel.h.aHG().kcB);
      AppMethodBeat.o(108742);
      return paramString1;
    }
    if (paramString1.equals("getEmojiKey"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", a.aBf().aBg());
      AppMethodBeat.o(108742);
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getBoolean"))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("key", ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(paramBundle.getInt("key"), Boolean.FALSE)).booleanValue());
      AppMethodBeat.o(108742);
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getString"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", (String)com.tencent.mm.kernel.h.aHG().aHp().b(paramBundle.getInt("key"), ""));
      AppMethodBeat.o(108742);
      return paramString1;
    }
    if (paramString1.equals("getAllCustomEmoji"))
    {
      paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
      paramString1.putParcelableArrayList("key_data", k.aBH().aBK());
      AppMethodBeat.o(108742);
      return paramString1;
    }
    if (paramString1.equals("getRandomEmoji"))
    {
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
        paramString1 = (EmojiInfo)paramBundle.getParcelable("emoji");
        paramString2 = new Bundle(EmojiInfo.class.getClassLoader());
        paramString2.putParcelable("data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().p(paramString1));
        AppMethodBeat.o(108742);
        return paramString2;
      }
      if (paramBundle == null) {
        Log.e("MicroMsg.EmotionContentProvider", "[getRandomEmoji] extras:%s", new Object[] { Boolean.valueOf(bool1) });
      }
    }
    label1471:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(108742);
        return null;
        bool1 = false;
        break;
        if (paramString1.equals("getCurLangDesc"))
        {
          paramString1 = new Bundle();
          paramString1.putString("data", p.getEmojiDescMgr().auh(paramString2));
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("countCustomEmoji"))
        {
          bool1 = bool3;
          if (paramBundle != null)
          {
            bool1 = paramBundle.getBoolean("withSystem");
            bool2 = paramBundle.getBoolean("onlySuccess");
          }
          paramString1 = new Bundle();
          paramString1.putInt("data", p.getEmojiStorageMgr().VFH.bl(bool1, bool2));
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("countCaptureEmoji"))
        {
          bool1 = bool4;
          if (paramBundle != null) {
            bool1 = paramBundle.getBoolean("onlySuccess");
          }
          paramString1 = new Bundle();
          paramString1.putInt("data", p.getEmojiStorageMgr().VFH.EU(bool1));
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("countProductId"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", p.getEmojiStorageMgr().VFH.bxD(paramString2));
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("getEmojiListByGroupId"))
        {
          paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", (ArrayList)((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aug(paramString2));
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("getDesignerInfo"))
        {
          paramString1 = new Bundle();
          paramString2 = bj.hyV().VFL.bxT(paramString2);
          if (paramString2 != null) {
            paramString1.putByteArray("buffer", paramString2.field_content);
          }
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("getEmojiGroupInfoList"))
        {
          paramString1 = new Bundle(EmojiGroupInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", p.getEmojiStorageMgr().VFV.aBL());
          AppMethodBeat.o(108742);
          return paramString1;
        }
        if (paramString1.equals("createEmojiInfo"))
        {
          if (paramBundle != null)
          {
            paramString1 = paramBundle.getString("key_md5");
            int i = paramBundle.getInt("key_group");
            int j = paramBundle.getInt("key_type");
            int k = paramBundle.getInt("key_size");
            paramString1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().n(paramString1, i, j, k);
            paramString2 = new Bundle();
            paramString2.putParcelable("key_emoji_info", paramString1);
            AppMethodBeat.o(108742);
            return paramString2;
          }
        }
        else if (paramString1.equals("updateEmojiInfo"))
        {
          if (paramBundle != null)
          {
            paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
            paramString1 = (EmojiInfo)paramBundle.get("key_emoji_info");
            ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramString1);
          }
        }
        else
        {
          if (paramString1.equals("isEnableHEVCDecode"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUw());
            AppMethodBeat.o(108742);
            return paramString1;
          }
          if (paramString1.equals("isEnableHevcUpload"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aBZ());
            AppMethodBeat.o(108742);
            return paramString1;
          }
          if (paramString1.equals("getEmojiByMd5"))
          {
            if (paramBundle != null)
            {
              paramString1 = paramBundle.getString("key_md5");
              paramString2 = new Bundle();
              paramString2.putParcelable("key_emoji_info", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aue(paramString1));
              AppMethodBeat.o(108742);
              return paramString2;
            }
          }
          else if (paramString1.equals("getConfig"))
          {
            if (paramBundle != null)
            {
              paramString1 = (ar.a)paramBundle.get("key_config_key");
              paramString1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(paramString1, null);
              paramString2 = new Bundle();
              paramString2.putSerializable("key_config_value", (Serializable)paramString1);
              AppMethodBeat.o(108742);
              return paramString2;
            }
          }
          else if (paramString1.equals("setConfig"))
          {
            if (paramBundle != null)
            {
              paramString1 = (ar.a)paramBundle.get("key_config_key");
              paramString2 = paramBundle.get("key_config_value");
              ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramString1, paramString2);
            }
          }
          else if (paramString1.equals("checkGifFile"))
          {
            if (paramBundle != null)
            {
              paramString1 = new Bundle();
              paramString2 = paramBundle.getString("key_path");
              paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aus(paramString2));
              AppMethodBeat.o(108742);
              return paramString1;
            }
          }
          else
          {
            if (paramString1.equals("getSmileyInfoList"))
            {
              paramString1 = new Bundle();
              try
              {
                paramString1.putParcelableArrayList("key_data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUo());
                AppMethodBeat.o(108742);
                return paramString1;
              }
              catch (Exception paramString2)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.EmotionContentProvider", paramString2, "", new Object[0]);
                }
              }
            }
            if (paramString1.equals("deleteLoadingCaptureEmoji"))
            {
              if (!Util.isNullOrNil(paramString2)) {
                ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auu(paramString2);
              }
            }
            else if (paramString1.equals("showCaptureEmojiInPanel"))
            {
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
                paramString1 = (EmojiInfo)paramBundle.getParcelable("emojiInfo");
                ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().t(paramString1);
              }
            }
            else
            {
              if (!paramString1.equals("addCaptureEmojiUploadTask")) {
                break label1471;
              }
              if (paramBundle != null)
              {
                paramString1 = paramBundle.getString("key_md5");
                ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auv(paramString1);
              }
            }
          }
        }
      }
      if (paramString1.equals("getCaptureEmoji"))
      {
        paramString1 = new Bundle();
        paramString1.putParcelableArrayList("key_data", k.aBH().es(false));
        AppMethodBeat.o(108742);
        return paramString1;
      }
      if (paramString1.equals("getSmileyPanelInfoList"))
      {
        paramString1 = new Bundle();
        paramString1.putParcelableArrayList("smiley_panel_info", ((PluginEmoji)com.tencent.mm.kernel.h.ag(PluginEmoji.class)).getEmojiMgr().cUp());
        AppMethodBeat.o(108742);
        return paramString1;
      }
    } while (!paramString1.equals("getPanelConfigName"));
    paramString1 = new Bundle();
    paramString1.putString("key_data", ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cUs());
    AppMethodBeat.o(108742);
    return paramString1;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(108740);
    if ((!com.tencent.mm.kernel.h.aHH().kdm) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      Log.i("MicroMsg.EmotionContentProvider", "[delete] kernel or account not init.");
      AppMethodBeat.o(108740);
      return 0;
    }
    switch (uGx.match(paramUri))
    {
    default: 
      AppMethodBeat.o(108740);
      return 0;
    }
    int i = com.tencent.mm.kernel.h.aHG().kcF.delete("GetEmotionListCache", paramString, paramArrayOfString);
    AppMethodBeat.o(108740);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(108739);
    if ((!com.tencent.mm.kernel.h.aHH().kdm) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      Log.i("MicroMsg.EmotionContentProvider", "[insert] kernel or account not init.");
      AppMethodBeat.o(108739);
      return paramUri;
    }
    switch (uGx.match(paramUri))
    {
    default: 
      AppMethodBeat.o(108739);
      return paramUri;
    }
    paramUri = Uri.withAppendedPath(paramUri, String.valueOf(com.tencent.mm.kernel.h.aHG().kcF.insert("GetEmotionListCache", r.info.primaryKey, paramContentValues)));
    AppMethodBeat.o(108739);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(108737);
    Log.i("MicroMsg.EmotionContentProvider", "[onCreate]");
    AppMethodBeat.o(108737);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(108738);
    if ((!com.tencent.mm.kernel.h.aHH().kdm) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      Log.i("MicroMsg.EmotionContentProvider", "[query] kernel or account not init.");
      AppMethodBeat.o(108738);
      return null;
    }
    Log.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", new Object[] { paramUri.getPath(), paramString1 });
    switch (uGx.match(paramUri))
    {
    case 2: 
    default: 
      AppMethodBeat.o(108738);
      return null;
    case 1: 
      paramUri = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(108738);
      return paramUri;
    case 3: 
      paramUri = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(108738);
      return paramUri;
    case 4: 
      paramUri = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(108738);
      return paramUri;
    }
    paramUri = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString1, paramArrayOfString2, 2);
    AppMethodBeat.o(108738);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(108741);
    if ((!com.tencent.mm.kernel.h.aHH().kdm) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      Log.i("MicroMsg.EmotionContentProvider", "[update] kernel or account not init.");
      AppMethodBeat.o(108741);
      return -1;
    }
    switch (uGx.match(paramUri))
    {
    default: 
      AppMethodBeat.o(108741);
      return -1;
    case 2: 
      com.tencent.mm.kernel.h.aHG().aHp().i(((Integer)paramContentValues.get("type")).intValue(), paramContentValues.get("value"));
      AppMethodBeat.o(108741);
      return 0;
    }
    int i = com.tencent.mm.kernel.h.aHG().kcF.update("EmojiGroupInfo", paramContentValues, paramString, paramArrayOfString);
    AppMethodBeat.o(108741);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.provider.EmotionContentProvider
 * JD-Core Version:    0.7.0.1
 */