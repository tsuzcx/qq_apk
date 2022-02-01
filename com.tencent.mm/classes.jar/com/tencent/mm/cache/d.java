package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  public Stack<c> fmC;
  public Stack<c> fmD;
  private int fmF;
  
  public final void Mj()
  {
    this.fmF += 1;
  }
  
  public final ListIterator<c> UA()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.fmC.listIterator(this.fmC.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void Ut()
  {
    AppMethodBeat.i(9214);
    ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fmC.size()), Boolean.FALSE });
    this.fmC.clear();
    if (this.fmD != null)
    {
      ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fmD.size()) });
      this.fmC.addAll(this.fmD);
    }
    ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.fmC.size()) });
    Iterator localIterator = this.fmC.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).adN();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c Uy()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.fmC.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c Uz()
  {
    AppMethodBeat.i(9218);
    if ((this.fmC != null) && (this.fmC.size() > 0))
    {
      c localc = (c)this.fmC.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fmC.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.fsk) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = Uz();
    if ((localObject != null) && (!((c)localObject).fsk)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.fmC != null) {
      this.fmC.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.fmC != null)
      {
        i = this.fmC.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.fmD != null)
    {
      i = this.fmD.size();
      AppMethodBeat.o(9220);
      return i;
    }
    AppMethodBeat.o(9220);
    return 0;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(9221);
    if (paramc == null)
    {
      AppMethodBeat.o(9221);
      return;
    }
    int i = this.fmC.indexOf(paramc);
    this.fmC.remove(i);
    this.fmC.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    ad.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fmC.size()), Boolean.valueOf(paramBoolean) });
    if (this.fmD != null) {
      this.fmD.clear();
    }
    this.fmD = new Stack();
    Iterator localIterator = this.fmC.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.fmD.push(localc.adS());
    }
    ad.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.fmD.size()) });
    if (paramBoolean)
    {
      this.fmC.clear();
      localIterator = this.fmD.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.gax != null) && (!localc.gax.isRecycled()))
        {
          ad.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.gax.toString() });
          localc.gax.recycle();
        }
      }
    }
    AppMethodBeat.o(9213);
  }
  
  public final int[] cB(boolean paramBoolean)
  {
    AppMethodBeat.i(9223);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.fmC.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.aa.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.fmD != null)
    {
      localIterator = this.fmD.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.aa.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    AppMethodBeat.o(9223);
    return arrayOfInt;
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9216);
    Iterator localIterator = this.fmC.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.setSelected(false);
      localc.draw(paramCanvas);
    }
    AppMethodBeat.o(9216);
  }
  
  public final String[] oJ(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.fmC.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.aa.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.aa.f)localc).gaW.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.gaw.JS() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9211);
    ad.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.fmC = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    ad.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.fmC != null)
    {
      localIterator = this.fmC.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fmC.clear();
    }
    if (this.fmD != null)
    {
      localIterator = this.fmD.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fmD.clear();
    }
    AppMethodBeat.o(9212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */