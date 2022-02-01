package androidx.compose.ui.m.a;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactoryPre21;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class k
  implements j
{
  public static final a baX;
  private static boolean baY;
  private static Constructor<StaticLayout> baZ;
  
  static
  {
    AppMethodBeat.i(205223);
    baX = new a((byte)0);
    AppMethodBeat.o(205223);
  }
  
  public final StaticLayout a(l paraml)
  {
    AppMethodBeat.i(205232);
    s.u(paraml, "params");
    Object localObject1 = a.AY();
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(205232);
      return localObject1;
      try
      {
        localObject1 = (StaticLayout)((Constructor)localObject1).newInstance(new Object[] { paraml.bba, Integer.valueOf(paraml.start), Integer.valueOf(paraml.end), paraml.bbb, Integer.valueOf(paraml.width), paraml.bbd, paraml.bbc, Float.valueOf(paraml.bbg), Float.valueOf(paraml.bbh), Boolean.valueOf(paraml.bbj), paraml.bbe, Integer.valueOf(paraml.bbf), Integer.valueOf(paraml.maxLines) });
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        baZ = null;
        Object localObject2 = null;
      }
      catch (InstantiationException localInstantiationException)
      {
        baZ = null;
        Object localObject3 = null;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        baZ = null;
        Object localObject4 = null;
      }
    }
    paraml = new StaticLayout(paraml.bba, paraml.start, paraml.end, paraml.bbb, paraml.width, paraml.bbd, paraml.bbg, paraml.bbh, paraml.bbj, paraml.bbe, paraml.bbf);
    AppMethodBeat.o(205232);
    return paraml;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactoryPre21$Companion;", "", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static Constructor<StaticLayout> AY()
    {
      AppMethodBeat.i(205162);
      Constructor localConstructor;
      if (k.AV())
      {
        localConstructor = k.AW();
        AppMethodBeat.o(205162);
        return localConstructor;
      }
      k.AX();
      try
      {
        k.a(StaticLayout.class.getConstructor(new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE }));
        localConstructor = k.AW();
        AppMethodBeat.o(205162);
        return localConstructor;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          k.a(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.m.a.k
 * JD-Core Version:    0.7.0.1
 */