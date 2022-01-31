package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;
import java.util.HashSet;

final class a$i
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private boolean kyN;
  private String username;
  
  public a$i(a parama, String paramString)
  {
    this.username = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{username: %s isSkipped: %b}", new Object[] { this.username, Boolean.valueOf(this.kyN) });
  }
  
  public final boolean execute()
  {
    if (a.b(this.kyt).containsKey(this.username))
    {
      this.kyN = true;
      return true;
    }
    if (!a.c(this.kyt).add(this.username))
    {
      this.kyN = true;
      return true;
    }
    Object localObject = a.d(this.kyt).DK(this.username);
    if ((localObject != null) && (!this.kyt.G((ad)localObject)))
    {
      this.kyN = true;
      return true;
    }
    localObject = a.a(this.kyt);
    String str = this.username;
    ((com.tencent.mm.plugin.fts.a.a)localObject).kuK.bindLong(1, 2L);
    ((com.tencent.mm.plugin.fts.a.a)localObject).kuK.bindString(2, str);
    ((com.tencent.mm.plugin.fts.a.a)localObject).kuK.bindLong(3, 0L);
    ((com.tencent.mm.plugin.fts.a.a)localObject).kuK.execute();
    return true;
  }
  
  public final String getName()
  {
    return "MarkContactTimestampTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.i
 * JD-Core Version:    0.7.0.1
 */