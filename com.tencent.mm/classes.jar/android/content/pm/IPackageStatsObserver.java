package android.content.pm;

import android.os.IInterface;

public abstract interface IPackageStatsObserver
  extends IInterface
{
  public abstract void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.content.pm.IPackageStatsObserver
 * JD-Core Version:    0.7.0.1
 */