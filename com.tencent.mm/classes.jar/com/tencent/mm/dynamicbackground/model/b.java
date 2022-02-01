package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener;", "", "isInitCrash", "", "markDrawEndPoint", "", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "willCrash", "Companion", "dynamicbg_release"})
public abstract interface b
{
  public static final a gRg = a.gRh;
  
  public abstract boolean atE();
  
  public abstract void atF();
  
  public abstract void atG();
  
  public abstract void atH();
  
  public abstract boolean atI();
  
  public abstract boolean atJ();
  
  public abstract void atK();
  
  public abstract void atL();
  
  @l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/model/DynamicBgCrashListener$Companion;", "", "()V", "CHECK_DRAW_COUNT", "", "dynamicbg_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(103078);
      gRh = new a();
      AppMethodBeat.o(103078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.b
 * JD-Core Version:    0.7.0.1
 */