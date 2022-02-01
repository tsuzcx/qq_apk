package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyRecommendTroop;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import java.util.List;
import kcw;
import kcx;

public class NearbyRecommendView
  extends NearbyTroopsBaseView
  implements View.OnClickListener
{
  public static final int a = 105;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public SlideDetectListView a;
  public List a;
  public kcx a;
  protected boolean a;
  public RelativeLayout b;
  private boolean d = false;
  
  public NearbyRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean a(Intent paramIntent)
  {
    a(2130903529);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298657));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298660));
    ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298662)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298658));
    this.b = ((RelativeLayout)findViewById(2131298659));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_Kcx = new kcx(this, a(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_Kcx.a(54, 54);
    paramIntent = paramIntent.getStringExtra("config_res_plugin_item_name");
    if (!TextUtils.isEmpty(paramIntent)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(paramIntent);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(2131365804, -1);
    }
  }
  
  private boolean c()
  {
    EntityManager localEntityManager = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject2;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (NearbyRecommendTroop)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((NearbyRecommendTroop)localObject2).isRead)
        {
          ((NearbyRecommendTroop)localObject2).isRead = true;
          localArrayList.add(localObject2);
        }
        i += 1;
      }
      if (!localArrayList.isEmpty()) {
        try
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
          if ((localObject2 instanceof BrowserAppInterface)) {
            localEntityManager = ((BrowserAppInterface)localObject2).a(null).createEntityManager();
          }
          for (;;)
          {
            if (localEntityManager != null)
            {
              localObject2 = localEntityManager.a();
              ((EntityTransaction)localObject2).a();
              try
              {
                int j = localArrayList.size();
                i = 0;
                for (;;)
                {
                  if (i < j)
                  {
                    localEntityManager.a((Entity)localArrayList.get(i));
                    i += 1;
                    continue;
                    if (!(localObject2 instanceof QQAppInterface)) {
                      break;
                    }
                    localEntityManager = ((QQAppInterface)localObject2).a().createEntityManager();
                    break;
                  }
                }
                ((EntityTransaction)localObject2).c();
                return true;
              }
              finally
              {
                ((EntityTransaction)localObject2).b();
              }
            }
          }
          return false;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected List a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
        if ((localObject1 instanceof BrowserAppInterface))
        {
          localObject1 = ((BrowserAppInterface)localObject1).a(null).createEntityManager();
          if (localObject1 != null)
          {
            List localList = ((EntityManager)localObject1).a(NearbyRecommendTroop.class, false, null, new String[0], null, null, null, null);
            ((EntityManager)localObject1).a();
            return localList;
          }
        }
        else
        {
          if (!(localObject1 instanceof QQAppInterface)) {
            break label90;
          }
          localObject1 = ((QQAppInterface)localObject1).a().createEntityManager();
          continue;
        }
        return new ArrayList();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label90:
      Object localObject2 = null;
    }
  }
  
  protected void a()
  {
    GroupCatalogTool.a(a()).a();
    if (this.jdField_a_of_type_Kcx != null) {
      this.jdField_a_of_type_Kcx.e();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent, NearbyTroopsBaseView.INearbyTroopContext paramINearbyTroopContext)
  {
    super.a(paramIntent, paramINearbyTroopContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramIntent);
  }
  
  public void a(NearbyRecommendTroop paramNearbyRecommendTroop)
  {
    if (paramNearbyRecommendTroop == null) {
      return;
    }
    Object localObject = TroopUtils.a(19, paramNearbyRecommendTroop, 0);
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), (Bundle)localObject, 2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    String str = paramNearbyRecommendTroop.uin;
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a();
    if (paramNearbyRecommendTroop.isRead) {}
    for (paramNearbyRecommendTroop = "1";; paramNearbyRecommendTroop = "0")
    {
      ReportController.b((QQAppInterface)localObject, "P_CliOper", "Grp_nearby", "", "recom", "Clk_data", 0, 0, str, String.valueOf(i), paramNearbyRecommendTroop, "");
      return;
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      f();
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.b();
    f();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
  }
  
  protected void c()
  {
    super.c();
    f();
  }
  
  protected void e()
  {
    super.e();
    c();
  }
  
  public void f()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    List localList = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(new kcw(this, localList));
    this.d = false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131298662) {
      AddContactsActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.NearbyRecommendView
 * JD-Core Version:    0.7.0.1
 */