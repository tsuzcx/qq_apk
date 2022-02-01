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
  private static final TypeEvaluator<Matrix> At = new TypeEvaluator() {};
  private static final Property<ImageView, Matrix> Au = new Property(Matrix.class, "animatedTransform") {};
  private static final String[] zP = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(v paramv)
  {
    Object localObject = paramv.view;
    if ((!(localObject instanceof ImageView)) || (((View)localObject).getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)localObject;
    } while (localImageView.getDrawable() == null);
    Map localMap = paramv.values;
    localMap.put("android:changeImageTransform:bounds", new Rect(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom()));
    switch (ChangeImageTransform.3.Av[localImageView.getScaleType().ordinal()])
    {
    default: 
      paramv = new Matrix(localImageView.getImageMatrix());
    }
    for (;;)
    {
      localMap.put("android:changeImageTransform:matrix", paramv);
      return;
      localObject = localImageView.getDrawable();
      paramv = new Matrix();
      paramv.postScale(localImageView.getWidth() / ((Drawable)localObject).getIntrinsicWidth(), localImageView.getHeight() / ((Drawable)localObject).getIntrinsicHeight());
      continue;
      paramv = localImageView.getDrawable();
      int j = paramv.getIntrinsicWidth();
      int k = localImageView.getWidth();
      float f1 = k / j;
      int m = paramv.getIntrinsicHeight();
      int i = localImageView.getHeight();
      f1 = Math.max(f1, i / m);
      float f2 = j;
      float f3 = m;
      j = Math.round((k - f2 * f1) / 2.0F);
      i = Math.round((i - f3 * f1) / 2.0F);
      paramv = new Matrix();
      paramv.postScale(f1, f1);
      paramv.postTranslate(j, i);
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, v paramv1, v paramv2)
  {
    if ((paramv1 == null) || (paramv2 == null))
    {
      paramv1 = null;
      return paramv1;
    }
    paramViewGroup = (Rect)paramv1.values.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramv2.values.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null)) {
      return null;
    }
    paramv1 = (Matrix)paramv1.values.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramv2.values.get("android:changeImageTransform:matrix");
    if (((paramv1 == null) && (localMatrix == null)) || ((paramv1 != null) && (paramv1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0) {
      return null;
    }
    paramv2 = (ImageView)paramv2.view;
    paramViewGroup = paramv2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      paramViewGroup = paramv2.getScaleType();
      paramv2.setTag(2131307215, paramViewGroup);
      if (paramViewGroup == ImageView.ScaleType.MATRIX)
      {
        paramv2.setTag(2131307211, paramv2.getImageMatrix());
        label194:
        paramv2.setImageMatrix(i.xV);
      }
    }
    else
    {
      if ((i != 0) && (j != 0)) {
        break label268;
      }
    }
    for (paramViewGroup = ObjectAnimator.ofObject(paramv2, Au, At, new Matrix[] { null, null });; paramViewGroup = ObjectAnimator.ofObject(paramv2, Au, new u.a(), new Matrix[] { paramViewGroup, paramv1 }))
    {
      paramv1 = paramViewGroup;
      if (Build.VERSION.SDK_INT >= 21) {
        break;
      }
      paramViewGroup.addListener(new h.1(paramv2));
      return paramViewGroup;
      paramv2.setScaleType(ImageView.ScaleType.MATRIX);
      break label194;
      label268:
      paramViewGroup = paramv1;
      if (paramv1 == null) {
        paramViewGroup = i.xV;
      }
      paramv1 = localMatrix;
      if (localMatrix == null) {
        paramv1 = i.xV;
      }
      Au.set(paramv2, paramViewGroup);
    }
  }
  
  public final void a(v paramv)
  {
    c(paramv);
  }
  
  public final void b(v paramv)
  {
    c(paramv);
  }
  
  public final String[] getTransitionProperties()
  {
    return zP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */