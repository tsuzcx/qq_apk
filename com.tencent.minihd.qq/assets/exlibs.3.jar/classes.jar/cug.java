import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.Random;
import org.apache.http.protocol.HttpContext;

public final class cug
{
  private static final Random a = new Random();
  
  public static int a(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + a.nextInt();
  }
  
  public static String a(HttpContext paramHttpContext, boolean paramBoolean)
  {
    return null;
  }
  
  public static boolean a(File paramFile, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFile == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        File localFile = paramFile.getParentFile();
        if ((localFile.exists()) && (localFile.isFile())) {
          FileUtils.a(localFile);
        }
        if (!localFile.exists())
        {
          bool1 = bool2;
          if (!localFile.mkdirs()) {
            continue;
          }
        }
        if ((paramBoolean) && (paramFile.exists())) {
          FileUtils.a(paramFile);
        }
        if (!paramFile.exists())
        {
          paramBoolean = paramFile.createNewFile();
          bool1 = bool2;
          if (!paramBoolean) {
            continue;
          }
        }
        bool1 = true;
      }
      finally {}
    }
  }
  
  public static String b(HttpContext paramHttpContext, boolean paramBoolean)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cug
 * JD-Core Version:    0.7.0.1
 */