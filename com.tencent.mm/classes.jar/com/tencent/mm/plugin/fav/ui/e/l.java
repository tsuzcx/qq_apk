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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.h;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.o.2;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
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
  private final int qkA;
  private HashMap<String, SpannableString> qlk;
  
  public l(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.qlk = new HashMap();
    this.qkA = a.ao(paramo.context, 2131165359);
    AppMethodBeat.o(107477);
  }
  
  private static String O(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, afy paramafy)
  {
    AppMethodBeat.i(107479);
    if (!paramafy.DgW)
    {
      ad.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      ad.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramafy.dataType) });
      switch (paramafy.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(k.b(paramTextView1.getContext(), paramafy.DgV, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(k.b(paramTextView2.getContext(), paramafy.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759016));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759014) + paramafy.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.chA())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759014) + bt.nullAsNil(paramafy.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759011) + paramafy.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramafy.DgT.DhC;
      paramafy = new StringBuilder().append(O(paramTextView2.getContext(), 2131759010));
      if (bt.isNullOrNil(paramTextView1.dtN)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.dtN)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759006) + paramafy.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759002));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759015));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759008));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131758926) + paramafy.DgT.DhG.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131758907));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759013));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(O(paramTextView2.getContext(), 2131759004) + paramafy.title);
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
      paramViewGroup.kXS = ((ImageView)((View)localObject).findViewById(2131299794));
      paramViewGroup.qlm = ((TextView)((View)localObject).findViewById(2131299849));
      paramViewGroup.qln = ((TextView)((View)localObject).findViewById(2131299779));
      paramViewGroup.qlo = ((TextView)((View)localObject).findViewById(2131299850));
      paramViewGroup.qlp = ((TextView)((View)localObject).findViewById(2131299780));
      paramViewGroup.qkZ = ((ImageView)((View)localObject).findViewById(2131299800));
      paramViewGroup.qll = ((ImageView)((View)localObject).findViewById(2131299799));
      paramViewGroup.qlq = ((FrameLayout)((View)localObject).findViewById(2131299795));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.mVb;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label405;
      }
      switch (((afy)paramView.next()).dataType)
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
    paramView = (afy)localLinkedList.get(j);
    a(paramViewGroup.qlm, paramViewGroup.qln, paramView);
    ImageView localImageView;
    afy localafy;
    label619:
    o localo;
    if (bool)
    {
      paramViewGroup.qlq.setVisibility(0);
      paramViewGroup.kXS.setVisibility(0);
      localImageView = paramViewGroup.kXS;
      localafy = (afy)localLinkedList.get(m);
      switch (localafy.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.qlo.setVisibility(0);
            paramViewGroup.qlp.setVisibility(0);
            a(paramViewGroup.qlo, paramViewGroup.qlp, (afy)localLinkedList.get(j + 1));
            AppMethodBeat.o(107478);
            return localObject;
            localo = this.qcI;
            i = this.qkA;
            k = this.qkA;
            if (localImageView != null) {
              if (!e.XG())
              {
                localImageView.setImageResource(2131233476);
              }
              else if ((localafy != null) && (paramg != null))
              {
                String str = localafy.dkb;
                if (str != null)
                {
                  paramView = null;
                  if (localafy.dkb != null)
                  {
                    paramView = (String[])localo.qfO.get(str);
                    if (paramView != null) {
                      break label872;
                    }
                    paramView = new String[2];
                    paramView[0] = com.tencent.mm.plugin.fav.a.b.d(localafy);
                    paramView[1] = com.tencent.mm.plugin.fav.a.b.a(localafy);
                    localo.qfO.put(str, paramView);
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
      localo.qfN.a(localImageView, paramView, null, 2131691091, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.afE().ax(new o.2(localo, paramView, paramg, localafy));
      break;
      this.qcI.b(localImageView, localafy, paramg, 2131689581, this.qkA, this.qkA);
      break;
      paramViewGroup.qlq.setVisibility(8);
      paramViewGroup.kXS.setVisibility(8);
      break;
      paramViewGroup.qlo.setVisibility(8);
      paramViewGroup.qlp.setVisibility(8);
      break label619;
    }
  }
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView kXS;
    ImageView qkZ;
    ImageView qll;
    TextView qlm;
    TextView qln;
    TextView qlo;
    TextView qlp;
    FrameLayout qlq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.l
 * JD-Core Version:    0.7.0.1
 */