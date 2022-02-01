package com.tencent.mapsdk.core.components.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class SCFileUpdateRsp
  extends MapJceStruct
{
  static ArrayList<FileUpdateRsp> a;
  public int iRet = 0;
  public ArrayList<FileUpdateRsp> vItems = null;
  
  static
  {
    AppMethodBeat.i(221239);
    a = new ArrayList();
    FileUpdateRsp localFileUpdateRsp = new FileUpdateRsp();
    a.add(localFileUpdateRsp);
    AppMethodBeat.o(221239);
  }
  
  public SCFileUpdateRsp() {}
  
  public SCFileUpdateRsp(int paramInt, ArrayList<FileUpdateRsp> paramArrayList)
  {
    this.iRet = paramInt;
    this.vItems = paramArrayList;
  }
  
  public final String className()
  {
    return "MapConfProtocol.SCFileUpdateRsp";
  }
  
  public final void readFrom(m paramm)
  {
    AppMethodBeat.i(221274);
    this.iRet = paramm.a(this.iRet, 0, true);
    this.vItems = ((ArrayList)paramm.a(a, 1, false));
    AppMethodBeat.o(221274);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221282);
    Object localObject = new StringBuffer("SCFileUpdateRsp{");
    ((StringBuffer)localObject).append("iRet=").append(this.iRet);
    ((StringBuffer)localObject).append(", vItems=").append(this.vItems);
    ((StringBuffer)localObject).append('}');
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221282);
    return localObject;
  }
  
  public final void writeTo(n paramn)
  {
    AppMethodBeat.i(221266);
    paramn.a(this.iRet, 0);
    if (this.vItems != null) {
      paramn.a(this.vItems, 1);
    }
    AppMethodBeat.o(221266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp
 * JD-Core Version:    0.7.0.1
 */