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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private bd hyl;
  private int mScrollState;
  protected f<String, Bitmap> sRA;
  protected SparseIntArray sRB;
  private LinkedList<String> sRC;
  d sRD;
  boolean sRE;
  private SparseArray<WeakReference<MultiTouchImageView>> sRw;
  HashMap<String, Integer> sRx;
  private SparseArray<String> sRy;
  SparseArray<Bitmap> sRz;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.hyl = new bd(1, "album-image-gallery-lazy-loader");
    this.sRw = new SparseArray();
    this.sRx = new HashMap();
    this.sRy = new SparseArray();
    this.sRz = new SparseArray();
    this.mScrollState = 0;
    this.sRA = new b(5, new f.b() {}, getClass());
    this.sRB = new SparseIntArray();
    this.sRC = new LinkedList();
    this.sRE = false;
    this.sRD = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void Ge(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.sRy.get(paramInt) != null)
    {
      String str = (String)this.sRy.get(paramInt);
      this.sRw.remove(paramInt);
      this.sRy.remove(paramInt);
      this.sRx.remove(str);
      this.sRz.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(198424);
    this.sRx.put(paramString, Integer.valueOf(paramInt));
    this.sRy.put(paramInt, paramString);
    this.sRw.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(198424);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.sRw.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.sRw.get(paramInt)).get();
    String str = (String)this.sRy.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.sRB.indexOfValue(paramInt);
      if (j >= 0) {
        this.sRB.removeAt(j);
      }
      this.sRB.put(i, paramInt);
    }
    this.sRD.a(localMultiTouchImageView, str, paramBitmap);
    Ge(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void cNO()
  {
    AppMethodBeat.i(111551);
    this.sRA.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  final void MO()
  {
    AppMethodBeat.i(111555);
    if (this.sRE)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.sRC.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.sRC.removeLast();
    if (!this.sRx.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.sRE = true;
    localObject = new bd.a()
    {
      private Bitmap sRG = null;
      
      public final boolean aBj()
      {
        AppMethodBeat.i(111547);
        if ((e.this.sRD == null) || (TextUtils.isEmpty(this.sRH)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        String str = this.sRH;
        long l = bs.Gn();
        Bitmap localBitmap = q.asW(str);
        ac.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(bs.aO(l)), str });
        this.sRG = localBitmap;
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(111548);
        e.this.sRE = false;
        int i;
        if (e.this.sRx.containsKey(this.sRH))
        {
          i = ((Integer)e.this.sRx.get(this.sRH)).intValue();
          if (e.this.cNP()) {
            break label115;
          }
          e.this.sRz.put(i, this.sRG);
        }
        for (;;)
        {
          e.this.sRA.o(this.sRH, this.sRG);
          this.sRG = null;
          e.this.MO();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.sRG);
        }
      }
    };
    this.hyl.c((bd.a)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(198425);
    if (this.sRC.contains(paramString))
    {
      AppMethodBeat.o(198425);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    Ge(i);
    a(i, paramMultiTouchImageView, paramString);
    this.sRC.add(paramString);
    MO();
    AppMethodBeat.o(198425);
  }
  
  final boolean cNP()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.sRD = null;
    this.sRw.clear();
    this.sRz.clear();
    this.sRy.clear();
    this.sRx.clear();
    cNO();
    AppMethodBeat.o(111550);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (cNP())
    {
      int[] arrayOfInt = new int[this.sRz.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.sRz.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.sRz.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(111552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */