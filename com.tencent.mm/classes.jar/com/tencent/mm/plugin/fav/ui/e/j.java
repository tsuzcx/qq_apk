package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends b
{
  private static int rLq;
  
  public j(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    rLq = com.tencent.mm.cb.a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107469);
  }
  
  private static String a(ake paramake)
  {
    AppMethodBeat.i(107471);
    if (paramake == null)
    {
      ae.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramake = paramake.label;
    AppMethodBeat.o(107471);
    return paramake;
  }
  
  private static String b(ake paramake)
  {
    AppMethodBeat.i(107472);
    if (paramake == null)
    {
      ae.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramake = paramake.dEv;
    AppMethodBeat.o(107472);
    return paramake;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107470);
    paramViewGroup = paramViewGroup.getContext();
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a();
      localView = a(View.inflate(paramViewGroup, 2131493967, null), locala, paramg);
      locala.rLJ = localView.findViewById(2131303890);
      locala.rLK = localView.findViewById(2131298545);
      locala.rLL = localView.findViewById(2131306490);
      locala.rLM = localView.findViewById(2131298213);
      locala.rLN = localView.findViewById(2131299820);
      locala.rLO = ((ImageView)localView.findViewById(2131299818));
      locala.rLQ = localView.findViewById(2131299796);
      locala.rLP = ((ImageView)localView.findViewById(2131299800));
      locala.rLR = ((TextView)localView.findViewById(2131299797));
      locala.rLS = ((TextView)localView.findViewById(2131299824));
      locala.rLT = ((TextView)localView.findViewById(2131299819));
      locala.rLU = ((ImageView)localView.findViewById(2131299776));
      locala.rLV = ((TextView)localView.findViewById(2131299768));
      locala.rLW = ((TextView)localView.findViewById(2131299767));
      locala.rLX = ((TextView)localView.findViewById(2131299856));
      locala.rLY = ((TextView)localView.findViewById(2131299770));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.oeJ;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      ae.e("MicroMsg.Fav.FavNoteListItem", "no other item");
      AppMethodBeat.o(107470);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
    }
    int m = -1;
    int i3 = ((List)localObject2).size();
    int j = 0;
    int i2 = -1;
    int i4 = 1;
    int k = 0;
    int i = 0;
    if (k < ((List)localObject2).size())
    {
      paramViewGroup = (ajx)((List)localObject2).get(k);
      if (k == 0)
      {
        paramView = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.fav.a.b.d(paramViewGroup));
        if (!paramView.exists()) {
          o.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.GAC == null)
        {
          paramViewGroup = new nk();
          paramViewGroup.dCo.type = 10;
          paramViewGroup.dCo.field_localId = paramg.field_localId;
          paramViewGroup.dCo.path = w.B(paramView.fTh());
          com.tencent.mm.sdk.b.a.IvT.l(paramViewGroup);
        }
        continue;
        int i1;
        if ((paramViewGroup.dataType != 2) && (paramViewGroup.dataType != 4))
        {
          i1 = j;
          n = m;
          j = i;
          if (paramViewGroup.dataType != 15) {}
        }
        else
        {
          i += 1;
          int i5 = 1;
          i1 = i5;
          n = m;
          j = i;
          if (m == -1)
          {
            n = k;
            j = i;
            i1 = i5;
          }
        }
        switch (paramViewGroup.dataType)
        {
        }
        do
        {
          i4 = 0;
          i = j;
          j = i1;
          m = n;
          break;
          i2 = k;
          i = j;
          j = i1;
          m = n;
          break;
        } while (bu.bI(paramViewGroup.desc, "").trim().length() > 0);
        i3 -= 1;
        i = j;
        j = i1;
        m = n;
      }
    }
    if ((i4 != 0) && (i3 == 2))
    {
      k = 1;
      if ((k == 0) || (i2 <= 0)) {
        break label1192;
      }
      localObject2 = (ajx)((List)localObject2).get(i2);
      if (((ajx)localObject2).dataType != 3) {
        break label860;
      }
      locala.rLJ.setVisibility(8);
      locala.rLK.setVisibility(8);
      locala.rLL.setVisibility(0);
      locala.rLM.setVisibility(8);
      locala.rLX.setText(n.R(this.rDB.context, (int)com.tencent.mm.plugin.fav.a.b.vK(((ajx)localObject2).duration)));
    }
    label860:
    label997:
    Object localObject1;
    for (;;)
    {
      AppMethodBeat.o(107470);
      return localView;
      k = 0;
      break;
      if (((ajx)localObject2).dataType == 20)
      {
        locala.rLJ.setVisibility(8);
        locala.rLK.setVisibility(8);
        locala.rLL.setVisibility(8);
        locala.rLM.setVisibility(0);
        locala.rLY.setText(n.R(this.rDB.context, (int)com.tencent.mm.plugin.fav.a.b.vK(((ajx)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((ajx)localObject2).dataType == 6)
        {
          i = 2131689562;
          paramg = ((ajx)localObject2).GAu.GBd;
          paramViewGroup = ((ajx)localObject2).GAu.iWF;
          if (bu.isNullOrNil(paramViewGroup)) {
            if (n.ahJ(b(paramg)))
            {
              paramView = b(paramg);
              paramg = a(paramg);
              paramViewGroup = paramView;
              paramView = paramg;
            }
          }
        }
        for (;;)
        {
          locala.rLL.setVisibility(8);
          locala.rLM.setVisibility(8);
          locala.rLJ.setVisibility(8);
          locala.rLK.setVisibility(0);
          locala.rLU.setImageResource(i);
          locala.rLV.setText(paramViewGroup);
          if (bu.isNullOrNil(paramView)) {
            break label1179;
          }
          locala.rLW.setText(paramView);
          locala.rLW.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.ahJ(b(paramg))) {
            break label997;
          }
          paramView = b(paramg);
          continue;
          j = e.ahD(((ajx)localObject2).GzP);
          paramg = ((ajx)localObject2).title;
          localObject1 = ((ajx)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bu.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.ba((float)((ajx)localObject2).GzV);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1179:
        locala.rLW.setVisibility(8);
      }
    }
    label1192:
    locala.rLJ.setVisibility(0);
    locala.rLK.setVisibility(8);
    locala.rLL.setVisibility(8);
    locala.rLM.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (ajx)((List)localObject2).get(n);
        if (((ajx)localObject1).dataType == 1)
        {
          localObject1 = ((ajx)localObject1).desc;
          if (bu.isNullOrNil((String)localObject1)) {
            break label2554;
          }
          paramView = (View)localObject1;
          if (((String)localObject1).length() > 1000) {
            paramView = ((String)localObject1).substring(0, 1000);
          }
          paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
          label1363:
          localObject1 = paramViewGroup;
          if (paramView == null) {
            break label2571;
          }
          localObject1 = paramViewGroup;
          if (paramView.length <= 0) {
            break label2571;
          }
          ArrayList localArrayList2 = new ArrayList();
          k = 0;
          for (;;)
          {
            if (k < paramView.length)
            {
              if (!bu.isNullOrNil(paramView[k].trim()))
              {
                localArrayList2.add(paramView[k]);
                label1420:
                k += 1;
                localObject1 = "";
                while (k < paramView.length)
                {
                  localObject1 = (String)localObject1 + paramView[k] + " ";
                  k += 1;
                }
              }
              k += 1;
              continue;
              paramView = ((String)localObject1).trim();
              if (paramView.length() > 0) {
                localArrayList2.add(paramView);
              }
              k = 0;
              if ((localArrayList2.size() > 0) && (bu.isNullOrNil(paramViewGroup)))
              {
                paramView = (String)localArrayList2.get(0);
                k = 1;
                label1536:
                while (k < localArrayList2.size())
                {
                  localArrayList1.add(localArrayList2.get(k));
                  k += 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          paramView = localView.getContext();
          switch (((ajx)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (bu.isNullOrNil(paramView)) {
              break label2571;
            }
            localArrayList1.add(paramView);
            localObject1 = paramViewGroup;
          }
        }
        catch (Exception paramView)
        {
          ae.e("MicroMsg.Fav.FavNoteListItem", "getDataItemDesc exception:".concat(String.valueOf(paramView)));
          localObject1 = paramViewGroup;
        }
        paramView = n.S(paramView, 2131759016) + " " + n.R(paramView, (int)com.tencent.mm.plugin.fav.a.b.vK(((ajx)localObject1).duration));
        continue;
        paramView = n.S(paramView, 2131759014) + " " + ((ajx)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.cwn())
        {
          paramView = n.S(paramView, 2131759014) + " " + ((ajx)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131759011) + " " + ((ajx)localObject1).title;
          continue;
          localObject1 = ((ajx)localObject1).GAu.GBd;
          if (localObject1 == null)
          {
            paramView = n.S(paramView, 2131759010);
            continue;
          }
          if (n.ahJ(((ake)localObject1).dEv))
          {
            paramView = n.S(paramView, 2131759010) + " " + ((ake)localObject1).dEv;
            continue;
          }
          paramView = n.S(paramView, 2131759010) + " " + ((ake)localObject1).label;
          continue;
          paramView = n.S(paramView, 2131759006) + " " + ((ajx)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131758926) + " " + ((ajx)localObject1).GAu.GBh.title;
          continue;
          paramView = n.S(paramView, 2131758907);
          continue;
          if (!bu.isNullOrNil(paramViewGroup))
          {
            locala.rLS.setText(com.tencent.mm.pluginsdk.ui.span.k.b(locala.rLS.getContext(), paramViewGroup, locala.rLS.getTextSize()));
            locala.rLS.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.rLS.setMaxLines(1);
            }
          }
          for (;;)
          {
            paramView = new StringBuffer();
            k = 0;
            while ((k < localArrayList1.size()) && (k < 2))
            {
              paramView.append((String)localArrayList1.get(k));
              paramView.append("\n");
              k += 1;
            }
            locala.rLS.setMaxLines(3);
            continue;
            locala.rLS.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.rLT.setText(com.tencent.mm.pluginsdk.ui.span.k.b(locala.rLT.getContext(), paramView, locala.rLT.getTextSize()));
            locala.rLT.setVisibility(0);
            label2303:
            if (j == 0) {
              break label2530;
            }
            locala.rLN.setVisibility(0);
            paramView = (ajx)((List)localObject2).get(m);
            if (((ajx)((List)localObject2).get(m)).dataType != 2) {
              break label2455;
            }
            paramViewGroup = locala.rLO;
            j = rLq;
            o.a(paramViewGroup, 2131690142, paramView, paramg, true, j, j);
            locala.rLP.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2507;
            }
            locala.rLR.setText(localView.getContext().getString(2131758911, new Object[] { Integer.valueOf(i) }));
            locala.rLR.setVisibility(0);
            locala.rLQ.setVisibility(0);
            break;
            locala.rLT.setVisibility(8);
            break label2303;
            label2455:
            locala.rLP.setVisibility(0);
            paramViewGroup = this.rDB;
            localObject1 = locala.rLO;
            localObject2 = paramView.dox;
            j = rLq;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131689581, j, j);
          }
          label2507:
          locala.rLR.setVisibility(8);
          locala.rLQ.setVisibility(8);
          break;
          label2530:
          locala.rLN.setVisibility(8);
          break;
          paramView = paramViewGroup;
          break label1536;
          k = 0;
          break label1420;
          label2554:
          paramView = null;
          break label1363;
          localObject1 = paramView;
          break label2571;
        }
        paramView = "";
      }
      label2571:
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View rLJ;
    View rLK;
    View rLL;
    View rLM;
    View rLN;
    ImageView rLO;
    ImageView rLP;
    View rLQ;
    TextView rLR;
    TextView rLS;
    TextView rLT;
    ImageView rLU;
    TextView rLV;
    TextView rLW;
    TextView rLX;
    TextView rLY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.j
 * JD-Core Version:    0.7.0.1
 */