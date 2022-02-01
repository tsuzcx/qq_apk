package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] RMi;
  static byte[] RMj;
  public int RLZ = 0;
  public int RLr = 0;
  public int RMa = 0;
  public int RMb = 0;
  public byte[] RMc = null;
  public int RMd = 0;
  public long RMe = 0L;
  public byte[] RMf = null;
  public int RMg = 0;
  public int RMh = 0;
  public int iSY = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    RMi = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    RMj = arrayOfByte;
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
    this.RLZ = paramJceInputStream.read(this.RLZ, 0, false);
    this.RLr = paramJceInputStream.read(this.RLr, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.RMa = paramJceInputStream.read(this.RMa, 3, false);
    this.RMb = paramJceInputStream.read(this.RMb, 4, false);
    this.RMc = ((byte[])paramJceInputStream.read(RMi, 5, false));
    this.RMd = paramJceInputStream.read(this.RMd, 6, false);
    this.iSY = paramJceInputStream.read(this.iSY, 7, false);
    this.RMe = paramJceInputStream.read(this.RMe, 8, false);
    this.RMf = ((byte[])paramJceInputStream.read(RMj, 9, false));
    this.RMg = paramJceInputStream.read(this.RMg, 10, false);
    this.RMh = paramJceInputStream.read(this.RMh, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.RLZ != 0) {
      paramJceOutputStream.write(this.RLZ, 0);
    }
    paramJceOutputStream.write(this.RLr, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.RMa != 0) {
      paramJceOutputStream.write(this.RMa, 3);
    }
    if (this.RMb != 0) {
      paramJceOutputStream.write(this.RMb, 4);
    }
    if (this.RMc != null) {
      paramJceOutputStream.write(this.RMc, 5);
    }
    if (this.RMd != 0) {
      paramJceOutputStream.write(this.RMd, 6);
    }
    if (this.iSY != 0) {
      paramJceOutputStream.write(this.iSY, 7);
    }
    if (this.RMe != 0L) {
      paramJceOutputStream.write(this.RMe, 8);
    }
    if (this.RMf != null) {
      paramJceOutputStream.write(this.RMf, 9);
    }
    if (this.RMg != 0) {
      paramJceOutputStream.write(this.RMg, 10);
    }
    if (this.RMh != 0) {
      paramJceOutputStream.write(this.RMh, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.b.c
 * JD-Core Version:    0.7.0.1
 */