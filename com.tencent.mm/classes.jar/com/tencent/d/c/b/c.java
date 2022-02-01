package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] ZoP;
  static byte[] ZoQ;
  public int ZnY = 0;
  public int ZoG = 0;
  public int ZoH = 0;
  public int ZoI = 0;
  public byte[] ZoJ = null;
  public int ZoK = 0;
  public long ZoL = 0L;
  public byte[] ZoM = null;
  public int ZoN = 0;
  public int ZoO = 0;
  public int lJq = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    ZoP = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    ZoQ = arrayOfByte;
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
    this.ZoG = paramJceInputStream.read(this.ZoG, 0, false);
    this.ZnY = paramJceInputStream.read(this.ZnY, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.ZoH = paramJceInputStream.read(this.ZoH, 3, false);
    this.ZoI = paramJceInputStream.read(this.ZoI, 4, false);
    this.ZoJ = ((byte[])paramJceInputStream.read(ZoP, 5, false));
    this.ZoK = paramJceInputStream.read(this.ZoK, 6, false);
    this.lJq = paramJceInputStream.read(this.lJq, 7, false);
    this.ZoL = paramJceInputStream.read(this.ZoL, 8, false);
    this.ZoM = ((byte[])paramJceInputStream.read(ZoQ, 9, false));
    this.ZoN = paramJceInputStream.read(this.ZoN, 10, false);
    this.ZoO = paramJceInputStream.read(this.ZoO, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.ZoG != 0) {
      paramJceOutputStream.write(this.ZoG, 0);
    }
    paramJceOutputStream.write(this.ZnY, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.ZoH != 0) {
      paramJceOutputStream.write(this.ZoH, 3);
    }
    if (this.ZoI != 0) {
      paramJceOutputStream.write(this.ZoI, 4);
    }
    if (this.ZoJ != null) {
      paramJceOutputStream.write(this.ZoJ, 5);
    }
    if (this.ZoK != 0) {
      paramJceOutputStream.write(this.ZoK, 6);
    }
    if (this.lJq != 0) {
      paramJceOutputStream.write(this.lJq, 7);
    }
    if (this.ZoL != 0L) {
      paramJceOutputStream.write(this.ZoL, 8);
    }
    if (this.ZoM != null) {
      paramJceOutputStream.write(this.ZoM, 9);
    }
    if (this.ZoN != 0) {
      paramJceOutputStream.write(this.ZoN, 10);
    }
    if (this.ZoO != 0) {
      paramJceOutputStream.write(this.ZoO, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */