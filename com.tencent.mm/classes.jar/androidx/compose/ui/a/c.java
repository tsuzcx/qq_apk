package androidx.compose.ui.a;

import android.view.ViewStructure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/autofill/AutofillApi23Helper;", "", "()V", "addChildCount", "", "structure", "Landroid/view/ViewStructure;", "num", "newChild", "index", "setDimens", "", "left", "top", "scrollX", "scrollY", "width", "height", "setId", "id", "packageName", "", "typeName", "entryName", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c auh;
  
  static
  {
    AppMethodBeat.i(204445);
    auh = new c();
    AppMethodBeat.o(204445);
  }
  
  public final ViewStructure a(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(204451);
    s.u(paramViewStructure, "structure");
    paramViewStructure = paramViewStructure.newChild(paramInt);
    AppMethodBeat.o(204451);
    return paramViewStructure;
  }
  
  public final void a(ViewStructure paramViewStructure, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(204464);
    s.u(paramViewStructure, "structure");
    paramViewStructure.setDimens(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.o(204464);
  }
  
  public final void a(ViewStructure paramViewStructure, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(204459);
    s.u(paramViewStructure, "structure");
    paramViewStructure.setId(paramInt, paramString1, paramString2, paramString3);
    AppMethodBeat.o(204459);
  }
  
  public final int b(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(204453);
    s.u(paramViewStructure, "structure");
    paramInt = paramViewStructure.addChildCount(paramInt);
    AppMethodBeat.o(204453);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.a.c
 * JD-Core Version:    0.7.0.1
 */