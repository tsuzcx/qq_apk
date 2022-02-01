package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetTagListRsp
  extends JceStruct
{
  static int cache_flagChange;
  static Map cache_friendInfo;
  static Map cache_groupInfo;
  static Map cache_specialList;
  static ArrayList cache_tagList;
  public int errorCode = 0;
  public String fingerPrint = "";
  public int flagChange = 0;
  public Map friendInfo = null;
  public Map groupInfo = null;
  public Map specialList = null;
  public ArrayList tagList = null;
  public short totalFriendCount = 0;
  public long uin = 0L;
  
  public GetTagListRsp() {}
  
  public GetTagListRsp(long paramLong, ArrayList paramArrayList, short paramShort, Map paramMap1, Map paramMap2, int paramInt1, String paramString, int paramInt2, Map paramMap3)
  {
    this.uin = paramLong;
    this.tagList = paramArrayList;
    this.totalFriendCount = paramShort;
    this.friendInfo = paramMap1;
    this.groupInfo = paramMap2;
    this.errorCode = paramInt1;
    this.fingerPrint = paramString;
    this.flagChange = paramInt2;
    this.specialList = paramMap3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    Object localObject;
    if (cache_tagList == null)
    {
      cache_tagList = new ArrayList();
      localObject = new TagInfo();
      cache_tagList.add(localObject);
    }
    this.tagList = ((ArrayList)paramJceInputStream.read(cache_tagList, 1, false));
    this.totalFriendCount = paramJceInputStream.read(this.totalFriendCount, 2, false);
    if (cache_friendInfo == null)
    {
      cache_friendInfo = new HashMap();
      localObject = new FriendInfo();
      cache_friendInfo.put(Long.valueOf(0L), localObject);
    }
    this.friendInfo = ((Map)paramJceInputStream.read(cache_friendInfo, 3, false));
    if (cache_groupInfo == null)
    {
      cache_groupInfo = new HashMap();
      localObject = new GroupInfo();
      cache_groupInfo.put(Short.valueOf((short)0), localObject);
    }
    this.groupInfo = ((Map)paramJceInputStream.read(cache_groupInfo, 4, false));
    this.errorCode = paramJceInputStream.read(this.errorCode, 5, false);
    this.fingerPrint = paramJceInputStream.readString(6, false);
    this.flagChange = paramJceInputStream.read(this.flagChange, 7, false);
    if (cache_specialList == null)
    {
      cache_specialList = new HashMap();
      localObject = new FriendInfo();
      cache_specialList.put(Long.valueOf(0L), localObject);
    }
    this.specialList = ((Map)paramJceInputStream.read(cache_specialList, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.tagList != null) {
      paramJceOutputStream.write(this.tagList, 1);
    }
    paramJceOutputStream.write(this.totalFriendCount, 2);
    if (this.friendInfo != null) {
      paramJceOutputStream.write(this.friendInfo, 3);
    }
    if (this.groupInfo != null) {
      paramJceOutputStream.write(this.groupInfo, 4);
    }
    paramJceOutputStream.write(this.errorCode, 5);
    if (this.fingerPrint != null) {
      paramJceOutputStream.write(this.fingerPrint, 6);
    }
    paramJceOutputStream.write(this.flagChange, 7);
    if (this.specialList != null) {
      paramJceOutputStream.write(this.specialList, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.GetTagListRsp
 * JD-Core Version:    0.7.0.1
 */