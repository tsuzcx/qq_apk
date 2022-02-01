package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ParameterComponent
{
  private static final String PARAMETER_NAME_KEY = "name";
  private static final String PARAMETER_PATH_KEY = "path";
  private static final String PARAMETER_VALUE_KEY = "value";
  public final String name;
  public final List<PathComponent> path;
  public final String pathType;
  public final String value;
  
  public ParameterComponent(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17537);
    this.name = paramJSONObject.getString("name");
    this.value = paramJSONObject.optString("value");
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("path");
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(new PathComponent(localJSONArray.getJSONObject(i)));
        i += 1;
      }
    }
    this.path = localArrayList;
    this.pathType = paramJSONObject.optString("path_type", "absolute");
    AppMethodBeat.o(17537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.ParameterComponent
 * JD-Core Version:    0.7.0.1
 */