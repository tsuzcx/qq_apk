package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.bb;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b
{
  private final int Aod;
  
  public e(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(164112);
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavFinderImageSize);
    AppMethodBeat.o(164112);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(164110);
    if (paramViewGroup == null) {
      paramViewGroup = null;
    }
    Object localObject2;
    int i;
    for (;;)
    {
      if (paramView == null)
      {
        localObject1 = new a();
        paramView = a(View.inflate(paramViewGroup, q.f.fav_listitem_finder, null), (b.b)localObject1, paramg);
        localObject2 = paramView.findViewById(q.e.fav_record_card_icon);
        if (localObject2 == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(164110);
          throw paramView;
          paramViewGroup = paramViewGroup.getContext();
        }
        else
        {
          ((a)localObject1).Aop = ((ImageView)localObject2);
          localObject2 = paramView.findViewById(q.e.fav_record_title);
          if (localObject2 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).titleTv = ((TextView)localObject2);
          localObject2 = paramView.findViewById(q.e.fav_record_desc);
          if (localObject2 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).descTv = ((TextView)localObject2);
          localObject2 = paramView.findViewById(q.e.finder_item_tag_iv);
          if (localObject2 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).Aoq = ((ImageView)localObject2);
          a((b.b)localObject1, paramg);
          b.b((View)((a)localObject1).Aop, paramg);
          localObject2 = ((a)localObject1).titleTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          localObject2 = ((a)localObject1).descTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          if (paramg != null)
          {
            paramg = paramg.field_favProto;
            if (paramg != null)
            {
              localObject2 = paramg.ZAB;
              if (localObject2 != null)
              {
                TextView localTextView = ((a)localObject1).titleTv;
                if (localTextView != null)
                {
                  s.checkNotNull(paramViewGroup);
                  paramg = (CharSequence)((bvl)localObject2).mIK;
                  if ((paramg != null) && (paramg.length() != 0)) {
                    break label596;
                  }
                  i = 1;
                  label351:
                  if (i == 0) {
                    break label602;
                  }
                  paramg = ((bvl)localObject2).nickname;
                  label362:
                  localTextView.setText((CharSequence)p.b(paramViewGroup, (CharSequence)paramg));
                }
                if (((bvl)localObject2).GfT != 1)
                {
                  paramg = ((a)localObject1).descTv;
                  if (paramg != null)
                  {
                    s.checkNotNull(paramViewGroup);
                    paramg.setText((CharSequence)p.b(paramViewGroup, (CharSequence)((bvl)localObject2).desc));
                  }
                }
                if (((bvl)localObject2).GfT != 2) {
                  break label611;
                }
                paramg = ((a)localObject1).Aoq;
                if (paramg != null) {
                  paramg.setVisibility(0);
                }
                paramg = ((a)localObject1).Aoq;
                if (paramg != null) {
                  paramg.setImageDrawable(bb.m(paramViewGroup, q.h.icons_filled_album, a.w(paramViewGroup, q.b.White)));
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((((bvl)localObject2).mediaList != null) && (!((bvl)localObject2).mediaList.isEmpty()))
      {
        paramg = (bvj)((bvl)localObject2).mediaList.get(0);
        paramViewGroup = (cn)h.az(cn.class);
        paramg = paramg.thumbUrl;
        localObject1 = ((a)localObject1).Aop;
        s.checkNotNull(localObject1);
        paramViewGroup.loadImage(paramg, (ImageView)localObject1);
      }
      s.checkNotNull(paramView);
      AppMethodBeat.o(164110);
      return paramView;
      if (paramView == null) {}
      while (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
        AppMethodBeat.o(164110);
        throw paramView;
        localObject1 = paramView.getTag();
      }
      localObject1 = (a)localObject1;
      break;
      label596:
      i = 0;
      break label351;
      label602:
      paramg = ((bvl)localObject2).mIK;
      break label362;
      label611:
      if (((bvl)localObject2).GfT != 4)
      {
        paramViewGroup = ((a)localObject1).Aoq;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(164111);
    Object localObject = WeChatBrands.Business.Entries.SessionChannels;
    if (paramView == null) {}
    for (paramarx = null; !((WeChatBrands.Business.Entries)localObject).checkAvailable(paramarx); paramarx = paramView.getContext())
    {
      AppMethodBeat.o(164111);
      return;
    }
    if (paramView == null) {}
    for (paramarx = null; paramarx == null; paramarx = paramView.getTag())
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
      AppMethodBeat.o(164111);
      throw paramView;
    }
    paramarx = ((a)paramarx).AdF;
    if (paramarx != null)
    {
      paramarx = paramarx.field_favProto;
      if (paramarx != null)
      {
        paramarx = paramarx.ZAB;
        if (paramarx != null)
        {
          localObject = f.Ahd;
          paramView = paramView.getContext();
          s.s(paramView, "view.context");
          f.a(paramView, paramarx);
        }
      }
    }
    AppMethodBeat.o(164111);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends b.b
  {
    ImageView Aop;
    ImageView Aoq;
    TextView descTv;
    TextView titleTv;
    
    public a()
    {
      AppMethodBeat.i(274440);
      AppMethodBeat.o(274440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.e
 * JD-Core Version:    0.7.0.1
 */