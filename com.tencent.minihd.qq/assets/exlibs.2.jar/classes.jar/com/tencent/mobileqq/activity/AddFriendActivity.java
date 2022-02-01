package com.tencent.mobileqq.activity;

import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import ded;
import dee;
import deg;
import deh;
import dei;
import dej;
import dek;
import del;
import dem;
import den;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 100;
  private static final long jdField_a_of_type_Long = 300L;
  private static final int jdField_b_of_type_Int = 25;
  public static final String b = "p_need_display_recommend";
  private static final int jdField_c_of_type_Int = 15;
  private static final int jdField_d_of_type_Int = 8;
  private static final String jdField_d_of_type_JavaLangString = "btroop";
  private static final int jdField_e_of_type_Int = 20;
  private static final String jdField_e_of_type_JavaLangString = "uin";
  private static final int jdField_f_of_type_Int = 1;
  private static final String jdField_f_of_type_JavaLangString = "troopuin";
  private static final int jdField_g_of_type_Int = 3;
  private static final String jdField_g_of_type_JavaLangString = "performAutoAction";
  private static final int jdField_h_of_type_Int = 4;
  private static final String jdField_h_of_type_JavaLangString = "needFinish";
  private Handler jdField_a_of_type_AndroidOsHandler = new del(this);
  public View a;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AdapterView.OnItemClickListener a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public GridView a;
  public TextView a;
  ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new deh(this);
  private ContactSearchFacade jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new deg(this);
  public LBSObserver a;
  private TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  public TroopObserver a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public den a;
  String jdField_a_of_type_JavaLangString = "";
  public List a;
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private boolean jdField_a_of_type_Boolean = false;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9]");
  private boolean jdField_b_of_type_Boolean = false;
  public TextView c;
  public String c;
  private boolean jdField_c_of_type_Boolean = true;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean jdField_e_of_type_Boolean;
  
  public AddFriendActivity()
  {
    this.e = false;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new dee(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new dei(this);
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new dem(this);
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("troopuin");
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("btroop", false);
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("performAutoAction", true);
    this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("needFinish", false);
  }
  
  public static void a(Activity paramActivity, SearchInfo paramSearchInfo, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 1;
    long l = paramSearchInfo.lUIN;
    if (l != 0L)
    {
      if (l == Long.parseLong(paramString)) {
        i = 0;
      }
      for (;;)
      {
        paramString = new ProfileActivity.AllInOne(l + "", i);
        paramString.jdField_h_of_type_JavaLangString = paramSearchInfo.strNick;
        paramString.b = paramArrayOfByte;
        if (paramActivity.getIntent().getStringExtra("param_return_addr") == null) {
          break;
        }
        paramSearchInfo = ProfileActivity.a(paramActivity, paramString);
        paramSearchInfo.putExtra("param_return_addr", paramActivity.getIntent().getStringExtra("param_return_addr"));
        paramSearchInfo.putExtra("AllInOne", paramString);
        paramActivity.startActivity(paramSearchInfo);
        return;
        if (paramSearchInfo.bIsFriend != 1) {
          if (paramBoolean) {
            i = 37;
          } else {
            i = 35;
          }
        }
      }
    }
    if (paramSearchInfo.bInContact == 1) {}
    for (i = 31;; i = 36)
    {
      paramString = new ProfileActivity.AllInOne(paramSearchInfo.strMobile, i);
      if (paramSearchInfo.bInContact == 1) {
        paramString.jdField_h_of_type_Int = 3001;
      }
      break;
    }
    ProfileActivity.a(paramActivity, paramString, 100);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, AddFriendActivity.class);
    localIntent.putExtra("btroop", paramBoolean1);
    localIntent.putExtra("performAutoAction", paramBoolean2);
    if ((paramContext instanceof ChatActivity))
    {
      localIntent.addFlags(1073741824);
      localIntent.putExtra("needFinish", true);
    }
    if (paramString != null)
    {
      if (!paramBoolean1) {
        break label78;
      }
      localIntent.putExtra("troopuin", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      label78:
      localIntent.putExtra("uin", paramString);
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.e(this)) {
      return false;
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    ((LBSHandler)this.app.a(3)).a(20, 1);
    return true;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString != null) {
      bool = paramString.matches("^\\d{5,11}$");
    }
    return bool;
  }
  
  private void b()
  {
    Button localButton = (Button)findViewById(2131296672);
    TextView localTextView = (TextView)findViewById(2131296670);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296650));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296673));
    if (this.jdField_b_of_type_Boolean)
    {
      setTitle(2131367265);
      localTextView.setText(2131367267);
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localButton.setOnClickListener(this);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
      setTitle(2131367264);
      localTextView.setText(2131367266);
    }
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList = MayKnowManActivity.a(this, this.app.a());
    Object localObject = findViewById(2131296674);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296675));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296676));
    this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131296677);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131296679));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131296680));
    ((View)localObject).setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() < 15) && (a()))
    {
      localObject = getResources().getDrawable(2130838130);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      ((Animatable)localObject).start();
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      d();
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131366982);
  }
  
  private void d()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_JavaUtilList.size() > 8) {}
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      this.jdField_a_of_type_Den = new den(this);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Den);
      return;
    }
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean)) {
      f();
    }
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean)) {
      g();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString().trim();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.trim();
    if (this.jdField_a_of_type_JavaLangString.equals("")) {
      a(2131366971);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.length() < 5)
      {
        a(2131366972);
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.indexOf("@") != -1)
      {
        if (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).matches()) {
          a("非法的邮箱地址");
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString).replaceAll("");
        if (this.jdField_a_of_type_JavaLangString.length() < 5)
        {
          a(2131366971);
          return;
        }
      }
      if (!NetworkUtil.e(this)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString);
      b(2131366974);
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131367328, 0).b(getTitleBarHeight());
  }
  
  private void g()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (this.jdField_c_of_type_JavaLangString.trim().equals("")) {
      a(2131367267);
    }
    do
    {
      return;
      if (!NetworkUtil.e(this)) {
        break;
      }
      b(2131366976);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      h();
    } while (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager == null);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131367328, 0).b(getTitleBarHeight());
  }
  
  private void h()
  {
    if (a(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_c_of_type_JavaLangString, 3001);
      return;
    }
    long l = Long.parseLong(this.app.a());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l, 12, 0, 1, this.jdField_c_of_type_JavaLangString, 1, 0L);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    runOnUiThread(new dej(this, paramInt));
  }
  
  public void a(RespSearch paramRespSearch)
  {
    Intent localIntent = new Intent(this, SearchFriendListActivity.class);
    localIntent.putExtra("param_search_resp", paramRespSearch.toByteArray());
    localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
    if (getIntent().getStringExtra("from_activity").equals(ChatActivity.class.getName()))
    {
      startActivityForResult(localIntent, 100);
      return;
    }
    startActivity(localIntent);
  }
  
  public void a(String paramString)
  {
    runOnUiThread(new dek(this, paramString));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    a();
    paramBundle = getActivity().getWindow();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) || (this.jdField_a_of_type_Boolean)) {
      paramBundle.setSoftInputMode(2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.app);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.a(19));
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)getSystemService("input_method"));
      paramBundle = View.inflate(this, 2130903069, null);
      setContentView(paramBundle);
      setContentBackgroundResource(2130837687);
      b();
      if (this.jdField_a_of_type_Boolean)
      {
        c();
        paramBundle.setOnTouchListener(new ded(this));
      }
      return true;
      paramBundle.setSoftInputMode(4);
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    super.doOnDestroy();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.e))
    {
      this.e = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null)
    {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131296672)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!isFinishing())
      {
        if (this.jdField_b_of_type_Boolean) {
          break label39;
        }
        f();
      }
    }
    label39:
    while (i != 2131296676)
    {
      return;
      g();
      return;
    }
    MayKnowManActivity.a(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0) || (this.jdField_d_of_type_Boolean)) {
      return getString(2131366374);
    }
    return this.centerView.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */