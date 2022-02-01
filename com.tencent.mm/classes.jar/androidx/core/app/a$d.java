package androidx.core.app;

import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

final class a$d
  extends SharedElementCallback
{
  private final k HO;
  
  a$d(k paramk)
  {
    this.HO = paramk;
  }
  
  public final Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    AppMethodBeat.i(250203);
    k localk = this.HO;
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      Drawable localDrawable = ((ImageView)localObject1).getBackground();
      if ((localObject2 != null) && (localDrawable == null))
      {
        localObject2 = k.k((Drawable)localObject2);
        if (localObject2 != null)
        {
          paramView = new Bundle();
          paramView.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
          paramView.putString("sharedElement:snapshot:imageScaleType", ((ImageView)localObject1).getScaleType().toString());
          if (((ImageView)localObject1).getScaleType() == ImageView.ScaleType.MATRIX)
          {
            paramMatrix = ((ImageView)localObject1).getImageMatrix();
            paramRectF = new float[9];
            paramMatrix.getValues(paramRectF);
            paramView.putFloatArray("sharedElement:snapshot:imageMatrix", paramRectF);
          }
          AppMethodBeat.o(250203);
          return paramView;
        }
      }
    }
    int j = Math.round(paramRectF.width());
    int i = Math.round(paramRectF.height());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (j > 0)
    {
      localObject1 = localObject2;
      if (i > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (j * i));
        j = (int)(j * f);
        i = (int)(i * f);
        if (localk.JR == null) {
          localk.JR = new Matrix();
        }
        localk.JR.set(paramMatrix);
        localk.JR.postTranslate(-paramRectF.left, -paramRectF.top);
        localk.JR.postScale(f, f);
        localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        paramMatrix.concat(localk.JR);
        paramView.draw(paramMatrix);
      }
    }
    AppMethodBeat.o(250203);
    return localObject1;
  }
  
  public final View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    AppMethodBeat.i(250205);
    paramContext = k.onCreateSnapshotView(paramContext, paramParcelable);
    AppMethodBeat.o(250205);
    return paramContext;
  }
  
  public final void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public final void onRejectSharedElements(List<View> paramList) {}
  
  public final void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public final void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
  {
    AppMethodBeat.i(250206);
    k.a(new k.a()
    {
      public final void gl()
      {
        AppMethodBeat.i(250192);
        paramOnSharedElementsReadyListener.onSharedElementsReady();
        AppMethodBeat.o(250192);
      }
    });
    AppMethodBeat.o(250206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.app.a.d
 * JD-Core Version:    0.7.0.1
 */