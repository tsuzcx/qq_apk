package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.service.MMService;

public class FaceDetectProcessService
  extends MMService
{
  private FaceDetectProcessService.a mke;
  public g mkf;
  private Messenger mkg;
  private a mkh;
  
  public FaceDetectProcessService()
  {
    AppMethodBeat.i(340);
    this.mke = new FaceDetectProcessService.a(this);
    this.mkf = null;
    this.mkg = null;
    this.mkh = null;
    AppMethodBeat.o(340);
  }
  
  private void em(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(347);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    q(localMessage);
    AppMethodBeat.o(347);
  }
  
  private void n(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(348);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    if (paramBundle != null) {
      localMessage.setData(paramBundle);
    }
    q(localMessage);
    AppMethodBeat.o(348);
  }
  
  private void q(Message paramMessage)
  {
    AppMethodBeat.i(346);
    try
    {
      if (this.mkg != null)
      {
        ab.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.toString(), Integer.valueOf(this.mkg.hashCode()) });
        this.mkg.send(paramMessage);
      }
      AppMethodBeat.o(346);
      return;
    }
    catch (RemoteException paramMessage)
    {
      ab.printErrStackTrace("MicroMsg.FaceDetectProcessService", paramMessage, "", new Object[0]);
      AppMethodBeat.o(346);
    }
  }
  
  public final IBinder It()
  {
    AppMethodBeat.i(343);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.mke = new FaceDetectProcessService.a(this);
    FaceDetectProcessService.a locala = this.mke;
    AppMethodBeat.o(343);
    return locala;
  }
  
  public final String getTag()
  {
    return "MicroMsg.FaceDetectProcessService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(341);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate();
    this.mkf = new g();
    AppMethodBeat.o(341);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(345);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
    super.onDestroy();
    AppMethodBeat.o(345);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(342);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
    if (paramIntent == null)
    {
      ab.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(342);
      return paramInt1;
    }
    Object localObject1 = (Messenger)paramIntent.getParcelableExtra("k_messenger");
    if (localObject1 != null)
    {
      this.mkg = ((Messenger)localObject1);
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(342);
      return paramInt1;
    }
    int i = paramIntent.getIntExtra("k_cmd", -1);
    ab.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      ab.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
    }
    for (;;)
    {
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(342);
      return paramInt1;
      Object localObject2 = paramIntent.getStringExtra("k_bio_id");
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("k_bio_config");
      FaceContextData.a((FaceContextData)paramIntent.getParcelableExtra("k_ontext_data"));
      switch (paramIntent.getIntExtra("k_server_scene", 2))
      {
      case 3: 
      case 4: 
      default: 
        localObject1 = null;
        label251:
        this.mkh = ((a)localObject1);
        localObject1 = this.mkf;
        if (((g)localObject1).mic != null)
        {
          ab.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
          ((g)localObject1).buz();
        }
        if (!p.buF())
        {
          ab.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
          i = -4;
        }
        break;
      }
      for (;;)
      {
        em(0, i);
        break;
        localObject1 = null;
        break label251;
        localObject1 = new b();
        break label251;
        ((g)localObject1).mic = new FaceProNative();
        i = ((g)localObject1).mic.engineInit((String)localObject2, arrayOfByte, p.buH(), p.buI());
        ab.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", new Object[] { Integer.valueOf(i) });
      }
      f.S(new FaceDetectProcessService.2(this, new q()
      {
        public final void b(final FaceProNative.FaceResult paramAnonymousFaceResult)
        {
          int j = -1;
          AppMethodBeat.i(337);
          boolean bool;
          if (paramAnonymousFaceResult == null)
          {
            bool = true;
            if (paramAnonymousFaceResult == null) {
              break label100;
            }
          }
          label100:
          for (int i = paramAnonymousFaceResult.result;; i = -1)
          {
            ab.i("MicroMsg.FaceDetectProcessService", "alvinluo release out result == null:%b, result: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
            if ((paramAnonymousFaceResult != null) && (paramAnonymousFaceResult.result == 0)) {
              break label105;
            }
            ab.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
            i = j;
            if (paramAnonymousFaceResult != null) {
              i = paramAnonymousFaceResult.result;
            }
            FaceDetectProcessService.a(FaceDetectProcessService.this, i);
            AppMethodBeat.o(337);
            return;
            bool = false;
            break;
          }
          label105:
          f.S(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(336);
              String str = p.a(paramAnonymousFaceResult);
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_face_result_code", 0);
              localBundle.putString("key_face_result_file_path", str);
              FaceDetectProcessService.a(FaceDetectProcessService.this, localBundle);
              AppMethodBeat.o(336);
            }
          });
          AppMethodBeat.o(337);
        }
      }));
      continue;
      boolean bool = paramIntent.getBooleanExtra("key_is_need_video", false);
      com.tencent.mm.plugin.facedetect.e.a.bvo().mnp = bool;
      continue;
      if (this.mkh != null)
      {
        this.mkh.R(paramIntent);
        continue;
        localObject1 = paramIntent.getStringExtra("key_bio_buffer_path");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_bio_buffer_path", (String)localObject1);
        n(6, (Bundle)localObject2);
      }
    }
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(344);
    ab.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(344);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService
 * JD-Core Version:    0.7.0.1
 */