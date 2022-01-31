package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.protocal.protobuf.rc;
import java.util.ArrayList;
import java.util.List;

public final class o
  implements com.tencent.mm.plugin.chatroom.a.b
{
  public final boolean N(String paramString, int paramInt)
  {
    AppMethodBeat.i(5551);
    boolean bool = n.N(paramString, paramInt);
    AppMethodBeat.o(5551);
    return bool;
  }
  
  public final String R(List<String> paramList)
  {
    AppMethodBeat.i(5550);
    paramList = n.f(paramList, -1);
    AppMethodBeat.o(5550);
    return paramList;
  }
  
  public final boolean a(String paramString1, String paramString2, rc paramrc, String paramString3, a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(5552);
    boolean bool = n.a(paramString1, paramString2, paramrc, 0, paramString3, parama, paramb);
    AppMethodBeat.o(5552);
    return bool;
  }
  
  public final boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(5549);
    boolean bool = n.a(paramString1, paramArrayList, paramString2);
    AppMethodBeat.o(5549);
    return bool;
  }
  
  public final List<String> nt(String paramString)
  {
    AppMethodBeat.i(5547);
    paramString = n.nt(paramString);
    AppMethodBeat.o(5547);
    return paramString;
  }
  
  public final int nv(String paramString)
  {
    AppMethodBeat.i(5548);
    int i = n.nv(paramString);
    AppMethodBeat.o(5548);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.o
 * JD-Core Version:    0.7.0.1
 */