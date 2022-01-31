package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

public final class h
  extends a
{
  private static int kiw;
  
  public h(l paraml)
  {
    super(paraml);
    kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavImageSize);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramViewGroup = paramViewGroup.getContext();
    h.a locala;
    View localView;
    if (paramView == null)
    {
      locala = new h.a();
      localView = a(View.inflate(paramViewGroup, n.f.fav_listitem_wenote, null), locala, paramg);
      locala.kiC = localView.findViewById(n.e.record_layout);
      locala.kiD = localView.findViewById(n.e.common_card_layout);
      locala.kiE = localView.findViewById(n.e.voice_layout);
      locala.kiF = localView.findViewById(n.e.chatvoice_layout);
      locala.kiG = localView.findViewById(n.e.fav_record_icon_ll);
      locala.kiH = ((ImageView)localView.findViewById(n.e.fav_record_card_icon));
      locala.kiJ = localView.findViewById(n.e.fav_icon_info_bg);
      locala.kiI = ((ImageView)localView.findViewById(n.e.fav_icon_video_mask));
      locala.kiK = ((TextView)localView.findViewById(n.e.fav_icon_info_tv));
      locala.kiL = ((TextView)localView.findViewById(n.e.fav_record_title));
      locala.kiM = ((TextView)localView.findViewById(n.e.fav_record_desc));
      locala.kiN = ((ImageView)localView.findViewById(n.e.fav_common_card_icon));
      locala.kiO = ((TextView)localView.findViewById(n.e.fav_card_title));
      locala.kiP = ((TextView)localView.findViewById(n.e.fav_card_desc));
      locala.kiQ = ((TextView)localView.findViewById(n.e.fav_voice_title));
      locala.kiR = ((TextView)localView.findViewById(n.e.fav_chatvoice_title));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.sXc;
      if (((List)localObject2).size() >= 2) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.Fav.FavNoteListItem", "no other item");
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
      paramViewGroup = (xv)((List)localObject2).get(k);
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
        if (paramViewGroup.sVI == null)
        {
          paramViewGroup = new ku();
          paramViewGroup.bTL.type = 10;
          paramViewGroup.bTL.field_localId = paramg.field_localId;
          paramViewGroup.bTL.path = com.tencent.mm.vfs.j.n(paramView.cLr());
          com.tencent.mm.sdk.b.a.udP.m(paramViewGroup);
        }
        continue;
        int i1;
        if ((paramViewGroup.aYU != 2) && (paramViewGroup.aYU != 4))
        {
          i1 = j;
          n = m;
          j = i;
          if (paramViewGroup.aYU != 15) {}
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
        switch (paramViewGroup.aYU)
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
        } while (bk.aM(paramViewGroup.desc, "").trim().length() > 0);
        i3 -= 1;
        i = j;
        j = i1;
        m = n;
      }
    }
    if ((i4 != 0) && (i3 == 2)) {
      k = 1;
    }
    while ((k != 0) && (i2 > 0))
    {
      localObject2 = (xv)((List)localObject2).get(i2);
      if (((xv)localObject2).aYU == 3)
      {
        locala.kiC.setVisibility(8);
        locala.kiD.setVisibility(8);
        locala.kiE.setVisibility(0);
        locala.kiF.setVisibility(8);
        locala.kiQ.setText(k.B(this.kbg.context, (int)com.tencent.mm.plugin.fav.a.b.eu(((xv)localObject2).duration)));
        return localView;
        k = 0;
      }
      else
      {
        if (((xv)localObject2).aYU == 20)
        {
          locala.kiC.setVisibility(8);
          locala.kiD.setVisibility(8);
          locala.kiE.setVisibility(8);
          locala.kiF.setVisibility(0);
          locala.kiR.setText(k.B(this.kbg.context, (int)com.tencent.mm.plugin.fav.a.b.eu(((xv)localObject2).duration)));
          return localView;
        }
        paramView = null;
        if (((xv)localObject2).aYU == 6)
        {
          i = n.h.app_attach_file_icon_location;
          paramg = ((xv)localObject2).sVA.sWf;
          paramViewGroup = ((xv)localObject2).sVA.fGK;
          if (bk.bl(paramViewGroup)) {
            if (k.CZ(paramg.bVA))
            {
              paramView = paramg.bVA;
              paramg = paramg.label;
              paramViewGroup = paramView;
              paramView = paramg;
            }
          }
        }
        for (;;)
        {
          locala.kiE.setVisibility(8);
          locala.kiF.setVisibility(8);
          locala.kiC.setVisibility(8);
          locala.kiD.setVisibility(0);
          locala.kiN.setImageResource(i);
          locala.kiO.setText(paramViewGroup);
          if (bk.bl(paramView)) {
            break label1175;
          }
          locala.kiP.setText(paramView);
          locala.kiP.setVisibility(0);
          return localView;
          paramViewGroup = paramg.label;
          continue;
          paramView = paramViewGroup;
          if (!k.CZ(paramg.bVA)) {
            break;
          }
          paramView = paramg.bVA;
          continue;
          j = c.CT(((xv)localObject2).sUV);
          paramg = ((xv)localObject2).title;
          localObject1 = ((xv)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (bk.bl((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.ar((float)((xv)localObject2).sVb);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1175:
        locala.kiP.setVisibility(8);
        return localView;
      }
    }
    locala.kiC.setVisibility(0);
    locala.kiD.setVisibility(8);
    locala.kiE.setVisibility(8);
    locala.kiF.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    if (n < ((List)localObject2).size())
    {
      localObject1 = (xv)((List)localObject2).get(n);
      if (((xv)localObject1).aYU == 1)
      {
        localObject1 = ((xv)localObject1).desc;
        if (bk.bl((String)localObject1)) {
          break label2455;
        }
        paramView = (View)localObject1;
        if (((String)localObject1).length() > 1000) {
          paramView = ((String)localObject1).substring(0, 1000);
        }
        paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
        label1359:
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
                break label2449;
              }
              if (!bk.bl(paramView[k].trim()))
              {
                localArrayList2.add(paramView[k]);
                label1416:
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
            if ((localArrayList2.size() <= 0) || (!bk.bl(paramViewGroup))) {
              break label2444;
            }
            paramView = (String)localArrayList2.get(0);
            k = 1;
            label1533:
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
        switch (((xv)localObject1).aYU)
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
          label1668:
          localObject1 = paramViewGroup;
          if (!bk.bl(paramView)) {
            localArrayList1.add(paramView);
          }
          break;
        }
      }
    }
    for (Object localObject1 = paramViewGroup;; localObject1 = paramView)
    {
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
      break;
      paramView = k.C(paramView, n.i.favorite_sub_title_voice) + " " + k.B(paramView, (int)com.tencent.mm.plugin.fav.a.b.eu(((xv)localObject1).duration));
      break label1668;
      paramView = k.C(paramView, n.i.favorite_sub_title_url) + " " + ((xv)localObject1).title;
      break label1668;
      paramView = k.C(paramView, n.i.favorite_sub_title_music) + " " + ((xv)localObject1).title;
      break label1668;
      localObject1 = ((xv)localObject1).sVA.sWf;
      if (k.CZ(((yc)localObject1).bVA))
      {
        paramView = k.C(paramView, n.i.favorite_sub_title_location) + " " + ((yc)localObject1).bVA;
        break label1668;
      }
      paramView = k.C(paramView, n.i.favorite_sub_title_location) + " " + ((yc)localObject1).label;
      break label1668;
      paramView = k.C(paramView, n.i.favorite_sub_title_file) + " " + ((xv)localObject1).title;
      break label1668;
      paramView = k.C(paramView, n.i.favorite_mall_product) + " " + ((xv)localObject1).sVA.sWj.title;
      break label1668;
      paramView = k.C(paramView, n.i.favorite_friend_card);
      break label1668;
      if (!bk.bl(paramViewGroup))
      {
        locala.kiL.setText(com.tencent.mm.pluginsdk.ui.d.j.a(locala.kiL.getContext(), paramViewGroup, locala.kiL.getTextSize()));
        locala.kiL.setVisibility(0);
        if (localArrayList1.size() > 0) {
          locala.kiL.setMaxLines(1);
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
        locala.kiL.setMaxLines(3);
        continue;
        locala.kiL.setVisibility(8);
      }
      if (paramView.length() != 0)
      {
        paramView = paramView.substring(0, paramView.length() - 1);
        locala.kiM.setText(com.tencent.mm.pluginsdk.ui.d.j.a(locala.kiM.getContext(), paramView, locala.kiM.getTextSize()));
        locala.kiM.setVisibility(0);
        if (j == 0) {
          break label2431;
        }
        locala.kiG.setVisibility(0);
        paramView = (xv)((List)localObject2).get(m);
        if (((xv)((List)localObject2).get(m)).aYU != 2) {
          break label2369;
        }
        l.a(locala.kiH, n.h.fav_list_img_default, paramView, paramg, true, kiw, kiw);
        locala.kiI.setVisibility(8);
      }
      for (;;)
      {
        if (i <= 1) {
          break label2408;
        }
        locala.kiK.setText(localView.getContext().getString(n.i.favorite_img_count, new Object[] { Integer.valueOf(i) }));
        locala.kiK.setVisibility(0);
        locala.kiJ.setVisibility(0);
        return localView;
        locala.kiM.setVisibility(8);
        break;
        label2369:
        locala.kiI.setVisibility(0);
        this.kbg.a(locala.kiH, paramView, paramg, paramView.bIm, n.h.app_attach_file_icon_video, kiw, kiw);
      }
      label2408:
      locala.kiK.setVisibility(8);
      locala.kiJ.setVisibility(8);
      return localView;
      label2431:
      locala.kiG.setVisibility(8);
      return localView;
      label2444:
      paramView = paramViewGroup;
      break label1533;
      label2449:
      k = 0;
      break label1416;
      label2455:
      paramView = null;
      break label1359;
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    h.a locala = (h.a)paramView.getTag();
    paramView = paramView.getContext();
    ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.fav.a.y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.h
 * JD-Core Version:    0.7.0.1
 */