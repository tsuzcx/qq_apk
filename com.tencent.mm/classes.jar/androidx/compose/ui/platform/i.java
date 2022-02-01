package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.ui.m.c.m;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"textInputServiceFactory", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputServiceFactory$annotations", "()V", "getTextInputServiceFactory", "()Lkotlin/jvm/functions/Function1;", "setTextInputServiceFactory", "(Lkotlin/jvm/functions/Function1;)V", "localeLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroid/content/res/Configuration;", "getLocaleLayoutDirection", "(Landroid/content/res/Configuration;)Landroidx/compose/ui/unit/LayoutDirection;", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "layoutDirectionFromInt", "layoutDirection", "invertTo", "", "other", "invertTo-JiSxe2E", "([F[F)V", "preTransform", "preTransform-JiSxe2E", "toRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  private static b<? super m, ? extends androidx.compose.ui.m.c.s> aSG = (b)i.b.aSI;
  
  private static final float a(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2)
  {
    return paramArrayOfFloat1[(paramInt1 * 4 + 0)] * paramArrayOfFloat2[(paramInt2 + 0)] + paramArrayOfFloat1[(paramInt1 * 4 + 1)] * paramArrayOfFloat2[(paramInt2 + 4)] + paramArrayOfFloat1[(paramInt1 * 4 + 2)] * paramArrayOfFloat2[(paramInt2 + 8)] + paramArrayOfFloat1[(paramInt1 * 4 + 3)] * paramArrayOfFloat2[(paramInt2 + 12)];
  }
  
  public static final n a(Configuration paramConfiguration)
  {
    AppMethodBeat.i(206887);
    kotlin.g.b.s.u(paramConfiguration, "<this>");
    paramConfiguration = db(paramConfiguration.getLayoutDirection());
    AppMethodBeat.o(206887);
    return paramConfiguration;
  }
  
  private static final n db(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return n.beP;
    case 0: 
      return n.beP;
    }
    return n.beQ;
  }
  
  public static final b<m, androidx.compose.ui.m.c.s> yI()
  {
    return aSG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.i
 * JD-Core Version:    0.7.0.1
 */