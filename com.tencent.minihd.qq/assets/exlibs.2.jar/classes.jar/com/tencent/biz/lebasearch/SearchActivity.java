package com.tencent.biz.lebasearch;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cgl;
import cgn;
import cgo;
import cgp;
import cgq;
import cgr;
import cgs;
import cgt;
import cgu;
import cgv;
import cgw;
import cgx;
import cgy;
import chk;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.biz.widgets.ActiveSearchTipsContainer;
import com.tencent.biz.widgets.ActiveSearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SoftInputActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.BasePadActivity;
import org.json.JSONObject;

public class SearchActivity
  extends BaseActivity
  implements View.OnClickListener, SearchHistoryAdapter.OnItemClickObserver, SearchResultAdapter.OnResultItemClickedListener
{
  public static final int a = 1;
  public static final String a = "DynamicSearch";
  public static final int b = 2;
  public static final String b = "1002";
  public static final int c = 3;
  public static final String c = "0X8004AB2";
  public static final int d = 4;
  public static final String d = "0X8004AB4";
  public static final int e = 0;
  public static final String e = "0X8004B21";
  public static final int f = 1;
  public static final String f = "0X8004B22";
  public static final int g = 2;
  public static final String g = "0X8004B23";
  public static final int h = 3;
  public static final String h = "0X8004B24";
  public static final int i = 20;
  public static final String i = "0X8004D70";
  public static final int j = 1;
  public static final String j = "0X8004AB1";
  public static final int k = 2;
  public static final String k = "0X8004AB3";
  public static final String l = "0X800513C";
  public static final String m = "0X800516F";
  public static final String n = "0X800516E";
  public static final String o = "request_keyword";
  public static final String p = "request_home_hot_word";
  public static final String q = "receiver_text";
  public static final String r = "refresh_text";
  public static final String s = "do_search_text";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cgv(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new cgt(this);
  private View jdField_a_of_type_AndroidViewView;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private cgy jdField_a_of_type_Cgy = new cgy(this, null);
  private SearchProtocol.SearchObserver jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver = new cgl(this);
  private SearchProtocol.WordItem jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem;
  private SearchResultAdapter jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter;
  private ViewPluginManager jdField_a_of_type_ComTencentBizViewpluginViewPluginManager;
  private ActiveSearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener = new cgq(this);
  private ActiveSearchTipsContainer jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private XListView jdField_c_of_type_ComTencentWidgetXListView;
  private List jdField_c_of_type_JavaUtilList = null;
  private View jdField_d_of_type_AndroidViewView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private int l;
  private int m;
  private int n = -1;
  private int o = 0;
  private String t;
  
  public SearchActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new cgw(this);
  }
  
  public static void a(BaseActivity paramBaseActivity, View paramView, SearchProtocol.WordItem paramWordItem)
  {
    Intent localIntent = new Intent(paramBaseActivity, SearchActivity.class);
    if (paramView != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramBaseActivity.getResources().getDimension(2131492923));
      localTranslateAnimation.setDuration(200L);
      localTranslateAnimation.setFillAfter(true);
      View localView = paramBaseActivity.findViewById(2131297977);
      if (localView != null) {
        localView.setBackgroundResource(2130837687);
      }
      localTranslateAnimation.setAnimationListener(new cgu(localIntent, paramWordItem, paramBaseActivity));
      paramView.startAnimation(localTranslateAnimation);
      ThreadPriorityManager.a(true);
      return;
    }
    localIntent.putExtra("clear_fragment_stack", false);
    setContaierViewId(2131297931);
    paramBaseActivity.startActivity(localIntent);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((SearchProtocol.WordItem)localIterator.next());
      }
      this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer.a(localArrayList);
    } while (!paramBoolean);
    c(1);
  }
  
  private void d()
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.gravity = 51;
    localLayoutParams.x = SizeMeasure.a(this);
    localLayoutParams.y = 0;
    localLayoutParams.width = SizeMeasure.b(this);
    localLayoutParams.height = -1;
    getWindow().setAttributes(localLayoutParams);
  }
  
  private void d(int paramInt)
  {
    this.l = paramInt;
    if (this.l == 2)
    {
      this.t = null;
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_c_of_type_JavaUtilList);
      c(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      a(true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004B22", "0X8004B22", 0, 0, null, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "4", null, null, null);
    }
    while (this.l != 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem == null) {}
    for (String str = null;; str = this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.id)
    {
      this.t = str;
      SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString(), this.jdField_c_of_type_JavaUtilList);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString());
      c(this.jdField_a_of_type_AndroidWidgetEditText.getHint().toString());
      a(true);
      ReportController.b(this.app, "CliOper", "", "", "0X8004AB2", "0X8004AB2", 0, 0, this.t, null, null, null);
      ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "0", null, null, null);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem == null) {
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word);
    localSpannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#b4e088")), 0, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word.length(), 33);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Cgy);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word.length());
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Cgy);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131364149);
  }
  
  private void f()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    List localList = localEntityManager.a(SearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localEntityManager.b((SearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    localEntityManager.a();
    ReportController.b(this.app, "CliOper", "", "", "0X8004D70", "0X8004D70", 0, 0, null, null, null, null);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new cgo(this);
      IntentFilter localIntentFilter = new IntentFilter("receiver_text");
      localIntentFilter.addAction("refresh_text");
      localIntentFilter.addAction("do_search_text");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      sendBroadcast(new Intent("hide_soft_panel"));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      sendBroadcast(new Intent("clear_text"));
    }
  }
  
  private void k()
  {
    g();
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new cgp(this), 500L);
    Intent localIntent = new Intent(this, SoftInputActivity.class);
    localIntent.setFlags(268435456);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
      localIntent.putExtra("text", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    }
    startActivity(localIntent);
  }
  
  private void l()
  {
    i();
    h();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void a()
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298488));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298490));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint("");
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299465));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299461));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364150));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298496));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297284));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297285));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297286));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298491));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(new cgr(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298494));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131298495));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new cgs(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(getString(2131364149));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298492));
    this.jdField_c_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297287));
    this.jdField_c_of_type_ComTencentWidgetXListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903486, null);
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer = ((ActiveSearchTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131297582));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298487);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298485);
    this.jdField_c_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131298498);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case -1: 
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364155);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131364156);
  }
  
  protected void a(Intent paramIntent)
  {
    b();
    paramIntent = (SearchProtocol.WordItem)paramIntent.getSerializableExtra("request_home_hot_word");
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.word)))
    {
      this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem = paramIntent;
      e();
    }
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
    SearchProtocol.b(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver);
  }
  
  public void a(chk paramchk)
  {
    if (paramchk == null) {
      return;
    }
    String str;
    Intent localIntent;
    if (paramchk.e == 2)
    {
      str = ((JSONObject)paramchk.jdField_a_of_type_JavaLangObject).optString("jump_url");
      if (!TextUtils.isEmpty(str))
      {
        str = str.trim();
        if ((!str.startsWith("http:")) && (!str.startsWith("https:"))) {
          break label238;
        }
        localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        localIntent.putExtra("clear_fragment_stack", true);
        startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSearch", 2, "click detail : jumpUrl = " + str);
        }
      }
    }
    label447:
    for (;;)
    {
      if ((getActivity() instanceof BasePadActivity))
      {
        ((BasePadActivity)getActivity()).rightPanelEmpty();
        l();
      }
      if ((this.l != 2) && (this.l != 4)) {
        break label449;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, null, "" + this.l, paramchk.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
      return;
      label238:
      localIntent = new Intent();
      localIntent.putExtra("cur_tab_index", getTabIndex());
      localIntent.setData(Uri.parse(str));
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("clear_fragment_stack", true);
      startActivity(localIntent);
      break;
      if (paramchk.e == 3)
      {
        str = (String)paramchk.jdField_a_of_type_JavaLangObject;
        if (!TextUtils.isEmpty(str))
        {
          str = str.trim();
          if ((str.startsWith("http:")) || (str.startsWith("https:")))
          {
            localIntent = new Intent(this, QQBrowserActivity.class);
            localIntent.putExtra("url", str);
            localIntent.putExtra("clear_fragment_stack", true);
            startActivity(localIntent);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label447;
            }
            QLog.d("DynamicSearch", 2, "click more: jump_url = " + str);
            break;
            localIntent = new Intent();
            localIntent.setData(Uri.parse(str));
            localIntent.setAction("android.intent.action.VIEW");
            localIntent.putExtra("clear_fragment_stack", true);
            startActivity(localIntent);
          }
        }
      }
    }
    label449:
    ReportController.b(this.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, this.t, "" + this.l, paramchk.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
  }
  
  public void a(SearchHistoryEntity paramSearchHistoryEntity)
  {
    if (paramSearchHistoryEntity == null) {
      return;
    }
    this.l = 4;
    a(paramSearchHistoryEntity.keyWord);
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, paramSearchHistoryEntity.keyWord, this.jdField_c_of_type_JavaUtilList);
    c(paramSearchHistoryEntity.keyWord);
    a(true);
    ReportController.b(this.app, "CliOper", "", "", "0X800513C", "0X800513C", 0, 0, null, null, null, null);
    ReportController.b(this.app, "CliOper", "", "", "0X800516E", "0X800516E", 0, 0, "2", null, null, null);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_Cgy);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
    if ((this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem != null) && (!paramString.equals(this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$WordItem.word))) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Cgy);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      c(1);
    }
    if (this.jdField_c_of_type_ComTencentWidgetXListView.a() == null)
    {
      paramList = new SearchHistoryAdapter(this, paramList, this);
      this.jdField_c_of_type_ComTencentWidgetXListView.setAdapter(paramList);
    }
    SearchHistoryAdapter localSearchHistoryAdapter;
    do
    {
      return;
      if (!(this.jdField_c_of_type_ComTencentWidgetXListView.a() instanceof HeaderViewListAdapter)) {
        break;
      }
      localSearchHistoryAdapter = (SearchHistoryAdapter)((HeaderViewListAdapter)this.jdField_c_of_type_ComTencentWidgetXListView.a()).getWrappedAdapter();
    } while (localSearchHistoryAdapter == null);
    localSearchHistoryAdapter.a(paramList);
    return;
    ((SearchHistoryAdapter)this.jdField_c_of_type_ComTencentWidgetXListView.a()).a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      c(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131365736);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364150));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
  }
  
  public void b()
  {
    ThreadManager.a(new cgn(this));
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter == null) {}
    label201:
    label210:
    label245:
    for (;;)
    {
      return;
      Object localObject2 = (chk)this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter.getItem(paramInt);
      Object localObject1 = ((chk)localObject2).jdField_a_of_type_JavaLangString;
      if (paramInt == 0)
      {
        localObject1 = this.jdField_b_of_type_ComTencentWidgetXListView.getChildAt(0);
        if (((View)localObject1).getBottom() < ((View)localObject1).getHeight())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((chk)localObject2).jdField_a_of_type_JavaLangString);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject2 = (chk)this.jdField_a_of_type_ComTencentBizLebasearchSearchResultAdapter.getItem(paramInt + 1);
      if (localObject2 != null)
      {
        if (((chk)localObject2).e != 1) {
          break label210;
        }
        localObject2 = this.jdField_b_of_type_ComTencentWidgetXListView.getChildAt(1);
        paramInt = ((View)localObject2).getHeight();
        int i1 = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (i1 >= paramInt * 2) {
          break label201;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (i1 - paramInt * 2);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label245;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        break;
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(""))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131365736);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364150));
      c(1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131364149);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131364149));
    SearchProtocol.a(this.app, this, this.jdField_a_of_type_ComTencentBizLebasearchSearchProtocol$SearchObserver, paramString);
  }
  
  public void c()
  {
    f();
  }
  
  public void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) && ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)))
      {
        this.o = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      this.o = 1;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() != 0)) {
          break label193;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_c_of_type_ComTencentWidgetXListView.setSelection(0);
        return;
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    case 2: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.o = 2;
      this.jdField_c_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
    case 3: 
      label193:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.o = 3;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.o = 0;
  }
  
  public void c(String paramString)
  {
    ThreadManager.a(new cgx(this, paramString));
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    d();
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_JavaUtilList = LebaShowListManager.a().a();
    setContentView(2130903487);
    a();
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager = new ViewPluginManager(this, "SearchViewPlugin.apk", "1002");
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginManager.a();
    SearchProtocol.a(this, this.app, 600000L);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    a(paramBundle);
    c(0);
    ReportController.b(this.app, "CliOper", "", "", "0X8004B21", "0X8004B21", 0, 0, null, null, null, null);
    doOnResume();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    l();
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    setContaierViewId(2131297932);
  }
  
  public void finish()
  {
    setResult(-1);
    l();
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    a(str);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
    this.jdField_a_of_type_Boolean = false;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131365736)))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004B23", "0X8004B23", 0, 0, null, null, null, null);
        finish();
      }
      for (;;)
      {
        l();
        return;
        if ((this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equals(getString(2131364149))) && (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText()))) {
          d(2);
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      j();
      return;
      l();
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    } while ((isResume()) || (!SizeMeasure.a(this)));
    k();
  }
  
  protected boolean popStack()
  {
    return false;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchActivity
 * JD-Core Version:    0.7.0.1
 */