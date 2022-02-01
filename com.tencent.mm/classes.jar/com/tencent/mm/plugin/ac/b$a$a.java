package com.tencent.mm.plugin.ac;

import androidx.lifecycle.af;
import androidx.lifecycle.ah.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mvvmstorage/BaseMvvmStorage$Companion$get$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a$a
  implements ah.b
{
  public final <T extends af> T create(Class<T> paramClass)
  {
    AppMethodBeat.i(262715);
    s.u(paramClass, "modelClass");
    paramClass = (af)paramClass.newInstance();
    AppMethodBeat.o(262715);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b.a.a
 * JD-Core Version:    0.7.0.1
 */