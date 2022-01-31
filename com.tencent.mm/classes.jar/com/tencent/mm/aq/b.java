package com.tencent.mm.aq;

import android.content.ContentValues;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  h dXo;
  
  public b(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(a parama)
  {
    parama.bcw = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.bcw & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.bcw & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.eml));
    }
    if ((parama.bcw & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.bcw & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.emm));
    }
    if ((parama.bcw & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.dXk));
    }
    if ((parama.bcw & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.emn));
    }
    if ((parama.bcw & 0x40) != 0) {
      localContentValues.put("reserved3", parama.Oj());
    }
    if ((parama.bcw & 0x80) != 0) {
      localContentValues.put("reserved4", parama.Ok());
    }
    if ((int)this.dXo.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      aam(parama.getUsername());
      return true;
    }
    return false;
  }
  
  public final boolean lU(String paramString)
  {
    if (this.dXo.delete("getcontactinfov2", "username= ?", new String[] { paramString }) > 0)
    {
      aam(paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.b
 * JD-Core Version:    0.7.0.1
 */