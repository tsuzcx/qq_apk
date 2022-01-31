package com.tencent.mm.be;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;

final class e$3
  implements f
{
  e$3(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (e.c(this.eBw) == null) {}
    do
    {
      return;
      y.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a)paramm).filename + " filepath " + e.c(this.eBw) + " errCode " + paramInt2);
    } while (!((a)paramm).filename.equals(e.c(this.eBw)));
    g.Dk().b(240, e.d(this.eBw));
    if (paramInt2 == 0)
    {
      d.Rc();
      d.Re();
    }
    paramString = new b(e.c(this.eBw));
    try
    {
      boolean bool = paramString.delete();
      y.d("MicroMsg.SpeexUploadCore", "delete " + e.c(this.eBw) + " delete " + bool + " errCode " + paramInt2);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[] { bk.j(paramString) });
      return;
    }
    finally
    {
      e.Rk().start();
      e.e(this.eBw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.e.3
 * JD-Core Version:    0.7.0.1
 */