package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.z.a>
{
  public Stack<com.tencent.mm.z.a> fpX;
  private Stack<com.tencent.mm.z.a> fpY;
  public Matrix fpZ;
  private int fqa;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.fpZ = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void Mh()
  {
    this.fqa += 1;
  }
  
  public final void Vo()
  {
    AppMethodBeat.i(9191);
    ac.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    this.fpX.clear();
    if (this.fpY != null)
    {
      ac.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fpY.size()) });
      this.fpX.addAll(this.fpY);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.z.a Vp()
  {
    AppMethodBeat.i(9192);
    if (this.fpX.size() <= 0)
    {
      ac.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.fpX.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.z.a Vq()
  {
    AppMethodBeat.i(9194);
    if ((this.fpX != null) && (this.fpX.size() > 0))
    {
      com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.fpX.peek();
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
    if (this.fpX != null) {
      this.fpX.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.fpX != null)
      {
        i = this.fpX.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.fpY != null)
    {
      i = this.fpY.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    ac.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    if (this.fpY != null) {
      this.fpY.clear();
    }
    this.fpY = ((Stack)this.fpX.clone());
    if (paramBoolean) {
      this.fpX.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void e(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    ac.i("MicroMsg.CropCache", "[onCreate]");
    this.fpX = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.fpX != null) {
      this.fpX.clear();
    }
    if (this.fpY != null) {
      this.fpY.clear();
    }
    this.fpZ.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */