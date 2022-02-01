package b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  static byte[] cache_sBuffer;
  public String UoK = "";
  public int Vh = 0;
  public byte aamK = 0;
  public String aamL = "";
  public byte aamM = 0;
  public String aamN = "";
  public String aamO = "";
  public String aamP = "";
  public String aamQ = "";
  public byte aamR = 0;
  public byte aamS = 0;
  public String fIY = "";
  public String productId = "";
  public String qua = "";
  public String reserved = "";
  public byte[] sBuffer = null;
  public String sdkId = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(207536);
    this.aamM = paramJceInputStream.read(this.aamM, 0, true);
    this.productId = paramJceInputStream.readString(1, true);
    this.aamO = paramJceInputStream.readString(2, true);
    this.sdkId = paramJceInputStream.readString(3, true);
    this.aamQ = paramJceInputStream.readString(4, true);
    this.Vh = paramJceInputStream.read(this.Vh, 5, true);
    if (cache_sBuffer == null)
    {
      byte[] arrayOfByte = new byte[1];
      cache_sBuffer = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.sBuffer = paramJceInputStream.read(cache_sBuffer, 6, true);
    this.aamL = paramJceInputStream.readString(7, false);
    this.qua = paramJceInputStream.readString(8, false);
    this.aamK = paramJceInputStream.read(this.aamK, 9, false);
    this.aamS = paramJceInputStream.read(this.aamS, 10, false);
    this.aamN = paramJceInputStream.readString(11, false);
    this.reserved = paramJceInputStream.readString(12, false);
    this.UoK = paramJceInputStream.readString(13, false);
    this.aamR = paramJceInputStream.read(this.aamR, 14, false);
    this.aamP = paramJceInputStream.readString(15, false);
    this.fIY = paramJceInputStream.readString(16, false);
    AppMethodBeat.o(207536);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(207535);
    paramJceOutputStream.write(this.aamM, 0);
    paramJceOutputStream.write(this.productId, 1);
    paramJceOutputStream.write(this.aamO, 2);
    paramJceOutputStream.write(this.sdkId, 3);
    paramJceOutputStream.write(this.aamQ, 4);
    paramJceOutputStream.write(this.Vh, 5);
    paramJceOutputStream.write(this.sBuffer, 6);
    if (this.aamL != null) {
      paramJceOutputStream.write(this.aamL, 7);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 8);
    }
    paramJceOutputStream.write(this.aamK, 9);
    paramJceOutputStream.write(this.aamS, 10);
    if (this.aamN != null) {
      paramJceOutputStream.write(this.aamN, 11);
    }
    if (this.reserved != null) {
      paramJceOutputStream.write(this.reserved, 12);
    }
    if (this.UoK != null) {
      paramJceOutputStream.write(this.UoK, 13);
    }
    paramJceOutputStream.write(this.aamR, 14);
    if (this.aamP != null) {
      paramJceOutputStream.write(this.aamP, 15);
    }
    if (this.fIY != null) {
      paramJceOutputStream.write(this.fIY, 16);
    }
    AppMethodBeat.o(207535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.7.0.1
 */