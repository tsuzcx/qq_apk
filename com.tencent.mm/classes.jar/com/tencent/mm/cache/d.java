package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  public Stack<c> fKi;
  public Stack<c> fKj;
  private int fKl;
  
  public final void NO()
  {
    this.fKl += 1;
  }
  
  public final void XP()
  {
    AppMethodBeat.i(9214);
    ae.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fKi.size()), Boolean.FALSE });
    this.fKi.clear();
    if (this.fKj != null)
    {
      ae.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.fKj.size()) });
      this.fKi.addAll(this.fKj);
    }
    ae.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.fKi.size()) });
    Iterator localIterator = this.fKi.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).aie();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c XU()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.fKi.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c XV()
  {
    AppMethodBeat.i(9218);
    if ((this.fKi != null) && (this.fKi.size() > 0))
    {
      c localc = (c)this.fKi.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> XW()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.fKi.listIterator(this.fKi.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.fKi.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.fRe) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = XV();
    if ((localObject != null) && (!((c)localObject).fRe)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.fKi != null) {
      this.fKi.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final int aj(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.fKi != null)
      {
        i = this.fKi.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.fKj != null)
    {
      i = this.fKj.size();
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
    int i = this.fKi.indexOf(paramc);
    this.fKi.remove(i);
    this.fKi.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void cC(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    ae.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.fKi.size()), Boolean.valueOf(paramBoolean) });
    if (this.fKj != null) {
      this.fKj.clear();
    }
    this.fKj = new Stack();
    Iterator localIterator = this.fKi.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.fKj.push(localc.aij());
    }
    ae.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.fKj.size()) });
    if (paramBoolean)
    {
      this.fKi.clear();
      localIterator = this.fKj.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ae.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.gBu != null) && (!localc.gBu.isRecycled()))
        {
          ae.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.gBu.toString() });
          localc.gBu.recycle();
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
      localIterator = this.fKi.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.z.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.fKj != null)
    {
      localIterator = this.fKj.iterator();
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
    Iterator localIterator = this.fKi.iterator();
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
    ae.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.fKi = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    ae.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.fKi != null)
    {
      localIterator = this.fKi.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fKi.clear();
    }
    if (this.fKj != null)
    {
      localIterator = this.fKj.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.fKj.clear();
    }
    AppMethodBeat.o(9212);
  }
  
  public final String[] va(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.fKi.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.z.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.z.f)localc).gBT.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.gBt.Lj() + paramString);
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