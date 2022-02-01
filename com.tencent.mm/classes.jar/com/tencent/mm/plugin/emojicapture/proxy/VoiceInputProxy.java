package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy
  extends a
{
  private static g oNi;
  public static final a oNj;
  private final String TAG;
  private b oNh;
  
  static
  {
    AppMethodBeat.i(433);
    oNj = new a((byte)0);
    AppMethodBeat.o(433);
  }
  
  public VoiceInputProxy(b paramb, d paramd)
  {
    super(paramd);
    this.oNh = paramb;
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
    ad.d(this.TAG, "getMaxAmplitudeRateRemote call " + oNi);
    if (oNi != null)
    {
      g localg = oNi;
      if (localg == null) {
        k.fvU();
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
    return this.oNh;
  }
  
  @e
  public final void onRecongnizeFinish()
  {
    AppMethodBeat.i(428);
    b localb = this.oNh;
    if (localb != null)
    {
      localb.aDU();
      AppMethodBeat.o(428);
      return;
    }
    AppMethodBeat.o(428);
  }
  
  @e
  public final void onRes(String paramString)
  {
    AppMethodBeat.i(427);
    b localb = this.oNh;
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
    this.oNh = paramb;
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
    localObject = new g(g.hEm, 9, (g.b)localObject);
    oNi = (g)localObject;
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
    g localg = oNi;
    if (localg != null) {
      localg.stop(paramBoolean);
    }
    oNi = null;
    AppMethodBeat.o(432);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$Companion;", "", "()V", "voiceInputRemote", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr;", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void aDU();
    
    public abstract void onRes(String paramString);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
  public static final class c
    implements g.b
  {
    public final void aDQ()
    {
      AppMethodBeat.i(423);
      ad.i(VoiceInputProxy.access$getTAG$p(this.oNk), "onRecordFin");
      AppMethodBeat.o(423);
    }
    
    public final void aDU()
    {
      AppMethodBeat.i(424);
      ad.i(VoiceInputProxy.access$getTAG$p(this.oNk), "onRecognizeFinish");
      this.oNk.CLIENT_CALL("onRecognizeFinish", new Object[0]);
      AppMethodBeat.o(424);
    }
    
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
            ad.i(VoiceInputProxy.access$getTAG$p(this.oNk), "onRes remote ".concat(String.valueOf(paramList)));
            i = n.e((CharSequence)paramList, "。");
            paramArrayOfString = paramList;
            if (i >= 0)
            {
              if (paramList == null)
              {
                paramArrayOfString = new v("null cannot be cast to non-null type java.lang.String");
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
              k.g(paramArrayOfString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            this.oNk.CLIENT_CALL("onRes", new Object[] { paramArrayOfString });
          }
        }
      }
      label154:
      AppMethodBeat.o(421);
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      AppMethodBeat.i(422);
      ad.w(VoiceInputProxy.access$getTAG$p(this.oNk), "onError " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramLong);
      AppMethodBeat.o(422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy
 * JD-Core Version:    0.7.0.1
 */