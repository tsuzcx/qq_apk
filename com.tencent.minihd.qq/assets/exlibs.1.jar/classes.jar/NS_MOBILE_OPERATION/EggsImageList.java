package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class EggsImageList
  extends JceStruct
{
  static ArrayList cache_vecEggsImage;
  public ArrayList vecEggsImage = null;
  
  public EggsImageList() {}
  
  public EggsImageList(ArrayList paramArrayList)
  {
    this.vecEggsImage = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecEggsImage == null)
    {
      cache_vecEggsImage = new ArrayList();
      EggsImage localEggsImage = new EggsImage();
      cache_vecEggsImage.add(localEggsImage);
    }
    this.vecEggsImage = ((ArrayList)paramJceInputStream.read(cache_vecEggsImage, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecEggsImage != null) {
      paramJceOutputStream.write(this.vecEggsImage, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.EggsImageList
 * JD-Core Version:    0.7.0.1
 */