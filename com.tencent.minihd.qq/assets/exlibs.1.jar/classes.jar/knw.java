import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.helper.QQHeadFace;
import com.tencent.biz.helper.QQHeadFace.IGetQQHeadCallBack;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapViewOverlayItem;
import java.util.ArrayList;
import java.util.Iterator;

public class knw
  implements QQHeadFace.IGetQQHeadCallBack
{
  public knw(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((NearbyTroopsMapView.b(this.a) != null) && (!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(NearbyTroopsMapView.b(this.a).b))))
        {
          paramArrayList = NearbyTroopsMapView.a(this.a).a(str, 4, false);
          if (paramArrayList != null) {
            this.a.a.setImageBitmap(paramArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knw
 * JD-Core Version:    0.7.0.1
 */