import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class gtk
  extends Handler
{
  private final WeakReference a;
  
  public gtk(SendPhotoActivity paramSendPhotoActivity)
  {
    this.a = new WeakReference(paramSendPhotoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.a.get();
    if (localSendPhotoActivity != null) {}
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1: 
      localSendPhotoActivity.a(2131368524);
      return;
    }
    SendPhotoActivity.a(localSendPhotoActivity);
    try
    {
      Object localObject1 = new String[localSendPhotoActivity.jdField_a_of_type_JavaUtilArrayList.size()];
      localSendPhotoActivity.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject1);
      StatisticConstants.a((String[])localObject1, SendPhotoActivity.a(localSendPhotoActivity), false, -1, localSendPhotoActivity.app);
      if ((SendPhotoActivity.a(localSendPhotoActivity) != null) && (SendPhotoActivity.a(localSendPhotoActivity).isShowing()))
      {
        bool = true;
        try
        {
          localSendPhotoActivity.a();
          label131:
          Intent localIntent = localSendPhotoActivity.getIntent();
          localIntent.putExtra(AlbumConstants.i, 2);
          if (!localIntent.hasExtra("extra_image_sender_tag")) {
            localIntent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
          }
          localObject1 = null;
          Object localObject2 = paramMessage.getData();
          int j = 0;
          int i = j;
          paramMessage = (Message)localObject1;
          if (localObject2 != null)
          {
            ((Bundle)localObject2).setClassLoader(CompressInfo.class.getClassLoader());
            localObject1 = ((Bundle)localObject2).getParcelableArrayList("flag_compressinfolist");
            i = j;
            paramMessage = (Message)localObject1;
            if (localObject1 != null)
            {
              paramMessage = ((ArrayList)localObject1).iterator();
              while (paramMessage.hasNext())
              {
                localObject2 = (CompressInfo)paramMessage.next();
                Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage print CompressInfo", "info:" + localObject2);
                localSendPhotoActivity.b.add(((CompressInfo)localObject2).e);
              }
              i = ((ArrayList)localObject1).size();
              paramMessage = (Message)localObject1;
            }
          }
          long l1 = System.nanoTime();
          long l2 = (l1 - SendPhotoActivity.a(localSendPhotoActivity)) / 1000000L;
          Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "CompressLog", "compress startTime = " + SendPhotoActivity.a(localSendPhotoActivity) + "ns,finishTime = " + l1 + "ns,duration = " + l2 + "ms,count = " + i + ",isShowing = " + bool);
          StatisticConstants.a(l2, i, bool);
          localSendPhotoActivity.app.a().a(l1);
          Logger.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "TimeCompare", "CompressFinish Time = " + l1 + "ns");
          SendPhotoActivity.a(localSendPhotoActivity, localIntent);
          localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
          localSendPhotoActivity.finish();
          Utils.a(BaseApplication.getContext(), paramMessage);
          return;
        }
        catch (Exception localException1)
        {
          break label131;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gtk
 * JD-Core Version:    0.7.0.1
 */