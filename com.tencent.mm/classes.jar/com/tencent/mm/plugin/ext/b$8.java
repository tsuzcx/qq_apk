package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;

final class b$8
  extends ak
{
  b$8(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(20267);
    Object localObject1;
    Object localObject2;
    label136:
    do
    {
      for (;;)
      {
        try
        {
          i = b.b(this.mdJ).size();
          if (i <= 0)
          {
            AppMethodBeat.o(20267);
            return;
          }
          paramMessage = b.b(this.mdJ).iterator();
          if (!paramMessage.hasNext()) {
            break label359;
          }
          localObject1 = (String)paramMessage.next();
          if ("*".equals(localObject1)) {
            continue;
          }
          localObject2 = g.ca((String)localObject1, false);
          if (localObject2 == null)
          {
            ab.w("MicroMsg.SubCoreExt", "appInfo is null");
            continue;
          }
          if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((f)localObject2).field_appId)) {
            break label136;
          }
        }
        catch (Exception paramMessage)
        {
          ab.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[] { paramMessage.getMessage() });
          AppMethodBeat.o(20267);
          return;
        }
        ab.w("MicroMsg.SubCoreExt", "appId is null");
        continue;
        ab.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[] { localObject1, Integer.valueOf(((f)localObject2).field_appInfoFlag), ((f)localObject2).field_appId });
        localObject1 = b.bts().asu(((f)localObject2).field_appId);
        if (localObject1 != null) {
          break;
        }
        ab.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[] { ((f)localObject2).field_appId });
      }
      if (!g.m((f)localObject2)) {
        break;
      }
    } while (((com.tencent.mm.storage.bo)localObject1).field_status == 1);
    bp localbp;
    for (((com.tencent.mm.storage.bo)localObject1).field_status = 1;; ((com.tencent.mm.storage.bo)localObject1).field_status = 0)
    {
      localbp = b.bts();
      localObject2 = ((f)localObject2).field_appId;
      if ((!com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String)localObject2)) && (localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((com.tencent.mm.storage.bo)localObject1).field_appId))) {
        break label288;
      }
      ab.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
      break;
      if (((com.tencent.mm.storage.bo)localObject1).field_status == 0) {
        break;
      }
    }
    label288:
    ContentValues localContentValues = ((com.tencent.mm.storage.bo)localObject1).convertTo();
    if (localContentValues.size() > 0) {}
    for (int i = localbp.db.update("OpenMsgListener", localContentValues, "appId=?", new String[] { com.tencent.mm.sdk.platformtools.bo.wC((String)localObject2) });; i = 0)
    {
      ab.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[] { ((com.tencent.mm.storage.bo)localObject1).field_appId, Integer.valueOf(i) });
      break;
      label359:
      b.b(this.mdJ).clear();
      AppMethodBeat.o(20267);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.8
 * JD-Core Version:    0.7.0.1
 */