package android.support.transition;

import android.view.View;
import java.util.Map;

public abstract class bc
  extends ag
{
  private static final String[] tY = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  static int a(ai paramai, int paramInt)
  {
    if (paramai == null) {
      return -1;
    }
    paramai = (int[])paramai.values.get("android:visibilityPropagation:center");
    if (paramai == null) {
      return -1;
    }
    return paramai[paramInt];
  }
  
  public static int e(ai paramai)
  {
    if (paramai == null) {
      return 8;
    }
    paramai = (Integer)paramai.values.get("android:visibilityPropagation:visibility");
    if (paramai == null) {
      return 8;
    }
    return paramai.intValue();
  }
  
  public final void c(ai paramai)
  {
    View localView = paramai.view;
    Integer localInteger = (Integer)paramai.values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramai.values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    int i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    paramai.values.put("android:visibilityPropagation:center", localObject);
  }
  
  public final String[] getPropagationProperties()
  {
    return tY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.bc
 * JD-Core Version:    0.7.0.1
 */