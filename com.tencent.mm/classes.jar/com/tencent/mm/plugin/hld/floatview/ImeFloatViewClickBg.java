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
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bgWidth", "", "buttonWidth", "centerRl", "getCenterRl", "()Landroid/widget/RelativeLayout;", "centerRl$delegate", "Lkotlin/Lazy;", "mContext", "getBgWidth", "getButtonWidth", "Companion", "plugin-hld_release"})
public final class ImeFloatViewClickBg
  extends RelativeLayout
{
  public static final a Dxb;
  private final f DwY;
  private float DwZ;
  private float Dxa;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(211788);
    Dxb = new a((byte)0);
    AppMethodBeat.o(211788);
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
    AppMethodBeat.i(211787);
    this.DwY = g.ar((kotlin.g.a.a)new b(this));
    this.mContext = paramContext;
    Object localObject = k.DHH;
    localObject = this.mContext;
    if (localObject == null) {
      p.iCn();
    }
    double d = k.gX((Context)localObject);
    localObject = getResources().getString(a.j.S2_button_width);
    p.j(localObject, "resources.getString(R.string.S2_button_width)");
    this.DwZ = ((float)(d * Float.parseFloat((String)localObject)));
    if (paramContext == null) {
      p.iCn();
    }
    paramInt = paramContext.obtainStyledAttributes(paramAttributeSet, a.l.ImeFloatViewClickBg, paramInt, 0).getInt(a.l.ImeFloatViewClickBg_ime_float_view_click_bg_type, 1);
    if (paramInt == 1)
    {
      ad.kS(paramContext).inflate(a.h.ime_key_float_view_click_bg, (ViewGroup)this, true);
      this.Dxa = (this.DwZ + com.tencent.mm.ci.a.aZ(paramContext, a.d.ime_float_view_click_bg_part_width) * 2);
    }
    for (;;)
    {
      paramContext = getCenterRl().getLayoutParams();
      if (paramContext != null) {
        break;
      }
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
      AppMethodBeat.o(211787);
      throw paramContext;
      if (paramInt == 2)
      {
        ad.kS(paramContext).inflate(a.h.ime_key_float_view_click_left_bg, (ViewGroup)this, true);
        this.Dxa = (this.DwZ + com.tencent.mm.ci.a.aZ(paramContext, a.d.ime_float_view_click_bg_part_width));
      }
      else if (paramInt == 3)
      {
        ad.kS(paramContext).inflate(a.h.ime_key_float_view_click_right_bg, (ViewGroup)this, true);
        this.Dxa = (this.DwZ + com.tencent.mm.ci.a.aZ(paramContext, a.d.ime_float_view_click_bg_part_width));
      }
      else
      {
        Log.e("WxIme.ImeClickFloatBgView", "no correct key_click_bg_type(" + paramInt + ')');
      }
    }
    paramContext.width = ((int)this.DwZ);
    getCenterRl().setLayoutParams(paramContext);
    AppMethodBeat.o(211787);
  }
  
  private final RelativeLayout getCenterRl()
  {
    AppMethodBeat.i(211784);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DwY.getValue();
    AppMethodBeat.o(211784);
    return localRelativeLayout;
  }
  
  public final int getBgWidth()
  {
    return (int)this.Dxa;
  }
  
  public final int getButtonWidth()
  {
    return (int)this.DwZ;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/floatview/ImeFloatViewClickBg$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
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