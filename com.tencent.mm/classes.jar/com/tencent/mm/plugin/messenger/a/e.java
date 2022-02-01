package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.c.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract interface e
  extends a
{
  public abstract void a(b paramb);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, c paramc);
  
  public abstract void a(String paramString, d paramd);
  
  public abstract void a(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  public abstract void aOe(String paramString);
  
  public abstract void aOf(String paramString);
  
  public abstract CharSequence aOg(String paramString);
  
  public abstract CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  public abstract void b(b paramb);
  
  public abstract void b(String paramString, d paramd);
  
  public static abstract interface a
  {
    public abstract String f(Map<String, String> paramMap, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract Boolean al(Map<String, String> paramMap);
    
    public abstract CharSequence m(Map<String, String> paramMap, String paramString);
  }
  
  public static abstract interface c
  {
    public abstract CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  }
  
  public static abstract interface d
  {
    public abstract void a(Map<String, String> paramMap, h.a parama);
    
    public abstract void b(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.e
 * JD-Core Version:    0.7.0.1
 */