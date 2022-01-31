package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.z;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionContentProvider
  extends ContentProvider
{
  private static final UriMatcher ljd;
  
  static
  {
    AppMethodBeat.i(53170);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    ljd = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
    ljd.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
    ljd.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
    ljd.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
    ljd.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
    AppMethodBeat.o(53170);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(53169);
    ab.d("MicroMsg.EmotionContentProvider", "[call] method:%s", new Object[] { paramString1 });
    if (paramString1.equals("getAccPath"))
    {
      paramString1 = new Bundle();
      paramString1.putString("path", g.RL().eHR);
      AppMethodBeat.o(53169);
      return paramString1;
    }
    if (paramString1.equals("getEmojiKey"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", i.getEmojiStorageMgr().yNn.getKey());
      AppMethodBeat.o(53169);
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getBoolean"))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("key", ((Boolean)g.RL().Ru().get(paramBundle.getInt("key"), Boolean.FALSE)).booleanValue());
      AppMethodBeat.o(53169);
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getString"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", (String)g.RL().Ru().get(paramBundle.getInt("key"), ""));
      AppMethodBeat.o(53169);
      return paramString1;
    }
    if (paramString1.equals("getAllCustomEmoji"))
    {
      paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
      paramString1.putParcelableArrayList("data", i.getEmojiStorageMgr().ch(false));
      AppMethodBeat.o(53169);
      return paramString1;
    }
    if (paramString1.equals("getRandomEmoji"))
    {
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
        paramString1 = (EmojiInfo)paramBundle.getParcelable("emoji");
        paramString2 = new Bundle(EmojiInfo.class.getClassLoader());
        paramString2.putParcelable("data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().n(paramString1));
        AppMethodBeat.o(53169);
        return paramString2;
      }
      if (paramBundle == null) {
        ab.e("MicroMsg.EmotionContentProvider", "[getRandomEmoji] extras:%s", new Object[] { Boolean.valueOf(bool1) });
      }
    }
    label1565:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(53169);
        return null;
        bool1 = false;
        break;
        if (paramString1.equals("getCurLangDesc"))
        {
          paramString1 = new Bundle();
          paramString1.putString("data", i.getEmojiDescMgr().Kx(paramString2));
          AppMethodBeat.o(53169);
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
          paramString1.putInt("data", i.getEmojiStorageMgr().yNn.y(bool1, bool2));
          AppMethodBeat.o(53169);
          return paramString1;
        }
        if (paramString1.equals("countCaptureEmoji"))
        {
          bool1 = bool4;
          if (paramBundle != null) {
            bool1 = paramBundle.getBoolean("onlySuccess");
          }
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().yNn.pT(bool1));
          AppMethodBeat.o(53169);
          return paramString1;
        }
        if (paramString1.equals("countProductId"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().yNn.KF(paramString2));
          AppMethodBeat.o(53169);
          return paramString1;
        }
        if (paramString1.equals("getDownloadedCount"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().blc());
          AppMethodBeat.o(53169);
          return paramString1;
        }
        if (paramString1.equals("getEmojiListByGroupId"))
        {
          paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", (ArrayList)((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kw(paramString2));
          AppMethodBeat.o(53169);
          return paramString1;
        }
        if (paramString1.equals("getEmojiGroupInfoList"))
        {
          paramString1 = new Bundle(EmojiGroupInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", i.getEmojiStorageMgr().yNz.OB());
          AppMethodBeat.o(53169);
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
            paramString1 = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().j(paramString1, i, j, k);
            paramString2 = new Bundle();
            paramString2.putParcelable("key_emoji_info", paramString1);
            AppMethodBeat.o(53169);
            return paramString2;
          }
        }
        else if (paramString1.equals("updateEmojiInfo"))
        {
          if (paramBundle != null)
          {
            paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
            paramString1 = (EmojiInfo)paramBundle.get("key_emoji_info");
            ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramString1);
          }
        }
        else
        {
          if (paramString1.equals("isEnableHEVCDecode"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().ble());
            AppMethodBeat.o(53169);
            return paramString1;
          }
          if (paramString1.equals("isEnableHevcUpload"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OQ());
            AppMethodBeat.o(53169);
            return paramString1;
          }
          if (paramString1.equals("getEmojiByMd5"))
          {
            if (paramBundle != null)
            {
              paramString1 = paramBundle.getString("key_md5");
              paramString2 = new Bundle();
              paramString2.putParcelable("key_emoji_info", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ku(paramString1));
              AppMethodBeat.o(53169);
              return paramString2;
            }
          }
          else if (paramString1.equals("getConfig"))
          {
            if (paramBundle != null)
            {
              paramString1 = (ac.a)paramBundle.get("key_config_key");
              paramString1 = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(paramString1, null);
              paramString2 = new Bundle();
              paramString2.putSerializable("key_config_value", (Serializable)paramString1);
              AppMethodBeat.o(53169);
              return paramString2;
            }
          }
          else if (paramString1.equals("setConfig"))
          {
            if (paramBundle != null)
            {
              paramString1 = (ac.a)paramBundle.get("key_config_key");
              paramString2 = paramBundle.get("key_config_value");
              ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramString1, paramString2);
            }
          }
          else if (paramString1.equals("checkGifFile"))
          {
            if (paramBundle != null)
            {
              paramString1 = new Bundle();
              paramString2 = paramBundle.getString("key_path");
              paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KG(paramString2));
              AppMethodBeat.o(53169);
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
                paramString1.putParcelableArrayList("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkU());
                AppMethodBeat.o(53169);
                return paramString1;
              }
              catch (Exception paramString2)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.EmotionContentProvider", paramString2, "", new Object[0]);
                }
              }
            }
            if (paramString1.equals("deleteLoadingCaptureEmoji"))
            {
              if (!bo.isNullOrNil(paramString2)) {
                ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KH(paramString2);
              }
            }
            else if (paramString1.equals("uploadEmojiRemote"))
            {
              if (paramBundle != null)
              {
                paramString1 = (String)paramBundle.getParcelable("emojiMd5");
                paramBundle.setClassLoader(EmojiCaptureReporter.class.getClassLoader());
                paramString2 = (EmojiCaptureReporter)paramBundle.getParcelable("reporter");
                ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(new EmojiCaptureUploadManager.UploadTask(paramString1, paramString2));
              }
            }
            else if (paramString1.equals("showCaptureEmojiInPanel"))
            {
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
                paramString1 = (EmojiInfo)paramBundle.getParcelable("emojiInfo");
                ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(paramString1);
              }
            }
            else if (paramString1.equals("showCaptureEmojiDefaultErrorDialog"))
            {
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
                paramString1 = (EmojiInfo)paramBundle.getParcelable("emojiInfo");
                ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s(paramString1);
              }
            }
            else
            {
              if (!paramString1.equals("addCaptureEmojiUploadTask")) {
                break label1565;
              }
              if (paramBundle != null)
              {
                paramBundle.setClassLoader(EmojiCaptureUploadManager.UploadTask.class.getClassLoader());
                paramString1 = (EmojiCaptureUploadManager.UploadTask)paramBundle.getParcelable("uploadTask");
                ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().b(paramString1);
              }
            }
          }
        }
      }
      if (paramString1.equals("getCaptureEmoji"))
      {
        paramString1 = new Bundle();
        paramString1.putParcelableArrayList("key_data", com.tencent.mm.emoji.a.d.Oz().ci(false));
        AppMethodBeat.o(53169);
        return paramString1;
      }
      if (paramString1.equals("getSmileyPanelInfoList"))
      {
        paramString1 = new Bundle();
        paramString1.putParcelableArrayList("smiley_panel_info", ((PluginEmoji)g.G(PluginEmoji.class)).getEmojiMgr().bkV());
        AppMethodBeat.o(53169);
        return paramString1;
      }
    } while (!paramString1.equals("getPanelConfigName"));
    paramString1 = new Bundle();
    paramString1.putString("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().bkY());
    AppMethodBeat.o(53169);
    return paramString1;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(53167);
    switch (ljd.match(paramUri))
    {
    default: 
      AppMethodBeat.o(53167);
      return 0;
    }
    int i = g.RL().eHS.delete("GetEmotionListCache", paramString, paramArrayOfString);
    AppMethodBeat.o(53167);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(53166);
    switch (ljd.match(paramUri))
    {
    default: 
      AppMethodBeat.o(53166);
      return paramUri;
    }
    paramUri = Uri.withAppendedPath(paramUri, String.valueOf(g.RL().eHS.a("GetEmotionListCache", o.info.yrL, paramContentValues)));
    AppMethodBeat.o(53166);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(53164);
    ab.i("MicroMsg.EmotionContentProvider", "[onCreate]");
    AppMethodBeat.o(53164);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(53165);
    ab.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", new Object[] { paramUri.getPath(), paramString1 });
    switch (ljd.match(paramUri))
    {
    case 2: 
    default: 
      AppMethodBeat.o(53165);
      return null;
    case 1: 
      paramUri = g.RL().eHS.a(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(53165);
      return paramUri;
    case 3: 
      paramUri = g.RL().eHS.a(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(53165);
      return paramUri;
    case 4: 
      paramUri = g.RL().eHS.a(paramString1, paramArrayOfString2, 2);
      AppMethodBeat.o(53165);
      return paramUri;
    }
    paramUri = g.RL().eHS.a(paramString1, paramArrayOfString2, 2);
    AppMethodBeat.o(53165);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(53168);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(53168);
      return -1;
    }
    switch (ljd.match(paramUri))
    {
    default: 
      AppMethodBeat.o(53168);
      return -1;
    case 2: 
      g.RL().Ru().set(((Integer)paramContentValues.get("type")).intValue(), paramContentValues.get("value"));
      AppMethodBeat.o(53168);
      return 0;
    }
    int i = g.RL().eHS.update("EmojiGroupInfo", paramContentValues, paramString, paramArrayOfString);
    AppMethodBeat.o(53168);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.provider.EmotionContentProvider
 * JD-Core Version:    0.7.0.1
 */