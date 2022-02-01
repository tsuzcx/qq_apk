package androidx.transition;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class ChangeImageTransform
  extends Transition
{
  private static final TypeEvaluator<Matrix> ceE;
  private static final Property<ImageView, Matrix> ceF;
  private static final String[] cec;
  
  static
  {
    AppMethodBeat.i(201653);
    cec = new String[] { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
    ceE = new TypeEvaluator() {};
    ceF = new Property(Matrix.class, "animatedTransform") {};
    AppMethodBeat.o(201653);
  }
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(w paramw)
  {
    AppMethodBeat.i(201643);
    Object localObject = paramw.view;
    if ((!(localObject instanceof ImageView)) || (((View)localObject).getVisibility() != 0))
    {
      AppMethodBeat.o(201643);
      return;
    }
    ImageView localImageView = (ImageView)localObject;
    if (localImageView.getDrawable() == null)
    {
      AppMethodBeat.o(201643);
      return;
    }
    Map localMap = paramw.values;
    localMap.put("android:changeImageTransform:bounds", new Rect(((View)localObject).getLeft(), ((View)localObject).getTop(), ((View)localObject).getRight(), ((View)localObject).getBottom()));
    switch (3.ceG[localImageView.getScaleType().ordinal()])
    {
    default: 
      paramw = new Matrix(localImageView.getImageMatrix());
    }
    for (;;)
    {
      localMap.put("android:changeImageTransform:matrix", paramw);
      AppMethodBeat.o(201643);
      return;
      localObject = localImageView.getDrawable();
      paramw = new Matrix();
      paramw.postScale(localImageView.getWidth() / ((Drawable)localObject).getIntrinsicWidth(), localImageView.getHeight() / ((Drawable)localObject).getIntrinsicHeight());
      continue;
      paramw = localImageView.getDrawable();
      int j = paramw.getIntrinsicWidth();
      int k = localImageView.getWidth();
      float f1 = k / j;
      int m = paramw.getIntrinsicHeight();
      int i = localImageView.getHeight();
      f1 = Math.max(f1, i / m);
      float f2 = j;
      float f3 = m;
      j = Math.round((k - f2 * f1) / 2.0F);
      i = Math.round((i - f3 * f1) / 2.0F);
      paramw = new Matrix();
      paramw.postScale(f1, f1);
      paramw.postTranslate(j, i);
    }
  }
  
  public final String[] LI()
  {
    return cec;
  }
  
  public final Animator a(ViewGroup paramViewGroup, w paramw1, w paramw2)
  {
    AppMethodBeat.i(201692);
    if ((paramw1 == null) || (paramw2 == null))
    {
      AppMethodBeat.o(201692);
      return null;
    }
    paramViewGroup = (Rect)paramw1.values.get("android:changeImageTransform:bounds");
    Rect localRect = (Rect)paramw2.values.get("android:changeImageTransform:bounds");
    if ((paramViewGroup == null) || (localRect == null))
    {
      AppMethodBeat.o(201692);
      return null;
    }
    paramw1 = (Matrix)paramw1.values.get("android:changeImageTransform:matrix");
    Matrix localMatrix = (Matrix)paramw2.values.get("android:changeImageTransform:matrix");
    if (((paramw1 == null) && (localMatrix == null)) || ((paramw1 != null) && (paramw1.equals(localMatrix)))) {}
    for (int i = 1; (paramViewGroup.equals(localRect)) && (i != 0); i = 0)
    {
      AppMethodBeat.o(201692);
      return null;
    }
    paramw2 = (ImageView)paramw2.view;
    paramViewGroup = paramw2.getDrawable();
    i = paramViewGroup.getIntrinsicWidth();
    int j = paramViewGroup.getIntrinsicHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      paramViewGroup = paramw2.getScaleType();
      paramw2.setTag(m.a.save_scale_type, paramViewGroup);
      if (paramViewGroup == ImageView.ScaleType.MATRIX)
      {
        paramw2.setTag(m.a.save_image_matrix, paramw2.getImageMatrix());
        paramw2.setImageMatrix(i.cfz);
      }
    }
    else
    {
      if ((i != 0) && (j != 0)) {
        break label291;
      }
    }
    for (paramViewGroup = ObjectAnimator.ofObject(paramw2, ceF, ceE, new Matrix[] { null, null });; paramViewGroup = ObjectAnimator.ofObject(paramw2, ceF, new v.a(), new Matrix[] { paramViewGroup, paramw1 }))
    {
      if (Build.VERSION.SDK_INT < 21) {
        paramViewGroup.addListener(new h.1(paramw2));
      }
      AppMethodBeat.o(201692);
      return paramViewGroup;
      paramw2.setScaleType(ImageView.ScaleType.MATRIX);
      break;
      label291:
      paramViewGroup = paramw1;
      if (paramw1 == null) {
        paramViewGroup = i.cfz;
      }
      paramw1 = localMatrix;
      if (localMatrix == null) {
        paramw1 = i.cfz;
      }
      ceF.set(paramw2, paramViewGroup);
    }
  }
  
  public final void b(w paramw)
  {
    AppMethodBeat.i(201661);
    a(paramw);
    AppMethodBeat.o(201661);
  }
  
  public final void c(w paramw)
  {
    AppMethodBeat.i(201672);
    a(paramw);
    AppMethodBeat.o(201672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.ChangeImageTransform
 * JD-Core Version:    0.7.0.1
 */