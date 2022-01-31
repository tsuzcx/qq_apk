package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bm;
import com.tencent.mm.sdk.e.c.a;

public final class c
  extends bm
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(102622);
    info = bm.Hm();
    AppMethodBeat.o(102622);
  }
  
  public final boolean bwi()
  {
    return this.field_dataType == 4;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final float getProgress()
  {
    AppMethodBeat.i(102621);
    float f = Math.max(0.0F, Math.min(99.0F, this.field_offset / this.field_totalLen) * 100.0F);
    AppMethodBeat.o(102621);
    return f;
  }
  
  public final boolean isFinished()
  {
    return this.field_status == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.c
 * JD-Core Version:    0.7.0.1
 */