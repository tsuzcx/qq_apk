package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FriendInfo
  extends JceStruct
{
  public byte groupId = 0;
  public String nick = "";
  
  public FriendInfo() {}
  
  public FriendInfo(byte paramByte, String paramString)
  {
    this.groupId = paramByte;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.groupId = paramJceInputStream.read(this.groupId, 0, true);
    this.nick = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.groupId, 0);
    paramJceOutputStream.write(this.nick, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.FriendInfo
 * JD-Core Version:    0.7.0.1
 */