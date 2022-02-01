package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private final d[] glz;
  private final Object mLock;
  private int mPoolSize;
  
  public e()
  {
    AppMethodBeat.i(141032);
    this.mLock = new Object();
    this.glz = new d[3];
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
        if (this.glz[i] == paramd)
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
    paramd.glm = null;
    paramd.gln = null;
    paramd.glo = 0;
    paramd.glp = 0;
    paramd.glq = new TextPaint();
    paramd.width = 0;
    paramd.glr = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.gls = null;
    paramd.glt = 0;
    paramd.maxLines = 2147483647;
    paramd.glu = null;
    paramd.glv = 0.0F;
    paramd.glw = 1.0F;
    paramd.glx = false;
    paramd.maxLength = 0;
    paramd.gly = null;
    if (this.mPoolSize < this.glz.length)
    {
      this.glz[this.mPoolSize] = paramd;
      this.mPoolSize += 1;
      AppMethodBeat.o(141033);
      return true;
    }
    AppMethodBeat.o(141033);
    return false;
  }
  
  public final d ahV()
  {
    synchronized (this.mLock)
    {
      if (this.mPoolSize > 0)
      {
        int i = this.mPoolSize - 1;
        d locald = this.glz[i];
        this.glz[i] = null;
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