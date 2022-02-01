package NeighborSvc;

import EncounterSvc.EntranceContent;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetEntrance
  extends JceStruct
{
  static ArrayList cache_entrance_list;
  public ArrayList entrance_list = null;
  
  public RespGetEntrance() {}
  
  public RespGetEntrance(ArrayList paramArrayList)
  {
    this.entrance_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_entrance_list == null)
    {
      cache_entrance_list = new ArrayList();
      EntranceContent localEntranceContent = new EntranceContent();
      cache_entrance_list.add(localEntranceContent);
    }
    this.entrance_list = ((ArrayList)paramJceInputStream.read(cache_entrance_list, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.entrance_list != null) {
      paramJceOutputStream.write(this.entrance_list, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NeighborSvc.RespGetEntrance
 * JD-Core Version:    0.7.0.1
 */