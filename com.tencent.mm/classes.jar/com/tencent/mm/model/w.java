package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public final class w
  implements b
{
  public final List<String> Ic(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = v.Ic(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final int Ie(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = v.Ie(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
  
  public final boolean Ih(String paramString)
  {
    AppMethodBeat.i(194529);
    boolean bool = v.Ih(paramString);
    AppMethodBeat.o(194529);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, xg paramxg, String paramString3, a parama, IEvent paramIEvent)
  {
    AppMethodBeat.i(101781);
    boolean bool = v.a(paramString1, paramString2, paramxg, 0, -1, paramString3, parama, paramIEvent);
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
  
  public final String ao(List<String> paramList)
  {
    AppMethodBeat.i(101779);
    paramList = v.e(paramList, -1);
    AppMethodBeat.o(101779);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */