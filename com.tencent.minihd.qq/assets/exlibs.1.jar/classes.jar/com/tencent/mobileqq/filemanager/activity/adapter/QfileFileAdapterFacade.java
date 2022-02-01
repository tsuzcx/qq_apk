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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class QfileFileAdapterFacade
{
  public static View a(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    QfileFileItemHolder localQfileFileItemHolder = new QfileFileItemHolder();
    paramContext = LayoutInflater.from(paramContext).inflate(2130903761, paramViewGroup, false);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131299529));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localQfileFileItemHolder);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramContext.findViewById(2131299501));
    localQfileFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramContext.findViewById(2131299498));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131299530));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131299503));
    localQfileFileItemHolder.b = ((TextView)paramContext.findViewById(2131299532));
    localQfileFileItemHolder.c = ((TextView)paramContext.findViewById(2131299504));
    localQfileFileItemHolder.d = ((TextView)paramContext.findViewById(2131297921));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131298193));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131299500));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localQfileFileItemHolder);
    paramContext.setTag(localQfileFileItemHolder);
    return paramContext;
  }
  
  public static View a(Context paramContext, FileInfo paramFileInfo, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    if (!paramFileInfo.a()) {
      return a(paramContext, paramViewGroup, paramOnClickListener, paramOnLongClickListener);
    }
    paramContext = new QfileFileItemHolder();
    paramFileInfo = localLayoutInflater.inflate(2130903758, paramViewGroup, false);
    paramFileInfo.setOnClickListener(paramOnClickListener);
    paramContext.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131299522));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131299256));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131299523));
    paramFileInfo.setTag(paramContext);
    return paramFileInfo;
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    if (paramInt == 5)
    {
      FileManagerUtil.a(paramAsyncImageView, paramString, 5);
      return;
    }
    FileManagerUtil.a(paramAsyncImageView, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileFileAdapterFacade
 * JD-Core Version:    0.7.0.1
 */