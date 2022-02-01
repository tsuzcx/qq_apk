package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class l
{
  Matrix bpU;
  
  public static void a(a parama)
  {
    parama.Du();
  }
  
  static Bitmap l(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    float f = Math.min(1.0F, 1048576.0F / (i * j));
    if (((paramDrawable instanceof BitmapDrawable)) && (f == 1.0F)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    i = (int)(i * f);
    j = (int)(j * f);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect = paramDrawable.getBounds();
    int k = localRect.left;
    int m = localRect.top;
    int n = localRect.right;
    int i1 = localRect.bottom;
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    paramDrawable.setBounds(k, m, n, i1);
    return localBitmap;
  }
  
  public static View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
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
  
  public static abstract interface a
  {
    public abstract void Du();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.core.app.l
 * JD-Core Version:    0.7.0.1
 */