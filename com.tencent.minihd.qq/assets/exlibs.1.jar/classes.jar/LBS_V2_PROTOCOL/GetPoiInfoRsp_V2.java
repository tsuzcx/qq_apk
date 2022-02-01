package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetPoiInfoRsp_V2
  extends JceStruct
{
  static ArrayList cache_vPoiList;
  public int iHasMore = 1;
  public int iTotalNum = 0;
  public String strAttachInfo = "";
  public ArrayList vPoiList = null;
  
  public GetPoiInfoRsp_V2() {}
  
  public GetPoiInfoRsp_V2(ArrayList paramArrayList, int paramInt1, String paramString, int paramInt2)
  {
    this.vPoiList = paramArrayList;
    this.iTotalNum = paramInt1;
    this.strAttachInfo = paramString;
    this.iHasMore = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPoiList == null)
    {
      cache_vPoiList = new ArrayList();
      PoiInfo_V2 localPoiInfo_V2 = new PoiInfo_V2();
      cache_vPoiList.add(localPoiInfo_V2);
    }
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 0, true));
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 1, false);
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vPoiList, 0);
    paramJceOutputStream.write(this.iTotalNum, 1);
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetPoiInfoRsp_V2
 * JD-Core Version:    0.7.0.1
 */