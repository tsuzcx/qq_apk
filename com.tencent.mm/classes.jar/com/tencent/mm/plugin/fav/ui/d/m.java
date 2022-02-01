package com.tencent.mm.plugin.fav.ui.d;

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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends b
{
  private HashMap<String, SpannableString> tlN;
  private final int tlc;
  
  public m(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.tlN = new HashMap();
    this.tlc = a.aG(paramo.context, 2131165370);
    AppMethodBeat.o(107477);
  }
  
  private static String X(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, aml paramaml)
  {
    AppMethodBeat.i(107479);
    if (!paramaml.Lwk)
    {
      Log.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      Log.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramaml.dataType) });
      switch (paramaml.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(l.b(paramTextView1.getContext(), paramaml.Lwj, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(l.b(paramTextView2.getContext(), paramaml.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759342));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759340) + paramaml.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.cUq())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759340) + Util.nullAsNil(paramaml.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759337) + paramaml.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramaml.Lwh.LwQ;
      paramaml = new StringBuilder().append(X(paramTextView2.getContext(), 2131759336));
      if (Util.isNullOrNil(paramTextView1.dWi)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.dWi)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759331) + paramaml.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759327));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759341));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759334));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759250) + paramaml.Lwh.LwU.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759231));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759339));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(X(paramTextView2.getContext(), 2131759329) + paramaml.title);
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
    label340:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localObject = a(View.inflate((Context)localObject, 2131494132, null), paramViewGroup, paramg);
      paramViewGroup.nnL = ((ImageView)((View)localObject).findViewById(2131300468));
      paramViewGroup.tlP = ((TextView)((View)localObject).findViewById(2131300527));
      paramViewGroup.tlQ = ((TextView)((View)localObject).findViewById(2131300452));
      paramViewGroup.tlR = ((TextView)((View)localObject).findViewById(2131300528));
      paramViewGroup.tlS = ((TextView)((View)localObject).findViewById(2131300453));
      paramViewGroup.tlC = ((ImageView)((View)localObject).findViewById(2131300475));
      paramViewGroup.tlO = ((ImageView)((View)localObject).findViewById(2131300474));
      paramViewGroup.tlT = ((FrameLayout)((View)localObject).findViewById(2131300470));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.ppH;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label433;
      }
      switch (((aml)paramView.next()).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      default: 
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
        break label340;
      }
      bool = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label340;
      }
      j = 1;
      k = i;
    }
    label433:
    Log.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      Log.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return localObject;
    }
    paramView = (aml)localLinkedList.get(j);
    a(paramViewGroup.tlP, paramViewGroup.tlQ, paramView);
    ImageView localImageView;
    aml localaml;
    label647:
    o localo;
    if (bool)
    {
      paramViewGroup.tlT.setVisibility(0);
      paramViewGroup.nnL.setVisibility(0);
      localImageView = paramViewGroup.nnL;
      localaml = (aml)localLinkedList.get(m);
      switch (localaml.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.tlR.setVisibility(0);
            paramViewGroup.tlS.setVisibility(0);
            a(paramViewGroup.tlR, paramViewGroup.tlS, (aml)localLinkedList.get(j + 1));
            AppMethodBeat.o(107478);
            return localObject;
            localo = this.tdg;
            i = this.tlc;
            k = this.tlc;
            if (localImageView != null) {
              if (!e.apn())
              {
                localImageView.setImageResource(2131234279);
              }
              else if ((localaml != null) && (paramg != null))
              {
                String str = localaml.dLl;
                if (str != null)
                {
                  paramView = null;
                  if (localaml.dLl != null)
                  {
                    paramView = (String[])localo.tgg.get(str);
                    if (paramView != null) {
                      break label900;
                    }
                    paramView = new String[2];
                    paramView[0] = com.tencent.mm.plugin.fav.a.b.d(localaml);
                    paramView[1] = com.tencent.mm.plugin.fav.a.b.a(localaml);
                    localo.tgg.put(str, paramView);
                  }
                }
              }
            }
          }
        }
      }
    }
    label900:
    for (;;)
    {
      localo.tgf.a(localImageView, paramView, null, 2131691393, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.aAk().postToWorker(new o.2(localo, paramView, paramg, localaml));
      break;
      this.tdg.b(localImageView, localaml, paramg, 2131689584, this.tlc, this.tlc);
      break;
      paramViewGroup.tlT.setVisibility(8);
      paramViewGroup.nnL.setVisibility(8);
      break;
      paramViewGroup.tlR.setVisibility(8);
      paramViewGroup.tlS.setVisibility(8);
      break label647;
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView nnL;
    ImageView tlC;
    ImageView tlO;
    TextView tlP;
    TextView tlQ;
    TextView tlR;
    TextView tlS;
    FrameLayout tlT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.m
 * JD-Core Version:    0.7.0.1
 */