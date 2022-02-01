package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ae;

public final class c$a
  implements f
{
  public c$a()
  {
    AppMethodBeat.i(182078);
    g.ajj().a(3618, this);
    g.ajj().a(3854, this);
    AppMethodBeat.o(182078);
  }
  
  public static void a(String paramString, int paramInt, cxh paramcxh)
  {
    AppMethodBeat.i(182080);
    g.ajj().a(new r(paramString, paramInt, paramcxh), 0);
    AppMethodBeat.o(182080);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(182079);
    g.ajj().b(3618, this);
    g.ajj().b(3854, this);
    super.finalize();
    AppMethodBeat.o(182079);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(182081);
    ae.i("MicroMsg.roomTodo.RoomTodoMsg", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    AppMethodBeat.o(182081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.c.a
 * JD-Core Version:    0.7.0.1
 */