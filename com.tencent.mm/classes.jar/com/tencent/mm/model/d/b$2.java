package com.tencent.mm.model.d;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  extends IPackageStatsObserver.Stub
{
  b$2(b paramb) {}
  
  public final void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    b.d(this.dZD)[0] = paramPackageStats.cacheSize;
    b.d(this.dZD)[1] = paramPackageStats.dataSize;
    b.d(this.dZD)[2] = paramPackageStats.codeSize;
    y.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[] { Long.valueOf(paramPackageStats.cacheSize), Long.valueOf(paramPackageStats.dataSize), Long.valueOf(paramPackageStats.codeSize) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.b.2
 * JD-Core Version:    0.7.0.1
 */