package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.storage.bq;

public final class b
  implements w
{
  public final void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.z paramz)
  {
    AppMethodBeat.i(116875);
    switch (paramzu.FYU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramzu = (acq)new acq().parseFrom(paramArrayOfByte);
      ((l)g.ab(l.class)).azv().aTx(com.tencent.mm.platformtools.z.a(paramzu.GbY));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */