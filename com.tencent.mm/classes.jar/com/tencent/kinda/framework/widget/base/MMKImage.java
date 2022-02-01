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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.network.b;
import com.tencent.mm.network.v;
import com.tencent.mm.network.y;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import javax.net.ssl.HttpsURLConnection;

public class MMKImage
  implements KImage
{
  private static final String PATTERN_FILE = "file://";
  private static final String PATTERN_HTTP = "http://";
  private static final String PATTERN_HTTPS = "https://";
  private Drawable drawable;
  private float height = -1.0F;
  private Bitmap imageBitmap;
  private boolean isNetworkImage = false;
  private boolean isSvgUrl;
  public int localResId;
  private int mSvgColor;
  private boolean needGetNetworkImageImmediately = false;
  private String url;
  private float width = -1.0F;
  
  private void createBitmapOrDrawableFromUrl(String paramString)
  {
    AppMethodBeat.i(19046);
    if (paramString != null)
    {
      if (!paramString.startsWith("file://")) {
        break label72;
      }
      this.imageBitmap = g.aQf(paramString.replaceFirst("file://", ""));
    }
    for (;;)
    {
      if (this.imageBitmap != null)
      {
        this.width = this.imageBitmap.getWidth();
        this.height = this.imageBitmap.getHeight();
      }
      AppMethodBeat.o(19046);
      return;
      label72:
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.isNetworkImage = true;
        if (this.needGetNetworkImageImmediately) {
          try
          {
            this.imageBitmap = getImageFromNet(paramString);
          }
          catch (Exception paramString)
          {
            this.imageBitmap = null;
          }
        }
      }
      else
      {
        this.localResId = ResourcesUtils.getDrawableId(aj.getContext(), paramString);
        if ((this.localResId == 0) || (this.isSvgUrl))
        {
          int i = ResourcesUtils.getResId(aj.getContext(), paramString, "raw");
          if (i != 0) {
            this.localResId = i;
          }
        }
        this.imageBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), this.localResId);
        if (this.imageBitmap == null) {
          try
          {
            this.drawable = aj.getContext().getResources().getDrawable(this.localResId);
          }
          catch (Resources.NotFoundException paramString) {}
        }
      }
    }
  }
  
  private Bitmap getImageFromNet(String paramString)
  {
    AppMethodBeat.i(19049);
    if (!bt.isNullOrNil(paramString)) {
      if (paramString.startsWith("http://"))
      {
        paramString = b.a(paramString, null);
        paramString.setConnectTimeout(10000);
        paramString.setReadTimeout(20000);
        paramString.setRequestMethod("GET");
        if (paramString.getResponseCode() != 200) {
          break label136;
        }
        paramString = paramString.getInputStream();
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = MMBitmapFactory.decodeStream(paramString);
        AppMethodBeat.o(19049);
        return paramString;
        if (paramString.startsWith("https://"))
        {
          paramString = b.Is(paramString);
          paramString.setConnectTimeout(10000);
          paramString.setReadTimeout(20000);
          paramString.iFV.setRequestMethod("GET");
          paramString = paramString.iFV.getInputStream();
        }
      }
      else
      {
        AppMethodBeat.o(19049);
        return null;
      }
      label136:
      paramString = null;
    }
  }
  
  private void setIconColor(int paramInt)
  {
    AppMethodBeat.i(199509);
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
      AppMethodBeat.o(199509);
      return;
    }
  }
  
  public void drawableTint(DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(160762);
    if ((this.drawable != null) && (paramDynamicColor != null))
    {
      this.drawable.setColorFilter((int)ColorUtil.getColorByMode(paramDynamicColor), PorterDuff.Mode.SRC_ATOP);
      this.mSvgColor = ((int)ColorUtil.getColorByMode(paramDynamicColor));
    }
    AppMethodBeat.o(160762);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(19047);
    if ((!bt.isNullOrNil(this.url)) && (this.imageBitmap == null) && (!this.isNetworkImage)) {
      createBitmapOrDrawableFromUrl(this.url);
    }
    Bitmap localBitmap = this.imageBitmap;
    AppMethodBeat.o(19047);
    return localBitmap;
  }
  
  public Drawable getDrawable()
  {
    AppMethodBeat.i(19048);
    if ((!bt.isNullOrNil(this.url)) && ((this.imageBitmap == null) || (this.drawable == null)) && (!this.isNetworkImage)) {
      createBitmapOrDrawableFromUrl(this.url);
    }
    Object localObject;
    if (this.imageBitmap != null)
    {
      localObject = new BitmapDrawable(aj.getContext().getResources(), this.imageBitmap);
      AppMethodBeat.o(19048);
      return localObject;
    }
    if (this.drawable != null)
    {
      setIconColor(this.mSvgColor);
      localObject = this.drawable;
      AppMethodBeat.o(19048);
      return localObject;
    }
    AppMethodBeat.o(19048);
    return null;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(19045);
    if (this.imageBitmap != null)
    {
      float f = this.imageBitmap.getHeight();
      AppMethodBeat.o(19045);
      return f;
    }
    AppMethodBeat.o(19045);
    return 0.0F;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(19044);
    if (this.imageBitmap != null)
    {
      float f = this.imageBitmap.getWidth();
      AppMethodBeat.o(19044);
      return f;
    }
    AppMethodBeat.o(19044);
    return 0.0F;
  }
  
  public boolean isNeedGetNetworkImageImmediately()
  {
    return this.needGetNetworkImageImmediately;
  }
  
  public boolean isNetworkImage()
  {
    return this.isNetworkImage;
  }
  
  public void setDarkModeUrl(String paramString) {}
  
  public void setNeedGetNetworkImageImmediately(boolean paramBoolean)
  {
    this.needGetNetworkImageImmediately = paramBoolean;
  }
  
  public void setSvgUrl(String paramString, DynamicColor paramDynamicColor)
  {
    AppMethodBeat.i(19050);
    this.isSvgUrl = true;
    setUrl(paramString);
    if ((this.drawable != null) && (paramDynamicColor != null))
    {
      setIconColor((int)ColorUtil.getColorByMode(paramDynamicColor));
      this.mSvgColor = ((int)ColorUtil.getColorByMode(paramDynamicColor));
    }
    AppMethodBeat.o(19050);
  }
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(19043);
    if (paramString.equals("PaidDetail_WeChatPay.png"))
    {
      AppMethodBeat.o(19043);
      return;
    }
    this.url = paramString;
    createBitmapOrDrawableFromUrl(paramString);
    AppMethodBeat.o(19043);
  }
  
  public void stretchImage(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImage
 * JD-Core Version:    0.7.0.1
 */