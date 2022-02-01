package com.tencent.mobileqq.model;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.List;
import mqq.manager.Manager;

public abstract interface PhoneContactManager
  extends Manager
{
  public static final String a = "PhoneContactManager";
  public static final int d = -1;
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 10;
  public static final int p = 11;
  public static final int q = 0;
  public static final int r = 1;
  public static final int s = 2;
  public static final int t = 3;
  
  public abstract RespondQueryQQBindingStat a();
  
  public abstract PhoneContact a(String paramString);
  
  public abstract List a();
  
  public abstract void a(long paramLong1, long paramLong2, List paramList1, List paramList2);
  
  public abstract void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(List paramList, long paramLong);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract int b();
  
  public abstract PhoneContact b(String paramString);
  
  public abstract String b();
  
  public abstract String b(String paramString);
  
  public abstract List b();
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void b(String paramString1, String paramString2, int paramInt);
  
  public abstract void b(List paramList, long paramLong);
  
  public abstract PhoneContact c(String paramString);
  
  public abstract String c();
  
  public abstract String c(String paramString);
  
  public abstract List c();
  
  public abstract void c();
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract void c(List paramList);
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract void i();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.PhoneContactManager
 * JD-Core Version:    0.7.0.1
 */