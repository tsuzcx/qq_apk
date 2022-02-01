package androidx.transition;

import android.view.View;
import java.util.Map;

public abstract class an
  extends u
{
  private static final String[] cil = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  private static int a(w paramw, int paramInt)
  {
    if (paramw == null) {
      return -1;
    }
    paramw = (int[])paramw.values.get("android:visibilityPropagation:center");
    if (paramw == null) {
      return -1;
    }
    return paramw[paramInt];
  }
  
  public static int e(w paramw)
  {
    if (paramw == null) {
      return 8;
    }
    paramw = (Integer)paramw.values.get("android:visibilityPropagation:visibility");
    if (paramw == null) {
      return 8;
    }
    return paramw.intValue();
  }
  
  public static int f(w paramw)
  {
    return a(paramw, 0);
  }
  
  public static int g(w paramw)
  {
    return a(paramw, 1);
  }
  
  public final String[] Mb()
  {
    return cil;
  }
  
  public final void a(w paramw)
  {
    View localView = paramw.view;
    Integer localInteger = (Integer)paramw.values.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramw.values.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    int i = localObject[1];
    localObject[1] = (localView.getHeight() / 2 + i);
    paramw.values.put("android:visibilityPropagation:center", localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.an
 * JD-Core Version:    0.7.0.1
 */