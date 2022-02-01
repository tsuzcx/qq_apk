package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONTINUE_CLICK_SHORT_PAG", "", "CONTINUE_KEEP_DURATION", "", "SINGLE_CLICK_SHORT_PAG", "TAG", "continueClickPag", "fullScreenSendAgainContainer", "Landroid/view/View;", "fullScreenSendAgainPag", "Lorg/libpag/PAGView;", "singleClickPag", "singleClickPagTask", "Ljava/lang/Runnable;", "getSingleClickPagTask", "()Ljava/lang/Runnable;", "doSingleClickPagTask", "", "release", "removeClickPagTask", "resetSendAgainPagPath", "path", "showContinueClickSendAgain", "longClick", "", "showSingleClickSendAgian", "stopSendAgainPag", "plugin-finder_release"})
public final class FinderLiveGiftSendBtn
  extends RelativeLayout
{
  public final String TAG;
  private final String yUp;
  private final String yUq;
  public final long yUr;
  private final View yUs;
  public final PAGView yUt;
  public String yUu;
  private String yUv;
  public final Runnable yUw;
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(269497);
    AppMethodBeat.o(269497);
  }
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(269496);
    this.TAG = "FinderLiveGiftSendBtn";
    this.yUp = "assets://finder_live_gift_continue_click_short.pag";
    this.yUq = "assets://finder_live_gift_single_click_short.pag";
    this.yUr = 500L;
    this.yUu = this.yUp;
    this.yUv = this.yUq;
    View.inflate(paramContext, b.g.finder_live_gift_send_btn_ui, (ViewGroup)this);
    paramContext = findViewById(b.f.finder_live_full_screen_gift_send_container);
    p.j(paramContext, "findViewById(R.id.finder…reen_gift_send_container)");
    this.yUs = paramContext;
    paramContext = this.yUs.findViewById(b.f.finder_live_full_screen_gift_send_again_pag);
    p.j(paramContext, "fullScreenSendAgainConta…reen_gift_send_again_pag)");
    this.yUt = ((PAGView)paramContext);
    this.yUw = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237669);
        this.yUx.dFa();
        AppMethodBeat.o(237669);
      }
    });
    AppMethodBeat.o(269496);
  }
  
  public final void aCU(String paramString)
  {
    AppMethodBeat.i(269495);
    if ((p.h(this.yUt.getPath(), paramString) ^ true)) {
      this.yUt.setPath(paramString);
    }
    AppMethodBeat.o(269495);
  }
  
  public final void dFa()
  {
    AppMethodBeat.i(269493);
    Log.i(this.TAG, "showSingleClickSendAgian");
    if ((p.h(this.yUt.getPath(), this.yUv) ^ true))
    {
      dFb();
      aCU(this.yUv);
      this.yUt.setRepeatCount(-1);
      this.yUt.setProgress(0.0D);
    }
    if (!this.yUt.isPlaying()) {
      this.yUt.play();
    }
    AppMethodBeat.o(269493);
  }
  
  public final void dFb()
  {
    AppMethodBeat.i(269494);
    if (this.yUt.isPlaying()) {
      this.yUt.stop();
    }
    AppMethodBeat.o(269494);
  }
  
  public final Runnable getSingleClickPagTask()
  {
    return this.yUw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn
 * JD-Core Version:    0.7.0.1
 */