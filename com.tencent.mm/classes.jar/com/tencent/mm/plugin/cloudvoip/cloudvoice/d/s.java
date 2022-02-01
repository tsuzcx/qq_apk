package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wxmm.v2conference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class s
{
  byte[] frameData;
  boolean mStarted;
  private HandlerThread mThread;
  Timer mTimer;
  private j oWh;
  int oZw;
  int oZx;
  public final Map<String, c> oZy;
  private boolean oZz;
  
  public s(j paramj)
  {
    AppMethodBeat.i(90942);
    this.oWh = null;
    this.mThread = null;
    this.oZw = 0;
    this.oZx = 0;
    this.mTimer = null;
    this.frameData = new byte[l.bZY().defaultHeight * l.bZY().defaultWidth * 4];
    this.oZy = new HashMap();
    this.mStarted = false;
    this.oZz = true;
    this.oWh = paramj;
    AppMethodBeat.o(90942);
  }
  
  private b ZM(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.oWh == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.oWh.oWO;
    if (localObject == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      if (localb.openId.equals(paramString))
      {
        AppMethodBeat.o(90945);
        return localb;
      }
    }
    AppMethodBeat.o(90945);
    return null;
  }
  
  final dvt ZL(String paramString)
  {
    AppMethodBeat.i(184492);
    ad.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
    c localc;
    synchronized (this.oZy)
    {
      localc = (c)this.oZy.get(paramString);
      if (localc == null)
      {
        AppMethodBeat.o(184492);
        return null;
      }
    }
    paramString = new dvt();
    paramString.Gan = localc.getMemberId();
    if (localc.bZT())
    {
      ??? = (i)localc;
      if (((i)???).getHeight() > ((i)???).getWidth()) {}
      for (i = ((i)???).getHeight();; i = ((i)???).getWidth())
      {
        paramString.HIe = i;
        AppMethodBeat.o(184492);
        return paramString;
      }
    }
    ??? = (t)localc;
    if (((t)???).getHeight() > ((t)???).getWidth()) {}
    for (int i = ((t)???).getHeight();; i = ((t)???).getWidth())
    {
      paramString.HIe = i;
      break;
    }
  }
  
  public final c a(Context paramContext, JSONObject arg2)
  {
    AppMethodBeat.i(90944);
    if (p.oXv.oXB != p.d.oZn)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = ZM(str);
    if (localObject == null)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).oWb + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      if (this.oZz) {
        paramContext = new n(paramContext, (b)localObject);
      }
    }
    for (;;)
    {
      if (paramContext.bZT())
      {
        ??? = p.oXv;
        ad.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.af(new p.16(???));
      }
      synchronized (this.oZy)
      {
        localObject = (c)this.oZy.get(str);
        if (localObject != null)
        {
          ((c)localObject).uint();
          this.oZy.remove(str);
        }
        this.oZy.put(str, paramContext);
        AppMethodBeat.o(90944);
        return paramContext;
        paramContext = new i(paramContext, (b)localObject);
        continue;
        paramContext = new t(paramContext, (b)localObject, ???);
      }
    }
  }
  
  public final boolean caf()
  {
    AppMethodBeat.i(90943);
    ad.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay");
    try
    {
      try
      {
        if (this.mStarted) {
          return false;
        }
        this.mStarted = true;
        if (this.mTimer != null)
        {
          this.mTimer.cancel();
          this.mTimer = null;
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(90941);
            int k = 8;
            if (k > 0) {}
            for (;;)
            {
              int i;
              try
              {
                if (s.this.isStarted())
                {
                  j = 0;
                  int m = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    s.this.frameData[0] = i;
                    ??? = p.oXv;
                    j = p.aR(s.this.frameData);
                    int n = l.bZY().field_remoteImgLength;
                    int i1 = l.bZY().field_remoteImgHeight;
                    int i2 = l.bZY().field_remoteImgWidth;
                    int i3 = l.bZY().field_remoteImgMember;
                    ??? = s.this;
                    int i4 = ((s)???).oZw + 1;
                    ((s)???).oZw = i4;
                    if (i4 % 100 == 0) {
                      ad.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + s.this.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + s.this.oZx);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label518;
                    }
                    a locala = new a();
                    locala.oVZ = s.this.frameData;
                    locala.cSb = n;
                    locala.width = i2;
                    locala.height = i1;
                    locala.oWa = i3;
                    synchronized (s.this.oZy)
                    {
                      Object localObject3 = s.this.oZy.entrySet().iterator();
                      if (!((Iterator)localObject3).hasNext()) {
                        break label513;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
                      if ((localc == null) || (localc.bZT()) || (localc.getMemberId() != locala.oWa)) {
                        continue;
                      }
                      localc.a(locala);
                      localObject3 = s.this;
                      ((s)localObject3).oZx += 1;
                      j = 1;
                      if (j == 0) {
                        ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.oWa + " not found");
                      }
                      j = i;
                      m = 1;
                    }
                  }
                  if (m != 0) {
                    break label506;
                  }
                }
              }
              catch (Exception localException)
              {
                ad.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(90941);
                return;
              }
              AppMethodBeat.o(90941);
              return;
              label506:
              k -= 1;
              break;
              label513:
              int j = 0;
              continue;
              label518:
              j = i;
            }
          }
        }, 0L, 20L);
        AppMethodBeat.o(90943);
        return true;
      }
      finally
      {
        AppMethodBeat.o(90943);
      }
      return false;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay error:" + localException.toString());
      AppMethodBeat.o(90943);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s
 * JD-Core Version:    0.7.0.1
 */