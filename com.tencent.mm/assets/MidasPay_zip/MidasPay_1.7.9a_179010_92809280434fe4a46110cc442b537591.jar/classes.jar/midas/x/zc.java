package midas.x;

import android.text.TextUtils;
import android.util.Pair;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

public class zc
  implements Serializable
{
  public static int f = 16;
  public static final long serialVersionUID = 1L;
  public volatile String a;
  public volatile Pair<Long, Long> b;
  public volatile Pair<Long, Long>[] c;
  public volatile Integer d;
  public volatile Integer e;
  
  public zc(String paramString)
  {
    this.a = paramString;
    paramString = Long.valueOf(0L);
    this.b = new Pair(paramString, paramString);
    int i = 0;
    Integer localInteger = Integer.valueOf(0);
    this.d = localInteger;
    this.c = new Pair[f];
    while (i < this.c.length)
    {
      this.c[i] = new Pair(paramString, paramString);
      i += 1;
    }
    this.e = localInteger;
  }
  
  public zc(zc paramzc)
  {
    this.a = paramzc.a;
    this.b = new Pair(paramzc.b.first, paramzc.b.second);
    this.d = paramzc.d;
    this.e = paramzc.e;
    this.c = new Pair[paramzc.c.length];
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new Pair(paramzc.c[i].first, paramzc.c[i].second);
      i += 1;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readObject() in = ");
    localStringBuilder.append(paramObjectInputStream);
    ed.a("IPNode", localStringBuilder.toString());
    try
    {
      paramObjectInputStream = paramObjectInputStream.readFields();
      this.a = bd.a((String)paramObjectInputStream.get("ip", bd.b("")));
      a(bd.a((String)paramObjectInputStream.get("measure", bd.b(new zc("").e()))));
      a(bd.a((String)paramObjectInputStream.get("history", bd.b(new zc("").a()))), Integer.valueOf(bd.a((String)paramObjectInputStream.get("index", bd.b("0")))).intValue());
      this.e = Integer.valueOf(bd.a((String)paramObjectInputStream.get("category", bd.b("0"))));
      return;
    }
    catch (Exception paramObjectInputStream)
    {
      paramObjectInputStream.printStackTrace();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("writeObject() out = ");
    ((StringBuilder)localObject).append(paramObjectOutputStream);
    ed.a("IPNode", ((StringBuilder)localObject).toString());
    try
    {
      localObject = paramObjectOutputStream.putFields();
      ((ObjectOutputStream.PutField)localObject).put("ip", bd.b(this.a));
      ((ObjectOutputStream.PutField)localObject).put("measure", bd.b(e()));
      ((ObjectOutputStream.PutField)localObject).put("history", bd.b(a()));
      ((ObjectOutputStream.PutField)localObject).put("index", bd.b(String.valueOf(this.d)));
      ((ObjectOutputStream.PutField)localObject).put("category", bd.b(String.valueOf(this.e)));
      paramObjectOutputStream.writeFields();
      return;
    }
    catch (Exception paramObjectOutputStream)
    {
      paramObjectOutputStream.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    int k;
    for (int j = 0; i <= paramInt; j = k)
    {
      int m = (this.d.intValue() - i + this.c.length) % this.c.length;
      k = j;
      if (((Long)this.c[m].first).longValue() > 0L)
      {
        k = j;
        if (((Long)this.c[m].second).longValue() < 0L) {
          k = j + 1;
        }
      }
      i += 1;
    }
    return j;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Pair[] arrayOfPair = this.c;
    int j = arrayOfPair.length;
    int i = 0;
    while (i < j)
    {
      Pair localPair = arrayOfPair[i];
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(String.valueOf(localPair.first));
      localStringBuilder2.append(":");
      localStringBuilder2.append(String.valueOf(localPair.second));
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("|");
      i += 1;
    }
    return localStringBuilder1.substring(0, localStringBuilder1.lastIndexOf("|"));
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.c[this.d.intValue()] = new Pair(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    this.d = Integer.valueOf((this.d.intValue() + 1) % this.c.length);
  }
  
  public void a(String paramString)
  {
    this.b = b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = paramString.split("\\|");
    Pair[] arrayOfPair = new Pair[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      arrayOfPair[i] = b(paramString[i]);
      i += 1;
    }
    this.c = new Pair[f];
    i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new Pair(Long.valueOf(0L), Long.valueOf(0L));
      i += 1;
    }
    i = 1;
    for (;;)
    {
      int j = f;
      if ((i > j) || (i > arrayOfPair.length)) {
        break;
      }
      int k = arrayOfPair.length;
      int m = arrayOfPair.length;
      this.c[((j - i + j) % j)] = arrayOfPair[((paramInt - i + k) % m)];
      i += 1;
    }
    this.d = Integer.valueOf(0);
  }
  
  public final Pair<Long, Long> b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    Long localLong = Long.valueOf(0L);
    if (bool) {
      return new Pair(localLong, localLong);
    }
    paramString = paramString.split(":");
    if ((paramString != null) && (paramString.length > 0)) {}
    for (;;)
    {
      try
      {
        if (paramString.length <= 0) {
          break label132;
        }
        l1 = Long.valueOf(paramString[0]).longValue();
        if (paramString.length > 1) {
          l2 = Long.valueOf(paramString[1]).longValue();
        }
        paramString = new Pair(Long.valueOf(l1), Long.valueOf(l2));
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return new Pair(localLong, localLong);
      }
      return new Pair(localLong, localLong);
      label132:
      long l1 = 0L;
    }
  }
  
  public boolean b()
  {
    int j = 1;
    int i = 0;
    while (j <= this.c.length)
    {
      int k = (this.d.intValue() - j + this.c.length) % this.c.length;
      if (((Long)this.c[k].second).longValue() == 0L) {
        return false;
      }
      if (((Long)this.c[k].second).longValue() < 0L)
      {
        k = i + 1;
        i = k;
        if (k >= 3) {
          return true;
        }
      }
      else
      {
        i = 0;
      }
      j += 1;
    }
    return false;
  }
  
  public long c()
  {
    int i = 1;
    while (i <= this.c.length)
    {
      int j = (this.d.intValue() - i + this.c.length) % this.c.length;
      if (((Long)this.c[j].first).longValue() == 0L) {
        return 0L;
      }
      if (((Long)this.c[j].second).longValue() < 0L) {
        return ((Long)this.c[j].first).longValue();
      }
      i += 1;
    }
    return 0L;
  }
  
  public long d()
  {
    int i = 1;
    while (i <= this.c.length)
    {
      int j = (this.d.intValue() - i + this.c.length) % this.c.length;
      if (((Long)this.c[j].first).longValue() == 0L) {
        return 0L;
      }
      if (((Long)this.c[j].second).longValue() > 0L) {
        return ((Long)this.c[j].first).longValue();
      }
      i += 1;
    }
    return 0L;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.b.first));
    localStringBuilder.append(":");
    localStringBuilder.append(String.valueOf(this.b.second));
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (zc)paramObject;
    if (!TextUtils.isEmpty(this.a))
    {
      if (TextUtils.isEmpty(paramObject.a)) {
        return false;
      }
      return this.a.equals(paramObject.a);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append(this.a);
    localStringBuilder.append("-[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("](");
    localStringBuilder.append(e());
    localStringBuilder.append("->[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    localStringBuilder.append(a());
    localStringBuilder.append(")}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.zc
 * JD-Core Version:    0.7.0.1
 */