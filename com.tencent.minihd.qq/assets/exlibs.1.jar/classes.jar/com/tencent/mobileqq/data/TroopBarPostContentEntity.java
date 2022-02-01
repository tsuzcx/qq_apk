package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPostContentEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_ADDR = "addr";
  protected static final String JSON_KEY_CHANNEL = "channel";
  protected static final String JSON_KEY_CONTENT = "content";
  protected static final String JSON_KEY_IMAGE1 = "image1";
  protected static final String JSON_KEY_IMAGE2 = "image2";
  protected static final String JSON_KEY_PIC_LITS = "pic_list";
  protected static final String JSON_KEY_PRICE = "price";
  protected static final String JSON_KEY_SPONSOR = "sponsor";
  protected static final String JSON_KEY_TAG = "tag";
  protected static final String JSON_KEY_TIME = "time";
  protected static final long serialVersionUID = 10000L;
  public String addr;
  public String channel;
  public String content;
  public String image1;
  public String image2;
  public ArrayList pic_lists;
  public String price;
  public String sponsor;
  public String tag;
  public String time;
  
  public TroopBarPostContentEntity() {}
  
  public TroopBarPostContentEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.content = paramJSONObject.optString("content", "");
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("pic_list");
      this.pic_lists = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        this.pic_lists.add(new TroopBarPostContentEntity.Pic_list(localJSONArray.getJSONObject(i)));
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      this.time = paramJSONObject.optString("time", "");
      this.price = paramJSONObject.optString("price", "");
      this.tag = paramJSONObject.optString("tag", "");
      this.addr = paramJSONObject.optString("addr", "");
      this.sponsor = paramJSONObject.optString("sponsor", "");
      this.image2 = paramJSONObject.optString("image2", "");
      this.image1 = paramJSONObject.optString("image1", "");
      this.channel = paramJSONObject.optString("channel", "");
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.content = paramObjectInput.readUTF();
    this.pic_lists = ((ArrayList)paramObjectInput.readObject());
    this.time = paramObjectInput.readUTF();
    this.price = paramObjectInput.readUTF();
    this.tag = paramObjectInput.readUTF();
    this.addr = paramObjectInput.readUTF();
    this.sponsor = paramObjectInput.readUTF();
    this.image2 = paramObjectInput.readUTF();
    this.image1 = paramObjectInput.readUTF();
    this.channel = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.content);
    paramObjectOutput.writeObject(this.pic_lists);
    paramObjectOutput.writeUTF(this.time);
    paramObjectOutput.writeUTF(this.price);
    paramObjectOutput.writeUTF(this.tag);
    paramObjectOutput.writeUTF(this.addr);
    paramObjectOutput.writeUTF(this.sponsor);
    paramObjectOutput.writeUTF(this.image2);
    paramObjectOutput.writeUTF(this.image1);
    paramObjectOutput.writeUTF(this.channel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPostContentEntity
 * JD-Core Version:    0.7.0.1
 */