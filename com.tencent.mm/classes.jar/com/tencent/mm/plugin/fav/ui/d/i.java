package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.d;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Set;

public final class i
  extends b
{
  private final int Aod;
  private Set<ImageView> Aos;
  private View.OnClickListener Aot;
  
  public i(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107465);
    this.Aot = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107464);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!e.aPU())
        {
          aa.j(i.this.AfM.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107464);
          return;
        }
        asb localasb;
        arf localarf;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g))
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag();
          localasb = ((com.tencent.mm.plugin.fav.a.g)localObject).field_favProto.ZBt;
          localarf = com.tencent.mm.plugin.fav.a.b.c((com.tencent.mm.plugin.fav.a.g)localObject);
          if (localarf == null)
          {
            Log.w("MicroMsg.FavBaseListItem", "data item is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107464);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localarf))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            com.tencent.mm.aw.a.bLi();
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
        localObject = new u(com.tencent.mm.plugin.fav.a.b.a(localarf));
        if (!((u)localObject).jKS()) {
          if (localarf.hDd == null) {
            localObject = "";
          }
        }
        for (;;)
        {
          localObject = com.tencent.mm.aw.i.a(6, null, localarf.title, localarf.desc, localarf.ZyM, localarf.ZyQ, localarf.ZyO, localarf.hIQ, com.tencent.mm.plugin.fav.a.b.dQc(), (String)localObject, "", localasb.appId);
          ((f)localObject).oOM = localarf.songAlbumUrl;
          ((f)localObject).oOE = localarf.songLyric;
          if ((localarf.Zzy != null) && (localarf.Zzy.ZAJ != null) && (!Util.isNullOrNil(localarf.Zzy.ZAJ.oOZ))) {
            ((f)localObject).oOZ = localarf.Zzy.ZAJ.oOZ;
          }
          ((f)localObject).oOW = localarf.hIQ;
          com.tencent.mm.aw.a.c((f)localObject);
          i.a(i.this, (ImageView)paramAnonymousView);
          break;
          localObject = new u(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(localarf.hDd.getBytes()));
          if (((u)localObject).jKS()) {}
          for (localObject = ah.v(((u)localObject).jKT());; localObject = "") {
            break;
          }
          localObject = ah.v(((u)localObject).jKT());
        }
      }
    };
    this.Aod = com.tencent.mm.cd.a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    this.Aos = new HashSet();
    AppMethodBeat.o(107465);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(107466);
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate(localContext, q.f.fav_listitem_appmsg, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.pJJ = ((TextView)paramView.findViewById(q.e.fav_title));
      paramViewGroup.plr = ((TextView)paramView.findViewById(q.e.fav_desc));
      paramViewGroup.Aov = ((ImageView)paramView.findViewById(q.e.fav_icon_mask));
      paramViewGroup.Aoo = ((TextView)paramView.findViewById(q.e.fav_source));
      paramViewGroup.Aoo.setVisibility(8);
      paramViewGroup.Aov.setOnClickListener(this.Aot);
      paramViewGroup.Aov.setVisibility(0);
      this.Aos.add(paramViewGroup.Aov);
      a(paramViewGroup, paramg);
      arf localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
      paramViewGroup.pJJ.setText(localarf.title);
      am(paramViewGroup.ttT, 7);
      paramViewGroup.plr.setText(localarf.desc);
      paramViewGroup.plr.setVisibility(0);
      this.AfM.a(paramViewGroup.ttT, localarf, paramg, q.h.app_attach_file_icon_music, this.Aod, this.Aod);
      paramViewGroup.Aov.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f(localarf)) {
        break label322;
      }
      paramViewGroup.Aov.setImageResource(q.d.music_pauseicon);
      paramViewGroup.Aov.setContentDescription(localContext.getString(q.i.app_pause));
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
      label322:
      paramViewGroup.Aov.setImageResource(q.d.music_playicon);
      paramViewGroup.Aov.setContentDescription(localContext.getString(q.i.app_play));
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107467);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(107467);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107467);
  }
  
  public static final class a
    extends b.b
  {
    TextView Aoo;
    ImageView Aov;
    TextView pJJ;
    TextView plr;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.i
 * JD-Core Version:    0.7.0.1
 */