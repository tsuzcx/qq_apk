package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.ui.v3.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "bannerRv", "Landroidx/recyclerview/widget/RecyclerView;", "lastActionX", "", "lastActionY", "layoutManager", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerLayoutManager;", "setting", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$BannerConfig;", "sizeResolver", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "getSizeResolver", "()Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "setSizeResolver", "(Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;)V", "snapHelper", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerPageSnapHelper;", "timerHandler", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$TimerHandler;", "checkConfigNeedChange", "", "maxCompleteVisibleBannerCount", "", "createDefaultAdapterInstance", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerAdapter;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getCurrentAdapter", "getCurrentBannerConfig", "getDefaultBannerConfig", "getDefaultLayoutManger", "getNoLoopLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onSizeChanged", "w", "h", "oldw", "oldh", "setUp", "bannerConfig", "startAutoSlide", "stopAutoSlide", "updateConfig", "BannerConfig", "Companion", "TimerHandler", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3BannerView
  extends FrameLayout
{
  public static final EmojiStoreV3BannerView.b ybc;
  private final String TAG;
  private RecyclerView.a<?> mlt;
  private k xZu;
  private a ybd;
  private final EmojiStoreV3BannerLayoutManager ybe;
  private c ybf;
  private c ybg;
  private final RecyclerView ybh;
  private float ybi;
  private float ybj;
  
  static
  {
    AppMethodBeat.i(270594);
    ybc = new EmojiStoreV3BannerView.b((byte)0);
    AppMethodBeat.o(270594);
  }
  
  public EmojiStoreV3BannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270554);
    this.ybd = getDefaultBannerConfig();
    this.ybe = getDefaultLayoutManger();
    this.ybf = new c();
    this.TAG = "MicroMsg.EmojiStoreV3BannerView";
    paramContext = LayoutInflater.from(paramContext).inflate(h.f.emoji_store_v3_banner_recylerview, (ViewGroup)this, true).findViewById(h.e.banner_recycler_view);
    s.s(paramContext, "from(context).inflate(R.….id.banner_recycler_view)");
    this.ybh = ((RecyclerView)paramContext);
    AppMethodBeat.o(270554);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(270564);
    s.u(parama, "bannerConfig");
    this.ybd = parama;
    if (parama.ybl)
    {
      Object localObject = Looper.getMainLooper();
      s.s(localObject, "getMainLooper()");
      this.ybg = new c(this, (Looper)localObject);
      if (!parama.loop) {
        break label173;
      }
      this.ybf.a(this.ybh);
      this.ybf.ybb = this.ybd.ybo;
      this.ybf.loop = parama.loop;
      localObject = this.ybe;
      ((EmojiStoreV3BannerLayoutManager)localObject).loop = parama.loop;
      ((EmojiStoreV3BannerLayoutManager)localObject).yaX = parama.ybn;
      ((EmojiStoreV3BannerLayoutManager)localObject).yaY = parama.yaY;
      ((EmojiStoreV3BannerLayoutManager)localObject).vqv = parama.ybk;
      this.ybh.setLayoutManager((RecyclerView.LayoutManager)this.ybe);
    }
    for (;;)
    {
      parama = this.ybh.getAdapter();
      if (parama != null) {
        parama.bZE.notifyChanged();
      }
      AppMethodBeat.o(270564);
      return;
      this.ybg = null;
      break;
      label173:
      this.ybf.a(null);
      this.ybh.setLayoutManager((RecyclerView.LayoutManager)getNoLoopLayoutManager());
      if (this.ybh.getItemDecorationCount() == 0) {
        this.ybh.a((RecyclerView.h)new b(parama.yaY));
      }
    }
  }
  
  public final void KD(int paramInt)
  {
    AppMethodBeat.i(270648);
    a locala = getCurrentBannerConfig();
    if (this.mlt != null)
    {
      if (paramInt < 2) {
        break label50;
      }
      locala.ybl = false;
      locala.ybk = true;
    }
    for (locala.loop = false;; locala.loop = true)
    {
      a(locala);
      AppMethodBeat.o(270648);
      return;
      label50:
      locala.ybl = true;
      locala.ybk = true;
    }
  }
  
  public final void a(a parama, RecyclerView.a<?> parama1)
  {
    AppMethodBeat.i(270638);
    s.u(parama, "bannerConfig");
    s.u(parama1, "adapter");
    a(parama);
    this.mlt = parama1;
    this.ybh.setAdapter(parama1);
    Log.i(this.TAG, s.X("banner setUp, adapter hash: ", Integer.valueOf(parama1.hashCode())));
    AppMethodBeat.o(270638);
  }
  
  public final void dCU()
  {
    AppMethodBeat.i(270622);
    c localc = this.ybg;
    if (localc != null) {
      localc.sendEmptyMessageDelayed(1, this.ybd.ybm);
    }
    AppMethodBeat.o(270622);
  }
  
  public final void dCV()
  {
    AppMethodBeat.i(270633);
    c localc = this.ybg;
    if (localc != null) {
      localc.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(270633);
  }
  
  public final a dCW()
  {
    AppMethodBeat.i(270675);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = new a((Context)localObject, new LinkedList());
    AppMethodBeat.o(270675);
    return localObject;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(270615);
    if (paramMotionEvent == null)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(270615);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(270615);
      return bool;
      requestDisallowInterceptTouchEvent(true);
      if (this.ybd.ybl) {
        dCV();
      }
      this.ybi = paramMotionEvent.getX();
      this.ybj = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (Math.abs(this.ybi - f1) >= Math.abs(this.ybj - f2)) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      for (;;)
      {
        Log.d(this.TAG, "XEvent:" + bool + ", deltaX:" + Math.abs(this.ybi - f1) + ", deltaY:" + Math.abs(this.ybj - f2) + ", eventX:" + f1 + ", eventY:" + f2);
        if (this.ybd.ybk) {
          break;
        }
        AppMethodBeat.o(270615);
        return false;
        getParent().requestDisallowInterceptTouchEvent(false);
        bool = false;
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      if (this.ybd.ybl) {
        dCU();
      }
    }
  }
  
  public final RecyclerView.a<?> getCurrentAdapter()
  {
    return this.mlt;
  }
  
  public final a getCurrentBannerConfig()
  {
    return this.ybd;
  }
  
  public final a getDefaultBannerConfig()
  {
    AppMethodBeat.i(270652);
    a locala = new a((byte)0);
    AppMethodBeat.o(270652);
    return locala;
  }
  
  public final EmojiStoreV3BannerLayoutManager getDefaultLayoutManger()
  {
    AppMethodBeat.i(270654);
    EmojiStoreV3BannerLayoutManager localEmojiStoreV3BannerLayoutManager = new EmojiStoreV3BannerLayoutManager();
    AppMethodBeat.o(270654);
    return localEmojiStoreV3BannerLayoutManager;
  }
  
  public final LinearLayoutManager getNoLoopLayoutManager()
  {
    AppMethodBeat.i(270660);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(0, false);
    AppMethodBeat.o(270660);
    return localLinearLayoutManager;
  }
  
  public final k getSizeResolver()
  {
    return this.xZu;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(270607);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.TAG, "onSizeChanged w:" + paramInt1 + ", h:" + paramInt2 + ", oldw::" + paramInt3 + ", oldH:" + paramInt4);
    k localk = this.xZu;
    if (localk != null)
    {
      localk.KI(paramInt1);
      KD(localk.spanCount);
    }
    AppMethodBeat.o(270607);
  }
  
  public final void setSizeResolver(k paramk)
  {
    this.xZu = paramk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$BannerConfig;", "", "loop", "", "enableSlideByTouch", "enableAutoSlide", "slideTimeGap", "", "autoSlideSpeed", "", "firstBannerStayX", "itemIntervalPx", "(ZZZJIII)V", "getAutoSlideSpeed", "()I", "setAutoSlideSpeed", "(I)V", "getEnableAutoSlide", "()Z", "setEnableAutoSlide", "(Z)V", "getEnableSlideByTouch", "setEnableSlideByTouch", "getFirstBannerStayX", "setFirstBannerStayX", "getItemIntervalPx", "setItemIntervalPx", "getLoop", "setLoop", "getSlideTimeGap", "()J", "setSlideTimeGap", "(J)V", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean loop = false;
    public int yaY = 30;
    public boolean ybk = true;
    public boolean ybl = true;
    public long ybm = 5000L;
    int ybn = 500;
    public int ybo = 0;
    
    private a() {}
    
    public a(char paramChar)
    {
      this((byte)0);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$TimerHandler;", "Landroid/os/Handler;", "view", "Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView;", "looper", "Landroid/os/Looper;", "(Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView;Landroid/os/Looper;)V", "bannerView", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "Companion", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends Handler
  {
    public static final EmojiStoreV3BannerView.c.a ybp;
    private final WeakReference<EmojiStoreV3BannerView> ybq;
    
    static
    {
      AppMethodBeat.i(270557);
      ybp = new EmojiStoreV3BannerView.c.a((byte)0);
      AppMethodBeat.o(270557);
    }
    
    public c(EmojiStoreV3BannerView paramEmojiStoreV3BannerView, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(270550);
      this.ybq = new WeakReference(paramEmojiStoreV3BannerView);
      AppMethodBeat.o(270550);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(270578);
      s.u(paramMessage, "msg");
      EmojiStoreV3BannerView localEmojiStoreV3BannerView = (EmojiStoreV3BannerView)this.ybq.get();
      if (localEmojiStoreV3BannerView == null)
      {
        AppMethodBeat.o(270578);
        return;
      }
      if (paramMessage.what == 1)
      {
        int i = EmojiStoreV3BannerView.a(localEmojiStoreV3BannerView).getCurrentPosition();
        paramMessage = EmojiStoreV3BannerView.b(localEmojiStoreV3BannerView);
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i + 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramMessage, locala.aYi(), "com/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$TimerHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramMessage.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramMessage, "com/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerView$TimerHandler", "handleMessage", "(Landroid/os/Message;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        sendEmptyMessageDelayed(1, EmojiStoreV3BannerView.a(localEmojiStoreV3BannerView).yaX + EmojiStoreV3BannerView.c(localEmojiStoreV3BannerView).ybm);
      }
      AppMethodBeat.o(270578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.EmojiStoreV3BannerView
 * JD-Core Version:    0.7.0.1
 */