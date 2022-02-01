package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.z.a>
{
  public Stack<com.tencent.mm.z.a> fKi;
  private Stack<com.tencent.mm.z.a> fKj;
  public Matrix fKk;
  private int fKl;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.fKk = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void NO()
  {
    this.fKl += 1;
  }
  
  public final void XP()
  {
    AppMethodBeat.i(9191);
    ae.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    this.fKi.clear();
    if (this.fKj != null)
    {
      ae.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fKj.size()) });
      this.fKi.addAll(this.fKj);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.z.a XQ()
  {
    AppMethodBeat.i(9192);
    if (this.fKi.size() <= 0)
    {
      ae.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.fKi.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.z.a XR()
  {
    AppMethodBeat.i(9194);
    if ((this.fKi != null) && (this.fKi.size() > 0))
    {
      com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.fKi.peek();
      AppMethodBeat.o(9194);
      return locala;
    }
    AppMethodBeat.o(9194);
    return null;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.z.a parama)
  {
    AppMethodBeat.i(9193);
    if (this.fKi != null) {
      this.fKi.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.fKi != null)
      {
        i = this.fKi.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.fKj != null)
    {
      i = this.fKj.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    ae.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    if (this.fKj != null) {
      this.fKj.clear();
    }
    this.fKj = ((Stack)this.fKi.clone());
    if (paramBoolean) {
      this.fKi.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void e(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    ae.i("MicroMsg.CropCache", "[onCreate]");
    this.fKi = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.fKi != null) {
      this.fKi.clear();
    }
    if (this.fKj != null) {
      this.fKj.clear();
    }
    this.fKk.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */