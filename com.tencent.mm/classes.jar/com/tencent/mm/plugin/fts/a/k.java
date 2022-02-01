package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.HashMap;

public abstract interface k
{
  public abstract a a(j paramj);
  
  public abstract void a(String paramString, m paramm, int paramInt, HashMap<String, String> paramHashMap);
  
  public abstract void addSOSHistory(String paramString1, String paramString2);
  
  public abstract void create();
  
  public abstract void deleteSOSHistory();
  
  public abstract void deleteSOSHistory(String paramString);
  
  public abstract void destroy();
  
  public abstract String getName();
  
  public abstract boolean isCreated();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.k
 * JD-Core Version:    0.7.0.1
 */