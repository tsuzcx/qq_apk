package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

final class ai
{
  private static final am chJ;
  private static Field chK;
  private static boolean chL;
  static final Property<View, Float> chM;
  static final Property<View, Rect> chN;
  
  static
  {
    AppMethodBeat.i(201635);
    if (Build.VERSION.SDK_INT >= 22) {
      chJ = new al();
    }
    for (;;)
    {
      chM = new Property(Float.class, "translationAlpha") {};
      chN = new Property(Rect.class, "clipBounds") {};
      AppMethodBeat.o(201635);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        chJ = new ak();
      } else if (Build.VERSION.SDK_INT >= 19) {
        chJ = new aj();
      } else {
        chJ = new am();
      }
    }
  }
  
  static void K(View paramView, int paramInt)
  {
    AppMethodBeat.i(201597);
    if (!chL) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      chK = localField;
      localField.setAccessible(true);
      label28:
      chL = true;
      if (chK != null) {
        try
        {
          int i = chK.getInt(paramView);
          chK.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
          AppMethodBeat.o(201597);
          return;
        }
        catch (IllegalAccessException paramView) {}
      }
      AppMethodBeat.o(201597);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label28;
    }
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201604);
    chJ.a(paramView, paramMatrix);
    AppMethodBeat.o(201604);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201613);
    chJ.b(paramView, paramMatrix);
    AppMethodBeat.o(201613);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201620);
    chJ.c(paramView, paramMatrix);
    AppMethodBeat.o(201620);
  }
  
  static ah cg(View paramView)
  {
    AppMethodBeat.i(201559);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramView = new ag(paramView);
      AppMethodBeat.o(201559);
      return paramView;
    }
    paramView = af.cf(paramView);
    AppMethodBeat.o(201559);
    return paramView;
  }
  
  static aq ch(View paramView)
  {
    AppMethodBeat.i(201568);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramView = new ap(paramView);
      AppMethodBeat.o(201568);
      return paramView;
    }
    paramView = new ao(paramView.getWindowToken());
    AppMethodBeat.o(201568);
    return paramView;
  }
  
  static float ci(View paramView)
  {
    AppMethodBeat.i(201580);
    float f = chJ.ci(paramView);
    AppMethodBeat.o(201580);
    return f;
  }
  
  static void cj(View paramView)
  {
    AppMethodBeat.i(201584);
    chJ.cj(paramView);
    AppMethodBeat.o(201584);
  }
  
  static void ck(View paramView)
  {
    AppMethodBeat.i(201590);
    chJ.ck(paramView);
    AppMethodBeat.o(201590);
  }
  
  static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201628);
    chJ.j(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(201628);
  }
  
  static void o(View paramView, float paramFloat)
  {
    AppMethodBeat.i(201575);
    chJ.o(paramView, paramFloat);
    AppMethodBeat.o(201575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.transition.ai
 * JD-Core Version:    0.7.0.1
 */