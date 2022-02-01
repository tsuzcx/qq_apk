package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomSettingCell
  extends JceStruct
{
  public int iCellId = 0;
  public int iHasNewFlag = 0;
  public String strDetail = "";
  public String strImageUrl = "";
  public String strSchemaUrl = "";
  public String strTitle = "";
  public int uiCount = 0;
  
  public CustomSettingCell() {}
  
  public CustomSettingCell(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    this.iCellId = paramInt1;
    this.strTitle = paramString1;
    this.strDetail = paramString2;
    this.uiCount = paramInt2;
    this.strImageUrl = paramString3;
    this.strSchemaUrl = paramString4;
    this.iHasNewFlag = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCellId = paramJceInputStream.read(this.iCellId, 0, true);
    this.strTitle = paramJceInputStream.readString(1, false);
    this.strDetail = paramJceInputStream.readString(2, false);
    this.uiCount = paramJceInputStream.read(this.uiCount, 3, false);
    this.strImageUrl = paramJceInputStream.readString(4, false);
    this.strSchemaUrl = paramJceInputStream.readString(5, false);
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCellId, 0);
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 1);
    }
    if (this.strDetail != null) {
      paramJceOutputStream.write(this.strDetail, 2);
    }
    paramJceOutputStream.write(this.uiCount, 3);
    if (this.strImageUrl != null) {
      paramJceOutputStream.write(this.strImageUrl, 4);
    }
    if (this.strSchemaUrl != null) {
      paramJceOutputStream.write(this.strSchemaUrl, 5);
    }
    paramJceOutputStream.write(this.iHasNewFlag, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.CustomSettingCell
 * JD-Core Version:    0.7.0.1
 */