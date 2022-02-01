package mqq.app;

import android.app.Activity;
import android.os.Binder;
import java.util.ArrayList;
import java.util.HashMap;

public class LocalActivityManager
{
  private HashMap<String, ArrayList<LocalActivityRecord>> activityMap = new HashMap(4);
  private String currentTabId;
  
  public void clear()
  {
    if (this.activityMap.containsKey(this.currentTabId)) {
      ((ArrayList)this.activityMap.get(this.currentTabId)).clear();
    }
  }
  
  public ArrayList<LocalActivityRecord> getCurrentList()
  {
    if (!this.activityMap.containsKey(this.currentTabId)) {
      return null;
    }
    return (ArrayList)this.activityMap.get(this.currentTabId);
  }
  
  public LocalActivityRecord pop()
  {
    return pop(null);
  }
  
  public LocalActivityRecord pop(String paramString)
  {
    if (this.activityMap.containsKey(this.currentTabId))
    {
      ArrayList localArrayList = (ArrayList)this.activityMap.get(this.currentTabId);
      if ((paramString == null) && (localArrayList.size() > 0)) {
        return (LocalActivityRecord)localArrayList.remove(localArrayList.size() - 1);
      }
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        if (paramString.equalsIgnoreCase(((LocalActivityRecord)localArrayList.get(i)).id)) {
          return (LocalActivityRecord)localArrayList.remove(i);
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public void push(String paramString, Activity paramActivity)
  {
    if (this.activityMap.containsKey(this.currentTabId))
    {
      ((ArrayList)this.activityMap.get(this.currentTabId)).add(new LocalActivityRecord(paramString, paramActivity));
      return;
    }
    paramString = new LocalActivityRecord(paramString, paramActivity);
    paramActivity = new ArrayList();
    paramActivity.add(paramString);
    this.activityMap.put(this.currentTabId, paramActivity);
  }
  
  public void setCurrentTabId(String paramString)
  {
    this.currentTabId = paramString;
  }
  
  public static class LocalActivityRecord
    extends Binder
  {
    Activity activity;
    final String id;
    
    LocalActivityRecord(String paramString, Activity paramActivity)
    {
      this.id = paramString;
      this.activity = paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.LocalActivityManager
 * JD-Core Version:    0.7.0.1
 */