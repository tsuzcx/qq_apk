import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class hum
  implements TencentLocationListener
{
  boolean a = false;
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    boolean bool4;
    String str;
    long l;
    int m;
    boolean bool5;
    Object localObject5;
    Object localObject1;
    label118:
    int i;
    label180:
    boolean bool1;
    Object localObject4;
    Object localObject6;
    if (paramInt == 0)
    {
      bool4 = true;
      com.tencent.mobileqq.app.LBSHandler.D = paramInt;
      str = paramTencentLocation.getExtra().getString("qq_caller");
      l = SystemClock.elapsedRealtime() - SosoInterface.a();
      SosoInterface.a(SystemClock.elapsedRealtime());
      m = paramTencentLocation.getExtra().getInt("qq_level");
      bool5 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      localObject5 = paramTencentLocation.getExtra().getByteArray("raw_data");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onLocationChanged() err=").append(paramInt);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label470;
        }
        localObject1 = "";
        localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" caller=").append(str).append(" level=").append(m).append(" reqLocation=").append(bool5).append(" consume=").append(l).append(" rawData=");
        if (localObject5 != null) {
          break label494;
        }
        i = 0;
        QLog.d("SOSO.LBS", 4, i);
      }
      bool2 = false;
      bool1 = false;
      localObject2 = null;
      localObject4 = null;
      localObject3 = null;
      localObject1 = null;
      localObject6 = SosoInterface.a;
      if ((paramInt == 0) && (!bool5)) {
        break label502;
      }
    }
    label267:
    try
    {
      SosoInterface.a(m, paramTencentLocation);
      label237:
      if (SosoInterface.a().size() <= 0) {
        break label939;
      }
      i = SosoInterface.a().size();
      if (!bool5) {
        break label533;
      }
      localObject5 = SosoInterface.b();
    }
    finally {}
    Object localObject3 = localObject1;
    Object localObject2 = paramTencentLocation;
    boolean bool2 = bool1;
    int j;
    label344:
    label360:
    boolean bool3;
    if (i >= 0)
    {
      int k = 0;
      localObject3 = (SosoInterface.OnLocationListener)SosoInterface.a().get(i);
      j = k;
      if (((SosoInterface.OnLocationListener)localObject3).g == bool5) {
        if (((SosoInterface.OnLocationListener)localObject3).g)
        {
          if (((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int != 1) {
            break label541;
          }
          j = k;
          if (((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int != m) {}
        }
        else
        {
          if (!((SosoInterface.OnLocationListener)localObject3).e) {
            break label558;
          }
          SosoInterface.a((SosoInterface.OnLocationListener)localObject3, paramInt, (SosoInterface.SosoLbsInfo)localObject5);
          ((SosoInterface.OnLocationListener)localObject3).h = true;
          if (!((SosoInterface.OnLocationListener)localObject3).f) {
            break label569;
          }
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString + " goon...");
            j = k;
          }
        }
      }
      label422:
      localObject4 = paramTencentLocation;
      bool3 = bool1;
      if (j != 0) {
        break label1414;
      }
      bool2 = ((SosoInterface.OnLocationListener)localObject3).f;
      if (bool2)
      {
        if (localObject1 == null) {}
        for (localObject1 = localObject3;; localObject1 = localObject3)
        {
          label455:
          i -= 1;
          break label267;
          bool4 = false;
          break;
          label470:
          localObject1 = " reason=" + paramString;
          break label118;
          label494:
          i = localObject5.length;
          break label180;
          label502:
          if ((localObject5 == null) || (localObject5.length <= 0)) {
            break label237;
          }
          SosoInterface.a(paramTencentLocation.getProvider(), (byte[])localObject5);
          break label237;
          label533:
          localObject5 = SosoInterface.a();
          break label1380;
          label541:
          j = k;
          if (((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int > m) {
            break label422;
          }
          break label344;
          label558:
          ((SosoInterface.OnLocationListener)localObject3).a(paramInt, (SosoInterface.SosoLbsInfo)localObject5);
          break label360;
          label569:
          SosoInterface.a().remove(i);
          k = 1;
          j = k;
          if (!QLog.isColorLevel()) {
            break label422;
          }
          QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString + " removed normally.");
          j = k;
          break label422;
          localObject4 = paramTencentLocation;
          bool3 = bool1;
          if (((SosoInterface.OnLocationListener)localObject1).jdField_b_of_type_Int >= ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int) {
            break label1414;
          }
        }
      }
      if (SystemClock.elapsedRealtime() - ((SosoInterface.OnLocationListener)localObject3).d > 30000L)
      {
        SosoInterface.a().remove(i);
        if (((SosoInterface.OnLocationListener)localObject3).g)
        {
          localObject2 = SosoInterface.b();
          break label1392;
          label700:
          ((SosoInterface.OnLocationListener)localObject3).a(j, (SosoInterface.SosoLbsInfo)localObject2);
          if (!QLog.isColorLevel()) {
            break label1405;
          }
          QLog.d("SOSO.LBS", 2, "lis=" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString + " err_timeout.reqRaw=" + ((SosoInterface.OnLocationListener)localObject3).g + " received=" + ((SosoInterface.OnLocationListener)localObject3).h + ". Force 2 remove it.");
          break label1405;
        }
        localObject2 = SosoInterface.a();
        break label1392;
      }
      if (!((SosoInterface.OnLocationListener)localObject3).g) {
        break label1424;
      }
      if (paramTencentLocation == null)
      {
        localObject2 = localObject3;
        bool2 = bool1;
      }
    }
    for (;;)
    {
      localObject4 = localObject2;
      bool3 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString + " goon=" + ((SosoInterface.OnLocationListener)localObject3).f + " reqLocation=" + ((SosoInterface.OnLocationListener)localObject3).g + " received=" + ((SosoInterface.OnLocationListener)localObject3).h + " hasReqRaw=" + bool2);
        localObject4 = localObject2;
        bool3 = bool2;
        break label1414;
        localObject2 = paramTencentLocation;
        bool2 = bool1;
        if (paramTencentLocation.jdField_b_of_type_Int >= ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_Int) {
          continue;
        }
        localObject2 = localObject3;
        bool2 = bool1;
        continue;
        label939:
        SosoInterface.a().set(0);
        if (SosoInterface.a().size() == 0)
        {
          TencentLocationManager.getInstance(BaseApplicationImpl.getContext()).removeUpdates(this);
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 4, "listener is empty. remveUpdate and stop LBS");
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramInt));
          if ((str != null) && (str.length() > 0)) {
            ((HashMap)localObject1).put("param_caller", str);
          }
          if ((paramString != null) && (paramString.length() > 0)) {
            ((HashMap)localObject1).put("param_reason", paramString);
          }
          ((HashMap)localObject1).put("param_useCache", Boolean.toString(Boolean.FALSE.booleanValue()));
          paramString = EarlyDownloadManager.a();
          localObject2 = StatisticCollector.a(BaseApplicationImpl.getContext());
          if (!bool5) {
            break label1373;
          }
        }
        label1175:
        label1373:
        for (paramTencentLocation = "actSosoLocation";; paramTencentLocation = "actSosoRawData")
        {
          ((StatisticCollector)localObject2).a(paramString, paramTencentLocation, bool4, l, 0L, (HashMap)localObject1, "");
          return;
          if (bool2)
          {
            if (localObject3 != null) {
              this.a = true;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("onLocationChanged()");
              if (localObject3 != null) {
                break label1175;
              }
            }
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:reqRawData");
              SosoInterface.a(SosoInterface.a());
              break;
            }
          }
          if (localObject2 != null)
          {
            if (localObject3 != null) {
              this.a = true;
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder().append("onLocationChanged()");
              if (localObject3 != null) {
                break label1284;
              }
            }
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:" + ((SosoInterface.OnLocationListener)localObject2).jdField_b_of_type_JavaLangString);
              SosoInterface.a((SosoInterface.OnLocationListener)localObject2);
              break;
            }
          }
          if ((!this.a) || (localObject3 == null)) {
            break;
          }
          this.a = false;
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "onLocationChanged() goonLis goon:" + ((SosoInterface.OnLocationListener)localObject3).jdField_b_of_type_JavaLangString);
          }
          SosoInterface.a((SosoInterface.OnLocationListener)localObject3);
          break;
        }
        label1284:
        label1380:
        i -= 1;
        paramTencentLocation = (TencentLocation)localObject4;
        break;
        label1392:
        if (localObject2 == null)
        {
          j = -10000;
          break label700;
          label1405:
          break label455;
        }
        j = 0;
        break label700;
      }
      label1414:
      paramTencentLocation = (TencentLocation)localObject4;
      bool1 = bool3;
      break label455;
      label1424:
      bool2 = true;
      localObject2 = paramTencentLocation;
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hum
 * JD-Core Version:    0.7.0.1
 */