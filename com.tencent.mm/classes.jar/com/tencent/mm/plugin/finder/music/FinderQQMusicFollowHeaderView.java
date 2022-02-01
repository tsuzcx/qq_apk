package com.tencent.mm.plugin.finder.music;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coverImageUrl", "Landroid/widget/ImageView;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "followBtn", "Landroid/view/View;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "musicPlayEventListener", "com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView$musicPlayEventListener$1;", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "songId", "", "topicFollowHelper", "Lcom/tencent/mm/plugin/finder/music/FinderTopicFollowHelper;", "getSongId", "initView", "", "onAttachedToWindow", "onDetachedFromWindow", "onFollow", "onPause", "onPlay", "onViewPause", "onWindowFocusChanged", "hasWindowFocus", "", "playOrPause", "refreshView", "flag", "setTopicFollowHelper", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderQQMusicFollowHeaderView
  extends FrameLayout
{
  public static final a EEZ;
  private FinderObject ABJ;
  WeImageView DPY;
  private ImageView EFa;
  private c EFb;
  private final musicPlayEventListener.1 EFc;
  private String mLQ;
  private bqj musicInfo;
  private View yEO;
  
  static
  {
    AppMethodBeat.i(330969);
    EEZ = new a((byte)0);
    AppMethodBeat.o(330969);
  }
  
  public FinderQQMusicFollowHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(330873);
    this.mLQ = "";
    this.EFc = new IListener(com.tencent.mm.app.f.hfK) {};
    ci(paramContext);
    AppMethodBeat.o(330873);
  }
  
  public FinderQQMusicFollowHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(330877);
    this.mLQ = "";
    this.EFc = new IListener(com.tencent.mm.app.f.hfK) {};
    ci(paramContext);
    AppMethodBeat.o(330877);
  }
  
  public FinderQQMusicFollowHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330880);
    this.mLQ = "";
    this.EFc = new IListener(com.tencent.mm.app.f.hfK) {};
    ci(paramContext);
    AppMethodBeat.o(330880);
  }
  
  private static final void a(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(330953);
    kotlin.g.b.s.u(paramFinderQQMusicFollowHeaderView, "this$0");
    Intent localIntent = new Intent();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      paramFinderQQMusicFollowHeaderView = paramFinderQQMusicFollowHeaderView.ABJ;
      if (paramFinderQQMusicFollowHeaderView != null) {
        long l = paramFinderQQMusicFollowHeaderView.refObjectId;
      }
      AppMethodBeat.o(330953);
      return;
      localIntent.putExtra("key_finder_post_router", 2);
      continue;
      localIntent.putExtra("key_finder_post_router", 3);
    }
  }
  
  private static final void a(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView, View paramView)
  {
    AppMethodBeat.i(330913);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderQQMusicFollowHeaderView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderQQMusicFollowHeaderView, "this$0");
    paramFinderQQMusicFollowHeaderView.eDV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330913);
  }
  
  private static final void a(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView, FinderObject paramFinderObject, View paramView)
  {
    AppMethodBeat.i(330923);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderQQMusicFollowHeaderView);
    localb.cH(paramFinderObject);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderQQMusicFollowHeaderView, "this$0");
    paramView = paramFinderQQMusicFollowHeaderView.EFb;
    paramFinderQQMusicFollowHeaderView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("topicFollowHelper");
      paramFinderQQMusicFollowHeaderView = null;
    }
    paramFinderQQMusicFollowHeaderView.o(paramFinderObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330923);
  }
  
  private static final void a(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView, FinderObject paramFinderObject, bqj parambqj, View paramView)
  {
    AppMethodBeat.i(330939);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderQQMusicFollowHeaderView);
    localb.cH(paramFinderObject);
    localb.cH(parambqj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderQQMusicFollowHeaderView, "this$0");
    kotlin.g.b.s.u(parambqj, "$musicInfo");
    paramFinderQQMusicFollowHeaderView.a(paramFinderObject, parambqj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330939);
  }
  
  private final void a(FinderObject paramFinderObject, bqj parambqj)
  {
    AppMethodBeat.i(330899);
    String str2 = n(paramFinderObject);
    dtj localdtj = new dtj();
    long l;
    if (paramFinderObject == null)
    {
      l = 0L;
      localdtj.YqN = com.tencent.mm.ae.d.hF(l);
      if (paramFinderObject != null) {
        break label175;
      }
      paramFinderObject = "";
    }
    for (;;)
    {
      localdtj.YqO = paramFinderObject;
      localdtj.YqP = parambqj.ZYo;
      localdtj.YqQ = "";
      localdtj.singerName = "";
      localdtj.albumName = parambqj.albumName;
      localdtj.LNC = parambqj.ZYs;
      localdtj.songName = parambqj.name;
      localdtj.RfH = parambqj.ZYo;
      localdtj.oPc = parambqj.ZYo;
      paramFinderObject = k.aeZF;
      paramFinderObject = getContext();
      kotlin.g.b.s.s(paramFinderObject, "context");
      ((com.tencent.mm.plugin.finder.profile.uic.f)k.nq(paramFinderObject).q(com.tencent.mm.plugin.finder.profile.uic.f.class)).eJf();
      paramFinderObject = aj.FMk;
      aj.a(parambqj, str2, localdtj);
      AppMethodBeat.o(330899);
      return;
      l = paramFinderObject.id;
      break;
      label175:
      String str1 = paramFinderObject.objectNonceId;
      paramFinderObject = str1;
      if (str1 == null) {
        paramFinderObject = "";
      }
    }
  }
  
  private static final void b(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView, FinderObject paramFinderObject, View paramView)
  {
    AppMethodBeat.i(330930);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderQQMusicFollowHeaderView);
    localb.cH(paramFinderObject);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderQQMusicFollowHeaderView, "this$0");
    paramView = paramFinderQQMusicFollowHeaderView.EFb;
    paramFinderQQMusicFollowHeaderView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("topicFollowHelper");
      paramFinderQQMusicFollowHeaderView = null;
    }
    paramFinderQQMusicFollowHeaderView.o(paramFinderObject);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330930);
  }
  
  private final void ci(Context paramContext)
  {
    AppMethodBeat.i(330892);
    af.mU(paramContext).inflate(e.f.finder_qq_music_follow_header, (ViewGroup)this, true);
    this.EFa = ((ImageView)findViewById(e.e.finder_follow_item_image));
    LinearLayout localLinearLayout = (LinearLayout)findViewById(e.e.follow_qq_music_follow_btn);
    if (localLinearLayout == null) {
      localLinearLayout = null;
    }
    for (;;)
    {
      this.yEO = ((View)localLinearLayout);
      aw.a((Paint)((TextView)findViewById(e.e.follow_qq_music_follow_text)).getPaint(), 0.8F);
      this.EFb = new c(paramContext);
      AppMethodBeat.o(330892);
      return;
      localLinearLayout.setOnClickListener(new FinderQQMusicFollowHeaderView..ExternalSyntheticLambda0(this));
      ah localah = ah.aiuX;
    }
  }
  
  private final String n(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(330906);
    if (paramFinderObject == null) {}
    for (paramFinderObject = null; paramFinderObject == null; paramFinderObject = this.mLQ)
    {
      this.mLQ = com.tencent.mm.ae.d.hF(cn.bDw());
      paramFinderObject = this.mLQ;
      AppMethodBeat.o(330906);
      return paramFinderObject;
      this.mLQ = com.tencent.mm.ae.d.hF(paramFinderObject.id);
    }
    AppMethodBeat.o(330906);
    return paramFinderObject;
  }
  
  public final void a(bqj parambqj, int paramInt)
  {
    AppMethodBeat.i(331022);
    kotlin.g.b.s.u(parambqj, "musicInfo");
    this.ABJ = null;
    this.musicInfo = parambqj;
    Object localObject2 = this.EFb;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("topicFollowHelper");
      localObject1 = null;
    }
    ((c)localObject1).musicInfo = parambqj;
    this.mLQ = com.tencent.mm.ae.d.hF(cn.bDw());
    localObject1 = this.EFa;
    if (localObject1 != null)
    {
      ((ImageView)localObject1).setImageResource(e.d.finder_empty_mv_avatar_bg);
      Object localObject3 = parambqj.ZYo;
      if (!Util.isNullOrNil((String)localObject3))
      {
        localObject2 = p.ExI;
        localObject2 = p.eCl();
        localObject3 = new com.tencent.mm.plugin.finder.loader.s((String)localObject3, com.tencent.mm.plugin.finder.storage.v.FKZ);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject1, p.a(p.a.ExQ));
      }
    }
    localObject1 = (TextView)findViewById(e.e.follow_qq_music_name);
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)parambqj.name);
    }
    localObject1 = (TextView)findViewById(e.e.follow_qq_music_title);
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)parambqj.albumName);
    }
    localObject1 = (TextView)findViewById(e.e.follow_qq_music_desc);
    if (localObject1 != null)
    {
      localObject2 = av.GiL;
      ((TextView)localObject1).setText((CharSequence)av.Uq(parambqj.ZYs));
    }
    this.DPY = ((WeImageView)findViewById(e.e.follow_qq_music_play_icon));
    if (this.EFb == null) {
      kotlin.g.b.s.bIx("topicFollowHelper");
    }
    if (c.Qv(paramInt))
    {
      parambqj = this.DPY;
      if (parambqj != null) {
        parambqj.setOnClickListener(new FinderQQMusicFollowHeaderView..ExternalSyntheticLambda2(this, null));
      }
      parambqj = this.yEO;
      if (parambqj != null) {
        parambqj.setOnClickListener(new FinderQQMusicFollowHeaderView..ExternalSyntheticLambda1(this, null));
      }
      AppMethodBeat.o(331022);
      return;
    }
    a(null, parambqj);
    localObject1 = this.DPY;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setOnClickListener(new FinderQQMusicFollowHeaderView..ExternalSyntheticLambda3(this, null, parambqj));
    }
    AppMethodBeat.o(331022);
  }
  
  public final void eDV()
  {
    Object localObject2 = null;
    AppMethodBeat.i(331034);
    Object localObject1 = this.EFb;
    kotlin.g.a.a locala;
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("topicFollowHelper");
      localObject1 = null;
      locala = (kotlin.g.a.a)new b(this);
      kotlin.g.b.s.u(locala, "whenPreCheckReConnect");
      localObject3 = av.GiL;
      switch (av.fgg())
      {
      default: 
        Log.d("Finder.TopicFollowHelper", "not one of six state");
      case 3: 
      case 6: 
        i = 0;
        label103:
        if (i != 0)
        {
          i = 0;
          label109:
          if (i != 0)
          {
            localObject1 = this.EFb;
            if (localObject1 != null) {
              break label343;
            }
            kotlin.g.b.s.bIx("topicFollowHelper");
            localObject1 = localObject2;
          }
        }
        break;
      }
    }
    label338:
    label343:
    for (;;)
    {
      ((c)localObject1).eDW().GAC = new FinderQQMusicFollowHeaderView..ExternalSyntheticLambda4(this);
      AppMethodBeat.o(331034);
      return;
      break;
      aa.makeText(((c)localObject1).context, e.h.finder_no_post_quality_tips, 0).show();
      i = 1;
      break label103;
      ((c)localObject1).cpX();
      i = 1;
      break label103;
      aa.makeText(((c)localObject1).context, e.h.finder_account_forbid, 0).show();
      i = 1;
      break label103;
      aa.makeText(((c)localObject1).context, e.h.finder_self_contact_reviewing, 0).show();
      i = 1;
      break label103;
      localObject3 = com.tencent.mm.plugin.findersdk.d.a.Hdr;
      if (com.tencent.mm.plugin.findersdk.d.a.aDj("post"))
      {
        i = 0;
        break label109;
      }
      localObject3 = com.tencent.mm.plugin.finder.utils.a.GfO;
      if (com.tencent.mm.plugin.finder.utils.a.gW(((c)localObject1).context))
      {
        localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
        com.tencent.mm.plugin.finder.report.v.aP(6, true);
        i = 0;
        break label109;
      }
      localObject3 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(6, false);
      localObject3 = ((c)localObject1).AwN;
      if ((localObject3 != null) && (!((g)localObject3).a((kotlin.g.a.a)new c.b(locala), (kotlin.g.a.a)new c.c((c)localObject1)))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label338;
        }
        i = 0;
        break;
      }
      i = 1;
      break label109;
    }
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(331006);
    super.onAttachedToWindow();
    this.EFc.alive();
    AppMethodBeat.o(331006);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(331010);
    super.onDetachedFromWindow();
    this.EFc.dead();
    AppMethodBeat.o(331010);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(331026);
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(331026);
  }
  
  public final void setTopicFollowHelper(c paramc)
  {
    AppMethodBeat.i(331015);
    kotlin.g.b.s.u(paramc, "topicFollowHelper");
    this.EFb = paramc;
    AppMethodBeat.o(331015);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/music/FinderQQMusicFollowHeaderView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderQQMusicFollowHeaderView paramFinderQQMusicFollowHeaderView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderQQMusicFollowHeaderView
 * JD-Core Version:    0.7.0.1
 */