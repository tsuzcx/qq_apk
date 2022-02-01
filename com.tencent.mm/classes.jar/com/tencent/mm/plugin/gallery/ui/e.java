package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private SparseArray<WeakReference<MultiTouchImageView>> CcA;
  HashMap<String, Integer> CcB;
  private SparseArray<String> CcC;
  SparseArray<Bitmap> CcD;
  protected f<String, Bitmap> CcE;
  protected SparseIntArray CcF;
  private LinkedList<String> CcG;
  d CcH;
  boolean CcI;
  private QueueWorkerThread lFb;
  private int mScrollState;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.lFb = new QueueWorkerThread(1, "album-image-gallery-lazy-loader");
    this.CcA = new SparseArray();
    this.CcB = new HashMap();
    this.CcC = new SparseArray();
    this.CcD = new SparseArray();
    this.mScrollState = 0;
    this.CcE = new b(5, new e.1(this), getClass());
    this.CcF = new SparseIntArray();
    this.CcG = new LinkedList();
    this.CcI = false;
    this.CcH = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void Ti(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.CcC.get(paramInt) != null)
    {
      String str = (String)this.CcC.get(paramInt);
      this.CcA.remove(paramInt);
      this.CcC.remove(paramInt);
      this.CcB.remove(str);
      this.CcD.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(241683);
    this.CcB.put(paramString, Integer.valueOf(paramInt));
    this.CcC.put(paramInt, paramString);
    this.CcA.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(241683);
  }
  
  private void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.CcA.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.CcA.get(paramInt)).get();
    String str = (String)this.CcC.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.CcF.indexOfValue(paramInt);
      if (j >= 0) {
        this.CcF.removeAt(j);
      }
      this.CcF.put(i, paramInt);
    }
    this.CcH.a(localMultiTouchImageView, str, paramBitmap);
    Ti(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void euK()
  {
    AppMethodBeat.i(111551);
    this.CcE.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(241686);
    if (this.CcG.contains(paramString))
    {
      AppMethodBeat.o(241686);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    Ti(i);
    a(i, paramMultiTouchImageView, paramString);
    this.CcG.add(paramString);
    adj();
    AppMethodBeat.o(241686);
  }
  
  final void adj()
  {
    AppMethodBeat.i(111555);
    if (this.CcI)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.CcG.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.CcG.removeLast();
    if (!this.CcB.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.CcI = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private Bitmap tJN = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(111547);
        if ((e.this.CcH == null) || (TextUtils.isEmpty(this.CcK)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        this.tJN = d.aIz(this.CcK);
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(111548);
        e.this.CcI = false;
        int i;
        if (e.this.CcB.containsKey(this.CcK))
        {
          i = ((Integer)e.this.CcB.get(this.CcK)).intValue();
          if (e.this.euL()) {
            break label115;
          }
          e.this.CcD.put(i, this.tJN);
        }
        for (;;)
        {
          e.this.CcE.q(this.CcK, this.tJN);
          this.tJN = null;
          e.this.adj();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.tJN);
        }
      }
    };
    this.lFb.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.CcH = null;
    this.CcA.clear();
    this.CcD.clear();
    this.CcC.clear();
    this.CcB.clear();
    euK();
    AppMethodBeat.o(111550);
  }
  
  final boolean euL()
  {
    return this.mScrollState == 0;
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (euL())
    {
      int[] arrayOfInt = new int[this.CcD.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.CcD.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        c(i, (Bitmap)this.CcD.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(111552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */