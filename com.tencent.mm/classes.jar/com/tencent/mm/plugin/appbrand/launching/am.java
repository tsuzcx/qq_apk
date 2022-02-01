package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class am
  extends MAutoStorage<al>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(146072);
    nVW = new String[] { MAutoStorage.getCreateSQLs(al.DB_INFO, "LaunchWxaAppPBTable") };
    AppMethodBeat.o(146072);
  }
  
  public am(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, al.DB_INFO, "LaunchWxaAppPBTable", al.INDEX_CREATE);
  }
  
  public final boolean b(String paramString, dgu paramdgu)
  {
    AppMethodBeat.i(146071);
    if ((TextUtils.isEmpty(paramString)) || (paramdgu == null))
    {
      AppMethodBeat.o(146071);
      return false;
    }
    al localal = new al();
    localal.field_appId = paramString;
    localal.field_launchPB = paramdgu;
    boolean bool = super.replace(localal);
    AppMethodBeat.o(146071);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */