package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONTINUE_CLICK_SHORT_PAG", "", "CONTINUE_KEEP_DURATION", "", "SINGLE_CLICK_SHORT_PAG", "TAG", "continueClickPag", "fullScreenSendAgainContainer", "Landroid/view/View;", "fullScreenSendAgainPag", "Lorg/libpag/PAGView;", "singleClickPag", "singleClickPagTask", "Ljava/lang/Runnable;", "getSingleClickPagTask", "()Ljava/lang/Runnable;", "doSingleClickPagTask", "", "release", "removeClickPagTask", "resetSendAgainPagPath", "path", "showContinueClickSendAgain", "longClick", "", "showSingleClickSendAgian", "stopSendAgainPag", "plugin-finder_release"})
public final class FinderLiveGiftSendBtn
  extends RelativeLayout
{
  public final String TAG;
  public final long uyA;
  private final View uyB;
  public final PAGView uyC;
  public String uyD;
  private String uyE;
  public final Runnable uyF;
  private final String uyy;
  private final String uyz;
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(247458);
    AppMethodBeat.o(247458);
  }
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247457);
    this.TAG = "FinderLiveGiftSendBtn";
    this.uyy = "assets://finder_live_gift_continue_click_short.pag";
    this.uyz = "assets://finder_live_gift_single_click_short.pag";
    this.uyA = 500L;
    this.uyD = this.uyy;
    this.uyE = this.uyz;
    View.inflate(paramContext, 2131494402, (ViewGroup)this);
    paramContext = findViewById(2131300988);
    p.g(paramContext, "findViewById(R.id.finder…reen_gift_send_container)");
    this.uyB = paramContext;
    paramContext = this.uyB.findViewById(2131300986);
    p.g(paramContext, "fullScreenSendAgainConta…reen_gift_send_again_pag)");
    this.uyC = ((PAGView)paramContext);
    this.uyF = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247453);
        this.uyG.dit();
        AppMethodBeat.o(247453);
      }
    });
    AppMethodBeat.o(247457);
  }
  
  public final void atQ(String paramString)
  {
    AppMethodBeat.i(247456);
    if ((p.j(this.uyC.getPath(), paramString) ^ true)) {
      this.uyC.setPath(paramString);
    }
    AppMethodBeat.o(247456);
  }
  
  public final void dit()
  {
    AppMethodBeat.i(247454);
    Log.i(this.TAG, "showSingleClickSendAgian");
    if ((p.j(this.uyC.getPath(), this.uyE) ^ true))
    {
      diu();
      atQ(this.uyE);
      this.uyC.setRepeatCount(-1);
      this.uyC.setProgress(0.0D);
    }
    if (!this.uyC.isPlaying()) {
      this.uyC.play();
    }
    AppMethodBeat.o(247454);
  }
  
  public final void diu()
  {
    AppMethodBeat.i(247455);
    if (this.uyC.isPlaying()) {
      this.uyC.stop();
    }
    AppMethodBeat.o(247455);
  }
  
  public final Runnable getSingleClickPagTask()
  {
    return this.uyF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn
 * JD-Core Version:    0.7.0.1
 */