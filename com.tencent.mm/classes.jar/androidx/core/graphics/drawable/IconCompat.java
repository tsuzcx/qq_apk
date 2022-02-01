package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IconCompat
  extends CustomVersionedParcelable
{
  public static final PorterDuff.Mode KQ = PorterDuff.Mode.SRC_IN;
  public Object KM;
  public Parcelable KN = null;
  public int KO = 0;
  public int KP = 0;
  public String KR = null;
  public ColorStateList jE = null;
  public PorterDuff.Mode jF = KQ;
  public byte[] mData = null;
  public int mType = -1;
  
  public IconCompat() {}
  
  private IconCompat(byte paramByte)
  {
    this.mType = 2;
  }
  
  public static int a(Icon paramIcon)
  {
    AppMethodBeat.i(250842);
    int i;
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramIcon.getType();
      AppMethodBeat.o(250842);
      return i;
    }
    try
    {
      i = ((Integer)paramIcon.getClass().getMethod("getType", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      AppMethodBeat.o(250842);
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(250842);
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(250842);
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(250842);
    }
    return -1;
  }
  
  private static String b(Icon paramIcon)
  {
    AppMethodBeat.i(250844);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramIcon = paramIcon.getResPackage();
      AppMethodBeat.o(250844);
      return paramIcon;
    }
    try
    {
      paramIcon = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      AppMethodBeat.o(250844);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(250844);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(250844);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(250844);
    }
    return null;
  }
  
  private static int c(Icon paramIcon)
  {
    AppMethodBeat.i(250845);
    int i;
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramIcon.getResId();
      AppMethodBeat.o(250845);
      return i;
    }
    try
    {
      i = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      AppMethodBeat.o(250845);
      return i;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(250845);
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(250845);
      return 0;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(250845);
    }
    return 0;
  }
  
  public static Bitmap d(Bitmap paramBitmap)
  {
    AppMethodBeat.i(250849);
    int i = (int)(0.6666667F * Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()));
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f = i * 0.5F;
    localPaint.setColor(-16777216);
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new BitmapShader(paramBitmap, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - i) / 2, -(paramBitmap.getHeight() - i) / 2);
    ((BitmapShader)localObject).setLocalMatrix(localMatrix);
    localPaint.setShader((Shader)localObject);
    localCanvas.drawCircle(f, f, 0.9166667F * f, localPaint);
    localCanvas.setBitmap(null);
    AppMethodBeat.o(250849);
    return localBitmap;
  }
  
  public static Uri d(Icon paramIcon)
  {
    AppMethodBeat.i(250847);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramIcon = paramIcon.getUri();
      AppMethodBeat.o(250847);
      return paramIcon;
    }
    try
    {
      paramIcon = (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
      AppMethodBeat.o(250847);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(250847);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(250847);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(250847);
    }
    return null;
  }
  
  public static IconCompat h(String paramString, int paramInt)
  {
    AppMethodBeat.i(250832);
    if (paramInt == 0)
    {
      paramString = new IllegalArgumentException("Drawable resource ID must not be 0");
      AppMethodBeat.o(250832);
      throw paramString;
    }
    IconCompat localIconCompat = new IconCompat((byte)0);
    localIconCompat.KO = paramInt;
    localIconCompat.KM = paramString;
    AppMethodBeat.o(250832);
    return localIconCompat;
  }
  
  public final int getResId()
  {
    AppMethodBeat.i(250840);
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      i = c((Icon)this.KM);
      AppMethodBeat.o(250840);
      return i;
    }
    if (this.mType != 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
      AppMethodBeat.o(250840);
      throw localIllegalStateException;
    }
    int i = this.KO;
    AppMethodBeat.o(250840);
    return i;
  }
  
  public final String gz()
  {
    AppMethodBeat.i(250838);
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = b((Icon)this.KM);
      AppMethodBeat.o(250838);
      return localObject;
    }
    if (this.mType != 2)
    {
      localObject = new IllegalStateException("called getResPackage() on ".concat(String.valueOf(this)));
      AppMethodBeat.o(250838);
      throw ((Throwable)localObject);
    }
    Object localObject = ((String)this.KM).split(":", -1)[0];
    AppMethodBeat.o(250838);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(250841);
    Object localObject;
    if (this.mType == -1)
    {
      localObject = String.valueOf(this.KM);
      AppMethodBeat.o(250841);
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=");
    switch (this.mType)
    {
    default: 
      localObject = "UNKNOWN";
      localObject = localStringBuilder.append((String)localObject);
      switch (this.mType)
      {
      }
      break;
    }
    for (;;)
    {
      if (this.jE != null)
      {
        ((StringBuilder)localObject).append(" tint=");
        ((StringBuilder)localObject).append(this.jE);
      }
      if (this.jF != KQ) {
        ((StringBuilder)localObject).append(" mode=").append(this.jF);
      }
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(250841);
      return localObject;
      localObject = "BITMAP";
      break;
      localObject = "BITMAP_MASKABLE";
      break;
      localObject = "DATA";
      break;
      localObject = "RESOURCE";
      break;
      localObject = "URI";
      break;
      localObject = "URI_MASKABLE";
      break;
      ((StringBuilder)localObject).append(" size=").append(((Bitmap)this.KM).getWidth()).append("x").append(((Bitmap)this.KM).getHeight());
      continue;
      ((StringBuilder)localObject).append(" pkg=").append(gz()).append(" id=").append(String.format("0x%08x", new Object[] { Integer.valueOf(getResId()) }));
      continue;
      ((StringBuilder)localObject).append(" len=").append(this.KO);
      if (this.KP != 0)
      {
        ((StringBuilder)localObject).append(" off=").append(this.KP);
        continue;
        ((StringBuilder)localObject).append(" uri=").append(this.KM);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompat
 * JD-Core Version:    0.7.0.1
 */