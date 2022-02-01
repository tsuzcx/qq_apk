package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import java.util.List;

public class LebaListViewAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final String a = "empty_normal";
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 0;
  public static final String b = "empty_header_footer";
  public static final int c = 1;
  public static final int d = 2;
  Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  String c = "";
  private int e;
  private int f;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = paramInt1;
    this.f = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("mobileQQ", 0);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("leba_red_touch", paramBoolean).commit();
  }
  
  private void a(LebaViewItem paramLebaViewItem, ImageView paramImageView)
  {
    paramLebaViewItem = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName;
    paramImageView.setImageResource(2130841952);
    if ((paramLebaViewItem != null) && ((paramLebaViewItem.equals("com.tencent.xiaoshuo2.androidhd")) || (paramLebaViewItem.equals("com.tencent.manhua2.androidhd"))) && (a(paramLebaViewItem)))
    {
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramRedTouch.a(((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString));
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getBoolean("leba_red_touch", true);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, false).commit();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return !TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, true);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    if (localLebaViewItem.jdField_a_of_type_JavaLangString.equals("empty_header_footer")) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItem(paramInt) == null) {
      return paramView;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    int i = getItemViewType(paramInt);
    if (i == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.e, null);
        paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297525));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297528));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297527));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131297211));
        paramView.setTag(paramViewGroup);
        label115:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        a(localLebaViewItem, paramViewGroup.b);
        if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label204;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
        label160:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        paramViewGroup = paramView;
      }
    }
    for (;;)
    {
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
      break label115;
      label204:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840354);
      break label160;
      if (i == 1)
      {
        View localView = paramView;
        if (paramView == null) {
          localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.f, null);
        }
        paramViewGroup = localView;
        if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
        {
          paramViewGroup = localView;
          if (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName))
          {
            localView.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
            paramViewGroup = localView;
          }
        }
      }
      else if (i == 2)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903277, null);
        }
      }
      else
      {
        paramViewGroup = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((LebaViewItem)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */