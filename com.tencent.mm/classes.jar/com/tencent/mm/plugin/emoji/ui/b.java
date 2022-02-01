package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.emojisearch.d.a;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.x;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "talkName", "", "toSendText", "panelCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "needCancelTouch", "getPanelCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getTalkName", "()Ljava/lang/String;", "targetView", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView;", "getToSendText", "checkFocus", "", "dismiss", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "show", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final a uJS;
  private com.tencent.mm.ui.o.b jKS;
  private boolean kJN;
  private boolean kJO;
  private boolean kJP;
  private Context mContext;
  final String uJM;
  public c uJO;
  private final b uJP;
  private final String uJQ;
  private final j uJR;
  
  static
  {
    AppMethodBeat.i(233750);
    uJS = new a((byte)0);
    AppMethodBeat.o(233750);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, j paramj)
  {
    super(paramContext, a.k.EmojiDialog);
    AppMethodBeat.i(233748);
    this.mContext = paramContext;
    this.uJM = paramString1;
    this.uJQ = paramString2;
    this.uJR = paramj;
    this.uJO = new c((Context)new x(this.mContext, a.k.EmojiPanel), this.uJM, this.uJQ, this, this.uJR);
    bb();
    paramContext = getContext();
    p.j(paramContext, "context");
    this.jKS = new com.tencent.mm.ui.o.b(paramContext);
    this.uJO.cVZ();
    this.uJP = new b(this);
    AppMethodBeat.o(233748);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(233742);
    Resources localResources = this.mContext.getResources();
    p.j(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(233742);
      return true;
    }
    AppMethodBeat.o(233742);
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(233741);
    Log.i("MicroMsg.EmojiSearch", "dialog dismiss");
    this.uJO.hideVKB();
    super.dismiss();
    this.uJR.A(false, 0);
    AppMethodBeat.o(233741);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(233746);
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
      AppMethodBeat.o(233746);
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
    AppMethodBeat.o(233746);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233735);
    super.onCreate(paramBundle);
    paramBundle = this.uJR;
    Context localContext = getContext();
    p.j(localContext, "context");
    paramBundle.A(true, localContext.getResources().getDimensionPixelOffset(a.e.Edge_18A));
    setContentView((View)this.uJO);
    AppMethodBeat.o(233735);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233739);
    Log.i("MicroMsg.EmojiSearch", "dialog onStop");
    super.onStop();
    this.uJO.uJW.onDestroy();
    AppMethodBeat.o(233739);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(233745);
    p.k(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localObject == null) {
        p.iCn();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(a.k.RightToLeftAnimation);
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!isLandscape()) {
        break label202;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = ad.bC(getContext());
      localObject = getContext();
      p.j(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(a.e.Edge_25A)));
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setLayout(-1, -2);
      paramView = getWindow();
      if (paramView == null) {
        p.iCn();
      }
      paramView.setFlags(256, 256);
      AppMethodBeat.o(233745);
      return;
      if (localObject == null) {
        p.iCn();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(a.k.BottomToTopSlowAnimation);
      break;
      label202:
      localLayoutParams.width = -1;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(233737);
    Log.i("MicroMsg.EmojiSearch", "dialog show");
    super.show();
    Object localObject = this.uJO;
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((c)localObject).uJQ)) {
        break label74;
      }
      ((c)localObject).jQj = 1;
      ((c)localObject).uJY.aDU();
      ((c)localObject).uJY.aDT();
    }
    for (;;)
    {
      localObject = a.jQm;
      a.LU(this.uJM);
      AppMethodBeat.o(233737);
      return;
      label74:
      ((c)localObject).jQj = 2;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aRj()
    {
      long l1 = 0L;
      AppMethodBeat.i(226505);
      c localc = b.a(this.uJT);
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(226505);
        return;
        l1 = l2;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(229005);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223705);
            if (this.uJV.uJU.uJT.isShowing()) {
              this.uJV.uJU.uJT.cancel();
            }
            AppMethodBeat.o(223705);
          }
        });
        AppMethodBeat.o(229005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.b
 * JD-Core Version:    0.7.0.1
 */