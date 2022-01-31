package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2conference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public final class r
{
  byte[] frameData;
  private j kJD;
  int kMw;
  int kMx;
  public final Map<String, c> kMy;
  boolean mStarted;
  HandlerThread mThread;
  Timer mTimer;
  
  public r(j paramj)
  {
    AppMethodBeat.i(145868);
    this.kJD = null;
    this.mThread = null;
    this.kMw = 0;
    this.kMx = 0;
    this.mTimer = null;
    this.frameData = new byte[l.bhq().defaultHeight * l.bhq().defaultWidth * 4];
    this.kMy = new HashMap();
    this.mStarted = false;
    this.kJD = paramj;
    AppMethodBeat.o(145868);
  }
  
  private b Jn(String paramString)
  {
    AppMethodBeat.i(145872);
    if (this.kJD == null)
    {
      AppMethodBeat.o(145872);
      return null;
    }
    Object localObject = this.kJD.kKm;
    if (localObject == null)
    {
      AppMethodBeat.o(145872);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.openId.equals(paramString))
      {
        AppMethodBeat.o(145872);
        return localb;
      }
    }
    AppMethodBeat.o(145872);
    return null;
  }
  
  public final c a(Context paramContext, JSONObject arg2)
  {
    AppMethodBeat.i(145870);
    if (o.kKN.kKS != o.d.kMn)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(145870);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = Jn(str);
    if (localObject == null)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(145870);
      return null;
    }
    ab.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).kJx + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      paramContext = new i(paramContext, (b)localObject);
    }
    synchronized (this.kMy)
    {
      localObject = (c)this.kMy.get(str);
      if (localObject != null)
      {
        ((c)localObject).uint();
        this.kMy.remove(str);
      }
      this.kMy.put(str, paramContext);
      AppMethodBeat.o(145870);
      return paramContext;
      paramContext = new s(paramContext, (b)localObject, ???);
    }
  }
  
  public final boolean bhv()
  {
    AppMethodBeat.i(145869);
    ab.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay");
    try
    {
      try
      {
        if (this.mStarted) {
          return false;
        }
        this.mStarted = true;
        if (this.mThread != null)
        {
          this.mThread.quit();
          this.mThread = null;
        }
        this.mThread = new HandlerThread("OpenVoiceVideoThread");
        this.mThread.start();
        if (this.mTimer != null)
        {
          this.mTimer.cancel();
          this.mTimer = null;
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new r.1(this), 0L, 20L);
        AppMethodBeat.o(145869);
        return true;
      }
      finally
      {
        AppMethodBeat.o(145869);
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay error:" + localException.toString());
      AppMethodBeat.o(145869);
    }
  }
  
  public final boolean isStarted()
  {
    try
    {
      boolean bool = this.mStarted;
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.r
 * JD-Core Version:    0.7.0.1
 */