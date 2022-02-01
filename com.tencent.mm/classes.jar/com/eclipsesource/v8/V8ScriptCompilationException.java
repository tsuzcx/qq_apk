package com.eclipsesource.v8;

public class V8ScriptCompilationException
  extends V8ScriptException
{
  V8ScriptCompilationException(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramString1, paramInt2, paramString2, paramString3, paramInt3, paramInt4, null, null);
  }
  
  V8ScriptCompilationException(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    super(0, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.V8ScriptCompilationException
 * JD-Core Version:    0.7.0.1
 */