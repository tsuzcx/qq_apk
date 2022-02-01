package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.bi;
import com.tencent.mm.plugin.finder.profile.uic.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "()V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getLayoutId", "", "isSelf", "item", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "refreshProgress", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLikeArea", "setOrigin", "mvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPostFailed", "context", "Landroid/content/Context;", "setPosting", "Companion", "plugin-finder_release"})
public final class ce
  extends e<bi>
{
  public static final a xox;
  private RecyclerView jLl;
  public Boolean xor;
  
  static
  {
    AppMethodBeat.i(243401);
    xox = new a((byte)0);
    AppMethodBeat.o(243401);
  }
  
  private static void a(Context paramContext, i parami, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243398);
    View localView = parami.RD(b.f.profile_music_post_container);
    p.j(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(0);
    localView = parami.RD(b.f.profile_music_fail_icon);
    p.j(localView, "holder.getView<View>(R.id.profile_music_fail_icon)");
    localView.setVisibility(0);
    localView = parami.RD(b.f.profile_music_posting_text);
    p.j(localView, "holder.getView<TextView>…ofile_music_posting_text)");
    ((TextView)localView).setText((CharSequence)paramContext.getString(b.j.finder_post_tip_failed));
    paramContext = parami.RD(b.f.profile_music_upload_progress);
    p.j(paramContext, "holder.getView<FinderPos…le_music_upload_progress)");
    ((FinderPostProgressView)paramContext).setVisibility(8);
    paramContext = parami.RD(b.f.profile_music_retry_container);
    p.j(paramContext, "holder.getView<View>(R.i…le_music_retry_container)");
    paramContext.setVisibility(0);
    paramContext = parami.RD(b.f.profile_music_origin_text);
    p.j(paramContext, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)paramContext).setVisibility(8);
    paramWeImageView.setVisibility(8);
    AppMethodBeat.o(243398);
  }
  
  private final void a(final bi parambi, final i parami)
  {
    AppMethodBeat.i(243397);
    Object localObject1 = (WeImageView)parami.RD(b.f.profile_music_play_icon);
    Object localObject2 = parami.getContext();
    p.j(localObject2, "holder.context");
    p.j(localObject1, "playIcon");
    b((Context)localObject2, parami, (WeImageView)localObject1);
    if (parambi.zBk.getFeedObject() != null)
    {
      if (parambi.zBk.isPostFailed())
      {
        parambi = parami.getContext();
        p.j(parambi, "holder.context");
        a(parambi, parami, (WeImageView)localObject1);
        AppMethodBeat.o(243397);
        return;
      }
      if (parambi.dKT())
      {
        localObject2 = ValueAnimator.ofInt(new int[] { ((FinderPostProgressView)parami.RD(b.f.profile_music_upload_progress)).getProgress(), parambi.dKU() });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, parambi, parami, (WeImageView)localObject1));
        localObject1 = ((ValueAnimator)localObject2).setDuration(400L);
        if (localObject1 != null) {
          ((ValueAnimator)localObject1).start();
        }
        parami.setTag(localObject2);
        Log.i("Finder.ProfileMusicConvert", "progress animate: " + ((FinderPostProgressView)parami.RD(b.f.profile_music_upload_progress)).getProgress() + ", " + parambi.dKU());
        AppMethodBeat.o(243397);
        return;
      }
      a(parambi.dKQ(), parami, (WeImageView)localObject1);
    }
    AppMethodBeat.o(243397);
  }
  
  private static void a(FinderItem paramFinderItem, i parami)
  {
    AppMethodBeat.i(243396);
    Object localObject = (csg)j.lp((List)paramFinderItem.getMediaList());
    if (localObject != null)
    {
      paramFinderItem = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderItem = com.tencent.mm.plugin.finder.loader.t.dJe();
      localObject = new r((csg)localObject, u.Alz, null, null, 12);
      parami = parami.RD(b.f.finder_profile_item_image);
      p.j(parami, "holder.getView<ImageView…inder_profile_item_image)");
      parami = (ImageView)parami;
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramFinderItem.a(localObject, parami, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU));
      AppMethodBeat.o(243396);
      return;
    }
    AppMethodBeat.o(243396);
  }
  
  private static void a(bdp parambdp, i parami, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243400);
    View localView = parami.RD(b.f.profile_music_post_container);
    p.j(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(8);
    localView = parami.RD(b.f.profile_music_origin_text);
    p.j(localView, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)localView).setVisibility(0);
    localView = parami.RD(b.f.profile_music_origin_text);
    p.j(localView, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)localView).setText((CharSequence)"");
    paramWeImageView.setVisibility(0);
    if (parambdp != null)
    {
      parambdp = parambdp.Gbq;
      if (parambdp != null)
      {
        paramWeImageView = parami.getContext();
        p.j(paramWeImageView, "holder.context");
        parambdp = paramWeImageView.getResources().getString(b.j.finder_profile_music_completion, new Object[] { Integer.valueOf((int)(parambdp.SOI * 100.0F)) });
        p.j(parambdp, "holder.context.resources…ompletion * 100).toInt())");
        parami = parami.RD(b.f.profile_music_origin_text);
        p.j(parami, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView)parami).setText((CharSequence)parambdp);
        AppMethodBeat.o(243400);
        return;
      }
    }
    AppMethodBeat.o(243400);
  }
  
  private static void b(Context paramContext, i parami, WeImageView paramWeImageView)
  {
    AppMethodBeat.i(243399);
    View localView = parami.RD(b.f.profile_music_post_container);
    p.j(localView, "holder.getView<LinearLay…ile_music_post_container)");
    ((LinearLayout)localView).setVisibility(0);
    localView = parami.RD(b.f.profile_music_fail_icon);
    p.j(localView, "holder.getView<View>(R.id.profile_music_fail_icon)");
    localView.setVisibility(8);
    localView = parami.RD(b.f.profile_music_posting_text);
    p.j(localView, "holder.getView<TextView>…ofile_music_posting_text)");
    ((TextView)localView).setText((CharSequence)paramContext.getString(b.j.finder_profile_item_uploading));
    paramContext = parami.RD(b.f.profile_music_upload_progress);
    p.j(paramContext, "holder.getView<FinderPos…le_music_upload_progress)");
    ((FinderPostProgressView)paramContext).setVisibility(0);
    paramContext = parami.RD(b.f.profile_music_retry_container);
    p.j(paramContext, "holder.getView<View>(R.i…le_music_retry_container)");
    paramContext.setVisibility(8);
    paramContext = parami.RD(b.f.profile_music_origin_text);
    p.j(paramContext, "holder.getView<TextView>…rofile_music_origin_text)");
    ((TextView)paramContext).setVisibility(8);
    paramWeImageView.setVisibility(8);
    AppMethodBeat.o(243399);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(243391);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    this.jLl = paramRecyclerView;
    AppMethodBeat.o(243391);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_profile_music_item;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(bi parambi) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(222643);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.xoy.zBk;
      localObject = c.AnK;
      c.a.MS(this.xoy.zBk.getLocalId());
      localObject = c.AnK;
      c.a.MV(paramView.getLocalId());
      localObject = new hn();
      ((hn)localObject).fEy.localId = paramView.getLocalId();
      EventCenter.instance.publish((IEvent)localObject);
      Log.i("Finder.ProfileMusicConvert", "deleteItem by localId " + paramView.getLocalId());
      a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(222643);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(285341);
      Object localObject = g.Xox;
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      ((f)g.lm((Context)localObject).i(f.class)).M("mv", 0, this.xgT);
      AppMethodBeat.o(285341);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$refreshProgress$1$1"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(ce paramce, bi parambi, i parami, WeImageView paramWeImageView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(289627);
      FinderPostProgressView localFinderPostProgressView = (FinderPostProgressView)parami.RD(b.f.profile_music_upload_progress);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(289627);
        throw paramValueAnimator;
      }
      localFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
      ((FinderPostProgressView)parami.RD(b.f.profile_music_upload_progress)).invalidate();
      AppMethodBeat.o(289627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ce
 * JD-Core Version:    0.7.0.1
 */