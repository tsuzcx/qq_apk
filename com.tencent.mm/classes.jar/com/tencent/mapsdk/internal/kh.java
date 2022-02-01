package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintStream;

public final class kh
{
  public static ki a;
  
  public static String a()
  {
    AppMethodBeat.i(224765);
    if (a != null)
    {
      String str = a.b();
      AppMethodBeat.o(224765);
      return str;
    }
    AppMethodBeat.o(224765);
    return null;
  }
  
  public static void a(Context paramContext, jx.a parama)
  {
    AppMethodBeat.i(224805);
    if (a != null) {
      a.a(paramContext, parama);
    }
    AppMethodBeat.o(224805);
  }
  
  private static void a(ki paramki)
  {
    if (a != paramki) {
      a = paramki;
    }
  }
  
  private static void a(File paramFile, String paramString1, String paramString2)
  {
    AppMethodBeat.i(224770);
    if (a != null) {
      a.a(paramFile, paramString1, paramString2);
    }
    AppMethodBeat.o(224770);
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(224641);
    if (a != null)
    {
      a.d(paramString);
      AppMethodBeat.o(224641);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224641);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224581);
    if (a != null)
    {
      a.a(paramString1, paramString2);
      AppMethodBeat.o(224581);
      return;
    }
    g(paramString1, paramString2);
    AppMethodBeat.o(224581);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224736);
    if (a != null)
    {
      a.e(paramString1, paramString2, paramThrowable);
      AppMethodBeat.o(224736);
      return;
    }
    b(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(224736);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224687);
    if (a != null)
    {
      a.d(paramString, paramThrowable);
      AppMethodBeat.o(224687);
      return;
    }
    c(paramString, paramThrowable);
    AppMethodBeat.o(224687);
  }
  
  private static void a(boolean paramBoolean, int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(224820);
    if (a != null) {
      a.a(paramBoolean, paramInt, paramVarArgs);
    }
    AppMethodBeat.o(224820);
  }
  
  private static void a(boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(224812);
    if (a != null) {
      a.a(paramBoolean, paramVarArgs);
    }
    AppMethodBeat.o(224812);
  }
  
  private static boolean a(int paramInt, String paramString)
  {
    AppMethodBeat.i(224795);
    if (a != null)
    {
      boolean bool = a.a(paramInt, paramString);
      AppMethodBeat.o(224795);
      return bool;
    }
    AppMethodBeat.o(224795);
    return false;
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(224679);
    if (a != null)
    {
      a.e(paramString);
      AppMethodBeat.o(224679);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224679);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224618);
    if (a != null)
    {
      a.b(paramString1, paramString2);
      AppMethodBeat.o(224618);
      return;
    }
    g(paramString1, paramString2);
    AppMethodBeat.o(224618);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224837);
    paramString1 = "[" + paramString1 + "]:" + paramString2 + paramThrowable;
    System.out.println(paramString1);
    AppMethodBeat.o(224837);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224719);
    if (a != null)
    {
      a.e(paramString, paramThrowable);
      AppMethodBeat.o(224719);
      return;
    }
    c(paramString, paramThrowable);
    AppMethodBeat.o(224719);
  }
  
  private static boolean b()
  {
    AppMethodBeat.i(224777);
    if (a != null)
    {
      boolean bool = a.a();
      AppMethodBeat.o(224777);
      return bool;
    }
    AppMethodBeat.o(224777);
    return false;
  }
  
  public static void c(String paramString)
  {
    AppMethodBeat.i(224713);
    if (a != null)
    {
      a.f(paramString);
      AppMethodBeat.o(224713);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224713);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224661);
    if (a != null)
    {
      a.c(paramString1, paramString2);
      AppMethodBeat.o(224661);
      return;
    }
    g(paramString1, paramString2);
    AppMethodBeat.o(224661);
  }
  
  private static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224591);
    if (a != null)
    {
      a.a(paramString1, paramString2, paramThrowable);
      AppMethodBeat.o(224591);
      return;
    }
    b(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(224591);
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224845);
    paramString = paramString + paramThrowable;
    System.out.println(paramString);
    AppMethodBeat.o(224845);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224696);
    if (a != null)
    {
      a.d(paramString1, paramString2);
      AppMethodBeat.o(224696);
      return;
    }
    g(paramString1, paramString2);
    AppMethodBeat.o(224696);
  }
  
  private static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224630);
    if (a != null)
    {
      a.b(paramString1, paramString2, paramThrowable);
      AppMethodBeat.o(224630);
      return;
    }
    b(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(224630);
  }
  
  private static void d(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224573);
    if (a != null)
    {
      a.a(paramString, paramThrowable);
      AppMethodBeat.o(224573);
      return;
    }
    c(paramString, paramThrowable);
    AppMethodBeat.o(224573);
  }
  
  public static boolean d(String paramString)
  {
    AppMethodBeat.i(224787);
    if (a != null)
    {
      boolean bool = a.a(paramString);
      AppMethodBeat.o(224787);
      return bool;
    }
    AppMethodBeat.o(224787);
    return false;
  }
  
  private static void e(String paramString)
  {
    AppMethodBeat.i(224563);
    if (a != null)
    {
      a.b(paramString);
      AppMethodBeat.o(224563);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224563);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224726);
    if (a != null)
    {
      a.e(paramString1, paramString2);
      AppMethodBeat.o(224726);
      return;
    }
    g(paramString1, paramString2);
    AppMethodBeat.o(224726);
  }
  
  private static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224668);
    if (a != null)
    {
      a.c(paramString1, paramString2, paramThrowable);
      AppMethodBeat.o(224668);
      return;
    }
    b(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(224668);
  }
  
  private static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224612);
    if (a != null)
    {
      a.b(paramString, paramThrowable);
      AppMethodBeat.o(224612);
      return;
    }
    c(paramString, paramThrowable);
    AppMethodBeat.o(224612);
  }
  
  private static void f(String paramString)
  {
    AppMethodBeat.i(224600);
    if (a != null)
    {
      a.c(paramString);
      AppMethodBeat.o(224600);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224600);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224757);
    if (a != null) {
      a.f(paramString1, paramString2);
    }
    AppMethodBeat.o(224757);
  }
  
  private static void f(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224704);
    if (a != null)
    {
      a.d(paramString1, paramString2, paramThrowable);
      AppMethodBeat.o(224704);
      return;
    }
    b(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(224704);
  }
  
  private static void f(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224651);
    if (a != null)
    {
      a.c(paramString, paramThrowable);
      AppMethodBeat.o(224651);
      return;
    }
    c(paramString, paramThrowable);
    AppMethodBeat.o(224651);
  }
  
  private static void g(String paramString)
  {
    AppMethodBeat.i(224746);
    if (a != null)
    {
      a.g(paramString);
      AppMethodBeat.o(224746);
      return;
    }
    System.out.println(paramString);
    AppMethodBeat.o(224746);
  }
  
  private static void g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224855);
    paramString1 = "[" + paramString1 + "]:" + paramString2;
    System.out.println(paramString1);
    AppMethodBeat.o(224855);
  }
  
  private static void h(String paramString)
  {
    AppMethodBeat.i(224828);
    System.out.println(paramString);
    AppMethodBeat.o(224828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kh
 * JD-Core Version:    0.7.0.1
 */