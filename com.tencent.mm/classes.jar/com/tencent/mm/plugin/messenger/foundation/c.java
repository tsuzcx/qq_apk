package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.storage.by;

public final class c
  implements ab
{
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116875);
    switch (paramadw.Zmc)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramadw = (ahy)new ahy().parseFrom(paramArrayOfByte);
      ((n)h.ax(n.class)).bzG().bxK(w.a(paramadw.ZqL));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */