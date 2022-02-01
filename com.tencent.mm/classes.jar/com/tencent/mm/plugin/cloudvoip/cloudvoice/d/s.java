package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.ac;
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
  private j osL;
  int owb;
  int owc;
  public final Map<String, c> owd;
  private boolean owe;
  
  public s(j paramj)
  {
    AppMethodBeat.i(90942);
    this.osL = null;
    this.mThread = null;
    this.owb = 0;
    this.owc = 0;
    this.mTimer = null;
    this.frameData = new byte[l.bVu().defaultHeight * l.bVu().defaultWidth * 4];
    this.owd = new HashMap();
    this.mStarted = false;
    this.owe = true;
    this.osL = paramj;
    AppMethodBeat.o(90942);
  }
  
  private b Wf(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.osL == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.osL.ots;
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
  
  final dqc We(String paramString)
  {
    AppMethodBeat.i(184492);
    ac.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
    c localc;
    synchronized (this.owd)
    {
      localc = (c)this.owd.get(paramString);
      if (localc == null)
      {
        AppMethodBeat.o(184492);
        return null;
      }
    }
    paramString = new dqc();
    paramString.EsY = localc.getMemberId();
    if (localc.bVo())
    {
      ??? = (i)localc;
      if (((i)???).getHeight() > ((i)???).getWidth()) {}
      for (i = ((i)???).getHeight();; i = ((i)???).getWidth())
      {
        paramString.FXp = i;
        AppMethodBeat.o(184492);
        return paramString;
      }
    }
    ??? = (t)localc;
    if (((t)???).getHeight() > ((t)???).getWidth()) {}
    for (int i = ((t)???).getHeight();; i = ((t)???).getWidth())
    {
      paramString.FXp = i;
      break;
    }
  }
  
  public final c a(Context paramContext, JSONObject arg2)
  {
    AppMethodBeat.i(90944);
    if (p.otZ.ouf != p.d.ovS)
    {
      ac.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = Wf(str);
    if (localObject == null)
    {
      ac.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(90944);
      return null;
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).osF + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      if (this.owe) {
        paramContext = new n(paramContext, (b)localObject);
      }
    }
    for (;;)
    {
      if (paramContext.bVo())
      {
        ??? = p.otZ;
        ac.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.ag(new p.15(???));
      }
      synchronized (this.owd)
      {
        localObject = (c)this.owd.get(str);
        if (localObject != null)
        {
          ((c)localObject).uint();
          this.owd.remove(str);
        }
        this.owd.put(str, paramContext);
        AppMethodBeat.o(90944);
        return paramContext;
        paramContext = new i(paramContext, (b)localObject);
        continue;
        paramContext = new t(paramContext, (b)localObject, ???);
      }
    }
  }
  
  public final boolean bVC()
  {
    AppMethodBeat.i(90943);
    ac.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay");
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
                    ??? = p.otZ;
                    j = p.aO(s.this.frameData);
                    int n = l.bVu().field_remoteImgLength;
                    int i1 = l.bVu().field_remoteImgHeight;
                    int i2 = l.bVu().field_remoteImgWidth;
                    int i3 = l.bVu().field_remoteImgMember;
                    ??? = s.this;
                    int i4 = ((s)???).owb + 1;
                    ((s)???).owb = i4;
                    if (i4 % 100 == 0) {
                      ac.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + s.this.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + s.this.owc);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label518;
                    }
                    a locala = new a();
                    locala.osD = s.this.frameData;
                    locala.cGX = n;
                    locala.width = i2;
                    locala.height = i1;
                    locala.osE = i3;
                    synchronized (s.this.owd)
                    {
                      Object localObject3 = s.this.owd.entrySet().iterator();
                      if (!((Iterator)localObject3).hasNext()) {
                        break label513;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
                      if ((localc == null) || (localc.bVo()) || (localc.getMemberId() != locala.osE)) {
                        continue;
                      }
                      localc.a(locala);
                      localObject3 = s.this;
                      ((s)localObject3).owc += 1;
                      j = 1;
                      if (j == 0) {
                        ac.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.osE + " not found");
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
                ac.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
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
      ac.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay error:" + localException.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s
 * JD-Core Version:    0.7.0.1
 */