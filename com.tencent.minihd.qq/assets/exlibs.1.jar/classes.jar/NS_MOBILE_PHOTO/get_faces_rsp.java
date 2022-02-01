package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.stFaceItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class get_faces_rsp
  extends JceStruct
{
  static Map cache_facelist;
  public Map facelist = null;
  
  public get_faces_rsp() {}
  
  public get_faces_rsp(Map paramMap)
  {
    this.facelist = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_facelist == null)
    {
      cache_facelist = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new stFaceItem());
      cache_facelist.put("", localArrayList);
    }
    this.facelist = ((Map)paramJceInputStream.read(cache_facelist, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.facelist != null) {
      paramJceOutputStream.write(this.facelist, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_faces_rsp
 * JD-Core Version:    0.7.0.1
 */