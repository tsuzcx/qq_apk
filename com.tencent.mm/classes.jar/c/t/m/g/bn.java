package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class bn
{
  public String a = "";
  public int b = 0;
  public String c = "";
  public String d = "";
  public int e;
  
  public bn()
  {
    try
    {
      this.a = m.a().getPackageName();
      PackageInfo localPackageInfo = m.a().getPackageManager().getPackageInfo(this.a, 0);
      this.b = localPackageInfo.versionCode;
      this.c = localPackageInfo.versionName;
      this.e = m.b();
      this.d = "";
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.bn
 * JD-Core Version:    0.7.0.1
 */