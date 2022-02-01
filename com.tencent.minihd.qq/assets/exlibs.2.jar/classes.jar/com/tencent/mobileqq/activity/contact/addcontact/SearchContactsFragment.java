package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import ggr;
import ggs;
import ggt;
import ggu;
import ggv;
import ggw;
import ggx;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  public static final int b = 0;
  private static final String d = "SearchContactsFragment";
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public int a;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  public ggv a;
  private ggx jdField_a_of_type_Ggx;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private ArrayList b;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 80000000: 
    default: 
      return 1;
    case 80000001: 
      return 2;
    }
    return 3;
  }
  
  @Deprecated
  public static SearchContactsFragment a(BaseActivity paramBaseActivity, SearchResultDialog paramSearchResultDialog, int paramInt)
  {
    SearchContactsFragment localSearchContactsFragment = new SearchContactsFragment();
    localSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    localSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = paramSearchResultDialog;
    paramSearchResultDialog = new Bundle();
    paramSearchResultDialog.putInt("from_key", paramInt);
    localSearchContactsFragment.setArguments(paramSearchResultDialog);
    localSearchContactsFragment.j();
    localSearchContactsFragment.onCreateView(paramBaseActivity.getLayoutInflater(), null, null);
    return localSearchContactsFragment;
  }
  
  private SearchResult a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SearchResult localSearchResult = (SearchResult)localIterator.next();
      if (localSearchResult.jdField_a_of_type_Int == paramInt) {
        return localSearchResult;
      }
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000000: 
      return "0X8004BEE";
    case 80000001: 
      return "0X8004BEF";
    }
    return "0X8004BF0";
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).b;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        l();
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
      if ((localObject != null) && (((List)localObject).size() == 2))
      {
        localObject = SearchBaseActivity.c.matcher(this.jdField_c_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.jdField_c_of_type_JavaLangString);
        }
        if (((Matcher)localObject).matches())
        {
          d();
          a(jdField_a_of_type_JavaUtilHashMap, this.jdField_b_of_type_JavaUtilArrayList);
          a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int);
          return true;
        }
      }
    }
    return false;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 1) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ggu(this));
    }
  }
  
  public String a(SearchBaseFragment.ItemViewHolder paramItemViewHolder, ggw paramggw)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramggw.jdField_b_of_type_Int;
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get() + "");
    if (paramggw.jdField_b_of_type_Int != 80000001)
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.uin.get()));
      localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      switch (i)
      {
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramggw = localBitmap;
      if (localBitmap == null)
      {
        localBitmap = ImageUtil.a();
        paramggw = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, i, true, (byte)1);
          paramggw = localBitmap;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramggw);
      return localStringBuilder.toString() + "轻触两次进入资料卡";
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(b(paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get()));
      break;
      localStringBuilder.append(a(paramItemViewHolder, paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
      continue;
      i = 4;
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get() + "人");
      paramItemViewHolder.c.setText("");
      paramItemViewHolder.d.setText(paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get());
      paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(a().getResources().getColor(2131427972));
      paramItemViewHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      localStringBuilder.append(paramItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramItemViewHolder.d.getText());
      continue;
      localStringBuilder.append(b(paramItemViewHolder, paramggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record));
      i = 1;
    }
  }
  
  ArrayList a(ArrayList paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.a(this.d);
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        SearchResult localSearchResult = (SearchResult)localIterator.next();
        if (localSearchResult.jdField_a_of_type_Int == k) {
          localArrayList.add(localSearchResult);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      f();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ggx == null)
      {
        this.jdField_a_of_type_Ggx = new ggx(this, null);
        this.jdField_a_of_type_Ggx.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ggx);
        this.a = this.jdField_a_of_type_Ggx;
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      this.jdField_a_of_type_Ggx.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Ggx.notifyDataSetChanged();
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("last_key_words", this.jdField_c_of_type_JavaLangString);
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
        a().runOnUiThread(new ggt(this));
      }
      return;
      ((Intent)localObject).putExtra("from_key", 0);
      ((Intent)localObject).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject, a(paramInt));
      paramInt = i;
      continue;
      localObject = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.jdField_c_of_type_JavaLangString) + "&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165";
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "lastKeywords = " + this.jdField_c_of_type_JavaLangString + " jump url is : " + (String)localObject);
      }
      Intent localIntent = new Intent(a(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("isShowAd", false);
      a().runOnUiThread(new ggs(this, localIntent));
      paramInt = 2;
      continue;
      ((Intent)localObject).putExtra("from_key", 2);
      ((Intent)localObject).setClass(a(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(a(), (Intent)localObject, a(paramInt));
      paramInt = 3;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_c_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        i();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      ContactSearchFacade localContactSearchFacade = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = this.jdField_a_of_type_Int;; i = 80000003)
      {
        localContactSearchFacade.a(paramString, i);
        this.jdField_c_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramString = a(this.jdField_a_of_type_Int);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, this.d + 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BED", "0X8004BED", this.d + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131367328, 0).b(a());
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      if (!b(this.jdField_b_of_type_JavaUtilArrayList))
      {
        this.jdField_a_of_type_JavaUtilArrayList = b(a(paramArrayList));
        d();
        a(jdField_a_of_type_JavaUtilHashMap, this.jdField_b_of_type_JavaUtilArrayList);
        return true;
      }
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    d();
    a(jdField_a_of_type_JavaUtilHashMap, this.jdField_b_of_type_JavaUtilArrayList);
    if (!b(this.jdField_b_of_type_JavaUtilArrayList)) {
      a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int);
    }
    return false;
  }
  
  ArrayList b(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int k = paramArrayList.size();
    int i = 0;
    while (i < k)
    {
      SearchResult localSearchResult = (SearchResult)paramArrayList.get(i);
      if ((localSearchResult == null) || (localSearchResult.b.size() <= 0))
      {
        i += 1;
      }
      else
      {
        ggw localggw = new ggw();
        localggw.jdField_a_of_type_Int = 0;
        localggw.jdField_a_of_type_JavaLangString = a().getString(ViewFactory.a(localSearchResult.jdField_a_of_type_Int));
        localArrayList.add(localggw);
        int i1 = localSearchResult.b.size();
        int j = 0;
        for (;;)
        {
          if (j < 2)
          {
            localggw = new ggw();
            localggw.jdField_a_of_type_Int = 2;
            localggw.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)localSearchResult.b.get(j));
            localggw.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
            localArrayList.add(localggw);
            if (j < i1 - 1) {}
          }
          else
          {
            if (i1 > 2)
            {
              localggw = new ggw();
              localggw.jdField_a_of_type_Int = 1;
              localggw.jdField_b_of_type_Int = localSearchResult.jdField_a_of_type_Int;
              localArrayList.add(localggw);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localSearchResult.jdField_a_of_type_Int + "count = " + localSearchResult.b.size());
            break;
          }
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000003, a(), true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new ggr(this));
      a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.a(b(), paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b();
      b(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void k()
  {
    super.k();
    d();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof SearchBaseFragment.ItemViewHolder)))
    {
      paramView = (SearchBaseFragment.ItemViewHolder)paramView;
      l();
      a(paramView.jdField_b_of_type_Int, paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BF2", "0X8004BF2", a(paramView.jdField_b_of_type_Int), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */