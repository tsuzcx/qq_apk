package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import java.util.HashMap;

public abstract interface k
{
  public abstract c a(l paraml);
  
  public abstract void a(String paramString, o paramo, int paramInt, HashMap<String, String> paramHashMap);
  
  public abstract void addSOSHistory(String paramString1, String paramString2);
  
  public abstract void create();
  
  public abstract void deleteSOSHistory();
  
  public abstract void deleteSOSHistory(String paramString);
  
  public abstract void destroy();
  
  public abstract String getName();
  
  public abstract boolean isCreated();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.k
 * JD-Core Version:    0.7.0.1
 */