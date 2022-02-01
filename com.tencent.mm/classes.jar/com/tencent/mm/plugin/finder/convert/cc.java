package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.profile.uic.e;
import com.tencent.mm.plugin.finder.publish.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "()V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getLayoutId", "", "isSelf", "item", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "refreshProgress", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLikeArea", "setOrigin", "mvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPostFailed", "context", "Landroid/content/Context;", "setPosting", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cc
  extends com.tencent.mm.view.recyclerview.f<bm>
{
  public static final a AMd;
  public Boolean ALZ;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(349849);
    AMd = new a((byte)0);
    AppMethodBeat.o(349849);
  }
  
  private static final void a(bm parambm, View paramView)
  {
    AppMethodBeat.i(349789);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambm, "$item");
    paramView = parambm.EDt;
    localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    d.a.qr(parambm.EDt.getLocalId());
    parambm = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    if (d.a.qu(paramView.getLocalId()))
    {
      parambm = new hy();
      parambm.hJo.localId = paramView.getLocalId();
      parambm.publish();
      Log.i("Finder.ProfileMusicConvert", s.X("deleteItem by localId ", Long.valueOf(paramView.getLocalId())));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349789);
  }
  
  private static void a(bm parambm, j paramj)
  {
    AppMethodBeat.i(349779);
    Object localObject1 = (WeImageView)paramj.UH(e.e.profile_music_play_icon);
    Object localObject2 = paramj.context;
    s.s(localObject2, "holder.context");
    s.s(localObject1, "playIcon");
    ((LinearLayout)paramj.UH(e.e.profile_music_post_container)).setVisibility(0);
    paramj.UH(e.e.profile_music_fail_icon).setVisibility(8);
    ((TextView)paramj.UH(e.e.profile_music_posting_text)).setText((CharSequence)((Context)localObject2).getString(e.h.finder_profile_item_uploading));
    ((FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress)).setVisibility(0);
    paramj.UH(e.e.profile_music_retry_container).setVisibility(8);
    ((TextView)paramj.UH(e.e.profile_music_origin_text)).setVisibility(8);
    ((WeImageView)localObject1).setVisibility(8);
    if (parambm.EDt.getFeedObject() != null)
    {
      if (parambm.EDt.isPostFailed())
      {
        parambm = paramj.context;
        s.s(parambm, "holder.context");
        ((LinearLayout)paramj.UH(e.e.profile_music_post_container)).setVisibility(0);
        paramj.UH(e.e.profile_music_fail_icon).setVisibility(0);
        ((TextView)paramj.UH(e.e.profile_music_posting_text)).setText((CharSequence)parambm.getString(e.h.finder_post_tip_failed));
        ((FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress)).setVisibility(8);
        paramj.UH(e.e.profile_music_retry_container).setVisibility(0);
        ((TextView)paramj.UH(e.e.profile_music_origin_text)).setVisibility(8);
        ((WeImageView)localObject1).setVisibility(8);
        AppMethodBeat.o(349779);
        return;
      }
      if ((!parambm.EDt.isPostFailed()) && (!parambm.EDt.isPostFinish())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress)).getProgress(), parambm.eDC() });
        ((ValueAnimator)localObject1).addUpdateListener(new cc..ExternalSyntheticLambda0(paramj));
        localObject2 = ((ValueAnimator)localObject1).setDuration(400L);
        if (localObject2 != null) {
          ((ValueAnimator)localObject2).start();
        }
        paramj.tag = localObject1;
        Log.i("Finder.ProfileMusicConvert", "progress animate: " + ((FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress)).getProgress() + ", " + parambm.eDC());
        AppMethodBeat.o(349779);
        return;
      }
      parambm = parambm.eDz();
      ((LinearLayout)paramj.UH(e.e.profile_music_post_container)).setVisibility(8);
      ((TextView)paramj.UH(e.e.profile_music_origin_text)).setVisibility(0);
      ((TextView)paramj.UH(e.e.profile_music_origin_text)).setText((CharSequence)"");
      ((WeImageView)localObject1).setVisibility(0);
      if (parambm != null)
      {
        parambm = parambm.LXo;
        if (parambm != null)
        {
          parambm = paramj.context.getResources().getString(e.h.finder_profile_music_completion, new Object[] { Integer.valueOf((int)(parambm.ZWP * 100.0F)) });
          s.s(parambm, "holder.context.resources…ompletion * 100).toInt())");
          ((TextView)paramj.UH(e.e.profile_music_origin_text)).setText((CharSequence)parambm);
        }
      }
    }
    AppMethodBeat.o(349779);
  }
  
  private static void a(FinderItem paramFinderItem, j paramj)
  {
    AppMethodBeat.i(349757);
    Object localObject = (dji)kotlin.a.p.oL((List)paramFinderItem.getMediaList());
    if (localObject != null)
    {
      paramFinderItem = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramFinderItem = com.tencent.mm.plugin.finder.loader.p.eCl();
      localObject = new n((dji)localObject, v.FKZ, null, null, 12);
      paramj = paramj.UH(e.e.finder_profile_item_image);
      s.s(paramj, "holder.getView<ImageView…inder_profile_item_image)");
      paramj = (ImageView)paramj;
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramFinderItem.a(localObject, paramj, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    }
    AppMethodBeat.o(349757);
  }
  
  private static final void a(bol parambol, bm parambm, String paramString1, j paramj, String paramString2, View paramView)
  {
    AppMethodBeat.i(349822);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambol);
    localb.cH(parambm);
    localb.cH(paramString1);
    localb.cH(paramj);
    localb.cH(paramString2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambm, "$item");
    s.u(paramString1, "$coverUrl");
    s.u(paramj, "$holder");
    s.u(paramString2, "$songId");
    paramView = new dtj();
    paramView.YqN = com.tencent.mm.ae.d.hF(parambm.feedObject.getFinderObject().id);
    paramView.YqO = parambm.feedObject.getFinderObject().objectNonceId;
    paramView.YqP = paramString1;
    parambm = parambm.feedObject.getFinderObject().contact;
    label185:
    label197:
    label209:
    label221:
    long l;
    label234:
    label247:
    int i;
    if (parambm == null)
    {
      parambm = null;
      paramView.YqQ = parambm;
      if (parambol != null) {
        break label474;
      }
      parambm = null;
      paramView.singerName = parambm;
      if (parambol != null) {
        break label496;
      }
      parambm = null;
      paramView.albumName = parambm;
      if (parambol != null) {
        break label518;
      }
      parambm = null;
      paramView.extraInfo = parambm;
      if (parambol != null) {
        break label540;
      }
      parambm = null;
      paramView.musicGenre = parambm;
      if (parambol != null) {
        break label562;
      }
      l = 0L;
      paramView.issueDate = l;
      if (parambol != null) {
        break label586;
      }
      parambm = null;
      paramView.identification = parambm;
      if (parambol != null) {
        break label608;
      }
      i = 0;
      label260:
      paramView.LNC = i;
      if (parambol != null) {
        break label632;
      }
      parambm = null;
      label273:
      paramView.songName = parambm;
      if (parambol != null) {
        break label654;
      }
      parambm = null;
      label285:
      paramView.songLyric = parambm;
      if (parambol != null) {
        break label676;
      }
      parambm = null;
      label297:
      paramView.RfH = parambm;
      paramView.oPc = paramString1;
      if (parambol != null)
      {
        parambm = parambol.LWI;
        if (parambm != null)
        {
          Log.i("Finder.ProfileMusicConvert", "playOrPauseMusic");
          parambol = k.aeZF;
          parambol = paramj.context;
          s.s(parambol, "holder.context");
          ((com.tencent.mm.plugin.finder.profile.uic.f)k.nq(parambol).q(com.tencent.mm.plugin.finder.profile.uic.f.class)).eJf();
          parambol = ac.FLX;
          s.u(parambm, "musicSongInfo");
          s.u(paramString2, "musicId");
          paramString1 = com.tencent.mm.aw.a.bLn();
          if (paramString1 != null) {
            break label698;
          }
          parambol = null;
          label390:
          if ((parambol == null) || (!Util.isEqual(paramString1.oOv, paramString2))) {
            break label717;
          }
          if (!com.tencent.mm.aw.a.bLk()) {
            break label706;
          }
          parambol = new kn();
          parambol.ioV = 2L;
          parambol.iqr = 8L;
          cp.a(parambol);
          com.tencent.mm.aw.a.bLi();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349822);
      return;
      parambm = parambm.nickname;
      break;
      label474:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label185;
      }
      parambm = parambm.rDl;
      break label185;
      label496:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label197;
      }
      parambm = parambm.albumName;
      break label197;
      label518:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label209;
      }
      parambm = parambm.extraInfo;
      break label209;
      label540:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label221;
      }
      parambm = parambm.ZTA;
      break label221;
      label562:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        l = 0L;
        break label234;
      }
      l = parambm.ZWU;
      break label234;
      label586:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label247;
      }
      parambm = parambm.rDl;
      break label247;
      label608:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        i = 0;
        break label260;
      }
      i = parambm.duration;
      break label260;
      label632:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label273;
      }
      parambm = parambm.songName;
      break label273;
      label654:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label285;
      }
      parambm = parambm.Mcq;
      break label285;
      label676:
      parambm = parambol.LWI;
      if (parambm == null)
      {
        parambm = null;
        break label297;
      }
      parambm = parambm.ZWS;
      break label297;
      label698:
      parambol = paramString1.oOv;
      break label390;
      label706:
      ac.b(parambm, paramString2, paramView);
      continue;
      label717:
      Log.i("FinderMvLogic", "playMusic");
      ac.b(parambm, paramString2, paramView);
    }
  }
  
  private static final void a(j paramj, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(349842);
    s.u(paramj, "$holder");
    FinderPostProgressView localFinderPostProgressView = (FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress);
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(349842);
      throw paramj;
    }
    localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    ((FinderPostProgressView)paramj.UH(e.e.profile_music_upload_progress)).invalidate();
    AppMethodBeat.o(349842);
  }
  
  private static final void b(bm parambm, View paramView)
  {
    AppMethodBeat.i(349801);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambm, "$item");
    ((c)h.az(c.class)).finderPostManager().fy(parambm.EDt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349801);
  }
  
  private static final void e(j paramj, String paramString)
  {
    AppMethodBeat.i(349834);
    s.u(paramj, "$holder");
    s.u(paramString, "$feedId");
    k localk = k.aeZF;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    ((e)k.nq(paramj).q(e.class)).O("mv", 0, paramString);
    AppMethodBeat.o(349834);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349895);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(349895);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_music_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cc
 * JD-Core Version:    0.7.0.1
 */