package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RichText
  extends JceStruct
{
  static ArrayList cache_vElem;
  public ArrayList vElem = null;
  
  public RichText() {}
  
  public RichText(ArrayList paramArrayList)
  {
    this.vElem = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vElem == null)
    {
      cache_vElem = new ArrayList();
      stElem localstElem = new stElem();
      cache_vElem.add(localstElem);
    }
    this.vElem = ((ArrayList)paramJceInputStream.read(cache_vElem, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vElem != null) {
      paramJceOutputStream.write(this.vElem, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.RichText
 * JD-Core Version:    0.7.0.1
 */