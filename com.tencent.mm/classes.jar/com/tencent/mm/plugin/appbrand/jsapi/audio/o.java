package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.f.a.bu.a;
import com.tencent.mm.pluginsdk.k.a.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class o
  extends IListener<bu>
{
  public o()
  {
    AppMethodBeat.i(251269);
    this.__eventId = bu.class.getName().hashCode();
    AppMethodBeat.o(251269);
  }
  
  private static boolean a(bu parambu)
  {
    AppMethodBeat.i(251273);
    if (parambu.fxB.fxC == 88)
    {
      Log.i("MicroMsg.WxAudioCheckResUpdateListener", "webaudio update coming. subtype: %d, file path: %s, file version: %d", new Object[] { Integer.valueOf(parambu.fxB.subType), parambu.fxB.filePath, Integer.valueOf(parambu.fxB.fxD) });
      if (parambu.fxB.subType != 1) {
        break label511;
      }
      if (new File(parambu.fxB.filePath).exists())
      {
        String str = u.buc(parambu.fxB.filePath);
        if (TextUtils.isEmpty(str))
        {
          Log.e("MicroMsg.WxAudioCheckResUpdateListener", "current_file_md5 is empty");
          AppMethodBeat.o(251273);
          return false;
        }
        if (!str.equals(parambu.fxB.fxF))
        {
          Log.e("MicroMsg.WxAudioCheckResUpdateListener", "md5 is diff, current md5:%s, original md5:%s", new Object[] { str, parambu.fxB.fxF });
          AppMethodBeat.o(251273);
          return false;
        }
        Log.i("MicroMsg.WxAudioCheckResUpdateListener", "md5 is same, current md5:%s, original md5:%s", new Object[] { str, parambu.fxB.fxF });
        str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/WxAudioLib";
        Object localObject = new File(str);
        if (!((File)localObject).exists()) {}
        try
        {
          ((File)localObject).mkdir();
          localObject = str + "/" + parambu.fxB.fxD;
          localFile = new File((String)localObject);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        catch (Exception localException1)
        {
          try
          {
            File localFile;
            localFile.mkdirs();
            int i = u.gj(parambu.fxB.filePath, (String)localObject);
            if (i < 0)
            {
              Log.e("MicroMsg.WxAudioCheckResUpdateListener", "unzip fail, ret = " + i + ", zipFilePath = " + parambu.fxB.filePath + ", unzipPath = " + (String)localObject);
              AppMethodBeat.o(251273);
              return true;
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.WxAudioCheckResUpdateListener", localException1, "create file:%s", new Object[] { str });
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WxAudioCheckResUpdateListener", localException2, "create file:%s", new Object[] { localException1 });
              continue;
              Log.i("MicroMsg.WxAudioCheckResUpdateListener", "unzip file success, unzipFolder file :%s  to path:%s", new Object[] { parambu.fxB.filePath, localException1 });
              b.hii().aT(parambu.fxB.fxC, parambu.fxB.subType, parambu.fxB.fxD);
              cf(str, parambu.fxB.fxD);
            }
          }
        }
      }
      Log.e("MicroMsg.WxAudioCheckResUpdateListener", "file not exits :%s", new Object[] { parambu.fxB.filePath });
    }
    for (;;)
    {
      AppMethodBeat.o(251273);
      return false;
      label511:
      Log.e("MicroMsg.WxAudioCheckResUpdateListener", "sub type can't be handled!, subtype:%d", new Object[] { Integer.valueOf(parambu.fxB.subType) });
    }
  }
  
  private static void cf(String paramString, int paramInt)
  {
    AppMethodBeat.i(251276);
    Log.i("MicroMsg.WxAudioCheckResUpdateListener", "recycleOldVersionSo current fileVersion", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt - 2;
    paramInt = i;
    if (i < 0)
    {
      AppMethodBeat.o(251276);
      return;
    }
    while (paramInt >= 0)
    {
      String str = paramString + "/" + paramInt;
      File localFile = new File(str);
      if (localFile.exists())
      {
        localFile.delete();
        Log.i("MicroMsg.WxAudioCheckResUpdateListener", "delete versionFolder:%s", new Object[] { str });
      }
      paramInt -= 1;
    }
    AppMethodBeat.o(251276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.o
 * JD-Core Version:    0.7.0.1
 */