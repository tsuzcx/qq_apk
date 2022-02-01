package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.f.e;
import com.tencent.mm.plugin.hld.model.n;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/Keyboard;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "deleteExeFuture", "Ljava/util/concurrent/Future;", "deleteFuture", "deleteKeyType", "deleteKeyWidth", "lastDeleteKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "getMKeyboardActionListener", "()Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "setMKeyboardActionListener", "(Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;)V", "mLastClickTime", "", "mLastClickView", "Landroid/view/View;", "mLastUpperMode", "mUpperMode", "supportDoubleKeyOnClickHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "triggerLeftDeleteMode", "", "closeDeleteTouch", "", "v", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "event", "Landroid/view/MotionEvent;", "doDelete", "deleteLength", "delayTime", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "getUpperMode", "handleDeleteKey", "reportKeyArea", "(Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;Landroid/view/MotionEvent;Ljava/lang/Integer;)Z", "handleDoubleClick", "isOnlySupportClickFloatViewKey", "view", "isSupportFloatViewKey", "isUpper", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onReset", "onResume", "listener", "onSelectCandidate", "text", "", "id", "", "suffix", "onUpdateSelection", "oldSelStart", "oldSelEnd", "newSelStart", "newSelEnd", "candidatesStart", "candidatesEnd", "supportDoubleClick", "switchUpperMode", "upperMode", "transparentBg", "transparent", "updateEnterKey", "actionStr", "actionMode", "updateUpperKey", "updateUpperKeyImp", "Companion", "plugin-hld_release"})
public class ImeKeyboard
  extends Keyboard
{
  public static final a Dyb;
  private com.tencent.mm.plugin.hld.a.c DvY;
  private int DxQ;
  private int DxR;
  private View DxS;
  private long DxT;
  private final MMHandler DxU;
  private Future<?> DxV;
  private Future<?> DxW;
  private int DxX;
  private b DxY;
  private int DxZ;
  private boolean Dya;
  
  static
  {
    AppMethodBeat.i(216681);
    Dyb = new a((byte)0);
    AppMethodBeat.o(216681);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216675);
    this.DxR = 1;
    this.DxU = ((MMHandler)new d(this, Looper.getMainLooper()));
    AppMethodBeat.o(216675);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216678);
    this.DxR = 1;
    this.DxU = ((MMHandler)new d(this, Looper.getMainLooper()));
    AppMethodBeat.o(216678);
  }
  
  public ImeKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(216680);
    this.DxR = 1;
    this.DxU = ((MMHandler)new d(this, Looper.getMainLooper()));
    AppMethodBeat.o(216680);
  }
  
  public static boolean a(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(216669);
    p.k(paramImeKeyRelativeLayout, "view");
    if (((paramImeKeyRelativeLayout.getType() & 0x2) != 2) && ((paramImeKeyRelativeLayout.getType() & 0x4) != 4))
    {
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      if (!com.tencent.mm.plugin.hld.f.l.e(paramImeKeyRelativeLayout)) {}
    }
    else
    {
      AppMethodBeat.o(216669);
      return false;
    }
    AppMethodBeat.o(216669);
    return true;
  }
  
  private final void ax(int paramInt, long paramLong)
  {
    AppMethodBeat.i(216671);
    final long l = System.currentTimeMillis();
    this.DxW = ((Future)h.ZvG.n((Runnable)new b(this, l, paramInt), paramLong));
    AppMethodBeat.o(216671);
  }
  
  public static boolean b(ImeKeyRelativeLayout paramImeKeyRelativeLayout)
  {
    AppMethodBeat.i(216670);
    p.k(paramImeKeyRelativeLayout, "view");
    boolean bool = p.h(paramImeKeyRelativeLayout.eHG(), Boolean.TRUE);
    AppMethodBeat.o(216670);
    return bool;
  }
  
  public final void Uu(int paramInt)
  {
    this.DxQ = this.DxR;
    this.DxR = paramInt;
  }
  
  public final void a(ImeKeyRelativeLayout paramImeKeyRelativeLayout, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    AppMethodBeat.i(216667);
    p.k(paramImeKeyRelativeLayout, "v");
    com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
    if (!com.tencent.mm.plugin.hld.f.l.e(paramImeKeyRelativeLayout))
    {
      paramImeKeyRelativeLayout = this.DxV;
      if (paramImeKeyRelativeLayout != null)
      {
        paramImeKeyRelativeLayout.cancel(true);
        this.DxV = null;
      }
      paramImeKeyRelativeLayout = localObject;
      if (paramMotionEvent != null) {
        paramImeKeyRelativeLayout = Integer.valueOf(paramMotionEvent.getActionMasked());
      }
      if (paramImeKeyRelativeLayout == null) {}
      while (paramImeKeyRelativeLayout.intValue() != 5)
      {
        if (paramImeKeyRelativeLayout != null) {
          break;
        }
        AppMethodBeat.o(216667);
        return;
      }
      while (paramImeKeyRelativeLayout.intValue() == 0)
      {
        paramImeKeyRelativeLayout = this.DxY;
        if (paramImeKeyRelativeLayout == null) {
          break;
        }
        paramImeKeyRelativeLayout = (View)paramImeKeyRelativeLayout.aFW.get();
        if (paramImeKeyRelativeLayout == null) {
          break label143;
        }
        p.j(paramImeKeyRelativeLayout, "v");
        paramImeKeyRelativeLayout.setSelected(false);
        AppMethodBeat.o(216667);
        return;
      }
    }
    AppMethodBeat.o(216667);
    return;
    label143:
    AppMethodBeat.o(216667);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(216660);
    p.k(paramString1, "text");
    p.k(paramArrayOfByte, "id");
    AppMethodBeat.o(216660);
  }
  
  protected final boolean a(ImeKeyRelativeLayout paramImeKeyRelativeLayout, MotionEvent paramMotionEvent, Integer paramInteger)
  {
    AppMethodBeat.i(216664);
    p.k(paramImeKeyRelativeLayout, "v");
    Object localObject1;
    Object localObject2;
    label39:
    int i;
    label62:
    int j;
    long l1;
    if (paramMotionEvent != null)
    {
      localObject1 = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (paramMotionEvent == null) {
        break label175;
      }
      localObject2 = Float.valueOf(paramMotionEvent.getRawX());
      i = (int)((Float)localObject2).floatValue();
      if (paramMotionEvent == null) {
        break label184;
      }
      paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY());
      j = (int)((Float)paramMotionEvent).floatValue();
      l1 = System.currentTimeMillis();
      Log.d("WxIme.ImeKeyboard", "handleBackKey action " + localObject1 + ' ' + i + ' ' + j + ' ' + l1);
      if (localObject1 != null) {
        break label192;
      }
      label136:
      if (localObject1 != null) {
        break label385;
      }
      if (localObject1 != null) {
        break label402;
      }
      label146:
      if (localObject1 != null) {
        break label546;
      }
      label151:
      if (localObject1 != null) {
        break label626;
      }
      if (localObject1 != null) {
        break label639;
      }
    }
    for (;;)
    {
      label161:
      AppMethodBeat.o(216664);
      return false;
      localObject1 = null;
      break;
      label175:
      localObject2 = Double.valueOf(0.0D);
      break label39;
      label184:
      paramMotionEvent = Double.valueOf(0.0D);
      break label62;
      label192:
      if (((Integer)localObject1).intValue() != 5) {
        break label136;
      }
      label201:
      paramMotionEvent = com.tencent.mm.plugin.hld.f.i.DHq;
      com.tencent.mm.plugin.hld.f.i.an((View)paramImeKeyRelativeLayout, 2);
      this.DxY = new b(i, j, l1, null, new WeakReference(paramImeKeyRelativeLayout), 0L, 88);
      paramMotionEvent = paramImeKeyRelativeLayout.findViewById(a.f.inside_root);
      p.j(paramMotionEvent, "v.findViewById<ViewGroup>(R.id.inside_root)");
      this.DxZ = ((ViewGroup)paramMotionEvent).getWidth();
      paramImeKeyRelativeLayout.setSelected(true);
      paramImeKeyRelativeLayout = n.DEn;
      if (n.eEE()) {}
      for (i = 2;; i = 1)
      {
        this.DxX = i;
        paramImeKeyRelativeLayout = e.DGW;
        ax(1, e.eGr());
        paramImeKeyRelativeLayout = this.DxV;
        if (paramImeKeyRelativeLayout != null) {
          paramImeKeyRelativeLayout.cancel(true);
        }
        paramImeKeyRelativeLayout = h.ZvG;
        paramMotionEvent = (Runnable)new c(this);
        localObject1 = e.DGW;
        this.DxV = ((Future)paramImeKeyRelativeLayout.o(paramMotionEvent, e.eGr()));
        if (paramInteger == null) {
          break label161;
        }
        i = ((Number)paramInteger).intValue();
        paramImeKeyRelativeLayout = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.hO(i, 1);
        break label161;
        label385:
        if (((Integer)localObject1).intValue() != 0) {
          break;
        }
        break label201;
      }
      label402:
      if (((Integer)localObject1).intValue() != 2) {
        break label146;
      }
      if (!this.Dya)
      {
        paramImeKeyRelativeLayout = this.DxY;
        if ((paramImeKeyRelativeLayout != null) && (this.DxX == 1))
        {
          paramMotionEvent = this.DxY;
          if (paramMotionEvent == null) {
            p.iCn();
          }
          long l2 = paramMotionEvent.time;
          paramMotionEvent = e.DGW;
          if ((l1 - l2 < e.eGr() - 5L) && (paramImeKeyRelativeLayout.x - i > this.DxZ) && (this.DxZ != 0))
          {
            paramImeKeyRelativeLayout = this.DxV;
            if (paramImeKeyRelativeLayout != null)
            {
              paramImeKeyRelativeLayout.cancel(true);
              this.DxV = null;
            }
            paramImeKeyRelativeLayout = this.DxW;
            if (paramImeKeyRelativeLayout != null)
            {
              paramImeKeyRelativeLayout.cancel(true);
              this.DxW = null;
            }
            this.Dya = true;
            continue;
            label546:
            if (((Integer)localObject1).intValue() != 3) {
              break label151;
            }
            for (;;)
            {
              paramImeKeyRelativeLayout.setSelected(false);
              paramImeKeyRelativeLayout = this.DxV;
              if (paramImeKeyRelativeLayout != null)
              {
                paramImeKeyRelativeLayout.cancel(true);
                this.DxV = null;
              }
              if (!this.Dya) {
                break label660;
              }
              this.Dya = false;
              paramImeKeyRelativeLayout = this.DxY;
              if (paramImeKeyRelativeLayout == null) {
                break label161;
              }
              if (paramImeKeyRelativeLayout.x - i <= this.DxZ) {
                break label651;
              }
              n.DEn.eEO();
              break label161;
              label626:
              if (((Integer)localObject1).intValue() != 6)
              {
                break;
                label639:
                if (((Integer)localObject1).intValue() != 1) {
                  break label161;
                }
              }
            }
            label651:
            ax(1, 0L);
            continue;
            label660:
            paramImeKeyRelativeLayout = this.DxY;
            if (paramImeKeyRelativeLayout == null) {
              p.iCn();
            }
            l2 = paramImeKeyRelativeLayout.time;
            paramImeKeyRelativeLayout = e.DGW;
            if (l1 - l2 < e.eGr() - 5L)
            {
              paramImeKeyRelativeLayout = this.DxW;
              if (paramImeKeyRelativeLayout != null)
              {
                paramImeKeyRelativeLayout.cancel(true);
                this.DxW = null;
              }
              ax(1, 0L);
            }
          }
        }
      }
    }
  }
  
  public void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.DvY = paramc;
  }
  
  public final boolean eDJ()
  {
    return this.DxR != 1;
  }
  
  public final void eDK()
  {
    AppMethodBeat.i(216657);
    if (this.DxQ != this.DxR) {
      eDL();
    }
    AppMethodBeat.o(216657);
  }
  
  protected void eDL() {}
  
  public void eO(String paramString, int paramInt)
  {
    AppMethodBeat.i(216659);
    p.k(paramString, "actionStr");
    ImeKeyButton localImeKeyButton = getActionKey();
    if (localImeKeyButton != null)
    {
      ImeKeyRelativeLayout.a(localImeKeyButton, paramString);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(216659);
        return;
      case 2: 
        localImeKeyButton.setClickable(true);
        paramString = com.tencent.mm.plugin.hld.f.k.DHH;
        if (com.tencent.mm.plugin.hld.f.k.UK(localImeKeyButton.getViewType()))
        {
          paramString = localImeKeyButton.getInsideView();
          if (paramString != null) {
            paramString.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
          }
        }
        for (;;)
        {
          localImeKeyButton.UO(a.c.ime_key_text_color);
          AppMethodBeat.o(216659);
          return;
          localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
        }
      case 3: 
        localImeKeyButton.setClickable(true);
        paramString = com.tencent.mm.plugin.hld.f.k.DHH;
        if (com.tencent.mm.plugin.hld.f.k.UK(localImeKeyButton.getViewType()))
        {
          paramString = localImeKeyButton.getInsideView();
          if (paramString != null) {
            paramString.setBackground(getResources().getDrawable(a.e.ime_key_green_bg));
          }
        }
        for (;;)
        {
          localImeKeyButton.UO(a.c.White);
          AppMethodBeat.o(216659);
          return;
          localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_green_bg));
        }
      }
      localImeKeyButton.setClickable(false);
      paramString = com.tencent.mm.plugin.hld.f.k.DHH;
      if (com.tencent.mm.plugin.hld.f.k.UK(localImeKeyButton.getViewType()))
      {
        paramString = localImeKeyButton.getInsideView();
        if (paramString != null) {
          paramString.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
        }
      }
      for (;;)
      {
        localImeKeyButton.UO(a.c.S2_text_invalid_color);
        break;
        localImeKeyButton.setBackground(getResources().getDrawable(a.e.ime_key_grey_bg));
      }
    }
    AppMethodBeat.o(216659);
  }
  
  public boolean fa(View paramView)
  {
    return false;
  }
  
  public void fb(View paramView) {}
  
  public void fc(View paramView) {}
  
  public final boolean fd(View paramView)
  {
    AppMethodBeat.i(216661);
    View localView = this.DxS;
    long l = this.DxT;
    this.DxS = paramView;
    this.DxT = System.currentTimeMillis();
    if (!fa(paramView))
    {
      AppMethodBeat.o(216661);
      return false;
    }
    if ((p.h(paramView, localView)) && (System.currentTimeMillis() - l <= 200L))
    {
      fc(paramView);
      AppMethodBeat.o(216661);
      return true;
    }
    Log.d("WxIme.ImeKeyboard", "supportDoubleKeyOnClickHandler");
    fb(paramView);
    AppMethodBeat.o(216661);
    return true;
  }
  
  protected ImeKeyButton getActionKey()
  {
    return null;
  }
  
  public c getKeyboardType()
  {
    return c.Dyl;
  }
  
  protected final com.tencent.mm.plugin.hld.a.c getMKeyboardActionListener()
  {
    return this.DvY;
  }
  
  public int getUpperMode()
  {
    return this.DxR;
  }
  
  public void onCreate() {}
  
  public void onReset()
  {
    AppMethodBeat.i(216655);
    Uu(1);
    eDK();
    AppMethodBeat.o(216655);
  }
  
  public void sM(boolean paramBoolean) {}
  
  protected final void setMKeyboardActionListener(com.tencent.mm.plugin.hld.a.c paramc)
  {
    this.DvY = paramc;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ImeKeyboard paramImeKeyboard, long paramLong, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(214009);
      Log.i("WxIme.ImeKeyboard", "doDeleteImp inter time:" + (System.currentTimeMillis() - l));
      com.tencent.mm.plugin.hld.a.c localc = this.Dyc.getMKeyboardActionListener();
      if (localc != null)
      {
        localc.q(1, new Keyboard.a(ImeKeyboard.a(this.Dyc), this.Dyd));
        AppMethodBeat.o(214009);
        return;
      }
      AppMethodBeat.o(214009);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ImeKeyboard paramImeKeyboard) {}
    
    public final void run()
    {
      AppMethodBeat.i(216624);
      for (;;)
      {
        int i;
        long l;
        try
        {
          Object localObject = e.DGW;
          Thread.sleep(e.eGq());
          int j = 1;
          i = j;
          if (ImeKeyboard.a(this.Dyc) == 2)
          {
            l = System.currentTimeMillis();
            localObject = ImeKeyboard.b(this.Dyc);
            if (localObject == null) {
              p.iCn();
            }
            l -= ((b)localObject).time;
            if (l > 2000L) {
              i = 3;
            }
          }
          else
          {
            ImeKeyboard.a(this.Dyc, i);
            continue;
          }
          i = j;
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("WxIme.ImeKeyboard", "deleteFuture " + localInterruptedException.getMessage());
          AppMethodBeat.o(216624);
          return;
        }
        if (l > 5000L) {
          i = 5;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/hld/keyboard/ImeKeyboard$supportDoubleKeyOnClickHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-hld_release"})
  public static final class d
    extends MMHandler
  {
    d(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(209824);
      p.k(paramMessage, "msg");
      Log.d("WxIme.ImeKeyboard", "supportDoubleKeyOnClickHandler");
      this.Dyc.fb((View)paramMessage.obj);
      AppMethodBeat.o(209824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.ImeKeyboard
 * JD-Core Version:    0.7.0.1
 */