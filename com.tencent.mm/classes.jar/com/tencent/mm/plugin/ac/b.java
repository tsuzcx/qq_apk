package com.tencent.mm.plugin.ac;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmStorage;", "Landroidx/lifecycle/ViewModel;", "()V", "Companion", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends af
{
  public static final a MnM;
  
  static
  {
    AppMethodBeat.i(262729);
    MnM = new a((byte)0);
    AppMethodBeat.o(262729);
  }
  
  public static <T extends af> T q(Class<T> paramClass)
  {
    AppMethodBeat.i(262726);
    paramClass = a.q(paramClass);
    AppMethodBeat.o(262726);
    return paramClass;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmstorage/BaseMvvmStorage$Companion;", "", "()V", "get", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T extends af> T q(Class<T> paramClass)
    {
      AppMethodBeat.i(262749);
      s.u(paramClass, "modelClass");
      h.baC().aZJ();
      if (!b.class.isAssignableFrom(paramClass))
      {
        paramClass = new IllegalArgumentException("getLiveStorage modelClass must extends BaseMMLiveStorage");
        AppMethodBeat.o(262749);
        throw paramClass;
      }
      paramClass = new ah((ak)h.baC().mBP, (ah.b)new b.a.a()).q(paramClass);
      AppMethodBeat.o(262749);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b
 * JD-Core Version:    0.7.0.1
 */