package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import hfr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShowExternalTroopListAdapter
  extends FacePreloadBaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new hfr(this);
  public ShowExternalTroopListAdapter.OnTroopListClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopHandler a;
  protected TroopManager a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  List jdField_a_of_type_JavaUtilList;
  protected boolean a;
  private List b;
  protected boolean b;
  private List c = new ArrayList();
  
  public ShowExternalTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ShowExternalTroopListAdapter.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(50));
    a();
  }
  
  protected Object a(int paramInt)
  {
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if ((getItem(paramInt) instanceof TroopInfo))
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = ((TroopInfo)getItem(paramInt)).troopuin;
      localFaceInfo.jdField_a_of_type_Int = 4;
    }
    return localFaceInfo;
  }
  
  public List a()
  {
    return this.c;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null)
      {
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c();
        notifyDataSetChanged();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19));
    } while (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_JavaLangString, 0, 0);
  }
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903693, null);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilList.size() == 0) && ((this.jdField_a_of_type_AndroidContentContext instanceof ShowExternalTroopListActivity)))
    {
      paramInt = ((ShowExternalTroopListActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903693, null);
      paramViewGroup = (TextView)paramView.findViewById(2131299339);
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(2131363985);
      paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 2130839495, 0, 0);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels - paramInt));
      return paramView;
    }
    Object localObject1 = (ShowExternalTroopListAdapter.TroopListItem)getItem(paramInt);
    if (localObject1 == null) {
      return null;
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903526, paramViewGroup, false);
      paramViewGroup = new ShowExternalTroopListAdapter.TroopListViewItemTag(paramView);
      paramView.setTag(paramViewGroup);
      ((ImageView)paramView.findViewById(2131302340)).setVisibility(0);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    TextView localTextView;
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter$TroopListItem = ((ShowExternalTroopListAdapter.TroopListItem)localObject1);
      localObject2 = paramView.findViewById(2131298650);
      localTextView = (TextView)paramView.findViewById(2131298649);
      if (((ShowExternalTroopListAdapter.TroopListItem)localObject1).c != 0) {
        break label317;
      }
      ((View)localObject2).setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localTextView.setVisibility(0);
      localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131363981));
      return paramView;
      paramViewGroup = (ShowExternalTroopListAdapter.TroopListViewItemTag)paramView.getTag();
    }
    localTextView.setVisibility(8);
    return paramView;
    label317:
    ((View)localObject2).setVisibility(0);
    localTextView.setVisibility(8);
    Object localObject2 = ((ShowExternalTroopListAdapter.TroopListItem)localObject1).a;
    paramViewGroup.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin);
    localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
    if (paramInt != 3)
    {
      paramInt = 4;
      ((ImageView)localObject1).setVisibility(paramInt);
      localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
      if (((TroopInfo)localObject2).troopname == null) {
        break label502;
      }
      localObject1 = ((TroopInfo)localObject2).troopname;
      label399:
      localTextView.setText((CharSequence)localObject1);
      localTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
      if (((TroopInfo)localObject2).troopmemo == null) {
        break label512;
      }
    }
    label512:
    for (localObject1 = ((TroopInfo)localObject2).troopmemo;; localObject1 = "")
    {
      localTextView.setText((CharSequence)localObject1);
      paramViewGroup.d.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
      if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
        break label561;
      }
      if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
        break label520;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838652);
      return paramView;
      paramInt = 0;
      break;
      label502:
      localObject1 = ((TroopInfo)localObject2).troopcode;
      break label399;
    }
    label520:
    if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839096);
      return paramView;
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
    label561:
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    Object localObject2 = new ArrayList();
    Iterator localIterator;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, new ShowExternalTroopListAdapter.ShowExternalTroopCompator());
      }
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    label241:
    label244:
    for (;;)
    {
      ShowExternalTroop localShowExternalTroop;
      Object localObject1;
      if (localIterator.hasNext())
      {
        localShowExternalTroop = (ShowExternalTroop)localIterator.next();
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            break label241;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(localShowExternalTroop.troopUin);
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label244;
        }
        ((List)localObject2).add(localObject1);
        break;
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = localShowExternalTroop.troopUin;
        ((TroopInfo)localObject1).troopname = localShowExternalTroop.troopName;
        continue;
        if (!((List)localObject2).isEmpty()) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.jdField_b_of_type_JavaUtilList.add(new ShowExternalTroopListAdapter.TroopListItem(0, null));
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Entity)((Iterator)localObject1).next();
            this.jdField_b_of_type_JavaUtilList.add(new ShowExternalTroopListAdapter.TroopListItem(1, (Entity)localObject2));
          }
        }
        super.notifyDataSetChanged();
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */