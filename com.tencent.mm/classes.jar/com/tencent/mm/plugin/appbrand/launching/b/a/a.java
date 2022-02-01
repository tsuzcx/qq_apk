package com.tencent.mm.plugin.appbrand.launching.b.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract e<List<a>> a(String paramString1, String paramString2, ab paramab);
  
  public abstract void a(String paramString, androidx.a.a.c.a<WxaAttributes, Void> parama);
  
  public abstract void dz(List<Pair<a, String>> paramList);
  
  public abstract void eP(String paramString1, String paramString2);
  
  public static final class a
    extends egm
  {
    public String tdo;
    public String tdp;
    public long tdq;
    
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
    
    public final byte[] cAH()
    {
      AppMethodBeat.i(153225);
      byte[] arrayOfByte = super.toByteArray();
      AppMethodBeat.o(153225);
      return arrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153227);
      String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.tdo + '\'' + ", packageURL='" + this.tdp + '\'' + ", urlLifespan=" + this.tdq + ", appId='" + this.appId + '\'' + ", packageKey='" + this.ablN + '\'' + ", packageType=" + this.hDq + ", packageVersion=" + this.ablO + '}';
      AppMethodBeat.o(153227);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.a
 * JD-Core Version:    0.7.0.1
 */