package coil.memory;

import android.graphics.drawable.BitmapDrawable;
import coil.j.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcoil/memory/InvalidatableEmptyTargetDelegate;", "Lcoil/memory/TargetDelegate;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "(Lcoil/bitmap/BitmapReferenceCounter;)V", "success", "", "result", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends s
{
  private final coil.b.d cnQ;
  
  public i(coil.b.d paramd)
  {
    super((byte)0);
    AppMethodBeat.i(188281);
    this.cnQ = paramd;
    AppMethodBeat.o(188281);
  }
  
  public final Object a(m paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188290);
    paramd = this.cnQ;
    paramm = ((coil.j.i)paramm).getDrawable();
    if ((paramm instanceof BitmapDrawable))
    {
      paramm = (BitmapDrawable)paramm;
      if (paramm != null) {
        break label64;
      }
    }
    label64:
    for (paramm = null;; paramm = paramm.getBitmap())
    {
      if (paramm != null) {
        paramd.a(paramm, false);
      }
      paramm = ah.aiuX;
      AppMethodBeat.o(188290);
      return paramm;
      paramm = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.i
 * JD-Core Version:    0.7.0.1
 */