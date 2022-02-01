package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class NearbyTroopsView$UIHandler
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public NearbyTroopsView$UIHandler(NearbyTroopsView paramNearbyTroopsView1, NearbyTroopsView paramNearbyTroopsView2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyTroopsView2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    Object localObject = (NearbyTroopsView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              int k;
              int m;
              do
              {
                return;
                switch (paramMessage.what)
                {
                case 5: 
                default: 
                  return;
                case 1: 
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.D != 0) {
                    i = 4;
                  }
                  ((NearbyTroopsView)localObject).a(false, i, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.D);
                  return;
                case 3: 
                  NearbyTroopsView.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, true);
                  ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
                  ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
                  return;
                case 2: 
                  NearbyTroopsView.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, true);
                  ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
                  ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.B();
                  this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidContentContext.getString(2131367328));
                  if (((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d)
                  {
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.notifyDataSetChanged();
                  }
                  i = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.getResources().getDimensionPixelOffset(2131493040);
                  this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_e_of_type_AndroidViewView.setVisibility(0);
                  this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
                  this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView));
                  this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.setSelectionFromTop(0, -i);
                  return;
                case 4: 
                  paramMessage = paramMessage.getData();
                  i = (int)paramMessage.getLong("index", 0L);
                  j = (int)paramMessage.getLong("count", 0L);
                  k = paramMessage.getInt("lat", 0);
                  m = paramMessage.getInt("lon", 0);
                  paramMessage = paramMessage.getString("name");
                }
              } while ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (TextUtils.isEmpty(paramMessage)));
              this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramMessage, k, m, i, j);
              return;
              ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
              ((NearbyTroopsView)localObject).m();
              return;
              this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(false);
              return;
            } while ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().isFinishing()) || ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.g != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.g.getVisibility() == 0)));
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView);
            localObject = paramMessage.getData();
          } while ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout == null));
          paramMessage = ((Bundle)localObject).getString("classify_json_data");
          long l = ((Bundle)localObject).getLong("last_modify");
          try
          {
            localObject = new JSONObject(paramMessage);
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout, (JSONObject)localObject);
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, paramMessage);
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().getSharedPreferences("nearby_group_classify_sp", 0).edit();
            paramMessage.putLong("nearby_group_classify_last_modify_time", l);
            paramMessage.commit();
            return;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("NearbyTroopsActivity", 2, "MSG_REQUEST_CLASSIFY_DATA_SUCCESS ==>Exception:" + paramMessage.toString());
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().isFinishing());
      NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.c == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.c.setVisibility(8);
    return;
    NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, 0, (Bitmap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler
 * JD-Core Version:    0.7.0.1
 */