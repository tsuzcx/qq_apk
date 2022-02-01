package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.e.a;
import com.tencent.mm.ipcinvoker.e.b;

final class XIPCInvoker$b
  implements d, a
{
  d<XIPCInvoker.WrapperParcelable> fZM;
  a fZN;
  
  XIPCInvoker$b(d<XIPCInvoker.WrapperParcelable> paramd)
  {
    AppMethodBeat.i(158803);
    this.fZM = paramd;
    if ((paramd instanceof a)) {
      this.fZN = ((a)paramd);
    }
    AppMethodBeat.o(158803);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(158805);
    if (this.fZN == null)
    {
      AppMethodBeat.o(158805);
      return;
    }
    this.fZN.a(paramb);
    AppMethodBeat.o(158805);
  }
  
  public final void bf(Object paramObject)
  {
    AppMethodBeat.i(158804);
    if (this.fZM != null) {
      this.fZM.bf(new XIPCInvoker.WrapperParcelable(null, paramObject));
    }
    AppMethodBeat.o(158804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XIPCInvoker.b
 * JD-Core Version:    0.7.0.1
 */