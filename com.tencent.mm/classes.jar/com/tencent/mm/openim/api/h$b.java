package com.tencent.mm.openim.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/api/OpenIMKefuConstants$OpenIMKefuContactConfirmType;", "", "()V", "DEFAULT", "", "OPENIM_KEFU_CONTACT_CONFIRM_TYPE_ADD_CONTACT", "OPENIM_KEFU_CONTACT_CONFIRM_TYPE_SHOW", "needConfirm", "", "confirmType", "showConfirm", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$b
{
  public static final b prj;
  
  static
  {
    AppMethodBeat.i(235780);
    prj = new b();
    AppMethodBeat.o(235780);
  }
  
  public static final boolean xE(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static final boolean xF(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.api.h.b
 * JD-Core Version:    0.7.0.1
 */