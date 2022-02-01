package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListViewUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ab_BizHeaderCanJump2Profile", "", "getAb_BizHeaderCanJump2Profile", "()Z", "ab_OftenReadCanJump2Profile", "getAb_OftenReadCanJump2Profile", "getFinderLiveInfoList", "", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveInfo;", "list", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "updateFinderGreenDotState", "", "info", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b vPq;
  private static final boolean vPr;
  private static final boolean vPs;
  
  static
  {
    boolean bool2 = true;
    AppMethodBeat.i(302278);
    vPq = new b();
    TAG = "BizTimeLineHotListViewUtil";
    if (((c)h.ax(c.class)).a(c.a.zwW, 0) == 1)
    {
      bool1 = true;
      vPr = bool1;
      if (((c)h.ax(c.class)).a(c.a.zwV, 0) != 1) {
        break label87;
      }
    }
    label87:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      vPs = bool1;
      AppMethodBeat.o(302278);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean dew()
  {
    return vPr;
  }
  
  public static boolean dex()
  {
    return vPs;
  }
  
  public static void e(e parame)
  {
    AppMethodBeat.i(302272);
    s.u(parame, "info");
    long l1 = MultiProcessMMKV.getMMKV("BizTimeLineHotList_UserClick_FinderMsgTimeStamp").decodeLong(parame.YIf);
    long l2 = parame.vPU;
    long l3 = br.bCJ() - l2;
    if ((!vPr) || (!vPs)) {}
    label51:
    label250:
    for (;;)
    {
      boolean bool = false;
      parame.vPT = bool;
      if ((parame.vPQ) && (!parame.vPT)) {
        parame.vPV = 1;
      }
      for (;;)
      {
        if (parame.vPT) {
          Log.i(TAG, "info.finderUnreadDotShow = true, username = " + parame.YIf + ", time = " + parame.vPU + ", jumpType = " + parame.vPV);
        }
        AppMethodBeat.o(302272);
        return;
        if ((l2 == 0L) || ((l3 >= 0L) && (l3 > com.tencent.mm.plugin.brandservice.ui.b.b.dhO()))) {
          break;
        }
        if (l2 <= l1) {
          break label250;
        }
        bool = true;
        break label51;
        if ((!parame.vPQ) && (parame.vPT)) {
          parame.vPV = 2;
        } else if ((parame.vPQ) && (parame.vPT))
        {
          if (parame.uWw < parame.vPU) {
            parame.vPV = 2;
          } else {
            parame.vPV = 1;
          }
        }
        else {
          parame.vPV = 0;
        }
      }
    }
  }
  
  public static List<pi> ev(List<? extends e> paramList)
  {
    AppMethodBeat.i(302261);
    if (paramList == null)
    {
      AppMethodBeat.o(302261);
      return null;
    }
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    label94:
    label120:
    label123:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (e)localObject2;
      if (((e)localObject3).YSN == 0)
      {
        localObject3 = (CharSequence)((e)localObject3).YSM;
        if ((localObject3 == null) || (n.bp((CharSequence)localObject3)))
        {
          i = 1;
          if (i != 0) {
            break label120;
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label123;
        }
        paramList.add(localObject2);
        break;
        i = 0;
        break label94;
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      localObject3 = new pi();
      ((pi)localObject3).YIf = ((e)localObject2).YIf;
      ((pi)localObject3).YSM = ((e)localObject2).YSM;
      ((pi)localObject3).YSN = ((e)localObject2).YSN;
      paramList.add(localObject3);
    }
    paramList = (List)paramList;
    AppMethodBeat.o(302261);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.b
 * JD-Core Version:    0.7.0.1
 */