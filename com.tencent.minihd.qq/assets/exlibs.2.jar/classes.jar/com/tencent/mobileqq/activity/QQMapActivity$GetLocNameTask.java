package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import org.apache.http.client.HttpClient;

public class QQMapActivity$GetLocNameTask
  extends AsyncTask
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected GeoPoint a;
  protected HttpClient a;
  
  public QQMapActivity$GetLocNameTask(QQMapActivity paramQQMapActivity) {}
  
  public QQMapActivity$GetLocNameTask(QQMapActivity paramQQMapActivity, GeoPoint paramGeoPoint, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = paramGeoPoint;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
  }
  
  protected String a(GeoPoint... paramVarArgs)
  {
    int i = 0;
    if (i < 3)
    {
      if (isCancelled())
      {
        localObject = "";
        label17:
        return localObject;
      }
      paramVarArgs = ReverseGeocode.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (paramVarArgs != null) {
          break label125;
        }
      }
      label125:
      for (Object localObject = "";; localObject = paramVarArgs)
      {
        QLog.i("fetch_address", 2, (String)localObject);
        if (paramVarArgs != null)
        {
          localObject = paramVarArgs;
          if (paramVarArgs.length() > 0) {
            break label17;
          }
        }
        i += 1;
        break;
      }
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("fetch_address", 2, "get address finish, onPostExecute, result:" + paramString);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.jdField_a_of_type_AndroidWidgetTextView.getTag();
      if ((localGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6()) && (localGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6()) && (paramString != null) && (paramString.length() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.k) {
          break label147;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.j.findViewById(2131297913).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.j.findViewById(2131297914).setVisibility(0);
      }
    }
    return;
    label147:
    this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.i = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.GetLocNameTask
 * JD-Core Version:    0.7.0.1
 */