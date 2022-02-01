package com.tencent.mm.plugin.fav.ui.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.ui.am;
import d.v;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem;", "imageServer", "Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;", "(Lcom/tencent/mm/plugin/fav/ui/FavoriteImageServer;)V", "ITEM_SIZE", "", "getITEM_SIZE", "()I", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "onListItemClick", "", "view", "favReportInfo", "Lcom/tencent/mm/protocal/protobuf/FavReportInfo;", "FavFinderHolder", "ui-fav_release"})
public final class e
  extends b
{
  private final int qTc;
  
  public e(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(164112);
    this.qTc = a.au(paramo.getContext(), 2131165356);
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
          ((a)localObject1).qTo = ((ImageView)localObject2);
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
          ((a)localObject1).gAI = ((TextView)localObject2);
          localObject2 = paramView.findViewById(2131300002);
          if (localObject2 == null)
          {
            paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(164110);
            throw paramView;
          }
          ((a)localObject1).qTp = ((ImageView)localObject2);
          a((b.b)localObject1, paramg);
          localObject2 = ((a)localObject1).titleTv;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          localObject2 = ((a)localObject1).gAI;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)"");
          }
          if (paramg != null)
          {
            paramg = paramg.field_favProto;
            if (paramg != null)
            {
              paramg = paramg.eRJ();
              if (paramg != null)
              {
                localObject2 = ((a)localObject1).titleTv;
                if (localObject2 != null)
                {
                  if (paramViewGroup == null) {
                    d.g.b.k.fOy();
                  }
                  ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramViewGroup, (CharSequence)paramg.nickname));
                }
                if (paramg.EGJ != 1)
                {
                  localObject2 = ((a)localObject1).gAI;
                  if (localObject2 != null)
                  {
                    if (paramViewGroup == null) {
                      d.g.b.k.fOy();
                    }
                    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(paramViewGroup, (CharSequence)paramg.desc));
                  }
                }
                if (paramg.EGJ != 2) {
                  break label552;
                }
                localObject2 = ((a)localObject1).qTp;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
                localObject2 = ((a)localObject1).qTp;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setImageDrawable(am.k(paramViewGroup, 2131690348, a.n(paramViewGroup, 2131099828)));
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
        paramg = (anw)paramg.mediaList.get(0);
        paramViewGroup = (com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        paramg = paramg.thumbUrl;
        localObject1 = ((a)localObject1).qTo;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup.loadImage(paramg, (ImageView)localObject1);
      }
      if (paramView == null) {
        d.g.b.k.fOy();
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
      if (paramg.EGJ != 4)
      {
        paramViewGroup = ((a)localObject1).qTp;
        if (paramViewGroup != null) {
          paramViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public final void a(View paramView, ahp paramahp)
  {
    AppMethodBeat.i(164111);
    if (paramView != null) {}
    for (paramahp = paramView.getTag(); paramahp == null; paramahp = null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.fav.ui.listitem.FavFinderListItem.FavFinderHolder");
      AppMethodBeat.o(164111);
      throw paramView;
    }
    paramahp = ((a)paramahp).qJy;
    if (paramahp != null)
    {
      paramahp = paramahp.field_favProto;
      if (paramahp != null)
      {
        paramahp = paramahp.eRJ();
        if (paramahp != null)
        {
          f localf = f.qMB;
          paramView = paramView.getContext();
          d.g.b.k.g(paramView, "view.context");
          f.a(paramView, paramahp);
          AppMethodBeat.o(164111);
          return;
        }
      }
    }
    AppMethodBeat.o(164111);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem$FavFinderHolder;", "Lcom/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$FavBaseHolder;", "(Lcom/tencent/mm/plugin/fav/ui/listitem/FavFinderListItem;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "imageIV", "Landroid/widget/ImageView;", "getImageIV", "()Landroid/widget/ImageView;", "setImageIV", "(Landroid/widget/ImageView;)V", "tagIv", "getTagIv", "setTagIv", "titleTv", "getTitleTv", "setTitleTv", "ui-fav_release"})
  public final class a
    extends b.b
  {
    TextView gAI;
    ImageView qTo;
    ImageView qTp;
    TextView titleTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.e
 * JD-Core Version:    0.7.0.1
 */