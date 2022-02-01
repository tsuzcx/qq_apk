package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class a
{
  private HashMap<String, c> byu;
  public String dfM;
  public String dkB;
  public int dkC;
  public String kQn;
  public String kQo;
  public f kQp;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.byu = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void KG(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.byu.get(paramString) == null)
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    com.tencent.mm.sdk.b.a.ESL.d((c)this.byu.remove(paramString));
    this.byu.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean KH(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.kQn))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.kQo))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.az.a.azI();
    if (paramString == null)
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.kQo.equalsIgnoreCase(paramString.hnp))
    {
      ad.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.az.a.azF())
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
    if (this.byu.get(paramString) != null)
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    com.tencent.mm.sdk.b.a.ESL.c(paramc);
    this.byu.put(paramString, paramc);
    AppMethodBeat.o(145819);
  }
  
  public final boolean dE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      ad.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.kQn });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.kQn))
    {
      paramString1 = com.tencent.mm.az.a.azI();
      if ((paramString1 != null) && (paramString1.hnp.equals(this.kQo)))
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
    private static a kQq;
    
    static
    {
      AppMethodBeat.i(145816);
      kQq = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */