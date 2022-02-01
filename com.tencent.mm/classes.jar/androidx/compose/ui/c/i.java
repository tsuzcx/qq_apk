package androidx.compose.ui.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.i.j;
import androidx.compose.ui.i.o;
import androidx.compose.ui.i.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/ModifiedFocusRequesterNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "freeFocus", "requestFocus", "", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final int Ue;
  public static final i.a avb;
  private static final i avd;
  public final e<q> avc;
  
  static
  {
    AppMethodBeat.i(204387);
    avb = new i.a((byte)0);
    Ue = e.Ue;
    avd = new i();
    AppMethodBeat.o(204387);
  }
  
  public i()
  {
    AppMethodBeat.i(204372);
    this.avc = new e(new q[16]);
    AppMethodBeat.o(204372);
  }
  
  public final void requestFocus()
  {
    AppMethodBeat.i(204400);
    if (!this.avc.qn())
    {
      localObject = (Throwable)new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
      AppMethodBeat.o(204400);
      throw ((Throwable)localObject);
    }
    Object localObject = this.avc;
    int j = ((e)localObject).size;
    Object[] arrayOfObject;
    int i;
    if (j > 0)
    {
      arrayOfObject = ((e)localObject).aqq;
      i = 0;
    }
    for (;;)
    {
      q localq = (q)arrayOfObject[i];
      localObject = localq.xk();
      if (localObject == null) {
        localObject = f.a(localq.aOb);
      }
      for (;;)
      {
        if (localObject != null) {
          m.a((o)localObject);
        }
        i += 1;
        if (i < j) {
          break;
        }
        AppMethodBeat.o(204400);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.i
 * JD-Core Version:    0.7.0.1
 */