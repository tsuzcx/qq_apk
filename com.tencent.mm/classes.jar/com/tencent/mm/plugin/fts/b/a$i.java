package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;
import java.util.HashSet;

final class a$i
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private boolean mUC;
  private String username;
  
  public a$i(a parama, String paramString)
  {
    this.username = paramString;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136681);
    String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.mUC) });
    AppMethodBeat.o(136681);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136680);
    if (a.b(this.mUg).containsKey(this.username))
    {
      this.mUC = true;
      AppMethodBeat.o(136680);
      return true;
    }
    if (!a.c(this.mUg).add(this.username))
    {
      this.mUC = true;
      AppMethodBeat.o(136680);
      return true;
    }
    Object localObject = a.d(this.mUg).OT(this.username);
    if ((localObject != null) && (!this.mUg.H((ad)localObject)))
    {
      this.mUC = true;
      AppMethodBeat.o(136680);
      return true;
    }
    localObject = a.a(this.mUg);
    String str = this.username;
    ((com.tencent.mm.plugin.fts.a.a)localObject).mQx.bindLong(1, 2L);
    ((com.tencent.mm.plugin.fts.a.a)localObject).mQx.bindString(2, str);
    ((com.tencent.mm.plugin.fts.a.a)localObject).mQx.bindLong(3, 0L);
    ((com.tencent.mm.plugin.fts.a.a)localObject).mQx.execute();
    AppMethodBeat.o(136680);
    return true;
  }
  
  public final String getName()
  {
    return "MarkContactTimestampTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.i
 * JD-Core Version:    0.7.0.1
 */