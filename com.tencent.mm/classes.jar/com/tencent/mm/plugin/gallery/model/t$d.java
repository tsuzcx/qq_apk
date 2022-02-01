package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t$d
  extends t.i
{
  public String HIH;
  public String categoryID;
  
  t$d()
  {
    this.mType = 0;
  }
  
  t$d(String paramString1, String paramString2)
  {
    this();
    this.categoryID = paramString1;
    this.HIH = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(111364);
    if (((paramObject instanceof d)) && (this.HIH.equals(((d)paramObject).HIH)) && (this.categoryID.equals(((d)paramObject).categoryID)))
    {
      AppMethodBeat.o(111364);
      return true;
    }
    AppMethodBeat.o(111364);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(111363);
    int i = this.categoryID.hashCode();
    int j = this.HIH.hashCode();
    AppMethodBeat.o(111363);
    return (i + 629) * 37 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.t.d
 * JD-Core Version:    0.7.0.1
 */