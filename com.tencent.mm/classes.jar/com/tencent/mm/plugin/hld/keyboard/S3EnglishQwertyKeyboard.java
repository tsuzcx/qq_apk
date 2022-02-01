package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.i;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.g;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.view.ImeKeyButton;
import com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentKeyArea", "Lcom/tencent/mm/plugin/hld/keyboard/KeyArea;", "diffScale", "", "lastKeyOperation", "Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "letterKeyList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Lkotlin/collections/ArrayList;", "computeMedia", "", "getActionKey", "Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "handleClickUpperKey", "doubleClick", "", "handleNormalTouch", "v", "event", "Landroid/view/MotionEvent;", "onClick", "Landroid/view/View;", "onClickForSupportDoubleClick", "onCreate", "onDoubleClick", "onLongClick", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "onTextKeyClick", "onTouch", "onUpperSlide", "supportDoubleClick", "transparentBg", "transparent", "updateChildrenView", "id", "isLetter", "updateKeyUpperStatus", "isUpper", "updateUpperKeyImp", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S3EnglishQwertyKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener
{
  public static final S3EnglishQwertyKeyboard.a JrX;
  private b JrQ;
  private a JrV;
  private float JrW;
  private final ArrayList<ImeKeyRelativeLayout> JrY;
  
  static
  {
    AppMethodBeat.i(313056);
    JrX = new S3EnglishQwertyKeyboard.a((byte)0);
    AppMethodBeat.o(313056);
  }
  
  public S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S3EnglishQwertyKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(313017);
    this.JrY = new ArrayList();
    AppMethodBeat.o(313017);
  }
  
  private final void bf(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(313036);
    Object localObject1 = (ImeKeyRelativeLayout)findViewById(paramInt);
    Object localObject2 = (ViewGroup)((ImeKeyRelativeLayout)localObject1).findViewById(a.f.inside_root);
    ViewGroup.LayoutParams localLayoutParams = ((ViewGroup)localObject2).getLayoutParams();
    if (localLayoutParams == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(313036);
      throw ((Throwable)localObject1);
    }
    localLayoutParams.height = ((ImeKeyRelativeLayout)localObject1).getKeyHeight();
    localLayoutParams.width = ((int)(((ImeKeyRelativeLayout)localObject1).getKeyWidth() * this.JrW));
    ((ViewGroup)localObject2).setLayoutParams(localLayoutParams);
    ((ImeKeyRelativeLayout)localObject1).setPadding((int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginLeft() * this.JrW), ((ImeKeyRelativeLayout)localObject1).getKeyMarginTop(), (int)(((ImeKeyRelativeLayout)localObject1).getKeyMarginRight() * this.JrW), ((ImeKeyRelativeLayout)localObject1).getKeyMarginBottom());
    if (paramBoolean) {
      this.JrY.add(localObject1);
    }
    localObject2 = l.JyV;
    s.s(localObject1, "view");
    if (l.f((ImeKeyRelativeLayout)localObject1))
    {
      com.tencent.mm.plugin.hld.view.f.JzR.a((View)localObject1, (View.OnClickListener)this);
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
      AppMethodBeat.o(313036);
      return;
    }
    localObject2 = l.JyV;
    if (l.e((ImeKeyRelativeLayout)localObject1))
    {
      ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
      AppMethodBeat.o(313036);
      return;
    }
    if (((a((ImeKeyRelativeLayout)localObject1)) || (paramInt == a.f.s3_key_comma) || (paramInt == a.f.s3_key_at)) && (!b((ImeKeyRelativeLayout)localObject1))) {
      ((ImeKeyRelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)this);
    }
    ((ImeKeyRelativeLayout)localObject1).setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(313036);
  }
  
  private final void wT(boolean paramBoolean)
  {
    AppMethodBeat.i(313025);
    int i = getUpperMode();
    if (paramBoolean)
    {
      if (i == 3) {
        break label47;
      }
      Yr(3);
    }
    for (;;)
    {
      fLM();
      AppMethodBeat.o(313025);
      return;
      if (i == 1) {
        Yr(2);
      } else {
        label47:
        Yr(1);
      }
    }
  }
  
  private final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(313046);
    Iterator localIterator = this.JrY.iterator();
    if (localIterator.hasNext())
    {
      ImeKeyRelativeLayout localImeKeyRelativeLayout = (ImeKeyRelativeLayout)localIterator.next();
      Object localObject;
      if (paramBoolean)
      {
        localObject = localImeKeyRelativeLayout.getText();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313046);
          throw ((Throwable)localObject);
        }
        localObject = ((String)localObject).toUpperCase();
        s.s(localObject, "(this as java.lang.String).toUpperCase()");
      }
      for (;;)
      {
        localImeKeyRelativeLayout.b((String)localObject, Boolean.valueOf(paramBoolean));
        break;
        localObject = localImeKeyRelativeLayout.getText();
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313046);
          throw ((Throwable)localObject);
        }
        localObject = ((String)localObject).toLowerCase();
        s.s(localObject, "(this as java.lang.String).toLowerCase()");
      }
    }
    AppMethodBeat.o(313046);
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313079);
    super.b(paramc);
    fLM();
    AppMethodBeat.o(313079);
  }
  
  protected final void fLN()
  {
    AppMethodBeat.i(313120);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s3_key_upper);
    switch (getUpperMode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(313120);
      return;
      localImeKeyButton.YN(a.i.icons_outlined_capslock);
      wU(false);
      AppMethodBeat.o(313120);
      return;
      localImeKeyButton.YN(a.i.icons_filled_capslock);
      wU(true);
      AppMethodBeat.o(313120);
      return;
      localImeKeyButton.YN(a.i.icons_filled_capslocked);
      wU(true);
    }
  }
  
  protected final ImeKeyButton getActionKey()
  {
    AppMethodBeat.i(313144);
    ImeKeyButton localImeKeyButton = (ImeKeyButton)findViewById(a.f.s3_key_action);
    AppMethodBeat.o(313144);
    return localImeKeyButton;
  }
  
  public final c getKeyboardType()
  {
    return c.Jrr;
  }
  
  public final boolean hL(View paramView)
  {
    AppMethodBeat.i(313101);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3))
    {
      AppMethodBeat.o(313101);
      return true;
    }
    AppMethodBeat.o(313101);
    return false;
  }
  
  public final void hM(View paramView)
  {
    AppMethodBeat.i(313105);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3)) {
      wT(false);
    }
    AppMethodBeat.o(313105);
  }
  
  public final void hN(View paramView)
  {
    AppMethodBeat.i(313109);
    super.hN(paramView);
    if (((paramView instanceof ImeKeyRelativeLayout)) && (((ImeKeyRelativeLayout)paramView).getType() == 2) && (((ImeKeyRelativeLayout)paramView).getFunctionCode() == 3)) {
      wT(true);
    }
    AppMethodBeat.o(313109);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(313095);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S3EnglishQwertyKeyboard", "onClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      if (hO(paramView))
      {
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.YA(301);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(313095);
        return;
      }
      if ((((ImeKeyRelativeLayout)paramView).getType() & 0x2) != 2) {
        break label231;
      }
      localObject1 = getMKeyboardActionListener();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.hld.a.c)localObject1).Yl(((ImeKeyRelativeLayout)paramView).getFunctionCode());
      }
    }
    label231:
    while ((((ImeKeyRelativeLayout)paramView).getType() & 0x4) != 4)
    {
      localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.hT(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(313095);
      return;
    }
    localObject1 = ((ImeKeyRelativeLayout)paramView).getText();
    Object localObject2;
    if (fLL())
    {
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313095);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toUpperCase();
      s.s(localObject2, "(this as java.lang.String).toUpperCase()");
      label294:
      localObject1 = this.JrQ;
      if (localObject1 != null) {
        break label375;
      }
      localObject1 = null;
      label305:
      if (localObject1 != null) {
        break label391;
      }
      localObject1 = new g((String)localObject2);
    }
    label391:
    for (;;)
    {
      localObject2 = getMKeyboardActionListener();
      if (localObject2 == null) {
        break;
      }
      ((com.tencent.mm.plugin.hld.a.c)localObject2).b((g)localObject1);
      break;
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313095);
        throw paramView;
      }
      localObject2 = ((String)localObject1).toLowerCase();
      s.s(localObject2, "(this as java.lang.String).toLowerCase()");
      break label294;
      label375:
      localObject1 = new g((String)localObject2, ((b)localObject1).Jrm);
      break label305;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(313071);
    super.onCreate();
    Object localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape()) {}
    DisplayMetrics localDisplayMetrics;
    int i;
    for (this.JrW = 1.0F;; this.JrW = (i / (localDisplayMetrics.widthPixels - i) + 1.0F))
    {
      bf(a.f.s3_key_q, true);
      bf(a.f.s3_key_w, true);
      bf(a.f.s3_key_e, true);
      bf(a.f.s3_key_r, true);
      bf(a.f.s3_key_t, true);
      bf(a.f.s3_key_y, true);
      bf(a.f.s3_key_u, true);
      bf(a.f.s3_key_i, true);
      bf(a.f.s3_key_o, true);
      bf(a.f.s3_key_p, true);
      bf(a.f.s3_key_a, true);
      bf(a.f.s3_key_s, true);
      bf(a.f.s3_key_d, true);
      bf(a.f.s3_key_f, true);
      bf(a.f.s3_key_g, true);
      bf(a.f.s3_key_h, true);
      bf(a.f.s3_key_j, true);
      bf(a.f.s3_key_k, true);
      bf(a.f.s3_key_l, true);
      bf(a.f.s3_key_upper, false);
      bf(a.f.s3_key_z, true);
      bf(a.f.s3_key_x, true);
      bf(a.f.s3_key_c, true);
      bf(a.f.s3_key_v, true);
      bf(a.f.s3_key_b, true);
      bf(a.f.s3_key_n, true);
      bf(a.f.s3_key_m, true);
      bf(a.f.s3_key_delete, false);
      bf(a.f.s3_key_symbol, false);
      bf(a.f.s3_key_number, false);
      bf(a.f.s3_key_comma, false);
      bf(a.f.s3_key_space, false);
      bf(a.f.s3_key_at, false);
      bf(a.f.s3_key_exchange, false);
      bf(a.f.s3_key_action, false);
      fLM();
      AppMethodBeat.o(313071);
      return;
      localObject = (ImeKeyRelativeLayout)findViewById(a.f.s3_key_q);
      localDisplayMetrics = getContext().getResources().getDisplayMetrics();
      i = localDisplayMetrics.widthPixels - ((ImeKeyRelativeLayout)localObject).getKeyWidth() * 10 - ((ImeKeyRelativeLayout)localObject).getKeyMarginLeft() * 10 - ((ImeKeyRelativeLayout)localObject).getKeyMarginRight() * 10;
    }
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(313114);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      localObject1 = l.JyV;
      l.jC("WxIme.S3EnglishQwertyKeyboard", "onLongClick:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
      localObject1 = l.JyV;
      if (l.f((ImeKeyRelativeLayout)paramView))
      {
        paramView = (d)h.ax(d.class);
        if (paramView != null)
        {
          paramView = paramView.fKG();
          if (paramView != null) {
            paramView.fKs();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(313114);
        return true;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((ImeKeyRelativeLayout)paramView).getSecondText());
      Object localObject2 = com.tencent.mm.plugin.hld.model.f.JuH;
      localObject2 = (ImeKeyRelativeLayout)paramView;
      paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
      s.checkNotNull(paramView);
      com.tencent.mm.plugin.hld.model.f.a(3, (ArrayList)localObject1, (ImeKeyRelativeLayout)localObject2, paramView, this.JrQ);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(313114);
      return true;
    }
    paramView = com.tencent.mm.plugin.hld.model.f.JuH;
    com.tencent.mm.plugin.hld.model.f.fLV();
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/hld/keyboard/S3EnglishQwertyKeyboard", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(313114);
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313138);
    if ((paramView instanceof ImeKeyRelativeLayout))
    {
      Object localObject1 = l.JyV;
      boolean bool;
      if (l.e((ImeKeyRelativeLayout)paramView))
      {
        bool = a((ImeKeyRelativeLayout)paramView, paramMotionEvent, Integer.valueOf(308));
        AppMethodBeat.o(313138);
        return bool;
      }
      a((ImeKeyRelativeLayout)paramView, paramMotionEvent);
      Object localObject2 = (ImeKeyRelativeLayout)paramView;
      label85:
      int i;
      if (paramMotionEvent == null)
      {
        paramView = null;
        if (paramMotionEvent != null) {
          break label251;
        }
        localObject1 = Double.valueOf(0.0D);
        i = (int)((Float)localObject1).floatValue();
        if (paramMotionEvent != null) {
          break label263;
        }
      }
      int j;
      long l;
      label263:
      for (paramMotionEvent = Double.valueOf(0.0D);; paramMotionEvent = Float.valueOf(paramMotionEvent.getRawY()))
      {
        j = (int)((Float)paramMotionEvent).floatValue();
        l = System.currentTimeMillis();
        paramMotionEvent = ((ImeKeyRelativeLayout)localObject2).getText();
        localObject1 = l.JyV;
        l.jC("WxIme.S3EnglishQwertyKeyboard", "onTouch action " + paramView + ' ' + i + ' ' + j + ' ' + l + ' ' + paramMotionEvent);
        if (this.JrQ == null) {
          break label427;
        }
        localObject1 = this.JrQ;
        s.checkNotNull(localObject1);
        localObject1 = ((b)localObject1).Jrk;
        if (localObject1 != null) {
          break label274;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313138);
        throw paramView;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label251:
        localObject1 = Float.valueOf(paramMotionEvent.getRawX());
        break label85;
      }
      label274:
      localObject1 = ((String)localObject1).toLowerCase();
      s.s(localObject1, "(this as java.lang.String).toLowerCase()");
      if (paramMotionEvent == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(313138);
        throw paramView;
      }
      Object localObject3 = paramMotionEvent.toLowerCase();
      s.s(localObject3, "(this as java.lang.String).toLowerCase()");
      if (!Util.isEqual((String)localObject1, (String)localObject3)) {
        if (paramView == null)
        {
          if (paramView != null) {
            break label541;
          }
          localObject1 = l.JyV;
          localObject1 = new StringBuilder("lastKey:");
          localObject2 = this.JrQ;
          s.checkNotNull(localObject2);
          l.jC("WxIme.S3EnglishQwertyKeyboard", ((b)localObject2).Jrk + " currentKey:" + paramMotionEvent + " action:" + paramView);
          label410:
          break label439;
        }
      }
      label411:
      label427:
      label431:
      label435:
      label439:
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(313138);
            return false;
            if (paramView.intValue() != 5) {
              break;
            }
            if (paramView != null) {
              break label551;
            }
            if (paramView != null) {
              break label1214;
            }
            if (paramView != null) {
              break label1824;
            }
          } while ((paramView == null) || (paramView.intValue() != 3));
          ((ImeKeyRelativeLayout)localObject2).setSelected(false);
          paramView = this.JrQ;
          if (paramView != null)
          {
            paramView.Jrl = true;
            paramView = ah.aiuX;
            paramView = ah.aiuX;
          }
          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
          com.tencent.mm.plugin.hld.model.f.rL(70L);
        } while ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2);
        paramMotionEvent = getMKeyboardActionListener();
      } while (paramMotionEvent == null);
      paramView = this.JrQ;
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.Jrk)
      {
        paramMotionEvent.c(new g(paramView));
        paramView = ah.aiuX;
        break label411;
        label541:
        if (paramView.intValue() == 0) {
          break label427;
        }
        break;
        label551:
        if (paramView.intValue() != 0) {
          break label431;
        }
        paramView = i.JyA;
        i.d((ImeKeyRelativeLayout)localObject2);
        localObject1 = this.JrQ;
        if (localObject1 != null) {
          if ((!((b)localObject1).Jrl) && (!Util.isNullOrNil(((b)localObject1).Jrk)))
          {
            paramView = l.JyV;
            l.jC("WxIme.S3EnglishQwertyKeyboard", s.X("process no ACTION_UP input:", ((b)localObject1).Jrk));
            paramView = (View)((b)localObject1).viewRef.get();
            if (paramView != null)
            {
              paramView.setSelected(false);
              if ((!(paramView instanceof ImeKeyRelativeLayout)) || (!a((ImeKeyRelativeLayout)paramView))) {
                break label751;
              }
              localObject3 = getMKeyboardActionListener();
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.hld.a.c)localObject3).b(new g(((b)localObject1).Jrk, ((b)localObject1).Jrm));
                localObject1 = ah.aiuX;
              }
              localObject1 = com.tencent.mm.plugin.hld.model.k.JvH;
              com.tencent.mm.plugin.hld.model.k.hT(paramView);
            }
          }
        }
        for (;;)
        {
          paramView = ah.aiuX;
          paramView = ah.aiuX;
          paramView = ah.aiuX;
          paramView = ah.aiuX;
          if (!fLL()) {
            break label992;
          }
          if (paramMotionEvent != null) {
            break;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313138);
          throw paramView;
          label751:
          onClick(paramView);
        }
        paramView = paramMotionEvent.toUpperCase();
        s.s(paramView, "(this as java.lang.String).toUpperCase()");
        for (;;)
        {
          this.JrQ = new b(i, j, l, paramView, new WeakReference(localObject2), l, 16);
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          this.JrV = new a(paramView[0], paramView[1], paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth(), paramView[1] + ((ImeKeyRelativeLayout)localObject2).getMeasuredHeight());
          if (!a((ImeKeyRelativeLayout)localObject2)) {
            break label1196;
          }
          paramMotionEvent = (View)localObject2;
          if (!(paramMotionEvent instanceof ImeKeyRelativeLayout)) {
            break label1186;
          }
          paramView = l.JyV;
          l.jC("WxIme.S3EnglishQwertyKeyboard", "onTextKeyClick:" + ((ImeKeyRelativeLayout)paramMotionEvent).getType() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramMotionEvent).getFunctionCode());
          localObject1 = new ArrayList();
          if (!fLL()) {
            break label1140;
          }
          paramView = ((ImeKeyRelativeLayout)paramMotionEvent).getText();
          if (paramView != null) {
            break;
          }
          paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313138);
          throw paramView;
          label992:
          if (paramMotionEvent == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(313138);
            throw paramView;
          }
          paramView = paramMotionEvent.toLowerCase();
          s.s(paramView, "(this as java.lang.String).toLowerCase()");
        }
        paramView = paramView.toUpperCase();
        s.s(paramView, "(this as java.lang.String).toUpperCase()");
        label1042:
        ((ArrayList)localObject1).add(paramView);
        paramView = com.tencent.mm.plugin.hld.model.f.JuH;
        paramView = (ImeKeyRelativeLayout)paramMotionEvent;
        paramMotionEvent = ((ImeKeyRelativeLayout)paramMotionEvent).getInsideView();
        s.checkNotNull(paramMotionEvent);
        com.tencent.mm.plugin.hld.model.f.a(1, (ArrayList)localObject1, paramView, paramMotionEvent, this.JrQ);
        label1082:
        ((ImeKeyRelativeLayout)localObject2).setSelected(true);
        if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) == 2) {
          break label411;
        }
        paramMotionEvent = getMKeyboardActionListener();
        if (paramMotionEvent == null) {
          break label411;
        }
        paramView = this.JrQ;
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.Jrk)
        {
          paramMotionEvent.a(new g(paramView));
          paramView = ah.aiuX;
          break;
          label1140:
          paramView = ((ImeKeyRelativeLayout)paramMotionEvent).getText();
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(313138);
            throw paramView;
          }
          paramView = paramView.toLowerCase();
          s.s(paramView, "(this as java.lang.String).toLowerCase()");
          break label1042;
          label1186:
          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
          com.tencent.mm.plugin.hld.model.f.fLV();
          break label1082;
          label1196:
          paramView = com.tencent.mm.plugin.hld.model.f.JuH;
          com.tencent.mm.plugin.hld.model.f.fLV();
          break label1082;
        }
        label1214:
        if (paramView.intValue() != 2) {
          break label435;
        }
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          paramView = this.JrV;
          if (paramView != null)
          {
            if ((i < paramView.x) || (i > paramView.Jri) || (j < paramView.y) || (j > paramView.Jrj))
            {
              paramView = com.tencent.mm.plugin.hld.model.f.JuH;
              com.tencent.mm.plugin.hld.model.f.fLW();
            }
            paramView = ah.aiuX;
            paramView = ah.aiuX;
          }
        }
        paramView = this.JrQ;
        if (paramView == null) {
          break label411;
        }
        paramMotionEvent = l.JyV;
        paramMotionEvent = new StringBuilder("onTouch ");
        if ((l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height))) {}
        for (bool = true;; bool = false)
        {
          l.jC("WxIme.S3EnglishQwertyKeyboard", bool + " diff:" + (l - paramView.time) + " yOffset:" + Math.abs(j - paramView.y) + " minHeight:" + com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height));
          int k = Math.abs(paramView.x - i);
          paramMotionEvent = com.tencent.mm.plugin.hld.f.k.JyF;
          if (k <= com.tencent.mm.plugin.hld.f.k.fOz()) {
            break;
          }
          paramMotionEvent = com.tencent.mm.plugin.hld.e.b.JqP;
          paramMotionEvent = (View)localObject2;
          localObject1 = ((ImeKeyRelativeLayout)localObject2).getInsideView();
          s.checkNotNull(localObject1);
          com.tencent.mm.plugin.hld.e.b.a(paramMotionEvent, (View)localObject1, this.JrQ, i);
          if ((((ImeKeyRelativeLayout)localObject2).getType() & 0x2) != 2)
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.c(new g(paramView.Jrk));
              paramView = ah.aiuX;
            }
          }
          AppMethodBeat.o(313138);
          return true;
        }
        if (((a((ImeKeyRelativeLayout)localObject2)) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s3_key_comma) || (((ImeKeyRelativeLayout)localObject2).getId() == a.f.s3_key_at)) && (!b((ImeKeyRelativeLayout)localObject2)) && (l - paramView.time < 500L) && (Math.abs(j - paramView.y) > com.tencent.mm.cd.a.bs(getContext(), a.d.ime_upper_slide_min_height)))
        {
          paramView = new int[2];
          ((ImeKeyRelativeLayout)localObject2).getLocationOnScreen(paramView);
          if ((i >= paramView[0]) && (i <= paramView[0] + ((ImeKeyRelativeLayout)localObject2).getMeasuredWidth()))
          {
            paramView = (View)localObject2;
            if ((paramView instanceof ImeKeyRelativeLayout))
            {
              paramMotionEvent = l.JyV;
              l.jC("WxIme.S3EnglishQwertyKeyboard", "onUpperSlide:" + ((ImeKeyRelativeLayout)paramView).getType() + ' ' + ((ImeKeyRelativeLayout)paramView).getText() + ' ' + ((ImeKeyRelativeLayout)paramView).getSecondText() + ' ' + ((ImeKeyRelativeLayout)paramView).getFunctionCode());
              paramMotionEvent = new ArrayList();
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getText());
              paramMotionEvent.add(((ImeKeyRelativeLayout)paramView).getSecondText());
              localObject1 = com.tencent.mm.plugin.hld.model.f.JuH;
              localObject1 = (ImeKeyRelativeLayout)paramView;
              paramView = ((ImeKeyRelativeLayout)paramView).getInsideView();
              s.checkNotNull(paramView);
              com.tencent.mm.plugin.hld.model.f.a(2, paramMotionEvent, (ImeKeyRelativeLayout)localObject1, paramView, this.JrQ);
            }
            for (;;)
            {
              AppMethodBeat.o(313138);
              return true;
              paramView = com.tencent.mm.plugin.hld.model.f.JuH;
              com.tencent.mm.plugin.hld.model.f.fLV();
            }
          }
        }
        paramView = ah.aiuX;
        paramView = ah.aiuX;
        break label411;
        label1824:
        if (paramView.intValue() != 1) {
          break label410;
        }
        ((ImeKeyRelativeLayout)localObject2).setSelected(false);
        paramView = this.JrQ;
        if (paramView != null)
        {
          paramView.Jrl = true;
          paramView = ah.aiuX;
          paramView = ah.aiuX;
        }
        paramView = com.tencent.mm.plugin.hld.model.f.JuH;
        com.tencent.mm.plugin.hld.model.f.rL(70L);
        if (a((ImeKeyRelativeLayout)localObject2))
        {
          paramView = ((ImeKeyRelativeLayout)localObject2).getText();
          if (fLL())
          {
            if (paramView == null)
            {
              paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(313138);
              throw paramView;
            }
            paramMotionEvent = paramView.toUpperCase();
            s.s(paramMotionEvent, "(this as java.lang.String).toUpperCase()");
            label1926:
            paramView = this.JrQ;
            if (paramView != null) {
              break label2023;
            }
            paramView = null;
            label1937:
            if (paramView != null) {
              break label2039;
            }
            paramView = new g(paramMotionEvent);
          }
          label2023:
          label2039:
          for (;;)
          {
            paramMotionEvent = getMKeyboardActionListener();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.b(paramView);
              paramView = ah.aiuX;
            }
            paramView = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.hT((View)localObject2);
            break;
            if (paramView == null)
            {
              paramView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(313138);
              throw paramView;
            }
            paramMotionEvent = paramView.toLowerCase();
            s.s(paramMotionEvent, "(this as java.lang.String).toLowerCase()");
            break label1926;
            paramView = new g(paramMotionEvent, paramView.Jrm);
            break label1937;
          }
        }
        onClick((View)localObject2);
        break label411;
      }
    }
    AppMethodBeat.o(313138);
    return false;
  }
  
  public final void wS(boolean paramBoolean)
  {
    AppMethodBeat.i(313149);
    if (paramBoolean)
    {
      ((LinearLayout)findViewById(a.f.root)).setBackgroundColor(getResources().getColor(a.c.transparent));
      AppMethodBeat.o(313149);
      return;
    }
    ((LinearLayout)findViewById(a.f.root)).setBackgroundResource(a.e.ime_keyboard_gradient_bg_color);
    AppMethodBeat.o(313149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S3EnglishQwertyKeyboard
 * JD-Core Version:    0.7.0.1
 */