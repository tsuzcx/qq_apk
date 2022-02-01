package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a
{
  public String appUserName;
  private HashMap<String, IListener> djU;
  public String hEy;
  public int hJK;
  public String tib;
  public String tic;
  public f tie;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.djU = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void a(IListener paramIListener, String paramString)
  {
    AppMethodBeat.i(145819);
    if (this.djU.get(paramString) != null)
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    paramIListener.alive();
    this.djU.put(paramString, paramIListener);
    AppMethodBeat.o(145819);
  }
  
  public final void adD(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.djU.get(paramString) == null)
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    ((IListener)this.djU.remove(paramString)).dead();
    this.djU.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean adE(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.tib))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.tic))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.aw.a.bLn();
    if (paramString == null)
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.tic.equalsIgnoreCase(paramString.oOv))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.aw.a.bLk())
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      AppMethodBeat.o(145821);
      return false;
    }
    AppMethodBeat.o(145821);
    return true;
  }
  
  public final boolean eX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.tib });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.tib))
    {
      paramString1 = com.tencent.mm.aw.a.bLn();
      if ((paramString1 != null) && (paramString1.oOv.equals(this.tic)))
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
    private static a tif;
    
    static
    {
      AppMethodBeat.i(145816);
      tif = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */