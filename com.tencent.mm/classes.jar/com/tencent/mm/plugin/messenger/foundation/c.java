package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.storage.bw;

public final class c
  implements ab
{
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116875);
    switch (paramabu.SnG)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramabu = (afl)new afl().parseFrom(paramArrayOfByte);
      ((n)h.ae(n.class)).bbR().bwv(z.a(paramabu.SrH));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.c
 * JD-Core Version:    0.7.0.1
 */