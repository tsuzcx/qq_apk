package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.d.a.a.a.d.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "container", "Landroid/view/View;", "thumbPagView", "Lorg/libpag/PAGView;", "tvSend", "Landroid/widget/TextView;", "release", "", "setContent", "curGiftId", "startPAGAnim", "stopPAGAnim", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGiftPreviewView
  extends RelativeLayout
{
  public final PAGView DNF;
  private final TextView DNG;
  private final String TAG;
  private final View hDw;
  
  public FinderLiveGiftPreviewView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(357528);
    AppMethodBeat.o(357528);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357533);
    AppMethodBeat.o(357533);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357522);
    this.TAG = "Finder.FinderLiveGiftPreviewView";
    paramContext = View.inflate(paramContext, p.f.Cea, (ViewGroup)this);
    s.s(paramContext, "inflate(context, R.layou…live_gift_thumb_ui, this)");
    this.hDw = paramContext;
    paramContext = findViewById(p.e.BMd);
    s.s(paramContext, "findViewById(R.id.finder_live_gift_thumb_pag)");
    this.DNF = ((PAGView)paramContext);
    paramContext = findViewById(p.e.BMe);
    s.s(paramContext, "findViewById(R.id.finder_live_gift_thumb_send_btn)");
    this.DNG = ((TextView)paramContext);
    AppMethodBeat.o(357522);
  }
  
  public final void setContent(String paramString)
  {
    AppMethodBeat.i(357542);
    q localq = q.CFU;
    paramString = q.awx(paramString);
    if ((paramString != null) && (paramString.jWv()))
    {
      paramString = aj.CGT;
      paramString = (h)aj.business(h.class);
      if ((paramString != null) && (!paramString.Eff)) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.hDw.setBackgroundResource(p.d.BzX);
        this.DNG.setText((CharSequence)getContext().getString(p.h.CjZ));
        this.DNG.setTextSize(1, 12.0F);
        AppMethodBeat.o(357542);
        return;
      }
    }
    this.hDw.setBackgroundResource(p.d.BAf);
    this.DNG.setText((CharSequence)getContext().getString(p.h.CkS));
    this.DNG.setTextSize(1, 15.0F);
    AppMethodBeat.o(357542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPreviewView
 * JD-Core Version:    0.7.0.1
 */