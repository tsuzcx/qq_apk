package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iImeCheckBoxCallback", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "iconIv$delegate", "Lkotlin/Lazy;", "summaryTv", "Landroid/widget/TextView;", "getSummaryTv", "()Landroid/widget/TextView;", "summaryTv$delegate", "switchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "switchBtn$delegate", "titleTv", "getTitleTv", "titleTv$delegate", "isChecked", "", "setChecked", "", "checked", "setIImeSeekCallback", "checkBoxCallback", "setTitle", "title", "", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeCheckBox
  extends LinearLayout
{
  public static final ImeCheckBox.a JyZ;
  private final j Jza;
  private final j Jzb;
  private final j Jzc;
  private b Jzd;
  private final j vOl;
  
  static
  {
    AppMethodBeat.i(312679);
    JyZ = new ImeCheckBox.a((byte)0);
    AppMethodBeat.o(312679);
  }
  
  public ImeCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312670);
    this.vOl = k.cm((kotlin.g.a.a)new e(this));
    this.Jza = k.cm((kotlin.g.a.a)new d(this));
    this.Jzb = k.cm((kotlin.g.a.a)new b(this));
    this.Jzc = k.cm((kotlin.g.a.a)new c(this));
    af.mU(paramContext).inflate(a.h.mm_preference_summary_checkbox, (ViewGroup)this, true);
    getSwitchBtn().setSwitchListener(new ImeCheckBox..ExternalSyntheticLambda0(this));
    getIconIv().setVisibility(8);
    getSummaryTv().setVisibility(8);
    getTitleTv().setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, a.d.BodyTextSize));
    AppMethodBeat.o(312670);
  }
  
  private static final void a(ImeCheckBox paramImeCheckBox, boolean paramBoolean)
  {
    AppMethodBeat.i(312675);
    s.u(paramImeCheckBox, "this$0");
    b localb = paramImeCheckBox.Jzd;
    if (localb != null) {
      localb.z((View)paramImeCheckBox, paramBoolean);
    }
    AppMethodBeat.o(312675);
  }
  
  private final ImageView getIconIv()
  {
    AppMethodBeat.i(312660);
    Object localObject = this.Jzb.getValue();
    s.s(localObject, "<get-iconIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312660);
    return localObject;
  }
  
  private final TextView getSummaryTv()
  {
    AppMethodBeat.i(312662);
    Object localObject = this.Jzc.getValue();
    s.s(localObject, "<get-summaryTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312662);
    return localObject;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(312656);
    Object localObject = this.vOl.getValue();
    s.s(localObject, "<get-titleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312656);
    return localObject;
  }
  
  public final MMSwitchBtn getSwitchBtn()
  {
    AppMethodBeat.i(312690);
    Object localObject = this.Jza.getValue();
    s.s(localObject, "<get-switchBtn>(...)");
    localObject = (MMSwitchBtn)localObject;
    AppMethodBeat.o(312690);
    return localObject;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(312697);
    getSwitchBtn().setCheck(paramBoolean);
    AppMethodBeat.o(312697);
  }
  
  public final void setIImeSeekCallback(b paramb)
  {
    AppMethodBeat.i(312704);
    s.u(paramb, "checkBoxCallback");
    this.Jzd = paramb;
    AppMethodBeat.o(312704);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(312695);
    s.u(paramString, "title");
    getTitleTv().setText((CharSequence)paramString);
    AppMethodBeat.o(312695);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MMSwitchBtn>
  {
    d(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeCheckBox
 * JD-Core Version:    0.7.0.1
 */