package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract interface f
  extends a
{
  public abstract void a(String paramString, f.a parama);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void a(String paramString, c paramc);
  
  public abstract void a(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  
  public abstract void akI(String paramString);
  
  public abstract void akJ(String paramString);
  
  public abstract CharSequence akK(String paramString);
  
  public abstract CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  
  public abstract void b(String paramString, c paramc);
  
  public static abstract interface b
  {
    public abstract CharSequence a(Map<String, String> paramMap, String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1);
  }
  
  public static abstract interface c
  {
    public abstract void a(Map<String, String> paramMap, com.tencent.mm.ak.f.a parama);
    
    public abstract void b(String paramString, Map<String, String> paramMap, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */