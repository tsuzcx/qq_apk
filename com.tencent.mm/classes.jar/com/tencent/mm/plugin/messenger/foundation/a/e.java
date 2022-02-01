package com.tencent.mm.plugin.messenger.foundation.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.io.Serializable;

public abstract interface e
  extends a
{
  public abstract void a(Context paramContext, b paramb);
  
  public abstract void a(Context paramContext, b paramb, a parama);
  
  public abstract void a(Context paramContext, b paramb, e.c paramc);
  
  public abstract void a(Context paramContext, b paramb, String paramString, e.c paramc);
  
  public abstract void b(Context paramContext, b paramb, a parama);
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static final class b
    implements Serializable
  {
    public int EVA;
    public int EVB;
    public String EVw;
    public String EVx;
    public String EVy;
    public String EVz;
    public String appId;
    public String appName;
    public String signature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.e
 * JD-Core Version:    0.7.0.1
 */