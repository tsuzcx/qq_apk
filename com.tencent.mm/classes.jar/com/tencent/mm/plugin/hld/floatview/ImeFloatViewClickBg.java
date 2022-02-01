package com.tencent.mm.plugin.hld.floatview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bgWidth", "", "buttonWidth", "centerRl", "getCenterRl", "()Landroid/widget/RelativeLayout;", "centerRl$delegate", "Lkotlin/Lazy;", "mContext", "getBgWidth", "getButtonWidth", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeFloatViewClickBg
  extends RelativeLayout
{
  public static final ImeFloatViewClickBg.a Jqd;
  private final j Jqe;
  private float Jqf;
  private float Jqg;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(312791);
    Jqd = new ImeFloatViewClickBg.a((byte)0);
    AppMethodBeat.o(312791);
  }
  
  public ImeFloatViewClickBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ImeFloatViewClickBg(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ImeFloatViewClickBg(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(312779);
    this.Jqe = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.mContext = paramContext;
    Object localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    localObject = this.mContext;
    s.checkNotNull(localObject);
    double d = com.tencent.mm.plugin.hld.f.k.is((Context)localObject);
    localObject = getResources().getString(a.j.S2_button_width);
    s.s(localObject, "resources.getString(R.string.S2_button_width)");
    this.Jqf = ((float)(d * Float.parseFloat((String)localObject)));
    s.checkNotNull(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeFloatViewClickBg, paramInt, 0);
    s.s(paramAttributeSet, "context!!.obtainStyledAt…ClickBg, defStyleAttr, 0)");
    paramInt = paramAttributeSet.getInt(a.l.ImeFloatViewClickBg_ime_float_view_click_bg_type, 1);
    switch (paramInt)
    {
    default: 
      Log.e("WxIme.ImeClickFloatBgView", "no correct key_click_bg_type(" + paramInt + ')');
    }
    for (;;)
    {
      paramContext = getCenterRl().getLayoutParams();
      if (paramContext != null) {
        break;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(312779);
      throw paramContext;
      af.mU(paramContext).inflate(a.h.ime_key_float_view_click_bg, (ViewGroup)this, true);
      this.Jqg = (this.Jqf + com.tencent.mm.cd.a.bs(paramContext, a.d.ime_float_view_click_bg_part_width) * 2);
      continue;
      af.mU(paramContext).inflate(a.h.ime_key_float_view_click_left_bg, (ViewGroup)this, true);
      this.Jqg = (this.Jqf + com.tencent.mm.cd.a.bs(paramContext, a.d.ime_float_view_click_bg_part_width));
      continue;
      af.mU(paramContext).inflate(a.h.ime_key_float_view_click_right_bg, (ViewGroup)this, true);
      this.Jqg = (this.Jqf + com.tencent.mm.cd.a.bs(paramContext, a.d.ime_float_view_click_bg_part_width));
    }
    paramContext.width = ((int)this.Jqf);
    getCenterRl().setLayoutParams(paramContext);
    AppMethodBeat.o(312779);
  }
  
  private final RelativeLayout getCenterRl()
  {
    AppMethodBeat.i(312753);
    Object localObject = this.Jqe.getValue();
    s.s(localObject, "<get-centerRl>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312753);
    return localObject;
  }
  
  public final int getBgWidth()
  {
    return (int)this.Jqg;
  }
  
  public final int getButtonWidth()
  {
    return (int)this.Jqf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(ImeFloatViewClickBg paramImeFloatViewClickBg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.floatview.ImeFloatViewClickBg
 * JD-Core Version:    0.7.0.1
 */