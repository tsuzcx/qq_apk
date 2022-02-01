package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] RLV;
  static byte[] RLW;
  static ArrayList<Integer> RLX;
  static ArrayList<byte[]> RLY;
  public int RLC = 0;
  public byte[] RLD = null;
  public String RLE = "";
  public byte[] RLF = null;
  public long RLG = 0L;
  public String RLH = "";
  public int RLI = 0;
  public String RLJ = "";
  public int RLK = 0;
  public String RLL = "";
  public int RLM = 0;
  public int RLN = 0;
  public int RLO = 0;
  public ArrayList<Integer> RLP = null;
  public int RLQ = 0;
  public boolean RLR = false;
  public int RLS = 0;
  public int RLT = 0;
  public ArrayList<byte[]> RLU = null;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = (byte[])new byte[1];
    RLV = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    RLW = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    RLX = new ArrayList();
    RLX.add(Integer.valueOf(0));
    RLY = new ArrayList();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    RLY.add(arrayOfByte);
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
    this.RLC = paramJceInputStream.read(this.RLC, 0, true);
    this.RLD = ((byte[])paramJceInputStream.read(RLV, 1, false));
    this.RLE = paramJceInputStream.readString(2, false);
    this.RLF = ((byte[])paramJceInputStream.read(RLW, 3, false));
    this.RLG = paramJceInputStream.read(this.RLG, 4, false);
    this.RLH = paramJceInputStream.readString(5, false);
    this.RLI = paramJceInputStream.read(this.RLI, 6, false);
    this.RLJ = paramJceInputStream.readString(7, false);
    this.RLK = paramJceInputStream.read(this.RLK, 8, false);
    this.RLL = paramJceInputStream.readString(9, false);
    this.RLM = paramJceInputStream.read(this.RLM, 10, false);
    this.RLN = paramJceInputStream.read(this.RLN, 11, false);
    this.RLO = paramJceInputStream.read(this.RLO, 12, false);
    this.RLP = ((ArrayList)paramJceInputStream.read(RLX, 13, false));
    this.RLQ = paramJceInputStream.read(this.RLQ, 14, false);
    this.RLR = paramJceInputStream.read(this.RLR, 15, false);
    this.RLS = paramJceInputStream.read(this.RLS, 16, false);
    this.RLT = paramJceInputStream.read(this.RLT, 17, false);
    this.RLU = ((ArrayList)paramJceInputStream.read(RLY, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.RLC, 0);
    if (this.RLD != null) {
      paramJceOutputStream.write(this.RLD, 1);
    }
    if (this.RLE != null) {
      paramJceOutputStream.write(this.RLE, 2);
    }
    if (this.RLF != null) {
      paramJceOutputStream.write(this.RLF, 3);
    }
    if (this.RLG != 0L) {
      paramJceOutputStream.write(this.RLG, 4);
    }
    if (this.RLH != null) {
      paramJceOutputStream.write(this.RLH, 5);
    }
    if (this.RLI != 0) {
      paramJceOutputStream.write(this.RLI, 6);
    }
    if (this.RLJ != null) {
      paramJceOutputStream.write(this.RLJ, 7);
    }
    if (this.RLK != 0) {
      paramJceOutputStream.write(this.RLK, 8);
    }
    if (this.RLL != null) {
      paramJceOutputStream.write(this.RLL, 9);
    }
    paramJceOutputStream.write(this.RLM, 10);
    if (this.RLN != 0) {
      paramJceOutputStream.write(this.RLN, 11);
    }
    if (this.RLO != 0) {
      paramJceOutputStream.write(this.RLO, 12);
    }
    if (this.RLP != null) {
      paramJceOutputStream.write(this.RLP, 13);
    }
    if (this.RLQ != 0) {
      paramJceOutputStream.write(this.RLQ, 14);
    }
    paramJceOutputStream.write(this.RLR, 15);
    if (this.RLS != 0) {
      paramJceOutputStream.write(this.RLS, 16);
    }
    paramJceOutputStream.write(this.RLT, 17);
    if (this.RLU != null) {
      paramJceOutputStream.write(this.RLU, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.c.b.b
 * JD-Core Version:    0.7.0.1
 */