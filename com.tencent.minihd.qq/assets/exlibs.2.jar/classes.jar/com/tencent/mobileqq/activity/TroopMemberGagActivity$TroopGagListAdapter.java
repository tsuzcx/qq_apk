package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagItem;
import fis;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopMemberGagActivity$TroopGagListAdapter
  extends BaseAdapter
  implements View.OnClickListener, ListAdapter
{
  private final int jdField_a_of_type_Int = 45;
  Context jdField_a_of_type_AndroidContentContext;
  private TroopMemberGagActivity.GagItemListener jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener;
  private TroopGagMgr jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr;
  public fis a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public TroopMemberGagActivity$TroopGagListAdapter(TroopMemberGagActivity paramTroopMemberGagActivity, ArrayList paramArrayList, TroopMemberGagActivity.GagItemListener paramGagItemListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener = paramGagItemListener;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    if (paramArrayList.hasNext())
    {
      paramGagItemListener = (TroopGagMgr.GagItem)paramArrayList.next();
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(new fis(this, paramGagItemListener, bool));
        i += 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr = ((TroopGagMgr)paramTroopMemberGagActivity.app.getManager(47));
    this.jdField_a_of_type_Fis = new fis(this, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr.a(paramTroopMemberGagActivity.getResources().getString(2131363477), 0), false, true);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Fis);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (!(paramView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.setMargins(paramInt, localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Fis != null)
    {
      this.jdField_a_of_type_Fis.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_JavaLangString = paramString;
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130904490, null);
      paramView = new TroopMemberGagActivity.TroopGagListAdapter.Holder(this);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131299414));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302331));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302332));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302333));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302334));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131302335);
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131302336);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setTag(paramView);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setTag(paramView);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setTag(paramView);
      localView.setTag(paramView);
    }
    paramView = (TroopMemberGagActivity.TroopGagListAdapter.Holder)localView.getTag();
    paramViewGroup = (fis)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_JavaLangString);
    ImageView localImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramViewGroup.jdField_a_of_type_Boolean)
    {
      i = 0;
      localImageView.setVisibility(i);
      paramView.jdField_a_of_type_Fis = ((fis)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      i = (int)TypedValue.applyDimension(1, 45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.getResources().getDisplayMetrics());
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramInt >= getCount() - 1) {
        break label434;
      }
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(4);
      if (paramInt != 0) {
        break label421;
      }
      a(paramView.jdField_a_of_type_AndroidViewView, 0);
      label324:
      if (!paramViewGroup.b) {
        break label466;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_Int <= 0) {
        break label454;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_Int));
      label391:
      localView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.getString(2131363478));
    }
    for (;;)
    {
      localView.setSelected(true);
      return localView;
      i = 8;
      break;
      label421:
      a(paramView.jdField_a_of_type_AndroidViewView, i);
      break label324;
      label434:
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
      a(paramView.jdField_b_of_type_AndroidViewView, 0);
      break label324;
      label454:
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label391;
      label466:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localView.setContentDescription(paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopMemberGagActivity.TroopGagListAdapter.Holder)paramView.getTag();
    if (paramView.jdField_a_of_type_Fis.b)
    {
      paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramView.hasNext()) {
        ((fis)paramView.next()).jdField_a_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagDurationSettingDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagDurationSettingDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagDurationSettingDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagDurationSettingDialog = new TroopMemberGagActivity.TroopGagDurationSettingDialog(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$TroopGagDurationSettingDialog.show();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.app, "P_CliOper", "Grp_manage", "", "silent", "Clk_custom_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity.d), "", "");
      return;
    }
    if ((this.jdField_a_of_type_Fis != null) && (this.jdField_a_of_type_Fis.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem != null)) {
      this.jdField_a_of_type_Fis.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem.jdField_a_of_type_Int = 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      fis localfis = (fis)localIterator.next();
      if (paramView.jdField_a_of_type_Fis == localfis) {
        localfis.jdField_a_of_type_Boolean = true;
      } else {
        localfis.jdField_a_of_type_Boolean = false;
      }
    }
    TroopMemberGagActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberGagActivity$GagItemListener.a(paramView.jdField_a_of_type_Fis.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$GagItem);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberGagActivity.TroopGagListAdapter
 * JD-Core Version:    0.7.0.1
 */