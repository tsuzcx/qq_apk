import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class kae
  implements BitmapDecoder
{
  public kae(FileAssistantDownloader paramFileAssistantDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    return FileAssistantDownloader.a(this.a, paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kae
 * JD-Core Version:    0.7.0.1
 */