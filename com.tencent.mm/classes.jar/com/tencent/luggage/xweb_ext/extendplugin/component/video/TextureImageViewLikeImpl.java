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
import com.tencent.mm.sdk.platformtools.Log;

public class TextureImageViewLikeImpl
  extends ConstraintLayout
  implements h
{
  private final FrameLayout cIL;
  private final TextureView cIM;
  private final ImageView cIN;
  
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
    AppMethodBeat.i(215668);
    setId(2131296880);
    setBackgroundColor(-16777216);
    this.cIL = new FrameLayout(paramContext);
    addView(this.cIL, -1, -1);
    this.cIL.setId(2131296879);
    this.cIM = new TextureView(paramContext);
    this.cIL.addView(this.cIM, -1, -1);
    this.cIN = new ImageView(paramContext);
    this.cIL.addView(this.cIN, -1, -1);
    this.cIN.setVisibility(4);
    paramContext = new ConstraintSet();
    paramContext.clone(this);
    paramContext.connect(2131296879, 3, 2131296880, 3, 0);
    paramContext.connect(2131296879, 4, 2131296880, 4, 0);
    paramContext.connect(2131296879, 1, 2131296880, 1, 0);
    paramContext.connect(2131296879, 2, 2131296880, 2, 0);
    paramContext.applyTo(this);
    AppMethodBeat.o(215668);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(215673);
    Bitmap localBitmap = this.cIM.getBitmap();
    AppMethodBeat.o(215673);
    return localBitmap;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    AppMethodBeat.i(215674);
    SurfaceTexture localSurfaceTexture = this.cIM.getSurfaceTexture();
    AppMethodBeat.o(215674);
    return localSurfaceTexture;
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    AppMethodBeat.i(215672);
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.cIM.getSurfaceTextureListener();
    AppMethodBeat.o(215672);
    return localSurfaceTextureListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(215675);
    if (paramBitmap != null)
    {
      this.cIN.setImageBitmap(paramBitmap);
      this.cIN.setVisibility(0);
      AppMethodBeat.o(215675);
      return;
    }
    this.cIN.setVisibility(4);
    AppMethodBeat.o(215675);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(215671);
    this.cIM.setSurfaceTextureListener(paramSurfaceTextureListener);
    AppMethodBeat.o(215671);
  }
  
  public void setTextureViewHeightWeight(float paramFloat)
  {
    AppMethodBeat.i(215670);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cIL.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.matchConstraintPercentHeight = paramFloat;
    localLayoutParams.width = -1;
    this.cIL.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(215670);
  }
  
  public void setTextureViewWidthWeight(float paramFloat)
  {
    AppMethodBeat.i(215669);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cIL.getLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.matchConstraintPercentWidth = paramFloat;
    localLayoutParams.height = -1;
    this.cIL.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(215669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl
 * JD-Core Version:    0.7.0.1
 */