package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class i
{
  public static void a(String paramString1, final String paramString2, final String paramString3, final DialogInterface.OnClickListener paramOnClickListener1, final String paramString4, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(117443);
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
      AppMethodBeat.o(117443);
      return;
    }
    ac.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117442);
        jm localjm = new jm();
        b localb = new b();
        localb.title = this.cNi;
        localb.bIO = paramString2;
        localb.DKx = new LinkedList();
        com.tencent.mm.protocal.b.a.a locala = new com.tencent.mm.protocal.b.a.a();
        locala.DKv = paramString3;
        localb.DKx.add(locala);
        locala = new com.tencent.mm.protocal.b.a.a();
        locala.DKv = paramString4;
        localb.DKx.add(locala);
        localjm.dkX.type = 1;
        localjm.dkX.dkY = localb;
        localjm.dkX.dkZ = paramOnClickListener1;
        localjm.dkX.dla = paramOnClickListener2;
        com.tencent.mm.sdk.b.a.GpY.l(localjm);
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