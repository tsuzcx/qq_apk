package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.storage.be;

public final class b
  implements r
{
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean, u paramu)
  {
    AppMethodBeat.i(1024);
    switch (paramud.wMC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(1024);
      return;
      paramud = (wm)new wm().parseFrom(paramArrayOfByte);
      ((j)g.E(j.class)).YF().arF(aa.a(paramud.wOT));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */