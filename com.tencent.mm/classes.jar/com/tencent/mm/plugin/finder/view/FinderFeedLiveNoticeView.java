package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.cf;
import com.tencent.mm.plugin.findersdk.a.cf.a;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "root", "Landroid/view/View;", "upDateFinderLiveNotice", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "username", "isHardDarkMode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedLiveNoticeView
  extends LinearLayout
{
  private final String TAG;
  private View lBX;
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344016);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_live_notice_layout, (ViewGroup)this);
    kotlin.g.b.s.s(paramContext, "getInflater(context).inf…live_notice_layout, this)");
    this.lBX = paramContext;
    AppMethodBeat.o(344016);
  }
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344021);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = af.mU(getContext()).inflate(e.f.finder_feed_live_notice_layout, (ViewGroup)this);
    kotlin.g.b.s.s(paramContext, "getInflater(context).inf…live_notice_layout, this)");
    this.lBX = paramContext;
    AppMethodBeat.o(344021);
  }
  
  private static final void a(bkk parambkk, FinderFeedLiveNoticeView paramFinderFeedLiveNoticeView, TextView paramTextView, Context paramContext, boolean paramBoolean, String paramString, View paramView)
  {
    AppMethodBeat.i(344040);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambkk);
    localb.cH(paramFinderFeedLiveNoticeView);
    localb.cH(paramTextView);
    localb.cH(paramContext);
    localb.fv(paramBoolean);
    localb.cH(paramString);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambkk, "$noticeInfo");
    kotlin.g.b.s.u(paramFinderFeedLiveNoticeView, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString, "$username");
    int i;
    if (parambkk.status == 1)
    {
      parambkk.status = 0;
      paramView = q.cg.DFs;
      i = 1;
      if (parambkk.status != 1) {
        break label418;
      }
      paramFinderFeedLiveNoticeView.setVisibility(0);
      paramTextView.setText((CharSequence)paramContext.getResources().getString(e.h.finder_create_live_notice_btn_book));
      if (!paramBoolean) {
        break label401;
      }
      paramTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_stream_link_color));
      label181:
      paramFinderFeedLiveNoticeView = k.aeZF;
      paramFinderFeedLiveNoticeView = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)paramContext).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
      paramTextView = h.ax(g.class);
      kotlin.g.b.s.s(paramTextView, "service(IFinderCommonLiveService::class.java)");
      paramTextView = (g)paramTextView;
      localObject = parambkk.hAR;
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "noticeInfo.noticeId!!");
      paramTextView = g.a.a(paramTextView, paramString, (String)localObject, i, paramFinderFeedLiveNoticeView);
      h.aZW().a(paramTextView, 0);
      paramTextView = h.ax(cf.class);
      kotlin.g.b.s.s(paramTextView, "service(IHellLiveVisitorReoprter::class.java)");
      paramTextView = (cf)paramTextView;
      if (paramFinderFeedLiveNoticeView != null) {
        break label479;
      }
    }
    label401:
    label418:
    label479:
    for (paramFinderFeedLiveNoticeView = null;; paramFinderFeedLiveNoticeView = Integer.valueOf(paramFinderFeedLiveNoticeView.AJo))
    {
      localObject = paramFinderFeedLiveNoticeView.toString();
      paramFinderFeedLiveNoticeView = parambkk.YSR;
      parambkk = paramFinderFeedLiveNoticeView;
      if (paramFinderFeedLiveNoticeView == null) {
        parambkk = "";
      }
      cf.a.a(paramTextView, paramView, paramString, 0L, (String)localObject, null, null, null, null, parambkk, null, 1504);
      parambkk = k.aeZF;
      ((ar)k.d((AppCompatActivity)paramContext).cq(ar.class)).eiJ().avX(paramString);
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344040);
      return;
      parambkk.status = 1;
      paramView = q.cg.DFt;
      i = 2;
      break;
      paramTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_link_color));
      break label181;
      paramFinderFeedLiveNoticeView.setVisibility(0);
      paramTextView.setText((CharSequence)paramContext.getResources().getString(e.h.finder_create_live_notice_btn_book_cancel));
      if (paramBoolean)
      {
        paramTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
        break label181;
      }
      paramTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_5));
      break label181;
    }
  }
  
  public final void a(Context paramContext, bkk parambkk, String paramString)
  {
    AppMethodBeat.i(344061);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parambkk, "noticeInfo");
    kotlin.g.b.s.u(paramString, "username");
    TextView localTextView = (TextView)this.lBX.findViewById(e.e.finder_feed_notice_time_tips);
    Object localObject = this.lBX.findViewById(e.e.finder_feed_notice_divider);
    WeImageView localWeImageView = (WeImageView)this.lBX.findViewById(e.e.finder_feed_notice_icon);
    Resources localResources = paramContext.getResources();
    int i = e.h.finder_feed_live_notice_tips;
    aw localaw = aw.Gjk;
    localTextView.setText((CharSequence)localResources.getString(i, new Object[] { aw.a(parambkk.startTime * 1000L, null, false, 6) }));
    localTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_8));
    ((View)localObject).setBackgroundColor(paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_3));
    localWeImageView.setIconColor(paramContext.getResources().getColor(e.b.Red_100));
    findViewById(e.e.finder_feed_notice_layout).setBackgroundResource(e.d.finder_feed_item_live_notice_bg_dark);
    localTextView = (TextView)this.lBX.findViewById(e.e.finder_feed_notice_btn);
    localObject = av.GiL;
    kotlin.g.b.s.s(localTextView, "finderLiveBookBtn");
    av.gU((View)localTextView);
    if (parambkk.status == 1)
    {
      setVisibility(0);
      localTextView.setText((CharSequence)paramContext.getResources().getString(e.h.finder_create_live_notice_btn_book));
      localTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_stream_link_color));
    }
    while (getVisibility() == 0)
    {
      localTextView.setOnClickListener(new FinderFeedLiveNoticeView..ExternalSyntheticLambda0(parambkk, this, localTextView, paramContext, true, paramString));
      AppMethodBeat.o(344061);
      return;
      if (parambkk.status == 0) {
        if (getVisibility() == 0)
        {
          localTextView.setText((CharSequence)paramContext.getResources().getString(e.h.finder_create_live_notice_btn_book_cancel));
          localTextView.setTextColor(paramContext.getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
        }
        else
        {
          setVisibility(8);
        }
      }
    }
    localTextView.setOnClickListener(null);
    AppMethodBeat.o(344061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView
 * JD-Core Version:    0.7.0.1
 */