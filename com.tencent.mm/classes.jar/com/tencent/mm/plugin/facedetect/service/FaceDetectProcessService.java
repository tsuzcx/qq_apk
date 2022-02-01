package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.service.MMService;
import com.tencent.mm.vfs.i;

public class FaceDetectProcessService
  extends MMService
{
  private a qzA;
  private a qzx;
  public g qzy;
  private Messenger qzz;
  
  public FaceDetectProcessService()
  {
    AppMethodBeat.i(103859);
    this.qzx = new a();
    this.qzy = null;
    this.qzz = null;
    this.qzA = null;
    AppMethodBeat.o(103859);
  }
  
  private void fv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103866);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    p(localMessage);
    AppMethodBeat.o(103866);
  }
  
  private void p(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(103867);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    if (paramBundle != null) {
      localMessage.setData(paramBundle);
    }
    p(localMessage);
    AppMethodBeat.o(103867);
  }
  
  private void p(Message paramMessage)
  {
    AppMethodBeat.i(103865);
    try
    {
      if (this.qzz != null)
      {
        ac.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", new Object[] { Integer.valueOf(paramMessage.what), paramMessage.toString(), Integer.valueOf(this.qzz.hashCode()) });
        this.qzz.send(paramMessage);
      }
      AppMethodBeat.o(103865);
      return;
    }
    catch (RemoteException paramMessage)
    {
      ac.printErrStackTrace("MicroMsg.FaceDetectProcessService", paramMessage, "", new Object[0]);
      AppMethodBeat.o(103865);
    }
  }
  
  public final IBinder Uz()
  {
    AppMethodBeat.i(103862);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.qzx = new a();
    a locala = this.qzx;
    AppMethodBeat.o(103862);
    return locala;
  }
  
  public final String getTag()
  {
    return "MicroMsg.FaceDetectProcessService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(103860);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    super.onCreate();
    this.qzy = new g();
    AppMethodBeat.o(103860);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(103864);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
    super.onDestroy();
    AppMethodBeat.o(103864);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103861);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
    if (paramIntent == null)
    {
      ac.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103861);
      return paramInt1;
    }
    Object localObject1 = (Messenger)paramIntent.getParcelableExtra("k_messenger");
    if (localObject1 != null)
    {
      this.qzz = ((Messenger)localObject1);
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103861);
      return paramInt1;
    }
    int i = paramIntent.getIntExtra("k_cmd", -1);
    ac.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      ac.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
    }
    for (;;)
    {
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(103861);
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
        label247:
        this.qzA = ((a)localObject1);
        localObject1 = this.qzy;
        if (((g)localObject1).qxy != null)
        {
          ac.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
          ((g)localObject1).cnA();
        }
        if (!p.cnF())
        {
          ac.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
          i = -4;
        }
        break;
      }
      for (;;)
      {
        fv(0, i);
        break;
        localObject1 = null;
        break label247;
        localObject1 = new b();
        break label247;
        if (!PluginFace.isEnabled())
        {
          ac.w("MicroMsg.FaceDetectNativeManager", "expansions file is not yet installed");
          i = -5;
        }
        else
        {
          ((g)localObject1).qxy = new FaceProNative();
          i = ((g)localObject1).qxy.engineInit((String)localObject2, arrayOfByte, i.k(p.cnK(), true), p.cnL());
          ac.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", new Object[] { Integer.valueOf(i) });
        }
      }
      f.al(new Runnable()
      {
        public final void b(final FaceProNative.FaceResult paramAnonymousFaceResult)
        {
          int j = -1;
          AppMethodBeat.i(103856);
          boolean bool;
          if (paramAnonymousFaceResult == null)
          {
            bool = true;
            if (paramAnonymousFaceResult == null) {
              break label98;
            }
          }
          label98:
          for (int i = paramAnonymousFaceResult.result;; i = -1)
          {
            ac.i("MicroMsg.FaceDetectProcessService", "alvinluo release out result == null:%b, result: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
            if ((paramAnonymousFaceResult != null) && (paramAnonymousFaceResult.result == 0)) {
              break label103;
            }
            ac.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
            i = j;
            if (paramAnonymousFaceResult != null) {
              i = paramAnonymousFaceResult.result;
            }
            FaceDetectProcessService.a(FaceDetectProcessService.this, i);
            AppMethodBeat.o(103856);
            return;
            bool = false;
            break;
          }
          label103:
          f.al(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103855);
              String str = p.a(paramAnonymousFaceResult);
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_face_result_code", 0);
              localBundle.putString("key_face_result_file_path", str);
              FaceDetectProcessService.a(FaceDetectProcessService.this, localBundle);
              AppMethodBeat.o(103855);
            }
          });
          AppMethodBeat.o(103856);
        }
      }
      {
        public final void run()
        {
          AppMethodBeat.i(103858);
          ac.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103857);
              FaceDetectProcessService.2.this.qzE.b(this.qzF);
              AppMethodBeat.o(103857);
            }
          });
          AppMethodBeat.o(103858);
        }
      });
      continue;
      boolean bool = paramIntent.getBooleanExtra("key_is_need_video", false);
      com.tencent.mm.plugin.facedetect.e.a.coq().qCF = bool;
      continue;
      if (this.qzA != null)
      {
        this.qzA.ag(paramIntent);
        continue;
        localObject1 = paramIntent.getStringExtra("key_bio_buffer_path");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("key_bio_buffer_path", (String)localObject1);
        p(6, (Bundle)localObject2);
      }
    }
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(103863);
    ac.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(103863);
    return bool;
  }
  
  public final class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService
 * JD-Core Version:    0.7.0.1
 */