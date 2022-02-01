package com.tencent.mm.plugin.ae.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;

public final class c
{
  private static final a MHX;
  private static final b MHY;
  
  static
  {
    AppMethodBeat.i(264836);
    MHX = new a()
    {
      public final void An(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(264829);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader setPayTestEnvID2RR, isKinda: ".concat(String.valueOf(paramAnonymousBoolean)));
        AppMethodBeat.o(264829);
      }
      
      public final void gxO()
      {
        AppMethodBeat.i(264818);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader savePayTestEnvIDs");
        AppMethodBeat.o(264818);
      }
      
      public final void jm(Context paramAnonymousContext)
      {
        AppMethodBeat.i(264838);
        Log.d("MicroMsg.PayTestHelper", "sDummyNetPayTestHeader showPayTestEnvIDsUI");
        aa.makeText(paramAnonymousContext, "不支持此功能， 需要支付测试包编译参数。", 1).show();
        AppMethodBeat.o(264838);
      }
    };
    MHY = new b() {};
    AppMethodBeat.o(264836);
  }
  
  public static a gxP()
  {
    AppMethodBeat.i(264826);
    a locala = (a)com.tencent.mm.kernel.h.ax(a.class);
    if (locala != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1490L, 0L, 1L, false);
      AppMethodBeat.o(264826);
      return locala;
    }
    locala = MHX;
    AppMethodBeat.o(264826);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ae.a.c
 * JD-Core Version:    0.7.0.1
 */