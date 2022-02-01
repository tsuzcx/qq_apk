package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.f.k;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "functionCode", "Ljava/lang/Integer;", "keyBackground", "Landroid/graphics/drawable/Drawable;", "getKeyBackground", "()Landroid/graphics/drawable/Drawable;", "setKeyBackground", "(Landroid/graphics/drawable/Drawable;)V", "keyHeight", "getKeyHeight", "()I", "setKeyHeight", "(I)V", "keyMarginBottom", "getKeyMarginBottom", "setKeyMarginBottom", "keyMarginLeft", "getKeyMarginLeft", "setKeyMarginLeft", "keyMarginRight", "getKeyMarginRight", "setKeyMarginRight", "keyMarginTop", "getKeyMarginTop", "setKeyMarginTop", "keyWidth", "getKeyWidth", "setKeyWidth", "onTouchListener", "Ljava/lang/ref/WeakReference;", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Ljava/lang/ref/WeakReference;", "setOnTouchListener", "(Ljava/lang/ref/WeakReference;)V", "type", "viewType", "getViewType", "()Ljava/lang/Integer;", "setViewType", "(Ljava/lang/Integer;)V", "getFunctionCode", "getInsideView", "Landroid/view/View;", "getSecondText", "", "getText", "getType", "isOnlyClickFloatView", "", "()Ljava/lang/Boolean;", "", "l", "updateFunctionCode", "updateSecondText", "text", "updateText", "isUpperMode", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateTextColor", "resId", "updateTextColorStateList", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ImeKeyRelativeLayout
  extends RelativeLayout
{
  public static final ImeKeyRelativeLayout.a JzF;
  private Integer JzG;
  private int JzH;
  private int JzI;
  private int JzJ;
  private int JzK;
  private int JzL;
  private int JzM;
  private WeakReference<View.OnTouchListener> JzN;
  private Drawable JzO;
  private Integer JzP;
  private Integer type;
  
  static
  {
    AppMethodBeat.i(312611);
    JzF = new ImeKeyRelativeLayout.a((byte)0);
    AppMethodBeat.o(312611);
  }
  
  public ImeKeyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeKeyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  public ImeKeyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312596);
    s.checkNotNull(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeKeyRelativeLayout, paramInt, 0);
    s.s(paramAttributeSet, "context!!.obtainStyledAt…eLayout, defStyleAttr, 0)");
    boolean bool = paramAttributeSet.getBoolean(a.l.ImeKeyRelativeLayout_imeKeyMarginDp, false);
    k localk = k.JyF;
    double d1 = k.is(paramContext);
    localk = k.JyF;
    double d2 = k.it(paramContext);
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyWidth);
    if (paramContext == null)
    {
      f = 0.0F;
      this.JzH = ((int)(f * d1));
      if (!bool) {
        break label250;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginLeft, 0);
      this.JzL = paramInt;
      if (!bool) {
        break label285;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginRight, 0);
      this.JzM = paramInt;
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyHeight);
      if (paramContext != null) {
        break label320;
      }
    }
    label285:
    label320:
    for (float f = 0.0F;; f = Float.parseFloat(paramContext))
    {
      this.JzI = ((int)(f * d2));
      if (!bool) {
        break label329;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginTop, 0);
      this.JzJ = paramInt;
      if (!bool) {
        break label364;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginBottom, 0);
      this.JzK = paramInt;
      this.type = Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyRelativeLayout_keyType, 0));
      this.JzP = Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyRelativeLayout_functionCode, 0));
      this.JzO = paramAttributeSet.getDrawable(a.l.ImeKeyRelativeLayout_imeKeyBackground);
      AppMethodBeat.o(312596);
      return;
      f = Float.parseFloat(paramContext);
      break;
      label250:
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginLeft);
      if (paramContext == null) {}
      for (f = 0.0F;; f = Float.parseFloat(paramContext))
      {
        paramInt = (int)(f * d1);
        break;
      }
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginRight);
      if (paramContext == null) {}
      for (f = 0.0F;; f = Float.parseFloat(paramContext))
      {
        paramInt = (int)(d1 * f);
        break;
      }
    }
    label329:
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginTop);
    if (paramContext == null) {}
    for (f = 0.0F;; f = Float.parseFloat(paramContext))
    {
      paramInt = (int)(f * d2);
      break;
    }
    label364:
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginBottom);
    if (paramContext == null) {}
    for (f = 0.0F;; f = Float.parseFloat(paramContext))
    {
      paramInt = (int)(f * d2);
      break;
    }
  }
  
  public void YM(int paramInt) {}
  
  public final void YO(int paramInt)
  {
    AppMethodBeat.i(312774);
    this.JzP = Integer.valueOf(paramInt);
    AppMethodBeat.o(312774);
  }
  
  public void aIE(String paramString)
  {
    AppMethodBeat.i(312771);
    s.u(paramString, "text");
    AppMethodBeat.o(312771);
  }
  
  public void b(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(312766);
    s.u(paramString, "text");
    AppMethodBeat.o(312766);
  }
  
  public Boolean fPs()
  {
    return null;
  }
  
  public int getFunctionCode()
  {
    AppMethodBeat.i(312761);
    Integer localInteger = this.JzP;
    if (localInteger == null)
    {
      AppMethodBeat.o(312761);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(312761);
    return i;
  }
  
  public View getInsideView()
  {
    return null;
  }
  
  public final Drawable getKeyBackground()
  {
    return this.JzO;
  }
  
  public final int getKeyHeight()
  {
    return this.JzI;
  }
  
  public final int getKeyMarginBottom()
  {
    return this.JzK;
  }
  
  public final int getKeyMarginLeft()
  {
    return this.JzL;
  }
  
  public final int getKeyMarginRight()
  {
    return this.JzM;
  }
  
  public final int getKeyMarginTop()
  {
    return this.JzJ;
  }
  
  public final int getKeyWidth()
  {
    return this.JzH;
  }
  
  public final WeakReference<View.OnTouchListener> getOnTouchListener()
  {
    return this.JzN;
  }
  
  public String getSecondText()
  {
    return "null";
  }
  
  public String getText()
  {
    return "null";
  }
  
  public int getType()
  {
    AppMethodBeat.i(312749);
    Integer localInteger = this.type;
    if (localInteger == null)
    {
      AppMethodBeat.o(312749);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(312749);
    return i;
  }
  
  public int getViewType()
  {
    AppMethodBeat.i(312744);
    Integer localInteger = this.JzG;
    if (localInteger == null)
    {
      AppMethodBeat.o(312744);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(312744);
    return i;
  }
  
  public final Integer getViewType()
  {
    return this.JzG;
  }
  
  public final void setKeyBackground(Drawable paramDrawable)
  {
    this.JzO = paramDrawable;
  }
  
  public final void setKeyHeight(int paramInt)
  {
    this.JzI = paramInt;
  }
  
  public final void setKeyMarginBottom(int paramInt)
  {
    this.JzK = paramInt;
  }
  
  public final void setKeyMarginLeft(int paramInt)
  {
    this.JzL = paramInt;
  }
  
  public final void setKeyMarginRight(int paramInt)
  {
    this.JzM = paramInt;
  }
  
  public final void setKeyMarginTop(int paramInt)
  {
    this.JzJ = paramInt;
  }
  
  public final void setKeyWidth(int paramInt)
  {
    this.JzH = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(312788);
    super.setOnTouchListener(paramOnTouchListener);
    this.JzN = new WeakReference(paramOnTouchListener);
    AppMethodBeat.o(312788);
  }
  
  public final void setOnTouchListener(WeakReference<View.OnTouchListener> paramWeakReference)
  {
    this.JzN = paramWeakReference;
  }
  
  public final void setViewType(Integer paramInteger)
  {
    this.JzG = paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */