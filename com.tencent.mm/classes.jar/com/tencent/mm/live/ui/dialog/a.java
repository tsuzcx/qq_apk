package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.i;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "mIsActive", "needCancelTouch", "targetView", "Landroid/view/View;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "view", "wrapSheet", "layoutResId", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  private static final String TAG;
  public static final a.a nme;
  private Context mContext;
  private com.tencent.mm.ui.o.b mke;
  private View nmf;
  private final b nmg;
  private boolean nmh;
  private boolean nmi;
  private boolean nmj;
  
  static
  {
    AppMethodBeat.i(246378);
    nme = new a.a((byte)0);
    TAG = "MicroMsg.LiveMicDialog";
    AppMethodBeat.o(246378);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, b.i.CustomSheetStyle);
    AppMethodBeat.i(246355);
    this.mContext = paramContext;
    this.nmg = new b(this);
    bU();
    paramContext = getContext();
    s.s(paramContext, "context");
    this.mke = new com.tencent.mm.ui.o.b(paramContext);
    AppMethodBeat.o(246355);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(246364);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveMicDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    if (parama.isShowing()) {
      parama.cancel();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveMicDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246364);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(246415);
    s.u(paramMotionEvent, "ev");
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      this.mke.aw(paramMotionEvent);
      int i = this.mke.Irw;
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if ((this.nmi) || (this.nmh)) {
            break label166;
          }
          bool1 = this.mke.dispatchTouchEvent(paramMotionEvent);
        }
      }
      break;
    }
    for (;;)
    {
      if ((!this.nmi) && (!bool1)) {
        break label225;
      }
      if (!this.nmj)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.nmj = true;
      }
      AppMethodBeat.o(246415);
      return true;
      this.nmj = false;
      this.nmi = false;
      break;
      label166:
      bool1 = bool2;
      if (!this.nmj)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        com.tencent.mm.ui.o.b localb = this.mke;
        s.s(localMotionEvent, "cancelEvent");
        localb.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        this.nmj = true;
        bool1 = bool2;
      }
    }
    label225:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(246415);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246391);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.0F);
    }
    AppMethodBeat.o(246391);
  }
  
  public final void setContentView(View paramView)
  {
    int i = 0;
    AppMethodBeat.i(246403);
    s.u(paramView, "view");
    Window localWindow = getWindow();
    s.checkNotNull(localWindow);
    localWindow.setGravity(80);
    localWindow.setWindowAnimations(b.i.BottomToTopSlowAnimation);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (this.mContext.getResources().getConfiguration().orientation == 2) {
      i = 1;
    }
    if (i != 0) {
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      paramView.findViewById(b.e.live_mic_outside).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      super.setContentView(paramView);
      this.nmf = paramView;
      paramView = new com.tencent.mm.search.a.a(paramView, (com.tencent.mm.search.a.b)this.nmg);
      this.mke.a((com.tencent.mm.ui.o.a)paramView);
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setLayout(-1, -1);
      AppMethodBeat.o(246403);
      return;
      localLayoutParams.width = -1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveMicDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    b(a parama) {}
    
    private static final void b(a parama, View paramView)
    {
      AppMethodBeat.i(246386);
      s.u(parama, "this$0");
      s.u(paramView, "$it");
      if (parama.isShowing()) {
        parama.cancel();
      }
      paramView.setTranslationY(0.0F);
      AppMethodBeat.o(246386);
    }
    
    private static final void c(a parama, View paramView)
    {
      AppMethodBeat.i(246394);
      s.u(parama, "this$0");
      s.u(paramView, "$it");
      new MMHandler().post(new a.b..ExternalSyntheticLambda0(parama, paramView));
      AppMethodBeat.o(246394);
    }
    
    public final void bkW()
    {
      long l1 = 0L;
      AppMethodBeat.i(246420);
      View localView = a.a(this.nmk);
      a locala;
      long l2;
      if (localView != null)
      {
        locala = this.nmk;
        localView.setEnabled(false);
        l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
        if (l2 >= 0L) {
          break label104;
        }
      }
      for (;;)
      {
        localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction(new a.b..ExternalSyntheticLambda1(locala, localView)).start();
        AppMethodBeat.o(246420);
        return;
        label104:
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */