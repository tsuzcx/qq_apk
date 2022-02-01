package com.tencent.mm.plugin.hld.keyboard;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/KeyOperation;", "", "x", "", "y", "time", "", "processText", "", "process", "", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "pressTimestamp", "(IIJLjava/lang/String;ZLjava/lang/ref/WeakReference;J)V", "getPressTimestamp", "()J", "getProcess", "()Z", "setProcess", "(Z)V", "getProcessText", "()Ljava/lang/String;", "setProcessText", "(Ljava/lang/String;)V", "getTime", "getViewRef", "()Ljava/lang/ref/WeakReference;", "setViewRef", "(Ljava/lang/ref/WeakReference;)V", "getX", "()I", "getY", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  String Jrk;
  public boolean Jrl;
  public final long Jrm;
  final long time;
  WeakReference<View> viewRef;
  public final int x;
  public final int y;
  
  private b(int paramInt1, int paramInt2, long paramLong1, String paramString, WeakReference<View> paramWeakReference, long paramLong2)
  {
    AppMethodBeat.i(312915);
    this.x = paramInt1;
    this.y = paramInt2;
    this.time = paramLong1;
    this.Jrk = paramString;
    this.Jrl = false;
    this.viewRef = paramWeakReference;
    this.Jrm = paramLong2;
    AppMethodBeat.o(312915);
  }
  
  public final void aIl(String paramString)
  {
    AppMethodBeat.i(312926);
    s.u(paramString, "<set-?>");
    this.Jrk = paramString;
    AppMethodBeat.o(312926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.b
 * JD-Core Version:    0.7.0.1
 */