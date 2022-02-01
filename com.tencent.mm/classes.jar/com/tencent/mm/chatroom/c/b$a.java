package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.r;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.sdk.platformtools.ad;

public final class b$a
  implements com.tencent.mm.al.g
{
  public b$a()
  {
    AppMethodBeat.i(182078);
    com.tencent.mm.kernel.g.aeS().a(3618, this);
    com.tencent.mm.kernel.g.aeS().a(3854, this);
    AppMethodBeat.o(182078);
  }
  
  public static void a(String paramString, int paramInt, clz paramclz)
  {
    AppMethodBeat.i(182080);
    com.tencent.mm.kernel.g.aeS().a(new r(paramString, paramInt, paramclz), 0);
    AppMethodBeat.o(182080);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(182079);
    com.tencent.mm.kernel.g.aeS().b(3618, this);
    com.tencent.mm.kernel.g.aeS().b(3854, this);
    super.finalize();
    AppMethodBeat.o(182079);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182081);
    ad.i("MicroMsg.roomTodo.RoomTodoMsg", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    AppMethodBeat.o(182081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.b.a
 * JD-Core Version:    0.7.0.1
 */