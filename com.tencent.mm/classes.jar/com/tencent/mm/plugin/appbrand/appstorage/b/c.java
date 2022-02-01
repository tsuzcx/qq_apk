package com.tencent.mm.plugin.appbrand.appstorage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ji;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/security/InfoRecord;", "Lcom/tencent/mm/autogen/table/BaseWxaSecurityStorageInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends ji
{
  private static final IAutoDBItem.MAutoDBInfo nVV;
  private static final String[] nVW;
  public static final c.a qOh;
  
  static
  {
    AppMethodBeat.i(323217);
    qOh = new c.a((byte)0);
    Object localObject = ji.aJm();
    s.s(localObject, "initAutoDBInfo(InfoRecord::class.java)");
    nVV = (IAutoDBItem.MAutoDBInfo)localObject;
    localObject = MAutoStorage.getCreateSQLs(nVV, "WxaSecurityStorageInfo");
    s.s(localObject, "getCreateSQLs(INFO, TABLE_NAME)");
    nVW = new String[] { localObject };
    AppMethodBeat.o(323217);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.c
 * JD-Core Version:    0.7.0.1
 */