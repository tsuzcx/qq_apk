package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a
{
  private HashMap<String, c> bat;
  public String cqQ;
  public String cvr;
  public int cvs;
  public String ipb;
  public String ipc;
  
  private a()
  {
    AppMethodBeat.i(137837);
    this.bat = new HashMap();
    AppMethodBeat.o(137837);
  }
  
  public final boolean DA(String paramString)
  {
    AppMethodBeat.i(137841);
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(137841);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.ipb))
    {
      ab.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(137841);
      return false;
    }
    if (TextUtils.isEmpty(this.ipc))
    {
      ab.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(137841);
      return false;
    }
    paramString = com.tencent.mm.aw.a.aiz();
    if (paramString == null)
    {
      ab.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(137841);
      return false;
    }
    if (!this.ipc.equalsIgnoreCase(paramString.fKj))
    {
      ab.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(137841);
      return false;
    }
    if (!com.tencent.mm.aw.a.aiw())
    {
      ab.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      AppMethodBeat.o(137841);
      return false;
    }
    AppMethodBeat.o(137841);
    return true;
  }
  
  public final void Dz(String paramString)
  {
    AppMethodBeat.i(137840);
    if (this.bat.get(paramString) == null)
    {
      ab.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(137840);
      return;
    }
    com.tencent.mm.sdk.b.a.ymk.d((c)this.bat.remove(paramString));
    this.bat.remove(paramString);
    AppMethodBeat.o(137840);
  }
  
  public final void a(c paramc, String paramString)
  {
    AppMethodBeat.i(137839);
    if (this.bat.get(paramString) != null)
    {
      ab.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(137839);
      return;
    }
    com.tencent.mm.sdk.b.a.ymk.c(paramc);
    this.bat.put(paramString, paramc);
    AppMethodBeat.o(137839);
  }
  
  public final boolean cH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137838);
    if (paramString2.equalsIgnoreCase("play"))
    {
      ab.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.ipb });
      AppMethodBeat.o(137838);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.ipb))
    {
      paramString1 = com.tencent.mm.aw.a.aiz();
      if ((paramString1 != null) && (paramString1.fKj.equals(this.ipc)))
      {
        AppMethodBeat.o(137838);
        return true;
      }
    }
    AppMethodBeat.o(137838);
    return false;
  }
  
  public static final class a
  {
    private static a ipd;
    
    static
    {
      AppMethodBeat.i(137836);
      ipd = new a((byte)0);
      AppMethodBeat.o(137836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */