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
  private final FrameLayout cJp;
  private final TextureView cJq;
  private final ImageView cJr;
  
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
    AppMethodBeat.i(222514);
    setId(a.b.app_brand_pip_video_image_container);
    setBackgroundColor(-16777216);
    this.cJp = new FrameLayout(paramContext);
    addView(this.cJp, -1, -1);
    this.cJp.setId(a.b.app_brand_pip_video_image_area);
    this.cJq = new TextureView(paramContext);
    this.cJp.addView(this.cJq, -1, -1);
    this.cJr = new ImageView(paramContext);
    this.cJp.addView(this.cJr, -1, -1);
    this.cJr.setVisibility(4);
    paramContext = new a();
    paramContext.b(this);
    paramContext.d(a.b.app_brand_pip_video_image_area, 3, a.b.app_brand_pip_video_image_container, 3);
    paramContext.d(a.b.app_brand_pip_video_image_area, 4, a.b.app_brand_pip_video_image_container, 4);
    paramContext.d(a.b.app_brand_pip_video_image_area, 1, a.b.app_brand_pip_video_image_container, 1);
    paramContext.d(a.b.app_brand_pip_video_image_area, 2, a.b.app_brand_pip_video_image_container, 2);
    paramContext.c(this);
    AppMethodBeat.o(222514);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(222530);
    Bitmap localBitmap = this.cJq.getBitmap();
    AppMethodBeat.o(222530);
    return localBitmap;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    AppMethodBeat.i(222533);
    SurfaceTexture localSurfaceTexture = this.cJq.getSurfaceTexture();
    AppMethodBeat.o(222533);
    return localSurfaceTexture;
  }
  
  public TextureView.SurfaceTextureListener getSurfaceTextureListener()
  {
    AppMethodBeat.i(222529);
    TextureView.SurfaceTextureListener localSurfaceTextureListener = this.cJq.getSurfaceTextureListener();
    AppMethodBeat.o(222529);
    return localSurfaceTextureListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(222535);
    if (paramBitmap != null)
    {
      this.cJr.setImageBitmap(paramBitmap);
      this.cJr.setVisibility(0);
      AppMethodBeat.o(222535);
      return;
    }
    this.cJr.setVisibility(4);
    AppMethodBeat.o(222535);
  }
  
  public void setSurfaceTextureListener(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(222526);
    this.cJq.setSurfaceTextureListener(paramSurfaceTextureListener);
    AppMethodBeat.o(222526);
  }
  
  public void setTextureViewHeightWeight(float paramFloat)
  {
    AppMethodBeat.i(222524);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewHeightWeight, heightWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cJp.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.FL = paramFloat;
    localLayoutParams.width = -1;
    this.cJp.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(222524);
  }
  
  public void setTextureViewWidthWeight(float paramFloat)
  {
    AppMethodBeat.i(222519);
    Log.i("MicroMsg.AppBrand.TextureImageViewLikeImpl", "setTextureViewWidthWeight, widthWeight: ".concat(String.valueOf(paramFloat)));
    ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.cJp.getLayoutParams();
    localLayoutParams.width = 0;
    localLayoutParams.FK = paramFloat;
    localLayoutParams.height = -1;
    this.cJp.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(222519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.TextureImageViewLikeImpl
 * JD-Core Version:    0.7.0.1
 */