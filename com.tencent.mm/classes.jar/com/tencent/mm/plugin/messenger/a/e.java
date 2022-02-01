package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract interface e
  extends a
{
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, e.c paramc);
  
  public abstract void a(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  public abstract void aDU(String paramString);
  
  public abstract void aDV(String paramString);
  
  public abstract CharSequence aDW(String paramString);
  
  public abstract CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  public abstract void b(String paramString, e.c paramc);
  
  public static abstract interface a
  {
    public abstract String f(Map<String, String> paramMap, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.e
 * JD-Core Version:    0.7.0.1
 */