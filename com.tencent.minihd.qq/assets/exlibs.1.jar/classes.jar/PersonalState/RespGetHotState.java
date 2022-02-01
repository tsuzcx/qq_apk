package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetHotState
  extends JceStruct
{
  static BusiRespHead cache_oHead;
  static ArrayList cache_vHostRichSateList;
  public BusiRespHead oHead = null;
  public ArrayList vHostRichSateList = null;
  
  public RespGetHotState() {}
  
  public RespGetHotState(BusiRespHead paramBusiRespHead, ArrayList paramArrayList)
  {
    this.oHead = paramBusiRespHead;
    this.vHostRichSateList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiRespHead();
    }
    this.oHead = ((BusiRespHead)paramJceInputStream.read(cache_oHead, 0, true));
    if (cache_vHostRichSateList == null)
    {
      cache_vHostRichSateList = new ArrayList();
      HotRishState localHotRishState = new HotRishState();
      cache_vHostRichSateList.add(localHotRishState);
    }
    this.vHostRichSateList = ((ArrayList)paramJceInputStream.read(cache_vHostRichSateList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
    paramJceOutputStream.write(this.vHostRichSateList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     PersonalState.RespGetHotState
 * JD-Core Version:    0.7.0.1
 */