package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
{
  Map<Integer, Object<?>> oQZ;
  public IListener oRa;
  public IListener oRb;
  
  public r()
  {
    AppMethodBeat.i(150833);
    this.oQZ = new ConcurrentHashMap();
    this.oRa = new PackageChangeListener.1(this, f.hfK);
    this.oRb = new PackageChangeListener.2(this, f.hfK);
    AppMethodBeat.o(150833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.r
 * JD-Core Version:    0.7.0.1
 */