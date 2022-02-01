package com.tencent.mm.plugin.fav.ui.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.au;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"})
public final class e
  extends b
{
  private final int wRA;
  
  public e(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(164112);
    this.wRA = a.aY(paramo.getContext(), s.c.FavFinderImageSize);
    AppMethodBeat.o(164112);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(164110);
    if (paramViewGroup != null) {
      paramViewGroup = paramViewGroup.getContext();
    }
    for (;;)
    {
      if (paramView == null)
      {
        localObject1 = new a();
        paramView = a(View.inflate(paramViewGroup, s.f.fav_listitem_finder, null), (b.b)localObject1, paramg);
        Object localObject2 = paramView.findViewById(s.e.fav_record_card_icon);
        if (localObject2 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(164110);
          throw paramView;
          paramViewGroup = null;
        }
        else
        {
          ((a)localObject1).wRM = ((ImageView)localObject2);
          localObject2 = paramView.findViewById(s.e.fav_record_title);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).titleTv = ((TextView)localObject2);
          localObject2 = paramView.findViewById(s.e.fav_record_desc);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).kEs = ((TextView)localObject2);
          localObject2 = paramView.findViewById(s.e.finder_item_tag_iv);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).wRN = ((ImageView)localObject2);
          a((b.b)localObject1, paramg);
          localObject2 = ((a)localObject1).titleTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          localObject2 = ((a)localObject1).kEs;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          if (paramg != null)
          {
            paramg = paramg.field_favProto;
            if (paramg != null)
            {
              paramg = paramg.hpG();
              if (paramg != null)
              {
                localObject2 = ((a)localObject1).titleTv;
                if (localObject2 != null)
                {
                  if (paramViewGroup == null) {
                    p.iCn();
                  }
                  ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramViewGroup, (CharSequence)paramg.nickname));
                }
                if (paramg.ACQ != 1)
                {
                  localObject2 = ((a)localObject1).kEs;
                  if (localObject2 != null)
                  {
                    if (paramViewGroup == null) {
                      p.iCn();
                    }
                    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramViewGroup, (CharSequence)paramg.desc));
                  }
                }
                if (paramg.ACQ != 2) {
                  break label559;
                }
                localObject2 = ((a)localObject1).wRN;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
                localObject2 = ((a)localObject1).wRN;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setImageDrawable(au.o(paramViewGroup, s.h.icons_filled_album, a.w(paramViewGroup, s.b.White)));
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramg.mediaList != null) && (!paramg.mediaList.isEmpty()))
      {
        paramg = (bjc)paramg.mediaList.get(0);
        paramViewGroup = (ak)h.ag(ak.class);
        paramg = paramg.thumbUrl;
        localObject1 = ((a)localObject1).wRM;
        if (localObject1 == null) {
          p.iCn();
        }
        paramViewGroup.loadImage(paramg, (ImageView)localObject1);
      }
      if (paramView == null) {
        p.iCn();
      }
      AppMethodBeat.o(164110);
      return paramView;
      if (paramView != null) {
        localObject1 = paramView.getTag();
      }
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
        AppMethodBeat.o(164110);
        throw paramView;
      }
      localObject1 = (a)localObject1;
      break;
      label559:
      if (paramg.ACQ != 4)
      {
        paramViewGroup = ((a)localObject1).wRN;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(164111);
    Object localObject = WeChatBrands.Business.Entries.SessionChannels;
    if (paramView != null) {}
    for (paramaoe = paramView.getContext(); !((WeChatBrands.Business.Entries)localObject).checkAvailable(paramaoe); paramaoe = null)
    {
      AppMethodBeat.o(164111);
      return;
    }
    if (paramView != null) {}
    for (paramaoe = paramView.getTag(); paramaoe == null; paramaoe = null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
      AppMethodBeat.o(164111);
      throw paramView;
    }
    paramaoe = ((a)paramaoe).wHw;
    if (paramaoe != null)
    {
      paramaoe = paramaoe.field_favProto;
      if (paramaoe != null)
      {
        paramaoe = paramaoe.hpG();
        if (paramaoe != null)
        {
          localObject = f.wKG;
          paramView = paramView.getContext();
          p.j(paramView, "view.context");
          f.a(paramView, paramaoe);
          AppMethodBeat.o(164111);
          return;
        }
      }
    }
    AppMethodBeat.o(164111);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"})
  public final class a
    extends b.b
  {
    TextView kEs;
    TextView titleTv;
    ImageView wRM;
    ImageView wRN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.e
 * JD-Core Version:    0.7.0.1
 */