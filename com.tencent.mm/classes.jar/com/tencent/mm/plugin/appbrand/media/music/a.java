package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.mm.av.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class a
{
  public String bJw;
  public String bNZ;
  public int bOa;
  private HashMap<String, c> elp = new HashMap();
  public String gNh;
  public String gNi;
  
  public final void a(c paramc, String paramString)
  {
    if (this.elp.get(paramString) != null)
    {
      y.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      return;
    }
    com.tencent.mm.sdk.b.a.udP.c(paramc);
    this.elp.put(paramString, paramc);
  }
  
  public final boolean bS(String paramString1, String paramString2)
  {
    if (paramString2.equalsIgnoreCase("play")) {
      y.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.gNh });
    }
    do
    {
      return true;
      if (!paramString1.equalsIgnoreCase(this.gNh)) {
        break;
      }
      paramString1 = com.tencent.mm.av.a.Pw();
    } while ((paramString1 != null) && (paramString1.eux.equals(this.gNi)));
    return false;
  }
  
  public final void tO(String paramString)
  {
    if (this.elp.get(paramString) == null)
    {
      y.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      return;
    }
    com.tencent.mm.sdk.b.a.udP.d((c)this.elp.remove(paramString));
    this.elp.remove(paramString);
  }
  
  public final boolean vd(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.gNh))
    {
      y.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      return false;
    }
    if (TextUtils.isEmpty(this.gNi))
    {
      y.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      return false;
    }
    paramString = com.tencent.mm.av.a.Pw();
    if (paramString == null)
    {
      y.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      return false;
    }
    if (!this.gNi.equalsIgnoreCase(paramString.eux))
    {
      y.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      return false;
    }
    if (!com.tencent.mm.av.a.Pu())
    {
      y.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      return false;
    }
    return true;
  }
  
  private static final class a
  {
    private static a gNj = new a((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */