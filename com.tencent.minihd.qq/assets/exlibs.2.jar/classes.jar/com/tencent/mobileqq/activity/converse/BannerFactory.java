package com.tencent.mobileqq.activity.converse;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.HashMap;

public class BannerFactory
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 100;
  public static final int d = 102;
  public static final int e = 103;
  public static final int f = 104;
  public static final int g = 105;
  public static final int h = 106;
  public static final int i = 107;
  public static final int j = 108;
  public static final int k = 109;
  public static final int l = 110;
  public static final int m = 200;
  public static final int n = 201;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  
  public BannerFactory(Context paramContext, LinearLayout paramLinearLayout, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  private BaseBanner a(int paramInt)
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))))
    {
      localObject2 = (BaseBanner)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      return localObject2;
    }
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject1);
      return localObject1;
      localObject1 = new NetworkBanner(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      continue;
      localObject1 = new TroopAssistBanner(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    BaseBanner localBaseBanner1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localBaseBanner1 = (BaseBanner)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        BaseBanner localBaseBanner2 = (BaseBanner)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        if (localBaseBanner1.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseBanner1.a(this.jdField_a_of_type_AndroidContentContext));
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseBanner2.a(this.jdField_a_of_type_AndroidContentContext));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseBanner1.a(this.jdField_a_of_type_AndroidContentContext));
      continue;
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        localBaseBanner1 = (BaseBanner)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localBaseBanner1.a(this.jdField_a_of_type_AndroidContentContext));
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
    }
    for (ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList; localArrayList.size() > 0; localArrayList = this.jdField_b_of_type_JavaUtilArrayList)
    {
      paramInt2 = 0;
      while (paramInt2 < localArrayList.size())
      {
        if (((BaseBanner)localArrayList.get(paramInt2)).jdField_a_of_type_Int == paramInt1)
        {
          localArrayList.remove(paramInt2);
          if (paramInt2 == 0) {
            this.jdField_a_of_type_Boolean = true;
          }
        }
        paramInt2 += 1;
      }
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
    }
    a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList;
    int i1;
    label45:
    BaseBanner localBaseBanner;
    if (paramInt3 == 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      i1 = a(paramInt1);
      if (localArrayList.size() <= 0) {
        break label171;
      }
      paramInt3 = 0;
      if (paramInt3 < localArrayList.size())
      {
        localBaseBanner = (BaseBanner)localArrayList.get(paramInt3);
        if (localBaseBanner.jdField_a_of_type_Int != paramInt1) {
          break label115;
        }
        if (!localBaseBanner.a(paramInt2)) {}
      }
    }
    label171:
    for (;;)
    {
      a();
      return;
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      break;
      label115:
      if (localBaseBanner.c <= i1)
      {
        localBaseBanner = a(paramInt1);
        if (localBaseBanner != null)
        {
          localBaseBanner.a(paramInt2);
          localArrayList.add(paramInt3, localBaseBanner);
          if (paramInt3 == 0) {
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        paramInt3 += 1;
        break label45;
        localBaseBanner = a(paramInt1);
        if (localBaseBanner != null)
        {
          localArrayList.add(localBaseBanner);
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.converse.BannerFactory
 * JD-Core Version:    0.7.0.1
 */