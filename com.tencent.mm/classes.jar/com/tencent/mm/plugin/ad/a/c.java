package com.tencent.mm.plugin.ad.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;

public final class c
{
  private static final a GLe;
  private static final b GLf;
  
  static
  {
    AppMethodBeat.i(246784);
    GLe = new a()
    {
      public final void fnb()
      {
        AppMethodBeat.i(246786);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader savePayTestEnvIDs");
        AppMethodBeat.o(246786);
      }
      
      public final void hL(Context paramAnonymousContext)
      {
        AppMethodBeat.i(246788);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader showPayTestEnvIDsUI");
        w.makeText(paramAnonymousContext, "不支持此功能， 需要支付测试包编译参数。", 1).show();
        AppMethodBeat.o(246788);
      }
      
      public final void vR(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(246787);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader setPayTestEnvID2RR, isKinda: ".concat(String.valueOf(paramAnonymousBoolean)));
        AppMethodBeat.o(246787);
      }
    };
    GLf = new b() {};
    AppMethodBeat.o(246784);
  }
  
  public static a fnc()
  {
    AppMethodBeat.i(246781);
    a locala = (a)com.tencent.mm.kernel.h.ae(a.class);
    if (locala != null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1490L, 0L, 1L, false);
      AppMethodBeat.o(246781);
      return locala;
    }
    locala = GLe;
    AppMethodBeat.o(246781);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.c
 * JD-Core Version:    0.7.0.1
 */