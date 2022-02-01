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
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  private static final String TAG = "MicroMsg.LiveMicDialog";
  public static final a.a gFZ;
  private com.tencent.mm.ui.j.b fSY;
  private final b gFV;
  private boolean gFW;
  private boolean gFX;
  private boolean gFY;
  private Context mContext;
  private View targetView;
  
  static
  {
    AppMethodBeat.i(190600);
    gFZ = new a.a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(190600);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(190599);
    this.mContext = paramContext;
    this.gFV = new b(this);
    gt();
    paramContext = getContext();
    k.g(paramContext, "context");
    this.fSY = new com.tencent.mm.ui.j.b(paramContext);
    AppMethodBeat.o(190599);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(190598);
    k.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.fSY.ae(paramMotionEvent);
      int i = this.fSY.ILj;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.gFX) || (this.gFW)) {
            break label172;
          }
          bool1 = this.fSY.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.gFX) && (!bool1)) {
        break label227;
      }
      if (!this.gFY)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.gFY = true;
      }
      AppMethodBeat.o(190598);
      return true;
      this.gFY = false;
      this.gFX = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.gFY)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.fSY.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.gFY = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(190598);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190596);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(190596);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(190597);
    k.h(paramView, "view");
    Window localWindow = getWindow();
    if (localWindow == null) {
      k.fOy();
    }
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(2131820790);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    Resources localResources = this.mContext.getResources();
    k.g(localResources, "mContext.resources");
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
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.gFV);
      this.fSY.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        k.fOy();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(190597);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void anM()
    {
      long l1 = 0L;
      AppMethodBeat.i(190594);
      View localView = a.a(this.gGa);
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
        AppMethodBeat.o(190594);
        return;
        AppMethodBeat.o(190594);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(190593);
        new ao().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190592);
            if (this.gGc.gGb.gGa.isShowing()) {
              this.gGc.gGb.gGa.cancel();
            }
            AppMethodBeat.o(190592);
          }
        });
        AppMethodBeat.o(190593);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */