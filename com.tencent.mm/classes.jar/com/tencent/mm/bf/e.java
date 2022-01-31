package com.tencent.mm.bf;

import android.content.Context;
import com.tencent.mm.bg.d;
import com.tencent.mm.h.a.jw;
import com.tencent.mm.h.a.jw.b;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public final class e
{
  public static boolean RS()
  {
    jw localjw = new jw();
    localjw.bSp.action = 2;
    com.tencent.mm.sdk.b.a.udP.m(localjw);
    return localjw.bSq.bSr;
  }
  
  public static boolean RT()
  {
    return (d.eEX != null) && (d.eEX.RU());
  }
  
  public static c a(Context paramContext, int paramInt, Runnable paramRunnable)
  {
    paramContext = new c.a(paramContext);
    paramContext.Ip(a.h.app_tip);
    paramContext.Iq(paramInt);
    paramContext.Is(a.h.app_i_known).a(new e.1(paramRunnable));
    paramContext.nW(true);
    paramContext.e(new e.2(paramRunnable));
    paramContext = paramContext.aoP();
    paramContext.show();
    return paramContext;
  }
  
  public static boolean bi(Context paramContext)
  {
    return com.tencent.mm.r.a.bi(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bf.e
 * JD-Core Version:    0.7.0.1
 */