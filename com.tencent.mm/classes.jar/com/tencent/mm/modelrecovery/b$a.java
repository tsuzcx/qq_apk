package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  public int eke;
  public int fMZ;
  public int fNa;
  public int fNb;
  public int fNc;
  public int fNd;
  
  public final String toString()
  {
    AppMethodBeat.i(16547);
    Object localObject = new StringBuffer();
    if (this.eke > 0) {
      ((StringBuffer)localObject).append("totalCount:" + this.eke + " ");
    }
    if (this.fMZ > 0) {
      ((StringBuffer)localObject).append("enterRecoveryCount:" + this.fMZ + " ");
    }
    if (this.fNa > 0) {
      ((StringBuffer)localObject).append("existRecoveryProcessCount:" + this.fNa + " ");
    }
    if (this.fNb > 0) {
      ((StringBuffer)localObject).append("foregroundExpCount:" + this.fNb + " ");
    }
    if (this.fNc > 0) {
      ((StringBuffer)localObject).append("backgroundExpCount:" + this.fNc + " ");
    }
    if (this.fNd > 0) {
      ((StringBuffer)localObject).append("normalCount:" + this.fNd + " ");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(16547);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b.a
 * JD-Core Version:    0.7.0.1
 */