package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class CSFileUpdateReq
  extends MapJceStruct
{
  static ArrayList<FileUpdateReq> a;
  public String sAppId = "";
  public String sCity = "";
  public String sEngineVersion = "";
  public String sId = "";
  public String sSDKVersion = "";
  public ArrayList<FileUpdateReq> vItems = null;
  
  static
  {
    AppMethodBeat.i(221216);
    a = new ArrayList();
    FileUpdateReq localFileUpdateReq = new FileUpdateReq();
    a.add(localFileUpdateReq);
    AppMethodBeat.o(221216);
  }
  
  public CSFileUpdateReq() {}
  
  public CSFileUpdateReq(ArrayList<FileUpdateReq> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.vItems = paramArrayList;
    this.sAppId = paramString1;
    this.sSDKVersion = paramString2;
    this.sCity = paramString3;
    this.sEngineVersion = paramString4;
    this.sId = paramString5;
  }
  
  public final String className()
  {
    return "MapConfProtocol.CSFileUpdateReq";
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221233);
    this.vItems = ((ArrayList)paramm.a(a, 0, true));
    this.sAppId = paramm.b(1, false);
    this.sSDKVersion = paramm.b(2, false);
    this.sCity = paramm.b(3, false);
    this.sEngineVersion = paramm.b(4, false);
    this.sId = paramm.b(5, false);
    AppMethodBeat.o(221233);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221244);
    Object localObject = new StringBuffer("CSFileUpdateReq{");
    ((StringBuffer)localObject).append("vItems=").append(this.vItems);
    ((StringBuffer)localObject).append(", sAppId='").append(this.sAppId).append('\'');
    ((StringBuffer)localObject).append(", sSDKVersion='").append(this.sSDKVersion).append('\'');
    ((StringBuffer)localObject).append(", sCity='").append(this.sCity).append('\'');
    ((StringBuffer)localObject).append(", sEngineVersion='").append(this.sEngineVersion).append('\'');
    ((StringBuffer)localObject).append(", sId='").append(this.sId).append('\'');
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221244);
    return localObject;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221226);
    paramn.a(this.vItems, 0);
    if (this.sAppId != null) {
      paramn.a(this.sAppId, 1);
    }
    if (this.sSDKVersion != null) {
      paramn.a(this.sSDKVersion, 2);
    }
    if (this.sCity != null) {
      paramn.a(this.sCity, 3);
    }
    if (this.sEngineVersion != null) {
      paramn.a(this.sEngineVersion, 4);
    }
    if (this.sId != null) {
      paramn.a(this.sId, 5);
    }
    AppMethodBeat.o(221226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq
 * JD-Core Version:    0.7.0.1
 */