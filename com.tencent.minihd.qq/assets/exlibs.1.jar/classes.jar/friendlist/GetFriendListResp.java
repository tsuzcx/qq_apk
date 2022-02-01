package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetFriendListResp
  extends JceStruct
{
  static int cache_reqtype;
  static int cache_result;
  static FriendInfo cache_stSelfInfo;
  static ArrayList cache_vecFriendInfo;
  static ArrayList cache_vecGroupInfo;
  static ArrayList cache_vecMSFGroupInfo;
  public byte cHasOtherRespFlag = 0;
  public byte cRespType = 0;
  public byte cShowPcIcon = 0;
  public short errorCode = 0;
  public short friend_count = 0;
  public short getfriendCount = 0;
  public byte getgroupCount = 0;
  public byte group_count = 0;
  public byte groupid = 0;
  public byte groupstartIndex = 0;
  public byte ifGetGroupInfo = 0;
  public byte ifReflush = 0;
  public short online_friend_count = 0;
  public int reqtype = 0;
  public int result = 0;
  public long serverTime = 0L;
  public short sqqOnLine_count = 0;
  public FriendInfo stSelfInfo = null;
  public short startIndex = 0;
  public short totoal_friend_count = 0;
  public short totoal_group_count = 0;
  public long uin = 0L;
  public ArrayList vecFriendInfo = null;
  public ArrayList vecGroupInfo = null;
  public ArrayList vecMSFGroupInfo = null;
  
  public GetFriendListResp() {}
  
  public GetFriendListResp(int paramInt1, byte paramByte1, long paramLong1, short paramShort1, short paramShort2, short paramShort3, short paramShort4, ArrayList paramArrayList1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, short paramShort5, byte paramByte6, ArrayList paramArrayList2, int paramInt2, short paramShort6, short paramShort7, long paramLong2, short paramShort8, ArrayList paramArrayList3, byte paramByte7, byte paramByte8, FriendInfo paramFriendInfo, byte paramByte9)
  {
    this.reqtype = paramInt1;
    this.ifReflush = paramByte1;
    this.uin = paramLong1;
    this.startIndex = paramShort1;
    this.getfriendCount = paramShort2;
    this.totoal_friend_count = paramShort3;
    this.friend_count = paramShort4;
    this.vecFriendInfo = paramArrayList1;
    this.groupid = paramByte2;
    this.ifGetGroupInfo = paramByte3;
    this.groupstartIndex = paramByte4;
    this.getgroupCount = paramByte5;
    this.totoal_group_count = paramShort5;
    this.group_count = paramByte6;
    this.vecGroupInfo = paramArrayList2;
    this.result = paramInt2;
    this.errorCode = paramShort6;
    this.online_friend_count = paramShort7;
    this.serverTime = paramLong2;
    this.sqqOnLine_count = paramShort8;
    this.vecMSFGroupInfo = paramArrayList3;
    this.cRespType = paramByte7;
    this.cHasOtherRespFlag = paramByte8;
    this.stSelfInfo = paramFriendInfo;
    this.cShowPcIcon = paramByte9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqtype = paramJceInputStream.read(this.reqtype, 0, true);
    this.ifReflush = paramJceInputStream.read(this.ifReflush, 1, true);
    this.uin = paramJceInputStream.read(this.uin, 2, true);
    this.startIndex = paramJceInputStream.read(this.startIndex, 3, true);
    this.getfriendCount = paramJceInputStream.read(this.getfriendCount, 4, true);
    this.totoal_friend_count = paramJceInputStream.read(this.totoal_friend_count, 5, true);
    this.friend_count = paramJceInputStream.read(this.friend_count, 6, true);
    Object localObject;
    if (cache_vecFriendInfo == null)
    {
      cache_vecFriendInfo = new ArrayList();
      localObject = new FriendInfo();
      cache_vecFriendInfo.add(localObject);
    }
    this.vecFriendInfo = ((ArrayList)paramJceInputStream.read(cache_vecFriendInfo, 7, true));
    this.groupid = paramJceInputStream.read(this.groupid, 8, false);
    this.ifGetGroupInfo = paramJceInputStream.read(this.ifGetGroupInfo, 9, true);
    this.groupstartIndex = paramJceInputStream.read(this.groupstartIndex, 10, false);
    this.getgroupCount = paramJceInputStream.read(this.getgroupCount, 11, false);
    this.totoal_group_count = paramJceInputStream.read(this.totoal_group_count, 12, false);
    this.group_count = paramJceInputStream.read(this.group_count, 13, false);
    if (cache_vecGroupInfo == null)
    {
      cache_vecGroupInfo = new ArrayList();
      localObject = new GroupInfo();
      cache_vecGroupInfo.add(localObject);
    }
    this.vecGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vecGroupInfo, 14, false));
    this.result = paramJceInputStream.read(this.result, 15, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 16, false);
    this.online_friend_count = paramJceInputStream.read(this.online_friend_count, 17, false);
    this.serverTime = paramJceInputStream.read(this.serverTime, 18, false);
    this.sqqOnLine_count = paramJceInputStream.read(this.sqqOnLine_count, 19, false);
    if (cache_vecMSFGroupInfo == null)
    {
      cache_vecMSFGroupInfo = new ArrayList();
      localObject = new GroupInfo();
      cache_vecMSFGroupInfo.add(localObject);
    }
    this.vecMSFGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vecMSFGroupInfo, 20, false));
    this.cRespType = paramJceInputStream.read(this.cRespType, 21, false);
    this.cHasOtherRespFlag = paramJceInputStream.read(this.cHasOtherRespFlag, 22, false);
    if (cache_stSelfInfo == null) {
      cache_stSelfInfo = new FriendInfo();
    }
    this.stSelfInfo = ((FriendInfo)paramJceInputStream.read(cache_stSelfInfo, 23, false));
    this.cShowPcIcon = paramJceInputStream.read(this.cShowPcIcon, 24, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqtype, 0);
    paramJceOutputStream.write(this.ifReflush, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.startIndex, 3);
    paramJceOutputStream.write(this.getfriendCount, 4);
    paramJceOutputStream.write(this.totoal_friend_count, 5);
    paramJceOutputStream.write(this.friend_count, 6);
    paramJceOutputStream.write(this.vecFriendInfo, 7);
    paramJceOutputStream.write(this.groupid, 8);
    paramJceOutputStream.write(this.ifGetGroupInfo, 9);
    paramJceOutputStream.write(this.groupstartIndex, 10);
    paramJceOutputStream.write(this.getgroupCount, 11);
    paramJceOutputStream.write(this.totoal_group_count, 12);
    paramJceOutputStream.write(this.group_count, 13);
    if (this.vecGroupInfo != null) {
      paramJceOutputStream.write(this.vecGroupInfo, 14);
    }
    paramJceOutputStream.write(this.result, 15);
    paramJceOutputStream.write(this.errorCode, 16);
    paramJceOutputStream.write(this.online_friend_count, 17);
    paramJceOutputStream.write(this.serverTime, 18);
    paramJceOutputStream.write(this.sqqOnLine_count, 19);
    if (this.vecMSFGroupInfo != null) {
      paramJceOutputStream.write(this.vecMSFGroupInfo, 20);
    }
    paramJceOutputStream.write(this.cRespType, 21);
    paramJceOutputStream.write(this.cHasOtherRespFlag, 22);
    if (this.stSelfInfo != null) {
      paramJceOutputStream.write(this.stSelfInfo, 23);
    }
    paramJceOutputStream.write(this.cShowPcIcon, 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetFriendListResp
 * JD-Core Version:    0.7.0.1
 */