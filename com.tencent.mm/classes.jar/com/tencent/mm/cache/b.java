package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements f<com.tencent.mm.ab.b>
{
  public Stack<com.tencent.mm.ab.b> iTF;
  public Stack<com.tencent.mm.ab.b> iTG;
  public int iTI;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.iTF.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.ab.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.iTF != null) && (this.iTF.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.ab.b)this.iTF.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.ab.b)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
  }
  
  public final void acG()
  {
    this.iTI += 1;
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9204);
    int i;
    if (paramBoolean)
    {
      if (this.iTF != null)
      {
        i = this.iTF.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.iTG != null)
    {
      i = this.iTG.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void arB()
  {
    AppMethodBeat.i(9201);
    Log.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    this.iTF.clear();
    if (this.iTG != null)
    {
      Log.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.iTG.size()) });
      this.iTF.addAll(this.iTG);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(259909);
    if (this.iTF != null) {
      this.iTF.clear();
    }
    AppMethodBeat.o(259909);
  }
  
  public final void dL(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    Log.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.iTF.size()) });
    if (this.iTG != null) {
      this.iTG.clear();
    }
    this.iTG = ((Stack)this.iTF.clone());
    if (paramBoolean) {
      this.iTF.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.iTF.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ab.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.iTF = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    Log.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.iTF != null) {
      this.iTF.clear();
    }
    if (this.iTG != null) {
      this.iTG.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */