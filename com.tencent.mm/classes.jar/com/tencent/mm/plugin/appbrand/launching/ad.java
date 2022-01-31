package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.e.j;

public class ad
  extends j<ac>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(94159);
    fkl = new String[] { j.getCreateSQLs(ac.gUb, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(94159);
  }
  
  public final boolean b(String paramString, azn paramazn)
  {
    AppMethodBeat.i(94158);
    if ((TextUtils.isEmpty(paramString)) || (paramazn == null))
    {
      AppMethodBeat.o(94158);
      return false;
    }
    ac localac = new ac();
    localac.field_appId = paramString;
    localac.field_launchPB = paramazn;
    boolean bool = super.replace(localac);
    AppMethodBeat.o(94158);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ad
 * JD-Core Version:    0.7.0.1
 */