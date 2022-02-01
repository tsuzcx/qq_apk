package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileFloatBallUIC;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "()V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "isSelf", "item", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "refreshProgress", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLikeArea", "setOrigin", "mvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPostFailed", "context", "Landroid/content/Context;", "setPosting", "Companion", "plugin-finder_release"})
public final class ca
  extends e<bf>
{
  public static final a tFQ;
  private RecyclerView hak;
  public Boolean tFI;
  
  static
  {
    AppMethodBeat.i(243262);
    tFQ = new a((byte)0);
    AppMethodBeat.o(243262);
  }
  
  private static void a(Context paramContext, h paramh, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243259);
    View localView = paramh.Mn(2131306230);
    p.g(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(0);
    localView = paramh.Mn(2131306224);
    p.g(localView, "holder.getView<View>(R.id.profile_music_fail_icon)");
    localView.setVisibility(0);
    localView = paramh.Mn(2131306231);
    p.g(localView, "holder.getView<TextView>…ofile_music_posting_text)");
    ((TextView)localView).setText((CharSequence)paramContext.getString(2131760419));
    paramContext = paramh.Mn(2131306236);
    p.g(paramContext, "holder.getView<FinderPos…le_music_upload_progress)");
    ((FinderPostProgressView)paramContext).setVisibility(8);
    paramContext = paramh.Mn(2131306232);
    p.g(paramContext, "holder.getView<View>(R.i…le_music_retry_container)");
    paramContext.setVisibility(0);
    paramContext = paramh.Mn(2131306227);
    p.g(paramContext, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)paramContext).setVisibility(8);
    paramWeImageView.setVisibility(8);
    AppMethodBeat.o(243259);
  }
  
  private final void a(final bf parambf, final h paramh)
  {
    AppMethodBeat.i(243258);
    Object localObject1 = (WeImageView)paramh.Mn(2131306229);
    Object localObject2 = paramh.getContext();
    p.g(localObject2, "holder.context");
    p.g(localObject1, "playIcon");
    b((Context)localObject2, paramh, (WeImageView)localObject1);
    if (parambf.uOO.getFeedObject() != null)
    {
      if (parambf.uOO.isPostFailed())
      {
        parambf = paramh.getContext();
        p.g(parambf, "holder.context");
        a(parambf, paramh, (WeImageView)localObject1);
        AppMethodBeat.o(243258);
        return;
      }
      if (parambf.dkT())
      {
        localObject2 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)paramh.Mn(2131306236)).getProgress(), parambf.dkU() });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, parambf, paramh, (WeImageView)localObject1));
        localObject1 = ((ValueAnimator)localObject2).setDuration(400L);
        if (localObject1 != null) {
          ((ValueAnimator)localObject1).start();
        }
        paramh.setTag(localObject2);
        Log.i("Finder.ProfileMusicConvert", "progress animate: " + ((FinderPostProgressView)paramh.Mn(2131306236)).getProgress() + ", " + parambf.dkU());
        AppMethodBeat.o(243258);
        return;
      }
      a(parambf.dkQ(), paramh, (WeImageView)localObject1);
    }
    AppMethodBeat.o(243258);
  }
  
  private static void a(FinderItem paramFinderItem, h paramh)
  {
    AppMethodBeat.i(243257);
    Object localObject = (cjl)j.kt((List)paramFinderItem.getMediaList());
    if (localObject != null)
    {
      paramFinderItem = m.uJa;
      paramFinderItem = m.djY();
      localObject = new k((cjl)localObject, x.vEo, null, null, 12);
      paramh = paramh.Mn(2131301449);
      p.g(paramh, "holder.getView<ImageView…inder_profile_item_image)");
      paramh = (ImageView)paramh;
      m localm = m.uJa;
      paramFinderItem.a(localObject, paramh, m.a(m.a.uJb));
      AppMethodBeat.o(243257);
      return;
    }
    AppMethodBeat.o(243257);
  }
  
  private static void a(axw paramaxw, h paramh, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243261);
    View localView = paramh.Mn(2131306230);
    p.g(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(8);
    localView = paramh.Mn(2131306227);
    p.g(localView, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)localView).setVisibility(0);
    localView = paramh.Mn(2131306227);
    p.g(localView, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)localView).setText((CharSequence)"");
    paramWeImageView.setVisibility(0);
    if (paramaxw != null)
    {
      paramaxw = paramaxw.ApI;
      if (paramaxw != null)
      {
        Log.i("Finder.ProfileMusicConvert", "setOrigin :" + paramaxw.LIe);
        paramWeImageView = paramh.getContext();
        p.g(paramWeImageView, "holder.context");
        paramaxw = paramWeImageView.getResources().getString(2131760471, new Object[] { Integer.valueOf((int)(paramaxw.LIe * 100.0F)) });
        p.g(paramaxw, "holder.context.resources…iginality * 100).toInt())");
        paramh = paramh.Mn(2131306227);
        p.g(paramh, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView)paramh).setText((CharSequence)paramaxw);
        AppMethodBeat.o(243261);
        return;
      }
    }
    AppMethodBeat.o(243261);
  }
  
  private static void b(Context paramContext, h paramh, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243260);
    View localView = paramh.Mn(2131306230);
    p.g(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(0);
    localView = paramh.Mn(2131306224);
    p.g(localView, "holder.getView<View>(R.id.profile_music_fail_icon)");
    localView.setVisibility(8);
    localView = paramh.Mn(2131306231);
    p.g(localView, "holder.getView<TextView>…ofile_music_posting_text)");
    ((TextView)localView).setText((CharSequence)paramContext.getString(2131760466));
    paramContext = paramh.Mn(2131306236);
    p.g(paramContext, "holder.getView<FinderPos…le_music_upload_progress)");
    ((FinderPostProgressView)paramContext).setVisibility(0);
    paramContext = paramh.Mn(2131306232);
    p.g(paramContext, "holder.getView<View>(R.i…le_music_retry_container)");
    paramContext.setVisibility(8);
    paramContext = paramh.Mn(2131306227);
    p.g(paramContext, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)paramContext).setVisibility(8);
    paramWeImageView.setVisibility(8);
    AppMethodBeat.o(243260);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243255);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    this.hak = paramRecyclerView;
    AppMethodBeat.o(243255);
  }
  
  public final int getLayoutId()
  {
    return 2131494591;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bf parambf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243250);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tFR.uOO;
      localObject = c.vGN;
      c.a.FS(this.tFR.uOO.getLocalId());
      localObject = c.vGN;
      c.a.FV(paramView.getLocalId());
      localObject = new hg();
      ((hg)localObject).dLJ.localId = paramView.getLocalId();
      EventCenter.instance.publish((IEvent)localObject);
      Log.i("Finder.ProfileMusicConvert", "deleteItem by localId " + paramView.getLocalId());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243250);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(bf parambf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243251);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.finder.upload.g.vSJ;
      com.tencent.mm.plugin.finder.upload.g.dBa().t(this.tFR.uOO);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243251);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(bf parambf, String paramString1, axw paramaxw, h paramh, String paramString2) {}
    
    public final void onClick(View paramView)
    {
      Object localObject1 = null;
      AppMethodBeat.i(243252);
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
      localObject2 = new css();
      ((css)localObject2).Ktn = com.tencent.mm.ac.d.zs(this.tFR.feedObject.getFinderObject().id);
      ((css)localObject2).Kto = this.tFR.feedObject.getFinderObject().objectNonceId;
      ((css)localObject2).Ktp = this.tra;
      paramView = this.tFR.feedObject.getFinderObject().contact;
      label149:
      label178:
      label207:
      label236:
      long l;
      label265:
      label294:
      int i;
      label323:
      label352:
      label381:
      axy localaxy;
      label410:
      String str;
      if (paramView != null)
      {
        paramView = paramView.nickname;
        ((css)localObject2).Ktq = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label601;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label601;
        }
        paramView = paramView.lDR;
        ((css)localObject2).singerName = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label606;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label606;
        }
        paramView = paramView.albumName;
        ((css)localObject2).albumName = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label611;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label611;
        }
        paramView = paramView.extraInfo;
        ((css)localObject2).extraInfo = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label616;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label616;
        }
        paramView = paramView.LIi;
        ((css)localObject2).musicGenre = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label621;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label621;
        }
        l = paramView.LIk;
        ((css)localObject2).issueDate = l;
        paramView = this.tFS;
        if (paramView == null) {
          break label626;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label626;
        }
        paramView = paramView.lDR;
        ((css)localObject2).identification = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label631;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label631;
        }
        i = paramView.duration;
        ((css)localObject2).Alz = i;
        paramView = this.tFS;
        if (paramView == null) {
          break label636;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label636;
        }
        paramView = paramView.BPc;
        ((css)localObject2).BPc = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label641;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label641;
        }
        paramView = paramView.LIh;
        ((css)localObject2).songLyric = paramView;
        paramView = this.tFS;
        if (paramView == null) {
          break label646;
        }
        paramView = paramView.Aqo;
        if (paramView == null) {
          break label646;
        }
        paramView = paramView.Djf;
        ((css)localObject2).EsK = paramView;
        ((css)localObject2).jfz = this.tra;
        paramView = this.tFS;
        if (paramView != null)
        {
          localaxy = paramView.Aqo;
          if (localaxy != null)
          {
            Log.i("Finder.ProfileMusicConvert", "playOrPauseMusic");
            paramView = com.tencent.mm.ui.component.a.PRN;
            paramView = this.qhp.getContext();
            p.g(paramView, "holder.context");
            ((FinderProfileFloatBallUIC)com.tencent.mm.ui.component.a.ko(paramView).get(FinderProfileFloatBallUIC.class)).UpW = false;
            ((com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(false);
            paramView = ac.vER;
            p.g(localaxy, "it");
            str = this.tFT;
            p.h(localaxy, "musicSongInfo");
            p.h(str, "musicId");
            f localf = com.tencent.mm.ay.a.bef();
            paramView = localObject1;
            if (localf != null) {
              paramView = localf.jeV;
            }
            if ((paramView == null) || (!Util.isEqual(localf.jeV, str))) {
              break label663;
            }
            if (!com.tencent.mm.ay.a.bec()) {
              break label651;
            }
            com.tencent.mm.ay.a.bea();
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243252);
        return;
        paramView = null;
        break;
        label601:
        paramView = null;
        break label149;
        label606:
        paramView = null;
        break label178;
        label611:
        paramView = null;
        break label207;
        label616:
        paramView = null;
        break label236;
        label621:
        l = 0L;
        break label265;
        label626:
        paramView = null;
        break label294;
        label631:
        i = 0;
        break label323;
        label636:
        paramView = null;
        break label352;
        label641:
        paramView = null;
        break label381;
        label646:
        paramView = null;
        break label410;
        label651:
        ac.b(localaxy, str, (css)localObject2);
        continue;
        label663:
        Log.i("FinderMvLogic", "playMusic");
        ac.b(localaxy, str, (css)localObject2);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(h paramh, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(243253);
      Object localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      ((FinderProfileEduUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(FinderProfileEduUIC.class)).gP("mv", this.tzi);
      AppMethodBeat.o(243253);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$refreshProgress$1$1"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(ca paramca, bf parambf, h paramh, WeImageView paramWeImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(243254);
      FinderPostProgressView localFinderPostProgressView = (FinderPostProgressView)paramh.Mn(2131306236);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(243254);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      ((FinderPostProgressView)paramh.Mn(2131306236)).invalidate();
      AppMethodBeat.o(243254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ca
 * JD-Core Version:    0.7.0.1
 */