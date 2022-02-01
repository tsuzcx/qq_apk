package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class ar
  extends MAutoStorage<aq>
{
  public static final String[] iBh;
  
  static
  {
    AppMethodBeat.i(146072);
    iBh = new String[] { MAutoStorage.getCreateSQLs(aq.kLR, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public ar(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, aq.kLR, "LaunchWxaAppPBTable", aq.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, che paramche)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (paramche == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    aq localaq = new aq();
    localaq.field_appId = paramString;
    localaq.field_launchPB = paramche;
    boolean bool = super.replace(localaq);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ar
 * JD-Core Version:    0.7.0.1
 */