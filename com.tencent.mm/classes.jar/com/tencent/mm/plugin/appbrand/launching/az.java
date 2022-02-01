package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class az
  extends j<ay>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(146072);
    hGX = new String[] { j.getCreateSQLs(ay.jJU, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public az(e parame)
  {
    super(parame, ay.jJU, "LaunchWxaAppPBTable", ay.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, bua parambua)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (parambua == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    ay localay = new ay();
    localay.field_appId = paramString;
    localay.field_launchPB = parambua;
    boolean bool = super.replace(localay);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.az
 * JD-Core Version:    0.7.0.1
 */