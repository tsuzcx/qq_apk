package com.tencent.qav.bussiness;

import android.text.TextUtils;
import com.tencent.qav.observer.FilterableObserver;

public class QavBussinessObserver
  extends FilterableObserver
{
  public static final int a = 1;
  public static final int b = 21;
  public static final int c = 22;
  public static final int d = 24;
  public static final int e = 25;
  public static final int f = 26;
  public static final int g = 27;
  public static final int h = 28;
  public static final int i = 29;
  public static final int j = 30;
  public static final int k = 31;
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(long paramLong) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void b(String paramString) {}
  
  public void b(String paramString, int paramInt) {}
  
  public void c(String paramString) {}
  
  public void d(String paramString) {}
  
  public void e(String paramString) {}
  
  public void f(String paramString) {}
  
  public void update(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      f((String)paramVarArgs[0]);
      return;
    case 21: 
      b((String)paramVarArgs[0]);
      return;
    case 22: 
      a((String)paramVarArgs[0]);
      return;
    case 24: 
      c((String)paramVarArgs[0]);
      return;
    case 25: 
      d((String)paramVarArgs[0]);
      return;
    case 26: 
      e((String)paramVarArgs[0]);
      return;
    case 27: 
      a((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue());
      return;
    case 28: 
      b((String)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue());
      return;
    case 29: 
      a(((Integer)paramVarArgs[0]).intValue(), ((Integer)paramVarArgs[1]).intValue(), ((Integer)paramVarArgs[2]).intValue(), (String)paramVarArgs[3]);
      return;
    case 30: 
      a(((Long)paramVarArgs[0]).longValue());
      return;
    }
    String str = (String)paramVarArgs[0];
    boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
    paramVarArgs = str;
    if (TextUtils.isEmpty(str)) {
      paramVarArgs = "";
    }
    a(paramVarArgs, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.bussiness.QavBussinessObserver
 * JD-Core Version:    0.7.0.1
 */