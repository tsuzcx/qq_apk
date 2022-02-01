package com.google.a.b.a;

import com.google.a.b.j;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
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
  private final com.google.a.b.c bKQ;
  private final d bKR;
  private final com.google.a.b.d bKT;
  private final com.google.a.b.b.b bLA;
  private final com.google.a.d bML;
  
  public i(com.google.a.b.c paramc, com.google.a.d paramd, com.google.a.b.d paramd1, d paramd2)
  {
    AppMethodBeat.i(108032);
    this.bLA = com.google.a.b.b.b.zL();
    this.bKQ = paramc;
    this.bML = paramd;
    this.bKT = paramd1;
    this.bKR = paramd2;
    AppMethodBeat.o(108032);
  }
  
  private Map<String, b> a(final com.google.a.e parame, com.google.a.c.a<?> parama, Class<?> paramClass)
  {
    AppMethodBeat.i(108036);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
    {
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
    Type localType1 = parama.bNe;
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
          this.bLA.a(localField);
          Type localType2 = com.google.a.b.b.a(((com.google.a.c.a)localObject1).bNe, (Class)localObject2, localField.getGenericType());
          List localList = b(localField);
          parama = null;
          int m = localList.size();
          j = 0;
          if (j < m)
          {
            String str = (String)localList.get(j);
            if (j != 0) {
              bool1 = false;
            }
            final com.google.a.c.a locala = com.google.a.c.a.h(localType2);
            final boolean bool4 = j.g(locala.bOw);
            Object localObject3 = (com.google.a.a.b)localField.getAnnotation(com.google.a.a.b.class);
            paramClass = null;
            if (localObject3 != null) {
              paramClass = d.a(this.bKQ, parame, locala, (com.google.a.a.b)localObject3);
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
                final void a(com.google.a.d.a paramAnonymousa, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(222838);
                  paramAnonymousa = this.bMO.a(paramAnonymousa);
                  if ((paramAnonymousa != null) || (!bool4)) {
                    localField.set(paramAnonymousObject, paramAnonymousa);
                  }
                  AppMethodBeat.o(222838);
                }
                
                final void a(com.google.a.d.c paramAnonymousc, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108000);
                  Object localObject = localField.get(paramAnonymousObject);
                  if (bool2) {}
                  for (paramAnonymousObject = this.bMO;; paramAnonymousObject = new m(parame, this.bMO, locala.bNe))
                  {
                    paramAnonymousObject.a(paramAnonymousc, localObject);
                    AppMethodBeat.o(108000);
                    return;
                  }
                }
                
                public final boolean ai(Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108001);
                  if (!this.bMU)
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
      localObject1 = com.google.a.c.a.h(com.google.a.b.b.a(((com.google.a.c.a)localObject1).bNe, (Class)localObject2, ((Class)localObject2).getGenericSuperclass()));
      localObject2 = ((com.google.a.c.a)localObject1).bOw;
      break;
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    AppMethodBeat.i(108033);
    Object localObject = this.bKT;
    int i;
    if ((((com.google.a.b.d)localObject).s(paramField.getType())) || (((com.google.a.b.d)localObject).bo(paramBoolean)))
    {
      i = 1;
      if (i != 0) {
        break label299;
      }
      if ((((com.google.a.b.d)localObject).bLK & paramField.getModifiers()) == 0) {
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
      if ((((com.google.a.b.d)localObject).bLJ != -1.0D) && (!((com.google.a.b.d)localObject).a((com.google.a.a.d)paramField.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e)paramField.getAnnotation(com.google.a.a.e.class))))
      {
        i = 1;
      }
      else if (paramField.isSynthetic())
      {
        i = 1;
      }
      else
      {
        if (((com.google.a.b.d)localObject).bLM)
        {
          com.google.a.a.a locala = (com.google.a.a.a)paramField.getAnnotation(com.google.a.a.a.class);
          if (locala != null)
          {
            if (!paramBoolean) {
              break label167;
            }
            if (locala.zg()) {
              break label177;
            }
          }
          while (!locala.zh())
          {
            i = 1;
            break;
          }
        }
        if ((!((com.google.a.b.d)localObject).bLL) && (com.google.a.b.d.u(paramField.getType())))
        {
          i = 1;
        }
        else if (com.google.a.b.d.t(paramField.getType()))
        {
          i = 1;
        }
        else
        {
          if (paramBoolean) {}
          for (localObject = ((com.google.a.b.d)localObject).bLN;; localObject = ((com.google.a.b.d)localObject).bLO)
          {
            if (((List)localObject).isEmpty()) {
              break label294;
            }
            new com.google.a.b(paramField);
            paramField = ((List)localObject).iterator();
            do
            {
              if (!paramField.hasNext()) {
                break;
              }
            } while (!((com.google.a.a)paramField.next()).yW());
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
  
  private List<String> b(Field paramField)
  {
    AppMethodBeat.i(108034);
    Object localObject = (com.google.a.a.c)paramField.getAnnotation(com.google.a.a.c.class);
    if (localObject == null)
    {
      paramField = Collections.singletonList(this.bML.a(paramField));
      AppMethodBeat.o(108034);
      return paramField;
    }
    paramField = ((com.google.a.a.c)localObject).value();
    localObject = ((com.google.a.a.c)localObject).zj();
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
  
  public final <T> r<T> a(com.google.a.e parame, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(108035);
    Class localClass = parama.bOw;
    if (!Object.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108035);
      return null;
    }
    parame = new a(this.bKQ.b(parama), a(parame, parama, localClass));
    AppMethodBeat.o(108035);
    return parame;
  }
  
  public static final class a<T>
    extends r<T>
  {
    private final Map<String, i.b> bMT;
    private final com.google.a.b.i<T> bMx;
    
    a(com.google.a.b.i<T> parami, Map<String, i.b> paramMap)
    {
      this.bMx = parami;
      this.bMT = paramMap;
    }
    
    public final T a(com.google.a.d.a parama)
    {
      AppMethodBeat.i(222979);
      if (parama.zw() == com.google.a.d.b.bOQ)
      {
        parama.zA();
        AppMethodBeat.o(222979);
        return null;
      }
      Object localObject1 = this.bMx.zl();
      try
      {
        parama.zu();
        for (;;)
        {
          if (!parama.hasNext()) {
            break label127;
          }
          localObject2 = parama.zx();
          localObject2 = (i.b)this.bMT.get(localObject2);
          if ((localObject2 != null) && (((i.b)localObject2).bMV)) {
            break;
          }
          parama.zE();
        }
      }
      catch (IllegalStateException parama)
      {
        for (;;)
        {
          Object localObject2;
          parama = new p(parama);
          AppMethodBeat.o(222979);
          throw parama;
          ((i.b)localObject2).a(parama, localObject1);
        }
      }
      catch (IllegalAccessException parama)
      {
        parama = new AssertionError(parama);
        AppMethodBeat.o(222979);
        throw parama;
      }
      label127:
      parama.zv();
      AppMethodBeat.o(222979);
      return localObject1;
    }
    
    public final void a(com.google.a.d.c paramc, T paramT)
    {
      AppMethodBeat.i(108013);
      if (paramT == null)
      {
        paramc.zK();
        AppMethodBeat.o(108013);
        return;
      }
      paramc.zI();
      try
      {
        Iterator localIterator = this.bMT.values().iterator();
        while (localIterator.hasNext())
        {
          i.b localb = (i.b)localIterator.next();
          if (localb.ai(paramT))
          {
            paramc.cm(localb.name);
            localb.a(paramc, paramT);
          }
        }
        paramc.zJ();
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
    final boolean bMU;
    final boolean bMV;
    final String name;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.bMU = paramBoolean1;
      this.bMV = paramBoolean2;
    }
    
    abstract void a(com.google.a.d.a parama, Object paramObject);
    
    abstract void a(com.google.a.d.c paramc, Object paramObject);
    
    abstract boolean ai(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.a.i
 * JD-Core Version:    0.7.0.1
 */