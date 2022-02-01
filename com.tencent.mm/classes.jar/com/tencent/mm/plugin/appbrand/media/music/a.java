package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public final class a
{
  private HashMap<String, c> bwc;
  public String ddh;
  public String dia;
  public int dib;
  public String lrM;
  public String lrN;
  public f lrO;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.bwc = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void ON(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.bwc.get(paramString) == null)
    {
      ac.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    com.tencent.mm.sdk.b.a.GpY.d((c)this.bwc.remove(paramString));
    this.bwc.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean OO(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      ac.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.lrM))
    {
      ac.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.lrN))
    {
      ac.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.ay.a.aGy();
    if (paramString == null)
    {
      ac.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.lrN.equalsIgnoreCase(paramString.hNS))
    {
      ac.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.ay.a.aGv())
    {
      ac.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      AppMethodBeat.o(145821);
      return false;
    }
    AppMethodBeat.o(145821);
    return true;
  }
  
  public final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(145819);
    if (this.bwc.get(paramString) != null)
    {
      ac.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    com.tencent.mm.sdk.b.a.GpY.c(paramc);
    this.bwc.put(paramString, paramc);
    AppMethodBeat.o(145819);
  }
  
  public final boolean dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      ac.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.lrM });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.lrM))
    {
      paramString1 = com.tencent.mm.ay.a.aGy();
      if ((paramString1 != null) && (paramString1.hNS.equals(this.lrN)))
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
    private static a lrP;
    
    static
    {
      AppMethodBeat.i(145816);
      lrP = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */