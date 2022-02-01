package com.tencent.mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a
{
  public String appUserName;
  private HashMap<String, IListener> bqq;
  public int fES;
  public String fzM;
  public String qdn;
  public String qdo;
  public f qdp;
  
  private a()
  {
    AppMethodBeat.i(145817);
    this.bqq = new HashMap();
    AppMethodBeat.o(145817);
  }
  
  public final void a(IListener paramIListener, String paramString)
  {
    AppMethodBeat.i(145819);
    if (this.bqq.get(paramString) != null)
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145819);
      return;
    }
    EventCenter.instance.addListener(paramIListener);
    this.bqq.put(paramString, paramIListener);
    AppMethodBeat.o(145819);
  }
  
  public final void akx(String paramString)
  {
    AppMethodBeat.i(145820);
    if (this.bqq.get(paramString) == null)
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      AppMethodBeat.o(145820);
      return;
    }
    EventCenter.instance.removeListener((IListener)this.bqq.remove(paramString));
    this.bqq.remove(paramString);
    AppMethodBeat.o(145820);
  }
  
  public final boolean aky(String paramString)
  {
    AppMethodBeat.i(145821);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.qdn))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      AppMethodBeat.o(145821);
      return false;
    }
    if (TextUtils.isEmpty(this.qdo))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      AppMethodBeat.o(145821);
      return false;
    }
    paramString = com.tencent.mm.bb.a.bnA();
    if (paramString == null)
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!this.qdo.equalsIgnoreCase(paramString.lVt))
    {
      Log.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      AppMethodBeat.o(145821);
      return false;
    }
    if (!com.tencent.mm.bb.a.bnx())
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      AppMethodBeat.o(145821);
      return false;
    }
    AppMethodBeat.o(145821);
    return true;
  }
  
  public final boolean eG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145818);
    if (paramString2.equalsIgnoreCase("play"))
    {
      Log.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.qdn });
      AppMethodBeat.o(145818);
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.qdn))
    {
      paramString1 = com.tencent.mm.bb.a.bnA();
      if ((paramString1 != null) && (paramString1.lVt.equals(this.qdo)))
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
    private static a qdq;
    
    static
    {
      AppMethodBeat.i(145816);
      qdq = new a((byte)0);
      AppMethodBeat.o(145816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.music.a
 * JD-Core Version:    0.7.0.1
 */