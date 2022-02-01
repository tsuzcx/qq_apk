package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public boolean JHA;
  public com.tencent.mm.plugin.ipcall.model.a.a JHB;
  public final Object JHy;
  public int JHz;
  public boolean isStart;
  public c wTy;
  
  public a(com.tencent.mm.plugin.ipcall.model.a.a parama)
  {
    AppMethodBeat.i(303695);
    this.wTy = null;
    this.JHy = new Object();
    this.isStart = false;
    this.JHz = 0;
    this.JHA = false;
    this.JHB = parama;
    AppMethodBeat.o(303695);
  }
  
  public final class a
    implements Runnable
  {
    private c JHD = null;
    
    public a(c paramc)
    {
      this.JHD = paramc;
    }
    
    public final void run()
    {
      AppMethodBeat.i(25414);
      if (this.JHD != null)
      {
        this.JHD.hVF();
        this.JHD.hVC();
        this.JHD = null;
        a.this.JHA = false;
      }
      a.this.JHB.cTP();
      AppMethodBeat.o(25414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.c.a
 * JD-Core Version:    0.7.0.1
 */