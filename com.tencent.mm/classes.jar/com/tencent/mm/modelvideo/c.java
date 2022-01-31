package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.storage.z;

public final class c
{
  public static final int fUY;
  Context context;
  int duration;
  public a fUZ;
  String fVa;
  final AsyncTask<String, Integer, String> fVb;
  String fileName;
  Intent intent;
  String thumbPath;
  String videoPath;
  
  static
  {
    AppMethodBeat.i(50628);
    fUY = b.MY();
    AppMethodBeat.o(50628);
  }
  
  public c()
  {
    AppMethodBeat.i(50626);
    this.context = null;
    this.fUZ = null;
    this.fVa = null;
    this.duration = 0;
    this.intent = null;
    this.fileName = null;
    this.thumbPath = null;
    this.videoPath = null;
    this.fVb = new c.1(this);
    AppMethodBeat.o(50626);
  }
  
  public final void a(Context paramContext, Intent paramIntent, a parama)
  {
    AppMethodBeat.i(50627);
    this.context = paramContext;
    this.intent = paramIntent;
    this.fileName = t.ve((String)g.RL().Ru().get(2, ""));
    o.alE();
    this.thumbPath = t.vg(this.fileName);
    o.alE();
    this.videoPath = t.vf(this.fileName);
    this.fUZ = parama;
    this.fVb.execute(new String[0]);
    AppMethodBeat.o(50627);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt1, String paramString1, String paramString2, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelvideo.c
 * JD-Core Version:    0.7.0.1
 */