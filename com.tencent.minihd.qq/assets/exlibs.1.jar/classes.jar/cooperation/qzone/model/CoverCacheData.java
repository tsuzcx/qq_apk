package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.GameCoverInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mbq;
import mbr;

public class CoverCacheData
  extends DbCacheData
  implements Parcelable
{
  public static final String COVER_ID = "coverId";
  public static final Parcelable.Creator CREATOR = new mbr();
  public static final DbCacheData.DbCreator DB_CREATOR = new mbq();
  public static final String GAME_COVER_INFO = "game_cover_info";
  public static final String JIGSAW = "jigsaw";
  public static final String LOCAL_URL = "local_url";
  public static final String PACKAGE_INFO = "package_info";
  public static final String PHOTO_WALL = "photo_wall";
  public static final String TYPE = "type";
  public static final String TYPE_COVER_ID = "TEXT";
  public static final String TYPE_GAME_COVER_INFO = "BLOB";
  public static final String TYPE_JIGSAW = "INTEGER";
  public static final String TYPE_LOCAL_URL = "TEXT";
  public static final String TYPE_PACKAGE_DATA = "BLOB";
  public static final String TYPE_PHOTO_WALL = "BLOB";
  public static final String TYPE_TYPE = "TEXT";
  public static final String TYPE_UIN = "INTEGER";
  public static final String TYPE_URLS = "BLOB";
  public static final String UIN = "uin";
  public static final String URLS = "urls";
  public static final int VERSION = 9;
  public String coverId = "";
  public CoverCacheData.GameCoverInfo gameCoverInfo;
  public int isJigsawOpen = 0;
  public String local_url = "";
  public CoverCacheData.PackageInfo packageInfo;
  public ArrayList photoWall = new ArrayList();
  public String type = "";
  public long uin = 0L;
  public HashMap urls = new HashMap();
  
  public static CoverCacheData createFromResponse(long paramLong, feeds_cover paramfeeds_cover)
  {
    Object localObject;
    if (paramfeeds_cover == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      do
      {
        return localObject;
        localCoverCacheData = new CoverCacheData();
        localCoverCacheData.uin = paramLong;
        localCoverCacheData.coverId = paramfeeds_cover.id;
        localCoverCacheData.type = paramfeeds_cover.type;
        localCoverCacheData.isJigsawOpen = paramfeeds_cover.photoWallCombinePic;
        if (QLog.isColorLevel()) {
          QLog.d("CoverCacheData", 2, "feeds_cover, isJigsawOpen=" + localCoverCacheData.isJigsawOpen);
        }
        if (paramfeeds_cover.MulRelsotionUrl != null) {
          localCoverCacheData.urls.putAll(paramfeeds_cover.MulRelsotionUrl);
        }
        if (paramfeeds_cover.packageInfo != null)
        {
          localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
          localCoverCacheData.packageInfo.jdField_a_of_type_JavaLangString = paramfeeds_cover.packageInfo.prePic;
          localCoverCacheData.packageInfo.jdField_b_of_type_JavaLangString = paramfeeds_cover.packageInfo.PackageUrl;
          localCoverCacheData.packageInfo.jdField_c_of_type_JavaLangString = paramfeeds_cover.packageInfo.md5;
          localCoverCacheData.packageInfo.jdField_a_of_type_Int = paramfeeds_cover.packageInfo.weather;
          localCoverCacheData.packageInfo.jdField_b_of_type_Int = paramfeeds_cover.packageInfo.daytime;
          localCoverCacheData.packageInfo.jdField_c_of_type_Int = paramfeeds_cover.packageInfo.coverStyle;
        }
        if (paramfeeds_cover.gameCoverInfo != null)
        {
          localCoverCacheData.gameCoverInfo = new CoverCacheData.GameCoverInfo();
          localCoverCacheData.gameCoverInfo.jdField_a_of_type_Double = paramfeeds_cover.gameCoverInfo.xCoordLU;
          localCoverCacheData.gameCoverInfo.jdField_b_of_type_Double = paramfeeds_cover.gameCoverInfo.yCoordLU;
          localCoverCacheData.gameCoverInfo.c = paramfeeds_cover.gameCoverInfo.xCoordRD;
          localCoverCacheData.gameCoverInfo.d = paramfeeds_cover.gameCoverInfo.yCoordRD;
          localCoverCacheData.gameCoverInfo.jdField_a_of_type_JavaLangString = paramfeeds_cover.gameCoverInfo.jmpUrl;
          localCoverCacheData.gameCoverInfo.jdField_b_of_type_JavaLangString = paramfeeds_cover.gameCoverInfo.schema;
          localCoverCacheData.gameCoverInfo.jdField_a_of_type_Int = paramfeeds_cover.gameCoverInfo.jmpType;
        }
        localObject = localCoverCacheData;
      } while (paramfeeds_cover.vecUrls == null);
      localObject = localCoverCacheData;
    } while (paramfeeds_cover.vecUrls.size() <= 0);
    localCoverCacheData.photoWall.addAll(paramfeeds_cover.vecUrls);
    return localCoverCacheData;
  }
  
  public static CoverCacheData createFromResponse(long paramLong, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject;
    if (parammobile_sub_get_cover_rsp == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      do
      {
        return localObject;
        localCoverCacheData = new CoverCacheData();
        localCoverCacheData.uin = paramLong;
        localCoverCacheData.type = parammobile_sub_get_cover_rsp.type;
        localCoverCacheData.isJigsawOpen = parammobile_sub_get_cover_rsp.photoWallCombinePic;
        if (QLog.isColorLevel()) {
          QLog.d("CoverCacheData", 2, "get_cover_rsp, isJigsawOpen=" + localCoverCacheData.isJigsawOpen);
        }
        if (parammobile_sub_get_cover_rsp.MulRelsotionUrl != null) {
          localCoverCacheData.urls.putAll(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
        }
        if (parammobile_sub_get_cover_rsp.packageInfo != null)
        {
          localCoverCacheData.packageInfo = new CoverCacheData.PackageInfo();
          localCoverCacheData.packageInfo.jdField_a_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.prePic;
          localCoverCacheData.packageInfo.jdField_b_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.PackageUrl;
          localCoverCacheData.packageInfo.jdField_c_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.md5;
          localCoverCacheData.packageInfo.jdField_a_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.weather;
          localCoverCacheData.packageInfo.jdField_b_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.daytime;
          localCoverCacheData.packageInfo.jdField_c_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.coverStyle;
        }
        localObject = localCoverCacheData;
      } while (parammobile_sub_get_cover_rsp.vecUrls == null);
      localObject = localCoverCacheData;
    } while (parammobile_sub_get_cover_rsp.vecUrls.size() <= 0);
    localCoverCacheData.photoWall.addAll(parammobile_sub_get_cover_rsp.vecUrls);
    return localCoverCacheData;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    paramContentValues.put("uin", Long.valueOf(this.uin));
    paramContentValues.put("coverId", this.coverId);
    paramContentValues.put("type", this.type);
    paramContentValues.put("local_url", this.local_url);
    paramContentValues.put("jigsaw", Integer.valueOf(this.isJigsawOpen));
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeMap(this.urls);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("urls", arrayOfByte);
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeParcelable(this.packageInfo, 0);
    arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("package_info", arrayOfByte);
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeParcelable(this.gameCoverInfo, 0);
    arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("game_cover_info", arrayOfByte);
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeList(this.photoWall);
    arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("photo_wall", arrayOfByte);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.coverId);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.local_url);
    paramParcel.writeMap(this.urls);
    paramParcel.writeParcelable(this.packageInfo, paramInt);
    paramParcel.writeParcelable(this.gameCoverInfo, paramInt);
    paramParcel.writeList(this.photoWall);
    paramParcel.writeInt(this.isJigsawOpen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData
 * JD-Core Version:    0.7.0.1
 */