package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Option
{
  public String mContent;
  public boolean mEnabled;
  
  public Option() {}
  
  public Option(String paramString, boolean paramBoolean)
  {
    this.mContent = paramString;
    this.mEnabled = paramBoolean;
  }
  
  public final String getContent()
  {
    return this.mContent;
  }
  
  public final boolean getEnabled()
  {
    return this.mEnabled;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(141439);
    String str = "Option{mContent=" + this.mContent + ",mEnabled=" + this.mEnabled + "}";
    AppMethodBeat.o(141439);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.Option
 * JD-Core Version:    0.7.0.1
 */