package com.tencent.mm.plugin.fav.ui.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"})
public final class e
  extends b
{
  private final int rDf;
  
  public e(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(164112);
    this.rDf = a.ax(paramo.getContext(), 2131165356);
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
        paramView = a(View.inflate(paramViewGroup, 2131493958, null), (b.b)localObject1, paramg);
        Object localObject2 = paramView.findViewById(2131299818);
        if (localObject2 == null)
        {
          paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(164110);
          throw paramView;
          paramViewGroup = null;
        }
        else
        {
          ((a)localObject1).rDr = ((ImageView)localObject2);
          localObject2 = paramView.findViewById(2131299824);
          if (localObject2 == null)
          {
            paramView = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).titleTv = ((TextView)localObject2);
          localObject2 = paramView.findViewById(2131299819);
          if (localObject2 == null)
          {
            paramView = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).gUs = ((TextView)localObject2);
          localObject2 = paramView.findViewById(2131300002);
          if (localObject2 == null)
          {
            paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).rDs = ((ImageView)localObject2);
          a((b.b)localObject1, paramg);
          localObject2 = ((a)localObject1).titleTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          localObject2 = ((a)localObject1).gUs;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          if (paramg != null)
          {
            paramg = paramg.field_favProto;
            if (paramg != null)
            {
              paramg = paramg.fgN();
              if (paramg != null)
              {
                localObject2 = ((a)localObject1).titleTv;
                if (localObject2 != null)
                {
                  if (paramViewGroup == null) {
                    p.gfZ();
                  }
                  ((TextView)localObject2).setText((CharSequence)k.c(paramViewGroup, (CharSequence)paramg.nickname));
                }
                if (paramg.Gpi != 1)
                {
                  localObject2 = ((a)localObject1).gUs;
                  if (localObject2 != null)
                  {
                    if (paramViewGroup == null) {
                      p.gfZ();
                    }
                    ((TextView)localObject2).setText((CharSequence)k.c(paramViewGroup, (CharSequence)paramg.desc));
                  }
                }
                if (paramg.Gpi != 2) {
                  break label552;
                }
                localObject2 = ((a)localObject1).rDs;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
                localObject2 = ((a)localObject1).rDs;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setImageDrawable(ao.k(paramViewGroup, 2131690348, a.n(paramViewGroup, 2131099828)));
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
        paramg = (ari)paramg.mediaList.get(0);
        paramViewGroup = (t)com.tencent.mm.kernel.g.ad(t.class);
        paramg = paramg.thumbUrl;
        localObject1 = ((a)localObject1).rDr;
        if (localObject1 == null) {
          p.gfZ();
        }
        paramViewGroup.loadImage(paramg, (ImageView)localObject1);
      }
      if (paramView == null) {
        p.gfZ();
      }
      AppMethodBeat.o(164110);
      return paramView;
      if (paramView != null) {
        localObject1 = paramView.getTag();
      }
      if (localObject1 == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
        AppMethodBeat.o(164110);
        throw paramView;
      }
      localObject1 = (a)localObject1;
      break;
      label552:
      if (paramg.Gpi != 4)
      {
        paramViewGroup = ((a)localObject1).rDs;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(164111);
    if (paramView != null) {}
    for (paramakf = paramView.getTag(); paramakf == null; paramakf = null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
      AppMethodBeat.o(164111);
      throw paramView;
    }
    paramakf = ((a)paramakf).rtA;
    if (paramakf != null)
    {
      paramakf = paramakf.field_favProto;
      if (paramakf != null)
      {
        paramakf = paramakf.fgN();
        if (paramakf != null)
        {
          f localf = f.rwD;
          paramView = paramView.getContext();
          p.g(paramView, "view.context");
          f.a(paramView, paramakf);
          AppMethodBeat.o(164111);
          return;
        }
      }
    }
    AppMethodBeat.o(164111);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"})
  public final class a
    extends b.b
  {
    TextView gUs;
    ImageView rDr;
    ImageView rDs;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.e
 * JD-Core Version:    0.7.0.1
 */