package com.tencent.e.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static byte[] ahtk;
  static byte[] ahtl;
  static ArrayList<Integer> ahtm;
  static ArrayList<byte[]> ahtn;
  public int ahsR = 0;
  public byte[] ahsS = null;
  public String ahsT = "";
  public byte[] ahsU = null;
  public long ahsV = 0L;
  public String ahsW = "";
  public int ahsX = 0;
  public String ahsY = "";
  public int ahsZ = 0;
  public String ahta = "";
  public int ahtb = 0;
  public int ahtc = 0;
  public int ahtd = 0;
  public ArrayList<Integer> ahte = null;
  public int ahtf = 0;
  public boolean ahtg = false;
  public int ahth = 0;
  public int ahti = 0;
  public ArrayList<byte[]> ahtj = null;
  
  static
  {
    AppMethodBeat.i(138335);
    byte[] arrayOfByte = new byte[1];
    ahtk = arrayOfByte;
    arrayOfByte[0] = 0;
    arrayOfByte = new byte[1];
    ahtl = arrayOfByte;
    arrayOfByte[0] = 0;
    ahtm = new ArrayList();
    ahtm.add(Integer.valueOf(0));
    ahtn = new ArrayList();
    ahtn.add(new byte[] { 0 });
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
    this.ahsR = paramJceInputStream.read(this.ahsR, 0, true);
    this.ahsS = paramJceInputStream.read(ahtk, 1, false);
    this.ahsT = paramJceInputStream.readString(2, false);
    this.ahsU = paramJceInputStream.read(ahtl, 3, false);
    this.ahsV = paramJceInputStream.read(this.ahsV, 4, false);
    this.ahsW = paramJceInputStream.readString(5, false);
    this.ahsX = paramJceInputStream.read(this.ahsX, 6, false);
    this.ahsY = paramJceInputStream.readString(7, false);
    this.ahsZ = paramJceInputStream.read(this.ahsZ, 8, false);
    this.ahta = paramJceInputStream.readString(9, false);
    this.ahtb = paramJceInputStream.read(this.ahtb, 10, false);
    this.ahtc = paramJceInputStream.read(this.ahtc, 11, false);
    this.ahtd = paramJceInputStream.read(this.ahtd, 12, false);
    this.ahte = ((ArrayList)paramJceInputStream.read(ahtm, 13, false));
    this.ahtf = paramJceInputStream.read(this.ahtf, 14, false);
    this.ahtg = paramJceInputStream.read(this.ahtg, 15, false);
    this.ahth = paramJceInputStream.read(this.ahth, 16, false);
    this.ahti = paramJceInputStream.read(this.ahti, 17, false);
    this.ahtj = ((ArrayList)paramJceInputStream.read(ahtn, 18, false));
    AppMethodBeat.o(138334);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(138333);
    paramJceOutputStream.write(this.ahsR, 0);
    if (this.ahsS != null) {
      paramJceOutputStream.write(this.ahsS, 1);
    }
    if (this.ahsT != null) {
      paramJceOutputStream.write(this.ahsT, 2);
    }
    if (this.ahsU != null) {
      paramJceOutputStream.write(this.ahsU, 3);
    }
    if (this.ahsV != 0L) {
      paramJceOutputStream.write(this.ahsV, 4);
    }
    if (this.ahsW != null) {
      paramJceOutputStream.write(this.ahsW, 5);
    }
    if (this.ahsX != 0) {
      paramJceOutputStream.write(this.ahsX, 6);
    }
    if (this.ahsY != null) {
      paramJceOutputStream.write(this.ahsY, 7);
    }
    if (this.ahsZ != 0) {
      paramJceOutputStream.write(this.ahsZ, 8);
    }
    if (this.ahta != null) {
      paramJceOutputStream.write(this.ahta, 9);
    }
    paramJceOutputStream.write(this.ahtb, 10);
    if (this.ahtc != 0) {
      paramJceOutputStream.write(this.ahtc, 11);
    }
    if (this.ahtd != 0) {
      paramJceOutputStream.write(this.ahtd, 12);
    }
    if (this.ahte != null) {
      paramJceOutputStream.write(this.ahte, 13);
    }
    if (this.ahtf != 0) {
      paramJceOutputStream.write(this.ahtf, 14);
    }
    paramJceOutputStream.write(this.ahtg, 15);
    if (this.ahth != 0) {
      paramJceOutputStream.write(this.ahth, 16);
    }
    paramJceOutputStream.write(this.ahti, 17);
    if (this.ahtj != null) {
      paramJceOutputStream.write(this.ahtj, 18);
    }
    AppMethodBeat.o(138333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.c.b.b
 * JD-Core Version:    0.7.0.1
 */