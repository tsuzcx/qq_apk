package com.google.c.b.a;

import com.google.c.b.j;
import com.google.c.p;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i
  implements s
{
  private final com.google.c.b.d dEB;
  private final com.google.c.b.c dEy;
  private final d dEz;
  private final com.google.c.b.b.b dFi;
  private final com.google.c.d dGq;
  
  public i(com.google.c.b.c paramc, com.google.c.d paramd, com.google.c.b.d paramd1, d paramd2)
  {
    AppMethodBeat.i(108032);
    this.dFi = com.google.c.b.b.b.Zw();
    this.dEy = paramc;
    this.dGq = paramd;
    this.dEB = paramd1;
    this.dEz = paramd2;
    AppMethodBeat.o(108032);
  }
  
  private Map<String, b> a(final com.google.c.e parame, com.google.c.c.a<?> parama, Class<?> paramClass)
  {
    AppMethodBeat.i(108036);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
    {
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
    Type localType1 = parama.dGJ;
    Object localObject2 = paramClass;
    Object localObject1 = parama;
    int i;
    label63:
    int j;
    label153:
    final boolean bool2;
    if (localObject2 != Object.class)
    {
      Field[] arrayOfField = ((Class)localObject2).getDeclaredFields();
      int k = arrayOfField.length;
      i = 0;
      if (i < k)
      {
        final Field localField = arrayOfField[i];
        boolean bool1 = a(localField, true);
        boolean bool3 = a(localField, false);
        if ((bool1) || (bool3))
        {
          this.dFi.a(localField);
          Type localType2 = com.google.c.b.b.a(((com.google.c.c.a)localObject1).dGJ, (Class)localObject2, localField.getGenericType());
          List localList = c(localField);
          parama = null;
          int m = localList.size();
          j = 0;
          if (j < m)
          {
            String str = (String)localList.get(j);
            if (j != 0) {
              bool1 = false;
            }
            final com.google.c.c.a locala = com.google.c.c.a.h(localType2);
            final boolean bool4 = j.g(locala.dIb);
            Object localObject3 = (com.google.c.a.b)localField.getAnnotation(com.google.c.a.b.class);
            paramClass = null;
            if (localObject3 != null) {
              paramClass = d.a(this.dEy, parame, locala, (com.google.c.a.b)localObject3);
            }
            if (paramClass != null)
            {
              bool2 = true;
              label238:
              localObject3 = paramClass;
              if (paramClass == null) {
                localObject3 = parame.a(locala);
              }
              paramClass = (b)localLinkedHashMap.put(str, new b(str, bool1, bool3)
              {
                final void a(com.google.c.d.a paramAnonymousa, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(208904);
                  paramAnonymousa = this.dGt.a(paramAnonymousa);
                  if ((paramAnonymousa != null) || (!bool4)) {
                    localField.set(paramAnonymousObject, paramAnonymousa);
                  }
                  AppMethodBeat.o(208904);
                }
                
                final void a(com.google.c.d.c paramAnonymousc, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108000);
                  Object localObject = localField.get(paramAnonymousObject);
                  if (bool2) {}
                  for (paramAnonymousObject = this.dGt;; paramAnonymousObject = new m(parame, this.dGt, locala.dGJ))
                  {
                    paramAnonymousObject.a(paramAnonymousc, localObject);
                    AppMethodBeat.o(108000);
                    return;
                  }
                }
                
                public final boolean bq(Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108001);
                  if (!this.dGz)
                  {
                    AppMethodBeat.o(108001);
                    return false;
                  }
                  if (localField.get(paramAnonymousObject) != paramAnonymousObject)
                  {
                    AppMethodBeat.o(108001);
                    return true;
                  }
                  AppMethodBeat.o(108001);
                  return false;
                }
              });
              if (parama != null) {
                break label405;
              }
              parama = paramClass;
            }
          }
        }
      }
    }
    label405:
    for (;;)
    {
      j += 1;
      break label153;
      bool2 = false;
      break label238;
      if (parama != null)
      {
        parame = new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + parama.name);
        AppMethodBeat.o(108036);
        throw parame;
      }
      i += 1;
      break label63;
      localObject1 = com.google.c.c.a.h(com.google.c.b.b.a(((com.google.c.c.a)localObject1).dGJ, (Class)localObject2, ((Class)localObject2).getGenericSuperclass()));
      localObject2 = ((com.google.c.c.a)localObject1).dIb;
      break;
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    AppMethodBeat.i(108033);
    Object localObject = this.dEB;
    int i;
    if ((((com.google.c.b.d)localObject).B(paramField.getType())) || (((com.google.c.b.d)localObject).bV(paramBoolean)))
    {
      i = 1;
      if (i != 0) {
        break label299;
      }
      if ((((com.google.c.b.d)localObject).dFs & paramField.getModifiers()) == 0) {
        break label69;
      }
      i = 1;
    }
    label167:
    label177:
    for (;;)
    {
      if (i != 0) {
        break label299;
      }
      AppMethodBeat.o(108033);
      return true;
      i = 0;
      break;
      label69:
      if ((((com.google.c.b.d)localObject).dFr != -1.0D) && (!((com.google.c.b.d)localObject).a((com.google.c.a.d)paramField.getAnnotation(com.google.c.a.d.class), (com.google.c.a.e)paramField.getAnnotation(com.google.c.a.e.class))))
      {
        i = 1;
      }
      else if (paramField.isSynthetic())
      {
        i = 1;
      }
      else
      {
        if (((com.google.c.b.d)localObject).dFu)
        {
          com.google.c.a.a locala = (com.google.c.a.a)paramField.getAnnotation(com.google.c.a.a.class);
          if (locala != null)
          {
            if (!paramBoolean) {
              break label167;
            }
            if (locala.YR()) {
              break label177;
            }
          }
          while (!locala.YS())
          {
            i = 1;
            break;
          }
        }
        if ((!((com.google.c.b.d)localObject).dFt) && (com.google.c.b.d.D(paramField.getType())))
        {
          i = 1;
        }
        else if (com.google.c.b.d.C(paramField.getType()))
        {
          i = 1;
        }
        else
        {
          if (paramBoolean) {}
          for (localObject = ((com.google.c.b.d)localObject).dFv;; localObject = ((com.google.c.b.d)localObject).dFw)
          {
            if (((List)localObject).isEmpty()) {
              break label294;
            }
            new com.google.c.b(paramField);
            paramField = ((List)localObject).iterator();
            do
            {
              if (!paramField.hasNext()) {
                break;
              }
            } while (!((com.google.c.a)paramField.next()).YH());
            i = 1;
            break;
          }
          i = 0;
        }
      }
    }
    label294:
    label299:
    AppMethodBeat.o(108033);
    return false;
  }
  
  private List<String> c(Field paramField)
  {
    AppMethodBeat.i(108034);
    Object localObject = (com.google.c.a.c)paramField.getAnnotation(com.google.c.a.c.class);
    if (localObject == null)
    {
      paramField = Collections.singletonList(this.dGq.b(paramField));
      AppMethodBeat.o(108034);
      return paramField;
    }
    paramField = ((com.google.c.a.c)localObject).value();
    localObject = ((com.google.c.a.c)localObject).YU();
    if (localObject.length == 0)
    {
      paramField = Collections.singletonList(paramField);
      AppMethodBeat.o(108034);
      return paramField;
    }
    ArrayList localArrayList = new ArrayList(localObject.length + 1);
    localArrayList.add(paramField);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(localObject[i]);
      i += 1;
    }
    AppMethodBeat.o(108034);
    return localArrayList;
  }
  
  public final <T> r<T> a(com.google.c.e parame, com.google.c.c.a<T> parama)
  {
    AppMethodBeat.i(108035);
    Class localClass = parama.dIb;
    if (!Object.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108035);
      return null;
    }
    parame = new a(this.dEy.b(parama), a(parame, parama, localClass));
    AppMethodBeat.o(108035);
    return parame;
  }
  
  public static final class a<T>
    extends r<T>
  {
    private final com.google.c.b.i<T> dGd;
    private final Map<String, i.b> dGy;
    
    a(com.google.c.b.i<T> parami, Map<String, i.b> paramMap)
    {
      this.dGd = parami;
      this.dGy = paramMap;
    }
    
    public final T a(com.google.c.d.a parama)
    {
      AppMethodBeat.i(208888);
      if (parama.Zh() == com.google.c.d.b.dIv)
      {
        parama.Zl();
        AppMethodBeat.o(208888);
        return null;
      }
      Object localObject1 = this.dGd.YW();
      try
      {
        parama.Zf();
        for (;;)
        {
          if (!parama.hasNext()) {
            break label127;
          }
          localObject2 = parama.Zi();
          localObject2 = (i.b)this.dGy.get(localObject2);
          if ((localObject2 != null) && (((i.b)localObject2).dGA)) {
            break;
          }
          parama.Zp();
        }
      }
      catch (IllegalStateException parama)
      {
        for (;;)
        {
          Object localObject2;
          parama = new p(parama);
          AppMethodBeat.o(208888);
          throw parama;
          ((i.b)localObject2).a(parama, localObject1);
        }
      }
      catch (IllegalAccessException parama)
      {
        parama = new AssertionError(parama);
        AppMethodBeat.o(208888);
        throw parama;
      }
      label127:
      parama.Zg();
      AppMethodBeat.o(208888);
      return localObject1;
    }
    
    public final void a(com.google.c.d.c paramc, T paramT)
    {
      AppMethodBeat.i(108013);
      if (paramT == null)
      {
        paramc.Zv();
        AppMethodBeat.o(108013);
        return;
      }
      paramc.Zt();
      try
      {
        Iterator localIterator = this.dGy.values().iterator();
        while (localIterator.hasNext())
        {
          i.b localb = (i.b)localIterator.next();
          if (localb.bq(paramT))
          {
            paramc.dM(localb.name);
            localb.a(paramc, paramT);
          }
        }
        paramc.Zu();
      }
      catch (IllegalAccessException paramc)
      {
        paramc = new AssertionError(paramc);
        AppMethodBeat.o(108013);
        throw paramc;
      }
      AppMethodBeat.o(108013);
    }
  }
  
  static abstract class b
  {
    final boolean dGA;
    final boolean dGz;
    final String name;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.dGz = paramBoolean1;
      this.dGA = paramBoolean2;
    }
    
    abstract void a(com.google.c.d.a parama, Object paramObject);
    
    abstract void a(com.google.c.d.c paramc, Object paramObject);
    
    abstract boolean bq(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.a.i
 * JD-Core Version:    0.7.0.1
 */