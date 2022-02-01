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
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  private static final String TAG = "MicroMsg.LiveMicDialog";
  public static final a.a gZJ;
  private final b gZF;
  private boolean gZG;
  private boolean gZH;
  private boolean gZI;
  private com.tencent.mm.ui.j.b gmC;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(212890);
    gZJ = new a.a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(212890);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(212889);
    this.mContext = paramContext;
    this.gZF = new b(this);
    gK();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gmC = new com.tencent.mm.ui.j.b(paramContext);
    AppMethodBeat.o(212889);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(212888);
    p.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.gmC.ag(paramMotionEvent);
      int i = this.gmC.KCq;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.gZH) || (this.gZG)) {
            break label172;
          }
          bool1 = this.gmC.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.gZH) && (!bool1)) {
        break label227;
      }
      if (!this.gZI)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.gZI = true;
      }
      AppMethodBeat.o(212888);
      return true;
      this.gZI = false;
      this.gZH = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.gZI)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        p.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.gmC.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.gZI = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(212888);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212886);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(212886);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(212887);
    p.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      p.gfZ();
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
      paramView.findViewById(2131307704).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.gZF);
      this.gmC.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        p.gfZ();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(212887);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aqy()
    {
      long l1 = 0L;
      AppMethodBeat.i(212884);
      View localView = a.a(this.gZK);
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
        AppMethodBeat.o(212884);
        return;
        AppMethodBeat.o(212884);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(212883);
        new ap().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(212882);
            if (this.gZM.gZL.gZK.isShowing()) {
              this.gZM.gZL.gZK.cancel();
            }
            AppMethodBeat.o(212882);
          }
        });
        AppMethodBeat.o(212883);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212885);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (this.gZK.isShowing()) {
        this.gZK.cancel();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */