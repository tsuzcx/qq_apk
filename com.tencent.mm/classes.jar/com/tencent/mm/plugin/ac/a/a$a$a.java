package com.tencent.mm.plugin.ac.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.sql.ISqlOrder;
import com.tencent.mm.sdk.storage.sql.ISqlOrder.DefaultImpls;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mvvmstorage/contact/MvvmContactStorage$Companion$getShowHeadOrder$1", "Lcom/tencent/mm/sdk/storage/sql/ISqlOrder;", "toSql", "", "plugin-mvvmstorage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a$a
  implements ISqlOrder
{
  public final String[] params()
  {
    AppMethodBeat.i(262742);
    String[] arrayOfString = ISqlOrder.DefaultImpls.params((ISqlOrder)this);
    AppMethodBeat.o(262742);
    return arrayOfString;
  }
  
  public final String toSql()
  {
    AppMethodBeat.i(262735);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(262735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */