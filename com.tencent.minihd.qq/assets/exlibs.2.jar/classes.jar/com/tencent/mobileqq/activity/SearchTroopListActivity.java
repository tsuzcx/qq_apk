package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import ezb;
import ezc;
import ezd;
import eze;
import ezf;
import ezg;
import ezi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class SearchTroopListActivity
  extends BaseActivity
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener
{
  public static final int a = 12;
  static final String jdField_a_of_type_JavaLangString = SearchTroopListActivity.class.getSimpleName();
  private static final String b = "keyword";
  private static final String jdField_c_of_type_JavaLangString = "troop_list";
  private static final String jdField_d_of_type_JavaLangString = "is_finish";
  public Dialog a;
  public View a;
  public LinearLayout a;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  public TextView a;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ezf(this);
  public XListView a;
  public ezg a;
  public List a;
  public boolean a;
  public int b;
  public TextView b;
  public int c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private String e;
  
  public SearchTroopListActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static int a(SearchGroup.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.bGroupAllow.has()) && (paramGroupInfo.bGroupAllow.get())) {
      return 2;
    }
    return 3;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == this.d) {}
    while (!a(paramInt, 0)) {
      return;
    }
    this.d = paramInt;
    g();
    this.jdField_b_of_type_Int = 0;
    b(2131367999);
  }
  
  public static void a(Activity paramActivity, String paramString, List paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SearchTroopListActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("is_finish", paramBoolean);
    localIntent.putParcelableArrayListExtra("troop_list", SearchTroopListActivity.StrangeTroopWrapper.a(paramList));
    paramActivity.startActivity(localIntent);
  }
  
  private void a(View paramView)
  {
    i();
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {}
    try
    {
      int i = a();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setPadding(0, i, 0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(getWindow().getDecorView(), 48, 0, 0);
      return;
    }
    catch (Exception paramView) {}
  }
  
  private void a(SearchGroup.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo != null) {
      TroopUtils.a(this, TroopUtils.a(6, paramGroupInfo, 0), 2);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131365941), 0).b(this.jdField_c_of_type_Int);
      return false;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    long l = Long.parseLong(this.app.a());
    switch (paramInt1)
    {
    default: 
      return true;
    case 2131302033: 
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 1, 0L);
      return true;
    case 2131302034: 
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 2, 0L);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, paramInt2, 1, this.e, 4, 0L);
    return true;
  }
  
  private void b(int paramInt)
  {
    a();
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this, this.jdField_c_of_type_Int);
    localQQProgressDialog.a(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog = localQQProgressDialog;
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ezc(this));
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ezd(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void d()
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    this.d = 2131302033;
    this.e = localIntent.getStringExtra("keyword");
    this.jdField_a_of_type_JavaUtilList = SearchTroopListActivity.StrangeTroopWrapper.a(localIntent.getParcelableArrayListExtra("troop_list"));
    if (!localIntent.getBooleanExtra("is_finish", false)) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Int = 1;
  }
  
  private void e()
  {
    f();
    h();
  }
  
  private void f()
  {
    Object localObject1 = (ViewGroup)findViewById(2131297347);
    TextView localTextView1 = (TextView)((ViewGroup)localObject1).findViewById(2131297357);
    Object localObject2 = ((ViewGroup)localObject1).findViewById(2131298708);
    TextView localTextView2 = (TextView)((View)localObject2).findViewById(2131297348);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131298709));
    View localView = ((ViewGroup)localObject1).findViewById(2131302036);
    IphoneTitleBarActivity.setLayerType((View)localObject1);
    IphoneTitleBarActivity.setLayerType(localTextView2);
    IphoneTitleBarActivity.setLayerType(this.jdField_c_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.setLayerType(localTextView1);
    IphoneTitleBarActivity.setLayerType(localView);
    localTextView2.setText(2131367994);
    ((View)localObject2).setOnClickListener(this);
    g();
    localObject2 = getIntent().getStringExtra("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131366374);
    }
    localTextView1.setText((CharSequence)localObject1);
    localTextView1.setOnClickListener(this);
    localView.setOnClickListener(this);
  }
  
  private void g()
  {
    switch (this.d)
    {
    default: 
      return;
    case 2131302033: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367995);
      return;
    case 2131302034: 
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367996);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131367997);
  }
  
  private void h()
  {
    View localView = findViewById(2131302238);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131302240));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302241));
    this.jdField_b_of_type_AndroidWidgetTextView.setText("没找到适合条件的群");
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131302239));
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903377, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366569);
    this.jdField_a_of_type_Ezg = new ezg(this, this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_Ezg.a(new ezb(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ezg);
  }
  
  private void i()
  {
    View localView1 = getLayoutInflater().inflate(2130904394, null);
    View localView2 = localView1.findViewById(2131302033);
    View localView3 = localView1.findViewById(2131302034);
    View localView4 = localView1.findViewById(2131302035);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localView1, -1, -1, true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchInterceptor(this);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558938);
    localView1.setOnClickListener(new eze(this));
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException) {}
    return j;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      if (this.jdField_a_of_type_Boolean) {
        c();
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0));
      paramAdapterView = (ezi)paramView.getTag();
    } while (paramAdapterView == null);
    a(paramAdapterView.a);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c()
  {
    if (a(this.d, this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366594);
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131296735);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297996);
      localProgressBar.setVisibility(0);
      localImageView.setVisibility(8);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
    d();
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131492923);
    setContentView(2130904449);
    setContentBackgroundResource(2130837687);
    e();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131296735).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131297996).setVisibility(8);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297997);
      paramBundle.setVisibility(0);
      paramBundle.setText("没有更多");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_Ezg.b();
    super.doOnDestroy();
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297357: 
      onBackEvent();
      return;
    case 2131298708: 
    case 2131302036: 
      a(paramView);
      return;
    }
    b();
    a(paramView.getId());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      b();
      return true;
    }
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected String setLastActivityName()
  {
    return getString(2131367994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchTroopListActivity
 * JD-Core Version:    0.7.0.1
 */