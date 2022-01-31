package com.tencent.mm.plugin.emojicapture.proxy;

import a.h.l;
import a.k;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

public final class VoiceInputProxy
  extends a
{
  private static com.tencent.mm.modelvoiceaddr.g jny;
  public static final VoiceInputProxy.a jnz = new VoiceInputProxy.a((byte)0);
  private final String TAG;
  private final VoiceInputProxy.b jnx;
  
  public VoiceInputProxy(VoiceInputProxy.b paramb, d paramd)
  {
    super(paramd);
    this.jnx = paramb;
    this.TAG = "MicroMsg.VoiceInputProxy";
  }
  
  @com.tencent.mm.remoteservice.e
  public final int getMaxAmplitudeRate()
  {
    Object localObject = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
    if ((localObject != null) && ((localObject instanceof Integer))) {
      return ((Number)localObject).intValue();
    }
    return 0;
  }
  
  @f
  public final int getMaxAmplitudeRateRemote()
  {
    y.d(this.TAG, "getMaxAmplitudeRateRemote call " + access$getVoiceInputRemote$cp());
    if (access$getVoiceInputRemote$cp() != null)
    {
      com.tencent.mm.modelvoiceaddr.g localg = access$getVoiceInputRemote$cp();
      if (localg == null) {
        a.d.b.g.cUk();
      }
      return localg.getMaxAmplitudeRate();
    }
    return 0;
  }
  
  @com.tencent.mm.remoteservice.e
  public final void onRecongnizeFinish()
  {
    VoiceInputProxy.b localb = this.jnx;
    if (localb != null) {
      localb.TC();
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public final void onRes(String paramString)
  {
    VoiceInputProxy.b localb = this.jnx;
    if (localb != null) {
      localb.onRes(paramString);
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public final void start()
  {
    REMOTE_CALL("startRemote", new Object[0]);
  }
  
  @f
  public final void startRemote()
  {
    Object localObject = new c(this);
    access$setVoiceInputRemote$cp(new com.tencent.mm.modelvoiceaddr.g(com.tencent.mm.modelvoiceaddr.g.eLT, 0, (g.b)localObject));
    localObject = access$getVoiceInputRemote$cp();
    if (localObject != null) {
      ((com.tencent.mm.modelvoiceaddr.g)localObject).start();
    }
  }
  
  @com.tencent.mm.remoteservice.e
  public final void stop(boolean paramBoolean)
  {
    REMOTE_CALL("stopRemote", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  @f
  public final void stopRemote(boolean paramBoolean)
  {
    com.tencent.mm.modelvoiceaddr.g localg = access$getVoiceInputRemote$cp();
    if (localg != null) {
      localg.stop(paramBoolean);
    }
    access$setVoiceInputRemote$cp(null);
  }
  
  public static final class c
    implements g.b
  {
    public final void TC()
    {
      y.i(VoiceInputProxy.access$getTAG$p(this.jnA), "onRecognizeFinish");
      this.jnA.CLIENT_CALL("onRecognizeFinish", new Object[0]);
    }
    
    public final void Ty()
    {
      y.i(VoiceInputProxy.access$getTAG$p(this.jnA), "onRecordFin");
    }
    
    public final void a(String[] paramArrayOfString, Set<String> paramSet)
    {
      if (paramArrayOfString != null)
      {
        if (((Object[])paramArrayOfString).length == 0)
        {
          i = 1;
          if (i != 0) {
            break label142;
          }
          i = 1;
          label20:
          if (i == 0) {
            return;
          }
          if (((CharSequence)paramArrayOfString[0]).length() <= 0) {
            break label147;
          }
          i = 1;
          label40:
          if (i == 0) {
            return;
          }
          paramSet = paramArrayOfString[0];
          y.i(VoiceInputProxy.access$getTAG$p(this.jnA), "onRes remote " + paramSet);
          paramArrayOfString = (CharSequence)paramSet;
          i = a.h.e.Y(paramArrayOfString);
          a.d.b.g.k(paramArrayOfString, "$receiver");
          a.d.b.g.k("。", "string");
          if ((paramArrayOfString instanceof String)) {
            break label152;
          }
        }
        label142:
        label147:
        label152:
        for (int i = l.b(paramArrayOfString, (CharSequence)"。", i, 0, true);; i = ((String)paramArrayOfString).lastIndexOf("。", i))
        {
          paramArrayOfString = paramSet;
          if (i < 0) {
            break label179;
          }
          if (paramSet != null) {
            break label166;
          }
          throw new k("null cannot be cast to non-null type java.lang.String");
          i = 0;
          break;
          i = 0;
          break label20;
          i = 0;
          break label40;
        }
        label166:
        paramArrayOfString = paramSet.substring(0, i);
        a.d.b.g.j(paramArrayOfString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        label179:
        this.jnA.CLIENT_CALL("onRes", new Object[] { paramArrayOfString });
      }
    }
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      y.w(VoiceInputProxy.access$getTAG$p(this.jnA), "onError " + paramInt1 + ' ' + paramInt2 + ' ' + paramInt3 + ' ' + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy
 * JD-Core Version:    0.7.0.1
 */