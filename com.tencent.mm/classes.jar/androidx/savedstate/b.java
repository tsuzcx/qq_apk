package androidx.savedstate;

import android.os.Bundle;
import androidx.a.a.b.b.d;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class b
{
  public androidx.a.a.b.b<String, b> cce;
  private Bundle ccf;
  private Recreator.a ccg;
  boolean cch;
  private boolean mRestored;
  
  b()
  {
    AppMethodBeat.i(193347);
    this.cce = new androidx.a.a.b.b();
    this.cch = true;
    AppMethodBeat.o(193347);
  }
  
  final void a(j paramj, Bundle paramBundle)
  {
    AppMethodBeat.i(193397);
    if (this.mRestored)
    {
      paramj = new IllegalStateException("SavedStateRegistry was already restored.");
      AppMethodBeat.o(193397);
      throw paramj;
    }
    if (paramBundle != null) {
      this.ccf = paramBundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
    }
    paramj.addObserver(new SavedStateRegistry.1(this));
    this.mRestored = true;
    AppMethodBeat.o(193397);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(193369);
    if ((b)this.cce.putIfAbsent(paramString, paramb) != null)
    {
      paramString = new IllegalArgumentException("SavedStateProvider with the given key is already registered");
      AppMethodBeat.o(193369);
      throw paramString;
    }
    AppMethodBeat.o(193369);
  }
  
  public final Bundle aR(String paramString)
  {
    AppMethodBeat.i(193360);
    if (!this.mRestored)
    {
      paramString = new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
      AppMethodBeat.o(193360);
      throw paramString;
    }
    if (this.ccf != null)
    {
      Bundle localBundle = this.ccf.getBundle(paramString);
      this.ccf.remove(paramString);
      if (this.ccf.isEmpty()) {
        this.ccf = null;
      }
      AppMethodBeat.o(193360);
      return localBundle;
    }
    AppMethodBeat.o(193360);
    return null;
  }
  
  final void m(Bundle paramBundle)
  {
    AppMethodBeat.i(193410);
    Bundle localBundle = new Bundle();
    if (this.ccf != null) {
      localBundle.putAll(this.ccf);
    }
    b.d locald = this.cce.fJ();
    while (locald.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      localBundle.putBundle((String)localEntry.getKey(), ((b)localEntry.getValue()).saveState());
    }
    paramBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", localBundle);
    AppMethodBeat.o(193410);
  }
  
  public final void r(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(193386);
    if (!this.cch)
    {
      paramClass = new IllegalStateException("Can not perform this action after onSaveInstanceState");
      AppMethodBeat.o(193386);
      throw paramClass;
    }
    if (this.ccg == null) {
      this.ccg = new Recreator.a(this);
    }
    try
    {
      paramClass.getDeclaredConstructor(new Class[0]);
      this.ccg.add(paramClass.getName());
      AppMethodBeat.o(193386);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = new IllegalArgumentException("Class" + paramClass.getSimpleName() + " must have default constructor in order to be automatically recreated", localNoSuchMethodException);
      AppMethodBeat.o(193386);
      throw paramClass;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd);
  }
  
  public static abstract interface b
  {
    public abstract Bundle saveState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.savedstate.b
 * JD-Core Version:    0.7.0.1
 */