package a.f;

import a.f.b.d;
import a.f.b.j;
import a.j.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"})
public final class a
{
  public static final <T extends Annotation> b<? extends T> a(T paramT)
  {
    AppMethodBeat.i(56247);
    j.q(paramT, "receiver$0");
    paramT = paramT.annotationType();
    j.p(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = aF(paramT);
    if (paramT == null)
    {
      paramT = new a.v("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
      AppMethodBeat.o(56247);
      throw paramT;
    }
    AppMethodBeat.o(56247);
    return paramT;
  }
  
  public static final <T> Class<T> a(b<T> paramb)
  {
    AppMethodBeat.i(56243);
    j.q(paramb, "receiver$0");
    paramb = ((d)paramb).ebg();
    if (paramb == null)
    {
      paramb = new a.v("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(56243);
      throw paramb;
    }
    AppMethodBeat.o(56243);
    return paramb;
  }
  
  public static final <T> b<T> aF(Class<T> paramClass)
  {
    AppMethodBeat.i(56246);
    j.q(paramClass, "receiver$0");
    paramClass = a.f.b.v.aG(paramClass);
    AppMethodBeat.o(56246);
    return paramClass;
  }
  
  public static final <T> Class<T> b(b<T> paramb)
  {
    AppMethodBeat.i(56244);
    j.q(paramb, "receiver$0");
    paramb = ((d)paramb).ebg();
    if (paramb.isPrimitive())
    {
      if (paramb == null)
      {
        paramb = new a.v("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(56244);
        throw paramb;
      }
      AppMethodBeat.o(56244);
      return paramb;
    }
    paramb = paramb.getName();
    if (paramb == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        AppMethodBeat.o(56244);
                        return null;
                        switch (paramb.hashCode())
                        {
                        }
                      }
                    } while (!paramb.equals("java.lang.Integer"));
                    paramb = Integer.TYPE;
                    AppMethodBeat.o(56244);
                    return paramb;
                  } while (!paramb.equals("java.lang.Float"));
                  paramb = Float.TYPE;
                  AppMethodBeat.o(56244);
                  return paramb;
                } while (!paramb.equals("java.lang.Void"));
                paramb = Void.TYPE;
                AppMethodBeat.o(56244);
                return paramb;
              } while (!paramb.equals("java.lang.Character"));
              paramb = Character.TYPE;
              AppMethodBeat.o(56244);
              return paramb;
            } while (!paramb.equals("java.lang.Long"));
            paramb = Long.TYPE;
            AppMethodBeat.o(56244);
            return paramb;
          } while (!paramb.equals("java.lang.Double"));
          paramb = Double.TYPE;
          AppMethodBeat.o(56244);
          return paramb;
        } while (!paramb.equals("java.lang.Short"));
        paramb = Short.TYPE;
        AppMethodBeat.o(56244);
        return paramb;
      } while (!paramb.equals("java.lang.Boolean"));
      paramb = Boolean.TYPE;
      AppMethodBeat.o(56244);
      return paramb;
    } while (!paramb.equals("java.lang.Byte"));
    paramb = Byte.TYPE;
    AppMethodBeat.o(56244);
    return paramb;
  }
  
  public static final <T> Class<T> c(b<T> paramb)
  {
    AppMethodBeat.i(56245);
    j.q(paramb, "receiver$0");
    paramb = ((d)paramb).ebg();
    if (!paramb.isPrimitive())
    {
      if (paramb == null)
      {
        paramb = new a.v("null cannot be cast to non-null type java.lang.Class<T>");
        AppMethodBeat.o(56245);
        throw paramb;
      }
      AppMethodBeat.o(56245);
      return paramb;
    }
    String str = paramb.getName();
    if (str == null) {}
    while (paramb == null)
    {
      paramb = new a.v("null cannot be cast to non-null type java.lang.Class<T>");
      AppMethodBeat.o(56245);
      throw paramb;
      switch (str.hashCode())
      {
      default: 
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramb = Double.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramb = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramb = Void.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramb = Byte.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramb = Character.class;
        }
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramb = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramb = Float.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramb = Integer.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramb = Long.class;
        }
        break;
      }
    }
    AppMethodBeat.o(56245);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.f.a
 * JD-Core Version:    0.7.0.1
 */