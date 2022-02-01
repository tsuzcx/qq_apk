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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class e
{
  private QueueWorkerThread iOL;
  private int mScrollState;
  private SparseArray<WeakReference<MultiTouchImageView>> xqf;
  HashMap<String, Integer> xqg;
  private SparseArray<String> xqh;
  SparseArray<Bitmap> xqi;
  protected f<String, Bitmap> xqj;
  protected SparseIntArray xqk;
  private LinkedList<String> xql;
  d xqm;
  boolean xqn;
  
  public e(d paramd)
  {
    AppMethodBeat.i(111549);
    this.iOL = new QueueWorkerThread(1, "album-image-gallery-lazy-loader");
    this.xqf = new SparseArray();
    this.xqg = new HashMap();
    this.xqh = new SparseArray();
    this.xqi = new SparseArray();
    this.mScrollState = 0;
    this.xqj = new b(5, new f.b() {}, getClass());
    this.xqk = new SparseIntArray();
    this.xql = new LinkedList();
    this.xqn = false;
    this.xqm = paramd;
    AppMethodBeat.o(111549);
  }
  
  private void NT(int paramInt)
  {
    AppMethodBeat.i(111553);
    if (this.xqh.get(paramInt) != null)
    {
      String str = (String)this.xqh.get(paramInt);
      this.xqf.remove(paramInt);
      this.xqh.remove(paramInt);
      this.xqg.remove(str);
      this.xqi.remove(paramInt);
    }
    AppMethodBeat.o(111553);
  }
  
  private void a(int paramInt, MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(257752);
    this.xqg.put(paramString, Integer.valueOf(paramInt));
    this.xqh.put(paramInt, paramString);
    this.xqf.put(paramInt, new WeakReference(paramMultiTouchImageView));
    AppMethodBeat.o(257752);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111554);
    if (this.xqf.get(paramInt) == null)
    {
      AppMethodBeat.o(111554);
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.xqf.get(paramInt)).get();
    String str = (String)this.xqh.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.xqk.indexOfValue(paramInt);
      if (j >= 0) {
        this.xqk.removeAt(j);
      }
      this.xqk.put(i, paramInt);
    }
    this.xqm.a(localMultiTouchImageView, str, paramBitmap);
    NT(paramInt);
    AppMethodBeat.o(111554);
  }
  
  private void dSj()
  {
    AppMethodBeat.i(111551);
    this.xqj.a(new f.a() {});
    AppMethodBeat.o(111551);
  }
  
  final void YC()
  {
    AppMethodBeat.i(111555);
    if (this.xqn)
    {
      AppMethodBeat.o(111555);
      return;
    }
    if (this.xql.size() == 0)
    {
      AppMethodBeat.o(111555);
      return;
    }
    Object localObject = (String)this.xql.removeLast();
    if (!this.xqg.containsKey(localObject))
    {
      AppMethodBeat.o(111555);
      return;
    }
    this.xqn = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private Bitmap xqp = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(111547);
        if ((e.this.xqm == null) || (TextUtils.isEmpty(this.xqq)))
        {
          AppMethodBeat.o(111547);
          return false;
        }
        String str = this.xqq;
        long l = Util.currentTicks();
        Bitmap localBitmap = r.aOp(str);
        Log.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), str });
        this.xqp = localBitmap;
        AppMethodBeat.o(111547);
        return true;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(111548);
        e.this.xqn = false;
        int i;
        if (e.this.xqg.containsKey(this.xqq))
        {
          i = ((Integer)e.this.xqg.get(this.xqq)).intValue();
          if (e.this.dSk()) {
            break label115;
          }
          e.this.xqi.put(i, this.xqp);
        }
        for (;;)
        {
          e.this.xqj.x(this.xqq, this.xqp);
          this.xqp = null;
          e.this.YC();
          AppMethodBeat.o(111548);
          return false;
          label115:
          e.a(e.this, i, this.xqp);
        }
      }
    };
    this.iOL.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(111555);
  }
  
  public final void a(MultiTouchImageView paramMultiTouchImageView, String paramString)
  {
    AppMethodBeat.i(257753);
    if (this.xql.contains(paramString))
    {
      AppMethodBeat.o(257753);
      return;
    }
    int i = paramMultiTouchImageView.hashCode();
    NT(i);
    a(i, paramMultiTouchImageView, paramString);
    this.xql.add(paramString);
    YC();
    AppMethodBeat.o(257753);
  }
  
  final boolean dSk()
  {
    return this.mScrollState == 0;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(111550);
    this.xqm = null;
    this.xqf.clear();
    this.xqi.clear();
    this.xqh.clear();
    this.xqg.clear();
    dSj();
    AppMethodBeat.o(111550);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(111552);
    this.mScrollState = paramInt;
    if (dSk())
    {
      int[] arrayOfInt = new int[this.xqi.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.xqi.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.xqi.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(111552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.e
 * JD-Core Version:    0.7.0.1
 */