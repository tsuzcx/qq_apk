package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "definitionAfter", "", "getDefinitionAfter", "()I", "setDefinitionAfter", "(I)V", "definitionBefore", "getDefinitionBefore", "setDefinitionBefore", "definitionOptions", "getDefinitionOptions", "()Ljava/lang/String;", "setDefinitionOptions", "(Ljava/lang/String;)V", "endPlayTime", "getEndPlayTime", "setEndPlayTime", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "setPlayErrType", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "videoView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Ljava/lang/ref/WeakReference;", "setVideoView", "(Ljava/lang/ref/WeakReference;)V", "width", "getWidth", "setWidth", "wifiTipsWordingType", "getWifiTipsWordingType", "setWifiTipsWordingType", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "bufferType", "urlInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "Companion", "plugin-brandservice_release"})
public final class m
{
  private static WeakReference<m> orK;
  public static final a orL;
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  public b opy;
  public WeakReference<MPVideoView> oqJ;
  public int orA;
  public int orB;
  public int orC;
  public String orD = "";
  public boolean orE;
  public boolean orF = true;
  public int orG;
  public int orH;
  public int orI = 1;
  private String orJ = "";
  private final String orz = ",";
  public int width;
  
  static
  {
    AppMethodBeat.i(179021);
    orL = new a((byte)0);
    AppMethodBeat.o(179021);
  }
  
  public static int Ab(int paramInt)
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
  
  public static final void Ac(int paramInt)
  {
    AppMethodBeat.i(179022);
    a.Ac(paramInt);
    AppMethodBeat.o(179022);
  }
  
  private final MPVideoView bRo()
  {
    AppMethodBeat.i(7324);
    if (this.oqJ == null)
    {
      AppMethodBeat.o(7324);
      return null;
    }
    Object localObject = this.oqJ;
    if (localObject != null)
    {
      localObject = (MPVideoView)((WeakReference)localObject).get();
      AppMethodBeat.o(7324);
      return localObject;
    }
    AppMethodBeat.o(7324);
    return null;
  }
  
  public final void J(LinkedList<fu> paramLinkedList)
  {
    AppMethodBeat.i(7321);
    p.h(paramLinkedList, "urlInfos");
    StringBuilder localStringBuilder = new StringBuilder();
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      fu localfu = (fu)paramLinkedList.next();
      if (((CharSequence)localStringBuilder).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localfu.Fyb);
        break;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    p.g(paramLinkedList, "sb.toString()");
    this.orJ = paramLinkedList;
    AppMethodBeat.o(7321);
  }
  
  public final void eR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7322);
    if ((paramInt1 < 0) || (paramInt1 > 3600000L))
    {
      AppMethodBeat.o(7322);
      return;
    }
    ed(paramInt2, paramInt1);
    if (this.orF)
    {
      this.orF = false;
      ed(16, paramInt1);
      ad.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(7322);
      return;
    }
    ed(17, paramInt1);
    AppMethodBeat.o(7322);
  }
  
  public final void ed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7323);
    int j = com.tencent.mm.ai.m.aaW();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.orA < 0) || (this.orA > 86400000L)) {
      this.orA = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(this.orz);
    Object localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).VS());
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).hDP);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).idx);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).ooj);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).oog);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).hzm);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).bRh().hDq);
    localStringBuilder.append(this.orz);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(this.orz);
    localStringBuilder.append((int)(System.currentTimeMillis() / 1000L));
    localStringBuilder.append(this.orz);
    localStringBuilder.append(this.orA);
    localStringBuilder.append(this.orz);
    localStringBuilder.append(this.orB);
    localStringBuilder.append(this.orz);
    localStringBuilder.append(this.orC);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).scene);
    localStringBuilder.append(this.orz);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localStringBuilder.append(((b)localObject1).ooi);
    localStringBuilder.append(this.orz);
    localStringBuilder.append(this.orD);
    localStringBuilder.append(this.orz);
    if (this.orE)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.height);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.width);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(2);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.orG);
      localStringBuilder.append(this.orz);
      if (paramInt1 != 22) {
        break label1480;
      }
      i = this.orH;
      label722:
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      if (bRo() == null) {
        break label1485;
      }
      localObject1 = bRo();
      if (localObject1 == null) {
        p.gfZ();
      }
      if (!((MPVideoView)localObject1).bmN()) {
        break label1485;
      }
      i = 1;
      label770:
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.orz);
      localObject1 = bRo();
      if (localObject1 == null) {
        break label1490;
      }
      localObject1 = Integer.valueOf(((MPVideoView)localObject1).getCurrPosMs());
      label818:
      localStringBuilder.append(localObject1);
      localStringBuilder.append(this.orz);
      if ((paramInt1 != 22) && (paramInt1 != 21)) {
        break label1496;
      }
      localObject1 = this.orJ;
      label854:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.orz);
      if (paramInt1 != 14) {
        break label1503;
      }
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      i = ((b)localObject1).bRm();
      label978:
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      if (paramInt1 != 14) {
        break label1508;
      }
      i = this.orI;
      label1006:
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      localStringBuilder.append(((b)localObject1).hzh);
      localStringBuilder.append(this.orz);
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      localStringBuilder.append(((b)localObject1).ool);
      localStringBuilder.append(this.orz);
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      localStringBuilder.append(((b)localObject1).oom);
      localStringBuilder.append(this.orz);
      localStringBuilder.append(this.orz);
      localObject1 = a.oqk;
      if (!a.bRY()) {
        break label1513;
      }
      i = 1;
      label1157:
      localStringBuilder.append(i);
      localStringBuilder.append(this.orz);
      if (paramInt1 != 32) {
        break label1518;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.orz);
      if (paramInt1 == 43)
      {
        localObject1 = c.otD;
        localObject1 = c.bSx();
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
      localStringBuilder.append(this.orz);
      if (paramInt1 == 43)
      {
        localObject1 = c.otD;
        localObject1 = c.bSy();
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
      Object localObject2 = this.opy;
      if (localObject2 == null) {
        p.bcb("controller");
      }
      localObject2 = ((b)localObject2).ool;
      b localb = this.opy;
      if (localb == null) {
        p.bcb("controller");
      }
      ad.d((String)localObject1, "alvinluo reportKV17149 channelSessionId: %s, landingPageType: %d", new Object[] { localObject2, Integer.valueOf(localb.oom) });
      localObject1 = localStringBuilder.toString();
      p.g(localObject1, "sb.toString()");
      ad.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject1);
      g.yhR.kvStat(17149, (String)localObject1);
      if (paramInt1 != 3) {
        break label1523;
      }
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      ((b)localObject1).ooc.Ad(0);
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
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      ((b)localObject1).ooc.Ad(1);
      AppMethodBeat.o(7323);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject1 = this.opy;
      if (localObject1 == null) {
        p.bcb("controller");
      }
      ((b)localObject1).ooc.Ad(2);
    }
    AppMethodBeat.o(7323);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149$Companion;", "", "()V", "kv17149Ref", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKv17149Ref", "()Ljava/lang/ref/WeakReference;", "setKv17149Ref", "(Ljava/lang/ref/WeakReference;)V", "quickReport", "", "eventType", "", "bufferingTime", "plugin-brandservice_release"})
  public static final class a
  {
    public static void Ac(int paramInt)
    {
      AppMethodBeat.i(179020);
      Object localObject = m.bSe();
      if (localObject != null)
      {
        localObject = (m)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((m)localObject).ed(paramInt, 0);
          AppMethodBeat.o(179020);
          return;
        }
      }
      AppMethodBeat.o(179020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m
 * JD-Core Version:    0.7.0.1
 */