package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_picdata
  extends JceStruct
{
  static Map cache_busi_param;
  static s_imgcrop cache_cropinfo;
  static ArrayList cache_facelist;
  static ArrayList cache_photoTag;
  static Map cache_photourl;
  static stPoi cache_poi;
  public Map busi_param = null;
  public String clientkey = "";
  public int commentcount = 0;
  public s_imgcrop cropinfo = null;
  public String curlikekey = "";
  public String desc = "";
  public ArrayList facelist = null;
  public int flag = 0;
  public boolean isAutoPlayGif = false;
  public int isIndependentUgc = 0;
  public boolean ismylike = false;
  public int likecount = 0;
  public String lloc = "";
  public long modifytime = 0L;
  public int opsynflag = 0;
  public String orglikekey = "";
  public ArrayList photoTag = null;
  public Map photourl = null;
  public String picname = "";
  public stPoi poi = null;
  public int raw = 0;
  public int shoottime = 0;
  public String sloc = "";
  public int type = 0;
  public long uUploadTime = 0L;
  public long uploadUin = 0L;
  
  public s_picdata() {}
  
  public s_picdata(String paramString1, String paramString2, String paramString3, Map paramMap1, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, Map paramMap2, String paramString4, int paramInt4, int paramInt5, long paramLong1, long paramLong2, String paramString5, String paramString6, String paramString7, s_imgcrop params_imgcrop, long paramLong3, int paramInt6, int paramInt7, stPoi paramstPoi, ArrayList paramArrayList1, int paramInt8, boolean paramBoolean2, ArrayList paramArrayList2)
  {
    this.picname = paramString1;
    this.sloc = paramString2;
    this.lloc = paramString3;
    this.photourl = paramMap1;
    this.type = paramInt1;
    this.ismylike = paramBoolean1;
    this.likecount = paramInt2;
    this.commentcount = paramInt3;
    this.busi_param = paramMap2;
    this.clientkey = paramString4;
    this.isIndependentUgc = paramInt4;
    this.opsynflag = paramInt5;
    this.uUploadTime = paramLong1;
    this.modifytime = paramLong2;
    this.desc = paramString5;
    this.orglikekey = paramString6;
    this.curlikekey = paramString7;
    this.cropinfo = params_imgcrop;
    this.uploadUin = paramLong3;
    this.shoottime = paramInt6;
    this.flag = paramInt7;
    this.poi = paramstPoi;
    this.facelist = paramArrayList1;
    this.raw = paramInt8;
    this.isAutoPlayGif = paramBoolean2;
    this.photoTag = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picname = paramJceInputStream.readString(0, false);
    this.sloc = paramJceInputStream.readString(1, false);
    this.lloc = paramJceInputStream.readString(2, false);
    Object localObject;
    if (cache_photourl == null)
    {
      cache_photourl = new HashMap();
      localObject = new s_picurl();
      cache_photourl.put(Integer.valueOf(0), localObject);
    }
    this.photourl = ((Map)paramJceInputStream.read(cache_photourl, 3, false));
    this.type = paramJceInputStream.read(this.type, 4, false);
    this.ismylike = paramJceInputStream.read(this.ismylike, 5, false);
    this.likecount = paramJceInputStream.read(this.likecount, 6, false);
    this.commentcount = paramJceInputStream.read(this.commentcount, 7, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 8, false));
    this.clientkey = paramJceInputStream.readString(9, false);
    this.isIndependentUgc = paramJceInputStream.read(this.isIndependentUgc, 10, false);
    this.opsynflag = paramJceInputStream.read(this.opsynflag, 11, false);
    this.uUploadTime = paramJceInputStream.read(this.uUploadTime, 12, false);
    this.modifytime = paramJceInputStream.read(this.modifytime, 13, false);
    this.desc = paramJceInputStream.readString(14, false);
    this.orglikekey = paramJceInputStream.readString(15, false);
    this.curlikekey = paramJceInputStream.readString(16, false);
    if (cache_cropinfo == null) {
      cache_cropinfo = new s_imgcrop();
    }
    this.cropinfo = ((s_imgcrop)paramJceInputStream.read(cache_cropinfo, 17, false));
    this.uploadUin = paramJceInputStream.read(this.uploadUin, 18, false);
    this.shoottime = paramJceInputStream.read(this.shoottime, 19, false);
    this.flag = paramJceInputStream.read(this.flag, 20, false);
    if (cache_poi == null) {
      cache_poi = new stPoi();
    }
    this.poi = ((stPoi)paramJceInputStream.read(cache_poi, 21, false));
    if (cache_facelist == null)
    {
      cache_facelist = new ArrayList();
      localObject = new stFaceItem();
      cache_facelist.add(localObject);
    }
    this.facelist = ((ArrayList)paramJceInputStream.read(cache_facelist, 22, false));
    this.raw = paramJceInputStream.read(this.raw, 23, false);
    this.isAutoPlayGif = paramJceInputStream.read(this.isAutoPlayGif, 24, false);
    if (cache_photoTag == null)
    {
      cache_photoTag = new ArrayList();
      localObject = new stPhotoTag();
      cache_photoTag.add(localObject);
    }
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 25, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picname != null) {
      paramJceOutputStream.write(this.picname, 0);
    }
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 1);
    }
    if (this.lloc != null) {
      paramJceOutputStream.write(this.lloc, 2);
    }
    if (this.photourl != null) {
      paramJceOutputStream.write(this.photourl, 3);
    }
    paramJceOutputStream.write(this.type, 4);
    paramJceOutputStream.write(this.ismylike, 5);
    paramJceOutputStream.write(this.likecount, 6);
    paramJceOutputStream.write(this.commentcount, 7);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 8);
    }
    if (this.clientkey != null) {
      paramJceOutputStream.write(this.clientkey, 9);
    }
    paramJceOutputStream.write(this.isIndependentUgc, 10);
    paramJceOutputStream.write(this.opsynflag, 11);
    paramJceOutputStream.write(this.uUploadTime, 12);
    paramJceOutputStream.write(this.modifytime, 13);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 14);
    }
    if (this.orglikekey != null) {
      paramJceOutputStream.write(this.orglikekey, 15);
    }
    if (this.curlikekey != null) {
      paramJceOutputStream.write(this.curlikekey, 16);
    }
    if (this.cropinfo != null) {
      paramJceOutputStream.write(this.cropinfo, 17);
    }
    paramJceOutputStream.write(this.uploadUin, 18);
    paramJceOutputStream.write(this.shoottime, 19);
    paramJceOutputStream.write(this.flag, 20);
    if (this.poi != null) {
      paramJceOutputStream.write(this.poi, 21);
    }
    if (this.facelist != null) {
      paramJceOutputStream.write(this.facelist, 22);
    }
    paramJceOutputStream.write(this.raw, 23);
    paramJceOutputStream.write(this.isAutoPlayGif, 24);
    if (this.photoTag != null) {
      paramJceOutputStream.write(this.photoTag, 25);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_picdata
 * JD-Core Version:    0.7.0.1
 */