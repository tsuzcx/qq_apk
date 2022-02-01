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
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iImeCheckBoxCallback", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "iconIv$delegate", "Lkotlin/Lazy;", "summaryTv", "Landroid/widget/TextView;", "getSummaryTv", "()Landroid/widget/TextView;", "summaryTv$delegate", "switchBtn", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "getSwitchBtn", "()Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "switchBtn$delegate", "titleTv", "getTitleTv", "titleTv$delegate", "isChecked", "", "setChecked", "", "checked", "setIImeSeekCallback", "checkBoxCallback", "setTitle", "title", "", "Companion", "plugin-hld_release"})
public final class ImeCheckBox
  extends LinearLayout
{
  public static final a DHW;
  private final f DHR;
  private final f DHS;
  private final f DHT;
  private final f DHU;
  private b DHV;
  
  static
  {
    AppMethodBeat.i(209866);
    DHW = new a((byte)0);
    AppMethodBeat.o(209866);
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
    AppMethodBeat.i(209865);
    this.DHR = g.ar((kotlin.g.a.a)new e(this));
    this.DHS = g.ar((kotlin.g.a.a)new d(this));
    this.DHT = g.ar((kotlin.g.a.a)new b(this));
    this.DHU = g.ar((kotlin.g.a.a)new c(this));
    ad.kS(paramContext).inflate(a.h.mm_preference_summary_checkbox, (ViewGroup)this, true);
    getSwitchBtn().setSwitchListener((MMSwitchBtn.a)new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(211407);
        b localb = ImeCheckBox.a(this.DHX);
        if (localb != null)
        {
          localb.t((View)this.DHX, paramAnonymousBoolean);
          AppMethodBeat.o(211407);
          return;
        }
        AppMethodBeat.o(211407);
      }
    });
    getIconIv().setVisibility(8);
    getSummaryTv().setVisibility(8);
    getTitleTv().setTextSize(0, com.tencent.mm.ci.a.aZ(paramContext, a.d.BodyTextSize));
    AppMethodBeat.o(209865);
  }
  
  private final ImageView getIconIv()
  {
    AppMethodBeat.i(209858);
    ImageView localImageView = (ImageView)this.DHT.getValue();
    AppMethodBeat.o(209858);
    return localImageView;
  }
  
  private final TextView getSummaryTv()
  {
    AppMethodBeat.i(209859);
    TextView localTextView = (TextView)this.DHU.getValue();
    AppMethodBeat.o(209859);
    return localTextView;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(209856);
    TextView localTextView = (TextView)this.DHR.getValue();
    AppMethodBeat.o(209856);
    return localTextView;
  }
  
  public final MMSwitchBtn getSwitchBtn()
  {
    AppMethodBeat.i(209857);
    MMSwitchBtn localMMSwitchBtn = (MMSwitchBtn)this.DHS.getValue();
    AppMethodBeat.o(209857);
    return localMMSwitchBtn;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(209862);
    getSwitchBtn().setCheck(paramBoolean);
    AppMethodBeat.o(209862);
  }
  
  public final void setIImeSeekCallback(b paramb)
  {
    AppMethodBeat.i(209864);
    p.k(paramb, "checkBoxCallback");
    this.DHV = paramb;
    AppMethodBeat.o(209864);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(209861);
    p.k(paramString, "title");
    getTitleTv().setText((CharSequence)paramString);
    AppMethodBeat.o(209861);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeCheckBox$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    b(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<TextView>
  {
    c(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<MMSwitchBtn>
  {
    d(ImeCheckBox paramImeCheckBox)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
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