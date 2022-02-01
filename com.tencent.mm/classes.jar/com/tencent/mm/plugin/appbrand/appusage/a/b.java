package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class b
  extends MAutoStorage<a>
{
  public static final String[] nVW;
  ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(44668);
    nVW = new String[] { MAutoStorage.getCreateSQLs(a.info, "AppBrandRecommendCard") };
    AppMethodBeat.o(44668);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.info, "AppBrandRecommendCard", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final void cju()
  {
    AppMethodBeat.i(44665);
    this.db.execSQL("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
    AppMethodBeat.o(44665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.b
 * JD-Core Version:    0.7.0.1
 */