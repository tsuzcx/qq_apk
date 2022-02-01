package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.eee;
import com.tencent.mm.protocal.protobuf.een;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fes;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderProfilePoiUtils;", "", "()V", "MIN_TO_SHOW_SEARCH", "", "covertData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderPoiInfo;", "snsPoiDetailList", "", "Lcom/tencent/mm/protocal/protobuf/SnsPoiDetail;", "getContentHeight", "context", "Landroid/content/Context;", "size", "getHeaderHeight", "getTopHeight", "jumpPoiLocation", "", "poiBrief", "Lcom/tencent/mm/protocal/protobuf/PoiBrief;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final ai Ghs;
  
  static
  {
    AppMethodBeat.i(333554);
    Ghs = new ai();
    AppMethodBeat.o(333554);
  }
  
  public static void a(Context paramContext, eee parameee)
  {
    AppMethodBeat.i(333548);
    s.u(paramContext, "context");
    if (parameee == null) {}
    for (een localeen = null; localeen == null; localeen = parameee.abja)
    {
      AppMethodBeat.o(333548);
      return;
    }
    fei localfei = new fei();
    localfei.pSh = parameee.pSh;
    localfei.ZaH = localeen.ZaH;
    localfei.ZaG = localeen.ZaG;
    localfei.ReU = parameee.aaMz;
    localfei.poiName = parameee.IGU;
    localfei.ZWG = parameee.UID;
    parameee = new Intent();
    parameee.putExtra("key_location", localfei.toByteArray());
    parameee.putExtra("key_from_type", (Serializable)bi.a.Hcp);
    a.GfO.w(paramContext, parameee);
    AppMethodBeat.o(333548);
  }
  
  public static int aD(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(333525);
    s.u(paramContext, "context");
    if (paramInt >= 20)
    {
      paramInt = paramContext.getResources().getDimensionPixelSize(e.c.Edge_14A);
      AppMethodBeat.o(333525);
      return paramInt;
    }
    paramInt = paramContext.getResources().getDimensionPixelSize(e.c.Edge_8A);
    AppMethodBeat.o(333525);
    return paramInt;
  }
  
  public static LinkedList<bsg> hH(List<? extends fes> paramList)
  {
    AppMethodBeat.i(333533);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(333533);
      return null;
    }
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      fes localfes = (fes)paramList.next();
      bsg localbsg = new bsg();
      localbsg.aaae = localfes;
      ((LinkedList)localObject).add(localbsg);
    }
    AppMethodBeat.o(333533);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ai
 * JD-Core Version:    0.7.0.1
 */