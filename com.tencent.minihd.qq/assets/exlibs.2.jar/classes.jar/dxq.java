import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;

public class dxq
  extends EmoticonPackageDownloadListener
{
  public dxq(EmosmActivity paramEmosmActivity) {}
  
  public void onCoverComplete(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if ((paramEmoticonPackage == null) || (paramInt1 != 2) || (paramInt2 != 0)) {}
    while (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxq
 * JD-Core Version:    0.7.0.1
 */