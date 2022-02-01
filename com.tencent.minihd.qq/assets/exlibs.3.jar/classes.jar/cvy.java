import android.content.Context;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.FileUtils.AssetFileComparator;
import java.io.File;

public final class cvy
  implements FileUtils.AssetFileComparator
{
  public boolean a(Context paramContext, String paramString, File paramFile)
  {
    long l = FileUtils.a(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cvy
 * JD-Core Version:    0.7.0.1
 */