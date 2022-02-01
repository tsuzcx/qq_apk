package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements f<com.tencent.mm.z.b>
{
  public Stack<com.tencent.mm.z.b> fpX;
  public Stack<com.tencent.mm.z.b> fpY;
  public int fqa;
  
  public final void Mh()
  {
    this.fqa += 1;
  }
  
  public final void Vo()
  {
    AppMethodBeat.i(9201);
    ac.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    this.fpX.clear();
    if (this.fpY != null)
    {
      ac.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fpY.size()) });
      this.fpX.addAll(this.fpY);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fpX.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.z.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.fpX != null) && (this.fpX.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.z.b)this.fpX.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.z.b)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9204);
    int i;
    if (paramBoolean)
    {
      if (this.fpX != null)
      {
        i = this.fpX.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.fpY != null)
    {
      i = this.fpY.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    ac.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fpX.size()) });
    if (this.fpY != null) {
      this.fpY.clear();
    }
    this.fpY = ((Stack)this.fpX.clone());
    if (paramBoolean) {
      this.fpX.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.fpX.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.z.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.fpX = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    ac.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.fpX != null) {
      this.fpX.clear();
    }
    if (this.fpY != null) {
      this.fpY.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */