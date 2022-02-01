package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FileUpdateReq
  extends MapJceStruct
{
  public int iVersion = 0;
  public String sMd5 = "";
  public String sName = "";
  
  public FileUpdateReq() {}
  
  public FileUpdateReq(String paramString1, int paramInt, String paramString2)
  {
    this.sName = paramString1;
    this.iVersion = paramInt;
    this.sMd5 = paramString2;
  }
  
  public final String className()
  {
    return "MapConfProtocol.FileUpdateReq";
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221235);
    this.sName = paramm.b(0, true);
    this.iVersion = paramm.a(this.iVersion, 1, true);
    this.sMd5 = paramm.b(2, false);
    AppMethodBeat.o(221235);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221246);
    Object localObject = new StringBuffer("FileUpdateReq{");
    ((StringBuffer)localObject).append("sName='").append(this.sName).append('\'');
    ((StringBuffer)localObject).append(", iVersion=").append(this.iVersion);
    ((StringBuffer)localObject).append(", sMd5='").append(this.sMd5).append('\'');
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221246);
    return localObject;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221227);
    paramn.a(this.sName, 0);
    paramn.a(this.iVersion, 1);
    if (this.sMd5 != null) {
      paramn.a(this.sMd5, 2);
    }
    AppMethodBeat.o(221227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq
 * JD-Core Version:    0.7.0.1
 */