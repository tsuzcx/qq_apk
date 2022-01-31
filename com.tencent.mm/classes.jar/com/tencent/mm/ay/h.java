package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.e.j;

public final class h
  extends j
  implements i
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) " };
  com.tencent.mm.cf.h dXo;
  
  public h(com.tencent.mm.cf.h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(i.b paramb)
  {
    if (paramb == null) {}
    while (this.dXo.delete("oplog2", "id= ? AND inserTime= ?", new String[] { paramb.id, paramb.eml }) >= 0) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ay.h
 * JD-Core Version:    0.7.0.1
 */