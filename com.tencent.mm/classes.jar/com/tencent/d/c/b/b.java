package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] JSE;
  static byte[] JSF;
  static ArrayList<Integer> JSG;
  static ArrayList<byte[]> JSH;
  public boolean JSA = false;
  public int JSB = 0;
  public int JSC = 0;
  public ArrayList<byte[]> JSD = null;
  public int JSl = 0;
  public byte[] JSm = null;
  public String JSn = "";
  public byte[] JSo = null;
  public long JSp = 0L;
  public String JSq = "";
  public int JSr = 0;
  public String JSs = "";
  public int JSt = 0;
  public String JSu = "";
  public int JSv = 0;
  public int JSw = 0;
  public int JSx = 0;
  public ArrayList<Integer> JSy = null;
  public int JSz = 0;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    JSE = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    JSF = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    JSG = new ArrayList();
    JSG.add(Integer.valueOf(0));
    JSH = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    JSH.add(arrayOfByte);
    AppMethodBeat.o(138335);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(138332);
    b localb = new b();
    AppMethodBeat.o(138332);
    return localb;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(138334);
    this.JSl = paramJceInputStream.read(this.JSl, 0, true);
    this.JSm = ((byte[])paramJceInputStream.read(JSE, 1, false));
    this.JSn = paramJceInputStream.readString(2, false);
    this.JSo = ((byte[])paramJceInputStream.read(JSF, 3, false));
    this.JSp = paramJceInputStream.read(this.JSp, 4, false);
    this.JSq = paramJceInputStream.readString(5, false);
    this.JSr = paramJceInputStream.read(this.JSr, 6, false);
    this.JSs = paramJceInputStream.readString(7, false);
    this.JSt = paramJceInputStream.read(this.JSt, 8, false);
    this.JSu = paramJceInputStream.readString(9, false);
    this.JSv = paramJceInputStream.read(this.JSv, 10, false);
    this.JSw = paramJceInputStream.read(this.JSw, 11, false);
    this.JSx = paramJceInputStream.read(this.JSx, 12, false);
    this.JSy = ((ArrayList)paramJceInputStream.read(JSG, 13, false));
    this.JSz = paramJceInputStream.read(this.JSz, 14, false);
    this.JSA = paramJceInputStream.read(this.JSA, 15, false);
    this.JSB = paramJceInputStream.read(this.JSB, 16, false);
    this.JSC = paramJceInputStream.read(this.JSC, 17, false);
    this.JSD = ((ArrayList)paramJceInputStream.read(JSH, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.JSl, 0);
    if (this.JSm != null) {
      paramJceOutputStream.write(this.JSm, 1);
    }
    if (this.JSn != null) {
      paramJceOutputStream.write(this.JSn, 2);
    }
    if (this.JSo != null) {
      paramJceOutputStream.write(this.JSo, 3);
    }
    if (this.JSp != 0L) {
      paramJceOutputStream.write(this.JSp, 4);
    }
    if (this.JSq != null) {
      paramJceOutputStream.write(this.JSq, 5);
    }
    if (this.JSr != 0) {
      paramJceOutputStream.write(this.JSr, 6);
    }
    if (this.JSs != null) {
      paramJceOutputStream.write(this.JSs, 7);
    }
    if (this.JSt != 0) {
      paramJceOutputStream.write(this.JSt, 8);
    }
    if (this.JSu != null) {
      paramJceOutputStream.write(this.JSu, 9);
    }
    paramJceOutputStream.write(this.JSv, 10);
    if (this.JSw != 0) {
      paramJceOutputStream.write(this.JSw, 11);
    }
    if (this.JSx != 0) {
      paramJceOutputStream.write(this.JSx, 12);
    }
    if (this.JSy != null) {
      paramJceOutputStream.write(this.JSy, 13);
    }
    if (this.JSz != 0) {
      paramJceOutputStream.write(this.JSz, 14);
    }
    paramJceOutputStream.write(this.JSA, 15);
    if (this.JSB != 0) {
      paramJceOutputStream.write(this.JSB, 16);
    }
    paramJceOutputStream.write(this.JSC, 17);
    if (this.JSD != null) {
      paramJceOutputStream.write(this.JSD, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */