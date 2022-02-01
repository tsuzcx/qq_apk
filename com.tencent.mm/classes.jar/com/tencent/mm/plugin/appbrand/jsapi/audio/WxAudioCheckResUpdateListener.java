package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.y;
import java.io.File;

public class WxAudioCheckResUpdateListener
  extends IListener<cd>
{
  public WxAudioCheckResUpdateListener()
  {
    super(f.hfK);
    AppMethodBeat.i(327764);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(327764);
  }
  
  private static boolean a(cd paramcd)
  {
    AppMethodBeat.i(327766);
    if (paramcd.hCg.hCh == 88)
    {
      Log.i("MicroMsg.WxAudioCheckResUpdateListener", "webaudio update coming. subtype: %d, file path: %s, file version: %d", new Object[] { Integer.valueOf(paramcd.hCg.subType), paramcd.hCg.filePath, Integer.valueOf(paramcd.hCg.hCi) });
      if (paramcd.hCg.subType != 1) {
        break label511;
      }
      if (new File(paramcd.hCg.filePath).exists())
      {
        String str = y.bub(paramcd.hCg.filePath);
        if (TextUtils.isEmpty(str))
        {
          Log.e("MicroMsg.WxAudioCheckResUpdateListener", "current_file_md5 is empty");
          AppMethodBeat.o(327766);
          return false;
        }
        if (!str.equals(paramcd.hCg.hCk))
        {
          Log.e("MicroMsg.WxAudioCheckResUpdateListener", "md5 is diff, current md5:%s, original md5:%s", new Object[] { str, paramcd.hCg.hCk });
          AppMethodBeat.o(327766);
          return false;
        }
        Log.i("MicroMsg.WxAudioCheckResUpdateListener", "md5 is same, current md5:%s, original md5:%s", new Object[] { str, paramcd.hCg.hCk });
        str = MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/WxAudioLib";
        Object localObject = new File(str);
        if (!((File)localObject).exists()) {}
        try
        {
          ((File)localObject).mkdir();
          localObject = str + "/" + paramcd.hCg.hCi;
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
            int i = y.aA(paramcd.hCg.filePath, (String)localObject);
            if (i < 0)
            {
              Log.e("MicroMsg.WxAudioCheckResUpdateListener", "unzip fail, ret = " + i + ", zipFilePath = " + paramcd.hCg.filePath + ", unzipPath = " + (String)localObject);
              AppMethodBeat.o(327766);
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
              Log.i("MicroMsg.WxAudioCheckResUpdateListener", "unzip file success, unzipFolder file :%s  to path:%s", new Object[] { paramcd.hCg.filePath, localException1 });
              b.iJf().bu(paramcd.hCg.hCh, paramcd.hCg.subType, paramcd.hCg.hCi);
              cC(str, paramcd.hCg.hCi);
            }
          }
        }
      }
      Log.e("MicroMsg.WxAudioCheckResUpdateListener", "file not exits :%s", new Object[] { paramcd.hCg.filePath });
    }
    for (;;)
    {
      AppMethodBeat.o(327766);
      return false;
      label511:
      Log.e("MicroMsg.WxAudioCheckResUpdateListener", "sub type can't be handled!, subtype:%d", new Object[] { Integer.valueOf(paramcd.hCg.subType) });
    }
  }
  
  private static void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(327767);
    Log.i("MicroMsg.WxAudioCheckResUpdateListener", "recycleOldVersionSo current fileVersion", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt - 2;
    paramInt = i;
    if (i < 0)
    {
      AppMethodBeat.o(327767);
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
    AppMethodBeat.o(327767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.WxAudioCheckResUpdateListener
 * JD-Core Version:    0.7.0.1
 */