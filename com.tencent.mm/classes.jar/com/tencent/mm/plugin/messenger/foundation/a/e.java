package com.tencent.mm.plugin.messenger.foundation.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.io.Serializable;

public abstract interface e
  extends a
{
  public abstract void a(Context paramContext, b paramb);
  
  public abstract void a(Context paramContext, b paramb, e.a parama);
  
  public abstract void a(Context paramContext, b paramb, e.c paramc);
  
  public abstract void a(Context paramContext, b paramb, String paramString, e.c paramc);
  
  public abstract void b(Context paramContext, b paramb, e.a parama);
  
  public static final class b
    implements Serializable
  {
    public String KQX;
    public String KQY;
    public String KQZ;
    public String KRa;
    public int KRb;
    public String appId;
    public String appName;
    public int mIJ;
    public String signature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.e
 * JD-Core Version:    0.7.0.1
 */