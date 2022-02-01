package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

class TroopBarPostEntity$TroopBarPostAddress
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_CITY = "city";
  protected static final String JSON_KEY_COUNTRY = "country";
  protected static final String JSON_KEY_LATITUDE = "latitude";
  protected static final String JSON_KEY_LONGITUDE = "longitude";
  protected static final String JSON_KEY_PROVINCE = "province";
  protected static final String JSON_KEY_STREET = "street";
  protected static final long serialVersionUID = 10006L;
  public String city;
  public String country;
  public long latitude;
  public long longitude;
  public String province;
  public String street;
  
  public TroopBarPostEntity$TroopBarPostAddress(TroopBarPostEntity paramTroopBarPostEntity) {}
  
  public TroopBarPostEntity$TroopBarPostAddress(TroopBarPostEntity paramTroopBarPostEntity, JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.street = paramJSONObject.optString("street", "");
    this.province = paramJSONObject.optString("province", "");
    this.longitude = paramJSONObject.optLong("longitude", -1L);
    this.latitude = paramJSONObject.optLong("latitude", -1L);
    this.city = paramJSONObject.optString("city", "");
    this.country = paramJSONObject.optString("country", "");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.street = paramObjectInput.readUTF();
    this.province = paramObjectInput.readUTF();
    this.longitude = paramObjectInput.readLong();
    this.latitude = paramObjectInput.readLong();
    this.city = paramObjectInput.readUTF();
    this.country = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.street);
    paramObjectOutput.writeUTF(this.province);
    paramObjectOutput.writeLong(this.longitude);
    paramObjectOutput.writeLong(this.latitude);
    paramObjectOutput.writeUTF(this.city);
    paramObjectOutput.writeUTF(this.country);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPostEntity.TroopBarPostAddress
 * JD-Core Version:    0.7.0.1
 */