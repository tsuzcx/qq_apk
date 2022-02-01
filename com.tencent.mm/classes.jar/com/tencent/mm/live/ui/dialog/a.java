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
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  private static final String TAG = "MicroMsg.LiveMicDialog";
  public static final a.a hcw;
  private com.tencent.mm.ui.j.b goY;
  private final b hcs;
  private boolean hct;
  private boolean hcu;
  private boolean hcv;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(216518);
    hcw = new a.a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(216518);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(216517);
    this.mContext = paramContext;
    this.hcs = new b(this);
    gK();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.goY = new com.tencent.mm.ui.j.b(paramContext);
    AppMethodBeat.o(216517);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(216516);
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.goY.ae(paramMotionEvent);
      int i = this.goY.KYK;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.hcu) || (this.hct)) {
            break label172;
          }
          bool1 = this.goY.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.hcu) && (!bool1)) {
        break label227;
      }
      if (!this.hcv)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.hcv = true;
      }
      AppMethodBeat.o(216516);
      return true;
      this.hcv = false;
      this.hcu = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.hcv)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.goY.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.hcv = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(216516);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216514);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(216514);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(216515);
    p.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      p.gkB();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820790);
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
      paramView.findViewById(2131307704).setOnClickListener((View.OnClickListener)new a.c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.hcs);
      this.goY.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.gkB();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(216515);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aqN()
    {
      long l1 = 0L;
      AppMethodBeat.i(216512);
      View localView = a.a(this.hcx);
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
        AppMethodBeat.o(216512);
        return;
        AppMethodBeat.o(216512);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(216511);
        new aq().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216510);
            if (this.hcz.hcy.hcx.isShowing()) {
              this.hcz.hcy.hcx.cancel();
            }
            AppMethodBeat.o(216510);
          }
        });
        AppMethodBeat.o(216511);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */