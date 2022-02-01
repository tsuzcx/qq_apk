package com.tencent.mm.ae;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
final class d$e
  extends u
  implements a<ah>
{
  d$e(LiveData<T> paramLiveData, y<T> paramy)
  {
    super(0);
  }
  
  private static final void c(LiveData paramLiveData, y paramy)
  {
    AppMethodBeat.i(233424);
    s.u(paramLiveData, "$this_observeForeverWithNotify");
    s.u(paramy, "$observer");
    paramLiveData = paramLiveData.getValue();
    if (paramLiveData != null) {
      paramy.onChanged(paramLiveData);
    }
    AppMethodBeat.o(233424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.d.e
 * JD-Core Version:    0.7.0.1
 */