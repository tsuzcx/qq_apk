package com.tencent.mm.as.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.as.a.c.a;
import com.tencent.mm.as.a.c.e;
import com.tencent.mm.as.a.c.f;
import com.tencent.mm.as.a.c.h;
import com.tencent.mm.as.a.c.j;
import com.tencent.mm.as.a.c.k;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.as.a.c.n;
import java.util.concurrent.Executor;

public final class b
{
  public static final int eqN = Runtime.getRuntime().availableProcessors();
  public final Resources eqO;
  public final int eqP;
  public final int eqQ;
  public final c eqR;
  public final m eqS;
  public final a eqT;
  public final com.tencent.mm.as.a.c.b eqU;
  public final f eqV;
  public final j eqW;
  public final k eqX;
  public final e eqY;
  public final h eqZ;
  public final Executor era;
  public final n erb;
  public final String packageName;
  
  public b(b.a parama)
  {
    this.packageName = parama.context.getPackageName();
    this.eqO = parama.context.getResources();
    this.eqP = parama.eqP;
    this.eqQ = parama.eqQ;
    this.eqR = parama.eqR;
    this.eqS = parama.eqS;
    this.eqT = parama.eqT;
    this.eqU = parama.eqU;
    this.eqV = parama.eqV;
    this.eqW = parama.eqW;
    this.eqZ = parama.eqZ;
    this.era = parama.era;
    this.eqX = parama.erc;
    this.eqY = parama.eqY;
    this.erb = parama.erb;
  }
  
  public static b bz(Context paramContext)
  {
    return new b.a(paramContext).OU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.as.a.a.b
 * JD-Core Version:    0.7.0.1
 */