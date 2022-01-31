package a.j.b.a.c.i.b;

import a.f.b.j;
import a.j.b.a.c.b.y;
import a.j.b.a.c.l.w;

public abstract class f<T>
{
  private final T value;
  
  public f(T paramT)
  {
    this.value = paramT;
  }
  
  public abstract w b(y paramy);
  
  public boolean equals(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((f)this != paramObject)
    {
      localObject2 = getValue();
      if ((paramObject instanceof f)) {
        break label55;
      }
      paramObject = null;
    }
    label55:
    for (;;)
    {
      f localf = (f)paramObject;
      paramObject = localObject1;
      if (localf != null) {
        paramObject = localf.getValue();
      }
      return j.e(localObject2, paramObject);
    }
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = getValue();
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.i.b.f
 * JD-Core Version:    0.7.0.1
 */