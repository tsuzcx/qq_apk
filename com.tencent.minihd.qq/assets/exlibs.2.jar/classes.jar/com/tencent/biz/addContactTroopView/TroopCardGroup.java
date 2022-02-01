package com.tencent.biz.addContactTroopView;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import ccd;
import cce;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardGroup
  extends BaseTroopCardView
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private cce jdField_a_of_type_Cce;
  private ListViewForListview jdField_a_of_type_ComTencentBizWidgetsListViewForListview;
  private List jdField_a_of_type_JavaUtilList;
  private searchtab.Card jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card;
  private TextView b;
  
  public TroopCardGroup(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void a(searchtab.Item1 paramItem1)
  {
    if (paramItem1 == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramItem1.str_transfer_url.get()))
      {
        String str = paramItem1.str_transfer_url.get();
        if (this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get().contains("附近")) {
          paramItem1 = str + "&jump_from_group_search=" + String.valueOf(20);
        }
        for (;;)
        {
          a(paramItem1);
          return;
          paramItem1 = str;
          if (this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get().contains("推荐")) {
            paramItem1 = str + "&jump_from_group_search=" + String.valueOf(21);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopCardGroup", 2, "goto groupInfoCard scheme is empty");
  }
  
  private void g()
  {
    int i = getResources().getDimensionPixelSize(2131493297);
    setPadding(i, i, i, 0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298511));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298510);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298507));
    this.b = ((TextView)findViewById(2131298508));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)findViewById(2131298509));
    this.jdField_a_of_type_Cce = new cce(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview);
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.jdField_a_of_type_Cce);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ccd(this));
  }
  
  public void a()
  {
    setContentView(2130903493);
    g();
  }
  
  public void a(searchtab.Card paramCard)
  {
    if (paramCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card = paramCard;
      this.jdField_a_of_type_JavaUtilList = ((searchtab.Card)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.get()).rpt_item1.get();
      this.b.setText(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_desc.get());
      if (!TextUtils.isEmpty(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get())) {
        break label133;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842114);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get())) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_url.get()))) {
        break label166;
      }
      h();
    }
    for (;;)
    {
      this.jdField_a_of_type_Cce.notifyDataSetChanged();
      return;
      label133:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get(), null));
      break;
      label166:
      i();
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (searchtab.Item1)this.jdField_a_of_type_JavaUtilList.get(i);
    if (!TextUtils.isEmpty(paramView.str_oper_transfer_url.get())) {
      a(paramView.str_oper_transfer_url.get());
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, String.valueOf(paramView.uint64_group_code.get()), this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get(), "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopCardGroup", 2, "join group scheme is empty");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup
 * JD-Core Version:    0.7.0.1
 */