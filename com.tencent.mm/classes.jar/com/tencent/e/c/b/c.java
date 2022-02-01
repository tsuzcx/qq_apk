package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] ahtx;
  static byte[] ahty;
  public int ahsG = 0;
  public int ahto = 0;
  public int ahtp = 0;
  public int ahtq = 0;
  public byte[] ahtr = null;
  public int ahts = 0;
  public long ahtt = 0L;
  public byte[] ahtu = null;
  public int ahtv = 0;
  public int ahtw = 0;
  public int oBS = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = new byte[1];
    ahtx = arrayOfByte;
    arrayOfByte[0] = 0;
    arrayOfByte = new byte[1];
    ahty = arrayOfByte;
    arrayOfByte[0] = 0;
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
    this.ahto = paramJceInputStream.read(this.ahto, 0, false);
    this.ahsG = paramJceInputStream.read(this.ahsG, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.ahtp = paramJceInputStream.read(this.ahtp, 3, false);
    this.ahtq = paramJceInputStream.read(this.ahtq, 4, false);
    this.ahtr = paramJceInputStream.read(ahtx, 5, false);
    this.ahts = paramJceInputStream.read(this.ahts, 6, false);
    this.oBS = paramJceInputStream.read(this.oBS, 7, false);
    this.ahtt = paramJceInputStream.read(this.ahtt, 8, false);
    this.ahtu = paramJceInputStream.read(ahty, 9, false);
    this.ahtv = paramJceInputStream.read(this.ahtv, 10, false);
    this.ahtw = paramJceInputStream.read(this.ahtw, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.ahto != 0) {
      paramJceOutputStream.write(this.ahto, 0);
    }
    paramJceOutputStream.write(this.ahsG, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.ahtp != 0) {
      paramJceOutputStream.write(this.ahtp, 3);
    }
    if (this.ahtq != 0) {
      paramJceOutputStream.write(this.ahtq, 4);
    }
    if (this.ahtr != null) {
      paramJceOutputStream.write(this.ahtr, 5);
    }
    if (this.ahts != 0) {
      paramJceOutputStream.write(this.ahts, 6);
    }
    if (this.oBS != 0) {
      paramJceOutputStream.write(this.oBS, 7);
    }
    if (this.ahtt != 0L) {
      paramJceOutputStream.write(this.ahtt, 8);
    }
    if (this.ahtu != null) {
      paramJceOutputStream.write(this.ahtu, 9);
    }
    if (this.ahtv != 0) {
      paramJceOutputStream.write(this.ahtv, 10);
    }
    if (this.ahtw != 0) {
      paramJceOutputStream.write(this.ahtw, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.b.c
 * JD-Core Version:    0.7.0.1
 */