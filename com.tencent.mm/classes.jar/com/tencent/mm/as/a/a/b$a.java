package com.tencent.mm.as.a.a;

import android.content.Context;
import com.tencent.mm.as.a.b.d;
import com.tencent.mm.as.a.b.g;
import com.tencent.mm.as.a.b.i;
import com.tencent.mm.as.a.c.h;
import com.tencent.mm.as.a.c.j;
import com.tencent.mm.as.a.c.k;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.as.a.c.n;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b$a
{
  Context context;
  int eqP = b.eqN;
  int eqQ = 5;
  c eqR = null;
  public m eqS = null;
  com.tencent.mm.as.a.c.a eqT = null;
  public com.tencent.mm.as.a.c.b eqU = null;
  com.tencent.mm.as.a.c.f eqV = null;
  j eqW = null;
  com.tencent.mm.as.a.c.e eqY = null;
  h eqZ = null;
  Executor era;
  n erb = null;
  k erc = null;
  
  public b$a(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
  }
  
  public final b OU()
  {
    if (this.eqR == null) {
      this.eqR = new c.a().OV();
    }
    if (this.eqS == null) {
      this.eqS = new com.tencent.mm.as.a.b.f();
    }
    if (this.eqT == null) {
      this.eqT = new com.tencent.mm.as.a.b.a();
    }
    if (this.eqU == null) {
      this.eqU = new com.tencent.mm.as.a.b.b();
    }
    if (this.eqV == null) {
      this.eqV = new d();
    }
    if (this.eqW == null) {
      this.eqW = new i();
    }
    if (this.eqZ == null) {
      this.eqZ = a.bm(this.eqP, this.eqQ);
    }
    if (this.era == null) {
      this.era = Executors.newSingleThreadExecutor();
    }
    if (this.erc == null) {
      this.erc = new com.tencent.mm.as.a.b.e();
    }
    if (this.eqY == null) {
      this.eqY = new com.tencent.mm.as.a.b.c();
    }
    if (this.erb == null) {
      this.erb = new g();
    }
    return new b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.as.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */