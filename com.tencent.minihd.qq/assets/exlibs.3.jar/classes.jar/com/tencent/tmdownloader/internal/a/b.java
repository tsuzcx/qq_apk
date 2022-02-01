package com.tencent.tmdownloader.internal.a;

import android.content.res.Resources.NotFoundException;
import com.tencent.tmassistantbase.a.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  public static final String a = b.class.getSimpleName();
  protected static final Pattern d = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
  protected static final Pattern e = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
  protected final long b;
  protected final Long c;
  
  public b(long paramLong1, long paramLong2)
  {
    this(paramLong1, Long.valueOf(paramLong2));
    if (paramLong1 < 0L)
    {
      k.e(a, "exception: If end is provided, start must be positive.");
      throw new IllegalArgumentException("If end is provided, start must be positive.");
    }
    if (paramLong2 < paramLong1)
    {
      k.e(a, "exception: Byte Range end must be >= start.()");
      throw new IllegalArgumentException("end must be >= start.");
    }
  }
  
  protected b(long paramLong, Long paramLong1)
  {
    this.b = paramLong;
    this.c = paramLong1;
  }
  
  public static b a(String paramString)
  {
    Matcher localMatcher = e.matcher(paramString);
    if (!localMatcher.matches())
    {
      k.e(a, "exception: Invalid content-range format: " + paramString);
      throw new Throwable("Invalid content-range format: " + paramString);
    }
    return new b(Long.parseLong(localMatcher.group(1)), Long.parseLong(localMatcher.group(2)));
  }
  
  public static long b(String paramString)
  {
    int i = paramString.indexOf("/");
    if (i == -1)
    {
      k.e(a, "exception: NotFoundException()");
      throw new Resources.NotFoundException();
    }
    return Long.parseLong(paramString.substring(i + 1));
  }
  
  public boolean a()
  {
    return this.c != null;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public long c()
  {
    if (!a())
    {
      k.e(a, "exception: Byte-range does not have end.  Check hasEnd() before use");
      throw new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
    }
    return this.c.longValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if (this.b == paramObject.b()) {
        break label26;
      }
    }
    label26:
    while (a() != paramObject.a()) {
      return false;
    }
    if (a()) {
      return this.c.equals(Long.valueOf(paramObject.c()));
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = Long.valueOf(this.b).hashCode() + 629;
    int i = j;
    if (this.c != null) {
      i = j * 37 + this.c.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    if (this.c != null) {
      return "bytes=" + this.b + "-" + this.c;
    }
    if (this.b < 0L) {
      return "bytes=" + this.b;
    }
    return "bytes=" + this.b + "-";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.b
 * JD-Core Version:    0.7.0.1
 */