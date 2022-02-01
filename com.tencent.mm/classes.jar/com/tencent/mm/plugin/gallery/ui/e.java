package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private bf hTx;
  private int mScrollState;
  private SparseArray<WeakReference<MultiTouchImageView>> tYR;
  HashMap<String, Integer> tYS;
  private SparseArray<String> tYT;
  SparseArray<Bitmap> tYU;
  protected f<String, Bitmap> tYV;
  protected SparseIntArray tYW;
  private LinkedList<String> tYX;
  d tYY;
  boolean tYZ;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.hTx = new bf(1, "album-image-gallery-lazy-loader");
    this.tYR = new SparseArray();
    this.tYS = new HashMap();
    this.tYT = new SparseArray();
    this.tYU = new SparseArray();
    this.mScrollState = 0;
    this.tYV = new b(5, new f.b() {}, getClass());
    this.tYW = new SparseIntArray();
    this.tYX = new LinkedList();
    this.tYZ = false;
    this.tYY = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void HQ(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.tYT.get(paramInt) != null)
    {
      String str = (String)this.tYT.get(paramInt);
      this.tYR.remove(paramInt);
      this.tYT.remove(paramInt);
      this.tYS.remove(str);
      this.tYU.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(186191);
    this.tYS.put(paramString, Integer.valueOf(paramInt));
    this.tYT.put(paramInt, paramString);
    this.tYR.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(186191);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.tYR.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.tYR.get(paramInt)).get();
    String str = (String)this.tYT.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.tYW.indexOfValue(paramInt);
      if (j >= 0) {
        this.tYW.removeAt(j);
      }
      this.tYW.put(i, paramInt);
    }
    this.tYY.a(localMultiTouchImageView, str, paramBitmap);
    HQ(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void cYL()
  {
    AppMethodBeat.i(111551);
    this.tYV.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  final void Ov()
  {
    AppMethodBeat.i(111555);
    if (this.tYZ)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.tYX.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.tYX.removeLast();
    if (!this.tYS.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.tYZ = true;
    localObject = new bf.a()
    {
      private Bitmap tZb = null;
      
      public final boolean aEC()
      {
        AppMethodBeat.i(111547);
        if ((e.this.tYY == null) || (TextUtils.isEmpty(this.tZc)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        String str = this.tZc;
        long l = bu.HQ();
        Bitmap localBitmap = r.azs(str);
        ae.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bu.aO(l)), str });
        this.tZb = localBitmap;
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean aED()
      {
        AppMethodBeat.i(111548);
        e.this.tYZ = false;
        int i;
        if (e.this.tYS.containsKey(this.tZc))
        {
          i = ((Integer)e.this.tYS.get(this.tZc)).intValue();
          if (e.this.cYM()) {
            break label115;
          }
          e.this.tYU.put(i, this.tZb);
        }
        for (;;)
        {
          e.this.tYV.q(this.tZc, this.tZb);
          this.tZb = null;
          e.this.Ov();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.tZb);
        }
      }
    };
    this.hTx.c((bf.a)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(186192);
    if (this.tYX.contains(paramString))
    {
      AppMethodBeat.o(186192);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    HQ(i);
    a(i, paramMultiTouchImageView, paramString);
    this.tYX.add(paramString);
    Ov();
    AppMethodBeat.o(186192);
  }
  
  final boolean cYM()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.tYY = null;
    this.tYR.clear();
    this.tYU.clear();
    this.tYT.clear();
    this.tYS.clear();
    cYL();
    AppMethodBeat.o(111550);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (cYM())
    {
      int[] arrayOfInt = new int[this.tYU.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.tYU.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.tYU.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(111552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */