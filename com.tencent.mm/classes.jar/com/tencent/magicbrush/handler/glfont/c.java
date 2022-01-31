package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

abstract interface c
{
  public abstract void a(int paramInt1, int paramInt2, Rect paramRect);
  
  public abstract void init(int paramInt1, int paramInt2);
  
  public abstract void reset();
  
  public static final class a
  {
    public Queue<c.b> bJI;
    
    public a()
    {
      AppMethodBeat.i(115905);
      this.bJI = new LinkedList();
      AppMethodBeat.o(115905);
    }
    
    public final void a(c.b paramb)
    {
      AppMethodBeat.i(115907);
      this.bJI.offer(paramb);
      AppMethodBeat.o(115907);
    }
    
    public final void c(ArrayList<c.b> paramArrayList)
    {
      AppMethodBeat.i(115908);
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        AppMethodBeat.o(115908);
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        c.b localb = (c.b)localIterator.next();
        this.bJI.offer(localb);
      }
      paramArrayList.clear();
      AppMethodBeat.o(115908);
    }
    
    public final c.b yt()
    {
      AppMethodBeat.i(115906);
      c.b localb = (c.b)this.bJI.poll();
      if (localb == null)
      {
        localb = new c.b();
        AppMethodBeat.o(115906);
        return localb;
      }
      AppMethodBeat.o(115906);
      return localb;
    }
  }
  
  public static final class b
  {
    public int x;
    public int y;
    public int z;
    
    public final b fK(int paramInt)
    {
      this.x = 1;
      this.y = 1;
      this.z = paramInt;
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(115909);
      String str = "[" + this.x + ", " + this.y + ", " + this.z + "]";
      AppMethodBeat.o(115909);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.c
 * JD-Core Version:    0.7.0.1
 */