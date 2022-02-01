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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private be hQF;
  private int mScrollState;
  private SparseArray<WeakReference<MultiTouchImageView>> tOa;
  HashMap<String, Integer> tOb;
  private SparseArray<String> tOc;
  SparseArray<Bitmap> tOd;
  protected f<String, Bitmap> tOe;
  protected SparseIntArray tOf;
  private LinkedList<String> tOg;
  d tOh;
  boolean tOi;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.hQF = new be(1, "album-image-gallery-lazy-loader");
    this.tOa = new SparseArray();
    this.tOb = new HashMap();
    this.tOc = new SparseArray();
    this.tOd = new SparseArray();
    this.mScrollState = 0;
    this.tOe = new b(5, new f.b() {}, getClass());
    this.tOf = new SparseIntArray();
    this.tOg = new LinkedList();
    this.tOi = false;
    this.tOh = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void Ht(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.tOc.get(paramInt) != null)
    {
      String str = (String)this.tOc.get(paramInt);
      this.tOa.remove(paramInt);
      this.tOc.remove(paramInt);
      this.tOb.remove(str);
      this.tOd.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(198782);
    this.tOb.put(paramString, Integer.valueOf(paramInt));
    this.tOc.put(paramInt, paramString);
    this.tOa.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(198782);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.tOa.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.tOa.get(paramInt)).get();
    String str = (String)this.tOc.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.tOf.indexOfValue(paramInt);
      if (j >= 0) {
        this.tOf.removeAt(j);
      }
      this.tOf.put(i, paramInt);
    }
    this.tOh.a(localMultiTouchImageView, str, paramBitmap);
    Ht(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void cWg()
  {
    AppMethodBeat.i(111551);
    this.tOe.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  final void Ox()
  {
    AppMethodBeat.i(111555);
    if (this.tOi)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.tOg.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.tOg.removeLast();
    if (!this.tOb.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.tOi = true;
    localObject = new be.a()
    {
      private Bitmap tOk = null;
      
      public final boolean aEm()
      {
        AppMethodBeat.i(111547);
        if ((e.this.tOh == null) || (TextUtils.isEmpty(this.tOl)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        String str = this.tOl;
        long l = bt.HI();
        Bitmap localBitmap = q.ayb(str);
        ad.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bt.aO(l)), str });
        this.tOk = localBitmap;
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(111548);
        e.this.tOi = false;
        int i;
        if (e.this.tOb.containsKey(this.tOl))
        {
          i = ((Integer)e.this.tOb.get(this.tOl)).intValue();
          if (e.this.cWh()) {
            break label115;
          }
          e.this.tOd.put(i, this.tOk);
        }
        for (;;)
        {
          e.this.tOe.q(this.tOl, this.tOk);
          this.tOk = null;
          e.this.Ox();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.tOk);
        }
      }
    };
    this.hQF.c((be.a)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(198783);
    if (this.tOg.contains(paramString))
    {
      AppMethodBeat.o(198783);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    Ht(i);
    a(i, paramMultiTouchImageView, paramString);
    this.tOg.add(paramString);
    Ox();
    AppMethodBeat.o(198783);
  }
  
  final boolean cWh()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.tOh = null;
    this.tOa.clear();
    this.tOd.clear();
    this.tOc.clear();
    this.tOb.clear();
    cWg();
    AppMethodBeat.o(111550);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (cWh())
    {
      int[] arrayOfInt = new int[this.tOd.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.tOd.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.tOd.get(i));
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