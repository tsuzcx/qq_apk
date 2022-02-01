package com.tencent.mm.plugin.ai.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abs;
import com.tencent.mm.f.a.vf;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.plugin.ai.f.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
{
  private static b noX;
  private LinkedList<d> noV;
  public IListener<abs> noW;
  public IListener<vf> nob;
  
  private b()
  {
    AppMethodBeat.i(239360);
    this.nob = new IListener() {};
    this.noW = new IListener() {};
    this.noV = new LinkedList();
    AppMethodBeat.o(239360);
  }
  
  public static b bBb()
  {
    AppMethodBeat.i(239361);
    if (noX == null) {
      noX = new b();
    }
    b localb = noX;
    AppMethodBeat.o(239361);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */