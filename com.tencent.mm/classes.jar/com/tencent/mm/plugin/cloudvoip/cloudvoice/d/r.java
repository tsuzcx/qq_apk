package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.dkl;
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

public final class r
{
  byte[] frameData;
  boolean mStarted;
  private HandlerThread mThread;
  Timer mTimer;
  private j nPH;
  int nSH;
  int nSI;
  public final Map<String, c> nSJ;
  
  public r(j paramj)
  {
    AppMethodBeat.i(90942);
    this.nPH = null;
    this.mThread = null;
    this.nSH = 0;
    this.nSI = 0;
    this.mTimer = null;
    this.frameData = new byte[l.bOh().defaultHeight * l.bOh().defaultWidth * 4];
    this.nSJ = new HashMap();
    this.mStarted = false;
    this.nPH = paramj;
    AppMethodBeat.o(90942);
  }
  
  private b RT(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.nPH == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.nPH.nQn;
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
  
  final dkl RS(String paramString)
  {
    AppMethodBeat.i(184492);
    ad.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
    c localc;
    synchronized (this.nSJ)
    {
      localc = (c)this.nSJ.get(paramString);
      if (localc == null)
      {
        AppMethodBeat.o(184492);
        return null;
      }
    }
    paramString = new dkl();
    paramString.Dab = localc.getMemberId();
    if (localc.bOc())
    {
      ??? = (i)localc;
      if (((i)???).getHeight() > ((i)???).getWidth()) {}
      for (i = ((i)???).getHeight();; i = ((i)???).getWidth())
      {
        paramString.EAb = i;
        AppMethodBeat.o(184492);
        return paramString;
      }
    }
    ??? = (s)localc;
    if (((s)???).getHeight() > ((s)???).getWidth()) {}
    for (int i = ((s)???).getHeight();; i = ((s)???).getWidth())
    {
      paramString.EAb = i;
      break;
    }
  }
  
  public final c a(Context paramContext, JSONObject arg2)
  {
    AppMethodBeat.i(90944);
    if (o.nQO.nQT != o.d.nSy)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = RT(str);
    if (localObject == null)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).nPB + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      paramContext = new i(paramContext, (b)localObject);
    }
    for (;;)
    {
      if (paramContext.bOc())
      {
        ??? = o.nQO;
        ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onCameraStart");
        ???.ae(new o.13(???));
      }
      synchronized (this.nSJ)
      {
        localObject = (c)this.nSJ.get(str);
        if (localObject != null)
        {
          ((c)localObject).uint();
          this.nSJ.remove(str);
        }
        this.nSJ.put(str, paramContext);
        AppMethodBeat.o(90944);
        return paramContext;
        paramContext = new s(paramContext, (b)localObject, ???);
      }
    }
  }
  
  public final boolean bOm()
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
                if (r.this.isStarted())
                {
                  j = 0;
                  int m = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    r.this.frameData[0] = i;
                    ??? = o.nQO;
                    j = o.aP(r.this.frameData);
                    int n = l.bOh().field_remoteImgLength;
                    int i1 = l.bOh().field_remoteImgHeight;
                    int i2 = l.bOh().field_remoteImgWidth;
                    int i3 = l.bOh().field_remoteImgMember;
                    ??? = r.this;
                    int i4 = ((r)???).nSH + 1;
                    ((r)???).nSH = i4;
                    if (i4 % 100 == 0) {
                      ad.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + r.this.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + r.this.nSI);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label518;
                    }
                    a locala = new a();
                    locala.nPz = r.this.frameData;
                    locala.cJQ = n;
                    locala.width = i2;
                    locala.height = i1;
                    locala.nPA = i3;
                    synchronized (r.this.nSJ)
                    {
                      Object localObject3 = r.this.nSJ.entrySet().iterator();
                      if (!((Iterator)localObject3).hasNext()) {
                        break label513;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
                      if ((localc == null) || (localc.bOc()) || (localc.getMemberId() != locala.nPA)) {
                        continue;
                      }
                      localc.a(locala);
                      localObject3 = r.this;
                      ((r)localObject3).nSI += 1;
                      j = 1;
                      if (j == 0) {
                        ad.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.nPA + " not found");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.r
 * JD-Core Version:    0.7.0.1
 */