package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.List;

public final class j
  extends b
{
  private static int qTc;
  
  public j(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    qTc = com.tencent.mm.cc.a.au(paramo.context, 2131165359);
    AppMethodBeat.o(107469);
  }
  
  private static String a(ahe paramahe)
  {
    AppMethodBeat.i(107471);
    if (paramahe == null)
    {
      ac.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramahe = paramahe.label;
    AppMethodBeat.o(107471);
    return paramahe;
  }
  
  private static String b(ahe paramahe)
  {
    AppMethodBeat.i(107472);
    if (paramahe == null)
    {
      ac.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramahe = paramahe.dry;
    AppMethodBeat.o(107472);
    return paramahe;
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
      locala.qTv = localView.findViewById(2131303890);
      locala.qTw = localView.findViewById(2131298545);
      locala.qTx = localView.findViewById(2131306490);
      locala.qTy = localView.findViewById(2131298213);
      locala.qTz = localView.findViewById(2131299820);
      locala.qTA = ((ImageView)localView.findViewById(2131299818));
      locala.qTC = localView.findViewById(2131299796);
      locala.qTB = ((ImageView)localView.findViewById(2131299800));
      locala.qTD = ((TextView)localView.findViewById(2131299797));
      locala.qTE = ((TextView)localView.findViewById(2131299824));
      locala.qTF = ((TextView)localView.findViewById(2131299819));
      locala.qTG = ((ImageView)localView.findViewById(2131299776));
      locala.qTH = ((TextView)localView.findViewById(2131299768));
      locala.qTI = ((TextView)localView.findViewById(2131299767));
      locala.qTJ = ((TextView)localView.findViewById(2131299856));
      locala.qTK = ((TextView)localView.findViewById(2131299770));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.nxC;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      ac.e("MicroMsg.Fav.FavNoteListItem", "no other item");
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
      paramViewGroup = (agx)((List)localObject2).get(k);
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
        if (paramViewGroup.EAh == null)
        {
          paramViewGroup = new nb();
          paramViewGroup.dpw.type = 10;
          paramViewGroup.dpw.field_localId = paramg.field_localId;
          paramViewGroup.dpw.path = q.B(paramView.fxV());
          com.tencent.mm.sdk.b.a.GpY.l(paramViewGroup);
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
        } while (bs.bG(paramViewGroup.desc, "").trim().length() > 0);
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
      localObject2 = (agx)((List)localObject2).get(i2);
      if (((agx)localObject2).dataType != 3) {
        break label860;
      }
      locala.qTv.setVisibility(8);
      locala.qTw.setVisibility(8);
      locala.qTx.setVisibility(0);
      locala.qTy.setVisibility(8);
      locala.qTJ.setText(n.R(this.qLn.context, (int)com.tencent.mm.plugin.fav.a.b.tx(((agx)localObject2).duration)));
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
      if (((agx)localObject2).dataType == 20)
      {
        locala.qTv.setVisibility(8);
        locala.qTw.setVisibility(8);
        locala.qTx.setVisibility(8);
        locala.qTy.setVisibility(0);
        locala.qTK.setText(n.R(this.qLn.context, (int)com.tencent.mm.plugin.fav.a.b.tx(((agx)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((agx)localObject2).dataType == 6)
        {
          i = 2131689562;
          paramg = ((agx)localObject2).EzZ.EAI;
          paramViewGroup = ((agx)localObject2).EzZ.iAC;
          if (bs.isNullOrNil(paramViewGroup)) {
            if (n.acX(b(paramg)))
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
          locala.qTx.setVisibility(8);
          locala.qTy.setVisibility(8);
          locala.qTv.setVisibility(8);
          locala.qTw.setVisibility(0);
          locala.qTG.setImageResource(i);
          locala.qTH.setText(paramViewGroup);
          if (bs.isNullOrNil(paramView)) {
            break label1179;
          }
          locala.qTI.setText(paramView);
          locala.qTI.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.acX(b(paramg))) {
            break label997;
          }
          paramView = b(paramg);
          continue;
          j = com.tencent.mm.plugin.fav.ui.e.acR(((agx)localObject2).Ezu);
          paramg = ((agx)localObject2).title;
          localObject1 = ((agx)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bs.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.aX((float)((agx)localObject2).EzA);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1179:
        locala.qTI.setVisibility(8);
      }
    }
    label1192:
    locala.qTv.setVisibility(0);
    locala.qTw.setVisibility(8);
    locala.qTx.setVisibility(8);
    locala.qTy.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (agx)((List)localObject2).get(n);
        if (((agx)localObject1).dataType == 1)
        {
          localObject1 = ((agx)localObject1).desc;
          if (bs.isNullOrNil((String)localObject1)) {
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
              if (!bs.isNullOrNil(paramView[k].trim()))
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
              if ((localArrayList2.size() > 0) && (bs.isNullOrNil(paramViewGroup)))
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
          switch (((agx)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (bs.isNullOrNil(paramView)) {
              break label2571;
            }
            localArrayList1.add(paramView);
            localObject1 = paramViewGroup;
          }
        }
        catch (Exception paramView)
        {
          ac.e("MicroMsg.Fav.FavNoteListItem", "getDataItemDesc exception:".concat(String.valueOf(paramView)));
          localObject1 = paramViewGroup;
        }
        paramView = n.S(paramView, 2131759016) + " " + n.R(paramView, (int)com.tencent.mm.plugin.fav.a.b.tx(((agx)localObject1).duration));
        continue;
        paramView = n.S(paramView, 2131759014) + " " + ((agx)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.cph())
        {
          paramView = n.S(paramView, 2131759014) + " " + ((agx)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131759011) + " " + ((agx)localObject1).title;
          continue;
          localObject1 = ((agx)localObject1).EzZ.EAI;
          if (localObject1 == null)
          {
            paramView = n.S(paramView, 2131759010);
            continue;
          }
          if (n.acX(((ahe)localObject1).dry))
          {
            paramView = n.S(paramView, 2131759010) + " " + ((ahe)localObject1).dry;
            continue;
          }
          paramView = n.S(paramView, 2131759010) + " " + ((ahe)localObject1).label;
          continue;
          paramView = n.S(paramView, 2131759006) + " " + ((agx)localObject1).title;
          continue;
          paramView = n.S(paramView, 2131758926) + " " + ((agx)localObject1).EzZ.EAM.title;
          continue;
          paramView = n.S(paramView, 2131758907);
          continue;
          if (!bs.isNullOrNil(paramViewGroup))
          {
            locala.qTE.setText(k.b(locala.qTE.getContext(), paramViewGroup, locala.qTE.getTextSize()));
            locala.qTE.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.qTE.setMaxLines(1);
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
            locala.qTE.setMaxLines(3);
            continue;
            locala.qTE.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.qTF.setText(k.b(locala.qTF.getContext(), paramView, locala.qTF.getTextSize()));
            locala.qTF.setVisibility(0);
            label2303:
            if (j == 0) {
              break label2530;
            }
            locala.qTz.setVisibility(0);
            paramView = (agx)((List)localObject2).get(m);
            if (((agx)((List)localObject2).get(m)).dataType != 2) {
              break label2455;
            }
            paramViewGroup = locala.qTA;
            j = qTc;
            o.a(paramViewGroup, 2131690142, paramView, paramg, true, j, j);
            locala.qTB.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2507;
            }
            locala.qTD.setText(localView.getContext().getString(2131758911, new Object[] { Integer.valueOf(i) }));
            locala.qTD.setVisibility(0);
            locala.qTC.setVisibility(0);
            break;
            locala.qTF.setVisibility(8);
            break label2303;
            label2455:
            locala.qTB.setVisibility(0);
            paramViewGroup = this.qLn;
            localObject1 = locala.qTA;
            localObject2 = paramView.dbZ;
            j = qTc;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131689581, j, j);
          }
          label2507:
          locala.qTD.setVisibility(8);
          locala.qTC.setVisibility(8);
          break;
          label2530:
          locala.qTz.setVisibility(8);
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
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.qJy, paramahp);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    ImageView qTA;
    ImageView qTB;
    View qTC;
    TextView qTD;
    TextView qTE;
    TextView qTF;
    ImageView qTG;
    TextView qTH;
    TextView qTI;
    TextView qTJ;
    TextView qTK;
    View qTv;
    View qTw;
    View qTx;
    View qTy;
    View qTz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.j
 * JD-Core Version:    0.7.0.1
 */