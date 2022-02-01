package com.google.a.b.a;

import com.google.a.b.j;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
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

public final class h
  implements t
{
  private final com.google.a.b.b.b bFO;
  private final com.google.a.b.c bFb;
  private final d bFc;
  private final com.google.a.b.d bFe;
  private final com.google.a.e bFx;
  
  public h(com.google.a.b.c paramc, com.google.a.e parame, com.google.a.b.d paramd, d paramd1)
  {
    AppMethodBeat.i(108032);
    this.bFO = com.google.a.b.b.b.xJ();
    this.bFb = paramc;
    this.bFx = parame;
    this.bFe = paramd;
    this.bFc = paramd1;
    AppMethodBeat.o(108032);
  }
  
  private Map<String, b> a(final f paramf, com.google.a.c.a<?> parama, Class<?> paramClass)
  {
    AppMethodBeat.i(108036);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
    {
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
    Type localType1 = parama.bHl;
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
          this.bFO.a(localField);
          Type localType2 = com.google.a.b.b.a(((com.google.a.c.a)localObject1).bHl, (Class)localObject2, localField.getGenericType());
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
            final boolean bool4 = j.g(locala.bIC);
            Object localObject3 = (com.google.a.a.b)localField.getAnnotation(com.google.a.a.b.class);
            paramClass = null;
            if (localObject3 != null) {
              paramClass = d.a(this.bFb, paramf, locala, (com.google.a.a.b)localObject3);
            }
            if (paramClass != null)
            {
              bool2 = true;
              label238:
              localObject3 = paramClass;
              if (paramClass == null) {
                localObject3 = paramf.a(locala);
              }
              paramClass = (b)localLinkedHashMap.put(str, new b(str, bool1, bool3)
              {
                final void a(com.google.a.d.a paramAnonymousa, Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108000);
                  Object localObject = localField.get(paramAnonymousObject);
                  if (bool2) {}
                  for (paramAnonymousObject = this.bGV;; paramAnonymousObject = new l(paramf, this.bGV, locala.bHl))
                  {
                    paramAnonymousObject.a(paramAnonymousa, localObject);
                    AppMethodBeat.o(108000);
                    return;
                  }
                }
                
                public final boolean ak(Object paramAnonymousObject)
                {
                  AppMethodBeat.i(108001);
                  if (!this.bHb)
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
        paramf = new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + parama.name);
        AppMethodBeat.o(108036);
        throw paramf;
      }
      i += 1;
      break label63;
      localObject1 = com.google.a.c.a.h(com.google.a.b.b.a(((com.google.a.c.a)localObject1).bHl, (Class)localObject2, ((Class)localObject2).getGenericSuperclass()));
      localObject2 = ((com.google.a.c.a)localObject1).bIC;
      break;
      AppMethodBeat.o(108036);
      return localLinkedHashMap;
    }
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    AppMethodBeat.i(108033);
    Object localObject = this.bFe;
    int i;
    if ((((com.google.a.b.d)localObject).D(paramField.getType())) || (((com.google.a.b.d)localObject).bf(paramBoolean)))
    {
      i = 1;
      if (i != 0) {
        break label299;
      }
      if ((((com.google.a.b.d)localObject).bFY & paramField.getModifiers()) == 0) {
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
      if ((((com.google.a.b.d)localObject).bFX != -1.0D) && (!((com.google.a.b.d)localObject).a((com.google.a.a.d)paramField.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e)paramField.getAnnotation(com.google.a.a.e.class))))
      {
        i = 1;
      }
      else if (paramField.isSynthetic())
      {
        i = 1;
      }
      else
      {
        if (((com.google.a.b.d)localObject).bGa)
        {
          com.google.a.a.a locala = (com.google.a.a.a)paramField.getAnnotation(com.google.a.a.a.class);
          if (locala != null)
          {
            if (!paramBoolean) {
              break label167;
            }
            if (locala.xs()) {
              break label177;
            }
          }
          while (!locala.xt())
          {
            i = 1;
            break;
          }
        }
        if ((!((com.google.a.b.d)localObject).bFZ) && (com.google.a.b.d.F(paramField.getType())))
        {
          i = 1;
        }
        else if (com.google.a.b.d.E(paramField.getType()))
        {
          i = 1;
        }
        else
        {
          if (paramBoolean) {}
          for (localObject = ((com.google.a.b.d)localObject).bGb;; localObject = ((com.google.a.b.d)localObject).bGc)
          {
            if (((List)localObject).isEmpty()) {
              break label294;
            }
            new com.google.a.c(paramField);
            paramField = ((List)localObject).iterator();
            do
            {
              if (!paramField.hasNext()) {
                break;
              }
            } while (!((com.google.a.b)paramField.next()).xj());
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
      paramField = Collections.singletonList(this.bFx.a(paramField));
      AppMethodBeat.o(108034);
      return paramField;
    }
    paramField = ((com.google.a.a.c)localObject).value();
    localObject = ((com.google.a.a.c)localObject).xv();
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
  
  public final <T> s<T> a(f paramf, com.google.a.c.a<T> parama)
  {
    AppMethodBeat.i(108035);
    Class localClass = parama.bIC;
    if (!Object.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(108035);
      return null;
    }
    paramf = new a(this.bFb.b(parama), a(paramf, parama, localClass));
    AppMethodBeat.o(108035);
    return paramf;
  }
  
  public static final class a<T>
    extends s<T>
  {
    private final com.google.a.b.h<T> bGJ;
    private final Map<String, h.b> bHa;
    
    a(com.google.a.b.h<T> paramh, Map<String, h.b> paramMap)
    {
      this.bGJ = paramh;
      this.bHa = paramMap;
    }
    
    public final void a(com.google.a.d.a parama, T paramT)
    {
      AppMethodBeat.i(108013);
      if (paramT == null)
      {
        parama.xI();
        AppMethodBeat.o(108013);
        return;
      }
      parama.xG();
      try
      {
        Iterator localIterator = this.bHa.values().iterator();
        while (localIterator.hasNext())
        {
          h.b localb = (h.b)localIterator.next();
          if (localb.ak(paramT))
          {
            parama.bp(localb.name);
            localb.a(parama, paramT);
          }
        }
        parama.xH();
      }
      catch (IllegalAccessException parama)
      {
        parama = new AssertionError(parama);
        AppMethodBeat.o(108013);
        throw parama;
      }
      AppMethodBeat.o(108013);
    }
  }
  
  static abstract class b
  {
    final boolean bHb;
    final boolean bHc;
    final String name;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.bHb = paramBoolean1;
      this.bHc = paramBoolean2;
    }
    
    abstract void a(com.google.a.d.a parama, Object paramObject);
    
    abstract boolean ak(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.a.h
 * JD-Core Version:    0.7.0.1
 */