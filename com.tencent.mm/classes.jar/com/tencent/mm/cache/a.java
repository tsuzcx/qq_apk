package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Stack;

public final class a
  implements e<com.tencent.mm.y.a>
{
  public Stack<com.tencent.mm.y.a> ecq;
  private Stack<com.tencent.mm.y.a> ecr;
  public Matrix ecs;
  private int ect;
  
  public a()
  {
    AppMethodBeat.i(116215);
    this.ecs = new Matrix();
    AppMethodBeat.o(116215);
  }
  
  public final void CH()
  {
    this.ect += 1;
  }
  
  public final void Jd()
  {
    AppMethodBeat.i(116219);
    ab.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    this.ecq.clear();
    if (this.ecr != null)
    {
      ab.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ecr.size()) });
      this.ecq.addAll(this.ecr);
    }
    AppMethodBeat.o(116219);
  }
  
  public final com.tencent.mm.y.a Je()
  {
    AppMethodBeat.i(116220);
    if (this.ecq.size() <= 0)
    {
      ab.e("MicroMsg.CropCache", "[pop]");
      AppMethodBeat.o(116220);
      return null;
    }
    com.tencent.mm.y.a locala = (com.tencent.mm.y.a)this.ecq.pop();
    AppMethodBeat.o(116220);
    return locala;
  }
  
  public final com.tencent.mm.y.a Jf()
  {
    AppMethodBeat.i(116222);
    if ((this.ecq != null) && (this.ecq.size() > 0))
    {
      com.tencent.mm.y.a locala = (com.tencent.mm.y.a)this.ecq.peek();
      AppMethodBeat.o(116222);
      return locala;
    }
    AppMethodBeat.o(116222);
    return null;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.y.a parama)
  {
    AppMethodBeat.i(116221);
    if (this.ecq != null) {
      this.ecq.push(parama);
    }
    AppMethodBeat.o(116221);
  }
  
  public final int ad(boolean paramBoolean)
  {
    AppMethodBeat.i(116223);
    int i;
    if (paramBoolean)
    {
      if (this.ecq != null)
      {
        i = this.ecq.size();
        AppMethodBeat.o(116223);
        return i;
      }
      AppMethodBeat.o(116223);
      return 0;
    }
    if (this.ecr != null)
    {
      i = this.ecr.size();
      AppMethodBeat.o(116223);
      return i;
    }
    AppMethodBeat.o(116223);
    return 0;
  }
  
  public final void bH(boolean paramBoolean)
  {
    AppMethodBeat.i(116218);
    ab.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    if (this.ecr != null) {
      this.ecr.clear();
    }
    this.ecr = ((Stack)this.ecq.clone());
    if (paramBoolean) {
      this.ecq.clear();
    }
    AppMethodBeat.o(116218);
  }
  
  public final void c(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(116216);
    ab.i("MicroMsg.CropCache", "[onCreate]");
    this.ecq = new Stack();
    AppMethodBeat.o(116216);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116217);
    if (this.ecq != null) {
      this.ecq.clear();
    }
    if (this.ecr != null) {
      this.ecr.clear();
    }
    this.ecs.reset();
    AppMethodBeat.o(116217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */