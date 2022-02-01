package com.tencent.mobileqq.activity.widget.qqmusic.business.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.QQMusicHelper;
import com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader;
import com.tencent.mobileqq.activity.widget.qqmusic.business.player.UtilForFromTag;
import com.tencent.mobileqq.activity.widget.qqmusic.business.session.SessionManager;
import com.tencent.mobileqq.activity.widget.qqmusic.data.Session;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.QLog;
import hdc;
import hde;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareHelper
{
  static final byte a = 1;
  public static final String a = "liwei";
  static final String b = "title";
  static final String c = "desc";
  static final String d = "share_url";
  static final String e = "image_url";
  static final String f = "shareElement";
  static final String g = "flash_url";
  static final String h = "callback";
  static final String i = "keepShareUrl";
  static final String j = "share_type";
  static final String k = "toUin";
  static final String l = "uinType";
  static final String m = "appid";
  static final String n = "back";
  static final String o = "report";
  static final String p = "sourceName";
  private static final String q = "100497308";
  private static final String r = "8498609f25f65295491a1d866e4f0258";
  private static final String s = "https://y.qq.com/i/song.html?";
  private static final String t = "https://open.music.qq.com/fcgi-bin/fcg_music_get_playurl.fcg?";
  
  public static String a(long paramLong)
  {
    String str1 = null;
    String str3 = String.valueOf(paramLong) + "&appshare=android_qq";
    String str4 = SessionManager.a().a().e();
    if (str4.contains("(1rpl)")) {
      str1 = str4.replace("(1rpl)", str3);
    }
    String str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.contains("(2rpl)")) {
        str2 = str1.replace("(2rpl)", "");
      }
    }
    if ((str2 != null) && (str2.contains("(3rpl)"))) {
      return str2.replace("(3rpl)", MusicUtil.e(QQMusicHelper.a() + ""));
    }
    return str4.replace("(1rpl)", str3);
  }
  
  public static String a(long paramLong, String paramString)
  {
    return "i.y.qq.com/v8/playsong.html?songmid=" + paramString;
  }
  
  private static String a(SongInfo paramSongInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("redirect=0&");
    localStringBuilder.append("song_id=");
    localStringBuilder.append(paramSongInfo.a + "&");
    localStringBuilder.append("filetype=mp3&");
    localStringBuilder.append("qqmusic_fromtag=50&");
    localStringBuilder.append("app_id=100497308&");
    localStringBuilder.append("app_key=8498609f25f65295491a1d866e4f0258&");
    localStringBuilder.append("device_id=" + MusicUtil.b(BaseApplicationImpl.getContext()));
    return UtilForFromTag.a("https://open.music.qq.com/fcgi-bin/fcg_music_get_playurl.fcg?" + localStringBuilder.toString(), 50);
  }
  
  public static void a(SongInfo paramSongInfo, Activity paramActivity, AppInterface paramAppInterface)
  {
    if ((paramSongInfo == null) || (paramActivity == null) || (paramAppInterface == null)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("share_type", 0);
      localJSONObject.put("share_url", b(paramSongInfo));
      localJSONObject.put("title", paramSongInfo.b);
      localJSONObject.put("desc", paramSongInfo.g);
      String str2 = AlbumImageLoader.a().a(paramSongInfo);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://imgcache.qq.com/music/common/upload/PUBLIC/20140616160706.jpg";
      }
      localJSONObject.put("image_url", str1);
      localJSONObject.put("shareElement", "audio");
      localJSONObject.put("flash_url", a(paramSongInfo));
      localJSONObject.put("appid", "100497308");
      MLog.b("liwei", "param.toString() : " + localJSONObject.toString());
      a(localJSONObject.toString(), paramActivity, paramAppInterface);
      return;
    }
    catch (JSONException paramSongInfo)
    {
      paramSongInfo.printStackTrace();
    }
  }
  
  private static void a(String paramString, Activity paramActivity, AppInterface paramAppInterface)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    do
    {
      do
      {
        return;
        try
        {
          paramString = new JSONObject(paramString);
          str1 = paramString.optString("share_type", "0");
          str2 = paramString.getString("title");
          str3 = paramString.getString("desc");
          str4 = paramString.getString("share_url");
          str5 = paramString.optString("image_url");
          str6 = paramString.optString("shareElement");
          str7 = paramString.optString("flash_url");
          paramString.optString("callback");
          boolean bool = paramString.optBoolean("keepShareUrl", false);
          HashMap localHashMap = new HashMap();
          if ((!bool) && (str4 != null) && (str4.length() > 180)) {
            localHashMap.put("share_url", str4);
          }
          if ((str5 != null) && (str5.length() > 30) && (!"2".equals(str1)) && (!"3".equals(str1))) {
            localHashMap.put("image_url", str5);
          }
          if ((str7 != null) && (str7.length() > 30)) {
            localHashMap.put("flash_url", str7);
          }
          if (localHashMap.isEmpty()) {
            break;
          }
          ThreadManager.a(new hdc(localHashMap, str4, str5, str7, paramAppInterface, paramActivity, str1, paramString, str2, str3, str6));
          return;
        }
        catch (JSONException paramString) {}
      } while (!QLog.isColorLevel());
      QLog.d("liwei", 2, "shareMsg error: " + paramString.toString());
      return;
    } while (("1".equals(str1)) || ("2".equals(str1)) || ("3".equals(str1)));
    b(paramString, str1, str2, str3, str4, str5, str6, str7, paramActivity, paramAppInterface);
  }
  
  public static String b(long paramLong)
  {
    String str1 = null;
    String str3 = String.valueOf(paramLong);
    String str4 = SessionManager.a().a().e();
    if (str4.contains("(1rpl)")) {
      str1 = str4.replace("(1rpl)", str3);
    }
    String str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (str1.contains("(2rpl)")) {
        str2 = str1.replace("(2rpl)", "");
      }
    }
    if ((str2 != null) && (str2.contains("(3rpl)"))) {
      return str2.replace("(3rpl)", MusicUtil.e(QQMusicHelper.a() + ""));
    }
    return str4.replace("(1rpl)", str3);
  }
  
  private static String b(SongInfo paramSongInfo)
  {
    Session localSession = SessionManager.a().a();
    String str = "https://y.qq.com/i/song.html?";
    if (localSession != null) {
      str = a(paramSongInfo.a);
    }
    paramSongInfo = new StringBuilder();
    paramSongInfo.append("&source=qq");
    return str + paramSongInfo.toString();
  }
  
  private static void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, Activity paramActivity, AppInterface paramAppInterface)
  {
    Intent localIntent = new Intent("com.tencent.intent.QQ_FORWARD");
    paramString1 = paramJSONObject.optString("toUin");
    int i1 = paramJSONObject.optInt("uinType", 0);
    if ((paramString1 != null) && (paramString1.length() >= 5))
    {
      localIntent.setClass(paramActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString1);
      localIntent.putExtra("uinType", i1);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString2);
      localIntent.putExtra("desc", paramString3);
      localIntent.putExtra("detail_url", paramString4);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.minihd.qq");
      localIntent.putExtra("image_url_remote", paramString5);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131363662, new Object[] { paramString2 }));
      if (!"audio".equals(paramString6)) {
        break label357;
      }
      i1 = 2;
      localIntent.putExtra("audio_url", paramString7);
    }
    for (;;)
    {
      localIntent.putExtra("req_type", i1);
      if (paramJSONObject.has("report")) {
        localIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getProcessName());
      localIntent.putExtra("k_back", paramJSONObject.optBoolean("back", false));
      long l1 = paramJSONObject.optLong("appid", 0L);
      if (l1 <= 0L) {
        break label400;
      }
      if (paramAppInterface != null)
      {
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l1));
        Share.a(paramAppInterface, paramActivity, paramAppInterface.getAccount(), l1, 3000L, new hde(localIntent, paramActivity));
      }
      return;
      localIntent.setClass(paramActivity, ForwardRecentActivity.class);
      break;
      label357:
      int i2 = paramJSONObject.optInt("req_type", 1);
      i1 = i2;
      if (i2 == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        i1 = i2;
      }
    }
    label400:
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = paramAppInterface.a(paramAppInterface.getAccount()).createEntityManager();
        paramString3 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        if (paramString3 == null) {
          break label670;
        }
      }
      label670:
      for (paramString3 = paramString3.name;; paramString3 = null)
      {
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          paramString2 = paramString3;
          if (paramJSONObject.has("sourceName")) {
            paramString2 = paramJSONObject.optString("sourceName");
          }
        }
        paramJSONObject = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramJSONObject = paramString1;
        }
        paramString2 = String.format("mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
        paramString1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
        localIntent.putExtra("struct_share_key_source_action", "plugin");
        localIntent.putExtra("struct_share_key_source_a_action_data", paramString2);
        localIntent.putExtra("struct_share_key_source_i_action_data", paramString1);
        localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
        localIntent.putExtra("app_name", paramJSONObject);
        for (;;)
        {
          paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
          if (paramJSONObject != null) {
            break label638;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("liwei", 2, "build struct msg fail");
          return;
          localIntent.putExtra("app_name", paramActivity.getString(2131363661));
        }
        label638:
        localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
        localIntent.putExtra("display_like_dialog", true);
        paramActivity.startActivityForResult(localIntent, 1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.share.ShareHelper
 * JD-Core Version:    0.7.0.1
 */