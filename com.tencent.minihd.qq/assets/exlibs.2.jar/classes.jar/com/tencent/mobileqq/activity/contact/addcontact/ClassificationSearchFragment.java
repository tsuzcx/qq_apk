package com.tencent.mobileqq.activity.contact.addcontact;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import gfx;
import gfy;
import gfz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static SearchResult jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult;
  private static final String jdField_d_of_type_JavaLangString = "ClassificationSearchFragment";
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  private static final int o = 3;
  private static final int p = 4;
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private gfz jdField_a_of_type_Gfz;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(20);
  public boolean a;
  int b;
  private HashMap c;
  private boolean jdField_d_of_type_Boolean;
  private int q;
  
  public ClassificationSearchFragment()
  {
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap(15);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static ClassificationSearchFragment a(SearchResult paramSearchResult)
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = paramSearchResult;
    return new ClassificationSearchFragment();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Gfz != null) {
      this.jdField_a_of_type_Gfz.notifyDataSetChanged();
    }
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((SearchResult)paramArrayList.get(0)).jdField_b_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((SearchResult)paramArrayList.get(0)).jdField_a_of_type_Int, (AccountSearchPb.record)localObject);
        return true;
      }
    }
    return false;
  }
  
  private String c(SearchBaseFragment.ItemViewHolder paramItemViewHolder, AccountSearchPb.record paramrecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramItemViewHolder.jdField_a_of_type_JavaLangString = (paramrecord.uin.get() + "");
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramrecord.uin.get()));
    localStringBuilder.append(paramItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.getText());
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramItemViewHolder.jdField_a_of_type_JavaLangString);
      paramrecord = localBitmap;
      if (localBitmap == null)
      {
        localBitmap = ImageUtil.a();
        paramrecord = localBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramItemViewHolder.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          paramrecord = localBitmap;
        }
      }
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramrecord);
      return localStringBuilder.toString() + "轻触两次进入资料卡";
      localStringBuilder.append(a(paramItemViewHolder, paramrecord));
      continue;
      localStringBuilder.append(b(paramItemViewHolder, paramrecord));
    }
  }
  
  protected SpannableString a(long paramLong)
  {
    return (SpannableString)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  protected void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("isGetMore = ").append(this.jdField_b_of_type_Boolean).append(" mListData is null = ");
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ClassificationSearchFragment", 2, bool);
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList != null)) {
        break;
      }
      f();
      return;
    }
    if (this.jdField_a_of_type_Gfz == null)
    {
      this.jdField_a_of_type_Gfz = new gfz(this, null);
      this.jdField_a_of_type_Gfz.a(this.jdField_a_of_type_JavaUtilList);
      View localView = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.jdField_d_of_type_Int == 0)
      {
        localObject = "好友";
        label133:
        localView.setContentDescription((String)localObject + "搜索结果");
        this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gfz);
        this.a = this.jdField_a_of_type_Gfz;
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) != this.jdField_a_of_type_ComTencentWidgetXListView)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label273;
      }
      this.jdField_a_of_type_Gfz.a().addAll(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      this.jdField_a_of_type_Gfz.notifyDataSetChanged();
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      return;
      localObject = "生活服务";
      break label133;
      label273:
      this.jdField_a_of_type_Gfz.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    a(3);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_c_of_type_JavaLangString, this.q);
      return;
    }
    if (NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      h();
      this.jdField_c_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(paramString, this.q);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131367328, 0).b(a());
    a(4);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    SearchResult localSearchResult = (SearchResult)paramArrayList.get(0);
    if (b(paramArrayList))
    {
      this.jdField_d_of_type_Boolean = true;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new gfx(this, localSearchResult));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localSearchResult.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilList = localSearchResult.jdField_b_of_type_JavaUtilList;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
    }
    a(this.jdField_c_of_type_JavaUtilHashMap, paramArrayList);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      a(2);
      a(this.jdField_c_of_type_JavaLangString, true);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int == 2) {
      a(0);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (paramView != null)
    {
      if (!(paramView instanceof SearchBaseFragment.ItemViewHolder)) {
        break label34;
      }
      paramView = (SearchBaseFragment.ItemViewHolder)paramView;
      a(paramView.jdField_b_of_type_Int, paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
    }
    label34:
    while ((!(paramView instanceof gfy)) || ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 4))) {
      return;
    }
    if (NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(1);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131367328, 0).b(a());
    a(4);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(2130903814, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_AndroidViewView.setClickable(false);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    int i;
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult != null) {
      if (!jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Boolean)
      {
        i = 1;
        a(i);
        this.jdField_a_of_type_JavaUtilList.addAll(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_b_of_type_Int);
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299721)).setText(ViewFactory.a(jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult.jdField_a_of_type_Int));
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchResult = null;
        this.jdField_c_of_type_JavaUtilHashMap.putAll(jdField_a_of_type_JavaUtilHashMap);
        a();
      }
    }
    for (;;)
    {
      this.q = b();
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */