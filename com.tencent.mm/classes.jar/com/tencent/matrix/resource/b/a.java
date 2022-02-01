package com.tencent.matrix.resource.b;

import android.content.Intent;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final long cHu = TimeUnit.MINUTES.toMillis(1L);
  public static final long cHv = TimeUnit.MINUTES.toMillis(20L);
  private static final b cHw = b.cHD;
  public final com.tencent.c.a.a cBC;
  public final b cHx;
  public final boolean cHy;
  public final Intent cHz;
  
  private a(com.tencent.c.a.a parama, b paramb, boolean paramBoolean, Intent paramIntent)
  {
    this.cBC = parama;
    this.cHx = paramb;
    this.cHy = paramBoolean;
    this.cHz = paramIntent;
  }
  
  public final long IF()
  {
    return this.cBC.get(com.tencent.c.a.a.a.LCW.name(), cHu);
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cEm;
    public a.b cHA = a.IG();
    public boolean cHy = false;
    public Intent cHz;
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.b.a
 * JD-Core Version:    0.7.0.1
 */