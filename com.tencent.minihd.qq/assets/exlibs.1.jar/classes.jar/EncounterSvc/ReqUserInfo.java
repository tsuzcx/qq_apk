package EncounterSvc;

import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqUserInfo
  extends JceStruct
{
  static int cache_eListType;
  static int cache_eLocalInfo;
  static GPS cache_stGps;
  static ArrayList cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList cache_vMacs;
  static ArrayList cache_vSOSOCells;
  static ArrayList cache_vSOSOMac;
  public int eListType = 1;
  public int eLocalInfo = 0;
  public GPS stGps = null;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public ArrayList vCells = null;
  public byte[] vLBSKeyData = null;
  public ArrayList vMacs = null;
  public ArrayList vSOSOCells = null;
  public ArrayList vSOSOMac = null;
  
  public ReqUserInfo() {}
  
  public ReqUserInfo(GPS paramGPS, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.stGps = paramGPS;
    this.vMacs = paramArrayList1;
    this.vCells = paramArrayList2;
    this.strAuthName = paramString1;
    this.strAuthPassword = paramString2;
    this.eListType = paramInt1;
    this.eLocalInfo = paramInt2;
    this.vLBSKeyData = paramArrayOfByte;
    this.vSOSOMac = paramArrayList3;
    this.vSOSOCells = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, false));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 1, false));
    Object localObject;
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      localObject = new Cell();
      cache_vCells.add(localObject);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, false));
    this.strAuthName = paramJceInputStream.readString(3, false);
    this.strAuthPassword = paramJceInputStream.readString(4, false);
    this.eListType = paramJceInputStream.read(this.eListType, 5, false);
    this.eLocalInfo = paramJceInputStream.read(this.eLocalInfo, 6, false);
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 7, false));
    if (cache_vSOSOMac == null)
    {
      cache_vSOSOMac = new ArrayList();
      localObject = new SOSO_Wifi();
      cache_vSOSOMac.add(localObject);
    }
    this.vSOSOMac = ((ArrayList)paramJceInputStream.read(cache_vSOSOMac, 8, false));
    if (cache_vSOSOCells == null)
    {
      cache_vSOSOCells = new ArrayList();
      localObject = new SOSO_Cell();
      cache_vSOSOCells.add(localObject);
    }
    this.vSOSOCells = ((ArrayList)paramJceInputStream.read(cache_vSOSOCells, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 0);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 1);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 2);
    }
    if (this.strAuthName != null) {
      paramJceOutputStream.write(this.strAuthName, 3);
    }
    if (this.strAuthPassword != null) {
      paramJceOutputStream.write(this.strAuthPassword, 4);
    }
    paramJceOutputStream.write(this.eListType, 5);
    paramJceOutputStream.write(this.eLocalInfo, 6);
    if (this.vLBSKeyData != null) {
      paramJceOutputStream.write(this.vLBSKeyData, 7);
    }
    if (this.vSOSOMac != null) {
      paramJceOutputStream.write(this.vSOSOMac, 8);
    }
    if (this.vSOSOCells != null) {
      paramJceOutputStream.write(this.vSOSOCells, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.ReqUserInfo
 * JD-Core Version:    0.7.0.1
 */