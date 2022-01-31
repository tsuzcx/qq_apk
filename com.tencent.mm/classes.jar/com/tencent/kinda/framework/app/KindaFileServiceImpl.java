package com.tencent.kinda.framework.app;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.kinda.gen.KFileService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class KindaFileServiceImpl
  implements KFileService
{
  public byte[] getData(String paramString)
  {
    AppMethodBeat.i(144350);
    byte[] arrayOfByte = new byte[0];
    Object localObject1 = arrayOfByte;
    Object localObject2;
    try
    {
      paramString = new BufferedReader(new InputStreamReader(ah.getContext().getAssets().open("kinda-strings/".concat(String.valueOf(paramString))), StandardCharsets.UTF_8));
      localObject1 = arrayOfByte;
      localObject2 = new StringBuilder();
      for (;;)
      {
        localObject1 = arrayOfByte;
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localObject1 = arrayOfByte;
        ((StringBuilder)localObject2).append(str);
      }
      AppMethodBeat.o(144350);
    }
    catch (IOException paramString)
    {
      ab.e("kinda KindaFileServiceImpl", "kinda打开json资源文件时出错，错误信息是：" + paramString.getMessage());
      paramString = (String)localObject1;
    }
    for (;;)
    {
      return paramString;
      localObject1 = arrayOfByte;
      paramString.close();
      localObject1 = arrayOfByte;
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = arrayOfByte;
      paramString = ((String)localObject2).getBytes();
      localObject1 = paramString;
      ab.d("kinda KindaFileServiceImpl", "读取kinda的字符串资源文件结果是：".concat(String.valueOf(localObject2)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaFileServiceImpl
 * JD-Core Version:    0.7.0.1
 */