package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.assistant.PubAccountAssistantEmptyItemBuilder;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantGuideBuilder;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;

public class RecentItemBuilderFactory
{
  protected static final int A = 2;
  protected static final int B = 3;
  protected static final int C = 4;
  protected static final int D = 5;
  protected static final int E = 6;
  public static final int a = 0;
  public static final Long a;
  public static final String a = "RECENT_BLANK_VIEW";
  protected static final int[] a;
  public static final int b = 1;
  public static final Long b;
  protected static final int[] b;
  public static final int c = 3;
  public static final Long c;
  protected static final int[] c;
  public static final int d = 4;
  protected static final int[] d = { 0, 1, 2, 3 };
  public static final int e = 5;
  protected static final int[] e = { 0, 1, 2 };
  public static final int f = 6;
  protected static final int[] f = { 0, 1, 2, 3, 4, 5, 6 };
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 3;
  public static final int n = 4;
  public static final int o = 5;
  protected static final int p = 0;
  protected static final int q = 1;
  protected static final int r = 2;
  protected static final int s = 3;
  protected static final int t = 1;
  protected static final int u = 2;
  protected static final int v = 3;
  protected static final int w = 1;
  protected static final int x = 2;
  protected static final int y = 3;
  protected static final int z = 1;
  protected int F;
  protected PubAccountAssistantEmptyItemBuilder a;
  protected PubAccountAssistantGuideBuilder a;
  protected RecentAdapter a;
  protected RecentBlankItemBuilder a;
  protected RecentCallContactItemBuilder a;
  protected RecentCallHoldItemBuilder a;
  protected RecentCallItemBuilder a;
  protected RecentCallMoreItemBuilder a;
  protected RecentDefaultItemBuilder a;
  protected RecentEmptyItemBuilder a;
  protected TroopAssistantEducationBuilder a;
  protected TroopAssistantEmptyItemBuilder a;
  protected RecentCallItemBuilder b;
  protected int[] g;
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    jdField_b_of_type_JavaLangLong = Long.valueOf(1L);
    jdField_c_of_type_JavaLangLong = Long.valueOf(2L);
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
    jdField_b_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
    jdField_c_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3 };
  }
  
  public RecentItemBuilderFactory(int paramInt)
  {
    this.F = paramInt;
    if (this.F == 0)
    {
      this.g = jdField_b_of_type_ArrayOfInt;
      return;
    }
    if (this.F == 1)
    {
      this.g = jdField_c_of_type_ArrayOfInt;
      return;
    }
    if (this.F == 3)
    {
      this.g = d;
      return;
    }
    if (this.F == 4)
    {
      this.g = f;
      return;
    }
    if (this.F == 5)
    {
      this.g = e;
      return;
    }
    this.g = jdField_a_of_type_ArrayOfInt;
  }
  
  public int a()
  {
    return this.F;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.g[0];
    switch (this.F)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i1;
                    if ((paramObject instanceof Integer)) {
                      return this.g[1];
                    }
                    if (((paramObject instanceof RecentUserBaseData)) || ((paramObject instanceof RecentAdapter.TimeLineDivider))) {
                      return this.g[2];
                    }
                    if ((paramObject instanceof String)) {
                      return this.g[0];
                    }
                  } while (!(paramObject instanceof RecentMsgBoxItem));
                  return this.g[2];
                  if (!(paramObject instanceof Integer)) {
                    break;
                  }
                  paramObject = (Integer)paramObject;
                  if (paramObject.intValue() == 3) {
                    return this.g[3];
                  }
                  if (paramObject.intValue() == 4) {
                    return this.g[1];
                  }
                } while (paramObject.intValue() != 5);
                return this.g[1];
              } while (!(paramObject instanceof RecentBaseData));
              return this.g[2];
              if (!(paramObject instanceof Integer)) {
                break;
              }
              paramObject = (Integer)paramObject;
              if (paramObject.intValue() == 8) {
                return this.g[3];
              }
              if (paramObject.intValue() == 9) {
                return this.g[1];
              }
            } while (paramObject.intValue() != 10);
            return this.g[1];
          } while (!(paramObject instanceof RecentBaseData));
          return this.g[2];
          if (!(paramObject instanceof Long)) {
            break;
          }
          paramObject = (Long)paramObject;
          if (jdField_a_of_type_JavaLangLong == paramObject) {
            return this.g[1];
          }
          if (jdField_b_of_type_JavaLangLong == paramObject) {
            return this.g[5];
          }
        } while (jdField_c_of_type_JavaLangLong != paramObject);
        return this.g[6];
        if ((paramObject instanceof Integer)) {
          return this.g[2];
        }
        if ((paramObject instanceof RecentBaseData))
        {
          if (((RecentBaseData)paramObject).a() == 8) {
            return this.g[4];
          }
          return this.g[3];
        }
      } while (!(paramObject instanceof String));
      return this.g[0];
      if ((paramObject instanceof Integer)) {
        return this.g[1];
      }
    } while (!(paramObject instanceof RecentBaseData));
    return this.g[2];
  }
  
  public RecentItemBaseBuilder a(Object paramObject)
  {
    Object localObject = null;
    int i1 = a(paramObject);
    if (this.F == 0) {
      if (i1 == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder = new RecentEmptyItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder;
      }
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder = new RecentBlankItemBuilder();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBlankItemBuilder;
      }
      ((RecentItemBaseBuilder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      return localObject;
      paramObject = localObject;
      if (i1 == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
        }
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
        continue;
        if (this.F == 1)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder = new TroopAssistantEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEmptyItemBuilder;
          }
          else if (i1 == 2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
          }
          else
          {
            paramObject = localObject;
            if (i1 == 3)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder = new TroopAssistantEducationBuilder();
              }
              paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentTroopAssistantEducationBuilder;
            }
          }
        }
        else if (this.F == 3)
        {
          if (i1 == 1)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder == null) {
              this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder = new PubAccountAssistantEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder;
          }
          else if (i1 == 2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
          }
          else
          {
            paramObject = localObject;
            if (i1 == 3)
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder = new PubAccountAssistantGuideBuilder();
              }
              paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantGuideBuilder;
            }
          }
        }
        else if (this.F == 4)
        {
          if (i1 == 5)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallContactItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallContactItemBuilder = new RecentCallContactItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallContactItemBuilder;
          }
          else if (i1 == 6)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHoldItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHoldItemBuilder = new RecentCallHoldItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHoldItemBuilder;
          }
          else if (i1 == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallMoreItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallMoreItemBuilder = new RecentCallMoreItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallMoreItemBuilder;
          }
          else if (i1 == 2)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder = new RecentEmptyItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentEmptyItemBuilder;
          }
          else if (i1 == 3)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder = new RecentCallItemBuilder();
            }
            paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder;
          }
          else
          {
            paramObject = localObject;
            if (i1 == 4)
            {
              if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder == null) {
                this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder = new RecentCallItemBuilder(1);
              }
              paramObject = this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentCallItemBuilder;
            }
          }
        }
        else
        {
          paramObject = localObject;
          if (this.F == 5) {
            if (i1 == 1)
            {
              if (this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder == null) {
                this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder = new PubAccountAssistantEmptyItemBuilder();
              }
              paramObject = this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantEmptyItemBuilder;
            }
            else
            {
              paramObject = localObject;
              if (i1 == 2)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder == null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder = new RecentDefaultItemBuilder();
                }
                paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDefaultItemBuilder;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(RecentAdapter paramRecentAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = paramRecentAdapter;
  }
  
  public int b()
  {
    return this.g.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */