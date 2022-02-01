package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.chatroom.d.u;
import com.tencent.mm.chatroom.d.w;
import com.tencent.mm.protocal.protobuf.etd;
import com.tencent.mm.sdk.platformtools.Log;

public class c$a
  implements com.tencent.mm.am.h
{
  public c$a()
  {
    AppMethodBeat.i(182078);
    com.tencent.mm.kernel.h.aZW().a(3618, this);
    com.tencent.mm.kernel.h.aZW().a(3854, this);
    AppMethodBeat.o(182078);
  }
  
  public static void a(String paramString, int paramInt, etd parametd)
  {
    AppMethodBeat.i(182080);
    com.tencent.mm.kernel.h.aZW().a(new u(paramString, paramInt, parametd), 0);
    AppMethodBeat.o(182080);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, etd parametd)
  {
    AppMethodBeat.i(241461);
    com.tencent.mm.kernel.h.aZW().a(new w(paramString1, paramString2, paramString3, parametd), 0);
    AppMethodBeat.o(241461);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(182079);
    com.tencent.mm.kernel.h.aZW().b(3618, this);
    com.tencent.mm.kernel.h.aZW().b(3854, this);
    super.finalize();
    AppMethodBeat.o(182079);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(182081);
    Log.i("MicroMsg.roomTodo.RoomTodoMsg", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    AppMethodBeat.o(182081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.c.a
 * JD-Core Version:    0.7.0.1
 */