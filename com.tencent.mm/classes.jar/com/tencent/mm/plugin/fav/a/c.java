package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.h.c.bk;
import com.tencent.mm.sdk.e.c.a;

public final class c
  extends bk
{
  public static c.a buS = ;
  
  public final boolean aPU()
  {
    return this.field_dataType == 4;
  }
  
  public final float getProgress()
  {
    return Math.max(0.0F, Math.min(99.0F, this.field_offset / this.field_totalLen) * 100.0F);
  }
  
  public final boolean isFinished()
  {
    return this.field_status == 3;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.c
 * JD-Core Version:    0.7.0.1
 */