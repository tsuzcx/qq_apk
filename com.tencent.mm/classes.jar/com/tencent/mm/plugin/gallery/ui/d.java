package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.TextView;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

final class d
{
  private av egH = new av(1, "album-image-gallery-lazy-loader");
  SparseArray<WeakReference<MultiTouchImageView>> kJp = new SparseArray();
  HashMap<String, Integer> kJq = new HashMap();
  SparseArray<String> kJr = new SparseArray();
  SparseArray<Bitmap> kJs = new SparseArray();
  protected f<String, Bitmap> kJt = new f(5, new d.1(this));
  protected SparseIntArray kJu = new SparseIntArray();
  LinkedList<String> kJv = new LinkedList();
  c kJw;
  boolean kJx = false;
  private int lf = 0;
  
  public d(c paramc)
  {
    this.kJw = paramc;
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    if (this.kJp.get(paramInt) == null) {
      return;
    }
    MultiTouchImageView localMultiTouchImageView = (MultiTouchImageView)((WeakReference)this.kJp.get(paramInt)).get();
    String str = (String)this.kJr.get(paramInt);
    if ((paramBitmap != null) && (localMultiTouchImageView != null))
    {
      int i = paramBitmap.hashCode();
      int j = this.kJu.indexOfValue(paramInt);
      if (j >= 0) {
        this.kJu.removeAt(j);
      }
      this.kJu.put(i, paramInt);
    }
    this.kJw.kIX.remove(str);
    TextView localTextView;
    if (localMultiTouchImageView != null)
    {
      localTextView = (TextView)localMultiTouchImageView.getTag();
      if (paramBitmap == null) {
        break label147;
      }
      c.a(localMultiTouchImageView, paramBitmap);
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      sa(paramInt);
      return;
      label147:
      if (localTextView != null)
      {
        localTextView.setText(str);
        localTextView.setVisibility(0);
      }
    }
  }
  
  public final void Q(int paramInt)
  {
    int j = 0;
    this.lf = paramInt;
    if (aXR())
    {
      int[] arrayOfInt = new int[this.kJs.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.kJs.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        a(i, (Bitmap)this.kJs.get(i));
        paramInt += 1;
      }
    }
  }
  
  final void aXQ()
  {
    this.kJt.a(new d.2(this));
  }
  
  final boolean aXR()
  {
    return this.lf == 0;
  }
  
  final void ahX()
  {
    if (this.kJx) {}
    do
    {
      do
      {
        return;
      } while (this.kJv.size() == 0);
      localObject = (String)this.kJv.removeLast();
    } while (!this.kJq.containsKey(localObject));
    this.kJx = true;
    Object localObject = new d.3(this, (String)localObject);
    this.egH.c((av.a)localObject);
  }
  
  final void sa(int paramInt)
  {
    if (this.kJr.get(paramInt) != null)
    {
      String str = (String)this.kJr.get(paramInt);
      this.kJp.remove(paramInt);
      this.kJr.remove(paramInt);
      this.kJq.remove(str);
      this.kJs.remove(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.d
 * JD-Core Version:    0.7.0.1
 */