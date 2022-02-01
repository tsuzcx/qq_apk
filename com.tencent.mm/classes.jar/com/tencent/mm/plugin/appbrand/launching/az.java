package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class az
  extends j<ay>
{
  public static final String[] hEf;
  
  static
  {
    AppMethodBeat.i(146072);
    hEf = new String[] { j.getCreateSQLs(ay.jGU, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public az(e parame)
  {
    super(parame, ay.jGU, "LaunchWxaAppPBTable", ay.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, btg parambtg)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (parambtg == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    ay localay = new ay();
    localay.field_appId = paramString;
    localay.field_launchPB = parambtg;
    boolean bool = super.replace(localay);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */