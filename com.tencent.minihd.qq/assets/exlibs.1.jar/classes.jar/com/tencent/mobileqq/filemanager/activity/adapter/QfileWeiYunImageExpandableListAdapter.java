package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.IWeiYunImageEvent;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import ilo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileWeiYunImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  static final int jdField_c_of_type_Int = 2;
  private static final int f = 3;
  private float jdField_a_of_type_Float = 0.0F;
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QfileCloudFileTabView.IWeiYunImageEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent;
  public final int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private int jdField_d_of_type_Int = 50;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private int e = 0;
  private int g = 0;
  
  public QfileWeiYunImageExpandableListAdapter(QfileCloudFileTabView.IWeiYunImageEvent paramIWeiYunImageEvent, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.c = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = paramOnClickListener3;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent = paramIWeiYunImageEvent;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.e = ((int)(2.0F * this.jdField_a_of_type_Float));
    this.g = ((int)(32.0F * this.jdField_a_of_type_Float));
    this.jdField_d_of_type_Int = a(3);
  }
  
  private int a(int paramInt)
  {
    return (SizeMeasure.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null) - this.g * 2 - this.e * (paramInt - 1)) / paramInt;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    ilo localilo = (ilo)paramView.getTag();
    int i = 0;
    View localView;
    if (i < 3)
    {
      localView = b(paramInt1, paramInt2 * 3 + i, paramBoolean, localilo.a[i], paramViewGroup);
      if (localView != null) {}
    }
    else
    {
      return paramView;
    }
    localilo.a[i] = localView;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new LinearLayout.LayoutParams(this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ((LinearLayout.LayoutParams)localObject).width = this.jdField_d_of_type_Int;
    ((LinearLayout.LayoutParams)localObject).height = this.jdField_d_of_type_Int;
    if (i == 0)
    {
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      label162:
      if (paramInt2 != 0) {
        break label205;
      }
    }
    label205:
    for (((LinearLayout.LayoutParams)localObject).topMargin = (this.g / 2);; ((LinearLayout.LayoutParams)localObject).topMargin = this.e)
    {
      paramView.addView(localView);
      i += 1;
      break;
      ((LinearLayout.LayoutParams)localObject).leftMargin = this.e;
      break label162;
    }
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new ilo(null));
    paramViewGroup.setPadding(this.g, 0, this.g, 0);
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    label284:
    View localView;
    for (WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramViewGroup;; localView = null)
    {
      if (localWeiYunFileInfo == null)
      {
        if (a(paramInt1, paramInt2) == 1) {
          return null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.c()) {
          return null;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("@#@#@#", 4, "groupPosition[" + paramInt1 + "],position[" + paramInt2 + "] add getMoreButton");
        }
        paramView = new QfileWeiYunImageExpandableListAdapter.ImageHolder(this);
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903756, null);
        paramViewGroup.setClickable(true);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299471));
        paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296735));
        paramView.c = ((ImageView)paramViewGroup.findViewById(2131297996));
        paramView.jdField_a_of_type_Boolean = true;
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.a(paramView.jdField_a_of_type_AndroidWidgetTextView));
        paramViewGroup.setTag(paramView);
        if ((this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.a()))
        {
          paramViewGroup.setVisibility(8);
          if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView$IWeiYunImageEvent.b()) {
            break label284;
          }
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          paramView.c.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131362474);
        }
        for (;;)
        {
          return paramViewGroup;
          paramViewGroup.setVisibility(0);
          break;
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView.c.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131362391);
        }
      }
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903764, null);
          paramViewGroup = paramView;
          paramView.setOnClickListener(this.c);
          paramViewGroup = paramView;
          localObject = new QfileWeiYunImageExpandableListAdapter.ImageHolder(this);
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296300));
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299535));
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).b = ((ImageView)paramView.findViewById(2131297175));
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_Boolean = false;
          paramViewGroup = paramView;
          paramView.setTag(localObject);
          paramViewGroup = (ViewGroup)localObject;
        }
        catch (Exception paramView)
        {
          Object localObject;
          localView = paramView;
          continue;
          paramViewGroup = (ViewGroup)localObject;
          continue;
        }
        try
        {
          paramViewGroup.jdField_a_of_type_JavaLangObject = localWeiYunFileInfo;
          paramViewGroup.jdField_a_of_type_Int = paramInt2;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841071);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
          paramViewGroup.jdField_a_of_type_Boolean = false;
          paramInt1 = paramInt2 / 3;
          localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362464), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
          if ((localWeiYunFileInfo.g != null) && (localWeiYunFileInfo.g.length() > 0) && (FileUtil.b(localWeiYunFileInfo.g))) {
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localWeiYunFileInfo.g);
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h()) || (!FMDataCache.a(localWeiYunFileInfo))) {
            continue;
          }
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131427404));
          paramView.setOnLongClickListener(null);
          return paramView;
        }
        catch (Exception localException)
        {
          paramViewGroup = paramView;
        }
        localException.printStackTrace();
        QLog.e("#######", 1, localException.toString());
        return paramViewGroup;
        paramViewGroup = paramView;
        localObject = (QfileWeiYunImageExpandableListAdapter.ImageHolder)paramView.getTag();
        paramViewGroup = paramView;
        if (((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_Boolean == true)
        {
          paramViewGroup = paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903764, null);
          paramViewGroup = paramView;
          paramView.setOnClickListener(this.c);
          paramViewGroup = paramView;
          localObject = new QfileWeiYunImageExpandableListAdapter.ImageHolder(this);
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131296300));
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299535));
          paramViewGroup = paramView;
          ((QfileWeiYunImageExpandableListAdapter.ImageHolder)localObject).b = ((ImageView)paramView.findViewById(2131297175));
          paramViewGroup = paramView;
          paramView.setTag(localObject);
          paramViewGroup = (ViewGroup)localObject;
          continue;
          paramViewGroup.b.setVisibility(4);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          return paramView;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size()) {
      return 1;
    }
    if (paramInt2 == ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(getGroup(paramInt1))).size()) {
      return 2;
    }
    return 1;
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_d_of_type_Int = a(3);
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
  }
  
  public int getChildrenCount(int paramInt)
  {
    int k = 0;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i != paramInt) {
          break label82;
        }
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          j = 1;
        }
      }
      else
      {
        return j;
      }
      return paramInt / 4 + 1;
      label82:
      i += 1;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileWeiYunImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */