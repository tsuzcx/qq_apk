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
import android.graphics.RectF;
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
import java.util.List;
import java.util.Map;

public final class a
  extends b
{
  private static b ub;
  
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
  
  public static void a(Activity paramActivity, ad paramad)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramad != null) {
        localObject1 = new e(paramad);
      }
      paramActivity.setEnterSharedElementCallback((SharedElementCallback)localObject1);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    localObject1 = localObject2;
    if (paramad != null) {
      localObject1 = new d(paramad);
    }
    paramActivity.setEnterSharedElementCallback((SharedElementCallback)localObject1);
  }
  
  public static void a(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    if ((ub != null) && (ub.bG())) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((paramActivity instanceof c)) {
          ((c)paramActivity).validateRequestPermissionsRequestCode(paramInt);
        }
        paramActivity.requestPermissions(paramArrayOfString, paramInt);
        return;
      }
    } while (!(paramActivity instanceof a));
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        int[] arrayOfInt = new int[this.uc.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = this.uc.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(this.uc[i], str);
          i += 1;
        }
        ((a.a)paramActivity).onRequestPermissionsResult(paramInt, this.uc, arrayOfInt);
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
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static void b(Activity paramActivity, ad paramad)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramad != null) {
        localObject1 = new e(paramad);
      }
      paramActivity.setExitSharedElementCallback((SharedElementCallback)localObject1);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    localObject1 = localObject2;
    if (paramad != null) {
      localObject1 = new d(paramad);
    }
    paramActivity.setExitSharedElementCallback((SharedElementCallback)localObject1);
  }
  
  public static b bF()
  {
    return ub;
  }
  
  public static void c(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  public static void e(Activity paramActivity)
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
    public abstract boolean bG();
    
    public abstract boolean bH();
  }
  
  public static abstract interface c
  {
    public abstract void validateRequestPermissionsRequestCode(int paramInt);
  }
  
  private static class d
    extends SharedElementCallback
  {
    protected ad ud;
    
    d(ad paramad)
    {
      this.ud = paramad;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      ad localad = this.ud;
      ImageView localImageView;
      Object localObject1;
      if ((paramView instanceof ImageView))
      {
        localImageView = (ImageView)paramView;
        localObject1 = localImageView.getDrawable();
        Object localObject2 = localImageView.getBackground();
        if ((localObject1 != null) && (localObject2 == null))
        {
          localObject2 = ad.a((Drawable)localObject1);
          if (localObject2 != null)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
            ((Bundle)localObject1).putString("sharedElement:snapshot:imageScaleType", localImageView.getScaleType().toString());
            if (localImageView.getScaleType() == ImageView.ScaleType.MATRIX)
            {
              paramView = localImageView.getImageMatrix();
              paramMatrix = new float[9];
              paramView.getValues(paramMatrix);
              ((Bundle)localObject1).putFloatArray("sharedElement:snapshot:imageMatrix", paramMatrix);
            }
          }
        }
      }
      do
      {
        do
        {
          return localObject1;
          j = Math.round(paramRectF.width());
          i = Math.round(paramRectF.height());
          localImageView = null;
          localObject1 = localImageView;
        } while (j <= 0);
        localObject1 = localImageView;
      } while (i <= 0);
      float f = Math.min(1.0F, ad.yQ / (j * i));
      int j = (int)(j * f);
      int i = (int)(i * f);
      if (localad.qh == null) {
        localad.qh = new Matrix();
      }
      localad.qh.set(paramMatrix);
      localad.qh.postTranslate(-paramRectF.left, -paramRectF.top);
      localad.qh.postScale(f, f);
      paramMatrix = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      paramRectF = new Canvas(paramMatrix);
      paramRectF.concat(localad.qh);
      paramView.draw(paramRectF);
      return paramMatrix;
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return ad.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
    
    public void onRejectSharedElements(List<View> paramList) {}
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  }
  
  private static final class e
    extends a.d
  {
    e(ad paramad)
    {
      super();
    }
    
    public final void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
    {
      ad.a(new ad.a()
      {
        public final void onSharedElementsReady()
        {
          paramOnSharedElementsReadyListener.onSharedElementsReady();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.a
 * JD-Core Version:    0.7.0.1
 */