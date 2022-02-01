package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.y;
import com.tencent.mm.plugin.appbrand.ae.b.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class b
  extends y
  implements com.tencent.mm.plugin.appbrand.ae.b
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  static final String[] qDJ;
  
  static
  {
    AppMethodBeat.i(44430);
    qDJ = new String[] { "appId", "version", "packageType", "packageKey" };
    nVV = y.aJm();
    StringBuilder localStringBuilder = new StringBuilder();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = nVV;
    localMAutoDBInfo.sql += b.a.s(qDJ);
    AppMethodBeat.o(44430);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String[] getKeys()
  {
    return qDJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d.b
 * JD-Core Version:    0.7.0.1
 */