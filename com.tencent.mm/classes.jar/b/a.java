package b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  static byte[] cache_sBuffer;
  public int EX = 0;
  public String Nco = "";
  public byte SKQ = 0;
  public String SKR = "";
  public byte SKS = 0;
  public String SKT = "";
  public String SKU = "";
  public String SKV = "";
  public byte SKW = 0;
  public byte SKX = 0;
  public String dPI = "";
  public String dfy = "";
  public String productId = "";
  public String qua = "";
  public String reserved = "";
  public byte[] sBuffer = null;
  public String sdkId = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(214831);
    this.SKS = paramJceInputStream.read(this.SKS, 0, true);
    this.productId = paramJceInputStream.readString(1, true);
    this.SKU = paramJceInputStream.readString(2, true);
    this.sdkId = paramJceInputStream.readString(3, true);
    this.dfy = paramJceInputStream.readString(4, true);
    this.EX = paramJceInputStream.read(this.EX, 5, true);
    if (cache_sBuffer == null)
    {
      byte[] arrayOfByte = new byte[1];
      cache_sBuffer = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.sBuffer = paramJceInputStream.read(cache_sBuffer, 6, true);
    this.SKR = paramJceInputStream.readString(7, false);
    this.qua = paramJceInputStream.readString(8, false);
    this.SKQ = paramJceInputStream.read(this.SKQ, 9, false);
    this.SKX = paramJceInputStream.read(this.SKX, 10, false);
    this.SKT = paramJceInputStream.readString(11, false);
    this.reserved = paramJceInputStream.readString(12, false);
    this.Nco = paramJceInputStream.readString(13, false);
    this.SKW = paramJceInputStream.read(this.SKW, 14, false);
    this.SKV = paramJceInputStream.readString(15, false);
    this.dPI = paramJceInputStream.readString(16, false);
    AppMethodBeat.o(214831);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(214830);
    paramJceOutputStream.write(this.SKS, 0);
    paramJceOutputStream.write(this.productId, 1);
    paramJceOutputStream.write(this.SKU, 2);
    paramJceOutputStream.write(this.sdkId, 3);
    paramJceOutputStream.write(this.dfy, 4);
    paramJceOutputStream.write(this.EX, 5);
    paramJceOutputStream.write(this.sBuffer, 6);
    if (this.SKR != null) {
      paramJceOutputStream.write(this.SKR, 7);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 8);
    }
    paramJceOutputStream.write(this.SKQ, 9);
    paramJceOutputStream.write(this.SKX, 10);
    if (this.SKT != null) {
      paramJceOutputStream.write(this.SKT, 11);
    }
    if (this.reserved != null) {
      paramJceOutputStream.write(this.reserved, 12);
    }
    if (this.Nco != null) {
      paramJceOutputStream.write(this.Nco, 13);
    }
    paramJceOutputStream.write(this.SKW, 14);
    if (this.SKV != null) {
      paramJceOutputStream.write(this.SKV, 15);
    }
    if (this.dPI != null) {
      paramJceOutputStream.write(this.dPI, 16);
    }
    AppMethodBeat.o(214830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.7.0.1
 */