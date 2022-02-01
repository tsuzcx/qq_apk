package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.ab.a>
{
  private Stack<com.tencent.mm.ab.a> iTF;
  private Stack<com.tencent.mm.ab.a> iTG;
  public Matrix iTH;
  private int iTI;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.iTH = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.ab.a parama)
  {
    AppMethodBeat.i(9193);
    if (this.iTF != null) {
      this.iTF.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final void acG()
  {
    this.iTI += 1;
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.iTF != null)
      {
        i = this.iTF.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.iTG != null)
    {
      i = this.iTG.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void arB()
  {
    AppMethodBeat.i(9191);
    Log.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    this.iTF.clear();
    if (this.iTG != null)
    {
      Log.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.iTG.size()) });
      this.iTF.addAll(this.iTG);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.ab.a arC()
  {
    AppMethodBeat.i(9192);
    if (this.iTF.size() <= 0)
    {
      Log.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.ab.a locala = (com.tencent.mm.ab.a)this.iTF.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.ab.a arD()
  {
    AppMethodBeat.i(9194);
    if ((this.iTF != null) && (this.iTF.size() > 0))
    {
      com.tencent.mm.ab.a locala = (com.tencent.mm.ab.a)this.iTF.peek();
      AppMethodBeat.o(9194);
      return locala;
    }
    AppMethodBeat.o(9194);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(260249);
    if (this.iTF != null) {
      this.iTF.clear();
    }
    AppMethodBeat.o(260249);
  }
  
  public final void dL(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    Log.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    if (this.iTG != null) {
      this.iTG.clear();
    }
    this.iTG = ((Stack)this.iTF.clone());
    if (paramBoolean) {
      this.iTF.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void f(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    Log.i("MicroMsg.CropCache", "[onCreate]");
    this.iTF = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.iTF != null) {
      this.iTF.clear();
    }
    if (this.iTG != null) {
      this.iTG.clear();
    }
    this.iTH.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */