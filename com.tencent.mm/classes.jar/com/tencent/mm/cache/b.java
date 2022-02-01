package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements f<com.tencent.mm.aa.b>
{
  public Stack<com.tencent.mm.aa.b> fIe;
  public Stack<com.tencent.mm.aa.b> fIf;
  public int fIh;
  
  public final void NQ()
  {
    this.fIh += 1;
  }
  
  public final void XF()
  {
    AppMethodBeat.i(9201);
    ad.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    this.fIe.clear();
    if (this.fIf != null)
    {
      ad.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fIf.size()) });
      this.fIe.addAll(this.fIf);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fIe.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.aa.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.fIe != null) && (this.fIe.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.aa.b)this.fIe.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.aa.b)localObject).draw(paramCanvas);
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
      if (this.fIe != null)
      {
        i = this.fIe.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.fIf != null)
    {
      i = this.fIf.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    ad.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fIe.size()) });
    if (this.fIf != null) {
      this.fIf.clear();
    }
    this.fIf = ((Stack)this.fIe.clone());
    if (paramBoolean) {
      this.fIe.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.fIe.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.aa.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.fIe = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    ad.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.fIe != null) {
      this.fIe.clear();
    }
    if (this.fIf != null) {
      this.fIf.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */