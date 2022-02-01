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
import com.tencent.mm.sdk.platformtools.ae;

public class TextureImageViewLikeImpl
  extends ConstraintLayout
  implements h
{
  private final FrameLayout cuN;
  private final TextureView cuO;
  private final ImageView cuP;
  
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
    AppMethodBeat.i(220476);
    setId(2131303460);
    setBackgroundColor(-16777216);
    this.cuN = new FrameLayout(paramContext);
    addView(this.cuN, -1, -1);
    this.cuN.setId(2131303459);
    this.cuO = new TextureView(paramContext);
    this.cuN.addView(this.cuO, -1, -1);
    this.cuP = new ImageView(paramContext);
    this.cuN.addView(this.cuP, -1, -1);
    this.cuP.setVisibility(4);
    paramContext = new ConstraintSet();
    paramContext.clone(this);
    paramContext.connect(2131303459, 3, 2131303460, 3, 0);
    paramContext.connect(2131303459, 4, 2131303460, 4, 0);
    paramContext.connect(2131303459, 1, 2131303460, 1, 0);
    paramContext.connect(2131303459, 2, 2131303460, 2, 0);
    paramContext.applyTo(this);
    AppMethodBeat.o(220476);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(220481);
    Bitmap localBitmap = this.cuO.getBitmap();
    AppMethodBeat.o(220481);
    return localBitmap;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    AppMethodBeat.i(220482);
    SurfaceTexture localSurfaceTexture = this.cuO.getSurfaceTexture();
    AppMethodBeat.o(220482);
    return localSurfaceTexture;
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    AppMethodBeat.i(220480);
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.cuO.getSurfaceTextureListener();
    AppMethodBeat.o(220480);
    return localSurfaceTextureListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(220483);
    if (paramBitmap != null)
    {
      this.cuP.setImageBitmap(paramBitmap);
      this.cuP.setVisibility(0);
      AppMethodBeat.o(220483);
      return;
    }
    this.cuP.setVisibility(4);
    AppMethodBeat.o(220483);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(220479);
    this.cuO.setSurfaceTextureListener(paramSurfaceTextureListener);
    AppMethodBeat.o(220479);
  }
  
  public void setTextureViewHeightWeight(float paramFloat)
  {
    AppMethodBeat.i(220478);
    ae.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cuN.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.matchConstraintPercentHeight = paramFloat;
    localLayoutParams.width = -1;
    this.cuN.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(220478);
  }
  
  public void setTextureViewWidthWeight(float paramFloat)
  {
    AppMethodBeat.i(220477);
    ae.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cuN.getLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.matchConstraintPercentWidth = paramFloat;
    localLayoutParams.height = -1;
    this.cuN.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(220477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl
 * JD-Core Version:    0.7.0.1
 */