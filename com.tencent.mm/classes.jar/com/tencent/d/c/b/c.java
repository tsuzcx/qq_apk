package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] LMI;
  static byte[] LMJ;
  public int LLR = 0;
  public int LMA = 0;
  public int LMB = 0;
  public byte[] LMC = null;
  public int LMD = 0;
  public long LME = 0L;
  public byte[] LMF = null;
  public int LMG = 0;
  public int LMH = 0;
  public int LMz = 0;
  public int hVi = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    LMI = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    LMJ = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138336);
    c localc = new c();
    AppMethodBeat.o(138336);
    return localc;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138338);
    this.LMz = paramJceInputStream.read(this.LMz, 0, false);
    this.LLR = paramJceInputStream.read(this.LLR, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.LMA = paramJceInputStream.read(this.LMA, 3, false);
    this.LMB = paramJceInputStream.read(this.LMB, 4, false);
    this.LMC = ((byte[])paramJceInputStream.read(LMI, 5, false));
    this.LMD = paramJceInputStream.read(this.LMD, 6, false);
    this.hVi = paramJceInputStream.read(this.hVi, 7, false);
    this.LME = paramJceInputStream.read(this.LME, 8, false);
    this.LMF = ((byte[])paramJceInputStream.read(LMJ, 9, false));
    this.LMG = paramJceInputStream.read(this.LMG, 10, false);
    this.LMH = paramJceInputStream.read(this.LMH, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.LMz != 0) {
      paramJceOutputStream.write(this.LMz, 0);
    }
    paramJceOutputStream.write(this.LLR, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.LMA != 0) {
      paramJceOutputStream.write(this.LMA, 3);
    }
    if (this.LMB != 0) {
      paramJceOutputStream.write(this.LMB, 4);
    }
    if (this.LMC != null) {
      paramJceOutputStream.write(this.LMC, 5);
    }
    if (this.LMD != 0) {
      paramJceOutputStream.write(this.LMD, 6);
    }
    if (this.hVi != 0) {
      paramJceOutputStream.write(this.hVi, 7);
    }
    if (this.LME != 0L) {
      paramJceOutputStream.write(this.LME, 8);
    }
    if (this.LMF != null) {
      paramJceOutputStream.write(this.LMF, 9);
    }
    if (this.LMG != 0) {
      paramJceOutputStream.write(this.LMG, 10);
    }
    if (this.LMH != 0) {
      paramJceOutputStream.write(this.LMH, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */