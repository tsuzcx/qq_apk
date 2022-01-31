package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.mm.h.a.ie;
import com.tencent.mm.plugin.l.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView
  extends AppCompatImageView
{
  private String iUT;
  private int lhF = a.d.emoji_download_icon;
  private int lhG = a.d.nosdcard_pic;
  private boolean lhH = true;
  private float mDensity = 0.0F;
  
  public MMAnimateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMAnimateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (com.tencent.mm.compatible.util.d.gF(26)) {
      setLayerType(1, null);
    }
  }
  
  private void a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    b localb = null;
    try
    {
      Object localObject;
      if (!bk.bl(null))
      {
        setCacheKey(null);
        c localc = c.baM();
        if (localc.lhD.get(null) != null) {
          localb = (b)((WeakReference)localc.lhD.get(null)).get();
        }
        localObject = localb;
        if (localb == null)
        {
          localObject = new d(paramResources, paramInt);
          localc.lhD.put(null, new WeakReference(localObject));
        }
      }
      while (paramBoolean)
      {
        setImageDrawable((Drawable)localObject);
        return;
        localObject = new d(paramResources, paramInt);
      }
      return;
    }
    catch (IOException paramResources)
    {
      y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
      if (paramBoolean)
      {
        super.setImageResource(paramInt);
        return;
        setBackgroundDrawable((Drawable)localObject);
        return;
      }
      super.setBackgroundResource(paramInt);
    }
  }
  
  public static void a(MMGIFException paramMMGIFException)
  {
    ie localie = new ie();
    localie.bQp.errorCode = paramMMGIFException.getErrorCode();
    com.tencent.mm.sdk.b.a.udP.m(localie);
  }
  
  private void dv(String paramString1, String paramString2)
  {
    try
    {
      if (o.Zb(paramString1))
      {
        paramString2 = new h(e.c(paramString1, 0, -1));
        paramString2.start();
        setImageDrawable(paramString2);
        return;
      }
      if (bk.bl(paramString2)) {
        break label143;
      }
      setCacheKey(paramString2);
      paramString2 = c.baM().dt(getCacheKey(), paramString1);
    }
    catch (MMGIFException paramString2)
    {
      for (;;)
      {
        try
        {
          a(paramString2);
          int i = paramString2.getErrorCode();
          if (i != 103) {
            return;
          }
          try
          {
            paramString2 = com.tencent.mm.sdk.platformtools.c.decodeFile(paramString1, null);
            if (paramString2 == null) {
              break;
            }
            paramString2.setDensity(getEmojiDensity());
            setImageBitmap(paramString2);
            return;
          }
          catch (OutOfMemoryError paramString2)
          {
            y.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", paramString2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[] { paramString1 });
            init();
            return;
          }
          paramString2 = new d(paramString1);
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[] { bk.j(paramString1) });
          return;
        }
      }
    }
    catch (IOException paramString2)
    {
      y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[] { bk.j(paramString2) });
      e.deleteFile(paramString1);
      init();
      return;
      y.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[] { paramString1 });
      init();
      e.deleteFile(paramString1);
      return;
    }
    catch (NullPointerException paramString1)
    {
      label143:
      init();
    }
    setImageDrawable(paramString2);
    return;
  }
  
  public final void a(String paramString, k paramk)
  {
    try
    {
      localObject = new d(paramString);
      setImageDrawable((Drawable)localObject);
      ((d)localObject).lia = 2147483647;
      ((d)localObject).lid = paramk;
      return;
    }
    catch (MMGIFException paramk)
    {
      try
      {
        Object localObject;
        a(paramk);
        if (paramk.getErrorCode() == 103)
        {
          localObject = com.tencent.mm.sdk.platformtools.c.decodeStream(e.openRead(paramString));
          if (localObject == null) {
            break label122;
          }
          ((Bitmap)localObject).setDensity(getEmojiDensity());
          setImageBitmap((Bitmap)localObject);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramk.toString());
      }
      init();
      return;
      y.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
      init();
      e.deleteFile(paramString);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        label122:
        y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final void b(InputStream paramInputStream, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (bk.bl(paramString)) {
          continue;
        }
        setCacheKey(paramString);
        localc = c.baM();
        str = getCacheKey();
        if (paramInputStream != null) {
          continue;
        }
        paramString = (String)localObject1;
      }
      catch (MMGIFException paramString)
      {
        c localc;
        String str;
        a(paramString);
        if (paramString.getErrorCode() != 103) {
          break label218;
        }
        paramInputStream = com.tencent.mm.sdk.platformtools.c.decodeStream(paramInputStream);
        if (paramInputStream == null) {
          break label205;
        }
        paramInputStream.setDensity(getEmojiDensity());
        setImageBitmap(paramInputStream);
        return;
        paramString = new d(paramInputStream);
        continue;
      }
      catch (IOException paramInputStream)
      {
        y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
      setImageDrawable(paramString);
      return;
      y.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[] { str });
      localObject1 = localObject2;
      if (localc.lhD.get(str) != null) {
        localObject1 = (b)((WeakReference)localc.lhD.get(str)).get();
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new d(paramInputStream);
        localc.lhD.put(str, new WeakReference(paramString));
      }
    }
    for (;;)
    {
      init();
      return;
      label205:
      y.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
      init();
      return;
      label218:
      y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void du(String paramString1, String paramString2)
  {
    dv(paramString1, paramString2);
  }
  
  public String getCacheKey()
  {
    return this.iUT;
  }
  
  public int getEmojiDensity()
  {
    return 320;
  }
  
  public float getEmojiDensityScale()
  {
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ae.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label40;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      return this.mDensity;
      label40:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    if (getDrawable() == null) {
      return 0;
    }
    return getDrawable().getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (getDrawable() == null) {
      return 0;
    }
    return getDrawable().getIntrinsicWidth();
  }
  
  public final void h(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {}
    try
    {
      y.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[] { Boolean.valueOf(true), paramString });
      return;
    }
    catch (MMGIFException paramString)
    {
      for (;;)
      {
        a(paramString);
        if (paramString.getErrorCode() != 103) {
          break label179;
        }
        paramString = com.tencent.mm.sdk.platformtools.c.bu(paramArrayOfByte);
        if (paramString == null) {
          break label155;
        }
        paramString.setDensity(getEmojiDensity());
        setImageBitmap(paramString);
        return;
        if (!o.bz(paramArrayOfByte)) {
          break;
        }
        paramString = new h(paramArrayOfByte);
        paramString.start();
      }
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (!bk.bl(paramString))
    {
      setCacheKey(paramString);
      paramString = c.baM().p(getCacheKey(), paramArrayOfByte);
      setImageDrawable(paramString);
      return;
    }
    for (;;)
    {
      init();
      return;
      paramString = new d(paramArrayOfByte);
      continue;
      label155:
      y.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
      init();
      return;
      label179:
      y.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void init()
  {
    this.lhH = com.tencent.mm.compatible.util.f.zF();
    if (this.lhH) {
      if (this.lhF > 0) {
        super.setImageResource(this.lhF);
      }
    }
    while (this.lhG <= 0) {
      return;
    }
    super.setImageResource(this.lhG);
  }
  
  public final void pause()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).pause();
    }
  }
  
  public final void recycle()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof d))) {
      ((d)getDrawable()).recycle();
    }
  }
  
  public final void reset()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).reset();
    }
  }
  
  public final void resume()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).resume();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    a(getResources(), paramInt, false);
  }
  
  public void setCacheKey(String paramString)
  {
    this.iUT = paramString;
  }
  
  public void setDefaultBackgroundResource(int paramInt)
  {
    this.lhF = paramInt;
  }
  
  public void setDefaultImageResource(int paramInt)
  {
    this.lhF = paramInt;
  }
  
  public void setImageFilePath(String paramString)
  {
    dv(paramString, null);
  }
  
  public void setImageResource(int paramInt)
  {
    a(getResources(), paramInt, true);
  }
  
  public final void start()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMAnimateView
 * JD-Core Version:    0.7.0.1
 */