package com.bumptech.glide.e.a;

import com.bumptech.glide.g.k;

@Deprecated
public abstract class c<Z>
  extends a<Z>
{
  private final int height = -2147483648;
  private final int width = -2147483648;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte) {}
  
  public final void a(d paramd)
  {
    if (!k.aT(this.width, this.height)) {
      throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }
    paramd.aS(this.width, this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.a.c
 * JD-Core Version:    0.7.0.1
 */