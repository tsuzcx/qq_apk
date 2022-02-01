package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KImage;
import com.tencent.kinda.gen.KSize;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.d;
import com.tencent.mm.network.y;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import javax.net.ssl.HttpsURLConnection;

public class MMKImage
  implements KImage
{
  private static final String PATTERN_FILE = "file://";
  private static final String PATTERN_HTTP = "http://";
  private static final String PATTERN_HTTPS = "https://";
  private ImageInfo darkImage;
  private ImageInfo lightImage;
  
  public MMKImage()
  {
    AppMethodBeat.i(226513);
    this.lightImage = new ImageInfo();
    this.darkImage = new ImageInfo();
    AppMethodBeat.o(226513);
  }
  
  private ImageInfo getImage()
  {
    AppMethodBeat.i(226516);
    if ((aw.isDarkMode()) && (!Util.isNullOrNil(this.darkImage.url)))
    {
      localImageInfo = this.darkImage;
      AppMethodBeat.o(226516);
      return localImageInfo;
    }
    ImageInfo localImageInfo = this.lightImage;
    AppMethodBeat.o(226516);
    return localImageInfo;
  }
  
  private void setIconColor(int paramInt)
  {
    AppMethodBeat.i(226520);
    getImage().setIconColor(paramInt);
    AppMethodBeat.o(226520);
  }
  
  public MMKImage copy()
  {
    AppMethodBeat.i(226559);
    MMKImage localMMKImage = new MMKImage();
    if (this.lightImage != null) {
      localMMKImage.lightImage = this.lightImage.copy();
    }
    if (this.darkImage != null) {
      localMMKImage.darkImage = this.darkImage.copy();
    }
    AppMethodBeat.o(226559);
    return localMMKImage;
  }
  
  public void drawableTint(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(160762);
    getImage().drawableTint(paramDynamicColor);
    AppMethodBeat.o(160762);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(19047);
    Bitmap localBitmap = getImage().getBitmap();
    AppMethodBeat.o(19047);
    return localBitmap;
  }
  
  public String getDarkUrl()
  {
    return this.darkImage.url;
  }
  
  public Drawable getDrawable()
  {
    AppMethodBeat.i(19048);
    Drawable localDrawable = getImage().getDrawable();
    AppMethodBeat.o(19048);
    return localDrawable;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(19045);
    float f = getImage().getHeight();
    AppMethodBeat.o(19045);
    return f;
  }
  
  public boolean getSupportDynamicSize()
  {
    return false;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(226536);
    String str = getImage().url;
    AppMethodBeat.o(226536);
    return str;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(19044);
    float f = getImage().getWidth();
    AppMethodBeat.o(19044);
    return f;
  }
  
  public boolean isNeedGetNetworkImageImmediately()
  {
    AppMethodBeat.i(226554);
    boolean bool = getImage().needGetNetworkImageImmediately;
    AppMethodBeat.o(226554);
    return bool;
  }
  
  public boolean isNetworkImage()
  {
    AppMethodBeat.i(226550);
    boolean bool = getImage().isNetworkImage;
    AppMethodBeat.o(226550);
    return bool;
  }
  
  public void setDarkModeUrl(String paramString)
  {
    AppMethodBeat.i(226534);
    this.darkImage.url = paramString;
    this.darkImage.parse();
    AppMethodBeat.o(226534);
  }
  
  public void setNeedGetNetworkImageImmediately(boolean paramBoolean)
  {
    this.lightImage.needGetNetworkImageImmediately = paramBoolean;
    this.darkImage.needGetNetworkImageImmediately = paramBoolean;
  }
  
  public void setSupportDynamicSize(boolean paramBoolean) {}
  
  public void setSvgUrl(String paramString, DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19050);
    getImage().setSvgUrl(paramString, paramDynamicColor);
    AppMethodBeat.o(19050);
  }
  
  public void setSvgUrl(String paramString, DynamicColor paramDynamicColor, KSize paramKSize)
  {
    AppMethodBeat.i(226543);
    getImage().setSvgUrl(paramString, paramDynamicColor);
    AppMethodBeat.o(226543);
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(19043);
    if (paramString.equals("PaidDetail_WeChatPay.png"))
    {
      AppMethodBeat.o(19043);
      return;
    }
    this.lightImage.url = paramString;
    this.lightImage.parse();
    AppMethodBeat.o(19043);
  }
  
  public void stretchImage(float paramFloat1, float paramFloat2) {}
  
  static class ImageInfo
  {
    Drawable drawable;
    float height = -1.0F;
    Bitmap imageBitmap;
    boolean isNetworkImage = false;
    boolean isSvgUrl;
    int localResId;
    private int mSvgColor;
    boolean needGetNetworkImageImmediately = false;
    String url;
    float width = -1.0F;
    
    private Bitmap getImageFromNet(String paramString)
    {
      AppMethodBeat.i(226638);
      if (!Util.isNullOrNil(paramString)) {
        if (paramString.startsWith("http://"))
        {
          paramString = d.a(paramString, null);
          paramString.xx(10000);
          paramString.xy(20000);
          paramString.Rx("GET");
          if (paramString.getResponseCode() != 200) {
            break label133;
          }
          paramString = paramString.getInputStream();
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString = MMBitmapFactory.decodeStream(paramString);
          AppMethodBeat.o(226638);
          return paramString;
          if (paramString.startsWith("https://"))
          {
            paramString = d.Ru(paramString);
            paramString.xx(10000);
            paramString.xy(20000);
            paramString.ppu.setRequestMethod("GET");
            paramString = paramString.ppu.getInputStream();
          }
        }
        else
        {
          AppMethodBeat.o(226638);
          return null;
        }
        label133:
        paramString = null;
      }
    }
    
    public ImageInfo copy()
    {
      AppMethodBeat.i(226640);
      ImageInfo localImageInfo = new ImageInfo();
      localImageInfo.url = this.url;
      localImageInfo.imageBitmap = this.imageBitmap;
      localImageInfo.drawable = this.drawable;
      localImageInfo.width = this.width;
      localImageInfo.height = this.height;
      localImageInfo.isSvgUrl = this.isSvgUrl;
      localImageInfo.mSvgColor = this.mSvgColor;
      localImageInfo.isNetworkImage = this.isNetworkImage;
      localImageInfo.needGetNetworkImageImmediately = this.needGetNetworkImageImmediately;
      AppMethodBeat.o(226640);
      return localImageInfo;
    }
    
    public void drawableTint(DynamicColor paramDynamicColor)
    {
      AppMethodBeat.i(226655);
      if ((this.drawable != null) && (paramDynamicColor != null))
      {
        this.drawable.setColorFilter((int)ColorUtil.getColorByMode(paramDynamicColor), PorterDuff.Mode.SRC_ATOP);
        this.mSvgColor = ((int)ColorUtil.getColorByMode(paramDynamicColor));
      }
      AppMethodBeat.o(226655);
    }
    
    public Bitmap getBitmap()
    {
      AppMethodBeat.i(226651);
      if ((!Util.isNullOrNil(this.url)) && (this.imageBitmap == null) && (!this.isNetworkImage)) {
        parse();
      }
      Bitmap localBitmap = this.imageBitmap;
      AppMethodBeat.o(226651);
      return localBitmap;
    }
    
    public Drawable getDrawable()
    {
      AppMethodBeat.i(226654);
      if ((!Util.isNullOrNil(this.url)) && ((this.imageBitmap == null) || (this.drawable == null)) && (!this.isNetworkImage)) {
        parse();
      }
      Object localObject;
      if (this.imageBitmap != null)
      {
        localObject = new BitmapDrawable(MMApplicationContext.getContext().getResources(), this.imageBitmap);
        AppMethodBeat.o(226654);
        return localObject;
      }
      if (this.drawable != null)
      {
        setIconColor(this.mSvgColor);
        localObject = this.drawable;
        AppMethodBeat.o(226654);
        return localObject;
      }
      AppMethodBeat.o(226654);
      return null;
    }
    
    public float getHeight()
    {
      AppMethodBeat.i(226646);
      if (this.imageBitmap != null)
      {
        float f = this.imageBitmap.getHeight();
        AppMethodBeat.o(226646);
        return f;
      }
      AppMethodBeat.o(226646);
      return 0.0F;
    }
    
    public float getWidth()
    {
      AppMethodBeat.i(226645);
      if (this.imageBitmap != null)
      {
        float f = this.imageBitmap.getWidth();
        AppMethodBeat.o(226645);
        return f;
      }
      AppMethodBeat.o(226645);
      return 0.0F;
    }
    
    void parse()
    {
      AppMethodBeat.i(226643);
      if (this.url == null)
      {
        AppMethodBeat.o(226643);
        return;
      }
      if (this.url.startsWith("file://")) {
        this.imageBitmap = BitmapUtil.getBitmapNative(this.url.replaceFirst("file://", ""));
      }
      for (;;)
      {
        if (this.imageBitmap != null)
        {
          this.width = this.imageBitmap.getWidth();
          this.height = this.imageBitmap.getHeight();
        }
        AppMethodBeat.o(226643);
        return;
        if ((this.url.startsWith("http://")) || (this.url.startsWith("https://")))
        {
          this.isNetworkImage = true;
          if (this.needGetNetworkImageImmediately) {
            try
            {
              this.imageBitmap = getImageFromNet(this.url);
            }
            catch (Exception localException)
            {
              this.imageBitmap = null;
            }
          }
        }
        else
        {
          this.localResId = ResourcesUtils.getDrawableId(MMApplicationContext.getContext(), this.url);
          if ((this.localResId == 0) || (this.isSvgUrl))
          {
            int i = ResourcesUtils.getResId(MMApplicationContext.getContext(), this.url, "raw");
            if (i != 0) {
              this.localResId = i;
            }
          }
          this.imageBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), this.localResId);
          if (this.imageBitmap == null) {
            try
            {
              this.drawable = MMApplicationContext.getContext().getResources().getDrawable(this.localResId);
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              this.drawable = null;
            }
          }
        }
      }
    }
    
    public void setIconColor(int paramInt)
    {
      AppMethodBeat.i(226656);
      if (this.drawable != null) {
        if (paramInt == 0) {
          break label72;
        }
      }
      label72:
      for (int i = 0xFFFFFF & paramInt | 0xFF000000;; i = paramInt)
      {
        int j = Color.alpha(paramInt);
        PorterDuffColorFilter localPorterDuffColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        this.drawable.mutate().setColorFilter(localPorterDuffColorFilter);
        if (paramInt != 0) {
          this.drawable.setAlpha(j);
        }
        AppMethodBeat.o(226656);
        return;
      }
    }
    
    public void setSvgUrl(String paramString, DynamicColor paramDynamicColor)
    {
      AppMethodBeat.i(226649);
      this.isSvgUrl = true;
      this.url = paramString;
      parse();
      if ((this.drawable != null) && (paramDynamicColor != null))
      {
        setIconColor((int)ColorUtil.getColorByMode(paramDynamicColor));
        this.mSvgColor = ((int)ColorUtil.getColorByMode(paramDynamicColor));
      }
      AppMethodBeat.o(226649);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImage
 * JD-Core Version:    0.7.0.1
 */