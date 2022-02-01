package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import ixm;
import ixn;
import ixo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseActionBar
{
  protected View a;
  public RelativeLayout a;
  public BaseActionBar.IActionBarClickEvent a;
  public HorizontalListViewAdapter a;
  public IconPopupWindow a;
  public ActionSheet a;
  ArrayList a;
  ArrayList b = new ArrayList();
  ArrayList c = new ArrayList();
  
  public BaseActionBar(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = null;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299482);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131299492).setVisibility(8);
  }
  
  private Button a(int paramInt)
  {
    if (((paramInt >= 4) || (paramInt < 0)) && (QLog.isDevelopLevel())) {
      throw new IndexOutOfBoundsException();
    }
    Button localButton = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localButton == null) {
        QLog.e("BaseActinBar<FileAssistant>", 1, "addActionBar getButton index is[" + paramInt + "]");
      }
      return localButton;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299488);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299489);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299490);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299491);
    }
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {
      return;
    }
    localButton.setText(paramString);
    localButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {
      return;
    }
    localButton.setEnabled(paramBoolean);
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(paramOnClickListener);
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.jdField_a_of_type_JavaUtilArrayList.add(localActionBar);
  }
  
  public void a(Context paramContext, List paramList, View paramView)
  {
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow = new IconPopupWindow(paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.b();
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramList = (ActionBar)paramContext.next();
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramList.a(), paramList.a(), 0, null, paramList.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a(paramView, 5);
  }
  
  public void a(BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = paramIActionBarClickEvent;
  }
  
  public void a(Object paramObject) {}
  
  public ArrayList b()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    return this.b;
  }
  
  public void b(Activity paramActivity)
  {
    a(3, "更多", new ixn(this, paramActivity));
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(paramOnClickListener);
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.b.add(localActionBar);
  }
  
  public ArrayList c()
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    return this.c;
  }
  
  public void c(Activity paramActivity)
  {
    a(1, "转发", new ixm(this, paramActivity));
  }
  
  public void c(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(paramOnClickListener);
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.c.add(localActionBar);
  }
  
  public void d(Activity paramActivity)
  {
    a(0, "打开原文件", new ixo(this, paramActivity));
  }
  
  public void e_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar
 * JD-Core Version:    0.7.0.1
 */