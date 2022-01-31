package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class l
{
  private static volatile l hbk;
  public final Set<l.b> hbl;
  public volatile asz hbm;
  public final Object mLock;
  
  public l()
  {
    AppMethodBeat.i(129566);
    this.mLock = new Object();
    this.hbl = new HashSet();
    this.hbm = null;
    AppMethodBeat.o(129566);
  }
  
  public static l axc()
  {
    AppMethodBeat.i(129567);
    if (hbk == null) {}
    try
    {
      if (hbk == null) {
        hbk = new l();
      }
      l locall = hbk;
      AppMethodBeat.o(129567);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(129567);
    }
  }
  
  public static boolean enabled()
  {
    AppMethodBeat.i(129569);
    if (g.RG())
    {
      Object localObject = com.tencent.mm.model.c.c.abU().me("100328");
      if (((com.tencent.mm.storage.c)localObject).isValid())
      {
        localObject = l.a.ns(bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("isOpenGameEntry"), 0));
        if ((localObject != null) && (localObject == l.a.hbp))
        {
          AppMethodBeat.o(129569);
          return true;
        }
      }
    }
    AppMethodBeat.o(129569);
    return false;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(129568);
    this.hbm = null;
    b.a locala = new b.a();
    locala.funcId = 1841;
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxagame";
    locala.fsX = new asy();
    locala.fsY = new asz();
    w.a(locala.ado(), new l.1(this));
    AppMethodBeat.o(129568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.l
 * JD-Core Version:    0.7.0.1
 */