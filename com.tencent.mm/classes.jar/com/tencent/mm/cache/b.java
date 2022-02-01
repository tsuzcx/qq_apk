package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements f<com.tencent.mm.z.b>
{
  public Stack<com.tencent.mm.z.b> fKi;
  public Stack<com.tencent.mm.z.b> fKj;
  public int fKl;
  
  public final void NO()
  {
    this.fKl += 1;
  }
  
  public final void XP()
  {
    AppMethodBeat.i(9201);
    ae.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    this.fKi.clear();
    if (this.fKj != null)
    {
      ae.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fKj.size()) });
      this.fKi.addAll(this.fKj);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fKi.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.z.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.fKi != null) && (this.fKi.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.z.b)this.fKi.peek();; localObject = null)
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
      if (this.fKi != null)
      {
        i = this.fKi.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.fKj != null)
    {
      i = this.fKj.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    ae.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fKi.size()) });
    if (this.fKj != null) {
      this.fKj.clear();
    }
    this.fKj = ((Stack)this.fKi.clone());
    if (paramBoolean) {
      this.fKi.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.fKi.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.z.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.fKi = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    ae.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.fKi != null) {
      this.fKi.clear();
    }
    if (this.fKj != null) {
      this.fKj.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */