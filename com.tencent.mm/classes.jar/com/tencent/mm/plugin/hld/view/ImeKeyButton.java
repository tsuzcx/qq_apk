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
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeKeyButton;", "Lcom/tencent/mm/plugin/hld/view/ImeKeyRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "buttonTextView", "Landroid/widget/TextView;", "getButtonTextView", "()Landroid/widget/TextView;", "buttonTextView$delegate", "Lkotlin/Lazy;", "iconColor", "Ljava/lang/Integer;", "iconHeight", "iconImg", "Landroid/graphics/drawable/Drawable;", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "iconIv$delegate", "iconWidth", "insideRootView", "Landroid/view/View;", "getInsideRootView", "()Landroid/view/View;", "insideRootView$delegate", "isOnlyClickFloatView", "", "Ljava/lang/Boolean;", "textColor", "textColorStateList", "Landroid/content/res/ColorStateList;", "textMarginTopSize", "", "Ljava/lang/Float;", "textSize", "textSizeUpperMode", "textStr", "", "upTextSize", "upTextStr", "upTextView", "getUpTextView", "upTextView$delegate", "getInsideView", "getSecondText", "getText", "()Ljava/lang/Boolean;", "onFinishInflate", "", "updateButtonTextColor", "enabled", "resId", "updateImg", "colorId", "updateSecondText", "text", "updateText", "isUpperMode", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateTextColor", "updateTextColorStateList", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeKeyButton
  extends ImeKeyRelativeLayout
{
  public static final ImeKeyButton.a Jzo;
  private Integer Fgw;
  private Boolean JzA;
  private Drawable JzB;
  private Integer JzC;
  private Integer JzD;
  private final j Jzb;
  private final j Jzp;
  private final j Jzq;
  private final j Jzr;
  private String Jzs;
  private String Jzt;
  private Float Jzu;
  private Float Jzv;
  private Float Jzw;
  private Float Jzx;
  private Integer Jzy;
  private ColorStateList Jzz;
  
  static
  {
    AppMethodBeat.i(312595);
    Jzo = new ImeKeyButton.a((byte)0);
    AppMethodBeat.o(312595);
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
    AppMethodBeat.i(312580);
    this.Jzp = k.cm((kotlin.g.a.a)new d(this));
    this.Jzq = k.cm((kotlin.g.a.a)new e(this));
    this.Jzr = k.cm((kotlin.g.a.a)new b(this));
    this.JzA = Boolean.FALSE;
    this.Jzb = k.cm((kotlin.g.a.a)new c(this));
    s.checkNotNull(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeKeyButton, paramInt, 0);
    s.s(paramAttributeSet, "context!!.obtainStyledAt…yButton, defStyleAttr, 0)");
    setViewType(Integer.valueOf(paramAttributeSet.getInt(a.l.ImeKeyButton_key_view_type, 1)));
    Integer localInteger = getViewType();
    if (localInteger == null)
    {
      if (localInteger != null) {
        break label353;
      }
      label144:
      paramInt = 0;
      label146:
      if (paramInt == 0) {
        break label406;
      }
      localInteger = getViewType();
      if (localInteger != null) {
        break label367;
      }
      label161:
      af.mU(paramContext).inflate(a.m.wxime_key_buttom_layout, (ViewGroup)this, true);
      label177:
      this.Jzs = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
      this.Jzt = paramAttributeSet.getString(a.l.ImeKeyButton_text);
      this.Jzu = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
      this.Jzv = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
      this.Jzw = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
      if (s.a(this.Jzw, 0.0F)) {
        this.Jzw = this.Jzv;
      }
      this.Jzx = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
      this.Jzy = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
      this.Jzz = paramAttributeSet.getColorStateList(a.l.ImeKeyButton_key_text_color_state_list);
      this.JzA = Boolean.valueOf(paramAttributeSet.getBoolean(a.l.ImeKeyButton_key_only_click_float, false));
    }
    for (;;)
    {
      setHapticFeedbackEnabled(false);
      AppMethodBeat.o(312580);
      return;
      if (localInteger.intValue() != 5) {
        break;
      }
      paramInt = 1;
      break label146;
      label353:
      if (localInteger.intValue() != 1) {
        break label144;
      }
      paramInt = 1;
      break label146;
      label367:
      if (localInteger.intValue() != 5) {
        break label161;
      }
      af.mU(paramContext).inflate(a.m.wxime_key_padding_buttom_layout, (ViewGroup)this, true);
      getInsideRootView().setBackground(getKeyBackground());
      break label177;
      label406:
      if (localInteger == null)
      {
        label411:
        if (localInteger != null) {
          break label534;
        }
        label416:
        paramInt = 0;
        label418:
        if (paramInt == 0) {
          break label588;
        }
        localInteger = getViewType();
        if (localInteger != null) {
          break label548;
        }
        label433:
        af.mU(paramContext).inflate(a.m.wxime_key_img_buttom_layout, (ViewGroup)this, true);
      }
      for (;;)
      {
        this.Fgw = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_icon_color, paramContext.getResources().getColor(a.c.FG_0)));
        this.JzB = paramAttributeSet.getDrawable(a.l.ImeKeyButton_icon_src);
        this.JzC = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
        this.JzD = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
        break;
        if (localInteger.intValue() != 6) {
          break label411;
        }
        paramInt = 1;
        break label418;
        label534:
        if (localInteger.intValue() != 2) {
          break label416;
        }
        paramInt = 1;
        break label418;
        label548:
        if (localInteger.intValue() != 6) {
          break label433;
        }
        af.mU(paramContext).inflate(a.m.wxime_key_padding_img_buttom_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
      }
      label588:
      if (localInteger == null)
      {
        label593:
        if (localInteger != null) {
          break label701;
        }
        label598:
        paramInt = 0;
        label600:
        if (paramInt == 0) {
          break label755;
        }
        localInteger = getViewType();
        if (localInteger != null) {
          break label715;
        }
        label615:
        af.mU(paramContext).inflate(a.m.wxime_key_exchange_buttom_layout, (ViewGroup)this, true);
      }
      for (;;)
      {
        this.Jzs = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
        this.Jzt = paramAttributeSet.getString(a.l.ImeKeyButton_text);
        this.Jzu = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
        this.Jzv = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
        break;
        if (localInteger.intValue() != 7) {
          break label593;
        }
        paramInt = 1;
        break label600;
        label701:
        if (localInteger.intValue() != 3) {
          break label598;
        }
        paramInt = 1;
        break label600;
        label715:
        if (localInteger.intValue() != 7) {
          break label615;
        }
        af.mU(paramContext).inflate(a.h.wxime_key_padding_exchange_buttom_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
      }
      label755:
      if (localInteger == null) {
        label760:
        if (localInteger != null) {
          break label964;
        }
      }
      label964:
      while (localInteger.intValue() != 8)
      {
        Log.w("WxIme.KeyButton", "ImeKeyButton viewType:" + getViewType() + " ????");
        break;
        if (localInteger.intValue() != 4) {
          break label760;
        }
        af.mU(paramContext).inflate(a.m.wxime_key_buttom_large_up_layout, (ViewGroup)this, true);
        getInsideRootView().setBackground(getKeyBackground());
        this.Jzs = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
        this.Jzt = paramAttributeSet.getString(a.l.ImeKeyButton_text);
        this.Jzu = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
        this.Jzv = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
        this.Jzw = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
        if (s.a(this.Jzw, 0.0F)) {
          this.Jzw = this.Jzv;
        }
        this.Jzx = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
        this.Jzy = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
        break;
      }
      af.mU(paramContext).inflate(a.m.wxime_key_text_padding_img_buttom_layout, (ViewGroup)this, true);
      getInsideRootView().setBackground(getKeyBackground());
      this.Jzt = paramAttributeSet.getString(a.l.ImeKeyButton_text);
      this.Jzs = paramAttributeSet.getString(a.l.ImeKeyButton_up_text);
      this.Jzu = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_up_text_size, 0.0F));
      this.Jzv = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size, 0.0F));
      this.Jzw = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_size_upper_mode, 0.0F));
      if (s.a(this.Jzw, 0.0F)) {
        this.Jzw = this.Jzv;
      }
      this.Jzx = Float.valueOf(paramAttributeSet.getDimension(a.l.ImeKeyButton_key_text_margin_top, 0.0F));
      this.Jzy = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_key_text_color, paramContext.getResources().getColor(a.c.key_text_color_default)));
      this.Jzz = paramAttributeSet.getColorStateList(a.l.ImeKeyButton_key_text_color_state_list);
      this.Fgw = Integer.valueOf(paramAttributeSet.getColor(a.l.ImeKeyButton_icon_color, paramContext.getResources().getColor(a.c.FG_0)));
      this.JzB = paramAttributeSet.getDrawable(a.l.ImeKeyButton_icon_src);
      this.JzC = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
      this.JzD = Integer.valueOf((int)paramAttributeSet.getDimension(a.l.ImeKeyButton_icon_width, 0.0F));
    }
  }
  
  private final WeImageView getIconIv()
  {
    AppMethodBeat.i(312542);
    Object localObject = this.Jzb.getValue();
    s.s(localObject, "<get-iconIv>(...)");
    localObject = (WeImageView)localObject;
    AppMethodBeat.o(312542);
    return localObject;
  }
  
  private final View getInsideRootView()
  {
    AppMethodBeat.i(312526);
    Object localObject = this.Jzp.getValue();
    s.s(localObject, "<get-insideRootView>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(312526);
    return localObject;
  }
  
  private final TextView getUpTextView()
  {
    AppMethodBeat.i(312533);
    Object localObject = this.Jzq.getValue();
    s.s(localObject, "<get-upTextView>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312533);
    return localObject;
  }
  
  public final void YM(int paramInt)
  {
    AppMethodBeat.i(312642);
    getButtonTextView().setTextColor(getResources().getColor(paramInt));
    AppMethodBeat.o(312642);
  }
  
  public final void YN(int paramInt)
  {
    AppMethodBeat.i(312650);
    Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
    getIconIv().setImageDrawable(localDrawable);
    AppMethodBeat.o(312650);
  }
  
  public final void aIE(String paramString)
  {
    AppMethodBeat.i(312638);
    s.u(paramString, "text");
    getUpTextView().setText((CharSequence)paramString);
    AppMethodBeat.o(312638);
  }
  
  public final void b(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(312633);
    s.u(paramString, "text");
    getButtonTextView().setText((CharSequence)paramString);
    if (paramBoolean != null)
    {
      if (paramBoolean.booleanValue())
      {
        paramString = getButtonTextView();
        paramBoolean = this.Jzw;
        s.checkNotNull(paramBoolean);
        paramString.setTextSize(0, paramBoolean.floatValue());
        AppMethodBeat.o(312633);
        return;
      }
      paramString = getButtonTextView();
      paramBoolean = this.Jzv;
      s.checkNotNull(paramBoolean);
      paramString.setTextSize(0, paramBoolean.floatValue());
    }
    AppMethodBeat.o(312633);
  }
  
  public final Boolean fPs()
  {
    return this.JzA;
  }
  
  public final TextView getButtonTextView()
  {
    AppMethodBeat.i(312602);
    Object localObject = this.Jzr.getValue();
    s.s(localObject, "<get-buttonTextView>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312602);
    return localObject;
  }
  
  public final View getInsideView()
  {
    AppMethodBeat.i(312645);
    View localView = getInsideRootView();
    AppMethodBeat.o(312645);
    return localView;
  }
  
  public final String getSecondText()
  {
    String str2 = this.Jzs;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getText()
  {
    String str2 = this.Jzt;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  protected final void onFinishInflate()
  {
    int j = 1;
    int k = 1;
    AppMethodBeat.i(312619);
    super.onFinishInflate();
    Object localObject1 = getViewType();
    label31:
    int i;
    label33:
    label39:
    label97:
    label104:
    label108:
    float f;
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label238;
      }
      i = 0;
      if (i == 0) {
        break label252;
      }
      i = 1;
      if (i == 0) {
        break label419;
      }
      getUpTextView().setText((CharSequence)this.Jzs);
      getButtonTextView().setText((CharSequence)this.Jzt);
      localObject1 = this.Jzu;
      if (localObject1 != null)
      {
        if (((Number)localObject1).floatValue() != 0.0F) {
          break label276;
        }
        i = 1;
        if (i != 0) {
          break label281;
        }
        i = k;
        if (i == 0) {
          break label286;
        }
        if (localObject1 != null)
        {
          f = ((Number)localObject1).floatValue();
          getUpTextView().setTextSize(0, f);
        }
      }
      localObject1 = g.JuL;
      if (!g.fMm()) {
        break label292;
      }
      localObject1 = this.Jzw;
      if (localObject1 != null)
      {
        f = ((Number)localObject1).floatValue();
        getButtonTextView().setTextSize(0, f);
      }
      label171:
      if (this.Jzz == null) {
        break label324;
      }
      getButtonTextView().setTextColor(this.Jzz);
    }
    for (;;)
    {
      localObject1 = getButtonTextView().getLayoutParams();
      if (localObject1 != null) {
        break label355;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(312619);
      throw ((Throwable)localObject1);
      if (((Integer)localObject1).intValue() != 5) {
        break;
      }
      i = 1;
      break label33;
      label238:
      if (((Integer)localObject1).intValue() != 4) {
        break label31;
      }
      i = 1;
      break label33;
      label252:
      if (localObject1 == null) {}
      while (((Integer)localObject1).intValue() != 1)
      {
        i = 0;
        break;
      }
      i = 1;
      break label39;
      label276:
      i = 0;
      break label97;
      label281:
      i = 0;
      break label104;
      label286:
      localObject1 = null;
      break label108;
      label292:
      localObject1 = this.Jzv;
      if (localObject1 == null) {
        break label171;
      }
      f = ((Number)localObject1).floatValue();
      getButtonTextView().setTextSize(0, f);
      break label171;
      label324:
      localObject1 = this.Jzy;
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        getButtonTextView().setTextColor(i);
      }
    }
    label355:
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    Object localObject2 = this.Jzx;
    s.checkNotNull(localObject2);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)((Float)localObject2).floatValue());
    getButtonTextView().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    aw.a((Paint)getButtonTextView().getPaint(), 0.1F);
    AppMethodBeat.o(312619);
    return;
    label419:
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label556;
      }
      label429:
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label570;
      }
      localObject1 = this.Fgw;
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        getIconIv().setIconColor(i);
      }
      getIconIv().setImageDrawable(this.JzB);
      localObject1 = getIconIv().getLayoutParams();
      localObject2 = this.JzC;
      s.checkNotNull(localObject2);
      ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
      localObject2 = this.JzD;
      s.checkNotNull(localObject2);
      ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
      getIconIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(312619);
      return;
      if (((Integer)localObject1).intValue() != 6) {
        break;
      }
      i = 1;
      continue;
      label556:
      if (((Integer)localObject1).intValue() != 2) {
        break label429;
      }
      i = 1;
    }
    label570:
    if (localObject1 == null)
    {
      if (localObject1 != null) {
        break label795;
      }
      label580:
      i = 0;
      label582:
      if (i == 0) {
        break label841;
      }
      getUpTextView().setText((CharSequence)this.Jzs);
      getButtonTextView().setText((CharSequence)this.Jzt);
      ((TextView)findViewById(a.f.solidus_tv)).setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.d.ime_exchange_below_text_size));
      localObject1 = this.Jzu;
      if (localObject1 != null)
      {
        if (((Number)localObject1).floatValue() != 0.0F) {
          break label809;
        }
        i = 1;
        if (i != 0) {
          break label814;
        }
        i = 1;
        if (i == 0) {
          break label819;
        }
        if (localObject1 != null)
        {
          f = ((Number)localObject1).floatValue();
          getUpTextView().setTextSize(0, f);
        }
      }
      localObject1 = this.Jzv;
      if (localObject1 != null)
      {
        if (((Number)localObject1).floatValue() != 0.0F) {
          break label825;
        }
        i = 1;
        label724:
        if (i != 0) {
          break label830;
        }
        i = j;
        label730:
        if (i == 0) {
          break label835;
        }
      }
    }
    for (;;)
    {
      label665:
      label671:
      label675:
      if (localObject1 != null)
      {
        f = ((Number)localObject1).floatValue();
        getButtonTextView().setTextSize(0, f);
      }
      aw.a((Paint)getButtonTextView().getPaint(), 0.1F);
      AppMethodBeat.o(312619);
      return;
      if (((Integer)localObject1).intValue() != 7) {
        break;
      }
      i = 1;
      break label582;
      label795:
      if (((Integer)localObject1).intValue() != 3) {
        break label580;
      }
      i = 1;
      break label582;
      label809:
      i = 0;
      break label665;
      label814:
      i = 0;
      break label671;
      label819:
      localObject1 = null;
      break label675;
      label825:
      i = 0;
      break label724;
      label830:
      i = 0;
      break label730;
      label835:
      localObject1 = null;
    }
    label841:
    if (localObject1 == null)
    {
      AppMethodBeat.o(312619);
      return;
    }
    if (((Integer)localObject1).intValue() == 8)
    {
      getUpTextView().setText((CharSequence)this.Jzs);
      localObject1 = this.Jzu;
      if (localObject1 != null)
      {
        if (((Number)localObject1).floatValue() != 0.0F) {
          break label1042;
        }
        i = 1;
        if (i != 0) {
          break label1047;
        }
        i = 1;
        label909:
        if (i == 0) {
          break label1052;
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
      localObject1 = this.Fgw;
      if (localObject1 != null)
      {
        i = ((Number)localObject1).intValue();
        getIconIv().setIconColor(i);
      }
      getIconIv().setImageDrawable(this.JzB);
      localObject1 = getIconIv().getLayoutParams();
      localObject2 = this.JzC;
      s.checkNotNull(localObject2);
      ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
      localObject2 = this.JzD;
      s.checkNotNull(localObject2);
      ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
      getIconIv().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(312619);
      return;
      label1042:
      i = 0;
      break;
      label1047:
      i = 0;
      break label909;
      label1052:
      localObject1 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    c(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(ImeKeyButton paramImeKeyButton)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
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