package androidx.core.g;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class g
{
  private static Field btm;
  private static boolean bto;
  
  private static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    AppMethodBeat.i(195720);
    if (!bto) {}
    try
    {
      Field localField = LayoutInflater.class.getDeclaredField("mFactory2");
      btm = localField;
      localField.setAccessible(true);
      bto = true;
      if (btm == null) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        try
        {
          btm.set(paramLayoutInflater, paramFactory2);
          AppMethodBeat.o(195720);
          return;
        }
        catch (IllegalAccessException paramFactory2)
        {
          new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ").append(paramLayoutInflater).append("; inflation may have unexpected results.");
        }
        localNoSuchFieldException = localNoSuchFieldException;
        new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ").append(LayoutInflater.class.getName()).append("; inflation may have unexpected results.");
      }
      AppMethodBeat.o(195720);
    }
  }
  
  public static void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    AppMethodBeat.i(195727);
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21)
    {
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if ((localFactory instanceof LayoutInflater.Factory2))
      {
        a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
        AppMethodBeat.o(195727);
        return;
      }
      a(paramLayoutInflater, paramFactory2);
    }
    AppMethodBeat.o(195727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.g
 * JD-Core Version:    0.7.0.1
 */