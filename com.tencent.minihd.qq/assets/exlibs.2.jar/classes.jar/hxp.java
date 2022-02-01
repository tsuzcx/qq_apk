import com.tencent.mobileqq.config.NearbyBannerManager;
import java.io.File;
import java.util.Comparator;

public class hxp
  implements Comparator
{
  public hxp(NearbyBannerManager paramNearbyBannerManager) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() > paramFile1.lastModified()) {
      return 1;
    }
    if (paramFile2.lastModified() < paramFile1.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hxp
 * JD-Core Version:    0.7.0.1
 */