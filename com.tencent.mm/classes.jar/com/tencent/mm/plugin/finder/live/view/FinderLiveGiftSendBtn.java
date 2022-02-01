package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveGiftSendBtn;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CONTINUE_CLICK_SHORT_PAG", "", "CONTINUE_KEEP_DURATION", "", "SINGLE_CLICK_SHORT_PAG", "TAG", "continueClickPag", "fullScreenSendAgainContainer", "Landroid/view/View;", "fullScreenSendAgainPag", "Lorg/libpag/PAGView;", "singleClickPag", "singleClickPagTask", "Ljava/lang/Runnable;", "getSingleClickPagTask", "()Ljava/lang/Runnable;", "doSingleClickPagTask", "", "release", "removeClickPagTask", "resetSendAgainPagPath", "path", "showContinueClickSendAgain", "longClick", "", "showSingleClickSendAgian", "stopSendAgainPag", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveGiftSendBtn
  extends RelativeLayout
{
  private final String DNH;
  private final String DNI;
  public final long DNJ;
  private final View DNK;
  public final PAGView DNL;
  public String DNM;
  private String DNN;
  public final Runnable DNO;
  public final String TAG;
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357957);
    AppMethodBeat.o(357957);
  }
  
  public FinderLiveGiftSendBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357952);
    this.TAG = "FinderLiveGiftSendBtn";
    this.DNH = "assets://finder_live_gift_continue_click_short.pag";
    this.DNI = "assets://finder_live_gift_single_click_short.pag";
    this.DNJ = 500L;
    this.DNM = this.DNH;
    this.DNN = this.DNI;
    View.inflate(paramContext, p.f.CdZ, (ViewGroup)this);
    paramContext = findViewById(p.e.BKB);
    s.s(paramContext, "findViewById(R.id.finder…reen_gift_send_container)");
    this.DNK = paramContext;
    paramContext = this.DNK.findViewById(p.e.BKA);
    s.s(paramContext, "fullScreenSendAgainConta…reen_gift_send_again_pag)");
    this.DNL = ((PAGView)paramContext);
    this.DNO = new FinderLiveGiftSendBtn..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(357952);
  }
  
  private static final void a(FinderLiveGiftSendBtn paramFinderLiveGiftSendBtn)
  {
    AppMethodBeat.i(357963);
    s.u(paramFinderLiveGiftSendBtn, "this$0");
    paramFinderLiveGiftSendBtn.evp();
    AppMethodBeat.o(357963);
  }
  
  public final void axW(String paramString)
  {
    AppMethodBeat.i(357994);
    if (!s.p(this.DNL.getPath(), paramString)) {
      this.DNL.setPath(paramString);
    }
    AppMethodBeat.o(357994);
  }
  
  public final void evp()
  {
    AppMethodBeat.i(357983);
    Log.i(this.TAG, "showSingleClickSendAgian");
    if (!s.p(this.DNL.getPath(), this.DNN))
    {
      evq();
      axW(this.DNN);
      this.DNL.setRepeatCount(-1);
      this.DNL.setProgress(0.0D);
    }
    if (!this.DNL.isPlaying()) {
      this.DNL.play();
    }
    AppMethodBeat.o(357983);
  }
  
  public final void evq()
  {
    AppMethodBeat.i(357989);
    if (this.DNL.isPlaying()) {
      this.DNL.stop();
    }
    AppMethodBeat.o(357989);
  }
  
  public final Runnable getSingleClickPagTask()
  {
    return this.DNO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveGiftSendBtn
 * JD-Core Version:    0.7.0.1
 */