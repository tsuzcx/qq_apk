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
  private final l bnR;
  
  a$d(l paraml)
  {
    this.bnR = paraml;
  }
  
  public final Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    AppMethodBeat.i(196463);
    l locall = this.bnR;
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      Drawable localDrawable = ((ImageView)localObject1).getBackground();
      if ((localObject2 != null) && (localDrawable == null))
      {
        localObject2 = l.l((Drawable)localObject2);
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
          AppMethodBeat.o(196463);
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
        if (locall.bpU == null) {
          locall.bpU = new Matrix();
        }
        locall.bpU.set(paramMatrix);
        locall.bpU.postTranslate(-paramRectF.left, -paramRectF.top);
        locall.bpU.postScale(f, f);
        localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        paramMatrix.concat(locall.bpU);
        paramView.draw(paramMatrix);
      }
    }
    AppMethodBeat.o(196463);
    return localObject1;
  }
  
  public final View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    AppMethodBeat.i(196474);
    paramContext = l.onCreateSnapshotView(paramContext, paramParcelable);
    AppMethodBeat.o(196474);
    return paramContext;
  }
  
  public final void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public final void onRejectSharedElements(List<View> paramList) {}
  
  public final void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public final void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final SharedElementCallback.OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
  {
    AppMethodBeat.i(196481);
    l.a(new l.a()
    {
      public final void Du()
      {
        AppMethodBeat.i(196297);
        paramOnSharedElementsReadyListener.onSharedElementsReady();
        AppMethodBeat.o(196297);
      }
    });
    AppMethodBeat.o(196481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.core.app.a.d
 * JD-Core Version:    0.7.0.1
 */