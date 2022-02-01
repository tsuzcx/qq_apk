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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "functionCode", "Ljava/lang/Integer;", "keyBackground", "Landroid/graphics/drawable/Drawable;", "getKeyBackground", "()Landroid/graphics/drawable/Drawable;", "setKeyBackground", "(Landroid/graphics/drawable/Drawable;)V", "keyHeight", "getKeyHeight", "()I", "setKeyHeight", "(I)V", "keyMarginBottom", "getKeyMarginBottom", "setKeyMarginBottom", "keyMarginLeft", "getKeyMarginLeft", "setKeyMarginLeft", "keyMarginRight", "getKeyMarginRight", "setKeyMarginRight", "keyMarginTop", "getKeyMarginTop", "setKeyMarginTop", "keyWidth", "getKeyWidth", "setKeyWidth", "onTouchListener", "Ljava/lang/ref/WeakReference;", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Ljava/lang/ref/WeakReference;", "setOnTouchListener", "(Ljava/lang/ref/WeakReference;)V", "type", "viewType", "getViewType", "()Ljava/lang/Integer;", "setViewType", "(Ljava/lang/Integer;)V", "getFunctionCode", "getInsideView", "Landroid/view/View;", "getSecondText", "", "getText", "getType", "isOnlyClickFloatView", "", "()Ljava/lang/Boolean;", "", "l", "updateFunctionCode", "updateSecondText", "text", "updateText", "isUpperMode", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateTextColor", "resId", "updateTextColorStateList", "Companion", "plugin-hld_release"})
public class ImeKeyRelativeLayout
  extends RelativeLayout
{
  public static final a DIN;
  private Integer DID;
  private int DIE;
  private int DIF;
  private int DIG;
  private int DIH;
  private int DII;
  private int DIJ;
  private WeakReference<View.OnTouchListener> DIK;
  private Drawable DIL;
  private Integer DIM;
  private Integer type;
  
  static
  {
    AppMethodBeat.i(216815);
    DIN = new a((byte)0);
    AppMethodBeat.o(216815);
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
    AppMethodBeat.i(216814);
    if (paramContext == null) {
      p.iCn();
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeKeyRelativeLayout, paramInt, 0);
    boolean bool = paramAttributeSet.getBoolean(a.l.ImeKeyRelativeLayout_imeKeyMarginDp, false);
    k localk = k.DHH;
    double d1 = k.gX(paramContext);
    localk = k.DHH;
    double d2 = k.gY(paramContext);
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyWidth);
    if (paramContext != null)
    {
      f = Float.parseFloat(paramContext);
      this.DIE = ((int)(f * d1));
      if (!bool) {
        break label250;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginLeft, 0);
      this.DII = paramInt;
      if (!bool) {
        break label285;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginRight, 0);
      this.DIJ = paramInt;
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyHeight);
      if (paramContext == null) {
        break label320;
      }
    }
    label285:
    label320:
    for (float f = Float.parseFloat(paramContext);; f = 0.0F)
    {
      this.DIF = ((int)(f * d2));
      if (!bool) {
        break label326;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginTop, 0);
      this.DIG = paramInt;
      if (!bool) {
        break label361;
      }
      paramInt = paramAttributeSet.getDimensionPixelSize(a.l.ImeKeyRelativeLayout_imeKeyMarginBottom, 0);
      this.DIH = paramInt;
      this.type = Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyRelativeLayout_keyType, 0));
      this.DIM = Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyRelativeLayout_functionCode, 0));
      this.DIL = paramAttributeSet.getDrawable(a.l.ImeKeyRelativeLayout_imeKeyBackground);
      AppMethodBeat.o(216814);
      return;
      f = 0.0F;
      break;
      label250:
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginLeft);
      if (paramContext != null) {}
      for (f = Float.parseFloat(paramContext);; f = 0.0F)
      {
        paramInt = (int)(f * d1);
        break;
      }
      paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginRight);
      if (paramContext != null) {}
      for (f = Float.parseFloat(paramContext);; f = 0.0F)
      {
        paramInt = (int)(d1 * f);
        break;
      }
    }
    label326:
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginTop);
    if (paramContext != null) {}
    for (f = Float.parseFloat(paramContext);; f = 0.0F)
    {
      paramInt = (int)(f * d2);
      break;
    }
    label361:
    paramContext = paramAttributeSet.getString(a.l.ImeKeyRelativeLayout_imeKeyMarginBottom);
    if (paramContext != null) {}
    for (f = Float.parseFloat(paramContext);; f = 0.0F)
    {
      paramInt = (int)(f * d2);
      break;
    }
  }
  
  public void UO(int paramInt) {}
  
  public final void UQ(int paramInt)
  {
    AppMethodBeat.i(216810);
    this.DIM = Integer.valueOf(paramInt);
    AppMethodBeat.o(216810);
  }
  
  public void aLK(String paramString)
  {
    AppMethodBeat.i(216809);
    p.k(paramString, "text");
    AppMethodBeat.o(216809);
  }
  
  public void b(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(216807);
    p.k(paramString, "text");
    AppMethodBeat.o(216807);
  }
  
  public Boolean eHG()
  {
    return null;
  }
  
  public int getFunctionCode()
  {
    AppMethodBeat.i(216806);
    Integer localInteger = this.DIM;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(216806);
      return i;
    }
    AppMethodBeat.o(216806);
    return 0;
  }
  
  public View getInsideView()
  {
    return null;
  }
  
  public final Drawable getKeyBackground()
  {
    return this.DIL;
  }
  
  public final int getKeyHeight()
  {
    return this.DIF;
  }
  
  public final int getKeyMarginBottom()
  {
    return this.DIH;
  }
  
  public final int getKeyMarginLeft()
  {
    return this.DII;
  }
  
  public final int getKeyMarginRight()
  {
    return this.DIJ;
  }
  
  public final int getKeyMarginTop()
  {
    return this.DIG;
  }
  
  public final int getKeyWidth()
  {
    return this.DIE;
  }
  
  public final WeakReference<View.OnTouchListener> getOnTouchListener()
  {
    return this.DIK;
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
    AppMethodBeat.i(216805);
    Integer localInteger = this.type;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(216805);
      return i;
    }
    AppMethodBeat.o(216805);
    return 0;
  }
  
  public int getViewType()
  {
    AppMethodBeat.i(216804);
    Integer localInteger = this.DID;
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(216804);
      return i;
    }
    AppMethodBeat.o(216804);
    return 0;
  }
  
  public final Integer getViewType()
  {
    return this.DID;
  }
  
  public final void setKeyBackground(Drawable paramDrawable)
  {
    this.DIL = paramDrawable;
  }
  
  public final void setKeyHeight(int paramInt)
  {
    this.DIF = paramInt;
  }
  
  public final void setKeyMarginBottom(int paramInt)
  {
    this.DIH = paramInt;
  }
  
  public final void setKeyMarginLeft(int paramInt)
  {
    this.DII = paramInt;
  }
  
  public final void setKeyMarginRight(int paramInt)
  {
    this.DIJ = paramInt;
  }
  
  public final void setKeyMarginTop(int paramInt)
  {
    this.DIG = paramInt;
  }
  
  public final void setKeyWidth(int paramInt)
  {
    this.DIE = paramInt;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(216811);
    super.setOnTouchListener(paramOnTouchListener);
    this.DIK = new WeakReference(paramOnTouchListener);
    AppMethodBeat.o(216811);
  }
  
  public final void setOnTouchListener(WeakReference<View.OnTouchListener> paramWeakReference)
  {
    this.DIK = paramWeakReference;
  }
  
  public final void setViewType(Integer paramInteger)
  {
    this.DID = paramInteger;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeKeyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */