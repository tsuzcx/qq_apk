package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.d;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.d.b;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.s.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class h
  extends Drawable
{
  private static final Paint hxL;
  private ImageView cum;
  private Bitmap mBitmap;
  private String mFilePath;
  private int mPosition;
  private int mediaType;
  private String tFR;
  private long tFS;
  private long tFU;
  private s.e tFV;
  public a tQk;
  private Rect tQl;
  private boolean tQm;
  private boolean tQn;
  private boolean tQo;
  
  static
  {
    AppMethodBeat.i(111733);
    Paint localPaint = new Paint();
    hxL = localPaint;
    localPaint.setAntiAlias(true);
    hxL.setFilterBitmap(true);
    AppMethodBeat.o(111733);
  }
  
  private h(ImageView paramImageView)
  {
    AppMethodBeat.i(111722);
    this.tQl = new Rect();
    this.tQm = false;
    this.tQn = false;
    this.tQo = false;
    this.cum = paramImageView;
    this.mFilePath = "";
    this.tFR = "";
    AppMethodBeat.o(111722);
  }
  
  private void Hw(int paramInt)
  {
    if (this.mPosition != paramInt)
    {
      this.tQn = true;
      this.mPosition = paramInt;
    }
  }
  
  public static void a(ImageView paramImageView, int paramInt1, String paramString1, String paramString2, long paramLong1, int paramInt2, long paramLong2)
  {
    AppMethodBeat.i(179477);
    a(paramImageView, paramInt1, paramString1, paramString2, paramLong1, paramInt2, null, null, paramLong2);
    AppMethodBeat.o(179477);
  }
  
  private static void a(ImageView paramImageView, int paramInt1, String paramString1, String paramString2, long paramLong1, int paramInt2, a parama, s.e parame, long paramLong2)
  {
    AppMethodBeat.i(179479);
    Object localObject = paramImageView.getDrawable();
    if ((localObject instanceof h)) {}
    for (localObject = (h)localObject;; localObject = new h(paramImageView))
    {
      ((h)localObject).a(parame);
      ((h)localObject).Hw(paramInt2);
      ((h)localObject).xC(paramLong2);
      ((h)localObject).tQk = parama;
      ((h)localObject).b(paramInt1, paramString1, paramString2, paramLong1);
      paramImageView.setImageDrawable((Drawable)localObject);
      AppMethodBeat.o(179479);
      return;
    }
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(179476);
    a(paramImageView, paramInt, paramString1, paramString2, paramLong1, -1, null, null, paramLong2);
    AppMethodBeat.o(179476);
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString1, String paramString2, long paramLong, s.e parame)
  {
    AppMethodBeat.i(111730);
    a(paramImageView, paramInt, paramString1, paramString2, paramLong, -1, null, parame, 0L);
    AppMethodBeat.o(111730);
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString1, String paramString2, long paramLong1, a parama, long paramLong2)
  {
    AppMethodBeat.i(179478);
    a(paramImageView, paramInt, paramString1, paramString2, paramLong1, -1, parama, null, paramLong2);
    AppMethodBeat.o(179478);
  }
  
  private void a(s.e parame)
  {
    AppMethodBeat.i(111732);
    if (parame == null)
    {
      this.tFV = null;
      this.tQm = false;
      AppMethodBeat.o(111732);
      return;
    }
    if (!parame.equals(this.tFV))
    {
      this.tQm = true;
      this.tFV = parame;
    }
    AppMethodBeat.o(111732);
  }
  
  private void b(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(111723);
    String str = paramString1;
    if (bt.isNullOrNil(paramString1)) {
      str = paramString2;
    }
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
      AppMethodBeat.o(111723);
      return;
    }
    if ((!this.mFilePath.equals(str)) || (this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.tQm) || (this.tQn) || (this.tQo))
    {
      boolean bool = this.tQm;
      if (this.tFV == null)
      {
        paramString1 = "";
        ad.d("MicroMsg.ThumbDrawable", "setMediaFeature, crop area: %s %s.", new Object[] { Boolean.valueOf(bool), paramString1 });
        if (this.tQm) {
          this.tQm = false;
        }
        ad.d("MicroMsg.ThumbDrawable", "setMediaFeature, path equal? [%s] isPositionUpdate? [%s] isDateModified? [%s] mModifyDate [%s].", new Object[] { Boolean.valueOf(this.mFilePath.equals(str)), Boolean.valueOf(this.tQn), Boolean.valueOf(this.tQo), Long.valueOf(this.tFU) });
        if (this.tQn) {
          this.tQn = false;
        }
        if (this.tQo) {
          this.tQo = false;
        }
        this.mFilePath = str;
        this.tFR = paramString2;
        this.tFS = paramLong;
        this.mediaType = paramInt;
        this.mBitmap = e.cUL().a(this.mFilePath, this.tFR, this.tFV, this.tFU);
        if (this.mBitmap != null) {
          break label529;
        }
        bool = true;
        label278:
        if (this.mBitmap == null) {
          break label535;
        }
        paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());
        label296:
        ad.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { str, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          break label553;
        }
        paramString1 = d.a(this.mFilePath, this.tFV, this.mPosition);
        ad.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 1: %s.", new Object[] { paramString1 });
        e.cUL().a(new c(this.cum, paramString1));
        this.mBitmap = e.cUL().a(this.mFilePath, paramInt, paramString2, paramLong, this.tFV, this.mPosition, this.tFU);
        paramString2 = this.mFilePath;
        if (this.mBitmap != null) {
          break label541;
        }
        bool = true;
        label439:
        if (this.mBitmap == null) {
          break label547;
        }
      }
      label529:
      label535:
      label541:
      label547:
      for (paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());; paramString1 = "")
      {
        ad.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 2, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
          break label674;
        }
        this.cum.invalidate();
        AppMethodBeat.o(111723);
        return;
        paramString1 = this.tFV.toString();
        break;
        bool = false;
        break label278;
        paramString1 = "";
        break label296;
        bool = false;
        break label439;
      }
      label553:
      paramString2 = this.mFilePath;
      if (this.mBitmap == null)
      {
        bool = true;
        label568:
        if (this.mBitmap == null) {
          break label626;
        }
      }
      label626:
      for (paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());; paramString1 = "")
      {
        ad.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1 ok!!! filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        break;
        bool = false;
        break label568;
      }
    }
    paramString2 = this.mFilePath;
    if (this.mBitmap != null) {}
    for (paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());; paramString1 = "bitmap is null.")
    {
      ad.d("MicroMsg.ThumbDrawable", "setMediaFeature filePath:[%s], mBitmap.isRecycled():[%s].", new Object[] { paramString2, paramString1 });
      label674:
      AppMethodBeat.o(111723);
      return;
    }
  }
  
  private void xC(long paramLong)
  {
    if (this.tFU != paramLong)
    {
      this.tQo = true;
      this.tFU = paramLong;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(111726);
    boolean bool;
    String str;
    label166:
    label193:
    int i;
    Object localObject4;
    Object localObject3;
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
      if (this.mBitmap == null)
      {
        bool = true;
        ad.d("MicroMsg.ThumbDrawable", "[duanyi] get bitmap is null: %s.", new Object[] { Boolean.valueOf(bool) });
        localObject1 = d.a(this.mFilePath, this.tFV, this.mPosition);
        ad.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 3: %s.", new Object[] { localObject1 });
        e.cUL().a(new c(this.cum, (String)localObject1));
        this.mBitmap = e.cUL().a(this.mFilePath, this.mediaType, this.tFR, this.tFS, this.tFV, this.mPosition, this.tFU);
        str = "pennqin, set bitmap 4, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.";
        localObject2 = new Object[4];
        localObject2[0] = this.mFilePath;
        if (this.mBitmap != null) {
          break label278;
        }
        bool = true;
        localObject2[1] = Boolean.valueOf(bool);
        if (this.mBitmap == null) {
          break label283;
        }
        localObject1 = Boolean.valueOf(this.mBitmap.isRecycled());
        localObject2[2] = localObject1;
        i = 3;
        localObject1 = this;
        localObject4 = localObject2;
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
    }
    for (;;)
    {
      localObject2[i] = localObject1;
      ad.d("MicroMsg.ThumbDrawable", str, localObject3);
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        break label363;
      }
      ad.d("MicroMsg.ThumbDrawable", "pennqin, get bitmap 4 fail!!! %s.", new Object[] { this.mFilePath });
      AppMethodBeat.o(111726);
      return;
      bool = false;
      break;
      label278:
      bool = false;
      break label166;
      label283:
      localObject1 = "";
      break label193;
      str = "[duanyi test] get bitmap ok: %s crop area id: %s.";
      localObject1 = new Object[2];
      localObject1[0] = this.mFilePath;
      if (this.tFV != null)
      {
        localObject4 = this.tFV.id;
        i = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
      else
      {
        localObject4 = "";
        i = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
    }
    label363:
    if (this.tQk != null) {
      this.tQk.cWp();
    }
    Object localObject1 = this.mBitmap;
    Object localObject2 = this.tQl;
    if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight())
    {
      ((Rect)localObject2).top = 0;
      ((Rect)localObject2).bottom = ((Bitmap)localObject1).getHeight();
      ((Rect)localObject2).left = (((Bitmap)localObject1).getWidth() - ((Bitmap)localObject1).getHeight() >> 1);
      i = ((Rect)localObject2).left;
      ((Rect)localObject2).right = (((Bitmap)localObject1).getHeight() + i);
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.mBitmap, this.tQl, getBounds(), hxL);
      ad.d("MicroMsg.ThumbDrawable", "bounds:%s", new Object[] { getBounds().toString() });
      AppMethodBeat.o(111726);
      return;
      ((Rect)localObject2).left = 0;
      ((Rect)localObject2).right = ((Bitmap)localObject1).getWidth();
      ((Rect)localObject2).top = (((Bitmap)localObject1).getHeight() - ((Bitmap)localObject1).getWidth() >> 1);
      i = ((Rect)localObject2).top;
      ((Rect)localObject2).bottom = (((Bitmap)localObject1).getWidth() + i);
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return 400;
  }
  
  public final int getIntrinsicWidth()
  {
    return 400;
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(111724);
    ad.d("MicroMsg.ThumbDrawable", "setBoundsLTRB:%d %d - %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(111724);
  }
  
  public final void setBounds(Rect paramRect)
  {
    AppMethodBeat.i(111725);
    ad.d("MicroMsg.ThumbDrawable", "setBoundsRECT:%s", new Object[] { paramRect.toString() });
    super.setBounds(paramRect);
    AppMethodBeat.o(111725);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public static abstract interface a
  {
    public abstract void cWp();
  }
  
  static final class b
    implements Runnable
  {
    final WeakReference<ImageView> tQp;
    
    b(ImageView paramImageView)
    {
      AppMethodBeat.i(111714);
      this.tQp = new WeakReference(paramImageView);
      AppMethodBeat.o(111714);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111715);
      Object localObject1 = (ImageView)this.tQp.get();
      if (localObject1 == null) {}
      for (localObject1 = null; !(localObject1 instanceof h); localObject1 = ((ImageView)localObject1).getDrawable())
      {
        ad.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
        AppMethodBeat.o(111715);
        return;
      }
      localObject1 = (h)localObject1;
      ad.d("MicroMsg.ThumbDrawable", "invalidateSelf, mFilePath: %s.", new Object[] { h.a((h)localObject1) });
      Object localObject2 = e.cUL();
      String str1 = h.a((h)localObject1);
      String str2 = h.d((h)localObject1);
      h.e((h)localObject1);
      h.a((h)localObject1, ((c)localObject2).a(str1, str2, h.b((h)localObject1), h.f((h)localObject1)));
      if (h.g((h)localObject1) == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 3, bitmap is null %s filepath: %s.", new Object[] { Boolean.valueOf(bool), h.a((h)localObject1) });
        if ((h.g((h)localObject1) == null) || (h.g((h)localObject1).isRecycled()))
        {
          localObject2 = d.a(h.a((h)localObject1), h.b((h)localObject1), h.c((h)localObject1));
          ad.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 2: %s.", new Object[] { localObject2 });
          e.cUL().a(new h.c(h.h((h)localObject1), (String)localObject2));
          e.cUL().a(h.a((h)localObject1), h.i((h)localObject1), h.d((h)localObject1), h.e((h)localObject1), h.b((h)localObject1), h.c((h)localObject1), h.f((h)localObject1));
          ad.d("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is invalid! path:%s.", new Object[] { h.a((h)localObject1) });
        }
        ((h)localObject1).invalidateSelf();
        AppMethodBeat.o(111715);
        return;
      }
    }
  }
  
  static final class c
    implements d.b
  {
    final WeakReference<ImageView> tQq;
    final String tQr;
    
    c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(111716);
      this.tQq = new WeakReference(paramImageView);
      this.tQr = paramString;
      AppMethodBeat.o(111716);
    }
    
    private Drawable cWr()
    {
      AppMethodBeat.i(111720);
      Object localObject = (ImageView)this.tQq.get();
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getDrawable();
        AppMethodBeat.o(111720);
        return localObject;
      }
      AppMethodBeat.o(111720);
      return null;
    }
    
    public final void akP(String paramString)
    {
      AppMethodBeat.i(111717);
      ad.d("MicroMsg.ThumbDrawable", "onImageGet fileKey: %s.", new Object[] { paramString });
      Object localObject = cWr();
      if ((localObject instanceof h))
      {
        localObject = (h)localObject;
        if (d.a(h.a((h)localObject), h.b((h)localObject), h.c((h)localObject)).equals(paramString))
        {
          ad.d("MicroMsg.ThumbDrawable", "match!!! start invalidate, fileKey: %s. ", new Object[] { paramString });
          paramString = (ImageView)this.tQq.get();
          if (paramString != null) {
            paramString.post(new h.b(paramString));
          }
        }
        AppMethodBeat.o(111717);
        return;
      }
      ad.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerRef [%s] is not a ThumbDrawable, ignore.", new Object[] { localObject, this.tQq });
      AppMethodBeat.o(111717);
    }
    
    public final String cUI()
    {
      return this.tQr;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111719);
      if (paramObject == null)
      {
        AppMethodBeat.o(111719);
        return false;
      }
      Drawable localDrawable = cWr();
      if ((paramObject instanceof c)) {
        paramObject = ((c)paramObject).cWr();
      }
      while ((localDrawable != null) && (paramObject != null))
      {
        boolean bool = localDrawable.equals(paramObject);
        AppMethodBeat.o(111719);
        return bool;
        if ((paramObject instanceof h))
        {
          paramObject = (Drawable)paramObject;
        }
        else
        {
          AppMethodBeat.o(111719);
          return false;
        }
      }
      AppMethodBeat.o(111719);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111718);
      Drawable localDrawable = cWr();
      if (localDrawable != null)
      {
        i = localDrawable.hashCode();
        AppMethodBeat.o(111718);
        return i;
      }
      int i = super.hashCode();
      AppMethodBeat.o(111718);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111721);
      String str = "decodeTaskKey:" + this.tQr + " ownerRef:" + this.tQq;
      AppMethodBeat.o(111721);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h
 * JD-Core Version:    0.7.0.1
 */