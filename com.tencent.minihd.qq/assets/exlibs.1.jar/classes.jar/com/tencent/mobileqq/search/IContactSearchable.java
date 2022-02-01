package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class IContactSearchable
  implements ISearchable
{
  public static final long a = 72057594037927936L;
  public static final long b = 42949672960L;
  public static final long c = 38654705664L;
  public static final long d = 34359738368L;
  public static final long e = 30064771072L;
  public static final long f = 25769803776L;
  public static final long g = 25769803776L;
  public static final long h = 21474836480L;
  public static final long i = 21474836480L;
  public static final long j = 17179869184L;
  public static final long k = 12884901888L;
  public static final long l = 8589934592L;
  public static final long m = 4294967296L;
  public static final long n = 1125899906842624L;
  public static final long o = 562949953421312L;
  public static final long p = 281474976710656L;
  public static final long q = 9007199254740992L;
  public static final long r = 4503599627370496L;
  public static final long s = 0L;
  public static final long t = 0L;
  public static final long u = 0L;
  public static final long v = 0L;
  public static final long w = 0L;
  protected long A;
  protected long x;
  protected long y = -1L;
  protected long z;
  
  public abstract int a();
  
  protected long a()
  {
    return 0L;
  }
  
  public abstract Drawable a();
  
  public abstract Object a();
  
  public abstract String a();
  
  protected void a()
  {
    for (;;)
    {
      int i1;
      try
      {
        String str = d();
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < str.length())
        {
          char c1 = str.charAt(i1);
          if ((c1 >= '0') && (c1 <= '9')) {
            localStringBuilder.append(c1);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.x = Long.parseLong(str);
            return;
          }
          this.x = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.x = hashCode();
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.z = paramLong;
  }
  
  public abstract int b();
  
  public long b()
  {
    return d() - this.A;
  }
  
  public abstract String b();
  
  public long c()
  {
    return e();
  }
  
  public abstract String c();
  
  public long d()
  {
    return this.z;
  }
  
  public abstract String d();
  
  public long e()
  {
    if (this.y == -1L) {
      this.y = a();
    }
    return this.y;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.x == ((IContactSearchable)paramObject).x;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.IContactSearchable
 * JD-Core Version:    0.7.0.1
 */