package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class TroopBarPageEntity$TroopBar
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_COVER = "cover";
  protected static final String JSON_KEY_CREATE_TIME = "create_time";
  protected static final String JSON_KEY_ERRNO = "errno";
  protected static final String JSON_KEY_FANS = "fans";
  protected static final String JSON_KEY_INTRO = "intro";
  protected static final String JSON_KEY_PIC = "pic";
  protected static final String JSON_KEY_PIDS = "pids";
  protected static final String JSON_KEY_RECOMMEND_PIDS = "recommend_pids";
  protected static final String JSON_KEY_TODAY_PIDS = "today_pids";
  protected static final long serialVersionUID = 10004L;
  public String cover;
  public long create_time;
  public int errno;
  public int fans;
  public String intro;
  public String pic;
  public int pids;
  public String recommend_pids;
  public int today_pids;
  
  public TroopBarPageEntity$TroopBar() {}
  
  public TroopBarPageEntity$TroopBar(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.cover = paramJSONObject.optString("cover", "");
    this.errno = paramJSONObject.optInt("errno", -1);
    this.pids = paramJSONObject.optInt("pids", -1);
    this.fans = paramJSONObject.optInt("fans", -1);
    this.today_pids = paramJSONObject.optInt("today_pids", -1);
    this.create_time = paramJSONObject.optLong("create_time", -1L);
    this.pic = paramJSONObject.optString("pic", "");
    this.recommend_pids = paramJSONObject.optString("recommend_pids", "");
    this.intro = paramJSONObject.optString("intro", "");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.cover = paramObjectInput.readUTF();
    this.errno = paramObjectInput.readInt();
    this.pids = paramObjectInput.readInt();
    this.fans = paramObjectInput.readInt();
    this.today_pids = paramObjectInput.readInt();
    this.create_time = paramObjectInput.readLong();
    this.pic = paramObjectInput.readUTF();
    this.recommend_pids = paramObjectInput.readUTF();
    this.intro = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.cover);
    paramObjectOutput.writeInt(this.errno);
    paramObjectOutput.writeInt(this.pids);
    paramObjectOutput.writeInt(this.fans);
    paramObjectOutput.writeInt(this.today_pids);
    paramObjectOutput.writeLong(this.create_time);
    paramObjectOutput.writeUTF(this.pic);
    paramObjectOutput.writeUTF(this.recommend_pids);
    paramObjectOutput.writeUTF(this.intro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity.TroopBar
 * JD-Core Version:    0.7.0.1
 */