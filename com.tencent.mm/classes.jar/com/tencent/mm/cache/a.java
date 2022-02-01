package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.ab.a>
{
  private Stack<com.tencent.mm.ab.a> lvL;
  private Stack<com.tencent.mm.ab.a> lvM;
  public Matrix lvN;
  private int lvO;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.lvN = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void a(com.tencent.mm.ab.a parama)
  {
    AppMethodBeat.i(9193);
    if (this.lvL != null) {
      this.lvL.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final void aEG()
  {
    this.lvO += 1;
  }
  
  public final void aLx()
  {
    AppMethodBeat.i(9191);
    Log.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    this.lvL.clear();
    if (this.lvM != null)
    {
      Log.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.lvM.size()) });
      this.lvL.addAll(this.lvM);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.ab.a aLy()
  {
    AppMethodBeat.i(9192);
    if (this.lvL.size() <= 0)
    {
      Log.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.ab.a locala = (com.tencent.mm.ab.a)this.lvL.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.ab.a aLz()
  {
    AppMethodBeat.i(9194);
    if ((this.lvL != null) && (this.lvL.size() > 0))
    {
      com.tencent.mm.ab.a locala = (com.tencent.mm.ab.a)this.lvL.peek();
      AppMethodBeat.o(9194);
      return locala;
    }
    AppMethodBeat.o(9194);
    return null;
  }
  
  public final int aR(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.lvL != null)
      {
        i = this.lvL.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.lvM != null)
    {
      i = this.lvM.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void clear()
  {
    AppMethodBeat.i(232045);
    if (this.lvL != null) {
      this.lvL.clear();
    }
    AppMethodBeat.o(232045);
  }
  
  public final void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    Log.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    if (this.lvM != null) {
      this.lvM.clear();
    }
    this.lvM = ((Stack)this.lvL.clone());
    if (paramBoolean) {
      this.lvL.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void i(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    Log.i("MicroMsg.CropCache", "[onCreate]");
    this.lvL = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.lvL != null) {
      this.lvL.clear();
    }
    if (this.lvM != null) {
      this.lvM.clear();
    }
    this.lvN.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */