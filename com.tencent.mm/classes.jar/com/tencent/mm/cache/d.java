package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.c;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  public Stack<c> iTF;
  public Stack<c> iTG;
  private int iTI;
  
  public final String[] Kh(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.iTF.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.ab.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.ab.f)localc).kaz.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.jZZ.getMd5() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.iTF.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.jaA) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = arH();
    if ((localObject != null) && (!((c)localObject).jaA)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.iTF != null) {
      this.iTF.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final void acG()
  {
    this.iTI += 1;
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.iTF != null)
      {
        i = this.iTF.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.iTG != null)
    {
      i = this.iTG.size();
      AppMethodBeat.o(9220);
      return i;
    }
    AppMethodBeat.o(9220);
    return 0;
  }
  
  public final void arB()
  {
    AppMethodBeat.i(9214);
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.iTF.size()), Boolean.FALSE });
    this.iTF.clear();
    if (this.iTG != null)
    {
      Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.iTG.size()) });
      this.iTF.addAll(this.iTG);
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.iTF.size()) });
    Iterator localIterator = this.iTF.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).aFN();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c arG()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.iTF.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c arH()
  {
    AppMethodBeat.i(9218);
    if ((this.iTF != null) && (this.iTF.size() > 0))
    {
      c localc = (c)this.iTF.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> arI()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.iTF.listIterator(this.iTF.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(9221);
    if (paramc == null)
    {
      AppMethodBeat.o(9221);
      return;
    }
    int i = this.iTF.indexOf(paramc);
    this.iTF.remove(i);
    this.iTF.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(260025);
    if (this.iTF != null) {
      this.iTF.clear();
    }
    AppMethodBeat.o(260025);
  }
  
  public final void dL(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.iTF.size()), Boolean.valueOf(paramBoolean) });
    if (this.iTG != null) {
      this.iTG.clear();
    }
    this.iTG = new Stack();
    Iterator localIterator = this.iTF.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.iTG.push(localc.aFS());
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.iTG.size()) });
    if (paramBoolean)
    {
      this.iTF.clear();
      localIterator = this.iTG.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        Log.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.kaa != null) && (!localc.kaa.isRecycled()))
        {
          Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.kaa.toString() });
          localc.kaa.recycle();
        }
      }
    }
    AppMethodBeat.o(9213);
  }
  
  public final int[] dM(boolean paramBoolean)
  {
    AppMethodBeat.i(9223);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.iTF.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.ab.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.iTG != null)
    {
      localIterator = this.iTG.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.ab.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    AppMethodBeat.o(9223);
    return arrayOfInt;
  }
  
  public final void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(9216);
    Iterator localIterator = this.iTF.iterator();
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
    Log.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.iTF = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    Log.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.iTF != null)
    {
      localIterator = this.iTF.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.iTF.clear();
    }
    if (this.iTG != null)
    {
      localIterator = this.iTG.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.iTG.clear();
    }
    AppMethodBeat.o(9212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */