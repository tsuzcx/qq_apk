package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class a
{
  private HashMap<String, c> bGq;
  public String doD;
  public String dtE;
  public int dtF;
  public String lQW;
  public String lQX;
  public f lQY;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.bGq = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void Sq(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.bGq.get(paramString) == null)
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.d((c)this.bGq.remove(paramString));
    this.bGq.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean Sr(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.lQW))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.lQX))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.az.a.aJJ();
    if (paramString == null)
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.lQX.equalsIgnoreCase(paramString.ihg))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.az.a.aJG())
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
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
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.c(paramc);
    this.bGq.put(paramString, paramc);
    AppMethodBeat.o(145819);
  }
  
  public final boolean dZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.lQW });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.lQW))
    {
      paramString1 = com.tencent.mm.az.a.aJJ();
      if ((paramString1 != null) && (paramString1.ihg.equals(this.lQX)))
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
    private static a lQZ;
    
    static
    {
      AppMethodBeat.i(145816);
      lQZ = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */