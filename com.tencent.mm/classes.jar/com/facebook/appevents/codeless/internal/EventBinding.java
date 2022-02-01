package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventBinding
{
  private final String activityName;
  private final String appVersion;
  private final String componentId;
  private final String eventName;
  private final EventBinding.MappingMethod method;
  private final List<ParameterComponent> parameters;
  private final List<PathComponent> path;
  private final String pathType;
  private final ActionType type;
  
  public EventBinding(String paramString1, EventBinding.MappingMethod paramMappingMethod, ActionType paramActionType, String paramString2, List<PathComponent> paramList, List<ParameterComponent> paramList1, String paramString3, String paramString4, String paramString5)
  {
    this.eventName = paramString1;
    this.method = paramMappingMethod;
    this.type = paramActionType;
    this.appVersion = paramString2;
    this.path = paramList;
    this.parameters = paramList1;
    this.componentId = paramString3;
    this.pathType = paramString4;
    this.activityName = paramString5;
  }
  
  public static EventBinding getInstanceFromJson(JSONObject paramJSONObject)
  {
    int j = 0;
    AppMethodBeat.i(17534);
    String str1 = paramJSONObject.getString("event_name");
    EventBinding.MappingMethod localMappingMethod = EventBinding.MappingMethod.valueOf(paramJSONObject.getString("method").toUpperCase());
    ActionType localActionType = ActionType.valueOf(paramJSONObject.getString("event_type").toUpperCase());
    String str2 = paramJSONObject.getString("app_version");
    Object localObject = paramJSONObject.getJSONArray("path");
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      localArrayList1.add(new PathComponent(((JSONArray)localObject).getJSONObject(i)));
      i += 1;
    }
    localObject = paramJSONObject.optString("path_type", "absolute");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("parameters");
    ArrayList localArrayList2 = new ArrayList();
    if (localJSONArray != null)
    {
      i = j;
      while (i < localJSONArray.length())
      {
        localArrayList2.add(new ParameterComponent(localJSONArray.getJSONObject(i)));
        i += 1;
      }
    }
    paramJSONObject = new EventBinding(str1, localMappingMethod, localActionType, str2, localArrayList1, localArrayList2, paramJSONObject.optString("component_id"), (String)localObject, paramJSONObject.optString("activity_name"));
    AppMethodBeat.o(17534);
    return paramJSONObject;
  }
  
  public static List<EventBinding> parseArray(JSONArray paramJSONArray)
  {
    int j = 0;
    AppMethodBeat.i(17533);
    localArrayList = new ArrayList();
    if (paramJSONArray != null) {}
    try
    {
      int i = paramJSONArray.length();
      while (j < i)
      {
        localArrayList.add(getInstanceFromJson(paramJSONArray.getJSONObject(j)));
        j += 1;
        continue;
        i = 0;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONArray)
    {
      AppMethodBeat.o(17533);
    }
  }
  
  public String getActivityName()
  {
    return this.activityName;
  }
  
  public String getAppVersion()
  {
    return this.appVersion;
  }
  
  public String getComponentId()
  {
    return this.componentId;
  }
  
  public String getEventName()
  {
    return this.eventName;
  }
  
  public EventBinding.MappingMethod getMethod()
  {
    return this.method;
  }
  
  public String getPathType()
  {
    return this.pathType;
  }
  
  public ActionType getType()
  {
    return this.type;
  }
  
  public List<ParameterComponent> getViewParameters()
  {
    AppMethodBeat.i(17536);
    List localList = Collections.unmodifiableList(this.parameters);
    AppMethodBeat.o(17536);
    return localList;
  }
  
  public List<PathComponent> getViewPath()
  {
    AppMethodBeat.i(17535);
    List localList = Collections.unmodifiableList(this.path);
    AppMethodBeat.o(17535);
    return localList;
  }
  
  public static enum ActionType
  {
    static
    {
      AppMethodBeat.i(17529);
      CLICK = new ActionType("CLICK", 0);
      SELECTED = new ActionType("SELECTED", 1);
      TEXT_CHANGED = new ActionType("TEXT_CHANGED", 2);
      $VALUES = new ActionType[] { CLICK, SELECTED, TEXT_CHANGED };
      AppMethodBeat.o(17529);
    }
    
    private ActionType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.EventBinding
 * JD-Core Version:    0.7.0.1
 */