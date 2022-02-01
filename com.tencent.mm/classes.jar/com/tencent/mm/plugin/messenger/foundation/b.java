package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.storage.br;

public final class b
  implements x
{
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116875);
    switch (paramzx.Gru)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramzx = (acz)new acz().parseFrom(paramArrayOfByte);
      ((l)g.ab(l.class)).azL().aUY(z.a(paramzx.GuF));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */