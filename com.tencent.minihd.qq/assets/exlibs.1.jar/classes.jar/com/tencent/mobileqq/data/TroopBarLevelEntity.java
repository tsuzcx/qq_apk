package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class TroopBarLevelEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_DIY = "diy";
  protected static final String JSON_KEY_LEVEL = "level";
  protected static final String JSON_KEY_NEXT = "next";
  protected static final String JSON_KEY_PERCENT = "percent";
  protected static final String JSON_KEY_POINT = "point";
  protected static final long serialVersionUID = 10001L;
  public int diy;
  public int level;
  public int next;
  public int percent;
  public int point;
  
  public TroopBarLevelEntity() {}
  
  public TroopBarLevelEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.point = paramJSONObject.optInt("point", -1);
    this.level = paramJSONObject.optInt("level", -1);
    this.percent = paramJSONObject.optInt("percent", -1);
    this.diy = paramJSONObject.optInt("diy", -1);
    this.next = paramJSONObject.optInt("next", -1);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.point = paramObjectInput.readInt();
    this.level = paramObjectInput.readInt();
    this.percent = paramObjectInput.readInt();
    this.diy = paramObjectInput.readInt();
    this.next = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.point);
    paramObjectOutput.writeInt(this.level);
    paramObjectOutput.writeInt(this.percent);
    paramObjectOutput.writeInt(this.diy);
    paramObjectOutput.writeInt(this.next);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarLevelEntity
 * JD-Core Version:    0.7.0.1
 */