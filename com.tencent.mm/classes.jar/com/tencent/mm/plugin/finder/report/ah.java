package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "PlayFocusBehavior", "plugin-finder_release"})
public final class ah
  extends e<b>
{
  public ah(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166719);
    AppMethodBeat.o(166719);
  }
  
  public final b doW()
  {
    AppMethodBeat.i(166718);
    b localb = (b)new c(this);
    AppMethodBeat.o(166718);
    return localb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "initPos", "", "(I)V", "getInitPos", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private final int uCt;
    
    public a(int paramInt)
    {
      this.uCt = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.uCt != paramObject.uCt) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.uCt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166716);
      String str = "PlayEvent(initPos=" + this.uCt + ")";
      AppMethodBeat.o(166716);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void KC(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/PlayFocusSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PlayFocusSubscriber$PlayFocusBehavior;", "onPlay", "", "initPos", "", "plugin-finder_release"})
  public static final class c
    implements ah.b
  {
    public final void KC(int paramInt)
    {
      AppMethodBeat.i(166717);
      ah.a locala = new ah.a(paramInt);
      this.viL.c((b)locala);
      AppMethodBeat.o(166717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ah
 * JD-Core Version:    0.7.0.1
 */