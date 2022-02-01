package com.tencent.mm.api;

import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.rq;
import java.util.List;

public abstract interface s
{
  public abstract void a(String paramString, i parami, db paramdb);
  
  public abstract void a(String paramString, i parami, db paramdb, List<db> paramList);
  
  public abstract void a(String paramString, rq paramrq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.s
 * JD-Core Version:    0.7.0.1
 */