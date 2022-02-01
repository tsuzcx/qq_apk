package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gm;
import com.tencent.mm.plugin.appbrand.ae.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends gm
  implements b
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  static final String[] qDJ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44437);
    qDJ = new String[] { "appId", "type", "version", "packageKey", "packageType" };
    nVV = aJm();
    String str = " PRIMARY KEY ( ";
    Object localObject1 = qDJ;
    int j = localObject1.length;
    while (i < j)
    {
      localObject2 = localObject1[i];
      str = str + ", " + (String)localObject2;
      i += 1;
    }
    str = str.replaceFirst(",", "");
    str = str + " )";
    localObject1 = new StringBuilder();
    Object localObject2 = nVV;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(44437);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String[] getKeys()
  {
    return qDJ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320451);
    String str = "CmdGetCodePersistentInfo{field_appId='" + this.field_appId + '\'' + ", field_version=" + this.field_version + ", field_type=" + this.field_type + ", field_retryTimes=" + this.field_retryTimes + ", field_retriedCount=" + this.field_retriedCount + ", field_retryInterval=" + this.field_retryInterval + ", field_networkType=" + this.field_networkType + ", field_pkgMd5='" + this.field_pkgMd5 + '\'' + ", field_packageKey='" + this.field_packageKey + '\'' + ", field_packageType=" + this.field_packageType + ", field_lastRetryTime=" + this.field_lastRetryTime + ", field_firstTimeTried=" + this.field_firstTimeTried + ", field_reportId=" + this.field_reportId + ", field_splitDownloadURLCgi=" + this.field_splitDownloadURLCgi + ", field_scene=" + this.field_scene + ", field_cmdSequence=" + this.field_cmdSequence + '}';
    AppMethodBeat.o(320451);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.c
 * JD-Core Version:    0.7.0.1
 */