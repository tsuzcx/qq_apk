package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.d;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.findersdk.a.al;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.w;
import java.util.HashSet;
import java.util.Set;

public final class j
  extends b
{
  private final int wRA;
  private Set<ImageView> wRP;
  private View.OnClickListener wRQ;
  
  public j(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(233566);
    this.wRQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(229904);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (!e.avA())
        {
          w.g(j.this.wJr.context, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229904);
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(229904);
            return;
          }
          if (com.tencent.mm.plugin.fav.a.b.f(localanm))
          {
            Log.i("MicroMsg.FavBaseListItem", "same song, do release");
            paramAnonymousView = new ig();
            paramAnonymousView.giq = 2L;
            paramAnonymousView.gnP = 9L;
            al.a(paramAnonymousView);
            com.tencent.mm.bb.a.bnv();
            j.a(j.this, null);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229904);
          return;
        }
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavMusicMvListItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(229904);
          return;
        }
        localObject = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.fav.a.b.a(localanm));
        if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
          if (localanm.fyu == null)
          {
            localObject = "";
            label267:
            if (localanm.SyG == null) {
              break label477;
            }
          }
        }
        label477:
        for (dbr localdbr = localanm.SyG.SzR;; localdbr = null)
        {
          localObject = i.a(6, null, localanm.title, localanm.desc, localanm.SxU, localanm.SxY, localanm.SxW, localanm.fEa, com.tencent.mm.plugin.fav.a.b.djr(), (String)localObject, "", localaoi.appId, com.tencent.mm.bb.h.a(localanm.fEa, localdbr));
          ((f)localObject).lVK = localanm.songAlbumUrl;
          ((f)localObject).lVC = localanm.songLyric;
          ((f)localObject).lVU = localanm.fEa;
          com.tencent.mm.bb.a.c((f)localObject);
          j.a(j.this, (ImageView)paramAnonymousView);
          paramAnonymousView = new ig();
          paramAnonymousView.giq = 1L;
          paramAnonymousView.gnP = 9L;
          al.a(paramAnonymousView);
          break;
          localObject = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.fav.a.b.djl() + com.tencent.mm.b.g.getMessageDigest(localanm.fyu.getBytes()));
          if (((com.tencent.mm.vfs.q)localObject).ifE()) {}
          for (localObject = ((com.tencent.mm.vfs.q)localObject).bOF();; localObject = "") {
            break;
          }
          localObject = ((com.tencent.mm.vfs.q)localObject).bOF();
          break label267;
        }
      }
    };
    this.wRA = com.tencent.mm.ci.a.aY(paramo.context, s.c.FavIconSize);
    this.wRP = new HashSet();
    AppMethodBeat.o(233566);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    dbr localdbr = null;
    AppMethodBeat.i(233570);
    Context localContext = paramViewGroup.getContext();
    a locala;
    View localView1;
    if (paramView == null)
    {
      locala = new a();
      localView1 = a(View.inflate(localContext, s.f.fav_listitem_appmsg, null), locala, paramg);
      locala.qps = ((ImageView)localView1.findViewById(s.e.fav_icon));
      locala.mNb = ((TextView)localView1.findViewById(s.e.fav_title));
      locala.mrM = ((TextView)localView1.findViewById(s.e.fav_desc));
      locala.wRS = ((ImageView)localView1.findViewById(s.e.fav_icon_mask));
      locala.wRL = ((TextView)localView1.findViewById(s.e.fav_source));
      locala.wRL.setVisibility(8);
      locala.wRS.setOnClickListener(this.wRQ);
      locala.wRS.setVisibility(0);
      this.wRP.add(locala.wRS);
    }
    anm localanm;
    for (;;)
    {
      a(locala, paramg);
      localanm = com.tencent.mm.plugin.fav.a.b.c(paramg);
      if (localanm == null)
      {
        Log.w("MicroMsg.FavBaseListItem", "getView, data item is null");
        AppMethodBeat.o(233570);
        return localView1;
        try
        {
          locala = (a)paramView.getTag();
          localView1 = paramView;
        }
        catch (Exception paramViewGroup)
        {
          Log.e("MicroMsg.FavBaseListItem", "invalid type, message:" + paramViewGroup.getMessage());
          AppMethodBeat.o(233570);
          return paramView;
        }
      }
    }
    String str1 = localanm.title;
    paramView = localanm.desc;
    String str2 = "";
    if (localanm.SyG != null) {
      localdbr = localanm.SyG.SzR;
    }
    View localView2 = paramView;
    paramViewGroup = str1;
    if (localdbr != null)
    {
      if (!Util.isNullOrNil(localdbr.Rux))
      {
        paramView = localdbr.Rux + localContext.getString(s.i.music_mv_info_share_suffix);
        paramViewGroup = str1 + String.format("·%s", new Object[] { localanm.desc });
        str2 = localdbr.Ruw;
        localView2 = paramView;
      }
    }
    else
    {
      locala.mNb.setText(paramViewGroup);
      if (!Util.isNullOrNil(localView2))
      {
        locala.mrM.setText(localView2);
        locala.mrM.setVisibility(0);
      }
      if (localanm.SyG == null) {
        localanm.a(new ann());
      }
      if (localanm.SyG.SzR == null) {
        localanm.SyG.e(new dbr());
      }
      if (Util.isNullOrNil(str2)) {
        break label620;
      }
      paramViewGroup = new c.a();
      paramView = com.tencent.mm.plugin.music.h.b.aSv(str2);
      paramViewGroup.fullPath = paramView;
      paramViewGroup.lRD = true;
      paramViewGroup.kPz = true;
      paramViewGroup.lRB = true;
      paramViewGroup.kOl = true;
      paramViewGroup.lRW = com.tencent.mm.ci.a.fromDPToPix(localContext, 2);
      paramViewGroup = paramViewGroup.bmL();
      com.tencent.mm.ay.q.bml().a(str2, locala.qps, paramViewGroup);
      localanm.SyG.SzR.lVZ = paramView;
      label558:
      locala.wRS.setTag(paramg);
      if (!com.tencent.mm.plugin.fav.a.b.f(localanm)) {
        break label649;
      }
      locala.wRS.setImageResource(s.d.music_pauseicon);
    }
    for (;;)
    {
      AppMethodBeat.o(233570);
      return localView1;
      paramViewGroup = str1;
      if (Util.isNullOrNil(localdbr.singerName)) {
        break;
      }
      paramView = localdbr.singerName;
      paramViewGroup = str1;
      break;
      label620:
      this.wJr.a(locala.qps, localanm, paramg, s.h.app_attach_file_icon_music, this.wRA, this.wRA);
      break label558;
      label649:
      locala.wRS.setImageResource(s.d.music_playicon);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(233572);
    if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramView.getContext()))
    {
      AppMethodBeat.o(233572);
      return;
    }
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)com.tencent.mm.kernel.h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(233572);
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
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.j
 * JD-Core Version:    0.7.0.1
 */