package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class j$a
{
  public ArrayList<String> JN;
  public ArrayList<String> JO;
  public ArrayList<String> JP;
  public ArrayList<Uri> JQ;
  private final Context mContext;
  public final Intent mIntent;
  
  public j$a(Context paramContext, ComponentName paramComponentName)
  {
    AppMethodBeat.i(250471);
    this.mContext = ((Context)g.checkNotNull(paramContext));
    this.mIntent = new Intent().setAction("android.intent.action.SEND");
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
    this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
    this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramComponentName);
    this.mIntent.addFlags(524288);
    AppMethodBeat.o(250471);
  }
  
  public final void b(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(250473);
    String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
    if (arrayOfString1 != null) {}
    for (int i = arrayOfString1.length;; i = 0)
    {
      String[] arrayOfString2 = new String[paramArrayList.size() + i];
      paramArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null) {
        System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
      }
      this.mIntent.putExtra(paramString, arrayOfString2);
      AppMethodBeat.o(250473);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.app.j.a
 * JD-Core Version:    0.7.0.1
 */