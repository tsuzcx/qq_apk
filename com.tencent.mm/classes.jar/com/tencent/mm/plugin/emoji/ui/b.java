package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.emojisearch.d.a;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "Landroid/support/v7/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "talkName", "", "toSendText", "panelCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "needCancelTouch", "getPanelCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getTalkName", "()Ljava/lang/String;", "targetView", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchView;", "getToSendText", "checkFocus", "", "dismiss", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "show", "wrapSheet", "Companion", "plugin-emojisdk_release"})
public final class b
  extends e
{
  public static final b.a rgJ;
  private com.tencent.mm.ui.m.b gZR;
  private boolean hVn;
  private boolean hVo;
  private boolean hVp;
  private Context mContext;
  final String rgD;
  public c rgF;
  private final b rgG;
  private final String rgH;
  private final j rgI;
  
  static
  {
    AppMethodBeat.i(200055);
    rgJ = new b.a((byte)0);
    AppMethodBeat.o(200055);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, j paramj)
  {
    super(paramContext, 2131820878);
    AppMethodBeat.i(200054);
    this.mContext = paramContext;
    this.rgD = paramString1;
    this.rgH = paramString2;
    this.rgI = paramj;
    this.rgF = new c((Context)new u(this.mContext, 2131820879), this.rgD, this.rgH, this, this.rgI);
    gR();
    paramContext = getContext();
    p.g(paramContext, "context");
    this.gZR = new com.tencent.mm.ui.m.b(paramContext);
    this.rgF.cHs();
    this.rgG = new b(this);
    AppMethodBeat.o(200054);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(200051);
    Resources localResources = this.mContext.getResources();
    p.g(localResources, "mContext.resources");
    if (localResources.getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(200051);
      return true;
    }
    AppMethodBeat.o(200051);
    return false;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200050);
    Log.i("MicroMsg.EmojiSearch", "dialog dismiss");
    this.rgF.hideVKB();
    super.dismiss();
    this.rgI.N(false, 0);
    AppMethodBeat.o(200050);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(200053);
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
      AppMethodBeat.o(200053);
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
    AppMethodBeat.o(200053);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200047);
    super.onCreate(paramBundle);
    paramBundle = this.rgI;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramBundle.N(true, localContext.getResources().getDimensionPixelOffset(2131165288));
    setContentView((View)this.rgF);
    AppMethodBeat.o(200047);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(200049);
    Log.i("MicroMsg.EmojiSearch", "dialog onStop");
    super.onStop();
    this.rgF.rgN.onDestroy();
    AppMethodBeat.o(200049);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(200052);
    p.h(paramView, "view");
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      if (localObject == null) {
        p.hyc();
      }
      ((Window)localObject).setGravity(5);
      ((Window)localObject).setWindowAnimations(2131821287);
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
      int i = ad.bD(getContext());
      localObject = getContext();
      p.g(localObject, "context");
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, i + ((Context)localObject).getResources().getDimensionPixelOffset(2131165294)));
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setLayout(-1, -2);
      paramView = getWindow();
      if (paramView == null) {
        p.hyc();
      }
      paramView.setFlags(256, 256);
      AppMethodBeat.o(200052);
      return;
      if (localObject == null) {
        p.hyc();
      }
      ((Window)localObject).setGravity(80);
      ((Window)localObject).setWindowAnimations(2131820793);
      break;
      label202:
      localLayoutParams.width = -1;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(200048);
    Log.i("MicroMsg.EmojiSearch", "dialog show");
    super.show();
    Object localObject = this.rgF;
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((c)localObject).rgH)) {
        break label74;
      }
      ((c)localObject).het = 1;
      ((c)localObject).rgP.awD();
      ((c)localObject).rgP.awC();
    }
    for (;;)
    {
      localObject = a.hew;
      a.Fb(this.rgD);
      AppMethodBeat.o(200048);
      return;
      label74:
      ((c)localObject).het = 2;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    public final void aJl()
    {
      long l1 = 0L;
      AppMethodBeat.i(200046);
      c localc = b.a(this.rgK);
      localc.setEnabled(false);
      long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
        AppMethodBeat.o(200046);
        return;
        l1 = l2;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
    static final class a
      implements Runnable
    {
      a(b.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(200045);
        new MMHandler().post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200044);
            if (this.rgM.rgL.rgK.isShowing()) {
              this.rgM.rgL.rgK.cancel();
            }
            AppMethodBeat.o(200044);
          }
        });
        AppMethodBeat.o(200045);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.b
 * JD-Core Version:    0.7.0.1
 */