package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceRespV2
  extends JceStruct
{
  static ArrayList<GetResourceRespInfoV2> cache_vecAddedResInfo;
  static ArrayList<GetResourceRespInfoV2> cache_vecDeletedResInfo;
  static ArrayList<GetResourceRespInfoV2> cache_vecUpdatedResInfo;
  public byte result = 0;
  public long uin = 0L;
  public ArrayList<GetResourceRespInfoV2> vecAddedResInfo = null;
  public ArrayList<GetResourceRespInfoV2> vecDeletedResInfo = null;
  public ArrayList<GetResourceRespInfoV2> vecUpdatedResInfo = null;
  
  public GetResourceRespV2() {}
  
  public GetResourceRespV2(long paramLong, byte paramByte, ArrayList<GetResourceRespInfoV2> paramArrayList1, ArrayList<GetResourceRespInfoV2> paramArrayList2, ArrayList<GetResourceRespInfoV2> paramArrayList3)
  {
    this.uin = paramLong;
    this.result = paramByte;
    this.vecAddedResInfo = paramArrayList1;
    this.vecDeletedResInfo = paramArrayList2;
    this.vecUpdatedResInfo = paramArrayList3;
  }
  
  public String className()
  {
    return "KQQConfig.GetResourceRespV2";
  }
  
  public String fullClassName()
  {
    return "protocol.KQQConfig.GetResourceRespV2";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    GetResourceRespInfoV2 localGetResourceRespInfoV2;
    if (cache_vecAddedResInfo == null)
    {
      cache_vecAddedResInfo = new ArrayList();
      localGetResourceRespInfoV2 = new GetResourceRespInfoV2();
      cache_vecAddedResInfo.add(localGetResourceRespInfoV2);
    }
    this.vecAddedResInfo = ((ArrayList)paramJceInputStream.read(cache_vecAddedResInfo, 2, true));
    if (cache_vecDeletedResInfo == null)
    {
      cache_vecDeletedResInfo = new ArrayList();
      localGetResourceRespInfoV2 = new GetResourceRespInfoV2();
      cache_vecDeletedResInfo.add(localGetResourceRespInfoV2);
    }
    this.vecDeletedResInfo = ((ArrayList)paramJceInputStream.read(cache_vecDeletedResInfo, 3, true));
    if (cache_vecUpdatedResInfo == null)
    {
      cache_vecUpdatedResInfo = new ArrayList();
      localGetResourceRespInfoV2 = new GetResourceRespInfoV2();
      cache_vecUpdatedResInfo.add(localGetResourceRespInfoV2);
    }
    this.vecUpdatedResInfo = ((ArrayList)paramJceInputStream.read(cache_vecUpdatedResInfo, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecAddedResInfo, 2);
    paramJceOutputStream.write(this.vecDeletedResInfo, 3);
    paramJceOutputStream.write(this.vecUpdatedResInfo, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceRespV2
 * JD-Core Version:    0.7.0.1
 */