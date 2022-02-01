package com.eclipsesource.v8;

public class V8ScriptExecutionException
  extends V8ScriptException
{
  V8ScriptExecutionException(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, String paramString4, Throwable paramThrowable)
  {
    super(paramInt1, paramString1, paramInt2, paramString2, paramString3, paramInt3, paramInt4, paramString4, paramThrowable);
  }
  
  V8ScriptExecutionException(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4)
  {
    this(0, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramString4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.V8ScriptExecutionException
 * JD-Core Version:    0.7.0.1
 */