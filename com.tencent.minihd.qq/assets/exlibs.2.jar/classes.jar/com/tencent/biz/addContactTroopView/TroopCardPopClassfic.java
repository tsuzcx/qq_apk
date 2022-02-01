package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import cch;
import cci;
import com.tencent.biz.widgets.GridViewForScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;
import tencent.im.troop_search_popclassifc.popclassifc.TitleBar;
import tencent.im.troop_search_searchtab.searchtab.Card;

public class TroopCardPopClassfic
  extends BaseTroopCardView
  implements View.OnClickListener
{
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new cch(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GridViewForScrollView jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView;
  private popclassifc.PopCard jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard;
  
  public TroopCardPopClassfic(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void a(int paramInt)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.get(paramInt);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localPopItem.str_transfer_url.get());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_hotcal", 0, 0, "", localPopItem.str_desc.get(), "", "");
  }
  
  private void g()
  {
    int i = getResources().getDimensionPixelSize(2131493297);
    setPadding(i, i, i, 0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298528));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView = ((GridViewForScrollView)findViewById(2131298530));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298529));
  }
  
  public void a()
  {
    setContentView(2130903498);
    g();
  }
  
  public void a(searchtab.Card paramCard) {}
  
  public void f()
  {
    super.f();
  }
  
  public void onClick(View paramView)
  {
    try
    {
      a(((cci)paramView.getTag()).a);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard = paramPopCard;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_desc.get());
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_icon_url.get())) {
        break label75;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842115);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
      label75:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.title_bar.str_icon_url.get(), null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */