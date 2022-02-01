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
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends b
{
  private HashMap<String, SpannableString> qTM;
  private final int qTc;
  
  public l(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.qTM = new HashMap();
    this.qTc = a.au(paramo.context, 2131165359);
    AppMethodBeat.o(107477);
  }
  
  private static String S(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, agx paramagx)
  {
    AppMethodBeat.i(107479);
    if (!paramagx.EAc)
    {
      ac.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      ac.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramagx.dataType) });
      switch (paramagx.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(k.b(paramTextView1.getContext(), paramagx.EAb, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(k.b(paramTextView2.getContext(), paramagx.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759016));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + paramagx.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.cph())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + bs.nullAsNil(paramagx.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759011) + paramagx.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramagx.EzZ.EAI;
      paramagx = new StringBuilder().append(S(paramTextView2.getContext(), 2131759010));
      if (bs.isNullOrNil(paramTextView1.dry)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.dry)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759006) + paramagx.title);
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
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758926) + paramagx.EzZ.EAM.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758907));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759013));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759004) + paramagx.title);
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
      paramViewGroup.lzC = ((ImageView)((View)localObject).findViewById(2131299794));
      paramViewGroup.qTO = ((TextView)((View)localObject).findViewById(2131299849));
      paramViewGroup.qTP = ((TextView)((View)localObject).findViewById(2131299779));
      paramViewGroup.qTQ = ((TextView)((View)localObject).findViewById(2131299850));
      paramViewGroup.qTR = ((TextView)((View)localObject).findViewById(2131299780));
      paramViewGroup.qTB = ((ImageView)((View)localObject).findViewById(2131299800));
      paramViewGroup.qTN = ((ImageView)((View)localObject).findViewById(2131299799));
      paramViewGroup.qTS = ((FrameLayout)((View)localObject).findViewById(2131299795));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.nxC;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label405;
      }
      switch (((agx)paramView.next()).dataType)
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
    ac.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      ac.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return localObject;
    }
    paramView = (agx)localLinkedList.get(j);
    a(paramViewGroup.qTO, paramViewGroup.qTP, paramView);
    ImageView localImageView;
    agx localagx;
    label619:
    o localo;
    if (bool)
    {
      paramViewGroup.qTS.setVisibility(0);
      paramViewGroup.lzC.setVisibility(0);
      localImageView = paramViewGroup.lzC;
      localagx = (agx)localLinkedList.get(m);
      switch (localagx.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.qTQ.setVisibility(0);
            paramViewGroup.qTR.setVisibility(0);
            a(paramViewGroup.qTQ, paramViewGroup.qTR, (agx)localLinkedList.get(j + 1));
            AppMethodBeat.o(107478);
            return localObject;
            localo = this.qLn;
            i = this.qTc;
            k = this.qTc;
            if (localImageView != null) {
              if (!e.YD())
              {
                localImageView.setImageResource(2131233476);
              }
              else if ((localagx != null) && (paramg != null))
              {
                String str = localagx.dhw;
                if (str != null)
                {
                  paramView = null;
                  if (localagx.dhw != null)
                  {
                    paramView = (String[])localo.qOq.get(str);
                    if (paramView != null) {
                      break label872;
                    }
                    paramView = new String[2];
                    paramView[0] = com.tencent.mm.plugin.fav.a.b.d(localagx);
                    paramView[1] = com.tencent.mm.plugin.fav.a.b.a(localagx);
                    localo.qOq.put(str, paramView);
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
      localo.qOp.a(localImageView, paramView, null, 2131691091, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.agU().az(new o.2(localo, paramView, paramg, localagx));
      break;
      this.qLn.b(localImageView, localagx, paramg, 2131689581, this.qTc, this.qTc);
      break;
      paramViewGroup.qTS.setVisibility(8);
      paramViewGroup.lzC.setVisibility(8);
      break;
      paramViewGroup.qTQ.setVisibility(8);
      paramViewGroup.qTR.setVisibility(8);
      break label619;
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView lzC;
    ImageView qTB;
    ImageView qTN;
    TextView qTO;
    TextView qTP;
    TextView qTQ;
    TextView qTR;
    FrameLayout qTS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.l
 * JD-Core Version:    0.7.0.1
 */