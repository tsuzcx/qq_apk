package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class QfileLocalFileCategoryAdapter
  extends QfileBaseExpandableListAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnLongClickListener a;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
  protected View.OnClickListener b;
  
  public QfileLocalFileCategoryAdapter(Context paramContext, Object paramObject, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    super(paramContext, paramObject);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.b = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (localFileInfo == null) {
      return null;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = QfileFileAdapterFacade.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileInfo, paramViewGroup, this.b, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    paramView = (QfileFileItemHolder)localView.getTag();
    paramView.jdField_a_of_type_JavaLangObject = localFileInfo;
    if (localFileInfo.a())
    {
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130839644);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.e());
      return localView;
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    QfileFileAdapterFacade.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.d(), FileManagerUtil.a(localFileInfo.d()));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.e());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.h())
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131362543);
      paramViewGroup = QfileTimeUtils.b(localFileInfo.b());
      paramView.b.setText(FileUtil.a(localFileInfo.a()));
      paramView.d.setText(paramViewGroup);
      return localView;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */