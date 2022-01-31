package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] eLN;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(105714);
    this.mLock = new Object();
    this.eLN = new d[3];
    AppMethodBeat.o(105714);
  }
  
  public final d SL()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.eLN[i];
        this.eLN[i] = null;
        this.mPoolSize -= 1;
        return locald;
      }
      return null;
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(105715);
    Object localObject = this.mLock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.mPoolSize) {
          break label72;
        }
        if (this.eLN[i] == paramd)
        {
          i = 1;
          if (i == 0) {
            break;
          }
          paramd = new IllegalStateException("Already in the pool!");
          AppMethodBeat.o(105715);
          throw paramd;
        }
      }
      finally
      {
        AppMethodBeat.o(105715);
      }
      i += 1;
      continue;
      label72:
      i = 0;
    }
    paramd.eLA = null;
    paramd.eLB = null;
    paramd.eLC = 0;
    paramd.eLD = 0;
    paramd.eLE = new TextPaint();
    paramd.width = 0;
    paramd.eLF = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.eLG = null;
    paramd.eLH = 0;
    paramd.maxLines = 2147483647;
    paramd.eLI = null;
    paramd.eLJ = 0.0F;
    paramd.eLK = 1.0F;
    paramd.eLL = false;
    paramd.maxLength = 0;
    paramd.eLM = null;
    if (this.mPoolSize < this.eLN.length)
    {
      this.eLN[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(105715);
      return true;
    }
    AppMethodBeat.o(105715);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */