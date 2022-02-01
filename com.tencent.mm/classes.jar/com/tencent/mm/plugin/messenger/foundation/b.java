package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.storage.bh;

public final class b
  implements u
{
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116875);
    switch (paramxd.CYY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramxd = (zr)new zr().parseFrom(paramArrayOfByte);
      ((k)g.ab(k.class)).apR().aIl(z.a(paramxd.Dby));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */