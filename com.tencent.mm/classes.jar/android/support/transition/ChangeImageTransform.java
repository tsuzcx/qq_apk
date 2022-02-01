package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final String[] xP = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  private static final TypeEvaluator<Matrix> yu = new TypeEvaluator() {};
  private static final Property<ImageView, Matrix> yv = new Property(Matrix.class, "animatedTransform") {};
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(u paramu)
  {
    Object localObject = paramu.view;
    if ((!(localObject instanceof ImageView)) || (((View)localObject).getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)localObject;
    } while (localImageView.getDrawable() == null);
    Map localMap = paramu.values;
    localMap.put("android:changeImageTransform:bounds", new Rect(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom()));
    switch (ChangeImageTransform.3.yw[localImageView.getScaleType().ordinal()])
    {
    default: 
      paramu = new Matrix(localImageView.getImageMatrix());
    }
    for (;;)
    {
      localMap.put("android:changeImageTransform:matrix", paramu);
      return;
      localObject = localImageView.getDrawable();
      paramu = new Matrix();
      paramu.postScale(localImageView.getWidth() / ((Drawable)localObject).getIntrinsicWidth(), localImageView.getHeight() / ((Drawable)localObject).getIntrinsicHeight());
      continue;
      paramu = localImageView.getDrawable();
      int j = paramu.getIntrinsicWidth();
      int k = localImageView.getWidth();
      float f1 = k / j;
      int m = paramu.getIntrinsicHeight();
      int i = localImageView.getHeight();
      f1 = Math.max(f1, i / m);
      float f2 = j;
      float f3 = m;
      j = Math.round((k - f2 * f1) / 2.0F);
      i = Math.round((i - f3 * f1) / 2.0F);
      paramu = new Matrix();
      paramu.postScale(f1, f1);
      paramu.postTranslate(j, i);
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, u paramu1, u paramu2)
  {
    if ((paramu1 == null) || (paramu2 == null))
    {
      paramu1 = null;
      return paramu1;
    }
    paramViewGroup = (Rect)paramu1.values.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramu2.values.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null)) {
      return null;
    }
    paramu1 = (Matrix)paramu1.values.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramu2.values.get("android:changeImageTransform:matrix");
    if (((paramu1 == null) && (localMatrix == null)) || ((paramu1 != null) && (paramu1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0) {
      return null;
    }
    paramu2 = (ImageView)paramu2.view;
    paramViewGroup = paramu2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      paramViewGroup = paramu2.getScaleType();
      paramu2.setTag(2131304287, paramViewGroup);
      if (paramViewGroup == ImageView.ScaleType.MATRIX)
      {
        paramu2.setTag(2131304283, paramu2.getImageMatrix());
        label194:
        paramu2.setImageMatrix(i.vW);
      }
    }
    else
    {
      if ((i != 0) && (j != 0)) {
        break label268;
      }
    }
    for (paramViewGroup = ObjectAnimator.ofObject(paramu2, yv, yu, new Matrix[] { null, null });; paramViewGroup = ObjectAnimator.ofObject(paramu2, yv, new t.a(), new Matrix[] { paramViewGroup, paramu1 }))
    {
      paramu1 = paramViewGroup;
      if (Build.VERSION.SDK_INT >= 21) {
        break;
      }
      paramViewGroup.addListener(new h.1(paramu2));
      return paramViewGroup;
      paramu2.setScaleType(ImageView.ScaleType.MATRIX);
      break label194;
      label268:
      paramViewGroup = paramu1;
      if (paramu1 == null) {
        paramViewGroup = i.vW;
      }
      paramu1 = localMatrix;
      if (localMatrix == null) {
        paramu1 = i.vW;
      }
      yv.set(paramu2, paramViewGroup);
    }
  }
  
  public final void a(u paramu)
  {
    c(paramu);
  }
  
  public final void b(u paramu)
  {
    c(paramu);
  }
  
  public final String[] getTransitionProperties()
  {
    return xP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */