package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.da;
import com.tencent.mm.f.a.zx;
import com.tencent.mm.sdk.event.IListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class q
{
  Map<Integer, Object<?>> lXV;
  public IListener lXW;
  public IListener lXX;
  
  public q()
  {
    AppMethodBeat.i(150833);
    this.lXV = new ConcurrentHashMap();
    this.lXW = new IListener() {};
    this.lXX = new IListener() {};
    AppMethodBeat.o(150833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.q
 * JD-Core Version:    0.7.0.1
 */