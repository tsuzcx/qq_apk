package com.tencent.mm.plugin.datapreloader;

import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/datapreloader/FutureTask$1$2", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FutureTask$1$2
  implements p
{
  FutureTask$1$2(a<_key, _value, T> parama, q paramq) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(260480);
    ar.a(this.xfN.getScope(), s.X(this.xfN.TAG, ", onDestroy"));
    this.eF.getLifecycle().removeObserver((p)this);
    AppMethodBeat.o(260480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.FutureTask.1.2
 * JD-Core Version:    0.7.0.1
 */