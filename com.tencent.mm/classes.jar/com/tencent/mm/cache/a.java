package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.aa.a>
{
  public Stack<com.tencent.mm.aa.a> fmC;
  private Stack<com.tencent.mm.aa.a> fmD;
  public Matrix fmE;
  private int fmF;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.fmE = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void Mj()
  {
    this.fmF += 1;
  }
  
  public final void Ut()
  {
    AppMethodBeat.i(9191);
    ad.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fmC.size()) });
    this.fmC.clear();
    if (this.fmD != null)
    {
      ad.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fmD.size()) });
      this.fmC.addAll(this.fmD);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.aa.a Uu()
  {
    AppMethodBeat.i(9192);
    if (this.fmC.size() <= 0)
    {
      ad.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.aa.a locala = (com.tencent.mm.aa.a)this.fmC.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.aa.a Uv()
  {
    AppMethodBeat.i(9194);
    if ((this.fmC != null) && (this.fmC.size() > 0))
    {
      com.tencent.mm.aa.a locala = (com.tencent.mm.aa.a)this.fmC.peek();
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
    if (this.fmC != null) {
      this.fmC.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.fmC != null)
      {
        i = this.fmC.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.fmD != null)
    {
      i = this.fmD.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    ad.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fmC.size()) });
    if (this.fmD != null) {
      this.fmD.clear();
    }
    this.fmD = ((Stack)this.fmC.clone());
    if (paramBoolean) {
      this.fmC.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void e(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    ad.i("MicroMsg.CropCache", "[onCreate]");
    this.fmC = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.fmC != null) {
      this.fmC.clear();
    }
    if (this.fmD != null) {
      this.fmD.clear();
    }
    this.fmE.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */