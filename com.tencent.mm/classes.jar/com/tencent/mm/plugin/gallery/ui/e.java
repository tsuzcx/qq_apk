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
  private be gXM;
  private int mScrollState;
  private SparseArray<WeakReference<MultiTouchImageView>> rJH;
  HashMap<String, Integer> rJI;
  private SparseArray<String> rJJ;
  SparseArray<Bitmap> rJK;
  protected f<String, Bitmap> rJL;
  protected SparseIntArray rJM;
  private LinkedList<String> rJN;
  d rJO;
  boolean rJP;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.gXM = new be(1, "album-image-gallery-lazy-loader");
    this.rJH = new SparseArray();
    this.rJI = new HashMap();
    this.rJJ = new SparseArray();
    this.rJK = new SparseArray();
    this.mScrollState = 0;
    this.rJL = new b(5, new f.b() {}, getClass());
    this.rJM = new SparseIntArray();
    this.rJN = new LinkedList();
    this.rJP = false;
    this.rJO = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void Ei(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.rJJ.get(paramInt) != null)
    {
      String str = (String)this.rJJ.get(paramInt);
      this.rJH.remove(paramInt);
      this.rJJ.remove(paramInt);
      this.rJI.remove(str);
      this.rJK.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(186730);
    this.rJI.put(paramString, Integer.valueOf(paramInt));
    this.rJJ.put(paramInt, paramString);
    this.rJH.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(186730);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.rJH.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.rJH.get(paramInt)).get();
    String str = (String)this.rJJ.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.rJM.indexOfValue(paramInt);
      if (j >= 0) {
        this.rJM.removeAt(j);
      }
      this.rJM.put(i, paramInt);
    }
    this.rJO.a(localMultiTouchImageView, str, paramBitmap);
    Ei(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void cAE()
  {
    AppMethodBeat.i(111551);
    this.rJL.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  final void MQ()
  {
    AppMethodBeat.i(111555);
    if (this.rJP)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.rJN.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.rJN.removeLast();
    if (!this.rJI.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.rJP = true;
    localObject = new be.a()
    {
      private Bitmap rJR = null;
      
      public final boolean aus()
      {
        AppMethodBeat.i(111547);
        if ((e.this.rJO == null) || (TextUtils.isEmpty(this.rJS)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        String str = this.rJS;
        long l = bt.GC();
        Bitmap localBitmap = q.anK(str);
        ad.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bt.aS(l)), str });
        this.rJR = localBitmap;
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(111548);
        e.this.rJP = false;
        int i;
        if (e.this.rJI.containsKey(this.rJS))
        {
          i = ((Integer)e.this.rJI.get(this.rJS)).intValue();
          if (e.this.cAF()) {
            break label115;
          }
          e.this.rJK.put(i, this.rJR);
        }
        for (;;)
        {
          e.this.rJL.o(this.rJS, this.rJR);
          this.rJR = null;
          e.this.MQ();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.rJR);
        }
      }
    };
    this.gXM.c((be.a)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(186731);
    if (this.rJN.contains(paramString))
    {
      AppMethodBeat.o(186731);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    Ei(i);
    a(i, paramMultiTouchImageView, paramString);
    this.rJN.add(paramString);
    MQ();
    AppMethodBeat.o(186731);
  }
  
  final boolean cAF()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.rJO = null;
    this.rJH.clear();
    this.rJK.clear();
    this.rJJ.clear();
    this.rJI.clear();
    cAE();
    AppMethodBeat.o(111550);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (cAF())
    {
      int[] arrayOfInt = new int[this.rJK.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.rJK.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.rJK.get(i));
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