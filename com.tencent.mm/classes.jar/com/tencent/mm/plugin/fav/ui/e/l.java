package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.h;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.o.2;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends b
{
  private HashMap<String, SpannableString> rDP;
  private final int rDf;
  
  public l(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.rDP = new HashMap();
    this.rDf = a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107477);
  }
  
  private static String S(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, ajn paramajn)
  {
    AppMethodBeat.i(107479);
    if (!paramajn.GhO)
    {
      ad.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      ad.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramajn.dataType) });
      switch (paramajn.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(k.b(paramTextView1.getContext(), paramajn.GhN, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(k.b(paramTextView2.getContext(), paramajn.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759016));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + paramajn.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.cuM())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + bt.nullAsNil(paramajn.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759011) + paramajn.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramajn.GhL.Giu;
      paramajn = new StringBuilder().append(S(paramTextView2.getContext(), 2131759010));
      if (bt.isNullOrNil(paramTextView1.dDq)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.dDq)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759006) + paramajn.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759002));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759015));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759008));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758926) + paramajn.GhL.Giy.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758907));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759013));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759004) + paramajn.title);
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107478);
    Object localObject = paramViewGroup.getContext();
    int m;
    int i;
    boolean bool;
    LinkedList localLinkedList;
    int k;
    int j;
    label190:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localObject = a(View.inflate((Context)localObject, 2131493962, null), paramViewGroup, paramg);
      paramViewGroup.lZa = ((ImageView)((View)localObject).findViewById(2131299794));
      paramViewGroup.rDR = ((TextView)((View)localObject).findViewById(2131299849));
      paramViewGroup.rDS = ((TextView)((View)localObject).findViewById(2131299779));
      paramViewGroup.rDT = ((TextView)((View)localObject).findViewById(2131299850));
      paramViewGroup.rDU = ((TextView)((View)localObject).findViewById(2131299780));
      paramViewGroup.rDE = ((ImageView)((View)localObject).findViewById(2131299800));
      paramViewGroup.rDQ = ((ImageView)((View)localObject).findViewById(2131299799));
      paramViewGroup.rDV = ((FrameLayout)((View)localObject).findViewById(2131299795));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.nZa;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label405;
      }
      switch (((ajn)paramView.next()).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      default: 
        label312:
        n = k;
        k = j;
        j = n;
      }
    }
    for (;;)
    {
      n = i + 1;
      i = j;
      j = k;
      k = i;
      i = n;
      break label190;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
      break;
      if (bool) {
        break label312;
      }
      bool = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label312;
      }
      j = 1;
      k = i;
    }
    label405:
    ad.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      ad.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return localObject;
    }
    paramView = (ajn)localLinkedList.get(j);
    a(paramViewGroup.rDR, paramViewGroup.rDS, paramView);
    ImageView localImageView;
    ajn localajn;
    label619:
    o localo;
    if (bool)
    {
      paramViewGroup.rDV.setVisibility(0);
      paramViewGroup.lZa.setVisibility(0);
      localImageView = paramViewGroup.lZa;
      localajn = (ajn)localLinkedList.get(m);
      switch (localajn.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.rDT.setVisibility(0);
            paramViewGroup.rDU.setVisibility(0);
            a(paramViewGroup.rDT, paramViewGroup.rDU, (ajn)localLinkedList.get(j + 1));
            AppMethodBeat.o(107478);
            return localObject;
            localo = this.rvp;
            i = this.rDf;
            k = this.rDf;
            if (localImageView != null) {
              if (!e.abf())
              {
                localImageView.setImageResource(2131233476);
              }
              else if ((localajn != null) && (paramg != null))
              {
                String str = localajn.dsU;
                if (str != null)
                {
                  paramView = null;
                  if (localajn.dsU != null)
                  {
                    paramView = (String[])localo.ryp.get(str);
                    if (paramView != null) {
                      break label872;
                    }
                    paramView = new String[2];
                    paramView[0] = com.tencent.mm.plugin.fav.a.b.d(localajn);
                    paramView[1] = com.tencent.mm.plugin.fav.a.b.a(localajn);
                    localo.ryp.put(str, paramView);
                  }
                }
              }
            }
          }
        }
      }
    }
    label872:
    for (;;)
    {
      localo.ryo.a(localImageView, paramView, null, 2131691091, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.ajF().ay(new o.2(localo, paramView, paramg, localajn));
      break;
      this.rvp.b(localImageView, localajn, paramg, 2131689581, this.rDf, this.rDf);
      break;
      paramViewGroup.rDV.setVisibility(8);
      paramViewGroup.lZa.setVisibility(8);
      break;
      paramViewGroup.rDT.setVisibility(8);
      paramViewGroup.rDU.setVisibility(8);
      break label619;
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView lZa;
    ImageView rDE;
    ImageView rDQ;
    TextView rDR;
    TextView rDS;
    TextView rDT;
    TextView rDU;
    FrameLayout rDV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.l
 * JD-Core Version:    0.7.0.1
 */