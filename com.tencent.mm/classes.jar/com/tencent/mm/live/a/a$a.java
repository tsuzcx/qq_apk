package com.tencent.mm.live.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/controller/LiveUIRouter$RotationSwitchObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "onChangCallback", "Lkotlin/Function0;", "", "(Landroid/os/Handler;Lkotlin/jvm/functions/Function0;)V", "mResolver", "Landroid/content/ContentResolver;", "getMResolver", "()Landroid/content/ContentResolver;", "setMResolver", "(Landroid/content/ContentResolver;)V", "getOnChangCallback", "()Lkotlin/jvm/functions/Function0;", "onChange", "selfChange", "", "startObserver", "stopObserver", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  extends ContentObserver
{
  private final a<ah> mJm;
  public ContentResolver mJn;
  
  public a$a(Handler paramHandler, a<ah> parama)
  {
    super(paramHandler);
    AppMethodBeat.i(245957);
    this.mJm = parama;
    paramHandler = MMApplicationContext.getContext().getContentResolver();
    s.s(paramHandler, "getContext().contentResolver");
    this.mJn = paramHandler;
    AppMethodBeat.o(245957);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    AppMethodBeat.i(245966);
    super.onChange(paramBoolean);
    a locala = this.mJm;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(245966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.a.a.a
 * JD-Core Version:    0.7.0.1
 */