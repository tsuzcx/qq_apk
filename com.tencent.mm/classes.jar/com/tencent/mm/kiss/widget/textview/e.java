package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] kgA;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(141032);
    this.mLock = new Object();
    this.kgA = new d[3];
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
        if (this.kgA[i] == paramd)
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
    paramd.kgm = null;
    paramd.kgn = null;
    paramd.kgo = 0;
    paramd.kgp = 0;
    paramd.kgq = new TextPaint();
    paramd.width = 0;
    paramd.kgr = Layout.Alignment.ALIGN_NORMAL;
    paramd.ek = 51;
    paramd.kgs = null;
    paramd.kgt = 0;
    paramd.maxLines = 2147483647;
    paramd.kgu = null;
    paramd.kgv = 0.0F;
    paramd.kgw = 1.0F;
    paramd.kgx = false;
    paramd.maxLength = 0;
    paramd.kgz = null;
    paramd.kgy = -1;
    if (this.mPoolSize < this.kgA.length)
    {
      this.kgA[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(141033);
      return true;
    }
    AppMethodBeat.o(141033);
    return false;
  }
  
  public final d aIP()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.kgA[i];
        this.kgA[i] = null;
        this.mPoolSize -= 1;
        return locald;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */