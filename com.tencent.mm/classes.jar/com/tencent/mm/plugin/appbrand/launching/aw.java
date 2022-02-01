package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class aw
  extends j<av>
{
  public static final String[] hlS;
  
  static
  {
    AppMethodBeat.i(146072);
    hlS = new String[] { j.getCreateSQLs(av.jmW, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public aw(e parame)
  {
    super(parame, av.jmW, "LaunchWxaAppPBTable", av.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, bot parambot)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (parambot == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    av localav = new av();
    localav.field_appId = paramString;
    localav.field_launchPB = parambot;
    boolean bool = super.replace(localav);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */