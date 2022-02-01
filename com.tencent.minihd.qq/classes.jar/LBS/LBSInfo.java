package LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;

public final class LBSInfo
  extends JceStruct
{
  static Attr cache_stAttr;
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static ArrayList<Wifi> cache_vWifis;
  public Attr stAttr = null;
  public GPS stGps = null;
  public ArrayList<Cell> vCells = null;
  public ArrayList<Wifi> vWifis = null;
  
  public LBSInfo() {}
  
  public LBSInfo(GPS paramGPS, ArrayList<Wifi> paramArrayList, ArrayList<Cell> paramArrayList1, Attr paramAttr)
  {
    this.stGps = paramGPS;
    this.vWifis = paramArrayList;
    this.vCells = paramArrayList1;
    this.stAttr = paramAttr;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, false));
    Object localObject;
    if (cache_vWifis == null)
    {
      cache_vWifis = new ArrayList();
      localObject = new Wifi();
      cache_vWifis.add(localObject);
    }
    this.vWifis = ((ArrayList)paramJceInputStream.read(cache_vWifis, 1, false));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      localObject = new Cell();
      cache_vCells.add(localObject);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, false));
    if (cache_stAttr == null) {
      cache_stAttr = new Attr();
    }
    this.stAttr = ((Attr)paramJceInputStream.read(cache_stAttr, 3, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LBSInfo[\n");
    if (this.stGps != null) {
      localStringBuilder.append(this.stGps.toString());
    }
    if (this.stAttr != null) {
      localStringBuilder.append(this.stAttr.toString());
    }
    Iterator localIterator;
    if ((this.vCells != null) && (this.vCells.size() > 0))
    {
      localIterator = this.vCells.iterator();
      if (localIterator.hasNext()) {}
    }
    else if ((this.vWifis != null) && (this.vWifis.size() > 0))
    {
      localIterator = this.vWifis.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
        localStringBuilder.append(((Cell)localIterator.next()).toString());
        break;
      }
      localStringBuilder.append(((Wifi)localIterator.next()).toString());
    }
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 0);
    }
    if (this.vWifis != null) {
      paramJceOutputStream.write(this.vWifis, 1);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 2);
    }
    if (this.stAttr != null) {
      paramJceOutputStream.write(this.stAttr, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     LBS.LBSInfo
 * JD-Core Version:    0.7.0.1
 */