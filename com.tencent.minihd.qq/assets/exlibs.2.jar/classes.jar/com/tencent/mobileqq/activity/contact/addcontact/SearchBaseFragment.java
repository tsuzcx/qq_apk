package com.tencent.mobileqq.activity.contact.addcontact;

import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import ggl;
import ggm;
import ggn;
import ggo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchBaseFragment
  extends Fragment
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final String a = "from_key";
  protected static HashMap a;
  public static final String b = "last_key_words";
  protected static HashMap b;
  private static final String d;
  public static final int g = -16734752;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public Handler a;
  protected BaseAdapter a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ContactSearchFacade.ISearchListener a;
  protected ContactSearchFacade a;
  CustomerLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected IIconListener a;
  protected StatusManager a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public XListView a;
  private Handler b;
  public boolean b;
  public final int c;
  public String c;
  protected boolean c;
  protected int d;
  public int e = 0;
  protected int f;
  
  static
  {
    jdField_d_of_type_JavaLangString = SearchBaseFragment.class.getName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap(15);
    jdField_b_of_type_JavaUtilHashMap = new HashMap(8);
  }
  
  public SearchBaseFragment()
  {
    this.jdField_c_of_type_Int = 64;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = new ggl(this);
    this.jdField_a_of_type_AndroidOsHandler = new ggm(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ggn(this);
  }
  
  protected int a()
  {
    return BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131492923);
  }
  
  protected SpannableString a(long paramLong)
  {
    return (SpannableString)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  protected String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int n;
    int m;
    switch (paramrecord.sex.get())
    {
    default: 
      localObject = "";
      n = 0;
      m = 0;
      localStringBuilder.append((String)localObject);
      if ((n == 0) && (paramrecord.age.get() == 0))
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      break;
    }
    for (;;)
    {
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(paramrecord.province_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.province_name.get()).append(" ");
      }
      if (!TextUtils.isEmpty(paramrecord.city_name.get())) {
        ((StringBuilder)localObject).append(paramrecord.city_name.get());
      }
      if ((((StringBuilder)localObject).length() == 0) && (!TextUtils.isEmpty(paramrecord.country_name.get()))) {
        ((StringBuilder)localObject).append(paramrecord.country_name.get());
      }
      paramItemViewHolder.c.setText(((StringBuilder)localObject).toString());
      localStringBuilder.append(((StringBuilder)localObject).toString());
      a(paramItemViewHolder, paramrecord.richStatus);
      localStringBuilder.append(paramItemViewHolder.d.getText().toString());
      return localStringBuilder.toString();
      n = 2130838484;
      m = 2130840435;
      localObject = "男";
      break;
      n = 2130838479;
      m = 2130840431;
      localObject = "女";
      break;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(n, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(m);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramrecord.age.get()));
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131427404));
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "onDecodeTaskCompleted type = " + paramInt2 + ", uin = " + paramString);
    }
    int m;
    if ((paramBitmap != null) && (this.e == 0))
    {
      m = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      Object localObject;
      if (paramInt1 < m)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject == null) || (!(localObject instanceof SearchBaseFragment.ItemViewHolder))) {
          break label155;
        }
        localObject = (SearchBaseFragment.ItemViewHolder)localObject;
        if (!((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          break label155;
        }
        if (paramInt2 == 4)
        {
          if (80000001 != ((SearchBaseFragment.ItemViewHolder)localObject).jdField_b_of_type_Int) {
            break label155;
          }
          ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      ((SearchBaseFragment.ItemViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      label155:
      paramInt1 += 1;
    }
  }
  
  protected void a(int paramInt, AccountSearchPb.record paramrecord)
  {
    if (a() == null) {
      return;
    }
    a().runOnUiThread(new ggo(this, paramInt, paramrecord));
  }
  
  public void a(int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramString));
  }
  
  @Deprecated
  public void a(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
  
  protected void a(View paramView)
  {
    if (paramView != null)
    {
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    }
  }
  
  public void a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, RichStatus paramRichStatus)
  {
    paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.a()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.jdField_c_of_type_JavaLangString))
      {
        paramItemViewHolder.jdField_a_of_type_Int = paramRichStatus.jdField_b_of_type_Int;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.jdField_b_of_type_Int, 200);
        localObject = new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), (Bitmap)localObject);
        int m = this.f;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * m), m);
        paramItemViewHolder.d.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramItemViewHolder.d.setText(paramRichStatus.a(" "));
        return;
        paramItemViewHolder.jdField_a_of_type_Int = 0;
        paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    paramItemViewHolder.jdField_a_of_type_Int = 0;
    paramItemViewHolder.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramItemViewHolder.d.setText("");
  }
  
  public void a(AccountSearchPb.record paramrecord)
  {
    SearchInfo localSearchInfo = new SearchInfo();
    localSearchInfo.lUIN = paramrecord.uin.get();
    localSearchInfo.strNick = paramrecord.name.get();
    localSearchInfo.strMobile = paramrecord.mobile.get();
    localSearchInfo.bIsFriend = ((byte)(int)(paramrecord.relation.get() & 1L));
    localSearchInfo.bInContact = ((byte)(int)(paramrecord.relation.get() & 0x2));
    AddFriendActivity.a(a(), localSearchInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, true);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    if (this.e != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    for (;;)
    {
      paramAbsListView = (InputMethodManager)a().getSystemService("input_method");
      if (paramAbsListView.isActive()) {
        paramAbsListView.hideSoftInputFromWindow(a().getWindow().getDecorView().getWindowToken(), 0);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) {
          this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        }
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "搜索失败，请稍后再试";
    }
    QQToast.a(BaseApplicationImpl.getContext(), str, 0).b(a());
  }
  
  public void a(String paramString, boolean paramBoolean) {}
  
  protected void a(Map paramMap, ArrayList paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    if (localIterator1.hasNext())
    {
      paramArrayList = (SearchResult)localIterator1.next();
      int m;
      List localList;
      Iterator localIterator2;
      if (paramArrayList.jdField_a_of_type_Int == 80000001)
      {
        m = 1;
        localList = paramArrayList.jdField_a_of_type_JavaUtilList;
        localIterator2 = paramArrayList.b.iterator();
      }
      label265:
      label289:
      for (;;)
      {
        label56:
        AccountSearchPb.record localrecord;
        SpannableString localSpannableString;
        if (localIterator2.hasNext())
        {
          localrecord = (AccountSearchPb.record)localIterator2.next();
          paramArrayList = localrecord.name.get();
          localSpannableString = new SpannableString(paramArrayList);
          Iterator localIterator3 = localList.iterator();
          for (;;)
          {
            if (localIterator3.hasNext())
            {
              String str = (String)localIterator3.next();
              int n = paramArrayList.indexOf(str);
              int i1 = str.length();
              if (n >= 0)
              {
                localSpannableString.setSpan(new ForegroundColorSpan(-16734752), n, i1 + n, 33);
                continue;
                m = 0;
                break;
              }
            }
          }
          paramArrayList = null;
          if (m == 0) {
            break label265;
          }
          jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localrecord.code.get()), localSpannableString);
        }
        for (;;)
        {
          if ((paramArrayList == null) || (!QLog.isColorLevel())) {
            break label289;
          }
          QLog.e(jdField_d_of_type_JavaLangString, 2, "重复 uin ！ uin = " + localrecord.uin.get() + " 对应内容：" + paramArrayList.toString());
          break label56;
          break;
          paramArrayList = (SpannableString)paramMap.put(Long.valueOf(localrecord.uin.get()), localSpannableString);
        }
      }
    }
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    return true;
  }
  
  protected int b()
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4)) {
      return 80000000;
    }
    if (this.jdField_d_of_type_Int == 2) {
      return 80000002;
    }
    return 80000001;
  }
  
  protected SpannableString b(long paramLong)
  {
    return (SpannableString)jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected String b(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    if ((paramrecord.flag.has()) && (paramrecord.flag.get() == 1L) && (paramrecord.class_index.has()) && (paramrecord.class_index.get() == 20))
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838652, 0);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 6.0F));
      if ((!paramrecord.class_index.has()) || (paramrecord.class_index.get() != 1)) {
        break label246;
      }
      if (paramrecord.class_name.has())
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramrecord.class_name.get());
        localStringBuilder.append(paramrecord.class_name.get());
      }
      if (paramrecord.brief.has())
      {
        paramItemViewHolder.d.setText(paramrecord.brief.get());
        localStringBuilder.append(paramrecord.brief.get());
      }
    }
    for (;;)
    {
      int m = BaseApplicationImpl.getContext().getResources().getColor(2131427972);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
      return localStringBuilder.toString();
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label246:
      if ((paramrecord.class_index.has()) && (paramrecord.class_index.get() == 20))
      {
        paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(2131363626);
        localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
        if (paramrecord.brief.has())
        {
          paramItemViewHolder.d.setText(paramrecord.brief.get());
          localStringBuilder.append(paramItemViewHolder.d.getText());
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_d_of_type_JavaLangString, 2, "clearHighLightString");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = new ContactSearchFacade(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.f = ((int)DisplayUtils.a(BaseApplicationImpl.getContext(), 12.0F));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void f()
  {
    if (a() != null) {
      a(ViewFactory.a().a(80000004, a(), true));
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void h()
  {
    if (a() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = new CustomerLoadingDialog(a());
      }
      if (!a().isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.show();
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog.dismiss();
    }
  }
  
  @Deprecated
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a().getAppRuntime());
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_d_of_type_Int = localBundle.getInt("from_key", 0);
      this.jdField_c_of_type_JavaLangString = localBundle.getString("last_key_words");
    }
    e();
  }
  
  @Deprecated
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactCustomerLoadingDialog = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    ViewFactory.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((FragmentActivity)paramActivity);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    j();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(a());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(a());
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2130842237);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = BaseApplicationImpl.getContext().getResources();
    if ((this instanceof SearchContactsFragment))
    {
      paramViewGroup = new View(a());
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(20.0F, paramLayoutInflater)));
      this.jdField_a_of_type_ComTencentWidgetXListView.b(paramViewGroup);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
      int m = paramLayoutInflater.getDimensionPixelSize(2131493297);
      paramLayoutInflater = new FrameLayout(a());
      paramLayoutInflater.setPadding(m, 0, m, m);
      paramViewGroup = new View(a());
      paramViewGroup.setBackgroundResource(2130837955);
      paramLayoutInflater.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, m / 2));
      paramLayoutInflater.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.jdField_a_of_type_ComTencentWidgetXListView.b(paramLayoutInflater, null, false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment
 * JD-Core Version:    0.7.0.1
 */