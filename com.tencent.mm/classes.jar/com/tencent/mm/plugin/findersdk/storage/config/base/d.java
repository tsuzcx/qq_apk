package com.tencent.mm.plugin.findersdk.storage.config.base;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "setContextRef", "(Ljava/lang/ref/WeakReference;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", "index", "reset", "setActivityContext", "context", "svrValue", "versionTag", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public int HdL;
  private WeakReference<Activity> contextRef;
  public String title;
  
  public d(String paramString)
  {
    this.title = paramString;
    this.HdL = -1;
  }
  
  public abstract void VB(int paramInt);
  
  public List<String> fsi()
  {
    return (List)new LinkedList();
  }
  
  public abstract String fsj();
  
  public abstract String fsk();
  
  public final WeakReference<Activity> fsm()
  {
    return this.contextRef;
  }
  
  public final void setActivityContext(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.contextRef = new WeakReference(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.storage.config.base.d
 * JD-Core Version:    0.7.0.1
 */