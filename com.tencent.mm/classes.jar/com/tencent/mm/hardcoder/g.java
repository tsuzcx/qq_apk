package com.tencent.mm.hardcoder;

import java.util.Map;

public final class g
  extends e
{
  public final boolean bZO;
  public final boolean dFg;
  public final int key;
  public final int value;
  
  public g(int paramInt)
  {
    this.dFg = false;
    this.key = ((Integer)WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(paramInt))).intValue();
    this.value = 1;
    this.bZO = false;
  }
  
  public g(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    this.dFg = paramBoolean1;
    this.key = paramInt1;
    this.value = paramInt2;
    this.bZO = paramBoolean2;
  }
  
  public final void wn()
  {
    h.reportInfo(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.g
 * JD-Core Version:    0.7.0.1
 */