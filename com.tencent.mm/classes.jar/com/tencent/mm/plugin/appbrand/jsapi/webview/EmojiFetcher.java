package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher;", "", "()V", "GIF_BYTES_CACHE", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "", "TAG", "fetchGifBytes", "md5", "encryptUrl", "aesKey", "productId", "designerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "EmojiArgs", "MMLogic", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiFetcher
{
  public static final EmojiFetcher sLt;
  private static final c<String, byte[]> sLu;
  
  static
  {
    AppMethodBeat.i(327437);
    sLt = new EmojiFetcher();
    sLu = new c(10);
    AppMethodBeat.o(327437);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "Landroid/os/Parcelable;", "md5", "", "encryptUrl", "aesKey", "productId", "designerId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAesKey", "()Ljava/lang/String;", "getDesignerId", "getEncryptUrl", "getMd5", "getProductId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class EmojiArgs
    implements Parcelable
  {
    public static final Parcelable.Creator<EmojiArgs> CREATOR;
    final String aesKey;
    final String hIo;
    final String hIp;
    final String md5;
    final String productId;
    
    static
    {
      AppMethodBeat.i(327436);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(327436);
    }
    
    public EmojiArgs(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(327433);
      this.md5 = paramString1;
      this.hIp = paramString2;
      this.aesKey = paramString3;
      this.productId = paramString4;
      this.hIo = paramString5;
      AppMethodBeat.o(327433);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(327451);
      if (this == paramObject)
      {
        AppMethodBeat.o(327451);
        return true;
      }
      if (!(paramObject instanceof EmojiArgs))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      paramObject = (EmojiArgs)paramObject;
      if (!s.p(this.md5, paramObject.md5))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      if (!s.p(this.hIp, paramObject.hIp))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      if (!s.p(this.aesKey, paramObject.aesKey))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      if (!s.p(this.productId, paramObject.productId))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      if (!s.p(this.hIo, paramObject.hIo))
      {
        AppMethodBeat.o(327451);
        return false;
      }
      AppMethodBeat.o(327451);
      return true;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(327445);
      int n = this.md5.hashCode();
      int i;
      int j;
      label35:
      int k;
      if (this.hIp == null)
      {
        i = 0;
        if (this.aesKey != null) {
          break label91;
        }
        j = 0;
        if (this.productId != null) {
          break label102;
        }
        k = 0;
        label44:
        if (this.hIo != null) {
          break label113;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(327445);
        return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
        i = this.hIp.hashCode();
        break;
        label91:
        j = this.aesKey.hashCode();
        break label35;
        label102:
        k = this.productId.hashCode();
        break label44;
        label113:
        m = this.hIo.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(327441);
      StringBuilder localStringBuilder = new StringBuilder("EmojiArgs(md5='").append(this.md5).append("', encryptUrl=");
      String str2 = this.hIp;
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
      str2 = this.hIo;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str1 = str1 + ')';
      AppMethodBeat.o(327441);
      return str1;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(327463);
      s.u(paramParcel, "out");
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.hIp);
      paramParcel.writeString(this.aesKey);
      paramParcel.writeString(this.productId);
      paramParcel.writeString(this.hIo);
      AppMethodBeat.o(327463);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<EmojiFetcher.EmojiArgs>
    {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$MMLogic;", "", "()V", "TAG", "", "decodeAsGif", "", "emoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "loadEmoji", "args", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToGifCache", "bytes", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    public static final a sLv;
    
    static
    {
      AppMethodBeat.i(327422);
      sLv = new a();
      AppMethodBeat.o(327422);
    }
    
    public static String b(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(327418);
      s.u(paramEmojiInfo, "emoji");
      s.u(paramArrayOfByte, "bytes");
      String str = com.tencent.mm.loader.i.b.bnq();
      paramEmojiInfo = str + paramEmojiInfo.getMd5() + ".data";
      try
      {
        y.bDX(str);
        y.f(paramEmojiInfo, paramArrayOfByte, paramArrayOfByte.length);
        AppMethodBeat.o(327418);
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
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$MMLogic$loadEmoji$3$1", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "onResult", "", "success", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h.a
    {
      a(EmojiFetcher.EmojiArgs paramEmojiArgs, p<? super EmojiInfo> paramp, ah.f<EmojiInfo> paramf) {}
      
      public final void onResult(boolean paramBoolean)
      {
        AppMethodBeat.i(327404);
        Log.i("MicroMsg.AppBrandHTMLWebView.EmojiFetcher.MMLogic", "load with args:" + this.sLw + ", async load success:" + paramBoolean);
        if (paramBoolean)
        {
          locald = (kotlin.d.d)this.bPy;
          localObject = this.sLx.aqH;
          Result.Companion localCompanion = Result.Companion;
          locald.resumeWith(Result.constructor-impl(localObject));
          AppMethodBeat.o(327404);
          return;
        }
        kotlin.d.d locald = (kotlin.d.d)this.bPy;
        Object localObject = Result.Companion;
        locald.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(327404);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "args", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$EmojiArgs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.d
  {
    public static final b<InputType, ResultType> sLy;
    
    static
    {
      AppMethodBeat.i(327419);
      sLy = new b();
      AppMethodBeat.o(327419);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/EmojiFetcher$fetchGifBytes$3$callback$1", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g<IPCString>
  {
    c(EmojiFetcher.EmojiArgs paramEmojiArgs, p<? super byte[]> paramp, String paramString) {}
    
    public final void aYr()
    {
      AppMethodBeat.i(327423);
      Log.e("MicroMsg.AppBrandHTMLWebView.EmojiFetcher", "fetch with args:" + this.sLw + ", onBridgeNotFound()");
      kotlin.d.d locald = (kotlin.d.d)this.bPy;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(327423);
    }
    
    public final void h(Exception paramException)
    {
      AppMethodBeat.i(327426);
      Log.e("MicroMsg.AppBrandHTMLWebView.EmojiFetcher", "fetch with args:" + this.sLw + ", onCaughtInvokeException(" + paramException + ')');
      paramException = (kotlin.d.d)this.bPy;
      Result.Companion localCompanion = Result.Companion;
      paramException.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(327426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.EmojiFetcher
 * JD-Core Version:    0.7.0.1
 */