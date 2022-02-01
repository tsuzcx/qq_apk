package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cbz;
import cca;
import ccc;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Timer;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class TroopCardBanner
  extends BaseTroopCardView
  implements View.OnClickListener
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private popclassifc.BannerCard jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard;
  
  public TroopCardBanner(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private String a()
  {
    try
    {
      Object localObject = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(75);
      if ((localObject != null) && (((AddContactTroopManage)localObject).a() != null) && (((AddContactTroopManage)localObject).a().popRsb != null))
      {
        int i = ((AddContactTroopManage)localObject).a().popRsb.uint32_longitude.get();
        int j = ((AddContactTroopManage)localObject).a().popRsb.uint32_latitude.get();
        localObject = ((AddContactTroopManage)localObject).a().popRsb.str_city_id.get();
        localObject = "lon=" + String.valueOf(i) + "&lat=" + String.valueOf(j) + "&city=" + (String)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if ((paramInt <= 0) || (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() <= 1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopView", 2, "startTimerInterval");
    }
    h();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    cca localcca = new cca(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localcca, paramInt, paramInt);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    if (paramBoolean)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size())
      {
        ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        int j = Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
          localImageView.setImageResource(2130837557);
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localImageView);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
          i += 1;
          break;
          localImageView.setImageResource(2130837558);
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298505));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131298504));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new ccc(this, null));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new cbz(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void a()
  {
    setContentView(2130903492);
    g();
  }
  
  public void a(searchtab.Card paramCard) {}
  
  public void c()
  {
    super.c();
    a(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.uint32_slid_interval.get() * 1000);
  }
  
  public void d()
  {
    super.d();
    h();
  }
  
  public void f()
  {
    super.f();
    h();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject;
    if (i >= 0)
    {
      paramView = (popclassifc.BannerItem)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(i);
      if (paramView != null)
      {
        localObject = paramView.str_transfer_url.get();
        paramView = (View)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramView = a();
          if (!((String)localObject).contains("?")) {
            break label157;
          }
        }
      }
    }
    label157:
    for (paramView = (String)localObject + "&" + paramView;; paramView = (String)localObject + "?" + paramView)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
      return;
    }
  }
  
  public void setData(popclassifc.BannerCard paramBannerCard)
  {
    boolean bool = true;
    this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard = paramBannerCard;
    if ((this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 0)) {
      if (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() <= 1) {
        break label71;
      }
    }
    for (;;)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new ccc(this, null));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
      return;
      label71:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */