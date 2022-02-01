package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragmentActivity.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/messenger/sec/SecurityMsgIntercept;", "Lcom/tencent/mm/ui/MMFragmentActivity$Interceptor;", "()V", "TAG", "", "doCgiIfNeed", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "msgId", "", "loading", "intercept", "activity", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements MMFragmentActivity.d
{
  public static final a KRw;
  
  static
  {
    AppMethodBeat.i(288614);
    KRw = new a();
    AppMethodBeat.o(288614);
  }
  
  public final boolean e(final Context paramContext, final String paramString, final Intent paramIntent)
  {
    AppMethodBeat.i(288628);
    long l;
    final int i;
    if (paramIntent == null)
    {
      l = -1L;
      if (l == -1L) {
        break label580;
      }
      if ((paramIntent == null) || (paramIntent.getBooleanExtra("Retr_Security_Is_Intercept", false))) {
        break label102;
      }
      i = 1;
      label40:
      if (i == 0) {
        break label580;
      }
      if (paramIntent != null) {
        paramIntent.putExtra("Retr_Security_Is_Intercept", true);
      }
      if (l != -1L) {
        break label108;
      }
      Log.i("MicroMsg.SecurityMsgIntercept", "doCgi, msgId is -1");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label580;
      }
      AppMethodBeat.o(288628);
      return true;
      l = paramIntent.getLongExtra("Retr_Security_Msg_Id", -1L);
      break;
      label102:
      i = 0;
      break label40;
      label108:
      paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
      if (paramString != null) {
        if ((paramString.jUq & 0x80000) == 0) {
          break label164;
        }
      }
      label164:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label170;
        }
        Log.i("MicroMsg.SecurityMsgIntercept", "doCgi, skip is open");
        i = 0;
        break;
      }
      label170:
      Object localObject1 = (CharSequence)paramString.jUr;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label248;
        }
        Log.i("MicroMsg.SecurityMsgIntercept", "doCgi, msgSource is null");
        paramString.jcm();
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.field_msgId, paramString);
        i = 0;
        break;
      }
      label248:
      localObject1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zld, "");
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label364;
        }
        Log.i("MicroMsg.SecurityMsgIntercept", "doCgi, swt[" + localObject1 + "] is empty");
        paramString.jcm();
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.field_msgId, paramString);
        i = 0;
        break;
      }
      label364:
      localObject2 = com.tencent.mm.message.k.b.Hf(paramString.field_content);
      if (localObject2 == null) {}
      for (i = 0;; i = ((com.tencent.mm.message.k.b)localObject2).type)
      {
        localObject2 = paramString.getType() + '_' + i;
        s.s(localObject1, "swt");
        if (kotlin.n.n.b((CharSequence)localObject1, new String[] { "," }).contains(localObject2)) {
          break label499;
        }
        paramString.jcm();
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramString.field_msgId, paramString);
        Log.i("MicroMsg.SecurityMsgIntercept", s.X("doCgi, skip currentType and set msg open: ", localObject2));
        i = 0;
        break;
      }
      label499:
      paramContext.getString(b.e.app_tip);
      localObject1 = com.tencent.mm.ui.base.k.a(paramContext, paramContext.getString(b.e.app_waiting), true, null);
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((com.tencent.mm.plugin.mvvmbase.a.a)com.tencent.mm.ui.component.k.nq(paramContext).q(com.tencent.mm.plugin.mvvmbase.a.a.class)).gsu();
      LifecycleScope.launchDefault$default((LifecycleScope)localObject2, null, (m)new a((LifecycleScope)localObject2, paramString, i, (com.tencent.mm.ui.base.w)localObject1, paramContext, paramIntent, null), 1, null);
      i = 1;
    }
    label580:
    AppMethodBeat.o(288628);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(LifecycleScope paramLifecycleScope, cc paramcc, int paramInt, com.tencent.mm.ui.base.w paramw, Context paramContext, Intent paramIntent, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(288620);
      paramObject = (kotlin.d.d)new a(this.HzV, paramString, i, this.KRz, paramContext, paramIntent, paramd);
      AppMethodBeat.o(288620);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(288613);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(288613);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      dwz localdwz = new dwz();
      cad localcad = new cad();
      cc localcc = paramString;
      int i = i;
      localcad.Njs = ((int)localcc.field_msgId);
      localObject = localcc.aJO();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localcad.YFE = com.tencent.mm.platformtools.w.Sk(paramObject);
      localObject = localcc.aJP();
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localcad.YFF = com.tencent.mm.platformtools.w.Sk(paramObject);
      localcad.IIs = localcc.getType();
      localcad.aajd = i;
      localcad.CreateTime = ((int)localcc.getCreateTime());
      localObject = localcc.jUr;
      paramObject = localObject;
      if (localObject == null) {
        paramObject = "";
      }
      localcad.YFJ = paramObject;
      localcad.Njv = localcc.field_msgSvrId;
      localcad.YFL = ((int)localcc.field_msgSeq);
      paramObject = ah.aiuX;
      localdwz.abcP = localcad;
      paramObject = localdwz.abcP;
      s.s(paramObject, "request.MsgInfo");
      Log.i("MicroMsg.SecurityMsgIntercept", s.X("doCgi, MsgInfo: ", com.tencent.mm.ae.f.dg(paramObject)));
      paramObject = new com.tencent.mm.am.c.a();
      paramObject.funcId = 6999;
      paramObject.uri = "/cgi-bin/micromsg-bin/forwardmsgviewspam";
      paramObject.otE = ((com.tencent.mm.bx.a)localdwz);
      paramObject.otF = ((com.tencent.mm.bx.a)new dxa());
      paramObject = paramObject.bEF();
      localObject = com.tencent.mm.am.a.b.ovw;
      s.s(paramObject, "commReqResp");
      paramObject = b.a.e(paramObject);
      j.a((aq)this.HzV, (kotlin.d.f)bg.kCh(), null, (m)new kotlin.d.b.a.k(paramObject, this.KRz)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(288612);
          paramAnonymousObject = (kotlin.d.d)new 1(this.KRA, this.KRz, this.KRx, this.$context, this.odM, this.KRy, paramAnonymousd);
          AppMethodBeat.o(288612);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(288611);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(288611);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.KRA;
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.KRz, this.KRx, this.$context, this.odM, this.KRy);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramAnonymousObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(288611);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(288611);
          return paramAnonymousObject;
        }
        
        @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
        public static final class a
          implements kotlinx.coroutines.b.h<com.tencent.mm.am.a.a<dxa>>
        {
          public a(com.tencent.mm.ui.base.w paramw, cc paramcc, Context paramContext, Intent paramIntent, int paramInt) {}
          
          public final Object a(com.tencent.mm.am.a.a<dxa> parama, kotlin.d.d<? super ah> paramd)
          {
            AppMethodBeat.i(288616);
            parama = (com.tencent.mm.am.a.a)parama;
            boolean bool;
            if ((parama.ovD == com.tencent.mm.am.b.b.ovB) && (this.KRB.isShowing()))
            {
              paramd = this.KRB;
              if (paramd != null) {
                paramd.dismiss();
              }
              if (parama.errCode == 0)
              {
                paramd = (dxa)parama.ott;
                if (paramd != null) {
                  break label241;
                }
                bool = false;
                if (!bool) {
                  break label249;
                }
              }
              bool = true;
              label70:
              if (bool) {
                break label254;
              }
              this.KRC.jcm();
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.KRC.field_msgId, this.KRC);
              paramd = this.KRD;
              Object localObject = this.KRE;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramd, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/messenger/sec/SecurityMsgIntercept$doCgiIfNeed$1$2$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramd.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/plugin/messenger/sec/SecurityMsgIntercept$doCgiIfNeed$1$2$invokeSuspend$$inlined$collect$1", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            for (;;)
            {
              Log.i("MicroMsg.SecurityMsgIntercept", "errType:" + parama.errType + ", errCode:" + parama.errCode + ", isBlocked:" + bool);
              parama = ah.aiuX;
              AppMethodBeat.o(288616);
              return parama;
              label241:
              bool = paramd.abcQ;
              break;
              label249:
              bool = false;
              break label70;
              label254:
              switch (this.KRF)
              {
              default: 
                break;
              case 19: 
                com.tencent.mm.ui.base.k.a(this.KRD, this.KRD.getString(b.e.security_msg_intercept_record_failed), "", this.KRD.getString(b.e.app_i_know), false, null);
                break;
              case 24: 
                com.tencent.mm.ui.base.k.a(this.KRD, this.KRD.getString(b.e.security_msg_intercept_fav_note_failed), "", this.KRD.getString(b.e.app_i_know), false, null);
              }
            }
          }
        }
      }, 2);
      paramObject = ah.aiuX;
      AppMethodBeat.o(288613);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.a
 * JD-Core Version:    0.7.0.1
 */