package com.tencent.mm.plugin.game.api;

import com.tencent.mm.kernel.c.a;
import org.json.JSONArray;

public abstract interface c
  extends a
{
  public abstract String PM(String paramString);
  
  public abstract String a(int paramInt1, int paramInt2, JSONArray paramJSONArray, String paramString, boolean paramBoolean);
  
  public abstract JSONArray b(JSONArray paramJSONArray, boolean paramBoolean);
  
  public abstract void c(JSONArray paramJSONArray, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.api.c
 * JD-Core Version:    0.7.0.1
 */