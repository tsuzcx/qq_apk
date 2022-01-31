package com.tencent.mm.ipcinvoker.wx_extension.b;

import java.lang.ref.WeakReference;

final class b$b<T>
  extends WeakReference<T>
{
  public b$b(T paramT)
  {
    super(paramT);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    Object localObject;
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = ((b)paramObject).get();
      localObject = get();
    } while ((paramObject == localObject) || ((localObject != null) && (localObject.equals(paramObject))));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b.b
 * JD-Core Version:    0.7.0.1
 */