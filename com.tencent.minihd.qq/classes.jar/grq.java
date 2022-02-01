import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class grq
  implements Runnable
{
  public grq(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    int k = 0;
    Object localObject1 = new ArrayList(AlbumListAdapter.a(this.a).size());
    ((List)localObject1).addAll(AlbumListAdapter.a(this.a));
    localObject1 = ((List)localObject1).iterator();
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = 0;
    int j = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (QQAlbumInfo)((Iterator)localObject1).next();
      String str = FileUtil.b(((QQAlbumInfo)localObject2).mCoverInfo.a);
      localObject2 = ((QQAlbumInfo)localObject2).name;
      if ((str != null) && (localObject2 != null))
      {
        str = str.toLowerCase(Locale.US);
        localObject2 = ((String)localObject2).toLowerCase(Locale.US);
        if (str.contains("/tencent/"))
        {
          if (str.contains("/qq_collection/")) {
            i3 += 1;
          } else if ((((String)localObject2).equals("qq_images")) || (str.contains("/mobileqq/photo")) || (str.contains("/mobileqq/diskcache"))) {
            i2 += 1;
          } else if (((String)localObject2).equals("qqfile_recv")) {
            i1 += 1;
          } else if (((String)localObject2).equals("qq_favorite")) {
            m += 1;
          } else if (str.contains("/zebra/cache")) {
            n += 1;
          } else if ((((String)localObject2).equals("weixin")) || (((String)localObject2).equals("wechat")) || (((String)localObject2).equals("micromsg"))) {
            k += 1;
          } else if (StatisticConstants.a(str)) {
            j += 1;
          } else {
            i += 1;
          }
        }
        else if (((String)localObject2).equals("qq_screenshot")) {
          i5 += 1;
        } else if ((str.contains("screenshot")) || (str.contains("截屏")) || (str.contains("截图")) || (str.equals("screen_cap")) || (str.equals("ScreenCapture"))) {
          i4 += 1;
        } else if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains("相机")) || (((String)localObject2).contains("照片")) || (((String)localObject2).contains("相片"))) {
          i6 += 1;
        } else if (StatisticConstants.a(str)) {
          j += 1;
        } else {
          i += 1;
        }
      }
    }
    StatisticConstants.b(i6, i5, i4, j, i, i3, i2, i1, n, m, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grq
 * JD-Core Version:    0.7.0.1
 */