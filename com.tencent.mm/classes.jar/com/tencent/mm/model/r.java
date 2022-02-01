package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.protocal.protobuf.tq;
import java.util.ArrayList;
import java.util.List;

public final class r
  implements com.tencent.mm.plugin.chatroom.a.b
{
  public final boolean U(String paramString, int paramInt)
  {
    AppMethodBeat.i(101780);
    boolean bool = q.U(paramString, paramInt);
    AppMethodBeat.o(101780);
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, tq paramtq, String paramString3, a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(101781);
    boolean bool = q.a(paramString1, paramString2, paramtq, 0, paramString3, parama, paramb);
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
  
  public final String ah(List<String> paramList)
  {
    AppMethodBeat.i(101779);
    paramList = q.e(paramList, -1);
    AppMethodBeat.o(101779);
    return paramList;
  }
  
  public final List<String> rW(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = q.rW(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final int rY(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = q.rY(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */