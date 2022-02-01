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
  public Stack<com.tencent.mm.aa.b> fmC;
  public Stack<com.tencent.mm.aa.b> fmD;
  public int fmF;
  
  public final void Mj()
  {
    this.fmF += 1;
  }
  
  public final void Ut()
  {
    AppMethodBeat.i(9201);
    ad.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.fmC.size()) });
    this.fmC.clear();
    if (this.fmD != null)
    {
      ad.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fmD.size()) });
      this.fmC.addAll(this.fmD);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fmC.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.aa.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.fmC != null) && (this.fmC.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.aa.b)this.fmC.peek();; localObject = null)
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
      if (this.fmC != null)
      {
        i = this.fmC.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.fmD != null)
    {
      i = this.fmD.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    ad.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.fmC.size()) });
    if (this.fmD != null) {
      this.fmD.clear();
    }
    this.fmD = ((Stack)this.fmC.clone());
    if (paramBoolean) {
      this.fmC.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.fmC.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.aa.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.fmC = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    ad.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.fmC != null) {
      this.fmC.clear();
    }
    if (this.fmD != null) {
      this.fmD.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */