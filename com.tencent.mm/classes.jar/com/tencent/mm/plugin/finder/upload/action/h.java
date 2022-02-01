package com.tencent.mm.plugin.finder.upload.action;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.kb;
import com.tencent.mm.autogen.a.kb.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.finder.cgi.p;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderUser", "", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "enterType", "participantFinderUsername", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "(Ljava/lang/String;IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ZILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getEnterType", "()I", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "()Z", "getLiveReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "getOpType", "getParticipantFinderUsername", "setParticipantFinderUsername", "(Ljava/lang/String;)V", "doFollow", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "uniqueId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends e
{
  public final int ACR;
  public final bui Auc;
  final boolean Gdb;
  public String Gdc;
  public final bma Gdd;
  public final long feedId;
  public final String hLI;
  public final int opType;
  
  public h(String paramString1, int paramInt1, long paramLong, bui parambui, boolean paramBoolean, int paramInt2, String paramString2, bma parambma)
  {
    super(null);
    AppMethodBeat.i(343323);
    this.hLI = paramString1;
    this.opType = paramInt1;
    this.feedId = paramLong;
    this.Auc = parambui;
    this.Gdb = paramBoolean;
    this.ACR = paramInt2;
    this.Gdc = paramString2;
    this.Gdd = parambma;
    AppMethodBeat.o(343323);
  }
  
  private static final ah a(h paramh, m.b paramb, b.a parama)
  {
    AppMethodBeat.i(343343);
    s.u(paramh, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.FollowActionTask", "FollowAction callback " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    kb.a locala;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = i.Gde;
      i.fej().a(paramh);
      parama = new kb();
      parama.hLH.hLI = paramh.hLI;
      parama.hLH.opType = paramh.opType;
      locala = parama.hLH;
      paramh = paramh.Auc;
      if (paramh == null)
      {
        i = 0;
        locala.hLK = i;
        parama.hLH.hLJ = true;
        parama.publish();
        paramb.a(com.tencent.mm.loader.f.i.nrG, false);
      }
    }
    for (;;)
    {
      paramh = ah.aiuX;
      AppMethodBeat.o(343343);
      return paramh;
      i = paramh.hLK;
      break;
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info finderfollow: " + parama.errType + ' ' + parama.errCode), 1).show();
      }
      if (parama.errType == 4)
      {
        parama = i.Gde;
        i.fej().a(paramh);
        parama = new kb();
        parama.hLH.hLI = paramh.hLI;
        parama.hLH.opType = paramh.opType;
        locala = parama.hLH;
        paramh = paramh.Auc;
        if (paramh == null) {}
        for (i = 0;; i = paramh.hLK)
        {
          locala.hLK = i;
          parama.hLH.hLJ = false;
          parama.publish();
          paramb.a(com.tencent.mm.loader.f.i.nrH, false);
          break;
        }
      }
      paramb.a(com.tencent.mm.loader.f.i.nrH, true);
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(343385);
    s.u(paramb, "callback");
    super.a(paramb);
    new p(this).bFJ().g(new h..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(343385);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343375);
    String str = "id_" + this.hLI + '_' + this.opType;
    AppMethodBeat.o(343375);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343368);
    String str = "action_" + this.hLI + '_' + this.opType + '_' + this.Gae + '_' + this.Gdc;
    AppMethodBeat.o(343368);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.h
 * JD-Core Version:    0.7.0.1
 */