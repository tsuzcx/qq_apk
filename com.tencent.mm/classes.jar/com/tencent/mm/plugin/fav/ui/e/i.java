package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int rDf;
  private Set<ImageView> rDu;
  private View.OnClickListener rDv;
  
  public i(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.rDv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!com.tencent.mm.compatible.util.e.abf())
        {
          t.g(i.this.rvp.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        akj localakj;
        ajn localajn;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localakj = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.Gjv;
          localajn = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localajn == null)
          {
            ad.w("MicroMsg.FavBaseListItem", "data item is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localajn))
          {
            ad.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.az.a.aJE();
            i.a(i.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.a(localajn));
        if (!((com.tencent.mm.vfs.e)localObject).exists()) {
          if (localajn.dnv == null) {
            localObject = "";
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.az.g.a(6, null, localajn.title, localajn.desc, localajn.GgY, localajn.Ghc, localajn.Gha, localajn.dsU, com.tencent.mm.plugin.fav.a.b.cuH(), (String)localObject, "", localakj.appId);
          ((f)localObject).ihx = localajn.songAlbumUrl;
          ((f)localObject).ihp = localajn.songLyric;
          ((f)localObject).ihH = localajn.dsU;
          com.tencent.mm.az.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          break;
          localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.fav.a.b.cuB() + com.tencent.mm.b.g.getMessageDigest(localajn.dnv.getBytes()));
          if (((com.tencent.mm.vfs.e)localObject).exists()) {}
          for (localObject = q.B(((com.tencent.mm.vfs.e)localObject).fOK());; localObject = "") {
            break;
          }
          localObject = q.B(((com.tencent.mm.vfs.e)localObject).fOK());
        }
      }
    };
    this.rDf = com.tencent.mm.cc.a.ax(paramo.context, 2131165358);
    this.rDu = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, 2131493955, null), paramViewGroup, paramg);
      paramViewGroup.lZa = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iVq = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iCV = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.rDx = ((ImageView)paramView.findViewById(2131299798));
      paramViewGroup.rDq = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rDq.setVisibility(8);
      paramViewGroup.rDx.setOnClickListener(this.rDv);
      paramViewGroup.rDx.setVisibility(0);
      this.rDu.add(paramViewGroup.rDx);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.iVq.setText(((ajn)localObject).title);
      paramViewGroup.iCV.setText(((ajn)localObject).desc);
      paramViewGroup.iCV.setVisibility(0);
      this.rvp.a(paramViewGroup.lZa, (ajn)localObject, paramg, 2131689564, this.rDf, this.rDf);
      paramViewGroup.rDx.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((ajn)localObject)) {
        break label256;
      }
      paramViewGroup.rDx.setImageResource(2131233393);
    }
    for (;;)
    {
      AppMethodBeat.o(107466);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label256:
      paramViewGroup.rDx.setImageResource(2131233395);
    }
  }
  
  public final void a(View paramView, akf paramakf)
  {
    AppMethodBeat.i(107467);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rtA, paramakf);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView iCV;
    TextView iVq;
    ImageView lZa;
    TextView rDq;
    ImageView rDx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.i
 * JD-Core Version:    0.7.0.1
 */