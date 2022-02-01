package com.tencent.matrix.resource.b;

import android.content.Intent;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final long czq = TimeUnit.MINUTES.toMillis(1L);
  public static final long czr = TimeUnit.MINUTES.toMillis(20L);
  private static final b czs = b.czz;
  public final com.tencent.c.a.a cty;
  public final b czt;
  public final boolean czu;
  public final Intent czv;
  
  private a(com.tencent.c.a.a parama, b paramb, boolean paramBoolean, Intent paramIntent)
  {
    this.cty = parama;
    this.czt = paramb;
    this.czu = paramBoolean;
    this.czv = paramIntent;
  }
  
  public final long Hz()
  {
    return this.cty.get(com.tencent.c.a.a.a.IhF.name(), czq);
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cwi;
    public boolean czu = false;
    public Intent czv;
    public a.b czw = a.HA();
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.resource.b.a
 * JD-Core Version:    0.7.0.1
 */