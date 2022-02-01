package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import cpd;
import java.util.ArrayList;
import java.util.List;

public class PopupMenu
  extends PopupWindows
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public CustomMenuBar.OnMenuItemClickListener a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int f;
  private int g;
  
  public PopupMenu(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    a(2130903298);
    this.g = 4;
    this.f = 0;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (this.g)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131558610);
  }
  
  public MenuItem a(int paramInt)
  {
    return (MenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131297600));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.b(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    a();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.jdField_a_of_type_AndroidViewView.measure(-2, -2);
    int k = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int j = arrayOfInt[0];
    k = (paramView.getWidth() - k) / 2;
    int m = localRect.top;
    int n = localRect.height() / 2;
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, j + k, n + (m - i));
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    String str = paramMenuItem.a();
    Drawable localDrawable = paramMenuItem.a();
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903297, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131297596);
    TextView localTextView = (TextView)localView.findViewById(2131297597);
    if (localDrawable != null)
    {
      localImageView.setImageDrawable(localDrawable);
      if (str == null) {
        break label184;
      }
      if (SubString.a(str) <= 18) {
        break label175;
      }
      localTextView.setText(SubString.a(str, 18, "..."));
    }
    for (;;)
    {
      localView.setOnClickListener(new cpd(this, paramMenuItem.b(), paramMenuItem.a()));
      localView.setFocusable(true);
      localView.setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      paramMenuItem.gravity = 17;
      localView.setLayoutParams(paramMenuItem);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      this.f += 1;
      return;
      localImageView.setVisibility(8);
      break;
      label175:
      localTextView.setText(str);
      continue;
      label184:
      localTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.ui.PopupMenu
 * JD-Core Version:    0.7.0.1
 */