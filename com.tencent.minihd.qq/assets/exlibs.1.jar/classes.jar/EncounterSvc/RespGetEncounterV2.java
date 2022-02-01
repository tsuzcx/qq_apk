package EncounterSvc;

import NeighborComm.EctFragmentation;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetEncounterV2
  extends JceStruct
{
  static ArrayList cache_entrance_list;
  static byte[] cache_nearbyGroupResp;
  static byte[] cache_nearbyPublicAcctResp;
  static ArrayList cache_neighbor_banners;
  static EctFragmentation cache_stEctFmt;
  static PengYouInfo cache_stPYInfo;
  static UserDetailLocalInfo cache_stUDLinfo;
  static UserData cache_stUserData;
  static ArrayList cache_vEncounterInfos;
  public long RespTime = 0L;
  public ArrayList entrance_list = null;
  public int iEncounterNumber = 0;
  public int iSessionTotalNumber = 0;
  public byte[] nearbyGroupResp = null;
  public byte[] nearbyPublicAcctResp = null;
  public ArrayList neighbor_banners = null;
  public EctFragmentation stEctFmt = null;
  public PengYouInfo stPYInfo = null;
  public UserDetailLocalInfo stUDLinfo = null;
  public UserData stUserData = null;
  public String strSecurityDetailUrl = "";
  public String strSecurityTips = "";
  public byte system_pic = 0;
  public ArrayList vEncounterInfos = null;
  
  public RespGetEncounterV2() {}
  
  public RespGetEncounterV2(long paramLong, UserData paramUserData, ArrayList paramArrayList1, UserDetailLocalInfo paramUserDetailLocalInfo, PengYouInfo paramPengYouInfo, EctFragmentation paramEctFragmentation, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, String paramString2, ArrayList paramArrayList2, ArrayList paramArrayList3, byte paramByte)
  {
    this.RespTime = paramLong;
    this.stUserData = paramUserData;
    this.vEncounterInfos = paramArrayList1;
    this.stUDLinfo = paramUserDetailLocalInfo;
    this.stPYInfo = paramPengYouInfo;
    this.stEctFmt = paramEctFragmentation;
    this.iSessionTotalNumber = paramInt1;
    this.iEncounterNumber = paramInt2;
    this.nearbyGroupResp = paramArrayOfByte1;
    this.nearbyPublicAcctResp = paramArrayOfByte2;
    this.strSecurityTips = paramString1;
    this.strSecurityDetailUrl = paramString2;
    this.entrance_list = paramArrayList2;
    this.neighbor_banners = paramArrayList3;
    this.system_pic = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.RespTime = paramJceInputStream.read(this.RespTime, 0, true);
    if (cache_stUserData == null) {
      cache_stUserData = new UserData();
    }
    this.stUserData = ((UserData)paramJceInputStream.read(cache_stUserData, 1, true));
    Object localObject;
    if (cache_vEncounterInfos == null)
    {
      cache_vEncounterInfos = new ArrayList();
      localObject = new RespEncounterInfo();
      cache_vEncounterInfos.add(localObject);
    }
    this.vEncounterInfos = ((ArrayList)paramJceInputStream.read(cache_vEncounterInfos, 2, false));
    if (cache_stUDLinfo == null) {
      cache_stUDLinfo = new UserDetailLocalInfo();
    }
    this.stUDLinfo = ((UserDetailLocalInfo)paramJceInputStream.read(cache_stUDLinfo, 3, false));
    if (cache_stPYInfo == null) {
      cache_stPYInfo = new PengYouInfo();
    }
    this.stPYInfo = ((PengYouInfo)paramJceInputStream.read(cache_stPYInfo, 4, false));
    if (cache_stEctFmt == null) {
      cache_stEctFmt = new EctFragmentation();
    }
    this.stEctFmt = ((EctFragmentation)paramJceInputStream.read(cache_stEctFmt, 5, false));
    this.iSessionTotalNumber = paramJceInputStream.read(this.iSessionTotalNumber, 6, false);
    this.iEncounterNumber = paramJceInputStream.read(this.iEncounterNumber, 7, false);
    if (cache_nearbyGroupResp == null)
    {
      cache_nearbyGroupResp = (byte[])new byte[1];
      ((byte[])cache_nearbyGroupResp)[0] = 0;
    }
    this.nearbyGroupResp = ((byte[])paramJceInputStream.read(cache_nearbyGroupResp, 8, false));
    if (cache_nearbyPublicAcctResp == null)
    {
      cache_nearbyPublicAcctResp = (byte[])new byte[1];
      ((byte[])cache_nearbyPublicAcctResp)[0] = 0;
    }
    this.nearbyPublicAcctResp = ((byte[])paramJceInputStream.read(cache_nearbyPublicAcctResp, 9, false));
    this.strSecurityTips = paramJceInputStream.readString(10, false);
    this.strSecurityDetailUrl = paramJceInputStream.readString(11, false);
    if (cache_entrance_list == null)
    {
      cache_entrance_list = new ArrayList();
      localObject = new EntranceContent();
      cache_entrance_list.add(localObject);
    }
    this.entrance_list = ((ArrayList)paramJceInputStream.read(cache_entrance_list, 12, false));
    if (cache_neighbor_banners == null)
    {
      cache_neighbor_banners = new ArrayList();
      localObject = new NeighborBanner();
      cache_neighbor_banners.add(localObject);
    }
    this.neighbor_banners = ((ArrayList)paramJceInputStream.read(cache_neighbor_banners, 13, false));
    this.system_pic = paramJceInputStream.read(this.system_pic, 14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.RespTime, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    if (this.vEncounterInfos != null) {
      paramJceOutputStream.write(this.vEncounterInfos, 2);
    }
    if (this.stUDLinfo != null) {
      paramJceOutputStream.write(this.stUDLinfo, 3);
    }
    if (this.stPYInfo != null) {
      paramJceOutputStream.write(this.stPYInfo, 4);
    }
    if (this.stEctFmt != null) {
      paramJceOutputStream.write(this.stEctFmt, 5);
    }
    paramJceOutputStream.write(this.iSessionTotalNumber, 6);
    paramJceOutputStream.write(this.iEncounterNumber, 7);
    if (this.nearbyGroupResp != null) {
      paramJceOutputStream.write(this.nearbyGroupResp, 8);
    }
    if (this.nearbyPublicAcctResp != null) {
      paramJceOutputStream.write(this.nearbyPublicAcctResp, 9);
    }
    if (this.strSecurityTips != null) {
      paramJceOutputStream.write(this.strSecurityTips, 10);
    }
    if (this.strSecurityDetailUrl != null) {
      paramJceOutputStream.write(this.strSecurityDetailUrl, 11);
    }
    if (this.entrance_list != null) {
      paramJceOutputStream.write(this.entrance_list, 12);
    }
    if (this.neighbor_banners != null) {
      paramJceOutputStream.write(this.neighbor_banners, 13);
    }
    paramJceOutputStream.write(this.system_pic, 14);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.RespGetEncounterV2
 * JD-Core Version:    0.7.0.1
 */