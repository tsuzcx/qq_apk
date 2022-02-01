package com.tencent.mm.emojisearch.a;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManagerRemote;", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "()V", "getEmojiSearchList", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "IPCEmojiSearch", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  public static final a moP;
  private static final String moQ;
  private static final String moR;
  
  static
  {
    AppMethodBeat.i(231450);
    moP = new a((byte)0);
    moQ = "model";
    moR = "resp";
    AppMethodBeat.o(231450);
  }
  
  public final Object a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, kotlin.d.d<? super enr> paramd)
  {
    AppMethodBeat.i(231455);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable(moQ, (Parcelable)paramSimilarEmojiQueryModel);
    paramSimilarEmojiQueryModel = new q(kotlin.d.a.b.au(paramd), 1);
    paramSimilarEmojiQueryModel.kBA();
    p localp = (p)paramSimilarEmojiQueryModel;
    j.a(MMApplicationContext.getMainProcessName(), (Parcelable)localBundle, b.class, (f)new c(localp));
    paramSimilarEmojiQueryModel = paramSimilarEmojiQueryModel.getResult();
    if (paramSimilarEmojiQueryModel == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(231455);
    return paramSimilarEmojiQueryModel;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManagerRemote$Companion;", "", "()V", "KEY_MODEL", "", "KEY_RESP", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManagerRemote$IPCEmojiSearch;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, Bundle paramBundle, f<Bundle> paramf, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(231460);
        paramObject = (kotlin.d.d)new a(this.moS, this.moT, this.mht, paramd);
        AppMethodBeat.o(231460);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(231453);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(231453);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
        }
        try
        {
          paramObject = new a();
          Object localObject = this.moS;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          paramObject = paramObject.a((SimilarEmojiQueryModel)localObject, locald);
          localObject = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(231453);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject = paramObject;
          }
          paramObject = (enr)localObject;
          this.moT.putByteArray(b.aWO(), paramObject.toByteArray());
          paramObject = this.mht;
          if (paramObject != null) {
            paramObject.onCallback(this.moT);
          }
        }
        catch (com.tencent.mm.af.a paramObject)
        {
          for (;;)
          {
            paramObject = this.mht;
            if (paramObject != null) {
              paramObject.onCallback(null);
            }
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(231453);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/os/Bundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c<T>
    implements f
  {
    c(p<? super enr> paramp) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emojisearch.a.b
 * JD-Core Version:    0.7.0.1
 */