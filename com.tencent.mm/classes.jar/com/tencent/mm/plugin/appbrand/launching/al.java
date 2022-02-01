package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class al
  extends MAutoStorage<ak>
{
  public static final String[] lqL;
  
  static
  {
    AppMethodBeat.i(146072);
    lqL = new String[] { MAutoStorage.getCreateSQLs(ak.nFK, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public al(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ak.nFK, "LaunchWxaAppPBTable", ak.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, cqa paramcqa)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (paramcqa == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    ak localak = new ak();
    localak.field_appId = paramString;
    localak.field_launchPB = paramcqa;
    boolean bool = super.replace(localak);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */