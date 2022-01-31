package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h$a
{
  private String cBq;
  private String id;
  
  public h$a(String paramString1, String paramString2)
  {
    this.cBq = paramString1;
    this.id = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11567);
    if (paramObject.getClass() != a.class)
    {
      AppMethodBeat.o(11567);
      return false;
    }
    paramObject = (a)paramObject;
    if (((this.cBq == null) && (paramObject.cBq == null)) || ((this.cBq != null) && (this.cBq.equals(paramObject.cBq)) && (((this.id == null) && (paramObject.id == null)) || ((this.id != null) && (this.id.equals(paramObject.id))))))
    {
      AppMethodBeat.o(11567);
      return true;
    }
    AppMethodBeat.o(11567);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(11568);
    int i = this.cBq.hashCode();
    int j = this.id.hashCode();
    AppMethodBeat.o(11568);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.aj.a.h.a
 * JD-Core Version:    0.7.0.1
 */