package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends JceStruct
{
  static byte[] JSR;
  static byte[] JSS;
  public int JSI = 0;
  public int JSJ = 0;
  public int JSK = 0;
  public byte[] JSL = null;
  public int JSM = 0;
  public long JSN = 0L;
  public byte[] JSO = null;
  public int JSP = 0;
  public int JSQ = 0;
  public int JSa = 0;
  public int hCD = 0;
  public int requestType = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    JSR = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    JSS = arrayOfByte;
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
    this.JSI = paramJceInputStream.read(this.JSI, 0, false);
    this.JSa = paramJceInputStream.read(this.JSa, 1, false);
    this.requestType = paramJceInputStream.read(this.requestType, 2, false);
    this.JSJ = paramJceInputStream.read(this.JSJ, 3, false);
    this.JSK = paramJceInputStream.read(this.JSK, 4, false);
    this.JSL = ((byte[])paramJceInputStream.read(JSR, 5, false));
    this.JSM = paramJceInputStream.read(this.JSM, 6, false);
    this.hCD = paramJceInputStream.read(this.hCD, 7, false);
    this.JSN = paramJceInputStream.read(this.JSN, 8, false);
    this.JSO = ((byte[])paramJceInputStream.read(JSS, 9, false));
    this.JSP = paramJceInputStream.read(this.JSP, 10, false);
    this.JSQ = paramJceInputStream.read(this.JSQ, 11, false);
    AppMethodBeat.o(138338);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138337);
    if (this.JSI != 0) {
      paramJceOutputStream.write(this.JSI, 0);
    }
    paramJceOutputStream.write(this.JSa, 1);
    paramJceOutputStream.write(this.requestType, 2);
    if (this.JSJ != 0) {
      paramJceOutputStream.write(this.JSJ, 3);
    }
    if (this.JSK != 0) {
      paramJceOutputStream.write(this.JSK, 4);
    }
    if (this.JSL != null) {
      paramJceOutputStream.write(this.JSL, 5);
    }
    if (this.JSM != 0) {
      paramJceOutputStream.write(this.JSM, 6);
    }
    if (this.hCD != 0) {
      paramJceOutputStream.write(this.hCD, 7);
    }
    if (this.JSN != 0L) {
      paramJceOutputStream.write(this.JSN, 8);
    }
    if (this.JSO != null) {
      paramJceOutputStream.write(this.JSO, 9);
    }
    if (this.JSP != 0) {
      paramJceOutputStream.write(this.JSP, 10);
    }
    if (this.JSQ != 0) {
      paramJceOutputStream.write(this.JSQ, 11);
    }
    AppMethodBeat.o(138337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.c
 * JD-Core Version:    0.7.0.1
 */