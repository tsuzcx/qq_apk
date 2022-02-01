package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private Set<ImageView> rLF;
  private View.OnClickListener rLG;
  private final int rLq;
  
  public i(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.rLG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!e.abo())
        {
          t.g(i.this.rDB.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        akt localakt;
        ajx localajx;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localakt = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.GCe;
          localajx = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localajx == null)
          {
            ae.w("MicroMsg.FavBaseListItem", "data item is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localajx))
          {
            ae.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.ay.a.aJX();
            i.a(i.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        localObject = new k(com.tencent.mm.plugin.fav.a.b.a(localajx));
        if (!((k)localObject).exists()) {
          if (localajx.dox == null) {
            localObject = "";
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.ay.g.a(6, null, localajx.title, localajx.desc, localajx.GzH, localajx.GzL, localajx.GzJ, localajx.dua, com.tencent.mm.plugin.fav.a.b.cwi(), (String)localObject, "", localakt.appId);
          ((f)localObject).ikq = localajx.songAlbumUrl;
          ((f)localObject).iki = localajx.songLyric;
          ((f)localObject).ikA = localajx.dua;
          com.tencent.mm.ay.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          break;
          localObject = new k(com.tencent.mm.plugin.fav.a.b.cwc() + com.tencent.mm.b.g.getMessageDigest(localajx.dox.getBytes()));
          if (((k)localObject).exists()) {}
          for (localObject = w.B(((k)localObject).fTh());; localObject = "") {
            break;
          }
          localObject = w.B(((k)localObject).fTh());
        }
      }
    };
    this.rLq = com.tencent.mm.cb.a.ax(paramo.context, 2131165358);
    this.rLF = new HashSet();
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
      paramViewGroup.mdt = ((ImageView)paramView.findViewById(2131299794));
      paramViewGroup.iYj = ((TextView)paramView.findViewById(2131299848));
      paramViewGroup.iFO = ((TextView)paramView.findViewById(2131299778));
      paramViewGroup.rLI = ((ImageView)paramView.findViewById(2131299798));
      paramViewGroup.rLB = ((TextView)paramView.findViewById(2131299825));
      paramViewGroup.rLB.setVisibility(8);
      paramViewGroup.rLI.setOnClickListener(this.rLG);
      paramViewGroup.rLI.setVisibility(0);
      this.rLF.add(paramViewGroup.rLI);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.iYj.setText(((ajx)localObject).title);
      paramViewGroup.iFO.setText(((ajx)localObject).desc);
      paramViewGroup.iFO.setVisibility(0);
      this.rDB.a(paramViewGroup.mdt, (ajx)localObject, paramg, 2131689564, this.rLq, this.rLq);
      paramViewGroup.rLI.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((ajx)localObject)) {
        break label256;
      }
      paramViewGroup.rLI.setImageResource(2131233393);
    }
    for (;;)
    {
      AppMethodBeat.o(107466);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label256:
      paramViewGroup.rLI.setImageResource(2131233395);
    }
  }
  
  public final void a(View paramView, akp paramakp)
  {
    AppMethodBeat.i(107467);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.ab(y.class)).a(paramView, locala.rBM, paramakp);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView iFO;
    TextView iYj;
    ImageView mdt;
    TextView rLB;
    ImageView rLI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.i
 * JD-Core Version:    0.7.0.1
 */