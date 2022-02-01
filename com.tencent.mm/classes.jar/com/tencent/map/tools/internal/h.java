package com.tencent.map.tools.internal;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class h
{
  Context a;
  private final String b;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(180795);
    this.b = h.class.getSimpleName();
    this.a = paramContext;
    AppMethodBeat.o(180795);
  }
  
  private int a(Context paramContext)
  {
    AppMethodBeat.i(180797);
    Object localObject1 = y.a(y.b(paramContext, u.q, "default"));
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(180797);
      return 0;
    }
    Object localObject2 = this.a;
    paramContext = new ArrayList();
    new ArrayList();
    new ArrayList();
    Object localObject3 = y.b(y.a((Context)localObject2, y.a));
    if (localObject3 != null)
    {
      paramContext.addAll((Collection)localObject3);
      if (z.e == 1)
      {
        i = t.a(this.a).a;
        localObject2 = y.b(y.a((Context)localObject2, y.c + File.separator + u.F[i]));
        if (localObject2 != null) {
          paramContext.addAll((Collection)localObject2);
        }
      }
    }
    if (paramContext.size() == 0)
    {
      g.a(this.a).a("DLC", "localComp file error");
      AppMethodBeat.o(180797);
      return 1;
    }
    localObject2 = y.b(this.a, u.v, "preference_default");
    localObject3 = y.a((String)localObject2);
    if ((!((String)localObject2).equals("preference_default")) && (!((List)localObject3).isEmpty()) && (y.a((List)localObject1, (List)localObject3)))
    {
      AppMethodBeat.o(180797);
      return 2;
    }
    localObject1 = ((List)localObject1).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      localObject3 = paramContext.iterator();
      String[] arrayOfString;
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        arrayOfString = ((String)((Iterator)localObject3).next()).split(",");
      } while ((arrayOfString.length != 3) || (!((p)localObject2).c.equals(arrayOfString[0])) || (!String.valueOf(((p)localObject2).d).equals(arrayOfString[1])) || (!((p)localObject2).e.equals(arrayOfString[2])));
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        i = 0;
      }
      for (;;)
      {
        break;
        if (i != 0)
        {
          AppMethodBeat.o(180797);
          return 4;
        }
        AppMethodBeat.o(180797);
        return 3;
      }
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(180798);
    paramString = new File(y.b(this.a, paramString));
    if (paramString.exists()) {
      paramString.delete();
    }
    AppMethodBeat.o(180798);
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(180796);
    Object localObject1 = this.a;
    int i = y.d((Context)localObject1);
    if (i <= 3) {
      y.a((Context)localObject1, u.A, "default");
    }
    Object localObject3 = y.a(y.b((Context)localObject1, u.q, "default"));
    if (((List)localObject3).isEmpty()) {
      i = 0;
    }
    Object localObject5;
    Object localObject2;
    Object localObject4;
    int j;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    for (;;)
    {
      if (i == 0)
      {
        AppMethodBeat.o(180796);
        return false;
        if (z.e == -1) {
          z.e = y.b((List)localObject3);
        }
        localObject1 = y.b((Context)localObject1, u.B, "default");
        if ((localObject1 == null) || (((String)localObject1).equals("default")))
        {
          i = 1;
        }
        else
        {
          localObject5 = y.a((String)localObject1);
          if (y.a((List)localObject5, (List)localObject3))
          {
            if (i <= 3) {
              i = 2;
            } else {
              i = 3;
            }
          }
          else if (i <= 3)
          {
            localObject2 = this.a;
            if ((y.b((Context)localObject2, u.u, "default").equals(u.k)) && (!((List)localObject5).isEmpty()))
            {
              localObject1 = y.b((Context)localObject2, u.v, "preference_default");
              localObject4 = y.a((String)localObject1);
              if ((((String)localObject1).equals("preference_default")) || (((List)localObject4).isEmpty()) || (!y.a((List)localObject5, (List)localObject4)))
              {
                j = t.a((Context)localObject2).a;
                localObject4 = new ArrayList();
                localArrayList1 = new ArrayList();
                localArrayList2 = new ArrayList();
                Iterator localIterator = ((List)localObject5).iterator();
                i = 1;
                label274:
                while (localIterator.hasNext())
                {
                  p localp = (p)localIterator.next();
                  localObject1 = y.a(localp.a, (List)localObject3);
                  if (localObject1 != null)
                  {
                    String str1;
                    String str2;
                    String str3;
                    if ((y.a(localp.a)) && (localp.a == j))
                    {
                      str1 = y.e + File.separator + u.F[j] + File.separator + localp.c;
                      str2 = y.c + File.separator + u.F[j] + File.separator + localp.c;
                      str3 = y.c + File.separator + u.F[j] + File.separator + ((p)localObject1).c;
                      str1 = y.b((Context)localObject2, str1);
                      str2 = y.b((Context)localObject2, str2);
                      if (((p)localObject1).c.equals(localp.c)) {}
                      for (localObject1 = null;; localObject1 = y.b((Context)localObject2, str3))
                      {
                        if (!y.a((Context)localObject2, str1, str2, false, false)) {
                          break label557;
                        }
                        localArrayList2.add(new Pair(str2, localObject1));
                        ((List)localObject4).add(localp);
                        break;
                      }
                      label557:
                      i = 0;
                    }
                    else
                    {
                      if (y.a(localp.a)) {
                        break label1134;
                      }
                      str1 = y.d + File.separator + localp.c;
                      str2 = y.a + File.separator + localp.c;
                      str3 = y.a + File.separator + ((p)localObject1).c;
                      str1 = y.b((Context)localObject2, str1);
                      str2 = y.b((Context)localObject2, str2);
                      if (((p)localObject1).c.equals(localp.c)) {}
                      for (localObject1 = null;; localObject1 = y.b((Context)localObject2, str3))
                      {
                        if (!y.a((Context)localObject2, str1, str2, false, false)) {
                          break label757;
                        }
                        localArrayList2.add(new Pair(str2, localObject1));
                        ((List)localObject4).add(localp);
                        break;
                      }
                      label757:
                      i = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1091:
    label1134:
    for (;;)
    {
      break label274;
      if ((((List)localObject4).size() == ((List)localObject5).size()) && (i != 0))
      {
        localObject1 = localArrayList2.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (String)((Pair)((Iterator)localObject1).next()).second;
          if (localObject5 != null)
          {
            localObject5 = new File((String)localObject5);
            if (((File)localObject5).exists()) {
              ((File)localObject5).delete();
            }
          }
        }
        localArrayList1.addAll((Collection)localObject4);
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (p)((Iterator)localObject1).next();
          if (y.a(((p)localObject3).a, (List)localObject4) == null) {
            localArrayList1.add(localObject3);
          }
        }
        localObject1 = y.a(localArrayList1);
        y.a((Context)localObject2, u.q, (String)localObject1);
        g.a((Context)localObject2).a("DBC", (String)localObject1);
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1091;
        }
        i = 5;
        break;
        localObject1 = ((List)localObject5).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (p)((Iterator)localObject1).next();
          if ((y.a(((p)localObject2).a)) && (((p)localObject2).a == j)) {
            a(y.c + File.separator + u.F[j] + File.separator + ((p)localObject2).c);
          } else {
            a(y.a + File.separator + ((p)localObject2).c);
          }
        }
      }
      i = 6;
      break;
      i = 4;
      break;
      i = a(this.a);
      if ((i >= 0) && (i < 4))
      {
        AppMethodBeat.o(180796);
        return false;
      }
      AppMethodBeat.o(180796);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.h
 * JD-Core Version:    0.7.0.1
 */