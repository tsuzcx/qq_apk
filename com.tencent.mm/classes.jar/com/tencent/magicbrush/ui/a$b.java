package com.tencent.magicbrush.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 13}, gfy={""}, gfz={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "", "(Ljava/lang/String;I)V", "ChoreographerInJsThread", "ChoreographerInMainThread", "EglSurfaceSwapLocker", "SchedulerLocker", "NativeLocker", "lib-magicbrush-nano_release"})
public enum a$b
{
  static
  {
    AppMethodBeat.i(140205);
    b localb1 = new b("ChoreographerInJsThread", 0);
    czL = localb1;
    b localb2 = new b("ChoreographerInMainThread", 1);
    czM = localb2;
    b localb3 = new b("EglSurfaceSwapLocker", 2);
    czN = localb3;
    b localb4 = new b("SchedulerLocker", 3);
    czO = localb4;
    b localb5 = new b("NativeLocker", 4);
    czP = localb5;
    czQ = new b[] { localb1, localb2, localb3, localb4, localb5 };
    AppMethodBeat.o(140205);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a.b
 * JD-Core Version:    0.7.0.1
 */