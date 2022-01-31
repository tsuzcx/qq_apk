package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] BjR;
  static byte[] BjS;
  static ArrayList<Integer> BjT;
  static ArrayList<byte[]> BjU;
  public String BjA = "";
  public byte[] BjB = null;
  public long BjC = 0L;
  public String BjD = "";
  public int BjE = 0;
  public String BjF = "";
  public int BjG = 0;
  public String BjH = "";
  public int BjI = 0;
  public int BjJ = 0;
  public int BjK = 0;
  public ArrayList<Integer> BjL = null;
  public int BjM = 0;
  public boolean BjN = false;
  public int BjO = 0;
  public int BjP = 0;
  public ArrayList<byte[]> BjQ = null;
  public int Bjy = 0;
  public byte[] Bjz = null;
  
  static
  {
    AppMethodBeat.i(114494);
    byte[] arrayOfByte = (byte[])new byte[1];
    BjR = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    BjS = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    BjT = new ArrayList();
    BjT.add(Integer.valueOf(0));
    BjU = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    BjU.add(arrayOfByte);
    AppMethodBeat.o(114494);
  }
  
  public final JceStruct newInit()
  {
    AppMethodBeat.i(114491);
    b localb = new b();
    AppMethodBeat.o(114491);
    return localb;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(114493);
    this.Bjy = paramJceInputStream.read(this.Bjy, 0, true);
    this.Bjz = ((byte[])paramJceInputStream.read(BjR, 1, false));
    this.BjA = paramJceInputStream.readString(2, false);
    this.BjB = ((byte[])paramJceInputStream.read(BjS, 3, false));
    this.BjC = paramJceInputStream.read(this.BjC, 4, false);
    this.BjD = paramJceInputStream.readString(5, false);
    this.BjE = paramJceInputStream.read(this.BjE, 6, false);
    this.BjF = paramJceInputStream.readString(7, false);
    this.BjG = paramJceInputStream.read(this.BjG, 8, false);
    this.BjH = paramJceInputStream.readString(9, false);
    this.BjI = paramJceInputStream.read(this.BjI, 10, false);
    this.BjJ = paramJceInputStream.read(this.BjJ, 11, false);
    this.BjK = paramJceInputStream.read(this.BjK, 12, false);
    this.BjL = ((ArrayList)paramJceInputStream.read(BjT, 13, false));
    this.BjM = paramJceInputStream.read(this.BjM, 14, false);
    this.BjN = paramJceInputStream.read(this.BjN, 15, false);
    this.BjO = paramJceInputStream.read(this.BjO, 16, false);
    this.BjP = paramJceInputStream.read(this.BjP, 17, false);
    this.BjQ = ((ArrayList)paramJceInputStream.read(BjU, 18, false));
    AppMethodBeat.o(114493);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(114492);
    paramJceOutputStream.write(this.Bjy, 0);
    if (this.Bjz != null) {
      paramJceOutputStream.write(this.Bjz, 1);
    }
    if (this.BjA != null) {
      paramJceOutputStream.write(this.BjA, 2);
    }
    if (this.BjB != null) {
      paramJceOutputStream.write(this.BjB, 3);
    }
    if (this.BjC != 0L) {
      paramJceOutputStream.write(this.BjC, 4);
    }
    if (this.BjD != null) {
      paramJceOutputStream.write(this.BjD, 5);
    }
    if (this.BjE != 0) {
      paramJceOutputStream.write(this.BjE, 6);
    }
    if (this.BjF != null) {
      paramJceOutputStream.write(this.BjF, 7);
    }
    if (this.BjG != 0) {
      paramJceOutputStream.write(this.BjG, 8);
    }
    if (this.BjH != null) {
      paramJceOutputStream.write(this.BjH, 9);
    }
    paramJceOutputStream.write(this.BjI, 10);
    if (this.BjJ != 0) {
      paramJceOutputStream.write(this.BjJ, 11);
    }
    if (this.BjK != 0) {
      paramJceOutputStream.write(this.BjK, 12);
    }
    if (this.BjL != null) {
      paramJceOutputStream.write(this.BjL, 13);
    }
    if (this.BjM != 0) {
      paramJceOutputStream.write(this.BjM, 14);
    }
    paramJceOutputStream.write(this.BjN, 15);
    if (this.BjO != 0) {
      paramJceOutputStream.write(this.BjO, 16);
    }
    paramJceOutputStream.write(this.BjP, 17);
    if (this.BjQ != null) {
      paramJceOutputStream.write(this.BjQ, 18);
    }
    AppMethodBeat.o(114492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.c.b.b
 * JD-Core Version:    0.7.0.1
 */