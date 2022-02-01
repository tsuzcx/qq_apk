package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] MjH;
  static byte[] MjI;
  public int MiQ = 0;
  public int MjA = 0;
  public byte[] MjB = null;
  public int MjC = 0;
  public long MjD = 0L;
  public byte[] MjE = null;
  public int MjF = 0;
  public int MjG = 0;
  public int Mjy = 0;
  public int Mjz = 0;
  public int hYa = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    MjH = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    MjI = arrayOfByte;
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
    this.Mjy = paramJceInputStream.read(this.Mjy, 0, false);
    this.MiQ = paramJceInputStream.read(this.MiQ, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.Mjz = paramJceInputStream.read(this.Mjz, 3, false);
    this.MjA = paramJceInputStream.read(this.MjA, 4, false);
    this.MjB = ((byte[])paramJceInputStream.read(MjH, 5, false));
    this.MjC = paramJceInputStream.read(this.MjC, 6, false);
    this.hYa = paramJceInputStream.read(this.hYa, 7, false);
    this.MjD = paramJceInputStream.read(this.MjD, 8, false);
    this.MjE = ((byte[])paramJceInputStream.read(MjI, 9, false));
    this.MjF = paramJceInputStream.read(this.MjF, 10, false);
    this.MjG = paramJceInputStream.read(this.MjG, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.Mjy != 0) {
      paramJceOutputStream.write(this.Mjy, 0);
    }
    paramJceOutputStream.write(this.MiQ, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.Mjz != 0) {
      paramJceOutputStream.write(this.Mjz, 3);
    }
    if (this.MjA != 0) {
      paramJceOutputStream.write(this.MjA, 4);
    }
    if (this.MjB != null) {
      paramJceOutputStream.write(this.MjB, 5);
    }
    if (this.MjC != 0) {
      paramJceOutputStream.write(this.MjC, 6);
    }
    if (this.hYa != 0) {
      paramJceOutputStream.write(this.hYa, 7);
    }
    if (this.MjD != 0L) {
      paramJceOutputStream.write(this.MjD, 8);
    }
    if (this.MjE != null) {
      paramJceOutputStream.write(this.MjE, 9);
    }
    if (this.MjF != 0) {
      paramJceOutputStream.write(this.MjF, 10);
    }
    if (this.MjG != 0) {
      paramJceOutputStream.write(this.MjG, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */