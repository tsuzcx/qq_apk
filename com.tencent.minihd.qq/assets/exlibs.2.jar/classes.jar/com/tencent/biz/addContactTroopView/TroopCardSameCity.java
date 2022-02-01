package com.tencent.biz.addContactTroopView;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ccj;
import cck;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardSameCity
  extends BaseTroopCardView
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new cck(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ListViewForListview jdField_a_of_type_ComTencentBizWidgetsListViewForListview;
  private List jdField_a_of_type_JavaUtilList;
  private searchtab.Card jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card;
  private TextView b;
  
  public TroopCardSameCity(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void g()
  {
    int i = getResources().getDimensionPixelSize(2131493297);
    setPadding(i, i, i, 0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298507));
    this.b = ((TextView)findViewById(2131298511));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298510);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298508));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)findViewById(2131298509));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
  }
  
  private void h() {}
  
  private void i()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void j()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.b.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get());
    this.b.setOnClickListener(new ccj(this));
  }
  
  public void a()
  {
    super.a();
    setContentView(2130903495);
    g();
    h();
  }
  
  public void a(searchtab.Card paramCard)
  {
    if (paramCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card = paramCard;
      this.jdField_a_of_type_JavaUtilList = paramCard.rpt_item2.get();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get());
      if (!TextUtils.isEmpty(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get())) {
        break label112;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842114);
      if ((!TextUtils.isEmpty(paramCard.str_transfer_desc.get())) && (!TextUtils.isEmpty(paramCard.str_transfer_url.get()))) {
        break label145;
      }
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
      label112:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get(), null));
      break;
      label145:
      j();
    }
  }
  
  public void f()
  {
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardSameCity
 * JD-Core Version:    0.7.0.1
 */