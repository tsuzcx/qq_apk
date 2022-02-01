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
  public Stack<com.tencent.mm.ab.b> lvL;
  public Stack<com.tencent.mm.ab.b> lvM;
  public int lvO;
  
  public final void aEG()
  {
    this.lvO += 1;
  }
  
  public final void aLx()
  {
    AppMethodBeat.i(9201);
    Log.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    this.lvL.clear();
    if (this.lvM != null)
    {
      Log.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.lvM.size()) });
      this.lvL.addAll(this.lvM);
    }
    AppMethodBeat.o(9201);
  }
  
  public final int aR(boolean paramBoolean)
  {
    AppMethodBeat.i(9204);
    int i;
    if (paramBoolean)
    {
      if (this.lvL != null)
      {
        i = this.lvL.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.lvM != null)
    {
      i = this.lvM.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.lvL.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.ab.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.lvL != null) && (this.lvL.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.ab.b)this.lvL.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.ab.b)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(232057);
    if (this.lvL != null) {
      this.lvL.clear();
    }
    AppMethodBeat.o(232057);
  }
  
  public final void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    Log.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.lvL.size()) });
    if (this.lvM != null) {
      this.lvM.clear();
    }
    this.lvM = ((Stack)this.lvL.clone());
    if (paramBoolean) {
      this.lvL.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.lvL.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.ab.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.lvL = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    Log.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.lvL != null) {
      this.lvL.clear();
    }
    if (this.lvM != null) {
      this.lvM.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */