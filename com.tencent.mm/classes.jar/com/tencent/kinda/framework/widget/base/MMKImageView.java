package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;

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
  
  private void setIconColor(int paramInt, Drawable paramDrawable)
  {
    AppMethodBeat.i(226476);
    if (paramDrawable != null) {
      if (paramInt == 0) {
        break label65;
      }
    }
    label65:
    for (int i = 0xFFFFFF & paramInt | 0xFF000000;; i = paramInt)
    {
      int j = Color.alpha(paramInt);
      PorterDuffColorFilter localPorterDuffColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      paramDrawable.mutate().setColorFilter(localPorterDuffColorFilter);
      if (paramInt != 0) {
        paramDrawable.setAlpha(j);
      }
      AppMethodBeat.o(226476);
      return;
    }
  }
  
  public CdnImageView createView(Context paramContext)
  {
    AppMethodBeat.i(19053);
    paramContext = new CdnImageView(paramContext);
    paramContext.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext.setAdjustViewBounds(true);
    paramContext.setUseSdcardCache(true);
    paramContext.setImgSavedDir(d.jOc());
    this.image.setNeedGetNetworkImageImmediately(false);
    this.defaultImage.setNeedGetNetworkImageImmediately(false);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(19053);
    return paramContext;
  }
  
  public String getDarkModeUrl()
  {
    AppMethodBeat.i(226495);
    String str = this.image.getDarkUrl();
    AppMethodBeat.o(226495);
    return str;
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
  
  public void setCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(226508);
    super.setCornerRadius(paramFloat);
    if (((getView() instanceof CdnImageView)) && (getWidth() > 0.0F))
    {
      ((CdnImageView)getView()).setRoundCorner(true);
      ((CdnImageView)getView()).setRoundCornerRate(paramFloat / getWidth());
    }
    AppMethodBeat.o(226508);
  }
  
  public void setDarkModeUrl(String paramString)
  {
    AppMethodBeat.i(226491);
    MMKImage localMMKImage = this.image.copy();
    localMMKImage.setDarkModeUrl(paramString);
    setImage(localMMKImage);
    AppMethodBeat.o(226491);
  }
  
  public void setDefaultUrl(String paramString)
  {
    AppMethodBeat.i(19056);
    if (this.defaultImage == null) {
      this.defaultImage = new MMKImage();
    }
    this.defaultImage.setUrl(paramString);
    if (((this.image == null) || (Util.isNullOrNil(this.image.getUrl()))) && (!Util.isNullOrNil(this.defaultImage.getUrl())))
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
      MMKImage localMMKImage = this.image;
      this.image = ((MMKImage)paramKImage);
      if (!this.image.isNetworkImage()) {
        break label126;
      }
      int j = 1;
      int i = j;
      if (localMMKImage != null)
      {
        i = j;
        if (localMMKImage.getUrl() != null)
        {
          i = j;
          if (this.image.getUrl() != null)
          {
            i = j;
            if (localMMKImage.getUrl().equals(this.image.getUrl())) {
              i = 0;
            }
          }
        }
      }
      if (i != 0) {
        ((CdnImageView)getView()).setUrl(this.image.getUrl());
      }
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(19058);
      return;
      label126:
      if (this.image.getBitmap() != null)
      {
        paramKImage = new BitmapDrawable(MMApplicationContext.getContext().getResources(), this.image.getBitmap());
        if (ColorUtil.getColorByMode(this.tintColor) != 0L)
        {
          paramKImage.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
          setIconColor((int)ColorUtil.getColorByMode(this.tintColor), paramKImage);
        }
        ((CdnImageView)getView()).setImageDrawable(paramKImage);
      }
      else if (this.image.getDrawable() != null)
      {
        paramKImage = this.image.getDrawable();
        if (ColorUtil.getColorByMode(this.tintColor) != 0L)
        {
          paramKImage.setColorFilter((int)ColorUtil.getColorByMode(this.tintColor), PorterDuff.Mode.SRC_ATOP);
          setIconColor((int)ColorUtil.getColorByMode(this.tintColor), paramKImage);
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
        setIconColor((int)ColorUtil.getColorByMode(this.tintColor), paramDynamicColor);
        ((CdnImageView)getView()).setImageDrawable(paramDynamicColor);
      }
      notifyChanged();
    }
    AppMethodBeat.o(162114);
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(19054);
    MMKImage localMMKImage = this.image.copy();
    localMMKImage.setSvgUrl(paramString, this.tintColor);
    setImage(localMMKImage);
    AppMethodBeat.o(19054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImageView
 * JD-Core Version:    0.7.0.1
 */