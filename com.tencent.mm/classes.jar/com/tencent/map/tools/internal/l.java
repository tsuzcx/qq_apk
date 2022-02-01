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
    Object localObject1 = y.a(paramContext, u.d);
    File localFile = y.a(paramContext, u.h);
    y.c((File)localObject1);
    y.c(localFile);
    y.a(paramContext, y.a);
    y.a(paramContext, y.b);
    y.a(paramContext, y.c);
    Object localObject2 = y.c(paramContext, u.o);
    int j = t.a(paramContext).a;
    Object localObject3 = y.a((String)localObject2);
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
        if ((y.a(localp.a)) && (localp.a == j))
        {
          if (y.a(paramContext, u.p + File.separator + u.F[j] + File.separator + localp.f, y.b(paramContext, y.c + File.separator + u.F[j] + File.separator + localp.c), true, true)) {
            ((ArrayList)localObject2).add(localp);
          } else {
            i = 0;
          }
        }
        else
        {
          if (y.a(localp.a)) {
            break label491;
          }
          if (y.a(paramContext, u.b + File.separator + localp.f, y.b(paramContext, y.a + File.separator + localp.c), true, true)) {
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
        y.c((File)localObject1);
        y.c(localFile);
        i = 0;
        break;
      }
      localObject1 = y.a((List)localObject2);
      y.a(paramContext, u.q, (String)localObject1);
      z.e = y.b((List)localObject2);
      i = 1;
      break;
      y.a(paramContext, u.C, paramString);
      y.a(paramContext, u.A, "default");
      y.a(paramContext, u.B, "default");
      AppMethodBeat.o(180817);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.l
 * JD-Core Version:    0.7.0.1
 */