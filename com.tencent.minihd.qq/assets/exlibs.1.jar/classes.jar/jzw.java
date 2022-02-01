import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class jzw
  implements BitmapDecoder
{
  public jzv a;
  
  public jzw(DataLineDownloader paramDataLineDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    this.jdField_a_of_type_Jzv = this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader.a(paramURL);
    return DataLineDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader, this.jdField_a_of_type_Jzv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzw
 * JD-Core Version:    0.7.0.1
 */