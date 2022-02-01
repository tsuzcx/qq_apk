package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends bv
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(103362);
    info = bv.ajs();
    AppMethodBeat.o(103362);
  }
  
  public final boolean cUr()
  {
    return this.field_dataType == 4;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.c
 * JD-Core Version:    0.7.0.1
 */