package com.tencent.mm.plugin.findersdk.d.a.a;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", "index", "reset", "setActivityContext", "context", "svrValue", "versionTag", "finder-sdk_release"})
public abstract class e
{
  public int BwA;
  private WeakReference<Activity> aFX;
  public String title;
  
  public e(String paramString)
  {
    this.title = paramString;
    this.BwA = -1;
  }
  
  public abstract void Si(int paramInt);
  
  public final WeakReference<Activity> enA()
  {
    return this.aFX;
  }
  
  public List<String> enw()
  {
    return (List)new LinkedList();
  }
  
  public abstract String enx();
  
  public abstract String eny();
  
  public final void setActivityContext(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.aFX = new WeakReference(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */