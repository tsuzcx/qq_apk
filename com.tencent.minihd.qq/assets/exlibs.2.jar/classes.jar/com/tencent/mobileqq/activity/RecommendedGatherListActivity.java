package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import ewd;
import ewe;
import ewf;
import ewg;
import ewh;
import ewi;
import ewj;
import ewk;
import ewl;
import ewm;
import ewn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RecommendedGatherListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "actionFromQQSetting";
  private static final String jdField_b_of_type_JavaLangString = "RecommendedGatherListActivity";
  int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public View a;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ewd(this);
  private FPSPinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView;
  public QQProgressDialog a;
  public ewn a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  public View c;
  private TextView c;
  View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public View e;
  private TextView e;
  
  private void a(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (ewk)this.jdField_b_of_type_JavaUtilArrayList.get(i);
    Object localObject = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramView.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ewl localewl = (ewl)((Iterator)localObject).next();
        if (paramView.jdField_a_of_type_Boolean)
        {
          if (localewl.jdField_a_of_type_Boolean == true)
          {
            localewl.jdField_a_of_type_Boolean = false;
            this.jdField_a_of_type_JavaUtilList.remove(localewl.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
            this.jdField_a_of_type_JavaUtilHashSet.add(localewl.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
        }
        else if (!localewl.jdField_a_of_type_Boolean)
        {
          localewl.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilList.add(localewl.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          this.jdField_a_of_type_JavaUtilHashSet.remove(localewl.jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
        }
      }
    }
    if (paramView.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369885));
      if (paramView.jdField_a_of_type_Boolean) {
        break label310;
      }
    }
    label310:
    for (boolean bool = true;; bool = false)
    {
      paramView.jdField_a_of_type_Boolean = bool;
      g();
      this.jdField_a_of_type_Ewn.notifyDataSetChanged();
      ReportController.b(this.app, "CliOper", "", "", "0X8004F49", "0X8004F49", 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_JavaUtilList.size() != this.jdField_b_of_type_Int)) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369886));
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_b_of_type_Int = 0;
    ArrayList localArrayList2 = this.jdField_b_of_type_JavaUtilArrayList;
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    ArrayList localArrayList3 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(49);
    ConcurrentHashMap localConcurrentHashMap2 = localFriendsManager.a();
    Object localObject1 = localConcurrentHashMap2.keySet();
    if ((localFriendsManager != null) && (localObject1 != null) && (((Set)localObject1).size() > 0)) {
      if (localFriendsManager == null) {
        break label487;
      }
    }
    label314:
    label484:
    label487:
    for (ArrayList localArrayList1 = localFriendsManager.a();; localArrayList1 = null)
    {
      localObject1 = ((Set)localObject1).iterator();
      int i = 0;
      String str;
      Object localObject3;
      Object localObject2;
      Object localObject4;
      int j;
      if (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localObject3 = (ArrayList)localConcurrentHashMap2.get(str);
        if (localObject3 == null) {
          break label484;
        }
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = new ewl(this, (Friends)((Iterator)localObject3).next());
          if (paramBoolean)
          {
            ((ewl)localObject4).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_JavaUtilList.add(((ewl)localObject4).jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
          for (;;)
          {
            ((ArrayList)localObject2).add(localObject4);
            this.jdField_b_of_type_Int += 1;
            break;
            if ((this.jdField_a_of_type_JavaUtilList.contains(((ewl)localObject4).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) || (!this.jdField_a_of_type_JavaUtilHashSet.contains(((ewl)localObject4).jdField_a_of_type_ComTencentMobileqqDataFriends.uin))) {
              ((ewl)localObject4).jdField_a_of_type_Boolean = true;
            }
          }
        }
        localConcurrentHashMap1.put(str, localObject2);
        if (localArrayList1 == null) {
          break label484;
        }
        j = 0;
        if (j >= localArrayList1.size()) {
          break label484;
        }
        localObject2 = (Groups)localArrayList1.get(j);
        if (((Groups)localObject2).group_id == Integer.valueOf(str).intValue())
        {
          localObject2 = new ewk(this, ((Groups)localObject2).group_id, ((Groups)localObject2).group_name, i);
          if (paramBoolean)
          {
            ((ewk)localObject2).jdField_a_of_type_Boolean = true;
            break label407;
            localArrayList3.add(localObject2);
            i += 1;
          }
        }
      }
      for (;;)
      {
        break;
        localObject3 = localArrayList2.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label385;
        }
        localObject4 = (ewk)((Iterator)localObject3).next();
        if (!((ewk)localObject4).jdField_a_of_type_JavaLangString.equals(str)) {
          break label384;
        }
        ((ewk)localObject2).jdField_a_of_type_Boolean = ((ewk)localObject4).jdField_a_of_type_Boolean;
        break label385;
        j += 1;
        break label314;
        localFriendsManager.b(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = localConcurrentHashMap1;
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList3;
        return;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    float f1 = this.jdField_d_of_type_AndroidViewView.getHeight();
    FrameLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.requestLayout();
    }
    float f2;
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        break label172;
      }
      f2 = f1;
      label65:
      if (!paramBoolean) {
        break label177;
      }
    }
    label172:
    label177:
    for (float f3 = 0.0F;; f3 = f1)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f2, f3);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ewe(this, paramBoolean, f1));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      if ((f1 != 0.0F) || (!paramBoolean)) {
        break label183;
      }
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.getLayoutParams();
      localLayoutParams.bottomMargin = 100;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.requestLayout();
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      break;
      f2 = 0.0F;
      break label65;
    }
    label183:
    this.jdField_d_of_type_AndroidViewView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  private void c()
  {
    setContentView(2130903855);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299834);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131299838);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131299836);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131493322);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131299832);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131299833));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297348));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131369884));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297357));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297358));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297360));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369886));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)findViewById(2131298897));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setSelector(2131427375);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(getResources().getDrawable(2130838167));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298649));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299840));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    startTitleProgress();
    a(true);
    Object localObject = LayoutInflater.from(getActivity()).inflate(2130903856, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView, false);
    this.jdField_e_of_type_AndroidViewView = ((View)localObject).findViewById(2131299841);
    this.jdField_e_of_type_AndroidViewView.setContentDescription("查看已经收起的不常联系好友");
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131299847)).setText("查看已经收起的不常联系好友");
    ((TextView)((View)localObject).findViewById(2131299842)).setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a((View)localObject);
    this.jdField_a_of_type_Ewn = new ewn(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Ewn);
    a(this);
    localObject = (FriendListHandler)this.app.a(1);
    SharedPreferences localSharedPreferences = this.app.a().getSharedPreferences(this.app.getAccount(), 0);
    if (localSharedPreferences.getBoolean("hasMsgBox", false))
    {
      localSharedPreferences.edit().putBoolean("hasMsgBox", false).commit();
      ((FriendListHandler)localObject).a(true, this.app.getAccount(), 4);
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().size() == 0))
    {
      if (!NetworkUtil.e(this))
      {
        QQToast.a(this, getString(2131365943), 0).b(getTitleBarHeight());
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getString(2131369894));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131369892));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131369893));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131369888));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369884));
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369885));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (!NetworkUtil.e(this)) {
        break label729;
      }
      ((FriendListHandler)localObject).e(false);
    }
    for (;;)
    {
      e();
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("actionFromQQSetting", false);
      return;
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      break;
      label729:
      stopTitleProgress();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      ((FriendListHandler)this.app.a(1)).a(paramBoolean, this.app.getAccount(), 3);
    }
    do
    {
      return;
      QQToast.a(getApplicationContext(), getString(2131365943), 0).b(getTitleBarHeight());
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()));
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (((FriendsManager)this.app.getManager(49)).e() > 0)) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  private void e()
  {
    int j = this.jdField_a_of_type_Ewn.getGroupCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.c(i);
      i += 1;
    }
  }
  
  private void f()
  {
    Intent localIntent = new Intent(getActivity(), UncommonlyUsedContactsActivity.class);
    localIntent.putExtra("isBack2Root", true);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
        b(true);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131369888) + "(" + this.jdField_a_of_type_JavaUtilList.size() + ")");
    }
    while (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    b(false);
  }
  
  protected Dialog a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = getResources().getString(paramInt1);
    Object localObject1 = getResources().getString(paramInt2);
    String str2 = getResources().getString(paramInt3);
    String str1 = getResources().getString(paramInt4);
    Dialog localDialog = new Dialog(this, 2131558902);
    localDialog.setContentView(2130903211);
    TextView localTextView = (TextView)localDialog.findViewById(2131297367);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)localObject2);
      localTextView.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = (TextView)localDialog.findViewById(2131296606);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)localDialog.findViewById(2131297370);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
    }
    paramOnClickListener1 = (TextView)localDialog.findViewById(2131297371);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setContentDescription(str1);
      paramOnClickListener1.setOnClickListener(paramOnClickListener2);
    }
    return localDialog;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(Activity paramActivity)
  {
    Object localObject = this.app.a().getSharedPreferences(this.app.getAccount(), 0);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("hasPopUpWelcomeDlg", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("everHasGatheredContacts", false);
    if ((bool1) || (bool2) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().size() <= 0)) {
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasPopUpWelcomeDlg", true).commit();
    localObject = DialogUtil.a(paramActivity, 0, 2130903859, null, null, paramActivity.getString(2131367782), paramActivity.getString(2131367782), new ewf(this), null);
    ((QQCustomDialog)localObject).setOnDismissListener(new ewg(this));
    ((QQCustomDialog)localObject).setMessageCount(paramActivity.getString(2131369889));
    ((QQCustomDialog)localObject).setPreviewImage(paramActivity.getResources().getDrawable(2130840095), true, 1);
    ((QQCustomDialog)localObject).show();
  }
  
  public void b()
  {
    if (this.app.a().getSharedPreferences(this.app.getAccount(), 0).getBoolean("hasShownPermDlg", false)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = a(2131369890, 2131369891, 2131365733, 2131365732, new ewh(this), new ewi(this));
    }
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (!this.app.e())
    {
      finish();
      return false;
    }
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ewn != null) {
      this.jdField_a_of_type_Ewn.a();
    }
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Handler localHandler = this.app.a(Conversation.class);
    if (localHandler != null) {
      localHandler.sendMessage(localHandler.obtainMessage(1037));
    }
    g();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (paramView == this.jdField_d_of_type_AndroidViewView) {
      if (!NetworkUtil.e(this)) {
        QQToast.a(this, getString(2131365943), 0).b(getTitleBarHeight());
      }
    }
    Object localObject1;
    do
    {
      short s;
      do
      {
        return;
        s = (short)this.jdField_a_of_type_JavaUtilList.size();
      } while (s <= 0);
      ((FriendListHandler)this.app.a(1)).a(s, this.jdField_a_of_type_JavaUtilList, true);
      a(2131369901);
      ReportController.b(this.app, "CliOper", "", "", "0X8004C4A", "0X8004C4A", 0, 0, "", "", "", "");
      return;
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, getString(2131365943), 0).b(getTitleBarHeight());
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        ((FriendListHandler)this.app.a(1)).a(0, false);
        startTitleProgress();
        return;
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof ewm))) {
        break;
      }
      paramView = (ewm)paramView.getTag();
      localObject1 = (ewl)((ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramView.jdField_a_of_type_JavaLangString)).get(paramView.jdField_a_of_type_Int);
    } while ((localObject1 == null) || (((ewl)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends == null));
    Object localObject2 = ((ewl)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    if (!((ewl)localObject1).jdField_a_of_type_Boolean)
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838502);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("已选定");
      ((ewl)localObject1).jdField_a_of_type_Boolean = true;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        this.jdField_a_of_type_JavaUtilHashSet.remove(localObject2);
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() == this.jdField_b_of_type_Int))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369886));
      }
      localObject1 = ((ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramView.jdField_a_of_type_JavaLangString)).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (((ewl)((Iterator)localObject1).next()).jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ewk)((Iterator)localObject1).next();
          if (((ewk)localObject2).jdField_a_of_type_JavaLangString.equals(paramView.jdField_a_of_type_JavaLangString))
          {
            ((ewk)localObject2).jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Ewn.notifyDataSetChanged();
            break label565;
          }
        }
      }
      for (;;)
      {
        g();
        return;
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838500);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("未选定");
        ((ewl)localObject1).jdField_a_of_type_Boolean = false;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_a_of_type_JavaUtilList.remove(localObject2);
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject2);
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369885));
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        label565:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ewk)((Iterator)localObject1).next();
          if ((!((ewk)localObject2).jdField_a_of_type_JavaLangString.equals(paramView.jdField_a_of_type_JavaLangString)) || (!((ewk)localObject2).jdField_a_of_type_Boolean)) {
            break;
          }
          ((ewk)localObject2).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Ewn.notifyDataSetChanged();
        }
      }
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof ewj)))
      {
        paramView = (ewj)paramView.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.e(paramView.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.d(paramView.jdField_a_of_type_Int);
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004F48", "0X8004F48", 0, 0, "", "", "", "");
          return;
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.c(paramView.jdField_a_of_type_Int);
          }
          catch (Throwable paramView) {}
        }
      }
      if (paramView == this.jdField_e_of_type_AndroidWidgetTextView)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        boolean bool;
        if (!this.jdField_b_of_type_Boolean)
        {
          bool = true;
          this.jdField_b_of_type_Boolean = bool;
          paramView = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        }
        label893:
        for (;;)
        {
          if (!paramView.hasNext()) {
            break label895;
          }
          localObject1 = ((ArrayList)paramView.next()).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label893;
            }
            localObject2 = (ewl)((Iterator)localObject1).next();
            ((ewl)localObject2).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
            if (this.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_JavaUtilList.add(((ewl)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
              this.jdField_a_of_type_JavaUtilHashSet.remove(((ewl)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
              continue;
              bool = false;
              break;
            }
            this.jdField_a_of_type_JavaUtilHashSet.add(((ewl)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends.uin);
          }
        }
        label895:
        paramView = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext()) {
          ((ewk)paramView.next()).jdField_a_of_type_Boolean = this.jdField_b_of_type_Boolean;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369885));
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369885));
          if (!this.jdField_b_of_type_Boolean) {
            break label1103;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004C48", "0X8004C48", 0, 0, "", "", "", "");
          if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
            b(true);
          }
          this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131369888) + "(" + this.jdField_a_of_type_JavaUtilList.size() + ")");
        }
        for (;;)
        {
          this.jdField_a_of_type_Ewn.notifyDataSetChanged();
          return;
          this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131369886));
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131369886));
          break;
          label1103:
          ReportController.b(this.app, "CliOper", "", "", "0X8004C49", "0X8004C49", 0, 0, "", "", "", "");
          if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
            b(false);
          }
        }
      }
      if (paramView.getId() == 2131299843)
      {
        a(paramView);
        return;
      }
      if (paramView == this.jdField_e_of_type_AndroidViewView)
      {
        if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8004F4A", "0X8004F4A", 0, 0, "", "", "", "");
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        f();
        return;
      }
      if (paramView != this.jdField_a_of_type_AndroidWidgetButton) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004F4B", "0X8004F4B", 0, 0, "", "", "", "");
      f();
      return;
      i = 1;
    }
  }
  
  public boolean startTitleProgress()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    return true;
  }
  
  public boolean stopTitleProgress()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecommendedGatherListActivity
 * JD-Core Version:    0.7.0.1
 */