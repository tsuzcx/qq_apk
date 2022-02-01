package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;

public final class a
  implements f<com.tencent.mm.z.a>
{
  private int gpA;
  private Stack<com.tencent.mm.z.a> gpx;
  private Stack<com.tencent.mm.z.a> gpy;
  public Matrix gpz;
  
  public a()
  {
    AppMethodBeat.i(9187);
    this.gpz = new Matrix();
    AppMethodBeat.o(9187);
  }
  
  public final void Ya()
  {
    this.gpA += 1;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.z.a parama)
  {
    AppMethodBeat.i(9193);
    if (this.gpx != null) {
      this.gpx.push(parama);
    }
    AppMethodBeat.o(9193);
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9195);
    int i;
    if (paramBoolean)
    {
      if (this.gpx != null)
      {
        i = this.gpx.size();
        AppMethodBeat.o(9195);
        return i;
      }
      AppMethodBeat.o(9195);
      return 0;
    }
    if (this.gpy != null)
    {
      i = this.gpy.size();
      AppMethodBeat.o(9195);
      return i;
    }
    AppMethodBeat.o(9195);
    return 0;
  }
  
  public final void alC()
  {
    AppMethodBeat.i(9191);
    Log.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    this.gpx.clear();
    if (this.gpy != null)
    {
      Log.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.gpy.size()) });
      this.gpx.addAll(this.gpy);
    }
    AppMethodBeat.o(9191);
  }
  
  public final com.tencent.mm.z.a alD()
  {
    AppMethodBeat.i(9192);
    if (this.gpx.size() <= 0)
    {
      Log.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(9192);
      return null;
    }
    com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.gpx.pop();
    AppMethodBeat.o(9192);
    return locala;
  }
  
  public final com.tencent.mm.z.a alE()
  {
    AppMethodBeat.i(9194);
    if ((this.gpx != null) && (this.gpx.size() > 0))
    {
      com.tencent.mm.z.a locala = (com.tencent.mm.z.a)this.gpx.peek();
      AppMethodBeat.o(9194);
      return locala;
    }
    AppMethodBeat.o(9194);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(204747);
    if (this.gpx != null) {
      this.gpx.clear();
    }
    AppMethodBeat.o(204747);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(9190);
    Log.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    if (this.gpy != null) {
      this.gpy.clear();
    }
    this.gpy = ((Stack)this.gpx.clone());
    if (paramBoolean) {
      this.gpx.clear();
    }
    AppMethodBeat.o(9190);
  }
  
  public final void e(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(9188);
    Log.i("MicroMsg.CropCache", "[onCreate]");
    this.gpx = new Stack();
    AppMethodBeat.o(9188);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9189);
    if (this.gpx != null) {
      this.gpx.clear();
    }
    if (this.gpy != null) {
      this.gpy.clear();
    }
    this.gpz.reset();
    AppMethodBeat.o(9189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */