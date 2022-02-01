package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2conference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class t
{
  int mHeight;
  boolean mStarted;
  private HandlerThread mThread;
  int mWidth;
  private k tQs;
  int tTQ;
  int tTR;
  int tTS;
  int tTT;
  int tTU;
  int tTV;
  Timer tTW;
  Timer tTX;
  final Map<Integer, c> tUa;
  private boolean tUb;
  
  public t(k paramk)
  {
    AppMethodBeat.i(90942);
    this.tQs = null;
    this.mThread = null;
    this.tTQ = 0;
    this.tTR = 0;
    this.tTS = 0;
    this.tTT = 0;
    this.tTU = 0;
    this.tTV = 0;
    this.tTW = null;
    this.tTX = null;
    this.tUa = new HashMap();
    this.mStarted = false;
    this.tUb = true;
    this.mWidth = 640;
    this.mHeight = 480;
    this.tQs = paramk;
    AppMethodBeat.o(90942);
  }
  
  private b asy(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.tQs == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.tQs.tRa;
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
    AppMethodBeat.i(203214);
    if (q.tRM.tRT != q.d.tTH)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(203214);
      return null;
    }
    int i = ???.optInt("viewId", 0);
    String str = ???.optString("openId", "");
    synchronized (this.tUa)
    {
      if ((c)this.tUa.get(Integer.valueOf(i)) != null)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, already create, viewId: %d openId: %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(203214);
        return null;
      }
      ??? = asy(str);
      if (??? == null)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
        AppMethodBeat.o(203214);
        return null;
      }
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)???).tQm + " data:" + ???.toString());
    str = ???.optString("type", "camera");
    if (str.equals("camera")) {
      if (paramBoolean)
      {
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isSameLayer: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
        paramContext = new v(paramContext, (b)???, this.mWidth, this.mHeight);
      }
    }
    for (;;)
    {
      if (paramContext.cNt())
      {
        ??? = q.tRM;
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.am(new q.17(???));
      }
      synchronized (this.tUa)
      {
        this.tUa.put(Integer.valueOf(i), paramContext);
        AppMethodBeat.o(203214);
        return paramContext;
        if (this.tUb)
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isUseNewPlayMode: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
          paramContext = new o(paramContext, (b)???, this.mWidth, this.mHeight);
          continue;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
        paramContext = new j(paramContext, (b)???, this.mWidth, this.mHeight);
        continue;
        if ((str.equals("video")) || (str.equals("screen")))
        {
          paramContext = new u(paramContext, (b)???, ???);
          continue;
        }
        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, type unsupport, data:" + ???.toString());
        AppMethodBeat.o(203214);
        return null;
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(203218);
    if (paramc.cNt()) {
      q.tRM.cNH();
    }
    synchronized (this.tUa)
    {
      paramc.uint();
      this.tUa.remove(Integer.valueOf(paramc.getViewId()));
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + paramc.getViewId() + " memberId:" + paramc.getMemberId());
      AppMethodBeat.o(203218);
      return;
    }
  }
  
  final void a(adi arg1)
  {
    AppMethodBeat.i(203223);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMemberId");
    if ((??? == null) || (???.RIQ == null) || (???.RIQ.size() == 0))
    {
      AppMethodBeat.o(203223);
      return;
    }
    Object localObject1 = ???.RIQ;
    synchronized (this.tUa)
    {
      adh localadh;
      c localc;
      do
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localadh = (adh)((Iterator)localObject1).next();
          localIterator = this.tUa.entrySet().iterator();
        }
        localc = (c)((Map.Entry)localIterator.next()).getValue();
      } while ((localc == null) || (!localc.getOpenId().equals(localadh.openid)));
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMemberId viewId: " + localc.getViewId() + " openId: " + localc.getOpenId() + " mid: [" + localc.getMemberId() + "->" + localadh.SoO);
      localc.Iz(localadh.SoO);
    }
    AppMethodBeat.o(203223);
  }
  
  final epk asw(String paramString)
  {
    AppMethodBeat.i(203226);
    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize openId: %s", new Object[] { paramString });
    for (;;)
    {
      synchronized (this.tUa)
      {
        Iterator localIterator = this.tUa.entrySet().iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject2 = (c)((Map.Entry)localIterator.next()).getValue();
          localObject1 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize openId: %s viewId: %d mid: %d", new Object[] { ((c)localObject2).getOpenId(), Integer.valueOf(((c)localObject2).getViewId()), Integer.valueOf(((c)localObject2).getMemberId()) });
          if (!((c)localObject2).cNu()) {
            break label413;
          }
          localObject1 = localObject2;
          if (!((c)localObject2).getOpenId().equals(paramString)) {
            break label413;
          }
        }
        if (localObject1 == null)
        {
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize, openId: " + paramString + " not found");
          AppMethodBeat.o(203226);
          return null;
        }
      }
      int i = Math.max(localObject1.getLogicWidth(), localObject1.getLogicHeight());
      if (i <= 0)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize, openId: " + paramString + " videoLen error");
        AppMethodBeat.o(203226);
        return null;
      }
      Object localObject2 = new epk();
      ((epk)localObject2).SoO = localObject1.getMemberId();
      ((epk)localObject2).Usi = i;
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize opend: %s veiwId: %d mid: %d width: %d height: %d logWidth: %d logHeight: %d videoLength:%d", new Object[] { paramString, Integer.valueOf(localObject1.getViewId()), Integer.valueOf(localObject1.getMemberId()), Integer.valueOf(localObject1.getWidth()), Integer.valueOf(localObject1.getHeight()), Integer.valueOf(localObject1.getLogicWidth()), Integer.valueOf(localObject1.getLogicHeight()), Integer.valueOf(((epk)localObject2).Usi) });
      AppMethodBeat.o(203226);
      return localObject2;
      label413:
      Object localObject1 = null;
    }
  }
  
  final epk asx(String paramString)
  {
    AppMethodBeat.i(203233);
    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize openId: %s", new Object[] { paramString });
    for (;;)
    {
      synchronized (this.tUa)
      {
        Iterator localIterator = this.tUa.entrySet().iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject2 = (c)((Map.Entry)localIterator.next()).getValue();
          localObject1 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize openId: %s viewId: %d mid: %d", new Object[] { ((c)localObject2).getOpenId(), Integer.valueOf(((c)localObject2).getViewId()), Integer.valueOf(((c)localObject2).getMemberId()) });
          if (!((c)localObject2).cNv()) {
            break label413;
          }
          localObject1 = localObject2;
          if (!((c)localObject2).getOpenId().equals(paramString)) {
            break label413;
          }
        }
        if (localObject1 == null)
        {
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize, openId: " + paramString + " not found");
          AppMethodBeat.o(203233);
          return null;
        }
      }
      int i = Math.max(localObject1.getLogicWidth(), localObject1.getLogicHeight());
      if (i <= 0)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize, openId: " + paramString + " videoLen error");
        AppMethodBeat.o(203233);
        return null;
      }
      Object localObject2 = new epk();
      ((epk)localObject2).SoO = localObject1.getMemberId();
      ((epk)localObject2).Usi = i;
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize opend: %s veiwId: %d mid: %d width: %d height: %d logWidth: %d logHeight: %d videoLength:%d", new Object[] { paramString, Integer.valueOf(localObject1.getViewId()), Integer.valueOf(localObject1.getMemberId()), Integer.valueOf(localObject1.getWidth()), Integer.valueOf(localObject1.getHeight()), Integer.valueOf(localObject1.getLogicWidth()), Integer.valueOf(localObject1.getLogicHeight()), Integer.valueOf(((epk)localObject2).Usi) });
      AppMethodBeat.o(203233);
      return localObject2;
      label413:
      Object localObject1 = null;
    }
  }
  
  public final boolean cNM()
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
        if (this.tTW != null)
        {
          this.tTW.cancel();
          this.tTW = null;
        }
        final byte[] arrayOfByte = new byte[m.cNC().defaultHeight * m.cNC().defaultWidth * 4 + 1];
        this.tTW = new Timer();
        this.tTW.schedule(new TimerTask()
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
                  m = 0;
                  j = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    arrayOfByte[0] = i;
                    Object localObject1 = q.tRM;
                    j = q.U(arrayOfByte, 0);
                    int n = m.cNC().field_remoteImgLength;
                    int i1 = m.cNC().field_remoteImgHeight;
                    int i2 = m.cNC().field_remoteImgWidth;
                    int i3 = m.cNC().field_remoteImgMember;
                    int i4 = m.cNC().field_remoteImgFormat;
                    if ((i4 & 0x80) <= 0) {
                      break label623;
                    }
                    bool = true;
                    localObject1 = t.this;
                    int i5 = ((t)localObject1).tTQ;
                    ((t)localObject1).tTQ = (i5 + 1);
                    if (i5 % 1000 == 0) {
                      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo video, mark: " + (i - 1) + " ret: " + j + ", len: " + arrayOfByte.length + ", len: " + n + ", height: " + i1 + ", width: " + i2 + ", mid: " + i3 + ", format: " + i4 + ", getCnt: " + t.this.tTQ + ", gotCnt: " + t.this.tTR + ", drawCnt: " + t.this.tTS);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label610;
                    }
                    localObject1 = new a();
                    ((a)localObject1).tQj = arrayOfByte;
                    ((a)localObject1).faO = n;
                    ((a)localObject1).width = i2;
                    ((a)localObject1).height = i1;
                    ((a)localObject1).tQk = i3;
                    ((a)localObject1).format = i4;
                    ((a)localObject1).tQl = bool;
                    ??? = t.this;
                    ((t)???).tTR += 1;
                    synchronized (t.this.tUa)
                    {
                      Object localObject4 = t.this.tUa.entrySet().iterator();
                      if (!((Iterator)localObject4).hasNext()) {
                        break label605;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject4).next()).getValue();
                      if ((localc == null) || (localc.cNt()) || (localc.getMemberId() != ((a)localObject1).tQk) || (localc.cNv() != ((a)localObject1).tQl)) {
                        continue;
                      }
                      localc.a((a)localObject1);
                      localObject4 = t.this;
                      ((t)localObject4).tTS += 1;
                      j = 1;
                      if (j != 0) {
                        break label615;
                      }
                      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + ((a)localObject1).tQk + " not found");
                    }
                  }
                  if (m != 0) {
                    break label598;
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
              label598:
              k -= 1;
              break;
              label605:
              int j = 0;
              continue;
              label610:
              j = i;
              continue;
              label615:
              j = i;
              int m = 1;
              continue;
              label623:
              boolean bool = false;
            }
          }
        }, 0L, 20L);
        if (this.tTX != null)
        {
          this.tTX.cancel();
          this.tTX = null;
        }
        arrayOfByte = new byte[14745601];
        this.tTX = new Timer();
        this.tTX.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(203436);
            int k = 8;
            if (k > 0) {}
            for (;;)
            {
              int i;
              try
              {
                if (t.this.isStarted())
                {
                  m = 0;
                  j = 0;
                  i = (byte)(j + 1);
                  if (j < 2)
                  {
                    arrayOfByte[0] = i;
                    Object localObject1 = q.tRM;
                    j = q.U(arrayOfByte, 128);
                    int n = m.cNC().field_remoteScreenImgLength;
                    int i1 = m.cNC().field_remoteScreenImgHeight;
                    int i2 = m.cNC().field_remoteScreenImgWidth;
                    int i3 = m.cNC().field_remoteScreenImgMember;
                    int i4 = m.cNC().field_remoteScreenImgFormat;
                    if ((i4 & 0x80) <= 0) {
                      break label625;
                    }
                    bool = true;
                    localObject1 = t.this;
                    int i5 = ((t)localObject1).tTT;
                    ((t)localObject1).tTT = (i5 + 1);
                    if (i5 % 1000 == 0) {
                      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo screen, mark: " + (i - 1) + " ret: " + j + ", len: " + arrayOfByte.length + ", len: " + n + ", height: " + i1 + ", width: " + i2 + ", mid: " + i3 + ", format: " + i4 + ", getCnt: " + t.this.tTT + ", gotCnt: " + t.this.tTU + ", drawCnt: " + t.this.tTV);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label612;
                    }
                    localObject1 = new a();
                    ((a)localObject1).tQj = arrayOfByte;
                    ((a)localObject1).faO = n;
                    ((a)localObject1).width = i2;
                    ((a)localObject1).height = i1;
                    ((a)localObject1).tQk = i3;
                    ((a)localObject1).format = i4;
                    ((a)localObject1).tQl = bool;
                    ??? = t.this;
                    ((t)???).tTU += 1;
                    synchronized (t.this.tUa)
                    {
                      Object localObject4 = t.this.tUa.entrySet().iterator();
                      if (!((Iterator)localObject4).hasNext()) {
                        break label607;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject4).next()).getValue();
                      if ((localc == null) || (localc.cNt()) || (localc.getMemberId() != ((a)localObject1).tQk) || (localc.cNv() != ((a)localObject1).tQl)) {
                        continue;
                      }
                      localc.a((a)localObject1);
                      localObject4 = t.this;
                      ((t)localObject4).tTV += 1;
                      j = 1;
                      if (j != 0) {
                        break label617;
                      }
                      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + ((a)localObject1).tQk + " not found");
                    }
                  }
                  if (m != 0) {
                    break label600;
                  }
                }
              }
              catch (Exception localException)
              {
                Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceVideoMgr", localException, "timer task crash", new Object[0]);
                AppMethodBeat.o(203436);
                return;
              }
              AppMethodBeat.o(203436);
              return;
              label600:
              k -= 1;
              break;
              label607:
              int j = 0;
              continue;
              label612:
              j = i;
              continue;
              label617:
              j = i;
              int m = 1;
              continue;
              label625:
              boolean bool = false;
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
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t
 * JD-Core Version:    0.7.0.1
 */