package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.ui.ad;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeSettingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconContainerIv", "getIconContainerIv", "()Landroid/widget/RelativeLayout;", "iconContainerIv$delegate", "Lkotlin/Lazy;", "iconDefaultImg", "Landroid/graphics/drawable/Drawable;", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "iconIv$delegate", "keyMarginBottom", "getKeyMarginBottom", "()I", "setKeyMarginBottom", "(I)V", "keyMarginLeft", "getKeyMarginLeft", "setKeyMarginLeft", "keyMarginTop", "getKeyMarginTop", "setKeyMarginTop", "keyWidth", "getKeyWidth", "setKeyWidth", "titleStr", "", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "titleTv$delegate", "onFinishInflate", "", "Companion", "plugin-hld_release"})
public final class ImeSettingView
  extends RelativeLayout
{
  public static final a DJf;
  private final f DHR;
  private final f DHT;
  private int DIE;
  private int DIG;
  private int DIH;
  private int DII;
  private String DJc;
  private final f DJd;
  private Drawable DJe;
  
  static
  {
    AppMethodBeat.i(213529);
    DJf = new a((byte)0);
    AppMethodBeat.o(213529);
  }
  
  public ImeSettingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeSettingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeSettingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(213526);
    this.DJd = g.ar((a)new b(this));
    this.DHT = g.ar((a)new c(this));
    this.DHR = g.ar((a)new d(this));
    ad.kS(paramContext).inflate(a.h.wxime_setting_view, (ViewGroup)this, true);
    if (paramContext == null) {
      p.iCn();
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeSettingView, paramInt, 0);
    this.DJc = paramAttributeSet.getString(a.l.ImeSettingView_keyboard_title);
    this.DJe = paramAttributeSet.getDrawable(a.l.ImeSettingView_icon_src_default);
    k localk = k.DHH;
    double d = k.gX(paramContext);
    localk = k.DHH;
    if (k.isLandscape())
    {
      localk = k.DHH;
      d = k.gY(paramContext);
    }
    paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingWidth);
    if (paramContext != null)
    {
      f1 = Float.parseFloat(paramContext);
      this.DIE = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginTop);
      if (paramContext == null) {
        break label291;
      }
      f1 = Float.parseFloat(paramContext);
      label206:
      this.DIG = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginBottom);
      if (paramContext == null) {
        break label297;
      }
    }
    label291:
    label297:
    for (float f1 = Float.parseFloat(paramContext);; f1 = 0.0F)
    {
      this.DIH = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginLeft);
      f1 = f2;
      if (paramContext != null) {
        f1 = Float.parseFloat(paramContext);
      }
      this.DII = ((int)(d * f1));
      AppMethodBeat.o(213526);
      return;
      f1 = 0.0F;
      break;
      f1 = 0.0F;
      break label206;
    }
  }
  
  private final RelativeLayout getIconContainerIv()
  {
    AppMethodBeat.i(213512);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DJd.getValue();
    AppMethodBeat.o(213512);
    return localRelativeLayout;
  }
  
  private final ImageView getIconIv()
  {
    AppMethodBeat.i(213513);
    ImageView localImageView = (ImageView)this.DHT.getValue();
    AppMethodBeat.o(213513);
    return localImageView;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(213514);
    TextView localTextView = (TextView)this.DHR.getValue();
    AppMethodBeat.o(213514);
    return localTextView;
  }
  
  public final int getKeyMarginBottom()
  {
    return this.DIH;
  }
  
  public final int getKeyMarginLeft()
  {
    return this.DII;
  }
  
  public final int getKeyMarginTop()
  {
    return this.DIG;
  }
  
  public final int getKeyWidth()
  {
    return this.DIE;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(213524);
    super.onFinishInflate();
    getTitleTv().setText((CharSequence)this.DJc);
    getIconIv().setImageDrawable(this.DJe);
    Object localObject = getIconContainerIv().getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(213524);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).width = this.DIE;
    ((RelativeLayout.LayoutParams)localObject).height = this.DIE;
    getIconContainerIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(213524);
  }
  
  public final void setKeyMarginBottom(int paramInt)
  {
    this.DIH = paramInt;
  }
  
  public final void setKeyMarginLeft(int paramInt)
  {
    this.DII = paramInt;
  }
  
  public final void setKeyMarginTop(int paramInt)
  {
    this.DIG = paramInt;
  }
  
  public final void setKeyWidth(int paramInt)
  {
    this.DIE = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeSettingView$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<RelativeLayout>
  {
    b(ImeSettingView paramImeSettingView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<ImageView>
  {
    c(ImeSettingView paramImeSettingView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<TextView>
  {
    d(ImeSettingView paramImeSettingView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeSettingView
 * JD-Core Version:    0.7.0.1
 */