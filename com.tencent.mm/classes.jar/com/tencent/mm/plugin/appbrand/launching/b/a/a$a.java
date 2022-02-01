package com.tencent.mm.plugin.appbrand.launching.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cly;
import java.io.IOException;

public final class a$a
  extends cly
{
  public String lMs;
  public String lMt;
  public long lMu;
  
  public final void ax(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(153226);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = new IOException("Invalid bytes");
      AppMethodBeat.o(153226);
      throw paramArrayOfByte;
    }
    super.parseFrom(paramArrayOfByte);
    AppMethodBeat.o(153226);
  }
  
  public final byte[] brQ()
  {
    AppMethodBeat.i(153225);
    byte[] arrayOfByte = super.toByteArray();
    AppMethodBeat.o(153225);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153227);
    String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.lMs + '\'' + ", packageURL='" + this.lMt + '\'' + ", urlLifespan=" + this.lMu + ", appId='" + this.appId + '\'' + ", packageKey='" + this.Hfh + '\'' + ", packageType=" + this.dnF + ", packageVersion=" + this.Hfi + '}';
    AppMethodBeat.o(153227);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */