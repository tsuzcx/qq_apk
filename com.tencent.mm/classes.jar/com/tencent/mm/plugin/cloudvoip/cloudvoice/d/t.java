package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.Log;
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

public final class t
{
  byte[] frameData;
  int mHeight;
  boolean mStarted;
  private HandlerThread mThread;
  Timer mTimer;
  int mWidth;
  private k qrJ;
  int qve;
  int qvf;
  final Map<String, c> qvg;
  private boolean qvh;
  
  public t(k paramk)
  {
    AppMethodBeat.i(90942);
    this.qrJ = null;
    this.mThread = null;
    this.qve = 0;
    this.qvf = 0;
    this.mTimer = null;
    this.frameData = new byte[m.czd().defaultHeight * m.czd().defaultWidth * 4];
    this.qvg = new HashMap();
    this.mStarted = false;
    this.qvh = true;
    this.mWidth = 640;
    this.mHeight = 480;
    this.qrJ = paramk;
    AppMethodBeat.o(90942);
  }
  
  private b akJ(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.qrJ == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.qrJ.qsr;
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
  
  public final c a(Context paramContext, JSONObject arg2, boolean paramBoolean)
  {
    AppMethodBeat.i(186786);
    if (q.qta.qth != q.d.quV)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(186786);
      return null;
    }
    String str = ???.optString("openId", "");
    Object localObject = akJ(str);
    if (localObject == null)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
      AppMethodBeat.o(186786);
      return null;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)localObject).qrD + " data:" + ???.toString());
    if (???.optString("type", "camera").equals("camera")) {
      if (paramBoolean)
      {
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isSameLayer: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
        paramContext = new v(paramContext, (b)localObject, this.mWidth, this.mHeight);
      }
    }
    for (;;)
    {
      if (paramContext.cyX())
      {
        ??? = q.qta;
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.aj(new q.16(???));
      }
      synchronized (this.qvg)
      {
        localObject = (c)this.qvg.get(str);
        if (localObject != null)
        {
          ((c)localObject).uint();
          this.qvg.remove(str);
        }
        this.qvg.put(str, paramContext);
        AppMethodBeat.o(186786);
        return paramContext;
        if (this.qvh)
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isUseNewPlayMode: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
          paramContext = new o(paramContext, (b)localObject, this.mWidth, this.mHeight);
          continue;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
        paramContext = new j(paramContext, (b)localObject, this.mWidth, this.mHeight);
        continue;
        paramContext = new u(paramContext, (b)localObject, ???);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(186787);
    if (paramc.cyX()) {
      q.qta.czi();
    }
    synchronized (this.qvg)
    {
      paramc.uint();
      this.qvg.remove(paramc.getOpenId());
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + paramc.getViewId() + " memberId:" + paramc.getMemberId());
      AppMethodBeat.o(186787);
      return;
    }
  }
  
  final efj akI(String paramString)
  {
    AppMethodBeat.i(186788);
    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
    synchronized (this.qvg)
    {
      paramString = (c)this.qvg.get(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(186788);
        return null;
      }
    }
    ??? = new efj();
    ((efj)???).Lnt = paramString.getMemberId();
    ((efj)???).NfF = Math.max(paramString.getLogicWidth(), paramString.getLogicHeight());
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "video_length:%d", new Object[] { Integer.valueOf(((efj)???).NfF) });
    AppMethodBeat.o(186788);
    return ???;
  }
  
  public final boolean czm()
  {
    AppMethodBeat.i(90943);
    Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay");
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
                if (t.this.isStarted())
                {
                  j = 0;
                  int m = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    t.this.frameData[0] = i;
                    ??? = q.qta;
                    j = q.bh(t.this.frameData);
                    int n = m.czd().field_remoteImgLength;
                    int i1 = m.czd().field_remoteImgHeight;
                    int i2 = m.czd().field_remoteImgWidth;
                    int i3 = m.czd().field_remoteImgMember;
                    ??? = t.this;
                    int i4 = ((t)???).qve + 1;
                    ((t)???).qve = i4;
                    if (i4 % 100 == 0) {
                      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo, mark:" + (i - 1) + " ret:" + j + ", len:" + t.this.frameData.length + ", rLen:" + n + ", rHeight:" + i1 + ", rWidth:" + i2 + ", rMid:" + i3 + ", drawCnt:" + t.this.qvf);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label518;
                    }
                    a locala = new a();
                    locala.qrB = t.this.frameData;
                    locala.djh = n;
                    locala.width = i2;
                    locala.height = i1;
                    locala.qrC = i3;
                    synchronized (t.this.qvg)
                    {
                      Object localObject3 = t.this.qvg.entrySet().iterator();
                      if (!((Iterator)localObject3).hasNext()) {
                        break label513;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject3).next()).getValue();
                      if ((localc == null) || (localc.cyX()) || (localc.getMemberId() != locala.qrC)) {
                        continue;
                      }
                      localc.a(locala);
                      localObject3 = t.this;
                      ((t)localObject3).qvf += 1;
                      j = 1;
                      if (j == 0) {
                        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + locala.qrC + " not found");
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
                Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
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
      Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "startPlay error:" + localException.toString());
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
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t
 * JD-Core Version:    0.7.0.1
 */