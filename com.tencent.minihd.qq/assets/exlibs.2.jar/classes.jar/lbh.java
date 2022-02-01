import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.DeviceDeleteFriendChooserActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.Iterator;

public class lbh
  extends Handler
{
  public lbh(DeviceDeleteFriendChooserActivity paramDeviceDeleteFriendChooserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = new Intent();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList;
    Iterator localIterator1;
    if (this.a.b.size() > 0)
    {
      localArrayList = new ArrayList();
      localIterator1 = this.a.a.iterator();
    }
    label217:
    label218:
    for (;;)
    {
      Friend localFriend1;
      int i;
      if (localIterator1.hasNext())
      {
        localFriend1 = (Friend)localIterator1.next();
        Iterator localIterator2 = this.a.b.iterator();
        i = 1;
        label111:
        if (localIterator2.hasNext())
        {
          Friend localFriend2 = (Friend)localIterator2.next();
          if (!localFriend1.a.equals(localFriend2.a)) {
            break label217;
          }
          i = 0;
        }
      }
      for (;;)
      {
        break label111;
        if (i == 0) {
          break label218;
        }
        localArrayList.add(localFriend1);
        break;
        localBundle.putInt("key_error_code", 0);
        localBundle.putParcelableArrayList("result_buddies_undeleted", localArrayList);
        for (;;)
        {
          paramMessage.putExtras(localBundle);
          DeviceDeleteFriendChooserActivity.a(this.a, -1, paramMessage);
          DeviceDeleteFriendChooserActivity.a(this.a);
          return;
          localBundle.putInt("key_error_code", 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */