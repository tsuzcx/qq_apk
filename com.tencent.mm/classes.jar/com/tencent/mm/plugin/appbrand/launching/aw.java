package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class aw
  extends j<av>
{
  public static final String[] gLs;
  
  static
  {
    AppMethodBeat.i(146072);
    gLs = new String[] { j.getCreateSQLs(av.iMP, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public aw(e parame)
  {
    super(parame, av.iMP, "LaunchWxaAppPBTable", av.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, bkx parambkx)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (parambkx == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    av localav = new av();
    localav.field_appId = paramString;
    localav.field_launchPB = parambkx;
    boolean bool = super.replace(localav);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */