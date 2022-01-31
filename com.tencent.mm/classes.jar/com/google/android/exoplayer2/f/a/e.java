package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.i;
import java.util.LinkedList;

public final class e
  extends i
{
  private final d aNM;
  
  public e(d paramd)
  {
    this.aNM = paramd;
  }
  
  public final void release()
  {
    d locald = this.aNM;
    clear();
    locald.aNJ.add(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.e
 * JD-Core Version:    0.7.0.1
 */