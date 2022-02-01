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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class h
  extends Drawable
{
  private static final Paint hAz;
  private ImageView cuP;
  private Bitmap mBitmap;
  private String mFilePath;
  private int mPosition;
  private int mediaType;
  private String tQI;
  private long tQJ;
  private long tQL;
  private s.e tQM;
  public a ubb;
  private Rect ubc;
  private boolean ubd;
  private boolean ube;
  private boolean ubf;
  
  static
  {
    AppMethodBeat.i(111733);
    Paint localPaint = new Paint();
    hAz = localPaint;
    localPaint.setAntiAlias(true);
    hAz.setFilterBitmap(true);
    AppMethodBeat.o(111733);
  }
  
  private h(ImageView paramImageView)
  {
    AppMethodBeat.i(111722);
    this.ubc = new Rect();
    this.ubd = false;
    this.ube = false;
    this.ubf = false;
    this.cuP = paramImageView;
    this.mFilePath = "";
    this.tQI = "";
    AppMethodBeat.o(111722);
  }
  
  private void HT(int paramInt)
  {
    if (this.mPosition != paramInt)
    {
      this.ube = true;
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
      ((h)localObject).HT(paramInt2);
      ((h)localObject).xW(paramLong2);
      ((h)localObject).ubb = parama;
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
      this.tQM = null;
      this.ubd = false;
      AppMethodBeat.o(111732);
      return;
    }
    if (!parame.equals(this.tQM))
    {
      this.ubd = true;
      this.tQM = parame;
    }
    AppMethodBeat.o(111732);
  }
  
  private void b(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(111723);
    String str = paramString1;
    if (bu.isNullOrNil(paramString1)) {
      str = paramString2;
    }
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
      AppMethodBeat.o(111723);
      return;
    }
    if ((!this.mFilePath.equals(str)) || (this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.ubd) || (this.ube) || (this.ubf))
    {
      boolean bool = this.ubd;
      if (this.tQM == null)
      {
        paramString1 = "";
        ae.d("MicroMsg.ThumbDrawable", "setMediaFeature, crop area: %s %s.", new Object[] { Boolean.valueOf(bool), paramString1 });
        if (this.ubd) {
          this.ubd = false;
        }
        ae.d("MicroMsg.ThumbDrawable", "setMediaFeature, path equal? [%s] isPositionUpdate? [%s] isDateModified? [%s] mModifyDate [%s].", new Object[] { Boolean.valueOf(this.mFilePath.equals(str)), Boolean.valueOf(this.ube), Boolean.valueOf(this.ubf), Long.valueOf(this.tQL) });
        if (this.ube) {
          this.ube = false;
        }
        if (this.ubf) {
          this.ubf = false;
        }
        this.mFilePath = str;
        this.tQI = paramString2;
        this.tQJ = paramLong;
        this.mediaType = paramInt;
        this.mBitmap = e.cXq().a(this.mFilePath, this.tQI, this.tQM, this.tQL);
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
        ae.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { str, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          break label553;
        }
        paramString1 = d.a(this.mFilePath, this.tQM, this.mPosition);
        ae.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 1: %s.", new Object[] { paramString1 });
        e.cXq().a(new c(this.cuP, paramString1));
        this.mBitmap = e.cXq().a(this.mFilePath, paramInt, paramString2, paramLong, this.tQM, this.mPosition, this.tQL);
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
        ae.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 2, filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {
          break label674;
        }
        this.cuP.invalidate();
        AppMethodBeat.o(111723);
        return;
        paramString1 = this.tQM.toString();
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
        ae.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 1 ok!!! filePath:[%s] mBitmap is null:[%s], mBitmap.isRecycled():[%s], this: %s.", new Object[] { paramString2, Boolean.valueOf(bool), paramString1, this });
        break;
        bool = false;
        break label568;
      }
    }
    paramString2 = this.mFilePath;
    if (this.mBitmap != null) {}
    for (paramString1 = Boolean.valueOf(this.mBitmap.isRecycled());; paramString1 = "bitmap is null.")
    {
      ae.d("MicroMsg.ThumbDrawable", "setMediaFeature filePath:[%s], mBitmap.isRecycled():[%s].", new Object[] { paramString2, paramString1 });
      label674:
      AppMethodBeat.o(111723);
      return;
    }
  }
  
  private void xW(long paramLong)
  {
    if (this.tQL != paramLong)
    {
      this.ubf = true;
      this.tQL = paramLong;
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
        ae.d("MicroMsg.ThumbDrawable", "[duanyi] get bitmap is null: %s.", new Object[] { Boolean.valueOf(bool) });
        localObject1 = d.a(this.mFilePath, this.tQM, this.mPosition);
        ae.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 3: %s.", new Object[] { localObject1 });
        e.cXq().a(new c(this.cuP, (String)localObject1));
        this.mBitmap = e.cXq().a(this.mFilePath, this.mediaType, this.tQI, this.tQJ, this.tQM, this.mPosition, this.tQL);
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
      ae.d("MicroMsg.ThumbDrawable", str, localObject3);
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        break label363;
      }
      ae.d("MicroMsg.ThumbDrawable", "pennqin, get bitmap 4 fail!!! %s.", new Object[] { this.mFilePath });
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
      if (this.tQM != null)
      {
        localObject4 = this.tQM.id;
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
    if (this.ubb != null) {
      this.ubb.cYU();
    }
    Object localObject1 = this.mBitmap;
    Object localObject2 = this.ubc;
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
      paramCanvas.drawBitmap(this.mBitmap, this.ubc, getBounds(), hAz);
      ae.d("MicroMsg.ThumbDrawable", "bounds:%s", new Object[] { getBounds().toString() });
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
    ae.d("MicroMsg.ThumbDrawable", "setBoundsLTRB:%d %d - %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(111724);
  }
  
  public final void setBounds(Rect paramRect)
  {
    AppMethodBeat.i(111725);
    ae.d("MicroMsg.ThumbDrawable", "setBoundsRECT:%s", new Object[] { paramRect.toString() });
    super.setBounds(paramRect);
    AppMethodBeat.o(111725);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public static abstract interface a
  {
    public abstract void cYU();
  }
  
  static final class b
    implements Runnable
  {
    final WeakReference<ImageView> ubg;
    
    b(ImageView paramImageView)
    {
      AppMethodBeat.i(111714);
      this.ubg = new WeakReference(paramImageView);
      AppMethodBeat.o(111714);
    }
    
    public final void run()
    {
      AppMethodBeat.i(111715);
      Object localObject1 = (ImageView)this.ubg.get();
      if (localObject1 == null) {}
      for (localObject1 = null; !(localObject1 instanceof h); localObject1 = ((ImageView)localObject1).getDrawable())
      {
        ae.w("MicroMsg.ThumbDrawable", "[tomys] ownerView is null or not a ThumbDrawable, ignore this task.");
        AppMethodBeat.o(111715);
        return;
      }
      localObject1 = (h)localObject1;
      ae.d("MicroMsg.ThumbDrawable", "invalidateSelf, mFilePath: %s.", new Object[] { h.a((h)localObject1) });
      Object localObject2 = e.cXq();
      String str1 = h.a((h)localObject1);
      String str2 = h.d((h)localObject1);
      h.e((h)localObject1);
      h.a((h)localObject1, ((c)localObject2).a(str1, str2, h.b((h)localObject1), h.f((h)localObject1)));
      if (h.g((h)localObject1) == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.ThumbDrawable", "pennqin, set bitmap 3, bitmap is null %s filepath: %s.", new Object[] { Boolean.valueOf(bool), h.a((h)localObject1) });
        if ((h.g((h)localObject1) == null) || (h.g((h)localObject1).isRecycled()))
        {
          localObject2 = d.a(h.a((h)localObject1), h.b((h)localObject1), h.c((h)localObject1));
          ae.d("MicroMsg.ThumbDrawable", "traceGetLis, create & add listener 2: %s.", new Object[] { localObject2 });
          e.cXq().a(new h.c(h.h((h)localObject1), (String)localObject2));
          e.cXq().a(h.a((h)localObject1), h.i((h)localObject1), h.d((h)localObject1), h.e((h)localObject1), h.b((h)localObject1), h.c((h)localObject1), h.f((h)localObject1));
          ae.d("MicroMsg.ThumbDrawable", "invalidateSelf! mBitmap is invalid! path:%s.", new Object[] { h.a((h)localObject1) });
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
    final WeakReference<ImageView> ubh;
    final String ubi;
    
    c(ImageView paramImageView, String paramString)
    {
      AppMethodBeat.i(111716);
      this.ubh = new WeakReference(paramImageView);
      this.ubi = paramString;
      AppMethodBeat.o(111716);
    }
    
    private Drawable cYW()
    {
      AppMethodBeat.i(111720);
      Object localObject = (ImageView)this.ubh.get();
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getDrawable();
        AppMethodBeat.o(111720);
        return localObject;
      }
      AppMethodBeat.o(111720);
      return null;
    }
    
    public final void alN(String paramString)
    {
      AppMethodBeat.i(111717);
      ae.d("MicroMsg.ThumbDrawable", "onImageGet fileKey: %s.", new Object[] { paramString });
      Object localObject = cYW();
      if ((localObject instanceof h))
      {
        localObject = (h)localObject;
        if (d.a(h.a((h)localObject), h.b((h)localObject), h.c((h)localObject)).equals(paramString))
        {
          ae.d("MicroMsg.ThumbDrawable", "match!!! start invalidate, fileKey: %s. ", new Object[] { paramString });
          paramString = (ImageView)this.ubh.get();
          if (paramString != null) {
            paramString.post(new h.b(paramString));
          }
        }
        AppMethodBeat.o(111717);
        return;
      }
      ae.w("MicroMsg.ThumbDrawable", "drawable [%s] in ownerRef [%s] is not a ThumbDrawable, ignore.", new Object[] { localObject, this.ubh });
      AppMethodBeat.o(111717);
    }
    
    public final String cXn()
    {
      return this.ubi;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111719);
      if (paramObject == null)
      {
        AppMethodBeat.o(111719);
        return false;
      }
      Drawable localDrawable = cYW();
      if ((paramObject instanceof c)) {
        paramObject = ((c)paramObject).cYW();
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
      Drawable localDrawable = cYW();
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
      String str = "decodeTaskKey:" + this.ubi + " ownerRef:" + this.ubh;
      AppMethodBeat.o(111721);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h
 * JD-Core Version:    0.7.0.1
 */