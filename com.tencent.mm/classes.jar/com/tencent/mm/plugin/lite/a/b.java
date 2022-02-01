package com.tencent.mm.plugin.lite.a;

import android.content.Intent;
import com.tencent.liteapp.jsapi.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  private static HashMap<Integer, a> JZA;
  private static int JZB;
  private static HashMap<Integer, a> JZC;
  private static int JZD;
  private static HashMap<Integer, a> JZE;
  private static int JZF;
  private static HashMap<Integer, a> JZG;
  private static int JZH;
  private static HashMap<Integer, a> JZI;
  private static int JZt;
  private static HashMap<Integer, a> JZu;
  private static int JZv;
  private static HashMap<Integer, a> JZw;
  private static int JZx;
  private static HashMap<Integer, a> JZy;
  private static int JZz;
  
  static
  {
    AppMethodBeat.i(271568);
    JZt = 0;
    JZu = new HashMap();
    JZv = 0;
    JZw = new HashMap();
    JZx = 0;
    JZy = new HashMap();
    JZz = 0;
    JZA = new HashMap();
    JZB = 0;
    JZC = new HashMap();
    JZD = 0;
    JZE = new HashMap();
    JZF = 0;
    JZG = new HashMap();
    JZH = 0;
    JZI = new HashMap();
    AppMethodBeat.o(271568);
  }
  
  public static int a(a parama)
  {
    AppMethodBeat.i(271477);
    JZt += 1;
    JZu.put(Integer.valueOf(JZt), parama);
    int i = JZt;
    AppMethodBeat.o(271477);
    return i;
  }
  
  public static void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(271515);
    a locala = (a)JZA.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271515);
      return;
    }
    locala.cY(paramInt2, paramInt3);
    JZA.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271515);
  }
  
  public static int b(a parama)
  {
    AppMethodBeat.i(271489);
    JZv += 1;
    JZw.put(Integer.valueOf(JZv), parama);
    int i = JZv;
    AppMethodBeat.o(271489);
    return i;
  }
  
  public static void b(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(271483);
    a locala = (a)JZu.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271483);
      return;
    }
    locala.c(paramInt2, paramInt3, paramIntent);
    JZu.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271483);
  }
  
  public static void bh(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(271530);
    a locala = (a)JZC.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(271530);
      return;
    }
    locala.cE(paramBoolean);
    JZC.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(271530);
  }
  
  public static void bi(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(271537);
    a locala = (a)JZE.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      AppMethodBeat.o(271537);
      return;
    }
    locala.cF(paramBoolean);
    JZE.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(271537);
  }
  
  public static int c(a parama)
  {
    AppMethodBeat.i(271500);
    JZx += 1;
    JZy.put(Integer.valueOf(JZx), parama);
    int i = JZx;
    AppMethodBeat.o(271500);
    return i;
  }
  
  public static void c(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(271497);
    a locala = (a)JZw.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271497);
      return;
    }
    locala.d(paramInt2, paramInt3, paramIntent);
    JZw.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271497);
  }
  
  public static int d(a parama)
  {
    AppMethodBeat.i(271509);
    JZz += 1;
    JZA.put(Integer.valueOf(JZz), parama);
    int i = JZz;
    AppMethodBeat.o(271509);
    return i;
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(271551);
    a locala = (a)JZG.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271551);
      return;
    }
    locala.e(paramInt2, paramInt3, paramIntent);
    JZG.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271551);
  }
  
  public static int e(a parama)
  {
    AppMethodBeat.i(271523);
    JZB += 1;
    JZC.put(Integer.valueOf(JZB), parama);
    int i = JZB;
    AppMethodBeat.o(271523);
    return i;
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(271558);
    a locala = (a)JZI.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271558);
      return;
    }
    locala.f(paramInt2, paramInt3, paramIntent);
    JZI.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271558);
  }
  
  public static int f(a parama)
  {
    AppMethodBeat.i(271532);
    JZD += 1;
    JZE.put(Integer.valueOf(JZD), parama);
    int i = JZD;
    AppMethodBeat.o(271532);
    return i;
  }
  
  public static int g(a parama)
  {
    AppMethodBeat.i(271546);
    JZF += 1;
    JZG.put(Integer.valueOf(JZF), parama);
    int i = JZF;
    AppMethodBeat.o(271546);
    return i;
  }
  
  public static int h(a parama)
  {
    AppMethodBeat.i(271553);
    JZH += 1;
    JZI.put(Integer.valueOf(JZH), parama);
    int i = JZH;
    AppMethodBeat.o(271553);
    return i;
  }
  
  public static void jz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271505);
    a locala = (a)JZy.get(Integer.valueOf(paramInt1));
    if (locala == null)
    {
      AppMethodBeat.o(271505);
      return;
    }
    locala.mi(paramInt2);
    JZy.remove(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b
 * JD-Core Version:    0.7.0.1
 */