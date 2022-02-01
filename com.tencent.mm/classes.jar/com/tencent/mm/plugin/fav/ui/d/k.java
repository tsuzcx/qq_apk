package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends b
{
  private static int tlc;
  
  public k(com.tencent.mm.plugin.fav.ui.o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    tlc = a.aG(paramo.context, 2131165370);
    AppMethodBeat.o(107469);
  }
  
  private static String a(ams paramams)
  {
    AppMethodBeat.i(107471);
    if (paramams == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramams = paramams.label;
    AppMethodBeat.o(107471);
    return paramams;
  }
  
  private static String b(ams paramams)
  {
    AppMethodBeat.i(107472);
    if (paramams == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramams = paramams.dWi;
    AppMethodBeat.o(107472);
    return paramams;
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
      localView = a(View.inflate(paramViewGroup, 2131494137, null), locala, paramg);
      locala.tlw = localView.findViewById(2131306718);
      locala.tlx = localView.findViewById(2131298976);
      locala.tly = localView.findViewById(2131309950);
      locala.tlz = localView.findViewById(2131298595);
      locala.tlA = localView.findViewById(2131300496);
      locala.tlB = ((ImageView)localView.findViewById(2131300494));
      locala.tlD = localView.findViewById(2131300471);
      locala.tlC = ((ImageView)localView.findViewById(2131300475));
      locala.tlE = ((TextView)localView.findViewById(2131300472));
      locala.tlF = ((TextView)localView.findViewById(2131300500));
      locala.tlG = ((TextView)localView.findViewById(2131300495));
      locala.tlH = ((ImageView)localView.findViewById(2131300447));
      locala.tlI = ((TextView)localView.findViewById(2131300439));
      locala.tlJ = ((TextView)localView.findViewById(2131300438));
      locala.tlK = ((TextView)localView.findViewById(2131300536));
      locala.tlL = ((TextView)localView.findViewById(2131300441));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.ppH;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      Log.e("MicroMsg.Fav.FavNoteListItem", "no other item");
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
      paramViewGroup = (aml)((List)localObject2).get(k);
      if (k == 0)
      {
        paramView = new com.tencent.mm.vfs.o(com.tencent.mm.plugin.fav.a.b.d(paramViewGroup));
        if (!paramView.exists()) {
          com.tencent.mm.plugin.fav.ui.o.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.Lwp == null)
        {
          paramViewGroup = new oc();
          paramViewGroup.dUe.type = 10;
          paramViewGroup.dUe.field_localId = paramg.field_localId;
          paramViewGroup.dUe.path = aa.z(paramView.her());
          EventCenter.instance.publish(paramViewGroup);
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
        } while (Util.nullAs(paramViewGroup.desc, "").trim().length() > 0);
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
        break label1220;
      }
      localObject2 = (aml)((List)localObject2).get(i2);
      if (((aml)localObject2).dataType != 3) {
        break label888;
      }
      locala.tlw.setVisibility(8);
      locala.tlx.setVisibility(8);
      locala.tly.setVisibility(0);
      locala.tlz.setVisibility(8);
      locala.tlK.setText(n.W(this.tdg.context, (int)com.tencent.mm.plugin.fav.a.b.DO(((aml)localObject2).duration)));
    }
    label888:
    Object localObject1;
    for (;;)
    {
      AppMethodBeat.o(107470);
      return localView;
      k = 0;
      break;
      if (((aml)localObject2).dataType == 20)
      {
        locala.tlw.setVisibility(8);
        locala.tlx.setVisibility(8);
        locala.tly.setVisibility(8);
        locala.tlz.setVisibility(0);
        locala.tlL.setText(n.W(this.tdg.context, (int)com.tencent.mm.plugin.fav.a.b.DO(((aml)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((aml)localObject2).dataType == 6)
        {
          i = 2131689565;
          paramg = ((aml)localObject2).Lwh.LwQ;
          paramViewGroup = ((aml)localObject2).Lwh.remark;
          if (Util.isNullOrNil(paramViewGroup)) {
            if (n.asr(b(paramg)))
            {
              paramView = b(paramg);
              label1025:
              paramg = a(paramg);
              paramViewGroup = paramView;
              paramView = paramg;
            }
          }
        }
        for (;;)
        {
          locala.tly.setVisibility(8);
          locala.tlz.setVisibility(8);
          locala.tlw.setVisibility(8);
          locala.tlx.setVisibility(0);
          locala.tlH.setImageResource(i);
          locala.tlI.setText(paramViewGroup);
          if (Util.isNullOrNil(paramView)) {
            break label1207;
          }
          locala.tlJ.setText(paramView);
          locala.tlJ.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.asr(b(paramg))) {
            break label1025;
          }
          paramView = b(paramg);
          continue;
          j = e.asl(((aml)localObject2).LvC);
          paramg = ((aml)localObject2).title;
          localObject1 = ((aml)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (Util.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.getLengthStr((float)((aml)localObject2).LvI);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1207:
        locala.tlJ.setVisibility(8);
      }
    }
    label1220:
    locala.tlw.setVisibility(0);
    locala.tlx.setVisibility(8);
    locala.tly.setVisibility(8);
    locala.tlz.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (aml)((List)localObject2).get(n);
        if (((aml)localObject1).dataType == 1)
        {
          localObject1 = ((aml)localObject1).desc;
          if (Util.isNullOrNil((String)localObject1)) {
            break label2579;
          }
          paramView = (View)localObject1;
          if (((String)localObject1).length() > 1000) {
            paramView = ((String)localObject1).substring(0, 1000);
          }
          paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
          label1391:
          localObject1 = paramViewGroup;
          if (paramView == null) {
            break label2596;
          }
          localObject1 = paramViewGroup;
          if (paramView.length <= 0) {
            break label2596;
          }
          ArrayList localArrayList2 = new ArrayList();
          k = 0;
          for (;;)
          {
            if (k < paramView.length)
            {
              if (!Util.isNullOrNil(paramView[k].trim()))
              {
                localArrayList2.add(paramView[k]);
                label1448:
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
              if ((localArrayList2.size() > 0) && (Util.isNullOrNil(paramViewGroup)))
              {
                paramView = (String)localArrayList2.get(0);
                k = 1;
                label1564:
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
          switch (((aml)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (Util.isNullOrNil(paramView)) {
              break label2596;
            }
            localArrayList1.add(paramView);
            localObject1 = paramViewGroup;
          }
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.Fav.FavNoteListItem", "getDataItemDesc exception:".concat(String.valueOf(paramView)));
          localObject1 = paramViewGroup;
        }
        paramView = n.X(paramView, 2131759342) + " " + n.W(paramView, (int)com.tencent.mm.plugin.fav.a.b.DO(((aml)localObject1).duration));
        continue;
        paramView = n.X(paramView, 2131759340) + " " + ((aml)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.cUq())
        {
          paramView = n.X(paramView, 2131759340) + " " + ((aml)localObject1).title;
          continue;
          paramView = n.X(paramView, 2131759337) + " " + ((aml)localObject1).title;
          continue;
          localObject1 = ((aml)localObject1).Lwh.LwQ;
          if (localObject1 == null)
          {
            paramView = n.X(paramView, 2131759336);
            continue;
          }
          if (n.asr(((ams)localObject1).dWi))
          {
            paramView = n.X(paramView, 2131759336) + " " + ((ams)localObject1).dWi;
            continue;
          }
          paramView = n.X(paramView, 2131759336) + " " + ((ams)localObject1).label;
          continue;
          paramView = n.X(paramView, 2131759331) + " " + ((aml)localObject1).title;
          continue;
          paramView = n.X(paramView, 2131759250) + " " + ((aml)localObject1).Lwh.LwU.title;
          continue;
          paramView = n.X(paramView, 2131759231);
          continue;
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.tlF.setText(l.b(locala.tlF.getContext(), paramViewGroup, locala.tlF.getTextSize()));
            locala.tlF.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.tlF.setMaxLines(1);
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
            locala.tlF.setMaxLines(3);
            continue;
            locala.tlF.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.tlG.setText(l.b(locala.tlG.getContext(), paramView, locala.tlG.getTextSize()));
            locala.tlG.setVisibility(0);
            label2327:
            if (j == 0) {
              break label2555;
            }
            locala.tlA.setVisibility(0);
            paramView = (aml)((List)localObject2).get(m);
            if (((aml)((List)localObject2).get(m)).dataType != 2) {
              break label2479;
            }
            paramViewGroup = locala.tlB;
            j = tlc;
            com.tencent.mm.plugin.fav.ui.o.a(paramViewGroup, 2131690179, paramView, paramg, true, j, j);
            locala.tlC.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2532;
            }
            locala.tlE.setText(localView.getContext().getString(2131759235, new Object[] { Integer.valueOf(i) }));
            locala.tlE.setVisibility(0);
            locala.tlD.setVisibility(0);
            break;
            locala.tlG.setVisibility(8);
            break label2327;
            label2479:
            locala.tlC.setVisibility(0);
            paramViewGroup = this.tdg;
            localObject1 = locala.tlB;
            localObject2 = paramView.dFN;
            j = tlc;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131689584, j, j);
          }
          label2532:
          locala.tlE.setVisibility(8);
          locala.tlD.setVisibility(8);
          break;
          label2555:
          locala.tlA.setVisibility(8);
          break;
          paramView = paramViewGroup;
          break label1564;
          k = 0;
          break label1448;
          label2579:
          paramView = null;
          break label1391;
          localObject1 = paramView;
          break label2596;
        }
        paramView = "";
      }
      label2596:
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.af(y.class)).a(paramView, locala.tbr, paramand);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View tlA;
    ImageView tlB;
    ImageView tlC;
    View tlD;
    TextView tlE;
    TextView tlF;
    TextView tlG;
    ImageView tlH;
    TextView tlI;
    TextView tlJ;
    TextView tlK;
    TextView tlL;
    View tlw;
    View tlx;
    View tly;
    View tlz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.k
 * JD-Core Version:    0.7.0.1
 */