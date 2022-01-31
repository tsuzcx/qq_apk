package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.ImageView.ScaleType;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KImageView;
import com.tencent.kinda.gen.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bo;

public class MMKImageView
  extends MMKView<CdnImageView>
  implements KImageView
{
  private MMKImage defaultImage;
  private MMKImage image;
  private ScaleType scaleType;
  
  public MMKImageView()
  {
    AppMethodBeat.i(144898);
    this.image = new MMKImage();
    this.defaultImage = new MMKImage();
    AppMethodBeat.o(144898);
  }
  
  public CdnImageView createView(Context paramContext)
  {
    AppMethodBeat.i(144899);
    paramContext = new CdnImageView(paramContext);
    paramContext.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.image.setNeedGetNetworkImageImmediately(false);
    this.defaultImage.setNeedGetNetworkImageImmediately(false);
    AppMethodBeat.o(144899);
    return paramContext;
  }
  
  public String getDefaultUrl()
  {
    AppMethodBeat.i(144903);
    String str = this.defaultImage.getUrl();
    AppMethodBeat.o(144903);
    return str;
  }
  
  public KImage getImage()
  {
    return this.image;
  }
  
  public ScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public long getTintColor()
  {
    return 0L;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(144901);
    String str = this.image.getUrl();
    AppMethodBeat.o(144901);
    return str;
  }
  
  public void setDefaultUrl(String paramString)
  {
    AppMethodBeat.i(144902);
    if (this.defaultImage == null) {
      this.defaultImage = new MMKImage();
    }
    this.defaultImage.setUrl(paramString);
    if (((this.image == null) || (bo.isNullOrNil(this.image.getUrl()))) && (!bo.isNullOrNil(this.defaultImage.getUrl())))
    {
      if (!this.defaultImage.isNetworkImage()) {
        break label102;
      }
      ((CdnImageView)getView()).setUrl(this.defaultImage.getUrl());
    }
    for (;;)
    {
      setCornerRadius(2.0F);
      AppMethodBeat.o(144902);
      return;
      label102:
      ((CdnImageView)getView()).setImageBitmap(this.defaultImage.getBitmap());
    }
  }
  
  public void setImage(KImage paramKImage)
  {
    AppMethodBeat.i(144904);
    if ((paramKImage != null) && ((paramKImage instanceof MMKImage)))
    {
      this.image = ((MMKImage)paramKImage);
      if (!this.image.isNetworkImage()) {
        break label61;
      }
      ((CdnImageView)getView()).setUrl(this.image.getUrl());
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144904);
      return;
      label61:
      if (this.image.getBitmap() != null) {
        ((CdnImageView)getView()).setImageBitmap(this.image.getBitmap());
      } else if (this.image.getDrawable() != null) {
        ((CdnImageView)getView()).setImageDrawable(this.image.getDrawable());
      }
    }
  }
  
  public void setScaleType(ScaleType paramScaleType)
  {
    AppMethodBeat.i(144905);
    this.scaleType = paramScaleType;
    switch (MMKImageView.1.$SwitchMap$com$tencent$kinda$gen$ScaleType[paramScaleType.ordinal()])
    {
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144905);
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
  
  public void setTintColor(long paramLong) {}
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(144900);
    if (paramString != null)
    {
      this.image.setUrl(paramString);
      if (!this.image.isNetworkImage()) {
        break label54;
      }
      ((CdnImageView)getView()).setUrl(this.image.getUrl());
    }
    for (;;)
    {
      notifyChanged();
      AppMethodBeat.o(144900);
      return;
      label54:
      if (this.image.getBitmap() != null) {
        ((CdnImageView)getView()).setImageBitmap(this.image.getBitmap());
      } else if (this.image.getDrawable() != null) {
        ((CdnImageView)getView()).setImageDrawable(this.image.getDrawable());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImageView
 * JD-Core Version:    0.7.0.1
 */