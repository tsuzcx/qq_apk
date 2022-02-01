package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class PathComponent
{
  private static final String PATH_CLASS_NAME_KEY = "class_name";
  private static final String PATH_DESCRIPTION_KEY = "description";
  private static final String PATH_HINT_KEY = "hint";
  private static final String PATH_ID_KEY = "id";
  private static final String PATH_INDEX_KEY = "index";
  private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
  private static final String PATH_TAG_KEY = "tag";
  private static final String PATH_TEXT_KEY = "text";
  public final String className;
  public final String description;
  public final String hint;
  public final int id;
  public final int index;
  public final int matchBitmask;
  public final String tag;
  public final String text;
  
  PathComponent(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(17541);
    this.className = paramJSONObject.getString("class_name");
    this.index = paramJSONObject.optInt("index", -1);
    this.id = paramJSONObject.optInt("id");
    this.text = paramJSONObject.optString("text");
    this.tag = paramJSONObject.optString("tag");
    this.description = paramJSONObject.optString("description");
    this.hint = paramJSONObject.optString("hint");
    this.matchBitmask = paramJSONObject.optInt("match_bitmask");
    AppMethodBeat.o(17541);
  }
  
  public static enum MatchBitmaskType
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(17540);
      ID = new MatchBitmaskType("ID", 0, 1);
      TEXT = new MatchBitmaskType("TEXT", 1, 2);
      TAG = new MatchBitmaskType("TAG", 2, 4);
      DESCRIPTION = new MatchBitmaskType("DESCRIPTION", 3, 8);
      HINT = new MatchBitmaskType("HINT", 4, 16);
      $VALUES = new MatchBitmaskType[] { ID, TEXT, TAG, DESCRIPTION, HINT };
      AppMethodBeat.o(17540);
    }
    
    private MatchBitmaskType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.PathComponent
 * JD-Core Version:    0.7.0.1
 */