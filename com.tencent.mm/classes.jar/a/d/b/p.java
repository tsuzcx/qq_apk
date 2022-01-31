package a.d.b;

import a.d.b.a.a;
import a.d.b.a.b;
import java.util.Collection;

public class p
{
  private static ClassCastException a(ClassCastException paramClassCastException)
  {
    throw ((ClassCastException)g.b(paramClassCastException, p.class.getName()));
  }
  
  public static Collection cx(Object paramObject)
  {
    if (((paramObject instanceof a)) && (!(paramObject instanceof b)))
    {
      if (paramObject == null) {}
      for (paramObject = "null";; paramObject = paramObject.getClass().getName()) {
        throw a(new ClassCastException(paramObject + " cannot be cast to " + "kotlin.collections.MutableCollection"));
      }
    }
    return cy(paramObject);
  }
  
  private static Collection cy(Object paramObject)
  {
    try
    {
      paramObject = (Collection)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw a(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.d.b.p
 * JD-Core Version:    0.7.0.1
 */