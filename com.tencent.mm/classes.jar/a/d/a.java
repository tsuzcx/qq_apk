package a.d;

import a.d.b.g;
import a.k;

public final class a
{
  public static final <T> Class<T> a(a.f.b<T> paramb)
  {
    g.k(paramb, "$receiver");
    paramb = ((a.d.b.b)paramb).cUj();
    Object localObject;
    if (!paramb.isPrimitive())
    {
      localObject = paramb;
      if (paramb == null) {
        throw new k("null cannot be cast to non-null type java.lang.Class<T>");
      }
    }
    else
    {
      localObject = paramb.getName();
      if (localObject == null) {}
      for (;;)
      {
        localObject = paramb;
        if (paramb != null) {
          break;
        }
        throw new k("null cannot be cast to non-null type java.lang.Class<T>");
        switch (((String)localObject).hashCode())
        {
        default: 
          break;
        case -1325958191: 
          if (((String)localObject).equals("double")) {
            paramb = Double.class;
          }
          break;
        case 64711720: 
          if (((String)localObject).equals("boolean")) {
            paramb = Boolean.class;
          }
          break;
        case 3039496: 
          if (((String)localObject).equals("byte")) {
            paramb = Byte.class;
          }
          break;
        case 3052374: 
          if (((String)localObject).equals("char")) {
            paramb = Character.class;
          }
          break;
        case 109413500: 
          if (((String)localObject).equals("short")) {
            paramb = Short.class;
          }
          break;
        case 97526364: 
          if (((String)localObject).equals("float")) {
            paramb = Float.class;
          }
          break;
        case 104431: 
          if (((String)localObject).equals("int")) {
            paramb = Integer.class;
          }
          break;
        case 3327612: 
          if (((String)localObject).equals("long")) {
            paramb = Long.class;
          }
          break;
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.d.a
 * JD-Core Version:    0.7.0.1
 */