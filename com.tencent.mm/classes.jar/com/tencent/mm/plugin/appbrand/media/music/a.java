package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class a
{
  private HashMap<String, c> bGq;
  public String dpI;
  public String duJ;
  public int duK;
  public String lVx;
  public String lVy;
  public f lVz;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.bGq = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void SZ(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.bGq.get(paramString) == null)
    {
      ae.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.d((c)this.bGq.remove(paramString));
    this.bGq.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean Ta(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.lVx))
    {
      ae.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.lVy))
    {
      ae.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.ay.a.aKc();
    if (paramString == null)
    {
      ae.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.lVy.equalsIgnoreCase(paramString.ijZ))
    {
      ae.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.ay.a.aJZ())
    {
      ae.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      AppMethodBeat.o(145821);
      return false;
    }
    AppMethodBeat.o(145821);
    return true;
  }
  
  public final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(145819);
    if (this.bGq.get(paramString) != null)
    {
      ae.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.c(paramc);
    this.bGq.put(paramString, paramc);
    AppMethodBeat.o(145819);
  }
  
  public final boolean eb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      ae.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.lVx });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.lVx))
    {
      paramString1 = com.tencent.mm.ay.a.aKc();
      if ((paramString1 != null) && (paramString1.ijZ.equals(this.lVy)))
      {
        AppMethodBeat.o(145818);
        return true;
      }
    }
    AppMethodBeat.o(145818);
    return false;
  }
  
  public static final class a
  {
    private static a lVA;
    
    static
    {
      AppMethodBeat.i(145816);
      lVA = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */