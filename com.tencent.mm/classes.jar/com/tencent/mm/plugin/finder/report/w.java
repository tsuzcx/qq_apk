package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "PlayFocusBehavior", "plugin-finder_release"})
public final class w
  extends e<b>
{
  public w(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166719);
    AppMethodBeat.o(166719);
  }
  
  public final b cEB()
  {
    AppMethodBeat.i(166718);
    b localb = (b)new c(this);
    AppMethodBeat.o(166718);
    return localb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "initPos", "", "(I)V", "getInitPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private final int ssv;
    
    public a(int paramInt)
    {
      this.ssv = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.ssv != paramObject.ssv) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.ssv;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166716);
      String str = "PlayEvent(initPos=" + this.ssv + ")";
      AppMethodBeat.o(166716);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void Fc(int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/report/PlayFocusSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static final class c
    implements w.b
  {
    public final void Fc(int paramInt)
    {
      AppMethodBeat.i(166717);
      w.a locala = new w.a(paramInt);
      this.ssw.c((b)locala);
      AppMethodBeat.o(166717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.w
 * JD-Core Version:    0.7.0.1
 */