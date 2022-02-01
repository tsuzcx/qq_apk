package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.md;
import com.tencent.mm.b.f;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class MMAnimateView
  extends AppCompatImageView
{
  private int JgD = a.f.emoji_download_icon;
  private int JgE = a.f.chat_img_default_bg;
  private boolean JgF = true;
  public boolean JgG = false;
  private float mDensity = 0.0F;
  private String xGz;
  
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
  }
  
  private void a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(104598);
    try
    {
      if (!Util.isNullOrNil(null)) {
        setCacheKey(null);
      }
      for (paramResources = c.fJa().d(paramResources, paramInt); paramBoolean; paramResources = new d(paramResources, paramInt, this.JgG))
      {
        setImageDrawable(paramResources);
        AppMethodBeat.o(104598);
        return;
      }
      return;
    }
    catch (IOException paramResources)
    {
      Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
      if (paramBoolean)
      {
        super.setImageResource(paramInt);
        AppMethodBeat.o(104598);
        return;
        setBackgroundDrawable(paramResources);
        AppMethodBeat.o(104598);
        return;
      }
      super.setBackgroundResource(paramInt);
      AppMethodBeat.o(104598);
    }
  }
  
  public static void a(MMGIFException paramMMGIFException)
  {
    AppMethodBeat.i(104610);
    md localmd = new md();
    localmd.hOh.errorCode = paramMMGIFException.getErrorCode();
    localmd.publish();
    AppMethodBeat.o(104610);
  }
  
  public final void a(String paramString, j paramj)
  {
    AppMethodBeat.i(104599);
    try
    {
      localObject = new d(paramString);
      setImageDrawable((Drawable)localObject);
      ((d)localObject).Jhb = 2147483647;
      ((d)localObject).Jhd = paramj;
      AppMethodBeat.o(104599);
      return;
    }
    catch (MMGIFException paramj)
    {
      try
      {
        Object localObject;
        a(paramj);
        if (paramj.getErrorCode() == 103)
        {
          localObject = BitmapUtil.decodeStream(y.Lh(paramString));
          if (localObject == null) {
            break label140;
          }
          ((Bitmap)localObject).setDensity(getEmojiDensity());
          setImageBitmap((Bitmap)localObject);
          AppMethodBeat.o(104599);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramj.toString());
      }
      init();
      AppMethodBeat.o(104599);
      return;
      Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
      init();
      y.deleteFile(paramString);
      AppMethodBeat.o(104599);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        label140:
        Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104597);
    c localc;
    Context localContext;
    Object localObject;
    if (!Util.isNullOrNil(paramString2))
    {
      setCacheKey(paramString2);
      localc = c.fJa();
      localContext = getContext();
      if (TextUtils.isEmpty(paramString1))
      {
        localObject = null;
        if (localObject == null) {
          break label215;
        }
        ((e)localObject).Jht = paramBoolean2;
        if (paramBoolean1 == ((e)localObject).qRV)
        {
          ((e)localObject).start();
          label66:
          setImageDrawable((Drawable)localObject);
          AppMethodBeat.o(104597);
        }
      }
      else
      {
        if ((localc.JgA.get(paramString2) == null) || (((WeakReference)localc.JgA.get(paramString2)).get() == null)) {
          break label265;
        }
      }
    }
    label265:
    for (e locale = (e)((WeakReference)localc.JgA.get(paramString2)).get();; locale = null)
    {
      localObject = locale;
      if (locale != null) {
        break;
      }
      localObject = new e(localContext, paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      localc.JgA.put(paramString2, new WeakReference(localObject));
      break;
      ((e)localObject).xYG = 0;
      ((e)localObject).crG = 0;
      ((e)localObject).qRV = true;
      ((e)localObject).start();
      break label66;
      label215:
      Log.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
      AppMethodBeat.o(104597);
      return;
      paramArrayOfInt = new e(getContext(), paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      paramArrayOfInt.start();
      setImageDrawable(paramArrayOfInt);
      AppMethodBeat.o(104597);
      return;
    }
  }
  
  public final void g(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(369703);
    h(paramArrayOfByte, paramString);
    AppMethodBeat.o(369703);
  }
  
  public String getCacheKey()
  {
    return this.xGz;
  }
  
  public int getEmojiDensity()
  {
    return 320;
  }
  
  public float getEmojiDensityScale()
  {
    AppMethodBeat.i(104596);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (a.getDensity(MMApplicationContext.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(104596);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(104604);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(104604);
      return 0;
    }
    int i = getDrawable().getIntrinsicHeight();
    AppMethodBeat.o(104604);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(104603);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(104603);
      return 0;
    }
    int i = getDrawable().getIntrinsicWidth();
    AppMethodBeat.o(104603);
    return i;
  }
  
  public final void h(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(104601);
    if (paramArrayOfByte == null) {}
    try
    {
      Log.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[] { Boolean.TRUE, paramString });
      AppMethodBeat.o(104601);
      return;
    }
    catch (MMGIFException paramString)
    {
      for (;;)
      {
        a(paramString);
        if (paramString.getErrorCode() != 103) {
          break label218;
        }
        paramString = BitmapUtil.decodeByteArray(paramArrayOfByte);
        if (paramString == null) {
          break;
        }
        paramString.setDensity(getEmojiDensity());
        setImageBitmap(paramString);
        AppMethodBeat.o(104601);
        return;
        paramString = new d(paramArrayOfByte, this.JgG);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (!Util.isNullOrNil(paramString))
    {
      setCacheKey(paramString);
      paramString = c.fJa().z(getCacheKey(), paramArrayOfByte);
    }
    for (;;)
    {
      setImageDrawable(paramString);
      AppMethodBeat.o(104601);
      return;
      if (!ImgUtil.isWXGF(paramArrayOfByte)) {
        break;
      }
      paramString = new h(paramArrayOfByte);
      paramString.start();
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(104601);
      return;
      Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
      init();
      AppMethodBeat.o(104601);
      return;
      label218:
      Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(104602);
    this.JgF = com.tencent.mm.compatible.util.e.aPU();
    if (this.JgF)
    {
      if (this.JgD > 0)
      {
        super.setImageResource(this.JgD);
        AppMethodBeat.o(104602);
      }
    }
    else if (this.JgE > 0) {
      super.setImageResource(this.JgE);
    }
    AppMethodBeat.o(104602);
  }
  
  public final void jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104594);
    jl(paramString1, paramString2);
    AppMethodBeat.o(104594);
  }
  
  public final void jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104600);
    try
    {
      if (ImgUtil.isWXGF(paramString1))
      {
        paramString2 = new h(y.bi(paramString1, 0, -1));
        paramString2.start();
        setImageDrawable(paramString2);
        AppMethodBeat.o(104600);
        return;
      }
      if (!Util.isNullOrNil(paramString2)) {
        setCacheKey(paramString2);
      }
      for (paramString2 = c.fJa().jj(getCacheKey(), paramString1);; paramString2 = new d(paramString1, this.JgG))
      {
        setImageDrawable(paramString2);
        AppMethodBeat.o(104600);
        return;
      }
      int i;
      label170:
      return;
    }
    catch (MMGIFException paramString2)
    {
      try
      {
        a(paramString2);
        i = paramString2.getErrorCode();
        if (i == 103)
        {
          try
          {
            paramString2 = BitmapUtil.decodeFile(paramString1, null);
            if (paramString2 == null) {
              break label170;
            }
            paramString2.setDensity(getEmojiDensity());
            setImageBitmap(paramString2);
            AppMethodBeat.o(104600);
            return;
          }
          catch (OutOfMemoryError paramString2)
          {
            Log.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", paramString2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[] { paramString1 });
            init();
          }
        }
        else
        {
          AppMethodBeat.o(104600);
          return;
        }
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[] { Util.stackTraceToString(paramString1) });
        AppMethodBeat.o(104600);
        return;
      }
      Log.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[] { paramString1 });
      init();
      y.deleteFile(paramString1);
      AppMethodBeat.o(104600);
      return;
    }
    catch (IOException paramString2)
    {
      Log.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[] { Util.stackTraceToString(paramString2) });
      y.deleteFile(paramString1);
      init();
      AppMethodBeat.o(104600);
      return;
    }
    catch (NullPointerException paramString1)
    {
      init();
      AppMethodBeat.o(104600);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(104607);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).pause();
    }
    AppMethodBeat.o(104607);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(104611);
    if ((getDrawable() != null) && ((getDrawable() instanceof d))) {
      ((d)getDrawable()).recycle();
    }
    AppMethodBeat.o(104611);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(104608);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).resume();
    }
    AppMethodBeat.o(104608);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(104592);
    a(getResources(), paramInt, false);
    AppMethodBeat.o(104592);
  }
  
  public void setBoundaryCheckInvalid(boolean paramBoolean)
  {
    this.JgG = paramBoolean;
  }
  
  public void setCacheKey(String paramString)
  {
    this.xGz = paramString;
  }
  
  public void setDefaultBackgroundResource(int paramInt)
  {
    this.JgD = paramInt;
  }
  
  public void setDefaultImageResource(int paramInt)
  {
    this.JgD = paramInt;
  }
  
  public void setImageFilePath(String paramString)
  {
    AppMethodBeat.i(104593);
    jl(paramString, null);
    AppMethodBeat.o(104593);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(104591);
    a(getResources(), paramInt, true);
    AppMethodBeat.o(104591);
  }
  
  public final void start()
  {
    AppMethodBeat.i(104606);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).start();
    }
    AppMethodBeat.o(104606);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(104609);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).stop();
    }
    AppMethodBeat.o(104609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMAnimateView
 * JD-Core Version:    0.7.0.1
 */