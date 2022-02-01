package android.support.transition;

import android.view.View;
import java.util.Map;

public abstract class al
  extends s
{
  private static final String[] Bn = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  static int a(u paramu, int paramInt)
  {
    if (paramu == null) {
      return -1;
    }
    paramu = (int[])paramu.values.get("android:visibilityPropagation:center");
    if (paramu == null) {
      return -1;
    }
    return paramu[paramInt];
  }
  
  public static int e(u paramu)
  {
    if (paramu == null) {
      return 8;
    }
    paramu = (Integer)paramu.values.get("android:visibilityPropagation:visibility");
    if (paramu == null) {
      return 8;
    }
    return paramu.intValue();
  }
  
  public final void c(u paramu)
  {
    View localView = paramu.view;
    Integer localInteger = (Integer)paramu.values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramu.values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    int i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    paramu.values.put("android:visibilityPropagation:center", localObject);
  }
  
  public final String[] getPropagationProperties()
  {
    return Bn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.al
 * JD-Core Version:    0.7.0.1
 */