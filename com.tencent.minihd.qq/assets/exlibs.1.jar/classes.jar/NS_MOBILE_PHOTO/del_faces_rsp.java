package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class del_faces_rsp
  extends JceStruct
{
  static ArrayList cache_resultlist;
  public String msg = "";
  public ArrayList resultlist = null;
  public int ret = 0;
  
  public del_faces_rsp() {}
  
  public del_faces_rsp(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.resultlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_resultlist == null)
    {
      cache_resultlist = new ArrayList();
      stUpdateItemResult localstUpdateItemResult = new stUpdateItemResult();
      cache_resultlist.add(localstUpdateItemResult);
    }
    this.resultlist = ((ArrayList)paramJceInputStream.read(cache_resultlist, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.resultlist != null) {
      paramJceOutputStream.write(this.resultlist, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.del_faces_rsp
 * JD-Core Version:    0.7.0.1
 */