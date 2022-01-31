package android.support.multidex;

import java.io.File;
import java.io.FileFilter;

final class b$1
  implements FileFilter
{
  b$1(String paramString) {}
  
  public final boolean accept(File paramFile)
  {
    return !paramFile.getName().startsWith(this.pi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.multidex.b.1
 * JD-Core Version:    0.7.0.1
 */