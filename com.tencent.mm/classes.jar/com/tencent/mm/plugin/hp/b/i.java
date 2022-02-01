package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class i
{
  public static void a(String paramString1, final String paramString2, final String paramString3, final DialogInterface.OnClickListener paramOnClickListener1, final String paramString4, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(117443);
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
      AppMethodBeat.o(117443);
      return;
    }
    ae.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117442);
        jv localjv = new jv();
        b localb = new b();
        localb.title = this.cZw;
        localb.msg = paramString2;
        localb.FIc = new LinkedList();
        com.tencent.mm.protocal.b.a.a locala = new com.tencent.mm.protocal.b.a.a();
        locala.FIa = paramString3;
        localb.FIc.add(locala);
        locala = new com.tencent.mm.protocal.b.a.a();
        locala.FIa = paramString4;
        localb.FIc.add(locala);
        localjv.dxP.type = 1;
        localjv.dxP.dxQ = localb;
        localjv.dxP.dxR = paramOnClickListener1;
        localjv.dxP.dxS = paramOnClickListener2;
        com.tencent.mm.sdk.b.a.IvT.l(localjv);
        AppMethodBeat.o(117442);
      }
    });
    AppMethodBeat.o(117443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.i
 * JD-Core Version:    0.7.0.1
 */