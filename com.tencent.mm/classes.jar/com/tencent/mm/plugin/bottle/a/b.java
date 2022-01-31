package com.tencent.mm.plugin.bottle.a;

import android.content.ContentValues;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  public h dXo;
  
  public b(h paramh)
  {
    this.dXo = paramh;
  }
  
  public final boolean a(a parama)
  {
    parama.bcw = -1;
    ContentValues localContentValues = new ContentValues();
    String str;
    if ((parama.bcw & 0x1) != 0)
    {
      if (parama.hYd == null)
      {
        str = "";
        localContentValues.put("parentclientid", str);
      }
    }
    else
    {
      if ((parama.bcw & 0x2) != 0) {
        localContentValues.put("childcount", Integer.valueOf(parama.hYe));
      }
      if ((parama.bcw & 0x4) != 0) {
        localContentValues.put("bottleid", parama.awE());
      }
      if ((parama.bcw & 0x8) != 0) {
        localContentValues.put("bottletype", Integer.valueOf(parama.hYg));
      }
      if ((parama.bcw & 0x10) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(parama.msgType));
      }
      if ((parama.bcw & 0x20) != 0) {
        localContentValues.put("voicelen", Integer.valueOf(parama.hYh));
      }
      if ((parama.bcw & 0x40) != 0) {
        localContentValues.put("content", parama.getContent());
      }
      if ((parama.bcw & 0x80) != 0) {
        localContentValues.put("createtime", Long.valueOf(parama.hYi));
      }
      if ((parama.bcw & 0x100) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(parama.dXk));
      }
      if ((parama.bcw & 0x200) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(parama.emn));
      }
      if ((parama.bcw & 0x400) != 0)
      {
        if (parama.dXm != null) {
          break label324;
        }
        str = "";
        label262:
        localContentValues.put("reserved3", str);
      }
      if ((parama.bcw & 0x800) != 0) {
        if (parama.dXn != null) {
          break label332;
        }
      }
    }
    label324:
    label332:
    for (parama = "";; parama = parama.dXn)
    {
      localContentValues.put("reserved4", parama);
      if ((int)this.dXo.insert("bottleinfo1", "bottleid", localContentValues) == -1) {
        break label340;
      }
      return true;
      str = parama.hYd;
      break;
      str = parama.dXm;
      break label262;
    }
    label340:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.b
 * JD-Core Version:    0.7.0.1
 */