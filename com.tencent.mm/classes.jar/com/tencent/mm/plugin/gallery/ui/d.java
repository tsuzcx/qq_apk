package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d
{
  private az fwL;
  private int mScrollState;
  SparseArray<WeakReference<MultiTouchImageView>> nfN;
  HashMap<String, Integer> nfO;
  SparseArray<String> nfP;
  SparseArray<Bitmap> nfQ;
  protected f<String, Bitmap> nfR;
  protected SparseIntArray nfS;
  LinkedList<String> nfT;
  c nfU;
  boolean nfV;
  
  public d(c paramc)
  {
    AppMethodBeat.i(21488);
    this.fwL = new az(1, "album-image-gallery-lazy-loader");
    this.nfN = new SparseArray();
    this.nfO = new HashMap();
    this.nfP = new SparseArray();
    this.nfQ = new SparseArray();
    this.mScrollState = 0;
    this.nfR = new b(5, new f.b() {}, getClass());
    this.nfS = new SparseIntArray();
    this.nfT = new LinkedList();
    this.nfV = false;
    this.nfU = paramc;
    AppMethodBeat.o(21488);
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(21493);
    if (this.nfN.get(paramInt) == null)
    {
      AppMethodBeat.o(21493);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.nfN.get(paramInt)).get();
    String str = (String)this.nfP.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.nfS.indexOfValue(paramInt);
      if (j >= 0) {
        this.nfS.removeAt(j);
      }
      this.nfS.put(i, paramInt);
    }
    this.nfU.a(localMultiTouchImageView, str, paramBitmap);
    wW(paramInt);
    AppMethodBeat.o(21493);
  }
  
  private void bEy()
  {
    AppMethodBeat.i(21490);
    this.nfR.a(new d.2(this));
    AppMethodBeat.o(21490);
  }
  
  final void Dh()
  {
    AppMethodBeat.i(21494);
    if (this.nfV)
    {
      AppMethodBeat.o(21494);
      return;
    }
    if (this.nfT.size() == 0)
    {
      AppMethodBeat.o(21494);
      return;
    }
    Object localObject = (String)this.nfT.removeLast();
    if (!this.nfO.containsKey(localObject))
    {
      AppMethodBeat.o(21494);
      return;
    }
    this.nfV = true;
    localObject = new d.3(this, (String)localObject);
    this.fwL.e((az.a)localObject);
    AppMethodBeat.o(21494);
  }
  
  final boolean bEz()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(21489);
    this.nfU = null;
    this.nfN.clear();
    this.nfQ.clear();
    this.nfP.clear();
    this.nfO.clear();
    bEy();
    AppMethodBeat.o(21489);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(21491);
    this.mScrollState = paramInt;
    if (bEz())
    {
      int[] arrayOfInt = new int[this.nfQ.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.nfQ.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        a(i, (Bitmap)this.nfQ.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(21491);
  }
  
  final void wW(int paramInt)
  {
    AppMethodBeat.i(21492);
    if (this.nfP.get(paramInt) != null)
    {
      String str = (String)this.nfP.get(paramInt);
      this.nfN.remove(paramInt);
      this.nfP.remove(paramInt);
      this.nfO.remove(str);
      this.nfQ.remove(paramInt);
    }
    AppMethodBeat.o(21492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */