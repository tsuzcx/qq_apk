package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Arrays;

public final class a
  extends androidx.core.content.a
{
  private static b bnP;
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(196318);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      AppMethodBeat.o(196318);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "androidx/core/app/ActivityCompat", "startActivityForResult", "(Landroid/app/Activity;Landroid/content/Intent;ILandroid/os/Bundle;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(196318);
  }
  
  public static void a(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(196329);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      AppMethodBeat.o(196329);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(196329);
  }
  
  public static void a(Activity paramActivity, l paraml)
  {
    AppMethodBeat.i(196353);
    if (Build.VERSION.SDK_INT >= 21) {
      if (paraml == null) {
        break label37;
      }
    }
    label37:
    for (paraml = new a.d(paraml);; paraml = null)
    {
      paramActivity.setEnterSharedElementCallback(paraml);
      AppMethodBeat.o(196353);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(196396);
    if ((bnP != null) && (bnP.b(paramActivity, paramArrayOfString, paramInt)))
    {
      AppMethodBeat.o(196396);
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.isEmpty(paramArrayOfString[i]))
      {
        paramActivity = new IllegalArgumentException("Permission request for permissions " + Arrays.toString(paramArrayOfString) + " must not contain null or empty values");
        AppMethodBeat.o(196396);
        throw paramActivity;
      }
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof c)) {
        ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramArrayOfString = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramArrayOfString);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramArrayOfString.aYi(), "androidx/core/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
      paramActivity.requestPermissions((String[])paramArrayOfString.sb(0), ((Integer)paramArrayOfString.sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "androidx/core/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
      AppMethodBeat.o(196396);
      return;
    }
    if ((paramActivity instanceof a.a)) {
      new Handler(Looper.getMainLooper()).post(new a.1(paramArrayOfString, paramActivity, paramInt));
    }
    AppMethodBeat.o(196396);
  }
  
  public static void a(b paramb)
  {
    bnP = paramb;
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(196407);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = paramActivity.shouldShowRequestPermissionRationale(paramString);
      AppMethodBeat.o(196407);
      return bool;
    }
    AppMethodBeat.o(196407);
    return false;
  }
  
  public static void b(Activity paramActivity)
  {
    AppMethodBeat.i(196338);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      AppMethodBeat.o(196338);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(196338);
  }
  
  public static void b(Activity paramActivity, l paraml)
  {
    AppMethodBeat.i(196364);
    if (Build.VERSION.SDK_INT >= 21) {
      if (paraml == null) {
        break label37;
      }
    }
    label37:
    for (paraml = new a.d(paraml);; paraml = null)
    {
      paramActivity.setExitSharedElementCallback(paraml);
      AppMethodBeat.o(196364);
      return;
    }
  }
  
  public static void c(Activity paramActivity)
  {
    AppMethodBeat.i(196344);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      AppMethodBeat.o(196344);
      return;
    }
    paramActivity.finish();
    AppMethodBeat.o(196344);
  }
  
  public static void d(Activity paramActivity)
  {
    AppMethodBeat.i(196373);
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
    AppMethodBeat.o(196373);
  }
  
  public static void e(Activity paramActivity)
  {
    AppMethodBeat.i(196379);
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
    AppMethodBeat.o(196379);
  }
  
  public static abstract interface b
  {
    public abstract boolean b(Activity paramActivity, String[] paramArrayOfString, int paramInt);
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