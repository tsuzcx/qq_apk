package com.tencent.mobileqq.search;

import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.List;

public abstract interface SearchAdapterInterface
  extends FaceDecoder.DecodeTaskCompletionListener
{
  public static final int d = 0;
  public static final int e = 1;
  
  public abstract void a();
  
  public abstract void a(ConversationSearchAdapter.SearchResultCallBack paramSearchResultCallBack);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List paramList);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void e();
  
  public abstract int getCount();
  
  public abstract Object getItem(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchAdapterInterface
 * JD-Core Version:    0.7.0.1
 */