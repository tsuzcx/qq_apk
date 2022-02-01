package com.tencent.mobileqq.activity.widget.qqmusic.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter;
import hdi;
import hdj;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class FolderListAdapter
  extends PinnedHeaderExpandableListView.ExpandableListAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "liwei";
  private final Context jdField_a_of_type_AndroidContentContext;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ExpandableListView a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public FolderListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    a();
  }
  
  public int a()
  {
    return 2130903949;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365005));
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365006));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a(View paramView, int paramInt)
  {
    hdj localhdj2 = (hdj)paramView.getTag();
    hdj localhdj1 = localhdj2;
    if (localhdj2 == null)
    {
      localhdj1 = new hdj();
      paramView.findViewById(2131297233).setVisibility(0);
      localhdj1.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297234));
      paramView.setTag(localhdj1);
    }
    localhdj1.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (paramArrayList1 != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), (ArrayList)paramArrayList1.clone());
    }
    if (paramArrayList2 != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), (ArrayList)paramArrayList2.clone());
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903945, paramViewGroup, false);
      paramViewGroup = new hdi();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300163));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300164));
      paramView.setTag(paramViewGroup);
      localObject2 = (FolderInfo)((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1))).get(paramInt2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((FolderInfo)localObject2).a());
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840655);
      if (!TextUtils.isEmpty(((FolderInfo)localObject2).b())) {
        break label155;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (hdi)paramView.getTag();
      break;
      try
      {
        label155:
        localObject2 = new URL(((FolderInfo)localObject2).b());
        localObject1 = URLDrawable.getDrawable(new URL("folder", ((URL)localObject2).getAuthority(), ((URL)localObject2).getFile()), (Drawable)localObject1, (Drawable)localObject1);
        if (localObject1 != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          return paramView;
        }
      }
      catch (MalformedURLException paramViewGroup)
      {
        MLog.d("liwei", "set child view image error : " + paramViewGroup.getMessage());
      }
    }
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return 0;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localArrayList == null) {}
    for (paramInt = 0;; paramInt = localArrayList.size()) {
      return paramInt;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      hdj localhdj = (hdj)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localhdj;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      if (!paramBoolean) {
        break;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841853);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903949, paramViewGroup, false);
      paramView = new hdj();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297233));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297234));
      paramViewGroup.setTag(paramView);
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841854);
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.ui.FolderListAdapter
 * JD-Core Version:    0.7.0.1
 */