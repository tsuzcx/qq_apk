package com.tencent.mm.plugin.flutter.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import k.a.a.a.a.a.a.a.a.a.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
  extends a
{
  private long HlP;
  private final String mediaId;
  private final String path;
  
  public d$b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263086);
    this.mediaId = paramString2;
    this.path = localObject;
    AppMethodBeat.o(263086);
  }
  
  private static final void g(d paramd)
  {
    AppMethodBeat.i(263094);
    s.u(paramd, "this$0");
    paramd = d.f(paramd);
    if (paramd != null) {
      paramd.onPlayerStateChanged(false, 2);
    }
    AppMethodBeat.o(263094);
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    return "video/mp4";
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(263162);
    paramString = e.HlR.fvk().HlT.aDD(this.mediaId);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.path)
    {
      s.checkNotNull(paramString);
      Log.d(this.HlQ.TAG, "[getDataFilePath] player: " + d.b(this.HlQ) + " mediaId=" + this.mediaId + " fileId: " + paramInt + ", path: " + paramString);
      AppMethodBeat.o(263162);
      return paramString;
    }
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    AppMethodBeat.i(263158);
    paramString = e.HlR.fvk().HlT.aDD(this.mediaId);
    if (paramString == null) {}
    for (paramString = null;; paramString = Long.valueOf(paramString.uWn))
    {
      s.checkNotNull(paramString);
      long l = paramString.longValue();
      AppMethodBeat.o(263158);
      return l;
    }
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263140);
    Log.d(this.HlQ.TAG, "[onReadData] player: " + d.b(this.HlQ) + " mediaId=" + this.mediaId + " fileId: " + paramInt + " state:" + this.HlQ.GuE);
    if (paramLong2 <= 0L)
    {
      Log.d(this.HlQ.TAG, "FVPlayer onReadDate 0");
      AppMethodBeat.o(263140);
      return 0;
    }
    b.a locala = e.HlR.fvk().HlT.aDD(this.mediaId);
    if ((locala != null) && (this.HlP != locala.wbD))
    {
      this.HlP = locala.wbD;
      com.tencent.threadpool.h.ahAA.bk(new d.b..ExternalSyntheticLambda0(this.HlQ));
    }
    if ((locala != null) && (locala.cUO))
    {
      Log.d(this.HlQ.TAG, "onreaddata completed");
      paramInt = (int)paramLong2;
      AppMethodBeat.o(263140);
      return paramInt;
    }
    boolean bool1;
    if (this.HlQ.GuE != 6)
    {
      bool1 = CdnLogic.taskExist(this.mediaId);
      if (bool1)
      {
        boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong1, paramLong2);
        if (bool2)
        {
          Log.d(this.HlQ.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong1 + " length:" + paramLong2 + " mediaId" + this.mediaId);
          paramInt = (int)paramLong2;
          AppMethodBeat.o(263140);
          return paramInt;
        }
      }
    }
    for (;;)
    {
      if ((this.HlQ.GuE != 3) && (this.HlQ.GuE != 5))
      {
        Log.v(this.HlQ.TAG, "not in need data state, ignore, state:" + this.HlQ.GuE + ", media:" + this.mediaId);
        AppMethodBeat.o(263140);
        return 0;
      }
      String str;
      StringBuilder localStringBuilder;
      if (this.HlQ.GuE == 3)
      {
        if (locala == null) {}
        for (paramString = null;; paramString = Long.valueOf(locala.Hly))
        {
          s.checkNotNull(paramString);
          if (paramString.longValue() < paramLong1 + paramLong2) {
            break;
          }
          Log.v(this.HlQ.TAG, s.X("onreaddata preload enough: ", this.mediaId));
          paramInt = (int)paramLong2;
          AppMethodBeat.o(263140);
          return paramInt;
        }
        if (bool1)
        {
          if (locala == null) {
            paramString = null;
          }
          for (;;)
          {
            if (paramString.booleanValue()) {
              if ((d.c(this.HlQ) == paramLong1) && (d.d(this.HlQ) == paramLong2))
              {
                Log.d(this.HlQ.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
                AppMethodBeat.o(263140);
                return 0;
                paramString = Boolean.valueOf(locala.HlA);
              }
              else
              {
                paramInt = e.HlR.fvk().HlU.D(this.mediaId, paramLong1, paramLong2);
                if (paramInt != 0)
                {
                  str = this.HlQ.TAG;
                  localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(paramInt).append(" state:").append(this.HlQ.GuE).append(" exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
                  if (locala == null)
                  {
                    paramString = null;
                    Log.e(str, paramString);
                    e.HlR.fvk().HlT.a(d.e(this.HlQ), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
                    d.a(this.HlQ, 0L);
                  }
                }
              }
            }
          }
        }
        label859:
        for (;;)
        {
          Log.d(this.HlQ.TAG, s.X("onreaddata need more: ", this.mediaId));
          AppMethodBeat.o(263140);
          return 0;
          paramString = Long.valueOf(locala.wbD);
          break;
          d.b(this.HlQ, paramLong1);
          d.a(this.HlQ, paramLong2);
          continue;
          if (locala == null) {}
          for (paramString = null;; paramString = Boolean.valueOf(locala.Hlz))
          {
            if (paramString.booleanValue()) {
              break label859;
            }
            e.HlR.fvk().HlT.a(d.e(this.HlQ), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
            break;
          }
        }
      }
      if (this.HlQ.GuE == 5)
      {
        if ((d.c(this.HlQ) == paramLong1) && (d.d(this.HlQ) == paramLong2))
        {
          Log.d(this.HlQ.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
          AppMethodBeat.o(263140);
          return 0;
        }
        paramInt = e.HlR.fvk().HlU.D(this.mediaId, paramLong1, paramLong2);
        if (paramInt != 0)
        {
          str = this.HlQ.TAG;
          localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(paramInt).append(" state:").append(this.HlQ.GuE).append(' ').append(this.mediaId).append(", ret:").append(paramInt).append(", exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
          if (locala == null)
          {
            paramString = null;
            Log.d(str, paramString);
            e.HlR.fvk().HlT.a(d.e(this.HlQ), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
            d.a(this.HlQ, 0L);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(263140);
          return 0;
          paramString = Long.valueOf(locala.wbD);
          break;
          d.b(this.HlQ, paramLong1);
          d.a(this.HlQ, paramLong2);
        }
      }
      AppMethodBeat.o(263140);
      return 0;
      bool1 = false;
    }
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263112);
    Log.d(this.HlQ.TAG, "[onStartReadData] player: " + d.b(this.HlQ) + " mediaId=" + this.mediaId + " fileId: " + paramInt);
    paramInt = this.mediaId.hashCode();
    AppMethodBeat.o(263112);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(263151);
    Log.d(this.HlQ.TAG, "[onStopReadData] player: " + d.b(this.HlQ) + " mediaId=" + this.mediaId + " taskId: " + paramInt1);
    AppMethodBeat.o(263151);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.d.b
 * JD-Core Version:    0.7.0.1
 */