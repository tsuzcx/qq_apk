package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzl;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.i;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderFeedRingtoneUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "isRemindMeetCondition", "", "isSetRingtoneMeetCondition", "bindRingtoneData", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "checkSetRingtoneAndRemind", "getContentView", "Landroid/view/View;", "hide", "fromUser", "isNeedShow", "isShowRingtoneInfo", "onBindView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportClickRingtone", "feedId", "", "songId", "", "reportSetRingtoneSuccess", "reportShowRingtone", "show", "showRingtoneInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends bh
  implements ai
{
  public static final a GPx;
  private boolean GPy;
  private boolean GPz;
  
  static
  {
    AppMethodBeat.i(337722);
    GPx = new a((byte)0);
    AppMethodBeat.o(337722);
  }
  
  public u(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337678);
    AppMethodBeat.o(337678);
  }
  
  private static final void a(View paramView, final u paramu, final j paramj)
  {
    AppMethodBeat.i(337690);
    s.u(paramView, "$ringtoneLayout");
    s.u(paramu, "this$0");
    s.u(paramj, "$holder");
    paramView.animate().alpha(1.0F).setDuration(250L).setListener((Animator.AnimatorListener)new d(paramView, paramu, paramj)).start();
    AppMethodBeat.o(337690);
  }
  
  private static final void a(final u paramu, final BaseFinderFeed paramBaseFinderFeed, final dzl paramdzl, j paramj, TextView paramTextView, final View paramView)
  {
    AppMethodBeat.i(337707);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramu);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBaseFinderFeed);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramdzl);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramTextView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramu, "this$0");
    s.u(paramBaseFinderFeed, "$item");
    s.u(paramj, "$holder");
    long l = paramBaseFinderFeed.bZA();
    if (paramdzl == null)
    {
      paramView = null;
      localObject2 = new JSONObject();
    }
    label164:
    label315:
    try
    {
      ((JSONObject)localObject2).put("feedid", com.tencent.mm.ae.d.hF(l));
      ((JSONObject)localObject2).put("feed_source", 0);
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = "";
      }
      ((JSONObject)localObject2).put("songid", localObject1);
    }
    catch (JSONException paramView)
    {
      label194:
      break label164;
    }
    paramView = bb.FuK;
    paramView = as.GSQ;
    paramView = as.a.hu((Context)paramu.getContext());
    if (paramView == null)
    {
      paramView = null;
      bb.a(paramView, "set_song_tips", 1, (JSONObject)localObject2);
      paramView = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
      paramView.fiH();
      paramj = paramj.context;
      if (!(paramj instanceof MMActivity)) {
        break label315;
      }
    }
    for (paramj = (MMActivity)paramj;; paramj = null)
    {
      if (paramj != null)
      {
        localObject1 = al.GhB;
        al.a((AppCompatActivity)paramj, paramBaseFinderFeed, (kotlin.g.a.b)new b(paramTextView, paramu, paramBaseFinderFeed, paramdzl, paramView));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(337707);
      return;
      paramView = paramdzl.abeF;
      break;
      paramView = paramView.fou();
      break label194;
    }
  }
  
  public final boolean R(j paramj)
  {
    AppMethodBeat.i(337798);
    s.u(paramj, "holder");
    if (S(paramj) == null)
    {
      AppMethodBeat.o(337798);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eYC().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(337798);
      return true;
    }
    paramj = paramj.CSA;
    int k;
    int m;
    label131:
    int i;
    if ((paramj instanceof BaseFinderFeed))
    {
      paramj = (BaseFinderFeed)paramj;
      if (paramj == null) {
        break label282;
      }
      localObject = l.Gdj;
      k = l.fek().v(paramj.feedObject.getFeedObject());
      m = paramj.feedObject.field_finderObject.ringtone_count;
      localObject = paramj.feedObject.getFeedObject().objectDesc;
      if (localObject != null) {
        break label241;
      }
      localObject = null;
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhX, 30);
      int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhY, 10);
      if (localObject != null) {
        break label251;
      }
      localObject = null;
      label169:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label261;
      }
      i = j;
      label182:
      if (k >= 10000) {
        break label264;
      }
      if (m <= i) {
        break label290;
      }
      i = 1;
    }
    for (;;)
    {
      localObject = av.GiL;
      if ((av.p(paramj)) && (i != 0) && (this.GPy) && (this.GPz))
      {
        AppMethodBeat.o(337798);
        return true;
        paramj = null;
        break;
        label241:
        localObject = ((FinderObjectDesc)localObject).originalsound_info;
        break label131;
        label251:
        localObject = ((dzl)localObject).name;
        break label169;
        label261:
        break label182;
        label264:
        if (m <= i * (k / 10000)) {
          break label290;
        }
        i = 1;
        continue;
      }
      label282:
      AppMethodBeat.o(337798);
      return false;
      label290:
      i = 0;
    }
  }
  
  public final View S(j paramj)
  {
    AppMethodBeat.i(337807);
    s.u(paramj, "holder");
    View localView = paramj.UH(e.e.finder_ringtone_layout);
    Object localObject = localView;
    if (localView == null)
    {
      paramj = (ViewStub)paramj.UH(e.e.finder_ringtone_vs);
      if (paramj != null) {
        break label66;
      }
    }
    label66:
    for (paramj = null;; paramj = paramj.inflate())
    {
      localObject = paramj;
      if (paramj != null)
      {
        paramj.setVisibility(8);
        localObject = paramj;
      }
      AppMethodBeat.o(337807);
      return localObject;
    }
  }
  
  public final void U(j paramj)
  {
    StringBuilder localStringBuilder2 = null;
    StringBuilder localStringBuilder1 = null;
    Object localObject4 = null;
    AppMethodBeat.i(337776);
    if (S(paramj) == null)
    {
      AppMethodBeat.o(337776);
      return;
    }
    Object localObject1 = paramj.CSA;
    if ((localObject1 instanceof BaseFinderFeed)) {}
    for (Object localObject2 = (BaseFinderFeed)localObject1; localObject2 == null; localObject2 = null)
    {
      AppMethodBeat.o(337776);
      return;
    }
    TextView localTextView = (TextView)paramj.UH(e.e.original_sound_tv);
    String str1 = paramj.context.getResources().getString(e.h.finder_video_original_sound);
    s.s(str1, "holder.context.resources…der_video_original_sound)");
    String str2 = paramj.context.getResources().getString(e.h.finder_original_sound);
    s.s(str2, "holder.context.resources…ng.finder_original_sound)");
    localObject1 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectDesc;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject3 = null;
      if (localObject3 != null) {
        break label397;
      }
      localObject1 = null;
      label146:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label415;
      }
      localStringBuilder1 = new StringBuilder().append(str1).append("「");
      if (localObject3 != null) {
        break label406;
      }
      localObject1 = localObject4;
      label184:
      localObject1 = (String)localObject1;
      s.s(localObject1, "{\n            StringBuil…tle).toString()\n        }");
      label201:
      localTextView.setText((CharSequence)localObject1);
      localTextView.requestLayout();
      localObject1 = (TextView)paramj.UH(e.e.set_ringtone_tv);
      ((TextView)localObject1).setOnClickListener(new u..ExternalSyntheticLambda0(this, (BaseFinderFeed)localObject2, (dzl)localObject3, paramj, (TextView)localObject1));
      localObject3 = al.GhB;
      if (!al.m((BaseFinderFeed)localObject2)) {
        break label684;
      }
      ((TextView)localObject1).setBackground(getContext().getResources().getDrawable(e.d.finder_ringtone_container_setting));
      ((TextView)localObject1).setText((CharSequence)getContext().getResources().getString(e.h.finder_ringtone_setting));
      ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_8));
    }
    for (;;)
    {
      localObject1 = (TextView)paramj.UH(e.e.ringtone_count_tv);
      localObject2 = r.TP(((BaseFinderFeed)localObject2).feedObject.field_finderObject.ringtone_count);
      ((TextView)localObject1).setText((CharSequence)getContext().getResources().getString(e.h.finder_ringtone_count, new Object[] { localObject2 }));
      ((TextView)paramj.UH(e.e.ringtone_info_tv)).setText((CharSequence)"」");
      AppMethodBeat.o(337776);
      return;
      localObject3 = ((FinderObjectDesc)localObject1).originalsound_info;
      break;
      label397:
      localObject1 = ((dzl)localObject3).title;
      break label146;
      label406:
      localObject1 = ((dzl)localObject3).title;
      break label184;
      label415:
      if (localObject3 == null)
      {
        localObject1 = null;
        label422:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label498;
        }
        localStringBuilder1 = new StringBuilder().append(str1).append("「");
        if (localObject3 != null) {
          break label489;
        }
      }
      label489:
      for (localObject1 = localStringBuilder2;; localObject1 = ((dzl)localObject3).abeE)
      {
        localObject1 = (String)localObject1;
        s.s(localObject1, "{\n            StringBuil…ame).toString()\n        }");
        break;
        localObject1 = ((dzl)localObject3).abeE;
        break label422;
      }
      label498:
      if (localObject3 == null)
      {
        localObject1 = null;
        label505:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label637;
        }
        if (localObject3 != null) {
          break label610;
        }
        localObject1 = null;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label637;
        }
        localStringBuilder2 = new StringBuilder().append(str1).append("「");
        if (localObject3 != null) {
          break label619;
        }
        localObject1 = null;
        localStringBuilder2 = localStringBuilder2.append((String)localObject1).append(" - ");
        if (localObject3 != null) {
          break label628;
        }
      }
      label522:
      label559:
      label610:
      label619:
      label628:
      for (localObject1 = localStringBuilder1;; localObject1 = ((dzl)localObject3).ZTx)
      {
        localObject1 = (String)localObject1;
        s.s(localObject1, "{\n            StringBuil…ame).toString()\n        }");
        break;
        localObject1 = ((dzl)localObject3).name;
        break label505;
        localObject1 = ((dzl)localObject3).ZTx;
        break label522;
        localObject1 = ((dzl)localObject3).name;
        break label559;
      }
      label637:
      localObject1 = str1 + "「" + ((BaseFinderFeed)localObject2).feedObject.getNickName() + str2;
      s.s(localObject1, "{\n            StringBuil…und).toString()\n        }");
      break label201;
      label684:
      ((TextView)localObject1).setBackground(getContext().getResources().getDrawable(e.d.finder_ringtone_shape));
      ((TextView)localObject1).setText((CharSequence)getContext().getResources().getString(e.h.finder_share_ringtone_title));
      ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.UN_BW_0_Alpha_0_9));
    }
  }
  
  public final void d(j paramj, boolean paramBoolean)
  {
    Object localObject3 = null;
    AppMethodBeat.i(337760);
    s.u(paramj, "holder");
    long l = System.currentTimeMillis();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adib, Long.valueOf(l));
    View localView = S(paramj);
    Object localObject2;
    label95:
    label109:
    JSONObject localJSONObject;
    if (localView != null)
    {
      localObject1 = paramj.CSA;
      if (!(localObject1 instanceof BaseFinderFeed)) {
        break label245;
      }
      localObject1 = (BaseFinderFeed)localObject1;
      if (localObject1 != null)
      {
        localObject2 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject().objectDesc;
        if (localObject2 != null) {
          break label251;
        }
        localObject2 = null;
        l = ((BaseFinderFeed)localObject1).bZA();
        if (localObject2 != null) {
          break label261;
        }
        localObject1 = null;
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("feedid", com.tencent.mm.ae.d.hF(l));
      localJSONObject.put("feed_source", 0);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localJSONObject.put("songid", localObject2);
    }
    catch (JSONException localJSONException)
    {
      label162:
      break label162;
    }
    Object localObject1 = bb.FuK;
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)getContext());
    if (localObject1 == null) {}
    for (localObject1 = localObject3;; localObject1 = ((as)localObject1).fou())
    {
      bb.a((bui)localObject1, "set_song_tips", 0, localJSONObject);
      localView.setVisibility(0);
      localView.setAlpha(0.0F);
      com.tencent.threadpool.h.ahAA.o(new u..ExternalSyntheticLambda1(localView, this, paramj), 150L);
      AppMethodBeat.o(337760);
      return;
      label245:
      localObject1 = null;
      break;
      label251:
      localObject2 = ((FinderObjectDesc)localObject2).originalsound_info;
      break label95;
      label261:
      localObject1 = ((dzl)localObject2).abeF;
      break label109;
    }
  }
  
  public final void e(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(337784);
    s.u(paramj, "holder");
    paramj = S(paramj);
    if (paramj == null)
    {
      AppMethodBeat.o(337784);
      return;
    }
    paramj.setAlpha(1.0F);
    paramj.animate().alpha(0.0F).setDuration(250L).setListener((Animator.AnimatorListener)new c(paramj)).start();
    AppMethodBeat.o(337784);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(337751);
    super.onCreate(paramBundle);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adhZ, 14);
    int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adia, 1);
    long l1 = System.currentTimeMillis();
    paramBundle = Calendar.getInstance();
    paramBundle.setTimeInMillis(l1);
    paramBundle.set(11, 0);
    paramBundle.set(12, 0);
    paramBundle.set(13, 0);
    paramBundle.set(14, 0);
    l1 = paramBundle.getTimeInMillis();
    long l2 = com.tencent.mm.plugin.ringtone.d.gOt();
    if (l2 != 0L)
    {
      paramBundle.setTimeInMillis(l2);
      paramBundle.set(11, 0);
      paramBundle.set(12, 0);
      paramBundle.set(13, 0);
      paramBundle.set(14, 0);
      l2 = paramBundle.getTimeInMillis();
      if ((i != 0) && (l1 - l2 < i)) {}
    }
    for (this.GPy = true;; this.GPy = true)
    {
      l2 = com.tencent.mm.kernel.h.baE().ban().a(at.a.adib, 0L);
      if (l2 == 0L) {
        break;
      }
      paramBundle.setTimeInMillis(l2);
      paramBundle.set(11, 0);
      paramBundle.set(12, 0);
      paramBundle.set(13, 0);
      paramBundle.set(14, 0);
      l2 = paramBundle.getTimeInMillis();
      if ((i != 0) && (l1 - l2 < j)) {
        break label263;
      }
      this.GPz = true;
      AppMethodBeat.o(337751);
      return;
    }
    this.GPz = true;
    label263:
    AppMethodBeat.o(337751);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC$Companion;", "", "()V", "EID_SET_SONG_TIPS", "", "FEED_ENTRANCE_DIRECT", "", "FEED_ENTRANCE_FORWARD", "FEED_SOURCE_OTHER", "FEED_SOURCE_RINGTONE", "REPORT_ENTRANCE", "REPORT_FEED_ID", "REPORT_FEED_SOURCE", "REPORT_SONG_ID", "RINGTONE_COUNT_THRESHOLD", "RINGTONE_COUNT_THRESHOLD_WITH_SONG_NAME", "RINGTONE_DAY_COUNT", "RINGTONE_LIKE_COUNT", "RINGTONE_NOTIFY_COUNT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSetRingtoneSuccess", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(TextView paramTextView, u paramu, BaseFinderFeed paramBaseFinderFeed, dzl paramdzl, FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC$hide$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.finder.animation.a
  {
    c(View paramView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338635);
      this.GPD.setAlpha(1.0F);
      this.GPD.setVisibility(8);
      AppMethodBeat.o(338635);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC$showRingtoneInfo$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.finder.animation.a
  {
    d(View paramView, u paramu, j paramj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(338639);
      this.GPD.setAlpha(1.0F);
      paramu.ab(paramj);
      AppMethodBeat.o(338639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.u
 * JD-Core Version:    0.7.0.1
 */