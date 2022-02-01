package com.tencent.mobileqq.troop.activity;

import NearbyGroup.GroupInfo;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FavOpenTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyOpenTroop;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import kct;
import kcu;

public class FavOpenTroopActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, SlideDetectListView.OnSlideListener
{
  static final int a = 3000;
  public static final String a = "FavOpenTroopActivity";
  public View.OnClickListener a;
  public FriendListObserver a;
  public FavOpenTroopActivity.TroopAdapter a;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  public ArrayList a;
  public int b = -1;
  
  public FavOpenTroopActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new kct(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new kcu(this);
  }
  
  View a()
  {
    View localView = getLayoutInflater().inflate(2130903517, null);
    FavOpenTroopActivity.CustomViewHolder localCustomViewHolder = new FavOpenTroopActivity.CustomViewHolder();
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298599));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297661));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298602));
    localCustomViewHolder.c = ((TextView)localView.findViewById(2131298603));
    localCustomViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298601));
    localCustomViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)localView.findViewById(2131298597));
    localCustomViewHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131298598));
    localView.setTag(localCustomViewHolder);
    return localView;
  }
  
  public CharSequence a(FavOpenTroopInfo paramFavOpenTroopInfo)
  {
    if (TextUtils.isEmpty(paramFavOpenTroopInfo.troopLocation)) {
      return "";
    }
    paramFavOpenTroopInfo = new SpannableString("[icon]" + " " + paramFavOpenTroopInfo.troopLocation);
    paramFavOpenTroopInfo.setSpan(new ImageSpan(this, 2130842113, 1), 0, "[icon]".length(), 17);
    return paramFavOpenTroopInfo;
  }
  
  public void a()
  {
    setTitle(getString(2131363253));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298596));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837687);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityFavOpenTroopActivity$TroopAdapter = new FavOpenTroopActivity.TroopAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityFavOpenTroopActivity$TroopAdapter);
  }
  
  public void a(int paramInt)
  {
    FavOpenTroopInfo localFavOpenTroopInfo = (FavOpenTroopInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localFavOpenTroopInfo == null) {
      return;
    }
    NearbyOpenTroop localNearbyOpenTroop = new NearbyOpenTroop(localFavOpenTroopInfo.troopCode, localFavOpenTroopInfo.troopName, this, (QQAppInterface)getAppRuntime(), getTitleBarHeight());
    try
    {
      paramInt = Integer.valueOf(localFavOpenTroopInfo.troopCode).intValue();
      localNearbyOpenTroop.a(new GroupInfo(paramInt, localFavOpenTroopInfo.troopName, localFavOpenTroopInfo.troopLocation, localFavOpenTroopInfo.troopMemberNum, localFavOpenTroopInfo.troopIntro, localFavOpenTroopInfo.troopFace, false, localFavOpenTroopInfo.troopDistance, localFavOpenTroopInfo.troopMemberNum, 0L, 0, 0, 0L, 0L, 0L, false, 0L, 0L, null), 2);
      ReportController.b(this.app, "CliOper", "", "", "Open_group", "Clk_open_group", 54, 0, localFavOpenTroopInfo.troopCode, "", "", "");
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
  }
  
  void a(View paramView, FavOpenTroopInfo paramFavOpenTroopInfo)
  {
    paramView = (FavOpenTroopActivity.CustomViewHolder)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.app.a(String.valueOf(paramFavOpenTroopInfo.troopCode), (byte)3, false, false));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramFavOpenTroopInfo.troopName);
    paramView.c.setText(paramFavOpenTroopInfo.troopIntro);
    paramView.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramFavOpenTroopInfo));
    paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    this.b = paramInt;
    paramSlideDetectListView = paramView.findViewById(2131298597);
    if (paramSlideDetectListView != null)
    {
      ((Button)paramSlideDetectListView.findViewById(2131298598)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ShaderAnimLayout)paramSlideDetectListView).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaWidth(paramSlideDetectListView.getLayoutParams().width);
    }
  }
  
  void b()
  {
    startTitleProgress();
    c();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityFavOpenTroopActivity$TroopAdapter.notifyDataSetChanged();
    }
    stopTitleProgress();
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    this.b = -1;
    paramSlideDetectListView = paramView.findViewById(2131298597);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).d();
      ((Button)paramSlideDetectListView.findViewById(2131298598)).setOnClickListener(null);
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = ((FriendManager)this.app.getManager(8)).d();
    if (localArrayList == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        if ((FavOpenTroopInfo)localArrayList.get(i) != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localArrayList.get(i));
          ReportController.b(this.app, "CliOper", "", "", "Open_group", "Open_group_exp", 54, 0, "", "", "", "");
        }
        i -= 1;
      }
    }
  }
  
  public void d()
  {
    if (this.b >= 0)
    {
      FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
      if (localFriendManager != null) {
        localFriendManager.h(((FavOpenTroopInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.b)).troopCode);
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.b);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityFavOpenTroopActivity$TroopAdapter.notifyDataSetChanged();
      this.b = -1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentViewNoBackground(2130903516);
    if ((getAppRuntime() instanceof QQAppInterface)) {
      paramBundle = (QQAppInterface)getAppRuntime();
    }
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b();
  }
  
  protected void onDestroy()
  {
    stopTitleProgress();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.FavOpenTroopActivity
 * JD-Core Version:    0.7.0.1
 */