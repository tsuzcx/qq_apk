package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.s;
import androidx.savedstate.b;
import androidx.savedstate.c;
import androidx.savedstate.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

class v
  implements d
{
  s mLifecycleRegistry = null;
  c mSavedStateRegistryController = null;
  
  final void a(j.a parama)
  {
    AppMethodBeat.i(193518);
    this.mLifecycleRegistry.a(parama);
    AppMethodBeat.o(193518);
  }
  
  public j getLifecycle()
  {
    AppMethodBeat.i(193509);
    initialize();
    s locals = this.mLifecycleRegistry;
    AppMethodBeat.o(193509);
    return locals;
  }
  
  public b getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.ccj;
  }
  
  final void initialize()
  {
    AppMethodBeat.i(193501);
    if (this.mLifecycleRegistry == null)
    {
      this.mLifecycleRegistry = new s(this);
      this.mSavedStateRegistryController = c.b(this);
    }
    AppMethodBeat.o(193501);
  }
  
  final void m(Bundle paramBundle)
  {
    AppMethodBeat.i(193532);
    this.mSavedStateRegistryController.m(paramBundle);
    AppMethodBeat.o(193532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.v
 * JD-Core Version:    0.7.0.1
 */