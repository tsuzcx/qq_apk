package com.tencent.filter.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class aj
{
  private static String bxC = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}\n";
  private static String bxD = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
  
  public static String b(int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(86488);
    if (paramInt <= 0)
    {
      str = bxD;
      AppMethodBeat.o(86488);
      return str;
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    int j = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject = new float[j];
    i = 0;
    while (i < j)
    {
      paramFloat = arrayOfFloat[(i * 2 + 1)];
      f1 = arrayOfFloat[(i * 2 + 2)];
      localObject[i] = ((paramFloat * (i * 2 + 1) + f1 * (i * 2 + 2)) / (paramFloat + f1));
      i += 1;
    }
    i = paramInt / 2 + paramInt % 2;
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
    if (paramBoolean) {}
    for (str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";; str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n")
    {
      paramInt = 0;
      while (paramInt < j)
      {
        paramFloat = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
        paramInt += 1;
      }
    }
    localObject = str;
    if (i > j)
    {
      paramInt = j;
      for (;;)
      {
        localObject = str;
        if (paramInt >= i) {
          break;
        }
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat;
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        paramInt += 1;
      }
    }
    str = (String)localObject + "gl_FragColor = sum;\n";
    str = str + "}\n";
    AppMethodBeat.o(86488);
    return str;
  }
  
  public static String b(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(86489);
    if (paramInt <= 0)
    {
      str = bxD;
      AppMethodBeat.o(86489);
      return str;
    }
    float[] arrayOfFloat = new float[paramInt + 1];
    float f1 = 0.0F;
    int i = 0;
    if (i < paramInt + 1)
    {
      arrayOfFloat[i] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(i, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (i == 0) {}
      for (f1 = arrayOfFloat[i] + f1;; f1 = (float)(f1 + 2.0D * arrayOfFloat[i]))
      {
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < paramInt + 1)
    {
      arrayOfFloat[i] /= f1;
      i += 1;
    }
    int j = Math.min(paramInt / 2 + paramInt % 2, 7);
    Object localObject = new float[j];
    i = 0;
    while (i < j)
    {
      paramFloat = arrayOfFloat[(i * 2 + 1)];
      f1 = arrayOfFloat[(i * 2 + 2)];
      localObject[i] = ((paramFloat * (i * 2 + 1) + f1 * (i * 2 + 2)) / (paramFloat + f1));
      i += 1;
    }
    i = paramInt / 2 + paramInt % 2;
    String str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n vec4 color = texture2D(inputImageTexture,textureCoordinate);\nlowp float sum = 0.0;\n", new Object[] { Integer.valueOf(j * 2 + 1) });
    if (paramBoolean1)
    {
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).g * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
      if (!paramBoolean2) {
        break label547;
      }
      str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
      label367:
      paramInt = 0;
      label369:
      if (paramInt >= j) {
        break label673;
      }
      paramFloat = arrayOfFloat[(paramInt * 2 + 1)] + arrayOfFloat[(paramInt * 2 + 2)];
      if (!paramBoolean1) {
        break label572;
      }
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
    }
    for (str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });; str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) }))
    {
      paramInt += 1;
      break label369;
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).a * %f;\n", new Object[] { Float.valueOf(arrayOfFloat[0]) });
      break;
      label547:
      str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
      break label367;
      label572:
      str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(localObject[paramInt]), Float.valueOf(paramFloat) });
    }
    label673:
    localObject = str;
    if (i > j)
    {
      paramInt = j;
      localObject = str;
      if (paramInt < i)
      {
        f1 = arrayOfFloat[(paramInt * 2 + 1)];
        float f2 = arrayOfFloat[(paramInt * 2 + 2)];
        paramFloat = f1 + f2;
        f1 = (f1 * (paramInt * 2 + 1) + f2 * (paramInt * 2 + 2)) / paramFloat;
        if (paramBoolean1) {
          str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        }
        for (str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });; str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) }))
        {
          paramInt += 1;
          break;
          str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat) });
        }
      }
    }
    str = (String)localObject + "color.a = sum;\n";
    str = str + "gl_FragColor = color;\n";
    str = str + "}\n";
    AppMethodBeat.o(86489);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.a.aj
 * JD-Core Version:    0.7.0.1
 */