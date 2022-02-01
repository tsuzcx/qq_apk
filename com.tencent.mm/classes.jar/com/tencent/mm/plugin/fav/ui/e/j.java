package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends b
{
  private static int rDf;
  
  public j(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    rDf = com.tencent.mm.cc.a.ax(paramo.context, 2131165359);
    AppMethodBeat.o(107469);
  }
  
  private static String a(aju paramaju)
  {
    AppMethodBeat.i(107471);
    if (paramaju == null)
    {
      ad.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramaju = paramaju.label;
    AppMethodBeat.o(107471);
    return paramaju;
  }
  
  private static String b(aju paramaju)
  {
    AppMethodBeat.i(107472);
    if (paramaju == null)
    {
      ad.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramaju = paramaju.dDq;
    AppMethodBeat.o(107472);
    return paramaju;
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
      locala.rDy = localView.findViewById(2131303890);
      locala.rDz = localView.findViewById(2131298545);
      locala.rDA = localView.findViewById(2131306490);
      locala.rDB = localView.findViewById(2131298213);
      locala.rDC = localView.findViewById(2131299820);
      locala.rDD = ((ImageView)localView.findViewById(2131299818));
      locala.rDF = localView.findViewById(2131299796);
      locala.rDE = ((ImageView)localView.findViewById(2131299800));
      locala.rDG = ((TextView)localView.findViewById(2131299797));
      locala.rDH = ((TextView)localView.findViewById(2131299824));
      locala.rDI = ((TextView)localView.findViewById(2131299819));
      locala.rDJ = ((ImageView)localView.findViewById(2131299776));
      locala.rDK = ((TextView)localView.findViewById(2131299768));
      locala.rDL = ((TextView)localView.findViewById(2131299767));
      locala.rDM = ((TextView)localView.findViewById(2131299856));
      locala.rDN = ((TextView)localView.findViewById(2131299770));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.nZa;
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
      paramViewGroup = (ajn)((List)localObject2).get(k);
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
        if (paramViewGroup.GhT == null)
        {
          paramViewGroup = new nj();
          paramViewGroup.dBj.type = 10;
          paramViewGroup.dBj.field_localId = paramg.field_localId;
          paramViewGroup.dBj.path = q.B(paramView.fOK());
          com.tencent.mm.sdk.b.a.IbL.l(paramViewGroup);
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
        } while (bt.bI(paramViewGroup.desc, "").trim().length() > 0);
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
      localObject2 = (ajn)((List)localObject2).get(i2);
      if (((ajn)localObject2).dataType != 3) {
        break label860;
      }
      locala.rDy.setVisibility(8);
      locala.rDz.setVisibility(8);
      locala.rDA.setVisibility(0);
      locala.rDB.setVisibility(8);
      locala.rDM.setText(n.R(this.rvp.context, (int)com.tencent.mm.plugin.fav.a.b.vu(((ajn)localObject2).duration)));
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
      if (((ajn)localObject2).dataType == 20)
      {
        locala.rDy.setVisibility(8);
        locala.rDz.setVisibility(8);
        locala.rDA.setVisibility(8);
        locala.rDB.setVisibility(0);
        locala.rDN.setText(n.R(this.rvp.context, (int)com.tencent.mm.plugin.fav.a.b.vu(((ajn)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((ajn)localObject2).dataType == 6)
        {
          i = 2131689562;
          paramg = ((ajn)localObject2).GhL.Giu;
          paramViewGroup = ((ajn)localObject2).GhL.iTM;
          if (bt.isNullOrNil(paramViewGroup)) {
            if (n.agM(b(paramg)))
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
          locala.rDA.setVisibility(8);
          locala.rDB.setVisibility(8);
          locala.rDy.setVisibility(8);
          locala.rDz.setVisibility(0);
          locala.rDJ.setImageResource(i);
          locala.rDK.setText(paramViewGroup);
          if (bt.isNullOrNil(paramView)) {
            break label1179;
          }
          locala.rDL.setText(paramView);
          locala.rDL.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.agM(b(paramg))) {
            break label997;
          }
          paramView = b(paramg);
          continue;
          j = com.tencent.mm.plugin.fav.ui.e.agG(((ajn)localObject2).Ghg);
          paramg = ((ajn)localObject2).title;
          localObject1 = ((ajn)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bt.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.ba((float)((ajn)localObject2).Ghm);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1179:
        locala.rDL.setVisibility(8);
      }
    }
    label1192:
    locala.rDy.setVisibility(0);
    locala.rDz.setVisibility(8);
    locala.rDA.setVisibility(8);
    locala.rDB.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (ajn)((List)localObject2).get(n);
        if (((ajn)localObject1).dataType == 1)
        {
          localObject1 = ((ajn)localObject1).desc;
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
          switch (((ajn)localObject1).dataType)
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
        paramView = n.S(paramView, 2131759016) + " " + n.R(paramView, (int)com.tencent.mm.plugin.fav.a.b.vu(((ajn)localObject1).duration));
        continue;
        paramView = n.S(paramView, 2131759014) + " " + ((ajn)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.cuM())
        {
          paramView = n.S(paramView, 2131759014) + " " + ((ajn)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131759011) + " " + ((ajn)localObject1).title;
          continue;
          localObject1 = ((ajn)localObject1).GhL.Giu;
          if (localObject1 == null)
          {
            paramView = n.S(paramView, 2131759010);
            continue;
          }
          if (n.agM(((aju)localObject1).dDq))
          {
            paramView = n.S(paramView, 2131759010) + " " + ((aju)localObject1).dDq;
            continue;
          }
          paramView = n.S(paramView, 2131759010) + " " + ((aju)localObject1).label;
          continue;
          paramView = n.S(paramView, 2131759006) + " " + ((ajn)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131758926) + " " + ((ajn)localObject1).GhL.Giy.title;
          continue;
          paramView = n.S(paramView, 2131758907);
          continue;
          if (!bt.isNullOrNil(paramViewGroup))
          {
            locala.rDH.setText(k.b(locala.rDH.getContext(), paramViewGroup, locala.rDH.getTextSize()));
            locala.rDH.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.rDH.setMaxLines(1);
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
            locala.rDH.setMaxLines(3);
            continue;
            locala.rDH.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.rDI.setText(k.b(locala.rDI.getContext(), paramView, locala.rDI.getTextSize()));
            locala.rDI.setVisibility(0);
            label2303:
            if (j == 0) {
              break label2530;
            }
            locala.rDC.setVisibility(0);
            paramView = (ajn)((List)localObject2).get(m);
            if (((ajn)((List)localObject2).get(m)).dataType != 2) {
              break label2455;
            }
            paramViewGroup = locala.rDD;
            j = rDf;
            o.a(paramViewGroup, 2131690142, paramView, paramg, true, j, j);
            locala.rDE.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2507;
            }
            locala.rDG.setText(localView.getContext().getString(2131758911, new Object[] { Integer.valueOf(i) }));
            locala.rDG.setVisibility(0);
            locala.rDF.setVisibility(0);
            break;
            locala.rDI.setVisibility(8);
            break label2303;
            label2455:
            locala.rDE.setVisibility(0);
            paramViewGroup = this.rvp;
            localObject1 = locala.rDD;
            localObject2 = paramView.dnv;
            j = rDf;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131689581, j, j);
          }
          label2507:
          locala.rDG.setVisibility(8);
          locala.rDF.setVisibility(8);
          break;
          label2530:
          locala.rDC.setVisibility(8);
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
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View rDA;
    View rDB;
    View rDC;
    ImageView rDD;
    ImageView rDE;
    View rDF;
    TextView rDG;
    TextView rDH;
    TextView rDI;
    ImageView rDJ;
    TextView rDK;
    TextView rDL;
    TextView rDM;
    TextView rDN;
    View rDy;
    View rDz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.j
 * JD-Core Version:    0.7.0.1
 */