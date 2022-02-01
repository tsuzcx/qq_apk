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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"})
public final class a
  extends e
{
  public static final a KzE;
  private static final String TAG = "MicroMsg.LiveMicDialog";
  private final b KzD;
  private com.tencent.mm.ui.j.b fPd;
  private Context mContext;
  private View targetView;
  private boolean ysM;
  private boolean ysN;
  private boolean ysO;
  
  static
  {
    AppMethodBeat.i(203389);
    KzE = new a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(203389);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, 2131820861);
    AppMethodBeat.i(203388);
    this.mContext = paramContext;
    this.KzD = new b(this);
    gl();
    paramContext = getContext();
    k.g(paramContext, "context");
    this.fPd = new com.tencent.mm.ui.j.b(paramContext);
    AppMethodBeat.o(203388);
  }
  
  private final boolean aov()
  {
    AppMethodBeat.i(203384);
    Resources localResources = this.mContext.getResources();
    k.g(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(203384);
      return true;
    }
    AppMethodBeat.o(203384);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(203387);
    k.h(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.fPd.ae(paramMotionEvent);
      int i = this.fPd.HkQ;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.ysN) || (this.ysM)) {
            break label172;
          }
          bool1 = this.fPd.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.ysN) && (!bool1)) {
        break label227;
      }
      if (!this.ysO)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(paramMotionEvent, "cancelEvent");
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.ysO = true;
      }
      AppMethodBeat.o(203387);
      return true;
      this.ysO = false;
      this.ysN = false;
      break;
      label172:
      bool1 = bool2;
      if (!this.ysO)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        k.g(localMotionEvent, "cancelEvent");
        localMotionEvent.setAction(3);
        this.fPd.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.ysO = true;
        bool1 = bool2;
      }
    }
    label227:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(203387);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203385);
    super.onCreate(paramBundle);
    getWindow().setDimAmount(0.0F);
    AppMethodBeat.o(203385);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(203386);
    k.h(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (aov())
    {
      if (localWindow == null) {
        k.fvU();
      }
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(2131821249);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!aov()) {
        break label184;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(2131307621).setOnClickListener((View.OnClickListener)new c(this));
      super.setContentView(paramView);
      this.targetView = paramView;
      paramView = new com.tencent.mm.search.d.a(paramView, (com.tencent.mm.search.d.b)this.KzD);
      this.fPd.a((com.tencent.mm.ui.j.a)paramView);
      paramView = getWindow();
      if (paramView == null) {
        k.fvU();
      }
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(203386);
      return;
      if (localWindow == null) {
        k.fvU();
      }
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(2131820790);
      break;
      label184:
      localLayoutParams.width = -1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.search.d.b
  {
    public final void dKU()
    {
      long l1 = 0L;
      AppMethodBeat.i(203382);
      View localView = a.a(this.KzF);
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
        AppMethodBeat.o(203382);
        return;
        AppMethodBeat.o(203382);
        return;
        label104:
        l1 = l2;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(203381);
        new ap().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203380);
            if (this.KzH.KzG.KzF.isShowing()) {
              this.KzH.KzG.KzF.cancel();
            }
            AppMethodBeat.o(203380);
          }
        });
        AppMethodBeat.o(203381);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203383);
      if (this.KzF.isShowing()) {
        this.KzF.cancel();
      }
      AppMethodBeat.o(203383);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */