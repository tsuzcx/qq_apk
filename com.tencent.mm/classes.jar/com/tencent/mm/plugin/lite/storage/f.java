package com.tencent.mm.plugin.lite.storage;

import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends b
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(271309);
    info = aJm();
    AppMethodBeat.o(271309);
  }
  
  public final WxaLiteAppBaselibInfo fUo()
  {
    AppMethodBeat.i(271323);
    WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = new WxaLiteAppBaselibInfo();
    localWxaLiteAppBaselibInfo.egH = this.field_majorVersion;
    localWxaLiteAppBaselibInfo.path = this.field_pkgPath;
    localWxaLiteAppBaselibInfo.egI = this.field_signatureKey;
    localWxaLiteAppBaselibInfo.egK = this.field_updateTime;
    localWxaLiteAppBaselibInfo.egJ = this.field_patchId;
    localWxaLiteAppBaselibInfo.url = this.field_url;
    localWxaLiteAppBaselibInfo.md5 = this.field_md5;
    localWxaLiteAppBaselibInfo.egL = this.field_lastUseTime;
    localWxaLiteAppBaselibInfo.type = this.field_pkgType;
    AppMethodBeat.o(271323);
    return localWxaLiteAppBaselibInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.f
 * JD-Core Version:    0.7.0.1
 */