package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.a;
import com.tencent.luggage.xweb_ext.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class TextureImageViewLikeImpl
  extends ConstraintLayout
  implements h
{
  private final FrameLayout eCZ;
  private final TextureView eDa;
  private final ImageView ewg;
  
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
    AppMethodBeat.i(220872);
    setId(a.b.app_brand_pip_video_image_container);
    setBackgroundColor(-16777216);
    this.eCZ = new FrameLayout(paramContext);
    addView(this.eCZ, -1, -1);
    this.eCZ.setId(a.b.app_brand_pip_video_image_area);
    this.eDa = new TextureView(paramContext);
    this.eCZ.addView(this.eDa, -1, -1);
    this.ewg = new ImageView(paramContext);
    this.eCZ.addView(this.ewg, -1, -1);
    this.ewg.setVisibility(4);
    paramContext = new a();
    paramContext.b(this);
    paramContext.e(a.b.app_brand_pip_video_image_area, 3, a.b.app_brand_pip_video_image_container, 3, 0);
    paramContext.e(a.b.app_brand_pip_video_image_area, 4, a.b.app_brand_pip_video_image_container, 4, 0);
    paramContext.e(a.b.app_brand_pip_video_image_area, 1, a.b.app_brand_pip_video_image_container, 1, 0);
    paramContext.e(a.b.app_brand_pip_video_image_area, 2, a.b.app_brand_pip_video_image_container, 2, 0);
    paramContext.c(this);
    AppMethodBeat.o(220872);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(220922);
    Bitmap localBitmap = this.eDa.getBitmap();
    AppMethodBeat.o(220922);
    return localBitmap;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    AppMethodBeat.i(220930);
    SurfaceTexture localSurfaceTexture = this.eDa.getSurfaceTexture();
    AppMethodBeat.o(220930);
    return localSurfaceTexture;
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    AppMethodBeat.i(220911);
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.eDa.getSurfaceTextureListener();
    AppMethodBeat.o(220911);
    return localSurfaceTextureListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(220934);
    if (paramBitmap != null)
    {
      this.ewg.setImageBitmap(paramBitmap);
      this.ewg.setVisibility(0);
      AppMethodBeat.o(220934);
      return;
    }
    this.ewg.setVisibility(4);
    AppMethodBeat.o(220934);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(220900);
    this.eDa.setSurfaceTextureListener(paramSurfaceTextureListener);
    AppMethodBeat.o(220900);
  }
  
  public void setTextureViewHeightWeight(float paramFloat)
  {
    AppMethodBeat.i(220892);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.eCZ.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.blQ = paramFloat;
    localLayoutParams.width = -1;
    this.eCZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(220892);
  }
  
  public void setTextureViewWidthWeight(float paramFloat)
  {
    AppMethodBeat.i(220882);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.eCZ.getLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.blP = paramFloat;
    localLayoutParams.height = -1;
    this.eCZ.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(220882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl
 * JD-Core Version:    0.7.0.1
 */