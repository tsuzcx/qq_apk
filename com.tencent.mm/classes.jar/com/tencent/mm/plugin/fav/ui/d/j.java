package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.aw.f;
import com.tencent.mm.aw.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.d;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.findersdk.a.cp;
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

public final class j
  extends b
{
  private final int Aod;
  private Set<ImageView> Aos;
  private View.OnClickListener Aot;
  
  public j(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(274437);
    this.Aot = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(274452);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!e.aPU())
        {
          aa.j(j.this.AfM.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274452);
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274452);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localarf))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            paramAnonymousView = new kn();
            paramAnonymousView.ioV = 2L;
            paramAnonymousView.iqr = 9L;
            cp.a(paramAnonymousView);
            com.tencent.mm.aw.a.bLi();
            j.a(j.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274452);
          return;
        }
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274452);
          return;
        }
        localObject = new u(com.tencent.mm.plugin.fav.a.b.a(localarf));
        if (!((u)localObject).jKS()) {
          if (localarf.hDd == null)
          {
            localObject = "";
            label267:
            if (localarf.Zzy == null) {
              break label534;
            }
          }
        }
        label534:
        for (dtj localdtj = localarf.Zzy.ZAJ;; localdtj = null)
        {
          localObject = i.a(6, null, localarf.title, localarf.desc, localarf.ZyM, localarf.ZyQ, localarf.ZyO, localarf.hIQ, com.tencent.mm.plugin.fav.a.b.dQc(), (String)localObject, "", localasb.appId, com.tencent.mm.aw.h.a(localarf.hIQ, localdtj));
          ((f)localObject).oOM = localarf.songAlbumUrl;
          ((f)localObject).oOE = localarf.songLyric;
          if ((localarf.Zzy != null) && (localarf.Zzy.ZAJ != null) && (!Util.isNullOrNil(localarf.Zzy.ZAJ.oOZ))) {
            ((f)localObject).oOZ = localarf.Zzy.ZAJ.oOZ;
          }
          ((f)localObject).oOW = localarf.hIQ;
          com.tencent.mm.aw.a.c((f)localObject);
          j.a(j.this, (ImageView)paramAnonymousView);
          paramAnonymousView = new kn();
          paramAnonymousView.ioV = 1L;
          paramAnonymousView.iqr = 9L;
          cp.a(paramAnonymousView);
          break;
          localObject = new u(com.tencent.mm.plugin.fav.a.b.dPW() + com.tencent.mm.b.g.getMessageDigest(localarf.hDd.getBytes()));
          if (((u)localObject).jKS()) {}
          for (localObject = ah.v(((u)localObject).jKT());; localObject = "") {
            break;
          }
          localObject = ah.v(((u)localObject).jKT());
          break label267;
        }
      }
    };
    this.Aod = com.tencent.mm.cd.a.br(paramFavoriteImageServer.context, q.c.FavIconSize);
    this.Aos = new HashSet();
    AppMethodBeat.o(274437);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    dtj localdtj = null;
    AppMethodBeat.i(274443);
    Context localContext = paramViewGroup.getContext();
    a locala;
    View localView1;
    if (paramView == null)
    {
      locala = new a();
      localView1 = a(View.inflate(localContext, q.f.fav_listitem_appmsg, null), locala, paramg);
      locala.ttT = ((ImageView)localView1.findViewById(q.e.fav_icon));
      locala.pJJ = ((TextView)localView1.findViewById(q.e.fav_title));
      locala.plr = ((TextView)localView1.findViewById(q.e.fav_desc));
      locala.Aov = ((ImageView)localView1.findViewById(q.e.fav_icon_mask));
      locala.Aoo = ((TextView)localView1.findViewById(q.e.fav_source));
      locala.Aoo.setVisibility(8);
      locala.Aov.setOnClickListener(this.Aot);
      locala.Aov.setVisibility(0);
      this.Aos.add(locala.Aov);
      am(locala.ttT, 7);
    }
    arf localarf;
    for (;;)
    {
      a(locala, paramg);
      localarf = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if (localarf == null)
      {
        Log.w("MicroMsg.FavBaseListItem", "getView, data item is null");
        AppMethodBeat.o(274443);
        return localView1;
        try
        {
          locala = (a)paramView.getTag();
          localView1 = paramView;
        }
        catch (Exception paramViewGroup)
        {
          Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + paramViewGroup.getMessage());
          AppMethodBeat.o(274443);
          return paramView;
        }
      }
    }
    String str1 = localarf.title;
    paramView = localarf.desc;
    String str2 = "";
    if (localarf.Zzy != null) {
      localdtj = localarf.Zzy.ZAJ;
    }
    View localView2 = paramView;
    paramViewGroup = str1;
    if (localdtj != null)
    {
      if (!Util.isNullOrNil(localdtj.YqQ))
      {
        paramView = localdtj.YqQ + localContext.getString(q.i.music_mv_info_share_suffix);
        paramViewGroup = str1 + String.format("·%s", new Object[] { localarf.desc });
        str2 = localdtj.YqP;
        localView2 = paramView;
      }
    }
    else
    {
      locala.pJJ.setText(paramViewGroup);
      if (!Util.isNullOrNil(localView2))
      {
        locala.plr.setText(localView2);
        locala.plr.setVisibility(0);
      }
      if (localarf.Zzy == null) {
        localarf.a(new arg());
      }
      if (localarf.Zzy.ZAJ == null) {
        localarf.Zzy.e(new dtj());
      }
      if (Util.isNullOrNil(str2)) {
        break label647;
      }
      paramViewGroup = new c.a();
      paramView = com.tencent.mm.plugin.music.h.b.aPp(str2);
      paramViewGroup.fullPath = paramView;
      paramViewGroup.oKp = true;
      paramViewGroup.nrc = true;
      paramViewGroup.oKn = true;
      paramViewGroup.nqa = true;
      paramViewGroup.oKI = com.tencent.mm.cd.a.fromDPToPix(localContext, 2);
      paramViewGroup = paramViewGroup.bKx();
      r.bKe().a(str2, locala.ttT, paramViewGroup);
      localarf.Zzy.ZAJ.oPc = paramView;
      label569:
      locala.Aov.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f(localarf)) {
        break label676;
      }
      locala.Aov.setImageResource(q.d.music_pauseicon);
      locala.Aov.setContentDescription(localContext.getString(q.i.app_pause));
    }
    for (;;)
    {
      AppMethodBeat.o(274443);
      return localView1;
      paramViewGroup = str1;
      if (Util.isNullOrNil(localdtj.singerName)) {
        break;
      }
      paramView = localdtj.singerName;
      paramViewGroup = str1;
      break;
      label647:
      this.AfM.a(locala.ttT, localarf, paramg, q.h.app_attach_file_icon_music, this.Aod, this.Aod);
      break label569;
      label676:
      locala.Aov.setImageResource(q.d.music_playicon);
      locala.Aov.setContentDescription(localContext.getString(q.i.app_play));
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(274445);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(274445);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)com.tencent.mm.kernel.h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(274445);
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
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.j
 * JD-Core Version:    0.7.0.1
 */