package com.tencent.mm.hellhoundlib;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class a
{
  private static a fXS;
  private static g fXW = null;
  private static c fXX = null;
  private final e fXT;
  private final f fXU;
  public d fXV;
  
  private a()
  {
    AppMethodBeat.i(55504);
    this.fXT = new e() {};
    this.fXU = new f() {};
    this.fXV = null;
    AppMethodBeat.o(55504);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Object paramObject)
  {
    AppMethodBeat.i(183786);
    if ((paramString2 == null) && (paramString3 == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString4, paramString5, paramString6, paramObject);
      AppMethodBeat.o(183786);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString4, paramString5, paramString6);
    AppMethodBeat.o(183786);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(177066);
    if ((paramString2 == null) && (paramString3 == null))
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString4, paramString5, paramString6, paramObject, paramArrayOfObject);
      AppMethodBeat.o(177066);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2, paramString4, paramString5, paramString6, paramObject, paramArrayOfObject);
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
    AppMethodBeat.i(55510);
    com.tencent.mm.hellhoundlib.a.a.g(paramMap, paramc);
    AppMethodBeat.o(55510);
  }
  
  public static a adm()
  {
    AppMethodBeat.i(55503);
    if (fXS == null) {}
    try
    {
      if (fXS == null) {
        fXS = new a();
      }
      a locala = fXS;
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
  
  public static void b(Map<String, List<Pair<String, String>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(177061);
    com.tencent.mm.hellhoundlib.a.a.h(paramMap, paramc);
    AppMethodBeat.o(177061);
  }
  
  public static void c(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(168718);
    com.tencent.mm.hellhoundlib.a.a.i(paramMap, paramc);
    AppMethodBeat.o(168718);
  }
  
  public static void d(Map<String, Pair<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(177062);
    com.tencent.mm.hellhoundlib.a.a.j(paramMap, paramc);
    AppMethodBeat.o(177062);
  }
  
  public static void e(Map<String, Map<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(177063);
    com.tencent.mm.hellhoundlib.a.a.k(paramMap, paramc);
    AppMethodBeat.o(177063);
  }
  
  public static void f(Map<String, Map<String, List<Pair<String, String>>>> paramMap, com.tencent.mm.hellhoundlib.a.c paramc)
  {
    AppMethodBeat.i(177064);
    com.tencent.mm.hellhoundlib.a.a.l(paramMap, paramc);
    AppMethodBeat.o(177064);
  }
  
  public final void a(Object paramObject, Intent paramIntent)
  {
    AppMethodBeat.i(55506);
    if (!b.aW(paramObject))
    {
      AppMethodBeat.o(55506);
      return;
    }
    if (this.fXV != null) {
      this.fXV.b(paramObject, paramIntent);
    }
    AppMethodBeat.o(55506);
  }
  
  public final void aV(Object paramObject)
  {
    AppMethodBeat.i(55508);
    if (((paramObject instanceof Activity)) && (this.fXV != null)) {
      this.fXV.x((Activity)paramObject);
    }
    AppMethodBeat.o(55508);
  }
  
  public final void e(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(55505);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55505);
      return;
      if (this.fXV != null)
      {
        this.fXV.aX(paramObject);
        AppMethodBeat.o(55505);
        return;
        if (this.fXV != null)
        {
          this.fXV.aY(paramObject);
          AppMethodBeat.o(55505);
          return;
          if (this.fXV != null)
          {
            this.fXV.aZ(paramObject);
            AppMethodBeat.o(55505);
            return;
            if (this.fXV != null)
            {
              this.fXV.ba(paramObject);
              AppMethodBeat.o(55505);
              return;
              if (this.fXV != null)
              {
                this.fXV.bb(paramObject);
                AppMethodBeat.o(55505);
                return;
                if (this.fXV != null) {
                  this.fXV.bc(paramObject);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.a
 * JD-Core Version:    0.7.0.1
 */