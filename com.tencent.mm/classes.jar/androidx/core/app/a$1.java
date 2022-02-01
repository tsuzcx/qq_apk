package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements Runnable
{
  a$1(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(250180);
    int[] arrayOfInt = new int[this.HN.length];
    PackageManager localPackageManager = this.val$activity.getPackageManager();
    String str = this.val$activity.getPackageName();
    int j = this.HN.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = localPackageManager.checkPermission(this.HN[i], str);
      i += 1;
    }
    ((a.a)this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.HN, arrayOfInt);
    AppMethodBeat.o(250180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.a.1
 * JD-Core Version:    0.7.0.1
 */