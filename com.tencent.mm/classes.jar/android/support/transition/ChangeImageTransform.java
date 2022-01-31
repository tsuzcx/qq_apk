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
  private static final TypeEvaluator<Matrix> pZ = new ChangeImageTransform.1();
  private static final String[] ps = { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  private static final Property<ImageView, Matrix> qa = new ChangeImageTransform.2(Matrix.class, "animatedTransform");
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void c(ai paramai)
  {
    Object localObject = paramai.view;
    if ((!(localObject instanceof ImageView)) || (((View)localObject).getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)localObject;
    } while (localImageView.getDrawable() == null);
    Map localMap = paramai.values;
    localMap.put("android:changeImageTransform:bounds", new Rect(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom()));
    switch (ChangeImageTransform.3.qb[localImageView.getScaleType().ordinal()])
    {
    default: 
      paramai = new Matrix(localImageView.getImageMatrix());
    }
    for (;;)
    {
      localMap.put("android:changeImageTransform:matrix", paramai);
      return;
      localObject = localImageView.getDrawable();
      paramai = new Matrix();
      paramai.postScale(localImageView.getWidth() / ((Drawable)localObject).getIntrinsicWidth(), localImageView.getHeight() / ((Drawable)localObject).getIntrinsicHeight());
      continue;
      paramai = localImageView.getDrawable();
      int j = paramai.getIntrinsicWidth();
      int k = localImageView.getWidth();
      float f1 = k / j;
      int m = paramai.getIntrinsicHeight();
      int i = localImageView.getHeight();
      f1 = Math.max(f1, i / m);
      float f2 = j;
      float f3 = m;
      j = Math.round((k - f2 * f1) / 2.0F);
      i = Math.round((i - f3 * f1) / 2.0F);
      paramai = new Matrix();
      paramai.postScale(f1, f1);
      paramai.postTranslate(j, i);
    }
  }
  
  public final Animator a(ViewGroup paramViewGroup, ai paramai1, ai paramai2)
  {
    if ((paramai1 == null) || (paramai2 == null)) {
      return null;
    }
    paramViewGroup = (Rect)paramai1.values.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramai2.values.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null)) {
      return null;
    }
    paramai1 = (Matrix)paramai1.values.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramai2.values.get("android:changeImageTransform:matrix");
    if (((paramai1 == null) && (localMatrix == null)) || ((paramai1 != null) && (paramai1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0) {
      return null;
    }
    paramai2 = (ImageView)paramai2.view;
    paramViewGroup = paramai2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    l.a(paramai2);
    if ((i == 0) || (j == 0)) {}
    for (paramViewGroup = ObjectAnimator.ofObject(paramai2, qa, pZ, new Matrix[] { null, null });; paramViewGroup = ObjectAnimator.ofObject(paramai2, qa, new ah.a(), new Matrix[] { paramViewGroup, paramai1 }))
    {
      l.a(paramai2, paramViewGroup);
      return paramViewGroup;
      paramViewGroup = paramai1;
      if (paramai1 == null) {
        paramViewGroup = p.ny;
      }
      paramai1 = localMatrix;
      if (localMatrix == null) {
        paramai1 = p.ny;
      }
      qa.set(paramai2, paramViewGroup);
    }
  }
  
  public final void a(ai paramai)
  {
    c(paramai);
  }
  
  public final void b(ai paramai)
  {
    c(paramai);
  }
  
  public final String[] getTransitionProperties()
  {
    return ps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */