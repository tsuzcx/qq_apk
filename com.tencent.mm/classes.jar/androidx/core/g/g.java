package androidx.core.g;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class g
{
  private static Field Nk;
  private static boolean Nl;
  
  private static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    AppMethodBeat.i(251452);
    if (!Nl) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      Nk = localField;
      localField.setAccessible(true);
      Nl = true;
      if (Nk == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          Nk.set(paramLayoutInflater, paramFactory2);
          AppMethodBeat.o(251452);
          return;
        }
        catch (IllegalAccessException paramFactory2)
        {
          new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(paramLayoutInflater).append("; inflation may have unexpected results.");
        }
        localNoSuchFieldException = localNoSuchFieldException;
        new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
      }
      AppMethodBeat.o(251452);
    }
  }
  
  public static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    AppMethodBeat.i(251455);
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        AppMethodBeat.o(251455);
        return;
      }
      a(paramLayoutInflater, paramFactory2);
    }
    AppMethodBeat.o(251455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.g.g
 * JD-Core Version:    0.7.0.1
 */