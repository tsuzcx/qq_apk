package com.tencent.tmassistant;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.a.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends c
{
  protected ArrayList a;
  
  protected void a()
  {
    k.c("TMAssistantDownloadSDKClient", "enter");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((WeakReference)localIterator.next()).get();
      d.a().a(this, locala);
    }
    k.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  protected void a(IBinder paramIBinder)
  {
    this.f = e.a(paramIBinder);
  }
  
  protected void b()
  {
    ((com.tencent.tmassistant.aidl.d)this.f).a(this.c, (com.tencent.tmassistant.aidl.a)this.g);
  }
  
  protected Intent c()
  {
    return new Intent(this.b, Class.forName(this.d));
  }
  
  protected void d()
  {
    ((com.tencent.tmassistant.aidl.d)this.f).b(this.c, (com.tencent.tmassistant.aidl.a)this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.b
 * JD-Core Version:    0.7.0.1
 */