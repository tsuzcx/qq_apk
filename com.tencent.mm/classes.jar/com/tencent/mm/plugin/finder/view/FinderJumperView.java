package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderJumperView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultIconId", "getDefaultIconId", "()I", "setDefaultIconId", "(I)V", "defaultTitle", "", "getDefaultTitle", "()Ljava/lang/String;", "setDefaultTitle", "(Ljava/lang/String;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "filledIconId", "getFilledIconId", "setFilledIconId", "iconDefaultIv", "Landroid/widget/ImageView;", "getIconDefaultIv", "()Landroid/widget/ImageView;", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "refresh", "", "title", "toggleToDefault", "toggleToFilled", "showProductIcon", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderJumperView
  extends RelativeLayout
{
  private final WeImageView Bqk;
  private final ImageView GAc;
  private int GAd;
  private int GAe;
  private final TextView descTv;
  private String pLF;
  
  public FinderJumperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344271);
    this.pLF = "";
    af.mU(getContext()).inflate(e.f.finder_choose_product_layout, (ViewGroup)this, true);
    paramContext = findViewById(e.e.choose_product_iv);
    s.s(paramContext, "findViewById(R.id.choose_product_iv)");
    this.Bqk = ((WeImageView)paramContext);
    paramContext = findViewById(e.e.choose_product_tv);
    s.s(paramContext, "findViewById(R.id.choose_product_tv)");
    this.descTv = ((TextView)paramContext);
    paramContext = findViewById(e.e.choose_product_iv_default);
    s.s(paramContext, "findViewById(R.id.choose_product_iv_default)");
    this.GAc = ((ImageView)paramContext);
    fkv();
    AppMethodBeat.o(344271);
  }
  
  public FinderJumperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344280);
    this.pLF = "";
    af.mU(getContext()).inflate(e.f.finder_choose_product_layout, (ViewGroup)this, true);
    paramContext = findViewById(e.e.choose_product_iv);
    s.s(paramContext, "findViewById(R.id.choose_product_iv)");
    this.Bqk = ((WeImageView)paramContext);
    paramContext = findViewById(e.e.choose_product_tv);
    s.s(paramContext, "findViewById(R.id.choose_product_tv)");
    this.descTv = ((TextView)paramContext);
    paramContext = findViewById(e.e.choose_product_iv_default);
    s.s(paramContext, "findViewById(R.id.choose_product_iv_default)");
    this.GAc = ((ImageView)paramContext);
    fkv();
    AppMethodBeat.o(344280);
  }
  
  public final void bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(344356);
    s.u(paramString, "title");
    if (paramBoolean)
    {
      this.Bqk.setVisibility(0);
      this.GAc.setVisibility(8);
      this.Bqk.setImageResource(this.GAe);
      this.Bqk.setIconColor(getContext().getResources().getColor(e.b.Orange));
    }
    for (;;)
    {
      this.descTv.setText((CharSequence)paramString);
      this.descTv.setTextColor(getContext().getResources().getColor(e.b.Orange));
      AppMethodBeat.o(344356);
      return;
      this.Bqk.setVisibility(8);
      this.GAc.setVisibility(0);
    }
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(344351);
    this.Bqk.setVisibility(0);
    this.GAc.setVisibility(8);
    this.Bqk.setImageResource(this.GAd);
    this.Bqk.setIconColor(getContext().getResources().getColor(e.b.FG_0));
    this.descTv.setText((CharSequence)this.pLF);
    this.descTv.setTextColor(getContext().getResources().getColor(e.b.normal_text_color));
    AppMethodBeat.o(344351);
  }
  
  public final int getDefaultIconId()
  {
    return this.GAd;
  }
  
  public final String getDefaultTitle()
  {
    return this.pLF;
  }
  
  public final TextView getDescTv()
  {
    return this.descTv;
  }
  
  public final int getFilledIconId()
  {
    return this.GAe;
  }
  
  public final ImageView getIconDefaultIv()
  {
    return this.GAc;
  }
  
  public final WeImageView getIconIv()
  {
    return this.Bqk;
  }
  
  public final void setDefaultIconId(int paramInt)
  {
    this.GAd = paramInt;
  }
  
  public final void setDefaultTitle(String paramString)
  {
    AppMethodBeat.i(344321);
    s.u(paramString, "<set-?>");
    this.pLF = paramString;
    AppMethodBeat.o(344321);
  }
  
  public final void setFilledIconId(int paramInt)
  {
    this.GAe = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderJumperView
 * JD-Core Version:    0.7.0.1
 */