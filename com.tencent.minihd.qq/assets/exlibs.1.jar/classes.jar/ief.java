import android.text.TextUtils;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class ief
  extends SosoInterface.OnLocationListener
{
  public ief(PublicDatingActivity paramPublicDatingActivity, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.dating", 4, "publish dating onLocationFinish() errCode=" + paramInt);
    }
    PublicDatingActivity.b(this.a, false);
    PublishDatingOption localPublishDatingOption = (PublishDatingOption)PublicDatingActivity.a(this.a).get(Integer.valueOf(5));
    if ((localPublishDatingOption == null) || (localPublishDatingOption.depLocalState != 0)) {}
    for (;;)
    {
      return;
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramInt == 0))
      {
        appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
        if (!TextUtils.isEmpty(paramSosoLbsInfo.a.jdField_c_of_type_JavaLangString)) {
          localLocaleInfo.str_country.set(paramSosoLbsInfo.a.jdField_c_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramSosoLbsInfo.a.d)) {
          localLocaleInfo.str_region.set(paramSosoLbsInfo.a.d);
        }
        if (!TextUtils.isEmpty(paramSosoLbsInfo.a.e)) {
          localLocaleInfo.str_city.set(paramSosoLbsInfo.a.e);
        }
        if (!TextUtils.isEmpty(paramSosoLbsInfo.a.f)) {
          localLocaleInfo.str_region.set(paramSosoLbsInfo.a.f);
        }
        if ((paramSosoLbsInfo.a.a != 0.0D) && (paramSosoLbsInfo.a.b != 0.0D))
        {
          appoint_define.GPS localGPS = new appoint_define.GPS();
          localGPS.int32_alt.set((int)(paramSosoLbsInfo.a.jdField_c_of_type_Double * 1000000.0D));
          localGPS.int32_lat.set((int)(paramSosoLbsInfo.a.a * 1000000.0D));
          localGPS.int32_lon.set((int)(paramSosoLbsInfo.a.b * 1000000.0D));
          PBInt32Field localPBInt32Field = localGPS.int32_type;
          paramInt = i;
          if ("network".equalsIgnoreCase(paramSosoLbsInfo.b)) {
            paramInt = 1;
          }
          localPBInt32Field.set(paramInt);
          localLocaleInfo.msg_gps.set(localGPS);
        }
        localPublishDatingOption.depLocal = localLocaleInfo;
      }
      for (localPublishDatingOption.depLocalState = 1; PublicDatingActivity.c(this.a) == 5; localPublishDatingOption.depLocalState = -1)
      {
        PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ief
 * JD-Core Version:    0.7.0.1
 */