package com.tencent.mm.live.a;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;
import org.xwalk.core.XWalkEnvironment;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"})
public final class b$a
  extends ContentObserver
{
  public ContentResolver gJw;
  private final a<z> gJx;
  
  public b$a(Handler paramHandler, a<z> parama)
  {
    super(paramHandler);
    AppMethodBeat.i(215628);
    this.gJx = parama;
    paramHandler = XWalkEnvironment.getContentResolver();
    p.g(paramHandler, "getContentResolver()");
    this.gJw = paramHandler;
    AppMethodBeat.o(215628);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(215627);
    super.onChange(paramBoolean);
    a locala = this.gJx;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(215627);
      return;
    }
    AppMethodBeat.o(215627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.a.b.a
 * JD-Core Version:    0.7.0.1
 */