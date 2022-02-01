package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DateCard
  extends JceStruct
{
  static byte[] cache_vDateInfo;
  static byte[] cache_vFaces;
  public byte bConstellation = 0;
  public byte bMarriage = 0;
  public String strCompany = "";
  public String strDistance = "";
  public String strElapse = "";
  public String strSchool = "";
  public long uHomeCity = 0L;
  public long uHomeCountry = 0L;
  public long uHomeProvince = 0L;
  public long uHomeZone = 0L;
  public long uProfession = 0L;
  public byte[] vDateInfo = null;
  public byte[] vFaces = null;
  
  public DateCard() {}
  
  public DateCard(byte[] paramArrayOfByte1, byte paramByte1, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte2, String paramString3, String paramString4, byte paramByte2, long paramLong5)
  {
    this.vFaces = paramArrayOfByte1;
    this.bConstellation = paramByte1;
    this.uProfession = paramLong1;
    this.strCompany = paramString1;
    this.strSchool = paramString2;
    this.uHomeCountry = paramLong2;
    this.uHomeProvince = paramLong3;
    this.uHomeCity = paramLong4;
    this.vDateInfo = paramArrayOfByte2;
    this.strDistance = paramString3;
    this.strElapse = paramString4;
    this.bMarriage = paramByte2;
    this.uHomeZone = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vFaces == null)
    {
      cache_vFaces = (byte[])new byte[1];
      ((byte[])cache_vFaces)[0] = 0;
    }
    this.vFaces = ((byte[])paramJceInputStream.read(cache_vFaces, 0, false));
    this.bConstellation = paramJceInputStream.read(this.bConstellation, 1, false);
    this.uProfession = paramJceInputStream.read(this.uProfession, 2, false);
    this.strCompany = paramJceInputStream.readString(3, false);
    this.strSchool = paramJceInputStream.readString(4, false);
    this.uHomeCountry = paramJceInputStream.read(this.uHomeCountry, 5, false);
    this.uHomeProvince = paramJceInputStream.read(this.uHomeProvince, 6, false);
    this.uHomeCity = paramJceInputStream.read(this.uHomeCity, 7, false);
    if (cache_vDateInfo == null)
    {
      cache_vDateInfo = (byte[])new byte[1];
      ((byte[])cache_vDateInfo)[0] = 0;
    }
    this.vDateInfo = ((byte[])paramJceInputStream.read(cache_vDateInfo, 8, false));
    this.strDistance = paramJceInputStream.readString(9, false);
    this.strElapse = paramJceInputStream.readString(10, false);
    this.bMarriage = paramJceInputStream.read(this.bMarriage, 11, false);
    this.uHomeZone = paramJceInputStream.read(this.uHomeZone, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vFaces != null) {
      paramJceOutputStream.write(this.vFaces, 0);
    }
    paramJceOutputStream.write(this.bConstellation, 1);
    paramJceOutputStream.write(this.uProfession, 2);
    if (this.strCompany != null) {
      paramJceOutputStream.write(this.strCompany, 3);
    }
    if (this.strSchool != null) {
      paramJceOutputStream.write(this.strSchool, 4);
    }
    paramJceOutputStream.write(this.uHomeCountry, 5);
    paramJceOutputStream.write(this.uHomeProvince, 6);
    paramJceOutputStream.write(this.uHomeCity, 7);
    if (this.vDateInfo != null) {
      paramJceOutputStream.write(this.vDateInfo, 8);
    }
    if (this.strDistance != null) {
      paramJceOutputStream.write(this.strDistance, 9);
    }
    if (this.strElapse != null) {
      paramJceOutputStream.write(this.strElapse, 10);
    }
    paramJceOutputStream.write(this.bMarriage, 11);
    paramJceOutputStream.write(this.uHomeZone, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     SummaryCard.DateCard
 * JD-Core Version:    0.7.0.1
 */