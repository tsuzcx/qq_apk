package com.tencent.mm.plugin.finder.ui.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "orderId", "", "contact", "Lcom/tencent/mm/storage/Contact;", "type", "(ILcom/tencent/mm/storage/Contact;I)V", "compareContent", "", "getCompareContent", "()Ljava/lang/String;", "setCompareContent", "(Ljava/lang/String;)V", "getContact", "()Lcom/tencent/mm/storage/Contact;", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "getOrderId", "()I", "showHead", "", "getShowHead", "()Z", "setShowHead", "(Z)V", "showHeadCode", "getShowHeadCode", "setShowHeadCode", "(I)V", "showHeadDisplay", "getShowHeadDisplay", "setShowHeadDisplay", "getType", "compareTo", "other", "getAtSomeoneDisplayShowHead", "getItemType", "getUniqueId", "isSameContent", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.mvvmlist.a<g>
{
  private final int FWs;
  public j FWt;
  public boolean FWu;
  private int FWv;
  public String FWw;
  private String FWx;
  public final au contact;
  public o rpp;
  final int type;
  
  public g(int paramInt1, au paramau, int paramInt2)
  {
    AppMethodBeat.i(347916);
    this.FWs = paramInt1;
    this.contact = paramau;
    this.type = paramInt2;
    this.FWv = 127;
    this.FWw = "";
    this.FWx = "";
    label84:
    label98:
    Object localObject2;
    if (this.type == 3)
    {
      if (Util.isNullOrNil(this.contact.field_conRemark)) {
        break label228;
      }
      paramau = this.contact.field_conRemark;
      if (paramau != null) {
        break label239;
      }
      paramau = "";
      localObject1 = d.aEj(paramau);
      if (localObject1 != null) {
        break label277;
      }
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = (g)this;
        ((g)localObject1).aBe(s.X(paramau, ""));
        localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
        ((g)localObject1).FWv = a.a.aPL(paramau);
      }
      this.FWx = s.X(this.FWx, paramau);
      paramInt1 = this.FWv;
      if ((paramInt1 < 65) || (paramInt1 > 90)) {
        break label349;
      }
    }
    label277:
    label349:
    for (Object localObject1 = String.valueOf((char)paramInt1);; localObject1 = "#")
    {
      this.FWw = ((String)localObject1);
      Log.i("jiaminchen.AtSomeone", "uiDisplayName:" + paramau + " showHeadCode:" + (char)this.FWv + " compareContent:" + this.FWx);
      AppMethodBeat.o(347916);
      return;
      label228:
      paramau = this.contact.aSU();
      break;
      label239:
      localObject1 = Locale.getDefault();
      s.s(localObject1, "getDefault()");
      paramau = paramau.toUpperCase((Locale)localObject1);
      s.s(paramau, "(this as java.lang.String).toUpperCase(locale)");
      if (paramau == null)
      {
        paramau = "";
        break label84;
      }
      break label84;
      localObject2 = Locale.getDefault();
      s.s(localObject2, "getDefault()");
      localObject1 = ((String)localObject1).toUpperCase((Locale)localObject2);
      s.s(localObject1, "(this as java.lang.String).toUpperCase(locale)");
      if (localObject1 == null)
      {
        localObject1 = null;
        break label98;
      }
      aBe(s.X((String)localObject1, ""));
      localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
      this.FWv = a.a.aPL((String)localObject1);
      localObject1 = ah.aiuX;
      break label98;
    }
  }
  
  private void aBe(String paramString)
  {
    AppMethodBeat.i(347926);
    s.u(paramString, "<set-?>");
    this.FWx = paramString;
    AppMethodBeat.o(347926);
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(347948);
    Object localObject = super.clone();
    AppMethodBeat.o(347948);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(347934);
    String str = this.contact.field_username + '-' + this.type;
    AppMethodBeat.o(347934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.g
 * JD-Core Version:    0.7.0.1
 */