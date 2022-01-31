package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.y;

public class FaceDetectProcessService
  extends Service
{
  private FaceDetectProcessService.a jPO = new FaceDetectProcessService.a(this);
  public g jPP = null;
  private Messenger jPQ = null;
  private a jPR = null;
  
  private void cO(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    k(localMessage);
  }
  
  private void k(int paramInt, Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    if (paramBundle != null) {
      localMessage.setData(paramBundle);
    }
    k(localMessage);
  }
  
  private void k(Message paramMessage)
  {
    try
    {
      if (this.jPQ != null)
      {
        y.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.toString(), Integer.valueOf(this.jPQ.hashCode()) });
        this.jPQ.send(paramMessage);
      }
      return;
    }
    catch (RemoteException paramMessage)
    {
      y.printErrStackTrace("MicroMsg.FaceDetectProcessService", paramMessage, "", new Object[0]);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.jPO = new FaceDetectProcessService.a(this);
    return this.jPO;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate();
    this.jPP = new g();
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
    if (paramIntent == null)
    {
      y.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    Object localObject1 = (Messenger)paramIntent.getParcelableExtra("k_messenger");
    if (localObject1 != null)
    {
      this.jPQ = ((Messenger)localObject1);
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    int i = paramIntent.getIntExtra("k_cmd", -1);
    y.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      y.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
    }
    for (;;)
    {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
      Object localObject2 = paramIntent.getStringExtra("k_bio_id");
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("k_bio_config");
      FaceContextData.a((FaceContextData)paramIntent.getParcelableExtra("k_ontext_data"));
      switch (paramIntent.getIntExtra("k_server_scene", 2))
      {
      case 3: 
      case 4: 
      default: 
        localObject1 = null;
        label219:
        this.jPR = ((a)localObject1);
        localObject1 = this.jPP;
        if (((g)localObject1).jNQ != null)
        {
          y.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
          ((g)localObject1).aOw();
        }
        if (!o.aOB())
        {
          y.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
          i = -4;
        }
        break;
      }
      for (;;)
      {
        cO(0, i);
        break;
        localObject1 = null;
        break label219;
        localObject1 = new b();
        break label219;
        ((g)localObject1).jNQ = new FaceProNative();
        i = ((g)localObject1).jNQ.engineInit((String)localObject2, arrayOfByte, o.aOD(), o.aOE());
        y.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", new Object[] { Integer.valueOf(i) });
      }
      f.J(new FaceDetectProcessService.2(this, new p()
      {
        public final void b(FaceProNative.FaceResult paramAnonymousFaceResult)
        {
          int j = -1;
          boolean bool;
          if (paramAnonymousFaceResult == null)
          {
            bool = true;
            if (paramAnonymousFaceResult == null) {
              break label88;
            }
          }
          label88:
          for (int i = paramAnonymousFaceResult.result;; i = -1)
          {
            y.i("MicroMsg.FaceDetectProcessService", "alvinluo release out result == null:%b, result: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
            if ((paramAnonymousFaceResult != null) && (paramAnonymousFaceResult.result == 0)) {
              break label93;
            }
            y.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
            i = j;
            if (paramAnonymousFaceResult != null) {
              i = paramAnonymousFaceResult.result;
            }
            FaceDetectProcessService.a(FaceDetectProcessService.this, i);
            return;
            bool = false;
            break;
          }
          label93:
          f.J(new FaceDetectProcessService.1.1(this, paramAnonymousFaceResult));
        }
      }));
      continue;
      boolean bool = paramIntent.getBooleanExtra("key_is_need_video", false);
      com.tencent.mm.plugin.facedetect.e.a.aPj().jST = bool;
      continue;
      if (this.jPR != null)
      {
        this.jPR.y(paramIntent);
        continue;
        localObject1 = paramIntent.getStringExtra("key_bio_buffer_path");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_bio_buffer_path", (String)localObject1);
        k(6, (Bundle)localObject2);
      }
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService
 * JD-Core Version:    0.7.0.1
 */