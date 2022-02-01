package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class GroupInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_labels;
  public boolean bAlive = true;
  public boolean bIsNew = false;
  public long dwCertType = 0L;
  public long dwExtFlag = 0L;
  public long dwGroupActiveGrade = 0L;
  public long dwGroupFlagExt = 0L;
  public int iDistance = 0;
  public int iFaceId = 0;
  public int iLat = 900000000;
  public int iLon = 900000000;
  public int iMemberCnt = 0;
  public int iOnlineMemberCnt = 0;
  public long lCode = 0L;
  public long lCreator = 0L;
  public long lUin = 0L;
  public ArrayList labels = null;
  public String strIntro = "";
  public String strLocation = "";
  public String strName = "";
  
  static
  {
    if (!GroupInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GroupInfo() {}
  
  public GroupInfo(long paramLong1, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, long paramLong2, int paramInt5, int paramInt6, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean2, long paramLong6, long paramLong7, ArrayList paramArrayList)
  {
    this.lCode = paramLong1;
    this.strName = paramString1;
    this.strLocation = paramString2;
    this.iMemberCnt = paramInt1;
    this.strIntro = paramString3;
    this.iFaceId = paramInt2;
    this.bAlive = paramBoolean1;
    this.iDistance = paramInt3;
    this.iOnlineMemberCnt = paramInt4;
    this.dwGroupFlagExt = paramLong2;
    this.iLat = paramInt5;
    this.iLon = paramInt6;
    this.lUin = paramLong3;
    this.dwCertType = paramLong4;
    this.dwGroupActiveGrade = paramLong5;
    this.bIsNew = paramBoolean2;
    this.lCreator = paramLong6;
    this.dwExtFlag = paramLong7;
    this.labels = paramArrayList;
  }
  
  public String className()
  {
    return "NearbyGroup.GroupInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lCode, "lCode");
    paramStringBuilder.display(this.strName, "strName");
    paramStringBuilder.display(this.strLocation, "strLocation");
    paramStringBuilder.display(this.iMemberCnt, "iMemberCnt");
    paramStringBuilder.display(this.strIntro, "strIntro");
    paramStringBuilder.display(this.iFaceId, "iFaceId");
    paramStringBuilder.display(this.bAlive, "bAlive");
    paramStringBuilder.display(this.iDistance, "iDistance");
    paramStringBuilder.display(this.iOnlineMemberCnt, "iOnlineMemberCnt");
    paramStringBuilder.display(this.dwGroupFlagExt, "dwGroupFlagExt");
    paramStringBuilder.display(this.iLat, "iLat");
    paramStringBuilder.display(this.iLon, "iLon");
    paramStringBuilder.display(this.lUin, "lUin");
    paramStringBuilder.display(this.dwCertType, "dwCertType");
    paramStringBuilder.display(this.dwGroupActiveGrade, "dwGroupActiveGrade");
    paramStringBuilder.display(this.bIsNew, "bIsNew");
    paramStringBuilder.display(this.lCreator, "lCreator");
    paramStringBuilder.display(this.dwExtFlag, "dwExtFlag");
    paramStringBuilder.display(this.labels, "labels");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lCode, true);
    paramStringBuilder.displaySimple(this.strName, true);
    paramStringBuilder.displaySimple(this.strLocation, true);
    paramStringBuilder.displaySimple(this.iMemberCnt, true);
    paramStringBuilder.displaySimple(this.strIntro, true);
    paramStringBuilder.displaySimple(this.iFaceId, true);
    paramStringBuilder.displaySimple(this.bAlive, true);
    paramStringBuilder.displaySimple(this.iDistance, true);
    paramStringBuilder.displaySimple(this.iOnlineMemberCnt, true);
    paramStringBuilder.displaySimple(this.dwGroupFlagExt, true);
    paramStringBuilder.displaySimple(this.iLat, true);
    paramStringBuilder.displaySimple(this.iLon, true);
    paramStringBuilder.displaySimple(this.lUin, true);
    paramStringBuilder.displaySimple(this.dwCertType, true);
    paramStringBuilder.displaySimple(this.dwGroupActiveGrade, true);
    paramStringBuilder.displaySimple(this.bIsNew, true);
    paramStringBuilder.displaySimple(this.lCreator, true);
    paramStringBuilder.displaySimple(this.dwExtFlag, true);
    paramStringBuilder.displaySimple(this.labels, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (GroupInfo)paramObject;
    } while ((!JceUtil.equals(this.lCode, paramObject.lCode)) || (!JceUtil.equals(this.strName, paramObject.strName)) || (!JceUtil.equals(this.strLocation, paramObject.strLocation)) || (!JceUtil.equals(this.iMemberCnt, paramObject.iMemberCnt)) || (!JceUtil.equals(this.strIntro, paramObject.strIntro)) || (!JceUtil.equals(this.iFaceId, paramObject.iFaceId)) || (!JceUtil.equals(this.bAlive, paramObject.bAlive)) || (!JceUtil.equals(this.iDistance, paramObject.iDistance)) || (!JceUtil.equals(this.iOnlineMemberCnt, paramObject.iOnlineMemberCnt)) || (!JceUtil.equals(this.dwGroupFlagExt, paramObject.dwGroupFlagExt)) || (!JceUtil.equals(this.iLat, paramObject.iLat)) || (!JceUtil.equals(this.iLon, paramObject.iLon)) || (!JceUtil.equals(this.lUin, paramObject.lUin)) || (!JceUtil.equals(this.dwCertType, paramObject.dwCertType)) || (!JceUtil.equals(this.dwGroupActiveGrade, paramObject.dwGroupActiveGrade)) || (!JceUtil.equals(this.bIsNew, paramObject.bIsNew)) || (!JceUtil.equals(this.lCreator, paramObject.lCreator)) || (!JceUtil.equals(this.dwExtFlag, paramObject.dwExtFlag)) || (!JceUtil.equals(this.labels, paramObject.labels)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.GroupInfo";
  }
  
  public boolean getBAlive()
  {
    return this.bAlive;
  }
  
  public boolean getBIsNew()
  {
    return this.bIsNew;
  }
  
  public long getDwCertType()
  {
    return this.dwCertType;
  }
  
  public long getDwExtFlag()
  {
    return this.dwExtFlag;
  }
  
  public long getDwGroupActiveGrade()
  {
    return this.dwGroupActiveGrade;
  }
  
  public long getDwGroupFlagExt()
  {
    return this.dwGroupFlagExt;
  }
  
  public int getIDistance()
  {
    return this.iDistance;
  }
  
  public int getIFaceId()
  {
    return this.iFaceId;
  }
  
  public int getILat()
  {
    return this.iLat;
  }
  
  public int getILon()
  {
    return this.iLon;
  }
  
  public int getIMemberCnt()
  {
    return this.iMemberCnt;
  }
  
  public int getIOnlineMemberCnt()
  {
    return this.iOnlineMemberCnt;
  }
  
  public long getLCode()
  {
    return this.lCode;
  }
  
  public long getLCreator()
  {
    return this.lCreator;
  }
  
  public long getLUin()
  {
    return this.lUin;
  }
  
  public ArrayList getLabels()
  {
    return this.labels;
  }
  
  public String getStrIntro()
  {
    return this.strIntro;
  }
  
  public String getStrLocation()
  {
    return this.strLocation;
  }
  
  public String getStrName()
  {
    return this.strName;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lCode = paramJceInputStream.read(this.lCode, 0, true);
    this.strName = paramJceInputStream.readString(1, true);
    this.strLocation = paramJceInputStream.readString(2, true);
    this.iMemberCnt = paramJceInputStream.read(this.iMemberCnt, 3, true);
    this.strIntro = paramJceInputStream.readString(4, true);
    this.iFaceId = paramJceInputStream.read(this.iFaceId, 5, true);
    this.bAlive = paramJceInputStream.read(this.bAlive, 6, true);
    this.iDistance = paramJceInputStream.read(this.iDistance, 7, false);
    this.iOnlineMemberCnt = paramJceInputStream.read(this.iOnlineMemberCnt, 8, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 9, false);
    this.iLat = paramJceInputStream.read(this.iLat, 10, false);
    this.iLon = paramJceInputStream.read(this.iLon, 11, false);
    this.lUin = paramJceInputStream.read(this.lUin, 12, false);
    this.dwCertType = paramJceInputStream.read(this.dwCertType, 13, false);
    this.dwGroupActiveGrade = paramJceInputStream.read(this.dwGroupActiveGrade, 14, false);
    this.bIsNew = paramJceInputStream.read(this.bIsNew, 15, false);
    this.lCreator = paramJceInputStream.read(this.lCreator, 16, false);
    this.dwExtFlag = paramJceInputStream.read(this.dwExtFlag, 17, false);
    if (cache_labels == null)
    {
      cache_labels = new ArrayList();
      GroupLabel localGroupLabel = new GroupLabel();
      cache_labels.add(localGroupLabel);
    }
    this.labels = ((ArrayList)paramJceInputStream.read(cache_labels, 18, false));
  }
  
  public void setBAlive(boolean paramBoolean)
  {
    this.bAlive = paramBoolean;
  }
  
  public void setBIsNew(boolean paramBoolean)
  {
    this.bIsNew = paramBoolean;
  }
  
  public void setDwCertType(long paramLong)
  {
    this.dwCertType = paramLong;
  }
  
  public void setDwExtFlag(long paramLong)
  {
    this.dwExtFlag = paramLong;
  }
  
  public void setDwGroupActiveGrade(long paramLong)
  {
    this.dwGroupActiveGrade = paramLong;
  }
  
  public void setDwGroupFlagExt(long paramLong)
  {
    this.dwGroupFlagExt = paramLong;
  }
  
  public void setIDistance(int paramInt)
  {
    this.iDistance = paramInt;
  }
  
  public void setIFaceId(int paramInt)
  {
    this.iFaceId = paramInt;
  }
  
  public void setILat(int paramInt)
  {
    this.iLat = paramInt;
  }
  
  public void setILon(int paramInt)
  {
    this.iLon = paramInt;
  }
  
  public void setIMemberCnt(int paramInt)
  {
    this.iMemberCnt = paramInt;
  }
  
  public void setIOnlineMemberCnt(int paramInt)
  {
    this.iOnlineMemberCnt = paramInt;
  }
  
  public void setLCode(long paramLong)
  {
    this.lCode = paramLong;
  }
  
  public void setLCreator(long paramLong)
  {
    this.lCreator = paramLong;
  }
  
  public void setLUin(long paramLong)
  {
    this.lUin = paramLong;
  }
  
  public void setLabels(ArrayList paramArrayList)
  {
    this.labels = paramArrayList;
  }
  
  public void setStrIntro(String paramString)
  {
    this.strIntro = paramString;
  }
  
  public void setStrLocation(String paramString)
  {
    this.strLocation = paramString;
  }
  
  public void setStrName(String paramString)
  {
    this.strName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lCode, 0);
    paramJceOutputStream.write(this.strName, 1);
    paramJceOutputStream.write(this.strLocation, 2);
    paramJceOutputStream.write(this.iMemberCnt, 3);
    paramJceOutputStream.write(this.strIntro, 4);
    paramJceOutputStream.write(this.iFaceId, 5);
    paramJceOutputStream.write(this.bAlive, 6);
    paramJceOutputStream.write(this.iDistance, 7);
    paramJceOutputStream.write(this.iOnlineMemberCnt, 8);
    paramJceOutputStream.write(this.dwGroupFlagExt, 9);
    paramJceOutputStream.write(this.iLat, 10);
    paramJceOutputStream.write(this.iLon, 11);
    paramJceOutputStream.write(this.lUin, 12);
    paramJceOutputStream.write(this.dwCertType, 13);
    paramJceOutputStream.write(this.dwGroupActiveGrade, 14);
    paramJceOutputStream.write(this.bIsNew, 15);
    paramJceOutputStream.write(this.lCreator, 16);
    paramJceOutputStream.write(this.dwExtFlag, 17);
    if (this.labels != null) {
      paramJceOutputStream.write(this.labels, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NearbyGroup.GroupInfo
 * JD-Core Version:    0.7.0.1
 */