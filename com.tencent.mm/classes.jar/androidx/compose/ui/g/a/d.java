package androidx.compose.ui.g.a;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import androidx.compose.ui.i.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/key/KeyInputModifier;", "Landroidx/compose/ui/Modifier$Element;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "keyInputNode", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "getKeyInputNode", "()Landroidx/compose/ui/node/ModifiedKeyInputNode;", "setKeyInputNode", "(Landroidx/compose/ui/node/ModifiedKeyInputNode;)V", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreviewKeyEvent", "processKeyInput", "keyEvent", "processKeyInput-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements f.c
{
  public final kotlin.g.a.b<b, Boolean> aKp;
  public final kotlin.g.a.b<b, Boolean> aKq;
  public r aKr;
  
  public d(kotlin.g.a.b<? super b, Boolean> paramb)
  {
    this.aKp = paramb;
    this.aKq = null;
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(205735);
    paramf = f.c.a.a((f.c)this, paramf);
    AppMethodBeat.o(205735);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205722);
    paramR = f.c.a.a(this, paramR, paramm);
    AppMethodBeat.o(205722);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205729);
    boolean bool = f.c.a.a(this, paramb);
    AppMethodBeat.o(205729);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205727);
    paramR = f.c.a.b(this, paramR, paramm);
    AppMethodBeat.o(205727);
    return paramR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.a.d
 * JD-Core Version:    0.7.0.1
 */