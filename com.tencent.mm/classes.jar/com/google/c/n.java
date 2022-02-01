package com.google.c;

import com.google.c.b.a;
import com.google.c.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;

public final class n
  extends i
{
  private static final Class<?>[] dEW = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  public Object value;
  
  public n(Boolean paramBoolean)
  {
    AppMethodBeat.i(107877);
    setValue(paramBoolean);
    AppMethodBeat.o(107877);
  }
  
  public n(Number paramNumber)
  {
    AppMethodBeat.i(107878);
    setValue(paramNumber);
    AppMethodBeat.o(107878);
  }
  
  public n(String paramString)
  {
    AppMethodBeat.i(107879);
    setValue(paramString);
    AppMethodBeat.o(107879);
  }
  
  private static boolean a(n paramn)
  {
    if ((paramn.value instanceof Number))
    {
      paramn = (Number)paramn.value;
      return ((paramn instanceof BigInteger)) || ((paramn instanceof Long)) || ((paramn instanceof Integer)) || ((paramn instanceof Short)) || ((paramn instanceof Byte));
    }
    return false;
  }
  
  private static boolean bl(Object paramObject)
  {
    AppMethodBeat.i(107884);
    if ((paramObject instanceof String))
    {
      AppMethodBeat.o(107884);
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = dEW;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom(paramObject))
      {
        AppMethodBeat.o(107884);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(107884);
    return false;
  }
  
  private void setValue(Object paramObject)
  {
    AppMethodBeat.i(107880);
    if ((paramObject instanceof Character))
    {
      this.value = String.valueOf(((Character)paramObject).charValue());
      AppMethodBeat.o(107880);
      return;
    }
    if (((paramObject instanceof Number)) || (bl(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.value = paramObject;
      AppMethodBeat.o(107880);
      return;
    }
  }
  
  public final Number YK()
  {
    AppMethodBeat.i(107882);
    if ((this.value instanceof String))
    {
      localObject = new g((String)this.value);
      AppMethodBeat.o(107882);
      return localObject;
    }
    Object localObject = (Number)this.value;
    AppMethodBeat.o(107882);
    return localObject;
  }
  
  public final String YL()
  {
    AppMethodBeat.i(107883);
    if ((this.value instanceof Number))
    {
      str = YK().toString();
      AppMethodBeat.o(107883);
      return str;
    }
    if ((this.value instanceof Boolean))
    {
      str = ((Boolean)this.value).toString();
      AppMethodBeat.o(107883);
      return str;
    }
    String str = (String)this.value;
    AppMethodBeat.o(107883);
    return str;
  }
  
  public final boolean YM()
  {
    AppMethodBeat.i(107881);
    if ((this.value instanceof Boolean))
    {
      bool = ((Boolean)this.value).booleanValue();
      AppMethodBeat.o(107881);
      return bool;
    }
    boolean bool = Boolean.parseBoolean(YL());
    AppMethodBeat.o(107881);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(107886);
    if (this == paramObject)
    {
      AppMethodBeat.o(107886);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(107886);
      return false;
    }
    paramObject = (n)paramObject;
    if (this.value == null)
    {
      if (paramObject.value == null)
      {
        AppMethodBeat.o(107886);
        return true;
      }
      AppMethodBeat.o(107886);
      return false;
    }
    if ((a(this)) && (a(paramObject)))
    {
      if (YK().longValue() == paramObject.YK().longValue())
      {
        AppMethodBeat.o(107886);
        return true;
      }
      AppMethodBeat.o(107886);
      return false;
    }
    if (((this.value instanceof Number)) && ((paramObject.value instanceof Number)))
    {
      double d1 = YK().doubleValue();
      double d2 = paramObject.YK().doubleValue();
      if ((d1 == d2) || ((Double.isNaN(d1)) && (Double.isNaN(d2))))
      {
        AppMethodBeat.o(107886);
        return true;
      }
      AppMethodBeat.o(107886);
      return false;
    }
    boolean bool = this.value.equals(paramObject.value);
    AppMethodBeat.o(107886);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(107885);
    if (this.value == null)
    {
      AppMethodBeat.o(107885);
      return 31;
    }
    long l;
    if (a(this))
    {
      l = YK().longValue();
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(107885);
      return i;
    }
    if ((this.value instanceof Number))
    {
      l = Double.doubleToLongBits(YK().doubleValue());
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(107885);
      return i;
    }
    int i = this.value.hashCode();
    AppMethodBeat.o(107885);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.n
 * JD-Core Version:    0.7.0.1
 */