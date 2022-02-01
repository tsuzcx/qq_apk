package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import jaf;
import java.io.File;
import java.util.List;

public class FileViewerGalleryAdapter
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "FileViewerGalleryAdapter";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private List jdField_a_of_type_JavaUtilList;
  private Drawable b;
  private Drawable c = null;
  
  public FileViewerGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_Int *= 2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130842124);
    this.b = paramContext.getResources().getDrawable(2130838136);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903785, null);
      paramViewGroup = new jaf(this, null);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131296300));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131299594));
      paramView.setTag(paramViewGroup);
    }
    IFileViewerAdapter localIFileViewerAdapter;
    for (;;)
    {
      localIFileViewerAdapter = (IFileViewerAdapter)getItem(paramInt);
      if (localIFileViewerAdapter != null) {
        break;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
      paramViewGroup = (jaf)paramView.getTag();
    }
    Object localObject1 = localIFileViewerAdapter.h();
    Object localObject2;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      localObject2 = localIFileViewerAdapter.g();
      localObject1 = localObject2;
      paramInt = i;
      if (localObject2 == null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return paramView;
      }
    }
    else
    {
      paramInt = 1;
    }
    File localFile = new File((String)localObject1);
    if (localFile.exists()) {
      for (;;)
      {
        try
        {
          Drawable localDrawable = this.b;
          localObject2 = localDrawable;
          if (paramInt != 0)
          {
            localObject2 = localDrawable;
            if (this.c != null)
            {
              localObject2 = localDrawable;
              if (this.jdField_a_of_type_Long == localIFileViewerAdapter.b()) {
                localObject2 = this.c;
              }
            }
          }
          localObject1 = URLDrawable.getDrawable(FileManagerUtil.a((String)localObject1, -1, -1, localFile), (Drawable)localObject2, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          ((URLDrawable)localObject1).setTargetDensity(this.jdField_a_of_type_Int);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
          if (localIFileViewerAdapter.a() == 1)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
            this.c = null;
            this.jdField_a_of_type_Long = -1L;
            if (paramInt != 0) {
              break;
            }
            this.c = ((Drawable)localObject1);
            this.jdField_a_of_type_Long = localIFileViewerAdapter.b();
            return paramView;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isDevelopLevel()) {
            QLog.e("FileViewerGalleryAdapter", 4, localException.toString());
          }
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          return paramView;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      }
    }
    if ((localIFileViewerAdapter.d() == 7) && (localException != null) && (localException.startsWith("http://")))
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localException);
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */