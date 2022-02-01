package com.tencent.av.opengl.program;

import android.opengl.GLES20;
import com.tencent.av.opengl.utils.Utils;
import java.util.HashMap;
import java.util.Map;

public class TextureProgramFactory
{
  public static final int PROGRAM_DEFAULT = 0;
  public static final int PROGRAM_OES_TEXTURE = 4;
  public static final int PROGRAM_RGB_TO_YUV = 5;
  public static final int PROGRAM_SHARPEN = 3;
  public static final int PROGRAM_YUV_TEXTURE = 1;
  public static final int PROGRAM_YUV_TEXTURE_FBO = 2;
  private static Map<String, TextureProgram> mProgramMaps = new HashMap();
  
  public static void clear()
  {
    try
    {
      mProgramMaps.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TextureProgram make(int paramInt)
  {
    for (;;)
    {
      int j;
      try
      {
        String str = paramInt + "_" + Thread.currentThread().getId();
        localObject1 = (TextureProgram)mProgramMaps.get(str);
        int i;
        if (localObject1 == null)
        {
          i = 1;
          j = i;
          if (i != 0) {
            break label162;
          }
          GLES20.glUseProgram(((TextureProgram)localObject1).getId());
          if (Utils.checkError() != 0)
          {
            j = 1;
            break label162;
            localObject1 = new TextureProgram();
            mProgramMaps.put(str, localObject1);
            return localObject1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        j = 0;
      }
      finally {}
      Object localObject1 = new YUVTextureProgram();
      continue;
      localObject1 = new YUVTextureAliasingProgram();
      continue;
      localObject1 = new SharpenProgram();
      continue;
      localObject1 = new RGBToYUVProgram();
      continue;
      label162:
      if (j != 0) {
        switch (paramInt)
        {
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.opengl.program.TextureProgramFactory
 * JD-Core Version:    0.7.0.1
 */