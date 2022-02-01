package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FileUpdateRsp
  extends MapJceStruct
{
  public int iFileSize = 0;
  public int iFileUpdated = 0;
  public int iRet = 0;
  public int iVersion = 0;
  public String sMd5 = "";
  public String sName = "";
  public String sUpdateUrl = "";
  
  public FileUpdateRsp() {}
  
  public FileUpdateRsp(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
  {
    this.sName = paramString1;
    this.iRet = paramInt1;
    this.iVersion = paramInt2;
    this.iFileUpdated = paramInt3;
    this.sUpdateUrl = paramString2;
    this.sMd5 = paramString3;
    this.iFileSize = paramInt4;
  }
  
  public final String className()
  {
    return "MapConfProtocol.FileUpdateRsp";
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221250);
    this.sName = paramm.b(0, true);
    this.iRet = paramm.a(this.iRet, 1, true);
    this.iVersion = paramm.a(this.iVersion, 2, true);
    this.iFileUpdated = paramm.a(this.iFileUpdated, 3, false);
    this.sUpdateUrl = paramm.b(4, false);
    this.sMd5 = paramm.b(5, false);
    this.iFileSize = paramm.a(this.iFileSize, 6, false);
    AppMethodBeat.o(221250);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221261);
    Object localObject = new StringBuffer("FileUpdateRsp{");
    ((StringBuffer)localObject).append("sName='").append(this.sName).append('\'');
    ((StringBuffer)localObject).append(", iRet=").append(this.iRet);
    ((StringBuffer)localObject).append(", iVersion=").append(this.iVersion);
    ((StringBuffer)localObject).append(", iFileUpdated=").append(this.iFileUpdated);
    ((StringBuffer)localObject).append(", sUpdateUrl='").append(this.sUpdateUrl).append('\'');
    ((StringBuffer)localObject).append(", sMd5='").append(this.sMd5).append('\'');
    ((StringBuffer)localObject).append(", iFileSize=").append(this.iFileSize);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221261);
    return localObject;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221241);
    paramn.a(this.sName, 0);
    paramn.a(this.iRet, 1);
    paramn.a(this.iVersion, 2);
    paramn.a(this.iFileUpdated, 3);
    if (this.sUpdateUrl != null) {
      paramn.a(this.sUpdateUrl, 4);
    }
    if (this.sMd5 != null) {
      paramn.a(this.sMd5, 5);
    }
    paramn.a(this.iFileSize, 6);
    AppMethodBeat.o(221241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp
 * JD-Core Version:    0.7.0.1
 */