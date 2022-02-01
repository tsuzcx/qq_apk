package b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends JceStruct
{
  static byte[] cache_sBuffer;
  public String abHs = "";
  public byte aisZ = 0;
  public String aita = "";
  public byte aitb = 0;
  public String aitc = "";
  public String aitd = "";
  public String aite = "";
  public String aitf = "";
  public byte aitg = 0;
  public byte aith = 0;
  public int bUl = 0;
  public String hOG = "";
  public String productId = "";
  public String qua = "";
  public String reserved = "";
  public byte[] sBuffer = null;
  public String sdkId = "";
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(186221);
    this.aitb = paramJceInputStream.read(this.aitb, 0, true);
    this.productId = paramJceInputStream.readString(1, true);
    this.aitd = paramJceInputStream.readString(2, true);
    this.sdkId = paramJceInputStream.readString(3, true);
    this.aitf = paramJceInputStream.readString(4, true);
    this.bUl = paramJceInputStream.read(this.bUl, 5, true);
    if (cache_sBuffer == null)
    {
      byte[] arrayOfByte = new byte[1];
      cache_sBuffer = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.sBuffer = paramJceInputStream.read(cache_sBuffer, 6, true);
    this.aita = paramJceInputStream.readString(7, false);
    this.qua = paramJceInputStream.readString(8, false);
    this.aisZ = paramJceInputStream.read(this.aisZ, 9, false);
    this.aith = paramJceInputStream.read(this.aith, 10, false);
    this.aitc = paramJceInputStream.readString(11, false);
    this.reserved = paramJceInputStream.readString(12, false);
    this.abHs = paramJceInputStream.readString(13, false);
    this.aitg = paramJceInputStream.read(this.aitg, 14, false);
    this.aite = paramJceInputStream.readString(15, false);
    this.hOG = paramJceInputStream.readString(16, false);
    AppMethodBeat.o(186221);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(186217);
    paramJceOutputStream.write(this.aitb, 0);
    paramJceOutputStream.write(this.productId, 1);
    paramJceOutputStream.write(this.aitd, 2);
    paramJceOutputStream.write(this.sdkId, 3);
    paramJceOutputStream.write(this.aitf, 4);
    paramJceOutputStream.write(this.bUl, 5);
    paramJceOutputStream.write(this.sBuffer, 6);
    if (this.aita != null) {
      paramJceOutputStream.write(this.aita, 7);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 8);
    }
    paramJceOutputStream.write(this.aisZ, 9);
    paramJceOutputStream.write(this.aith, 10);
    if (this.aitc != null) {
      paramJceOutputStream.write(this.aitc, 11);
    }
    if (this.reserved != null) {
      paramJceOutputStream.write(this.reserved, 12);
    }
    if (this.abHs != null) {
      paramJceOutputStream.write(this.abHs, 13);
    }
    paramJceOutputStream.write(this.aitg, 14);
    if (this.aite != null) {
      paramJceOutputStream.write(this.aite, 15);
    }
    if (this.hOG != null) {
      paramJceOutputStream.write(this.hOG, 16);
    }
    AppMethodBeat.o(186217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.7.0.1
 */