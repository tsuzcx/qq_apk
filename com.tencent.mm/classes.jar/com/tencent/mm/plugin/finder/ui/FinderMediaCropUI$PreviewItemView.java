package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderMediaCropUI$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-finder_release"})
public final class FinderMediaCropUI$PreviewItemView
  extends FrameLayout
{
  private final ImageView dtJ;
  private final View hcH;
  private final int padding;
  private final int sOE;
  private final View sOF;
  private final int size;
  
  public FinderMediaCropUI$PreviewItemView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(167351);
    paramContext = ak.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.sOE = paramContext.getResources().getColor(2131100726);
    this.dtJ = new ImageView(getContext());
    this.hcH = new View(getContext());
    this.sOF = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.padding = ((int)paramContext.getResources().getDimension(2131165274));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.size = ((int)paramContext.getResources().getDimension(2131165300));
    this.dtJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
    Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramContext.gravity = 17;
    localLayoutParams.gravity = 17;
    this.sOF.setBackgroundColor(this.sOE);
    addView(this.sOF, (ViewGroup.LayoutParams)paramContext);
    addView((View)this.dtJ, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext = this.hcH;
    localObject = getContext();
    p.g(localObject, "context");
    paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
    this.hcH.setAlpha(0.5F);
    paramContext = new FrameLayout.LayoutParams(-2, -1);
    paramContext.gravity = 17;
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(167351);
  }
  
  public FinderMediaCropUI$PreviewItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(167352);
    paramContext = ak.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.sOE = paramContext.getResources().getColor(2131100726);
    this.dtJ = new ImageView(getContext());
    this.hcH = new View(getContext());
    this.sOF = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.padding = ((int)paramContext.getResources().getDimension(2131165274));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.size = ((int)paramContext.getResources().getDimension(2131165300));
    this.dtJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
    paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
    paramAttributeSet.gravity = 17;
    paramContext.gravity = 17;
    localLayoutParams.gravity = 17;
    this.sOF.setBackgroundColor(this.sOE);
    addView(this.sOF, (ViewGroup.LayoutParams)paramContext);
    addView((View)this.dtJ, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext = this.hcH;
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
    this.hcH.setAlpha(0.5F);
    paramContext = new FrameLayout.LayoutParams(-2, -1);
    paramContext.gravity = 17;
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(167352);
  }
  
  public FinderMediaCropUI$PreviewItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(167353);
    paramContext = ak.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.sOE = paramContext.getResources().getColor(2131100726);
    this.dtJ = new ImageView(getContext());
    this.hcH = new View(getContext());
    this.sOF = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.padding = ((int)paramContext.getResources().getDimension(2131165274));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.size = ((int)paramContext.getResources().getDimension(2131165300));
    this.dtJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
    paramAttributeSet = new FrameLayout.LayoutParams(this.size, this.size);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
    paramAttributeSet.gravity = 17;
    paramContext.gravity = 17;
    localLayoutParams.gravity = 17;
    this.sOF.setBackgroundColor(this.sOE);
    addView(this.sOF, (ViewGroup.LayoutParams)paramContext);
    addView((View)this.dtJ, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext = this.hcH;
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramContext.setBackgroundColor(paramAttributeSet.getResources().getColor(2131101179));
    this.hcH.setAlpha(0.5F);
    paramContext = new FrameLayout.LayoutParams(-2, -1);
    paramContext.gravity = 17;
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(167353);
  }
  
  public final View getFocusedView()
  {
    return this.sOF;
  }
  
  public final ImageView getImageView()
  {
    return this.dtJ;
  }
  
  public final View getMaskView()
  {
    return this.hcH;
  }
  
  public final int getPadding()
  {
    return this.padding;
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(167349);
    super.setFocusable(paramBoolean);
    if (paramBoolean)
    {
      this.sOF.setVisibility(0);
      AppMethodBeat.o(167349);
      return;
    }
    this.sOF.setVisibility(4);
    AppMethodBeat.o(167349);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(167350);
    super.setSelected(paramBoolean);
    if (paramBoolean)
    {
      this.hcH.setVisibility(4);
      AppMethodBeat.o(167350);
      return;
    }
    this.hcH.setVisibility(0);
    AppMethodBeat.o(167350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.PreviewItemView
 * JD-Core Version:    0.7.0.1
 */