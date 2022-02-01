package com.tencent.mobileqq.dating.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.dating.DatingDetailItemView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import ies;

public class InputBar
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public InputBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public InputBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(AdapterView paramAdapterView, int paramInt)
  {
    int i = 0;
    while (i < paramAdapterView.getChildCount())
    {
      View localView = paramAdapterView.getChildAt(i);
      if (paramInt == a(paramAdapterView, localView)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public int a(AdapterView paramAdapterView, View paramView)
  {
    int j = paramAdapterView.c(paramView);
    int i = j;
    if ((paramAdapterView instanceof ListView)) {
      i = j - ((ListView)paramAdapterView).m();
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void a(boolean paramBoolean, ListView paramListView, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
      } while (paramListView == null);
      this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
      this.jdField_a_of_type_Int = paramInt;
      this.f = this.jdField_a_of_type_ComTencentWidgetListView.m();
      this.e = getResources().getDimensionPixelSize(2131492923);
      paramListView = a(this.jdField_a_of_type_ComTencentWidgetListView, paramInt);
    } while (!(paramListView instanceof DatingDetailItemView));
    paramListView = (DatingDetailItemView)paramListView;
    this.b = paramListView.getBottom();
    this.c = paramListView.getMeasuredHeight();
  }
  
  @TargetApi(11)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.e("datingDetail", 4, "inputBar onLayout top is: " + paramInt2 + "changed is: " + paramBoolean);
        }
      } while (paramInt2 <= 0);
      if (this.d <= 0)
      {
        this.d = paramInt2;
        this.g = paramInt2;
        return;
      }
      if ((paramInt2 != this.d) && (paramInt2 == this.g))
      {
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_ComTencentWidgetListView.b(this.jdField_a_of_type_AndroidViewView);
        }
        this.d = paramInt2;
        return;
      }
    } while ((paramInt2 == this.d) || (paramInt2 == this.g));
    getHandler().post(new ies(this, paramInt2));
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.InputBar
 * JD-Core Version:    0.7.0.1
 */