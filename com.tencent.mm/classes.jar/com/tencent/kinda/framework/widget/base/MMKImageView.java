package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KImageView;
import com.tencent.kinda.gen.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class MMKImageView
  extends MMKView<CdnImageView>
  implements KImageView
{
  private byte[] ImageData;
  private MMKImage defaultImage;
  private MMKImage image;
  private ScaleType scaleType;
  private DynamicColor tintColor;
  
  public MMKImageView()
  {
    AppMethodBeat.i(19052);
    this.image = new MMKImage();
    this.defaultImage = new MMKImage();
    this.tintColor = new DynamicColor(0L, 0L);
    AppMethodBeat.o(19052);
  }
  
  public CdnImageView createView(Context paramContext)
  {
    AppMethodBeat.i(19053);
    paramContext = new CdnImageView(paramContext);
    paramContext.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext.setAdjustViewBounds(true);
    this.image.setNeedGetNetworkImageImmediately(false);
    this.defaultImage.setNeedGetNetworkImageImmediately(false);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(19053);
    return paramContext;
  }
  
  public String getDarkModeUrl()
  {
    return null;
  }
  
  public String getDefaultUrl()
  {
    AppMethodBeat.i(19057);
    String str = this.defaultImage.getUrl();
    AppMethodBeat.o(19057);
    return str;
  }
  
  public KImage getImage()
  {
    return this.image;
  }
  
  public byte[] getImageData()
  {
    return this.ImageData;
  }
  
  public ScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public DynamicColor getTintColor()
  {
    return this.tintColor;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(19055);
    String str = this.image.getUrl();
    AppMethodBeat.o(19055);
    return str;
  }
  
  public void setDarkModeUrl(String paramString) {}
  
  public void setDefaultUrl(String paramString)
  {
    AppMethodBeat.i(19056);
    if (this.defaultImage == null) {
      this.defaultImage = new MMKImage();
    }
    this.defaultImage.setUrl(paramString);
    if (((this.image == null) || (bt.isNullOrNil(this.image.getUrl()))) && (!bt.isNullOrNil(this.defaultImage.getUrl())))
    {
      if (!this.defaultImage.isNetworkImage()) {
        break label104;
      }
      ((CdnImageView)getView()).setUrl(this.defaultImage.getUrl());
    }
    for (;;)
    {
      setCornerRadius(2.0F);
      AppMethodBeat.o(19056);
      return;
      label104:
      ((CdnImageView)getView()).setImageBitmap(this.defaultImage.getBitmap());
    }
  }
  
  public void setImage(KImage paramKImage)
  {
    AppMethodBeat.i(19058);
    if ((paramKImage != null) && ((paramKImage instanceof MMKImage)))
    {
      this.image = ((MMKImage)paramKImage);
      if (!this.image.isNetworkImage()) {
        break label63;
      }
      ((CdnImageView)getView()).setUrl(this.image.getUrl());
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19058);
      return;
      label63:
      if (this.image.getBitmap() != null)
      {
        paramKImage = new BitmapDrawable(aj.getContext().getResources(), this.image.getBitmap());
        if (ColorUtil.getColorByMode(this.tintColor) != 0L) {
          paramKImage.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
        }
        ((CdnImageView)getView()).setImageDrawable(paramKImage);
      }
      else if (this.image.getDrawable() != null)
      {
        paramKImage = this.image.getDrawable();
        if (ColorUtil.getColorByMode(this.tintColor) != 0L) {
          paramKImage.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
        }
        ((CdnImageView)getView()).setImageDrawable(paramKImage);
      }
    }
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19060);
    if (paramArrayOfByte != null)
    {
      this.ImageData = paramArrayOfByte;
      paramArrayOfByte = BitmapFactory.decodeByteArray(this.ImageData, 0, this.ImageData.length);
      setHeight(paramArrayOfByte.getHeight());
      ((CdnImageView)getView()).setImageBitmap(paramArrayOfByte);
    }
    AppMethodBeat.o(19060);
  }
  
  public void setScaleType(ScaleType paramScaleType)
  {
    AppMethodBeat.i(19059);
    this.scaleType = paramScaleType;
    switch (1.$SwitchMap$com$tencent$kinda$gen$ScaleType[paramScaleType.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19059);
      return;
      ((CdnImageView)getView()).setScaleType(ImageView.ScaleType.FIT_XY);
      continue;
      ((CdnImageView)getView()).setScaleType(ImageView.ScaleType.FIT_CENTER);
      continue;
      ((CdnImageView)getView()).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      continue;
      ((CdnImageView)getView()).setScaleType(ImageView.ScaleType.CENTER);
    }
  }
  
  public void setTintColor(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(162114);
    if (ColorUtil.getColorByModeNoCompat(this.tintColor) != ColorUtil.getColorByMode(paramDynamicColor))
    {
      this.tintColor = paramDynamicColor;
      paramDynamicColor = ((CdnImageView)getView()).getDrawable();
      if (paramDynamicColor != null)
      {
        paramDynamicColor.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
        ((CdnImageView)getView()).setImageDrawable(paramDynamicColor);
      }
      notifyChanged();
    }
    AppMethodBeat.o(162114);
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(19054);
    if (paramString != null)
    {
      this.image.setSvgUrl(paramString, this.tintColor);
      if (!this.image.isNetworkImage()) {
        break label60;
      }
      ((CdnImageView)getView()).setUrl(this.image.getUrl());
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19054);
      return;
      label60:
      if (this.image.getBitmap() != null)
      {
        paramString = new BitmapDrawable(aj.getContext().getResources(), this.image.getBitmap());
        if (ColorUtil.getColorByMode(this.tintColor) != 0L) {
          paramString.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
        }
        ((CdnImageView)getView()).setImageDrawable(paramString);
      }
      else if (this.image.getDrawable() != null)
      {
        paramString = this.image.getDrawable();
        if (ColorUtil.getColorByMode(this.tintColor) != 0L) {
          paramString.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
        }
        ((CdnImageView)getView()).setImageDrawable(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImageView
 * JD-Core Version:    0.7.0.1
 */