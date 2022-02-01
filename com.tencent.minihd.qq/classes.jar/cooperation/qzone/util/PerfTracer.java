package cooperation.qzone.util;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class PerfTracer
{
  public static final String A = "QunFeed_click2Activity";
  public static final String B = "QunFeed_onCreate";
  public static final String C = "QunFeed_parseIntent";
  public static final String D = "QunFeed_initUI";
  public static final String E = "QunFeed_initData";
  public static final String F = "QunFeed_onResume";
  public static final String G = "Detail_click2Activity";
  public static final String H = "Detail_onCreate";
  public static final String I = "Detail_init";
  public static final String J = "Detail_initEmoView";
  public static final String K = "Detail_onResume";
  public static final String L = "Detail_render";
  public static final String M = "UploadPhoto_click2Activity";
  public static final String N = "UploadPhoto_onCreate";
  public static final String O = "UploadPhoto_state_init";
  public static final String P = "UploadPhoto_initUI";
  public static final String Q = "UploadPhoto_initData";
  public static final String R = "UploadPhoto_initEmoView";
  public static final String S = "UploadPhoto_onResume";
  public static final String T = "PublishMood_click2Activity";
  public static final String U = "PublishMood_onCreate";
  public static final String V = "PublishMood_state_init";
  public static final String W = "PublishMood_initUI";
  public static final String X = "PublishMood_initData";
  public static final String Y = "PublishMood_onResume";
  public static final String Z = "QunAlbum_click2Activity";
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public static final String a = "click2LoadCompleted";
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aA = "PhotoWall_onResume";
  public static final String aB = "QzoneCover_init";
  public static final String aC = "QzoneCover_loadPhoto";
  public static final String aD = "QzoneCover_start_translate";
  public static final String aE = "QzoneCover_switch";
  public static final String aF = "MoodList_click2Activity";
  public static final String aG = "MoodList_onCreate";
  public static final String aH = "MoodList_initUI";
  public static final String aI = "MoodList_initData";
  public static final String aJ = "MyFeed_click2Activity";
  public static final String aK = "MyFeed_onCreate";
  public static final String aL = "MyFeed_initUI";
  public static final String aM = "MyFeed_initData";
  public static final String aN = "MyFeed_onResume";
  private static final String aO = "Perf.Qzone";
  public static final String aa = "QunAlbum_onCreate";
  public static final String ab = "QunAlbum_state_init";
  public static final String ac = "QunAlbum_parseIntent";
  public static final String ad = "QunAlbum_initUI";
  public static final String ae = "QunAlbum_initData";
  public static final String af = "QunAlbum_onResume";
  public static final String ag = "UserHome_click2Activity";
  public static final String ah = "UserHome_onCreate";
  public static final String ai = "UserHome_parseIntent";
  public static final String aj = "UserHome_initUI";
  public static final String ak = "UserHome_initData";
  public static final String al = "UserHome_onResume";
  public static final String am = "UserHome_FakeUI_Create";
  public static final String an = "UserHome_IncreaseDepth_Create";
  public static final String ao = "UserHome_Header_Resume";
  public static final String ap = "UserHome_PerformanceReport_Resume";
  public static final String aq = "QzoneAlbum_click2Activity";
  public static final String ar = "QzoneAlbum_onCreate";
  public static final String as = "QzoneAlbum_onResume";
  public static final String at = "QzoneRecent_click2Activity";
  public static final String au = "QzoneRecent_onCreate";
  public static final String av = "QzoneRecent_onResume";
  public static final String aw = "PhotoWall_click2Activity";
  public static final String ax = "PhotoWall_onCreate";
  public static final String ay = "PhotoWall_initUI";
  public static final String az = "PhotoWall_initData";
  public static final String b = "App_onCreate";
  public static boolean b = false;
  public static final String c = "APP_readTraceConfig";
  public static final String d = "Runtime_load_runtime";
  public static final String e = "Runtime_onCreate";
  public static final String f = "Runtime_super_onCreate";
  public static final String g = "Runtime_first_init";
  public static final String h = "Runtime_Business_onLogin";
  public static final String i = "Preload_contentView";
  public static final String j = "Preload_headView";
  public static final String k = "Preload_New_FriendFeed";
  public static final String l = "Preload_Cover";
  public static final String m = "Preload_Avatar";
  public static final String n = "Preload_FriendFeedData";
  public static final String o = "Preload_QunFeedData";
  public static final String p = "FriendFeed_click2Activity";
  public static final String q = "FriendFeed_onCreate";
  public static final String r = "FriendFeed_parseIntent";
  public static final String s = "FriendFeed_initFakeUI";
  public static final String t = "FriendFeed_initUI";
  public static final String u = "FriendFeed_initHeader";
  public static final String v = "FriendFeed_initHeader_Cover";
  public static final String w = "FriendFeed_initData";
  public static final String x = "FriendFeed_onResume";
  public static final String y = "FriendFeed_onCreate2WindowFocus";
  public static final String z = "FriendFeed_delayShow";
  
  static
  {
    if (BaseApplicationImpl.g == 2) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public static Handler a()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Perf.Qzone");
      jdField_a_of_type_AndroidOsHandlerThread.start();
      jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    System.currentTimeMillis();
    if (b)
    {
      TimeCostTrace.a("qzone_launch").a(paramString2);
      TimeCostTrace.a("qzone_launch").b(paramString1);
    }
  }
  
  private static boolean a(String paramString)
  {
    return !b;
  }
  
  private static boolean b(String paramString)
  {
    return (paramString.startsWith("FriendFeed_")) || (paramString.startsWith("App_")) || (paramString.startsWith("Runtime_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.util.PerfTracer
 * JD-Core Version:    0.7.0.1
 */