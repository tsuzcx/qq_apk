package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.g.a.b.h;

public class e
  extends a
{
  static final String TAG;
  public static final String vxc;
  public static final String vxd;
  public static final String vxe;
  public static final String vxf;
  public byte vxg;
  public byte vxh;
  public byte vxi;
  public byte vxj;
  public byte[] vxk;
  public int vxl;
  public byte vxm;
  public byte vxn;
  public byte[] vxo;
  
  static
  {
    AppMethodBeat.i(22582);
    TAG = e.class.getName();
    vxc = h.vvX;
    vxd = h.vvY;
    vxe = h.vvZ;
    vxf = h.vwa;
    AppMethodBeat.o(22582);
  }
  
  public e()
  {
    AppMethodBeat.i(22580);
    this.vwn = null;
    this.vwo = 8;
    this.vvH = 16L;
    this.vxg = 0;
    this.vxh = 0;
    this.vxi = 0;
    this.vxj = 0;
    this.vxk = new byte[] { 0, 0 };
    this.vxl = -1;
    this.vxm = 0;
    this.vxn = 0;
    this.vxo = null;
    AppMethodBeat.o(22580);
  }
  
  public final byte[] daY()
  {
    AppMethodBeat.i(22581);
    byte[] arrayOfByte;
    if (this.vwn.equalsIgnoreCase(vxc))
    {
      arrayOfByte = new byte[3];
      System.arraycopy(Byte.valueOf(this.vxg), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(this.vxh), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.vxi), 0, arrayOfByte, 2, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.vwn.equalsIgnoreCase(vxd))
    {
      arrayOfByte = new byte[1];
      System.arraycopy(Byte.valueOf(this.vxj), 0, arrayOfByte, 0, 1);
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    if (this.vwn.equalsIgnoreCase(vxf))
    {
      arrayOfByte = new byte[this.vxl];
      byte b1 = (byte)(this.vxl & 0xFF);
      byte b2 = (byte)(this.vxl >> 8 & 0xFF);
      System.arraycopy(Byte.valueOf(b1), 0, arrayOfByte, 0, 1);
      System.arraycopy(Byte.valueOf(b2), 0, arrayOfByte, 1, 1);
      System.arraycopy(Byte.valueOf(this.vxm), 0, arrayOfByte, 2, 1);
      if (this.vxl > 3) {
        System.arraycopy(this.vxo, 0, arrayOfByte, 3, this.vxl - 3);
      }
      AppMethodBeat.o(22581);
      return arrayOfByte;
    }
    AppMethodBeat.o(22581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */