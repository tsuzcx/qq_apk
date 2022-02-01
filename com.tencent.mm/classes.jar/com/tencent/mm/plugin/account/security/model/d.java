package com.tencent.mm.plugin.account.security.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gw;
import com.tencent.mm.protocal.protobuf.dkb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class d
  extends gw
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(125520);
    info = gw.aJm();
    AppMethodBeat.o(125520);
  }
  
  public d()
  {
    this.field_uid = "0";
    this.field_name = "";
    this.field_devicetype = "";
    this.field_createtime = 0L;
  }
  
  public d(dkb paramdkb)
  {
    AppMethodBeat.i(125519);
    this.field_uid = paramdkb.uuid;
    this.field_devicetype = paramdkb.devicetype;
    this.field_name = paramdkb.devicename;
    this.field_createtime = paramdkb.aaPU;
    AppMethodBeat.o(125519);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.model.d
 * JD-Core Version:    0.7.0.1
 */