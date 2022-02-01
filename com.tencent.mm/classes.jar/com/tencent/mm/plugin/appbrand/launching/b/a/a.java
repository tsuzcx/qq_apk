package com.tencent.mm.plugin.appbrand.launching.b.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.List;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void Kq(String paramString);
  
  public abstract void bw(List<Pair<a, String>> paramList);
  
  public abstract void dx(String paramString1, String paramString2);
  
  public abstract e<List<a>> dy(String paramString1, String paramString2);
  
  public static final class a
    extends cbx
  {
    public String kNB;
    public String kNC;
    public long kND;
    
    public final void ay(byte[] paramArrayOfByte)
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
    
    public final byte[] bhd()
    {
      AppMethodBeat.i(153225);
      byte[] arrayOfByte = super.toByteArray();
      AppMethodBeat.o(153225);
      return arrayOfByte;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(153227);
      String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.kNB + '\'' + ", packageURL='" + this.kNC + '\'' + ", urlLifespan=" + this.kND + ", appId='" + this.appId + '\'' + ", packageKey='" + this.DYi + '\'' + ", packageType=" + this.deP + ", packageVersion=" + this.DYj + '}';
      AppMethodBeat.o(153227);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.b.a.a
 * JD-Core Version:    0.7.0.1
 */