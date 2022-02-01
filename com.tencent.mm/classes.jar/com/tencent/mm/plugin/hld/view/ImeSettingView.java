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
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeSettingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconContainerIv", "getIconContainerIv", "()Landroid/widget/RelativeLayout;", "iconContainerIv$delegate", "Lkotlin/Lazy;", "iconDefaultImg", "Landroid/graphics/drawable/Drawable;", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "iconIv$delegate", "keyMarginBottom", "getKeyMarginBottom", "()I", "setKeyMarginBottom", "(I)V", "keyMarginLeft", "getKeyMarginLeft", "setKeyMarginLeft", "keyMarginTop", "getKeyMarginTop", "setKeyMarginTop", "keyWidth", "getKeyWidth", "setKeyWidth", "titleStr", "", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "titleTv$delegate", "onFinishInflate", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeSettingView
  extends RelativeLayout
{
  public static final ImeSettingView.a JAe;
  private String JAf;
  private final j JAg;
  private Drawable JAh;
  private int JzH;
  private int JzJ;
  private int JzK;
  private int JzL;
  private final j Jzb;
  private final j vOl;
  
  static
  {
    AppMethodBeat.i(312548);
    JAe = new ImeSettingView.a((byte)0);
    AppMethodBeat.o(312548);
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
    AppMethodBeat.i(312539);
    this.JAg = kotlin.k.cm((a)new b(this));
    this.Jzb = kotlin.k.cm((a)new c(this));
    this.vOl = kotlin.k.cm((a)new d(this));
    af.mU(paramContext).inflate(a.h.wxime_setting_view, (ViewGroup)this, true);
    s.checkNotNull(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeSettingView, paramInt, 0);
    s.s(paramAttributeSet, "context!!.obtainStyledAt…ingView, defStyleAttr, 0)");
    this.JAf = paramAttributeSet.getString(a.l.ImeSettingView_keyboard_title);
    this.JAh = paramAttributeSet.getDrawable(a.l.ImeSettingView_icon_src_default);
    com.tencent.mm.plugin.hld.f.k localk = com.tencent.mm.plugin.hld.f.k.JyF;
    double d = com.tencent.mm.plugin.hld.f.k.is(paramContext);
    localk = com.tencent.mm.plugin.hld.f.k.JyF;
    if (com.tencent.mm.plugin.hld.f.k.isLandscape())
    {
      localk = com.tencent.mm.plugin.hld.f.k.JyF;
      d = com.tencent.mm.plugin.hld.f.k.it(paramContext);
    }
    paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingWidth);
    if (paramContext == null)
    {
      f1 = 0.0F;
      this.JzH = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginTop);
      if (paramContext != null) {
        break label282;
      }
      f1 = 0.0F;
      label203:
      this.JzJ = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginBottom);
      if (paramContext != null) {
        break label291;
      }
      f1 = 0.0F;
      label229:
      this.JzK = ((int)(f1 * d));
      paramContext = paramAttributeSet.getString(a.l.ImeSettingView_imeSettingMarginLeft);
      if (paramContext != null) {
        break label300;
      }
    }
    label282:
    label291:
    label300:
    for (float f1 = f2;; f1 = Float.parseFloat(paramContext))
    {
      this.JzL = ((int)(d * f1));
      AppMethodBeat.o(312539);
      return;
      f1 = Float.parseFloat(paramContext);
      break;
      f1 = Float.parseFloat(paramContext);
      break label203;
      f1 = Float.parseFloat(paramContext);
      break label229;
    }
  }
  
  private final RelativeLayout getIconContainerIv()
  {
    AppMethodBeat.i(312494);
    Object localObject = this.JAg.getValue();
    s.s(localObject, "<get-iconContainerIv>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312494);
    return localObject;
  }
  
  private final ImageView getIconIv()
  {
    AppMethodBeat.i(312501);
    Object localObject = this.Jzb.getValue();
    s.s(localObject, "<get-iconIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312501);
    return localObject;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(312508);
    Object localObject = this.vOl.getValue();
    s.s(localObject, "<get-titleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312508);
    return localObject;
  }
  
  public final int getKeyMarginBottom()
  {
    return this.JzK;
  }
  
  public final int getKeyMarginLeft()
  {
    return this.JzL;
  }
  
  public final int getKeyMarginTop()
  {
    return this.JzJ;
  }
  
  public final int getKeyWidth()
  {
    return this.JzH;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(312607);
    super.onFinishInflate();
    getTitleTv().setText((CharSequence)this.JAf);
    getIconIv().setImageDrawable(this.JAh);
    Object localObject = getIconContainerIv().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(312607);
      throw ((Throwable)localObject);
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).width = this.JzH;
    ((RelativeLayout.LayoutParams)localObject).height = this.JzH;
    getIconContainerIv().setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(312607);
  }
  
  public final void setKeyMarginBottom(int paramInt)
  {
    this.JzK = paramInt;
  }
  
  public final void setKeyMarginLeft(int paramInt)
  {
    this.JzL = paramInt;
  }
  
  public final void setKeyMarginTop(int paramInt)
  {
    this.JzJ = paramInt;
  }
  
  public final void setKeyWidth(int paramInt)
  {
    this.JzH = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<RelativeLayout>
  {
    b(ImeSettingView paramImeSettingView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ImageView>
  {
    c(ImeSettingView paramImeSettingView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
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