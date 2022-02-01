package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.xweb_ext.extendplugin.component.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class TextureImageViewLikeImpl
  extends ConstraintLayout
  implements h
{
  private final FrameLayout cuk;
  private final TextureView cul;
  private final ImageView cum;
  
  public TextureImageViewLikeImpl(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextureImageViewLikeImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureImageViewLikeImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(186793);
    setId(2131303460);
    setBackgroundColor(-16777216);
    this.cuk = new FrameLayout(paramContext);
    addView(this.cuk, -1, -1);
    this.cuk.setId(2131303459);
    this.cul = new TextureView(paramContext);
    this.cuk.addView(this.cul, -1, -1);
    this.cum = new ImageView(paramContext);
    this.cuk.addView(this.cum, -1, -1);
    this.cum.setVisibility(4);
    paramContext = new ConstraintSet();
    paramContext.clone(this);
    paramContext.connect(2131303459, 3, 2131303460, 3, 0);
    paramContext.connect(2131303459, 4, 2131303460, 4, 0);
    paramContext.connect(2131303459, 1, 2131303460, 1, 0);
    paramContext.connect(2131303459, 2, 2131303460, 2, 0);
    paramContext.applyTo(this);
    AppMethodBeat.o(186793);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(186798);
    Bitmap localBitmap = this.cul.getBitmap();
    AppMethodBeat.o(186798);
    return localBitmap;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    AppMethodBeat.i(186799);
    SurfaceTexture localSurfaceTexture = this.cul.getSurfaceTexture();
    AppMethodBeat.o(186799);
    return localSurfaceTexture;
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    AppMethodBeat.i(186797);
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.cul.getSurfaceTextureListener();
    AppMethodBeat.o(186797);
    return localSurfaceTextureListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(186800);
    if (paramBitmap != null)
    {
      this.cum.setImageBitmap(paramBitmap);
      this.cum.setVisibility(0);
      AppMethodBeat.o(186800);
      return;
    }
    this.cum.setVisibility(4);
    AppMethodBeat.o(186800);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(186796);
    this.cul.setSurfaceTextureListener(paramSurfaceTextureListener);
    AppMethodBeat.o(186796);
  }
  
  public void setTextureViewHeightWeight(float paramFloat)
  {
    AppMethodBeat.i(186795);
    ad.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cuk.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.matchConstraintPercentHeight = paramFloat;
    localLayoutParams.width = -1;
    this.cuk.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(186795);
  }
  
  public void setTextureViewWidthWeight(float paramFloat)
  {
    AppMethodBeat.i(186794);
    ad.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cuk.getLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.matchConstraintPercentWidth = paramFloat;
    localLayoutParams.height = -1;
    this.cuk.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(186794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl
 * JD-Core Version:    0.7.0.1
 */