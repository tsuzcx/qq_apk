package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;

final class b$8
  extends ah
{
  b$8(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    label116:
    do
    {
      for (;;)
      {
        try
        {
          if (b.b(this.jJF).size() <= 0) {
            return;
          }
          paramMessage = b.b(this.jJF).iterator();
          if (!paramMessage.hasNext()) {
            break label339;
          }
          localObject1 = (String)paramMessage.next();
          if ("*".equals(localObject1)) {
            continue;
          }
          localObject2 = g.by((String)localObject1, false);
          if (localObject2 == null)
          {
            y.w("MicroMsg.SubCoreExt", "appInfo is null");
            continue;
          }
          if (!bk.bl(((f)localObject2).field_appId)) {
            break label116;
          }
        }
        catch (Exception paramMessage)
        {
          y.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramMessage.getMessage() });
          return;
        }
        y.w("MicroMsg.SubCoreExt", "appId is null");
        continue;
        y.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((f)localObject2).field_appInfoFlag), ((f)localObject2).field_appId });
        localObject1 = b.aNp().acj(((f)localObject2).field_appId);
        if (localObject1 != null) {
          break;
        }
        y.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((f)localObject2).field_appId });
      }
      if (!g.i((f)localObject2)) {
        break;
      }
    } while (((bo)localObject1).field_status == 1);
    bp localbp;
    for (((bo)localObject1).field_status = 1;; ((bo)localObject1).field_status = 0)
    {
      localbp = b.aNp();
      localObject2 = ((f)localObject2).field_appId;
      if ((!bk.bl((String)localObject2)) && (localObject1 != null) && (!bk.bl(((bo)localObject1).field_appId))) {
        break label268;
      }
      y.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
      break;
      if (((bo)localObject1).field_status == 0) {
        break;
      }
    }
    label268:
    ContentValues localContentValues = ((bo)localObject1).vf();
    if (localContentValues.size() > 0) {}
    for (int i = localbp.dXw.update("OpenMsgListener", localContentValues, "appId=?", new String[] { bk.pl((String)localObject2) });; i = 0)
    {
      y.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((bo)localObject1).field_appId, Integer.valueOf(i) });
      break;
      label339:
      b.b(this.jJF).clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.8
 * JD-Core Version:    0.7.0.1
 */