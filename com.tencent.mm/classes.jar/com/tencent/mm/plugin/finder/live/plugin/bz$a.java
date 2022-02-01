package com.tencent.mm.plugin.finder.live.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.as;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$Companion;", "", "()V", "NOTIFY_VISITOR_SHOPPING_THRESHOLD", "", "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "", "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "TAG", "getTAG", "()Ljava/lang/String;", "reportAnchorIssueCoupon", "", "issue", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bz$a
{
  public static void rE(boolean paramBoolean)
  {
    AppMethodBeat.i(354204);
    JSONObject localJSONObject = new JSONObject();
    int i;
    Object localObject;
    label71:
    long l;
    if (paramBoolean)
    {
      i = q.as.Dzv.action;
      localJSONObject.put("type", i);
      localObject = j.Dob;
      localJSONObject.put("sessionid", j.Doc.DpP);
      localObject = a.CMm;
      localObject = a.emY();
      if (localObject != null) {
        break label172;
      }
      localObject = null;
      localJSONObject.put("appid", localObject);
      localObject = a.CMm;
      localObject = a.emY();
      if (localObject != null) {
        break label205;
      }
      l = -1L;
      label100:
      if (l >= 0L) {
        break label257;
      }
      localJSONObject.put("liveid", "");
    }
    for (;;)
    {
      localObject = c.zGj;
      localJSONObject.put("clickid", c.dKp());
      localObject = c.zGj;
      c.a.arH("");
      j.Dob.a(q.c.Drn, localJSONObject.toString());
      AppMethodBeat.o(354204);
      return;
      i = q.as.Dzw.action;
      break;
      label172:
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (localObject == null)
      {
        localObject = null;
        break label71;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject).Eii;
      break label71;
      label205:
      localObject = (f)((a)localObject).business(f.class);
      if (localObject == null)
      {
        l = -1L;
        break label100;
      }
      localObject = ((f)localObject).liveInfo;
      if (localObject == null)
      {
        l = -1L;
        break label100;
      }
      l = ((bip)localObject).liveId;
      break label100;
      label257:
      localJSONObject.put("liveid", b.hF(l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bz.a
 * JD-Core Version:    0.7.0.1
 */