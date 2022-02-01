package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftPreviewView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "thumbPagView", "Lorg/libpag/PAGView;", "tvSend", "Landroid/widget/TextView;", "release", "", "startPAGAnim", "path", "stopPAGAnim", "plugin-finder_release"})
public final class FinderLiveGiftPreviewView
  extends RelativeLayout
{
  private final String TAG;
  public final PAGView uyw;
  private final TextView uyx;
  
  public FinderLiveGiftPreviewView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(247451);
    AppMethodBeat.o(247451);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(247452);
    AppMethodBeat.o(247452);
  }
  
  public FinderLiveGiftPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247450);
    this.TAG = "Finder.FinderLiveGiftPreviewView";
    View.inflate(paramContext, 2131494403, (ViewGroup)this);
    paramContext = findViewById(2131301024);
    p.g(paramContext, "findViewById(R.id.finder_live_gift_thumb_pag)");
    this.uyw = ((PAGView)paramContext);
    paramContext = findViewById(2131301025);
    p.g(paramContext, "findViewById(R.id.finder_live_gift_thumb_send_btn)");
    this.uyx = ((TextView)paramContext);
    AppMethodBeat.o(247450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftPreviewView
 * JD-Core Version:    0.7.0.1
 */