package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] Irh;
  static byte[] Iri;
  public int IqY = 0;
  public int IqZ = 0;
  public int Iqq = 0;
  public int Ira = 0;
  public byte[] Irb = null;
  public int Irc = 0;
  public long Ird = 0L;
  public byte[] Ire = null;
  public int Irf = 0;
  public int Irg = 0;
  public int hcb = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    Irh = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    Iri = arrayOfByte;
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
    this.IqY = paramJceInputStream.read(this.IqY, 0, false);
    this.Iqq = paramJceInputStream.read(this.Iqq, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.IqZ = paramJceInputStream.read(this.IqZ, 3, false);
    this.Ira = paramJceInputStream.read(this.Ira, 4, false);
    this.Irb = ((byte[])paramJceInputStream.read(Irh, 5, false));
    this.Irc = paramJceInputStream.read(this.Irc, 6, false);
    this.hcb = paramJceInputStream.read(this.hcb, 7, false);
    this.Ird = paramJceInputStream.read(this.Ird, 8, false);
    this.Ire = ((byte[])paramJceInputStream.read(Iri, 9, false));
    this.Irf = paramJceInputStream.read(this.Irf, 10, false);
    this.Irg = paramJceInputStream.read(this.Irg, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.IqY != 0) {
      paramJceOutputStream.write(this.IqY, 0);
    }
    paramJceOutputStream.write(this.Iqq, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.IqZ != 0) {
      paramJceOutputStream.write(this.IqZ, 3);
    }
    if (this.Ira != 0) {
      paramJceOutputStream.write(this.Ira, 4);
    }
    if (this.Irb != null) {
      paramJceOutputStream.write(this.Irb, 5);
    }
    if (this.Irc != 0) {
      paramJceOutputStream.write(this.Irc, 6);
    }
    if (this.hcb != 0) {
      paramJceOutputStream.write(this.hcb, 7);
    }
    if (this.Ird != 0L) {
      paramJceOutputStream.write(this.Ird, 8);
    }
    if (this.Ire != null) {
      paramJceOutputStream.write(this.Ire, 9);
    }
    if (this.Irf != 0) {
      paramJceOutputStream.write(this.Irf, 10);
    }
    if (this.Irg != 0) {
      paramJceOutputStream.write(this.Irg, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */