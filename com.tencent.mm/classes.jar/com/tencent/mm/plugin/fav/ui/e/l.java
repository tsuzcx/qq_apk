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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.h;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.o.2;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends b
{
  private final int rLq;
  private HashMap<String, SpannableString> rMa;
  
  public l(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.rMa = new HashMap();
    this.rLq = a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107477);
  }
  
  private static String S(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, ajx paramajx)
  {
    AppMethodBeat.i(107479);
    if (!paramajx.GAx)
    {
      ae.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      ae.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramajx.dataType) });
      switch (paramajx.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(k.b(paramTextView1.getContext(), paramajx.GAw, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(k.b(paramTextView2.getContext(), paramajx.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759016));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + paramajx.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.cwn())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759014) + bu.nullAsNil(paramajx.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759011) + paramajx.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramajx.GAu.GBd;
      paramajx = new StringBuilder().append(S(paramTextView2.getContext(), 2131759010));
      if (bu.isNullOrNil(paramTextView1.dEv)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.dEv)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759006) + paramajx.title);
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
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758926) + paramajx.GAu.GBh.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131758907));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759013));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(S(paramTextView2.getContext(), 2131759004) + paramajx.title);
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
      paramViewGroup.mdt = ((ImageView)((View)localObject).findViewById(2131299794));
      paramViewGroup.rMc = ((TextView)((View)localObject).findViewById(2131299849));
      paramViewGroup.rMd = ((TextView)((View)localObject).findViewById(2131299779));
      paramViewGroup.rMe = ((TextView)((View)localObject).findViewById(2131299850));
      paramViewGroup.rMf = ((TextView)((View)localObject).findViewById(2131299780));
      paramViewGroup.rLP = ((ImageView)((View)localObject).findViewById(2131299800));
      paramViewGroup.rMb = ((ImageView)((View)localObject).findViewById(2131299799));
      paramViewGroup.rMg = ((FrameLayout)((View)localObject).findViewById(2131299795));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.oeJ;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label405;
      }
      switch (((ajx)paramView.next()).dataType)
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
    ae.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      ae.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return localObject;
    }
    paramView = (ajx)localLinkedList.get(j);
    a(paramViewGroup.rMc, paramViewGroup.rMd, paramView);
    ImageView localImageView;
    ajx localajx;
    label619:
    o localo;
    if (bool)
    {
      paramViewGroup.rMg.setVisibility(0);
      paramViewGroup.mdt.setVisibility(0);
      localImageView = paramViewGroup.mdt;
      localajx = (ajx)localLinkedList.get(m);
      switch (localajx.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.rMe.setVisibility(0);
            paramViewGroup.rMf.setVisibility(0);
            a(paramViewGroup.rMe, paramViewGroup.rMf, (ajx)localLinkedList.get(j + 1));
            AppMethodBeat.o(107478);
            return localObject;
            localo = this.rDB;
            i = this.rLq;
            k = this.rLq;
            if (localImageView != null) {
              if (!e.abo())
              {
                localImageView.setImageResource(2131233476);
              }
              else if ((localajx != null) && (paramg != null))
              {
                String str = localajx.dua;
                if (str != null)
                {
                  paramView = null;
                  if (localajx.dua != null)
                  {
                    paramView = (String[])localo.rGA.get(str);
                    if (paramView != null) {
                      break label872;
                    }
                    paramView = new String[2];
                    paramView[0] = com.tencent.mm.plugin.fav.a.b.d(localajx);
                    paramView[1] = com.tencent.mm.plugin.fav.a.b.a(localajx);
                    localo.rGA.put(str, paramView);
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
      localo.rGz.a(localImageView, paramView, null, 2131691091, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.ajU().aw(new o.2(localo, paramView, paramg, localajx));
      break;
      this.rDB.b(localImageView, localajx, paramg, 2131689581, this.rLq, this.rLq);
      break;
      paramViewGroup.rMg.setVisibility(8);
      paramViewGroup.mdt.setVisibility(8);
      break;
      paramViewGroup.rMe.setVisibility(8);
      paramViewGroup.rMf.setVisibility(8);
      break label619;
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView mdt;
    ImageView rLP;
    ImageView rMb;
    TextView rMc;
    TextView rMd;
    TextView rMe;
    TextView rMf;
    FrameLayout rMg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.l
 * JD-Core Version:    0.7.0.1
 */