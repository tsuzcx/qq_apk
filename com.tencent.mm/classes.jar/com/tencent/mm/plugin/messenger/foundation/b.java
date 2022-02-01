package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.storage.bk;

public final class b
  implements u
{
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116875);
    switch (paramxv.ErL)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramxv = (aaq)new aaq().parseFrom(paramArrayOfByte);
      ((k)g.ab(k.class)).awG().aNG(z.a(paramxv.EuE));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */