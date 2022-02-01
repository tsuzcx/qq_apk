package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMAnimateView
  extends AppCompatImageView
{
  private float mDensity = 0.0F;
  private String oXi;
  private int txd = 2131232025;
  private int txe = 2131231559;
  private boolean txf = true;
  public boolean txg = false;
  
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
      if (!bs.isNullOrNil(null)) {
        setCacheKey(null);
      }
      for (paramResources = c.cRR().c(paramResources, paramInt); paramBoolean; paramResources = new d(paramResources, paramInt))
      {
        setImageDrawable(paramResources);
        AppMethodBeat.o(104598);
        return;
      }
      return;
    }
    catch (IOException paramResources)
    {
      ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + paramResources.toString());
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
    jk localjk = new jk();
    localjk.dkT.errorCode = paramMMGIFException.getErrorCode();
    com.tencent.mm.sdk.b.a.GpY.l(localjk);
    AppMethodBeat.o(104610);
  }
  
  public final void a(String paramString, k paramk)
  {
    AppMethodBeat.i(104599);
    try
    {
      localObject = new d(paramString);
      setImageDrawable((Drawable)localObject);
      ((d)localObject).txB = 2147483647;
      ((d)localObject).txD = paramk;
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
          localObject = com.tencent.mm.sdk.platformtools.f.decodeStream(i.openRead(paramString));
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
        ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
        ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramk.toString());
      }
      init();
      AppMethodBeat.o(104599);
      return;
      ac.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", new Object[] { paramString });
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
        ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + paramString.toString());
      }
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, int[] paramArrayOfInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104597);
    c localc;
    Context localContext;
    Object localObject;
    if (!bs.isNullOrNil(paramString2))
    {
      setCacheKey(paramString2);
      localc = c.cRR();
      localContext = getContext();
      if (TextUtils.isEmpty(paramString1))
      {
        localObject = null;
        if (localObject == null) {
          break label215;
        }
        ((e)localObject).txT = paramBoolean2;
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
        if ((localc.txa.get(paramString2) == null) || (((WeakReference)localc.txa.get(paramString2)).get() == null)) {
          break label266;
        }
      }
    }
    label266:
    for (e locale = (e)((WeakReference)localc.txa.get(paramString2)).get();; locale = null)
    {
      localObject = locale;
      if (locale != null) {
        break;
      }
      localObject = new e(localContext, paramBoolean1, paramBoolean2, paramInt, paramArrayOfInt, paramString1);
      localc.txa.put(paramString2, new WeakReference(localObject));
      break;
      ((e)localObject).plF = 0;
      ((e)localObject).txV = 0;
      ((e)localObject).mIsPlaying = true;
      ((e)localObject).start();
      break label66;
      label215:
      ac.e("MicroMsg.GIF.MMGIFImageView", "can not get drawable.");
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
        if (bs.isNullOrNil(paramString)) {
          continue;
        }
        setCacheKey(paramString);
        localc = c.cRR();
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
        paramInputStream = com.tencent.mm.sdk.platformtools.f.decodeStream(paramInputStream);
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
        ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramInputStream.toString() });
      }
      setImageDrawable(paramString);
      AppMethodBeat.o(104595);
      return;
      ac.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "stream key:%s", new Object[] { str });
      localObject1 = localObject2;
      if (localc.txb.get(str) != null) {
        localObject1 = (b)((WeakReference)localc.txb.get(str)).get();
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = new d(paramInputStream);
        localc.txb.put(str, new WeakReference(paramString));
      }
    }
    for (;;)
    {
      init();
      AppMethodBeat.o(104595);
      return;
      label235:
      ac.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
      init();
      AppMethodBeat.o(104595);
      return;
      label254:
      ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void g(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(104601);
    if (paramArrayOfByte == null) {}
    try
    {
      ac.e("MicroMsg.GIF.MMGIFImageView", "[setMMGIFFileByteArray] bytes is null! src:%s cacheKey:%s", new Object[] { Boolean.TRUE, paramString });
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
        paramString = com.tencent.mm.sdk.platformtools.f.ck(paramArrayOfByte);
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
      ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (!bs.isNullOrNil(paramString))
    {
      setCacheKey(paramString);
      paramString = c.cRR().r(getCacheKey(), paramArrayOfByte);
    }
    for (;;)
    {
      setImageDrawable(paramString);
      AppMethodBeat.o(104601);
      return;
      if (!s.co(paramArrayOfByte)) {
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
      ac.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", new Object[] { paramArrayOfByte.toString() });
      init();
      AppMethodBeat.o(104601);
      return;
      label214:
      ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", new Object[] { paramString.toString() });
    }
  }
  
  public final void gU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104594);
    gV(paramString1, paramString2);
    AppMethodBeat.o(104594);
  }
  
  public final void gV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104600);
    try
    {
      if (s.aKE(paramString1))
      {
        paramString2 = new h(i.aU(paramString1, 0, -1));
        paramString2.start();
        setImageDrawable(paramString2);
        AppMethodBeat.o(104600);
        return;
      }
      if (!bs.isNullOrNil(paramString2)) {
        setCacheKey(paramString2);
      }
      for (paramString2 = c.cRR().gT(getCacheKey(), paramString1);; paramString2 = new d(paramString1, this.txg))
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
            paramString2 = com.tencent.mm.sdk.platformtools.f.decodeFile(paramString1, null);
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
            ac.printErrStackTrace("MicroMsg.GIF.MMGIFImageView", paramString2, "setMMGIFFilePath failed, oom happened. show default. path %s", new Object[] { paramString1 });
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
        ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", new Object[] { bs.m(paramString1) });
        AppMethodBeat.o(104600);
        return;
      }
      ac.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", new Object[] { paramString1 });
      init();
      i.deleteFile(paramString1);
      AppMethodBeat.o(104600);
      return;
    }
    catch (IOException paramString2)
    {
      ac.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", new Object[] { bs.m(paramString2) });
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
  
  public String getCacheKey()
  {
    return this.oXi;
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
      this.mDensity = (com.tencent.mm.cc.a.getDensity(ai.getContext()) / 2.0F);
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
  
  public final void init()
  {
    AppMethodBeat.i(104602);
    this.txf = com.tencent.mm.compatible.util.e.YD();
    if (this.txf)
    {
      if (this.txd > 0)
      {
        super.setImageResource(this.txd);
        AppMethodBeat.o(104602);
      }
    }
    else if (this.txe > 0) {
      super.setImageResource(this.txe);
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
    this.oXi = paramString;
  }
  
  public void setDefaultBackgroundResource(int paramInt)
  {
    this.txd = paramInt;
  }
  
  public void setDefaultImageResource(int paramInt)
  {
    this.txd = paramInt;
  }
  
  public void setImageFilePath(String paramString)
  {
    AppMethodBeat.i(104593);
    gV(paramString, null);
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