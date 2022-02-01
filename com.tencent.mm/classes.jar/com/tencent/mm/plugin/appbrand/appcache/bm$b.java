package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class bm$b
  extends MAutoStorage<bh>
{
  public bm$b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, bh.lqK, "AppBrandWxaPkgManifestRecord", bh.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bm.b
 * JD-Core Version:    0.7.0.1
 */