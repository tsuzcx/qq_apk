package com.tencent.mm.hellhoundlib;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a jXm;
  private static g jXq = null;
  private static c jXr = null;
  private final e jXn;
  private final f jXo;
  public d jXp;
  
  private a()
  {
    AppMethodBeat.i(55504);
    this.jXn = new e() {};
    this.jXo = new f() {};
    this.jXp = null;
    AppMethodBeat.o(55504);
  }
  
  public static Object a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(215193);
    paramString1 = com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2, paramString3, paramString4, paramString5, paramObject, paramArrayOfObject);
    AppMethodBeat.o(215193);
    return paramString1;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(215198);
    if ((paramString2 == null) && (paramString3 == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString4, paramString5, paramString6, paramObject1, paramObject2);
      AppMethodBeat.o(215198);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString4, paramString5, paramString6, paramObject2);
    AppMethodBeat.o(215198);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(177066);
    if ((paramString2 == null) && (paramString3 == null))
    {
      com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString4, paramString5, paramString6, paramObject, paramArrayOfObject);
      AppMethodBeat.o(177066);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramObject, paramArrayOfObject);
    AppMethodBeat.o(177066);
  }
  
  public static void a(List<Pair<String, String>> paramList, com.tencent.mm.hellhoundlib.a.b paramb)
  {
    AppMethodBeat.i(177065);
    com.tencent.mm.hellhoundlib.a.a.c(paramList, paramb);
    AppMethodBeat.o(177065);
  }
  
  public static void a(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.b paramb)
  {
    AppMethodBeat.i(183784);
    com.tencent.mm.hellhoundlib.a.a.c(paramMap, paramb);
    AppMethodBeat.o(183784);
  }
  
  public static void a(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(215191);
    com.tencent.mm.hellhoundlib.a.a.b(paramMap, paramc);
    AppMethodBeat.o(215191);
  }
  
  public static void a(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(55510);
    com.tencent.mm.hellhoundlib.a.a.g(paramMap, paramd);
    AppMethodBeat.o(55510);
  }
  
  public static a aFg()
  {
    AppMethodBeat.i(55503);
    if (jXm == null) {}
    try
    {
      if (jXm == null) {
        jXm = new a();
      }
      a locala = jXm;
      AppMethodBeat.o(55503);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(55503);
    }
  }
  
  public static void b(List<Pair<String, String>> paramList, com.tencent.mm.hellhoundlib.a.b paramb)
  {
    AppMethodBeat.i(183783);
    com.tencent.mm.hellhoundlib.a.a.d(paramList, paramb);
    AppMethodBeat.o(183783);
  }
  
  public static void b(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.b paramb)
  {
    AppMethodBeat.i(183785);
    com.tencent.mm.hellhoundlib.a.a.d(paramMap, paramb);
    AppMethodBeat.o(183785);
  }
  
  public static void b(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(177061);
    com.tencent.mm.hellhoundlib.a.a.h(paramMap, paramd);
    AppMethodBeat.o(177061);
  }
  
  public static void c(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(168718);
    com.tencent.mm.hellhoundlib.a.a.i(paramMap, paramd);
    AppMethodBeat.o(168718);
  }
  
  public static void d(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(177062);
    com.tencent.mm.hellhoundlib.a.a.j(paramMap, paramd);
    AppMethodBeat.o(177062);
  }
  
  public static void e(Map<String, Map<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(177063);
    com.tencent.mm.hellhoundlib.a.a.k(paramMap, paramd);
    AppMethodBeat.o(177063);
  }
  
  public static void f(Map<String, Map<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.d paramd)
  {
    AppMethodBeat.i(177064);
    com.tencent.mm.hellhoundlib.a.a.l(paramMap, paramd);
    AppMethodBeat.o(177064);
  }
  
  public final void a(Object paramObject, Intent paramIntent)
  {
    AppMethodBeat.i(55506);
    if (!b.bf(paramObject))
    {
      AppMethodBeat.o(55506);
      return;
    }
    if (this.jXp != null) {
      this.jXp.b(paramObject, paramIntent);
    }
    AppMethodBeat.o(55506);
  }
  
  public final void be(Object paramObject)
  {
    AppMethodBeat.i(55508);
    if (((paramObject instanceof Activity)) && (this.jXp != null)) {
      this.jXp.w((Activity)paramObject);
    }
    AppMethodBeat.o(55508);
  }
  
  public final void g(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(55505);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55505);
      return;
      if (this.jXp != null)
      {
        this.jXp.bg(paramObject);
        AppMethodBeat.o(55505);
        return;
        if (this.jXp != null)
        {
          this.jXp.bh(paramObject);
          AppMethodBeat.o(55505);
          return;
          if (this.jXp != null)
          {
            this.jXp.bi(paramObject);
            AppMethodBeat.o(55505);
            return;
            if (this.jXp != null)
            {
              this.jXp.bj(paramObject);
              AppMethodBeat.o(55505);
              return;
              if (this.jXp != null)
              {
                this.jXp.bk(paramObject);
                AppMethodBeat.o(55505);
                return;
                if (this.jXp != null) {
                  this.jXp.bl(paramObject);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.a
 * JD-Core Version:    0.7.0.1
 */