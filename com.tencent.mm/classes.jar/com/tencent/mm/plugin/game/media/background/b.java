package com.tencent.mm.plugin.game.media.background;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;

public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(41213);
    ad.i("MicroMsg.Haowan.VideoMixCallback", "onFinish, taskId:%s, success:%b, model:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean), paramCaptureVideoNormalModel });
    if (paramString == null)
    {
      AppMethodBeat.o(41213);
      return;
    }
    Object localObject = f.vdH;
    k.h(paramString, "taskId");
    localObject = f.alz(paramString);
    if (localObject == null) {}
    for (localObject = new Bundle(); ((Bundle)localObject).getInt("key_game_haowan_flag", 0) != 10; localObject = f.alF((String)localObject))
    {
      ad.i("MicroMsg.Haowan.VideoMixCallback", "not game haowan task");
      AppMethodBeat.o(41213);
      return;
      localObject = ((d)localObject).field_userData;
      k.g(localObject, "videoEditData.field_userData");
    }
    a.a(paramCaptureVideoNormalModel, (Bundle)localObject);
    if ((paramBoolean) && (paramCaptureVideoNormalModel != null))
    {
      localObject = f.vdH;
      localObject = f.alE(paramString);
      if (localObject != null)
      {
        a.a(((aer)localObject).vhU, paramCaptureVideoNormalModel);
        a.b(((aer)localObject).DeV, paramCaptureVideoNormalModel);
      }
    }
    paramCaptureVideoNormalModel = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBg();
    paramString = String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanPublishEdition", "bgMixTaskId", paramString });
    ad.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryTaskByBgMixId, sql : %s", new Object[] { paramString });
    paramCaptureVideoNormalModel = paramCaptureVideoNormalModel.rawQuery(paramString, new String[0]);
    if (paramCaptureVideoNormalModel == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      ad.i("MicroMsg.Haowan.VideoMixCallback", "no perform publish action");
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
      ad.i("MicroMsg.Haowan.VideoMixCallback", "publish has finished");
      AppMethodBeat.o(41213);
      return;
    }
    ((c)com.tencent.mm.kernel.g.ab(c.class)).abV(paramString.field_taskId);
    AppMethodBeat.o(41213);
  }
  
  public final void acu(String paramString)
  {
    AppMethodBeat.i(41210);
    ad.i("MicroMsg.Haowan.VideoMixCallback", "onInit, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41210);
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(41212);
    ad.i("MicroMsg.Haowan.VideoMixCallback", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(41212);
  }
  
  public final void dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(41211);
    ad.i("MicroMsg.Haowan.VideoMixCallback", "onRun, taskId:%s, runNum:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(41211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.background.b
 * JD-Core Version:    0.7.0.1
 */