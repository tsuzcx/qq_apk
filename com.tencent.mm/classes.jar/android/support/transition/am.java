package android.support.transition;

import android.view.View;
import java.util.Map;

public abstract class am
  extends t
{
  private static final String[] Em = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  static int a(v paramv, int paramInt)
  {
    if (paramv == null) {
      return -1;
    }
    paramv = (int[])paramv.values.get("android:visibilityPropagation:center");
    if (paramv == null) {
      return -1;
    }
    return paramv[paramInt];
  }
  
  public static int e(v paramv)
  {
    if (paramv == null) {
      return 8;
    }
    paramv = (Integer)paramv.values.get("android:visibilityPropagation:visibility");
    if (paramv == null) {
      return 8;
    }
    return paramv.intValue();
  }
  
  public final void c(v paramv)
  {
    View localView = paramv.view;
    Integer localInteger = (Integer)paramv.values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramv.values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    int i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    paramv.values.put("android:visibilityPropagation:center", localObject);
  }
  
  public final String[] getPropagationProperties()
  {
    return Em;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.am
 * JD-Core Version:    0.7.0.1
 */