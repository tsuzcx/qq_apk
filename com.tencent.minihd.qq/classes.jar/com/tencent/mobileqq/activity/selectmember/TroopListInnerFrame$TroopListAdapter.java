package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.XListView;
import gyj;
import gyk;
import gyl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TroopListInnerFrame$TroopListAdapter
  extends FacePreloadBaseAdapter
{
  public int a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public int b;
  public int c;
  public int d;
  
  public TroopListInnerFrame$TroopListAdapter(TroopListInnerFrame paramTroopListInnerFrame, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    TroopListInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame);
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject2 = new ArrayList();
    Object localObject3 = ((TroopManager)localObject1).b();
    if (localObject3 != null)
    {
      Collections.sort((List)localObject3, new gyj(this, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
        if (localObject4 != null) {
          ((List)localObject2).add(localObject4);
        }
      }
      this.d = ((List)localObject2).size();
    }
    Object localObject4 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject5).hasNext())
    {
      Entity localEntity = (Entity)((Iterator)localObject5).next();
      i = a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
      if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
        ((List)localObject4).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
        ((List)localObject3).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      } else {
        ((List)localObject1).add(new TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask(this, i, localEntity));
      }
    }
    localObject5 = new gyk(this, null);
    Collections.sort((List)localObject4, (Comparator)localObject5);
    Collections.sort((List)localObject3, (Comparator)localObject5);
    Collections.sort((List)localObject1, (Comparator)localObject5);
    if (!((List)localObject2).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 0, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (Entity)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 1, (Entity)localObject5));
      }
    }
    this.jdField_a_of_type_Int = ((List)localObject4).size();
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 4, null));
      localObject2 = ((List)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 5, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject4).a));
      }
    }
    this.b = ((List)localObject3).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 6, null));
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 7, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject3).a));
      }
    }
    this.c = ((List)localObject1).size();
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListInnerFrame.TroopListAdapter.TroopListItem(this, 3, ((TroopListInnerFrame.TroopListAdapter.TroopListItemWithMask)localObject2).a));
      }
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
    localFaceInfo.jdField_a_of_type_Int = 4;
    return localFaceInfo;
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopListInnerFrame.TroopListAdapter.TroopListItem localTroopListItem = (TroopListInnerFrame.TroopListAdapter.TroopListItem)getItem(paramInt);
    TextView localTextView1;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (gyl)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = paramViewGroup.findViewById(2131298650);
      localTextView1 = (TextView)paramViewGroup.findViewById(2131298649);
      if (localTroopListItem.i != 0) {
        break label226;
      }
      ((View)localObject).setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131363418, new Object[] { String.valueOf(this.d) }));
    }
    int i;
    int j;
    for (;;)
    {
      i = (int)(16.0F * this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_Float);
      j = (int)(32.0F * this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_Float);
      if (paramInt != 0) {
        break label505;
      }
      localTextView1.setBackgroundResource(2130837958);
      localTextView1.setPadding(j, j, j, i);
      return paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904425, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
      paramView = new gyl(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame, null);
      paramView.d = ((ImageView)paramViewGroup.findViewById(2131296567));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297661));
      paramViewGroup.setTag(paramView);
      break;
      label226:
      if (localTroopListItem.i == 2)
      {
        ((View)localObject).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131363421, new Object[] { String.valueOf(this.c) }));
      }
      else if (localTroopListItem.i == 4)
      {
        ((View)localObject).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131363419, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      }
      else
      {
        if (localTroopListItem.i != 6) {
          break label395;
        }
        ((View)localObject).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame.jdField_a_of_type_AndroidContentContext.getString(2131363420, new Object[] { String.valueOf(this.b) }));
      }
    }
    label395:
    ((View)localObject).setVisibility(0);
    localTextView1.setVisibility(8);
    TroopInfo localTroopInfo = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    paramView.b = localTroopInfo.troopuin;
    TextView localTextView2 = paramView.jdField_a_of_type_AndroidWidgetTextView;
    if (localTroopInfo.troopname != null) {}
    for (Object localObject = localTroopInfo.troopname;; localObject = localTroopInfo.troopcode)
    {
      localTextView2.setText((CharSequence)localObject);
      paramView.d.setImageBitmap(a(4, localTroopInfo.troopuin));
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
      paramView.jdField_a_of_type_Int = localTroopListItem.i;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListInnerFrame);
      break;
    }
    label505:
    localTextView1.setBackgroundResource(2130837952);
    localTextView1.setPadding(j, i, j, i);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListInnerFrame.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */