package com.tencent.widget;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lrg;

public class ActionSheetAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  Context jdField_a_of_type_AndroidContentContext;
  final List jdField_a_of_type_JavaUtilList;
  
  public ActionSheetAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramActionSheetAdapter, paramOnItemClickListener, paramOnDismissListener, paramBoolean);
    paramContext.e(2131365736);
    paramContext.a(paramOnButtonClickListener);
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2130904504, null);
      paramContext.setBackgroundResource(2130837531);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.a(paramContext);
      if (paramBoolean)
      {
        localActionSheet.setOnDismissListener(new lrg(paramOnDismissListener));
        return localActionSheet;
      }
      localActionSheet.setOnDismissListener(paramOnDismissListener);
      return localActionSheet;
    }
    return null;
  }
  
  public static ActionSheetAdapter.ShareChanelInfo a(int paramInt)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo2 = null;
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo1 = localShareChanelInfo2;
    if (paramInt >= 0)
    {
      localShareChanelInfo1 = localShareChanelInfo2;
      if (paramInt <= 5)
      {
        localShareChanelInfo2 = new ActionSheetAdapter.ShareChanelInfo();
        localShareChanelInfo1 = localShareChanelInfo2;
      }
    }
    switch (paramInt)
    {
    default: 
      localShareChanelInfo1 = localShareChanelInfo2;
    case 2: 
    case 3: 
      return localShareChanelInfo1;
    case 0: 
      localShareChanelInfo2.a = 0;
      localShareChanelInfo2.b = 2131366053;
      localShareChanelInfo2.c = 2130841175;
      localShareChanelInfo2.d = 2131367843;
      return localShareChanelInfo2;
    case 1: 
      localShareChanelInfo2.a = 1;
      localShareChanelInfo2.b = 2131367820;
      localShareChanelInfo2.c = 2130837972;
      localShareChanelInfo2.d = 2131367844;
      return localShareChanelInfo2;
    case 5: 
      localShareChanelInfo2.a = 5;
      localShareChanelInfo2.b = 2131363587;
      localShareChanelInfo2.c = 2130839098;
      localShareChanelInfo2.d = 2131363560;
      return localShareChanelInfo2;
    }
    localShareChanelInfo2.a = 4;
    localShareChanelInfo2.c = 2130837969;
    localShareChanelInfo2.b = 2131367821;
    localShareChanelInfo2.d = 2131367845;
    return localShareChanelInfo2;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)paramList.next();
        if ((localShareChanelInfo != null) && (localShareChanelInfo.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localShareChanelInfo);
        }
      }
    }
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
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    if (localShareChanelInfo != null) {
      return localShareChanelInfo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904492, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131298904);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131298905);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    while (localShareChanelInfo != null)
    {
      paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
      return paramViewGroup;
      paramView.setImageResource(2130841175);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */