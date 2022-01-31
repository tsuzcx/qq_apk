package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$b
{
  public int fNe;
  public int fNf;
  public int fNg;
  public int fNh;
  public int fNi;
  public int fNj;
  public int fNk;
  public int fNl;
  public int fNm;
  public int fNn;
  public int fNo;
  public int fNp;
  
  public final String toString()
  {
    AppMethodBeat.i(16548);
    Object localObject = new StringBuffer();
    if (this.fNe > 0) {
      ((StringBuffer)localObject).append("appForegroundExpCount:" + this.fNe + " ");
    }
    if (this.fNf > 0) {
      ((StringBuffer)localObject).append("appBackgroundExpCount:" + this.fNf + " ");
    }
    if (this.fNg > 0) {
      ((StringBuffer)localObject).append("componentForegroundExpCount:" + this.fNg + " ");
    }
    if (this.fNh > 0) {
      ((StringBuffer)localObject).append("componentBackgroundExpCount:" + this.fNh + " ");
    }
    if (this.fNi > 0) {
      ((StringBuffer)localObject).append("appForegroundCrashOrAnrExpCount:" + this.fNi + " ");
    }
    if (this.fNj > 0) {
      ((StringBuffer)localObject).append("appBackgroundCrashOrAnrExpCount:" + this.fNj + " ");
    }
    if (this.fNk > 0) {
      ((StringBuffer)localObject).append("componentForegroundCrashOrAnrExpCount:" + this.fNk + " ");
    }
    if (this.fNl > 0) {
      ((StringBuffer)localObject).append("componentBackgroundCrashOrAnrExpCount:" + this.fNl + " ");
    }
    if (this.fNm > 0) {
      ((StringBuffer)localObject).append("appForegroundTimeoutExpCount:" + this.fNm + " ");
    }
    if (this.fNn > 0) {
      ((StringBuffer)localObject).append("appBackgroundTimeoutExpCount:" + this.fNn + " ");
    }
    if (this.fNo > 0) {
      ((StringBuffer)localObject).append("componentForegroundTimeoutExpCount:" + this.fNo + " ");
    }
    if (this.fNp > 0) {
      ((StringBuffer)localObject).append("componentBackgroundTimeoutExpCount:" + this.fNp + " ");
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(16548);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b.b
 * JD-Core Version:    0.7.0.1
 */