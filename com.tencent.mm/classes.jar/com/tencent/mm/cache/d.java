package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.c;
import com.tencent.mm.api.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  public Stack<c> lvL;
  public Stack<c> lvM;
  private int lvO;
  
  public final String[] CN(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.lvL.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.ab.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.ab.f)localc).mAC.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.mAc.getMd5() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.lvL != null) {
      this.lvL.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final void aEG()
  {
    this.lvO += 1;
  }
  
  public final c aLC()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.lvL.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c aLD()
  {
    AppMethodBeat.i(9218);
    if ((this.lvL != null) && (this.lvL.size() > 0))
    {
      c localc = (c)this.lvL.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> aLE()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.lvL.listIterator(this.lvL.size());
    AppMethodBeat.o(9222);
    return localListIterator;
  }
  
  public final void aLx()
  {
    AppMethodBeat.i(9214);
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.lvL.size()), Boolean.FALSE });
    this.lvL.clear();
    if (this.lvM != null)
    {
      Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.lvM.size()) });
      this.lvL.addAll(this.lvM);
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.lvL.size()) });
    Iterator localIterator = this.lvL.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).aYN();
    }
    AppMethodBeat.o(9214);
  }
  
  public final int aR(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.lvL != null)
      {
        i = this.lvL.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.lvM != null)
    {
      i = this.lvM.size();
      AppMethodBeat.o(9220);
      return i;
    }
    AppMethodBeat.o(9220);
    return 0;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.lvL.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.lCv) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = aLD();
    if ((localObject != null) && (!((c)localObject).lCv)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(9221);
    if (paramc == null)
    {
      AppMethodBeat.o(9221);
      return;
    }
    int i = this.lvL.indexOf(paramc);
    this.lvL.remove(i);
    this.lvL.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(232065);
    if (this.lvL != null) {
      this.lvL.clear();
    }
    AppMethodBeat.o(232065);
  }
  
  public final void ex(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.lvL.size()), Boolean.valueOf(paramBoolean) });
    if (this.lvM != null) {
      this.lvM.clear();
    }
    this.lvM = new Stack();
    Iterator localIterator = this.lvL.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.lvM.push(localc.aYS());
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.lvM.size()) });
    if (paramBoolean)
    {
      this.lvL.clear();
      localIterator = this.lvM.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        Log.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.mAd != null) && (!localc.mAd.isRecycled()))
        {
          Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.mAd.toString() });
          localc.mAd.recycle();
        }
      }
    }
    AppMethodBeat.o(9213);
  }
  
  public final int[] ey(boolean paramBoolean)
  {
    AppMethodBeat.i(9223);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.lvL.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.ab.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.lvM != null)
    {
      localIterator = this.lvM.iterator();
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
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(9216);
    Iterator localIterator = this.lvL.iterator();
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
    this.lvL = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    Log.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.lvL != null)
    {
      localIterator = this.lvL.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.lvL.clear();
    }
    if (this.lvM != null)
    {
      localIterator = this.lvM.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.lvM.clear();
    }
    AppMethodBeat.o(9212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */