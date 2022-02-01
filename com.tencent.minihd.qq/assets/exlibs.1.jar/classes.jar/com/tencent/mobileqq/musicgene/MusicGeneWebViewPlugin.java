package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import jhe;
import jhf;
import jhg;
import jhh;
import jhi;
import jhj;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicGeneWebViewPlugin
  extends WebViewPlugin
{
  private static final String A = "uin";
  private static final String B = "geneId";
  private static final String C = "index";
  private static final String D = "state";
  private static final String E = "code";
  private static final String F = "playUrl";
  private static final String G = "songPage";
  private static final String H = "songId";
  private static final String I = "songName";
  private static final String J = "singerName";
  private static final String K = "albumName";
  private static final String L = "albumImg";
  private static final String M = "curTime";
  private static final String N = "totalTime";
  private static final String O = "type";
  private static final String P = "volume";
  private static final String Q = "imgUrl";
  private static final String R = "title";
  private static final String S = "desc";
  private static final String T = "src";
  private static final String U = "audioUrl";
  private static final String V = "appid";
  private static final String W = "iconUrl";
  private static final String X = "geneType";
  private static final String Y = "pageUrl";
  private static final String Z = "101";
  public static final long a = 1101244924L;
  public static final String a = "2ua27x0nPOgcDHFM";
  private static final String aa = "0";
  private static final String ab = "1";
  private static final String ac = "qqmusic";
  private static final String ad = "webCallApp";
  private static final String ae = "bindApp";
  private static final String af = "unbindApp";
  private static final String ag = "SONG_PLAY";
  private static final String ah = "SONG_PAUSE";
  private static final String ai = "SONG_RESUME";
  private static final String aj = "SONG_STOP";
  private static final String ak = "SONG_PLAY_NEXT";
  private static final String al = "SONG_PLAY_PREV";
  private static final String am = "SONG_GET_SONG_INFO";
  private static final String an = "SONG_GET_LIST_INFO";
  private static final String ao = "SONG_SET_PLAYMODE";
  private static final String ap = "SONG_SET_VOLUME";
  private static final String aq = "SONG_GET_VOLUME";
  private static final String ar = "DO_MACK_IMG";
  private static final String as = "SHARE_SONG";
  private static final String at = "SHARE_GENE";
  private static final String au = "MANUAL_INIT";
  private static final String av = "CALLPAGE_SONG_STATE_CHANGE";
  private static final String aw = "CALLPAGE_SONG_TIME_UPDATE";
  private static final String ax = "DO_MACK_IMG_CALLBACK";
  private static final String ay = "CALLPAGE_SHARE";
  private static final long jdField_b_of_type_Long = 1000L;
  public static final String b = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
  public static final String c = "https://y.qq.com/m/recent_listen/play.html?uin=%s&_bid=266&_wv=14115";
  public static final String d = "https://y.qq.com/m/gene/play.html";
  public static final String e = "BROAD_CAST_SHARE_MUSIC_GENE";
  public static final String f = "BROAD_CAST_SHARE_SONG";
  public static final String g = "BROAD_CAST_CALL_PAGE_SHARE";
  public static final String h = "BROAD_CAST_UPDATE_TITLE";
  public static final String i = "BUNDLE_KEY_TITLE";
  public static final String j = "BUNDLE_KEY_DESC";
  public static final String k = "BUDNLE_KEY_IMG_URL";
  public static final String l = "BUNDLE_KEY_SRC";
  public static final String m = "BUNDLE_KEY_AUDIO_URL";
  public static final String n = "BUNDKE_KEY_APP_ID";
  public static final String o = "BUNDLE_KEY_ICON_URL";
  public static final String p = "BUNDLE_KEY_UIN";
  public static final String q = "BUNDLE_KEY_GENE_ID";
  public static final String r = "BUDNLE_KEY_IS_MY_PROFILE";
  public static final String s = "BUNDLE_KEY_URL";
  public static final String t = "BUNDLE_KEY_FROM_PLAY_BAR";
  public static final String u = "BUNDLE_KEY_JSONARRAY_SONG_LIST";
  private static final String v = MusicGeneWebViewPlugin.class.getSimpleName();
  private static final String w = "BUNDLE_KEY_FILE_PATH";
  private static final String x = "action";
  private static final String y = "data";
  private static final String z = "list";
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jhg(this);
  private Context jdField_a_of_type_AndroidContentContext = null;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new jhe(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new jhh(this, Looper.getMainLooper());
  private IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new jhf(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService = null;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener = null;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  private int a()
  {
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)) {}
    try
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
      return this.jdField_a_of_type_Int;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 103;
    case 0: 
      return 102;
    }
    return 101;
  }
  
  private Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private SongInfo a()
  {
    SongInfo localSongInfo2 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {
        localSongInfo1 = localSongInfo2;
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a() != null) {
        localSongInfo1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      }
      return localSongInfo1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return localSongInfo2;
  }
  
  private HashMap a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i1 = 0;
    try
    {
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i1 += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSongInfo != null)
    {
      localJSONObject.put("songPage", paramSongInfo.e);
      localJSONObject.put("playUrl", paramSongInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("songId", paramSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songName", paramSongInfo.b);
      localJSONObject.put("singerName", paramSongInfo.g);
      localJSONObject.put("albumName", paramSongInfo.f);
      localJSONObject.put("albumImg", paramSongInfo.d);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    jhj localjhj = new jhj(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localjhj, 1000L, 1000L);
  }
  
  private void a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = Base64Util.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = "data:image\\/jpg;base64," + paramBitmap;
      paramBitmap = new JSONObject();
    }
    try
    {
      paramBitmap.put("code", "0");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imgUrl", localObject);
      paramBitmap.put("data", localJSONObject);
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 7
    //   8: istore 6
    //   10: aload_0
    //   11: getfield 267	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   14: ifeq +216 -> 230
    //   17: aload_0
    //   18: invokespecial 486	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   21: astore 8
    //   23: aload_0
    //   24: getfield 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   27: ifnull +280 -> 307
    //   30: aload_0
    //   31: getfield 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   34: invokeinterface 488 1 0
    //   39: istore_1
    //   40: aload_0
    //   41: invokespecial 490	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
    //   44: istore_3
    //   45: aload 8
    //   47: astore 9
    //   49: iload_1
    //   50: istore 4
    //   52: aload_0
    //   53: getfield 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   56: ifnull +244 -> 300
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   64: invokeinterface 491 1 0
    //   69: invokespecial 493	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   72: istore_1
    //   73: aload_0
    //   74: getfield 269	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   77: invokeinterface 496 1 0
    //   82: astore 8
    //   84: iload_1
    //   85: istore_2
    //   86: aload 8
    //   88: ifnull +180 -> 268
    //   91: aload 8
    //   93: ldc 213
    //   95: invokevirtual 502	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   98: istore 5
    //   100: iload_1
    //   101: istore_2
    //   102: iload 5
    //   104: istore_1
    //   105: iload 7
    //   107: istore 6
    //   109: aload 9
    //   111: ifnull +119 -> 230
    //   114: aload 10
    //   116: astore 8
    //   118: aload_0
    //   119: aload 9
    //   121: invokespecial 504	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   124: astore 9
    //   126: aload 9
    //   128: astore 8
    //   130: aload 9
    //   132: ldc 44
    //   134: iload 4
    //   136: sipush 1000
    //   139: idiv
    //   140: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 9
    //   146: astore 8
    //   148: aload 9
    //   150: ldc 47
    //   152: iload_3
    //   153: sipush 1000
    //   156: idiv
    //   157: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 9
    //   163: astore 8
    //   165: aload 9
    //   167: ldc 11
    //   169: iload_1
    //   170: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 9
    //   176: astore 8
    //   178: aload 9
    //   180: ldc 17
    //   182: iload_2
    //   183: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload 9
    //   189: astore 8
    //   191: iload 7
    //   193: istore 6
    //   195: aload 8
    //   197: ifnull +33 -> 230
    //   200: aload_0
    //   201: ldc_w 509
    //   204: iconst_2
    //   205: anewarray 470	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: ldc 157
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload 8
    //   217: invokevirtual 510	org/json/JSONObject:toString	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 476	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   224: invokevirtual 479	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:callJs	(Ljava/lang/String;)V
    //   227: iconst_1
    //   228: istore 6
    //   230: iload 6
    //   232: ireturn
    //   233: astore 9
    //   235: aconst_null
    //   236: astore 8
    //   238: iconst_0
    //   239: istore_1
    //   240: aload 9
    //   242: invokevirtual 322	android/os/RemoteException:printStackTrace	()V
    //   245: iconst_0
    //   246: istore_3
    //   247: iload_1
    //   248: istore 4
    //   250: aload 8
    //   252: astore 9
    //   254: goto -202 -> 52
    //   257: astore 8
    //   259: iconst_0
    //   260: istore_1
    //   261: aload 8
    //   263: invokevirtual 322	android/os/RemoteException:printStackTrace	()V
    //   266: iload_1
    //   267: istore_2
    //   268: iconst_0
    //   269: istore_1
    //   270: goto -165 -> 105
    //   273: astore 9
    //   275: aload 9
    //   277: invokevirtual 397	org/json/JSONException:printStackTrace	()V
    //   280: goto -89 -> 191
    //   283: astore 8
    //   285: goto -24 -> 261
    //   288: astore 9
    //   290: iconst_0
    //   291: istore_1
    //   292: goto -52 -> 240
    //   295: astore 9
    //   297: goto -57 -> 240
    //   300: iconst_0
    //   301: istore_2
    //   302: iconst_0
    //   303: istore_1
    //   304: goto -199 -> 105
    //   307: iconst_0
    //   308: istore_1
    //   309: goto -269 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	MusicGeneWebViewPlugin
    //   39	270	1	i1	int
    //   85	217	2	i2	int
    //   44	203	3	i3	int
    //   50	199	4	i4	int
    //   98	5	5	i5	int
    //   8	223	6	bool1	boolean
    //   4	188	7	bool2	boolean
    //   21	230	8	localObject1	Object
    //   257	5	8	localRemoteException1	RemoteException
    //   283	1	8	localRemoteException2	RemoteException
    //   47	141	9	localObject2	Object
    //   233	8	9	localRemoteException3	RemoteException
    //   252	1	9	localObject3	Object
    //   273	3	9	localJSONException	JSONException
    //   288	1	9	localRemoteException4	RemoteException
    //   295	1	9	localRemoteException5	RemoteException
    //   1	114	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	233	android/os/RemoteException
    //   59	73	257	android/os/RemoteException
    //   118	126	273	org/json/JSONException
    //   130	144	273	org/json/JSONException
    //   148	161	273	org/json/JSONException
    //   165	174	273	org/json/JSONException
    //   178	187	273	org/json/JSONException
    //   73	84	283	android/os/RemoteException
    //   91	100	283	android/os/RemoteException
    //   23	40	288	android/os/RemoteException
    //   40	45	295	android/os/RemoteException
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      i1 = ((IQQPlayerService)localObject).e();
      paramInt = b(paramInt);
      localObject = new JSONObject();
    }
    catch (RemoteException localRemoteException)
    {
      try
      {
        ((JSONObject)localObject).put("state", paramInt);
        ((JSONObject)localObject).put("index", i1);
        if (!b()) {
          ((JSONObject)localObject).put("code", "101");
        }
        bool1 = bool2;
        if (localObject != null)
        {
          callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", ((JSONObject)localObject).toString() }));
          bool1 = true;
        }
        return bool1;
        localRemoteException = localRemoteException;
        localRemoteException.printStackTrace();
        int i1 = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = localUri.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")))
        {
          bool1 = bool2;
          if (!paramString.contains("imgcache.gtimg.cn")) {
            return bool1;
          }
        }
      }
      else
      {
        QLog.e(v, 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString: " + paramString + " is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e(v, 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!paramJSONObject.has("list")) {
      return null;
    }
    paramJSONObject = paramJSONObject.getJSONArray("list");
    SongInfo[] arrayOfSongInfo = new SongInfo[paramJSONObject.length()];
    int i1 = 0;
    while (i1 < paramJSONObject.length())
    {
      Object localObject = (JSONObject)paramJSONObject.get(i1);
      if (localObject != null)
      {
        String str1 = ((JSONObject)localObject).getString("playUrl");
        String str2 = ((JSONObject)localObject).getString("songPage");
        String str3 = ((JSONObject)localObject).getString("songId");
        String str4 = ((JSONObject)localObject).getString("songName");
        String str5 = ((JSONObject)localObject).getString("singerName");
        String str6 = ((JSONObject)localObject).getString("albumName");
        localObject = ((JSONObject)localObject).getString("albumImg");
        SongInfo localSongInfo = new SongInfo();
        localSongInfo.b = str4;
        localSongInfo.jdField_a_of_type_JavaLangString = str1;
        localSongInfo.c = str6;
        localSongInfo.d = ((String)localObject);
        localSongInfo.e = str2;
        localSongInfo.jdField_a_of_type_Long = Long.parseLong(str3);
        localSongInfo.f = str6;
        localSongInfo.g = str5;
        arrayOfSongInfo[i1] = localSongInfo;
      }
      i1 += 1;
    }
    return arrayOfSongInfo;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 4;
    case 3: 
      return 2;
    }
    return -1001;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(3, v);
      String str3 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(6, "");
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1)) {
        if (!str1.equals(str2))
        {
          boolean bool3 = str1.equals(str3);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private void d()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null)
        {
          if (localActivity.getApplicationContext() != null) {
            localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
          }
          QLog.e(v, 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
          return;
        }
        QLog.e(v, 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e(v, 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
      return;
    }
    QLog.e(v, 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.music.data.permission22");
    }
    return super.handleEvent(paramString, paramInt, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = new ArrayList(Arrays.asList(paramVarArgs));
    if ("qqmusic".equals(paramString2)) {
      if ("webCallApp".equals(paramString3)) {
        paramString1 = (String)((ArrayList)localObject).get(0);
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString1);
        if (!paramString2.has("action")) {
          continue;
        }
        paramString1 = paramString2.getString("action");
        if (!paramString2.has("data")) {
          continue;
        }
        paramString2 = paramString2.getJSONObject("data");
        boolean bool = "MANUAL_INIT".equals(paramString1);
        if (bool) {
          try
          {
            QLog.e(v, 1, "MusicGeneWebViewPlugin.handle js request: MANUAL_INIT");
            if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener = paramJsBridgeListener;
              d();
            }
            else
            {
              paramString1 = new JSONObject();
              paramString1.put("code", "0");
              paramJsBridgeListener.a(paramString1);
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            QLog.e(v, 1, "MusicGeneWebViewPlugin.handle js request get exception in ACTION_MANUAL_INIT", paramJsBridgeListener);
          }
        }
        paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
        if (paramVarArgs == null) {
          return false;
        }
        if ("SONG_PLAY".equals(paramString1))
        {
          paramString1 = "1";
          if (MusicPreferences.a().e() == 1)
          {
            MusicPreferences.a().e(0);
            try
            {
              paramVarArgs.a(this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub);
              paramString1 = "0";
            }
            catch (RemoteException paramString1)
            {
              paramString1.printStackTrace();
              paramString1 = "0";
              continue;
            }
            paramString2 = new JSONObject();
            paramString2.put("code", paramString1);
            paramJsBridgeListener.a(paramString2);
            continue;
          }
          localObject = a(paramString2);
          if (localObject == null) {
            continue;
          }
          if (!paramString2.has("index")) {
            continue;
          }
          i1 = paramString2.getInt("index");
          if (!paramString2.has("geneId")) {
            continue;
          }
          i2 = paramString2.getInt("geneId");
          if (!paramString2.has("uin")) {
            continue;
          }
          l1 = paramString2.getLong("uin");
          if (paramString2.has("geneType")) {
            paramString2.getString("geneType");
          }
          if (!paramString2.has("list")) {
            continue;
          }
          paramString3 = paramString2.getJSONArray("list");
          str1 = String.valueOf(l1);
          paramString1 = "";
          if (paramString2.has("pageUrl")) {
            paramString1 = paramString2.getString("pageUrl");
          }
          paramString2 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramString2 = String.format("https://y.qq.com/m/recent_listen/play.html?uin=%s&_bid=266&_wv=14115", new Object[] { str1 });
          }
          paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicGeneQQBrowserActivity.class);
          paramString1.putExtra("uin", str1);
          paramString1.putExtra("url", paramString2);
          paramString1.putExtra("BUNDLE_KEY_FROM_PLAY_BAR", true);
          paramString2 = new Bundle();
          paramString2.putLong("BUNDLE_KEY_UIN", l1);
          paramString2.putInt("BUNDLE_KEY_GENE_ID", i2);
          if (paramString3 != null) {
            paramString2.putString("BUNDLE_KEY_JSONARRAY_SONG_LIST", paramString3.toString());
          }
          try
          {
            paramVarArgs.a(paramString2);
            paramVarArgs.a(this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub);
            paramVarArgs.a(paramString1);
            paramVarArgs.a(103);
            paramVarArgs.a(paramVarArgs.a(3, v), (SongInfo[])localObject, i1);
            paramString1 = "0";
          }
          catch (RemoteException paramString1)
          {
            paramString1.printStackTrace();
            continue;
          }
        }
        if ("SONG_PAUSE".equals(paramString1))
        {
          this.jdField_b_of_type_Int = paramVarArgs.d();
          if (MusicPreferences.a().d() == 1)
          {
            paramString1 = new JSONObject();
            paramString1.put("code", "0");
            paramJsBridgeListener.a(paramString1);
            MusicPreferences.a().d(0);
            continue;
          }
          paramVarArgs.a();
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          continue;
        }
        if ("SONG_RESUME".equals(paramString1))
        {
          paramVarArgs.b();
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          continue;
        }
        if ("SONG_STOP".equals(paramString1))
        {
          paramVarArgs.c();
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          continue;
        }
        if ("SONG_PLAY_NEXT".equals(paramString1))
        {
          paramVarArgs.d();
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          continue;
        }
        if ("SONG_PLAY_PREV".equals(paramString1))
        {
          paramVarArgs.e();
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          continue;
        }
        if ("SONG_GET_SONG_INFO".equals(paramString1))
        {
          paramString3 = a();
          paramString1 = null;
          if (paramString3 != null)
          {
            paramString2 = paramVarArgs.a();
            if (paramString2 != null) {
              paramString1 = (JSONObject)a(new JSONArray(paramString2.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"))).get(String.valueOf(paramString3.jdField_a_of_type_Long));
            }
            paramString2 = paramString1;
            if (paramString1 == null) {
              paramString2 = a(paramString3);
            }
            paramString1 = paramString2;
            if (paramString2 == null) {
              paramString1 = new JSONObject();
            }
            long l2 = a();
            i1 = paramVarArgs.a();
            i2 = b(i1);
            if (i1 == 3)
            {
              l1 = this.jdField_b_of_type_Int;
              if (b())
              {
                paramString1.put("code", "0");
                paramString1.put("curTime", l1 / 1000L);
                paramString1.put("totalTime", l2 / 1000L);
                paramString1.put("state", i2);
                paramJsBridgeListener.a(paramString1);
                continue;
              }
            }
            else
            {
              l1 = paramVarArgs.d();
              continue;
            }
            paramString1.put("code", "101");
            continue;
          }
          paramString1 = new JSONObject();
          paramString1.put("code", "1");
          continue;
        }
        if (!"SONG_GET_LIST_INFO".equals(paramString1)) {
          continue;
        }
        paramString2 = new JSONObject();
        paramString1 = paramVarArgs.a();
        paramVarArgs.a(3, v);
        paramVarArgs.a(6, "");
        if (paramString1 == null) {
          continue;
        }
        paramString1 = paramVarArgs.a();
        if (paramString1 == null) {
          continue;
        }
        i4 = paramString1.getInt("BUNDLE_KEY_GENE_ID");
        l1 = paramString1.getLong("BUNDLE_KEY_UIN");
        paramString1 = new JSONArray(paramString1.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"));
        i5 = 0;
        i3 = 0;
        i1 = 0;
        i2 = 0;
        if (paramString1 != null) {
          continue;
        }
        paramString1 = new JSONArray();
        paramString3 = paramVarArgs.a();
        localObject = a();
        i3 = i1;
        if (paramString3 == null) {
          continue;
        }
        i1 = 0;
      }
      catch (JSONException paramJsBridgeListener)
      {
        long l1;
        String str1;
        int i4;
        int i5;
        float f1;
        float f2;
        String str2;
        return true;
      }
      catch (RemoteException paramJsBridgeListener)
      {
        continue;
      }
      catch (Exception paramJsBridgeListener)
      {
        int i1;
        int i3;
        continue;
        i1 += 1;
        int i2 = i3;
        continue;
        continue;
        i1 += 1;
        i2 = i3;
        continue;
      }
      i3 = i2;
      if (i1 >= paramString3.length) {
        continue;
      }
      str1 = paramString3[i1];
      i3 = i2;
      if (str1 == null) {
        continue;
      }
      paramString1.put(i1, a(str1));
      i3 = i2;
      if (localObject == null) {
        continue;
      }
      i3 = i2;
      if (str1.jdField_a_of_type_Long != ((SongInfo)localObject).jdField_a_of_type_Long) {
        continue;
      }
      i3 = i1;
      continue;
      paramString2.put("code", "0");
      paramString2.put("index", i3);
      paramString2.put("state", b(paramVarArgs.a()));
      paramString2.put("geneId", i4);
      paramString2.put("uin", l1);
      paramString2.put("list", paramString1);
      paramJsBridgeListener.a(paramString2);
      continue;
      paramString3 = paramVarArgs.a();
      localObject = a();
      if (paramString3 != null)
      {
        i1 = 0;
        i2 = i5;
        i3 = i2;
        if (i1 < paramString3.length)
        {
          str1 = paramString3[i1];
          i3 = i2;
          if (str1 == null) {
            continue;
          }
          i3 = i2;
          if (str1.jdField_a_of_type_Long != ((SongInfo)localObject).jdField_a_of_type_Long) {
            continue;
          }
          i3 = i1;
          continue;
          paramString2.put("code", "1");
          continue;
          if ("SONG_SET_PLAYMODE".equals(paramString1))
          {
            paramVarArgs.a(a(paramString2.getInt("type")));
            paramString1 = new JSONObject();
            paramString1.put("code", "0");
            paramJsBridgeListener.a(paramString1);
            continue;
          }
          if ("SONG_SET_VOLUME".equals(paramString1))
          {
            i1 = paramString2.getInt("volume");
            paramString2 = new JSONObject();
            paramString1 = this.jdField_a_of_type_AndroidContentContext;
            if ((paramString1 != null) && (i1 >= 0) && (i1 <= 100))
            {
              paramString1 = (AudioManager)paramString1.getSystemService("audio");
              if (paramString1 != null)
              {
                paramString1.setStreamVolume(3, paramString1.getStreamMaxVolume(3) * i1 / 100, 4);
                paramString1 = "0";
                paramString2.put("code", paramString1);
                paramJsBridgeListener.a(paramString2);
                continue;
              }
            }
          }
          else
          {
            if ("DO_MACK_IMG".equals(paramString1))
            {
              paramString1 = paramString2.getString("imgUrl");
              paramString2 = MD5.toMD5(paramString1);
              paramString2 = new File(new File(AppConstants.aG + File.separator + "diskcache"), paramString2);
              if ((paramString2 == null) || (!paramString2.exists()))
              {
                ThreadManager.a(new jhi(this, paramString1, paramString2));
                paramString1 = new JSONObject();
                paramString1.put("code", "0");
                paramJsBridgeListener.a(paramString1);
                continue;
              }
              a(BitmapFactory.decodeFile(paramString2.getPath()));
              continue;
            }
            if ("SONG_GET_VOLUME".equals(paramString1))
            {
              paramString1 = this.jdField_a_of_type_AndroidContentContext;
              paramString2 = new JSONObject();
              if (paramString1 != null)
              {
                paramString1 = (AudioManager)paramString1.getSystemService("audio");
                if (paramString1 != null)
                {
                  f1 = paramString1.getStreamMaxVolume(3);
                  f2 = paramString1.getStreamVolume(3);
                  i1 = (int)f2;
                  if (f1 > 0.0F) {
                    i1 = (int)(f2 / f1 * 100.0F);
                  }
                  paramString2.put("volume", i1);
                  paramString1 = "0";
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                  continue;
                }
              }
            }
            else
            {
              if ("SHARE_SONG".equals(paramString1))
              {
                paramString3 = paramString2.getString("title");
                paramVarArgs = paramString2.getString("desc");
                localObject = paramString2.getString("imgUrl");
                str1 = paramString2.getString("src");
                str2 = paramString2.getString("audioUrl");
                paramString1 = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                if (paramString2.has("iconUrl")) {
                  paramString1 = paramString2.getString("iconUrl");
                }
                if (this.jdField_a_of_type_AndroidContentContext != null)
                {
                  paramString2 = new Intent("BROAD_CAST_SHARE_SONG");
                  paramString2.putExtra("BUNDLE_KEY_TITLE", paramString3);
                  paramString2.putExtra("BUNDLE_KEY_DESC", paramVarArgs);
                  paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject);
                  paramString2.putExtra("BUNDLE_KEY_SRC", str1);
                  paramString2.putExtra("BUNDLE_KEY_AUDIO_URL", str2);
                  paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString1);
                  this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString2, "com.tencent.music.data.permission22");
                }
                paramString1 = new JSONObject();
                paramString1.put("code", "0");
                paramJsBridgeListener.a(paramString1);
                continue;
              }
              if (!"SHARE_GENE".equals(paramString1)) {
                continue;
              }
              paramString3 = paramString2.getString("title");
              paramVarArgs = paramString2.getString("desc");
              localObject = paramString2.getString("imgUrl");
              str1 = paramString2.getString("src");
              if (paramString2.has("appid"))
              {
                l1 = paramString2.getLong("appid");
                paramString1 = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                if (paramString2.has("iconUrl")) {
                  paramString1 = paramString2.getString("iconUrl");
                }
                if (this.jdField_a_of_type_AndroidContentContext != null)
                {
                  paramString2 = new Intent("BROAD_CAST_SHARE_MUSIC_GENE");
                  paramString2.putExtra("BUNDLE_KEY_TITLE", paramString3);
                  paramString2.putExtra("BUNDLE_KEY_DESC", paramVarArgs);
                  paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject);
                  paramString2.putExtra("BUNDLE_KEY_SRC", str1);
                  paramString2.putExtra("BUNDKE_KEY_APP_ID", l1);
                  paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString1);
                  this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString2, "com.tencent.music.data.permission22");
                }
                paramString1 = new JSONObject();
                paramString1.put("code", "0");
                paramJsBridgeListener.a(paramString1);
                continue;
                if ("bindApp".equals(paramString3)) {
                  paramString1 = (String)((ArrayList)localObject).get(0);
                }
              }
            }
          }
        }
      }
      try
      {
        paramString2 = new JSONObject(paramString1);
        paramString1 = null;
        if (paramString2.has("action")) {
          paramString1 = paramString2.getString("action");
        }
        if ("CALLPAGE_SONG_STATE_CHANGE".equals(paramString1))
        {
          this.jdField_a_of_type_Boolean = true;
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          a();
        }
        else if ("CALLPAGE_SONG_TIME_UPDATE".equals(paramString1))
        {
          this.jdField_b_of_type_Boolean = true;
          paramString1 = new JSONObject();
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        continue;
      }
      if (!"unbindApp".equals(paramString3)) {
        continue;
      }
      continue;
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      l1 = 1101244924L;
      continue;
      paramString1 = "1";
      continue;
      paramString1 = "1";
      continue;
      continue;
      i4 = 0;
      paramString1 = null;
      l1 = 0L;
      continue;
      paramString3 = null;
      continue;
      l1 = 0L;
      continue;
      i2 = 0;
      continue;
      i1 = 0;
      continue;
      paramString2 = null;
    }
    return true;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) && (a(paramString1))) {
        d();
      }
      return super.handleSchemaRequest(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(v, 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
      }
    }
  }
  
  public void onCreate()
  {
    for (;;)
    {
      try
      {
        localObject2 = this.mRuntime.a();
        if (localObject2 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentContext = ((Activity)localObject2).getApplicationContext();
        localObject1 = this.mRuntime.a();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((CustomWebView)localObject1).getUrl();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!(localObject2 instanceof QQBrowserActivity))) {
          continue;
        }
        localObject1 = ((QQBrowserActivity)localObject2).M;
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1;
        QLog.e(v, 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
        continue;
      }
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        if (a((String)localObject1))
        {
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.class);
          this.jdField_a_of_type_AndroidContentContext.bindService((Intent)localObject2, this.jdField_a_of_type_AndroidContentServiceConnection, 33);
        }
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("BROAD_CAST_CALL_PAGE_SHARE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject2);
      }
      QLog.e(v, 1, "MusicGeneWebViewPlugin.onCreate urlString: " + (String)localObject1);
      super.onCreate();
      return;
      localObject1 = "";
    }
  }
  
  protected void onDestroy()
  {
    for (;;)
    {
      try
      {
        b();
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
          if (localObject == null) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i1;
        QLog.e(v, 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
        this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        continue;
      }
      try
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        if (i1 != 2)
        {
          if (i1 == 3) {}
          try
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
            String str = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(6, "");
            if ((localObject == null) || (!((String)localObject).equals(str))) {
              this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
            }
          }
          catch (RemoteException localRemoteException2)
          {
            localRemoteException2.printStackTrace();
            continue;
          }
          a(4);
          this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentContext.stopService(new Intent(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.class));
          this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentContext = null;
          this.jdField_a_of_type_ComTencentMobileqqWebviewpluginJsBridgeListener = null;
          super.onDestroy();
          return;
        }
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
        i1 = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */