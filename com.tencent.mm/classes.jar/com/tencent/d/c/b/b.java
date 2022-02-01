package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] IqU;
  static byte[] IqV;
  static ArrayList<Integer> IqW;
  static ArrayList<byte[]> IqX;
  public int IqB = 0;
  public byte[] IqC = null;
  public String IqD = "";
  public byte[] IqE = null;
  public long IqF = 0L;
  public String IqG = "";
  public int IqH = 0;
  public String IqI = "";
  public int IqJ = 0;
  public String IqK = "";
  public int IqL = 0;
  public int IqM = 0;
  public int IqN = 0;
  public ArrayList<Integer> IqO = null;
  public int IqP = 0;
  public boolean IqQ = false;
  public int IqR = 0;
  public int IqS = 0;
  public ArrayList<byte[]> IqT = null;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    IqU = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    IqV = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    IqW = new ArrayList();
    IqW.add(Integer.valueOf(0));
    IqX = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    IqX.add(arrayOfByte);
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
    this.IqB = paramJceInputStream.read(this.IqB, 0, true);
    this.IqC = ((byte[])paramJceInputStream.read(IqU, 1, false));
    this.IqD = paramJceInputStream.readString(2, false);
    this.IqE = ((byte[])paramJceInputStream.read(IqV, 3, false));
    this.IqF = paramJceInputStream.read(this.IqF, 4, false);
    this.IqG = paramJceInputStream.readString(5, false);
    this.IqH = paramJceInputStream.read(this.IqH, 6, false);
    this.IqI = paramJceInputStream.readString(7, false);
    this.IqJ = paramJceInputStream.read(this.IqJ, 8, false);
    this.IqK = paramJceInputStream.readString(9, false);
    this.IqL = paramJceInputStream.read(this.IqL, 10, false);
    this.IqM = paramJceInputStream.read(this.IqM, 11, false);
    this.IqN = paramJceInputStream.read(this.IqN, 12, false);
    this.IqO = ((ArrayList)paramJceInputStream.read(IqW, 13, false));
    this.IqP = paramJceInputStream.read(this.IqP, 14, false);
    this.IqQ = paramJceInputStream.read(this.IqQ, 15, false);
    this.IqR = paramJceInputStream.read(this.IqR, 16, false);
    this.IqS = paramJceInputStream.read(this.IqS, 17, false);
    this.IqT = ((ArrayList)paramJceInputStream.read(IqX, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.IqB, 0);
    if (this.IqC != null) {
      paramJceOutputStream.write(this.IqC, 1);
    }
    if (this.IqD != null) {
      paramJceOutputStream.write(this.IqD, 2);
    }
    if (this.IqE != null) {
      paramJceOutputStream.write(this.IqE, 3);
    }
    if (this.IqF != 0L) {
      paramJceOutputStream.write(this.IqF, 4);
    }
    if (this.IqG != null) {
      paramJceOutputStream.write(this.IqG, 5);
    }
    if (this.IqH != 0) {
      paramJceOutputStream.write(this.IqH, 6);
    }
    if (this.IqI != null) {
      paramJceOutputStream.write(this.IqI, 7);
    }
    if (this.IqJ != 0) {
      paramJceOutputStream.write(this.IqJ, 8);
    }
    if (this.IqK != null) {
      paramJceOutputStream.write(this.IqK, 9);
    }
    paramJceOutputStream.write(this.IqL, 10);
    if (this.IqM != 0) {
      paramJceOutputStream.write(this.IqM, 11);
    }
    if (this.IqN != 0) {
      paramJceOutputStream.write(this.IqN, 12);
    }
    if (this.IqO != null) {
      paramJceOutputStream.write(this.IqO, 13);
    }
    if (this.IqP != 0) {
      paramJceOutputStream.write(this.IqP, 14);
    }
    paramJceOutputStream.write(this.IqQ, 15);
    if (this.IqR != 0) {
      paramJceOutputStream.write(this.IqR, 16);
    }
    paramJceOutputStream.write(this.IqS, 17);
    if (this.IqT != null) {
      paramJceOutputStream.write(this.IqT, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.c.b.b
 * JD-Core Version:    0.7.0.1
 */