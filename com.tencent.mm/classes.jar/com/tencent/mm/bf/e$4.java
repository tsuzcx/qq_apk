package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;

final class e$4
  implements f
{
  e$4(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(145808);
    if (e.c(this.fRn) == null)
    {
      AppMethodBeat.o(145808);
      return;
    }
    ab.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramm).filename + " filepath " + e.c(this.fRn) + " errCode " + paramInt2);
    if (((a)paramm).filename.equals(e.c(this.fRn)))
    {
      g.Rc().b(240, e.d(this.fRn));
      if (paramInt2 == 0)
      {
        d.akj();
        d.akl();
      }
      paramString = new b(e.c(this.fRn));
      try
      {
        boolean bool = paramString.delete();
        ab.d("MicroMsg.SpeexUploadCore", "delete " + e.c(this.fRn) + " delete " + bool + " errCode " + paramInt2);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bo.l(paramString) });
        return;
      }
      finally
      {
        e.aks().start();
        e.e(this.fRn);
        AppMethodBeat.o(145808);
      }
    }
    AppMethodBeat.o(145808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bf.e.4
 * JD-Core Version:    0.7.0.1
 */