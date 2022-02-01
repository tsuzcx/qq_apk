package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import fll;
import flm;
import fln;
import flo;
import flp;
import flq;
import flr;
import fls;
import flt;
import flu;
import flv;
import flw;
import flx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public Dialog a;
  public View a;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new flu(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new flv(this);
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public flw a;
  public ArrayList a;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public UncommonlyUsedContactsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a()
  {
    setContentView(2130903861);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296742));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131493322);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298649));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298897));
    View localView = LayoutInflater.from(getActivity()).inflate(2130904390, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    localView.findViewById(2131299461).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localView.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription("搜索栏");
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(localView);
    this.jdField_a_of_type_Flw = new flw(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Flw);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(new fll(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296488);
    this.b = ((TextView)findViewById(2131297348));
    this.b.setText(getString(2131369895));
    this.c = ((TextView)findViewById(2131297357));
    this.d = ((TextView)findViewById(2131297360));
    this.c.setText(2131366374);
    this.d.setVisibility(0);
    this.d.setText(2131369090);
    this.b.setContentDescription(getString(2131369895));
    this.d.setContentDescription(getString(2131369090) + " 按钮");
    this.c.setContentDescription(getString(2131366374) + " 按钮");
    this.c.setOnClickListener(new flo(this));
    this.d.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    do
    {
      return;
      paramInt -= 1;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_Flw.getItem(paramInt);
    } while (!(localObject1 instanceof UncommonlyUsedContactsActivity.ListItem));
    Object localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (paramInt + 1 < this.jdField_a_of_type_Flw.getCount())
    {
      if (((UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_Flw.getItem(paramInt + 1)).c != 0) {
        break label217;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
      if (localObject2 != null)
      {
        paramInt = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramInt >= this.jdField_a_of_type_Int) {
          break label209;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label258;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      label209:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break;
      label217:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    label258:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void c()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    ConcurrentHashMap localConcurrentHashMap = localFriendsManager.b();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = localConcurrentHashMap.keySet();
    int i;
    label111:
    Friends localFriends;
    Object localObject2;
    Object localObject3;
    if ((localFriendsManager != null) && (localObject1 != null) && (((Set)localObject1).size() > 0))
    {
      Iterator localIterator = ((Set)localObject1).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ArrayList localArrayList2 = (ArrayList)localConcurrentHashMap.get((String)localIterator.next());
          localObject1 = "";
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
          {
            i = 0;
            if (i < localArrayList2.size())
            {
              localFriends = (Friends)localArrayList2.get(i);
              localObject2 = localObject1;
              if (i == 0)
              {
                if (localFriendsManager == null) {
                  break label322;
                }
                localObject3 = localFriendsManager.a();
                label152:
                localObject2 = localObject1;
                if (localObject3 != null)
                {
                  localObject2 = localObject1;
                  if (((List)localObject3).size() > 0)
                  {
                    localObject3 = ((List)localObject3).iterator();
                    label180:
                    localObject2 = localObject1;
                    if (((Iterator)localObject3).hasNext())
                    {
                      localObject2 = (Groups)((Iterator)localObject3).next();
                      if (((Groups)localObject2).group_id != localFriends.groupid) {
                        break label328;
                      }
                      localObject1 = ((Groups)localObject2).group_name + "(" + localArrayList2.size() + ")";
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label322:
    label328:
    for (;;)
    {
      break label180;
      localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
      ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
      localArrayList1.add(localObject1);
      localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 1, localFriends);
      ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
      localArrayList1.add(localObject1);
      i += 1;
      localObject1 = localObject2;
      break label111;
      break;
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      return;
      localObject3 = null;
      break label152;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    long l = System.currentTimeMillis();
    Contacts.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_AndroidAppDialog = new flp(this, getActivity(), this.app, paramInt, 8, paramInt);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    paramInt = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new flq(this, l));
    localTranslateAnimation2.setAnimationListener(new flr(this, paramInt));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new fls(this, paramInt, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation1);
    ThreadPriorityManager.a(true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, this.jdField_a_of_type_AndroidViewView.getHeight(), 0, paramInt2);
  }
  
  void a(UncommonlyUsedContactsActivity.ListItem paramListItem)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131366330), 0, false, false);
    localActionSheet.a(getString(2131369896), 0, false, false);
    localActionSheet.a(getString(2131369897), 0, false, false);
    localActionSheet.a(getString(2131369898), 3, false, false);
    if (paramListItem.jdField_a_of_type_ComTencentMobileqqDataFriends == null) {
      return;
    }
    localActionSheet.a(new flt(this, paramListItem.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, localActionSheet));
    localActionSheet.e(2131365736);
    localActionSheet.show();
  }
  
  public void a(String paramString)
  {
    DialogUtil.a(getActivity(), 230).setTitle(getString(2131367048)).setMessage(getString(2131367057)).setPositiveButton(2131365959, new fln(this, paramString)).setNegativeButton(2131366375, new flm(this)).show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (this.jdField_a_of_type_Flw != null) {
      this.jdField_a_of_type_Flw.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", 3);
    startActivity(localIntent);
    super.finish();
    overridePendingTransition(2130968589, 2130968591);
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (flx)paramView.getTag();
    }
    try
    {
      paramView = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int);
      if (paramView == null)
      {
        return;
        a(0);
        ReportController.b(this.app, "CliOper", "", "", "0X8004C4F", "0X8004C4F", 0, 0, "", "", "", "");
        return;
        startActivity(new Intent(getActivity(), SettingUncommUsedContactsActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
      }
      a(paramView);
      ReportController.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */