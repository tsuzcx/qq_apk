package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends b
{
  private static int wRA;
  
  public k(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107469);
    wRA = a.aY(paramo.context, s.c.FavImageSize);
    AppMethodBeat.o(107469);
  }
  
  private static String a(ant paramant)
  {
    AppMethodBeat.i(107471);
    if (paramant == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramant = paramant.label;
    AppMethodBeat.o(107471);
    return paramant;
  }
  
  private static String b(ant paramant)
  {
    AppMethodBeat.i(107472);
    if (paramant == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramant = paramant.fPN;
    AppMethodBeat.o(107472);
    return paramant;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107470);
    paramViewGroup = paramViewGroup.getContext();
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a();
      localView = a(View.inflate(paramViewGroup, s.f.fav_listitem_wenote, null), locala, paramg);
      locala.wRU = localView.findViewById(s.e.record_layout);
      locala.wRV = localView.findViewById(s.e.common_card_layout);
      locala.wRW = localView.findViewById(s.e.voice_layout);
      locala.wRX = localView.findViewById(s.e.chatvoice_layout);
      locala.wRY = localView.findViewById(s.e.fav_record_icon_ll);
      locala.wRZ = ((ImageView)localView.findViewById(s.e.fav_record_card_icon));
      locala.wSb = localView.findViewById(s.e.fav_icon_info_bg);
      locala.wSa = ((ImageView)localView.findViewById(s.e.fav_icon_video_mask));
      locala.wSc = ((TextView)localView.findViewById(s.e.fav_icon_info_tv));
      locala.wSd = ((TextView)localView.findViewById(s.e.fav_record_title));
      locala.wSe = ((TextView)localView.findViewById(s.e.fav_record_desc));
      locala.wSf = ((ImageView)localView.findViewById(s.e.fav_common_card_icon));
      locala.wSg = ((TextView)localView.findViewById(s.e.fav_card_title));
      locala.wSh = ((TextView)localView.findViewById(s.e.fav_card_desc));
      locala.wSi = ((TextView)localView.findViewById(s.e.fav_voice_title));
      locala.wSj = ((TextView)localView.findViewById(s.e.fav_chatvoice_title));
      localView.setTag(locala);
    }
    Object localObject2;
    for (;;)
    {
      a(locala, paramg);
      localObject2 = paramg.field_favProto.syG;
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
      paramViewGroup = (anm)((List)localObject2).get(k);
      if (k == 0)
      {
        paramView = new q(com.tencent.mm.plugin.fav.a.b.d(paramViewGroup));
        if (!paramView.ifE()) {
          o.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.SyO == null)
        {
          paramViewGroup = new oz();
          paramViewGroup.fNG.type = 10;
          paramViewGroup.fNG.field_localId = paramg.field_localId;
          paramViewGroup.fNG.path = paramView.bOF();
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
        break label1236;
      }
      localObject2 = (anm)((List)localObject2).get(i2);
      if (((anm)localObject2).dataType != 3) {
        break label904;
      }
      locala.wRU.setVisibility(8);
      locala.wRV.setVisibility(8);
      locala.wRW.setVisibility(0);
      locala.wRX.setVisibility(8);
      locala.wSi.setText(n.ab(this.wJr.context, (int)com.tencent.mm.plugin.fav.a.b.Kc(((anm)localObject2).duration)));
    }
    label904:
    label1041:
    Object localObject1;
    for (;;)
    {
      AppMethodBeat.o(107470);
      return localView;
      k = 0;
      break;
      if (((anm)localObject2).dataType == 20)
      {
        locala.wRU.setVisibility(8);
        locala.wRV.setVisibility(8);
        locala.wRW.setVisibility(8);
        locala.wRX.setVisibility(0);
        locala.wSj.setText(n.ab(this.wJr.context, (int)com.tencent.mm.plugin.fav.a.b.Kc(((anm)localObject2).duration)));
      }
      else
      {
        paramView = null;
        if (((anm)localObject2).dataType == 6)
        {
          i = s.h.app_attach_file_icon_location;
          paramg = ((anm)localObject2).SyG.Szp;
          paramViewGroup = ((anm)localObject2).SyG.remark;
          if (Util.isNullOrNil(paramViewGroup)) {
            if (n.aAs(b(paramg)))
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
          locala.wRW.setVisibility(8);
          locala.wRX.setVisibility(8);
          locala.wRU.setVisibility(8);
          locala.wRV.setVisibility(0);
          locala.wSf.setImageResource(i);
          locala.wSg.setText(paramViewGroup);
          if (Util.isNullOrNil(paramView)) {
            break label1223;
          }
          locala.wSh.setText(paramView);
          locala.wSh.setVisibility(0);
          break;
          paramViewGroup = a(paramg);
          continue;
          paramView = paramViewGroup;
          if (!n.aAs(b(paramg))) {
            break label1041;
          }
          paramView = b(paramg);
          continue;
          j = e.aAm(((anm)localObject2).Syc);
          paramg = ((anm)localObject2).title;
          localObject1 = ((anm)localObject2).desc;
          i = j;
          paramView = (View)localObject1;
          paramViewGroup = paramg;
          if (Util.isNullOrNil((String)localObject1))
          {
            paramView = com.tencent.mm.plugin.fav.a.b.getLengthStr((float)((anm)localObject2).Syi);
            i = j;
            paramViewGroup = paramg;
          }
        }
        label1223:
        locala.wSh.setVisibility(8);
      }
    }
    label1236:
    locala.wRU.setVisibility(0);
    locala.wRV.setVisibility(8);
    locala.wRW.setVisibility(8);
    locala.wRX.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject2).size())
      {
        localObject1 = (anm)((List)localObject2).get(n);
        if (((anm)localObject1).dataType == 1)
        {
          localObject1 = ((anm)localObject1).desc;
          if (Util.isNullOrNil((String)localObject1)) {
            break label2603;
          }
          paramView = (View)localObject1;
          if (((String)localObject1).length() > 1000) {
            paramView = ((String)localObject1).substring(0, 1000);
          }
          paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
          label1407:
          localObject1 = paramViewGroup;
          if (paramView == null) {
            break label2620;
          }
          localObject1 = paramViewGroup;
          if (paramView.length <= 0) {
            break label2620;
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
                label1464:
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
                label1580:
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
          switch (((anm)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (Util.isNullOrNil(paramView)) {
              break label2620;
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
        paramView = n.ac(paramView, s.i.favorite_sub_title_voice) + " " + n.ab(paramView, (int)com.tencent.mm.plugin.fav.a.b.Kc(((anm)localObject1).duration));
        continue;
        paramView = n.ac(paramView, s.i.favorite_sub_title_url) + " " + ((anm)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.djw())
        {
          paramView = n.ac(paramView, s.i.favorite_sub_title_url) + " " + ((anm)localObject1).title;
          continue;
          paramView = n.ac(paramView, s.i.favorite_sub_title_music) + " " + ((anm)localObject1).title;
          continue;
          localObject1 = ((anm)localObject1).SyG.Szp;
          if (localObject1 == null)
          {
            paramView = n.ac(paramView, s.i.favorite_sub_title_location);
            continue;
          }
          if (n.aAs(((ant)localObject1).fPN))
          {
            paramView = n.ac(paramView, s.i.favorite_sub_title_location) + " " + ((ant)localObject1).fPN;
            continue;
          }
          paramView = n.ac(paramView, s.i.favorite_sub_title_location) + " " + ((ant)localObject1).label;
          continue;
          paramView = n.ac(paramView, s.i.favorite_sub_title_file) + " " + ((anm)localObject1).title;
          continue;
          paramView = n.ac(paramView, s.i.favorite_mall_product) + " " + ((anm)localObject1).SyG.Szt.title;
          continue;
          paramView = n.ac(paramView, s.i.favorite_friend_card);
          continue;
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.wSd.setText(l.b(locala.wSd.getContext(), paramViewGroup, locala.wSd.getTextSize()));
            locala.wSd.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.wSd.setMaxLines(1);
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
            locala.wSd.setMaxLines(3);
            continue;
            locala.wSd.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.wSe.setText(l.b(locala.wSe.getContext(), paramView, locala.wSe.getTextSize()));
            locala.wSe.setVisibility(0);
            label2343:
            if (j == 0) {
              break label2579;
            }
            locala.wRY.setVisibility(0);
            paramView = (anm)((List)localObject2).get(m);
            if (((anm)((List)localObject2).get(m)).dataType != 2) {
              break label2499;
            }
            paramViewGroup = locala.wRZ;
            j = s.h.fav_list_img_default;
            k = wRA;
            o.a(paramViewGroup, j, paramView, paramg, true, k, k);
            locala.wSa.setVisibility(8);
          }
          for (;;)
          {
            if (i <= 1) {
              break label2556;
            }
            locala.wSc.setText(localView.getContext().getString(s.i.favorite_img_count, new Object[] { Integer.valueOf(i) }));
            locala.wSc.setVisibility(0);
            locala.wSb.setVisibility(0);
            break;
            locala.wSe.setVisibility(8);
            break label2343;
            label2499:
            locala.wSa.setVisibility(0);
            paramViewGroup = this.wJr;
            localObject1 = locala.wRZ;
            localObject2 = paramView.fyu;
            j = s.h.app_attach_file_icon_video;
            k = wRA;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject2, j, k, k);
          }
          label2556:
          locala.wSc.setVisibility(8);
          locala.wSb.setVisibility(8);
          break;
          label2579:
          locala.wRY.setVisibility(8);
          break;
          paramView = paramViewGroup;
          break label1580;
          k = 0;
          break label1464;
          label2603:
          paramView = null;
          break label1407;
          localObject1 = paramView;
          break label2620;
        }
        paramView = "";
      }
      label2620:
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View wRU;
    View wRV;
    View wRW;
    View wRX;
    View wRY;
    ImageView wRZ;
    ImageView wSa;
    View wSb;
    TextView wSc;
    TextView wSd;
    TextView wSe;
    ImageView wSf;
    TextView wSg;
    TextView wSh;
    TextView wSi;
    TextView wSj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.k
 * JD-Core Version:    0.7.0.1
 */