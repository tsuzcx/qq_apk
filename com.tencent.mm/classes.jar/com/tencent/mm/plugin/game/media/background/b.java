package com.tencent.mm.plugin.game.media.background;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;

public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41213);
    ae.i("MicroMsg.Haowan.VideoMixCallback", "onFinish, taskId:%s, success:%b, model:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), paramCaptureVideoNormalModel });
    if (paramString == null)
    {
      AppMethodBeat.o(41213);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.xKl;
    p.h(paramString, "taskId");
    localObject = com.tencent.mm.plugin.recordvideo.background.e.awN(paramString);
    if (localObject == null) {}
    for (localObject = new Bundle(); ((Bundle)localObject).getInt("key_game_haowan_flag", 0) != 10; localObject = com.tencent.mm.plugin.recordvideo.background.e.awT((String)localObject))
    {
      ae.i("MicroMsg.Haowan.VideoMixCallback", "not game haowan task");
      AppMethodBeat.o(41213);
      return;
      localObject = ((c)localObject).field_userData;
      p.g(localObject, "videoEditData.field_userData");
    }
    a.a(paramCaptureVideoNormalModel, (Bundle)localObject);
    if ((paramBoolean) && (paramCaptureVideoNormalModel != null))
    {
      localObject = com.tencent.mm.plugin.recordvideo.background.e.xKl;
      localObject = com.tencent.mm.plugin.recordvideo.background.e.awS(paramString);
      if (localObject != null)
      {
        a.a(((aip)localObject).xOt, paramCaptureVideoNormalModel);
        a.b(((aip)localObject).Gyq, paramCaptureVideoNormalModel);
      }
    }
    paramCaptureVideoNormalModel = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZo();
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "bgMixTaskId", paramString });
    ae.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryTaskByBgMixId, sql : %s", new Object[] { paramString });
    paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.rawQuery(paramString, new String[0]);
    if (paramCaptureVideoNormalModel == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      ae.i("MicroMsg.Haowan.VideoMixCallback", "no perform publish action");
      AppMethodBeat.o(41213);
      return;
      paramString = null;
      if (paramCaptureVideoNormalModel.moveToNext())
      {
        paramString = new com.tencent.mm.plugin.game.media.e();
        paramString.convertFrom(paramCaptureVideoNormalModel);
      }
      paramCaptureVideoNormalModel.close();
    }
    if (paramString.field_publishState == 2)
    {
      ae.i("MicroMsg.Haowan.VideoMixCallback", "publish has finished");
      AppMethodBeat.o(41213);
      return;
    }
    ((d)com.tencent.mm.kernel.g.ab(d.class)).ami(paramString.field_taskId);
    AppMethodBeat.o(41213);
  }
  
  public final void amO(String paramString)
  {
    AppMethodBeat.i(41210);
    ae.i("MicroMsg.Haowan.VideoMixCallback", "onInit, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41210);
  }
  
  public final void amP(String paramString)
  {
    AppMethodBeat.i(41212);
    ae.i("MicroMsg.Haowan.VideoMixCallback", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41212);
  }
  
  public final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(41211);
    ae.i("MicroMsg.Haowan.VideoMixCallback", "onRun, taskId:%s, runNum:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(41211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.b
 * JD-Core Version:    0.7.0.1
 */