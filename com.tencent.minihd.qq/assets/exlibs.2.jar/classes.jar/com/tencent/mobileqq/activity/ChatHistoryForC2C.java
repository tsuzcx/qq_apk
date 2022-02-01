package com.tencent.mobileqq.activity;

import ActionMsg.MsgBody;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.ImageCache;
import com.tencent.mobileqq.util.ImageWorker;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dne;
import dnf;
import dng;
import dnh;
import dni;
import dnj;
import dnk;
import dnl;
import dnm;
import dnn;
import dno;
import dnq;
import dnr;
import dns;
import dnt;
import dnu;
import dnv;
import dnx;
import dny;
import dnz;
import dob;
import doc;
import dod;
import doe;
import dof;
import dog;
import doh;
import doq;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class ChatHistoryForC2C
  extends IphoneTitleBarActivity
  implements SensorEventListener
{
  public static final int A = 19;
  public static final int B = 20;
  public static final int C = 21;
  public static final int D = 22;
  public static final int E = 23;
  public static final int F = 24;
  public static final int G = 25;
  public static final int H = 29;
  public static final int I = 200;
  public static final int J = 1;
  public static final int K = 2;
  public static final int L = 3;
  public static final int M = 4;
  static final int N = 1;
  private static final int P = 26;
  private static final int Q = 27;
  private static final int R = 28;
  private static final int U = 1;
  private static Toast jdField_a_of_type_AndroidWidgetToast;
  public static final String a = "from_RecentSaidActivity";
  public static final String b = "target_shmsgseq";
  static final String jdField_e_of_type_JavaLangString = "https://m.qzone.com";
  static final String jdField_f_of_type_JavaLangString = "https://mobile.qzone.qq.com";
  public static final String g = "https://mapp.3g.qq.com/touch/psw/verify.jsp?type=history&sid=";
  public static final int h = 0;
  public static final String h = "https://mapp.3g.qq.com/touch/psw/create.jsp?sid=";
  public static final int i = 1;
  public static final String i = "https://imgcache.qq.com/club/client/msgRoam/rel/index.html?_wv=5123&ADTAG=msgHistory";
  public static final int j = 2;
  private static final String j = "ChatHistoryForC2C";
  public static final int k = 3;
  private static final String k = "https://kiss.3g.qq.com/activeQQ/mqq/groupMsg_wap20.jsp?bid=591&sid=%s&groupName=%s&groupCode=%s";
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final int o = 7;
  public static final int p = 8;
  public static final int q = 9;
  public static final int r = 10;
  public static final int s = 11;
  public static final int t = 12;
  public static final int u = 13;
  public static final int v = 14;
  public static final int w = 15;
  public static final int x = 16;
  public static final int y = 17;
  public static final int z = 18;
  public int O;
  private int S;
  private int T;
  float jdField_a_of_type_Float;
  public int a;
  public long a;
  public Dialog a;
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new dob(this);
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
  View jdField_a_of_type_AndroidViewView;
  AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new dny(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChatHistoryForC2C.ChatHistoryAdapter a;
  public ChatHistoryForC2C.PlayingPttHistoryInfo a;
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = new dnx(this);
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public MessageSearchDialog a;
  private ProxyObserver jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver = new dnv(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ImageWorker jdField_a_of_type_ComTencentMobileqqUtilImageWorker;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new dne(this);
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  public QQProgressDialog a;
  public TipsBar a;
  doq jdField_a_of_type_Doq = new doq(this, null);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  public long b;
  public Dialog b;
  private AnimationDrawable jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_b_of_type_AndroidOsHandler = new dod(this);
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  public Dialog c;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  final int jdField_f_of_type_Int;
  int g = 1;
  private final String l = "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou.json";
  private String m = null;
  private String n = "";
  
  public ChatHistoryForC2C()
  {
    this.f = 60;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = null;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
    }
  }
  
  private void B()
  {
    if (jdField_a_of_type_AndroidWidgetToast != null)
    {
      jdField_a_of_type_AndroidWidgetToast.cancel();
      jdField_a_of_type_AndroidWidgetToast = null;
    }
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = null;
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    }
    setVolumeControlStream(3);
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null)
    {
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange();
      if (this.jdField_b_of_type_Float <= 10.0F) {
        break label66;
      }
    }
    label66:
    for (float f1 = 10.0F;; f1 = this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      return;
    }
  }
  
  private void E()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      str = "999";
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "AIO_chatlog arg:" + str);
      }
      ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_chatlog", 0, 0, str, "", "", "");
      return;
      str = "0";
      continue;
      str = "3";
      continue;
      str = "2";
    }
  }
  
  private MsgBody a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (((paramInt2 != -1003) && (paramInt2 != -1032) && (paramInt2 != -1031) && (paramInt2 != 201)) || ((paramInt1 == 1001) || (ActionMsgUtil.a(paramInt2)) || (paramInt2 == -3001) || (paramInt2 == -30002) || (paramInt2 == -30003))) {
      return ActionMsgUtil.a(paramString);
    }
    if (paramInt2 == -2009)
    {
      localMsgBody = new MsgBody();
      boolean bool = MsgUtils.b(paramInt3);
      localMsgBody.msg = MsgUtils.a(TransfileUtile.a(paramString), this, bool, false);
      localMsgBody.action = null;
      return localMsgBody;
    }
    if (paramInt2 == -2016)
    {
      localMsgBody = new MsgBody();
      localMsgBody.msg = MsgUtils.a(this.app, TransfileUtile.a(paramString), this, this.jdField_c_of_type_JavaLangString, null, this.jdField_a_of_type_Int);
      localMsgBody.action = null;
      return localMsgBody;
    }
    MsgBody localMsgBody = new MsgBody();
    localMsgBody.msg = paramString;
    localMsgBody.action = null;
    return localMsgBody;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.app.a().createMessageRecordEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  private String a()
  {
    return this.app.a();
  }
  
  private String a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!AbsShareMsg.class.isInstance(paramAbsStructMsg))) {
      return null;
    }
    paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramAbsStructMsg.mMsgBrief)) {
      localStringBuffer.append(paramAbsStructMsg.mMsgBrief);
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (!TextUtils.isEmpty(paramAbsStructMsg.mSourceName))
      {
        localStringBuffer.append(paramAbsStructMsg.mSourceName);
        localStringBuffer.append(" " + getString(2131368751) + " ");
        if (!TextUtils.isEmpty(paramAbsStructMsg.mContentTitle)) {
          localStringBuffer.append(paramAbsStructMsg.mContentTitle);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ForwardHandlerActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.setFlags(67108864);
    startActivity(localIntent);
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.setBounds(0, 0, this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumWidth(), this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.getMinimumHeight());
      paramImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  private void a(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.a(true);
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        PicEmoticonInfo.b((URLDrawable)localDrawable);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131297177));
    g();
    y();
    t();
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter = new ChatHistoryForC2C.ChatHistoryAdapter(this, this, null);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_AndroidWidgetListView.setOverscrollFooter(null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    long l1 = ((SharedPreferences)localObject).getLong("blue_banner_last_update_timestamp", 0L);
    long l2 = ((SharedPreferences)localObject).getInt("blue_banner_cheak_update_internal", 24);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if ((paramBoolean) || (l3 - l1 > l2 * 3600000L) || (l3 < l1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)this.app.getManager(46));
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
      }
      localObject = new File(getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou.json");
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(new DownloadTask("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou.json", (File)localObject), this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
    }
  }
  
  private boolean a(SharedPreferences paramSharedPreferences)
  {
    boolean bool = false;
    switch (paramSharedPreferences.getInt("message_roam_flag" + this.app.a(), 0))
    {
    default: 
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.trim().equals("")) || (paramString.contains("\n"))) {
      bool = false;
    }
    while (!Pattern.compile("^[*+,./\\\"=_-]+").matcher(paramString.substring(0, 1)).matches()) {
      return bool;
    }
    return false;
  }
  
  private void b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      paramImageView.setImageDrawable(getResources().getDrawable(2130840753));
    }
  }
  
  private void b(ImageView paramImageView, PicEmoticonInfo paramPicEmoticonInfo)
  {
    if ((paramImageView != null) && (paramPicEmoticonInfo != null) && (paramPicEmoticonInfo.a()))
    {
      paramPicEmoticonInfo = paramPicEmoticonInfo.b();
      if ((paramPicEmoticonInfo != null) && ((paramPicEmoticonInfo instanceof URLDrawable))) {
        PicEmoticonInfo.a((URLDrawable)paramPicEmoticonInfo);
      }
      paramImageView.setImageDrawable(paramPicEmoticonInfo);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    ((MessageRoamManager)this.app.getManager(86)).a(paramString, paramInt, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_JavaLangStringBuffer);
  }
  
  private void b(boolean paramBoolean)
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(86);
    localMessageRoamManager.b(true);
    localMessageRoamManager.a(paramBoolean);
  }
  
  private void c(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private boolean c(String paramString)
  {
    C();
    MediaPlayerManager.a(this.app).a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "playSource|bRet = " + bool);
    }
    if ((bool) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 2);
    }
    return bool;
  }
  
  private void s()
  {
    SharedPreferences localSharedPreferences;
    String str2;
    String str1;
    if (new File(getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou.json").exists())
    {
      localSharedPreferences = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      str2 = this.app.a();
      int i1 = localSharedPreferences.getInt("message_roam_is_first_show" + str2, 0);
      bool = a(localSharedPreferences);
      long l1 = localSharedPreferences.getLong("banner_last_show_timestamp" + str2, 0L);
      long l2 = localSharedPreferences.getInt("blue_banner_show_internal", 24);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      long l4 = localSharedPreferences.getInt("blue_banner_show_time", 0) * 1000L;
      if (((!bool) && ((l3 - l1 > l2 * 3600000L) || (l3 < l1))) || ((i1 == 0) && (l4 != 0L)))
      {
        bool = VipUtils.b(this.app);
        if (!VipUtils.a(this.app)) {
          break label357;
        }
        this.n = "svip";
        str1 = localSharedPreferences.getString("blue_banner_svip_text", null);
        if (i1 == 0) {
          str1 = getResources().getString(2131366506);
        }
        this.m = localSharedPreferences.getString("blue_banner_go_url", null);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.m)))
        {
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12, str1).sendToTarget();
          if (i1 != 0) {
            break label407;
          }
          localSharedPreferences.edit().putInt("message_roam_is_first_show" + str2, 1).commit();
          label330:
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13), l4);
        }
      }
    }
    for (boolean bool = false;; bool = true)
    {
      a(bool);
      return;
      label357:
      if (bool)
      {
        this.n = "vip";
        str1 = localSharedPreferences.getString("blue_banner_vip_text", null);
        break;
      }
      this.n = "notvip";
      str1 = localSharedPreferences.getString("blue_banner_notvip_text", null);
      break;
      label407:
      localSharedPreferences.edit().putLong("banner_last_show_timestamp" + str2, NetConnInfoCenter.getServerTimeMillis()).commit();
      break label330;
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(getActivity(), 2130904096, null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131300827));
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setOnClickListener(new dnq(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131558902);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130904387);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131296606)).setText(getResources().getString(2131366490));
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new doc(this));
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void v()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(28));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localIllegalArgumentException.getMessage());
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "tipsDialog dismiss " + localException.getMessage());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void w()
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    int i1 = localSharedPreferences.getInt("message_roam_is_set_password" + this.app.a(), -1);
    if (!a(localSharedPreferences)) {
      x();
    }
    do
    {
      return;
      if ((i1 == 0) || (i1 == -1))
      {
        b();
        return;
      }
    } while (i1 != 1);
    b(false);
  }
  
  private void x()
  {
    u();
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(86);
    localMessageRoamManager.b(false);
    localMessageRoamManager.r();
  }
  
  private void y()
  {
    this.jdField_b_of_type_AndroidViewView = View.inflate(getActivity(), 2130903138, null);
    this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new doe(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131297044));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131297043);
    j();
  }
  
  private void z()
  {
    String str = getResources().getString(2131366331);
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_c_of_type_JavaLangString.equals(String.valueOf(AppConstants.ae)))
      {
        this.jdField_d_of_type_JavaLangString = getResources().getString(2131367460);
        if (!this.jdField_c_of_type_JavaLangString.equals(String.valueOf(AppConstants.ae))) {
          break label304;
        }
        str = getResources().getString(2131367460);
      }
    }
    label304:
    for (;;)
    {
      if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.trim().equals(""))) {
        this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      }
      setTitle(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.leftView = ((TextView)findViewById(2131297357));
      return;
      this.jdField_d_of_type_JavaLangString = ContactUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
      break;
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_d_of_type_JavaLangString = ((FriendManager)this.app.getManager(8)).e(this.jdField_c_of_type_JavaLangString);
      } else if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_d_of_type_JavaLangString = ((FriendManager)this.app.getManager(8)).a(this.jdField_c_of_type_JavaLangString);
      } else if (this.jdField_a_of_type_Int == 3000) {
        this.jdField_d_of_type_JavaLangString = ContactUtils.c(this.app, this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCheckPasswordUrl ! ");
    }
    Object localObject = (MessageRoamManager)this.app.getManager(86);
    ((MessageRoamManager)localObject).a(1);
    ((MessageRoamManager)localObject).d();
    localObject = new Intent(this, QQBrowserActivity.class);
    String str = this.app.getSid();
    ((Intent)localObject).putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?type=history&sid=" + str);
    startActivityForResult((Intent)localObject, 26);
  }
  
  public void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getResources().getDimensionPixelSize(2131492923));
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      if (paramMessageRecord == null) {
        break label110;
      }
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr uniseq is:" + paramMessageRecord.uniseq + ",id is:" + paramMessageRecord.getId());
    }
    for (;;)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(getResources().getString(2131363703));
      localActionSheet.a(2131366672, 3);
      localActionSheet.e(2131365736);
      localActionSheet.a(new dnz(this, paramMessageRecord, localActionSheet));
      localActionSheet.show();
      return;
      label110:
      QLog.d("Q.msg.delmsg", 2, "startDelMsg is called,mr is null");
    }
  }
  
  public void a(String paramString)
  {
    View localView = getLayoutInflater().inflate(2130903274, null);
    String str2 = getString(2131366352);
    String str1;
    if (1 == this.jdField_a_of_type_Int)
    {
      localView.findViewById(2131297524).setVisibility(8);
      str1 = getString(2131366377);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(str1).setPositiveButton(getString(2131366672), new dnn(this, paramString)).setNegativeButton(getString(2131366375), new dnm(this)).addView(localView);
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      if (3000 == this.jdField_a_of_type_Int)
      {
        localView.findViewById(2131297524).setVisibility(8);
        str1 = getString(2131366377);
      }
      else if ((1001 != this.jdField_a_of_type_Int) && (1000 != this.jdField_a_of_type_Int) && (1020 != this.jdField_a_of_type_Int))
      {
        str1 = str2;
        if (1004 != this.jdField_a_of_type_Int) {}
      }
      else
      {
        localView.findViewById(2131297524).setVisibility(8);
        str1 = str2;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.jdField_a_of_type_Int = 1;
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoCreatePasswordUrl ! ");
    }
    ((MessageRoamManager)this.app.getManager(86)).a(0);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    String str = this.app.getSid();
    localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/create.jsp?sid=" + str);
    startActivityForResult(localIntent, 26);
  }
  
  public void b(String paramString)
  {
    if (jdField_a_of_type_AndroidWidgetToast == null) {
      jdField_a_of_type_AndroidWidgetToast = Toast.makeText(this, paramString, 0);
    }
    for (;;)
    {
      jdField_a_of_type_AndroidWidgetToast.show();
      return;
      jdField_a_of_type_AndroidWidgetToast.setText(paramString);
    }
  }
  
  boolean b(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryForC2C", 2, "gotoRoamMessageSettingUrl ! ");
    }
    this.S = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), -1);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/msgRoam/rel/index.html?_wv=5123&ADTAG=msgHistory");
    startActivityForResult(localIntent, 27);
  }
  
  public void d()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.app.getManager(86);
    if (localMessageRoamManager.b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      if (!localMessageRoamManager.c()) {
        break label78;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    for (;;)
    {
      if (!localMessageRoamManager.d()) {
        break label97;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      break;
      label78:
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    label97:
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.getCursor().requery();
          return;
        } while (-1 != paramInt2);
        a(paramIntent.getExtras());
        return;
      } while (paramInt2 != 3000);
      x();
      return;
      paramInt1 = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.a(), -1);
    } while (paramInt1 == this.S);
    if (paramInt1 > this.S) {
      b(true);
    }
    for (;;)
    {
      this.S = paramInt1;
      return;
      if (paramInt1 < this.S) {
        b(true);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968766));
    this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130968728));
    paramBundle = getIntent().getExtras();
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("uin");
    this.jdField_a_of_type_Int = paramBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramBundle.getString("troop_uin");
    setContentViewNoTitle(2130903167);
    boolean bool = paramBundle.getBoolean("from_RecentSaidActivity", false);
    this.jdField_a_of_type_Boolean = bool;
    if (bool) {
      this.jdField_c_of_type_Long = paramBundle.getLong("target_shmsgseq");
    }
    init(getIntent());
    ((MessageRoamManager)this.app.getManager(86)).a(this.jdField_c_of_type_JavaLangString);
    z();
    a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    h();
    D();
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    if (this.app.a() != null) {
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker = new ImageWorker(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a((int)(150.0F * this.jdField_a_of_type_Float), (int)(100.0F * this.jdField_a_of_type_Float));
    s();
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      i();
      x();
    }
    do
    {
      return true;
      w();
      E();
      VipUtils.a(this.app, "vip", "0X8004FAB", "0X8004FAB", 0, 0, new String[] { this.n });
    } while (!QLog.isColorLevel());
    QLog.i("ChatHistoryForC2C", 2, "查看聊天记录页面的 ，T ：0X8004FAB ， userIdentity" + this.n);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryForC2C", 2, "ChatHistoryForC2C : close entityManager.");
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    A();
    B();
    r();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "onDestroy() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo.b();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_b_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
    this.app.a(getClass());
    ((MessageRoamManager)this.app.getManager(86)).a();
    if (this.app.a() != null) {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    this.app.a().e();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker.a().a();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "onPause() mCurPlayingPttInfo = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$PlayingPttHistoryInfo.b();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dnu(this), 300L);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  public void f()
  {
    View localView1 = findViewById(2131297176);
    View localView2 = findViewById(2131296742);
    int i1 = localView1.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog = new MessageSearchDialog(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new dof(this, localView2, localView1));
    localTranslateAnimation2.setAnimationListener(new dog(this, localView2, i1));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.setOnDismissListener(new doh(this, localView2, i1, localView1, localTranslateAnimation2));
    localView2.startAnimation(localTranslateAnimation1);
  }
  
  public void finish()
  {
    super.finish();
  }
  
  void g()
  {
    this.jdField_c_of_type_AndroidViewView = View.inflate(getActivity(), 2130904390, null);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
    }
    this.jdField_c_of_type_AndroidViewView.findViewById(2131299461).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131299473);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(new dnf(this));
    setLayerType(this.jdField_c_of_type_AndroidViewView);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297182));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297186));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131369346));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131369347));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297189));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131369348));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new dng(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new dnh(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new dni(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297188));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new dnj(this));
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1020) || (this.jdField_a_of_type_Int == 1005) || (this.jdField_a_of_type_Int == 1004) || (this.jdField_a_of_type_Int == 1009) || (this.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_Int == 1023) || (this.jdField_a_of_type_Int == 1024)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new dnk(this));
      e();
      return;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000))
      {
        FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
        if ((localFriendManager == null) || (!localFriendManager.b(String.valueOf(this.jdField_c_of_type_JavaLangString))))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatHistoryForC2C", 2, "--mRoamMsgSettingHistory button: fm is null or the uin is not my friend: fm:" + localFriendManager);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131366498));
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void k()
  {
    if (this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int) > 0)
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C$ChatHistoryAdapter.getCursor();
      if (localCursor != null) {
        localCursor.requery();
      }
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (!((CheckBox)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131297524)).isChecked()) {
        break label164;
      }
      VipUtils.a(this.app, "vip", "0X8004FAF", "0X8004FAF", 0, 0, new String[] { this.n });
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "删除云端消息记录 ，T ：0X8004FAF ， userIdentity" + this.n);
      }
      n();
      this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      ThreadManager.c(new dnl(this));
      return;
      label164:
      VipUtils.a(this.app, "vip", "0X8004FAE", "0X8004FAE", 0, 0, new String[] { this.n });
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "删除本地消息记录 ，T ：0X8004FAE ， userIdentity" + this.n);
      }
    }
  }
  
  public void l()
  {
    ((MessageRoamManager)this.app.getManager(86)).b(getResources().getString(2131366490));
  }
  
  void m()
  {
    ((MessageRoamManager)this.app.getManager(86)).h();
  }
  
  public void n()
  {
    if (!NetworkUtil.e(this.app.getApplication().getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131367017, 1).a();
      return;
    }
    c(getApplicationContext().getResources().getString(2131367018));
    ((MessageRoamManager)this.app.getManager(86)).o();
  }
  
  void o()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
    String str;
    if (this.jdField_d_of_type_JavaLangString.compareTo(this.jdField_c_of_type_JavaLangString) == 0)
    {
      str = this.jdField_d_of_type_JavaLangString;
      if (!a(str)) {
        break label196;
      }
      str = str.replaceAll("[\\\\/:*?\"<>|]", "");
      this.jdField_a_of_type_JavaLangStringBuffer.append(str + ".txt");
    }
    for (;;)
    {
      boolean bool = FileUtils.a(AppConstants.aG, this.jdField_a_of_type_JavaLangStringBuffer, ".txt");
      this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131366381), getString(2131366381) + AppConstants.aG + this.jdField_a_of_type_JavaLangStringBuffer.toString(), new dno(this), new dnr(this));
      if (!bool) {
        break label230;
      }
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
      str = String.format("%s(%s)", new Object[] { this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString });
      break;
      label196:
      this.jdField_a_of_type_JavaLangStringBuffer.append(this.jdField_c_of_type_JavaLangString + ".txt");
    }
    label230:
    b(getString(2131366383));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected boolean onBackEvent()
  {
    setResult(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.a(false);
      return true;
    }
    return super.onBackEvent();
  }
  
  protected View onCreateRightView()
  {
    super.onCreateRightView();
    TextView localTextView = this.rightViewText;
    if ((3000 == this.jdField_a_of_type_Int) || (1 == this.jdField_a_of_type_Int)) {
      this.rightViewText.setVisibility(8);
    }
    for (;;)
    {
      localTextView.setText(2131366499);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      return localTextView;
      this.rightViewText.setVisibility(0);
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool2 = true;
    if (AIOUtils.b()) {
      return;
    }
    boolean bool1;
    if (paramSensorEvent.values[0] < this.jdField_b_of_type_Float)
    {
      bool1 = true;
      label26:
      if (this.e == bool1) {
        break label87;
      }
      this.e = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)
      {
        paramSensorEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (this.e) {
          break label89;
        }
        bool1 = bool2;
        label61:
        paramSensorEvent.a(bool1);
      }
      if (!this.e) {
        break label94;
      }
    }
    label87:
    label89:
    label94:
    for (int i1 = 2131366523;; i1 = 2131366524)
    {
      a(i1);
      return;
      bool1 = false;
      break label26;
      break;
      bool1 = false;
      break label61;
    }
  }
  
  void p()
  {
    this.jdField_c_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131366492), getString(2131366493), new dns(this), new dnt(this));
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void q()
  {
    AudioUtil.b(2131165187, false);
  }
  
  public void r()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryForC2C
 * JD-Core Version:    0.7.0.1
 */