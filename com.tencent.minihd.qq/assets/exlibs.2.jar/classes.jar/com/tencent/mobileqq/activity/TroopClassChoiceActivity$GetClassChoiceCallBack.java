package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import fgk;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopClassChoiceActivity$GetClassChoiceCallBack
  implements HttpCgiAsyncTask.Callback
{
  protected TroopClassChoiceActivity$GetClassChoiceCallBack(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, paramException.getMessage());
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "result " + paramJSONObject);
    }
    try
    {
      paramJSONObject = (InputStream)paramJSONObject.get("content");
      if ((paramJSONObject != null) && (GroupCatalogTool.a(this.a).a(this.a, paramJSONObject)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = GroupCatalogTool.a(this.a).b(this.a, TroopClassChoiceActivity.a(this.a));
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
          this.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a).a();
        }
        for (;;)
        {
          this.a.runOnUiThread(new fgk(this));
          GroupCatalogTool.a(this.a).a(this.a, System.currentTimeMillis());
          boolean bool = GroupCatalogTool.a(this.a).a(this.a);
          if ((bool) || (!QLog.isColorLevel())) {
            break;
          }
          QLog.d("IphoneTitleBarActivity", 2, "isMoveSuccess " + bool);
          return;
          this.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a).a(this.a.jdField_a_of_type_JavaLangString);
          if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramJSONObject = (GroupCatalogBean)this.a.jdField_a_of_type_JavaUtilArrayList.get(0);
            if (paramJSONObject.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
              this.a.setTitle(paramJSONObject.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_JavaLangString);
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack
 * JD-Core Version:    0.7.0.1
 */