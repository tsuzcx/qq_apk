package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final TypeEvaluator<Matrix> qW = new ChangeImageTransform.1();
  private static final Property<ImageView, Matrix> qX = new ChangeImageTransform.2(Matrix.class, "animatedTransform");
  private static final String[] qo = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(ah paramah)
  {
    Object localObject = paramah.view;
    if ((!(localObject instanceof ImageView)) || (((View)localObject).getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)localObject;
    } while (localImageView.getDrawable() == null);
    Map localMap = paramah.values;
    localMap.put("android:changeImageTransform:bounds", new Rect(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom()));
    switch (ChangeImageTransform.3.qY[localImageView.getScaleType().ordinal()])
    {
    default: 
      paramah = new Matrix(localImageView.getImageMatrix());
    }
    for (;;)
    {
      localMap.put("android:changeImageTransform:matrix", paramah);
      return;
      localObject = localImageView.getDrawable();
      paramah = new Matrix();
      paramah.postScale(localImageView.getWidth() / ((Drawable)localObject).getIntrinsicWidth(), localImageView.getHeight() / ((Drawable)localObject).getIntrinsicHeight());
      continue;
      paramah = localImageView.getDrawable();
      int j = paramah.getIntrinsicWidth();
      int k = localImageView.getWidth();
      float f1 = k / j;
      int m = paramah.getIntrinsicHeight();
      int i = localImageView.getHeight();
      f1 = Math.max(f1, i / m);
      float f2 = j;
      float f3 = m;
      j = Math.round((k - f2 * f1) / 2.0F);
      i = Math.round((i - f3 * f1) / 2.0F);
      paramah = new Matrix();
      paramah.postScale(f1, f1);
      paramah.postTranslate(j, i);
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ah paramah1, ah paramah2)
  {
    if ((paramah1 == null) || (paramah2 == null)) {
      return null;
    }
    paramViewGroup = (Rect)paramah1.values.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramah2.values.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null)) {
      return null;
    }
    paramah1 = (Matrix)paramah1.values.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramah2.values.get("android:changeImageTransform:matrix");
    if (((paramah1 == null) && (localMatrix == null)) || ((paramah1 != null) && (paramah1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0) {
      return null;
    }
    paramah2 = (ImageView)paramah2.view;
    paramViewGroup = paramah2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    l.a(paramah2);
    if ((i == 0) || (j == 0)) {}
    for (paramViewGroup = ObjectAnimator.ofObject(paramah2, qX, qW, new Matrix[] { null, null });; paramViewGroup = ObjectAnimator.ofObject(paramah2, qX, new ag.a(), new Matrix[] { paramViewGroup, paramah1 }))
    {
      l.a(paramah2, paramViewGroup);
      return paramViewGroup;
      paramViewGroup = paramah1;
      if (paramah1 == null) {
        paramViewGroup = p.ow;
      }
      paramah1 = localMatrix;
      if (localMatrix == null) {
        paramah1 = p.ow;
      }
      qX.set(paramah2, paramViewGroup);
    }
  }
  
  public final void a(ah paramah)
  {
    c(paramah);
  }
  
  public final void b(ah paramah)
  {
    c(paramah);
  }
  
  public final String[] getTransitionProperties()
  {
    return qo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */