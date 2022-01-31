package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.z.e;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c
  implements d<com.tencent.mm.z.c>
{
  public Stack<com.tencent.mm.z.c> dkW;
  public Stack<com.tencent.mm.z.c> dkX;
  private int dkZ;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.dkW.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.z.c localc = (com.tencent.mm.z.c)((Iterator)localObject).next();
        if (!localc.dpc) {
          localc.draw(paramCanvas);
        }
      }
    }
    Object localObject = wR();
    if ((localObject != null) && (!((com.tencent.mm.z.c)localObject).dpc)) {
      ((com.tencent.mm.z.c)localObject).draw(paramCanvas);
    }
  }
  
  public final void a(com.tencent.mm.z.c paramc)
  {
    if (this.dkW != null) {
      this.dkW.push(paramc);
    }
  }
  
  public final void b(com.tencent.mm.z.c paramc)
  {
    if (paramc == null) {
      return;
    }
    int i = this.dkW.indexOf(paramc);
    this.dkW.remove(i);
    this.dkW.push(paramc);
  }
  
  public final void bf(boolean paramBoolean)
  {
    y.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.dkW.size()), Boolean.valueOf(paramBoolean) });
    if (this.dkX != null) {
      this.dkX.clear();
    }
    this.dkX = new Stack();
    Iterator localIterator = this.dkW.iterator();
    com.tencent.mm.z.c localc;
    while (localIterator.hasNext())
    {
      localc = (com.tencent.mm.z.c)localIterator.next();
      this.dkX.push(localc.Cn());
    }
    y.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.dkX.size()) });
    if (paramBoolean)
    {
      this.dkW.clear();
      localIterator = this.dkX.iterator();
      while (localIterator.hasNext())
      {
        localc = (com.tencent.mm.z.c)localIterator.next();
        y.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.dHM != null) && (!localc.dHM.isRecycled())) {
          localc.dHM.recycle();
        }
      }
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
    while (localIterator.hasNext())
    {
      com.tencent.mm.z.c localc = (com.tencent.mm.z.c)localIterator.next();
      localc.setSelected(false);
      localc.draw(paramCanvas);
    }
  }
  
  public final void onCreate()
  {
    y.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.dkW = new Stack();
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.dkW != null)
    {
      localIterator = this.dkW.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.z.c)localIterator.next()).clear();
      }
      this.dkW.clear();
    }
    if (this.dkX != null)
    {
      localIterator = this.dkX.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.z.c)localIterator.next()).clear();
      }
      this.dkX.clear();
    }
  }
  
  public final void tP()
  {
    this.dkZ += 1;
  }
  
  public final void wN()
  {
    y.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.dkW.size()), Boolean.valueOf(false) });
    this.dkW.clear();
    if (this.dkX != null)
    {
      y.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.dkX.size()) });
      this.dkW.addAll(this.dkX);
    }
    y.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.dkW.size()) });
    Iterator localIterator = this.dkW.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.z.c)localIterator.next()).Ci();
    }
  }
  
  public final com.tencent.mm.z.c wQ()
  {
    return (com.tencent.mm.z.c)this.dkW.pop();
  }
  
  public final com.tencent.mm.z.c wR()
  {
    if ((this.dkW != null) && (this.dkW.size() > 0)) {
      return (com.tencent.mm.z.c)this.dkW.peek();
    }
    return null;
  }
  
  public final ListIterator<com.tencent.mm.z.c> wS()
  {
    return this.dkW.listIterator(this.dkW.size());
  }
  
  public final int[] wT()
  {
    int[] arrayOfInt = new int[2];
    if (this.dkX != null)
    {
      Iterator localIterator = this.dkX.iterator();
      while (localIterator.hasNext()) {
        if (((com.tencent.mm.z.c)localIterator.next() instanceof e)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.c
 * JD-Core Version:    0.7.0.1
 */