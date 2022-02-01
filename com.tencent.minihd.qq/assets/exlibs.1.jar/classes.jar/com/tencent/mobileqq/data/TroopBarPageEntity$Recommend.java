package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPageEntity$Recommend
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_BID = "bid";
  protected static final String JSON_KEY_BRIEF = "brief";
  protected static final String JSON_KEY_PID = "pid";
  protected static final String JSON_KEY_POST = "post";
  protected static final String JSON_KEY_TIME = "time";
  protected static final String JSON_KEY_TITLE = "title";
  protected static final String JSON_KEY_TOTAL_COMMENT = "total_comment";
  protected static final String JSON_KEY_TYPE = "type";
  protected static final String JSON_KEY_UIN = "uin";
  protected static final long serialVersionUID = 10003L;
  public String bid;
  public String brief;
  public String pid;
  public TroopBarPostContentEntity post;
  public long time;
  public String title;
  public String total_comment;
  public int type;
  public long uin;
  
  public TroopBarPageEntity$Recommend() {}
  
  public TroopBarPageEntity$Recommend(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.type = paramJSONObject.optInt("type", -1);
    this.title = paramJSONObject.optString("title", "");
    this.time = paramJSONObject.optLong("time", -1L);
    try
    {
      this.post = new TroopBarPostContentEntity(paramJSONObject.getJSONObject("post"));
      label58:
      this.uin = paramJSONObject.optLong("uin", -1L);
      this.pid = paramJSONObject.optString("pid", "");
      this.bid = paramJSONObject.optString("bid", "");
      this.brief = paramJSONObject.optString("brief", "");
      this.total_comment = paramJSONObject.optString("total_comment", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label58;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.type = paramObjectInput.readInt();
    this.title = paramObjectInput.readUTF();
    this.time = paramObjectInput.readLong();
    this.post = ((TroopBarPostContentEntity)paramObjectInput.readObject());
    this.uin = paramObjectInput.readLong();
    this.pid = paramObjectInput.readUTF();
    this.bid = paramObjectInput.readUTF();
    this.brief = paramObjectInput.readUTF();
    this.total_comment = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.type);
    paramObjectOutput.writeUTF(this.title);
    paramObjectOutput.writeLong(this.time);
    paramObjectOutput.writeObject(this.post);
    paramObjectOutput.writeLong(this.uin);
    paramObjectOutput.writeUTF(this.pid);
    paramObjectOutput.writeUTF(this.bid);
    paramObjectOutput.writeUTF(this.brief);
    paramObjectOutput.writeUTF(this.total_comment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity.Recommend
 * JD-Core Version:    0.7.0.1
 */