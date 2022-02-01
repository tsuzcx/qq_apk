package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ql;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.n;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends b
{
  private static int Aod;
  
  public k(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107469);
    Aod = a.br(paramFavoriteImageServer.context, q.c.FavImageSize);
    AppMethodBeat.o(107469);
  }
  
  private static String a(arm paramarm)
  {
    AppMethodBeat.i(107471);
    if (paramarm == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getLabel but locItem is null");
      AppMethodBeat.o(107471);
      return "";
    }
    paramarm = paramarm.label;
    AppMethodBeat.o(107471);
    return paramarm;
  }
  
  private static String b(arm paramarm)
  {
    AppMethodBeat.i(107472);
    if (paramarm == null)
    {
      Log.i("MicroMsg.Fav.FavNoteListItem", "getPoiname but locItem is null");
      AppMethodBeat.o(107472);
      return "";
    }
    paramarm = paramarm.hVI;
    AppMethodBeat.o(107472);
    return paramarm;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107470);
    Object localObject2 = paramViewGroup.getContext();
    a locala;
    View localView;
    if (paramView == null)
    {
      locala = new a();
      localView = a(View.inflate((Context)localObject2, q.f.fav_listitem_wenote, null), locala, paramg);
      locala.Aox = localView.findViewById(q.e.record_layout);
      locala.Aoy = localView.findViewById(q.e.common_card_layout);
      locala.Aoz = localView.findViewById(q.e.voice_layout);
      locala.AoA = localView.findViewById(q.e.chatvoice_layout);
      locala.AoB = localView.findViewById(q.e.fav_record_icon_ll);
      locala.AoC = ((ImageView)localView.findViewById(q.e.fav_record_card_icon));
      locala.AoE = localView.findViewById(q.e.fav_icon_info_bg);
      locala.AoD = ((ImageView)localView.findViewById(q.e.fav_icon_video_mask));
      locala.AoF = ((TextView)localView.findViewById(q.e.fav_icon_info_tv));
      locala.AoG = ((TextView)localView.findViewById(q.e.fav_record_title));
      locala.AoH = ((TextView)localView.findViewById(q.e.fav_record_desc));
      locala.AoI = ((ImageView)localView.findViewById(q.e.fav_common_card_icon));
      locala.AoJ = ((TextView)localView.findViewById(q.e.fav_card_title));
      locala.AoK = ((TextView)localView.findViewById(q.e.fav_card_desc));
      locala.AoL = ((TextView)localView.findViewById(q.e.fav_voice_title));
      locala.AoM = ((TextView)localView.findViewById(q.e.fav_chatvoice_title));
      localView.setTag(locala);
    }
    Object localObject3;
    for (;;)
    {
      a(locala, paramg);
      localObject3 = paramg.field_favProto.vEn;
      if (((List)localObject3).size() >= 2) {
        break;
      }
      Log.e("MicroMsg.Fav.FavNoteListItem", "no other item");
      AppMethodBeat.o(107470);
      return localView;
      locala = (a)paramView.getTag();
      localView = paramView;
    }
    int m = -1;
    int i3 = ((List)localObject3).size();
    int j = 0;
    int i2 = -1;
    int i4 = 1;
    int k = 0;
    int i = 0;
    if (k < ((List)localObject3).size())
    {
      paramViewGroup = (arf)((List)localObject3).get(k);
      if (k == 0)
      {
        paramView = new u(com.tencent.mm.plugin.fav.a.b.d(paramViewGroup));
        if (!paramView.jKS()) {
          FavoriteImageServer.b(paramg, paramViewGroup);
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if (paramViewGroup.ZzG == null)
        {
          paramViewGroup = new ql();
          paramViewGroup.hTy.type = 10;
          paramViewGroup.hTy.field_localId = paramg.field_localId;
          paramViewGroup.hTy.path = ah.v(paramView.jKT());
          paramViewGroup.publish();
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
    Object localObject1;
    if ((i4 != 0) && (i3 == 2))
    {
      k = 1;
      if ((k == 0) || (i2 <= 0)) {
        break label1256;
      }
      localObject1 = (arf)((List)localObject3).get(i2);
      if (((arf)localObject1).dataType != 3) {
        break label904;
      }
      locala.Aox.setVisibility(8);
      locala.Aoy.setVisibility(8);
      locala.Aoz.setVisibility(0);
      locala.AoA.setVisibility(8);
      locala.AoL.setText(n.aj(this.AfM.context, (int)com.tencent.mm.plugin.fav.a.b.mA(((arf)localObject1).duration)));
    }
    for (;;)
    {
      AppMethodBeat.o(107470);
      return localView;
      k = 0;
      break;
      label904:
      if (((arf)localObject1).dataType == 20)
      {
        locala.Aox.setVisibility(8);
        locala.Aoy.setVisibility(8);
        locala.Aoz.setVisibility(8);
        locala.AoA.setVisibility(0);
        locala.AoM.setText(n.aj(this.AfM.context, (int)com.tencent.mm.plugin.fav.a.b.mA(((arf)localObject1).duration)));
      }
      else
      {
        paramg = null;
        if (((arf)localObject1).dataType == 6)
        {
          i = q.h.app_attach_file_icon_location;
          localObject2 = ((arf)localObject1).Zzy.ZAh;
          paramViewGroup = ((arf)localObject1).Zzy.remark;
          if (Util.isNullOrNil(paramViewGroup)) {
            if (n.auz(b((arm)localObject2)))
            {
              paramView = b((arm)localObject2);
              label1044:
              paramViewGroup = a((arm)localObject2);
              label1050:
              a(locala.AoI, (arf)localObject1);
            }
          }
        }
        for (;;)
        {
          locala.Aoz.setVisibility(8);
          locala.AoA.setVisibility(8);
          locala.Aox.setVisibility(8);
          locala.Aoy.setVisibility(0);
          locala.AoI.setImageResource(i);
          locala.AoJ.setText(paramView);
          if (Util.isNullOrNil(paramViewGroup)) {
            break label1243;
          }
          locala.AoK.setText(paramViewGroup);
          locala.AoK.setVisibility(0);
          break;
          paramView = a((arm)localObject2);
          paramViewGroup = paramg;
          break label1050;
          paramView = paramViewGroup;
          if (!n.auz(b((arm)localObject2))) {
            break label1044;
          }
          paramg = b((arm)localObject2);
          paramView = paramViewGroup;
          paramViewGroup = paramg;
          break label1050;
          i = e.aut(((arf)localObject1).ZyU);
          paramg = ((arf)localObject1).title;
          paramViewGroup = ((arf)localObject1).desc;
          paramView = paramViewGroup;
          if (Util.isNullOrNil(paramViewGroup)) {
            paramView = com.tencent.mm.plugin.fav.a.b.getLengthStr((float)((arf)localObject1).Zza);
          }
          a(locala.AoI, (arf)localObject1);
          paramViewGroup = paramView;
          paramView = paramg;
        }
        label1243:
        locala.AoK.setVisibility(8);
      }
    }
    label1256:
    locala.Aox.setVisibility(0);
    locala.Aoy.setVisibility(8);
    locala.Aoz.setVisibility(8);
    locala.AoA.setVisibility(8);
    ArrayList localArrayList1 = new ArrayList();
    paramViewGroup = null;
    int n = 1;
    for (;;)
    {
      if (n < ((List)localObject3).size())
      {
        localObject1 = (arf)((List)localObject3).get(n);
        if (((arf)localObject1).dataType == 1)
        {
          localObject1 = ((arf)localObject1).desc;
          if (Util.isNullOrNil((String)localObject1)) {
            break label2666;
          }
          paramView = (View)localObject1;
          if (((String)localObject1).length() > 1000) {
            paramView = ((String)localObject1).substring(0, 1000);
          }
          paramView = paramView.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace(" ", " ").split("\n");
          label1427:
          localObject1 = paramViewGroup;
          if (paramView == null) {
            break label2677;
          }
          localObject1 = paramViewGroup;
          if (paramView.length <= 0) {
            break label2677;
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
                label1484:
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
              if ((localArrayList2.size() > 0) && (Util.isNullOrNil(paramViewGroup)))
              {
                paramViewGroup = (String)localArrayList2.get(0);
                k = 1;
                for (;;)
                {
                  label1597:
                  localObject1 = paramViewGroup;
                  if (k >= localArrayList2.size()) {
                    break;
                  }
                  localArrayList1.add((String)localArrayList2.get(k));
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
          switch (((arf)localObject1).dataType)
          {
          case 3: 
            localObject1 = paramViewGroup;
            if (Util.isNullOrNil(paramView)) {
              break label2677;
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
        paramView = n.ak(paramView, q.i.favorite_sub_title_voice) + " " + n.aj(paramView, (int)com.tencent.mm.plugin.fav.a.b.mA(((arf)localObject1).duration));
        continue;
        paramView = n.ak(paramView, q.i.favorite_sub_title_url) + " " + ((arf)localObject1).title;
        continue;
        if (!com.tencent.mm.plugin.fav.a.b.dQh())
        {
          paramView = n.ak(paramView, q.i.favorite_sub_title_url) + " " + ((arf)localObject1).title;
          continue;
          paramView = n.ak(paramView, q.i.favorite_sub_title_music) + " " + ((arf)localObject1).title;
          continue;
          localObject1 = ((arf)localObject1).Zzy.ZAh;
          if (localObject1 == null)
          {
            paramView = n.ak(paramView, q.i.favorite_sub_title_location);
            continue;
          }
          if (n.auz(((arm)localObject1).hVI))
          {
            paramView = n.ak(paramView, q.i.favorite_sub_title_location) + " " + ((arm)localObject1).hVI;
            continue;
          }
          paramView = n.ak(paramView, q.i.favorite_sub_title_location) + " " + ((arm)localObject1).label;
          continue;
          paramView = n.ak(paramView, q.i.favorite_sub_title_file) + " " + ((arf)localObject1).title;
          continue;
          paramView = n.ak(paramView, q.i.favorite_mall_product) + " " + ((arf)localObject1).Zzy.ZAl.title;
          continue;
          paramView = n.ak(paramView, q.i.favorite_friend_card);
          continue;
          if (!Util.isNullOrNil(paramViewGroup))
          {
            locala.AoG.setText(p.b(locala.AoG.getContext(), paramViewGroup, locala.AoG.getTextSize()));
            locala.AoG.setVisibility(0);
            if (localArrayList1.size() > 0) {
              locala.AoG.setMaxLines(1);
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
            locala.AoG.setMaxLines(3);
            continue;
            locala.AoG.setVisibility(8);
          }
          if (paramView.length() != 0)
          {
            paramView = paramView.substring(0, paramView.length() - 1);
            locala.AoH.setText(p.b(locala.AoH.getContext(), paramView, locala.AoH.getTextSize()));
            locala.AoH.setVisibility(0);
            label2367:
            if (j == 0) {
              break label2641;
            }
            locala.AoB.setVisibility(0);
            paramView = (arf)((List)localObject3).get(m);
            if (((arf)((List)localObject3).get(m)).dataType != 2) {
              break label2542;
            }
            paramViewGroup = locala.AoC;
            j = q.h.fav_list_img_default;
            k = Aod;
            FavoriteImageServer.a(paramViewGroup, j, paramView, paramg, true, k, k);
            locala.AoD.setVisibility(8);
            locala.AoC.setContentDescription(((Context)localObject2).getResources().getString(q.i.app_pic_for_icon));
          }
          for (;;)
          {
            if (i <= 1) {
              break label2618;
            }
            locala.AoF.setText(localView.getContext().getString(q.i.favorite_img_count, new Object[] { Integer.valueOf(i) }));
            locala.AoF.setVisibility(0);
            locala.AoE.setVisibility(0);
            break;
            locala.AoH.setVisibility(8);
            break label2367;
            label2542:
            locala.AoD.setVisibility(0);
            paramViewGroup = this.AfM;
            localObject1 = locala.AoC;
            localObject3 = paramView.hDd;
            j = q.h.app_attach_file_icon_video;
            k = Aod;
            paramViewGroup.a((ImageView)localObject1, paramView, paramg, (String)localObject3, j, k, k);
            locala.AoC.setContentDescription(((Context)localObject2).getResources().getString(q.i.app_video));
          }
          label2618:
          locala.AoF.setVisibility(8);
          locala.AoE.setVisibility(8);
          break;
          label2641:
          locala.AoB.setVisibility(8);
          break;
          k = 0;
          break label1597;
          k = 0;
          break label1484;
          label2666:
          paramView = null;
          break label1427;
        }
        paramView = "";
      }
      label2677:
      n += 1;
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107473);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107473);
  }
  
  public static final class a
    extends b.b
  {
    View AoA;
    View AoB;
    ImageView AoC;
    ImageView AoD;
    View AoE;
    TextView AoF;
    TextView AoG;
    TextView AoH;
    ImageView AoI;
    TextView AoJ;
    TextView AoK;
    TextView AoL;
    TextView AoM;
    View Aox;
    View Aoy;
    View Aoz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.k
 * JD-Core Version:    0.7.0.1
 */