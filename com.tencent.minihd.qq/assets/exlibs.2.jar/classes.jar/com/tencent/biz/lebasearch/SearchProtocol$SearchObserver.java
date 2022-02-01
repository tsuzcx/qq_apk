package com.tencent.biz.lebasearch;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public abstract interface SearchProtocol$SearchObserver
{
  public abstract void a(int paramInt, SearchProtocol.WordItem paramWordItem);
  
  public abstract void a(int paramInt, ArrayList paramArrayList);
  
  public abstract void a(int paramInt, List paramList);
  
  public abstract void a(int paramInt, JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol.SearchObserver
 * JD-Core Version:    0.7.0.1
 */