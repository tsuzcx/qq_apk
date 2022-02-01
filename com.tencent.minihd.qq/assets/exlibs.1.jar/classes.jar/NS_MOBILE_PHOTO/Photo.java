package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class Photo
  extends JceStruct
{
  static Map cache_busi_param;
  static Map cache_pics_enlargerate;
  public String bigurl = "";
  public Map busi_param = null;
  public int cmtnum = 0;
  public String curkey = "";
  public String currenturl = "";
  public String desc = "";
  public int height = 0;
  public int isIndependentUgc = 0;
  public int likenum = 0;
  public String lloc = "";
  public String midurl = "";
  public int modifytime = 0;
  public byte mylike = 0;
  public String name = "";
  public int opsynflag = 0;
  public Map pics_enlargerate = null;
  public int quanflag = 0;
  public long raw = 0L;
  public String sloc = "";
  public String smallurl = "";
  public String thumburl = "";
  public int trannum = 0;
  public int type = 0;
  public long uin = 0L;
  public String unikey = "";
  public int uploadtime = 0;
  public String url = "";
  public int width = 0;
  
  public Photo() {}
  
  public Photo(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, int paramInt5, int paramInt6, byte paramByte, int paramInt7, String paramString8, String paramString9, String paramString10, String paramString11, Map paramMap1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, String paramString12, Map paramMap2)
  {
    this.uin = paramLong1;
    this.lloc = paramString1;
    this.sloc = paramString2;
    this.name = paramString3;
    this.desc = paramString4;
    this.uploadtime = paramInt1;
    this.modifytime = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.url = paramString5;
    this.bigurl = paramString6;
    this.smallurl = paramString7;
    this.cmtnum = paramInt5;
    this.likenum = paramInt6;
    this.mylike = paramByte;
    this.trannum = paramInt7;
    this.unikey = paramString8;
    this.curkey = paramString9;
    this.midurl = paramString10;
    this.thumburl = paramString11;
    this.busi_param = paramMap1;
    this.type = paramInt8;
    this.isIndependentUgc = paramInt9;
    this.opsynflag = paramInt10;
    this.quanflag = paramInt11;
    this.raw = paramLong2;
    this.currenturl = paramString12;
    this.pics_enlargerate = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.lloc = paramJceInputStream.readString(1, true);
    this.sloc = paramJceInputStream.readString(2, true);
    this.name = paramJceInputStream.readString(3, true);
    this.desc = paramJceInputStream.readString(4, true);
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 5, true);
    this.modifytime = paramJceInputStream.read(this.modifytime, 6, true);
    this.width = paramJceInputStream.read(this.width, 7, true);
    this.height = paramJceInputStream.read(this.height, 8, true);
    this.url = paramJceInputStream.readString(9, true);
    this.bigurl = paramJceInputStream.readString(10, true);
    this.smallurl = paramJceInputStream.readString(11, true);
    this.cmtnum = paramJceInputStream.read(this.cmtnum, 12, true);
    this.likenum = paramJceInputStream.read(this.likenum, 13, true);
    this.mylike = paramJceInputStream.read(this.mylike, 14, true);
    this.trannum = paramJceInputStream.read(this.trannum, 15, true);
    this.unikey = paramJceInputStream.readString(16, false);
    this.curkey = paramJceInputStream.readString(17, false);
    this.midurl = paramJceInputStream.readString(18, false);
    this.thumburl = paramJceInputStream.readString(19, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 20, false));
    this.type = paramJceInputStream.read(this.type, 21, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 22, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 23, false);
    this.quanflag = paramJceInputStream.read(this.quanflag, 24, false);
    this.raw = paramJceInputStream.read(this.raw, 25, false);
    this.currenturl = paramJceInputStream.readString(26, false);
    if (cache_pics_enlargerate == null)
    {
      cache_pics_enlargerate = new HashMap();
      cache_pics_enlargerate.put(Integer.valueOf(0), Integer.valueOf(0));
    }
    this.pics_enlargerate = ((Map)paramJceInputStream.read(cache_pics_enlargerate, 27, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.lloc, 1);
    paramJceOutputStream.write(this.sloc, 2);
    paramJceOutputStream.write(this.name, 3);
    paramJceOutputStream.write(this.desc, 4);
    paramJceOutputStream.write(this.uploadtime, 5);
    paramJceOutputStream.write(this.modifytime, 6);
    paramJceOutputStream.write(this.width, 7);
    paramJceOutputStream.write(this.height, 8);
    paramJceOutputStream.write(this.url, 9);
    paramJceOutputStream.write(this.bigurl, 10);
    paramJceOutputStream.write(this.smallurl, 11);
    paramJceOutputStream.write(this.cmtnum, 12);
    paramJceOutputStream.write(this.likenum, 13);
    paramJceOutputStream.write(this.mylike, 14);
    paramJceOutputStream.write(this.trannum, 15);
    if (this.unikey != null) {
      paramJceOutputStream.write(this.unikey, 16);
    }
    if (this.curkey != null) {
      paramJceOutputStream.write(this.curkey, 17);
    }
    if (this.midurl != null) {
      paramJceOutputStream.write(this.midurl, 18);
    }
    if (this.thumburl != null) {
      paramJceOutputStream.write(this.thumburl, 19);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 20);
    }
    paramJceOutputStream.write(this.type, 21);
    paramJceOutputStream.write(this.isIndependentUgc, 22);
    paramJceOutputStream.write(this.opsynflag, 23);
    paramJceOutputStream.write(this.quanflag, 24);
    paramJceOutputStream.write(this.raw, 25);
    if (this.currenturl != null) {
      paramJceOutputStream.write(this.currenturl, 26);
    }
    if (this.pics_enlargerate != null) {
      paramJceOutputStream.write(this.pics_enlargerate, 27);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.Photo
 * JD-Core Version:    0.7.0.1
 */