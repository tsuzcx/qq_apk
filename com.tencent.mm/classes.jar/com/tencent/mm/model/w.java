package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public final class w
  implements com.tencent.mm.plugin.chatroom.a.a
{
  public final List<String> Ps(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = v.Ps(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final int Pu(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = v.Pu(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
  
  public final boolean Px(String paramString)
  {
    AppMethodBeat.i(258788);
    boolean bool = v.Px(paramString);
    AppMethodBeat.o(258788);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, xm paramxm, String paramString3, com.tencent.mm.k.a.a.a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(101781);
    boolean bool = v.a(paramString1, paramString2, paramxm, 0, -1, paramString3, parama, paramIEvent);
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
  
  public final String am(List<String> paramList)
  {
    AppMethodBeat.i(101779);
    paramList = v.e(paramList, -1);
    AppMethodBeat.o(101779);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */