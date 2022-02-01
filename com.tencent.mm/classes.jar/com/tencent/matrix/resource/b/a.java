package com.tencent.matrix.resource.b;

import android.content.Intent;
import java.util.concurrent.TimeUnit;

public final class a
{
  private static final long cId = TimeUnit.MINUTES.toMillis(1L);
  public static final long cIe = TimeUnit.MINUTES.toMillis(20L);
  private static final b cIf = b.cIm;
  public final com.tencent.c.a.a cCj;
  public final b cIg;
  public final boolean cIh;
  public final Intent cIi;
  
  private a(com.tencent.c.a.a parama, b paramb, boolean paramBoolean, Intent paramIntent)
  {
    this.cCj = parama;
    this.cIg = paramb;
    this.cIh = paramBoolean;
    this.cIi = paramIntent;
  }
  
  public final long IN()
  {
    return this.cCj.get(com.tencent.c.a.a.a.Maa.name(), cId);
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cET;
    public boolean cIh = false;
    public Intent cIi;
    public a.b cIj = a.IO();
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