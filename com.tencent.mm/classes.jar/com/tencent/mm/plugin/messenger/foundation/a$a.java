package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.storage.ad;

final class a$a
  extends a<c>
  implements c
{
  public final void a(ad paramad1, ad paramad2, bdt parambdt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(1018);
    a(new a.a.1(this, paramad1, paramad2, parambdt, paramArrayOfByte, paramBoolean));
    AppMethodBeat.o(1018);
  }
  
  public final void b(ad paramad1, ad paramad2, bdt parambdt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(1019);
    a(new a.a.2(this, paramad1, paramad2, parambdt, paramArrayOfByte, paramBoolean));
    AppMethodBeat.o(1019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a
 * JD-Core Version:    0.7.0.1
 */