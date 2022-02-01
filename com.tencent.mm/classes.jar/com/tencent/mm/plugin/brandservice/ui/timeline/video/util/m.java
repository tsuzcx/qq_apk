package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "definitionAfter", "", "getDefinitionAfter", "()I", "setDefinitionAfter", "(I)V", "definitionBefore", "getDefinitionBefore", "setDefinitionBefore", "definitionOptions", "getDefinitionOptions", "()Ljava/lang/String;", "setDefinitionOptions", "(Ljava/lang/String;)V", "endPlayTime", "getEndPlayTime", "setEndPlayTime", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "setPlayErrType", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "videoView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Ljava/lang/ref/WeakReference;", "setVideoView", "(Ljava/lang/ref/WeakReference;)V", "width", "getWidth", "setWidth", "wifiTipsWordingType", "getWifiTipsWordingType", "setWifiTipsWordingType", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "bufferType", "urlInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "Companion", "plugin-brandservice_release"})
public final class m
{
  private static WeakReference<m> nme;
  public static final a nmf;
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  public b njZ;
  private final String nlT = ",";
  public int nlU;
  public int nlV;
  public int nlW;
  public String nlX = "";
  public boolean nlY;
  public boolean nlZ = true;
  public WeakReference<MPVideoView> nld;
  public int nma;
  public int nmb;
  public int nmc = 1;
  private String nmd = "";
  public int width;
  
  static
  {
    AppMethodBeat.i(179021);
    nmf = new a((byte)0);
    AppMethodBeat.o(179021);
  }
  
  private final MPVideoView bFB()
  {
    AppMethodBeat.i(7324);
    if (this.nld == null)
    {
      AppMethodBeat.o(7324);
      return null;
    }
    Object localObject = this.nld;
    if (localObject != null)
    {
      localObject = (MPVideoView)((WeakReference)localObject).get();
      AppMethodBeat.o(7324);
      return localObject;
    }
    AppMethodBeat.o(7324);
    return null;
  }
  
  public static int yB(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 4;
    case 0: 
      return 3;
    case 3: 
      return 9;
    }
    return 10;
  }
  
  public static final void yC(int paramInt)
  {
    AppMethodBeat.i(179022);
    a.yC(paramInt);
    AppMethodBeat.o(179022);
  }
  
  public final void J(LinkedList<fn> paramLinkedList)
  {
    AppMethodBeat.i(7321);
    k.h(paramLinkedList, "urlInfos");
    StringBuilder localStringBuilder = new StringBuilder();
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      fn localfn = (fn)paramLinkedList.next();
      if (((CharSequence)localStringBuilder).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localfn.CAm);
        break;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    k.g(paramLinkedList, "sb.toString()");
    this.nmd = paramLinkedList;
    AppMethodBeat.o(7321);
  }
  
  public final void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7322);
    if ((paramInt1 < 0) || (paramInt1 > 3600000L))
    {
      AppMethodBeat.o(7322);
      return;
    }
    ea(paramInt2, paramInt1);
    if (this.nlZ)
    {
      this.nlZ = false;
      ea(16, paramInt1);
      ad.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(7322);
      return;
    }
    ea(17, paramInt1);
    AppMethodBeat.o(7322);
  }
  
  public final void ea(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7323);
    int j = com.tencent.mm.ai.m.Xx();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.nlU < 0) || (this.nlU > 86400000L)) {
      this.nlU = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(this.nlT);
    Object localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).SI());
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).gLf);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).idx);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).niK);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).niH);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).gGC);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).bFu().gKH);
    localStringBuilder.append(this.nlT);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(this.nlT);
    localStringBuilder.append((int)(System.currentTimeMillis() / 1000L));
    localStringBuilder.append(this.nlT);
    localStringBuilder.append(this.nlU);
    localStringBuilder.append(this.nlT);
    localStringBuilder.append(this.nlV);
    localStringBuilder.append(this.nlT);
    localStringBuilder.append(this.nlW);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).scene);
    localStringBuilder.append(this.nlT);
    localObject1 = this.njZ;
    if (localObject1 == null) {
      k.aPZ("controller");
    }
    localStringBuilder.append(((b)localObject1).niJ);
    localStringBuilder.append(this.nlT);
    localStringBuilder.append(this.nlX);
    localStringBuilder.append(this.nlT);
    if (this.nlY)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.height);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.width);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(2);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.nma);
      localStringBuilder.append(this.nlT);
      if (paramInt1 != 22) {
        break label1480;
      }
      i = this.nmb;
      label722:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      if (bFB() == null) {
        break label1485;
      }
      localObject1 = bFB();
      if (localObject1 == null) {
        k.fvU();
      }
      if (!((MPVideoView)localObject1).bcg()) {
        break label1485;
      }
      i = 1;
      label770:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.nlT);
      localObject1 = bFB();
      if (localObject1 == null) {
        break label1490;
      }
      localObject1 = Integer.valueOf(((MPVideoView)localObject1).getCurrPosMs());
      label818:
      localStringBuilder.append(localObject1);
      localStringBuilder.append(this.nlT);
      if ((paramInt1 != 22) && (paramInt1 != 21)) {
        break label1496;
      }
      localObject1 = this.nmd;
      label854:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nlT);
      if (paramInt1 != 14) {
        break label1503;
      }
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      i = ((b)localObject1).bFz();
      label978:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      if (paramInt1 != 14) {
        break label1508;
      }
      i = this.nmc;
      label1006:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      localStringBuilder.append(((b)localObject1).gGx);
      localStringBuilder.append(this.nlT);
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      localStringBuilder.append(((b)localObject1).niM);
      localStringBuilder.append(this.nlT);
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      localStringBuilder.append(((b)localObject1).niN);
      localStringBuilder.append(this.nlT);
      localStringBuilder.append(this.nlT);
      localObject1 = a.nkE;
      if (!a.bGl()) {
        break label1513;
      }
      i = 1;
      label1157:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nlT);
      if (paramInt1 != 32) {
        break label1518;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.nlT);
      if (paramInt1 == 43)
      {
        localObject1 = c.nnW;
        localObject1 = c.bGJ();
        if (localObject1 != null)
        {
          localObject2 = ((c.a)localObject1).desc;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1238;
          }
        }
      }
      localObject1 = "";
      label1238:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.nlT);
      if (paramInt1 == 43)
      {
        localObject1 = c.nnW;
        localObject1 = c.bGK();
        if (localObject1 != null)
        {
          localObject2 = ((c.a)localObject1).desc;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1297;
          }
        }
      }
      localObject1 = "";
      label1297:
      localStringBuilder.append((String)localObject1);
      localObject1 = this.TAG;
      Object localObject2 = this.njZ;
      if (localObject2 == null) {
        k.aPZ("controller");
      }
      localObject2 = ((b)localObject2).niM;
      b localb = this.njZ;
      if (localb == null) {
        k.aPZ("controller");
      }
      ad.d((String)localObject1, "alvinluo reportKV17149 channelSessionId: %s, landingPageType: %d", new Object[] { localObject2, Integer.valueOf(localb.niN) });
      localObject1 = localStringBuilder.toString();
      k.g(localObject1, "sb.toString()");
      ad.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject1);
      h.vKh.kvStat(17149, (String)localObject1);
      if (paramInt1 != 3) {
        break label1523;
      }
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      ((b)localObject1).niD.yE(0);
      AppMethodBeat.o(7323);
      return;
      i = 0;
      break;
      label1480:
      i = 0;
      break label722;
      label1485:
      i = 2;
      break label770;
      label1490:
      localObject1 = null;
      break label818;
      label1496:
      localObject1 = "";
      break label854;
      label1503:
      i = 0;
      break label978;
      label1508:
      i = 0;
      break label1006;
      label1513:
      i = 0;
      break label1157;
      label1518:
      paramInt2 = 0;
    }
    label1523:
    if (paramInt1 == 4)
    {
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      ((b)localObject1).niD.yE(1);
      AppMethodBeat.o(7323);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject1 = this.njZ;
      if (localObject1 == null) {
        k.aPZ("controller");
      }
      ((b)localObject1).niD.yE(2);
    }
    AppMethodBeat.o(7323);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149$Companion;", "", "()V", "kv17149Ref", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKv17149Ref", "()Ljava/lang/ref/WeakReference;", "setKv17149Ref", "(Ljava/lang/ref/WeakReference;)V", "quickReport", "", "eventType", "", "bufferingTime", "plugin-brandservice_release"})
  public static final class a
  {
    public static void yC(int paramInt)
    {
      AppMethodBeat.i(179020);
      Object localObject = m.bGr();
      if (localObject != null)
      {
        localObject = (m)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((m)localObject).ea(paramInt, 0);
          AppMethodBeat.o(179020);
          return;
        }
      }
      AppMethodBeat.o(179020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m
 * JD-Core Version:    0.7.0.1
 */