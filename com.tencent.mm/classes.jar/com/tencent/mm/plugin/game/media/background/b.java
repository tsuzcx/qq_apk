package com.tencent.mm.plugin.game.media.background;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41213);
    ac.i("MicroMsg.Haowan.VideoMixCallback", "onFinish, taskId:%s, success:%b, model:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), paramCaptureVideoNormalModel });
    if (paramString == null)
    {
      AppMethodBeat.o(41213);
      return;
    }
    Object localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    k.h(paramString, "taskId");
    localObject = com.tencent.mm.plugin.recordvideo.background.g.aqy(paramString);
    if (localObject == null) {}
    for (localObject = new Bundle(); ((Bundle)localObject).getInt("key_game_haowan_flag", 0) != 10; localObject = com.tencent.mm.plugin.recordvideo.background.g.aqE((String)localObject))
    {
      ac.i("MicroMsg.Haowan.VideoMixCallback", "not game haowan task");
      AppMethodBeat.o(41213);
      return;
      localObject = ((com.tencent.mm.plugin.recordvideo.background.e)localObject).field_userData;
      k.g(localObject, "videoEditData.field_userData");
    }
    a.a(paramCaptureVideoNormalModel, (Bundle)localObject);
    if ((paramBoolean) && (paramCaptureVideoNormalModel != null))
    {
      localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      localObject = com.tencent.mm.plugin.recordvideo.background.g.aqD(paramString);
      if (localObject != null)
      {
        a.a(((afq)localObject).wqG, paramCaptureVideoNormalModel);
        a.b(((afq)localObject).Eyb, paramCaptureVideoNormalModel);
      }
    }
    paramCaptureVideoNormalModel = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOp();
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "bgMixTaskId", paramString });
    ac.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryTaskByBgMixId, sql : %s", new Object[] { paramString });
    paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.rawQuery(paramString, new String[0]);
    if (paramCaptureVideoNormalModel == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      ac.i("MicroMsg.Haowan.VideoMixCallback", "no perform publish action");
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
      ac.i("MicroMsg.Haowan.VideoMixCallback", "publish has finished");
      AppMethodBeat.o(41213);
      return;
    }
    ((c)com.tencent.mm.kernel.g.ab(c.class)).agN(paramString.field_taskId);
    AppMethodBeat.o(41213);
  }
  
  public final void ahm(String paramString)
  {
    AppMethodBeat.i(41210);
    ac.i("MicroMsg.Haowan.VideoMixCallback", "onInit, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41210);
  }
  
  public final void ahn(String paramString)
  {
    AppMethodBeat.i(41212);
    ac.i("MicroMsg.Haowan.VideoMixCallback", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41212);
  }
  
  public final void dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(41211);
    ac.i("MicroMsg.Haowan.VideoMixCallback", "onRun, taskId:%s, runNum:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(41211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.b
 * JD-Core Version:    0.7.0.1
 */