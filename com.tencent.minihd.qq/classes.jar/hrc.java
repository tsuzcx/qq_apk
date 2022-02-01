import java.io.File;
import java.util.Comparator;

class hrc
  implements Comparator
{
  hrc(hra paramhra) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() - paramFile1.lastModified() > 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hrc
 * JD-Core Version:    0.7.0.1
 */