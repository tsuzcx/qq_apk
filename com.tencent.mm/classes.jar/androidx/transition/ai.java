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
  private static final am ata;
  private static Field atb;
  private static boolean atc;
  static final Property<View, Float> atd;
  static final Property<View, Rect> ate;
  
  static
  {
    AppMethodBeat.i(193258);
    if (Build.VERSION.SDK_INT >= 22) {
      ata = new al();
    }
    for (;;)
    {
      atd = new Property(Float.class, "translationAlpha") {};
      ate = new Property(Rect.class, "clipBounds") {};
      AppMethodBeat.o(193258);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        ata = new ak();
      } else if (Build.VERSION.SDK_INT >= 19) {
        ata = new aj();
      } else {
        ata = new am();
      }
    }
  }
  
  static void G(View paramView, int paramInt)
  {
    AppMethodBeat.i(193243);
    if (!atc) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      atb = localField;
      localField.setAccessible(true);
      label28:
      atc = true;
      if (atb != null) {
        try
        {
          int i = atb.getInt(paramView);
          atb.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
          AppMethodBeat.o(193243);
          return;
        }
        catch (IllegalAccessException paramView) {}
      }
      AppMethodBeat.o(193243);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label28;
    }
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193244);
    ata.a(paramView, paramMatrix);
    AppMethodBeat.o(193244);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193249);
    ata.b(paramView, paramMatrix);
    AppMethodBeat.o(193249);
  }
  
  static ah bM(View paramView)
  {
    AppMethodBeat.i(193227);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramView = new ag(paramView);
      AppMethodBeat.o(193227);
      return paramView;
    }
    paramView = af.bL(paramView);
    AppMethodBeat.o(193227);
    return paramView;
  }
  
  static aq bN(View paramView)
  {
    AppMethodBeat.i(193231);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramView = new ap(paramView);
      AppMethodBeat.o(193231);
      return paramView;
    }
    paramView = new ao(paramView.getWindowToken());
    AppMethodBeat.o(193231);
    return paramView;
  }
  
  static float bO(View paramView)
  {
    AppMethodBeat.i(193236);
    float f = ata.bO(paramView);
    AppMethodBeat.o(193236);
    return f;
  }
  
  static void bP(View paramView)
  {
    AppMethodBeat.i(193238);
    ata.bP(paramView);
    AppMethodBeat.o(193238);
  }
  
  static void bQ(View paramView)
  {
    AppMethodBeat.i(193239);
    ata.bQ(paramView);
    AppMethodBeat.o(193239);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193252);
    ata.c(paramView, paramMatrix);
    AppMethodBeat.o(193252);
  }
  
  static void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193255);
    ata.j(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(193255);
  }
  
  static void n(View paramView, float paramFloat)
  {
    AppMethodBeat.i(193234);
    ata.n(paramView, paramFloat);
    AppMethodBeat.o(193234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ai
 * JD-Core Version:    0.7.0.1
 */