package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.z;

final class f$5
  implements z
{
  f$5(f paramf) {}
  
  public final boolean accept(q paramq, String paramString)
  {
    AppMethodBeat.i(198901);
    boolean bool = paramString.startsWith("EnMicroMsg.dberr");
    AppMethodBeat.o(198901);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.f.5
 * JD-Core Version:    0.7.0.1
 */