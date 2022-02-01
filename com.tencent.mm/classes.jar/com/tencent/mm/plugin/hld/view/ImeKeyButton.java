package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "buttonTextView", "Landroid/widget/TextView;", "getButtonTextView", "()Landroid/widget/TextView;", "buttonTextView$delegate", "Lkotlin/Lazy;", "iconColor", "Ljava/lang/Integer;", "iconHeight", "iconImg", "Landroid/graphics/drawable/Drawable;", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "iconIv$delegate", "iconWidth", "insideRootView", "Landroid/view/View;", "getInsideRootView", "()Landroid/view/View;", "insideRootView$delegate", "isOnlyClickFloatView", "", "Ljava/lang/Boolean;", "textColor", "textColorStateList", "Landroid/content/res/ColorStateList;", "textMarginTopSize", "", "Ljava/lang/Float;", "textSize", "textSizeUpperMode", "textStr", "", "upTextSize", "upTextStr", "upTextView", "getUpTextView", "upTextView$delegate", "getInsideView", "getSecondText", "getText", "()Ljava/lang/Boolean;", "onFinishInflate", "", "updateButtonTextColor", "enabled", "resId", "updateImg", "colorId", "updateSecondText", "text", "updateText", "isUpperMode", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateTextColor", "updateTextColorStateList", "Companion", "plugin-hld_release"})
public final class ImeKeyButton
  extends ImeKeyRelativeLayout
{
  public static final a DIB;
  private final f DHT;
  private Integer DIA;
  private final f DIl;
  private final f DIm;
  private final f DIn;
  private String DIo;
  private String DIp;
  private Float DIq;
  private Float DIr;
  private Float DIs;
  private Float DIt;
  private Integer DIu;
  private ColorStateList DIv;
  private Boolean DIw;
  private Integer DIx;
  private Drawable DIy;
  private Integer DIz;
  
  static
  {
    AppMethodBeat.i(214968);
    DIB = new a((byte)0);
    AppMethodBeat.o(214968);
  }
  
  public ImeKeyButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeKeyButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeKeyButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(214966);
    this.DIl = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.DIm = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.DIn = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.DIw = Boolean.FALSE;
    this.DHT = kotlin.g.ar((kotlin.g.a.a)new c(this));
    if (paramContext == null) {
      p.iCn();
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeKeyButton, paramInt, 0);
    setViewType(Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyButton_key_view_type, 1)));
    Integer localInteger = getViewType();
    if (localInteger == null)
    {
      if (localInteger != null) {
        break label400;
      }
      if (localInteger != null) {
        break label451;
      }
      label146:
      if (localInteger != null) {
        break label558;
      }
      if (localInteger != null) {
        break label610;
      }
      label156:
      if (localInteger != null) {
        break label702;
      }
      if (localInteger != null) {
        break label754;
      }
      label166:
      if (localInteger != null) {
        break label917;
      }
      label171:
      Log.w("WxIme.KeyButton", "ImeKeyButton viewType:" + getViewType() + " ????");
    }
    for (;;)
    {
      label200:
      setHapticFeedbackEnabled(false);
      AppMethodBeat.o(214966);
      return;
      if (localInteger.intValue() != 5) {
        break;
      }
      label220:
      localInteger = getViewType();
      if (localInteger == null) {
        label231:
        ad.kS(paramContext).inflate(a.m.wxime_key_buttom_layout, (ViewGroup)this, true);
      }
      for (;;)
      {
        this.DIo = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
        this.DIp = paramAttributeSet.getString(a.l.ImeKeyButton_text);
        this.DIq = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
        this.DIr = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
        this.DIs = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
        if (p.e(this.DIs)) {
          this.DIs = this.DIr;
        }
        this.DIt = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
        this.DIu = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
        this.DIv = paramAttributeSet.getColorStateList(a.l.ImeKeyButton_key_text_color_state_list);
        this.DIw = Boolean.valueOf(paramAttributeSet.getBoolean(a.l.ImeKeyButton_key_only_click_float, false));
        break label200;
        label400:
        if (localInteger.intValue() != 1) {
          break;
        }
        break label220;
        if (localInteger.intValue() != 5) {
          break label231;
        }
        ad.kS(paramContext).inflate(a.m.wxime_key_padding_buttom_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
      }
      label451:
      if (localInteger.intValue() != 6) {
        break label146;
      }
      label461:
      localInteger = getViewType();
      if (localInteger == null) {
        label472:
        ad.kS(paramContext).inflate(a.m.wxime_key_img_buttom_layout, (ViewGroup)this, true);
      }
      for (;;)
      {
        this.DIx = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_icon_color, paramContext.getResources().getColor(a.c.FG_0)));
        this.DIy = paramAttributeSet.getDrawable(a.l.ImeKeyButton_icon_src);
        this.DIz = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
        this.DIA = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
        break label200;
        label558:
        if (localInteger.intValue() != 2) {
          break;
        }
        break label461;
        if (localInteger.intValue() != 6) {
          break label472;
        }
        ad.kS(paramContext).inflate(a.m.wxime_key_padding_img_buttom_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
      }
      label610:
      if (localInteger.intValue() != 7) {
        break label156;
      }
      label620:
      localInteger = getViewType();
      if (localInteger == null) {
        label631:
        ad.kS(paramContext).inflate(a.m.wxime_key_exchange_buttom_layout, (ViewGroup)this, true);
      }
      for (;;)
      {
        this.DIo = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
        this.DIp = paramAttributeSet.getString(a.l.ImeKeyButton_text);
        this.DIq = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
        this.DIr = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
        break label200;
        label702:
        if (localInteger.intValue() != 3) {
          break;
        }
        break label620;
        if (localInteger.intValue() != 7) {
          break label631;
        }
        ad.kS(paramContext).inflate(a.h.wxime_key_padding_exchange_buttom_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
      }
      label754:
      if (localInteger.intValue() != 4) {
        break label166;
      }
      ad.kS(paramContext).inflate(a.m.wxime_key_buttom_large_up_layout, (ViewGroup)this, true);
      getInsideRootView().setBackground(getKeyBackground());
      this.DIo = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
      this.DIp = paramAttributeSet.getString(a.l.ImeKeyButton_text);
      this.DIq = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
      this.DIr = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
      this.DIs = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
      if (p.e(this.DIs)) {
        this.DIs = this.DIr;
      }
      this.DIt = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
      this.DIu = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
      continue;
      label917:
      if (localInteger.intValue() != 8) {
        break label171;
      }
      ad.kS(paramContext).inflate(a.m.wxime_key_text_padding_img_buttom_layout, (ViewGroup)this, true);
      getInsideRootView().setBackground(getKeyBackground());
      this.DIp = paramAttributeSet.getString(a.l.ImeKeyButton_text);
      this.DIo = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
      this.DIq = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
      this.DIr = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
      this.DIs = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
      if (p.e(this.DIs)) {
        this.DIs = this.DIr;
      }
      this.DIt = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
      this.DIu = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
      this.DIv = paramAttributeSet.getColorStateList(a.l.ImeKeyButton_key_text_color_state_list);
      this.DIx = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_icon_color, paramContext.getResources().getColor(a.c.FG_0)));
      this.DIy = paramAttributeSet.getDrawable(a.l.ImeKeyButton_icon_src);
      this.DIz = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
      this.DIA = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
    }
  }
  
  private final WeImageView getIconIv()
  {
    AppMethodBeat.i(214939);
    WeImageView localWeImageView = (WeImageView)this.DHT.getValue();
    AppMethodBeat.o(214939);
    return localWeImageView;
  }
  
  private final View getInsideRootView()
  {
    AppMethodBeat.i(214934);
    View localView = (View)this.DIl.getValue();
    AppMethodBeat.o(214934);
    return localView;
  }
  
  private final TextView getUpTextView()
  {
    AppMethodBeat.i(214935);
    TextView localTextView = (TextView)this.DIm.getValue();
    AppMethodBeat.o(214935);
    return localTextView;
  }
  
  public final void UO(int paramInt)
  {
    AppMethodBeat.i(214952);
    getButtonTextView().setTextColor(getResources().getColor(paramInt));
    AppMethodBeat.o(214952);
  }
  
  public final void UP(int paramInt)
  {
    AppMethodBeat.i(214956);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(paramInt);
    getIconIv().setImageDrawable((Drawable)localObject);
    AppMethodBeat.o(214956);
  }
  
  public final void aLK(String paramString)
  {
    AppMethodBeat.i(214951);
    p.k(paramString, "text");
    getUpTextView().setText((CharSequence)paramString);
    AppMethodBeat.o(214951);
  }
  
  public final void b(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(214949);
    p.k(paramString, "text");
    getButtonTextView().setText((CharSequence)paramString);
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramString = getButtonTextView();
        paramBoolean = this.DIs;
        if (paramBoolean == null) {
          p.iCn();
        }
        paramString.setTextSize(0, paramBoolean.floatValue());
        AppMethodBeat.o(214949);
        return;
      }
      paramString = getButtonTextView();
      paramBoolean = this.DIr;
      if (paramBoolean == null) {
        p.iCn();
      }
      paramString.setTextSize(0, paramBoolean.floatValue());
      AppMethodBeat.o(214949);
      return;
    }
    AppMethodBeat.o(214949);
  }
  
  public final Boolean eHG()
  {
    return this.DIw;
  }
  
  public final TextView getButtonTextView()
  {
    AppMethodBeat.i(214936);
    TextView localTextView = (TextView)this.DIn.getValue();
    AppMethodBeat.o(214936);
    return localTextView;
  }
  
  public final View getInsideView()
  {
    AppMethodBeat.i(214953);
    View localView = getInsideRootView();
    AppMethodBeat.o(214953);
    return localView;
  }
  
  public final String getSecondText()
  {
    String str2 = this.DIo;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getText()
  {
    String str2 = this.DIp;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  protected final void onFinishInflate()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(214946);
    super.onFinishInflate();
    Object localObject1 = getViewType();
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label248;
      }
      if (localObject1 != null) {
        break label260;
      }
      label35:
      if (localObject1 != null) {
        break label413;
      }
      label40:
      if (localObject1 != null) {
        break label535;
      }
      if (localObject1 != null) {
        break label547;
      }
    }
    label76:
    float f;
    label128:
    label132:
    label195:
    label248:
    Object localObject2;
    for (;;)
    {
      label640:
      if (localObject1 == null)
      {
        if (localObject1 != null) {
          break label773;
        }
        AppMethodBeat.o(214946);
        return;
        if (((Integer)localObject1).intValue() != 5) {
          break;
        }
        getUpTextView().setText((CharSequence)this.DIo);
        getButtonTextView().setText((CharSequence)this.DIp);
        localObject1 = this.DIq;
        if (localObject1 != null)
        {
          if (((Number)localObject1).floatValue() == 0.0F) {
            break label272;
          }
          if (i == 0) {
            break label277;
          }
          if (localObject1 != null)
          {
            f = ((Number)localObject1).floatValue();
            getUpTextView().setTextSize(0, f);
          }
        }
        localObject1 = com.tencent.mm.plugin.hld.model.g.DCm;
        if (com.tencent.mm.plugin.hld.model.g.eEk())
        {
          localObject1 = this.DIs;
          if (localObject1 != null)
          {
            f = ((Number)localObject1).floatValue();
            getButtonTextView().setTextSize(0, f);
          }
          if (this.DIv == null) {
            break label315;
          }
          getButtonTextView().setTextColor(this.DIv);
        }
        for (;;)
        {
          localObject1 = getButtonTextView().getLayoutParams();
          if (localObject1 != null) {
            break label346;
          }
          localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(214946);
          throw ((Throwable)localObject1);
          if (((Integer)localObject1).intValue() == 4) {
            break label76;
          }
          break;
          label260:
          if (((Integer)localObject1).intValue() != 1) {
            break label35;
          }
          break label76;
          label272:
          i = 0;
          break label128;
          label277:
          localObject1 = null;
          break label132;
          localObject1 = this.DIr;
          if (localObject1 == null) {
            break label195;
          }
          f = ((Number)localObject1).floatValue();
          getButtonTextView().setTextSize(0, f);
          break label195;
          label315:
          localObject1 = this.DIu;
          if (localObject1 != null)
          {
            i = ((Number)localObject1).intValue();
            getButtonTextView().setTextColor(i);
          }
        }
        label346:
        localObject1 = (RelativeLayout.LayoutParams)localObject1;
        localObject2 = this.DIt;
        if (localObject2 == null) {
          p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)((Float)localObject2).floatValue());
        getButtonTextView().setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ar.a((Paint)getButtonTextView().getPaint(), 0.1F);
        AppMethodBeat.o(214946);
        return;
        label413:
        if (((Integer)localObject1).intValue() != 6) {
          break label40;
        }
        for (;;)
        {
          localObject1 = this.DIx;
          if (localObject1 != null)
          {
            i = ((Number)localObject1).intValue();
            getIconIv().setIconColor(i);
          }
          getIconIv().setImageDrawable(this.DIy);
          localObject1 = getIconIv().getLayoutParams();
          localObject2 = this.DIz;
          if (localObject2 == null) {
            p.iCn();
          }
          ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
          localObject2 = this.DIA;
          if (localObject2 == null) {
            p.iCn();
          }
          ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
          getIconIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
          AppMethodBeat.o(214946);
          return;
          label535:
          if (((Integer)localObject1).intValue() != 2) {
            break;
          }
        }
        label547:
        if (((Integer)localObject1).intValue() == 7)
        {
          label557:
          getUpTextView().setText((CharSequence)this.DIo);
          getButtonTextView().setText((CharSequence)this.DIp);
          ((TextView)findViewById(a.f.solidus_tv)).setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_exchange_below_text_size));
          localObject1 = this.DIq;
          if (localObject1 != null)
          {
            if (((Number)localObject1).floatValue() == 0.0F) {
              break label751;
            }
            i = 1;
            label636:
            if (i == 0) {
              break label756;
            }
            if (localObject1 != null)
            {
              f = ((Number)localObject1).floatValue();
              getUpTextView().setTextSize(0, f);
            }
          }
          localObject1 = this.DIr;
          if (localObject1 != null)
          {
            if (((Number)localObject1).floatValue() == 0.0F) {
              break label762;
            }
            i = j;
            label689:
            if (i == 0) {
              break label767;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        f = ((Number)localObject1).floatValue();
        getButtonTextView().setTextSize(0, f);
      }
      ar.a((Paint)getButtonTextView().getPaint(), 0.1F);
      AppMethodBeat.o(214946);
      return;
      if (((Integer)localObject1).intValue() != 3) {
        break;
      }
      break label557;
      label751:
      i = 0;
      break label636;
      label756:
      localObject1 = null;
      break label640;
      label762:
      i = 0;
      break label689;
      label767:
      localObject1 = null;
    }
    label773:
    if (((Integer)localObject1).intValue() == 8)
    {
      getUpTextView().setText((CharSequence)this.DIo);
      localObject1 = this.DIq;
      if (localObject1 != null)
      {
        if (((Number)localObject1).floatValue() == 0.0F) {
          break label962;
        }
        i = 1;
        if (i == 0) {
          break label967;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        f = ((Number)localObject1).floatValue();
        getUpTextView().setTextSize(0, f);
      }
      localObject1 = this.DIx;
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        getIconIv().setIconColor(i);
      }
      getIconIv().setImageDrawable(this.DIy);
      localObject1 = getIconIv().getLayoutParams();
      localObject2 = this.DIz;
      if (localObject2 == null) {
        p.iCn();
      }
      ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
      localObject2 = this.DIA;
      if (localObject2 == null) {
        p.iCn();
      }
      ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
      getIconIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(214946);
      return;
      label962:
      i = 0;
      break;
      label967:
      localObject1 = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeKeyButton$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<TextView>
  {
    b(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    c(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<View>
  {
    d(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeKeyButton
 * JD-Core Version:    0.7.0.1
 */