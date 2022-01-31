package com.tencent.mm.model.d;

import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageStats;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  extends IPackageStatsObserver.Stub
{
  b$2(b paramb) {}
  
  public final void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    AppMethodBeat.i(16392);
    b.d(this.fpI)[0] = paramPackageStats.cacheSize;
    b.d(this.fpI)[1] = paramPackageStats.dataSize;
    b.d(this.fpI)[2] = paramPackageStats.codeSize;
    ab.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[] { Long.valueOf(paramPackageStats.cacheSize), Long.valueOf(paramPackageStats.dataSize), Long.valueOf(paramPackageStats.codeSize) });
    AppMethodBeat.o(16392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.b.2
 * JD-Core Version:    0.7.0.1
 */