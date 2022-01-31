package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import java.lang.ref.WeakReference;

public abstract interface e
  extends a
{
  public abstract void SM(String paramString);
  
  public abstract void SN(String paramString);
  
  public abstract CharSequence SO(String paramString);
  
  public abstract CharSequence a(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference);
  
  public abstract void a(String paramString, e.a parama);
  
  public abstract void a(String paramString, e.b paramb);
  
  public abstract void a(String paramString, e.c paramc);
  
  public abstract void b(String paramString, e.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.e
 * JD-Core Version:    0.7.0.1
 */