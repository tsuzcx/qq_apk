package com.tencent.mm.plugin.datareport.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
  implements b
{
  private static volatile a xhs;
  private b xhq;
  private b xhr;
  
  private a()
  {
    AppMethodBeat.i(262933);
    this.xhq = new com.tencent.mm.plugin.datareport.g.a.a.a();
    this.xhr = new com.tencent.mm.plugin.datareport.g.a.b.a();
    AppMethodBeat.o(262933);
  }
  
  public static a dtv()
  {
    AppMethodBeat.i(262940);
    if (xhs == null) {}
    try
    {
      if (xhs == null) {
        xhs = new a();
      }
      a locala = xhs;
      AppMethodBeat.o(262940);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(262940);
    }
  }
  
  public final void a(com.tencent.mm.plugin.datareport.g.b.a parama)
  {
    AppMethodBeat.i(262957);
    if (parama == null)
    {
      AppMethodBeat.o(262957);
      return;
    }
    if (this.xhq != null) {
      this.xhq.a(parama);
    }
    if (this.xhr != null) {
      this.xhr.a(parama);
    }
    AppMethodBeat.o(262957);
  }
  
  public final void startMonitor()
  {
    AppMethodBeat.i(262949);
    if (this.xhq != null) {
      this.xhq.startMonitor();
    }
    if (this.xhr != null) {
      this.xhr.startMonitor();
    }
    AppMethodBeat.o(262949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.a
 * JD-Core Version:    0.7.0.1
 */