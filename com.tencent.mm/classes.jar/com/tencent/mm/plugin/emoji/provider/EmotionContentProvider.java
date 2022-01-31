package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
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
  private static final UriMatcher jam;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jam = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
    jam.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
    jam.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
    jam.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
    jam.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool = true;
    y.d("MicroMsg.EmotionContentProvider", "[call] method:%s", new Object[] { paramString1 });
    if (paramString1.equals("getAccPath"))
    {
      paramString1 = new Bundle();
      paramString1.putString("path", g.DP().dKt);
      return paramString1;
    }
    if (paramString1.equals("getEmojiKey"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", i.getEmojiStorageMgr().uBb.getKey());
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getBoolean"))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("key", ((Boolean)g.DP().Dz().get(paramBundle.getInt("key"), Boolean.valueOf(false))).booleanValue());
      return paramString1;
    }
    if (paramString1.equals("ConfigStorage.getString"))
    {
      paramString1 = new Bundle();
      paramString1.putString("key", (String)g.DP().Dz().get(paramBundle.getInt("key"), ""));
      return paramString1;
    }
    if (paramString1.equals("getAllCustomEmoji"))
    {
      paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
      paramString1.putParcelableArrayList("data", i.getEmojiStorageMgr().aHp());
      return paramString1;
    }
    if (paramString1.equals("getRamdomEmoji"))
    {
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
        paramString1 = (EmojiInfo)paramBundle.getParcelable("emoji");
        paramString2 = new Bundle(EmojiInfo.class.getClassLoader());
        paramString2.putParcelable("data", ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().c(paramString1));
        return paramString2;
      }
      if (paramBundle == null) {
        y.e("MicroMsg.EmotionContentProvider", "[getRamdomEmoji] extras:%s", new Object[] { Boolean.valueOf(bool) });
      }
    }
    label952:
    do
    {
      for (;;)
      {
        return null;
        bool = false;
        break;
        if (paramString1.equals("getCurLangDesc"))
        {
          paramString1 = new Bundle();
          paramString1.putString("data", i.getEmojiDescMgr().Aw(paramString2));
          return paramString1;
        }
        if (paramString1.equals("countCustomEmoji"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().uBb.fc(true));
          return paramString1;
        }
        if (paramString1.equals("countProductId"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().uBb.AE(paramString2));
          return paramString1;
        }
        if (paramString1.equals("getDownloadedCount"))
        {
          paramString1 = new Bundle();
          paramString1.putInt("data", i.getEmojiStorageMgr().aHo());
          return paramString1;
        }
        if (paramString1.equals("getEmojiListByGroupId"))
        {
          paramString1 = new Bundle(EmojiInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", (ArrayList)((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Av(paramString2));
          return paramString1;
        }
        if (paramString1.equals("getEmojiGroupInfoList"))
        {
          paramString1 = new Bundle(EmojiGroupInfo.class.getClassLoader());
          paramString1.putParcelableArrayList("data", i.getEmojiStorageMgr().aHn());
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
            paramString1 = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(paramString1, i, j, k);
            paramString2 = new Bundle();
            paramString2.putParcelable("key_emoji_info", paramString1);
            return paramString2;
          }
        }
        else if (paramString1.equals("updateEmojiInfo"))
        {
          if (paramBundle != null)
          {
            paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
            paramString1 = (EmojiInfo)paramBundle.get("key_emoji_info");
            ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramString1);
          }
        }
        else
        {
          if (paramString1.equals("isEnableHEVCDecode"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHs());
            return paramString1;
          }
          if (paramString1.equals("isEnableHevcUpload"))
          {
            paramString1 = new Bundle();
            paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHt());
            return paramString1;
          }
          if (paramString1.equals("getEmojiByMd5"))
          {
            if (paramBundle != null)
            {
              paramString1 = paramBundle.getString("key_md5");
              paramString2 = new Bundle();
              paramString2.putParcelable("key_emoji_info", ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().At(paramString1));
              return paramString2;
            }
          }
          else if (paramString1.equals("getConfig"))
          {
            if (paramBundle != null)
            {
              paramString1 = (ac.a)paramBundle.get("key_config_key");
              paramString1 = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(paramString1, null);
              paramString2 = new Bundle();
              paramString2.putSerializable("key_config_value", (Serializable)paramString1);
              return paramString2;
            }
          }
          else
          {
            if (!paramString1.equals("setConfig")) {
              break label952;
            }
            if (paramBundle != null)
            {
              paramString1 = (ac.a)paramBundle.get("key_config_key");
              paramString2 = paramBundle.get("key_config_value");
              ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().b(paramString1, paramString2);
            }
          }
        }
      }
    } while ((!paramString1.equals("checkGifFile")) || (paramBundle == null));
    paramString1 = new Bundle();
    paramString2 = paramBundle.getString("key_path");
    paramString1.putBoolean("key_data", ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().AG(paramString2));
    return paramString1;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (jam.match(paramUri))
    {
    default: 
      return 0;
    }
    return g.DP().dKu.delete("GetEmotionListCache", paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    switch (jam.match(paramUri))
    {
    default: 
      return paramUri;
    }
    return Uri.withAppendedPath(paramUri, String.valueOf(g.DP().dKu.insert("GetEmotionListCache", o.buS.ujM, paramContentValues)));
  }
  
  public boolean onCreate()
  {
    y.i("MicroMsg.EmotionContentProvider", "[onCreate]");
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", new Object[] { paramUri.getPath(), paramString1 });
    switch (jam.match(paramUri))
    {
    case 2: 
    default: 
      return null;
    case 1: 
      return g.DP().dKu.a(paramString1, paramArrayOfString2, 2);
    case 3: 
      return g.DP().dKu.a(paramString1, paramArrayOfString2, 2);
    case 4: 
      return g.DP().dKu.a(paramString1, paramArrayOfString2, 2);
    }
    return g.DP().dKu.a(paramString1, paramArrayOfString2, 2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!g.DN().Dc()) {
      return -1;
    }
    switch (jam.match(paramUri))
    {
    default: 
      return -1;
    case 1: 
      return g.DP().dKu.update("EmojiGroupInfo", paramContentValues, paramString, paramArrayOfString);
    }
    g.DP().Dz().o(((Integer)paramContentValues.get("type")).intValue(), paramContentValues.get("value"));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.provider.EmotionContentProvider
 * JD-Core Version:    0.7.0.1
 */