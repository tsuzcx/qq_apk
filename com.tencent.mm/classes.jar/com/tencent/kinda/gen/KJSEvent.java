package com.tencent.kinda.gen;

import java.util.HashMap;

public abstract interface KJSEvent
{
  public abstract void kindaCloseWebViewImpl(boolean paramBoolean, VoidCallback paramVoidCallback);
  
  public abstract void kindaEndWithResult(String paramString, HashMap<String, String> paramHashMap);
  
  public abstract KindaJSEventType kindaGetType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KJSEvent
 * JD-Core Version:    0.7.0.1
 */