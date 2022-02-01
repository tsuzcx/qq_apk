package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public abstract class RecentItemBaseBuilder
{
  public static final String a = "tag_recent_item_menu_item";
  public static final int[] a;
  public static final int[] b = { 2130838177, 2130838184, 2130838173, 2130838173, 2130838181, 2130838187 };
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  protected RecentAdapter a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131366672, 2131368077, 2131369355, 2131369356, 2131369354, 2131369353 };
  }
  
  public RecentItemBaseBuilder() {}
  
  public RecentItemBaseBuilder(int paramInt) {}
  
  public abstract View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener);
  
  public final View a(Context paramContext, int paramInt1, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, int paramInt2)
  {
    View localView3 = null;
    View localView2 = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    View localView1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a()))
    {
      paramRecentItemBaseHolder.a = new ImageView[paramInt2];
      localView3 = a(paramContext, paramInt2, paramRecentItemBaseHolder.a);
      localView1 = a(paramContext, localView2, localView3);
    }
    for (paramContext = localView3;; paramContext = localView3)
    {
      paramRecentItemBaseHolder.c = localView2;
      paramRecentItemBaseHolder.d = paramContext;
      return localView1;
      localView1 = localView2;
    }
  }
  
  public View a(Context paramContext, int paramInt, ImageView[] paramArrayOfImageView)
  {
    if ((paramContext == null) || (paramInt == 0)) {
      return null;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    int i1 = paramContext.getResources().getDimensionPixelSize(2131493328);
    int i2 = paramContext.getResources().getDimensionPixelSize(2131493327);
    int n = 0;
    while (n < paramInt)
    {
      ImageView localImageView = (ImageView)LayoutInflater.from(paramContext).inflate(2130904378, null);
      localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(i1, i2));
      if ((paramArrayOfImageView != null) && (n < paramArrayOfImageView.length)) {
        paramArrayOfImageView[n] = localImageView;
      }
      n += 1;
    }
    return localLinearLayout;
  }
  
  public View a(Context paramContext, View paramView1, View paramView2)
  {
    if ((paramContext == null) || (paramView1 == null) || (paramView2 == null))
    {
      if (paramView1 != null) {
        return paramView1;
      }
      return paramView2;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(paramView1, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(paramView2, new LinearLayout.LayoutParams(paramContext.getResources().getDimensionPixelSize(2131493328), -2));
    return localLinearLayout;
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    return null;
  }
  
  public void a(Context paramContext, View paramView, int paramInt, Object paramObject, RecentItemBaseBuilder.RecentItemBaseHolder paramRecentItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if ((paramRecentItemBaseHolder == null) || (paramView == null) || (paramRecentItemBaseHolder.d == null) || (paramRecentItemBaseHolder.a == null) || (paramRecentItemBaseHolder.a.length == 0)) {
      return;
    }
    int i3 = paramRecentItemBaseHolder.a.length;
    if ((paramObject instanceof RecentBaseData)) {}
    for (int i2 = ((RecentBaseData)paramObject).G;; i2 = 0)
    {
      int n = 0;
      int i1 = n;
      if (i3 < 0)
      {
        i1 = n;
        if (paramRecentItemBaseHolder.a[0] != null)
        {
          i1 = n;
          if ((i2 & 0xF00) == 256)
          {
            a(paramRecentItemBaseHolder.a[0], paramInt, b[1], jdField_a_of_type_ArrayOfInt[1], 2130838176, paramOnClickListener);
            i1 = 1;
          }
        }
      }
      n = i1;
      int i4;
      if (i1 < i3)
      {
        n = i1;
        if (paramRecentItemBaseHolder.a[i1] != null)
        {
          i4 = 0xF000 & i2;
          if (i4 != 4096) {
            break label436;
          }
          a(paramRecentItemBaseHolder.a[i1], paramInt, b[2], jdField_a_of_type_ArrayOfInt[2], 2130838176, paramOnClickListener);
          n = i1 + 1;
        }
      }
      i1 = n;
      if (n < i3)
      {
        i1 = n;
        if (paramRecentItemBaseHolder.a[n] != null)
        {
          i4 = i2 & 0xF0;
          if (i4 != 32) {
            break label484;
          }
          a(paramRecentItemBaseHolder.a[n], paramInt, b[4], jdField_a_of_type_ArrayOfInt[4], 2130838176, paramOnClickListener);
          i1 = n + 1;
        }
      }
      label280:
      if ((i1 < i3) && (paramRecentItemBaseHolder.a[i1] != null) && ((i2 & 0xF) == 1)) {
        a(paramRecentItemBaseHolder.a[i1], paramInt, b[0], jdField_a_of_type_ArrayOfInt[0], 2130838178, paramOnClickListener);
      }
      for (n = i1 + 1;; n = i1)
      {
        i1 = n;
        for (;;)
        {
          if (i1 < i3)
          {
            if (paramRecentItemBaseHolder.a[n] != null)
            {
              paramRecentItemBaseHolder.a[i1].setVisibility(8);
              paramRecentItemBaseHolder.a[i1].setImageResource(0);
              paramRecentItemBaseHolder.a[i1].setTag(null);
              paramRecentItemBaseHolder.a[i1].setTag(-1, Integer.valueOf(paramInt));
              paramRecentItemBaseHolder.a[i1].setOnClickListener(null);
            }
            i1 += 1;
            continue;
            label436:
            n = i1;
            if (i4 != 8192) {
              break;
            }
            a(paramRecentItemBaseHolder.a[i1], paramInt, b[3], jdField_a_of_type_ArrayOfInt[3], 2130838176, paramOnClickListener);
            n = i1 + 1;
            break;
            label484:
            i1 = n;
            if (i4 != 16) {
              break label280;
            }
            a(paramRecentItemBaseHolder.a[n], paramInt, b[5], jdField_a_of_type_ArrayOfInt[5], 2130838176, paramOnClickListener);
            i1 = n + 1;
            break label280;
          }
        }
        n = paramContext.getResources().getDimensionPixelSize(2131493328) * n;
        paramContext = (LinearLayout.LayoutParams)paramRecentItemBaseHolder.d.getLayoutParams();
        if ((paramContext != null) && (paramContext.width != n)) {
          paramContext.width = n;
        }
        paramView.setTag(-3, Integer.valueOf(n));
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c == -1)) {
          break;
        }
        if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.c)
        {
          paramView.scrollTo(0, 0);
          return;
        }
        paramView.scrollTo(n, 0);
        return;
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable) {}
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable, QQAppInterface paramQQAppInterface) {}
  
  public void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(paramInt2);
      paramImageView.setBackgroundResource(paramInt4);
      paramImageView.setTag("tag_recent_item_menu_item");
      paramImageView.setTag(-2, Integer.valueOf(paramInt3));
      paramImageView.setTag(-1, Integer.valueOf(paramInt1));
      paramImageView.setContentDescription(paramImageView.getResources().getString(paramInt3));
      paramImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder
 * JD-Core Version:    0.7.0.1
 */