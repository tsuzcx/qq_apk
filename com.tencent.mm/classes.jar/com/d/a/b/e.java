package com.d.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static final Set<String> bWl = new HashSet(Arrays.asList(new String[] { Boolean.class.getName(), Character.class.getName(), Float.class.getName(), Double.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName() }));
  
  public static String a(b.a parama)
  {
    return a(parama.bVZ, parama.mValue);
  }
  
  private static String a(d paramd, Object paramObject)
  {
    return paramd.mName + " = " + paramObject;
  }
  
  public static String a(i parami)
  {
    parami = b(((b)parami).zX(), "name");
    if (parami == null) {
      return "Thread name not available";
    }
    return ap(parami);
  }
  
  public static String ap(Object paramObject)
  {
    int j = 1;
    Object localObject2 = (i)paramObject;
    paramObject = ((b)localObject2).zX();
    Object localObject1 = (Integer)b(paramObject, "count");
    com.tencent.matrix.resource.analyzer.a.b.checkNotNull(localObject1, "count");
    if (((Integer)localObject1).intValue() == 0) {
      return "";
    }
    Object localObject3 = b(paramObject, "value");
    com.tencent.matrix.resource.analyzer.a.b.checkNotNull(localObject3, "value");
    int i;
    if (((localObject3 instanceof a)) && (((a)localObject3).bVX == p.bXt))
    {
      i = 1;
      if (i == 0) {
        break label244;
      }
      localObject2 = (a)localObject3;
      localObject3 = paramObject.iterator();
      while (((Iterator)localObject3).hasNext()) {
        if (((b.a)((Iterator)localObject3).next()).bVZ.mName.equals("offset"))
        {
          i = j;
          label139:
          if (i == 0) {
            break label404;
          }
          paramObject = (Integer)b(paramObject, "offset");
          com.tencent.matrix.resource.analyzer.a.b.checkNotNull(paramObject, "offset");
        }
      }
    }
    for (;;)
    {
      i = paramObject.intValue();
      j = ((Integer)localObject1).intValue();
      if ((!a.$assertionsDisabled) && (((a)localObject2).bVX != p.bXt))
      {
        throw new AssertionError();
        i = 0;
        break;
        i = 0;
        break label139;
      }
      paramObject = ByteBuffer.wrap(((a)localObject2).bS(i, j)).order(com.d.a.b.a.a.bXC).asCharBuffer();
      localObject1 = new char[j];
      paramObject.get((char[])localObject1);
      return new String((char[])localObject1);
      label244:
      if (((localObject3 instanceof a)) && (((a)localObject3).bVX == p.bXw)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramObject = (a)localObject3;
        try
        {
          localObject2 = a.class.getDeclaredMethod("bS", new Class[] { Integer.TYPE, Integer.TYPE });
          ((Method)localObject2).setAccessible(true);
          paramObject = new String((byte[])((Method)localObject2).invoke(paramObject, new Object[] { Integer.valueOf(0), localObject1 }), Charset.forName("UTF-8"));
          return paramObject;
        }
        catch (NoSuchMethodException paramObject)
        {
          throw new RuntimeException(paramObject);
        }
        catch (IllegalAccessException paramObject)
        {
          throw new RuntimeException(paramObject);
        }
        catch (InvocationTargetException paramObject)
        {
          throw new RuntimeException(paramObject);
        }
      }
      throw new UnsupportedOperationException("Could not find char array in ".concat(String.valueOf(localObject2)));
      label404:
      paramObject = Integer.valueOf(0);
    }
  }
  
  public static boolean aq(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return bWl.contains(((b)paramObject).zW().mClassName);
  }
  
  public static boolean ar(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    if (paramObject.bVX != p.bXr) {
      return true;
    }
    return bWl.contains(paramObject.zW().mClassName);
  }
  
  public static <T> T b(List<b.a> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b.a locala = (b.a)paramList.next();
      if (locala.bVZ.mName.equals(paramString)) {
        return locala.mValue;
      }
    }
    throw new IllegalArgumentException("Field " + paramString + " does not exists");
  }
  
  public static String b(Map.Entry<d, Object> paramEntry)
  {
    return a((d)paramEntry.getKey(), paramEntry.getValue());
  }
  
  public static List<b.a> b(i parami)
  {
    return ((b)parami).zX();
  }
  
  public static boolean b(c paramc)
  {
    for (c localc = paramc; localc.zZ() != null; localc = localc.zZ()) {
      if (paramc.mClassName.equals(Thread.class.getName())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.e
 * JD-Core Version:    0.7.0.1
 */