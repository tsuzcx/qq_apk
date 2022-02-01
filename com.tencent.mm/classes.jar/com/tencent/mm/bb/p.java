package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.sdk.event.IListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
{
  Map<Integer, Object<?>> jhs;
  public IListener jht;
  public IListener jhu;
  
  public p()
  {
    AppMethodBeat.i(150833);
    this.jhs = new ConcurrentHashMap();
    this.jht = new IListener() {};
    this.jhu = new IListener() {};
    AppMethodBeat.o(150833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.p
 * JD-Core Version:    0.7.0.1
 */