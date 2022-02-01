package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.d;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int wRA;
  private Set<ImageView> wRP;
  private View.OnClickListener wRQ;
  
  public i(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107465);
    this.wRQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (!e.avA())
        {
          w.g(i.this.wJr.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        aoi localaoi;
        anm localanm;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localaoi = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.SAB;
          localanm = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localanm == null)
          {
            Log.w("MicroMsg.FavBaseListItem", "data item is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localanm))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.bb.a.bnv();
            i.a(i.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        localObject = new q(com.tencent.mm.plugin.fav.a.b.a(localanm));
        if (!((q)localObject).ifE()) {
          if (localanm.fyu == null) {
            localObject = "";
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.bb.i.a(6, null, localanm.title, localanm.desc, localanm.SxU, localanm.SxY, localanm.SxW, localanm.fEa, com.tencent.mm.plugin.fav.a.b.djr(), (String)localObject, "", localaoi.appId);
          ((f)localObject).lVK = localanm.songAlbumUrl;
          ((f)localObject).lVC = localanm.songLyric;
          ((f)localObject).lVU = localanm.fEa;
          com.tencent.mm.bb.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          break;
          localObject = new q(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(localanm.fyu.getBytes()));
          if (((q)localObject).ifE()) {}
          for (localObject = ((q)localObject).bOF();; localObject = "") {
            break;
          }
          localObject = ((q)localObject).bOF();
        }
      }
    };
    this.wRA = com.tencent.mm.ci.a.aY(paramo.context, s.c.FavIconSize);
    this.wRP = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Object localObject = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject, s.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.mNb = ((TextView)paramView.findViewById(s.e.fav_title));
      paramViewGroup.mrM = ((TextView)paramView.findViewById(s.e.fav_desc));
      paramViewGroup.wRS = ((ImageView)paramView.findViewById(s.e.fav_icon_mask));
      paramViewGroup.wRL = ((TextView)paramView.findViewById(s.e.fav_source));
      paramViewGroup.wRL.setVisibility(8);
      paramViewGroup.wRS.setOnClickListener(this.wRQ);
      paramViewGroup.wRS.setVisibility(0);
      this.wRP.add(paramViewGroup.wRS);
      a(paramViewGroup, paramg);
      localObject = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.mNb.setText(((anm)localObject).title);
      paramViewGroup.mrM.setText(((anm)localObject).desc);
      paramViewGroup.mrM.setVisibility(0);
      this.wJr.a(paramViewGroup.qps, (anm)localObject, paramg, s.h.app_attach_file_icon_music, this.wRA, this.wRA);
      paramViewGroup.wRS.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f((anm)localObject)) {
        break label296;
      }
      paramViewGroup.wRS.setImageResource(s.d.music_pauseicon);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(107466);
        return paramView;
        try
        {
          paramViewGroup = (a)paramView.getTag();
        }
        catch (Exception paramViewGroup)
        {
          Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + paramViewGroup.getMessage());
          AppMethodBeat.o(107466);
          return paramView;
        }
      }
      label296:
      paramViewGroup.wRS.setImageResource(s.d.music_playicon);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107467);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107467);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView mNb;
    TextView mrM;
    ImageView qps;
    TextView wRL;
    ImageView wRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.i
 * JD-Core Version:    0.7.0.1
 */