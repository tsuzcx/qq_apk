package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;

public final class a
  extends androidx.core.content.a
{
  private static b HM;
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(250212);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      AppMethodBeat.o(250212);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(250212);
  }
  
  public static void a(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(250214);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      AppMethodBeat.o(250214);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(250214);
  }
  
  public static void a(Activity paramActivity, k paramk)
  {
    AppMethodBeat.i(250219);
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramk == null) {
        break label37;
      }
    }
    label37:
    for (paramk = new a.d(paramk);; paramk = null)
    {
      paramActivity.setEnterSharedElementCallback(paramk);
      AppMethodBeat.o(250219);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(250224);
    if ((HM != null) && (HM.gj()))
    {
      AppMethodBeat.o(250224);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof c)) {
        ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramArrayOfString = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).bm(paramArrayOfString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramArrayOfString.aFh(), "androidx/core/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
      paramActivity.requestPermissions((String[])paramArrayOfString.sf(0), ((Integer)paramArrayOfString.sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "androidx/core/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
      AppMethodBeat.o(250224);
      return;
    }
    if ((paramActivity instanceof a.a)) {
      new Handler(Looper.getMainLooper()).post(new a.1(paramArrayOfString, paramActivity, paramInt));
    }
    AppMethodBeat.o(250224);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(250225);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = paramActivity.shouldShowRequestPermissionRationale(paramString);
      AppMethodBeat.o(250225);
      return bool;
    }
    AppMethodBeat.o(250225);
    return false;
  }
  
  public static void b(Activity paramActivity)
  {
    AppMethodBeat.i(250216);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      AppMethodBeat.o(250216);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(250216);
  }
  
  public static void b(Activity paramActivity, k paramk)
  {
    AppMethodBeat.i(250221);
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramk == null) {
        break label37;
      }
    }
    label37:
    for (paramk = new a.d(paramk);; paramk = null)
    {
      paramActivity.setExitSharedElementCallback(paramk);
      AppMethodBeat.o(250221);
      return;
    }
  }
  
  public static void c(Activity paramActivity)
  {
    AppMethodBeat.i(250218);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      AppMethodBeat.o(250218);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(250218);
  }
  
  public static void d(Activity paramActivity)
  {
    AppMethodBeat.i(250222);
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
    AppMethodBeat.o(250222);
  }
  
  public static void e(Activity paramActivity)
  {
    AppMethodBeat.i(250223);
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
    AppMethodBeat.o(250223);
  }
  
  public static b gi()
  {
    return HM;
  }
  
  public static abstract interface b
  {
    public abstract boolean gj();
    
    public abstract boolean gk();
  }
  
  public static abstract interface c
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.app.a
 * JD-Core Version:    0.7.0.1
 */