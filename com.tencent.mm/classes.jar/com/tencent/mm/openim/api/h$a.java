package com.tencent.mm.openim.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/api/OpenIMKefuConstants$ConfirmPageType;", "", "()V", "SHOW_DIALOG", "", "SHOW_FULL_UI", "getConfirmPageType", "scene", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$a
{
  public static final a pri;
  
  static
  {
    AppMethodBeat.i(235777);
    pri = new a();
    AppMethodBeat.o(235777);
  }
  
  public static final int xD(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.api.h.a
 * JD-Core Version:    0.7.0.1
 */