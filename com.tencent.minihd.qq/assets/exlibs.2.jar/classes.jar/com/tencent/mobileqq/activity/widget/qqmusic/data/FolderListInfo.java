package com.tencent.mobileqq.activity.widget.qqmusic.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FolderListInfo
  extends BaseJsonInfo
{
  private int jdField_a_of_type_Int;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      super.a(paramJSONObject);
      paramJSONObject = paramJSONObject.optJSONArray("d");
      if (paramJSONObject != null)
      {
        this.a = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            FolderInfo localFolderInfo = new FolderInfo();
            localFolderInfo.a(localJSONObject);
            this.a.add(localFolderInfo);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.FolderListInfo
 * JD-Core Version:    0.7.0.1
 */