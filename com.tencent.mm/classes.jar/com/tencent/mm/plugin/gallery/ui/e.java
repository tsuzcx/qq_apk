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
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private SparseArray<WeakReference<MultiTouchImageView>> HOD;
  HashMap<String, Integer> HOE;
  private SparseArray<String> HOF;
  SparseArray<Bitmap> HOG;
  protected f<String, Bitmap> HOH;
  protected SparseIntArray HOI;
  private LinkedList<String> HOJ;
  d HOK;
  boolean HOL;
  private int mScrollState;
  private QueueWorkerThread owH;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.owH = new QueueWorkerThread(1, "album-image-gallery-lazy-loader");
    this.HOD = new SparseArray();
    this.HOE = new HashMap();
    this.HOF = new SparseArray();
    this.HOG = new SparseArray();
    this.mScrollState = 0;
    this.HOH = new b(5, new f.b() {}, getClass());
    this.HOI = new SparseIntArray();
    this.HOJ = new LinkedList();
    this.HOL = false;
    this.HOK = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void WQ(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.HOF.get(paramInt) != null)
    {
      String str = (String)this.HOF.get(paramInt);
      this.HOD.remove(paramInt);
      this.HOF.remove(paramInt);
      this.HOE.remove(str);
      this.HOG.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(289548);
    this.HOE.put(paramString, Integer.valueOf(paramInt));
    this.HOF.put(paramInt, paramString);
    this.HOD.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(289548);
  }
  
  private void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.HOD.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.HOD.get(paramInt)).get();
    String str = (String)this.HOF.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.HOI.indexOfValue(paramInt);
      if (j >= 0) {
        this.HOI.removeAt(j);
      }
      this.HOI.put(i, paramInt);
    }
    this.HOK.a(localMultiTouchImageView, str, paramBitmap);
    WQ(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void fBF()
  {
    AppMethodBeat.i(111551);
    this.HOH.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(289554);
    if (this.HOJ.contains(paramString))
    {
      AppMethodBeat.o(289554);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    WQ(i);
    a(i, paramMultiTouchImageView, paramString);
    this.HOJ.add(paramString);
    aFi();
    AppMethodBeat.o(289554);
  }
  
  final void aFi()
  {
    AppMethodBeat.i(111555);
    if (this.HOL)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.HOJ.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.HOJ.removeLast();
    if (!this.HOE.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.HOL = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private Bitmap wNk = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(111547);
        if ((e.this.HOK == null) || (TextUtils.isEmpty(this.HON)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        this.wNk = d.aEY(this.HON);
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(111548);
        e.this.HOL = false;
        int i;
        if (e.this.HOE.containsKey(this.HON))
        {
          i = ((Integer)e.this.HOE.get(this.HON)).intValue();
          if (e.this.fBG()) {
            break label115;
          }
          e.this.HOG.put(i, this.wNk);
        }
        for (;;)
        {
          e.this.HOH.B(this.HON, this.wNk);
          this.wNk = null;
          e.this.aFi();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.wNk);
        }
      }
    };
    this.owH.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.HOK = null;
    this.HOD.clear();
    this.HOG.clear();
    this.HOF.clear();
    this.HOE.clear();
    fBF();
    AppMethodBeat.o(111550);
  }
  
  final boolean fBG()
  {
    return this.mScrollState == 0;
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (fBG())
    {
      int[] arrayOfInt = new int[this.HOG.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.HOG.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        e(i, (Bitmap)this.HOG.get(i));
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