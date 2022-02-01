package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.storage.bw;

public final class b
  implements x
{
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116875);
    switch (paramabn.Lms)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116875);
      return;
      paramabn = (afc)new afc().parseFrom(paramArrayOfByte);
      ((l)g.af(l.class)).aST().bjW(z.a(paramabn.Lqk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */