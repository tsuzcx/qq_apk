package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;", "", "()V", "TAG", "", "decodeThumb", "Landroid/graphics/Bitmap;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "byteArray", "", "getDecoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "md5", "isValid", "", "decoder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMGIFJNIFactory$Companion
{
  public final Bitmap decodeThumb(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(177050);
    s.u(paramEmojiInfo, "emojiInfo");
    paramEmojiInfo = getDecoder(paramEmojiInfo);
    if (isValid(paramEmojiInfo))
    {
      paramEmojiInfo.aUe();
      Bitmap localBitmap = paramEmojiInfo.getFrame();
      paramEmojiInfo.destroy();
      AppMethodBeat.o(177050);
      return localBitmap;
    }
    AppMethodBeat.o(177050);
    return null;
  }
  
  public final Bitmap decodeThumb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(242236);
    paramArrayOfByte = getDecoder(paramArrayOfByte);
    if (isValid(paramArrayOfByte))
    {
      paramArrayOfByte.aUe();
      Bitmap localBitmap = paramArrayOfByte.getFrame();
      paramArrayOfByte.destroy();
      AppMethodBeat.o(242236);
      return localBitmap;
    }
    AppMethodBeat.o(242236);
    return null;
  }
  
  public final d getDecoder(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105374);
    s.u(paramEmojiInfo, "emojiInfo");
    for (;;)
    {
      try
      {
        if ((paramEmojiInfo.field_catalog != EmojiGroupInfo.aklE) && (paramEmojiInfo.field_catalog != EmojiInfo.aklL) && (paramEmojiInfo.field_catalog != EmojiInfo.aklK)) {
          continue;
        }
        localObject = (d)new e(paramEmojiInfo.F(MMApplicationContext.getContext(), 300));
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      catch (MMGIFException localMMGIFException)
      {
        Object localObject;
        Log.w(MMGIFJNIFactory.access$getTAG$cp(), s.X("decode error: ", Integer.valueOf(localMMGIFException.getErrorCode())));
        if (localMMGIFException.getErrorCode() != 103) {
          continue;
        }
        paramEmojiInfo = ((PluginEmoji)h.az(PluginEmoji.class)).getProvider().a(paramEmojiInfo);
        if (paramEmojiInfo == null) {
          continue;
        }
        paramEmojiInfo = (d)new e(paramEmojiInfo);
        continue;
        AppMethodBeat.o(105374);
        return paramEmojiInfo;
        paramEmojiInfo = null;
        continue;
      }
      if (paramEmojiInfo != null) {
        continue;
      }
      paramEmojiInfo = (d)new b();
      AppMethodBeat.o(105374);
      return paramEmojiInfo;
      if (paramEmojiInfo.kMe())
      {
        localObject = EmojiInfo.cS(MMApplicationContext.getContext(), paramEmojiInfo.getName());
        s.s(localObject, "getEmojiFile(MMApplicati…ontext(), emojiInfo.name)");
        localObject = (d)new f((InputStream)localObject);
        paramEmojiInfo = (EmojiInfo)localObject;
      }
      else
      {
        localObject = ((PluginEmoji)h.az(PluginEmoji.class)).getProvider().a(paramEmojiInfo);
        if (localObject == null) {
          continue;
        }
        if (ImgUtil.isWXGF((byte[])localObject))
        {
          localObject = (d)new g((byte[])localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
        else
        {
          localObject = (d)new f((byte[])localObject);
          paramEmojiInfo = (EmojiInfo)localObject;
        }
      }
    }
  }
  
  public final d getDecoder(String paramString)
  {
    AppMethodBeat.i(242225);
    s.u(paramString, "md5");
    paramString = bl.jba().adju.bza(paramString);
    if (paramString == null)
    {
      paramString = (d)new b();
      AppMethodBeat.o(242225);
      return paramString;
    }
    paramString = getDecoder(paramString);
    AppMethodBeat.o(242225);
    return paramString;
  }
  
  public final d getDecoder(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(242230);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (!ImgUtil.isWXGF(paramArrayOfByte)) {
          continue;
        }
        locald = (d)new g(paramArrayOfByte);
        paramArrayOfByte = locald;
      }
      catch (MMGIFException localMMGIFException)
      {
        d locald;
        Log.printErrStackTrace(MMGIFJNIFactory.access$getTAG$cp(), (Throwable)localMMGIFException, "decode bytes error", new Object[0]);
        if ((localMMGIFException.getErrorCode() != 103) || (paramArrayOfByte == null)) {
          break label145;
        }
        paramArrayOfByte = (d)new e(paramArrayOfByte);
        continue;
        AppMethodBeat.o(242230);
        return paramArrayOfByte;
      }
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = (d)new b();
        AppMethodBeat.o(242230);
        return paramArrayOfByte;
        if (ImgUtil.isGif(paramArrayOfByte))
        {
          locald = (d)new f(paramArrayOfByte);
          paramArrayOfByte = locald;
        }
        else
        {
          locald = (d)new e(paramArrayOfByte);
          paramArrayOfByte = locald;
        }
      }
      else
      {
        label145:
        paramArrayOfByte = null;
      }
    }
  }
  
  public final boolean isValid(d paramd)
  {
    return (paramd != null) && (!(paramd instanceof b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion
 * JD-Core Version:    0.7.0.1
 */