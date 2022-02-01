package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.chatroom.d.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.Log;

public class c$a
  implements i
{
  public c$a()
  {
    AppMethodBeat.i(182078);
    h.aGY().a(3618, this);
    h.aGY().a(3854, this);
    AppMethodBeat.o(182078);
  }
  
  public static void a(String paramString, int paramInt, dzx paramdzx)
  {
    AppMethodBeat.i(182080);
    h.aGY().a(new r(paramString, paramInt, paramdzx), 0);
    AppMethodBeat.o(182080);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, dzx paramdzx)
  {
    AppMethodBeat.i(193987);
    h.aGY().a(new com.tencent.mm.chatroom.d.t(paramString1, paramString2, paramString3, paramdzx), 0);
    AppMethodBeat.o(193987);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(182079);
    h.aGY().b(3618, this);
    h.aGY().b(3854, this);
    super.finalize();
    AppMethodBeat.o(182079);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(182081);
    Log.i("MicroMsg.roomTodo.RoomTodoMsg", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    AppMethodBeat.o(182081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.c.a
 * JD-Core Version:    0.7.0.1
 */