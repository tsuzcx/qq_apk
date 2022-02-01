package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i.a;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d<-Lcom.tencent.mm.storage.emotion.EmojiInfo;>;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher;", "", "()V", "GIF_BYTES_CACHE", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "", "TAG", "fetchGifBytes", "md5", "encryptUrl", "aesKey", "productId", "designerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "EmojiArgs", "MMLogic", "plugin-appbrand-integration_release"})
public final class EmojiFetcher
{
  private static final c<String, byte[]> pGk;
  public static final EmojiFetcher pGl;
  
  static
  {
    AppMethodBeat.i(253510);
    pGl = new EmojiFetcher();
    pGk = new c(10);
    AppMethodBeat.o(253510);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "Landroid/os/Parcelable;", "md5", "", "encryptUrl", "aesKey", "productId", "designerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAesKey", "()Ljava/lang/String;", "getDesignerId", "getEncryptUrl", "getMd5", "getProductId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class EmojiArgs
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String aesKey;
    final String fDy;
    final String fDz;
    final String md5;
    final String productId;
    
    static
    {
      AppMethodBeat.i(275834);
      CREATOR = new a();
      AppMethodBeat.o(275834);
    }
    
    public EmojiArgs(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(275830);
      this.md5 = paramString1;
      this.fDz = paramString2;
      this.aesKey = paramString3;
      this.productId = paramString4;
      this.fDy = paramString5;
      AppMethodBeat.o(275830);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(275832);
      if (this != paramObject)
      {
        if ((paramObject instanceof EmojiArgs))
        {
          paramObject = (EmojiArgs)paramObject;
          if ((!p.h(this.md5, paramObject.md5)) || (!p.h(this.fDz, paramObject.fDz)) || (!p.h(this.aesKey, paramObject.aesKey)) || (!p.h(this.productId, paramObject.productId)) || (!p.h(this.fDy, paramObject.fDy))) {}
        }
      }
      else
      {
        AppMethodBeat.o(275832);
        return true;
      }
      AppMethodBeat.o(275832);
      return false;
    }
    
    public final int hashCode()
    {
      int n = 0;
      AppMethodBeat.i(275831);
      String str = this.md5;
      int i;
      int j;
      label42:
      int k;
      if (str != null)
      {
        i = str.hashCode();
        str = this.fDz;
        if (str == null) {
          break label129;
        }
        j = str.hashCode();
        str = this.aesKey;
        if (str == null) {
          break label134;
        }
        k = str.hashCode();
        label59:
        str = this.productId;
        if (str == null) {
          break label139;
        }
      }
      label129:
      label134:
      label139:
      for (int m = str.hashCode();; m = 0)
      {
        str = this.fDy;
        if (str != null) {
          n = str.hashCode();
        }
        AppMethodBeat.o(275831);
        return (m + (k + (j + i * 31) * 31) * 31) * 31 + n;
        i = 0;
        break;
        j = 0;
        break label42;
        k = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(275828);
      StringBuilder localStringBuilder = new StringBuilder("EmojiArgs(md5='").append(this.md5).append("', encryptUrl=");
      String str2 = this.fDz;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localStringBuilder = localStringBuilder.append(str1).append(", aesKey=");
      str2 = this.aesKey;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localStringBuilder = localStringBuilder.append(str1).append(", productId=");
      str2 = this.productId;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localStringBuilder = localStringBuilder.append(str1).append(", designerId=");
      str2 = this.fDy;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = str1 + ')';
      AppMethodBeat.o(275828);
      return str1;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(275833);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.fDz);
      paramParcel.writeString(this.aesKey);
      paramParcel.writeString(this.productId);
      paramParcel.writeString(this.fDy);
      AppMethodBeat.o(275833);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(268633);
        p.k(paramParcel, "in");
        paramParcel = new EmojiFetcher.EmojiArgs(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
        AppMethodBeat.o(268633);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new EmojiFetcher.EmojiArgs[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$MMLogic;", "", "()V", "TAG", "", "decodeAsGif", "", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadEmoji", "args", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToGifCache", "bytes", "plugin-appbrand-integration_release"})
  static final class a
  {
    public static final a pGm;
    
    static
    {
      AppMethodBeat.i(269118);
      pGm = new a();
      AppMethodBeat.o(269118);
    }
    
    public static String b(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(269116);
      p.k(paramEmojiInfo, "emoji");
      p.k(paramArrayOfByte, "bytes");
      String str = com.tencent.mm.loader.j.b.aTC();
      paramEmojiInfo = str + paramEmojiInfo.getMd5() + ".data";
      try
      {
        u.bBD(str);
        u.H(paramEmojiInfo, paramArrayOfByte);
        AppMethodBeat.o(269116);
        return paramEmojiInfo;
      }
      catch (IOException paramEmojiInfo)
      {
        for (;;)
        {
          paramEmojiInfo = null;
        }
      }
    }
    
    public final Object a(final EmojiFetcher.EmojiArgs paramEmojiArgs, kotlin.d.d<? super EmojiInfo> paramd)
    {
      AppMethodBeat.i(269115);
      if ((paramd instanceof b))
      {
        localObject1 = (b)paramd;
        if ((((b)localObject1).label & 0x80000000) != 0) {
          ((b)localObject1).label += -2147483648;
        }
      }
      a locala;
      for (paramd = (kotlin.d.d<? super EmojiInfo>)localObject1;; paramd = new b(this, paramd))
      {
        localObject1 = paramd.result;
        locala = a.aaAA;
        switch (paramd.label)
        {
        default: 
          paramEmojiArgs = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(269115);
          throw paramEmojiArgs;
        }
      }
      ResultKt.throwOnFailure(localObject1);
      Object localObject1 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(localObject1, "MMKernel.plugin(IPluginEmoji::class.java)");
      Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)localObject1).getEmojiMgr();
      if (localObject2 == null)
      {
        Log.e("MicroMsg.AppBrandHTMLWebView.EmojiFetcher.MMLogic", "load with args:" + paramEmojiArgs + ", invalid state, emojiMgr is NULL");
        AppMethodBeat.o(269115);
        return null;
      }
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = ((com.tencent.mm.pluginsdk.b.d)localObject2).aud(paramEmojiArgs.md5);
      Object localObject3;
      if ((EmojiInfo)((aa.f)localObject1).aaBC == null)
      {
        localObject3 = new EmojiInfo();
        ((EmojiInfo)localObject3).setMd5(paramEmojiArgs.md5);
        ((EmojiInfo)localObject3).bIR(paramEmojiArgs.productId);
        ((EmojiInfo)localObject3).field_encrypturl = paramEmojiArgs.fDz;
        ((EmojiInfo)localObject3).field_aeskey = paramEmojiArgs.aesKey;
        ((EmojiInfo)localObject3).field_catalog = EmojiInfo.YCx;
        ((EmojiInfo)localObject3).field_designerID = paramEmojiArgs.fDy;
        ((EmojiInfo)localObject3).hBA();
        ((aa.f)localObject1).aaBC = localObject3;
        localObject3 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        p.j(localObject3, "MMKernel.plugin(IPluginEmoji::class.java)");
        localObject3 = ((com.tencent.mm.plugin.emoji.b.d)localObject3).getEmojiStorageMgr();
        p.j(localObject3, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
        ((bj)localObject3).ctY().K((EmojiInfo)((aa.f)localObject1).aaBC);
      }
      if (!((EmojiInfo)((aa.f)localObject1).aaBC).hBr())
      {
        paramd.L$0 = this;
        paramd.oDA = paramEmojiArgs;
        paramd.pGq = localObject2;
        paramd.pGr = localObject1;
        paramd.label = 1;
        localObject2 = new n(kotlin.d.a.b.k(paramd), 1);
        ((n)localObject2).iQM();
        localObject3 = (kotlinx.coroutines.m)localObject2;
        e locale = e.jGI;
        e.a((EmojiInfo)((aa.f)localObject1).aaBC, (i.a)new a((kotlinx.coroutines.m)localObject3, (aa.f)localObject1, paramEmojiArgs));
        localObject1 = ((n)localObject2).getResult();
        if (localObject1 == a.aaAA) {
          p.k(paramd, "frame");
        }
        paramEmojiArgs = (EmojiFetcher.EmojiArgs)localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(269115);
          return locala;
          ResultKt.throwOnFailure(localObject1);
          paramEmojiArgs = (EmojiFetcher.EmojiArgs)localObject1;
        }
        paramEmojiArgs = (EmojiInfo)paramEmojiArgs;
        AppMethodBeat.o(269115);
        return paramEmojiArgs;
      }
      Log.i("MicroMsg.AppBrandHTMLWebView.EmojiFetcher.MMLogic", "load with args:" + paramEmojiArgs + ", return cached info");
      paramEmojiArgs = (EmojiInfo)((aa.f)localObject1).aaBC;
      AppMethodBeat.o(269115);
      return paramEmojiArgs;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$MMLogic$loadEmoji$3$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-appbrand-integration_release"})
    public static final class a
      implements i.a
    {
      a(kotlinx.coroutines.m paramm, aa.f paramf, EmojiFetcher.EmojiArgs paramEmojiArgs) {}
      
      public final void ep(boolean paramBoolean)
      {
        AppMethodBeat.i(279985);
        Log.i("MicroMsg.AppBrandHTMLWebView.EmojiFetcher.MMLogic", "load with args:" + paramEmojiArgs + ", async load success:" + paramBoolean);
        if (paramBoolean)
        {
          locald = (kotlin.d.d)this.khs;
          localObject = (EmojiInfo)this.pGn.aaBC;
          Result.Companion localCompanion = Result.Companion;
          locald.resumeWith(Result.constructor-impl(localObject));
          AppMethodBeat.o(279985);
          return;
        }
        kotlin.d.d locald = (kotlin.d.d)this.khs;
        Object localObject = Result.Companion;
        locald.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(279985);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"loadEmoji", "", "args", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;"})
    static final class b
      extends kotlin.d.b.a.d
    {
      Object L$0;
      int label;
      Object oDA;
      Object pGq;
      Object pGr;
      
      b(EmojiFetcher.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(276571);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.pGp.a(null, this);
        AppMethodBeat.o(276571);
        return paramObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$fetchGifBytes$3$callback$1", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"})
  public static final class b
    implements g<IPCString>
  {
    b(EmojiFetcher.EmojiArgs paramEmojiArgs, kotlinx.coroutines.m paramm, String paramString1, String paramString2, String paramString3) {}
    
    public final void aFq()
    {
      AppMethodBeat.i(269407);
      Log.e("MicroMsg.AppBrandHTMLWebView.EmojiFetcher", "fetch with args:" + this.pGs + ", onBridgeNotFound()");
      kotlin.d.d locald = (kotlin.d.d)this.khs;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(269407);
    }
    
    public final void g(Exception paramException)
    {
      AppMethodBeat.i(269408);
      Log.e("MicroMsg.AppBrandHTMLWebView.EmojiFetcher", "fetch with args:" + this.pGs + ", onCaughtInvokeException(" + paramException + ')');
      paramException = (kotlin.d.d)this.khs;
      Result.Companion localCompanion = Result.Companion;
      paramException.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(269408);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "args", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "invoke"})
  static final class c<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d<EmojiFetcher.EmojiArgs, IPCString>
  {
    public static final c pGy;
    
    static
    {
      AppMethodBeat.i(272897);
      pGy = new c();
      AppMethodBeat.o(272897);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.EmojiFetcher
 * JD-Core Version:    0.7.0.1
 */