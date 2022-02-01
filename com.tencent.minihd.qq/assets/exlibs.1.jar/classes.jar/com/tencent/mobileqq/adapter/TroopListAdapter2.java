package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import hft;
import hfu;
import hfv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  float jdField_a_of_type_Float;
  public Context a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new hfu(this);
  public TroopListAdapter2.OnTroopListClickListener a;
  public QQAppInterface a;
  public TroopManager a;
  protected TroopObserver a;
  public SlideDetectListView a;
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new hfv(this);
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  int c = 0;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if ((paramContext instanceof BaseActivity)) {
      this.jdField_b_of_type_Boolean = ((BaseActivity)paramContext).isModeleWindow();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(50));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new hft(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
    }
    if (paramBoolean1) {
      a();
    }
  }
  
  public static int a(int paramInt)
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
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).b();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      return;
      Object localObject2 = new ArrayList();
      Object localObject3 = ((TroopManager)localObject1).b();
      if (localObject3 != null)
      {
        Collections.sort((List)localObject3, new TroopListAdapter2.CommonlyUsedTroopCompator());
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject3).next()).troopUin);
          if (localObject4 != null) {
            ((List)localObject2).add(localObject4);
          }
        }
        this.g = ((List)localObject2).size();
      }
      Object localObject4 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject5 = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject5).next();
        i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localEntity).troopuin));
        if ((((TroopInfo)localEntity).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else if ((((TroopInfo)localEntity).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        } else {
          ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(i, localEntity));
        }
      }
      localObject5 = new TroopListAdapter2.TroopCompator();
      Collections.sort((List)localObject4, (Comparator)localObject5);
      Collections.sort((List)localObject3, (Comparator)localObject5);
      Collections.sort((List)localObject1, (Comparator)localObject5);
      if (!((List)localObject2).isEmpty()) {}
      for (int i = 1; (i != 0) && (!this.jdField_a_of_type_Boolean); i = 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(0, null));
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Entity)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(1, (Entity)localObject5));
        }
      }
      this.d = ((List)localObject4).size();
      if (this.d > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(4, null));
        localObject2 = ((List)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)localObject4).a));
        }
      }
      this.e = ((List)localObject3).size();
      if (this.e > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(6, null));
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(7, ((TroopListAdapter2.TroopListItemWithMask)localObject3).a));
        }
      }
      this.f = ((List)localObject1).size();
      if (this.f > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(2, null));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)localObject2).a));
        }
      }
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListAdapter2.TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a;
    }
    return null;
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
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = (TroopListAdapter2.TroopListItem)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    label242:
    TextView localTextView1;
    label340:
    int i;
    int j;
    if (paramView == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903526, paramViewGroup, false);
      localObject2 = new TroopListAdapter2.TroopListViewItemTag((View)localObject1);
      ((View)localObject1).setTag(localObject2);
      ((Button)((View)localObject1).findViewById(2131298652)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = (ViewGroup)localObject2;
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        ((TroopListAdapter2.TroopListViewItemTag)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject3);
      if ((this.jdField_a_of_type_Boolean) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 0) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 4) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 6) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.i != 2))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.a == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((TroopListAdapter2.TroopListItem)localObject3).a.troopuin))) {
          break label425;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((TroopListAdapter2.TroopListItem)localObject3).a.troopuin, paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      localObject2 = paramView.findViewById(2131298650);
      localTextView1 = (TextView)paramView.findViewById(2131298649);
      if (((TroopListAdapter2.TroopListItem)localObject3).i != 0) {
        break label436;
      }
      ((View)localObject2).setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131363418, new Object[] { String.valueOf(this.g) }));
      if (this.jdField_b_of_type_Boolean)
      {
        i = (int)(16.0F * this.jdField_a_of_type_Float);
        j = (int)(32.0F * this.jdField_a_of_type_Float);
        ((View)localObject2).setBackgroundResource(2130837949);
        if (paramInt != 0) {
          break label863;
        }
        localTextView1.setBackgroundResource(2130837958);
        localTextView1.setPadding(j, j, j, i);
      }
    }
    for (;;)
    {
      paramView.setPadding(j, 0, j, 0);
      return paramView;
      paramViewGroup = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      break;
      label425:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label242;
      label436:
      if (((TroopListAdapter2.TroopListItem)localObject3).i == 2)
      {
        ((View)localObject2).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131363421, new Object[] { String.valueOf(this.f) }));
        break label340;
      }
      if (((TroopListAdapter2.TroopListItem)localObject3).i == 4)
      {
        ((View)localObject2).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131363419, new Object[] { String.valueOf(this.d) }));
        break label340;
      }
      if (((TroopListAdapter2.TroopListItem)localObject3).i == 6)
      {
        ((View)localObject2).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131363420, new Object[] { String.valueOf(this.e) }));
        break label340;
      }
      ((View)localObject2).setVisibility(0);
      localTextView1.setVisibility(8);
      localObject3 = ((TroopListAdapter2.TroopListItem)localObject3).a;
      paramViewGroup.jdField_b_of_type_JavaLangString = ((TroopInfo)localObject3).troopuin;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject3).troopuin);
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      label657:
      TextView localTextView2;
      if (i != 3)
      {
        i = 4;
        ((ImageView)localObject1).setVisibility(i);
        localTextView2 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (((TroopInfo)localObject3).troopname == null) {
          break label790;
        }
        localObject1 = ((TroopInfo)localObject3).troopname;
        label685:
        localTextView2.setText((CharSequence)localObject1);
        localTextView2 = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
        if (((TroopInfo)localObject3).troopmemo == null) {
          break label800;
        }
      }
      label790:
      label800:
      for (localObject1 = ((TroopInfo)localObject3).troopmemo;; localObject1 = "")
      {
        localTextView2.setText((CharSequence)localObject1);
        paramViewGroup.d.setImageBitmap(a(4, ((TroopInfo)localObject3).troopuin));
        if ((((TroopInfo)localObject3).dwGroupFlagExt & 0x800) == 0L) {
          break label851;
        }
        if (((TroopInfo)localObject3).dwAuthGroupType != 2L) {
          break label808;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130838652);
        break;
        i = 0;
        break label657;
        localObject1 = ((TroopInfo)localObject3).troopcode;
        break label685;
      }
      label808:
      if (((TroopInfo)localObject3).dwAuthGroupType == 1L)
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130839096);
        break label340;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label340;
      label851:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label340;
      label863:
      localTextView1.setBackgroundResource(2130837952);
      localTextView1.setPadding(j, i, j, i);
    }
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof TroopListAdapter2.TroopListItem)) {}
    do
    {
      return;
      paramCompoundButton = (TroopListAdapter2.TroopListItem)paramCompoundButton;
    } while ((paramCompoundButton == null) || (paramCompoundButton.a == null));
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.e(paramCompoundButton.a.troopuin);
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(str, paramCompoundButton.a.troopuin, paramBoolean, false);
    if (paramBoolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramCompoundButton.a.troopuin, "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramCompoundButton.a.troopuin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */