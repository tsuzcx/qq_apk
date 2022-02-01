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
    localIconCompat.mType = parama.aN(localIconCompat.mType, 1);
    localIconCompat.mData = parama.j(localIconCompat.mData);
    localIconCompat.Ko = parama.a(localIconCompat.Ko, 3);
    localIconCompat.Kp = parama.aN(localIconCompat.Kp, 4);
    localIconCompat.Kq = parama.aN(localIconCompat.Kq, 5);
    localIconCompat.Kr = ((ColorStateList)parama.a(localIconCompat.Kr, 6));
    localIconCompat.Ks = parama.N(localIconCompat.Ks);
    localIconCompat.yl = PorterDuff.Mode.valueOf(localIconCompat.Ks);
    switch (localIconCompat.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62496);
      return localIconCompat;
      if (localIconCompat.Ko != null)
      {
        localIconCompat.Kn = localIconCompat.Ko;
      }
      else
      {
        parama = new IllegalArgumentException("Invalid icon");
        AppMethodBeat.o(62496);
        throw parama;
        if (localIconCompat.Ko != null)
        {
          localIconCompat.Kn = localIconCompat.Ko;
        }
        else
        {
          localIconCompat.Kn = localIconCompat.mData;
          localIconCompat.mType = 3;
          localIconCompat.Kp = 0;
          localIconCompat.Kq = localIconCompat.mData.length;
          continue;
          localIconCompat.Kn = new String(localIconCompat.mData, Charset.forName("UTF-16"));
          continue;
          localIconCompat.Kn = localIconCompat.mData;
        }
      }
    }
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    AppMethodBeat.i(62497);
    paramIconCompat.Ks = paramIconCompat.yl.name();
    switch (paramIconCompat.mType)
    {
    }
    for (;;)
    {
      parama.aM(paramIconCompat.mType, 1);
      parama.i(paramIconCompat.mData);
      parama.writeParcelable(paramIconCompat.Ko, 3);
      parama.aM(paramIconCompat.Kp, 4);
      parama.aM(paramIconCompat.Kq, 5);
      parama.writeParcelable(paramIconCompat.Kr, 6);
      parama.M(paramIconCompat.Ks);
      AppMethodBeat.o(62497);
      return;
      paramIconCompat.Ko = ((Parcelable)paramIconCompat.Kn);
      continue;
      paramIconCompat.Ko = ((Parcelable)paramIconCompat.Kn);
      continue;
      paramIconCompat.mData = paramIconCompat.Kn.toString().getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((String)paramIconCompat.Kn).getBytes(Charset.forName("UTF-16"));
      continue;
      paramIconCompat.mData = ((byte[])paramIconCompat.Kn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.core.graphics.drawable.IconCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */