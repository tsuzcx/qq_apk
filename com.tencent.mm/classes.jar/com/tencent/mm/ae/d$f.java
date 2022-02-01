package com.tencent.mm.ae;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
final class d$f
  extends u
  implements a<ah>
{
  d$f(LiveData<T> paramLiveData, q paramq, y<T> paramy)
  {
    super(0);
  }
  
  private static final void b(LiveData paramLiveData, q paramq, y paramy)
  {
    AppMethodBeat.i(233423);
    s.u(paramLiveData, "$this_observeWithNotify");
    s.u(paramq, "$owner");
    s.u(paramy, "$observer");
    paramLiveData = paramLiveData.getValue();
    if ((paramLiveData != null) && (paramq.getLifecycle().getCurrentState().d(j.b.bHj))) {
      paramy.onChanged(paramLiveData);
    }
    AppMethodBeat.o(233423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.d.f
 * JD-Core Version:    0.7.0.1
 */