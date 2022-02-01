import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.ContainerView;

public class ffg
  implements WordMatchManager.MatchCallback
{
  public ffg(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    paramArrayOfHotWordItem = new QQText(HightlightHotWordText.a(TextPreviewActivity.a(this.a), paramArrayOfHotWordItem), 13, 32, this.a.c);
    if (TextPreviewActivity.a(this.a).a(this.a))
    {
      this.a.a = paramArrayOfHotWordItem;
      return;
    }
    this.a.a = null;
    TextPreviewActivity.a(this.a).setText(paramArrayOfHotWordItem);
    this.a.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffg
 * JD-Core Version:    0.7.0.1
 */