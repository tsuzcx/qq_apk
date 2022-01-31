package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class d$b
{
  private int axc = 0;
  public long eiq;
  public long fDF;
  public int fDG;
  public int fDH;
  public List<d.c> fDI;
  
  public d$b(long paramLong1, long paramLong2, int paramInt)
  {
    this.fDF = paramLong1;
    this.eiq = paramLong2;
    this.fDG = paramInt;
    this.fDH = 0;
  }
  
  public final boolean a(d.a parama, Object paramObject)
  {
    AppMethodBeat.i(78173);
    if (this.fDI == null) {
      this.fDI = Collections.synchronizedList(new LinkedList());
    }
    parama = new d.c(parama, paramObject);
    if (this.fDI.contains(parama))
    {
      ab.d("ModelImage.DownloadImgService.Task", "task item already exists");
      AppMethodBeat.o(78173);
      return false;
    }
    this.fDI.add(parama);
    AppMethodBeat.o(78173);
    return true;
  }
  
  public final int ahf()
  {
    AppMethodBeat.i(78175);
    int i = this.fDI.size();
    AppMethodBeat.o(78175);
    return i;
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(78174);
    parama = new d.c(parama, null);
    if (this.fDI.contains(parama))
    {
      this.fDI.remove(parama);
      AppMethodBeat.o(78174);
      return true;
    }
    AppMethodBeat.o(78174);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof b))) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((paramObject.fDF != this.fDF) || (paramObject.eiq != this.eiq) || (paramObject.fDG != this.fDG));
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(78176);
    if (this.axc == 0) {
      this.axc = (this.fDF + "_" + this.eiq + "_" + this.fDG).hashCode();
    }
    int i = this.axc;
    AppMethodBeat.o(78176);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.d.b
 * JD-Core Version:    0.7.0.1
 */