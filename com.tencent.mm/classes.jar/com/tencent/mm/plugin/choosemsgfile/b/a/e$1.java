package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements b.b
{
  e$1(e parame) {}
  
  public final void q(int paramInt, String paramString)
  {
    AppMethodBeat.i(54264);
    ab.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      paramString = ((b)g.E(b.class)).q(e.a(this.kEB), e.b(this.kEB));
      ((b)g.E(b.class)).a(paramString);
      e.a(this.kEB, ((b)g.E(b.class)).a(e.b(this.kEB), e.a(this.kEB), new e.1.1(this, paramString)));
      AppMethodBeat.o(54264);
      return;
    }
    ab.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { this.kEB.kEs });
    this.kEB.bgi();
    AppMethodBeat.o(54264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e.1
 * JD-Core Version:    0.7.0.1
 */