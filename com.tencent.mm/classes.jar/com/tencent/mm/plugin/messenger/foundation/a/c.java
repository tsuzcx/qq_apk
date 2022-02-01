package com.tencent.mm.plugin.messenger.foundation.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.io.Serializable;

public abstract interface c
  extends a
{
  public abstract void a(Context paramContext, b paramb);
  
  public abstract void a(Context paramContext, b paramb, a parama);
  
  public abstract void a(Context paramContext, b paramb, c paramc);
  
  public abstract void a(Context paramContext, b paramb, String paramString, c paramc);
  
  public abstract void b(Context paramContext, b paramb, a parama);
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static final class b
    implements Serializable
  {
    public String appId;
    public String appName;
    public String signature;
    public String vVS;
    public String vVT;
    public String vVU;
    public String vVV;
    public int vVW;
    public int vVX;
  }
  
  public static abstract interface c
  {
    public abstract void e(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.c
 * JD-Core Version:    0.7.0.1
 */