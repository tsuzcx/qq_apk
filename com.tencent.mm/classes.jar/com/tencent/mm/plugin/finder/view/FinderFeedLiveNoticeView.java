package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bn;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "root", "Landroid/view/View;", "upDateFinderLiveNotice", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "username", "isHardDarkMode", "", "plugin-finder_release"})
public final class FinderFeedLiveNoticeView
  extends LinearLayout
{
  private final String TAG;
  private View jac;
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(222850);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_live_notice_layout, (ViewGroup)this);
    p.j(paramContext, "MMLayoutInflater.getInfl…live_notice_layout, this)");
    this.jac = paramContext;
    AppMethodBeat.o(222850);
  }
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(222853);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = ad.kS(getContext()).inflate(b.g.finder_feed_live_notice_layout, (ViewGroup)this);
    p.j(paramContext, "MMLayoutInflater.getInfl…live_notice_layout, this)");
    this.jac = paramContext;
    AppMethodBeat.o(222853);
  }
  
  public final void a(final Context paramContext, final bbh parambbh, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(222842);
    p.k(paramContext, "context");
    p.k(parambbh, "noticeInfo");
    p.k(paramString, "username");
    final TextView localTextView = (TextView)this.jac.findViewById(b.f.finder_feed_notice_time_tips);
    View localView = this.jac.findViewById(b.f.finder_feed_notice_divider);
    WeImageView localWeImageView = (WeImageView)this.jac.findViewById(b.f.finder_feed_notice_icon);
    p.j(localTextView, "noticeTips");
    Resources localResources = paramContext.getResources();
    int i = b.j.finder_feed_live_notice_tips;
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    localTextView.setText((CharSequence)localResources.getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.aj.Nj(parambbh.fod * 1000L) }));
    if (paramBoolean)
    {
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
      localTextView.setTypeface(null, 0);
      localView.setBackgroundColor(paramContext.getResources().getColor(b.c.hot_tab_O_1_alpha_white));
      localWeImageView.setIconColor(paramContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_8));
      findViewById(b.f.finder_feed_notice_layout).setBackgroundResource(b.e.finder_feed_full_item_shape_bg);
      localTextView = (TextView)this.jac.findViewById(b.f.finder_feed_notice_btn);
      if (parambbh.status != 1) {
        break label380;
      }
      setVisibility(0);
      p.j(localTextView, "finderLiveBookBtn");
      localTextView.setText((CharSequence)paramContext.getResources().getString(b.j.finder_create_live_notice_btn_book));
      if (!paramBoolean) {
        break label362;
      }
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.hot_tab_stream_link_color));
    }
    for (;;)
    {
      if (getVisibility() != 0) {
        break label469;
      }
      localTextView.setOnClickListener((View.OnClickListener)new a(this, parambbh, localTextView, paramContext, paramBoolean, paramString));
      AppMethodBeat.o(222842);
      return;
      localWeImageView.setIconColor(paramContext.getResources().getColor(b.c.BW_0_Alpha_0_5));
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.FG_0));
      localView.setBackgroundColor(paramContext.getResources().getColor(b.c.BW_0_Alpha_0_1));
      findViewById(b.f.finder_feed_notice_layout).setBackgroundResource(b.e.finder_feed_item_live_notice_bg);
      break;
      label362:
      localTextView.setTextColor(paramContext.getResources().getColor(b.c.Link_80));
      continue;
      label380:
      if (parambbh.status == 0) {
        if (getVisibility() == 0)
        {
          p.j(localTextView, "finderLiveBookBtn");
          localTextView.setText((CharSequence)paramContext.getResources().getString(b.j.finder_create_live_notice_btn_book_cancel));
          if (paramBoolean) {
            localTextView.setTextColor(paramContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
          } else {
            localTextView.setTextColor(paramContext.getResources().getColor(b.c.FG_1));
          }
        }
        else
        {
          setVisibility(8);
        }
      }
    }
    label469:
    localTextView.setOnClickListener(null);
    AppMethodBeat.o(222842);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderFeedLiveNoticeView paramFinderFeedLiveNoticeView, bbh parambbh, TextView paramTextView, Context paramContext, boolean paramBoolean, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(274312);
      Object localObject1 = new b();
      ((b)localObject1).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
      int i;
      if (parambbh.status == 1)
      {
        parambbh.status = 0;
        paramView = s.bn.yMZ;
        i = 1;
        if (parambbh.status != 1) {
          break label238;
        }
        this.AXF.setVisibility(0);
        localObject1 = localTextView;
        p.j(localObject1, "finderLiveBookBtn");
        ((TextView)localObject1).setText((CharSequence)paramContext.getResources().getString(b.j.finder_create_live_notice_btn_book));
        if (!paramBoolean) {
          break label215;
        }
        localTextView.setTextColor(paramContext.getResources().getColor(b.c.hot_tab_stream_link_color));
      }
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = parambbh.fwt;
        if (localObject2 == null) {
          p.iCn();
        }
        p.j(localObject2, "noticeInfo.noticeId!!");
        localObject3 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = paramContext;
        if (localObject3 != null) {
          break label330;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(274312);
        throw paramView;
        parambbh.status = 1;
        paramView = s.bn.yNa;
        i = 2;
        break;
        label215:
        localTextView.setTextColor(paramContext.getResources().getColor(b.c.Link_80));
        continue;
        label238:
        this.AXF.setVisibility(0);
        localObject1 = localTextView;
        p.j(localObject1, "finderLiveBookBtn");
        ((TextView)localObject1).setText((CharSequence)paramContext.getResources().getString(b.j.finder_create_live_notice_btn_book_cancel));
        if (paramBoolean) {
          localTextView.setTextColor(paramContext.getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
        } else {
          localTextView.setTextColor(paramContext.getResources().getColor(b.c.FG_1));
        }
      }
      label330:
      localObject1 = new au((String)localObject1, (String)localObject2, i, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)localObject3).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
      h.aGY().b((q)localObject1);
      Object localObject2 = m.yCt;
      Object localObject3 = paramString;
      localObject1 = ((com.tencent.mm.plugin.findersdk.b.g)localObject1).xbu;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((bid)localObject1).xkX);; localObject1 = null)
      {
        String str = String.valueOf(localObject1);
        localObject2 = parambbh.SNb;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        m.a(paramView, (String)localObject3, 0L, str, null, null, null, null, (String)localObject1, 480);
        paramView = com.tencent.mm.ui.component.g.Xox;
        paramView = ((y)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramContext).i(y.class)).yci;
        localObject1 = paramString;
        p.k(localObject1, "userName");
        paramView.btS().removeMessages(paramView.xFY);
        paramView.btS().sendMessage(paramView.btS().obtainMessage(paramView.xFY, localObject1));
        a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(274312);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView
 * JD-Core Version:    0.7.0.1
 */