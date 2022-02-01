package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView
  extends AppCompatImageView
{
  private float mDensity = 0.0F;
  private String pAS;
  private int uzN = 2131232025;
  private int uzO = 2131231559;
  private boolean uzP = true;
  public boolean uzQ = false;
  
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
      if (!bt.isNullOrNil(null)) {
        setCacheKey(null);
      }
      for (paramResources = c.daX().c(paramResources, paramInt); paramBoolean; paramResources = new d(paramResources, paramInt))
      {
        setImageDrawable(paramResources);
        AppMethodBeat.o(104598);
        return;
      }
      return;
    }
    catch (IOException paramResources)
    {
      ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
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
    js localjs = new js();
    localjs.dwG.errorCode = paramMMGIFException.getErrorCode();
    com.tencent.mm.sdk.b.a.IbL.l(localjs);
    AppMethodBeat.o(104610);
  }
  
  public final void a(String paramString, k paramk)
  {
    AppMethodBeat.i(104599);
    try
    {
      localObject = new d(paramString);
      setImageDrawable((Drawable)localObject);
      ((d)localObject).uAl = 2147483647;
      ((d)localObject).uAn = paramk;
      AppMethodBeat.o(104599);
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
          localObject = g.decodeStream(i.openRead(paramString));
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
        ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramk.toString());
      }
      init();
      AppMethodBeat.o(104599);
      return;
      ad.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
      init();
      i.deleteFile(paramString);
      AppMethodBeat.o(104599);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        label140:
        ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104597);
    c localc;
    Context localContext;
    Object localObject;
    if (!bt.isNullOrNil(paramString2))
    {
      setCacheKey(paramString2);
      localc = c.daX();
      localContext = getContext();
      if (TextUtils.isEmpty(paramString1))
      {
        localObject = null;
        if (localObject == null) {
          break label215;
        }
        ((e)localObject).uAD = paramBoolean2;
        if (paramBoolean1 == ((e)localObject).mIsPlaying)
        {
          ((e)localObject).start();
          label66:
          setImageDrawable((Drawable)localObject);
          AppMethodBeat.o(104597);
        }
      }
      else
      {
        if ((localc.uzK.get(paramString2) == null) || (((WeakReference)localc.uzK.get(paramString2)).get() == null)) {
          break label266;
        }
      }
    }
    label266:
    for (e locale = (e)((WeakReference)localc.uzK.get(paramString2)).get();; locale = null)
    {
      localObject = locale;
      if (locale != null) {
        break;
      }
      localObject = new e(localContext, paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      localc.uzK.put(paramString2, new WeakReference(localObject));
      break;
      ((e)localObject).pPf = 0;
      ((e)localObject).uAF = 0;
      ((e)localObject).mIsPlaying = true;
      ((e)localObject).start();
      break label66;
      label215:
      ad.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
      AppMethodBeat.o(104597);
      return;
      paramArrayOfInt = new e(getContext(), paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      paramArrayOfInt.start();
      setImageDrawable(paramArrayOfInt);
      AppMethodBeat.o(104597);
      return;
    }
  }
  
  public final void c(InputStream paramInputStream, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(104595);
    for (;;)
    {
      try
      {
        if (bt.isNullOrNil(paramString)) {
          continue;
        }
        setCacheKey(paramString);
        localc = c.daX();
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
        paramInputStream = g.decodeStream(paramInputStream);
        if (paramInputStream == null) {
          break label235;
        }
        paramInputStream.setDensity(getEmojiDensity());
        setImageBitmap(paramInputStream);
        AppMethodBeat.o(104595);
        return;
        paramString = new d(paramInputStream);
        continue;
      }
      catch (IOException paramInputStream)
      {
        ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
      setImageDrawable(paramString);
      AppMethodBeat.o(104595);
      return;
      ad.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[] { str });
      localObject1 = localObject2;
      if (localc.uzL.get(str) != null) {
        localObject1 = (b)((WeakReference)localc.uzL.get(str)).get();
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new d(paramInputStream);
        localc.uzL.put(str, new WeakReference(paramString));
      }
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(104595);
      return;
      label235:
      ad.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
      init();
      AppMethodBeat.o(104595);
      return;
      label254:
      ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void g(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(104601);
    if (paramArrayOfByte == null) {}
    try
    {
      ad.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[] { Boolean.TRUE, paramString });
      AppMethodBeat.o(104601);
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
        paramString = g.cr(paramArrayOfByte);
        if (paramString == null) {
          break;
        }
        paramString.setDensity(getEmojiDensity());
        setImageBitmap(paramString);
        AppMethodBeat.o(104601);
        return;
        paramString = new d(paramArrayOfByte);
      }
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (!bt.isNullOrNil(paramString))
    {
      setCacheKey(paramString);
      paramString = c.daX().s(getCacheKey(), paramArrayOfByte);
    }
    for (;;)
    {
      setImageDrawable(paramString);
      AppMethodBeat.o(104601);
      return;
      if (!t.cv(paramArrayOfByte)) {
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
      ad.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
      init();
      AppMethodBeat.o(104601);
      return;
      label214:
      ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public String getCacheKey()
  {
    return this.pAS;
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
      this.mDensity = (com.tencent.mm.cc.a.getDensity(aj.getContext()) / 2.0F);
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
  
  public final void hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104594);
    hh(paramString1, paramString2);
    AppMethodBeat.o(104594);
  }
  
  public final void hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104600);
    try
    {
      if (t.aQk(paramString1))
      {
        paramString2 = new h(i.aY(paramString1, 0, -1));
        paramString2.start();
        setImageDrawable(paramString2);
        AppMethodBeat.o(104600);
        return;
      }
      if (!bt.isNullOrNil(paramString2)) {
        setCacheKey(paramString2);
      }
      for (paramString2 = c.daX().hf(getCacheKey(), paramString1);; paramString2 = new d(paramString1, this.uzQ))
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
            paramString2 = g.decodeFile(paramString1, null);
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
            ad.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", paramString2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[] { paramString1 });
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
        ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[] { bt.n(paramString1) });
        AppMethodBeat.o(104600);
        return;
      }
      ad.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[] { paramString1 });
      init();
      i.deleteFile(paramString1);
      AppMethodBeat.o(104600);
      return;
    }
    catch (IOException paramString2)
    {
      ad.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[] { bt.n(paramString2) });
      i.deleteFile(paramString1);
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
  
  public final void init()
  {
    AppMethodBeat.i(104602);
    this.uzP = com.tencent.mm.compatible.util.e.abf();
    if (this.uzP)
    {
      if (this.uzN > 0)
      {
        super.setImageResource(this.uzN);
        AppMethodBeat.o(104602);
      }
    }
    else if (this.uzO > 0) {
      super.setImageResource(this.uzO);
    }
    AppMethodBeat.o(104602);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(104605);
    if ((getDrawable() != null) && ((getDrawable() instanceof b)))
    {
      boolean bool = ((b)getDrawable()).isRunning();
      AppMethodBeat.o(104605);
      return bool;
    }
    AppMethodBeat.o(104605);
    return false;
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
  
  public void setCacheKey(String paramString)
  {
    this.pAS = paramString;
  }
  
  public void setDefaultBackgroundResource(int paramInt)
  {
    this.uzN = paramInt;
  }
  
  public void setDefaultImageResource(int paramInt)
  {
    this.uzN = paramInt;
  }
  
  public void setImageFilePath(String paramString)
  {
    AppMethodBeat.i(104593);
    hh(paramString, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.MMAnimateView
 * JD-Core Version:    0.7.0.1
 */