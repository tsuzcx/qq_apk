package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.protocal.protobuf.vy;
import java.util.ArrayList;
import java.util.List;

public final class s
  implements com.tencent.mm.plugin.chatroom.a.b
{
  public final boolean a(String paramString1, String paramString2, vy paramvy, String paramString3, a parama, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(101781);
    boolean bool = r.a(paramString1, paramString2, paramvy, 0, -1, paramString3, parama, paramb);
    AppMethodBeat.o(101781);
    return bool;
  }
  
  public final boolean a(String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(101778);
    boolean bool = r.a(paramString1, paramArrayList, paramString2);
    AppMethodBeat.o(101778);
    return bool;
  }
  
  public final String af(List<String> paramList)
  {
    AppMethodBeat.i(101779);
    paramList = r.e(paramList, -1);
    AppMethodBeat.o(101779);
    return paramList;
  }
  
  public final List<String> zA(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = r.zA(paramString);
    AppMethodBeat.o(101776);
    return paramString;
  }
  
  public final int zC(String paramString)
  {
    AppMethodBeat.i(101777);
    int i = r.zC(paramString);
    AppMethodBeat.o(101777);
    return i;
  }
  
  public final boolean zF(String paramString)
  {
    AppMethodBeat.i(209890);
    boolean bool = r.zF(paramString);
    AppMethodBeat.o(209890);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.s
 * JD-Core Version:    0.7.0.1
 */