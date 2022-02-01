package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.aa.a>
{
  public Stack<com.tencent.mm.aa.a> fIe;
  private Stack<com.tencent.mm.aa.a> fIf;
  public Matrix fIg;
  private int fIh;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.fIg = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void NQ()
  {
    this.fIh += 1;
  }
  
  public final void XF()
  {
    AppMethodBeat.i(9191);
    ad.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    this.fIe.clear();
    if (this.fIf != null)
    {
      ad.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fIf.size()) });
      this.fIe.addAll(this.fIf);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.aa.a XG()
  {
    AppMethodBeat.i(9192);
    if (this.fIe.size() <= 0)
    {
      ad.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.aa.a locala = (com.tencent.mm.aa.a)this.fIe.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.aa.a XH()
  {
    AppMethodBeat.i(9194);
    if ((this.fIe != null) && (this.fIe.size() > 0))
    {
      com.tencent.mm.aa.a locala = (com.tencent.mm.aa.a)this.fIe.peek();
      AppMethodBeat.o(9194);
      return locala;
    }
    AppMethodBeat.o(9194);
    return null;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.aa.a parama)
  {
    AppMethodBeat.i(9193);
    if (this.fIe != null) {
      this.fIe.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.fIe != null)
      {
        i = this.fIe.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.fIf != null)
    {
      i = this.fIf.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    ad.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    if (this.fIf != null) {
      this.fIf.clear();
    }
    this.fIf = ((Stack)this.fIe.clone());
    if (paramBoolean) {
      this.fIe.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void e(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    ad.i("MicroMsg.CropCache", "[onCreate]");
    this.fIe = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.fIe != null) {
      this.fIe.clear();
    }
    if (this.fIf != null) {
      this.fIf.clear();
    }
    this.fIg.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */