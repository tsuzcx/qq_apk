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
import com.tencent.mm.api.ae;
import com.tencent.mm.emojisearch.ui.EmojiSearchEditTextView;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.k;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.z;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mContext", "Landroid/content/Context;", "talkName", "", "toSendText", "panelCallback", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "commentScrolling", "", "galleryScale", "com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1;", "galleryScrollHelper", "Lcom/tencent/mm/ui/recyclerview/GalleryScrollHelper;", "hasDispatchCancel", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mIsActive", "needCancelTouch", "getPanelCallback", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "getTalkName", "()Ljava/lang/String;", "targetView", "Lcom/tencent/mm/emojisearch/ui/EmojiSearchView;", "getToSendText", "checkFocus", "", "dismiss", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isLandscape", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "setContentView", "view", "Landroid/view/View;", "show", "wrapSheet", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final b.a xSD;
  private Context mContext;
  private com.tencent.mm.ui.o.b mke;
  public final String mpr;
  private final String mps;
  private final j mpu;
  private boolean nmh;
  private boolean nmi;
  private boolean nmj;
  private com.tencent.mm.emojisearch.ui.a xSE;
  private final b xSF;
  
  static
  {
    AppMethodBeat.i(270360);
    xSD = new b.a((byte)0);
    AppMethodBeat.o(270360);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, j paramj)
  {
    super(paramContext, a.k.EmojiDialog);
    AppMethodBeat.i(270348);
    this.mContext = paramContext;
    this.mpr = paramString1;
    this.mps = paramString2;
    this.mpu = paramj;
    paramj = (Context)new z(this.mContext, a.k.EmojiPanel);
    paramString1 = this.mpr;
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = "";
    }
    paramString2 = this.mps;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.xSE = new com.tencent.mm.emojisearch.ui.a(paramj, paramContext, paramString1, this, this.mpu);
    bU();
    paramContext = getContext();
    s.s(paramContext, "context");
    this.mke = new com.tencent.mm.ui.o.b(paramContext);
    this.xSE.aWV();
    this.xSF = new b(this);
    AppMethodBeat.o(270348);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(270352);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(270352);
      return true;
    }
    AppMethodBeat.o(270352);
    return false;
  }
  
  public final void dBD()
  {
    AppMethodBeat.i(270385);
    com.tencent.mm.emojisearch.ui.a locala = this.xSE;
    if (locala.mpx.hasFocus()) {
      locala.mpx.aWS();
    }
    AppMethodBeat.o(270385);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(270377);
    Log.i("MicroMsg.EmojiSearch", "dialog dismiss");
    this.xSE.hideVKB();
    super.dismiss();
    this.mpu.y(false, 0);
    AppMethodBeat.o(270377);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(270390);
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
        break label226;
      }
      if (!this.nmj)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        paramMotionEvent.recycle();
        this.nmj = true;
      }
      AppMethodBeat.o(270390);
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
    label226:
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(270390);
    return bool1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270363);
    super.onCreate(paramBundle);
    this.mpu.y(true, getContext().getResources().getDimensionPixelOffset(a.e.Edge_18A));
    setContentView((View)this.xSE);
    AppMethodBeat.o(270363);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(270372);
    Log.i("MicroMsg.EmojiSearch", "dialog onStop");
    super.onStop();
    ar.a(this.xSE.mainScope, null);
    AppMethodBeat.o(270372);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(270381);
    s.u(paramView, "view");
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams;
    if (isLandscape())
    {
      s.checkNotNull(localWindow);
      localWindow.setGravity(5);
      localWindow.setWindowAnimations(a.k.RightToLeftAnimation);
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = localWindow.getAttributes();
      if (!isLandscape()) {
        break label176;
      }
      localLayoutParams.width = -2;
    }
    for (localLayoutParams.height = -1;; localLayoutParams.height = -2)
    {
      localWindow.setAttributes(localLayoutParams);
      super.setContentView(paramView, new ViewGroup.LayoutParams(-1, ae.cp(getContext()) + getContext().getResources().getDimensionPixelOffset(a.e.Edge_25A)));
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setLayout(-1, -2);
      paramView = getWindow();
      s.checkNotNull(paramView);
      paramView.setFlags(256, 256);
      AppMethodBeat.o(270381);
      return;
      s.checkNotNull(localWindow);
      localWindow.setGravity(80);
      localWindow.setWindowAnimations(a.k.BottomToTopSlowAnimation);
      break;
      label176:
      localLayoutParams.width = -1;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(270367);
    Log.i("MicroMsg.EmojiSearch", "dialog show");
    super.show();
    Object localObject = this.xSE;
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((com.tencent.mm.emojisearch.ui.a)localObject).mps)) {
        break label85;
      }
      ((com.tencent.mm.emojisearch.ui.a)localObject).mpb = 1;
      ((com.tencent.mm.emojisearch.ui.a)localObject).mpx.aWT();
      ((com.tencent.mm.emojisearch.ui.a)localObject).mpx.aWS();
    }
    for (;;)
    {
      localObject = com.tencent.mm.emojisearch.c.a.moZ;
      String str = this.mpr;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.emojisearch.c.a.EA((String)localObject);
      AppMethodBeat.o(270367);
      return;
      label85:
      ((com.tencent.mm.emojisearch.ui.a)localObject).mpb = 2;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/EmojiSearchDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.search.a.b
  {
    b(b paramb) {}
    
    private static final void b(b paramb)
    {
      AppMethodBeat.i(270436);
      s.u(paramb, "this$0");
      if (paramb.isShowing()) {
        paramb.cancel();
      }
      AppMethodBeat.o(270436);
    }
    
    private static final void c(b paramb)
    {
      AppMethodBeat.i(270438);
      s.u(paramb, "this$0");
      new MMHandler().post(new b.b..ExternalSyntheticLambda0(paramb));
      AppMethodBeat.o(270438);
    }
    
    public final void bkW()
    {
      long l1 = 0L;
      AppMethodBeat.i(270444);
      com.tencent.mm.emojisearch.ui.a locala = b.a(this.xSG);
      b localb = this.xSG;
      locala.setEnabled(false);
      long l2 = ((locala.getHeight() - locala.getTranslationY()) / locala.getHeight() * 300.0F);
      if (l2 < 0L) {}
      for (;;)
      {
        locala.animate().translationY(locala.getHeight()).setDuration(l1).withEndAction(new b.b..ExternalSyntheticLambda1(localb)).start();
        AppMethodBeat.o(270444);
        return;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.b
 * JD-Core Version:    0.7.0.1
 */