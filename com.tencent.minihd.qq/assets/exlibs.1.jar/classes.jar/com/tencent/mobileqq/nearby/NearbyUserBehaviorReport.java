package com.tencent.mobileqq.nearby;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class NearbyUserBehaviorReport
{
  public static final int a = 0;
  public static final String a = "actNearbyUserBehavior";
  public static final boolean a = true;
  public static final int b = 1;
  public static final String b = "param_OPS";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  private long jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  private int[] jdField_a_of_type_ArrayOfInt = new int[11];
  private int m = 0;
  private int n = 0;
  
  public NearbyUserBehaviorReport()
  {
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "init", Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (this.n != 0)) {
      b(2);
    }
    this.n = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      DatingUtil.b("NearbyUserBehaviorReport", new Object[] { "doReport app is null" });
      return;
    }
    long l1 = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long) / 1000L;
    StringBuilder localStringBuilder = new StringBuilder(22);
    int i1 = 0;
    while (i1 < 11)
    {
      if (i1 > 0) {
        localStringBuilder.append('-');
      }
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt[i1]);
      i1 += 1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_OPS", localStringBuilder.toString());
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.a(), "actNearbyUserBehavior", true, l1, this.m, localHashMap, "");
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "doReport", Long.valueOf(l1), Integer.valueOf(this.m), localStringBuilder });
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 11))
    {
      this.m += 1;
      this.jdField_a_of_type_ArrayOfInt[paramInt] = (paramInt + 1);
    }
    DatingUtil.a("NearbyUserBehaviorReport", new Object[] { "addOps", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfInt });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyUserBehaviorReport
 * JD-Core Version:    0.7.0.1
 */