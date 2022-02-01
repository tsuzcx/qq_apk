package com.tencent.matrix.resource.b;

import android.content.Intent;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final long cYA = TimeUnit.MINUTES.toMillis(1L);
  public static final long cYB = TimeUnit.MINUTES.toMillis(20L);
  private static final b cYC = b.cYJ;
  public final com.tencent.c.a.a cQF;
  public final b cYD;
  public final boolean cYE;
  public final Intent cYF;
  
  private a(com.tencent.c.a.a parama, b paramb, boolean paramBoolean, Intent paramIntent)
  {
    this.cQF = parama;
    this.cYD = paramb;
    this.cYE = paramBoolean;
    this.cYF = paramIntent;
  }
  
  public final long Tb()
  {
    return this.cQF.get(com.tencent.c.a.a.a.RAs.name(), cYA);
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cVx;
    public boolean cYE = false;
    public Intent cYF;
    public a.b cYG = a.Tc();
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.b.a
 * JD-Core Version:    0.7.0.1
 */