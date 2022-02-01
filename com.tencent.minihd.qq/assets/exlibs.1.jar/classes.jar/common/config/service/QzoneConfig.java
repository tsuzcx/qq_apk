package common.config.service;

import android.text.TextUtils;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneConfig
{
  public static final String A = "URL";
  public static final String B = "QZONE_FLASH_URL";
  public static final String C = "QZONE_FLASH_BEGINTIME";
  public static final String D = "QZONE_FLASH_ENDTIME";
  public static final String E = "BeginTime";
  public static final String F = "EndTime";
  public static final String G = "ShowSigninBanner";
  public static final String H = "ExtraConfig";
  public static final String I = "WifiCarrierType";
  public static final String J = "MinBytes";
  public static final String K = "MaxNum";
  public static final String L = "LowSpeed";
  public static final String M = "HighSpeed";
  public static final String N = "KeepAlive";
  public static final String O = "KeepAliveProxy";
  public static final String P = "AutoWiFi";
  public static final String Q = "Auto3G";
  public static final String R = "Auto2G";
  public static final String S = "QualityLow";
  public static final String T = "QualityMid";
  public static final String U = "QualityHigh";
  public static final String V = "ResolutionLow";
  public static final String W = "ResolutionHigh";
  public static final String X = "WebPQualityLow";
  public static final String Y = "WebPQualityHigh";
  public static final String Z = "Description";
  public static final int a = 0;
  private static QzoneConfig jdField_a_of_type_CommonConfigServiceQzoneConfig = new QzoneConfig();
  public static final String a = "LoadingPhoto";
  public static final String aA = "OptimumIP2";
  public static final String aB = "PhotoURL1";
  public static final String aC = "PhotoURL2";
  public static final String aD = "PhotoURL3";
  public static final String aE = "BackupIP1";
  public static final String aF = "BackupIP2";
  public static final String aG = "AllowVoiceMood";
  public static final String aH = "AllowVoiceOP";
  public static final String aI = "AllowVoiceForward";
  public static final String aJ = "MaxReceiverCount";
  public static final String aK = "ShowOPDelay";
  public static final String aL = "DelayShowLoading";
  public static final String aM = "RestrictBeginTime";
  public static final String aN = "RestrictEndTime";
  public static final String aO = "RestrictFlag";
  public static final String aP = "PreloadQuanCount";
  public static final String aQ = "LevelFlag";
  public static final String aR = "FeedsLevelFlag";
  public static final String aS = "DetailLevelFlag";
  public static final String aT = "RestrictFlag";
  public static final String aU = "MergeMessage";
  public static final String aV = "BlackListVersion";
  public static final String aW = "TraceReportURL";
  public static final String aX = "TraceReportInterval";
  public static final String aY = "TraceReportCount";
  public static final String aZ = "TraceReportSamples";
  public static final String aa = "UploadQuality";
  public static final String ab = "UseLocalQuality";
  public static final String ac = "RemindUploadSizeIsLargeThreshold";
  public static final String ad = "MaxNum";
  public static final String ae = "3GQuality";
  public static final String af = "WIFIQuality";
  public static final String ag = "UploadPort";
  public static final String ah = "ConnectTimeout";
  public static final String ai = "DataTimeout";
  public static final String aj = "TimeoutRetryCount";
  public static final String ak = "MaxConcurrentNum";
  public static final String al = "VideoPartRetryCount";
  public static final String am = "VideoFileRetryCount";
  public static final String an = "VideoPartSize";
  public static final String ao = "VideoPartSizeFor2G";
  public static final String ap = "VideoPartSizeFor3G";
  public static final String aq = "VideoPartConcurrentCount";
  public static final String ar = "AlbumMaxPhotoCount";
  public static final String as = "EnableWatermarkCamera";
  public static final String at = "ReportLogSample";
  public static final String au = "MoodPreloadNetConfig";
  public static final String av = "PreloadCountWifi";
  public static final String aw = "PreloadCount3G";
  public static final String ax = "PreloadCount2G";
  public static final String ay = "IPList";
  public static final String az = "OptimumIP1";
  public static final int b = 1;
  public static final String b = "PhotoDownload";
  public static final String bA = "EmotionURL";
  public static final String bB = "FlowerVineURL";
  public static final String bC = "PhotoABSvrList";
  public static final String bD = "DownloadBackupIP";
  public static final String bE = "DownloadDirectIP";
  public static final String bF = "SwitchTimes";
  public static final String bG = "RetryTimes";
  public static final String bH = "photo_masterIplist";
  public static final String bI = "photo_backupIplist";
  public static final String bJ = "DownloadAccessPortList";
  public static final String bK = "DownloadIPValidTime";
  public static final String bL = "DownloadCustomDnsEnable";
  public static final String bM = "DownloadDirectIP_a";
  public static final String bN = "DownloadDirectIP_b";
  public static final String bO = "DownloadBackupIP_a";
  public static final String bP = "DownloadBackupIP_b";
  public static final String bQ = "photo_masterIplist_a";
  public static final String bR = "photo_backupIplist_a";
  public static final String bS = "photo_masterIplist_b";
  public static final String bT = "photo_backupIplist_b";
  public static final String bU = "KpDomainList";
  public static final String bV = "DownloadDirectIPVideo";
  public static final String bW = "DownloadBackupIPVideo";
  public static final String bX = "video_masterIplist";
  public static final String bY = "video_backupIplist";
  public static final String bZ = "quoteMaxNum";
  public static final String ba = "VisitorReportStopSeconds";
  public static final String bb = "VisitorReportCount";
  public static final String bc = "VisitorReportInteval";
  public static final String bd = "DisableVipInfoOnFriendFeed";
  public static final String be = "TouchQzoneBlog";
  public static final String bf = "TouchQzoneMsgb";
  public static final String bg = "TouchQzoneMood";
  public static final String bh = "TouchQzoneGift";
  public static final String bi = "TouchQzonePhoto";
  public static final String bj = "TouchQzoneShare";
  public static final String bk = "TouchQzoneOther";
  public static final String bl = "TouchQzoneProfile";
  public static final String bm = "ReConnCount";
  public static final String bn = "RetryTime";
  public static final String bo = "RetryInterval";
  public static final String bp = "AccReportCount";
  public static final String bq = "AccReportSamples";
  public static final String br = "AccReportInterval";
  public static final String bs = "CoordinateCacheTime";
  public static final String bt = "POICacheDistance";
  public static final String bu = "POICacheTime";
  public static final String bv = "WeatherCacheTime";
  public static final String bw = "LBSPreload";
  public static final String bx = "GPSPrelocateMaxTimeout";
  public static final String by = "GPSLocateMaxTimeout";
  public static final String bz = "AvatarURL";
  public static final int c = 2;
  public static final String c = "PhotoUpload";
  public static final String cA = "PreLoadGroupFeeds";
  public static final String cB = "ExifEnable";
  public static final String cC = "BlobCacheEnable";
  public static final String cD = "ShowFeedOpLayer";
  public static final String cE = "DbOptiSync";
  public static final String cF = "EnableFeedPreload";
  public static final String cG = "MusicPlayDetailUrl";
  public static final String cH = "BgMusicManagerUrl";
  public static final String cI = "JsBridgeAllowHostsList";
  public static final String cJ = "QunAioRememberUpload";
  public static final String cK = "TimeZone";
  public static final String cL = "MaxDays";
  public static final String cM = "StatTimeRegion";
  public static final String cN = "interval";
  public static final String cO = "PermitPreDownload";
  public static final String cP = "ShowNavigatorGameTab";
  public static final String cQ = "bar_iconurl";
  public static final String cR = "bar_name";
  public static final String cS = "bar_schema";
  public static final String cT = "bar_visiable";
  public static final String cU = "bar_personalize_iconurl";
  public static final String cV = "bar_personalize_name";
  public static final String cW = "bar_personalize_schema";
  public static final String cX = "bar_personalize_visiable";
  public static final String cY = "ItemCount";
  public static final String cZ = "ItemAttribute";
  public static final String ca = "CoverBannerSwitch";
  public static final String cb = "FeedTextMaxLine";
  public static final String cc = "UploadQuality";
  public static final String cd = "UploadResolution";
  public static final String ce = "ip_no_pmtu_disc";
  public static final String cf = "CompressToWebp";
  public static final String cg = "TextToBitmap";
  public static final String ch = "BitmapMemoryThreshold";
  public static final String ci = "MoodRecentPhotoTime";
  public static final String cj = "MoodRecentPhotoCount";
  public static final String ck = "StartDuration";
  public static final String cl = "CrashMax";
  public static final String cm = "CrashClearItems";
  public static final String cn = "FriendMaxSelectCount";
  public static final String co = "FriendMaxSelectCountComment";
  public static final String cp = "GroupTimeMin";
  public static final String cq = "GroupTimeMax";
  public static final String cr = "GroupDistanceMax";
  public static final String cs = "GroupMergeCount";
  public static final String ct = "RecentPhotoTipsCount";
  public static final String cu = "GroupOldDate";
  public static final String cv = "FeedBannerDuration";
  public static final String cw = "FeedBannerActiveMaxCount";
  public static final String cx = "PluginErrorHandleCount";
  public static final String cy = "PluginPermissionErrorHandle";
  public static final String cz = "PreLoadActiveFeeds";
  public static final int d = 1;
  public static final String d = "PhotoDomainIP";
  public static final String dA = "QzoneVisitor";
  public static final String dB = "CardStore";
  public static final String dC = "CardPreview";
  public static final String dD = "CardList";
  public static final String dE = "AvatarSetting";
  public static final String dF = "AvatarPreview";
  public static final String dG = "VipPay";
  public static final String dH = "WeiXinDownload";
  public static final String dI = "MemorySeal";
  public static final String dJ = "DisableForbidComment";
  public static final String dK = "CoverStore";
  public static final String dL = "CoverPreview";
  public static final String dM = "CoverList";
  public static final String dN = "DownloadQzoneClient";
  public static final String dO = "SendBirthdayGift";
  public static final String dP = "AlbumVisitorList";
  public static final String dQ = "AlbumLikeList";
  public static final String dR = "RetryMaxNum";
  public static final String dS = "PerformanceMonitor";
  public static final String dT = "Rate";
  public static final String dU = "Duration";
  public static final String dV = "Interval";
  private static final String dW = "QzoneConfig";
  public static final String da = "ItemDownURLPrefix";
  public static final String db = "ItemOrder";
  public static final String dc = "maxUgcTextCount";
  public static final String dd = "NewestFeedsMinTimeCell";
  public static final String de = "NewestFeedsUinNum";
  public static final String df = "NewestFeedsRetryNum";
  public static final String dg = "NewestFeedsMinRefreshTimeCell";
  public static final String dh = "FeedTextMaxLine";
  public static final String di = "H5Url";
  public static final String dj = "BuyFeedUrl";
  public static final String dk = "VipProfile";
  public static final String dl = "VipPK";
  public static final String dm = "Report";
  public static final String dn = "FeedSkinUrl";
  public static final String jdField_do = "EasterEgg";
  public static final String dp = "FamousHomePage";
  public static final String dq = "SignIn";
  public static final String dr = "GameBar";
  public static final String ds = "SeeMyVisitorPersimmonSetting";
  public static final String dt = "SeeMyQzonePermissionSetting";
  public static final String du = "HideSeeHis";
  public static final String dv = "HideHisRecord";
  public static final String dw = "GiftDetail";
  public static final String dx = "ReturnGiftList";
  public static final String dy = "FeedVisitor";
  public static final String dz = "PersonalQzoneVisitor";
  public static final String e = "VoiceMood";
  public static final String f = "PhotoSvrList";
  public static final String g = "VideoSvrList";
  public static final String h = "Gift";
  public static final String i = "PhotoView";
  public static final String j = "FeedsPre";
  public static final String k = "Push";
  public static final String l = "ReportSetting";
  public static final String m = "JumpQzone";
  public static final String n = "OutBox";
  public static final String o = "WNSSettting";
  public static final String p = "QZoneSetting";
  public static final String q = "TraceLog";
  public static final String r = "QunAlbumSetting";
  public static final String s = "QzoneCover";
  public static final String t = "SafeModeSetting";
  public static final String u = "NavigationBar";
  public static final String v = "HomepageBar";
  public static final String w = "ADFeedExposeTime";
  public static final String x = "famousWhiteList";
  public static final String y = "UpdateCountIntervalWhenActiveApp";
  public static final String z = "UpdateCountIntervalWhenClickFeedTab";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static QzoneConfig a()
  {
    return jdField_a_of_type_CommonConfigServiceQzoneConfig;
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return paramInt;
    }
    try
    {
      int i1 = Integer.valueOf(paramString1).intValue();
      return i1;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public String a(String paramString1, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap;
    if ((paramString1 != null) && (paramString2 != null))
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (localConcurrentHashMap != null) {
        break label93;
      }
      localConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localConcurrentHashMap);
    }
    label93:
    for (;;)
    {
      if (localConcurrentHashMap != null)
      {
        String str2 = (String)localConcurrentHashMap.get(paramString2);
        String str1 = str2;
        if (str2 == null)
        {
          paramString1 = QZConfigProviderUtil.a(paramString1, paramString2);
          str1 = paramString1;
          if (paramString1 != null)
          {
            localConcurrentHashMap.put(paramString2, paramString1);
            str1 = paramString1;
          }
        }
        return str1;
      }
      return null;
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString3;
    }
    return paramString1;
  }
  
  public void a()
  {
    WeakReference[] arrayOfWeakReference = new WeakReference[this.jdField_a_of_type_JavaUtilArrayList.size()];
    arrayOfWeakReference = (WeakReference[])this.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfWeakReference);
    int i2 = arrayOfWeakReference.length;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = arrayOfWeakReference[i1];
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject = (QzoneConfig.QzoneConfigChangeListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((QzoneConfig.QzoneConfigChangeListener)localObject).d();
        }
      }
    }
  }
  
  public void a(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    if (paramQzoneConfigChangeListener == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Object localObject;
        do
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label77;
            }
            localObject = (WeakReference)localIterator.next();
            if (localObject != null)
            {
              localObject = (QzoneConfig.QzoneConfigChangeListener)((WeakReference)localObject).get();
              if (localObject != null) {
                break;
              }
              localIterator.remove();
            }
          }
        } while (!paramQzoneConfigChangeListener.equals(localObject));
      }
      finally {}
      continue;
      label77:
      this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramQzoneConfigChangeListener));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    ConcurrentHashMap localConcurrentHashMap1;
    do
    {
      return;
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      localConcurrentHashMap1 = localConcurrentHashMap2;
      if (localConcurrentHashMap2 == null)
      {
        localConcurrentHashMap1 = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, localConcurrentHashMap1);
      }
    } while (localConcurrentHashMap1 == null);
    localConcurrentHashMap1.put(paramString2, paramString3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  /* Error */
  public void b(QzoneConfig.QzoneConfigChangeListener paramQzoneConfigChangeListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 788	common/config/service/QzoneConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokevirtual 853	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 859 1 0
    //   23: ifeq -17 -> 6
    //   26: aload_2
    //   27: invokeinterface 862 1 0
    //   32: checkcast 835	java/lang/ref/WeakReference
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull -20 -> 17
    //   40: aload_3
    //   41: invokevirtual 844	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   44: checkcast 846	common/config/service/QzoneConfig$QzoneConfigChangeListener
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +11 -> 60
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 869	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -40 -> 17
    //   60: aload_2
    //   61: invokeinterface 865 1 0
    //   66: goto -49 -> 17
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QzoneConfig
    //   0	74	1	paramQzoneConfigChangeListener	QzoneConfig.QzoneConfigChangeListener
    //   16	45	2	localIterator	Iterator
    //   35	19	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	17	69	finally
    //   17	36	69	finally
    //   40	48	69	finally
    //   52	60	69	finally
    //   60	66	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.config.service.QzoneConfig
 * JD-Core Version:    0.7.0.1
 */