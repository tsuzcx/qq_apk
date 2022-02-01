package com.google.a;

import com.google.a.b.a;
import com.google.a.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;

public final class p
  extends k
{
  private static final Class<?>[] bNy = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  public Object value;
  
  public p(Boolean paramBoolean)
  {
    AppMethodBeat.i(107877);
    setValue(paramBoolean);
    AppMethodBeat.o(107877);
  }
  
  public p(Number paramNumber)
  {
    AppMethodBeat.i(107878);
    setValue(paramNumber);
    AppMethodBeat.o(107878);
  }
  
  public p(String paramString)
  {
    AppMethodBeat.i(107879);
    setValue(paramString);
    AppMethodBeat.o(107879);
  }
  
  private static boolean a(p paramp)
  {
    if ((paramp.value instanceof Number))
    {
      paramp = (Number)paramp.value;
      return ((paramp instanceof BigInteger)) || ((paramp instanceof Long)) || ((paramp instanceof Integer)) || ((paramp instanceof Short)) || ((paramp instanceof Byte));
    }
    return false;
  }
  
  private static boolean ai(Object paramObject)
  {
    AppMethodBeat.i(107884);
    if ((paramObject instanceof String))
    {
      AppMethodBeat.o(107884);
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = bNy;
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
    if (((paramObject instanceof Number)) || (ai(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.value = paramObject;
      AppMethodBeat.o(107880);
      return;
    }
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
    paramObject = (p)paramObject;
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
      if (yx().longValue() == paramObject.yx().longValue())
      {
        AppMethodBeat.o(107886);
        return true;
      }
      AppMethodBeat.o(107886);
      return false;
    }
    if (((this.value instanceof Number)) && ((paramObject.value instanceof Number)))
    {
      double d1 = yx().doubleValue();
      double d2 = paramObject.yx().doubleValue();
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
  
  public final boolean getAsBoolean()
  {
    AppMethodBeat.i(107881);
    if ((this.value instanceof Boolean))
    {
      bool = ((Boolean)this.value).booleanValue();
      AppMethodBeat.o(107881);
      return bool;
    }
    boolean bool = Boolean.parseBoolean(yy());
    AppMethodBeat.o(107881);
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
      l = yx().longValue();
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(107885);
      return i;
    }
    if ((this.value instanceof Number))
    {
      l = Double.doubleToLongBits(yx().doubleValue());
      i = (int)(l ^ l >>> 32);
      AppMethodBeat.o(107885);
      return i;
    }
    int i = this.value.hashCode();
    AppMethodBeat.o(107885);
    return i;
  }
  
  public final Number yx()
  {
    AppMethodBeat.i(107882);
    if ((this.value instanceof String))
    {
      localObject = new f((String)this.value);
      AppMethodBeat.o(107882);
      return localObject;
    }
    Object localObject = (Number)this.value;
    AppMethodBeat.o(107882);
    return localObject;
  }
  
  public final String yy()
  {
    AppMethodBeat.i(107883);
    if ((this.value instanceof Number))
    {
      str = yx().toString();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.p
 * JD-Core Version:    0.7.0.1
 */