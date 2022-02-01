package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] gFj;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(141032);
    this.mLock = new Object();
    this.gFj = new d[3];
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
        if (this.gFj[i] == paramd)
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
    paramd.gEW = null;
    paramd.gEX = null;
    paramd.gEY = 0;
    paramd.gEZ = 0;
    paramd.gFa = new TextPaint();
    paramd.width = 0;
    paramd.gFb = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.gFc = null;
    paramd.gFd = 0;
    paramd.maxLines = 2147483647;
    paramd.gFe = null;
    paramd.gFf = 0.0F;
    paramd.gFg = 1.0F;
    paramd.gFh = false;
    paramd.maxLength = 0;
    paramd.gFi = null;
    paramd.breakStrategy = -1;
    if (this.mPoolSize < this.gFj.length)
    {
      this.gFj[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(141033);
      return true;
    }
    AppMethodBeat.o(141033);
    return false;
  }
  
  public final d akG()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.gFj[i];
        this.gFj[i] = null;
        this.mPoolSize -= 1;
        return locald;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */