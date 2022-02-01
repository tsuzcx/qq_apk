package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    AppMethodBeat.i(62496);
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.aT(localIconCompat.mType, 1);
    localIconCompat.mData = parama.j(localIconCompat.mData);
    localIconCompat.Ke = parama.a(localIconCompat.Ke, 3);
    localIconCompat.Kf = parama.aT(localIconCompat.Kf, 4);
    localIconCompat.Kg = parama.aT(localIconCompat.Kg, 5);
    localIconCompat.Kh = ((ColorStateList)parama.a(localIconCompat.Kh, 6));
    localIconCompat.Ki = parama.M(localIconCompat.Ki);
    localIconCompat.yf = PorterDuff.Mode.valueOf(localIconCompat.Ki);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62496);
      return localIconCompat;
      if (localIconCompat.Ke != null)
      {
        localIconCompat.Kd = localIconCompat.Ke;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(62496);
        throw parama;
        if (localIconCompat.Ke != null)
        {
          localIconCompat.Kd = localIconCompat.Ke;
        }
        else
        {
          localIconCompat.Kd = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.Kf = 0;
          localIconCompat.Kg = localIconCompat.mData.length;
          continue;
          localIconCompat.Kd = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.Kd = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(62497);
    paramIconCompat.Ki = paramIconCompat.yf.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      parama.aS(paramIconCompat.mType, 1);
      parama.i(paramIconCompat.mData);
      parama.writeParcelable(paramIconCompat.Ke, 3);
      parama.aS(paramIconCompat.Kf, 4);
      parama.aS(paramIconCompat.Kg, 5);
      parama.writeParcelable(paramIconCompat.Kh, 6);
      parama.L(paramIconCompat.Ki);
      AppMethodBeat.o(62497);
      return;
      paramIconCompat.Ke = ((Parcelable)paramIconCompat.Kd);
      continue;
      paramIconCompat.Ke = ((Parcelable)paramIconCompat.Kd);
      continue;
      paramIconCompat.mData = paramIconCompat.Kd.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.Kd).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.Kd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */