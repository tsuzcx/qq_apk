package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.protocal.protobuf.ua;
import java.util.ArrayList;
import java.util.List;

public final class r
  implements com.tencent.mm.plugin.chatroom.a.b
{
  public final boolean GN(String paramString)
  {
    AppMethodBeat.i(210532);
    boolean bool = q.GN(paramString);
    AppMethodBeat.o(210532);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, ua paramua, String paramString3, a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(101781);
    boolean bool = q.a(paramString1, paramString2, paramua, 0, -1, paramString3, parama, paramb);
    AppMethodBeat.o(101781);
    return bool;
  }
  
  public final boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(101778);
    boolean bool = q.a(paramString1, paramArrayList, paramString2);
    AppMethodBeat.o(101778);
    return bool;
  }
  
  public final String ae(List<String> paramList)
  {
    AppMethodBeat.i(101779);
    paramList = q.e(paramList, -1);
    AppMethodBeat.o(101779);
    return paramList;
  }
  
  public final List<String> vZ(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = q.vZ(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final int wb(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = q.wb(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */