package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.b;
import androidx.savedstate.b.a;
import androidx.savedstate.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class SavedStateHandleController
  implements o
{
  private boolean bIj = false;
  final ac bIk;
  private final String mKey;
  
  private SavedStateHandleController(String paramString, ac paramac)
  {
    this.mKey = paramString;
    this.bIk = paramac;
  }
  
  static SavedStateHandleController a(b paramb, j paramj, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(194383);
    paramString = new SavedStateHandleController(paramString, ac.a(paramb.aR(paramString), paramBundle));
    paramString.a(paramb, paramj);
    b(paramb, paramj);
    AppMethodBeat.o(194383);
    return paramString;
  }
  
  static void a(af paramaf, b paramb, j paramj)
  {
    AppMethodBeat.i(194391);
    paramaf = (SavedStateHandleController)paramaf.getTag("androidx.lifecycle.savedstate.vm.tag");
    if ((paramaf != null) && (!paramaf.bIj))
    {
      paramaf.a(paramb, paramj);
      b(paramb, paramj);
    }
    AppMethodBeat.o(194391);
  }
  
  private void a(b paramb, j paramj)
  {
    AppMethodBeat.i(194379);
    if (this.bIj)
    {
      paramb = new IllegalStateException("Already attached to lifecycleOwner");
      AppMethodBeat.o(194379);
      throw paramb;
    }
    this.bIj = true;
    paramj.addObserver(this);
    paramb.a(this.mKey, this.bIk.bIg);
    AppMethodBeat.o(194379);
  }
  
  private static void b(final b paramb, j paramj)
  {
    AppMethodBeat.i(194398);
    j.b localb = paramj.getCurrentState();
    if ((localb == j.b.bHh) || (localb.d(j.b.bHj)))
    {
      paramb.r(a.class);
      AppMethodBeat.o(194398);
      return;
    }
    paramj.addObserver(new o()
    {
      public void onStateChanged(q paramAnonymousq, j.a paramAnonymousa)
      {
        AppMethodBeat.i(194494);
        if (paramAnonymousa == j.a.ON_START)
        {
          SavedStateHandleController.this.removeObserver(this);
          paramb.r(SavedStateHandleController.a.class);
        }
        AppMethodBeat.o(194494);
      }
    });
    AppMethodBeat.o(194398);
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(194402);
    if (parama == j.a.ON_DESTROY)
    {
      this.bIj = false;
      paramq.getLifecycle().removeObserver(this);
    }
    AppMethodBeat.o(194402);
  }
  
  static final class a
    implements b.a
  {
    public final void a(d paramd)
    {
      AppMethodBeat.i(194500);
      if (!(paramd instanceof ak))
      {
        paramd = new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        AppMethodBeat.o(194500);
        throw paramd;
      }
      aj localaj = ((ak)paramd).getViewModelStore();
      b localb = paramd.getSavedStateRegistry();
      Iterator localIterator = localaj.Hq().iterator();
      while (localIterator.hasNext()) {
        SavedStateHandleController.a(localaj.aN((String)localIterator.next()), localb, paramd.getLifecycle());
      }
      if (!localaj.Hq().isEmpty()) {
        localb.r(a.class);
      }
      AppMethodBeat.o(194500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandleController
 * JD-Core Version:    0.7.0.1
 */