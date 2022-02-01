package DCClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stDataCollectionReq
  extends JceStruct
{
  static ArrayList<stDataPackage> cache_dataPackages;
  public ArrayList<stDataPackage> dataPackages = null;
  
  public stDataCollectionReq() {}
  
  public stDataCollectionReq(ArrayList<stDataPackage> paramArrayList)
  {
    this.dataPackages = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_dataPackages == null)
    {
      cache_dataPackages = new ArrayList();
      stDataPackage localstDataPackage = new stDataPackage();
      cache_dataPackages.add(localstDataPackage);
    }
    this.dataPackages = ((ArrayList)paramJceInputStream.read(cache_dataPackages, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dataPackages, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     DCClientInterface.stDataCollectionReq
 * JD-Core Version:    0.7.0.1
 */