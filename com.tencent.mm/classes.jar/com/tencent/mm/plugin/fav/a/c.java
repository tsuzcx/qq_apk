package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bu;
import com.tencent.mm.sdk.e.c.a;

public final class c
  extends bu
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(103362);
    info = bu.VD();
    AppMethodBeat.o(103362);
  }
  
  public final boolean cwo()
  {
    return this.field_dataType == 4;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final float getProgress()
  {
    AppMethodBeat.i(103361);
    float f = Math.max(0.0F, Math.min(99.0F, this.field_offset / this.field_totalLen) * 100.0F);
    AppMethodBeat.o(103361);
    return f;
  }
  
  public final boolean isFinished()
  {
    return this.field_status == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.c
 * JD-Core Version:    0.7.0.1
 */