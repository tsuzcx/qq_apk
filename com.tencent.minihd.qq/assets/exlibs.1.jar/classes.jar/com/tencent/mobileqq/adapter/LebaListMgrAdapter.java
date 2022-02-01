package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import hfn;
import hfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LebaListMgrAdapter
  extends BaseAdapter
{
  private static final int b = 3;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private float jdField_a_of_type_Float;
  protected int a;
  protected Drawable a;
  protected LayoutInflater a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LebaListMgrActivity jdField_a_of_type_ComTencentMobileqqActivityLebaListMgrActivity;
  protected QQAppInterface a;
  protected String a;
  protected HashMap a;
  protected List a;
  
  public LebaListMgrAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityLebaListMgrActivity = ((LebaListMgrActivity)paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840354);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131493316);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localObject instanceof LebaViewItem))
      {
        if (((LebaViewItem)localObject).jdField_a_of_type_Byte != 0) {
          break label79;
        }
        localArrayList1.add((LebaViewItem)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        label79:
        localArrayList2.add((LebaViewItem)localObject);
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localArrayList1.size() > 0)
    {
      Collections.sort(localArrayList1, new LebaUtil.LebaItemComparator());
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
      a(localArrayList1);
    }
    if (localArrayList2.size() > 0)
    {
      Collections.sort(localArrayList2, new LebaUtil.LebaItemComparator());
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(1));
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      a(localArrayList2);
    }
  }
  
  private void a(LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    byte b1 = 0;
    if (paramLebaViewItem.jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true; paramBoolean == bool; bool = false) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramLebaViewItem.jdField_a_of_type_Byte = b1;
      long l = NetConnInfoCenter.getServerTimeMillis();
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(33)).a(String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), paramBoolean, l);
      a();
      notifyDataSetChanged();
      return;
      b1 = 1;
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((LebaViewItem)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((LebaViewItem)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((LebaViewItem)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public void a(LebaListMgrAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem != null))
    {
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
    else {
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840354);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      paramView = (TextView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903934, paramViewGroup, false);
      paramView.setText(paramView.getResources().getString(2131366564));
      paramView.setFocusable(true);
      return paramView;
    }
    if (i == 1)
    {
      paramView = (TextView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903934, paramViewGroup, false);
      paramView.setText(paramView.getResources().getString(2131366565));
      paramView.setFocusable(true);
      return paramView;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return paramView;
    }
    Object localObject;
    if (paramView == null)
    {
      paramView = new LebaListMgrAdapter.ViewHolder();
      localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903275, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131297525));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131297528));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131297527));
      paramView.b = ((ImageView)((View)localObject).findViewById(2131297526));
      paramView.c = ((ImageView)((View)localObject).findViewById(2131297211));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityLebaListMgrActivity.a) {
        break label406;
      }
      paramViewGroup.b.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131297526);
      ((RelativeLayout.LayoutParams)localObject).setMargins((int)(13.0F * this.jdField_a_of_type_Float), 0, 0, 0);
      paramViewGroup.c.setVisibility(8);
      label300:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (localLebaViewItem.jdField_a_of_type_Byte != 0) {
        break label450;
      }
      paramViewGroup.b.setImageResource(2130840352);
      paramViewGroup.b.setOnClickListener(new hfn(this, localLebaViewItem));
      label344:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
      if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label480;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return paramView;
      paramViewGroup = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
      break;
      label406:
      paramViewGroup.b.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).setMargins((int)(32.0F * this.jdField_a_of_type_Float), 0, 0, 0);
      paramViewGroup.c.setVisibility(0);
      break label300;
      label450:
      paramViewGroup.b.setImageResource(2130840351);
      paramViewGroup.b.setOnClickListener(new hfo(this, localLebaViewItem));
      break label344;
      label480:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840354);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListMgrAdapter
 * JD-Core Version:    0.7.0.1
 */