package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "thumbPagView", "Lorg/libpag/PAGView;", "tvSend", "Landroid/widget/TextView;", "release", "", "startPAGAnim", "path", "stopPAGAnim", "plugin-finder_release"})
public final class FinderLiveGiftPreviewView
  extends RelativeLayout
{
  private final String TAG;
  public final PAGView yUn;
  private final TextView yUo;
  
  public FinderLiveGiftPreviewView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(224174);
    AppMethodBeat.o(224174);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(224176);
    AppMethodBeat.o(224176);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(224171);
    this.TAG = "Finder.FinderLiveGiftPreviewView";
    View.inflate(paramContext, b.g.finder_live_gift_thumb_ui, (ViewGroup)this);
    paramContext = findViewById(b.f.finder_live_gift_thumb_pag);
    p.j(paramContext, "findViewById(R.id.finder_live_gift_thumb_pag)");
    this.yUn = ((PAGView)paramContext);
    paramContext = findViewById(b.f.finder_live_gift_thumb_send_btn);
    p.j(paramContext, "findViewById(R.id.finder_live_gift_thumb_send_btn)");
    this.yUo = ((TextView)paramContext);
    AppMethodBeat.o(224171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPreviewView
 * JD-Core Version:    0.7.0.1
 */