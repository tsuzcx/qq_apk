package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  private static final String TAG = "MicroMsg.LiveMicDialog";
  public static final a kJQ;
  private com.tencent.mm.ui.o.b jKS;
  private View kJL;
  private final b kJM;
  private boolean kJN;
  private boolean kJO;
  private boolean kJP;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(189146);
    kJQ = new a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(189146);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, b.i.CustomSheetStyle);
    AppMethodBeat.i(189144);
    this.mContext = paramContext;
    this.kJM = new b(this);
    bb();
    paramContext = getContext();
    p.j(paramContext, "context");
    this.jKS = new com.tencent.mm.ui.o.b(paramContext);
    AppMethodBeat.o(189144);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(189143);
    p.k(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.jKS.at(paramMotionEvent);
      int i = this.jKS.XLC;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.kJO) || (this.kJN)) {
            break label172;
          }
          bool1 = this.jKS.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.kJO) && (!bool1)) {
        break label227;
      }
      if (!this.kJP)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.kJP = true;
      }
      AppMethodBeat.o(189143);
      return true;
      this.kJP = false;
      this.kJO = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.kJP)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.j(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.jKS.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.kJP = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(189143);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189136);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setDimAmount(0.0F);
      AppMethodBeat.o(189136);
      return;
    }
    AppMethodBeat.o(189136);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(189139);
    p.k(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      p.iCn();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(b.i.BottomToTopSlowAnimation);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    Resources localResources = this.mContext.getResources();
    p.j(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2) {
      i = 1;
    }
    if (i != 0) {
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(b.e.live_mic_outside).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.kJL = paramView;
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.kJM);
      this.jKS.a((com.tencent.mm.ui.o.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(189139);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aRj()
    {
      long l1 = 0L;
      AppMethodBeat.i(194844);
      View localView = a.a(this.kJR);
      long l2;
      if (localView != null)
      {
        localView.setEnabled(false);
        l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label106;
        }
      }
      for (;;)
      {
        localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction((Runnable)new a(localView, this)).start();
        AppMethodBeat.o(194844);
        return;
        AppMethodBeat.o(194844);
        return;
        label106:
        l1 = l2;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(View paramView, a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(190658);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196105);
            if (this.kJU.kJT.kJR.isShowing()) {
              this.kJU.kJT.kJR.cancel();
            }
            this.kJU.kJS.setTranslationY(0.0F);
            AppMethodBeat.o(196105);
          }
        });
        AppMethodBeat.o(190658);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195309);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.kJR.isShowing()) {
        this.kJR.cancel();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */