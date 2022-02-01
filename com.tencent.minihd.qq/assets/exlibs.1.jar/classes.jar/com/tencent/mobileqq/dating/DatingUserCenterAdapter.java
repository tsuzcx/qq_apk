package com.tencent.mobileqq.dating;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import icn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DatingUserCenterAdapter
  extends DismissAnimationAdapter
{
  private int jdField_a_of_type_Int = 0;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private DatingItemBuilder jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder;
  private icn jdField_a_of_type_Icn;
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  public DatingUserCenterAdapter(Context paramContext, QQAppInterface paramQQAppInterface, FaceDecoder paramFaceDecoder, int paramInt, icn paramicn)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Icn = paramicn;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder = new DatingItemBuilder(paramQQAppInterface, paramContext, paramFaceDecoder);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(paramicn);
  }
  
  public DatingInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (DatingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public DatingItemBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder;
  }
  
  protected void a()
  {
    a(false);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(int paramInt)
  {
    if (this.c == paramInt) {
      return;
    }
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(int paramInt, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    if (paramBoolean1) {
      notifyDataSetChanged();
    }
  }
  
  public void a(ListView paramListView, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramString.equals(((DatingInfo)this.jdField_a_of_type_JavaUtilList.get(i)).datingId))
        {
          paramString = new ArrayList();
          paramString.add(Integer.valueOf(i));
          a(paramListView, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(ListView paramListView, List paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      int j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          if ((!TextUtils.isEmpty((CharSequence)paramList.get(j))) && (((String)paramList.get(j)).equals(((DatingInfo)this.jdField_a_of_type_JavaUtilList.get(i)).datingId))) {
            localArrayList.add(Integer.valueOf(i));
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    a(paramListView, localArrayList);
  }
  
  protected void a(Collection paramCollection)
  {
    if (this.jdField_a_of_type_Icn != null) {
      this.jdField_a_of_type_Icn.a(this.jdField_a_of_type_Int, paramCollection);
    }
  }
  
  public void b(int paramInt)
  {
    b(this.jdField_a_of_type_AndroidViewView, paramInt);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903896, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, paramViewGroup.getHeight() - this.jdField_b_of_type_Int));
      paramView.findViewById(2131299997).setVisibility(8);
      paramView.findViewById(2131299995).setVisibility(0);
      paramViewGroup = (TextView)paramView.findViewById(2131299996);
      if (this.jdField_a_of_type_Int == 0) {}
      for (paramInt = 2131369790;; paramInt = 2131369791)
      {
        paramViewGroup.setText(paramInt);
        paramView.setClickable(false);
        paramView.setOnClickListener(null);
        paramViewGroup = paramView;
        return paramViewGroup;
      }
    }
    DatingInfo localDatingInfo = (DatingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(paramView)) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(paramViewGroup);
    }
    for (;;)
    {
      int i;
      if (this.jdField_a_of_type_Int == 0) {
        i = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(i, paramInt, paramView, localDatingInfo, Integer.valueOf(this.c));
        paramViewGroup = paramView;
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        paramViewGroup = paramView;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramViewGroup = paramView;
        if (localDatingInfo == null) {
          break;
        }
        paramViewGroup = paramView;
        if (localDatingInfo.datingStatus != 0) {
          break;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        this.jdField_a_of_type_AndroidViewView = paramView;
        return paramView;
        if (this.jdField_a_of_type_Int == 1) {
          i = 2;
        } else {
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUserCenterAdapter
 * JD-Core Version:    0.7.0.1
 */