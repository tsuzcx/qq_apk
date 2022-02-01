package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class BaseFileAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  
  public BaseFileAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = paramMotionViewSetter;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, Object paramObject)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_a_of_type_JavaLangObject.equals(paramObject)))
      {
        bool = true;
        paramShaderAnimLayout.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.c();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, String paramString)
  {
    boolean bool = false;
    if (paramShaderAnimLayout != null)
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        bool = true;
        paramShaderAnimLayout.a();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramButton.setTag(Integer.valueOf(paramInt));
      }
    }
    else {
      return bool;
    }
    paramShaderAnimLayout.c();
    paramButton.setOnClickListener(null);
    paramButton.setTag(null);
    return false;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.BaseFileAdapter
 * JD-Core Version:    0.7.0.1
 */