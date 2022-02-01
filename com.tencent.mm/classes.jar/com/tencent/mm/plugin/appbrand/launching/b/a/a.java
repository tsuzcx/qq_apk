package com.tencent.mm.plugin.appbrand.launching.b.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract e<List<a>> a(String paramString1, String paramString2, z paramz);
  
  public abstract void a(String paramString, android.arch.a.c.a<WxaAttributes, Void> parama);
  
  public abstract void bO(List<Pair<a, String>> paramList);
  
  public abstract void ek(String paramString1, String paramString2);
  
  public static final class a
    extends def
  {
    public String mYc;
    public String mYd;
    public long mYe;
    
    public final void aO(byte[] paramArrayOfByte)
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
    
    public final byte[] bNX()
    {
      AppMethodBeat.i(153225);
      byte[] arrayOfByte = super.toByteArray();
      AppMethodBeat.o(153225);
      return arrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153227);
      String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.mYc + '\'' + ", packageURL='" + this.mYd + '\'' + ", urlLifespan=" + this.mYe + ", appId='" + this.appId + '\'' + ", packageKey='" + this.MJn + '\'' + ", packageType=" + this.packageType + ", packageVersion=" + this.MJo + '}';
      AppMethodBeat.o(153227);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.a
 * JD-Core Version:    0.7.0.1
 */