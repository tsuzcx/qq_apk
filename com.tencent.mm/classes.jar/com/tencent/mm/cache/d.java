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
  public Stack<c> fIe;
  public Stack<c> fIf;
  private int fIh;
  
  public final void NQ()
  {
    this.fIh += 1;
  }
  
  public final void XF()
  {
    AppMethodBeat.i(9214);
    ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fIe.size()), Boolean.FALSE });
    this.fIe.clear();
    if (this.fIf != null)
    {
      ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fIf.size()) });
      this.fIe.addAll(this.fIf);
    }
    ad.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.fIe.size()) });
    Iterator localIterator = this.fIe.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).ahP();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c XK()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.fIe.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c XL()
  {
    AppMethodBeat.i(9218);
    if ((this.fIe != null) && (this.fIe.size() > 0))
    {
      c localc = (c)this.fIe.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> XM()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.fIe.listIterator(this.fIe.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fIe.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.fOY) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = XL();
    if ((localObject != null) && (!((c)localObject).fOY)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.fIe != null) {
      this.fIe.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.fIe != null)
      {
        i = this.fIe.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.fIf != null)
    {
      i = this.fIf.size();
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
    int i = this.fIe.indexOf(paramc);
    this.fIe.remove(i);
    this.fIe.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    ad.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fIe.size()), Boolean.valueOf(paramBoolean) });
    if (this.fIf != null) {
      this.fIf.clear();
    }
    this.fIf = new Stack();
    Iterator localIterator = this.fIe.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.fIf.push(localc.ahU());
    }
    ad.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.fIf.size()) });
    if (paramBoolean)
    {
      this.fIe.clear();
      localIterator = this.fIf.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ad.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.gyN != null) && (!localc.gyN.isRecycled()))
        {
          ad.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.gyN.toString() });
          localc.gyN.recycle();
        }
      }
    }
    AppMethodBeat.o(9213);
  }
  
  public final int[] cD(boolean paramBoolean)
  {
    AppMethodBeat.i(9223);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.fIe.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.aa.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.fIf != null)
    {
      localIterator = this.fIf.iterator();
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
    Iterator localIterator = this.fIe.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.setSelected(false);
      localc.draw(paramCanvas);
    }
    AppMethodBeat.o(9216);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9211);
    ad.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.fIe = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    ad.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.fIe != null)
    {
      localIterator = this.fIe.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fIe.clear();
    }
    if (this.fIf != null)
    {
      localIterator = this.fIf.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fIf.clear();
    }
    AppMethodBeat.o(9212);
  }
  
  public final String[] uF(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.fIe.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.aa.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.aa.f)localc).gzm.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.gyM.Lb() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */