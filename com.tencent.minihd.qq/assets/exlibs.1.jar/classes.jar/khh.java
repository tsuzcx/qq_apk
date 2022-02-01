import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.activity.TroopCreateAvatarActivity;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class khh
  extends Handler
{
  public khh(TroopCreateAvatarActivity paramTroopCreateAvatarActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    int j;
    do
    {
      return;
      paramMessage = paramMessage.getData();
      Object localObject = paramMessage.getStringArrayList("AVATAR_WALL_LIST");
      i = paramMessage.getInt("newSeq");
      j = paramMessage.getInt("CMD_TYPE");
      paramMessage = new ArrayList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          AvatarWallAdapter.AvatarInfo localAvatarInfo = new AvatarWallAdapter.AvatarInfo();
          localAvatarInfo.b = str;
          localAvatarInfo.c = "AVATAR_URL_STR";
          paramMessage.add(localAvatarInfo);
        }
      }
    } while (this.a.a == null);
    this.a.a.a(paramMessage, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     khh
 * JD-Core Version:    0.7.0.1
 */