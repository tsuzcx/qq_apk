import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class cla
  extends FilterOutputStream
{
  public int a;
  
  public cla(PubAccountHttpDownloader paramPubAccountHttpDownloader, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void write(int paramInt)
  {
    this.jdField_a_of_type_Int += 1;
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int += paramInt2;
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cla
 * JD-Core Version:    0.7.0.1
 */