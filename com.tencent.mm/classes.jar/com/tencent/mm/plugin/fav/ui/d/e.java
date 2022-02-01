package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ar;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"})
public final class e
  extends b
{
  private final int tlc;
  
  public e(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(164112);
    this.tlc = a.aG(paramo.getContext(), 2131165367);
    AppMethodBeat.o(164112);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
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
        paramView = a(View.inflate(paramViewGroup, 2131494127, null), (b.b)localObject1, paramg);
        Object localObject2 = paramView.findViewById(2131300494);
        if (localObject2 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(164110);
          throw paramView;
          paramViewGroup = null;
        }
        else
        {
          ((a)localObject1).tlo = ((ImageView)localObject2);
          localObject2 = paramView.findViewById(2131300500);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).titleTv = ((TextView)localObject2);
          localObject2 = paramView.findViewById(2131300495);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).hPW = ((TextView)localObject2);
          localObject2 = paramView.findViewById(2131300854);
          if (localObject2 == null)
          {
            paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).tlp = ((ImageView)localObject2);
          a((b.b)localObject1, paramg);
          localObject2 = ((a)localObject1).titleTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          localObject2 = ((a)localObject1).hPW;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          if (paramg != null)
          {
            paramg = paramg.field_favProto;
            if (paramg != null)
            {
              paramg = paramg.guk();
              if (paramg != null)
              {
                localObject2 = ((a)localObject1).titleTv;
                if (localObject2 != null)
                {
                  if (paramViewGroup == null) {
                    p.hyc();
                  }
                  ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramViewGroup, (CharSequence)paramg.nickname));
                }
                if (paramg.vXJ != 1)
                {
                  localObject2 = ((a)localObject1).hPW;
                  if (localObject2 != null)
                  {
                    if (paramViewGroup == null) {
                      p.hyc();
                    }
                    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(paramViewGroup, (CharSequence)paramg.desc));
                  }
                }
                if (paramg.vXJ != 2) {
                  break label552;
                }
                localObject2 = ((a)localObject1).tlp;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
                localObject2 = ((a)localObject1).tlp;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setImageDrawable(ar.m(paramViewGroup, 2131690479, a.n(paramViewGroup, 2131099844)));
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
        paramg = (bch)paramg.mediaList.get(0);
        paramViewGroup = (aj)com.tencent.mm.kernel.g.ah(aj.class);
        paramg = paramg.thumbUrl;
        localObject1 = ((a)localObject1).tlo;
        if (localObject1 == null) {
          p.hyc();
        }
        paramViewGroup.loadImage(paramg, (ImageView)localObject1);
      }
      if (paramView == null) {
        p.hyc();
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
      label552:
      if (paramg.vXJ != 4)
      {
        paramViewGroup = ((a)localObject1).tlp;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(View paramView, and paramand)
  {
    AppMethodBeat.i(164111);
    Object localObject = WeChatBrands.Business.Entries.SessionChannels;
    if (paramView != null) {}
    for (paramand = paramView.getContext(); !((WeChatBrands.Business.Entries)localObject).checkAvailable(paramand); paramand = null)
    {
      AppMethodBeat.o(164111);
      return;
    }
    if (paramView != null) {}
    for (paramand = paramView.getTag(); paramand == null; paramand = null)
    {
      paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
      AppMethodBeat.o(164111);
      throw paramView;
    }
    paramand = ((a)paramand).tbr;
    if (paramand != null)
    {
      paramand = paramand.field_favProto;
      if (paramand != null)
      {
        paramand = paramand.guk();
        if (paramand != null)
        {
          localObject = f.teu;
          paramView = paramView.getContext();
          p.g(paramView, "view.context");
          f.a(paramView, paramand);
          AppMethodBeat.o(164111);
          return;
        }
      }
    }
    AppMethodBeat.o(164111);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"})
  public final class a
    extends b.b
  {
    TextView hPW;
    TextView titleTv;
    ImageView tlo;
    ImageView tlp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.e
 * JD-Core Version:    0.7.0.1
 */