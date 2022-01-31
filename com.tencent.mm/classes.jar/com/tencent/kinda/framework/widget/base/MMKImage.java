package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.network.b;
import com.tencent.mm.network.v;
import com.tencent.mm.network.w;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
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
  private boolean needGetNetworkImageImmediately = false;
  private String url;
  private float width = -1.0F;
  
  private void createBitmapOrDrawableFromUrl(String paramString)
  {
    AppMethodBeat.i(144893);
    if (paramString != null)
    {
      if (!paramString.startsWith("file://")) {
        break label70;
      }
      this.imageBitmap = d.aoV(paramString.replaceFirst("file://", ""));
    }
    for (;;)
    {
      if (this.imageBitmap != null)
      {
        this.width = this.imageBitmap.getWidth();
        this.height = this.imageBitmap.getHeight();
      }
      AppMethodBeat.o(144893);
      return;
      label70:
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
        int j = ResourcesUtils.getDrawableId(ah.getContext(), paramString);
        int i = j;
        if (j == 0) {
          i = ResourcesUtils.getResId(ah.getContext(), paramString, "raw");
        }
        this.imageBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), i);
        if (this.imageBitmap == null) {
          try
          {
            this.drawable = ah.getContext().getResources().getDrawable(i);
          }
          catch (Resources.NotFoundException paramString) {}
        }
      }
    }
  }
  
  private Bitmap getImageFromNet(String paramString)
  {
    AppMethodBeat.i(144896);
    if (!bo.isNullOrNil(paramString)) {
      if (paramString.startsWith("http://"))
      {
        paramString = b.a(paramString, null);
        paramString.setConnectTimeout(10000);
        paramString.setReadTimeout(20000);
        paramString.setRequestMethod("GET");
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
        AppMethodBeat.o(144896);
        return paramString;
        if (paramString.startsWith("https://"))
        {
          paramString = b.wb(paramString);
          paramString.setConnectTimeout(10000);
          paramString.setReadTimeout(20000);
          paramString.gel.setRequestMethod("GET");
          paramString = paramString.gel.getInputStream();
        }
      }
      else
      {
        AppMethodBeat.o(144896);
        return null;
      }
      label133:
      paramString = null;
    }
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(144894);
    if ((!bo.isNullOrNil(this.url)) && (this.imageBitmap == null) && (!this.isNetworkImage)) {
      createBitmapOrDrawableFromUrl(this.url);
    }
    Bitmap localBitmap = this.imageBitmap;
    AppMethodBeat.o(144894);
    return localBitmap;
  }
  
  public Drawable getDrawable()
  {
    AppMethodBeat.i(144895);
    if ((!bo.isNullOrNil(this.url)) && ((this.imageBitmap == null) || (this.drawable == null)) && (!this.isNetworkImage)) {
      createBitmapOrDrawableFromUrl(this.url);
    }
    Object localObject;
    if (this.imageBitmap != null)
    {
      localObject = new BitmapDrawable(ah.getContext().getResources(), this.imageBitmap);
      AppMethodBeat.o(144895);
      return localObject;
    }
    if (this.drawable != null)
    {
      localObject = this.drawable;
      AppMethodBeat.o(144895);
      return localObject;
    }
    AppMethodBeat.o(144895);
    return null;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(144892);
    if (this.imageBitmap != null)
    {
      float f = this.imageBitmap.getHeight();
      AppMethodBeat.o(144892);
      return f;
    }
    AppMethodBeat.o(144892);
    return 0.0F;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(144891);
    if (this.imageBitmap != null)
    {
      float f = this.imageBitmap.getWidth();
      AppMethodBeat.o(144891);
      return f;
    }
    AppMethodBeat.o(144891);
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
  
  public void setNeedGetNetworkImageImmediately(boolean paramBoolean)
  {
    this.needGetNetworkImageImmediately = paramBoolean;
  }
  
  public void setSvgUrl(String paramString1, String paramString2) {}
  
  public void setUrl(String paramString)
  {
    AppMethodBeat.i(144890);
    if (paramString.equals("PaidDetail_WeChatPay.png"))
    {
      AppMethodBeat.o(144890);
      return;
    }
    this.url = paramString;
    createBitmapOrDrawableFromUrl(paramString);
    AppMethodBeat.o(144890);
  }
  
  public void stretchImage(float paramFloat1, float paramFloat2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKImage
 * JD-Core Version:    0.7.0.1
 */