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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import ili;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileLocalImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  static final int jdField_a_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private float jdField_a_of_type_Float = 0.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private int jdField_b_of_type_Int = 50;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int = 0;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private int e = 0;
  
  public QfileLocalImageExpandableListAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.d = paramOnClickListener3;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = ((int)(2.0F * this.jdField_a_of_type_Float));
    this.e = ((int)(32.0F * this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Int = a(3);
  }
  
  private int a(int paramInt)
  {
    return (SizeMeasure.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, null) - this.e * 2 - this.jdField_c_of_type_Int * (paramInt - 1)) / paramInt;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a(paramViewGroup);
    }
    paramView.removeAllViews();
    ili localili = (ili)paramView.getTag();
    int i = 0;
    View localView;
    if (i < 3)
    {
      localView = b(paramInt1, paramInt2 * 3 + i, paramBoolean, localili.a[i], paramViewGroup);
      if (localView != null) {}
    }
    else
    {
      return paramView;
    }
    localili.a[i] = localView;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    ((LinearLayout.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
    ((LinearLayout.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
    if (i == 0)
    {
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      label162:
      if (paramInt2 != 0) {
        break label205;
      }
    }
    label205:
    for (((LinearLayout.LayoutParams)localObject).topMargin = (this.e / 2);; ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_c_of_type_Int)
    {
      paramView.addView(localView);
      i += 1;
      break;
      ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_c_of_type_Int;
      break label162;
    }
  }
  
  private LinearLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    paramViewGroup.setOrientation(0);
    paramViewGroup.setClickable(false);
    paramViewGroup.setLongClickable(false);
    paramViewGroup.setTag(new ili(null));
    paramViewGroup.setPadding(this.e, 0, this.e, 0);
    return paramViewGroup;
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (FileInfo localFileInfo = (FileInfo)paramViewGroup;; localFileInfo = null)
    {
      if (localFileInfo == null) {
        return null;
      }
      if (paramView == null) {}
      try
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903764, null);
        paramView = paramViewGroup;
        try
        {
          paramViewGroup.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
          paramView = paramViewGroup;
          QfileLocalImageExpandableListAdapter.ImageHolder localImageHolder = new QfileLocalImageExpandableListAdapter.ImageHolder(this);
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131296300));
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131299535));
          paramView = paramViewGroup;
          localImageHolder.b = ((ImageView)paramViewGroup.findViewById(2131297175));
          paramView = paramViewGroup;
          paramViewGroup.setTag(localImageHolder);
          paramView = paramViewGroup;
          localFileInfo.a((String)getGroup(paramInt1));
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_JavaLangObject = localFileInfo;
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_Int = paramInt2;
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841071);
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          paramView = paramViewGroup;
          paramInt1 = paramInt2 / 3;
          paramView = paramViewGroup;
          String str = String.format(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131362464), new Object[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf((paramInt2 & 0x3) + 1) });
          paramView = paramViewGroup;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(str);
          paramView = paramViewGroup;
          if (localFileInfo.d() != null)
          {
            paramView = paramViewGroup;
            if (localFileInfo.d().length() > 0)
            {
              paramView = paramViewGroup;
              if (FileUtil.b(localFileInfo.d()))
              {
                paramView = paramViewGroup;
                localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileInfo.d());
              }
            }
          }
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())
          {
            paramView = paramViewGroup;
            if (FMDataCache.a(localFileInfo))
            {
              paramView = paramViewGroup;
              localImageHolder.b.setVisibility(0);
              paramView = paramViewGroup;
              localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131427404));
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
            }
          }
          for (;;)
          {
            return paramViewGroup;
            localImageHolder = (QfileLocalImageExpandableListAdapter.ImageHolder)paramView.getTag();
            paramViewGroup = paramView;
            break;
            paramView = paramViewGroup;
            localImageHolder.b.setVisibility(4);
            paramView = paramViewGroup;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            paramView = paramViewGroup;
            paramViewGroup.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          }
          paramViewGroup.printStackTrace();
        }
        catch (Exception paramViewGroup) {}
      }
      catch (Exception paramViewGroup)
      {
        label510:
        break label510;
      }
      QLog.e("#######", 1, paramViewGroup.toString());
      return paramView;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_b_of_type_Int = a(3);
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
        if (i == paramInt) {
          j = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size() / 4 + 1;
        }
      }
      else
      {
        return j;
      }
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */