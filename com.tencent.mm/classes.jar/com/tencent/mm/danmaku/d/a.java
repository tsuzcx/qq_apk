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
  public final LinkedList<a> jAF;
  private final LinkedList<a> jAG;
  private final int jAH;
  public int jAI;
  public int jAJ;
  public int jAK;
  
  public a()
  {
    AppMethodBeat.i(270383);
    this.jAF = new LinkedList();
    this.jAG = new LinkedList();
    DisplayMetrics localDisplayMetrics = com.tencent.mm.danmaku.f.a.aAh().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    this.jAH = (localDisplayMetrics.heightPixels * i * 6);
    AppMethodBeat.o(270383);
  }
  
  private void azY()
  {
    AppMethodBeat.i(270387);
    label26:
    label117:
    label118:
    for (;;)
    {
      Object localObject;
      if (this.jAI > this.jAH)
      {
        Iterator localIterator = this.jAF.iterator();
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
        this.jAF.remove(localObject);
        this.jAI -= localObject.jAL;
        localObject.destroy();
        this.jAG.addLast(localObject);
        break;
        AppMethodBeat.o(270387);
        return;
      }
    }
  }
  
  private a azZ()
  {
    AppMethodBeat.i(270388);
    a locala2 = (a)this.jAG.poll();
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a((byte)0);
    }
    AppMethodBeat.o(270388);
    return locala1;
  }
  
  public final Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270385);
    this.jAJ += 1;
    Iterator localIterator = this.jAF.iterator();
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
        this.jAF.remove(localObject1);
        this.jAI -= ((a)localObject1).jAL;
        localObject2 = ((a)localObject1).mBitmap;
        ((a)localObject1).reset();
        this.jAG.addLast(localObject1);
        AppMethodBeat.o(270385);
        return localObject2;
      }
      try
      {
        this.jAK += 1;
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
        AppMethodBeat.o(270385);
        return localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        e.e("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
        AppMethodBeat.o(270385);
        return null;
      }
    }
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(270386);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(270386);
      return;
    }
    this.jAI += paramBitmap.getRowBytes() * paramBitmap.getHeight();
    a locala = azZ();
    locala.t(paramBitmap);
    this.jAF.addLast(locala);
    azY();
    AppMethodBeat.o(270386);
  }
  
  public static final class a
  {
    int jAL;
    Bitmap mBitmap;
    int mHeight;
    int mSize;
    int mWidth;
    
    public final void destroy()
    {
      AppMethodBeat.i(268145);
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!com.tencent.mm.danmaku.f.a.aAd())) {
        this.mBitmap.recycle();
      }
      reset();
      AppMethodBeat.o(268145);
    }
    
    final void reset()
    {
      this.mBitmap = null;
      this.mWidth = 0;
      this.mHeight = 0;
      this.mSize = 0;
      this.jAL = 0;
    }
    
    final void t(Bitmap paramBitmap)
    {
      AppMethodBeat.i(268143);
      this.mBitmap = paramBitmap;
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = paramBitmap.getHeight();
      this.mSize = (paramBitmap.getHeight() * paramBitmap.getWidth());
      this.jAL = (paramBitmap.getRowBytes() * paramBitmap.getHeight());
      AppMethodBeat.o(268143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.a
 * JD-Core Version:    0.7.0.1
 */