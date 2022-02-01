package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class PreDownloadStrategyBeta
  extends BaseStrategy
{
  public static final String A = "AFBFlowHit3G";
  public static final String B = "AFBFlowMiss3G";
  public static final String C = "APicAvgSize";
  public static final String D = "APicMaxSize";
  public static final String E = "enablePeakFlow";
  public static final String F = "PeakFlowTimePeriod";
  public static final String G = "PeakFlowMaxPicSize";
  private static final String H = "PIC_TAG_PRELOAD.PreDownloadStrategyBeta";
  public static final String h = "xgFlowPre";
  public static final String i = "xgFlowWaste";
  public static final String j = "xgPreDownCount";
  public static final String k = "xgHitCount";
  public static final String l = "xgMissCount";
  public static final String m = "xgManulClickCount";
  public static final String n = "wifiPreDownCout";
  public static final String o = "wifiHitCount";
  public static final String p = "wifiMissCount";
  public static final String q = "wifiManulClickCount";
  public static final String r = "accFlowPreTotal";
  public static final String s = "accFlowWasteTotal";
  public static final String t = "accDays";
  public static final String u = "accStartDay";
  public static final String v = "lastDayTime";
  public static final String w = "xgFlowWasteBalance";
  public static final String x = "PicDPy471";
  public static final String y = "AMaxWFlow3G";
  public static final String z = "AMaxPDFlow3G";
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public float a;
  private PicStatisticsManager a;
  public boolean a;
  public long[] a;
  private QQAppInterface b;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u = -1L;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.s;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.c(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 2;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.E += 1L;
      PicPreDownloadUtils.a("wifiHitCount", this.E, true);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",wifiHitCount:" + this.E + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      paramLong = a(paramLong);
      this.u += this.p * paramLong / 100L;
      if (this.u > this.n) {
        this.u = this.n;
      }
      this.v -= paramLong;
      this.x -= paramLong;
      if (this.v < 0L) {
        this.v = 0L;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "picSize:" + paramLong + ",flowPre:" + this.u + ",flowWaste:" + this.v);
      }
      this.A += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.v, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.x, false);
      PicPreDownloadUtils.a("xgHitCount", this.A, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",xgHitCount:" + this.A + ",uniseq:" + paramMessageForPic.uniseq);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.w + ",accFlowWasteTotal:" + this.x);
  }
  
  public static void a(MessageForPic paramMessageForPic, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageForPic == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMessageForPic.previewed == 1);
        int i1 = paramMessageForPic.preDownNetworkType;
        paramMessageForPic.previewed = 1;
        paramMessageForPic.serial();
        if (i1 != 0) {
          break;
        }
      } while (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId);
      PicPreDownloadUtils.a("wifiManulClickCount", PicPreDownloadUtils.a("wifiManulClickCount", 0L) + 1L, true);
      paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
      return;
    } while (paramMessageForPic.subMsgId != MessageForPic.defaultSuMsgId);
    PicPreDownloadUtils.a("xgManulClickCount", PicPreDownloadUtils.a("xgManulClickCount", 0L) + 1L, true);
    paramQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageForPic.msgData);
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      PicPreDownloader localPicPreDownloader = this.b.a();
      if (localPicPreDownloader != null)
      {
        if (paramMessageForPic.mNotPredownloadReason != 0) {
          break label158;
        }
        int i1 = localPicPreDownloader.a(paramMessageForPic);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.f(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.d(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.F += 1L;
      PicPreDownloadUtils.a("wifiMissCount", this.F, true);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ",wifiMissCount:" + this.F + ",uniseq:" + paramMessageForPic.uniseq);
    }
    label158:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
      if (paramMessageForPic.mNotPredownloadReason == -1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.d(paramInt1, paramInt2);
      break;
      this.u += this.q;
      if (this.u > this.n) {
        this.u = this.n;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "picSize:" + paramLong + ",flowPre:" + this.u + ",flowWaste:" + this.v);
      }
      this.B += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgMissCount", this.B, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ", xgMissCount:" + this.B + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      PicPreDownloadUtils.a("wifiHitCount", this.E, true);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",wifiHitCount:" + this.E + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      this.u += this.r;
      if (this.u > this.n) {
        this.u = this.n;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "picSize:" + paramLong + ",flowPre:" + this.u + ",flowWaste:" + this.v + ",uniseq:" + paramMessageForPic.uniseq);
      }
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgHitCount", this.A, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",xgHitCount:" + this.A + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.e(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      PicPreDownloadUtils.a("wifiHitCount", this.E, true);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",wifiHitCount:" + this.E + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      this.u += this.r;
      if (this.u > this.n) {
        this.u = this.n;
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "picSize:" + paramLong + ",flowPre:" + this.u + ",flowWaste:" + this.v + ",uniseq:" + paramMessageForPic.uniseq);
      }
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgHitCount", this.A, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",xgHitCount:" + this.A + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void e()
  {
    this.E = PicPreDownloadUtils.a("wifiHitCount", this.E);
    this.F = PicPreDownloadUtils.a("wifiMissCount", this.F);
    this.G = PicPreDownloadUtils.a("wifiManulClickCount", this.G);
    this.D = PicPreDownloadUtils.a("wifiPreDownCout", this.D);
    this.v = PicPreDownloadUtils.a("xgFlowWaste", this.v);
    this.A = PicPreDownloadUtils.a("xgHitCount", this.A);
    this.B = PicPreDownloadUtils.a("xgMissCount", this.B);
    this.C = PicPreDownloadUtils.a("xgManulClickCount", this.C);
    this.z = PicPreDownloadUtils.a("xgPreDownCount", this.z);
    this.w = PicPreDownloadUtils.a("accFlowPreTotal", this.w);
    this.x = PicPreDownloadUtils.a("accFlowWasteTotal", this.x);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.E + " wifiMissCount=" + this.F + " wifiManulClickCount=" + this.G + " wifiPreDownCout=" + this.D + " xgFlowWaste=" + this.v + " xgHitCount=" + this.A + " xgMissCount=" + this.B + " xgManulClickCount=" + this.C + " xgPreDownCout=" + this.z + " accFlowPreTotal=" + this.w + " accFlowWasteTotal=" + this.x);
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int i1 = super.a(paramLong, paramInt1, paramInt2);
    if (i1 != 0) {}
    do
    {
      do
      {
        boolean bool;
        do
        {
          return i1;
          bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
          if (QLog.isColorLevel()) {
            Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "isInDPCWhiteList:" + bool);
          }
          i1 = i2;
        } while (paramInt2 == 0);
        if (!bool) {
          break;
        }
        i1 = i2;
      } while (paramInt2 != 3);
      paramLong = a(paramLong);
      if (this.u - paramLong < 0L) {
        break;
      }
      i1 = i2;
    } while (this.v + paramLong < this.o);
    if (this.u - paramLong < 0L) {}
    for (i2 = -9;; i2 = -10)
    {
      i1 = i2;
      if (!QLog.isColorLevel()) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i2 + ",xgFloWaste +picSize=" + (this.v + paramLong) + ",xgFlowWasteLimit：" + this.o + ",flowPre:" + this.u + ",picSize:" + paramLong + ",flowWaste:" + this.v + ",uinType:" + paramInt1 + ",networkType:" + paramInt2);
      return i2;
    }
  }
  
  public PredownloadTest.ConfigInfo a()
  {
    PredownloadTest.ConfigInfo localConfigInfo = new PredownloadTest.ConfigInfo();
    localConfigInfo.a = this.o;
    localConfigInfo.b = this.n;
    localConfigInfo.d = this.u;
    localConfigInfo.c = this.v;
    localConfigInfo.e = this.p;
    localConfigInfo.f = this.q;
    return localConfigInfo;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    long l1 = PicPreDownloadUtils.a("xgFlowPre", this.u);
    long l2 = PicPreDownloadUtils.a("xgFlowWaste", this.v);
    long l3 = PicPreDownloadUtils.a("accFlowPreTotal", this.w);
    long l4 = PicPreDownloadUtils.a("xgPreDownCount", this.z);
    long l5 = PicPreDownloadUtils.a("xgHitCount", this.A);
    long l6 = PicPreDownloadUtils.a("xgMissCount", this.B);
    long l7 = PicPreDownloadUtils.a("wifiPreDownCout", this.D);
    long l8 = PicPreDownloadUtils.a("wifiHitCount", this.E);
    long l9 = PicPreDownloadUtils.a("wifiMissCount", this.F);
    long l10 = PicPreDownloadUtils.a("xgManulClickCount", this.C);
    long l11 = PicPreDownloadUtils.a("wifiManulClickCount", this.G);
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- spFlowPre:" + l1 + "\n|-  spFlowWaste：" + l2 + "\n|-  spFlowPreTotal:" + l3 + "\n|-  spXgPreDownCount：" + l4 + "\n|-  spXgHitCount:" + l5 + "\n|-  spXgMissCount：" + l6 + "\n|-  spWifiPreDownCount:" + l7 + "\n|-  spWifiHitCount：" + l8 + "\n|-  spWifiMissCount:" + l9 + "\n|-  spXgManulClickCount：" + l10 + "\n|-  spWifiManulClickCount:" + l11);
    }
    localHashMap.put("xgFlowPre", String.valueOf(l1));
    localHashMap.put("xgFlowWaste", String.valueOf(l2));
    if ((l5 != 0L) || (l6 != 0L) || (l4 != 0L))
    {
      localHashMap.put("accFlowPreTotal", String.valueOf(l3));
      localHashMap.put("xgPreDownCount", String.valueOf(l4));
      localHashMap.put("xgHitCount", String.valueOf(l5));
      localHashMap.put("xgMissCount", String.valueOf(l4 - l5));
      localHashMap.put("xgManulClickCount", String.valueOf(l10));
      localHashMap.put("xgFlowWasteBalance", String.valueOf(this.o - l2));
    }
    localHashMap.put("wifiPreDownCout", String.valueOf(l7));
    localHashMap.put("wifiHitCount", String.valueOf(l8));
    localHashMap.put("wifiMissCount", String.valueOf(l9));
    localHashMap.put("wifiManulClickCount", String.valueOf(l11));
    return localHashMap;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.D += 1L;
      PicPreDownloadUtils.a("wifiPreDownCout", this.D, true);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      this.u -= paramLong;
      this.v += paramLong;
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize:" + paramLong + ",flowPre:" + this.u + ",flowWaste:" + this.v);
      }
      this.w += paramLong;
      this.x = (paramLong + this.x);
      this.z += 1L;
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.v, false);
      PicPreDownloadUtils.a("accFlowPreTotal", this.w, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.x, false);
      PicPreDownloadUtils.a("xgPreDownCount", this.z, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.D + ",xgPreDownCout:" + this.z);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.w + ",accFlowWasteTotal:" + this.x);
  }
  
  public void a(PredownloadTest.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.a != -1L) {
      this.o = paramConfigInfo.a;
    }
    if (paramConfigInfo.b != -1L) {
      this.n = paramConfigInfo.b;
    }
    if (paramConfigInfo.d != -1L)
    {
      this.u = paramConfigInfo.d;
      PicPreDownloadUtils.a("xgFlowPre", this.u, true);
    }
    if (paramConfigInfo.c != -1L)
    {
      this.v = paramConfigInfo.c;
      PicPreDownloadUtils.a("xgFlowWaste", this.v, true);
    }
    if (paramConfigInfo.e != -1L) {
      this.p = paramConfigInfo.e;
    }
    if (paramConfigInfo.f != -1L) {
      this.q = paramConfigInfo.f;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    this.b = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.b.getManager(69));
    this.u = PicPreDownloadUtils.a("xgFlowPre", this.u);
    this.v = PicPreDownloadUtils.a("xgFlowWaste", this.v);
    long l1 = PicPreDownloadUtils.a("lastDayTime", 0L);
    c();
    e();
    if (this.u == -1L) {
      this.u = this.n;
    }
    long l2 = System.currentTimeMillis();
    if (paramQQAppInterface != null) {}
    for (String str = paramQQAppInterface.a();; str = null)
    {
      if (l2 - l1 > 86400000L)
      {
        PicPreDownloadUtils.a("lastDayTime", l2, true);
        PicReporter.a(str, a());
        d();
        PicReporter.b(str, b());
        if (paramQQAppInterface != null) {
          ((PicStatisticsManager)paramQQAppInterface.getManager(69)).a();
        }
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
      }
      return;
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    PicPreDownloadUtils.a(this.b, paramMessageForPic);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if (paramMessageForPic.isSendFromLocal()) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (paramMessageForPic.subVersion < 5);
      i1 = PicPreDownloadUtils.a(this.b, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramMessageForPic.preDownState == 1)
      {
        a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        if (a(i1, paramMessageForPic.preDownNetworkType)[1] == 0)
        {
          d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
          return;
        }
        b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
    } while (paramMessageForPic.preDownState != 4);
    c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    if (PicPreDownloadUtils.a(this.b, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {}
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): Peek Flow is disable[true]");
      return true;
      int i2 = this.jdField_a_of_type_ArrayOfLong.length;
      if ((i2 == 0) || ((i2 & 0x1) != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime():  The length(" + i2 + ") of PeakFlowTimePeriod is error![false]");
        }
        return false;
      }
      int i3 = Calendar.getInstance().get(11);
      int i1 = 0;
      while (i1 < i2)
      {
        if ((i3 >= this.jdField_a_of_type_ArrayOfLong[i1]) && (i3 < this.jdField_a_of_type_ArrayOfLong[(i1 + 1)]) && (paramMessageForPic.size > this.H))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): picSize=" + paramMessageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.H + ")[false]");
          }
          return false;
        }
        i1 += 2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): [true]");
    return true;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i2;
    int i1;
    boolean bool1;
    if ((DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) && (paramInt2 != 3))
    {
      i2 = PicPreDownloadUtils.a(0, paramInt1, 0);
      i1 = PicPreDownloadUtils.a(0, paramInt1, 1);
      if ((this.m >> i2 & 1L) != 1L) {
        break label180;
      }
      bool1 = true;
      label52:
      if ((this.m >> i1 & 1L) != 1L) {
        break label186;
      }
    }
    label180:
    label186:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.m);
      }
      return new boolean[] { bool1, bool2 };
      i2 = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
      i1 = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
      break;
      bool1 = false;
      break label52;
    }
  }
  
  public HashMap b()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    int i1 = ((Calendar)localObject).get(6);
    localObject = new HashMap();
    long l2 = PicPreDownloadUtils.a("accDays", 0L);
    long l3 = PicPreDownloadUtils.a("accFlowPreTotal", this.w);
    long l4 = PicPreDownloadUtils.a("accFlowWasteTotal", this.x);
    long l1 = PicPreDownloadUtils.a("accStartDay", i1);
    ((HashMap)localObject).put("accDays", String.valueOf(l2));
    ((HashMap)localObject).put("accFlowPreTotal", String.valueOf(l3));
    ((HashMap)localObject).put("accFlowWasteTotal", String.valueOf(l4));
    l2 = i1 - l1;
    PicPreDownloadUtils.a("accDays", l2, true);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "" + l2);
    }
    if ((l2 >= 30L) || (l2 < 0L))
    {
      this.w = 0L;
      this.x = 0L;
      PicPreDownloadUtils.a("accStartDay", i1, false);
      PicPreDownloadUtils.a("accDays", 0L, false);
      PicPreDownloadUtils.a("accFlowPreTotal", 0L, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", 0L, true);
    }
    for (;;)
    {
      if (l2 < 0L) {
        localObject = null;
      }
      return localObject;
      if (l1 == i1) {
        PicPreDownloadUtils.a("accStartDay", i1, true);
      }
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      a(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType != 0) {}
    }
    else
    {
      return;
    }
    long l1 = this.s - paramLong;
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter start", "fixSize:" + paramLong + "xgFlowWaste :" + this.v + ",xgFlowPre:" + this.u + ",uniseq:" + paramMessageForPic.uniseq);
    }
    this.v -= l1;
    this.u += l1;
    this.w -= l1;
    this.x -= l1;
    if (this.v < 0L)
    {
      this.v = 0L;
      if (this.u <= this.n) {
        break label402;
      }
      this.u = this.n;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter end", "fixSize:" + paramLong + "xgFlowWaste :" + this.v + ",xgFlowPre:" + this.u + ",detaSize:" + l1 + ",uniseq:" + paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.w + ",accFlowWasteTotal:" + this.x);
      }
      PicPreDownloadUtils.a("xgFlowPre", this.u, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.v, false);
      PicPreDownloadUtils.a("accFlowPreTotal", this.w, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.x, true);
      return;
      if (this.v <= this.o) {
        break;
      }
      this.v = this.o;
      break;
      label402:
      if (this.u < 0L) {
        this.u = 0L;
      }
    }
  }
  
  public void c()
  {
    int i1 = 0;
    this.m = PicPreDownloadUtils.a(this.b, "PicDPy471", 1374942199L);
    this.p = PicPreDownloadUtils.a(this.b, "AFBFlowHit3G", 150L);
    this.q = PicPreDownloadUtils.a(this.b, "AFBFlowMiss3G", 40960L);
    this.r = this.q;
    this.n = PicPreDownloadUtils.a(this.b, "AMaxPDFlow3G", 307200L);
    this.o = PicPreDownloadUtils.a(this.b, "AMaxWFlow3G", 512000L);
    this.s = PicPreDownloadUtils.a(this.b, "APicAvgSize", 71680L);
    this.t = PicPreDownloadUtils.a(this.b, "APicMaxSize", 204800L);
    this.jdField_a_of_type_Boolean = PicPreDownloadUtils.a(this.b, false);
    this.jdField_a_of_type_ArrayOfLong = PicPreDownloadUtils.a(this.b);
    this.H = PicPreDownloadUtils.a(this.b, "APicMaxSize", 921600L);
    int i2;
    if (QLog.isColorLevel())
    {
      i2 = this.jdField_a_of_type_ArrayOfLong.length;
      if ((i2 != 0) && ((i2 & 0x1) == 0)) {
        break label367;
      }
    }
    for (Object localObject = "Error(Length=" + i2 + ")";; localObject = ((StringBuilder)localObject).toString())
    {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getServerConfig(): xGPreDownPolicy=" + this.m + " xgFlowHitFeedback=" + this.p + " XgFlowMissFeedback=" + this.q + " XgFlowLeftRightFeddback=" + this.r + " xgFlowPreLimit=" + this.n + " xgFlowWasteLimit=" + this.o + " pisSizeAvg=" + this.s + " pisSizeMax=" + this.t + " mEnablePeakFlow=" + this.jdField_a_of_type_Boolean + " mPeakFlowTimePeriod=" + (String)localObject + " mPeakFlowMaxPicSize=" + this.H);
      return;
      label367:
      localObject = new StringBuilder();
      while (i1 < i2)
      {
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[i1])).append("-").append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[(i1 + 1)])).append(" ");
        i1 += 2;
      }
    }
  }
  
  public void d()
  {
    this.E = 0L;
    this.F = 0L;
    this.G = 0L;
    this.D = 0L;
    this.v = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.z = 0L;
    PicPreDownloadUtils.a("wifiHitCount", this.E, false);
    PicPreDownloadUtils.a("wifiMissCount", this.F, false);
    PicPreDownloadUtils.a("wifiManulClickCount", this.G, false);
    PicPreDownloadUtils.a("wifiPreDownCout", this.D, false);
    PicPreDownloadUtils.a("xgFlowWaste", this.v, false);
    PicPreDownloadUtils.a("xgHitCount", this.A, false);
    PicPreDownloadUtils.a("xgMissCount", this.B, false);
    PicPreDownloadUtils.a("xgManulClickCount", this.C, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.z, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategyBeta
 * JD-Core Version:    0.7.0.1
 */