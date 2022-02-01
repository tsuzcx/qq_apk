package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends j<cgi>
{
  private static final String TAG;
  public static final a wvR;
  
  static
  {
    AppMethodBeat.i(112392);
    wvR = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    cgh localcgh = new cgh();
    cgi localcgi = new cgi();
    a((erp)localcgh, (esc)localcgi, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    Log.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void dli()
    {
      AppMethodBeat.i(294542);
      Log.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = h.baE().ban().get(at.a.acYb, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(294542);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      h.baE().ban().set(at.a.acYb, Long.valueOf(System.currentTimeMillis()));
      new e().bFJ().h(e.a..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(294542);
    }
    
    private static final ah e(b.a parama)
    {
      AppMethodBeat.i(294546);
      a locala = e.wvR;
      Log.i(e.access$getTAG$cp(), "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
      if ((parama.errType == 0) && (parama.errCode == 0))
      {
        parama = (cgi)parama.ott;
        locala = e.wvR;
        Log.i(e.access$getTAG$cp(), "retCode: %s", new Object[] { Integer.valueOf(parama.wuz) });
        if (parama.wuz == 0) {
          if (!parama.aaps) {
            break label296;
          }
        }
      }
      label296:
      for (int i = 1;; i = 0)
      {
        locala = e.wvR;
        Log.i(e.access$getTAG$cp(), "new version: %s, new version style: %s, trade area: %s, is_card_home_page_v2: %s", new Object[] { Boolean.valueOf(parama.aaps), Integer.valueOf(parama.aapt), Integer.valueOf(parama.aapu), Boolean.valueOf(parama.aapw) });
        h.baE().ban().set(at.a.acYc, Integer.valueOf(i));
        h.baE().ban().set(at.a.acYd, Integer.valueOf(parama.aapt));
        h.baE().ban().set(at.a.acYf, Integer.valueOf(parama.aapu));
        parama.aapw = true;
        h.baE().ban().set(at.a.acYh, Boolean.valueOf(parama.aapw));
        if (parama.aapv != null)
        {
          parama = parama.aapv.toByteArray();
          s.s(parama, "trade_area_version_mini_app_info.toByteArray()");
          parama = new String(parama, d.ISO_8859_1);
          h.baE().ban().set(at.a.acYg, parama);
        }
        parama = ah.aiuX;
        AppMethodBeat.o(294546);
        return parama;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */