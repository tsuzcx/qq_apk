package cooperation.qzone.music;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.NetworkStateForConfig;
import com.tencent.common.config.provider.NetworkStateForConfig.ApnNode;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import mcb;
import mcc;
import mcd;
import mce;
import mcf;
import mcg;
import mch;
import mci;
import mcj;
import mck;
import mcl;
import mcm;
import mcn;
import mco;
import mcp;
import mcr;
import mcs;
import mct;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneWebMusicJsPlugin
  extends WebViewPlugin
  implements RemoteMusicManager.MusicEventListener
{
  public static final String EVENT_BUFFERING = "buffering";
  public static final String EVENT_BUTTON_CLICK = "buttonclick";
  public static final String EVENT_CANCEL = "cancel";
  public static final String EVENT_ERROR = "error";
  public static final String EVENT_FINISH = "finish";
  public static final String EVENT_GET_NETWORKE_TYPE = "networktype";
  public static final String EVENT_GET_PLAY_MODE = "playmode";
  public static final String EVENT_GET_SONGINFO = "songinfo";
  public static final String EVENT_PAUSED = "paused";
  public static final String EVENT_PLAYING = "playing";
  public static final String EVENT_STOP = "stop";
  public static final String EVENT_UNKOWN = "unknow";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
  private static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
  private static boolean mTempChecked = false;
  private String TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
  private boolean isAutoPlay = false;
  private boolean isFlowWarningVisible = false;
  private boolean isRandom = false;
  private boolean isShowing = false;
  private boolean isUseRemoteMusicManager = false;
  private boolean isWebPageListening = false;
  
  private void callNetWorkInterface(String paramString)
  {
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"networktype\",data:{type:\"isUnicomNetwork\",value:" + paramString + "}})}catch(e){}");
    }
  }
  
  private void callWebPageInterface(String paramString)
  {
    if ((this.isWebPageListening) && (!this.isDestroy)) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\"}})}catch(e){}");
    }
  }
  
  private void callWebPageInterface(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject;
    if (this.isWebPageListening) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", getCurrentHostUin());
      if (paramBundle != null)
      {
        SongInfo localSongInfo = (SongInfo)paramBundle.getParcelable("param.song");
        if (localSongInfo != null)
        {
          localJSONObject.put("name", localSongInfo.jdField_b_of_type_JavaLangString);
          localJSONObject.put("singer", localSongInfo.g);
          localJSONObject.put("songId", localSongInfo.jdField_a_of_type_Long);
          localJSONObject.put("singerId", localSongInfo.jdField_b_of_type_Long);
          localJSONObject.put("type", localSongInfo.jdField_a_of_type_Int);
          localJSONObject.put("cover", localSongInfo.d);
        }
        localJSONObject.put("state", getStateString(paramBundle.getInt("param.state", -1)));
        localJSONObject.put("total", paramBundle.getInt("param.duration"));
        localJSONObject.put("curr", paramBundle.getInt("param.currentTime"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    if (paramBundle != null) {}
    try
    {
      if (paramBundle.getInt("param.playModeRandom", 0) != 1) {
        break label302;
      }
      bool = true;
      this.isRandom = bool;
      if (paramBundle.getInt("param.playModeAuto", 0) != 1) {
        break label307;
      }
      bool = true;
      this.isAutoPlay = bool;
      localJSONObject.put("randomMode", this.isRandom);
      localJSONObject.put("autoModeWithWifi", this.isAutoPlay);
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        boolean bool;
        paramBundle.printStackTrace();
      }
    }
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\",value:" + localJSONObject.toString() + "}})}catch(e){}");
    }
  }
  
  private static SongInfo convertSongInfo(JSONObject paramJSONObject)
  {
    SongInfo localSongInfo = new SongInfo();
    try
    {
      localSongInfo.jdField_b_of_type_JavaLangString = paramJSONObject.getString("name");
      localSongInfo.g = paramJSONObject.getString("singer");
      localSongInfo.jdField_a_of_type_Long = paramJSONObject.getLong("songId");
      localSongInfo.jdField_a_of_type_JavaLangString = paramJSONObject.getString("playUrl");
      localSongInfo.jdField_a_of_type_Int = paramJSONObject.getInt("type");
      localSongInfo.d = paramJSONObject.getString("cover");
      localSongInfo.jdField_b_of_type_Long = paramJSONObject.getLong("singerId");
      localSongInfo.f = paramJSONObject.getString("album");
      return localSongInfo;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localSongInfo;
  }
  
  private void doSetPlayMode(int paramInt1, int paramInt2)
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcj(this, paramInt1, paramInt2));
  }
  
  private long getCurrentHostUin()
  {
    try
    {
      String str = Uri.parse(this.mRuntime.a().getUrl()).getQueryParameter("guestuin");
      if (str == null) {
        return this.mRuntime.a().getLongAccountUin();
      }
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "illegal guestuin");
      }
    }
    return 10000L;
  }
  
  public static boolean getIsUnicomNetWork()
  {
    Object localObject = NetworkStateForConfig.a().a();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((NetworkStateForConfig.ApnNode)localObject).a();
    } while ((localObject == null) || ((!((String)localObject).equalsIgnoreCase("UNIWAP")) && (!((String)localObject).equalsIgnoreCase("UNINET")) && (!((String)localObject).equalsIgnoreCase("3GWAP")) && (!((String)localObject).equalsIgnoreCase("3GNET")) && (!((String)localObject).equalsIgnoreCase("WONET"))));
    return true;
  }
  
  private String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow";
    case 1: 
      return "buffering";
    case 2: 
      return "playing";
    case 3: 
      return "paused";
    case 4: 
    case 6: 
      return "stop";
    }
    return "error";
  }
  
  private boolean needPlayTips()
  {
    return (NetworkUtil.c(BaseApplicationImpl.getContext())) && (!mTempChecked);
  }
  
  private boolean needSetAutoPlayTips()
  {
    return BaseApplication.getContext().getSharedPreferences("share", 0).getBoolean("qzone_bg_music_auto_play_warn_flag", true);
  }
  
  private static final void showAutoPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = DialogUtil.a(paramContext, 230, "", "打开后，wifi环境下访问自己和好友的空间将自动播放背景音乐", "取消", "知道了", paramOnClickListener2, paramOnClickListener1);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, "流量提示", "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续\n", "继续", "取消", paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void getPlayMode()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcf(this));
  }
  
  public void getPlayingSongInfo()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcd(this));
  }
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    return super.handleEvent(paramString, paramInt, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {}
    do
    {
      return false;
      if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new mcb(this, paramVarArgs), new mcm(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusic(paramVarArgs[0]);
        }
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
      {
        paramJsBridgeListener = this.mRuntime.a();
        if ((paramJsBridgeListener != null) && (needPlayTips()))
        {
          showPlayTips(paramJsBridgeListener, new mcn(this, paramVarArgs), new mco(this));
          this.isFlowWarningVisible = true;
        }
        for (;;)
        {
          return true;
          playMusicList(paramVarArgs[0]);
        }
      }
      if (paramString3.equals("resumePlay"))
      {
        resumePlay();
        return true;
      }
      if (paramString3.equals("pausePlay"))
      {
        pausePlay();
        return true;
      }
      if ((paramString3.equals("listenMusicState")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        listenMusicState(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("musicListChange"))
      {
        musicListChange();
        return true;
      }
      if ((paramString3.equals("setPlayMode")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setPlayMode(paramVarArgs[0]);
        return true;
      }
      if ((paramString3.equals("setRightButton")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        setRightButton(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("getPlayingSongInfo"))
      {
        getPlayingSongInfo();
        return true;
      }
      if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        playMusicList(paramVarArgs[0]);
        return true;
      }
      if (paramString3.equals("getPlayMode"))
      {
        getPlayMode();
        return true;
      }
    } while (!paramString3.equals("getNetworkType"));
    if (getIsUnicomNetWork()) {
      callNetWorkInterface("true");
    }
    for (;;)
    {
      return true;
      callNetWorkInterface("false");
    }
  }
  
  public void listenMusicState(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("isOpen");
      if (i == 1)
      {
        this.isWebPageListening = true;
        RemoteMusicManager.getInstance().addOnMusicEventListener(this);
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        this.isWebPageListening = false;
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void musicListChange()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcc(this));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.isWebPageListening) {
      RemoteMusicManager.getInstance().addOnMusicEventListener(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteMusicManager.getInstance().removeOnMusicEventListener(this);
    if (this.isUseRemoteMusicManager) {
      RemoteMusicManager.getInstance().destroy();
    }
  }
  
  public void onMusicEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramBundle.getBundle("data") == null)) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "call js function,bundle is empty");
        return;
        String str = getStateString(paramBundle.getInt("param.state", -1));
        if (!paramString.equals("cmd.notifyStateCallback")) {
          break;
        }
        callWebPageInterface(str, paramBundle);
        bool = paramBundle.getBoolean("param.needPlayTips");
        paramString = this.mRuntime.a();
      } while ((paramString == null) || (paramString.isFinishing()) || (this.isShowing) || (!bool) || (!needPlayTips()));
      pausePlay();
      showPlayTips(paramString, new mck(this), new mcl(this));
      this.isShowing = true;
      return;
      if (paramString.equals("cmd.getPlayMode"))
      {
        callWebPageInterface("playmode", paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getPlayingSong"));
    callWebPageInterface("songinfo", paramBundle);
  }
  
  public void pausePlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcs(this));
  }
  
  public void playMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(convertSongInfo(new JSONObject(paramString)));
      if (localArrayList.size() > 0)
      {
        this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcp(this, localArrayList));
        return;
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.TAG, 2, "song info error");
    }
  }
  
  /* Error */
  public void playMusicList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 569	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 570	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: new 151	org/json/JSONObject
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 503	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 589
    //   24: invokevirtual 259	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: aload_1
    //   29: ldc_w 591
    //   32: invokevirtual 595	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: iload_2
    //   37: istore 4
    //   39: iload_3
    //   40: aload_1
    //   41: invokevirtual 600	org/json/JSONArray:length	()I
    //   44: if_icmpge +34 -> 78
    //   47: aload 5
    //   49: aload_1
    //   50: iload_3
    //   51: invokevirtual 604	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   54: invokestatic 572	cooperation/qzone/music/QzoneWebMusicJsPlugin:convertSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   57: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore_3
    //   65: goto -29 -> 36
    //   68: astore_1
    //   69: iconst_0
    //   70: istore_2
    //   71: aload_1
    //   72: invokevirtual 585	org/json/JSONException:printStackTrace	()V
    //   75: iload_2
    //   76: istore 4
    //   78: aload 5
    //   80: invokevirtual 579	java/util/ArrayList:size	()I
    //   83: ifle +32 -> 115
    //   86: aload_0
    //   87: getfield 117	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   90: invokevirtual 267	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   93: ldc 2
    //   95: invokevirtual 272	com/tencent/common/app/AppInterface:a	(Ljava/lang/Class;)Landroid/os/Handler;
    //   98: new 606	mcq
    //   101: dup
    //   102: aload_0
    //   103: iload 4
    //   105: aload 5
    //   107: invokespecial 609	mcq:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;ILjava/util/ArrayList;)V
    //   110: invokevirtual 282	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   113: pop
    //   114: return
    //   115: invokestatic 310	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq -4 -> 114
    //   121: aload_0
    //   122: getfield 74	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   125: iconst_2
    //   126: ldc_w 611
    //   129: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: return
    //   133: astore_1
    //   134: goto -63 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	QzoneWebMusicJsPlugin
    //   0	137	1	paramString	String
    //   27	49	2	i	int
    //   1	64	3	j	int
    //   37	67	4	k	int
    //   9	97	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	28	68	org/json/JSONException
    //   28	36	133	org/json/JSONException
    //   39	61	133	org/json/JSONException
  }
  
  public void resumePlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mcr(this));
  }
  
  public void setPlayMode(String paramString)
  {
    int j = 0;
    int k;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        bool = paramString.getBoolean("randomMode");
        if (bool) {
          i = 1;
        }
      }
      catch (JSONException paramString)
      {
        boolean bool;
        i = 0;
      }
      try
      {
        bool = paramString.getBoolean("autoModeWithWifi");
        k = i;
        if (bool)
        {
          j = 1;
          k = i;
        }
        bool = needSetAutoPlayTips();
        if ((j != 1) || (this.isAutoPlay) || (!bool)) {
          break;
        }
        showAutoPlayTips(this.mRuntime.a(), new mcg(this), new mch(this, k, j), new mci(this));
        return;
      }
      catch (JSONException paramString)
      {
        break label116;
      }
      int i = 0;
      continue;
      label116:
      paramString.printStackTrace();
      k = i;
    }
    doSetPlayMode(k, j);
  }
  
  public void setRightButton(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("text");
      String str = ((JSONObject)localObject).getString("color");
      boolean bool = ((JSONObject)localObject).getBoolean("visible");
      if ((this.mRuntime.a() instanceof QQBrowserActivity))
      {
        localObject = (TextView)this.mRuntime.a().findViewById(2131297360);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextColor(Color.parseColor("#" + str));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new mce(this));
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label152;
          }
          QLog.e(this.TAG, 2, "set right textview error");
          paramString.printStackTrace();
          return;
        }
        ((TextView)localObject).setVisibility(8);
        return;
      }
    }
    catch (Exception paramString)
    {
      label152:
      paramString.printStackTrace();
    }
  }
  
  public void stopPlay()
  {
    this.mRuntime.a().a(QzoneWebMusicJsPlugin.class).post(new mct(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */