package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class add_faces_req
  extends JceStruct
{
  static stFaceTwitterExtData cache_extdata;
  static ArrayList cache_facelist;
  public String albumid = "";
  public stFaceTwitterExtData extdata = null;
  public ArrayList facelist = null;
  public long owneruin = 0L;
  public int quanfrom = 0;
  
  public add_faces_req() {}
  
  public add_faces_req(String paramString, ArrayList paramArrayList, int paramInt, stFaceTwitterExtData paramstFaceTwitterExtData, long paramLong)
  {
    this.albumid = paramString;
    this.facelist = paramArrayList;
    this.quanfrom = paramInt;
    this.extdata = paramstFaceTwitterExtData;
    this.owneruin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    if (cache_facelist == null)
    {
      cache_facelist = new ArrayList();
      stFaceItem localstFaceItem = new stFaceItem();
      cache_facelist.add(localstFaceItem);
    }
    this.facelist = ((ArrayList)paramJceInputStream.read(cache_facelist, 1, true));
    this.quanfrom = paramJceInputStream.read(this.quanfrom, 2, true);
    if (cache_extdata == null) {
      cache_extdata = new stFaceTwitterExtData();
    }
    this.extdata = ((stFaceTwitterExtData)paramJceInputStream.read(cache_extdata, 3, false));
    this.owneruin = paramJceInputStream.read(this.owneruin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.facelist, 1);
    paramJceOutputStream.write(this.quanfrom, 2);
    if (this.extdata != null) {
      paramJceOutputStream.write(this.extdata, 3);
    }
    paramJceOutputStream.write(this.owneruin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.add_faces_req
 * JD-Core Version:    0.7.0.1
 */