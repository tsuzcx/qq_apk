package com.tencent.mm.plugin.flutter.e.a.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/plugins/video/api/EditReadPlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "uniqueId", "", "(Ljava/lang/String;)V", "reqId", "", "simpleAudioRemuxer", "Lcom/tencent/mm/plugin/vlog/ui/plugin/read/SimpleAudioRemuxer;", "uniqueString", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "kotlin.jvm.PlatformType", "cancel", "", "doNetRequest", "finderUserName", "inputText", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "textToSpeech", "text", "Companion", "plugin-flutter_release"})
public final class b
  implements i, com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static int wJJ;
  public static final b.a wJK;
  private final VideoTransPara irT;
  public int wJG;
  private String wJH;
  private final com.tencent.mm.plugin.vlog.ui.plugin.read.d wJI;
  
  static
  {
    AppMethodBeat.i(241060);
    wJK = new b.a((byte)0);
    AppMethodBeat.o(241060);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(241059);
    this.wJG = -1;
    this.wJH = paramString;
    paramString = com.tencent.mm.kernel.g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(5207, (i)this);
    this.wJI = new com.tencent.mm.plugin.vlog.ui.plugin.read.d();
    paramString = e.baZ();
    p.g(paramString, "SubCoreVideoControl.getCore()");
    this.irT = paramString.bbf();
    AppMethodBeat.o(241059);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241061);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(241061);
  }
  
  public final void onResume() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(241057);
    if (((paramq instanceof com.tencent.mm.plugin.vlog.ui.plugin.read.b)) && (((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).wJG == this.wJG))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        final String str1 = com.tencent.mm.plugin.sight.base.b.eVt() + '/' + UUID.randomUUID();
        final String str2 = str1 + ".wav";
        StringBuilder localStringBuilder = new StringBuilder("tts success, input text:").append(((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).GLT).append(", speech size:");
        paramString = ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).GLS;
        if (paramString != null) {}
        for (paramString = Integer.valueOf(paramString.length);; paramString = null)
        {
          Log.i("vison", paramString + ", speech duration:" + ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).durationMs + ", path:" + str1);
          s.C(str1, ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).GLS);
          kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMV(), (m)new b(this, str1, str2, paramq, null), 2);
          AppMethodBeat.o(241057);
          return;
        }
      }
      Log.e("vison", "tts error, input text:" + ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).GLT + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
    }
    AppMethodBeat.o(241057);
  }
  
  public final void release()
  {
    AppMethodBeat.i(241058);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(5207, (i)this);
    AppMethodBeat.o(241058);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.flutter.plugins.video.api.EditReadPlugin$onSceneEnd$1", f="EditReadPlugin.kt", hxM={87}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    
    b(b paramb, String paramString1, String paramString2, q paramq, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(241055);
      p.h(paramd, "completion");
      paramd = new b(this.wJL, str1, str2, paramq, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(241055);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(241056);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(241056);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(241054);
      Object localObject = a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(241054);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        ai localai = this.p$;
        paramObject = new z.a();
        paramObject.SYB = false;
        kotlin.d.f localf = (kotlin.d.f)ba.hMW();
        m localm = (m)new j(paramObject, null)
        {
          int label;
          private ai p$;
          
          public final kotlin.d.d<x> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(241052);
            p.h(paramAnonymousd, "completion");
            paramAnonymousd = new 1(this.wJO, paramObject, paramAnonymousd);
            paramAnonymousd.p$ = ((ai)paramAnonymousObject);
            AppMethodBeat.o(241052);
            return paramAnonymousd;
          }
          
          public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(241053);
            paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(x.SXb);
            AppMethodBeat.o(241053);
            return paramAnonymousObject1;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(241051);
            a locala = a.SXO;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(241051);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = paramObject;
            b.a(this.wJO.wJL);
            paramAnonymousObject.SYB = com.tencent.mm.plugin.vlog.ui.plugin.read.d.ak(this.wJO.wJM, this.wJO.wJN, b.b(this.wJO.wJL).audioChannelCount);
            paramAnonymousObject = x.SXb;
            AppMethodBeat.o(241051);
            return paramAnonymousObject;
          }
        };
        this.L$0 = localai;
        this.pED = paramObject;
        this.label = 1;
        if (kotlinx.coroutines.g.a(localf, localm, this) == localObject)
        {
          AppMethodBeat.o(241054);
          return localObject;
        }
        break;
      case 1: 
        localObject = (z.a)this.pED;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
      }
      for (;;)
      {
        if (paramObject.SYB)
        {
          Log.i("vison", "PATH = " + str2 + " , duration = " + ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).durationMs);
          paramObject = new ArrayList();
          paramObject.add(b.c(this.wJL));
          paramObject.add(str2);
          paramObject.add(kotlin.d.b.a.b.Pe(((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).durationMs));
          localObject = o.wKI;
          o.a.dMh().t("textToSpeech", paramObject);
        }
        for (;;)
        {
          paramObject = x.SXb;
          AppMethodBeat.o(241054);
          return paramObject;
          Log.e("vison", "tts remux error, input text:" + ((com.tencent.mm.plugin.vlog.ui.plugin.read.b)paramq).GLT);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.a.a.b
 * JD-Core Version:    0.7.0.1
 */