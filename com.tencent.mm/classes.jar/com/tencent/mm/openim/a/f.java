package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.bx.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactExtension;", "Lcom/tencent/mm/storage/IContactStorage$IContactExtension;", "()V", "get", "Lcom/tencent/mm/storage/Contact;", "username", "", "onPreInsertContact", "", "stg", "Lcom/tencent/mm/storage/IContactStorage;", "contact", "replace", "", "isUpdate", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements bx.a
{
  public static final a prV;
  
  static
  {
    AppMethodBeat.i(236028);
    prV = new a((byte)0);
    AppMethodBeat.o(236028);
  }
  
  public final au JE(String paramString)
  {
    AppMethodBeat.i(236042);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236042);
      return null;
    }
    if (!au.bwQ(paramString))
    {
      AppMethodBeat.o(236042);
      return null;
    }
    paramString = g.RM(paramString);
    AppMethodBeat.o(236042);
    return paramString;
  }
  
  public final void a(bx parambx, au paramau) {}
  
  public final int b(au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(236037);
    if ((paramau == null) || (!au.bwQ(paramau.field_username)))
    {
      AppMethodBeat.o(236037);
      return -1;
    }
    AppMethodBeat.o(236037);
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/contact/OpenIMKefuContactExtension$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.a.f
 * JD-Core Version:    0.7.0.1
 */