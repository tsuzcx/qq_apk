package com.tencent.mm.plugin.lite.storage;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class h
  extends c
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(271313);
    info = aJm();
    AppMethodBeat.o(271313);
  }
  
  public final WxaLiteAppInfo fUr()
  {
    AppMethodBeat.i(271325);
    WxaLiteAppInfo localWxaLiteAppInfo = new WxaLiteAppInfo();
    localWxaLiteAppInfo.appId = this.field_appId;
    localWxaLiteAppInfo.path = this.field_pkgPath;
    localWxaLiteAppInfo.egI = this.field_signatureKey;
    localWxaLiteAppInfo.egK = this.field_updateTime;
    localWxaLiteAppInfo.egJ = this.field_patchId;
    localWxaLiteAppInfo.url = this.field_url;
    localWxaLiteAppInfo.md5 = this.field_md5;
    localWxaLiteAppInfo.egL = this.field_lastUseTime;
    localWxaLiteAppInfo.groupId = this.field_groupId;
    localWxaLiteAppInfo.type = this.field_pkgType;
    AppMethodBeat.o(271325);
    return localWxaLiteAppInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.h
 * JD-Core Version:    0.7.0.1
 */