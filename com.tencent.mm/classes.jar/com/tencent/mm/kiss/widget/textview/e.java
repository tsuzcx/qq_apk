package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] ggT;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(141032);
    this.mLock = new Object();
    this.ggT = new d[3];
    AppMethodBeat.o(141032);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(141033);
    Object localObject = this.mLock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.mPoolSize) {
          break label72;
        }
        if (this.ggT[i] == paramd)
        {
          i = 1;
          if (i == 0) {
            break;
          }
          paramd = new IllegalStateException("Already in the pool!");
          AppMethodBeat.o(141033);
          throw paramd;
        }
      }
      finally
      {
        AppMethodBeat.o(141033);
      }
      i += 1;
      continue;
      label72:
      i = 0;
    }
    paramd.ggG = null;
    paramd.ggH = null;
    paramd.ggI = 0;
    paramd.ggJ = 0;
    paramd.ggK = new TextPaint();
    paramd.width = 0;
    paramd.ggL = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.ggM = null;
    paramd.ggN = 0;
    paramd.maxLines = 2147483647;
    paramd.ggO = null;
    paramd.ggP = 0.0F;
    paramd.ggQ = 1.0F;
    paramd.ggR = false;
    paramd.maxLength = 0;
    paramd.ggS = null;
    if (this.mPoolSize < this.ggT.length)
    {
      this.ggT[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(141033);
      return true;
    }
    AppMethodBeat.o(141033);
    return false;
  }
  
  public final d agE()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.ggT[i];
        this.ggT[i] = null;
        this.mPoolSize -= 1;
        return locald;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */