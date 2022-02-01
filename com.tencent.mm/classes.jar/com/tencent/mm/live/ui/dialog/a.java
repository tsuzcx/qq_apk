package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  private static final String TAG = "MicroMsg.LiveMicDialog";
  public static final a hVq;
  private com.tencent.mm.ui.m.b gZR;
  private final b hVm;
  private boolean hVn;
  private boolean hVo;
  private boolean hVp;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(208479);
    hVq = new a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(208479);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820868);
    AppMethodBeat.i(208478);
    this.mContext = paramContext;
    this.hVm = new b(this);
    gR();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gZR = new com.tencent.mm.ui.m.b(paramContext);
    AppMethodBeat.o(208478);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208477);
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.gZR.al(paramMotionEvent);
      int i = this.gZR.QnD;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.hVo) || (this.hVn)) {
            break label172;
          }
          bool1 = this.gZR.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.hVo) && (!bool1)) {
        break label227;
      }
      if (!this.hVp)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.hVp = true;
      }
      AppMethodBeat.o(208477);
      return true;
      this.hVp = false;
      this.hVo = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.hVp)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.gZR.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.hVp = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(208477);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208475);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setDimAmount(0.0F);
      AppMethodBeat.o(208475);
      return;
    }
    AppMethodBeat.o(208475);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(208476);
    p.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      p.hyc();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820793);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    Resources localResources = this.mContext.getResources();
    p.g(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2) {
      i = 1;
    }
    if (i != 0) {
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131303488).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.hVm);
      this.gZR.a((com.tencent.mm.ui.m.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(208476);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aJl()
    {
      long l1 = 0L;
      AppMethodBeat.i(208473);
      View localView = a.a(this.hVr);
      long l2;
      if (localView != null)
      {
        localView.setEnabled(false);
        l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label104;
        }
      }
      for (;;)
      {
        localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(208473);
        return;
        AppMethodBeat.o(208473);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(208472);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208471);
            if (this.hVt.hVs.hVr.isShowing()) {
              this.hVt.hVs.hVr.cancel();
            }
            AppMethodBeat.o(208471);
          }
        });
        AppMethodBeat.o(208472);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208474);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.hVr.isShowing()) {
        this.hVr.cancel();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */