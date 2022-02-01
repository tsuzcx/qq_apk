package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.az;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "root", "Landroid/view/View;", "upDateFinderLiveNotice", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "username", "isHardDarkMode", "", "plugin-finder_release"})
public final class FinderFeedLiveNoticeView
  extends LinearLayout
{
  private final String TAG;
  private View gvQ;
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254819);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = aa.jQ(getContext()).inflate(2131494293, (ViewGroup)this);
    p.g(paramContext, "MMLayoutInflater.getInfl…live_notice_layout, this)");
    this.gvQ = paramContext;
    AppMethodBeat.o(254819);
  }
  
  public FinderFeedLiveNoticeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254820);
    this.TAG = "Finder.FinderFeedLiveNoticeView";
    setOrientation(0);
    paramContext = aa.jQ(getContext()).inflate(2131494293, (ViewGroup)this);
    p.g(paramContext, "MMLayoutInflater.getInfl…live_notice_layout, this)");
    this.gvQ = paramContext;
    AppMethodBeat.o(254820);
  }
  
  public final void a(final Context paramContext, final awt paramawt, final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(254817);
    p.h(paramContext, "context");
    p.h(paramawt, "noticeInfo");
    p.h(paramString, "username");
    final TextView localTextView = (TextView)this.gvQ.findViewById(2131300840);
    View localView = this.gvQ.findViewById(2131300837);
    WeImageView localWeImageView = (WeImageView)this.gvQ.findViewById(2131300838);
    p.g(localTextView, "noticeTips");
    Resources localResources = paramContext.getResources();
    y localy = y.vXH;
    localTextView.setText((CharSequence)localResources.getString(2131759736, new Object[] { y.Gi(paramawt.dvv * 1000L) }));
    if (paramBoolean)
    {
      localTextView.setTextColor(paramContext.getResources().getColor(2131100620));
      localTextView.setTypeface(null, 0);
      localView.setBackgroundColor(paramContext.getResources().getColor(2131100623));
      localWeImageView.setIconColor(paramContext.getResources().getColor(2131100620));
      findViewById(2131300839).setBackgroundResource(2131232528);
      localTextView = (TextView)this.gvQ.findViewById(2131300836);
      if (paramawt.status != 1) {
        break label358;
      }
      setVisibility(0);
      p.g(localTextView, "finderLiveBookBtn");
      localTextView.setText((CharSequence)paramContext.getResources().getString(2131759643));
      if (!paramBoolean) {
        break label341;
      }
      localTextView.setTextColor(paramContext.getResources().getColor(2131100631));
    }
    for (;;)
    {
      if (getVisibility() != 0) {
        break label444;
      }
      localTextView.setOnClickListener((View.OnClickListener)new a(this, paramawt, localTextView, paramContext, paramBoolean, paramString));
      AppMethodBeat.o(254817);
      return;
      localWeImageView.setIconColor(paramContext.getResources().getColor(2131099665));
      localTextView.setTextColor(paramContext.getResources().getColor(2131099746));
      localView.setBackgroundColor(paramContext.getResources().getColor(2131099657));
      findViewById(2131300839).setBackgroundResource(2131232530);
      break;
      label341:
      localTextView.setTextColor(paramContext.getResources().getColor(2131099787));
      continue;
      label358:
      if (paramawt.status == 0) {
        if (getVisibility() == 0)
        {
          p.g(localTextView, "finderLiveBookBtn");
          localTextView.setText((CharSequence)paramContext.getResources().getString(2131759644));
          if (paramBoolean) {
            localTextView.setTextColor(paramContext.getResources().getColor(2131100617));
          } else {
            localTextView.setTextColor(paramContext.getResources().getColor(2131099748));
          }
        }
        else
        {
          setVisibility(8);
        }
      }
    }
    label444:
    localTextView.setOnClickListener(null);
    AppMethodBeat.o(254817);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FinderFeedLiveNoticeView paramFinderFeedLiveNoticeView, awt paramawt, TextView paramTextView, Context paramContext, boolean paramBoolean, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(254816);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
      int i;
      if (paramawt.status == 1)
      {
        paramawt.status = 0;
        paramView = s.az.vsT;
        i = 1;
        if (paramawt.status != 1) {
          break label235;
        }
        this.wmC.setVisibility(0);
        localObject1 = localTextView;
        p.g(localObject1, "finderLiveBookBtn");
        ((TextView)localObject1).setText((CharSequence)paramContext.getResources().getString(2131759643));
        if (!paramBoolean) {
          break label213;
        }
        localTextView.setTextColor(paramContext.getResources().getColor(2131100631));
      }
      Object localObject3;
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = paramawt.dDJ;
        if (localObject2 == null) {
          p.hyc();
        }
        p.g(localObject2, "noticeInfo.noticeId!!");
        localObject3 = com.tencent.mm.ui.component.a.PRN;
        localObject3 = paramContext;
        if (localObject3 != null) {
          break label324;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(254816);
        throw paramView;
        paramawt.status = 1;
        paramView = s.az.vsU;
        i = 2;
        break;
        label213:
        localTextView.setTextColor(paramContext.getResources().getColor(2131099787));
        continue;
        label235:
        this.wmC.setVisibility(0);
        localObject1 = localTextView;
        p.g(localObject1, "finderLiveBookBtn");
        ((TextView)localObject1).setText((CharSequence)paramContext.getResources().getString(2131759644));
        if (paramBoolean) {
          localTextView.setTextColor(paramContext.getResources().getColor(2131100617));
        } else {
          localTextView.setTextColor(paramContext.getResources().getColor(2131099748));
        }
      }
      label324:
      localObject1 = new ar((String)localObject1, (String)localObject2, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)localObject3).get(FinderReporterUIC.class)).dIx());
      g.azz().b((q)localObject1);
      Object localObject2 = m.vli;
      localObject2 = paramString;
      localObject1 = ((ax)localObject1).ttO;
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((bbn)localObject1).tCE);; localObject1 = null)
      {
        m.a(paramView, (String)localObject2, 0L, String.valueOf(localObject1));
        paramView = com.tencent.mm.ui.component.a.PRN;
        paramView = ((FinderLiveNoticePreLoadUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(FinderLiveNoticePreLoadUIC.class)).wyi;
        localObject1 = paramString;
        p.h(localObject1, "userName");
        paramView.bkj().removeMessages(paramView.tWk);
        paramView.bkj().sendMessage(paramView.bkj().obtainMessage(paramView.tWk, localObject1));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderFeedLiveNoticeView$upDateFinderLiveNotice$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254816);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView
 * JD-Core Version:    0.7.0.1
 */