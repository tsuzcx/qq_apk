package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class custom_list_switch
  extends JceStruct
{
  public int iAvatar = 0;
  public int iFacade = 0;
  public int iFeedSkin = 0;
  
  public custom_list_switch() {}
  
  public custom_list_switch(int paramInt1, int paramInt2, int paramInt3)
  {
    this.iFeedSkin = paramInt1;
    this.iFacade = paramInt2;
    this.iAvatar = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFeedSkin = paramJceInputStream.read(this.iFeedSkin, 0, false);
    this.iFacade = paramJceInputStream.read(this.iFacade, 1, false);
    this.iAvatar = paramJceInputStream.read(this.iAvatar, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFeedSkin, 0);
    paramJceOutputStream.write(this.iFacade, 1);
    paramJceOutputStream.write(this.iAvatar, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch
 * JD-Core Version:    0.7.0.1
 */