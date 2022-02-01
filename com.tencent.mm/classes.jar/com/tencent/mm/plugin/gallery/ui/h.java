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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class h
  extends Drawable
{
  private static final Paint hfD;
  private ImageView lqK;
  private Bitmap mBitmap;
  private String mFilePath;
  private int mPosition;
  private int mediaType;
  private String sJg;
  private long sJh;
  private long sJj;
  private s.e sJk;
  public a sTG;
  private Rect sTH;
  private boolean sTI;
  private boolean sTJ;
  private boolean sTK;
  
  static
  {
    AppMethodBeat.i(111733);
    Paint localPaint = new Paint();
    hfD = localPaint;
    localPaint.setAntiAlias(true);
    hfD.setFilterBitmap(true);
    AppMethodBeat.o(111733);
  }
  
  private h(ImageView paramImageView)
  {
    AppMethodBeat.i(111722);
    this.sTH = new Rect();
    this.sTI = false;
    this.sTJ = false;
    this.sTK = false;
    this.lqK = paramImageView;
    this.mFilePath = "";
    this.sJg = "";
    AppMethodBeat.o(111722);
  }
  
  private void Gh(int paramInt)
  {
    if (this.mPosition != paramInt)
    {
      this.sTJ = true;
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
      ((h)localObject).Gh(paramInt2);
      ((h)localObject).vw(paramLong2);
      ((h)localObject).sTG = parama;
      ((h)localObject).c(paramInt1, paramString1, paramString2, paramLong1);
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
      this.sJk = null;
      this.sTI = false;
      AppMethodBeat.o(111732);
      return;
    }
    if (!parame.equals(this.sJk))
    {
      this.sTI = true;
      this.sJk = parame;
    }
    AppMethodBeat.o(111732);
  }
  
  private void c(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(111723);
    String str = paramString1;
    if (bs.isNullOrNil(paramString1)) {
      str = paramString2;
    }
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
      AppMethodBeat.o(111723);
      return;
    }
    if ((!this.mFilePath.equals(str)) || (this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.sTI) || (this.sTJ) || (this.sTK))
    {
      boolean bool = this.sTI;
      if (this.sJk == null)
      {
        paramString1 = "";
        ac.d("MicroMsg.ThumbDrawable", "setMediaFeature, crop area: %s %s.", new Object[] { Boolean.valueOf(bool), paramString1 });
        if (this.sTI) {
          this.sTI = false;
        }
        ac.d("MicroMsg.ThumbDrawable", "setMediaFeature, path equal? [%s] isPositionUpdate? [%s] isDateModified? [%s] mModifyDate [%s].", new Object[] { Boolean.valueOf(this.mFilePath.equals(str)), Boolean.valueOf(this.sTJ), Boolean.valueOf(this.sTK), Long.valueOf(this.sJj) });
        if (this.sTJ) {
          this.sTJ = false;
        }
        if (this.sTK) {
          this.sTK = false;
        }
        this.mFilePath = str;
        this.sJg = paramString2;
        this.sJh = paramLong;
        this.mediaType = paramInt;
        this.mBitmap = e.cMs().a(this.mFilePath, this.sJg, this.sJk, this.sJj);
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
        ac.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { str, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          break label553;
        }
        paramString1 = d.a(this.mFilePath, this.sJk, this.mPosition);
        ac.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 1: %s.", new Object[] { paramString1 });
        e.cMs().a(new c(this.lqK, paramString1));
        this.mBitmap = e.cMs().a(this.mFilePath, paramInt, paramString2, paramLong, this.sJk, this.mPosition, this.sJj);
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
        ac.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 2, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
          break label674;
        }
        this.lqK.invalidate();
        AppMethodBeat.o(111723);
        return;
        paramString1 = this.sJk.toString();
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
        ac.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1 ok!!! filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        break;
        bool = false;
        break label568;
      }
    }
    paramString2 = this.mFilePath;
    if (this.mBitmap != null) {}
    for (paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());; paramString1 = "bitmap is null.")
    {
      ac.d("MicroMsg.ThumbDrawable", "setMediaFeature filePath:[%s], mBitmap.isRecycled():[%s].", new Object[] { paramString2, paramString1 });
      label674:
      AppMethodBeat.o(111723);
      return;
    }
  }
  
  private void vw(long paramLong)
  {
    if (this.sJj != paramLong)
    {
      this.sTK = true;
      this.sJj = paramLong;
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
        ac.d("MicroMsg.ThumbDrawable", "[duanyi] get bitmap is null: %s.", new Object[] { Boolean.valueOf(bool) });
        localObject1 = d.a(this.mFilePath, this.sJk, this.mPosition);
        ac.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 3: %s.", new Object[] { localObject1 });
        e.cMs().a(new c(this.lqK, (String)localObject1));
        this.mBitmap = e.cMs().a(this.mFilePath, this.mediaType, this.sJg, this.sJh, this.sJk, this.mPosition, this.sJj);
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
      ac.d("MicroMsg.ThumbDrawable", str, localObject3);
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        break label363;
      }
      ac.d("MicroMsg.ThumbDrawable", "pennqin, get bitmap 4 fail!!! %s.", new Object[] { this.mFilePath });
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
      if (this.sJk != null)
      {
        localObject4 = this.sJk.id;
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
    if (this.sTG != null) {
      this.sTG.cGk();
    }
    Object localObject1 = this.mBitmap;
    Object localObject2 = this.sTH;
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
      paramCanvas.drawBitmap(this.mBitmap, this.sTH, getBounds(), hfD);
      ac.d("MicroMsg.ThumbDrawable", "bounds:%s", new Object[] { getBounds().toString() });
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
    ac.d("MicroMsg.ThumbDrawable", "setBoundsLTRB:%d %d - %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(111724);
  }
  
  public final void setBounds(Rect paramRect)
  {
    AppMethodBeat.i(111725);
    ac.d("MicroMsg.ThumbDrawable", "setBoundsRECT:%s", new Object[] { paramRect.toString() });
    super.setBounds(paramRect);
    AppMethodBeat.o(111725);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public static abstract interface a
  {
    public abstract void cGk();
  }
  
  static final class b
    implements Runnable
  {
    final WeakReference<ImageView> sTL;
    
    b(ImageView paramImageView)
    {
      AppMethodBeat.i(111714);
      this.sTL = new WeakReference(paramImageView);
      AppMethodBeat.o(111714);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111715);
      Object localObject1 = (ImageView)this.sTL.get();
      if (localObject1 == null) {}
      for (localObject1 = null; !(localObject1 instanceof h); localObject1 = ((ImageView)localObject1).getDrawable())
      {
        ac.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
        AppMethodBeat.o(111715);
        return;
      }
      localObject1 = (h)localObject1;
      ac.d("MicroMsg.ThumbDrawable", "invalidateSelf, mFilePath: %s.", new Object[] { h.a((h)localObject1) });
      Object localObject2 = e.cMs();
      String str1 = h.a((h)localObject1);
      String str2 = h.d((h)localObject1);
      h.e((h)localObject1);
      h.a((h)localObject1, ((c)localObject2).a(str1, str2, h.b((h)localObject1), h.f((h)localObject1)));
      if (h.g((h)localObject1) == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 3, bitmap is null %s filepath: %s.", new Object[] { Boolean.valueOf(bool), h.a((h)localObject1) });
        if ((h.g((h)localObject1) == null) || (h.g((h)localObject1).isRecycled()))
        {
          localObject2 = d.a(h.a((h)localObject1), h.b((h)localObject1), h.c((h)localObject1));
          ac.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 2: %s.", new Object[] { localObject2 });
          e.cMs().a(new h.c(h.h((h)localObject1), (String)localObject2));
          e.cMs().a(h.a((h)localObject1), h.i((h)localObject1), h.d((h)localObject1), h.e((h)localObject1), h.b((h)localObject1), h.c((h)localObject1), h.f((h)localObject1));
          ac.d("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is invalid! path:%s.", new Object[] { h.a((h)localObject1) });
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
    final WeakReference<ImageView> sTM;
    final String sTN;
    
    c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(111716);
      this.sTM = new WeakReference(paramImageView);
      this.sTN = paramString;
      AppMethodBeat.o(111716);
    }
    
    private Drawable cNY()
    {
      AppMethodBeat.i(111720);
      Object localObject = (ImageView)this.sTM.get();
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getDrawable();
        AppMethodBeat.o(111720);
        return localObject;
      }
      AppMethodBeat.o(111720);
      return null;
    }
    
    public final void agr(String paramString)
    {
      AppMethodBeat.i(111717);
      ac.d("MicroMsg.ThumbDrawable", "onImageGet fileKey: %s.", new Object[] { paramString });
      Object localObject = cNY();
      if ((localObject instanceof h))
      {
        localObject = (h)localObject;
        if (d.a(h.a((h)localObject), h.b((h)localObject), h.c((h)localObject)).equals(paramString))
        {
          ac.d("MicroMsg.ThumbDrawable", "match!!! start invalidate, fileKey: %s. ", new Object[] { paramString });
          paramString = (ImageView)this.sTM.get();
          if (paramString != null) {
            paramString.post(new h.b(paramString));
          }
        }
        AppMethodBeat.o(111717);
        return;
      }
      ac.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerRef [%s] is not a ThumbDrawable, ignore.", new Object[] { localObject, this.sTM });
      AppMethodBeat.o(111717);
    }
    
    public final String cMp()
    {
      return this.sTN;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111719);
      if (paramObject == null)
      {
        AppMethodBeat.o(111719);
        return false;
      }
      Drawable localDrawable = cNY();
      if ((paramObject instanceof c)) {
        paramObject = ((c)paramObject).cNY();
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
      Drawable localDrawable = cNY();
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
      String str = "decodeTaskKey:" + this.sTN + " ownerRef:" + this.sTM;
      AppMethodBeat.o(111721);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h
 * JD-Core Version:    0.7.0.1
 */