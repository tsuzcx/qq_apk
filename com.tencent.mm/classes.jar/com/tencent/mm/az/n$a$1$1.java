package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bjn;

final class n$a$1$1
  implements Runnable
{
  n$a$1$1(n.a.1 param1, j.b paramb, int paramInt, bjn parambjn) {}
  
  public final void run()
  {
    AppMethodBeat.i(993);
    n localn = this.fMj.fMf;
    int i = this.fMg.getCmdId();
    int j = this.fMh;
    String str1;
    if (this.fMi == null)
    {
      str1 = "";
      if (this.fMi != null) {
        break label77;
      }
    }
    label77:
    for (String str2 = "";; str2 = this.fMi.ntu)
    {
      localn.c(i, j, str1, str2);
      AppMethodBeat.o(993);
      return;
      str1 = this.fMi.Title;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.az.n.a.1.1
 * JD-Core Version:    0.7.0.1
 */