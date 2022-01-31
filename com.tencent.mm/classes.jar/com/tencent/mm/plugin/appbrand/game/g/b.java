package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.magicbrush.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static volatile Map<String, b> huR;
  private static b.d huS;
  public al huT;
  public a.a huU;
  private b.f huV;
  private c.a huW;
  private c.a huX;
  private final Runnable huY;
  
  static
  {
    AppMethodBeat.i(143252);
    huR = new HashMap(1);
    huS = b.d.hvp;
    AppMethodBeat.o(143252);
  }
  
  private b(MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(143243);
    this.huV = b.f.hvr;
    this.huW = null;
    this.huX = null;
    this.huY = new b.2(this);
    this.huT = new al("wegame_screen_recorder_worker");
    if (huS != b.d.hvo) {
      this.huU = new a.b(paramMagicBrushView);
    }
    AppMethodBeat.o(143243);
  }
  
  public static b a(String paramString, MagicBrushView paramMagicBrushView)
  {
    AppMethodBeat.i(143244);
    if (bo.isNullOrNil(paramString))
    {
      paramString = new RuntimeException("Null or nil appid");
      AppMethodBeat.o(143244);
      throw paramString;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (!huR.containsKey(paramString)) {
      localObject1 = localObject2;
    }
    try
    {
      if (!huR.containsKey(paramString))
      {
        localObject1 = new b(paramMagicBrushView);
        huR.put(paramString, localObject1);
      }
      paramMagicBrushView = (MagicBrushView)localObject1;
      if (localObject1 == null) {
        paramMagicBrushView = (b)huR.get(paramString);
      }
      AppMethodBeat.o(143244);
      return paramMagicBrushView;
    }
    finally
    {
      AppMethodBeat.o(143244);
    }
  }
  
  public final void e(d<String> paramd)
  {
    AppMethodBeat.i(143245);
    ab.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
    this.huT.ac(new b.5(this, paramd));
    AppMethodBeat.o(143245);
  }
  
  public final void f(d<String> paramd)
  {
    AppMethodBeat.i(143246);
    ab.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
    this.huT.ac(new b.6(this, paramd));
    AppMethodBeat.o(143246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b
 * JD-Core Version:    0.7.0.1
 */