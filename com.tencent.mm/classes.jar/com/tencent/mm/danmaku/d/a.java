package com.tencent.mm.danmaku.d;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.e.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public final LinkedList<a> gQm;
  private final LinkedList<a> gQn;
  private final int gQo;
  public int gQp;
  public int gQq;
  public int gQr;
  
  public a()
  {
    AppMethodBeat.i(241741);
    this.gQm = new LinkedList();
    this.gQn = new LinkedList();
    DisplayMetrics localDisplayMetrics = com.tencent.mm.danmaku.f.a.atr().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    this.gQo = (localDisplayMetrics.heightPixels * i * 6);
    AppMethodBeat.o(241741);
  }
  
  private void atj()
  {
    AppMethodBeat.i(241744);
    label26:
    label117:
    label118:
    for (;;)
    {
      Object localObject;
      if (this.gQp > this.gQo)
      {
        Iterator localIterator = this.gQm.iterator();
        localObject = null;
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (localObject == null)
          {
            localObject = locala;
          }
          else
          {
            if (localObject.mSize <= locala.mSize) {
              break label117;
            }
            localObject = locala;
          }
        }
      }
      for (;;)
      {
        break label26;
        if (localObject == null) {
          break label118;
        }
        this.gQm.remove(localObject);
        this.gQp -= localObject.gQs;
        localObject.destroy();
        this.gQn.addLast(localObject);
        break;
        AppMethodBeat.o(241744);
        return;
      }
    }
  }
  
  private a atk()
  {
    AppMethodBeat.i(241745);
    a locala2 = (a)this.gQn.poll();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a((byte)0);
    }
    AppMethodBeat.o(241745);
    return locala1;
  }
  
  public final Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241742);
    this.gQq += 1;
    Iterator localIterator = this.gQm.iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (a)localIterator.next();
      if ((((a)localObject2).mWidth < paramInt1) || (((a)localObject2).mHeight < paramInt2)) {
        break label188;
      }
      if (localObject1 == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        if (((a)localObject1).mSize < ((a)localObject2).mSize) {
          break label188;
        }
        localObject1 = localObject2;
      }
    }
    label188:
    for (;;)
    {
      break;
      if (localObject1 != null)
      {
        this.gQm.remove(localObject1);
        this.gQp -= ((a)localObject1).gQs;
        localObject2 = ((a)localObject1).mBitmap;
        ((a)localObject1).reset();
        this.gQn.addLast(localObject1);
        AppMethodBeat.o(241742);
        return localObject2;
      }
      try
      {
        this.gQr += 1;
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
        AppMethodBeat.o(241742);
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        e.e("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
        AppMethodBeat.o(241742);
        return null;
      }
    }
  }
  
  public final void x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(241743);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(241743);
      return;
    }
    this.gQp += paramBitmap.getRowBytes() * paramBitmap.getHeight();
    a locala = atk();
    locala.y(paramBitmap);
    this.gQm.addLast(locala);
    atj();
    AppMethodBeat.o(241743);
  }
  
  public static final class a
  {
    int gQs;
    Bitmap mBitmap;
    int mHeight;
    int mSize;
    int mWidth;
    
    public final void destroy()
    {
      AppMethodBeat.i(241740);
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!com.tencent.mm.danmaku.f.a.atn())) {
        this.mBitmap.recycle();
      }
      reset();
      AppMethodBeat.o(241740);
    }
    
    final void reset()
    {
      this.mBitmap = null;
      this.mWidth = 0;
      this.mHeight = 0;
      this.mSize = 0;
      this.gQs = 0;
    }
    
    final void y(Bitmap paramBitmap)
    {
      AppMethodBeat.i(241739);
      this.mBitmap = paramBitmap;
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = paramBitmap.getHeight();
      this.mSize = (paramBitmap.getHeight() * paramBitmap.getWidth());
      this.gQs = (paramBitmap.getRowBytes() * paramBitmap.getHeight());
      AppMethodBeat.o(241739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.a
 * JD-Core Version:    0.7.0.1
 */