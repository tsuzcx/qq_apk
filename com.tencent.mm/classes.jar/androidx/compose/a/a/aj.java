package androidx.compose.a.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/MutableTransitionState;", "S", "", "initialState", "(Ljava/lang/Object;)V", "<set-?>", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "isIdle", "", "isIdle$annotations", "()V", "()Z", "isRunning", "isRunning$animation_core_release", "setRunning$animation_core_release", "(Z)V", "isRunning$delegate", "targetState", "getTargetState", "setTargetState", "targetState$delegate", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj<S>
{
  private final an TW;
  final an Vt;
  public final an Vu;
  
  public aj(S paramS)
  {
    AppMethodBeat.i(203402);
    this.Vt = bj.T(paramS);
    this.Vu = bj.T(paramS);
    this.TW = bj.T(Boolean.FALSE);
    AppMethodBeat.o(203402);
  }
  
  public final void ai(boolean paramBoolean)
  {
    AppMethodBeat.i(203418);
    this.TW.setValue(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(203418);
  }
  
  public final S lN()
  {
    AppMethodBeat.i(203406);
    Object localObject = ((bm)this.Vt).getValue();
    AppMethodBeat.o(203406);
    return localObject;
  }
  
  public final S lO()
  {
    AppMethodBeat.i(203412);
    Object localObject = ((bm)this.Vu).getValue();
    AppMethodBeat.o(203412);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.aj
 * JD-Core Version:    0.7.0.1
 */