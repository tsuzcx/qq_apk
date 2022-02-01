package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class QuanInfo
  extends JceStruct
{
  static FaceRect cache_faceRect;
  static FacePoint cache_leftEye;
  static Map<String, String> cache_property;
  static FaceRect cache_regionRect;
  static Map<String, String> cache_reserve;
  static FacePoint cache_rightEye;
  public int Quanstate = 0;
  public int confidence = 0;
  public FaceRect faceRect = null;
  public long iSource = 0L;
  public long identity = 0L;
  public FacePoint leftEye = null;
  public int photoHeight = 0;
  public int photoWidth = 0;
  public Map<String, String> property = null;
  public FaceRect regionRect = null;
  public Map<String, String> reserve = null;
  public FacePoint rightEye = null;
  
  public QuanInfo() {}
  
  public QuanInfo(FaceRect paramFaceRect1, int paramInt1, Map<String, String> paramMap1, FacePoint paramFacePoint1, FacePoint paramFacePoint2, FaceRect paramFaceRect2, long paramLong1, int paramInt2, int paramInt3, Map<String, String> paramMap2, long paramLong2, int paramInt4)
  {
    this.faceRect = paramFaceRect1;
    this.confidence = paramInt1;
    this.property = paramMap1;
    this.leftEye = paramFacePoint1;
    this.rightEye = paramFacePoint2;
    this.regionRect = paramFaceRect2;
    this.identity = paramLong1;
    this.photoWidth = paramInt2;
    this.photoHeight = paramInt3;
    this.reserve = paramMap2;
    this.iSource = paramLong2;
    this.Quanstate = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_faceRect == null) {
      cache_faceRect = new FaceRect();
    }
    this.faceRect = ((FaceRect)paramJceInputStream.read(cache_faceRect, 0, true));
    this.confidence = paramJceInputStream.read(this.confidence, 1, true);
    if (cache_property == null)
    {
      cache_property = new HashMap();
      cache_property.put("", "");
    }
    this.property = ((Map)paramJceInputStream.read(cache_property, 2, true));
    if (cache_leftEye == null) {
      cache_leftEye = new FacePoint();
    }
    this.leftEye = ((FacePoint)paramJceInputStream.read(cache_leftEye, 3, true));
    if (cache_rightEye == null) {
      cache_rightEye = new FacePoint();
    }
    this.rightEye = ((FacePoint)paramJceInputStream.read(cache_rightEye, 4, true));
    if (cache_regionRect == null) {
      cache_regionRect = new FaceRect();
    }
    this.regionRect = ((FaceRect)paramJceInputStream.read(cache_regionRect, 5, true));
    this.identity = paramJceInputStream.read(this.identity, 6, true);
    this.photoWidth = paramJceInputStream.read(this.photoWidth, 7, true);
    this.photoHeight = paramJceInputStream.read(this.photoHeight, 8, true);
    if (cache_reserve == null)
    {
      cache_reserve = new HashMap();
      cache_reserve.put("", "");
    }
    this.reserve = ((Map)paramJceInputStream.read(cache_reserve, 9, true));
    this.iSource = paramJceInputStream.read(this.iSource, 10, true);
    this.Quanstate = paramJceInputStream.read(this.Quanstate, 11, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.faceRect, 0);
    paramJceOutputStream.write(this.confidence, 1);
    paramJceOutputStream.write(this.property, 2);
    paramJceOutputStream.write(this.leftEye, 3);
    paramJceOutputStream.write(this.rightEye, 4);
    paramJceOutputStream.write(this.regionRect, 5);
    paramJceOutputStream.write(this.identity, 6);
    paramJceOutputStream.write(this.photoWidth, 7);
    paramJceOutputStream.write(this.photoHeight, 8);
    paramJceOutputStream.write(this.reserve, 9);
    paramJceOutputStream.write(this.iSource, 10);
    paramJceOutputStream.write(this.Quanstate, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     FileUpload.QuanInfo
 * JD-Core Version:    0.7.0.1
 */