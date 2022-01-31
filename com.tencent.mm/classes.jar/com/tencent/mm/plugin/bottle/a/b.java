package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  public h fnw;
  
  public b(h paramh)
  {
    this.fnw = paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.a.b
 * JD-Core Version:    0.7.0.1
 */