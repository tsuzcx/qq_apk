package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.g;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "PlayFocusBehavior", "plugin-finder_release"})
public final class j
  extends g<b>
{
  public j(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(166719);
    AppMethodBeat.o(166719);
  }
  
  public final b coj()
  {
    AppMethodBeat.i(166718);
    b localb = (b)new c(this);
    AppMethodBeat.o(166718);
    return localb;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "initPos", "", "(I)V", "getInitPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
    extends c
  {
    public final int qvB;
    
    public a(int paramInt)
    {
      this.qvB = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.qvB != paramObject.qvB) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.qvB;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166716);
      String str = "PlayEvent(initPos=" + this.qvB + ")";
      AppMethodBeat.o(166716);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void CN(int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/report/PlayFocusSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static final class c
    implements j.b
  {
    public final void CN(int paramInt)
    {
      AppMethodBeat.i(166717);
      j.a locala = new j.a(paramInt);
      this.qHx.b((c)locala);
      AppMethodBeat.o(166717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */