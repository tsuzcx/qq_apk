package com.tencent.mm.plugin.appbrand.launching.b.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract e<List<a>> a(String paramString1, String paramString2, z paramz);
  
  public abstract void a(String paramString, androidx.a.a.c.a<WxaAttributes, Void> parama);
  
  public abstract void bN(List<Pair<a, String>> paramList);
  
  public abstract void ey(String paramString1, String paramString2);
  
  public static final class a
    extends dnv
  {
    public String pYB;
    public String pYC;
    public long pYD;
    
    public final void ba(byte[] paramArrayOfByte)
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
    
    public final byte[] car()
    {
      AppMethodBeat.i(153225);
      byte[] arrayOfByte = super.toByteArray();
      AppMethodBeat.o(153225);
      return arrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153227);
      String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.pYB + '\'' + ", packageURL='" + this.pYC + '\'' + ", urlLifespan=" + this.pYD + ", appId='" + this.appId + '\'' + ", packageKey='" + this.TVc + '\'' + ", packageType=" + this.fyH + ", packageVersion=" + this.TVd + '}';
      AppMethodBeat.o(153227);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.a
 * JD-Core Version:    0.7.0.1
 */