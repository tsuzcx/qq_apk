package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] mGT;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(141032);
    this.mLock = new Object();
    this.mGT = new d[3];
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
        if (this.mGT[i] == paramd)
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
    paramd.mGK = null;
    paramd.mGL = null;
    paramd.mGM = 0;
    paramd.mGN = 0;
    paramd.bbb = new TextPaint();
    paramd.width = 0;
    paramd.bbd = Layout.Alignment.ALIGN_NORMAL;
    paramd.fl = 51;
    paramd.bbe = null;
    paramd.bbf = 0;
    paramd.maxLines = 2147483647;
    paramd.mGO = null;
    paramd.mGP = 0.0F;
    paramd.mGQ = 1.0F;
    paramd.mGR = false;
    paramd.maxLength = 0;
    paramd.mGS = null;
    paramd.bbl = -1;
    if (this.mPoolSize < this.mGT.length)
    {
      this.mGT[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(141033);
      return true;
    }
    AppMethodBeat.o(141033);
    return false;
  }
  
  public final d bbL()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.mGT[i];
        this.mGT[i] = null;
        this.mPoolSize -= 1;
        return locald;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */