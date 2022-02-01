import android.database.Cursor;
import android.os.Parcel;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.model.CoverCacheData.GameCoverInfo;
import cooperation.qzone.model.CoverCacheData.PackageInfo;
import cooperation.qzone.model.DbCacheData.DbCreator;
import cooperation.qzone.model.DbCacheData.Structure;

public final class mbq
  implements DbCacheData.DbCreator
{
  public int a()
  {
    return 9;
  }
  
  public CoverCacheData a(Cursor paramCursor)
  {
    CoverCacheData localCoverCacheData = new CoverCacheData();
    localCoverCacheData.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    localCoverCacheData.coverId = paramCursor.getString(paramCursor.getColumnIndex("coverId"));
    localCoverCacheData.type = paramCursor.getString(paramCursor.getColumnIndex("type"));
    localCoverCacheData.local_url = paramCursor.getString(paramCursor.getColumnIndex("local_url"));
    localCoverCacheData.isJigsawOpen = paramCursor.getInt(paramCursor.getColumnIndex("jigsaw"));
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("urls"));
    try
    {
      localParcel = Parcel.obtain();
      localParcel.unmarshall((byte[])localObject, 0, localObject.length);
      localParcel.setDataPosition(0);
      localCoverCacheData.urls = localParcel.readHashMap(getClass().getClassLoader());
      localParcel.recycle();
      localObject = paramCursor.getBlob(paramCursor.getColumnIndex("package_info"));
    }
    catch (Exception localException3)
    {
      try
      {
        localParcel = Parcel.obtain();
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        localCoverCacheData.packageInfo = ((CoverCacheData.PackageInfo)localParcel.readParcelable(getClass().getClassLoader()));
        localParcel.recycle();
        localObject = paramCursor.getBlob(paramCursor.getColumnIndex("game_cover_info"));
      }
      catch (Exception localException3)
      {
        try
        {
          Parcel localParcel = Parcel.obtain();
          localParcel.unmarshall((byte[])localObject, 0, localObject.length);
          localParcel.setDataPosition(0);
          localCoverCacheData.gameCoverInfo = ((CoverCacheData.GameCoverInfo)localParcel.readParcelable(getClass().getClassLoader()));
          localParcel.recycle();
          paramCursor = paramCursor.getBlob(paramCursor.getColumnIndex("photo_wall"));
        }
        catch (Exception localException3)
        {
          try
          {
            do
            {
              for (;;)
              {
                localObject = Parcel.obtain();
                ((Parcel)localObject).unmarshall(paramCursor, 0, paramCursor.length);
                ((Parcel)localObject).setDataPosition(0);
                localCoverCacheData.photoWall = ((Parcel)localObject).readArrayList(getClass().getClassLoader());
                ((Parcel)localObject).recycle();
                return localCoverCacheData;
                localException1 = localException1;
                if (QLog.isColorLevel())
                {
                  QLog.e("CoverCacheData", 2, "failed to read cover.urls:", localException1);
                  continue;
                  localException2 = localException2;
                  if (QLog.isColorLevel()) {
                    QLog.e("CoverCacheData", 2, "failed to read cover.packageInfo:", localException2);
                  }
                }
              }
              localException3 = localException3;
            } while (!QLog.isColorLevel());
            QLog.e("CoverCacheData", 2, "failed to read cover.gameCoverInfo:", localException3);
          }
          catch (Exception paramCursor)
          {
            while (!QLog.isColorLevel()) {}
            QLog.e("CoverCacheData", 2, "failed to read cover.photoWall:", paramCursor);
          }
        }
      }
    }
    return localCoverCacheData;
  }
  
  public String a()
  {
    return null;
  }
  
  public DbCacheData.Structure[] a()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("uin", "INTEGER"), new DbCacheData.Structure("coverId", "TEXT"), new DbCacheData.Structure("type", "TEXT"), new DbCacheData.Structure("local_url", "TEXT"), new DbCacheData.Structure("urls", "BLOB"), new DbCacheData.Structure("package_info", "BLOB"), new DbCacheData.Structure("game_cover_info", "BLOB"), new DbCacheData.Structure("photo_wall", "BLOB"), new DbCacheData.Structure("jigsaw", "INTEGER") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbq
 * JD-Core Version:    0.7.0.1
 */