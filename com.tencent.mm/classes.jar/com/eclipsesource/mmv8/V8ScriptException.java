package com.eclipsesource.mmv8;

public abstract class V8ScriptException
  extends V8RuntimeException
{
  private final int contextTag;
  private final int endColumn;
  private final String fileName;
  private final String jsMessage;
  private final String jsStackTrace;
  private final int lineNumber;
  private final String sourceLine;
  private final int startColumn;
  
  V8ScriptException(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, String paramString4, Throwable paramThrowable)
  {
    this.contextTag = paramInt1;
    this.fileName = paramString1;
    this.lineNumber = paramInt2;
    this.jsMessage = paramString2;
    this.sourceLine = paramString3;
    this.startColumn = paramInt3;
    this.endColumn = paramInt4;
    this.jsStackTrace = paramString4;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
  
  private char[] createCharSequence(int paramInt, char paramChar)
  {
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfChar[i] = paramChar;
      i += 1;
    }
    return arrayOfChar;
  }
  
  private String createJSStackDetails()
  {
    if (this.jsStackTrace != null) {
      return "\n" + this.jsStackTrace;
    }
    return "";
  }
  
  private String createMessageDetails()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.sourceLine != null) && (!this.sourceLine.isEmpty()))
    {
      localStringBuilder.append('\n');
      localStringBuilder.append(this.sourceLine);
      localStringBuilder.append('\n');
      if (this.startColumn >= 0)
      {
        localStringBuilder.append(createCharSequence(this.startColumn, ' '));
        localStringBuilder.append(createCharSequence(this.endColumn - this.startColumn, '^'));
      }
    }
    return localStringBuilder.toString();
  }
  
  private String createMessageLine()
  {
    return this.fileName + ":" + this.lineNumber + ": " + this.jsMessage;
  }
  
  public int getContextTag()
  {
    return this.contextTag;
  }
  
  public int getEndColumn()
  {
    return this.endColumn;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getJSMessage()
  {
    return this.jsMessage;
  }
  
  public String getJSStackTrace()
  {
    return this.jsStackTrace;
  }
  
  public int getLineNumber()
  {
    return this.lineNumber;
  }
  
  public String getMessage()
  {
    return createMessageLine();
  }
  
  public String getSourceLine()
  {
    return this.sourceLine;
  }
  
  public int getStartColumn()
  {
    return this.startColumn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(createMessageLine());
    localStringBuilder.append(createMessageDetails());
    localStringBuilder.append(createJSStackDetails());
    localStringBuilder.append("\n");
    localStringBuilder.append(getClass().getName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8ScriptException
 * JD-Core Version:    0.7.0.1
 */