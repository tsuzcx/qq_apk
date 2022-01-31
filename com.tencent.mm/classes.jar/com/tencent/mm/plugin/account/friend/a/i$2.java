package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.b.b;

final class i$2
  implements b.b
{
  i$2(i parami) {}
  
  public final int aqn()
  {
    AppMethodBeat.i(108340);
    int i = this.gxq.getCount();
    AppMethodBeat.o(108340);
    return i;
  }
  
  public final String mS(int paramInt)
  {
    AppMethodBeat.i(108339);
    if ((paramInt < 0) || (paramInt >= this.gxq.getCount()))
    {
      ab.e("MicroMsg.FriendAdapter", "pos is invalid");
      AppMethodBeat.o(108339);
      return null;
    }
    Object localObject = this.gxq.mR(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(108339);
      return null;
    }
    localObject = ((bai)localObject).jJA;
    AppMethodBeat.o(108339);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.i.2
 * JD-Core Version:    0.7.0.1
 */