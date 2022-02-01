package com.tencent.mm.plugin.collect.model.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public b wZP;
  
  private d()
  {
    AppMethodBeat.i(63892);
    this.wZP = new b();
    AppMethodBeat.o(63892);
  }
  
  public final int ami(String paramString)
  {
    AppMethodBeat.i(63893);
    int i = this.wZP.ami(paramString);
    AppMethodBeat.o(63893);
    return i;
  }
  
  static final class a
  {
    static d wZQ;
    
    static
    {
      AppMethodBeat.i(63891);
      wZQ = new d((byte)0);
      AppMethodBeat.o(63891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.d
 * JD-Core Version:    0.7.0.1
 */