package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements d<com.tencent.mm.z.b>
{
  private Stack<com.tencent.mm.z.b> dkW;
  public Stack<com.tencent.mm.z.b> dkX;
  public int dkZ;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.dkW.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.z.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
    }
    if ((this.dkW != null) && (this.dkW.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.z.b)this.dkW.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.z.b)localObject).draw(paramCanvas);
      }
      return;
    }
  }
  
  public final void bf(boolean paramBoolean)
  {
    y.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
    if (this.dkX != null) {
      this.dkX.clear();
    }
    this.dkX = ((Stack)this.dkW.clone());
    if (paramBoolean) {
      this.dkW.clear();
    }
  }
  
  public final int bg(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      if (this.dkW != null) {
        i = this.dkW.size();
      }
    }
    while (this.dkX == null) {
      return i;
    }
    return this.dkX.size();
  }
  
  public final void c(Canvas paramCanvas)
  {
    Iterator localIterator = this.dkW.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.z.b)localIterator.next()).draw(paramCanvas);
    }
  }
  
  public final void onCreate()
  {
    this.dkW = new Stack();
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.dkW != null) {
      this.dkW.clear();
    }
    if (this.dkX != null) {
      this.dkX.clear();
    }
  }
  
  public final void tP()
  {
    this.dkZ += 1;
  }
  
  public final void wN()
  {
    y.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
    this.dkW.clear();
    if (this.dkX != null)
    {
      y.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.dkX.size()) });
      this.dkW.addAll(this.dkX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */