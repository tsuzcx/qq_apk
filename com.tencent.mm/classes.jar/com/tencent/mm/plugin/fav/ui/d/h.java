package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
{
  private static int mDa;
  
  public h(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74633);
    mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427653);
    AppMethodBeat.o(74633);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74634);
    paramViewGroup = paramViewGroup.getContext();
    h.a locala;
    View localView;
    if (paramView == null)
    {
      locala = new h.a();
      localView = a(View.inflate(paramViewGroup, 2130969550, null), locala, paramg);
      locala.mDh = localView.findViewById(2131824043);
      locala.mDi = localView.findViewById(2131824054);
      locala.mDj = localView.findViewById(2131824050);
      locala.mDk = localView.findViewById(2131824052);
      locala.mDl = localView.findViewById(2131824044);
      locala.mDm = ((ImageView)localView.findViewById(2131824045));
      locala.mDo = localView.findViewById(2131824046);
      locala.mDn = ((ImageView)localView.findViewById(2131824035));
      locala.mDp = ((TextView)localView.findViewById(2131824047));
      locala.mDq = ((TextView)localView.findViewById(2131824048));
      locala.mDr = ((TextView)localView.findViewById(2131824049));
      locala.mDs = ((ImageView)localView.findViewById(2131824055));
      locala.mDt = ((TextView)localView.findViewById(2131824056));
      locala.mDu = ((TextView)localView.findViewById(2131824057));
      locala.mDv = ((TextView)localView.findViewById(2131824051));
      locala.mDw = ((TextView)localView.findViewById(2131824053));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.wVc;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      ab.e("MicroMsg.Fav.FavNoteListItem", "no other item");
      AppMethodBeat.o(74634);
      return localView;
      locala = (h.a)paramView.getTag();
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
      paramViewGroup = (aca)((List)localObject2).get(k);
      if (k == 0)
      {
        paramView = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(paramViewGroup));
        if (!paramView.exists()) {
          l.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.wTE == null)
        {
          paramViewGroup = new li();
          paramViewGroup.cBr.type = 10;
          paramViewGroup.cBr.field_localId = paramg.field_localId;
          paramViewGroup.cBr.path = com.tencent.mm.vfs.j.p(paramView.dQJ());
          com.tencent.mm.sdk.b.a.ymk.l(paramViewGroup);
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
        } while (bo.bf(paramViewGroup.desc, "").trim().length() > 0);
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
        break label1184;
      }
      localObject2 = (aca)((List)localObject2).get(i2);
      if (((aca)localObject2).dataType != 3) {
        break label852;
      }
      locala.mDh.setVisibility(8);
      locala.mDi.setVisibility(8);
      locala.mDj.setVisibility(0);
      locala.mDk.setVisibility(8);
      locala.mDv.setText(k.L(this.mvC.context, (int)com.tencent.mm.plugin.fav.a.b.jR(((aca)localObject2).duration)));
    }
    label1171:
    for (;;)
    {
      AppMethodBeat.o(74634);
      return localView;
      k = 0;
      break;
      label852:
      if (((aca)localObject2).dataType == 20)
      {
        locala.mDh.setVisibility(8);
        locala.mDi.setVisibility(8);
        locala.mDj.setVisibility(8);
        locala.mDk.setVisibility(0);
        locala.mDw.setText(k.L(this.mvC.context, (int)com.tencent.mm.plugin.fav.a.b.jR(((aca)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((aca)localObject2).dataType == 6)
        {
          i = 2131230807;
          paramg = ((aca)localObject2).wTw.wUd;
          paramViewGroup = ((aca)localObject2).wTw.hKa;
          if (bo.isNullOrNil(paramViewGroup)) {
            if (k.Ob(paramg.cDl))
            {
              paramView = paramg.cDl;
              label989:
              paramg = paramg.label;
              paramViewGroup = paramView;
              paramView = paramg;
            }
          }
        }
        for (;;)
        {
          locala.mDj.setVisibility(8);
          locala.mDk.setVisibility(8);
          locala.mDh.setVisibility(8);
          locala.mDi.setVisibility(0);
          locala.mDs.setImageResource(i);
          locala.mDt.setText(paramViewGroup);
          if (bo.isNullOrNil(paramView)) {
            break label1171;
          }
          locala.mDu.setText(paramView);
          locala.mDu.setVisibility(0);
          break;
          paramViewGroup = paramg.label;
          continue;
          paramView = paramViewGroup;
          if (!k.Ob(paramg.cDl)) {
            break label989;
          }
          paramView = paramg.cDl;
          continue;
          j = c.NV(((aca)localObject2).wSR);
          paramg = ((aca)localObject2).title;
          localObject1 = ((aca)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bo.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.aJ((float)((aca)localObject2).wSX);
            i = j;
            paramViewGroup = paramg;
          }
        }
        locala.mDu.setVisibility(8);
      }
    }
    label1184:
    locala.mDh.setVisibility(0);
    locala.mDi.setVisibility(8);
    locala.mDj.setVisibility(8);
    locala.mDk.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    label1237:
    if (n < ((List)localObject2).size())
    {
      localObject1 = (aca)((List)localObject2).get(n);
      if (((aca)localObject1).dataType == 1)
      {
        localObject1 = ((aca)localObject1).desc;
        if (bo.isNullOrNil((String)localObject1)) {
          break label2465;
        }
        paramView = (View)localObject1;
        if (((String)localObject1).length() > 1000) {
          paramView = ((String)localObject1).substring(0, 1000);
        }
        paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
        localObject1 = paramViewGroup;
        if (paramView != null)
        {
          localObject1 = paramViewGroup;
          if (paramView.length > 0)
          {
            ArrayList localArrayList2 = new ArrayList();
            k = 0;
            for (;;)
            {
              if (k >= paramView.length) {
                break label2459;
              }
              if (!bo.isNullOrNil(paramView[k].trim()))
              {
                localArrayList2.add(paramView[k]);
                k += 1;
                localObject1 = "";
                while (k < paramView.length)
                {
                  localObject1 = (String)localObject1 + paramView[k] + " ";
                  k += 1;
                }
              }
              k += 1;
            }
            paramView = ((String)localObject1).trim();
            if (paramView.length() > 0) {
              localArrayList2.add(paramView);
            }
            k = 0;
            if ((localArrayList2.size() <= 0) || (!bo.isNullOrNil(paramViewGroup))) {
              break label2454;
            }
            paramView = (String)localArrayList2.get(0);
            k = 1;
            label1528:
            while (k < localArrayList2.size())
            {
              localArrayList1.add(localArrayList2.get(k));
              k += 1;
            }
          }
        }
      }
      else
      {
        paramView = localView.getContext();
        switch (((aca)localObject1).dataType)
        {
        case 4: 
        case 9: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 17: 
        case 18: 
        case 19: 
        default: 
          paramView = "";
          label1663:
          localObject1 = paramViewGroup;
          if (!bo.isNullOrNil(paramView)) {
            localArrayList1.add(paramView);
          }
          break;
        }
      }
    }
    label1355:
    for (Object localObject1 = paramViewGroup;; localObject1 = paramView)
    {
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
      break label1237;
      paramView = k.M(paramView, 2131299840) + " " + k.L(paramView, (int)com.tencent.mm.plugin.fav.a.b.jR(((aca)localObject1).duration));
      break label1663;
      paramView = k.M(paramView, 2131299838) + " " + ((aca)localObject1).title;
      break label1663;
      paramView = k.M(paramView, 2131299835) + " " + ((aca)localObject1).title;
      break label1663;
      localObject1 = ((aca)localObject1).wTw.wUd;
      if (k.Ob(((ach)localObject1).cDl))
      {
        paramView = k.M(paramView, 2131299834) + " " + ((ach)localObject1).cDl;
        break label1663;
      }
      paramView = k.M(paramView, 2131299834) + " " + ((ach)localObject1).label;
      break label1663;
      paramView = k.M(paramView, 2131299831) + " " + ((aca)localObject1).title;
      break label1663;
      paramView = k.M(paramView, 2131299754) + " " + ((aca)localObject1).wTw.wUh.title;
      break label1663;
      paramView = k.M(paramView, 2131299735);
      break label1663;
      if (!bo.isNullOrNil(paramViewGroup))
      {
        locala.mDq.setText(com.tencent.mm.pluginsdk.ui.d.j.b(locala.mDq.getContext(), paramViewGroup, locala.mDq.getTextSize()));
        locala.mDq.setVisibility(0);
        if (localArrayList1.size() > 0) {
          locala.mDq.setMaxLines(1);
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
        locala.mDq.setMaxLines(3);
        continue;
        locala.mDq.setVisibility(8);
      }
      if (paramView.length() != 0)
      {
        paramView = paramView.substring(0, paramView.length() - 1);
        locala.mDr.setText(com.tencent.mm.pluginsdk.ui.d.j.b(locala.mDr.getContext(), paramView, locala.mDr.getTextSize()));
        locala.mDr.setVisibility(0);
        if (j == 0) {
          break label2441;
        }
        locala.mDl.setVisibility(0);
        paramView = (aca)((List)localObject2).get(m);
        if (((aca)((List)localObject2).get(m)).dataType != 2) {
          break label2366;
        }
        paramViewGroup = locala.mDm;
        j = mDa;
        l.a(paramViewGroup, paramView, paramg, true, j, j);
        locala.mDn.setVisibility(8);
      }
      for (;;)
      {
        if (i <= 1) {
          break label2418;
        }
        locala.mDp.setText(localView.getContext().getString(2131299739, new Object[] { Integer.valueOf(i) }));
        locala.mDp.setVisibility(0);
        locala.mDo.setVisibility(0);
        break;
        locala.mDr.setVisibility(8);
        break label2217;
        locala.mDn.setVisibility(0);
        paramViewGroup = this.mvC;
        localObject1 = locala.mDm;
        localObject2 = paramView.cpH;
        j = mDa;
        paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, 2131230826, j, j);
      }
      label2418:
      locala.mDp.setVisibility(8);
      locala.mDo.setVisibility(8);
      break;
      locala.mDl.setVisibility(8);
      break;
      paramView = paramViewGroup;
      break label1528;
      k = 0;
      break label1412;
      paramView = null;
      break label1355;
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74635);
    h.a locala = (h.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.h
 * JD-Core Version:    0.7.0.1
 */