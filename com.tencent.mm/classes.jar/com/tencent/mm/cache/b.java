package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Stack;

public final class b
  implements f<com.tencent.mm.z.b>
{
  public int gpA;
  public Stack<com.tencent.mm.z.b> gpx;
  public Stack<com.tencent.mm.z.b> gpy;
  
  public final void Ya()
  {
    this.gpA += 1;
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(9202);
    if (paramBoolean)
    {
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localObject = this.gpx.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.z.b)((Iterator)localObject).next()).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
    if ((this.gpx != null) && (this.gpx.size() > 0)) {}
    for (Object localObject = (com.tencent.mm.z.b)this.gpx.peek();; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.z.b)localObject).draw(paramCanvas);
      }
      AppMethodBeat.o(9202);
      return;
    }
  }
  
  public final int ai(boolean paramBoolean)
  {
    AppMethodBeat.i(9204);
    int i;
    if (paramBoolean)
    {
      if (this.gpx != null)
      {
        i = this.gpx.size();
        AppMethodBeat.o(9204);
        return i;
      }
      AppMethodBeat.o(9204);
      return 0;
    }
    if (this.gpy != null)
    {
      i = this.gpy.size();
      AppMethodBeat.o(9204);
      return i;
    }
    AppMethodBeat.o(9204);
    return 0;
  }
  
  public final void alC()
  {
    AppMethodBeat.i(9201);
    Log.i("MicroMsg.DoodleCache", "[onRestore] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    this.gpx.clear();
    if (this.gpy != null)
    {
      Log.i("MicroMsg.DoodleCache", "[onRestore] %s", new Object[] { Integer.valueOf(this.gpy.size()) });
      this.gpx.addAll(this.gpy);
    }
    AppMethodBeat.o(9201);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(204748);
    if (this.gpx != null) {
      this.gpx.clear();
    }
    AppMethodBeat.o(204748);
  }
  
  public final void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(9200);
    Log.i("MicroMsg.DoodleCache", "[onSave] size:%s", new Object[] { Integer.valueOf(this.gpx.size()) });
    if (this.gpy != null) {
      this.gpy.clear();
    }
    this.gpy = ((Stack)this.gpx.clone());
    if (paramBoolean) {
      this.gpx.clear();
    }
    AppMethodBeat.o(9200);
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(9203);
    Iterator localIterator = this.gpx.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.z.b)localIterator.next()).draw(paramCanvas);
    }
    AppMethodBeat.o(9203);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(9198);
    this.gpx = new Stack();
    AppMethodBeat.o(9198);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9199);
    Log.i("MicroMsg.DoodleCache", "[onDestroy]");
    if (this.gpx != null) {
      this.gpx.clear();
    }
    if (this.gpy != null) {
      this.gpy.clear();
    }
    AppMethodBeat.o(9199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.b
 * JD-Core Version:    0.7.0.1
 */