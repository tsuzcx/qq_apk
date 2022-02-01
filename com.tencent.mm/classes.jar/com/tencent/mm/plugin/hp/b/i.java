package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class i
{
  public static void a(String paramString1, final String paramString2, final String paramString3, final DialogInterface.OnClickListener paramOnClickListener1, final String paramString4, final DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(117443);
    if (bt.isNullOrNil(paramString2))
    {
      ad.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
      AppMethodBeat.o(117443);
      return;
    }
    ad.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117442);
        jf localjf = new jf();
        b localb = new b();
        localb.title = this.cPN;
        localb.bLg = paramString2;
        localb.Csf = new LinkedList();
        com.tencent.mm.protocal.b.a.a locala = new com.tencent.mm.protocal.b.a.a();
        locala.Csd = paramString3;
        localb.Csf.add(locala);
        locala = new com.tencent.mm.protocal.b.a.a();
        locala.Csd = paramString4;
        localb.Csf.add(locala);
        localjf.dnp.type = 1;
        localjf.dnp.dnq = localb;
        localjf.dnp.dnr = paramOnClickListener1;
        localjf.dnp.dns = paramOnClickListener2;
        com.tencent.mm.sdk.b.a.ESL.l(localjf);
        AppMethodBeat.o(117442);
      }
    });
    AppMethodBeat.o(117443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.i
 * JD-Core Version:    0.7.0.1
 */