package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public final class w
  implements com.tencent.mm.plugin.chatroom.a.a
{
  public final List<String> Il(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = v.Il(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final boolean Iq(String paramString)
  {
    AppMethodBeat.i(241865);
    boolean bool = v.Iq(paramString);
    AppMethodBeat.o(241865);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, zg paramzg, String paramString3, com.tencent.mm.h.a.a.a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(101781);
    boolean bool = v.a(paramString1, paramString2, paramzg, 0, -1, paramString3, parama, paramIEvent);
    AppMethodBeat.o(101781);
    return bool;
  }
  
  public final boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(101778);
    boolean bool = v.a(paramString1, paramArrayList, paramString2);
    AppMethodBeat.o(101778);
    return bool;
  }
  
  public final String f(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(241863);
    paramList = v.a(paramList, -1, paramString);
    AppMethodBeat.o(241863);
    return paramList;
  }
  
  public final int getMembersCountByChatRoomName(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = v.getMembersCountByChatRoomName(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */