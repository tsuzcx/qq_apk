package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView
  extends AppCompatImageView
{
  private String ldX;
  private float mDensity;
  private int nFb;
  private int nFc;
  private boolean nFd;
  
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
    AppMethodBeat.i(62358);
    this.nFb = 2130838614;
    this.nFc = 2130838223;
    this.nFd = true;
    this.mDensity = 0.0F;
    AppMethodBeat.o(62358);
  }
  
  private void a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(62366);
    try
    {
      if (!bo.isNullOrNil(null)) {
        setCacheKey(null);
      }
      for (paramResources = c.bHK().c(paramResources, paramInt); paramBoolean; paramResources = new d(paramResources, paramInt))
      {
        setImageDrawable(paramResources);
        AppMethodBeat.o(62366);
        return;
      }
      return;
    }
    catch (IOException paramResources)
    {
      ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
      if (paramBoolean)
      {
        super.setImageResource(paramInt);
        AppMethodBeat.o(62366);
        return;
        setBackgroundDrawable(paramResources);
        AppMethodBeat.o(62366);
        return;
      }
      super.setBackgroundResource(paramInt);
      AppMethodBeat.o(62366);
    }
  }
  
  public static void a(MMGIFException paramMMGIFException)
  {
    AppMethodBeat.i(62378);
    ii localii = new ii();
    localii.cxI.errorCode = paramMMGIFException.getErrorCode();
    com.tencent.mm.sdk.b.a.ymk.l(localii);
    AppMethodBeat.o(62378);
  }
  
  private void eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62368);
    try
    {
      if (r.aoZ(paramString1))
      {
        paramString2 = new h(com.tencent.mm.vfs.e.i(paramString1, 0, -1));
        paramString2.start();
        setImageDrawable(paramString2);
        AppMethodBeat.o(62368);
        return;
      }
      if (!bo.isNullOrNil(paramString2)) {
        setCacheKey(paramString2);
      }
      for (paramString2 = c.bHK().eK(getCacheKey(), paramString1);; paramString2 = new d(paramString1))
      {
        setImageDrawable(paramString2);
        AppMethodBeat.o(62368);
        return;
      }
      int i;
      label160:
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
            paramString2 = com.tencent.mm.sdk.platformtools.d.decodeFile(paramString1, null);
            if (paramString2 == null) {
              break label160;
            }
            paramString2.setDensity(getEmojiDensity());
            setImageBitmap(paramString2);
            AppMethodBeat.o(62368);
            return;
          }
          catch (OutOfMemoryError paramString2)
          {
            ab.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", paramString2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[] { paramString1 });
            init();
          }
        }
        else
        {
          AppMethodBeat.o(62368);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[] { bo.l(paramString1) });
        AppMethodBeat.o(62368);
        return;
      }
      ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[] { paramString1 });
      init();
      com.tencent.mm.vfs.e.deleteFile(paramString1);
      AppMethodBeat.o(62368);
      return;
    }
    catch (IOException paramString2)
    {
      ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[] { bo.l(paramString2) });
      com.tencent.mm.vfs.e.deleteFile(paramString1);
      init();
      AppMethodBeat.o(62368);
      return;
    }
    catch (NullPointerException paramString1)
    {
      init();
      AppMethodBeat.o(62368);
    }
  }
  
  public final void a(String paramString, k paramk)
  {
    AppMethodBeat.i(62367);
    try
    {
      localObject = new d(paramString);
      setImageDrawable((Drawable)localObject);
      ((d)localObject).nFw = 2147483647;
      ((d)localObject).nFy = paramk;
      AppMethodBeat.o(62367);
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
          localObject = com.tencent.mm.sdk.platformtools.d.decodeStream(com.tencent.mm.vfs.e.openRead(paramString));
          if (localObject == null) {
            break label140;
          }
          ((Bitmap)localObject).setDensity(getEmojiDensity());
          setImageBitmap((Bitmap)localObject);
          AppMethodBeat.o(62367);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramk.toString());
      }
      init();
      AppMethodBeat.o(62367);
      return;
      ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
      init();
      com.tencent.mm.vfs.e.deleteFile(paramString);
      AppMethodBeat.o(62367);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        label140:
        ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(62365);
    c localc;
    Context localContext;
    Object localObject;
    if (!bo.isNullOrNil(paramString2))
    {
      setCacheKey(paramString2);
      localc = c.bHK();
      localContext = getContext();
      if (TextUtils.isEmpty(paramString1))
      {
        localObject = null;
        if (localObject == null) {
          break label215;
        }
        ((e)localObject).nFN = paramBoolean2;
        if (paramBoolean1 == ((e)localObject).mIsPlaying)
        {
          ((e)localObject).start();
          label66:
          setImageDrawable((Drawable)localObject);
          AppMethodBeat.o(62365);
        }
      }
      else
      {
        if ((localc.nEY.get(paramString2) == null) || (((WeakReference)localc.nEY.get(paramString2)).get() == null)) {
          break label266;
        }
      }
    }
    label266:
    for (e locale = (e)((WeakReference)localc.nEY.get(paramString2)).get();; locale = null)
    {
      localObject = locale;
      if (locale != null) {
        break;
      }
      localObject = new e(localContext, paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      localc.nEY.put(paramString2, new WeakReference(localObject));
      break;
      ((e)localObject).lrL = 0;
      ((e)localObject).nFP = 0;
      ((e)localObject).mIsPlaying = true;
      ((e)localObject).start();
      break label66;
      label215:
      ab.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
      AppMethodBeat.o(62365);
      return;
      paramArrayOfInt = new e(getContext(), paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      paramArrayOfInt.start();
      setImageDrawable(paramArrayOfInt);
      AppMethodBeat.o(62365);
      return;
    }
  }
  
  public final void b(InputStream paramInputStream, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(62363);
    for (;;)
    {
      try
      {
        if (bo.isNullOrNil(paramString)) {
          continue;
        }
        setCacheKey(paramString);
        localc = c.bHK();
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
          break label254;
        }
        paramInputStream = com.tencent.mm.sdk.platformtools.d.decodeStream(paramInputStream);
        if (paramInputStream == null) {
          break label235;
        }
        paramInputStream.setDensity(getEmojiDensity());
        setImageBitmap(paramInputStream);
        AppMethodBeat.o(62363);
        return;
        paramString = new d(paramInputStream);
        continue;
      }
      catch (IOException paramInputStream)
      {
        ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
      setImageDrawable(paramString);
      AppMethodBeat.o(62363);
      return;
      ab.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[] { str });
      localObject1 = localObject2;
      if (localc.nEZ.get(str) != null) {
        localObject1 = (b)((WeakReference)localc.nEZ.get(str)).get();
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new d(paramInputStream);
        localc.nEZ.put(str, new WeakReference(paramString));
      }
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(62363);
      return;
      label235:
      ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
      init();
      AppMethodBeat.o(62363);
      return;
      label254:
      ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62362);
    eM(paramString1, paramString2);
    AppMethodBeat.o(62362);
  }
  
  public final void f(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(62369);
    if (paramArrayOfByte == null) {}
    try
    {
      ab.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[] { Boolean.TRUE, paramString });
      AppMethodBeat.o(62369);
      return;
    }
    catch (MMGIFException paramString)
    {
      for (;;)
      {
        a(paramString);
        if (paramString.getErrorCode() != 103) {
          break label214;
        }
        paramString = com.tencent.mm.sdk.platformtools.d.bT(paramArrayOfByte);
        if (paramString == null) {
          break;
        }
        paramString.setDensity(getEmojiDensity());
        setImageBitmap(paramString);
        AppMethodBeat.o(62369);
        return;
        paramString = new d(paramArrayOfByte);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (!bo.isNullOrNil(paramString))
    {
      setCacheKey(paramString);
      paramString = c.bHK().x(getCacheKey(), paramArrayOfByte);
    }
    for (;;)
    {
      setImageDrawable(paramString);
      AppMethodBeat.o(62369);
      return;
      if (!r.bX(paramArrayOfByte)) {
        break;
      }
      paramString = new h(paramArrayOfByte);
      paramString.start();
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(62369);
      return;
      ab.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
      init();
      AppMethodBeat.o(62369);
      return;
      label214:
      ab.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public String getCacheKey()
  {
    return this.ldX;
  }
  
  public int getEmojiDensity()
  {
    return 320;
  }
  
  public float getEmojiDensityScale()
  {
    AppMethodBeat.i(62364);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ah.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(62364);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    AppMethodBeat.i(62372);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(62372);
      return 0;
    }
    int i = getDrawable().getIntrinsicHeight();
    AppMethodBeat.o(62372);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    AppMethodBeat.i(62371);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(62371);
      return 0;
    }
    int i = getDrawable().getIntrinsicWidth();
    AppMethodBeat.o(62371);
    return i;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62370);
    this.nFd = com.tencent.mm.compatible.util.f.Mi();
    if (this.nFd)
    {
      if (this.nFb > 0)
      {
        super.setImageResource(this.nFb);
        AppMethodBeat.o(62370);
      }
    }
    else if (this.nFc > 0) {
      super.setImageResource(this.nFc);
    }
    AppMethodBeat.o(62370);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(62374);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).pause();
    }
    AppMethodBeat.o(62374);
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(62379);
    if ((getDrawable() != null) && ((getDrawable() instanceof d))) {
      ((d)getDrawable()).recycle();
    }
    AppMethodBeat.o(62379);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62377);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).reset();
    }
    AppMethodBeat.o(62377);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(62375);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).resume();
    }
    AppMethodBeat.o(62375);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(62360);
    a(getResources(), paramInt, false);
    AppMethodBeat.o(62360);
  }
  
  public void setCacheKey(String paramString)
  {
    this.ldX = paramString;
  }
  
  public void setDefaultBackgroundResource(int paramInt)
  {
    this.nFb = paramInt;
  }
  
  public void setDefaultImageResource(int paramInt)
  {
    this.nFb = paramInt;
  }
  
  public void setImageFilePath(String paramString)
  {
    AppMethodBeat.i(62361);
    eM(paramString, null);
    AppMethodBeat.o(62361);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(62359);
    a(getResources(), paramInt, true);
    AppMethodBeat.o(62359);
  }
  
  public final void start()
  {
    AppMethodBeat.i(62373);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).start();
    }
    AppMethodBeat.o(62373);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(62376);
    if ((getDrawable() != null) && ((getDrawable() instanceof b))) {
      ((b)getDrawable()).stop();
    }
    AppMethodBeat.o(62376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMAnimateView
 * JD-Core Version:    0.7.0.1
 */