package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "", "()V", "TAG", "", "animationCallBack", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "getAnimationCallBack", "()Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "setAnimationCallBack", "(Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;)V", "animationEnd", "", "getAnimationEnd", "()Z", "setAnimationEnd", "(Z)V", "animationView", "Landroid/view/View;", "bg", "duration", "", "enable", "getEnable", "setEnable", "hasInit", "getHasInit", "setHasInit", "imagePreviewAnimation", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation;", "isAnimated", "isXWeb", "setXWeb", "mHeight", "mLeft", "mTop", "mWidth", "playStarted", "getPlayStarted", "setPlayStarted", "forceHideAnimationView", "", "handleAnimation", "callBack", "hideAnimationView", "init", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "view", "onStartPlay", "resetAnimation", "showAnimationView", "plugin-brandservice_release"})
public final class h
{
  final String TAG = "MicroMsg.MPVideoImageAnimationHelper";
  int duration = 300;
  public boolean enable = true;
  public boolean hasInit;
  private boolean isAnimated;
  private e kip;
  public View kiq;
  View kir;
  public boolean kis;
  public boolean kit;
  private e.b kiu;
  public boolean kiv = true;
  private int mHeight;
  private int mWidth;
  private int qO;
  private int qP;
  
  private void aZQ()
  {
    AppMethodBeat.i(15334);
    if (((this.kit) && (this.kis)) || (!this.enable))
    {
      View localView = this.kiq;
      if (localView == null) {
        j.ays("animationView");
      }
      localView.setVisibility(8);
    }
    AppMethodBeat.o(15334);
  }
  
  public final void a(Intent paramIntent, Context paramContext, View paramView1, View paramView2)
  {
    AppMethodBeat.i(15333);
    j.q(paramIntent, "intent");
    j.q(paramContext, "context");
    j.q(paramView1, "view");
    this.hasInit = true;
    this.kip = new e(paramContext);
    this.kiq = paramView1;
    this.kir = paramView2;
    this.qP = paramIntent.getIntExtra("img_gallery_top", 0);
    this.qO = paramIntent.getIntExtra("img_gallery_left", 0);
    this.mWidth = paramIntent.getIntExtra("img_gallery_width", 0);
    this.mHeight = paramIntent.getIntExtra("img_gallery_height", 0);
    AppMethodBeat.o(15333);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(152970);
    j.q(paramb, "callBack");
    this.kiu = paramb;
    paramb = this.kip;
    if (paramb == null) {
      j.ays("imagePreviewAnimation");
    }
    paramb.L(this.qO, this.qP, this.mWidth, this.mHeight);
    if ((this.isAnimated) || (this.mWidth == 0) || (this.mHeight == 0) || (!this.enable))
    {
      ab.i(this.TAG, "handleAnimation return " + this.isAnimated + ',' + this.mWidth + ',' + this.mHeight);
      paramb = this.kir;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      this.kit = true;
      aZS();
      AppMethodBeat.o(152970);
      return;
    }
    this.isAnimated = true;
    this.kit = false;
    ab.d(this.TAG, "handleAnimation");
    paramb = this.kiq;
    if (paramb == null) {
      j.ays("animationView");
    }
    paramb = paramb.getViewTreeObserver();
    if (paramb != null) {
      paramb.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new h.a(this));
    }
    al.p((Runnable)new h.b(this), this.duration + 200L);
    AppMethodBeat.o(152970);
  }
  
  public final void aZP()
  {
    AppMethodBeat.i(152968);
    this.kis = true;
    aZQ();
    AppMethodBeat.o(152968);
  }
  
  public final void aZR()
  {
    AppMethodBeat.i(152969);
    View localView = this.kiq;
    if (localView == null) {
      j.ays("animationView");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(152969);
  }
  
  public final void aZS()
  {
    AppMethodBeat.i(152971);
    if (this.kit)
    {
      ab.d(this.TAG, "resetAnimation animationEnd");
      AppMethodBeat.o(152971);
      return;
    }
    Object localObject = this.kiq;
    if (localObject == null) {
      j.ays("animationView");
    }
    ((View)localObject).clearAnimation();
    localObject = this.kiq;
    if (localObject == null) {
      j.ays("animationView");
    }
    localObject = ((View)localObject).findViewById(2131821842);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    this.kit = true;
    aZQ();
    localObject = this.kir;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.kiu;
    if (localObject != null)
    {
      ((e.b)localObject).onAnimationEnd();
      AppMethodBeat.o(152971);
      return;
    }
    AppMethodBeat.o(152971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h
 * JD-Core Version:    0.7.0.1
 */