package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetMultiTroopInfoReq
  extends JceStruct
{
  static ArrayList<Long> cache_vecGroupCode;
  public byte cRichInfo = 0;
  public long uin = 0L;
  public ArrayList<Long> vecGroupCode = null;
  
  public GetMultiTroopInfoReq() {}
  
  public GetMultiTroopInfoReq(long paramLong, ArrayList<Long> paramArrayList, byte paramByte)
  {
    this.uin = paramLong;
    this.vecGroupCode = paramArrayList;
    this.cRichInfo = paramByte;
  }
  
  public String className()
  {
    return "friendlist.GetMultiTroopInfoReq";
  }
  
  public String fullClassName()
  {
    return "friendlist.GetMultiTroopInfoReq";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_vecGroupCode == null)
    {
      cache_vecGroupCode = new ArrayList();
      cache_vecGroupCode.add(Long.valueOf(0L));
    }
    this.vecGroupCode = ((ArrayList)paramJceInputStream.read(cache_vecGroupCode, 1, true));
    this.cRichInfo = paramJceInputStream.read(this.cRichInfo, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.vecGroupCode, 1);
    paramJceOutputStream.write(this.cRichInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     friendlist.GetMultiTroopInfoReq
 * JD-Core Version:    0.7.0.1
 */