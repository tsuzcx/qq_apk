package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.h;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "deleteExeFuture", "Ljava/util/concurrent/Future;", "deleteFuture", "deleteKeyType", "deleteKeyWidth", "lastDeleteKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "mLastClickTime", "", "mLastClickView", "Landroid/view/View;", "mLastUpperMode", "mUpperMode", "supportDoubleKeyOnClickHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "triggerLeftDeleteMode", "", "closeDeleteTouch", "", "v", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "event", "Landroid/view/MotionEvent;", "doDelete", "deleteLength", "delayTime", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getUpperMode", "handleDeleteKey", "reportKeyArea", "(Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;Landroid/view/MotionEvent;Ljava/lang/Integer;)Z", "handleDoubleClick", "isOnlySupportClickFloatViewKey", "view", "isSupportFloatViewKey", "isUpper", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onReset", "onResume", "listener", "onSelectCandidate", "text", "", "id", "", "suffix", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "supportDoubleClick", "switchUpperMode", "upperMode", "transparentBg", "transparent", "updateEnterKey", "actionStr", "actionMode", "updateUpperKey", "updateUpperKeyImp", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ImeKeyboard
  extends Keyboard
{
  public static final ImeKeyboard.a JqV;
  private com.tencent.mm.plugin.hld.a.c Jpf;
  private int JqW;
  private int JqX;
  private View JqY;
  private long JqZ;
  private final MMHandler Jra;
  private Future<?> Jrb;
  private Future<?> Jrc;
  private int Jrd;
  private b Jre;
  private int Jrf;
  private boolean Jrg;
  
  static
  {
    AppMethodBeat.i(313072);
    JqV = new ImeKeyboard.a((byte)0);
    AppMethodBeat.o(313072);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(312999);
    this.JqX = 1;
    this.Jra = ((MMHandler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(312999);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313006);
    this.JqX = 1;
    this.Jra = ((MMHandler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(313006);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(313014);
    this.JqX = 1;
    this.Jra = ((MMHandler)new b(this, Looper.getMainLooper()));
    AppMethodBeat.o(313014);
  }
  
  private static final void a(long paramLong, ImeKeyboard paramImeKeyboard, int paramInt)
  {
    AppMethodBeat.i(313065);
    s.u(paramImeKeyboard, "this$0");
    Log.i("WxIme.ImeKeyboard", s.X("doDeleteImp inter time:", Long.valueOf(System.currentTimeMillis() - paramLong)));
    com.tencent.mm.plugin.hld.a.c localc = paramImeKeyboard.getMKeyboardActionListener();
    if (localc != null) {
      localc.K(1, new Keyboard.a(paramImeKeyboard.Jrd, paramInt));
    }
    AppMethodBeat.o(313065);
  }
  
  private static final void a(ImeKeyboard paramImeKeyboard)
  {
    AppMethodBeat.i(313057);
    s.u(paramImeKeyboard, "this$0");
    for (;;)
    {
      int i;
      long l;
      try
      {
        Object localObject = e.Jym;
        Thread.sleep(e.fOd());
        int j = 1;
        i = j;
        if (paramImeKeyboard.Jrd == 2)
        {
          l = System.currentTimeMillis();
          localObject = paramImeKeyboard.Jre;
          s.checkNotNull(localObject);
          l -= ((b)localObject).time;
          if (l > 2000L) {
            i = 3;
          }
        }
        else
        {
          paramImeKeyboard.aE(i, 0L);
          continue;
        }
        i = j;
      }
      catch (InterruptedException paramImeKeyboard)
      {
        Log.e("WxIme.ImeKeyboard", s.X("deleteFuture ", paramImeKeyboard.getMessage()));
        AppMethodBeat.o(313057);
        return;
      }
      if (l > 5000L) {
        i = 5;
      }
    }
  }
  
  public static boolean a(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(313029);
    s.u(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) != 2) && ((paramImeKeyRelativeLayout.getType() & 0x4) != 4))
    {
      l locall = l.JyV;
      if (!l.e(paramImeKeyRelativeLayout)) {}
    }
    else
    {
      AppMethodBeat.o(313029);
      return false;
    }
    AppMethodBeat.o(313029);
    return true;
  }
  
  private final void aE(int paramInt, long paramLong)
  {
    AppMethodBeat.i(313042);
    long l = System.currentTimeMillis();
    this.Jrc = ((Future)h.ahAA.o(new ImeKeyboard..ExternalSyntheticLambda0(l, this, paramInt), paramLong));
    AppMethodBeat.o(313042);
  }
  
  public static boolean b(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(313035);
    s.u(paramImeKeyRelativeLayout, "view");
    boolean bool = s.p(paramImeKeyRelativeLayout.fPs(), Boolean.TRUE);
    AppMethodBeat.o(313035);
    return bool;
  }
  
  public final void Yr(int paramInt)
  {
    this.JqW = this.JqX;
    this.JqX = paramInt;
  }
  
  public final void a(ImeKeyRelativeLayout paramImeKeyRelativeLayout, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(313188);
    s.u(paramImeKeyRelativeLayout, "v");
    l locall = l.JyV;
    if (!l.e(paramImeKeyRelativeLayout))
    {
      paramImeKeyRelativeLayout = this.Jrb;
      if (paramImeKeyRelativeLayout != null)
      {
        paramImeKeyRelativeLayout.cancel(true);
        this.Jrb = null;
      }
      if (paramMotionEvent != null) {
        break label109;
      }
      paramImeKeyRelativeLayout = localObject;
      if (paramImeKeyRelativeLayout != null) {
        break label120;
      }
      label63:
      if (paramImeKeyRelativeLayout != null) {
        break label131;
      }
      label67:
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramImeKeyRelativeLayout = this.Jre;
        if (paramImeKeyRelativeLayout != null)
        {
          paramImeKeyRelativeLayout = (View)paramImeKeyRelativeLayout.viewRef.get();
          if (paramImeKeyRelativeLayout != null) {
            paramImeKeyRelativeLayout.setSelected(false);
          }
        }
      }
      AppMethodBeat.o(313188);
      return;
      label109:
      paramImeKeyRelativeLayout = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label120:
      if (paramImeKeyRelativeLayout.intValue() != 5) {
        break label63;
      }
      continue;
      label131:
      if (paramImeKeyRelativeLayout.intValue() != 0) {
        break label67;
      }
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(313160);
    s.u(paramString1, "text");
    s.u(paramArrayOfByte, "id");
    AppMethodBeat.o(313160);
  }
  
  protected final boolean a(ImeKeyRelativeLayout paramImeKeyRelativeLayout, MotionEvent paramMotionEvent, Integer paramInteger)
  {
    AppMethodBeat.i(313182);
    s.u(paramImeKeyRelativeLayout, "v");
    Object localObject1;
    Object localObject2;
    label30:
    int j;
    label50:
    long l1;
    label123:
    int i;
    if (paramMotionEvent == null)
    {
      localObject1 = null;
      if (paramMotionEvent != null) {
        break label325;
      }
      localObject2 = Double.valueOf(0.0D);
      j = (int)((Float)localObject2).floatValue();
      if (paramMotionEvent != null) {
        break label337;
      }
      paramMotionEvent = Double.valueOf(0.0D);
      int k = (int)((Float)paramMotionEvent).floatValue();
      l1 = System.currentTimeMillis();
      Log.d("WxIme.ImeKeyboard", "handleBackKey action " + localObject1 + ' ' + j + ' ' + k + ' ' + l1);
      if (localObject1 != null) {
        break label348;
      }
      if (localObject1 != null) {
        break label363;
      }
      label128:
      i = 0;
      label131:
      if (i == 0) {
        break label383;
      }
      paramMotionEvent = com.tencent.mm.plugin.hld.f.i.JyA;
      com.tencent.mm.plugin.hld.f.i.aC((View)paramImeKeyRelativeLayout, 2);
      this.Jre = new b(j, k, l1, null, new WeakReference(paramImeKeyRelativeLayout), 0L, 88);
      this.Jrf = ((ViewGroup)paramImeKeyRelativeLayout.findViewById(a.f.inside_root)).getWidth();
      paramImeKeyRelativeLayout.setSelected(true);
      paramImeKeyRelativeLayout = n.JvW;
      if (!n.fMH()) {
        break label377;
      }
      i = 2;
      label212:
      this.Jrd = i;
      paramImeKeyRelativeLayout = e.Jym;
      aE(1, e.fOe());
      paramImeKeyRelativeLayout = this.Jrb;
      if (paramImeKeyRelativeLayout != null) {
        paramImeKeyRelativeLayout.cancel(true);
      }
      paramImeKeyRelativeLayout = h.ahAA;
      paramMotionEvent = new ImeKeyboard..ExternalSyntheticLambda1(this);
      localObject1 = e.Jym;
      this.Jrb = ((Future)paramImeKeyRelativeLayout.p(paramMotionEvent, e.fOe()));
      if (paramInteger != null)
      {
        i = ((Number)paramInteger).intValue();
        paramImeKeyRelativeLayout = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.js(i, 1);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(313182);
      return false;
      localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      label325:
      localObject2 = Float.valueOf(paramMotionEvent.getRawX());
      break label30;
      label337:
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      break label50;
      label348:
      if (((Integer)localObject1).intValue() != 5) {
        break label123;
      }
      i = 1;
      break label131;
      label363:
      if (((Integer)localObject1).intValue() != 0) {
        break label128;
      }
      i = 1;
      break label131;
      label377:
      i = 1;
      break label212;
      label383:
      if (localObject1 == null)
      {
        if (localObject1 != null) {
          break label626;
        }
        if (localObject1 != null) {
          break label641;
        }
        i = 0;
        if (i == 0) {
          break label657;
        }
        i = 1;
      }
      for (;;)
      {
        label388:
        label393:
        label398:
        label401:
        if (i == 0) {
          break label681;
        }
        paramImeKeyRelativeLayout.setSelected(false);
        paramImeKeyRelativeLayout = this.Jrb;
        if (paramImeKeyRelativeLayout != null)
        {
          paramImeKeyRelativeLayout.cancel(true);
          this.Jrb = null;
        }
        if (!this.Jrg) {
          break label692;
        }
        this.Jrg = false;
        paramImeKeyRelativeLayout = this.Jre;
        if (paramImeKeyRelativeLayout == null) {
          break;
        }
        if (paramImeKeyRelativeLayout.x - j <= this.Jrf) {
          break label683;
        }
        n.JvW.fMR();
        break;
        if (((Integer)localObject1).intValue() != 2) {
          break label388;
        }
        if (this.Jrg) {
          break;
        }
        paramImeKeyRelativeLayout = this.Jre;
        if ((paramImeKeyRelativeLayout == null) || (this.Jrd != 1)) {
          break;
        }
        paramMotionEvent = this.Jre;
        s.checkNotNull(paramMotionEvent);
        l2 = paramMotionEvent.time;
        paramMotionEvent = e.Jym;
        if ((l1 - l2 >= e.fOe() - 5L) || (paramImeKeyRelativeLayout.x - j <= this.Jrf) || (this.Jrf == 0)) {
          break;
        }
        paramImeKeyRelativeLayout = this.Jrb;
        if (paramImeKeyRelativeLayout != null)
        {
          paramImeKeyRelativeLayout.cancel(true);
          this.Jrb = null;
        }
        paramImeKeyRelativeLayout = this.Jrc;
        if (paramImeKeyRelativeLayout != null)
        {
          paramImeKeyRelativeLayout.cancel(true);
          this.Jrc = null;
        }
        this.Jrg = true;
        break;
        label626:
        if (((Integer)localObject1).intValue() != 3) {
          break label393;
        }
        i = 1;
        break label401;
        label641:
        if (((Integer)localObject1).intValue() != 6) {
          break label398;
        }
        i = 1;
        break label401;
        label657:
        if (localObject1 == null) {}
        while (((Integer)localObject1).intValue() != 1)
        {
          i = 0;
          break;
        }
        i = 1;
      }
      label681:
      continue;
      label683:
      aE(1, 0L);
      continue;
      label692:
      paramImeKeyRelativeLayout = this.Jre;
      s.checkNotNull(paramImeKeyRelativeLayout);
      long l2 = paramImeKeyRelativeLayout.time;
      paramImeKeyRelativeLayout = e.Jym;
      if (l1 - l2 < e.fOe() - 5L)
      {
        paramImeKeyRelativeLayout = this.Jrc;
        if (paramImeKeyRelativeLayout != null)
        {
          paramImeKeyRelativeLayout.cancel(true);
          this.Jrc = null;
        }
        aE(1, 0L);
      }
    }
  }
  
  public void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.Jpf = paramc;
  }
  
  public void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(313148);
    s.u(paramString, "actionStr");
    ImeKeyButton localImeKeyButton = getActionKey();
    if (localImeKeyButton != null) {
      ImeKeyRelativeLayout.a((ImeKeyRelativeLayout)localImeKeyButton, paramString);
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(313148);
      return;
    case 2: 
      localImeKeyButton.setClickable(true);
      paramString = com.tencent.mm.plugin.hld.f.k.JyF;
      if (com.tencent.mm.plugin.hld.f.k.YI(localImeKeyButton.getViewType()))
      {
        paramString = localImeKeyButton.getInsideView();
        if (paramString != null) {
          paramString.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
        }
      }
      for (;;)
      {
        localImeKeyButton.YM(a.c.ime_key_text_color);
        AppMethodBeat.o(313148);
        return;
        localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
      }
    case 3: 
      localImeKeyButton.setClickable(true);
      paramString = com.tencent.mm.plugin.hld.f.k.JyF;
      if (com.tencent.mm.plugin.hld.f.k.YI(localImeKeyButton.getViewType()))
      {
        paramString = localImeKeyButton.getInsideView();
        if (paramString != null) {
          paramString.setBackground(getResources().getDrawable(a.e.ime_key_green_bg));
        }
      }
      for (;;)
      {
        localImeKeyButton.YM(a.c.White);
        AppMethodBeat.o(313148);
        return;
        localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_green_bg));
      }
    }
    localImeKeyButton.setClickable(false);
    paramString = com.tencent.mm.plugin.hld.f.k.JyF;
    if (com.tencent.mm.plugin.hld.f.k.YI(localImeKeyButton.getViewType()))
    {
      paramString = localImeKeyButton.getInsideView();
      if (paramString != null) {
        paramString.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
      }
    }
    for (;;)
    {
      localImeKeyButton.YM(a.c.S2_text_invalid_color);
      break;
      localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
    }
  }
  
  public final boolean fLL()
  {
    return this.JqX != 1;
  }
  
  public final void fLM()
  {
    AppMethodBeat.i(313131);
    if (this.JqW != this.JqX) {
      fLN();
    }
    AppMethodBeat.o(313131);
  }
  
  protected void fLN() {}
  
  protected ImeKeyButton getActionKey()
  {
    return null;
  }
  
  public c getKeyboardType()
  {
    return c.Jrp;
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.Jpf;
  }
  
  public int getUpperMode()
  {
    return this.JqX;
  }
  
  public boolean hL(View paramView)
  {
    return false;
  }
  
  public void hM(View paramView) {}
  
  public void hN(View paramView) {}
  
  public final boolean hO(View paramView)
  {
    AppMethodBeat.i(313171);
    View localView = this.JqY;
    long l = this.JqZ;
    this.JqY = paramView;
    this.JqZ = System.currentTimeMillis();
    if (!hL(paramView))
    {
      AppMethodBeat.o(313171);
      return false;
    }
    if ((s.p(paramView, localView)) && (System.currentTimeMillis() - l <= 200L))
    {
      hN(paramView);
      AppMethodBeat.o(313171);
      return true;
    }
    Log.d("WxIme.ImeKeyboard", "supportDoubleKeyOnClickHandler");
    hM(paramView);
    AppMethodBeat.o(313171);
    return true;
  }
  
  public void onCreate() {}
  
  public void onReset()
  {
    AppMethodBeat.i(313108);
    Yr(1);
    fLM();
    AppMethodBeat.o(313108);
  }
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.Jpf = paramc;
  }
  
  public void wS(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/keyboard/ImeKeyboard$supportDoubleKeyOnClickHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(ImeKeyboard paramImeKeyboard, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(312945);
      s.u(paramMessage, "msg");
      Log.d("WxIme.ImeKeyboard", "supportDoubleKeyOnClickHandler");
      this.Jrh.hM((View)paramMessage.obj);
      AppMethodBeat.o(312945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.ImeKeyboard
 * JD-Core Version:    0.7.0.1
 */