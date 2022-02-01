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
    public Queue<c.b> aHj;
    
    public a()
    {
      AppMethodBeat.i(140006);
      this.aHj = new LinkedList();
      AppMethodBeat.o(140006);
    }
    
    public final c.b Gg()
    {
      AppMethodBeat.i(140007);
      c.b localb = (c.b)this.aHj.poll();
      if (localb == null)
      {
        localb = new c.b();
        AppMethodBeat.o(140007);
        return localb;
      }
      AppMethodBeat.o(140007);
      return localb;
    }
    
    public final void a(c.b paramb)
    {
      AppMethodBeat.i(140008);
      this.aHj.offer(paramb);
      AppMethodBeat.o(140008);
    }
    
    public final void d(ArrayList<c.b> paramArrayList)
    {
      AppMethodBeat.i(140009);
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        AppMethodBeat.o(140009);
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        c.b localb = (c.b)localIterator.next();
        this.aHj.offer(localb);
      }
      paramArrayList.clear();
      AppMethodBeat.o(140009);
    }
  }
  
  public static final class b
  {
    public int x;
    public int y;
    public int z;
    
    public final b gP(int paramInt)
    {
      this.x = 1;
      this.y = 1;
      this.z = paramInt;
      return this;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(140010);
      String str = "[" + this.x + ", " + this.y + ", " + this.z + "]";
      AppMethodBeat.o(140010);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.c
 * JD-Core Version:    0.7.0.1
 */