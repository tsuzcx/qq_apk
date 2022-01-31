package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Stack;

public final class a
  implements d<com.tencent.mm.z.a>
{
  public Stack<com.tencent.mm.z.a> dkW;
  private Stack<com.tencent.mm.z.a> dkX;
  public Matrix dkY = new Matrix();
  private int dkZ;
  
  public final void a(Canvas paramCanvas, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.z.a parama)
  {
    if (this.dkW != null) {
      this.dkW.push(parama);
    }
  }
  
  public final void bf(boolean paramBoolean)
  {
    y.i("MicroMsg.CropCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
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
  
  public final void c(Canvas paramCanvas) {}
  
  public final void onCreate()
  {
    y.i("MicroMsg.CropCache", "[onCreate]");
    this.dkW = new Stack();
  }
  
  public final void onDestroy()
  {
    if (this.dkW != null) {
      this.dkW.clear();
    }
    if (this.dkX != null) {
      this.dkX.clear();
    }
    this.dkY.reset();
  }
  
  public final void tP()
  {
    this.dkZ += 1;
  }
  
  public final void wN()
  {
    y.i("MicroMsg.CropCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.dkW.size()) });
    this.dkW.clear();
    if (this.dkX != null)
    {
      y.i("MicroMsg.CropCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.dkX.size()) });
      this.dkW.addAll(this.dkX);
    }
  }
  
  public final com.tencent.mm.z.a wO()
  {
    if (this.dkW.size() <= 0)
    {
      y.e("MicroMsg.CropCache", "[pop]");
      return null;
    }
    return (com.tencent.mm.z.a)this.dkW.pop();
  }
  
  public final com.tencent.mm.z.a wP()
  {
    if ((this.dkW != null) && (this.dkW.size() > 0)) {
      return (com.tencent.mm.z.a)this.dkW.peek();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cache.a
 * JD-Core Version:    0.7.0.1
 */