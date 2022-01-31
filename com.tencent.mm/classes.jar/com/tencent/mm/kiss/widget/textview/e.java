package com.tencent.mm.kiss.widget.textview;

import android.text.Layout.Alignment;
import android.text.TextPaint;

public final class e
{
  private int Er;
  private final d[] dOf = new d[3];
  private final Object mLock = new Object();
  
  public final d EG()
  {
    synchronized (this.mLock)
    {
      if (this.Er > 0)
      {
        int i = this.Er - 1;
        d locald = this.dOf[i];
        this.dOf[i] = null;
        this.Er -= 1;
        return locald;
      }
      return null;
    }
  }
  
  public final boolean a(d paramd)
  {
    Object localObject = this.mLock;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.Er) {
          break label55;
        }
        if (this.dOf[i] == paramd)
        {
          i = 1;
          if (i == 0) {
            break;
          }
          throw new IllegalStateException("Already in the pool!");
        }
      }
      finally {}
      i += 1;
      continue;
      label55:
      i = 0;
    }
    paramd.dNS = null;
    paramd.dNT = null;
    paramd.dNU = 0;
    paramd.dNV = 0;
    paramd.dNW = new TextPaint();
    paramd.width = 0;
    paramd.dNX = Layout.Alignment.ALIGN_NORMAL;
    paramd.gravity = 51;
    paramd.dNY = null;
    paramd.dNZ = 0;
    paramd.maxLines = 2147483647;
    paramd.dOa = null;
    paramd.dOb = 0.0F;
    paramd.dOc = 1.0F;
    paramd.dOd = false;
    paramd.maxLength = 0;
    paramd.dOe = null;
    if (this.Er < this.dOf.length)
    {
      this.dOf[this.Er] = paramd;
      this.Er += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.e
 * JD-Core Version:    0.7.0.1
 */