package com.tencent.mm.plugin.messenger.foundation.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.io.Serializable;

public abstract interface c
  extends a
{
  public abstract void a(Context paramContext, b paramb);
  
  public abstract void a(Context paramContext, b paramb, c.a parama);
  
  public abstract void a(Context paramContext, b paramb, c.c paramc);
  
  public abstract void a(Context paramContext, b paramb, String paramString, c.c paramc);
  
  public abstract void b(Context paramContext, b paramb, c.a parama);
  
  public static final class b
    implements Serializable
  {
    public String appId;
    public String appName;
    public String signature;
    public String zpX;
    public String zpY;
    public String zpZ;
    public String zqa;
    public int zqb;
    public int zqc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.c
 * JD-Core Version:    0.7.0.1
 */