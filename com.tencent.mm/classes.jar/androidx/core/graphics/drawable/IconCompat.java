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
  public static final PorterDuff.Mode bqY = PorterDuff.Mode.SRC_IN;
  public Object bqU;
  public Parcelable bqV = null;
  public int bqW = 0;
  public int bqX = 0;
  public String bqZ = null;
  public String bra;
  public PorterDuff.Mode kA = bqY;
  public ColorStateList kz = null;
  public byte[] mData = null;
  public int mType = -1;
  
  public IconCompat() {}
  
  private IconCompat(byte paramByte)
  {
    this.mType = 2;
  }
  
  public static int a(Icon paramIcon)
  {
    AppMethodBeat.i(196213);
    int i;
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramIcon.getType();
      AppMethodBeat.o(196213);
      return i;
    }
    try
    {
      i = ((Integer)paramIcon.getClass().getMethod("getType", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      AppMethodBeat.o(196213);
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(196213);
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(196213);
      return -1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      new StringBuilder("Unable to get icon type ").append(paramIcon);
      AppMethodBeat.o(196213);
    }
    return -1;
  }
  
  public static String b(Icon paramIcon)
  {
    AppMethodBeat.i(196230);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramIcon = paramIcon.getResPackage();
      AppMethodBeat.o(196230);
      return paramIcon;
    }
    try
    {
      paramIcon = (String)paramIcon.getClass().getMethod("getResPackage", new Class[0]).invoke(paramIcon, new Object[0]);
      AppMethodBeat.o(196230);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(196230);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(196230);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(196230);
    }
    return null;
  }
  
  private static int c(Icon paramIcon)
  {
    AppMethodBeat.i(196241);
    int i;
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramIcon.getResId();
      AppMethodBeat.o(196241);
      return i;
    }
    try
    {
      i = ((Integer)paramIcon.getClass().getMethod("getResId", new Class[0]).invoke(paramIcon, new Object[0])).intValue();
      AppMethodBeat.o(196241);
      return i;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(196241);
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(196241);
      return 0;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(196241);
    }
    return 0;
  }
  
  private static Uri d(Icon paramIcon)
  {
    AppMethodBeat.i(196259);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramIcon = paramIcon.getUri();
      AppMethodBeat.o(196259);
      return paramIcon;
    }
    try
    {
      paramIcon = (Uri)paramIcon.getClass().getMethod("getUri", new Class[0]).invoke(paramIcon, new Object[0]);
      AppMethodBeat.o(196259);
      return paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      AppMethodBeat.o(196259);
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      AppMethodBeat.o(196259);
      return null;
    }
    catch (NoSuchMethodException paramIcon)
    {
      AppMethodBeat.o(196259);
    }
    return null;
  }
  
  public static IconCompat j(String paramString, int paramInt)
  {
    AppMethodBeat.i(196165);
    if (paramInt == 0)
    {
      paramString = new IllegalArgumentException("Drawable resource ID must not be 0");
      AppMethodBeat.o(196165);
      throw paramString;
    }
    IconCompat localIconCompat = new IconCompat((byte)0);
    localIconCompat.bqW = paramInt;
    localIconCompat.bqU = paramString;
    localIconCompat.bra = paramString;
    AppMethodBeat.o(196165);
    return localIconCompat;
  }
  
  public static Bitmap k(Bitmap paramBitmap)
  {
    AppMethodBeat.i(196273);
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
    AppMethodBeat.o(196273);
    return localBitmap;
  }
  
  public final int getResId()
  {
    AppMethodBeat.i(196294);
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      i = c((Icon)this.bqU);
      AppMethodBeat.o(196294);
      return i;
    }
    if (this.mType != 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
      AppMethodBeat.o(196294);
      throw localIllegalStateException;
    }
    int i = this.bqW;
    AppMethodBeat.o(196294);
    return i;
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(196306);
    if ((this.mType == -1) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = d((Icon)this.bqU);
      AppMethodBeat.o(196306);
      return localObject;
    }
    if ((this.mType != 4) && (this.mType != 6))
    {
      localObject = new IllegalStateException("called getUri() on ".concat(String.valueOf(this)));
      AppMethodBeat.o(196306);
      throw ((Throwable)localObject);
    }
    Object localObject = Uri.parse((String)this.bqU);
    AppMethodBeat.o(196306);
    return localObject;
  }
  
  public String toString()
  {
    AppMethodBeat.i(196334);
    Object localObject;
    if (this.mType == -1)
    {
      localObject = String.valueOf(this.bqU);
      AppMethodBeat.o(196334);
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
      if (this.kz != null)
      {
        ((StringBuilder)localObject).append(" tint=");
        ((StringBuilder)localObject).append(this.kz);
      }
      if (this.kA != bqY) {
        ((StringBuilder)localObject).append(" mode=").append(this.kA);
      }
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(196334);
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
      ((StringBuilder)localObject).append(" size=").append(((Bitmap)this.bqU).getWidth()).append("x").append(((Bitmap)this.bqU).getHeight());
      continue;
      ((StringBuilder)localObject).append(" pkg=").append(this.bra).append(" id=").append(String.format("0x%08x", new Object[] { Integer.valueOf(getResId()) }));
      continue;
      ((StringBuilder)localObject).append(" len=").append(this.bqW);
      if (this.bqX != 0)
      {
        ((StringBuilder)localObject).append(" off=").append(this.bqX);
        continue;
        ((StringBuilder)localObject).append(" uri=").append(this.bqU);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompat
 * JD-Core Version:    0.7.0.1
 */