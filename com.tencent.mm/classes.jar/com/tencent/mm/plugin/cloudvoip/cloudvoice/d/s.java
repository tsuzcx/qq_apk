package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.sdk.platformtools.ae;
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
  private j pcK;
  int pga;
  int pgb;
  public final Map<String, c> pgc;
  private boolean pgd;
  
  public s(j paramj)
  {
    AppMethodBeat.i(90942);
    this.pcK = null;
    this.mThread = null;
    this.pga = 0;
    this.pgb = 0;
    this.mTimer = null;
    this.frameData = new byte[l.cbn().defaultHeight * l.cbn().defaultWidth * 4];
    this.pgc = new HashMap();
    this.mStarted = false;
    this.pgd = true;
    this.pcK = paramj;
    AppMethodBeat.o(90942);
  }
  
  private b aaD(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.pcK == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.pcK.pdr;
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
  
  public final c a(Context paramContext, JSONObject arg2)
  {
    AppMethodBeat.i(90944);
    if (p.pdY.pee != p.d.pfR)
    {
      ae.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = aaD(str);
    if (localObject == null)
    {
      ae.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    ae.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).pcE + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      if (this.pgd) {
        paramContext = new n(paramContext, (b)localObject);
      }
    }
    for (;;)
    {
      if (paramContext.cbi())
      {
        ??? = p.pdY;
        ae.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.ad(new p.16(???));
      }
      synchronized (this.pgc)
      {
        localObject = (c)this.pgc.get(str);
        if (localObject != null)
        {
          ((c)localObject).uint();
          this.pgc.remove(str);
        }
        this.pgc.put(str, paramContext);
        AppMethodBeat.o(90944);
        return paramContext;
        paramContext = new i(paramContext, (b)localObject);
        continue;
        paramContext = new t(paramContext, (b)localObject, ???);
      }
    }
  }
  
  final dlw aaC(String paramString)
  {
    AppMethodBeat.i(211616);
    ae.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
    synchronized (this.pgc)
    {
      paramString = (c)this.pgc.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(211616);
        return null;
      }
    }
    ??? = new dlw();
    ((dlw)???).Gsd = paramString.getMemberId();
    if (paramString.getHeight() > paramString.getWidth()) {}
    for (int i = paramString.getHeight();; i = paramString.getWidth())
    {
      ((dlw)???).HTz = i;
      AppMethodBeat.o(211616);
      return ???;
    }
  }
  
  public final boolean cbu()
  {
    AppMethodBeat.i(90943);
    ae.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay");
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
                    ??? = p.pdY;
                    j = p.aQ(s.this.frameData);
                    int n = l.cbn().field_remoteImgLength;
                    int i1 = l.cbn().field_remoteImgHeight;
                    int i2 = l.cbn().field_remoteImgWidth;
                    int i3 = l.cbn().field_remoteImgMember;
                    ??? = s.this;
                    int i4 = ((s)???).pga + 1;
                    ((s)???).pga = i4;
                    if (i4 % 100 == 0) {
                      ae.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + s.this.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + s.this.pgb);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label518;
                    }
                    a locala = new a();
                    locala.pcC = s.this.frameData;
                    locala.cSL = n;
                    locala.width = i2;
                    locala.height = i1;
                    locala.pcD = i3;
                    synchronized (s.this.pgc)
                    {
                      Object localObject3 = s.this.pgc.entrySet().iterator();
                      if (!((Iterator)localObject3).hasNext()) {
                        break label513;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
                      if ((localc == null) || (localc.cbi()) || (localc.getMemberId() != locala.pcD)) {
                        continue;
                      }
                      localc.a(locala);
                      localObject3 = s.this;
                      ((s)localObject3).pgb += 1;
                      j = 1;
                      if (j == 0) {
                        ae.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.pcD + " not found");
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
                ae.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
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
      ae.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay error:" + localException.toString());
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