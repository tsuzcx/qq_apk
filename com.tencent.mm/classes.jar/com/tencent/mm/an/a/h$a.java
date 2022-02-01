package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h$a
{
  private String hTu;
  private String id;
  
  public h$a(String paramString1, String paramString2)
  {
    this.hTu = paramString1;
    this.id = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(124253);
    if (paramObject.getClass() != a.class)
    {
      AppMethodBeat.o(124253);
      return false;
    }
    paramObject = (a)paramObject;
    if (((this.hTu == null) && (paramObject.hTu == null)) || ((this.hTu != null) && (this.hTu.equals(paramObject.hTu)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
    {
      AppMethodBeat.o(124253);
      return true;
    }
    AppMethodBeat.o(124253);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(124254);
    int i = this.hTu.hashCode();
    int j = this.id.hashCode();
    AppMethodBeat.o(124254);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.h.a
 * JD-Core Version:    0.7.0.1
 */