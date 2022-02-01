package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  public Stack<c> fpX;
  public Stack<c> fpY;
  private int fqa;
  
  public final void Mh()
  {
    this.fqa += 1;
  }
  
  public final void Vo()
  {
    AppMethodBeat.i(9214);
    ac.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fpX.size()), Boolean.FALSE });
    this.fpX.clear();
    if (this.fpY != null)
    {
      ac.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fpY.size()) });
      this.fpX.addAll(this.fpY);
    }
    ac.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.fpX.size()) });
    Iterator localIterator = this.fpX.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).afd();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c Vt()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.fpX.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c Vu()
  {
    AppMethodBeat.i(9218);
    if ((this.fpX != null) && (this.fpX.size() > 0))
    {
      c localc = (c)this.fpX.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> Vv()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.fpX.listIterator(this.fpX.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fpX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.fvR) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = Vu();
    if ((localObject != null) && (!((c)localObject).fvR)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.fpX != null) {
      this.fpX.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.fpX != null)
      {
        i = this.fpX.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.fpY != null)
    {
      i = this.fpY.size();
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
    int i = this.fpX.indexOf(paramc);
    this.fpX.remove(i);
    this.fpX.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void cA(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    ac.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fpX.size()), Boolean.valueOf(paramBoolean) });
    if (this.fpY != null) {
      this.fpY.clear();
    }
    this.fpY = new Stack();
    Iterator localIterator = this.fpX.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.fpY.push(localc.afi());
    }
    ac.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.fpY.size()) });
    if (paramBoolean)
    {
      this.fpX.clear();
      localIterator = this.fpY.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ac.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.gfd != null) && (!localc.gfd.isRecycled()))
        {
          ac.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.gfd.toString() });
          localc.gfd.recycle();
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
      localIterator = this.fpX.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.z.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.fpY != null)
    {
      localIterator = this.fpY.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.z.f)) {
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
    Iterator localIterator = this.fpX.iterator();
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
    ac.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.fpX = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    ac.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.fpX != null)
    {
      localIterator = this.fpX.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fpX.clear();
    }
    if (this.fpY != null)
    {
      localIterator = this.fpY.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fpY.clear();
    }
    AppMethodBeat.o(9212);
  }
  
  public final String[] rS(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.fpX.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.z.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.z.f)localc).gfC.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.gfc.JC() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */