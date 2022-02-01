package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  private static String a;
  
  static
  {
    AppMethodBeat.i(180818);
    a = l.class.getSimpleName();
    AppMethodBeat.o(180818);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(180817);
    Object localObject1 = x.a(paramContext, t.d);
    File localFile = x.a(paramContext, t.h);
    x.c((File)localObject1);
    x.c(localFile);
    x.a(paramContext, x.a);
    x.a(paramContext, x.b);
    x.a(paramContext, x.c);
    Object localObject2 = x.c(paramContext, t.o);
    int j = s.a(paramContext).a();
    Object localObject3 = x.a((String)localObject2);
    int i;
    if (((List)localObject3).isEmpty())
    {
      i = 0;
      if (i == 0)
      {
        g.a(paramContext).a("DCV", "asset to dir fail");
        AppMethodBeat.o(180817);
        return false;
      }
    }
    else
    {
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      i = 1;
      label137:
      while (((Iterator)localObject3).hasNext())
      {
        p localp = (p)((Iterator)localObject3).next();
        if ((x.a(localp.a)) && (localp.a == j))
        {
          if (x.a(paramContext, t.p + File.separator + t.F[j] + File.separator + localp.f, x.b(paramContext, x.c + File.separator + t.F[j] + File.separator + localp.c), true, true)) {
            ((ArrayList)localObject2).add(localp);
          } else {
            i = 0;
          }
        }
        else
        {
          if (x.a(localp.a)) {
            break label491;
          }
          if (x.a(paramContext, t.b + File.separator + localp.f, x.b(paramContext, x.a + File.separator + localp.c), true, true)) {
            ((ArrayList)localObject2).add(localp);
          } else {
            i = 0;
          }
        }
      }
    }
    label491:
    for (;;)
    {
      break label137;
      if ((i == 0) || (((ArrayList)localObject2).isEmpty()))
      {
        x.c((File)localObject1);
        x.c(localFile);
        i = 0;
        break;
      }
      localObject1 = x.a((List)localObject2);
      x.a(paramContext, t.q, (String)localObject1);
      y.e = x.b((List)localObject2);
      i = 1;
      break;
      x.a(paramContext, t.C, paramString);
      x.a(paramContext, t.A, "default");
      x.a(paramContext, t.B, "default");
      AppMethodBeat.o(180817);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.l
 * JD-Core Version:    0.7.0.1
 */