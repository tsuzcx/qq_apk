package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements f<c>
{
  private int gpA;
  public Stack<c> gpx;
  public Stack<c> gpy;
  
  public final String[] Dq(String paramString)
  {
    AppMethodBeat.i(9224);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.gpx.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.z.f)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.z.f)localc).hoI.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.hoi.getMd5() + paramString);
      }
    }
    AppMethodBeat.o(9224);
    return arrayOfString;
  }
  
  public final void Ya()
  {
    this.gpA += 1;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9215);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.gpx.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.gwn) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(9215);
      return;
    }
    Object localObject = alI();
    if ((localObject != null) && (!((c)localObject).gwn)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(9215);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9219);
    if (this.gpx != null) {
      this.gpx.push(paramc);
    }
    AppMethodBeat.o(9219);
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9220);
    int i;
    if (paramBoolean)
    {
      if (this.gpx != null)
      {
        i = this.gpx.size();
        AppMethodBeat.o(9220);
        return i;
      }
      AppMethodBeat.o(9220);
      return 0;
    }
    if (this.gpy != null)
    {
      i = this.gpy.size();
      AppMethodBeat.o(9220);
      return i;
    }
    AppMethodBeat.o(9220);
    return 0;
  }
  
  public final void alC()
  {
    AppMethodBeat.i(9214);
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.gpx.size()), Boolean.FALSE });
    this.gpx.clear();
    if (this.gpy != null)
    {
      Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.gpy.size()) });
      this.gpx.addAll(this.gpy);
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.gpx.size()) });
    Iterator localIterator = this.gpx.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).ayu();
    }
    AppMethodBeat.o(9214);
  }
  
  public final c alH()
  {
    AppMethodBeat.i(9217);
    c localc = (c)this.gpx.pop();
    AppMethodBeat.o(9217);
    return localc;
  }
  
  public final c alI()
  {
    AppMethodBeat.i(9218);
    if ((this.gpx != null) && (this.gpx.size() > 0))
    {
      c localc = (c)this.gpx.peek();
      AppMethodBeat.o(9218);
      return localc;
    }
    AppMethodBeat.o(9218);
    return null;
  }
  
  public final ListIterator<c> alJ()
  {
    AppMethodBeat.i(9222);
    ListIterator localListIterator = this.gpx.listIterator(this.gpx.size());
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
    int i = this.gpx.indexOf(paramc);
    this.gpx.remove(i);
    this.gpx.push(paramc);
    AppMethodBeat.o(9221);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(204750);
    if (this.gpx != null) {
      this.gpx.clear();
    }
    AppMethodBeat.o(204750);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(9213);
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.gpx.size()), Boolean.valueOf(paramBoolean) });
    if (this.gpy != null) {
      this.gpy.clear();
    }
    this.gpy = new Stack();
    Iterator localIterator = this.gpx.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.gpy.push(localc.ayz());
    }
    Log.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.gpy.size()) });
    if (paramBoolean)
    {
      this.gpx.clear();
      localIterator = this.gpy.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        Log.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.hoj != null) && (!localc.hoj.isRecycled()))
        {
          Log.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.hoj.toString() });
          localc.hoj.recycle();
        }
      }
    }
    AppMethodBeat.o(9213);
  }
  
  public final int[] dm(boolean paramBoolean)
  {
    AppMethodBeat.i(9223);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.gpx.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.z.f)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.gpy != null)
    {
      localIterator = this.gpy.iterator();
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
    Iterator localIterator = this.gpx.iterator();
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
    this.gpx = new Stack();
    AppMethodBeat.o(9211);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9212);
    Log.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.gpx != null)
    {
      localIterator = this.gpx.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.gpx.clear();
    }
    if (this.gpy != null)
    {
      localIterator = this.gpy.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.gpy.clear();
    }
    AppMethodBeat.o(9212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */