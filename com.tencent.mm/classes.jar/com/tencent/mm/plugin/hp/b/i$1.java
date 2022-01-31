package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.protocal.b.a.b;
import java.util.LinkedList;

final class i$1
  implements Runnable
{
  i$1(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public final void run()
  {
    AppMethodBeat.i(90614);
    ik localik = new ik();
    b localb = new b();
    localb.title = this.cbK;
    localb.bjm = this.nKq;
    localb.wjT = new LinkedList();
    com.tencent.mm.protocal.b.a.a locala = new com.tencent.mm.protocal.b.a.a();
    locala.wjR = this.nKr;
    localb.wjT.add(locala);
    locala = new com.tencent.mm.protocal.b.a.a();
    locala.wjR = this.nKs;
    localb.wjT.add(locala);
    localik.cxM.type = 1;
    localik.cxM.cxN = localb;
    localik.cxM.cxO = this.nKt;
    localik.cxM.cxP = this.nKu;
    com.tencent.mm.sdk.b.a.ymk.l(localik);
    AppMethodBeat.o(90614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.i.1
 * JD-Core Version:    0.7.0.1
 */