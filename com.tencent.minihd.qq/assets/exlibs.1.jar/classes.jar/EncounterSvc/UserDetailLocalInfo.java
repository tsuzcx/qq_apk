package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserDetailLocalInfo
  extends JceStruct
{
  public String strCity = "";
  public String strDistrict = "";
  public String strPremises = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  
  public UserDetailLocalInfo() {}
  
  public UserDetailLocalInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.strProvince = paramString1;
    this.strCity = paramString2;
    this.strDistrict = paramString3;
    this.strTown = paramString4;
    this.strRoad = paramString5;
    this.strPremises = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strProvince = paramJceInputStream.readString(0, true);
    this.strCity = paramJceInputStream.readString(1, true);
    this.strDistrict = paramJceInputStream.readString(2, true);
    this.strTown = paramJceInputStream.readString(3, true);
    this.strRoad = paramJceInputStream.readString(4, true);
    this.strPremises = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strProvince, 0);
    paramJceOutputStream.write(this.strCity, 1);
    paramJceOutputStream.write(this.strDistrict, 2);
    paramJceOutputStream.write(this.strTown, 3);
    paramJceOutputStream.write(this.strRoad, 4);
    paramJceOutputStream.write(this.strPremises, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.UserDetailLocalInfo
 * JD-Core Version:    0.7.0.1
 */