package com.tencent.mobileqq.activity.widget.qqmusic.data;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class FolderSongListInfo
  extends BaseJsonInfo
{
  private ArrayList a;
  
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
      paramJSONObject = paramJSONObject.optJSONArray("songlist");
      if (paramJSONObject != null)
      {
        this.a = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            SongInfo localSongInfo = new SongInfo();
            localSongInfo.a(localJSONObject);
            this.a.add(localSongInfo);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.FolderSongListInfo
 * JD-Core Version:    0.7.0.1
 */