import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.anim.VipPendantDrawable;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache;
import java.util.Collection;
import java.util.Iterator;

public class kvj
  extends Handler
{
  public kvj(PendantInfo paramPendantInfo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l;
    Object localObject;
    if (paramMessage.what == 16)
    {
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.m == l)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            ((VipPendantDrawable)localObject).invalidateSelf();
          }
        }
      }
      paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
    for (;;)
    {
      return;
      if (paramMessage.what == 17)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.p = this.a.a(this.a.p);
        localObject = (Bitmap)paramMessage.obj;
        if ((localObject != null) && (PendantInfo.a(this.a) != localObject))
        {
          if (this.a.a() != null) {
            this.a.a().recycle();
          }
          PendantInfo.a(this.a, (Bitmap)localObject);
        }
        l = paramMessage.getData().getLong("targetId");
        if (PendantInfo.m == l)
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
          while (paramMessage.hasNext())
          {
            localObject = (VipPendantDrawable)paramMessage.next();
            if (localObject != null) {
              ((VipPendantDrawable)localObject).invalidateSelf();
            }
          }
        }
        paramMessage = (VipPendantDrawable)this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage != null) {
          paramMessage.invalidateSelf();
        }
        if (2 == this.a.o)
        {
          if (PendantInfo.a(this.a) == 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$DecodeNextFrameTask = null;
            return;
          }
          this.a.c();
        }
      }
      else if (paramMessage.what == 18)
      {
        if ((!PendantInfo.a(this.a)) && (this.a.o == 2) && (PendantInfo.a(this.a) > 0))
        {
          this.a.c();
          return;
        }
        if ((!PendantInfo.a(this.a)) && (this.a.o == 1)) {
          PendantInfo.a(this.a);
        }
      }
      else if (paramMessage.what == 19)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            this.a.a((VipPendantDrawable)localObject, true, 0L);
          }
        }
      }
      else if (paramMessage.what == 20)
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (VipPendantDrawable)paramMessage.next();
          if (localObject != null) {
            this.a.a((VipPendantDrawable)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvj
 * JD-Core Version:    0.7.0.1
 */