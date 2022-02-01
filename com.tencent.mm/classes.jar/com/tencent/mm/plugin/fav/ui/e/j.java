package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends b
{
  private static int qkA;
  
  public j(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    qkA = com.tencent.mm.cd.a.ao(paramo.context, 2131165359);
    AppMethodBeat.o(107469);
  }
  
  private static String a(agf paramagf)
  {
    AppMethodBeat.i(107471);
    if (paramagf == null)
    {
      ad.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramagf = paramagf.label;
    AppMethodBeat.o(107471);
    return paramagf;
  }
  
  private static String b(agf paramagf)
  {
    AppMethodBeat.i(107472);
    if (paramagf == null)
    {
      ad.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramagf = paramagf.dtN;
    AppMethodBeat.o(107472);
    return paramagf;
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
      locala.qkT = localView.findViewById(2131303890);
      locala.qkU = localView.findViewById(2131298545);
      locala.qkV = localView.findViewById(2131306490);
      locala.qkW = localView.findViewById(2131298213);
      locala.qkX = localView.findViewById(2131299820);
      locala.qkY = ((ImageView)localView.findViewById(2131299818));
      locala.qla = localView.findViewById(2131299796);
      locala.qkZ = ((ImageView)localView.findViewById(2131299800));
      locala.qlb = ((TextView)localView.findViewById(2131299797));
      locala.qlc = ((TextView)localView.findViewById(2131299824));
      locala.qld = ((TextView)localView.findViewById(2131299819));
      locala.qle = ((ImageView)localView.findViewById(2131299776));
      locala.qlf = ((TextView)localView.findViewById(2131299768));
      locala.qlg = ((TextView)localView.findViewById(2131299767));
      locala.qlh = ((TextView)localView.findViewById(2131299856));
      locala.qli = ((TextView)localView.findViewById(2131299770));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.mVb;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      ad.e("MicroMsg.Fav.FavNoteListItem", "no other item");
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
      paramViewGroup = (afy)((List)localObject2).get(k);
      if (k == 0)
      {
        paramView = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.d(paramViewGroup));
        if (!paramView.exists()) {
          o.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.Dhb == null)
        {
          paramViewGroup = new ms();
          paramViewGroup.drL.type = 10;
          paramViewGroup.drL.field_localId = paramg.field_localId;
          paramViewGroup.drL.path = q.B(paramView.fhU());
          com.tencent.mm.sdk.b.a.ESL.l(paramViewGroup);
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
        } while (bt.by(paramViewGroup.desc, "").trim().length() > 0);
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
      localObject2 = (afy)((List)localObject2).get(i2);
      if (((afy)localObject2).dataType != 3) {
        break label860;
      }
      locala.qkT.setVisibility(8);
      locala.qkU.setVisibility(8);
      locala.qkV.setVisibility(0);
      locala.qkW.setVisibility(8);
      locala.qlh.setText(n.N(this.qcI.context, (int)com.tencent.mm.plugin.fav.a.b.pI(((afy)localObject2).duration)));
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
      if (((afy)localObject2).dataType == 20)
      {
        locala.qkT.setVisibility(8);
        locala.qkU.setVisibility(8);
        locala.qkV.setVisibility(8);
        locala.qkW.setVisibility(0);
        locala.qli.setText(n.N(this.qcI.context, (int)com.tencent.mm.plugin.fav.a.b.pI(((afy)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((afy)localObject2).dataType == 6)
        {
          i = 2131689562;
          paramg = ((afy)localObject2).DgT.DhC;
          paramViewGroup = ((afy)localObject2).DgT.iaz;
          if (bt.isNullOrNil(paramViewGroup)) {
            if (n.YB(b(paramg)))
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
          locala.qkV.setVisibility(8);
          locala.qkW.setVisibility(8);
          locala.qkT.setVisibility(8);
          locala.qkU.setVisibility(0);
          locala.qle.setImageResource(i);
          locala.qlf.setText(paramViewGroup);
          if (bt.isNullOrNil(paramView)) {
            break label1179;
          }
          locala.qlg.setText(paramView);
          locala.qlg.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.YB(b(paramg))) {
            break label997;
          }
          paramView = b(paramg);
          continue;
          j = com.tencent.mm.plugin.fav.ui.e.Yv(((afy)localObject2).Dgo);
          paramg = ((afy)localObject2).title;
          localObject1 = ((afy)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bt.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.aS((float)((afy)localObject2).Dgu);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1179:
        locala.qlg.setVisibility(8);
      }
    }
    label1192:
    locala.qkT.setVisibility(0);
    locala.qkU.setVisibility(8);
    locala.qkV.setVisibility(8);
    locala.qkW.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (afy)((List)localObject2).get(n);
        if (((afy)localObject1).dataType == 1)
        {
          localObject1 = ((afy)localObject1).desc;
          if (bt.isNullOrNil((String)localObject1)) {
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
              if (!bt.isNullOrNil(paramView[k].trim()))
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
              if ((localArrayList2.size() > 0) && (bt.isNullOrNil(paramViewGroup)))
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
          switch (((afy)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (bt.isNullOrNil(paramView)) {
              break label2571;
            }
            localArrayList1.add(paramView);
            localObject1 = paramViewGroup;
          }
        }
        catch (Exception paramView)
        {
          ad.e("MicroMsg.Fav.FavNoteListItem", "getDataItemDesc exception:".concat(String.valueOf(paramView)));
          localObject1 = paramViewGroup;
        }
        paramView = n.O(paramView, 2131759016) + " " + n.N(paramView, (int)com.tencent.mm.plugin.fav.a.b.pI(((afy)localObject1).duration));
        continue;
        paramView = n.O(paramView, 2131759014) + " " + ((afy)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.chA())
        {
          paramView = n.O(paramView, 2131759014) + " " + ((afy)localObject1).title;
          continue;
          paramView = n.O(paramView, 2131759011) + " " + ((afy)localObject1).title;
          continue;
          localObject1 = ((afy)localObject1).DgT.DhC;
          if (localObject1 == null)
          {
            paramView = n.O(paramView, 2131759010);
            continue;
          }
          if (n.YB(((agf)localObject1).dtN))
          {
            paramView = n.O(paramView, 2131759010) + " " + ((agf)localObject1).dtN;
            continue;
          }
          paramView = n.O(paramView, 2131759010) + " " + ((agf)localObject1).label;
          continue;
          paramView = n.O(paramView, 2131759006) + " " + ((afy)localObject1).title;
          continue;
          paramView = n.O(paramView, 2131758926) + " " + ((afy)localObject1).DgT.DhG.title;
          continue;
          paramView = n.O(paramView, 2131758907);
          continue;
          if (!bt.isNullOrNil(paramViewGroup))
          {
            locala.qlc.setText(k.b(locala.qlc.getContext(), paramViewGroup, locala.qlc.getTextSize()));
            locala.qlc.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.qlc.setMaxLines(1);
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
            locala.qlc.setMaxLines(3);
            continue;
            locala.qlc.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.qld.setText(k.b(locala.qld.getContext(), paramView, locala.qld.getTextSize()));
            locala.qld.setVisibility(0);
            label2303:
            if (j == 0) {
              break label2530;
            }
            locala.qkX.setVisibility(0);
            paramView = (afy)((List)localObject2).get(m);
            if (((afy)((List)localObject2).get(m)).dataType != 2) {
              break label2455;
            }
            paramViewGroup = locala.qkY;
            j = qkA;
            o.a(paramViewGroup, 2131690142, paramView, paramg, true, j, j);
            locala.qkZ.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2507;
            }
            locala.qlb.setText(localView.getContext().getString(2131758911, new Object[] { Integer.valueOf(i) }));
            locala.qlb.setVisibility(0);
            locala.qla.setVisibility(0);
            break;
            locala.qld.setVisibility(8);
            break label2303;
            label2455:
            locala.qkZ.setVisibility(0);
            paramViewGroup = this.qcI;
            localObject1 = locala.qkY;
            localObject2 = paramView.deE;
            j = qkA;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131689581, j, j);
          }
          label2507:
          locala.qlb.setVisibility(8);
          locala.qla.setVisibility(8);
          break;
          label2530:
          locala.qkX.setVisibility(8);
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
  
  public final void a(View paramView, agq paramagq)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qaS, paramagq);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View qkT;
    View qkU;
    View qkV;
    View qkW;
    View qkX;
    ImageView qkY;
    ImageView qkZ;
    View qla;
    TextView qlb;
    TextView qlc;
    TextView qld;
    ImageView qle;
    TextView qlf;
    TextView qlg;
    TextView qlh;
    TextView qli;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.j
 * JD-Core Version:    0.7.0.1
 */