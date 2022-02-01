package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class Type_1_QQDataTextMsg
  extends JceStruct
{
  static ArrayList cache_msg_item;
  public ArrayList msg_item = null;
  
  public Type_1_QQDataTextMsg() {}
  
  public Type_1_QQDataTextMsg(ArrayList paramArrayList)
  {
    this.msg_item = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_msg_item == null)
    {
      cache_msg_item = new ArrayList();
      MsgType0x210SubMsgType0x13_MsgItem localMsgType0x210SubMsgType0x13_MsgItem = new MsgType0x210SubMsgType0x13_MsgItem();
      cache_msg_item.add(localMsgType0x210SubMsgType0x13_MsgItem);
    }
    this.msg_item = ((ArrayList)paramJceInputStream.read(cache_msg_item, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.msg_item != null) {
      paramJceOutputStream.write(this.msg_item, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     IMMsgBodyPack.Type_1_QQDataTextMsg
 * JD-Core Version:    0.7.0.1
 */