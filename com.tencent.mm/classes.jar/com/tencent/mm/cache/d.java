package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class d
  implements e<c>
{
  public Stack<c> ecq;
  public Stack<c> ecr;
  private int ect;
  
  public final void CH()
  {
    this.ect += 1;
  }
  
  public final void Jd()
  {
    AppMethodBeat.i(116238);
    ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", new Object[] { Integer.valueOf(this.ecq.size()), Boolean.FALSE });
    this.ecq.clear();
    if (this.ecr != null)
    {
      ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.ecr.size()) });
      this.ecq.addAll(this.ecr);
    }
    ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", new Object[] { Integer.valueOf(this.ecq.size()) });
    Iterator localIterator = this.ecq.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).Qb();
    }
    AppMethodBeat.o(116238);
  }
  
  public final c Ji()
  {
    AppMethodBeat.i(116241);
    c localc = (c)this.ecq.pop();
    AppMethodBeat.o(116241);
    return localc;
  }
  
  public final c Jj()
  {
    AppMethodBeat.i(116242);
    if ((this.ecq != null) && (this.ecq.size() > 0))
    {
      c localc = (c)this.ecq.peek();
      AppMethodBeat.o(116242);
      return localc;
    }
    AppMethodBeat.o(116242);
    return null;
  }
  
  public final ListIterator<c> Jk()
  {
    AppMethodBeat.i(116246);
    ListIterator localListIterator = this.ecq.listIterator(this.ecq.size());
    AppMethodBeat.o(116246);
    return localListIterator;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(116239);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.ecq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (!localc.egy) {
          localc.draw(paramCanvas);
        }
      }
      AppMethodBeat.o(116239);
      return;
    }
    Object localObject = Jj();
    if ((localObject != null) && (!((c)localObject).egy)) {
      ((c)localObject).draw(paramCanvas);
    }
    AppMethodBeat.o(116239);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(116243);
    if (this.ecq != null) {
      this.ecq.push(paramc);
    }
    AppMethodBeat.o(116243);
  }
  
  public final int ad(boolean paramBoolean)
  {
    AppMethodBeat.i(116244);
    int i;
    if (paramBoolean)
    {
      if (this.ecq != null)
      {
        i = this.ecq.size();
        AppMethodBeat.o(116244);
        return i;
      }
      AppMethodBeat.o(116244);
      return 0;
    }
    if (this.ecr != null)
    {
      i = this.ecr.size();
      AppMethodBeat.o(116244);
      return i;
    }
    AppMethodBeat.o(116244);
    return 0;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(116245);
    if (paramc == null)
    {
      AppMethodBeat.o(116245);
      return;
    }
    int i = this.ecq.indexOf(paramc);
    this.ecq.remove(i);
    this.ecq.push(paramc);
    AppMethodBeat.o(116245);
  }
  
  public final void bH(boolean paramBoolean)
  {
    AppMethodBeat.i(116237);
    ab.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", new Object[] { Integer.valueOf(this.ecq.size()), Boolean.valueOf(paramBoolean) });
    if (this.ecr != null) {
      this.ecr.clear();
    }
    this.ecr = new Stack();
    Iterator localIterator = this.ecq.iterator();
    c localc;
    while (localIterator.hasNext())
    {
      localc = (c)localIterator.next();
      this.ecr.push(localc.Qg());
    }
    ab.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", new Object[] { Integer.valueOf(this.ecr.size()) });
    if (paramBoolean)
    {
      this.ecq.clear();
      localIterator = this.ecr.iterator();
      while (localIterator.hasNext())
      {
        localc = (c)localIterator.next();
        ab.d("MicroMsg.EmojiItem", "[recycleBitmap]");
        if ((localc.eFr != null) && (!localc.eFr.isRecycled()))
        {
          ab.i("MicroMsg.EmojiItem", "bitmap recycle %s", new Object[] { localc.eFr.toString() });
          localc.eFr.recycle();
        }
      }
    }
    AppMethodBeat.o(116237);
  }
  
  public final int[] bI(boolean paramBoolean)
  {
    AppMethodBeat.i(155791);
    int[] arrayOfInt = new int[2];
    Iterator localIterator;
    if (paramBoolean)
    {
      localIterator = this.ecq.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.y.e)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    if (this.ecr != null)
    {
      localIterator = this.ecr.iterator();
      while (localIterator.hasNext()) {
        if (((c)localIterator.next() instanceof com.tencent.mm.y.e)) {
          arrayOfInt[1] += 1;
        } else {
          arrayOfInt[0] += 1;
        }
      }
    }
    AppMethodBeat.o(155791);
    return arrayOfInt;
  }
  
  public final void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(116240);
    Iterator localIterator = this.ecq.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      localc.setSelected(false);
      localc.draw(paramCanvas);
    }
    AppMethodBeat.o(116240);
  }
  
  public final String[] kR(String paramString)
  {
    AppMethodBeat.i(116248);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    Iterator localIterator = this.ecq.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc instanceof com.tencent.mm.y.e)) {
        arrayOfString[1] = (arrayOfString[1] + ((com.tencent.mm.y.e)localc).eFO.toString() + paramString);
      } else {
        arrayOfString[0] = (arrayOfString[0] + localc.eFq.Al() + paramString);
      }
    }
    AppMethodBeat.o(116248);
    return arrayOfString;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(116235);
    ab.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
    this.ecq = new Stack();
    AppMethodBeat.o(116235);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116236);
    ab.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
    Iterator localIterator;
    if (this.ecq != null)
    {
      localIterator = this.ecq.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.ecq.clear();
    }
    if (this.ecr != null)
    {
      localIterator = this.ecr.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).clear();
      }
      this.ecr.clear();
    }
    AppMethodBeat.o(116236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.d
 * JD-Core Version:    0.7.0.1
 */