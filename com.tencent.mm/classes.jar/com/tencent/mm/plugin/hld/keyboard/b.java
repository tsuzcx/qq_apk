package com.tencent.mm.plugin.hld.keyboard;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "", "x", "", "y", "time", "", "processText", "", "process", "", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "pressTimestamp", "(IIJLjava/lang/String;ZLjava/lang/ref/WeakReference;J)V", "getPressTimestamp", "()J", "getProcess", "()Z", "setProcess", "(Z)V", "getProcessText", "()Ljava/lang/String;", "setProcessText", "(Ljava/lang/String;)V", "getTime", "getViewRef", "()Ljava/lang/ref/WeakReference;", "setViewRef", "(Ljava/lang/ref/WeakReference;)V", "getX", "()I", "getY", "plugin-hld_release"})
public final class b
{
  String Dyg;
  public boolean Dyh;
  public final long Dyi;
  WeakReference<View> aFW;
  final long time;
  public final int x;
  public final int y;
  
  private b(int paramInt1, int paramInt2, long paramLong1, String paramString, WeakReference<View> paramWeakReference, long paramLong2)
  {
    AppMethodBeat.i(210909);
    this.x = paramInt1;
    this.y = paramInt2;
    this.time = paramLong1;
    this.Dyg = paramString;
    this.Dyh = false;
    this.aFW = paramWeakReference;
    this.Dyi = paramLong2;
    AppMethodBeat.o(210909);
  }
  
  public final void aLu(String paramString)
  {
    AppMethodBeat.i(210908);
    p.k(paramString, "<set-?>");
    this.Dyg = paramString;
    AppMethodBeat.o(210908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.b
 * JD-Core Version:    0.7.0.1
 */