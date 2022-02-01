package cooperation.qzone;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import maz;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneClickReport$ReportRunnable
  implements Runnable
{
  private static final int c = 1;
  private static final int d = 1;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public QZoneClickReport$ReportRunnable(ArrayList paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    Object localObject1;
    try
    {
      localJSONObject.put("count", ((ArrayList)localObject2).size());
      localJSONObject.put("qua", QUA.a());
      localJSONObject.put("device_info", PlatformInfor.a().e());
      localJSONObject.put("uin", this.jdField_a_of_type_Long);
      localJSONArray = new JSONArray();
      localObject2 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localJSONArray.put(((QZoneClickReport.ReportInfo)((Iterator)localObject2).next()).a());
          continue;
          if (localObject1 == null) {
            break;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localObject1 = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = localObject1.toString();
      this.jdField_a_of_type_Boolean = true;
      return;
      localObject1.put("data", localJSONArray);
    }
  }
  
  public void run()
  {
    String str = QzoneConfig.a().a("ReportSetting", "TraceReportURL");
    a();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      try
      {
        label33:
        if (QZoneHttpUtil.a(BaseApplication.getContext(), str, new ByteArrayEntity(QZoneClickReport.a(this.jdField_a_of_type_JavaLangString))).getStatusLine().getStatusCode() == 200)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_b_of_type_Boolean = true;
        }
        while ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int <= 1))
        {
          if (this.jdField_a_of_type_Int <= 1) {
            break label33;
          }
          ThreadManager.b().postDelayed(new maz(this), 300000L);
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Int = 0;
          return;
          this.jdField_a_of_type_Int += 1;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Int += 1;
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneClickReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */