package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.storage.z;

public final class c
{
  public static final int eFh = ;
  Context context = null;
  int duration = 0;
  public a eFi = null;
  String eFj = null;
  final AsyncTask<String, Integer, String> eFk = new c.1(this);
  String fileName = null;
  Intent intent = null;
  String thumbPath = null;
  String videoPath = null;
  
  public final void a(Context paramContext, Intent paramIntent, a parama)
  {
    this.context = paramContext;
    this.intent = paramIntent;
    this.fileName = t.nR((String)g.DP().Dz().get(2, ""));
    o.Sr();
    this.thumbPath = t.nT(this.fileName);
    o.Sr();
    this.videoPath = t.nS(this.fileName);
    this.eFi = parama;
    this.eFk.execute(new String[0]);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt1, String paramString1, String paramString2, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.c
 * JD-Core Version:    0.7.0.1
 */