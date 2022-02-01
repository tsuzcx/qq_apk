import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import java.io.File;
import java.util.List;
import tencent.im.group.nearbybanner.nearbybanner.BannerInfo;
import tencent.im.group.nearbybanner.nearbybanner.Banners;

public class kdm
  implements BusinessObserver
{
  public kdm(NearbyTroopsView paramNearbyTroopsView) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler == null) {
      break label10;
    }
    for (;;)
    {
      label10:
      return;
      if (paramInt == 16)
      {
        paramObject = ((Bundle)paramObject).getByteArray("data");
        if (paramObject == null) {
          break;
        }
        Object localObject = new nearbybanner.Banners();
        try
        {
          ((nearbybanner.Banners)localObject).mergeFrom(paramObject);
          if (((nearbybanner.Banners)localObject).rpt_banner_info.has())
          {
            paramObject = ((nearbybanner.Banners)localObject).rpt_banner_info.get();
            if (paramObject.size() != 0)
            {
              NearbyTroopsView.a(this.a, (nearbybanner.BannerInfo)paramObject.get(0));
              if ((NearbyTroopsView.a(this.a) != null) && (NearbyTroopsView.a(this.a).bytes_img_url.has()))
              {
                paramObject = NearbyTroopsView.a(this.a).bytes_img_url.get().toStringUtf8();
                localObject = this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("NearByTroop", 4);
                if (TextUtils.isEmpty(((SharedPreferences)localObject).getString("banner_url", null)))
                {
                  ((SharedPreferences)localObject).edit().putString("banner_url", paramObject).commit();
                  new Thread(NearbyTroopsView.a(this.a)).start();
                  return;
                }
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          NearbyTroopsView.a(this.a, null);
          return;
        }
      }
    }
    if (!new File(NearbyTroopsView.c).exists())
    {
      new Thread(NearbyTroopsView.a(this.a)).start();
      return;
    }
    try
    {
      paramObject = new BitmapFactory.Options();
      paramObject.inJustDecodeBounds = true;
      paramObject = BitmapFactory.decodeFile(NearbyTroopsView.c, paramObject);
      if (paramObject != null)
      {
        paramObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.obtainMessage(10, paramObject);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView$UIHandler.sendMessage(paramObject);
        return;
      }
      new Thread(NearbyTroopsView.a(this.a)).start();
      return;
    }
    catch (OutOfMemoryError paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdm
 * JD-Core Version:    0.7.0.1
 */