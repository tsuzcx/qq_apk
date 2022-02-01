package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.content.b;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.List;
import java.util.Map;

public final class a
  extends b
{
  private static b Ep;
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void a(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(Activity paramActivity, z paramz)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramz == null) {
        break label27;
      }
    }
    label27:
    for (paramz = new d(paramz);; paramz = null)
    {
      paramActivity.setEnterSharedElementCallback(paramz);
      return;
    }
  }
  
  public static void a(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    if ((Ep != null) && (Ep.dS())) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((paramActivity instanceof c)) {
          ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
        }
        paramArrayOfString = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).bc(paramArrayOfString);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramArrayOfString.ahE(), "android/support/v4/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        paramActivity.requestPermissions((String[])paramArrayOfString.mt(0), ((Integer)paramArrayOfString.mt(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "android/support/v4/app/ActivityCompat", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
        return;
      }
    } while (!(paramActivity instanceof a));
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        int[] arrayOfInt = new int[this.Eq.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = this.Eq.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(this.Eq[i], str);
          i += 1;
        }
        ((a.a)paramActivity).onRequestPermissionsResult(paramInt, this.Eq, arrayOfInt);
      }
    });
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void b(Activity paramActivity, z paramz)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramz == null) {
        break label27;
      }
    }
    label27:
    for (paramz = new d(paramz);; paramz = null)
    {
      paramActivity.setExitSharedElementCallback(paramz);
      return;
    }
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static b dR()
  {
    return Ep;
  }
  
  public static void e(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  public static void f(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  public static void g(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
  
  public static abstract interface a
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean dS();
    
    public abstract boolean dT();
  }
  
  public static abstract interface c
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  static final class d
    extends SharedElementCallback
  {
    private final z Er;
    
    d(z paramz)
    {
      this.Er = paramz;
    }
    
    public final Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      z localz = this.Er;
      ImageView localImageView;
      Drawable localDrawable;
      Object localObject;
      if ((paramView instanceof ImageView))
      {
        localImageView = (ImageView)paramView;
        localDrawable = localImageView.getDrawable();
        localObject = localImageView.getBackground();
        if ((localDrawable != null) && (localObject == null))
        {
          i = localDrawable.getIntrinsicWidth();
          j = localDrawable.getIntrinsicHeight();
          if ((i <= 0) || (j <= 0))
          {
            localObject = null;
            if (localObject == null) {
              break label298;
            }
            paramView = new Bundle();
            paramView.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject);
            paramView.putString("sharedElement:snapshot:imageScaleType", localImageView.getScaleType().toString());
            if (localImageView.getScaleType() == ImageView.ScaleType.MATRIX)
            {
              paramMatrix = localImageView.getImageMatrix();
              paramRectF = new float[9];
              paramMatrix.getValues(paramRectF);
              paramView.putFloatArray("sharedElement:snapshot:imageMatrix", paramRectF);
            }
            localObject = paramView;
          }
        }
      }
      label298:
      do
      {
        do
        {
          return localObject;
          f = Math.min(1.0F, 1048576.0F / (i * j));
          if (((localDrawable instanceof BitmapDrawable)) && (f == 1.0F))
          {
            localObject = ((BitmapDrawable)localDrawable).getBitmap();
            break;
          }
          i = (int)(i * f);
          j = (int)(j * f);
          localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas((Bitmap)localObject);
          Rect localRect = localDrawable.getBounds();
          int k = localRect.left;
          int m = localRect.top;
          int n = localRect.right;
          int i1 = localRect.bottom;
          localDrawable.setBounds(0, 0, i, j);
          localDrawable.draw(localCanvas);
          localDrawable.setBounds(k, m, n, i1);
          break;
          j = Math.round(paramRectF.width());
          i = Math.round(paramRectF.height());
          localImageView = null;
          localObject = localImageView;
        } while (j <= 0);
        localObject = localImageView;
      } while (i <= 0);
      float f = Math.min(1.0F, 1048576.0F / (j * i));
      int j = (int)(j * f);
      int i = (int)(i * f);
      if (localz.Av == null) {
        localz.Av = new Matrix();
      }
      localz.Av.set(paramMatrix);
      localz.Av.postTranslate(-paramRectF.left, -paramRectF.top);
      localz.Av.postScale(f, f);
      paramMatrix = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      paramRectF = new Canvas(paramMatrix);
      paramRectF.concat(localz.Av);
      paramView.draw(paramRectF);
      return paramMatrix;
    }
    
    public final View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof Bundle))
      {
        paramParcelable = (Bundle)paramParcelable;
        Object localObject = (Bitmap)paramParcelable.getParcelable("sharedElement:snapshot:bitmap");
        if (localObject == null) {
          return null;
        }
        paramContext = new ImageView(paramContext);
        paramContext.setImageBitmap((Bitmap)localObject);
        paramContext.setScaleType(ImageView.ScaleType.valueOf(paramParcelable.getString("sharedElement:snapshot:imageScaleType")));
        if (paramContext.getScaleType() == ImageView.ScaleType.MATRIX)
        {
          paramParcelable = paramParcelable.getFloatArray("sharedElement:snapshot:imageMatrix");
          localObject = new Matrix();
          ((Matrix)localObject).setValues(paramParcelable);
          paramContext.setImageMatrix((Matrix)localObject);
        }
      }
      for (;;)
      {
        return paramContext;
        if ((paramParcelable instanceof Bitmap))
        {
          paramParcelable = (Bitmap)paramParcelable;
          paramContext = new ImageView(paramContext);
          paramContext.setImageBitmap(paramParcelable);
        }
        else
        {
          paramContext = null;
        }
      }
    }
    
    public final void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
    
    public final void onRejectSharedElements(List<View> paramList) {}
    
    public final void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
    
    public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
    
    public final void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      new z.a()
      {
        public final void onSharedElementsReady()
        {
          paramOnSharedElementsReadyListener.onSharedElementsReady();
        }
      }.onSharedElementsReady();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.a
 * JD-Core Version:    0.7.0.1
 */