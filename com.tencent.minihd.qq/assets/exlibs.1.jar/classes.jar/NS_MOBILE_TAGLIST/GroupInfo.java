package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupInfo
  extends JceStruct
{
  public short friendCount = 0;
  public String groupName = "";
  public byte seqId = 0;
  
  public GroupInfo() {}
  
  public GroupInfo(byte paramByte, String paramString, short paramShort)
  {
    this.seqId = paramByte;
    this.groupName = paramString;
    this.friendCount = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seqId = paramJceInputStream.read(this.seqId, 0, true);
    this.groupName = paramJceInputStream.readString(1, true);
    this.friendCount = paramJceInputStream.read(this.friendCount, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqId, 0);
    paramJceOutputStream.write(this.groupName, 1);
    paramJceOutputStream.write(this.friendCount, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.GroupInfo
 * JD-Core Version:    0.7.0.1
 */