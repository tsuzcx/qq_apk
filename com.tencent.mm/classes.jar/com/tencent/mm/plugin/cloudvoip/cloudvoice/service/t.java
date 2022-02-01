package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.fkj;
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
  private k wTI;
  int wXh;
  int wXi;
  int wXj;
  int wXk;
  int wXl;
  int wXm;
  Timer wXn;
  Timer wXo;
  final Map<Integer, c> wXp;
  private boolean wXq;
  
  public t(k paramk)
  {
    AppMethodBeat.i(90942);
    this.wTI = null;
    this.mThread = null;
    this.wXh = 0;
    this.wXi = 0;
    this.wXj = 0;
    this.wXk = 0;
    this.wXl = 0;
    this.wXm = 0;
    this.wXn = null;
    this.wXo = null;
    this.wXp = new HashMap();
    this.mStarted = false;
    this.wXq = true;
    this.mWidth = 640;
    this.mHeight = 480;
    this.wTI = paramk;
    AppMethodBeat.o(90942);
  }
  
  private b amd(String paramString)
  {
    AppMethodBeat.i(90945);
    if (this.wTI == null)
    {
      AppMethodBeat.o(90945);
      return null;
    }
    Object localObject = this.wTI.wUq;
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
    AppMethodBeat.i(268306);
    if (q.wVc.wVj != q.d.wWY)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + ???.toString());
      AppMethodBeat.o(268306);
      return null;
    }
    int i = ???.optInt("viewId", 0);
    String str = ???.optString("openId", "");
    synchronized (this.wXp)
    {
      if ((c)this.wXp.get(Integer.valueOf(i)) != null)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, already create, viewId: %d openId: %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(268306);
        return null;
      }
      ??? = amd(str);
      if (??? == null)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + ???.toString());
        AppMethodBeat.o(268306);
        return null;
      }
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + ((b)???).wTC + " data:" + ???.toString());
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
      if (paramContext.dqZ())
      {
        ??? = q.wVc;
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
        ???.au(new q.17(???));
      }
      synchronized (this.wXp)
      {
        this.wXp.put(Integer.valueOf(i), paramContext);
        AppMethodBeat.o(268306);
        return paramContext;
        if (this.wXq)
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
        AppMethodBeat.o(268306);
        return null;
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(268311);
    if (paramc.dqZ()) {
      q.wVc.drn();
    }
    synchronized (this.wXp)
    {
      paramc.uint();
      this.wXp.remove(Integer.valueOf(paramc.getViewId()));
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + paramc.getViewId() + " memberId:" + paramc.getMemberId());
      AppMethodBeat.o(268311);
      return;
    }
  }
  
  final void a(afq arg1)
  {
    AppMethodBeat.i(268319);
    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMemberId");
    if ((??? == null) || (???.YFR == null) || (???.YFR.size() == 0))
    {
      AppMethodBeat.o(268319);
      return;
    }
    Object localObject1 = ???.YFR;
    synchronized (this.wXp)
    {
      afp localafp;
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
          localafp = (afp)((Iterator)localObject1).next();
          localIterator = this.wXp.entrySet().iterator();
        }
        localc = (c)((Map.Entry)localIterator.next()).getValue();
      } while ((localc == null) || (!localc.getOpenId().equals(localafp.openid)));
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMemberId viewId: " + localc.getViewId() + " openId: " + localc.getOpenId() + " mid: [" + localc.getMemberId() + "->" + localafp.ZnB);
      localc.Jc(localafp.ZnB);
    }
    AppMethodBeat.o(268319);
  }
  
  final fkj amb(String paramString)
  {
    AppMethodBeat.i(268324);
    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize openId: %s", new Object[] { paramString });
    for (;;)
    {
      synchronized (this.wXp)
      {
        Iterator localIterator = this.wXp.entrySet().iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject2 = (c)((Map.Entry)localIterator.next()).getValue();
          localObject1 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize openId: %s viewId: %d mid: %d", new Object[] { ((c)localObject2).getOpenId(), Integer.valueOf(((c)localObject2).getViewId()), Integer.valueOf(((c)localObject2).getMemberId()) });
          if (!((c)localObject2).dra()) {
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
          AppMethodBeat.o(268324);
          return null;
        }
      }
      int i = Math.max(localObject1.getLogicWidth(), localObject1.getLogicHeight());
      if (i <= 0)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize, openId: " + paramString + " videoLen error");
        AppMethodBeat.o(268324);
        return null;
      }
      Object localObject2 = new fkj();
      ((fkj)localObject2).ZnB = localObject1.getMemberId();
      ((fkj)localObject2).abLl = i;
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize opend: %s veiwId: %d mid: %d width: %d height: %d logWidth: %d logHeight: %d videoLength:%d", new Object[] { paramString, Integer.valueOf(localObject1.getViewId()), Integer.valueOf(localObject1.getMemberId()), Integer.valueOf(localObject1.getWidth()), Integer.valueOf(localObject1.getHeight()), Integer.valueOf(localObject1.getLogicWidth()), Integer.valueOf(localObject1.getLogicHeight()), Integer.valueOf(((fkj)localObject2).abLl) });
      AppMethodBeat.o(268324);
      return localObject2;
      label413:
      Object localObject1 = null;
    }
  }
  
  final fkj amc(String paramString)
  {
    AppMethodBeat.i(268329);
    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize openId: %s", new Object[] { paramString });
    for (;;)
    {
      synchronized (this.wXp)
      {
        Iterator localIterator = this.wXp.entrySet().iterator();
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject2 = (c)((Map.Entry)localIterator.next()).getValue();
          localObject1 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize openId: %s viewId: %d mid: %d", new Object[] { ((c)localObject2).getOpenId(), Integer.valueOf(((c)localObject2).getViewId()), Integer.valueOf(((c)localObject2).getMemberId()) });
          if (!((c)localObject2).drb()) {
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
          AppMethodBeat.o(268329);
          return null;
        }
      }
      int i = Math.max(localObject1.getLogicWidth(), localObject1.getLogicHeight());
      if (i <= 0)
      {
        Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize, openId: " + paramString + " videoLen error");
        AppMethodBeat.o(268329);
        return null;
      }
      Object localObject2 = new fkj();
      ((fkj)localObject2).ZnB = localObject1.getMemberId();
      ((fkj)localObject2).abLl = i;
      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getScreenSize opend: %s veiwId: %d mid: %d width: %d height: %d logWidth: %d logHeight: %d videoLength:%d", new Object[] { paramString, Integer.valueOf(localObject1.getViewId()), Integer.valueOf(localObject1.getMemberId()), Integer.valueOf(localObject1.getWidth()), Integer.valueOf(localObject1.getHeight()), Integer.valueOf(localObject1.getLogicWidth()), Integer.valueOf(localObject1.getLogicHeight()), Integer.valueOf(((fkj)localObject2).abLl) });
      AppMethodBeat.o(268329);
      return localObject2;
      label413:
      Object localObject1 = null;
    }
  }
  
  public final boolean drq()
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
        if (this.wXn != null)
        {
          this.wXn.cancel();
          this.wXn = null;
        }
        final byte[] arrayOfByte = new byte[m.dri().defaultHeight * m.dri().defaultWidth * 4 + 1];
        this.wXn = new Timer();
        this.wXn.schedule(new TimerTask()
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
                    Object localObject1 = q.wVc;
                    j = q.S(arrayOfByte, 0);
                    int n = m.dri().field_remoteImgLength;
                    int i1 = m.dri().field_remoteImgHeight;
                    int i2 = m.dri().field_remoteImgWidth;
                    int i3 = m.dri().field_remoteImgMember;
                    int i4 = m.dri().field_remoteImgFormat;
                    if ((i4 & 0x80) <= 0) {
                      break label623;
                    }
                    bool = true;
                    localObject1 = t.this;
                    int i5 = ((t)localObject1).wXh;
                    ((t)localObject1).wXh = (i5 + 1);
                    if (i5 % 1000 == 0) {
                      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo video, mark: " + (i - 1) + " ret: " + j + ", len: " + arrayOfByte.length + ", len: " + n + ", height: " + i1 + ", width: " + i2 + ", mid: " + i3 + ", format: " + i4 + ", getCnt: " + t.this.wXh + ", gotCnt: " + t.this.wXi + ", drawCnt: " + t.this.wXj);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label610;
                    }
                    localObject1 = new a();
                    ((a)localObject1).wTz = arrayOfByte;
                    ((a)localObject1).heo = n;
                    ((a)localObject1).width = i2;
                    ((a)localObject1).height = i1;
                    ((a)localObject1).wTA = i3;
                    ((a)localObject1).format = i4;
                    ((a)localObject1).wTB = bool;
                    ??? = t.this;
                    ((t)???).wXi += 1;
                    synchronized (t.this.wXp)
                    {
                      Object localObject4 = t.this.wXp.entrySet().iterator();
                      if (!((Iterator)localObject4).hasNext()) {
                        break label605;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject4).next()).getValue();
                      if ((localc == null) || (localc.dqZ()) || (localc.getMemberId() != ((a)localObject1).wTA) || (localc.drb() != ((a)localObject1).wTB)) {
                        continue;
                      }
                      localc.a((a)localObject1);
                      localObject4 = t.this;
                      ((t)localObject4).wXj += 1;
                      j = 1;
                      if (j != 0) {
                        break label615;
                      }
                      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + ((a)localObject1).wTA + " not found");
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
        if (this.wXo != null)
        {
          this.wXo.cancel();
          this.wXo = null;
        }
        arrayOfByte = new byte[14745601];
        this.wXo = new Timer();
        this.wXo.schedule(new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(268373);
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
                    Object localObject1 = q.wVc;
                    j = q.S(arrayOfByte, 128);
                    int n = m.dri().field_remoteScreenImgLength;
                    int i1 = m.dri().field_remoteScreenImgHeight;
                    int i2 = m.dri().field_remoteScreenImgWidth;
                    int i3 = m.dri().field_remoteScreenImgMember;
                    int i4 = m.dri().field_remoteScreenImgFormat;
                    if ((i4 & 0x80) <= 0) {
                      break label625;
                    }
                    bool = true;
                    localObject1 = t.this;
                    int i5 = ((t)localObject1).wXk;
                    ((t)localObject1).wXk = (i5 + 1);
                    if (i5 % 1000 == 0) {
                      Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "GetVideo screen, mark: " + (i - 1) + " ret: " + j + ", len: " + arrayOfByte.length + ", len: " + n + ", height: " + i1 + ", width: " + i2 + ", mid: " + i3 + ", format: " + i4 + ", getCnt: " + t.this.wXk + ", gotCnt: " + t.this.wXl + ", drawCnt: " + t.this.wXm);
                    }
                    if ((j <= 0) || (n <= 0) || (i1 <= 0) || (i2 <= 0)) {
                      break label612;
                    }
                    localObject1 = new a();
                    ((a)localObject1).wTz = arrayOfByte;
                    ((a)localObject1).heo = n;
                    ((a)localObject1).width = i2;
                    ((a)localObject1).height = i1;
                    ((a)localObject1).wTA = i3;
                    ((a)localObject1).format = i4;
                    ((a)localObject1).wTB = bool;
                    ??? = t.this;
                    ((t)???).wXl += 1;
                    synchronized (t.this.wXp)
                    {
                      Object localObject4 = t.this.wXp.entrySet().iterator();
                      if (!((Iterator)localObject4).hasNext()) {
                        break label607;
                      }
                      c localc = (c)((Map.Entry)((Iterator)localObject4).next()).getValue();
                      if ((localc == null) || (localc.dqZ()) || (localc.getMemberId() != ((a)localObject1).wTA) || (localc.drb() != ((a)localObject1).wTB)) {
                        continue;
                      }
                      localc.a((a)localObject1);
                      localObject4 = t.this;
                      ((t)localObject4).wXm += 1;
                      j = 1;
                      if (j != 0) {
                        break label617;
                      }
                      Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "thread handler, mid:" + ((a)localObject1).wTA + " not found");
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
                AppMethodBeat.o(268373);
                return;
              }
              AppMethodBeat.o(268373);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.t
 * JD-Core Version:    0.7.0.1
 */