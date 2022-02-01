package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy
  extends a
{
  private static g uXq;
  public static final a uXr;
  private final String TAG;
  private b uXp;
  
  static
  {
    AppMethodBeat.i(433);
    uXr = new a((byte)0);
    AppMethodBeat.o(433);
  }
  
  public VoiceInputProxy(b paramb, d paramd)
  {
    super(paramd);
    this.uXp = paramb;
    this.TAG = "MicroMsg.VoiceInputProxy";
  }
  
  @e
  public final int getMaxAmplitudeRate()
  {
    AppMethodBeat.i(429);
    Object localObject = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(429);
      return i;
    }
    AppMethodBeat.o(429);
    return 0;
  }
  
  @f
  public final int getMaxAmplitudeRateRemote()
  {
    AppMethodBeat.i(431);
    Log.d(this.TAG, "getMaxAmplitudeRateRemote call " + uXq);
    if (uXq != null)
    {
      g localg = uXq;
      if (localg == null) {
        p.iCn();
      }
      int i = localg.getMaxAmplitudeRate();
      AppMethodBeat.o(431);
      return i;
    }
    AppMethodBeat.o(431);
    return 0;
  }
  
  public final b getUiCallback()
  {
    return this.uXp;
  }
  
  @e
  public final void onRecongnizeFinish()
  {
    AppMethodBeat.i(428);
    b localb = this.uXp;
    if (localb != null)
    {
      localb.brX();
      AppMethodBeat.o(428);
      return;
    }
    AppMethodBeat.o(428);
  }
  
  @e
  public final void onRes(String paramString)
  {
    AppMethodBeat.i(427);
    b localb = this.uXp;
    if (localb != null)
    {
      localb.onRes(paramString);
      AppMethodBeat.o(427);
      return;
    }
    AppMethodBeat.o(427);
  }
  
  public final void setUiCallback(b paramb)
  {
    this.uXp = paramb;
  }
  
  @e
  public final void start()
  {
    AppMethodBeat.i(425);
    REMOTE_CALL("startRemote", new Object[0]);
    AppMethodBeat.o(425);
  }
  
  @f
  public final void startRemote()
  {
    AppMethodBeat.i(430);
    Object localObject = new c(this);
    localObject = new g(g.mlT, 9, (g.b)localObject);
    uXq = (g)localObject;
    ((g)localObject).start();
    AppMethodBeat.o(430);
  }
  
  @e
  public final void stop(boolean paramBoolean)
  {
    AppMethodBeat.i(426);
    REMOTE_CALL("stopRemote", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(426);
  }
  
  @f
  public final void stopRemote(boolean paramBoolean)
  {
    AppMethodBeat.i(432);
    g localg = uXq;
    if (localg != null) {
      localg.stop(paramBoolean);
    }
    uXq = null;
    AppMethodBeat.o(432);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$Companion;", "", "()V", "voiceInputRemote", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr;", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void brX();
    
    public abstract void onRes(String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
  public static final class c
    implements g.b
  {
    public final void b(String[] paramArrayOfString, List<String> paramList)
    {
      AppMethodBeat.i(421);
      if (paramArrayOfString != null)
      {
        int i;
        if (paramArrayOfString.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label113;
          }
          i = 1;
          label23:
          if (i == 0) {
            break label154;
          }
          if (((CharSequence)paramArrayOfString[0]).length() <= 0) {
            break label118;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            paramList = paramArrayOfString[0];
            Log.i(VoiceInputProxy.access$getTAG$p(this.uXs), "onRes remote ".concat(String.valueOf(paramList)));
            i = n.g((CharSequence)paramList, "。");
            paramArrayOfString = paramList;
            if (i >= 0)
            {
              if (paramList == null)
              {
                paramArrayOfString = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(421);
                throw paramArrayOfString;
                i = 0;
                break;
                label113:
                i = 0;
                break label23;
                label118:
                i = 0;
                continue;
              }
              paramArrayOfString = paramList.substring(0, i);
              p.j(paramArrayOfString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.uXs.CLIENT_CALL("onRes", new Object[] { paramArrayOfString });
          }
        }
      }
      label154:
      AppMethodBeat.o(421);
    }
    
    public final void brT()
    {
      AppMethodBeat.i(423);
      Log.i(VoiceInputProxy.access$getTAG$p(this.uXs), "onRecordFin");
      AppMethodBeat.o(423);
    }
    
    public final void brX()
    {
      AppMethodBeat.i(424);
      Log.i(VoiceInputProxy.access$getTAG$p(this.uXs), "onRecognizeFinish");
      this.uXs.CLIENT_CALL("onRecognizeFinish", new Object[0]);
      AppMethodBeat.o(424);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(422);
      Log.w(VoiceInputProxy.access$getTAG$p(this.uXs), "onError " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramLong);
      AppMethodBeat.o(422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy
 * JD-Core Version:    0.7.0.1
 */