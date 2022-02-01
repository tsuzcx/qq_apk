package com.tencent.luggage.sdk.b.a.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  private static void a(ArrayList<String> paramArrayList, File paramFile, ArrayList<File> paramArrayList1)
  {
    AppMethodBeat.i(234590);
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      Log.e("Luggage.WxAudioLoadSoHandler", "checkSoLibMatch apiFolder has none subfile, path:%s", new Object[] { paramFile.getAbsolutePath() });
      AppMethodBeat.o(234590);
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      Log.i("Luggage.WxAudioLoadSoHandler", "checkSoLibMatch file path:%s", new Object[] { arrayOfFile[i].getAbsolutePath() });
      if ((arrayOfFile[i].getName().contains("libwxWtf.so")) && (a(paramArrayList, arrayOfFile[i]))) {
        paramArrayList1.add(0, arrayOfFile[i]);
      }
      if ((arrayOfFile[i].getName().contains("libmmwebaudio.so")) && (a(paramArrayList, arrayOfFile[i]))) {
        paramArrayList1.add(arrayOfFile[i]);
      }
      i += 1;
    }
    AppMethodBeat.o(234590);
  }
  
  private static boolean a(ArrayList<String> paramArrayList, File paramFile)
  {
    AppMethodBeat.i(234592);
    paramFile = u.buc(paramFile.getPath());
    if (TextUtils.isEmpty(paramFile))
    {
      AppMethodBeat.o(234592);
      return false;
    }
    boolean bool = paramArrayList.contains(paramFile);
    AppMethodBeat.o(234592);
    return bool;
  }
  
  public static boolean aG(Context paramContext)
  {
    AppMethodBeat.i(234588);
    Log.e("Luggage.WxAudioLoadSoHandler", "loadSoLibrary");
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/WxAudioLib");
    if (!paramContext.exists())
    {
      Log.e("Luggage.WxAudioLoadSoHandler", "WxAudioLib folder not exist");
      AppMethodBeat.o(234588);
      return false;
    }
    if (!paramContext.isDirectory())
    {
      Log.e("Luggage.WxAudioLoadSoHandler", "WxAudioLib folder is not directory");
      AppMethodBeat.o(234588);
      return false;
    }
    paramContext = paramContext.listFiles();
    if ((paramContext == null) || (paramContext.length == 0))
    {
      Log.e("Luggage.WxAudioLoadSoHandler", "WxAudioLib not include any sub files");
      AppMethodBeat.o(234588);
      return false;
    }
    ArrayList localArrayList1 = new ArrayList(2);
    Log.i("Luggage.WxAudioLoadSoHandler", "file length:%d", new Object[] { Integer.valueOf(paramContext.length) });
    int i = 0;
    if (i < paramContext.length)
    {
      Log.i("Luggage.WxAudioLoadSoHandler", "file path:%s", new Object[] { paramContext[i].getAbsolutePath() });
      Object localObject;
      if (paramContext[i].isDirectory())
      {
        localObject = new File(paramContext[i].getAbsolutePath() + "/libs");
        if (((File)localObject).exists()) {
          break label235;
        }
        Log.i("Luggage.WxAudioLoadSoHandler", "libs not exist");
      }
      for (;;)
      {
        i += 1;
        break;
        label235:
        if (!((File)localObject).isDirectory())
        {
          Log.i("Luggage.WxAudioLoadSoHandler", "libs is not directory");
        }
        else
        {
          localObject = ((File)localObject).listFiles();
          if ((localObject != null) && (localObject.length != 0))
          {
            ArrayList localArrayList2 = new ArrayList(2);
            int j = 0;
            while (j < localObject.length)
            {
              localArrayList2.clear();
              localArrayList1.clear();
              Log.i("Luggage.WxAudioLoadSoHandler", "file path:%s", new Object[] { localObject[j].getAbsolutePath() });
              if ((BuildInfo.IS_ARM64) && (localObject[j].getName().contains("arm64-v8a")))
              {
                localArrayList2.add("ff10044eab4d2917d52140b225c746ee");
                localArrayList2.add("0de7531be050ef7af54df0f5a2b72c22");
                a(localArrayList2, localObject[j], localArrayList1);
              }
              while (localArrayList1.size() > 1)
              {
                Log.i("Luggage.WxAudioLoadSoHandler", "libwxWtf.so path:%s", new Object[] { ((File)localArrayList1.get(0)).getAbsolutePath() });
                Log.i("Luggage.WxAudioLoadSoHandler", "libmmwebaudio.so path:%s", new Object[] { ((File)localArrayList1.get(1)).getAbsolutePath() });
                System.load(((File)localArrayList1.get(0)).getAbsolutePath());
                System.load(((File)localArrayList1.get(1)).getAbsolutePath());
                Log.i("Luggage.WxAudioLoadSoHandler", "load webaudio so success!!");
                AppMethodBeat.o(234588);
                return true;
                if ((!BuildInfo.IS_ARM64) && (localObject[j].getName().contains("armeabi-v7a")))
                {
                  localArrayList2.add("28b8bcc8963de3fa466c96c750efb5ae");
                  localArrayList2.add("44300e52059fd6b732fb27f01a8d9721");
                  a(localArrayList2, localObject[j], localArrayList1);
                }
              }
              j += 1;
            }
          }
        }
      }
    }
    Log.e("Luggage.WxAudioLoadSoHandler", "load so fail!!");
    AppMethodBeat.o(234588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.a
 * JD-Core Version:    0.7.0.1
 */