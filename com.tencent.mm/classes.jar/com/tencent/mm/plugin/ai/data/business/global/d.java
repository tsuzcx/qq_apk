package com.tencent.mm.plugin.ai.data.business.global;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adp;
import com.tencent.mm.autogen.a.wv;
import com.tencent.mm.autogen.mmdata.rpt.i;
import com.tencent.mm.plugin.ai.b.a;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.ai.d.j;
import com.tencent.mm.plugin.ai.d.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d
{
  private static d qmw;
  public IListener<wv> qli;
  private LinkedList<g> qmt;
  public g qmu;
  public IListener<adp> qmv;
  
  private d()
  {
    AppMethodBeat.i(267515);
    this.qli = new AiSessionData.1(this, f.hfK);
    this.qmv = new AiSessionData.2(this, f.hfK);
    this.qmt = new LinkedList();
    AppMethodBeat.o(267515);
  }
  
  public static d cam()
  {
    AppMethodBeat.i(267524);
    if (qmw == null) {
      qmw = new d();
    }
    d locald = qmw;
    AppMethodBeat.o(267524);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.global.d
 * JD-Core Version:    0.7.0.1
 */