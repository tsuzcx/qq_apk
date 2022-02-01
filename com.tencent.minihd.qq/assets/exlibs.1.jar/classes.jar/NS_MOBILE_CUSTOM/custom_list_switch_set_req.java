package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class custom_list_switch_set_req
  extends JceStruct
{
  public int iAvatar = 0;
  public int iFacade = 0;
  public int iFeedSkin = 0;
  public int iSetItemBits = 0;
  
  public custom_list_switch_set_req() {}
  
  public custom_list_switch_set_req(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iSetItemBits = paramInt1;
    this.iFeedSkin = paramInt2;
    this.iFacade = paramInt3;
    this.iAvatar = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iSetItemBits = paramJceInputStream.read(this.iSetItemBits, 0, false);
    this.iFeedSkin = paramJceInputStream.read(this.iFeedSkin, 1, false);
    this.iFacade = paramJceInputStream.read(this.iFacade, 2, false);
    this.iAvatar = paramJceInputStream.read(this.iAvatar, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iSetItemBits, 0);
    paramJceOutputStream.write(this.iFeedSkin, 1);
    paramJceOutputStream.write(this.iFacade, 2);
    paramJceOutputStream.write(this.iAvatar, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_set_req
 * JD-Core Version:    0.7.0.1
 */