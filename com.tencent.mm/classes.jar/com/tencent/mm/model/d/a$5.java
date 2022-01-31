package com.tencent.mm.model.d;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  extends IPackageStatsObserver.Stub
{
  a$5(a parama) {}
  
  public final void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    a.m(this.dZq)[0] = paramPackageStats.cacheSize;
    a.m(this.dZq)[1] = paramPackageStats.dataSize;
    a.m(this.dZq)[2] = paramPackageStats.codeSize;
    y.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[] { Long.valueOf(paramPackageStats.cacheSize), Long.valueOf(paramPackageStats.dataSize), Long.valueOf(paramPackageStats.codeSize) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.a.5
 * JD-Core Version:    0.7.0.1
 */