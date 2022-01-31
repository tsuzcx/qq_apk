package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements e<com.tencent.mm.y.b>
{
  public Stack<com.tencent.mm.y.b> ecq;
  public Stack<com.tencent.mm.y.b> ecr;
  public int ect;
  
  public final void CH()
  {
    this.ect += 1;
  }
  
  public final void Jd()
  {
    AppMethodBeat.i(116229);
    ab.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    this.ecq.clear();
    if (this.ecr != null)
    {
      ab.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ecr.size()) });
      this.ecq.addAll(this.ecr);
    }
    AppMethodBeat.o(116229);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(116230);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.ecq.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.y.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(116230);
      return;
    }
    if ((this.ecq != null) && (this.ecq.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.y.b)this.ecq.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.y.b)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(116230);
      return;
    }
  }
  
  public final int ad(boolean paramBoolean)
  {
    AppMethodBeat.i(116232);
    int i;
    if (paramBoolean)
    {
      if (this.ecq != null)
      {
        i = this.ecq.size();
        AppMethodBeat.o(116232);
        return i;
      }
      AppMethodBeat.o(116232);
      return 0;
    }
    if (this.ecr != null)
    {
      i = this.ecr.size();
      AppMethodBeat.o(116232);
      return i;
    }
    AppMethodBeat.o(116232);
    return 0;
  }
  
  public final void bH(boolean paramBoolean)
  {
    AppMethodBeat.i(116228);
    ab.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.ecq.size()) });
    if (this.ecr != null) {
      this.ecr.clear();
    }
    this.ecr = ((Stack)this.ecq.clone());
    if (paramBoolean) {
      this.ecq.clear();
    }
    AppMethodBeat.o(116228);
  }
  
  public final void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(116231);
    Iterator localIterator = this.ecq.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.y.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(116231);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(116226);
    this.ecq = new Stack();
    AppMethodBeat.o(116226);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116227);
    ab.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.ecq != null) {
      this.ecq.clear();
    }
    if (this.ecr != null) {
      this.ecr.clear();
    }
    AppMethodBeat.o(116227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */